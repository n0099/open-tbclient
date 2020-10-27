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
    private final w aEc;
    private AlaAudioBackgroundDialogData ojR = new AlaAudioBackgroundDialogData();
    private com.baidu.yuyinala.background.b.a oke;
    private com.baidu.yuyinala.background.b.a okf;
    private InterfaceC0919a okg;

    /* renamed from: com.baidu.yuyinala.background.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0919a {
        void a(AlaAudioBackgroundDialogData alaAudioBackgroundDialogData, com.baidu.yuyinala.background.b.a aVar);

        void eaK();
    }

    public a(w wVar, InterfaceC0919a interfaceC0919a) {
        this.aEc = wVar;
        this.okg = interfaceC0919a;
        registerListener();
    }

    private void registerListener() {
        registerListener(new HttpMessageListener(1031015) { // from class: com.baidu.yuyinala.background.c.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof AlaAudioBackgroundListResponseMessage) {
                    AlaAudioBackgroundListResponseMessage alaAudioBackgroundListResponseMessage = (AlaAudioBackgroundListResponseMessage) httpResponsedMessage;
                    a.this.okf = a.this.oke = alaAudioBackgroundListResponseMessage.eaT();
                    a.this.ojR.setBgList(alaAudioBackgroundListResponseMessage.getBgList());
                    if (a.this.okg != null) {
                        a.this.okg.a(a.this.ojR, a.this.okf);
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
                    if (a.this.okg != null) {
                        a.this.okg.eaK();
                    }
                }
            }
        });
    }

    public void a(com.baidu.yuyinala.background.b.a aVar, Bitmap bitmap) {
        if (aVar != this.oke) {
            if (this.oke != null) {
                this.oke.zu(false);
            }
            this.oke = aVar;
            this.oke.zu(true);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501019, bitmap));
        }
    }

    public void eaJ() {
        if (this.okf != this.oke) {
            if (this.oke != null) {
                this.oke.zu(false);
            }
            if (this.okf != null) {
                this.okf.zu(true);
            }
            this.oke = null;
            this.okf = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501019));
        }
    }

    public void eaI() {
        if (this.okf != this.oke && this.oke != null && !StringUtils.isNull(this.oke.getOriginalUrl())) {
            WH(this.oke.getOriginalUrl());
            this.oke = null;
            this.okf = null;
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

    public void eaU() {
        String str;
        String str2;
        String str3 = null;
        if (this.aEc == null || this.aEc.aIS == null) {
            str = null;
            str2 = null;
        } else {
            str2 = this.aEc.aIS.live_id;
            str = this.aEc.aIS.croom_id;
            str3 = this.aEc.aIS.aRy;
        }
        HttpMessage httpMessage = new HttpMessage(1031015);
        httpMessage.addParam("live_id", str2);
        httpMessage.addParam("room_id", str3);
        httpMessage.addParam(UbcStatConstant.KEY_CUSTOM_ROOM_ID, str);
        sendMessage(httpMessage);
    }

    private void WH(String str) {
        String str2;
        String str3;
        String str4 = null;
        if (this.aEc == null || this.aEc.aIS == null) {
            str2 = null;
            str3 = null;
        } else {
            str3 = this.aEc.aIS.live_id;
            str2 = this.aEc.aIS.croom_id;
            str4 = this.aEc.aIS.aRy;
        }
        HttpMessage httpMessage = new HttpMessage(1031016);
        httpMessage.addParam("live_id", str3);
        httpMessage.addParam("room_id", str4);
        httpMessage.addParam(UbcStatConstant.KEY_CUSTOM_ROOM_ID, str2);
        httpMessage.addParam("background_url", str);
        sendMessage(httpMessage);
    }

    public String getCustomRoomId() {
        if (this.aEc == null || this.aEc.aIS == null) {
            return null;
        }
        return this.aEc.aIS.croom_id;
    }
}
