package com.baidu.tieba.im.validate;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.live.message.MemoryClearUnreadCountMessage;
import com.baidu.tbadk.util.ChatStatusManager;
import com.baidu.tbadk.util.k;
import com.baidu.tieba.d;
import com.baidu.tieba.im.data.ValidateItemData;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.PushMessage;
import com.baidu.tieba.im.message.RequestAddGroupUserMessage;
import com.baidu.tieba.im.message.RequestDelSystemMessage;
import com.baidu.tieba.im.message.ResponseDelSystemMessage;
import com.baidu.tieba.im.model.ValidateModel;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class ValidateActivity extends BaseActivity<ValidateActivity> implements BdListView.e {
    private k<LinkedList<GroupNewsPojo>> gnZ;
    private c gtm;
    private k<Boolean> gtn;
    private com.baidu.tbadk.core.dialog.b gto;
    private ValidateItemData gtp;
    private k<Integer> gts;
    private boolean isLoading;
    private int offset;
    private int totalCount;
    private boolean gtq = false;
    private int gtr = 20;
    private com.baidu.adp.framework.listener.c gaF = new com.baidu.adp.framework.listener.c(0) { // from class: com.baidu.tieba.im.validate.ValidateActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            ValidateActivity.this.gtm.lo(false);
            ValidateActivity.this.gtq = false;
            if (socketResponsedMessage != null && (socketResponsedMessage instanceof ResponsedMessage)) {
                int cmd = socketResponsedMessage.getCmd();
                if (cmd == 103111) {
                    RequestAddGroupUserMessage requestAddGroupUserMessage = (RequestAddGroupUserMessage) socketResponsedMessage.getOrginalMessage();
                    if (socketResponsedMessage.getError() != 0) {
                        if (requestAddGroupUserMessage != null) {
                            socketResponsedMessage.getError();
                            String errorString = socketResponsedMessage.getErrorString();
                            if (TextUtils.isEmpty(errorString)) {
                                ValidateActivity.this.showToast(d.j.validate_fail);
                            } else {
                                ValidateActivity.this.showToast(errorString);
                            }
                            ValidateItemData xB = ValidateActivity.this.xB(requestAddGroupUserMessage.getNotice_id());
                            if (xB != null) {
                                xB.setPass(false);
                                xB.setShown(true);
                                ValidateModel.updateValidateData(ValidateActivity.this.gtn, xB);
                                ValidateActivity.this.gtm.bwt().notifyDataSetChanged();
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    ValidateItemData xB2 = ValidateActivity.this.xB(requestAddGroupUserMessage.getNotice_id());
                    if (xB2 != null) {
                        xB2.setPass(true);
                        xB2.setShown(true);
                        ValidateModel.updateValidateData(ValidateActivity.this.gtn, xB2);
                        if (TextUtils.isEmpty(socketResponsedMessage.getErrorString())) {
                            ValidateActivity.this.showToast(d.j.validate_succ);
                        } else {
                            ValidateActivity.this.showToast(socketResponsedMessage.getErrorString());
                        }
                        ValidateActivity.this.gtm.bwt().notifyDataSetChanged();
                    }
                } else if (202004 == cmd) {
                    ResponseDelSystemMessage responseDelSystemMessage = (ResponseDelSystemMessage) socketResponsedMessage;
                    RequestDelSystemMessage requestDelSystemMessage = (RequestDelSystemMessage) responseDelSystemMessage.getOrginalMessage();
                    if (responseDelSystemMessage.getError() == 0) {
                        ValidateModel.deleteValidateData(ValidateActivity.this.gtp, ValidateActivity.this.gtn);
                        ValidateActivity.this.offset--;
                        ValidateActivity.this.totalCount--;
                        a bwt = ValidateActivity.this.gtm.bwt();
                        bwt.getDatas().remove(ValidateActivity.this.gtp);
                        ImMessageCenterPojo imMessageCenterPojo = null;
                        if (bwt.getDatas().size() > 0) {
                            ImMessageCenterPojo imMessageCenterPojo2 = new ImMessageCenterPojo();
                            imMessageCenterPojo2.setLast_content(bwt.getDatas().get(0).getUserName() + TbadkApplication.getInst().getApp().getApplicationContext().getString(d.j.validate_im_apply_prefix1) + bwt.getDatas().get(0).getGroupName());
                            imMessageCenterPojo2.setLast_content_time(bwt.getDatas().get(0).getApplyTime());
                            imMessageCenterPojo = imMessageCenterPojo2;
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001211, imMessageCenterPojo));
                        bwt.notifyDataSetChanged();
                        if (bwt != null && bwt.getDatas() != null && bwt.getDatas().size() == 0) {
                            ValidateActivity.this.finish();
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener mCustomListener = new CustomMessageListener(2001125) { // from class: com.baidu.tieba.im.validate.ValidateActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof PushMessage) {
                GroupNewsPojo p = ((PushMessage) customResponsedMessage).getP();
                ValidateActivity.this.offset++;
                ValidateActivity.this.totalCount++;
                ValidateActivity.this.gtm.bwt().getDatas().add(0, ValidateModel.convertToValidateItemData(p));
                ValidateActivity.this.gtm.bwt().notifyDataSetChanged();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gtm = new c(this);
        but();
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        ChatStatusManager.getInst().setIsOpen(7, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        com.baidu.tbadk.coreExtra.messageCenter.b.ahA().iB(1);
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a("-1003", -4)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        ChatStatusManager.getInst().setIsOpen(7, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        a bwt;
        super.onStop();
        ChatStatusManager.getInst().setIsOpen(7, false);
        if (this.gtm != null && (bwt = this.gtm.bwt()) != null) {
            ValidateModel.markShown(bwt.getDatas());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
    }

    private void but() {
        this.gtn = new k<Boolean>() { // from class: com.baidu.tieba.im.validate.ValidateActivity.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.k
            public void onReturnDataInUI(Boolean bool) {
                if (!ValidateActivity.this.gtq) {
                    ValidateActivity.this.gtm.lo(false);
                }
            }
        };
        this.gnZ = new k<LinkedList<GroupNewsPojo>>() { // from class: com.baidu.tieba.im.validate.ValidateActivity.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.k
            /* renamed from: s */
            public void onReturnDataInUI(LinkedList<GroupNewsPojo> linkedList) {
                ValidateActivity.this.gtm.setData(ValidateModel.convertToValidateItemDataList(linkedList));
                if (linkedList != null) {
                    ValidateActivity.this.offset += linkedList.size();
                }
                if (!ValidateActivity.this.gtq) {
                    ValidateActivity.this.gtm.lo(false);
                }
                ValidateActivity.this.isLoading = false;
            }
        };
        this.gts = new k<Integer>() { // from class: com.baidu.tieba.im.validate.ValidateActivity.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.k
            /* renamed from: i */
            public void onReturnDataInUI(Integer num) {
                ValidateActivity.this.totalCount = num.intValue();
                if (ValidateActivity.this.totalCount > 0) {
                    ValidateActivity.this.isLoading = true;
                    ValidateModel.requestValidateDataFromDB(ValidateActivity.this.gtr, ValidateActivity.this.offset, ValidateActivity.this.gnZ);
                }
            }
        };
        registerListener(103111, this.gaF);
        registerListener(202004, this.gaF);
        registerListener(this.mCustomListener);
        this.gtm.lo(true);
        ValidateModel.requestValidateDataCountFromDB(this.gts);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.gtm != null) {
            this.gtm.destroy();
        }
        this.gtp = null;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null && this.gtm != null && view.equals(this.gtm.bws())) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.gtm != null) {
            this.gtm.onChangeSkinType(i);
        }
    }

    public void a(View view, int i, int i2, long j, ValidateItemData validateItemData) {
        if (validateItemData != null) {
            if (100 == i) {
                d(validateItemData);
            } else if (101 == i) {
                c(validateItemData);
            }
        }
    }

    public void b(View view, int i, int i2, long j, ValidateItemData validateItemData) {
        if (view != null && validateItemData != null && 200 == i) {
            this.gtp = validateItemData;
            if (this.gto == null) {
                buu();
            }
            this.gto.abc();
        }
    }

    private void buu() {
        String string = getPageContext().getString(d.j.delete_user_chat);
        b.InterfaceC0225b interfaceC0225b = new b.InterfaceC0225b() { // from class: com.baidu.tieba.im.validate.ValidateActivity.4
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0225b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                bVar.dismiss();
                switch (i) {
                    case 0:
                        ValidateActivity.this.gtm.lo(true);
                        ValidateActivity.this.e(ValidateActivity.this.gtp);
                        return;
                    default:
                        return;
                }
            }
        };
        this.gto = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
        this.gto.gG(d.j.operation);
        this.gto.a(new String[]{string}, interfaceC0225b);
        this.gto.d(getPageContext());
    }

    private void c(ValidateItemData validateItemData) {
        if (validateItemData != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), validateItemData.getUserId(), validateItemData.getUserName())));
        }
    }

    private void d(ValidateItemData validateItemData) {
        if (!j.kY()) {
            showToast(d.j.neterror);
        } else if (validateItemData != null && !validateItemData.isPass() && !this.gtq) {
            try {
                validateItemData.setShown(true);
                this.gtm.lo(true);
                RequestAddGroupUserMessage requestAddGroupUserMessage = new RequestAddGroupUserMessage();
                requestAddGroupUserMessage.setInviterUserId(validateItemData.getInviterUserId());
                requestAddGroupUserMessage.setJoinType(validateItemData.getJoinType());
                requestAddGroupUserMessage.setUserIds(validateItemData.getUserId());
                requestAddGroupUserMessage.setGroupId(com.baidu.adp.lib.g.b.d(validateItemData.getGroupId(), 0L));
                requestAddGroupUserMessage.setNotice_id(validateItemData.getNotice_id());
                String notice_id = validateItemData.getNotice_id();
                String bvK = com.baidu.tieba.im.pushNotify.b.bvI().bvK();
                if (!TextUtils.isEmpty(notice_id) && !TextUtils.isEmpty(bvK) && TextUtils.isDigitsOnly(notice_id) && TextUtils.isDigitsOnly(bvK)) {
                    requestAddGroupUserMessage.setSysGroupId(com.baidu.adp.lib.g.b.l(bvK, 0));
                    requestAddGroupUserMessage.setSysMsgId(String.valueOf(com.baidu.adp.lib.g.b.d(notice_id, 0L) / 100));
                    requestAddGroupUserMessage.setDecision(1);
                    this.gtq = true;
                    MessageManager.getInstance().sendMessage(requestAddGroupUserMessage);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ValidateItemData validateItemData) {
        if (!j.kY()) {
            showToast(d.j.neterror);
        } else if (validateItemData != null) {
            long d = com.baidu.adp.lib.g.b.d(com.baidu.tieba.im.pushNotify.b.bvI().bvK(), 0L);
            if (d != 0) {
                this.gtm.lo(true);
                RequestDelSystemMessage requestDelSystemMessage = new RequestDelSystemMessage();
                requestDelSystemMessage.setGroupId(d);
                requestDelSystemMessage.setMsgIds("" + (Long.parseLong(validateItemData.getNotice_id()) / 100));
                this.gtq = true;
                MessageManager.getInstance().sendMessage(requestDelSystemMessage);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ValidateItemData xB(String str) {
        if (str == null) {
            return null;
        }
        List<ValidateItemData> datas = this.gtm.bwt().getDatas();
        if (datas != null) {
            for (ValidateItemData validateItemData : datas) {
                if (str.equals(validateItemData.getNotice_id())) {
                    return validateItemData;
                }
            }
        }
        return null;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!this.isLoading && this.offset < this.totalCount) {
            this.isLoading = true;
            ValidateModel.requestValidateDataFromDB(this.gtr, this.offset, this.gnZ);
        }
    }
}
