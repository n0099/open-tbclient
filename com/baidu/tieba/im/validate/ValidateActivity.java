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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.live.message.MemoryClearUnreadCountMessage;
import com.baidu.tbadk.util.ChatStatusManager;
import com.baidu.tbadk.util.m;
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
/* loaded from: classes26.dex */
public class ValidateActivity extends BaseActivity<ValidateActivity> implements BdListView.e {
    private boolean isLoading;
    private m<LinkedList<GroupNewsPojo>> kki;
    private c kpC;
    private m<Boolean> kpD;
    private com.baidu.tbadk.core.dialog.b kpE;
    private ValidateItemData kpF;
    private m<Integer> kpI;
    private int offset;
    private int totalCount;
    private boolean kpG = false;
    private int kpH = 20;
    private com.baidu.adp.framework.listener.c jUQ = new com.baidu.adp.framework.listener.c(0) { // from class: com.baidu.tieba.im.validate.ValidateActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            ValidateActivity.this.kpC.se(false);
            ValidateActivity.this.kpG = false;
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
                            ValidateItemData No = ValidateActivity.this.No(requestAddGroupUserMessage.getNotice_id());
                            if (No != null) {
                                No.setPass(false);
                                No.setShown(true);
                                ValidateModel.updateValidateData(ValidateActivity.this.kpD, No);
                                ValidateActivity.this.kpC.cVx().notifyDataSetChanged();
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    ValidateItemData No2 = ValidateActivity.this.No(requestAddGroupUserMessage.getNotice_id());
                    if (No2 != null) {
                        No2.setPass(true);
                        No2.setShown(true);
                        ValidateModel.updateValidateData(ValidateActivity.this.kpD, No2);
                        if (TextUtils.isEmpty(socketResponsedMessage.getErrorString())) {
                            ValidateActivity.this.showToast(R.string.validate_succ);
                        } else {
                            ValidateActivity.this.showToast(socketResponsedMessage.getErrorString());
                        }
                        ValidateActivity.this.kpC.cVx().notifyDataSetChanged();
                    }
                } else if (202004 == cmd) {
                    ResponseDelSystemMessage responseDelSystemMessage = (ResponseDelSystemMessage) socketResponsedMessage;
                    RequestDelSystemMessage requestDelSystemMessage = (RequestDelSystemMessage) responseDelSystemMessage.getOrginalMessage();
                    if (responseDelSystemMessage.getError() == 0) {
                        ValidateModel.deleteValidateData(ValidateActivity.this.kpF, ValidateActivity.this.kpD);
                        ValidateActivity.this.offset--;
                        ValidateActivity.this.totalCount--;
                        a cVx = ValidateActivity.this.kpC.cVx();
                        cVx.getDatas().remove(ValidateActivity.this.kpF);
                        ImMessageCenterPojo imMessageCenterPojo = null;
                        if (cVx.getDatas().size() > 0) {
                            ImMessageCenterPojo imMessageCenterPojo2 = new ImMessageCenterPojo();
                            imMessageCenterPojo2.setLast_content(cVx.getDatas().get(0).getUserName() + TbadkApplication.getInst().getApp().getApplicationContext().getString(R.string.validate_im_apply_prefix1) + cVx.getDatas().get(0).getGroupName());
                            imMessageCenterPojo2.setLast_content_time(cVx.getDatas().get(0).getApplyTime());
                            imMessageCenterPojo = imMessageCenterPojo2;
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_DELETED_VALIDATE, imMessageCenterPojo));
                        cVx.notifyDataSetChanged();
                        if (cVx != null && cVx.getDatas() != null && cVx.getDatas().size() == 0) {
                            ValidateActivity.this.finish();
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener mCustomListener = new CustomMessageListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_APPLY_JOIN_GROUP) { // from class: com.baidu.tieba.im.validate.ValidateActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof PushMessage) {
                GroupNewsPojo p = ((PushMessage) customResponsedMessage).getP();
                ValidateActivity.this.offset++;
                ValidateActivity.this.totalCount++;
                ValidateActivity.this.kpC.cVx().getDatas().add(0, ValidateModel.convertToValidateItemData(p));
                ValidateActivity.this.kpC.cVx().notifyDataSetChanged();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.kpC = new c(this);
        cTz();
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
        com.baidu.tbadk.coreExtra.messageCenter.b.bvS().qH(1);
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(TbEnum.CustomGroupId.GROUP_VALIDATION, -4)));
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
        a cVx;
        super.onStop();
        ChatStatusManager.getInst().setIsOpen(7, false);
        if (this.kpC != null && (cVx = this.kpC.cVx()) != null) {
            ValidateModel.markShown(cVx.getDatas());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
    }

    private void cTz() {
        this.kpD = new m<Boolean>() { // from class: com.baidu.tieba.im.validate.ValidateActivity.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.m
            public void onReturnDataInUI(Boolean bool) {
                if (!ValidateActivity.this.kpG) {
                    ValidateActivity.this.kpC.se(false);
                }
            }
        };
        this.kki = new m<LinkedList<GroupNewsPojo>>() { // from class: com.baidu.tieba.im.validate.ValidateActivity.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.m
            /* renamed from: o */
            public void onReturnDataInUI(LinkedList<GroupNewsPojo> linkedList) {
                ValidateActivity.this.kpC.setData(ValidateModel.convertToValidateItemDataList(linkedList));
                if (linkedList != null) {
                    ValidateActivity.this.offset += linkedList.size();
                }
                if (!ValidateActivity.this.kpG) {
                    ValidateActivity.this.kpC.se(false);
                }
                ValidateActivity.this.isLoading = false;
            }
        };
        this.kpI = new m<Integer>() { // from class: com.baidu.tieba.im.validate.ValidateActivity.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.m
            /* renamed from: p */
            public void onReturnDataInUI(Integer num) {
                ValidateActivity.this.totalCount = num.intValue();
                if (ValidateActivity.this.totalCount > 0) {
                    ValidateActivity.this.isLoading = true;
                    ValidateModel.requestValidateDataFromDB(ValidateActivity.this.kpH, ValidateActivity.this.offset, ValidateActivity.this.kki);
                }
            }
        };
        registerListener(CmdConfigSocket.CMD_ADD_GROUP_USER, this.jUQ);
        registerListener(CmdConfigSocket.CMD_DELETE_GROUP_MSG, this.jUQ);
        registerListener(this.mCustomListener);
        this.kpC.se(true);
        ValidateModel.requestValidateDataCountFromDB(this.kpI);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.kpC != null) {
            this.kpC.destroy();
        }
        this.kpF = null;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null && this.kpC != null && view.equals(this.kpC.cVw())) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.kpC != null) {
            this.kpC.onChangeSkinType(i);
        }
    }

    public void a(View view, int i, int i2, long j, ValidateItemData validateItemData) {
        if (validateItemData != null) {
            if (100 == i) {
                c(validateItemData);
            } else if (101 == i) {
                b(validateItemData);
            }
        }
    }

    public void b(View view, int i, int i2, long j, ValidateItemData validateItemData) {
        if (view != null && validateItemData != null && 200 == i) {
            this.kpF = validateItemData;
            if (this.kpE == null) {
                cTA();
            }
            this.kpE.bpe();
        }
    }

    private void cTA() {
        String string = getPageContext().getString(R.string.delete_user_chat);
        b.InterfaceC0576b interfaceC0576b = new b.InterfaceC0576b() { // from class: com.baidu.tieba.im.validate.ValidateActivity.4
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0576b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                bVar.dismiss();
                switch (i) {
                    case 0:
                        ValidateActivity.this.kpC.se(true);
                        ValidateActivity.this.d(ValidateActivity.this.kpF);
                        return;
                    default:
                        return;
                }
            }
        };
        this.kpE = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
        this.kpE.oB(R.string.operation);
        this.kpE.a(new String[]{string}, interfaceC0576b);
        this.kpE.d(getPageContext());
    }

    private void b(ValidateItemData validateItemData) {
        if (validateItemData != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), validateItemData.getUserId(), validateItemData.getUserName())));
        }
    }

    private void c(ValidateItemData validateItemData) {
        if (!j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
        } else if (validateItemData != null && !validateItemData.isPass() && !this.kpG) {
            try {
                validateItemData.setShown(true);
                this.kpC.se(true);
                RequestAddGroupUserMessage requestAddGroupUserMessage = new RequestAddGroupUserMessage();
                requestAddGroupUserMessage.setInviterUserId(validateItemData.getInviterUserId());
                requestAddGroupUserMessage.setJoinType(validateItemData.getJoinType());
                requestAddGroupUserMessage.setUserIds(validateItemData.getUserId());
                requestAddGroupUserMessage.setGroupId(com.baidu.adp.lib.f.b.toLong(validateItemData.getGroupId(), 0L));
                requestAddGroupUserMessage.setNotice_id(validateItemData.getNotice_id());
                String notice_id = validateItemData.getNotice_id();
                String cUP = com.baidu.tieba.im.pushNotify.b.cUN().cUP();
                if (!TextUtils.isEmpty(notice_id) && !TextUtils.isEmpty(cUP) && TextUtils.isDigitsOnly(notice_id) && TextUtils.isDigitsOnly(cUP)) {
                    requestAddGroupUserMessage.setSysGroupId(com.baidu.adp.lib.f.b.toInt(cUP, 0));
                    requestAddGroupUserMessage.setSysMsgId(String.valueOf(com.baidu.adp.lib.f.b.toLong(notice_id, 0L) / 100));
                    requestAddGroupUserMessage.setDecision(1);
                    this.kpG = true;
                    MessageManager.getInstance().sendMessage(requestAddGroupUserMessage);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ValidateItemData validateItemData) {
        if (!j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
        } else if (validateItemData != null) {
            long j = com.baidu.adp.lib.f.b.toLong(com.baidu.tieba.im.pushNotify.b.cUN().cUP(), 0L);
            if (j != 0) {
                this.kpC.se(true);
                RequestDelSystemMessage requestDelSystemMessage = new RequestDelSystemMessage();
                requestDelSystemMessage.setGroupId(j);
                requestDelSystemMessage.setMsgIds("" + (Long.parseLong(validateItemData.getNotice_id()) / 100));
                this.kpG = true;
                MessageManager.getInstance().sendMessage(requestDelSystemMessage);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ValidateItemData No(String str) {
        if (str == null) {
            return null;
        }
        List<ValidateItemData> datas = this.kpC.cVx().getDatas();
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
            ValidateModel.requestValidateDataFromDB(this.kpH, this.offset, this.kki);
        }
    }
}
