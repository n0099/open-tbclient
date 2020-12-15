package com.baidu.yuyinala.background.c;

import android.graphics.Bitmap;
import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.data.w;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.yuyinala.background.AlaAudioBackgroundDialogData;
import com.baidu.yuyinala.background.message.AlaAudioBackgroundListResponseMessage;
/* loaded from: classes4.dex */
public class a extends BdBaseModel {
    private final w aFN;
    private AlaAudioBackgroundDialogData oJI = new AlaAudioBackgroundDialogData();
    private com.baidu.yuyinala.background.b.a oJV;
    private com.baidu.yuyinala.background.b.a oJW;
    private InterfaceC0955a oJX;

    /* renamed from: com.baidu.yuyinala.background.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0955a {
        void a(AlaAudioBackgroundDialogData alaAudioBackgroundDialogData, com.baidu.yuyinala.background.b.a aVar);

        void eke();
    }

    public a(w wVar, InterfaceC0955a interfaceC0955a) {
        this.aFN = wVar;
        this.oJX = interfaceC0955a;
        registerListener();
    }

    private void registerListener() {
        registerListener(new HttpMessageListener(1031015) { // from class: com.baidu.yuyinala.background.c.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof AlaAudioBackgroundListResponseMessage) {
                    AlaAudioBackgroundListResponseMessage alaAudioBackgroundListResponseMessage = (AlaAudioBackgroundListResponseMessage) httpResponsedMessage;
                    a.this.oJW = a.this.oJV = alaAudioBackgroundListResponseMessage.ekn();
                    a.this.oJI.setBgList(alaAudioBackgroundListResponseMessage.getBgList());
                    if (a.this.oJX != null) {
                        a.this.oJX.a(a.this.oJI, a.this.oJW);
                    }
                }
            }
        });
        registerListener(new HttpMessageListener(1031016) { // from class: com.baidu.yuyinala.background.c.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage.getCmd() == 1031016 && httpResponsedMessage.getError() != 0) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501019));
                    if (a.this.oJX != null) {
                        a.this.oJX.eke();
                    }
                }
            }
        });
    }

    public void a(com.baidu.yuyinala.background.b.a aVar, Bitmap bitmap) {
        if (aVar != this.oJV) {
            if (this.oJV != null) {
                this.oJV.Aq(false);
            }
            this.oJV = aVar;
            this.oJV.Aq(true);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501019, bitmap));
        }
    }

    public void ekd() {
        if (this.oJW != this.oJV) {
            if (this.oJV != null) {
                this.oJV.Aq(false);
            }
            if (this.oJW != null) {
                this.oJW.Aq(true);
            }
            this.oJV = null;
            this.oJW = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501019));
        }
    }

    public void ekc() {
        if (this.oJW != this.oJV && this.oJV != null && !StringUtils.isNull(this.oJV.getOriginalUrl())) {
            Yq(this.oJV.getOriginalUrl());
            this.oJV = null;
            this.oJW = null;
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

    public void eko() {
        String str;
        String str2;
        String str3 = null;
        if (this.aFN == null || this.aFN.aKL == null) {
            str = null;
            str2 = null;
        } else {
            str2 = this.aFN.aKL.live_id;
            str = this.aFN.aKL.croom_id;
            str3 = this.aFN.aKL.aUg;
        }
        HttpMessage httpMessage = new HttpMessage(1031015);
        httpMessage.addParam("live_id", str2);
        httpMessage.addParam("room_id", str3);
        httpMessage.addParam(UbcStatConstant.KEY_CUSTOM_ROOM_ID, str);
        sendMessage(httpMessage);
    }

    private void Yq(String str) {
        String str2;
        String str3;
        String str4 = null;
        if (this.aFN == null || this.aFN.aKL == null) {
            str2 = null;
            str3 = null;
        } else {
            str3 = this.aFN.aKL.live_id;
            str2 = this.aFN.aKL.croom_id;
            str4 = this.aFN.aKL.aUg;
        }
        HttpMessage httpMessage = new HttpMessage(1031016);
        httpMessage.addParam("live_id", str3);
        httpMessage.addParam("room_id", str4);
        httpMessage.addParam(UbcStatConstant.KEY_CUSTOM_ROOM_ID, str2);
        httpMessage.addParam("background_url", str);
        sendMessage(httpMessage);
    }

    public String getCustomRoomId() {
        if (this.aFN == null || this.aFN.aKL == null) {
            return null;
        }
        return this.aFN.aKL.croom_id;
    }
}
