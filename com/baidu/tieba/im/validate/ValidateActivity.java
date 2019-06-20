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
import com.baidu.tieba.R;
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
    private k<LinkedList<GroupNewsPojo>> gFd;
    private c gKq;
    private k<Boolean> gKr;
    private com.baidu.tbadk.core.dialog.b gKs;
    private ValidateItemData gKt;
    private k<Integer> gKw;
    private boolean isLoading;
    private int offset;
    private int totalCount;
    private boolean gKu = false;
    private int gKv = 20;
    private com.baidu.adp.framework.listener.c grM = new com.baidu.adp.framework.listener.c(0) { // from class: com.baidu.tieba.im.validate.ValidateActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            ValidateActivity.this.gKq.me(false);
            ValidateActivity.this.gKu = false;
            if (socketResponsedMessage != null && (socketResponsedMessage instanceof ResponsedMessage)) {
                int cmd = socketResponsedMessage.getCmd();
                if (cmd == 103111) {
                    RequestAddGroupUserMessage requestAddGroupUserMessage = (RequestAddGroupUserMessage) socketResponsedMessage.getOrginalMessage();
                    if (socketResponsedMessage.getError() != 0) {
                        if (requestAddGroupUserMessage != null) {
                            socketResponsedMessage.getError();
                            String errorString = socketResponsedMessage.getErrorString();
                            if (TextUtils.isEmpty(errorString)) {
                                ValidateActivity.this.showToast(R.string.validate_fail);
                            } else {
                                ValidateActivity.this.showToast(errorString);
                            }
                            ValidateItemData yR = ValidateActivity.this.yR(requestAddGroupUserMessage.getNotice_id());
                            if (yR != null) {
                                yR.setPass(false);
                                yR.setShown(true);
                                ValidateModel.updateValidateData(ValidateActivity.this.gKr, yR);
                                ValidateActivity.this.gKq.bEc().notifyDataSetChanged();
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    ValidateItemData yR2 = ValidateActivity.this.yR(requestAddGroupUserMessage.getNotice_id());
                    if (yR2 != null) {
                        yR2.setPass(true);
                        yR2.setShown(true);
                        ValidateModel.updateValidateData(ValidateActivity.this.gKr, yR2);
                        if (TextUtils.isEmpty(socketResponsedMessage.getErrorString())) {
                            ValidateActivity.this.showToast(R.string.validate_succ);
                        } else {
                            ValidateActivity.this.showToast(socketResponsedMessage.getErrorString());
                        }
                        ValidateActivity.this.gKq.bEc().notifyDataSetChanged();
                    }
                } else if (202004 == cmd) {
                    ResponseDelSystemMessage responseDelSystemMessage = (ResponseDelSystemMessage) socketResponsedMessage;
                    RequestDelSystemMessage requestDelSystemMessage = (RequestDelSystemMessage) responseDelSystemMessage.getOrginalMessage();
                    if (responseDelSystemMessage.getError() == 0) {
                        ValidateModel.deleteValidateData(ValidateActivity.this.gKt, ValidateActivity.this.gKr);
                        ValidateActivity.this.offset--;
                        ValidateActivity.this.totalCount--;
                        a bEc = ValidateActivity.this.gKq.bEc();
                        bEc.getDatas().remove(ValidateActivity.this.gKt);
                        ImMessageCenterPojo imMessageCenterPojo = null;
                        if (bEc.getDatas().size() > 0) {
                            ImMessageCenterPojo imMessageCenterPojo2 = new ImMessageCenterPojo();
                            imMessageCenterPojo2.setLast_content(bEc.getDatas().get(0).getUserName() + TbadkApplication.getInst().getApp().getApplicationContext().getString(R.string.validate_im_apply_prefix1) + bEc.getDatas().get(0).getGroupName());
                            imMessageCenterPojo2.setLast_content_time(bEc.getDatas().get(0).getApplyTime());
                            imMessageCenterPojo = imMessageCenterPojo2;
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001211, imMessageCenterPojo));
                        bEc.notifyDataSetChanged();
                        if (bEc != null && bEc.getDatas() != null && bEc.getDatas().size() == 0) {
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
                ValidateActivity.this.gKq.bEc().getDatas().add(0, ValidateModel.convertToValidateItemData(p));
                ValidateActivity.this.gKq.bEc().notifyDataSetChanged();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gKq = new c(this);
        bCg();
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
        com.baidu.tbadk.coreExtra.messageCenter.b.amy().jo(1);
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
        a bEc;
        super.onStop();
        ChatStatusManager.getInst().setIsOpen(7, false);
        if (this.gKq != null && (bEc = this.gKq.bEc()) != null) {
            ValidateModel.markShown(bEc.getDatas());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
    }

    private void bCg() {
        this.gKr = new k<Boolean>() { // from class: com.baidu.tieba.im.validate.ValidateActivity.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.k
            public void onReturnDataInUI(Boolean bool) {
                if (!ValidateActivity.this.gKu) {
                    ValidateActivity.this.gKq.me(false);
                }
            }
        };
        this.gFd = new k<LinkedList<GroupNewsPojo>>() { // from class: com.baidu.tieba.im.validate.ValidateActivity.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.k
            /* renamed from: s */
            public void onReturnDataInUI(LinkedList<GroupNewsPojo> linkedList) {
                ValidateActivity.this.gKq.setData(ValidateModel.convertToValidateItemDataList(linkedList));
                if (linkedList != null) {
                    ValidateActivity.this.offset += linkedList.size();
                }
                if (!ValidateActivity.this.gKu) {
                    ValidateActivity.this.gKq.me(false);
                }
                ValidateActivity.this.isLoading = false;
            }
        };
        this.gKw = new k<Integer>() { // from class: com.baidu.tieba.im.validate.ValidateActivity.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.k
            /* renamed from: i */
            public void onReturnDataInUI(Integer num) {
                ValidateActivity.this.totalCount = num.intValue();
                if (ValidateActivity.this.totalCount > 0) {
                    ValidateActivity.this.isLoading = true;
                    ValidateModel.requestValidateDataFromDB(ValidateActivity.this.gKv, ValidateActivity.this.offset, ValidateActivity.this.gFd);
                }
            }
        };
        registerListener(103111, this.grM);
        registerListener(202004, this.grM);
        registerListener(this.mCustomListener);
        this.gKq.me(true);
        ValidateModel.requestValidateDataCountFromDB(this.gKw);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.gKq != null) {
            this.gKq.destroy();
        }
        this.gKt = null;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null && this.gKq != null && view.equals(this.gKq.bEb())) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.gKq != null) {
            this.gKq.onChangeSkinType(i);
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
            this.gKt = validateItemData;
            if (this.gKs == null) {
                bCh();
            }
            this.gKs.afJ();
        }
    }

    private void bCh() {
        String string = getPageContext().getString(R.string.delete_user_chat);
        b.a aVar = new b.a() { // from class: com.baidu.tieba.im.validate.ValidateActivity.4
            @Override // com.baidu.tbadk.core.dialog.b.a
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                bVar.dismiss();
                switch (i) {
                    case 0:
                        ValidateActivity.this.gKq.me(true);
                        ValidateActivity.this.e(ValidateActivity.this.gKt);
                        return;
                    default:
                        return;
                }
            }
        };
        this.gKs = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
        this.gKs.hs(R.string.operation);
        this.gKs.a(new String[]{string}, aVar);
        this.gKs.d(getPageContext());
    }

    private void c(ValidateItemData validateItemData) {
        if (validateItemData != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), validateItemData.getUserId(), validateItemData.getUserName())));
        }
    }

    private void d(ValidateItemData validateItemData) {
        if (!j.jS()) {
            showToast(R.string.neterror);
        } else if (validateItemData != null && !validateItemData.isPass() && !this.gKu) {
            try {
                validateItemData.setShown(true);
                this.gKq.me(true);
                RequestAddGroupUserMessage requestAddGroupUserMessage = new RequestAddGroupUserMessage();
                requestAddGroupUserMessage.setInviterUserId(validateItemData.getInviterUserId());
                requestAddGroupUserMessage.setJoinType(validateItemData.getJoinType());
                requestAddGroupUserMessage.setUserIds(validateItemData.getUserId());
                requestAddGroupUserMessage.setGroupId(com.baidu.adp.lib.g.b.c(validateItemData.getGroupId(), 0L));
                requestAddGroupUserMessage.setNotice_id(validateItemData.getNotice_id());
                String notice_id = validateItemData.getNotice_id();
                String bDu = com.baidu.tieba.im.pushNotify.b.bDs().bDu();
                if (!TextUtils.isEmpty(notice_id) && !TextUtils.isEmpty(bDu) && TextUtils.isDigitsOnly(notice_id) && TextUtils.isDigitsOnly(bDu)) {
                    requestAddGroupUserMessage.setSysGroupId(com.baidu.adp.lib.g.b.f(bDu, 0));
                    requestAddGroupUserMessage.setSysMsgId(String.valueOf(com.baidu.adp.lib.g.b.c(notice_id, 0L) / 100));
                    requestAddGroupUserMessage.setDecision(1);
                    this.gKu = true;
                    MessageManager.getInstance().sendMessage(requestAddGroupUserMessage);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ValidateItemData validateItemData) {
        if (!j.jS()) {
            showToast(R.string.neterror);
        } else if (validateItemData != null) {
            long c = com.baidu.adp.lib.g.b.c(com.baidu.tieba.im.pushNotify.b.bDs().bDu(), 0L);
            if (c != 0) {
                this.gKq.me(true);
                RequestDelSystemMessage requestDelSystemMessage = new RequestDelSystemMessage();
                requestDelSystemMessage.setGroupId(c);
                requestDelSystemMessage.setMsgIds("" + (Long.parseLong(validateItemData.getNotice_id()) / 100));
                this.gKu = true;
                MessageManager.getInstance().sendMessage(requestDelSystemMessage);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ValidateItemData yR(String str) {
        if (str == null) {
            return null;
        }
        List<ValidateItemData> datas = this.gKq.bEc().getDatas();
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
            ValidateModel.requestValidateDataFromDB(this.gKv, this.offset, this.gFd);
        }
    }
}
