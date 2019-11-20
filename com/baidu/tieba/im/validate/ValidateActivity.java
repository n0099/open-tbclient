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
import com.baidu.tbadk.util.j;
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
    private j<LinkedList<GroupNewsPojo>> gLh;
    private j<Integer> gQA;
    private c gQu;
    private j<Boolean> gQv;
    private com.baidu.tbadk.core.dialog.b gQw;
    private ValidateItemData gQx;
    private boolean isLoading;
    private int offset;
    private int totalCount;
    private boolean gQy = false;
    private int gQz = 20;
    private com.baidu.adp.framework.listener.c gxN = new com.baidu.adp.framework.listener.c(0) { // from class: com.baidu.tieba.im.validate.ValidateActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            ValidateActivity.this.gQu.mj(false);
            ValidateActivity.this.gQy = false;
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
                            ValidateItemData yu = ValidateActivity.this.yu(requestAddGroupUserMessage.getNotice_id());
                            if (yu != null) {
                                yu.setPass(false);
                                yu.setShown(true);
                                ValidateModel.updateValidateData(ValidateActivity.this.gQv, yu);
                                ValidateActivity.this.gQu.bEu().notifyDataSetChanged();
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    ValidateItemData yu2 = ValidateActivity.this.yu(requestAddGroupUserMessage.getNotice_id());
                    if (yu2 != null) {
                        yu2.setPass(true);
                        yu2.setShown(true);
                        ValidateModel.updateValidateData(ValidateActivity.this.gQv, yu2);
                        if (TextUtils.isEmpty(socketResponsedMessage.getErrorString())) {
                            ValidateActivity.this.showToast(R.string.validate_succ);
                        } else {
                            ValidateActivity.this.showToast(socketResponsedMessage.getErrorString());
                        }
                        ValidateActivity.this.gQu.bEu().notifyDataSetChanged();
                    }
                } else if (202004 == cmd) {
                    ResponseDelSystemMessage responseDelSystemMessage = (ResponseDelSystemMessage) socketResponsedMessage;
                    RequestDelSystemMessage requestDelSystemMessage = (RequestDelSystemMessage) responseDelSystemMessage.getOrginalMessage();
                    if (responseDelSystemMessage.getError() == 0) {
                        ValidateModel.deleteValidateData(ValidateActivity.this.gQx, ValidateActivity.this.gQv);
                        ValidateActivity.this.offset--;
                        ValidateActivity.this.totalCount--;
                        a bEu = ValidateActivity.this.gQu.bEu();
                        bEu.getDatas().remove(ValidateActivity.this.gQx);
                        ImMessageCenterPojo imMessageCenterPojo = null;
                        if (bEu.getDatas().size() > 0) {
                            ImMessageCenterPojo imMessageCenterPojo2 = new ImMessageCenterPojo();
                            imMessageCenterPojo2.setLast_content(bEu.getDatas().get(0).getUserName() + TbadkApplication.getInst().getApp().getApplicationContext().getString(R.string.validate_im_apply_prefix1) + bEu.getDatas().get(0).getGroupName());
                            imMessageCenterPojo2.setLast_content_time(bEu.getDatas().get(0).getApplyTime());
                            imMessageCenterPojo = imMessageCenterPojo2;
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_DELETED_VALIDATE, imMessageCenterPojo));
                        bEu.notifyDataSetChanged();
                        if (bEu != null && bEu.getDatas() != null && bEu.getDatas().size() == 0) {
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
                ValidateActivity.this.gQu.bEu().getDatas().add(0, ValidateModel.convertToValidateItemData(p));
                ValidateActivity.this.gQu.bEu().notifyDataSetChanged();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gQu = new c(this);
        bCy();
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
        com.baidu.tbadk.coreExtra.messageCenter.b.aqr().ji(1);
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
        a bEu;
        super.onStop();
        ChatStatusManager.getInst().setIsOpen(7, false);
        if (this.gQu != null && (bEu = this.gQu.bEu()) != null) {
            ValidateModel.markShown(bEu.getDatas());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
    }

    private void bCy() {
        this.gQv = new j<Boolean>() { // from class: com.baidu.tieba.im.validate.ValidateActivity.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.j
            public void onReturnDataInUI(Boolean bool) {
                if (!ValidateActivity.this.gQy) {
                    ValidateActivity.this.gQu.mj(false);
                }
            }
        };
        this.gLh = new j<LinkedList<GroupNewsPojo>>() { // from class: com.baidu.tieba.im.validate.ValidateActivity.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.j
            /* renamed from: o */
            public void onReturnDataInUI(LinkedList<GroupNewsPojo> linkedList) {
                ValidateActivity.this.gQu.setData(ValidateModel.convertToValidateItemDataList(linkedList));
                if (linkedList != null) {
                    ValidateActivity.this.offset += linkedList.size();
                }
                if (!ValidateActivity.this.gQy) {
                    ValidateActivity.this.gQu.mj(false);
                }
                ValidateActivity.this.isLoading = false;
            }
        };
        this.gQA = new j<Integer>() { // from class: com.baidu.tieba.im.validate.ValidateActivity.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.j
            /* renamed from: f */
            public void onReturnDataInUI(Integer num) {
                ValidateActivity.this.totalCount = num.intValue();
                if (ValidateActivity.this.totalCount > 0) {
                    ValidateActivity.this.isLoading = true;
                    ValidateModel.requestValidateDataFromDB(ValidateActivity.this.gQz, ValidateActivity.this.offset, ValidateActivity.this.gLh);
                }
            }
        };
        registerListener(CmdConfigSocket.CMD_ADD_GROUP_USER, this.gxN);
        registerListener(CmdConfigSocket.CMD_DELETE_GROUP_MSG, this.gxN);
        registerListener(this.mCustomListener);
        this.gQu.mj(true);
        ValidateModel.requestValidateDataCountFromDB(this.gQA);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.gQu != null) {
            this.gQu.destroy();
        }
        this.gQx = null;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null && this.gQu != null && view.equals(this.gQu.bEt())) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.gQu != null) {
            this.gQu.onChangeSkinType(i);
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
            this.gQx = validateItemData;
            if (this.gQw == null) {
                bCz();
            }
            this.gQw.akN();
        }
    }

    private void bCz() {
        String string = getPageContext().getString(R.string.delete_user_chat);
        b.a aVar = new b.a() { // from class: com.baidu.tieba.im.validate.ValidateActivity.4
            @Override // com.baidu.tbadk.core.dialog.b.a
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                bVar.dismiss();
                switch (i) {
                    case 0:
                        ValidateActivity.this.gQu.mj(true);
                        ValidateActivity.this.e(ValidateActivity.this.gQx);
                        return;
                    default:
                        return;
                }
            }
        };
        this.gQw = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
        this.gQw.hX(R.string.operation);
        this.gQw.a(new String[]{string}, aVar);
        this.gQw.d(getPageContext());
    }

    private void c(ValidateItemData validateItemData) {
        if (validateItemData != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), validateItemData.getUserId(), validateItemData.getUserName())));
        }
    }

    private void d(ValidateItemData validateItemData) {
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
        } else if (validateItemData != null && !validateItemData.isPass() && !this.gQy) {
            try {
                validateItemData.setShown(true);
                this.gQu.mj(true);
                RequestAddGroupUserMessage requestAddGroupUserMessage = new RequestAddGroupUserMessage();
                requestAddGroupUserMessage.setInviterUserId(validateItemData.getInviterUserId());
                requestAddGroupUserMessage.setJoinType(validateItemData.getJoinType());
                requestAddGroupUserMessage.setUserIds(validateItemData.getUserId());
                requestAddGroupUserMessage.setGroupId(com.baidu.adp.lib.g.b.toLong(validateItemData.getGroupId(), 0L));
                requestAddGroupUserMessage.setNotice_id(validateItemData.getNotice_id());
                String notice_id = validateItemData.getNotice_id();
                String bDM = com.baidu.tieba.im.pushNotify.b.bDK().bDM();
                if (!TextUtils.isEmpty(notice_id) && !TextUtils.isEmpty(bDM) && TextUtils.isDigitsOnly(notice_id) && TextUtils.isDigitsOnly(bDM)) {
                    requestAddGroupUserMessage.setSysGroupId(com.baidu.adp.lib.g.b.toInt(bDM, 0));
                    requestAddGroupUserMessage.setSysMsgId(String.valueOf(com.baidu.adp.lib.g.b.toLong(notice_id, 0L) / 100));
                    requestAddGroupUserMessage.setDecision(1);
                    this.gQy = true;
                    MessageManager.getInstance().sendMessage(requestAddGroupUserMessage);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ValidateItemData validateItemData) {
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
        } else if (validateItemData != null) {
            long j = com.baidu.adp.lib.g.b.toLong(com.baidu.tieba.im.pushNotify.b.bDK().bDM(), 0L);
            if (j != 0) {
                this.gQu.mj(true);
                RequestDelSystemMessage requestDelSystemMessage = new RequestDelSystemMessage();
                requestDelSystemMessage.setGroupId(j);
                requestDelSystemMessage.setMsgIds("" + (Long.parseLong(validateItemData.getNotice_id()) / 100));
                this.gQy = true;
                MessageManager.getInstance().sendMessage(requestDelSystemMessage);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ValidateItemData yu(String str) {
        if (str == null) {
            return null;
        }
        List<ValidateItemData> datas = this.gQu.bEu().getDatas();
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
            ValidateModel.requestValidateDataFromDB(this.gQz, this.offset, this.gLh);
        }
    }
}
