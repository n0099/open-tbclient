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
    private final w aDh;
    private AlaAudioBackgroundDialogData ouA = new AlaAudioBackgroundDialogData();
    private com.baidu.yuyinala.background.b.a ouN;
    private com.baidu.yuyinala.background.b.a ouO;
    private InterfaceC0938a ouP;

    /* renamed from: com.baidu.yuyinala.background.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0938a {
        void a(AlaAudioBackgroundDialogData alaAudioBackgroundDialogData, com.baidu.yuyinala.background.b.a aVar);

        void eeq();
    }

    public a(w wVar, InterfaceC0938a interfaceC0938a) {
        this.aDh = wVar;
        this.ouP = interfaceC0938a;
        registerListener();
    }

    private void registerListener() {
        registerListener(new HttpMessageListener(1031015) { // from class: com.baidu.yuyinala.background.c.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof AlaAudioBackgroundListResponseMessage) {
                    AlaAudioBackgroundListResponseMessage alaAudioBackgroundListResponseMessage = (AlaAudioBackgroundListResponseMessage) httpResponsedMessage;
                    a.this.ouO = a.this.ouN = alaAudioBackgroundListResponseMessage.eez();
                    a.this.ouA.setBgList(alaAudioBackgroundListResponseMessage.getBgList());
                    if (a.this.ouP != null) {
                        a.this.ouP.a(a.this.ouA, a.this.ouO);
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
                    if (a.this.ouP != null) {
                        a.this.ouP.eeq();
                    }
                }
            }
        });
    }

    public void a(com.baidu.yuyinala.background.b.a aVar, Bitmap bitmap) {
        if (aVar != this.ouN) {
            if (this.ouN != null) {
                this.ouN.zM(false);
            }
            this.ouN = aVar;
            this.ouN.zM(true);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501019, bitmap));
        }
    }

    public void eep() {
        if (this.ouO != this.ouN) {
            if (this.ouN != null) {
                this.ouN.zM(false);
            }
            if (this.ouO != null) {
                this.ouO.zM(true);
            }
            this.ouN = null;
            this.ouO = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501019));
        }
    }

    public void eeo() {
        if (this.ouO != this.ouN && this.ouN != null && !StringUtils.isNull(this.ouN.getOriginalUrl())) {
            WV(this.ouN.getOriginalUrl());
            this.ouN = null;
            this.ouO = null;
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

    public void eeA() {
        String str;
        String str2;
        String str3 = null;
        if (this.aDh == null || this.aDh.aHZ == null) {
            str = null;
            str2 = null;
        } else {
            str2 = this.aDh.aHZ.live_id;
            str = this.aDh.aHZ.croom_id;
            str3 = this.aDh.aHZ.aRe;
        }
        HttpMessage httpMessage = new HttpMessage(1031015);
        httpMessage.addParam("live_id", str2);
        httpMessage.addParam("room_id", str3);
        httpMessage.addParam(UbcStatConstant.KEY_CUSTOM_ROOM_ID, str);
        sendMessage(httpMessage);
    }

    private void WV(String str) {
        String str2;
        String str3;
        String str4 = null;
        if (this.aDh == null || this.aDh.aHZ == null) {
            str2 = null;
            str3 = null;
        } else {
            str3 = this.aDh.aHZ.live_id;
            str2 = this.aDh.aHZ.croom_id;
            str4 = this.aDh.aHZ.aRe;
        }
        HttpMessage httpMessage = new HttpMessage(1031016);
        httpMessage.addParam("live_id", str3);
        httpMessage.addParam("room_id", str4);
        httpMessage.addParam(UbcStatConstant.KEY_CUSTOM_ROOM_ID, str2);
        httpMessage.addParam("background_url", str);
        sendMessage(httpMessage);
    }

    public String getCustomRoomId() {
        if (this.aDh == null || this.aDh.aHZ == null) {
            return null;
        }
        return this.aDh.aHZ.croom_id;
    }
}
