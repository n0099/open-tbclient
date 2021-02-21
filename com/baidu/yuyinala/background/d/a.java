package com.baidu.yuyinala.background.d;

import android.graphics.Bitmap;
import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.data.ab;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.yuyinala.background.AlaAudioBackgroundDialogData;
import com.baidu.yuyinala.background.message.AlaAudioBackgroundListResponseMessage;
/* loaded from: classes11.dex */
public class a extends BdBaseModel {
    private final ab aDd;
    private AlaAudioBackgroundDialogData oVU = new AlaAudioBackgroundDialogData();
    private com.baidu.yuyinala.background.b.a oWm;
    private com.baidu.yuyinala.background.b.a oWn;
    private InterfaceC0959a oWo;

    /* renamed from: com.baidu.yuyinala.background.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0959a {
        void a(AlaAudioBackgroundDialogData alaAudioBackgroundDialogData, com.baidu.yuyinala.background.b.a aVar);

        void eiQ();

        void eiR();
    }

    public a(ab abVar, InterfaceC0959a interfaceC0959a) {
        this.aDd = abVar;
        this.oWo = interfaceC0959a;
        registerListener();
    }

    private void registerListener() {
        registerListener(new HttpMessageListener(1031015) { // from class: com.baidu.yuyinala.background.d.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof AlaAudioBackgroundListResponseMessage) {
                    AlaAudioBackgroundListResponseMessage alaAudioBackgroundListResponseMessage = (AlaAudioBackgroundListResponseMessage) httpResponsedMessage;
                    a.this.oWn = a.this.oWm = alaAudioBackgroundListResponseMessage.ejd();
                    a.this.oVU.setBgList(alaAudioBackgroundListResponseMessage.getBgList());
                    if (a.this.oWo != null) {
                        a.this.oWo.a(a.this.oVU, a.this.oWn);
                    }
                }
            }
        });
        registerListener(new HttpMessageListener(1031016) { // from class: com.baidu.yuyinala.background.d.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage.getCmd() == 1031016) {
                    if (httpResponsedMessage.getError() == 0) {
                        if (a.this.oWo != null) {
                            a.this.oWo.eiR();
                            return;
                        }
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501019));
                    if (a.this.oWo != null) {
                        a.this.oWo.eiQ();
                    }
                }
            }
        });
    }

    public void a(com.baidu.yuyinala.background.b.a aVar, Bitmap bitmap) {
        if (aVar != this.oWm) {
            if (this.oWm != null) {
                this.oWm.AG(false);
            }
            this.oWm = aVar;
            this.oWm.AG(true);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501019, bitmap));
        }
    }

    public void a(com.baidu.yuyinala.background.b.a aVar, String str) {
        if (aVar != this.oWm) {
            if (this.oWm != null) {
                this.oWm.AG(false);
            }
            this.oWm = aVar;
            this.oWm.AG(true);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501078, str));
        }
    }

    public void eiP() {
        if (this.oWn != this.oWm) {
            if (this.oWm != null) {
                this.oWm.AG(false);
            }
            if (this.oWn != null) {
                this.oWn.AG(true);
            }
            this.oWm = null;
            this.oWn = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501019));
        }
    }

    public void eiO() {
        if (this.oWn != this.oWm && this.oWm != null && !StringUtils.isNull(this.oWm.getOriginalUrl())) {
            Yd(this.oWm.getOriginalUrl());
            this.oWm = null;
            this.oWn = null;
        }
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    protected boolean loadData() {
        return false;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void eje() {
        String str;
        String str2;
        String str3;
        if (this.aDd == null || this.aDd.aIU == null) {
            str = null;
            str2 = null;
            str3 = null;
        } else {
            str3 = this.aDd.aIU.live_id;
            String str4 = this.aDd.aIU.croom_id;
            str = this.aDd.aIU.aTK;
            str2 = str4;
        }
        HttpMessage httpMessage = new HttpMessage(1031015);
        httpMessage.addParam("live_id", str3);
        httpMessage.addParam("room_id", str);
        httpMessage.addParam(UbcStatConstant.KEY_CUSTOM_ROOM_ID, str2);
        sendMessage(httpMessage);
    }

    private void Yd(String str) {
        String str2;
        String str3;
        String str4;
        if (this.aDd == null || this.aDd.aIU == null) {
            str2 = null;
            str3 = null;
            str4 = null;
        } else {
            str4 = this.aDd.aIU.live_id;
            String str5 = this.aDd.aIU.croom_id;
            str2 = this.aDd.aIU.aTK;
            str3 = str5;
        }
        HttpMessage httpMessage = new HttpMessage(1031016);
        httpMessage.addParam("live_id", str4);
        httpMessage.addParam("room_id", str2);
        httpMessage.addParam(UbcStatConstant.KEY_CUSTOM_ROOM_ID, str3);
        httpMessage.addParam("background_url", str);
        sendMessage(httpMessage);
    }

    public String getCustomRoomId() {
        if (this.aDd == null || this.aDd.aIU == null) {
            return null;
        }
        return this.aDd.aIU.croom_id;
    }
}
