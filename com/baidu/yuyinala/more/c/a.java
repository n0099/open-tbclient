package com.baidu.yuyinala.more.c;

import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
/* loaded from: classes4.dex */
public class a extends BdBaseModel {
    private String mCustomRoomId;
    private String mLiveId;
    private String mRoomId;
    private InterfaceC0923a okY;

    /* renamed from: com.baidu.yuyinala.more.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0923a {
        void ebk();

        void zw(boolean z);
    }

    public a(InterfaceC0923a interfaceC0923a) {
        this.okY = interfaceC0923a;
        registerListener(new HttpMessageListener(1031017) { // from class: com.baidu.yuyinala.more.c.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage.getCmd() == 1031017 && a.this.okY != null) {
                    a.this.okY.zw(httpResponsedMessage.getError() == 0);
                }
            }
        });
        registerListener(new HttpMessageListener(1031022) { // from class: com.baidu.yuyinala.more.c.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage.getCmd() == 1031022 && httpResponsedMessage.getError() != 0 && a.this.okY != null) {
                    a.this.okY.ebk();
                }
            }
        });
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    protected boolean loadData() {
        return false;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void O(String str, String str2, String str3, String str4) {
        this.mLiveId = str;
        this.mRoomId = str2;
        this.mCustomRoomId = str3;
    }

    public void ebo() {
        HttpMessage httpMessage = new HttpMessage(1031017);
        httpMessage.addParam("live_id", this.mLiveId);
        httpMessage.addParam(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.mCustomRoomId);
        httpMessage.addParam("room_id", this.mRoomId);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void ebp() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501024, this.mRoomId));
    }

    public void ebq() {
        HttpMessage httpMessage = new HttpMessage(1031022);
        httpMessage.addParam("room_id", this.mRoomId);
        httpMessage.addParam("live_id", this.mLiveId);
        MessageManager.getInstance().sendMessage(httpMessage);
    }
}
