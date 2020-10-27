package com.baidu.yuyinala.emoticon.b;

import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.data.w;
import com.baidu.yuyinala.emoticon.AlaEmoticonListDialogData;
import com.baidu.yuyinala.emoticon.message.AlaEmoticonListResponseMessage;
import com.baidu.yuyinala.emoticon.message.AlaSendEmoticonResponseMessage;
/* loaded from: classes4.dex */
public class a extends BdBaseModel {
    private w aEc;
    private InterfaceC0921a okA;
    private AlaEmoticonListDialogData okz = new AlaEmoticonListDialogData();

    /* renamed from: com.baidu.yuyinala.emoticon.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0921a {
        void WI(String str);

        void a(AlaEmoticonListDialogData alaEmoticonListDialogData);
    }

    public a(w wVar) {
        this.aEc = wVar;
        registerListener(new HttpMessageListener(1031004) { // from class: com.baidu.yuyinala.emoticon.b.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof AlaEmoticonListResponseMessage) {
                    AlaEmoticonListResponseMessage alaEmoticonListResponseMessage = (AlaEmoticonListResponseMessage) httpResponsedMessage;
                    a.this.okz.setEmoticonList(alaEmoticonListResponseMessage.getEmoticonList());
                    a.this.okz.setSendIntervalTime(alaEmoticonListResponseMessage.getSendIntervalTime());
                    a.this.okz.setNetError(!alaEmoticonListResponseMessage.isSuccess());
                    if (a.this.okA != null) {
                        a.this.okA.a(a.this.okz);
                    }
                }
            }
        });
        registerListener(new HttpMessageListener(1031025) { // from class: com.baidu.yuyinala.emoticon.b.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage.getCmd() == 1031025 && (httpResponsedMessage instanceof AlaSendEmoticonResponseMessage) && httpResponsedMessage.getError() != 0 && a.this.okA != null) {
                    if (httpResponsedMessage.getError() == 149010) {
                        a.this.okA.WI(((AlaSendEmoticonResponseMessage) httpResponsedMessage).getUserMsg());
                    } else {
                        a.this.okA.WI(null);
                    }
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

    public void a(InterfaceC0921a interfaceC0921a) {
        this.okA = interfaceC0921a;
    }

    public void eaZ() {
        sendMessage(new HttpMessage(1031004));
    }

    public void WJ(String str) {
        String str2;
        String str3;
        String str4 = null;
        if (this.aEc == null || this.aEc.mLiveInfo == null) {
            str2 = null;
            str3 = null;
        } else {
            str3 = String.valueOf(this.aEc.mLiveInfo.live_id);
            str4 = String.valueOf(this.aEc.mLiveInfo.room_id);
            str2 = String.valueOf(this.aEc.mLiveInfo.group_id);
        }
        HttpMessage httpMessage = new HttpMessage(1031025);
        httpMessage.addParam("img_id", str);
        httpMessage.addParam("live_id", str3);
        httpMessage.addParam("group_id", str2);
        httpMessage.addParam("room_id", str4);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public String getCustomRoomId() {
        if (this.aEc == null || this.aEc.aIS == null) {
            return null;
        }
        return this.aEc.aIS.croom_id;
    }
}
