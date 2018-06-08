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
import com.baidu.tbadk.util.h;
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
    private com.baidu.tbadk.core.dialog.b epw;
    private h<LinkedList<GroupNewsPojo>> epx;
    private c euQ;
    private h<Boolean> euR;
    private ValidateItemData euS;
    private h<Integer> euV;
    private boolean isLoading;
    private int offset;
    private int totalCount;
    private boolean euT = false;
    private int euU = 20;
    private com.baidu.adp.framework.listener.c ecb = new com.baidu.adp.framework.listener.c(0) { // from class: com.baidu.tieba.im.validate.ValidateActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            ValidateActivity.this.euQ.hw(false);
            ValidateActivity.this.euT = false;
            if (socketResponsedMessage != null && (socketResponsedMessage instanceof ResponsedMessage)) {
                int cmd = socketResponsedMessage.getCmd();
                if (cmd == 103111) {
                    RequestAddGroupUserMessage requestAddGroupUserMessage = (RequestAddGroupUserMessage) socketResponsedMessage.getOrginalMessage();
                    if (socketResponsedMessage.getError() != 0) {
                        if (requestAddGroupUserMessage != null) {
                            socketResponsedMessage.getError();
                            String errorString = socketResponsedMessage.getErrorString();
                            if (TextUtils.isEmpty(errorString)) {
                                ValidateActivity.this.showToast(d.k.validate_fail);
                            } else {
                                ValidateActivity.this.showToast(errorString);
                            }
                            ValidateItemData oP = ValidateActivity.this.oP(requestAddGroupUserMessage.getNotice_id());
                            if (oP != null) {
                                oP.setPass(false);
                                oP.setShown(true);
                                ValidateModel.updateValidateData(ValidateActivity.this.euR, oP);
                                ValidateActivity.this.euQ.aMg().notifyDataSetChanged();
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    ValidateItemData oP2 = ValidateActivity.this.oP(requestAddGroupUserMessage.getNotice_id());
                    if (oP2 != null) {
                        oP2.setPass(true);
                        oP2.setShown(true);
                        ValidateModel.updateValidateData(ValidateActivity.this.euR, oP2);
                        if (TextUtils.isEmpty(socketResponsedMessage.getErrorString())) {
                            ValidateActivity.this.showToast(d.k.validate_succ);
                        } else {
                            ValidateActivity.this.showToast(socketResponsedMessage.getErrorString());
                        }
                        ValidateActivity.this.euQ.aMg().notifyDataSetChanged();
                    }
                } else if (202004 == cmd) {
                    ResponseDelSystemMessage responseDelSystemMessage = (ResponseDelSystemMessage) socketResponsedMessage;
                    RequestDelSystemMessage requestDelSystemMessage = (RequestDelSystemMessage) responseDelSystemMessage.getOrginalMessage();
                    if (responseDelSystemMessage.getError() == 0) {
                        ValidateModel.deleteValidateData(ValidateActivity.this.euS, ValidateActivity.this.euR);
                        ValidateActivity.this.offset--;
                        ValidateActivity.this.totalCount--;
                        a aMg = ValidateActivity.this.euQ.aMg();
                        aMg.getDatas().remove(ValidateActivity.this.euS);
                        ImMessageCenterPojo imMessageCenterPojo = null;
                        if (aMg.getDatas().size() > 0) {
                            ImMessageCenterPojo imMessageCenterPojo2 = new ImMessageCenterPojo();
                            imMessageCenterPojo2.setLast_content(aMg.getDatas().get(0).getUserName() + TbadkApplication.getInst().getApp().getApplicationContext().getString(d.k.validate_im_apply_prefix1) + aMg.getDatas().get(0).getGroupName());
                            imMessageCenterPojo2.setLast_content_time(aMg.getDatas().get(0).getApplyTime());
                            imMessageCenterPojo = imMessageCenterPojo2;
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001211, imMessageCenterPojo));
                        aMg.notifyDataSetChanged();
                        if (aMg != null && aMg.getDatas() != null && aMg.getDatas().size() == 0) {
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
                ValidateActivity.this.euQ.aMg().getDatas().add(0, ValidateModel.convertToValidateItemData(p));
                ValidateActivity.this.euQ.aMg().notifyDataSetChanged();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.euQ = new c(this);
        aKe();
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
        com.baidu.tbadk.coreExtra.messageCenter.a.CX().dU(1);
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
        a aMg;
        super.onStop();
        ChatStatusManager.getInst().setIsOpen(7, false);
        if (this.euQ != null && (aMg = this.euQ.aMg()) != null) {
            ValidateModel.markShown(aMg.getDatas());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
    }

    private void aKe() {
        this.euR = new h<Boolean>() { // from class: com.baidu.tieba.im.validate.ValidateActivity.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.h
            public void onReturnDataInUI(Boolean bool) {
                if (!ValidateActivity.this.euT) {
                    ValidateActivity.this.euQ.hw(false);
                }
            }
        };
        this.epx = new h<LinkedList<GroupNewsPojo>>() { // from class: com.baidu.tieba.im.validate.ValidateActivity.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.h
            /* renamed from: t */
            public void onReturnDataInUI(LinkedList<GroupNewsPojo> linkedList) {
                ValidateActivity.this.euQ.setData(ValidateModel.convertToValidateItemDataList(linkedList));
                if (linkedList != null) {
                    ValidateActivity.this.offset += linkedList.size();
                }
                if (!ValidateActivity.this.euT) {
                    ValidateActivity.this.euQ.hw(false);
                }
                ValidateActivity.this.isLoading = false;
            }
        };
        this.euV = new h<Integer>() { // from class: com.baidu.tieba.im.validate.ValidateActivity.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.h
            /* renamed from: n */
            public void onReturnDataInUI(Integer num) {
                ValidateActivity.this.totalCount = num.intValue();
                if (ValidateActivity.this.totalCount > 0) {
                    ValidateActivity.this.isLoading = true;
                    ValidateModel.requestValidateDataFromDB(ValidateActivity.this.euU, ValidateActivity.this.offset, ValidateActivity.this.epx);
                }
            }
        };
        registerListener(103111, this.ecb);
        registerListener(202004, this.ecb);
        registerListener(this.mCustomListener);
        this.euQ.hw(true);
        ValidateModel.requestValidateDataCountFromDB(this.euV);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.euQ != null) {
            this.euQ.destroy();
        }
        this.euS = null;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null && this.euQ != null && view.equals(this.euQ.aMf())) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.euQ != null) {
            this.euQ.onChangeSkinType(i);
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
            this.euS = validateItemData;
            if (this.epw == null) {
                aKf();
            }
            this.epw.xd();
        }
    }

    private void aKf() {
        String string = getPageContext().getString(d.k.delete_user_chat);
        b.InterfaceC0103b interfaceC0103b = new b.InterfaceC0103b() { // from class: com.baidu.tieba.im.validate.ValidateActivity.4
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0103b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                bVar.dismiss();
                switch (i) {
                    case 0:
                        ValidateActivity.this.euQ.hw(true);
                        ValidateActivity.this.e(ValidateActivity.this.euS);
                        return;
                    default:
                        return;
                }
            }
        };
        this.epw = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
        this.epw.cf(d.k.operation);
        this.epw.a(new String[]{string}, interfaceC0103b);
        this.epw.d(getPageContext());
    }

    private void c(ValidateItemData validateItemData) {
        if (validateItemData != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), validateItemData.getUserId(), validateItemData.getUserName())));
        }
    }

    private void d(ValidateItemData validateItemData) {
        if (!j.jD()) {
            showToast(d.k.neterror);
        } else if (validateItemData != null && !validateItemData.isPass() && !this.euT) {
            try {
                validateItemData.setShown(true);
                this.euQ.hw(true);
                RequestAddGroupUserMessage requestAddGroupUserMessage = new RequestAddGroupUserMessage();
                requestAddGroupUserMessage.setInviterUserId(validateItemData.getInviterUserId());
                requestAddGroupUserMessage.setJoinType(validateItemData.getJoinType());
                requestAddGroupUserMessage.setUserIds(validateItemData.getUserId());
                requestAddGroupUserMessage.setGroupId(com.baidu.adp.lib.g.b.c(validateItemData.getGroupId(), 0L));
                requestAddGroupUserMessage.setNotice_id(validateItemData.getNotice_id());
                String notice_id = validateItemData.getNotice_id();
                String aLx = com.baidu.tieba.im.pushNotify.b.aLv().aLx();
                if (!TextUtils.isEmpty(notice_id) && !TextUtils.isEmpty(aLx) && TextUtils.isDigitsOnly(notice_id) && TextUtils.isDigitsOnly(aLx)) {
                    requestAddGroupUserMessage.setSysGroupId(com.baidu.adp.lib.g.b.g(aLx, 0));
                    requestAddGroupUserMessage.setSysMsgId(String.valueOf(com.baidu.adp.lib.g.b.c(notice_id, 0L) / 100));
                    requestAddGroupUserMessage.setDecision(1);
                    this.euT = true;
                    MessageManager.getInstance().sendMessage(requestAddGroupUserMessage);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ValidateItemData validateItemData) {
        if (!j.jD()) {
            showToast(d.k.neterror);
        } else if (validateItemData != null) {
            long c = com.baidu.adp.lib.g.b.c(com.baidu.tieba.im.pushNotify.b.aLv().aLx(), 0L);
            if (c != 0) {
                this.euQ.hw(true);
                RequestDelSystemMessage requestDelSystemMessage = new RequestDelSystemMessage();
                requestDelSystemMessage.setGroupId(c);
                requestDelSystemMessage.setMsgIds("" + (Long.parseLong(validateItemData.getNotice_id()) / 100));
                this.euT = true;
                MessageManager.getInstance().sendMessage(requestDelSystemMessage);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ValidateItemData oP(String str) {
        if (str == null) {
            return null;
        }
        List<ValidateItemData> datas = this.euQ.aMg().getDatas();
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
            ValidateModel.requestValidateDataFromDB(this.euU, this.offset, this.epx);
        }
    }
}
