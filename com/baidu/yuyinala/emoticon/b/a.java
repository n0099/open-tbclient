package com.baidu.yuyinala.emoticon.b;

import android.text.TextUtils;
import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.data.x;
import com.baidu.live.im.data.b;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.yuyinala.emoticon.AlaEmoticonListDialogData;
import com.baidu.yuyinala.emoticon.message.AlaEmoticonListResponseMessage;
import com.baidu.yuyinala.emoticon.message.AlaSendEmoticonResponseMessage;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a extends BdBaseModel {
    private static a oMg;
    private x aBr;
    private AlaEmoticonListDialogData oMe = new AlaEmoticonListDialogData();
    private InterfaceC0955a oMf;

    /* renamed from: com.baidu.yuyinala.emoticon.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0955a {
        void WT(String str);

        void a(AlaEmoticonListDialogData alaEmoticonListDialogData);
    }

    public static a aM(x xVar) {
        if (oMg == null) {
            oMg = new a(xVar);
        }
        return oMg;
    }

    public void aN(x xVar) {
        this.aBr = xVar;
    }

    private a(x xVar) {
        this.aBr = xVar;
        registerListener(new HttpMessageListener(1031004) { // from class: com.baidu.yuyinala.emoticon.b.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof AlaEmoticonListResponseMessage) {
                    AlaEmoticonListResponseMessage alaEmoticonListResponseMessage = (AlaEmoticonListResponseMessage) httpResponsedMessage;
                    a.this.oMe.setEmoticonList(alaEmoticonListResponseMessage.getEmoticonList());
                    a.this.oMe.setSendIntervalTime(alaEmoticonListResponseMessage.getSendIntervalTime());
                    a.this.oMe.setNetError(!alaEmoticonListResponseMessage.isSuccess());
                    if (a.this.oMf != null) {
                        a.this.oMf.a(a.this.oMe);
                    }
                }
            }
        });
        registerListener(new HttpMessageListener(1031025) { // from class: com.baidu.yuyinala.emoticon.b.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage.getCmd() == 1031025 && (httpResponsedMessage instanceof AlaSendEmoticonResponseMessage)) {
                    AlaSendEmoticonResponseMessage alaSendEmoticonResponseMessage = (AlaSendEmoticonResponseMessage) httpResponsedMessage;
                    if (httpResponsedMessage.getError() == 0) {
                        a.this.a(alaSendEmoticonResponseMessage);
                    } else if (a.this.oMf != null) {
                        if (httpResponsedMessage.getError() == 149010) {
                            a.this.oMf.WT(((AlaSendEmoticonResponseMessage) httpResponsedMessage).getUserMsg());
                        } else {
                            a.this.oMf.WT(null);
                        }
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaSendEmoticonResponseMessage alaSendEmoticonResponseMessage) {
        b Id = Id();
        Id.setMsgType(13);
        try {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("compression_img", alaSendEmoticonResponseMessage.oMc);
            jSONObject2.put("prototype_img", alaSendEmoticonResponseMessage.oMb);
            jSONObject2.put("result_img", alaSendEmoticonResponseMessage.oMd);
            jSONObject.put("user_uk", this.aBr.aGd.userUk);
            jSONObject.put("content_type", "audio_emoticon");
            jSONObject.put("emoticon_info", jSONObject2);
            Id.setContent(jSONObject.toString());
            com.baidu.live.data.a aVar = new com.baidu.live.data.a();
            AlaLiveUserInfoData alaLiveUserInfoData = this.aBr.aGd;
            aVar.userName = alaLiveUserInfoData.userName;
            aVar.aEk = alaLiveUserInfoData.isAdmin == 1;
            aVar.aEm = this.aBr.aGo;
            aVar.aEj = alaLiveUserInfoData.isOfficial == 1;
            aVar.portrait = alaLiveUserInfoData.portrait;
            aVar.userId = String.valueOf(ExtraParamsManager.getDecryptUserId(alaLiveUserInfoData.userUk));
            aVar.level_id = alaLiveUserInfoData.levelId;
            Id.e(aVar);
            Id.setUserId(Long.parseLong(aVar.userId));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501072, Id));
    }

    protected b Id() {
        com.baidu.live.im.a aVar = new com.baidu.live.im.a();
        aVar.setBornTime(System.currentTimeMillis());
        aVar.setTime(System.currentTimeMillis());
        aVar.setMsgId(System.currentTimeMillis());
        if (TextUtils.isEmpty(String.valueOf(this.aBr.mLiveInfo.getGroupID()))) {
            return null;
        }
        aVar.gy(String.valueOf(this.aBr.aGd.userId));
        return aVar;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    protected boolean loadData() {
        return false;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void a(InterfaceC0955a interfaceC0955a) {
        this.oMf = interfaceC0955a;
    }

    public void egJ() {
        sendMessage(new HttpMessage(1031004));
    }

    public void WU(String str) {
        String str2;
        String str3;
        String str4;
        if (this.aBr == null || this.aBr.mLiveInfo == null) {
            str2 = null;
            str3 = null;
            str4 = null;
        } else {
            str4 = String.valueOf(this.aBr.mLiveInfo.live_id);
            str2 = String.valueOf(this.aBr.mLiveInfo.room_id);
            str3 = String.valueOf(this.aBr.mLiveInfo.group_id);
        }
        HttpMessage httpMessage = new HttpMessage(1031025);
        httpMessage.addParam("img_id", str);
        httpMessage.addParam("live_id", str4);
        httpMessage.addParam("group_id", str3);
        httpMessage.addParam("room_id", str2);
        httpMessage.addParam("send_kind", 1);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public String getCustomRoomId() {
        if (this.aBr == null || this.aBr.aGy == null) {
            return null;
        }
        return this.aBr.aGy.croom_id;
    }
}
