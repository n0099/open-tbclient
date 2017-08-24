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
import com.baidu.tbadk.util.h;
import com.baidu.tbadk.util.t;
import com.baidu.tbadk.util.u;
import com.baidu.tieba.d;
import com.baidu.tieba.im.message.ResponseQueryUserInfoMessage;
import com.baidu.tieba.im.model.BlackListModel;
import com.baidu.tieba.im.settingcache.PersonalSettingItemData;
import com.baidu.tieba.imMessageCenter.RequestQueryUserInfoMessage;
import protobuf.QueryUserInfos.DataRes;
/* loaded from: classes2.dex */
public class f {
    private final BlackListModel dDI;
    private PersonalTalkSettingActivity dDJ;
    private a dDK;
    private DataRes data;
    private com.baidu.tbadk.coreExtra.c.a aqc = new com.baidu.tbadk.coreExtra.c.a(null);
    private boolean isAttention = false;
    private boolean dDG = false;
    private boolean dDH = false;
    private BdUniqueId tag = BdUniqueId.gen();
    private com.baidu.adp.framework.listener.c dip = new com.baidu.adp.framework.listener.c(0) { // from class: com.baidu.tieba.imMessageCenter.im.chat.personaltalk.f.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage != null) {
                switch (socketResponsedMessage.getCmd()) {
                    case 104102:
                        if (socketResponsedMessage instanceof ResponsedMessage) {
                            f.this.dDJ.closeLoadingDialog();
                            if (socketResponsedMessage.getError() != 0) {
                                f.this.dDJ.showToast(socketResponsedMessage.getErrorString());
                            }
                        }
                        if (socketResponsedMessage instanceof ResponseUpdateMaskInfoMessage) {
                            ResponseUpdateMaskInfoMessage responseUpdateMaskInfoMessage = (ResponseUpdateMaskInfoMessage) socketResponsedMessage;
                            if (responseUpdateMaskInfoMessage.getOrginalMessage() instanceof RequestUpdateMaskInfoMessage) {
                                RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = (RequestUpdateMaskInfoMessage) responseUpdateMaskInfoMessage.getOrginalMessage();
                                if (requestUpdateMaskInfoMessage.getMaskType() == 10) {
                                    f.this.dDG = requestUpdateMaskInfoMessage.getIsMask() == 1;
                                    if (f.this.dDK != null) {
                                        f.this.dDK.wQ();
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
                            f.this.dDJ.hideProgressBar();
                            f.this.dDJ.showToast(socketResponsedMessage.getErrorString());
                            return;
                        } else if (socketResponsedMessage instanceof ResponseQueryUserInfoMessage) {
                            ResponseQueryUserInfoMessage responseQueryUserInfoMessage = (ResponseQueryUserInfoMessage) socketResponsedMessage;
                            if (responseQueryUserInfoMessage.getResData() != null) {
                                f.this.data = responseQueryUserInfoMessage.getResData();
                                f.this.isAttention = f.this.data.hasConcerned.intValue() == 1;
                                f.this.dDG = f.this.data.isBlacklist.intValue() == 1;
                                f.this.dDJ.hideProgressBar();
                                if (f.this.dDK != null) {
                                    f.this.dDK.wQ();
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
                    if (f.this.dDJ != null && !TextUtils.isEmpty(updateAttentionMessage.getErrorString())) {
                        f.this.dDJ.showToast(updateAttentionMessage.getErrorString());
                        return;
                    }
                    return;
                }
                f.this.isAttention = updateAttentionMessage.isAttention();
                if (f.this.dDJ != null) {
                    if (f.this.isAttention) {
                        f.this.dDJ.showToast(d.l.add_black_success);
                    } else {
                        f.this.dDJ.showToast(d.l.remove_succ);
                    }
                }
                if (f.this.dDK != null) {
                    f.this.dDK.wQ();
                }
            }
        }
    };

    /* loaded from: classes2.dex */
    public interface a {
        void wQ();
    }

    public boolean azg() {
        return this.dDH;
    }

    public void gU(boolean z) {
        this.dDH = z;
    }

    public DataRes azh() {
        return this.data;
    }

    public boolean azi() {
        return this.dDG;
    }

    public f(final PersonalTalkSettingActivity personalTalkSettingActivity, a aVar, final long j) {
        this.dDJ = personalTalkSettingActivity;
        this.dDK = aVar;
        this.dDI = new BlackListModel(personalTalkSettingActivity.getPageContext());
        personalTalkSettingActivity.showProgressBar();
        u.b(new t<PersonalSettingItemData>() { // from class: com.baidu.tieba.imMessageCenter.im.chat.personaltalk.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.t
            /* renamed from: azl */
            public PersonalSettingItemData doInBackground() {
                return com.baidu.tieba.im.settingcache.e.ayt().bm(TbadkCoreApplication.getCurrentAccount(), String.valueOf(j));
            }
        }, new h<PersonalSettingItemData>() { // from class: com.baidu.tieba.imMessageCenter.im.chat.personaltalk.f.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.h
            /* renamed from: a */
            public void onReturnDataInUI(PersonalSettingItemData personalSettingItemData) {
                if (personalSettingItemData != null) {
                    f.this.dDH = personalSettingItemData.isAcceptNotify();
                }
                RequestQueryUserInfoMessage requestQueryUserInfoMessage = new RequestQueryUserInfoMessage();
                requestQueryUserInfoMessage.setReqUserId(j);
                personalTalkSettingActivity.sendMessage(requestQueryUserInfoMessage);
            }
        });
    }

    public void gV(boolean z) {
        RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = new RequestUpdateMaskInfoMessage();
        requestUpdateMaskInfoMessage.setMaskType(9);
        requestUpdateMaskInfoMessage.setList(String.valueOf(this.data.id));
        requestUpdateMaskInfoMessage.setSettingMask(z);
        requestUpdateMaskInfoMessage.setTag(this.tag);
        MessageManager.getInstance().removeMessage(104102, this.tag);
        MessageManager.getInstance().sendMessage(requestUpdateMaskInfoMessage);
    }

    public void gW(boolean z) {
        this.dDJ.showLoadingDialog(null);
        if (z) {
            this.dDI.addToBlackList(this.data.id.longValue());
        } else {
            this.dDI.removeFromBlackList(this.data.id.longValue());
        }
    }

    public void onDestory() {
        if (this.aqc != null) {
            this.aqc.cancel();
        }
        if (this.dDI != null) {
            this.dDI.cancelLoadData();
        }
    }

    public com.baidu.adp.framework.listener.c azj() {
        return this.dip;
    }

    public CustomMessageListener azk() {
        return this.mCustomListener;
    }
}
