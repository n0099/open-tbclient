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
    private com.baidu.tbadk.core.dialog.b eIy;
    private h<LinkedList<GroupNewsPojo>> eIz;
    private c eNP;
    private h<Boolean> eNQ;
    private ValidateItemData eNR;
    private h<Integer> eNU;
    private boolean isLoading;
    private int offset;
    private int totalCount;
    private boolean eNS = false;
    private int eNT = 20;
    private com.baidu.adp.framework.listener.c evf = new com.baidu.adp.framework.listener.c(0) { // from class: com.baidu.tieba.im.validate.ValidateActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            ValidateActivity.this.eNP.hP(false);
            ValidateActivity.this.eNS = false;
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
                            ValidateItemData nU = ValidateActivity.this.nU(requestAddGroupUserMessage.getNotice_id());
                            if (nU != null) {
                                nU.setPass(false);
                                nU.setShown(true);
                                ValidateModel.updateValidateData(ValidateActivity.this.eNQ, nU);
                                ValidateActivity.this.eNP.aMn().notifyDataSetChanged();
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    ValidateItemData nU2 = ValidateActivity.this.nU(requestAddGroupUserMessage.getNotice_id());
                    if (nU2 != null) {
                        nU2.setPass(true);
                        nU2.setShown(true);
                        ValidateModel.updateValidateData(ValidateActivity.this.eNQ, nU2);
                        if (TextUtils.isEmpty(socketResponsedMessage.getErrorString())) {
                            ValidateActivity.this.showToast(d.j.validate_succ);
                        } else {
                            ValidateActivity.this.showToast(socketResponsedMessage.getErrorString());
                        }
                        ValidateActivity.this.eNP.aMn().notifyDataSetChanged();
                    }
                } else if (202004 == cmd) {
                    ResponseDelSystemMessage responseDelSystemMessage = (ResponseDelSystemMessage) socketResponsedMessage;
                    RequestDelSystemMessage requestDelSystemMessage = (RequestDelSystemMessage) responseDelSystemMessage.getOrginalMessage();
                    if (responseDelSystemMessage.getError() == 0) {
                        ValidateModel.deleteValidateData(ValidateActivity.this.eNR, ValidateActivity.this.eNQ);
                        ValidateActivity.this.offset--;
                        ValidateActivity.this.totalCount--;
                        a aMn = ValidateActivity.this.eNP.aMn();
                        aMn.getDatas().remove(ValidateActivity.this.eNR);
                        ImMessageCenterPojo imMessageCenterPojo = null;
                        if (aMn.getDatas().size() > 0) {
                            ImMessageCenterPojo imMessageCenterPojo2 = new ImMessageCenterPojo();
                            imMessageCenterPojo2.setLast_content(aMn.getDatas().get(0).getUserName() + TbadkApplication.getInst().getApp().getApplicationContext().getString(d.j.validate_im_apply_prefix1) + aMn.getDatas().get(0).getGroupName());
                            imMessageCenterPojo2.setLast_content_time(aMn.getDatas().get(0).getApplyTime());
                            imMessageCenterPojo = imMessageCenterPojo2;
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001211, imMessageCenterPojo));
                        aMn.notifyDataSetChanged();
                        if (aMn != null && aMn.getDatas() != null && aMn.getDatas().size() == 0) {
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
                ValidateActivity.this.eNP.aMn().getDatas().add(0, ValidateModel.convertToValidateItemData(p));
                ValidateActivity.this.eNP.aMn().notifyDataSetChanged();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.eNP = new c(this);
        aKo();
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
        com.baidu.tbadk.coreExtra.messageCenter.a.GJ().gT(1);
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
        a aMn;
        super.onStop();
        ChatStatusManager.getInst().setIsOpen(7, false);
        if (this.eNP != null && (aMn = this.eNP.aMn()) != null) {
            ValidateModel.markShown(aMn.getDatas());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
    }

    private void aKo() {
        this.eNQ = new h<Boolean>() { // from class: com.baidu.tieba.im.validate.ValidateActivity.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.h
            public void onReturnDataInUI(Boolean bool) {
                if (!ValidateActivity.this.eNS) {
                    ValidateActivity.this.eNP.hP(false);
                }
            }
        };
        this.eIz = new h<LinkedList<GroupNewsPojo>>() { // from class: com.baidu.tieba.im.validate.ValidateActivity.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.h
            /* renamed from: q */
            public void onReturnDataInUI(LinkedList<GroupNewsPojo> linkedList) {
                ValidateActivity.this.eNP.setData(ValidateModel.convertToValidateItemDataList(linkedList));
                if (linkedList != null) {
                    ValidateActivity.this.offset += linkedList.size();
                }
                if (!ValidateActivity.this.eNS) {
                    ValidateActivity.this.eNP.hP(false);
                }
                ValidateActivity.this.isLoading = false;
            }
        };
        this.eNU = new h<Integer>() { // from class: com.baidu.tieba.im.validate.ValidateActivity.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.h
            /* renamed from: g */
            public void onReturnDataInUI(Integer num) {
                ValidateActivity.this.totalCount = num.intValue();
                if (ValidateActivity.this.totalCount > 0) {
                    ValidateActivity.this.isLoading = true;
                    ValidateModel.requestValidateDataFromDB(ValidateActivity.this.eNT, ValidateActivity.this.offset, ValidateActivity.this.eIz);
                }
            }
        };
        registerListener(103111, this.evf);
        registerListener(202004, this.evf);
        registerListener(this.mCustomListener);
        this.eNP.hP(true);
        ValidateModel.requestValidateDataCountFromDB(this.eNU);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.eNP != null) {
            this.eNP.destroy();
        }
        this.eNR = null;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null && this.eNP != null && view.equals(this.eNP.aMm())) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.eNP != null) {
            this.eNP.onChangeSkinType(i);
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
            this.eNR = validateItemData;
            if (this.eIy == null) {
                aKp();
            }
            this.eIy.AY();
        }
    }

    private void aKp() {
        String string = getPageContext().getString(d.j.delete_user_chat);
        b.InterfaceC0097b interfaceC0097b = new b.InterfaceC0097b() { // from class: com.baidu.tieba.im.validate.ValidateActivity.4
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0097b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                bVar.dismiss();
                switch (i) {
                    case 0:
                        ValidateActivity.this.eNP.hP(true);
                        ValidateActivity.this.e(ValidateActivity.this.eNR);
                        return;
                    default:
                        return;
                }
            }
        };
        this.eIy = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
        this.eIy.fe(d.j.operation);
        this.eIy.a(new String[]{string}, interfaceC0097b);
        this.eIy.d(getPageContext());
    }

    private void c(ValidateItemData validateItemData) {
        if (validateItemData != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), validateItemData.getUserId(), validateItemData.getUserName())));
        }
    }

    private void d(ValidateItemData validateItemData) {
        if (!j.oJ()) {
            showToast(d.j.neterror);
        } else if (validateItemData != null && !validateItemData.isPass() && !this.eNS) {
            try {
                validateItemData.setShown(true);
                this.eNP.hP(true);
                RequestAddGroupUserMessage requestAddGroupUserMessage = new RequestAddGroupUserMessage();
                requestAddGroupUserMessage.setInviterUserId(validateItemData.getInviterUserId());
                requestAddGroupUserMessage.setJoinType(validateItemData.getJoinType());
                requestAddGroupUserMessage.setUserIds(validateItemData.getUserId());
                requestAddGroupUserMessage.setGroupId(com.baidu.adp.lib.g.b.h(validateItemData.getGroupId(), 0));
                requestAddGroupUserMessage.setNotice_id(validateItemData.getNotice_id());
                String notice_id = validateItemData.getNotice_id();
                String aLH = com.baidu.tieba.im.pushNotify.b.aLF().aLH();
                if (!TextUtils.isEmpty(notice_id) && !TextUtils.isEmpty(aLH) && TextUtils.isDigitsOnly(notice_id) && TextUtils.isDigitsOnly(aLH)) {
                    requestAddGroupUserMessage.setSysGroupId(com.baidu.adp.lib.g.b.h(aLH, 0));
                    requestAddGroupUserMessage.setSysMsgId(String.valueOf(com.baidu.adp.lib.g.b.c(notice_id, 0L) / 100));
                    requestAddGroupUserMessage.setDecision(1);
                    this.eNS = true;
                    MessageManager.getInstance().sendMessage(requestAddGroupUserMessage);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ValidateItemData validateItemData) {
        int h;
        if (!j.oJ()) {
            showToast(d.j.neterror);
        } else if (validateItemData != null && (h = com.baidu.adp.lib.g.b.h(com.baidu.tieba.im.pushNotify.b.aLF().aLH(), 0)) != 0) {
            this.eNP.hP(true);
            RequestDelSystemMessage requestDelSystemMessage = new RequestDelSystemMessage();
            requestDelSystemMessage.setGroupId(h);
            requestDelSystemMessage.setMsgIds("" + (Long.parseLong(validateItemData.getNotice_id()) / 100));
            this.eNS = true;
            MessageManager.getInstance().sendMessage(requestDelSystemMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ValidateItemData nU(String str) {
        if (str == null) {
            return null;
        }
        List<ValidateItemData> datas = this.eNP.aMn().getDatas();
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
            ValidateModel.requestValidateDataFromDB(this.eNT, this.offset, this.eIz);
        }
    }
}
