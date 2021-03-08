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
/* loaded from: classes10.dex */
public class a extends BdBaseModel {
    private final ab aED;
    private AlaAudioBackgroundDialogData oXZ = new AlaAudioBackgroundDialogData();
    private com.baidu.yuyinala.background.b.a oYr;
    private com.baidu.yuyinala.background.b.a oYs;
    private InterfaceC0965a oYt;

    /* renamed from: com.baidu.yuyinala.background.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0965a {
        void a(AlaAudioBackgroundDialogData alaAudioBackgroundDialogData, com.baidu.yuyinala.background.b.a aVar);

        void eja();

        void ejb();
    }

    public a(ab abVar, InterfaceC0965a interfaceC0965a) {
        this.aED = abVar;
        this.oYt = interfaceC0965a;
        registerListener();
    }

    private void registerListener() {
        registerListener(new HttpMessageListener(1031015) { // from class: com.baidu.yuyinala.background.d.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof AlaAudioBackgroundListResponseMessage) {
                    AlaAudioBackgroundListResponseMessage alaAudioBackgroundListResponseMessage = (AlaAudioBackgroundListResponseMessage) httpResponsedMessage;
                    a.this.oYs = a.this.oYr = alaAudioBackgroundListResponseMessage.ejn();
                    a.this.oXZ.setBgList(alaAudioBackgroundListResponseMessage.getBgList());
                    if (a.this.oYt != null) {
                        a.this.oYt.a(a.this.oXZ, a.this.oYs);
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
                        if (a.this.oYt != null) {
                            a.this.oYt.ejb();
                            return;
                        }
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501019));
                    if (a.this.oYt != null) {
                        a.this.oYt.eja();
                    }
                }
            }
        });
    }

    public void a(com.baidu.yuyinala.background.b.a aVar, Bitmap bitmap) {
        if (aVar != this.oYr) {
            if (this.oYr != null) {
                this.oYr.AF(false);
            }
            this.oYr = aVar;
            this.oYr.AF(true);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501019, bitmap));
        }
    }

    public void a(com.baidu.yuyinala.background.b.a aVar, String str) {
        if (aVar != this.oYr) {
            if (this.oYr != null) {
                this.oYr.AF(false);
            }
            this.oYr = aVar;
            this.oYr.AF(true);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501078, str));
        }
    }

    public void eiZ() {
        if (this.oYs != this.oYr) {
            if (this.oYr != null) {
                this.oYr.AF(false);
            }
            if (this.oYs != null) {
                this.oYs.AF(true);
            }
            this.oYr = null;
            this.oYs = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501019));
        }
    }

    public void eiY() {
        if (this.oYs != this.oYr && this.oYr != null && !StringUtils.isNull(this.oYr.getOriginalUrl())) {
            Yk(this.oYr.getOriginalUrl());
            this.oYr = null;
            this.oYs = null;
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

    public void ejo() {
        String str;
        String str2;
        String str3;
        if (this.aED == null || this.aED.aKu == null) {
            str = null;
            str2 = null;
            str3 = null;
        } else {
            str3 = this.aED.aKu.live_id;
            String str4 = this.aED.aKu.croom_id;
            str = this.aED.aKu.aVk;
            str2 = str4;
        }
        HttpMessage httpMessage = new HttpMessage(1031015);
        httpMessage.addParam("live_id", str3);
        httpMessage.addParam("room_id", str);
        httpMessage.addParam(UbcStatConstant.KEY_CUSTOM_ROOM_ID, str2);
        sendMessage(httpMessage);
    }

    private void Yk(String str) {
        String str2;
        String str3;
        String str4;
        if (this.aED == null || this.aED.aKu == null) {
            str2 = null;
            str3 = null;
            str4 = null;
        } else {
            str4 = this.aED.aKu.live_id;
            String str5 = this.aED.aKu.croom_id;
            str2 = this.aED.aKu.aVk;
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
        if (this.aED == null || this.aED.aKu == null) {
            return null;
        }
        return this.aED.aKu.croom_id;
    }
}
