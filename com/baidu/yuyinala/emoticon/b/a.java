package com.baidu.yuyinala.emoticon.b;

import android.text.TextUtils;
import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.data.ab;
import com.baidu.live.im.data.b;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.yuyinala.emoticon.AlaEmoticonListDialogData;
import com.baidu.yuyinala.emoticon.message.AlaEmoticonListResponseMessage;
import com.baidu.yuyinala.emoticon.message.AlaSendEmoticonResponseMessage;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a extends BdBaseModel {
    private static a oWM;
    private ab aDd;
    private AlaEmoticonListDialogData oWK = new AlaEmoticonListDialogData();
    private InterfaceC0961a oWL;

    /* renamed from: com.baidu.yuyinala.emoticon.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0961a {
        void Ye(String str);

        void a(AlaEmoticonListDialogData alaEmoticonListDialogData);
    }

    public static a aP(ab abVar) {
        if (oWM == null) {
            oWM = new a(abVar);
        }
        return oWM;
    }

    public void aQ(ab abVar) {
        this.aDd = abVar;
    }

    private a(ab abVar) {
        this.aDd = abVar;
        registerListener(new HttpMessageListener(1031004) { // from class: com.baidu.yuyinala.emoticon.b.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof AlaEmoticonListResponseMessage) {
                    AlaEmoticonListResponseMessage alaEmoticonListResponseMessage = (AlaEmoticonListResponseMessage) httpResponsedMessage;
                    a.this.oWK.setEmoticonList(alaEmoticonListResponseMessage.getEmoticonList());
                    a.this.oWK.setSendIntervalTime(alaEmoticonListResponseMessage.getSendIntervalTime());
                    a.this.oWK.setNetError(!alaEmoticonListResponseMessage.isSuccess());
                    if (a.this.oWL != null) {
                        a.this.oWL.a(a.this.oWK);
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
                    } else if (a.this.oWL != null) {
                        if (httpResponsedMessage.getError() == 149010) {
                            a.this.oWL.Ye(((AlaSendEmoticonResponseMessage) httpResponsedMessage).getUserMsg());
                        } else {
                            a.this.oWL.Ye(null);
                        }
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaSendEmoticonResponseMessage alaSendEmoticonResponseMessage) {
        b JB = JB();
        JB.setMsgType(13);
        try {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("compression_img", alaSendEmoticonResponseMessage.oWI);
            jSONObject2.put("prototype_img", alaSendEmoticonResponseMessage.oWH);
            jSONObject2.put("result_img", alaSendEmoticonResponseMessage.oWJ);
            jSONObject.put("user_uk", this.aDd.aIz.userUk);
            jSONObject.put("content_type", "audio_emoticon");
            jSONObject.put("emoticon_info", jSONObject2);
            JB.setContent(jSONObject.toString());
            com.baidu.live.data.a aVar = new com.baidu.live.data.a();
            AlaLiveUserInfoData alaLiveUserInfoData = this.aDd.aIz;
            aVar.userName = alaLiveUserInfoData.userName;
            aVar.aFX = alaLiveUserInfoData.isAdmin == 1;
            aVar.aFZ = this.aDd.aIK;
            aVar.aFW = alaLiveUserInfoData.isOfficial == 1;
            aVar.portrait = alaLiveUserInfoData.portrait;
            aVar.userId = String.valueOf(ExtraParamsManager.getDecryptUserId(alaLiveUserInfoData.userUk));
            aVar.level_id = alaLiveUserInfoData.levelId;
            JB.e(aVar);
            JB.setUserId(Long.parseLong(aVar.userId));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501072, JB));
    }

    protected b JB() {
        com.baidu.live.im.a aVar = new com.baidu.live.im.a();
        aVar.setBornTime(System.currentTimeMillis());
        aVar.setTime(System.currentTimeMillis());
        aVar.setMsgId(System.currentTimeMillis());
        if (TextUtils.isEmpty(String.valueOf(this.aDd.mLiveInfo.getGroupID()))) {
            return null;
        }
        aVar.gW(String.valueOf(this.aDd.aIz.userId));
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

    public void a(InterfaceC0961a interfaceC0961a) {
        this.oWL = interfaceC0961a;
    }

    public void ejj() {
        sendMessage(new HttpMessage(1031004));
    }

    public void Yf(String str) {
        String str2;
        String str3;
        String str4;
        if (this.aDd == null || this.aDd.mLiveInfo == null) {
            str2 = null;
            str3 = null;
            str4 = null;
        } else {
            str4 = String.valueOf(this.aDd.mLiveInfo.live_id);
            str2 = String.valueOf(this.aDd.mLiveInfo.room_id);
            str3 = String.valueOf(this.aDd.mLiveInfo.group_id);
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
        if (this.aDd == null || this.aDd.aIU == null) {
            return null;
        }
        return this.aDd.aIU.croom_id;
    }
}
