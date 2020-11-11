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
    private final w aES;
    private AlaAudioBackgroundDialogData osW = new AlaAudioBackgroundDialogData();
    private com.baidu.yuyinala.background.b.a otj;
    private com.baidu.yuyinala.background.b.a otk;
    private InterfaceC0935a otl;

    /* renamed from: com.baidu.yuyinala.background.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0935a {
        void a(AlaAudioBackgroundDialogData alaAudioBackgroundDialogData, com.baidu.yuyinala.background.b.a aVar);

        void ees();
    }

    public a(w wVar, InterfaceC0935a interfaceC0935a) {
        this.aES = wVar;
        this.otl = interfaceC0935a;
        registerListener();
    }

    private void registerListener() {
        registerListener(new HttpMessageListener(1031015) { // from class: com.baidu.yuyinala.background.c.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof AlaAudioBackgroundListResponseMessage) {
                    AlaAudioBackgroundListResponseMessage alaAudioBackgroundListResponseMessage = (AlaAudioBackgroundListResponseMessage) httpResponsedMessage;
                    a.this.otk = a.this.otj = alaAudioBackgroundListResponseMessage.eeB();
                    a.this.osW.setBgList(alaAudioBackgroundListResponseMessage.getBgList());
                    if (a.this.otl != null) {
                        a.this.otl.a(a.this.osW, a.this.otk);
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
                    if (a.this.otl != null) {
                        a.this.otl.ees();
                    }
                }
            }
        });
    }

    public void a(com.baidu.yuyinala.background.b.a aVar, Bitmap bitmap) {
        if (aVar != this.otj) {
            if (this.otj != null) {
                this.otj.zF(false);
            }
            this.otj = aVar;
            this.otj.zF(true);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501019, bitmap));
        }
    }

    public void eer() {
        if (this.otk != this.otj) {
            if (this.otj != null) {
                this.otj.zF(false);
            }
            if (this.otk != null) {
                this.otk.zF(true);
            }
            this.otj = null;
            this.otk = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501019));
        }
    }

    public void eeq() {
        if (this.otk != this.otj && this.otj != null && !StringUtils.isNull(this.otj.getOriginalUrl())) {
            Xk(this.otj.getOriginalUrl());
            this.otj = null;
            this.otk = null;
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

    public void eeC() {
        String str;
        String str2;
        String str3 = null;
        if (this.aES == null || this.aES.aJK == null) {
            str = null;
            str2 = null;
        } else {
            str2 = this.aES.aJK.live_id;
            str = this.aES.aJK.croom_id;
            str3 = this.aES.aJK.aSP;
        }
        HttpMessage httpMessage = new HttpMessage(1031015);
        httpMessage.addParam("live_id", str2);
        httpMessage.addParam("room_id", str3);
        httpMessage.addParam(UbcStatConstant.KEY_CUSTOM_ROOM_ID, str);
        sendMessage(httpMessage);
    }

    private void Xk(String str) {
        String str2;
        String str3;
        String str4 = null;
        if (this.aES == null || this.aES.aJK == null) {
            str2 = null;
            str3 = null;
        } else {
            str3 = this.aES.aJK.live_id;
            str2 = this.aES.aJK.croom_id;
            str4 = this.aES.aJK.aSP;
        }
        HttpMessage httpMessage = new HttpMessage(1031016);
        httpMessage.addParam("live_id", str3);
        httpMessage.addParam("room_id", str4);
        httpMessage.addParam(UbcStatConstant.KEY_CUSTOM_ROOM_ID, str2);
        httpMessage.addParam("background_url", str);
        sendMessage(httpMessage);
    }

    public String getCustomRoomId() {
        if (this.aES == null || this.aES.aJK == null) {
            return null;
        }
        return this.aES.aJK.croom_id;
    }
}
