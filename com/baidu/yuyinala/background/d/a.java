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
    private com.baidu.yuyinala.background.b.a oVM;
    private com.baidu.yuyinala.background.b.a oVN;
    private InterfaceC0957a oVO;
    private AlaAudioBackgroundDialogData oVu = new AlaAudioBackgroundDialogData();

    /* renamed from: com.baidu.yuyinala.background.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0957a {
        void a(AlaAudioBackgroundDialogData alaAudioBackgroundDialogData, com.baidu.yuyinala.background.b.a aVar);

        void eiI();

        void eiJ();
    }

    public a(ab abVar, InterfaceC0957a interfaceC0957a) {
        this.aDd = abVar;
        this.oVO = interfaceC0957a;
        registerListener();
    }

    private void registerListener() {
        registerListener(new HttpMessageListener(1031015) { // from class: com.baidu.yuyinala.background.d.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof AlaAudioBackgroundListResponseMessage) {
                    AlaAudioBackgroundListResponseMessage alaAudioBackgroundListResponseMessage = (AlaAudioBackgroundListResponseMessage) httpResponsedMessage;
                    a.this.oVN = a.this.oVM = alaAudioBackgroundListResponseMessage.eiV();
                    a.this.oVu.setBgList(alaAudioBackgroundListResponseMessage.getBgList());
                    if (a.this.oVO != null) {
                        a.this.oVO.a(a.this.oVu, a.this.oVN);
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
                        if (a.this.oVO != null) {
                            a.this.oVO.eiJ();
                            return;
                        }
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501019));
                    if (a.this.oVO != null) {
                        a.this.oVO.eiI();
                    }
                }
            }
        });
    }

    public void a(com.baidu.yuyinala.background.b.a aVar, Bitmap bitmap) {
        if (aVar != this.oVM) {
            if (this.oVM != null) {
                this.oVM.AG(false);
            }
            this.oVM = aVar;
            this.oVM.AG(true);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501019, bitmap));
        }
    }

    public void a(com.baidu.yuyinala.background.b.a aVar, String str) {
        if (aVar != this.oVM) {
            if (this.oVM != null) {
                this.oVM.AG(false);
            }
            this.oVM = aVar;
            this.oVM.AG(true);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501078, str));
        }
    }

    public void eiH() {
        if (this.oVN != this.oVM) {
            if (this.oVM != null) {
                this.oVM.AG(false);
            }
            if (this.oVN != null) {
                this.oVN.AG(true);
            }
            this.oVM = null;
            this.oVN = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501019));
        }
    }

    public void eiG() {
        if (this.oVN != this.oVM && this.oVM != null && !StringUtils.isNull(this.oVM.getOriginalUrl())) {
            XR(this.oVM.getOriginalUrl());
            this.oVM = null;
            this.oVN = null;
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

    public void eiW() {
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

    private void XR(String str) {
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
