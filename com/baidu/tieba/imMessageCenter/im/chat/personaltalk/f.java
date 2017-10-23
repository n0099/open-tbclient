package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.message.RequestUpdateMaskInfoMessage;
import com.baidu.tbadk.core.message.ResponseUpdateMaskInfoMessage;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.util.s;
import com.baidu.tbadk.util.t;
import com.baidu.tieba.d;
import com.baidu.tieba.im.message.ResponseQueryUserInfoMessage;
import com.baidu.tieba.im.model.BlackListModel;
import com.baidu.tieba.im.settingcache.PersonalSettingItemData;
import com.baidu.tieba.imMessageCenter.RequestQueryUserInfoMessage;
import protobuf.QueryUserInfos.DataRes;
/* loaded from: classes2.dex */
public class f {
    private final BlackListModel dHi;
    private PersonalTalkSettingActivity dHj;
    private a dHk;
    private DataRes data;
    private com.baidu.tbadk.coreExtra.c.a aoD = new com.baidu.tbadk.coreExtra.c.a(null);
    private boolean isAttention = false;
    private boolean dHg = false;
    private boolean dHh = false;
    private BdUniqueId tag = BdUniqueId.gen();
    private com.baidu.adp.framework.listener.c dlQ = new com.baidu.adp.framework.listener.c(0) { // from class: com.baidu.tieba.imMessageCenter.im.chat.personaltalk.f.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage != null) {
                switch (socketResponsedMessage.getCmd()) {
                    case 104102:
                        if (socketResponsedMessage instanceof ResponsedMessage) {
                            f.this.dHj.closeLoadingDialog();
                            if (socketResponsedMessage.getError() != 0) {
                                f.this.dHj.showToast(socketResponsedMessage.getErrorString());
                            }
                        }
                        if (socketResponsedMessage instanceof ResponseUpdateMaskInfoMessage) {
                            ResponseUpdateMaskInfoMessage responseUpdateMaskInfoMessage = (ResponseUpdateMaskInfoMessage) socketResponsedMessage;
                            if (responseUpdateMaskInfoMessage.getOrginalMessage() instanceof RequestUpdateMaskInfoMessage) {
                                RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = (RequestUpdateMaskInfoMessage) responseUpdateMaskInfoMessage.getOrginalMessage();
                                if (requestUpdateMaskInfoMessage.getMaskType() == 10) {
                                    f.this.dHg = requestUpdateMaskInfoMessage.getIsMask() == 1;
                                    if (f.this.dHk != null) {
                                        f.this.dHk.wg();
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        return;
                    case 205003:
                        if ((socketResponsedMessage instanceof ResponsedMessage) && socketResponsedMessage.getError() != 0) {
                            f.this.dHj.hideProgressBar();
                            f.this.dHj.showToast(socketResponsedMessage.getErrorString());
                            return;
                        } else if (socketResponsedMessage instanceof ResponseQueryUserInfoMessage) {
                            ResponseQueryUserInfoMessage responseQueryUserInfoMessage = (ResponseQueryUserInfoMessage) socketResponsedMessage;
                            if (responseQueryUserInfoMessage.getResData() != null) {
                                f.this.data = responseQueryUserInfoMessage.getResData();
                                f.this.isAttention = f.this.data.hasConcerned.intValue() == 1;
                                f.this.dHg = f.this.data.isBlacklist.intValue() == 1;
                                f.this.dHj.hideProgressBar();
                                if (f.this.dHk != null) {
                                    f.this.dHk.wg();
                                    return;
                                }
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    default:
                        return;
                }
            }
        }
    };
    private CustomMessageListener mCustomListener = new CustomMessageListener(0) { // from class: com.baidu.tieba.imMessageCenter.im.chat.personaltalk.f.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (!updateAttentionMessage.isSucc()) {
                    if (f.this.dHj != null && !TextUtils.isEmpty(updateAttentionMessage.getErrorString())) {
                        f.this.dHj.showToast(updateAttentionMessage.getErrorString());
                        return;
                    }
                    return;
                }
                f.this.isAttention = updateAttentionMessage.isAttention();
                if (f.this.dHj != null) {
                    if (f.this.isAttention) {
                        f.this.dHj.showToast(d.l.add_success);
                    } else {
                        f.this.dHj.showToast(d.l.remove_succ);
                    }
                }
                if (f.this.dHk != null) {
                    f.this.dHk.wg();
                }
            }
        }
    };

    /* loaded from: classes2.dex */
    public interface a {
        void wg();
    }

    public boolean azM() {
        return this.dHh;
    }

    public void gP(boolean z) {
        this.dHh = z;
    }

    public DataRes azN() {
        return this.data;
    }

    public boolean azO() {
        return this.dHg;
    }

    public f(final PersonalTalkSettingActivity personalTalkSettingActivity, a aVar, final long j) {
        this.dHj = personalTalkSettingActivity;
        this.dHk = aVar;
        this.dHi = new BlackListModel(personalTalkSettingActivity.getPageContext());
        personalTalkSettingActivity.showProgressBar();
        t.b(new s<PersonalSettingItemData>() { // from class: com.baidu.tieba.imMessageCenter.im.chat.personaltalk.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.s
            /* renamed from: azR */
            public PersonalSettingItemData doInBackground() {
                return com.baidu.tieba.im.settingcache.e.azb().bi(TbadkCoreApplication.getCurrentAccount(), String.valueOf(j));
            }
        }, new com.baidu.tbadk.util.g<PersonalSettingItemData>() { // from class: com.baidu.tieba.imMessageCenter.im.chat.personaltalk.f.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.g
            /* renamed from: a */
            public void onReturnDataInUI(PersonalSettingItemData personalSettingItemData) {
                if (personalSettingItemData != null) {
                    f.this.dHh = personalSettingItemData.isAcceptNotify();
                }
                RequestQueryUserInfoMessage requestQueryUserInfoMessage = new RequestQueryUserInfoMessage();
                requestQueryUserInfoMessage.setReqUserId(j);
                personalTalkSettingActivity.sendMessage(requestQueryUserInfoMessage);
            }
        });
    }

    public void gQ(boolean z) {
        RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = new RequestUpdateMaskInfoMessage();
        requestUpdateMaskInfoMessage.setMaskType(9);
        requestUpdateMaskInfoMessage.setList(String.valueOf(this.data.id));
        requestUpdateMaskInfoMessage.setSettingMask(z);
        requestUpdateMaskInfoMessage.setTag(this.tag);
        MessageManager.getInstance().removeMessage(104102, this.tag);
        MessageManager.getInstance().sendMessage(requestUpdateMaskInfoMessage);
    }

    public void gR(boolean z) {
        this.dHj.showLoadingDialog(null);
        if (z) {
            this.dHi.addToBlackList(this.data.id.longValue());
        } else {
            this.dHi.removeFromBlackList(this.data.id.longValue());
        }
    }

    public void onDestory() {
        if (this.aoD != null) {
            this.aoD.cancel();
        }
        if (this.dHi != null) {
            this.dHi.cancelLoadData();
        }
    }

    public com.baidu.adp.framework.listener.c azP() {
        return this.dlQ;
    }

    public CustomMessageListener azQ() {
        return this.mCustomListener;
    }
}
