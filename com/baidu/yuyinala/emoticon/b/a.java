package com.baidu.yuyinala.emoticon.b;

import android.text.TextUtils;
import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.data.w;
import com.baidu.live.im.data.b;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.yuyinala.emoticon.AlaEmoticonListDialogData;
import com.baidu.yuyinala.emoticon.message.AlaEmoticonListResponseMessage;
import com.baidu.yuyinala.emoticon.message.AlaSendEmoticonResponseMessage;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a extends BdBaseModel {
    private static a oKv;
    private w aFN;
    private AlaEmoticonListDialogData oKt = new AlaEmoticonListDialogData();
    private InterfaceC0957a oKu;

    /* renamed from: com.baidu.yuyinala.emoticon.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0957a {
        void Yr(String str);

        void a(AlaEmoticonListDialogData alaEmoticonListDialogData);
    }

    public static a aA(w wVar) {
        if (oKv == null) {
            oKv = new a(wVar);
        }
        return oKv;
    }

    public void z(w wVar) {
        this.aFN = wVar;
    }

    private a(w wVar) {
        this.aFN = wVar;
        registerListener(new HttpMessageListener(1031004) { // from class: com.baidu.yuyinala.emoticon.b.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof AlaEmoticonListResponseMessage) {
                    AlaEmoticonListResponseMessage alaEmoticonListResponseMessage = (AlaEmoticonListResponseMessage) httpResponsedMessage;
                    a.this.oKt.setEmoticonList(alaEmoticonListResponseMessage.getEmoticonList());
                    a.this.oKt.setSendIntervalTime(alaEmoticonListResponseMessage.getSendIntervalTime());
                    a.this.oKt.setNetError(!alaEmoticonListResponseMessage.isSuccess());
                    if (a.this.oKu != null) {
                        a.this.oKu.a(a.this.oKt);
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
                    } else if (a.this.oKu != null) {
                        if (httpResponsedMessage.getError() == 149010) {
                            a.this.oKu.Yr(((AlaSendEmoticonResponseMessage) httpResponsedMessage).getUserMsg());
                        } else {
                            a.this.oKu.Yr(null);
                        }
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaSendEmoticonResponseMessage alaSendEmoticonResponseMessage) {
        b MB = MB();
        MB.setMsgType(13);
        try {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("compression_img", alaSendEmoticonResponseMessage.oKr);
            jSONObject2.put("prototype_img", alaSendEmoticonResponseMessage.oKq);
            jSONObject2.put("result_img", alaSendEmoticonResponseMessage.oKs);
            jSONObject.put("user_uk", this.aFN.aKr.userUk);
            jSONObject.put("content_type", "audio_emoticon");
            jSONObject.put("emoticon_info", jSONObject2);
            MB.setContent(jSONObject.toString());
            com.baidu.live.data.a aVar = new com.baidu.live.data.a();
            AlaLiveUserInfoData alaLiveUserInfoData = this.aFN.aKr;
            aVar.userName = alaLiveUserInfoData.userName;
            aVar.aIB = alaLiveUserInfoData.isAdmin == 1;
            aVar.aID = this.aFN.aKB;
            aVar.aIA = alaLiveUserInfoData.isOfficial == 1;
            aVar.portrait = alaLiveUserInfoData.portrait;
            aVar.userId = String.valueOf(ExtraParamsManager.getDecryptUserId(alaLiveUserInfoData.userUk));
            aVar.level_id = alaLiveUserInfoData.levelId;
            MB.e(aVar);
            MB.setUserId(Long.parseLong(aVar.userId));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501072, MB));
    }

    protected b MB() {
        com.baidu.live.im.a aVar = new com.baidu.live.im.a();
        aVar.setBornTime(System.currentTimeMillis());
        aVar.setTime(System.currentTimeMillis());
        aVar.setMsgId(System.currentTimeMillis());
        if (TextUtils.isEmpty(String.valueOf(this.aFN.mLiveInfo.getGroupID()))) {
            return null;
        }
        aVar.hY(String.valueOf(this.aFN.aKr.userId));
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

    public void a(InterfaceC0957a interfaceC0957a) {
        this.oKu = interfaceC0957a;
    }

    public void ekt() {
        sendMessage(new HttpMessage(1031004));
    }

    public void Ys(String str) {
        String str2;
        String str3;
        String str4 = null;
        if (this.aFN == null || this.aFN.mLiveInfo == null) {
            str2 = null;
            str3 = null;
        } else {
            str3 = String.valueOf(this.aFN.mLiveInfo.live_id);
            str4 = String.valueOf(this.aFN.mLiveInfo.room_id);
            str2 = String.valueOf(this.aFN.mLiveInfo.group_id);
        }
        HttpMessage httpMessage = new HttpMessage(1031025);
        httpMessage.addParam("img_id", str);
        httpMessage.addParam("live_id", str3);
        httpMessage.addParam("group_id", str2);
        httpMessage.addParam("room_id", str4);
        httpMessage.addParam("send_kind", 1);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public String getCustomRoomId() {
        if (this.aFN == null || this.aFN.aKL == null) {
            return null;
        }
        return this.aFN.aKL.croom_id;
    }
}
