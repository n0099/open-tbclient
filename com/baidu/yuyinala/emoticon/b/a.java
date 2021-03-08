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
/* loaded from: classes10.dex */
public class a extends BdBaseModel {
    private static a oYR;
    private ab aED;
    private AlaEmoticonListDialogData oYP = new AlaEmoticonListDialogData();
    private InterfaceC0967a oYQ;

    /* renamed from: com.baidu.yuyinala.emoticon.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0967a {
        void Yl(String str);

        void a(AlaEmoticonListDialogData alaEmoticonListDialogData);
    }

    public static a aP(ab abVar) {
        if (oYR == null) {
            oYR = new a(abVar);
        }
        return oYR;
    }

    public void aQ(ab abVar) {
        this.aED = abVar;
    }

    private a(ab abVar) {
        this.aED = abVar;
        registerListener(new HttpMessageListener(1031004) { // from class: com.baidu.yuyinala.emoticon.b.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof AlaEmoticonListResponseMessage) {
                    AlaEmoticonListResponseMessage alaEmoticonListResponseMessage = (AlaEmoticonListResponseMessage) httpResponsedMessage;
                    a.this.oYP.setEmoticonList(alaEmoticonListResponseMessage.getEmoticonList());
                    a.this.oYP.setSendIntervalTime(alaEmoticonListResponseMessage.getSendIntervalTime());
                    a.this.oYP.setNetError(!alaEmoticonListResponseMessage.isSuccess());
                    if (a.this.oYQ != null) {
                        a.this.oYQ.a(a.this.oYP);
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
                    } else if (a.this.oYQ != null) {
                        if (httpResponsedMessage.getError() == 149010) {
                            a.this.oYQ.Yl(((AlaSendEmoticonResponseMessage) httpResponsedMessage).getUserMsg());
                        } else {
                            a.this.oYQ.Yl(null);
                        }
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaSendEmoticonResponseMessage alaSendEmoticonResponseMessage) {
        b JE = JE();
        JE.setMsgType(13);
        try {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("compression_img", alaSendEmoticonResponseMessage.oYN);
            jSONObject2.put("prototype_img", alaSendEmoticonResponseMessage.oYM);
            jSONObject2.put("result_img", alaSendEmoticonResponseMessage.oYO);
            jSONObject.put("user_uk", this.aED.aJZ.userUk);
            jSONObject.put("content_type", "audio_emoticon");
            jSONObject.put("emoticon_info", jSONObject2);
            JE.setContent(jSONObject.toString());
            com.baidu.live.data.a aVar = new com.baidu.live.data.a();
            AlaLiveUserInfoData alaLiveUserInfoData = this.aED.aJZ;
            aVar.userName = alaLiveUserInfoData.userName;
            aVar.aHx = alaLiveUserInfoData.isAdmin == 1;
            aVar.aHz = this.aED.aKk;
            aVar.aHw = alaLiveUserInfoData.isOfficial == 1;
            aVar.portrait = alaLiveUserInfoData.portrait;
            aVar.userId = String.valueOf(ExtraParamsManager.getDecryptUserId(alaLiveUserInfoData.userUk));
            aVar.level_id = alaLiveUserInfoData.levelId;
            JE.e(aVar);
            JE.setUserId(Long.parseLong(aVar.userId));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501072, JE));
    }

    protected b JE() {
        com.baidu.live.im.a aVar = new com.baidu.live.im.a();
        aVar.setBornTime(System.currentTimeMillis());
        aVar.setTime(System.currentTimeMillis());
        aVar.setMsgId(System.currentTimeMillis());
        if (TextUtils.isEmpty(String.valueOf(this.aED.mLiveInfo.getGroupID()))) {
            return null;
        }
        aVar.hc(String.valueOf(this.aED.aJZ.userId));
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

    public void a(InterfaceC0967a interfaceC0967a) {
        this.oYQ = interfaceC0967a;
    }

    public void ejt() {
        sendMessage(new HttpMessage(1031004));
    }

    public void Ym(String str) {
        String str2;
        String str3;
        String str4;
        if (this.aED == null || this.aED.mLiveInfo == null) {
            str2 = null;
            str3 = null;
            str4 = null;
        } else {
            str4 = String.valueOf(this.aED.mLiveInfo.live_id);
            str2 = String.valueOf(this.aED.mLiveInfo.room_id);
            str3 = String.valueOf(this.aED.mLiveInfo.group_id);
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
        if (this.aED == null || this.aED.aKu == null) {
            return null;
        }
        return this.aED.aKu.croom_id;
    }
}
