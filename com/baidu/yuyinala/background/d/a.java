package com.baidu.yuyinala.background.d;

import android.graphics.Bitmap;
import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.data.x;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.yuyinala.background.AlaAudioBackgroundDialogData;
import com.baidu.yuyinala.background.message.AlaAudioBackgroundListResponseMessage;
/* loaded from: classes10.dex */
public class a extends BdBaseModel {
    private final x aBr;
    private com.baidu.yuyinala.background.b.a oLG;
    private com.baidu.yuyinala.background.b.a oLH;
    private InterfaceC0953a oLI;
    private AlaAudioBackgroundDialogData oLo = new AlaAudioBackgroundDialogData();

    /* renamed from: com.baidu.yuyinala.background.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0953a {
        void a(AlaAudioBackgroundDialogData alaAudioBackgroundDialogData, com.baidu.yuyinala.background.b.a aVar);

        void egq();

        void egr();
    }

    public a(x xVar, InterfaceC0953a interfaceC0953a) {
        this.aBr = xVar;
        this.oLI = interfaceC0953a;
        registerListener();
    }

    private void registerListener() {
        registerListener(new HttpMessageListener(1031015) { // from class: com.baidu.yuyinala.background.d.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof AlaAudioBackgroundListResponseMessage) {
                    AlaAudioBackgroundListResponseMessage alaAudioBackgroundListResponseMessage = (AlaAudioBackgroundListResponseMessage) httpResponsedMessage;
                    a.this.oLH = a.this.oLG = alaAudioBackgroundListResponseMessage.egD();
                    a.this.oLo.setBgList(alaAudioBackgroundListResponseMessage.getBgList());
                    if (a.this.oLI != null) {
                        a.this.oLI.a(a.this.oLo, a.this.oLH);
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
                        if (a.this.oLI != null) {
                            a.this.oLI.egr();
                            return;
                        }
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501019));
                    if (a.this.oLI != null) {
                        a.this.oLI.egq();
                    }
                }
            }
        });
    }

    public void a(com.baidu.yuyinala.background.b.a aVar, Bitmap bitmap) {
        if (aVar != this.oLG) {
            if (this.oLG != null) {
                this.oLG.An(false);
            }
            this.oLG = aVar;
            this.oLG.An(true);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501019, bitmap));
        }
    }

    public void a(com.baidu.yuyinala.background.b.a aVar, String str) {
        if (aVar != this.oLG) {
            if (this.oLG != null) {
                this.oLG.An(false);
            }
            this.oLG = aVar;
            this.oLG.An(true);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501078, str));
        }
    }

    public void egp() {
        if (this.oLH != this.oLG) {
            if (this.oLG != null) {
                this.oLG.An(false);
            }
            if (this.oLH != null) {
                this.oLH.An(true);
            }
            this.oLG = null;
            this.oLH = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501019));
        }
    }

    public void ego() {
        if (this.oLH != this.oLG && this.oLG != null && !StringUtils.isNull(this.oLG.getOriginalUrl())) {
            WS(this.oLG.getOriginalUrl());
            this.oLG = null;
            this.oLH = null;
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

    public void egE() {
        String str;
        String str2;
        String str3;
        if (this.aBr == null || this.aBr.aGy == null) {
            str = null;
            str2 = null;
            str3 = null;
        } else {
            str3 = this.aBr.aGy.live_id;
            String str4 = this.aBr.aGy.croom_id;
            str = this.aBr.aGy.aQH;
            str2 = str4;
        }
        HttpMessage httpMessage = new HttpMessage(1031015);
        httpMessage.addParam("live_id", str3);
        httpMessage.addParam("room_id", str);
        httpMessage.addParam(UbcStatConstant.KEY_CUSTOM_ROOM_ID, str2);
        sendMessage(httpMessage);
    }

    private void WS(String str) {
        String str2;
        String str3;
        String str4;
        if (this.aBr == null || this.aBr.aGy == null) {
            str2 = null;
            str3 = null;
            str4 = null;
        } else {
            str4 = this.aBr.aGy.live_id;
            String str5 = this.aBr.aGy.croom_id;
            str2 = this.aBr.aGy.aQH;
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
        if (this.aBr == null || this.aBr.aGy == null) {
            return null;
        }
        return this.aBr.aGy.croom_id;
    }
}
