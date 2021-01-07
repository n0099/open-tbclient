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
/* loaded from: classes11.dex */
public class a extends BdBaseModel {
    private final x aGe;
    private AlaAudioBackgroundDialogData oPP = new AlaAudioBackgroundDialogData();
    private com.baidu.yuyinala.background.b.a oQh;
    private com.baidu.yuyinala.background.b.a oQi;
    private InterfaceC0970a oQj;

    /* renamed from: com.baidu.yuyinala.background.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0970a {
        void a(AlaAudioBackgroundDialogData alaAudioBackgroundDialogData, com.baidu.yuyinala.background.b.a aVar);

        void ekk();

        void ekl();
    }

    public a(x xVar, InterfaceC0970a interfaceC0970a) {
        this.aGe = xVar;
        this.oQj = interfaceC0970a;
        registerListener();
    }

    private void registerListener() {
        registerListener(new HttpMessageListener(1031015) { // from class: com.baidu.yuyinala.background.d.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof AlaAudioBackgroundListResponseMessage) {
                    AlaAudioBackgroundListResponseMessage alaAudioBackgroundListResponseMessage = (AlaAudioBackgroundListResponseMessage) httpResponsedMessage;
                    a.this.oQi = a.this.oQh = alaAudioBackgroundListResponseMessage.ekx();
                    a.this.oPP.setBgList(alaAudioBackgroundListResponseMessage.getBgList());
                    if (a.this.oQj != null) {
                        a.this.oQj.a(a.this.oPP, a.this.oQi);
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
                        if (a.this.oQj != null) {
                            a.this.oQj.ekl();
                            return;
                        }
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501019));
                    if (a.this.oQj != null) {
                        a.this.oQj.ekk();
                    }
                }
            }
        });
    }

    public void a(com.baidu.yuyinala.background.b.a aVar, Bitmap bitmap) {
        if (aVar != this.oQh) {
            if (this.oQh != null) {
                this.oQh.Ar(false);
            }
            this.oQh = aVar;
            this.oQh.Ar(true);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501019, bitmap));
        }
    }

    public void a(com.baidu.yuyinala.background.b.a aVar, String str) {
        if (aVar != this.oQh) {
            if (this.oQh != null) {
                this.oQh.Ar(false);
            }
            this.oQh = aVar;
            this.oQh.Ar(true);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501078, str));
        }
    }

    public void ekj() {
        if (this.oQi != this.oQh) {
            if (this.oQh != null) {
                this.oQh.Ar(false);
            }
            if (this.oQi != null) {
                this.oQi.Ar(true);
            }
            this.oQh = null;
            this.oQi = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501019));
        }
    }

    public void eki() {
        if (this.oQi != this.oQh && this.oQh != null && !StringUtils.isNull(this.oQh.getOriginalUrl())) {
            XZ(this.oQh.getOriginalUrl());
            this.oQh = null;
            this.oQi = null;
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

    public void eky() {
        String str;
        String str2;
        String str3;
        if (this.aGe == null || this.aGe.aLl == null) {
            str = null;
            str2 = null;
            str3 = null;
        } else {
            str3 = this.aGe.aLl.live_id;
            String str4 = this.aGe.aLl.croom_id;
            str = this.aGe.aLl.aVu;
            str2 = str4;
        }
        HttpMessage httpMessage = new HttpMessage(1031015);
        httpMessage.addParam("live_id", str3);
        httpMessage.addParam("room_id", str);
        httpMessage.addParam(UbcStatConstant.KEY_CUSTOM_ROOM_ID, str2);
        sendMessage(httpMessage);
    }

    private void XZ(String str) {
        String str2;
        String str3;
        String str4;
        if (this.aGe == null || this.aGe.aLl == null) {
            str2 = null;
            str3 = null;
            str4 = null;
        } else {
            str4 = this.aGe.aLl.live_id;
            String str5 = this.aGe.aLl.croom_id;
            str2 = this.aGe.aLl.aVu;
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
        if (this.aGe == null || this.aGe.aLl == null) {
            return null;
        }
        return this.aGe.aLl.croom_id;
    }
}
