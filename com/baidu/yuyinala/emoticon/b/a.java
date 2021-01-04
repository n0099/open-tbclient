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
/* loaded from: classes11.dex */
public class a extends BdBaseModel {
    private static a oQH;
    private x aGe;
    private AlaEmoticonListDialogData oQF = new AlaEmoticonListDialogData();
    private InterfaceC0934a oQG;

    /* renamed from: com.baidu.yuyinala.emoticon.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0934a {
        void Yb(String str);

        void a(AlaEmoticonListDialogData alaEmoticonListDialogData);
    }

    public static a aM(x xVar) {
        if (oQH == null) {
            oQH = new a(xVar);
        }
        return oQH;
    }

    public void aN(x xVar) {
        this.aGe = xVar;
    }

    private a(x xVar) {
        this.aGe = xVar;
        registerListener(new HttpMessageListener(1031004) { // from class: com.baidu.yuyinala.emoticon.b.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof AlaEmoticonListResponseMessage) {
                    AlaEmoticonListResponseMessage alaEmoticonListResponseMessage = (AlaEmoticonListResponseMessage) httpResponsedMessage;
                    a.this.oQF.setEmoticonList(alaEmoticonListResponseMessage.getEmoticonList());
                    a.this.oQF.setSendIntervalTime(alaEmoticonListResponseMessage.getSendIntervalTime());
                    a.this.oQF.setNetError(!alaEmoticonListResponseMessage.isSuccess());
                    if (a.this.oQG != null) {
                        a.this.oQG.a(a.this.oQF);
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
                    } else if (a.this.oQG != null) {
                        if (httpResponsedMessage.getError() == 149010) {
                            a.this.oQG.Yb(((AlaSendEmoticonResponseMessage) httpResponsedMessage).getUserMsg());
                        } else {
                            a.this.oQG.Yb(null);
                        }
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaSendEmoticonResponseMessage alaSendEmoticonResponseMessage) {
        b LY = LY();
        LY.setMsgType(13);
        try {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("compression_img", alaSendEmoticonResponseMessage.oQD);
            jSONObject2.put("prototype_img", alaSendEmoticonResponseMessage.oQC);
            jSONObject2.put("result_img", alaSendEmoticonResponseMessage.oQE);
            jSONObject.put("user_uk", this.aGe.aKQ.userUk);
            jSONObject.put("content_type", "audio_emoticon");
            jSONObject.put("emoticon_info", jSONObject2);
            LY.setContent(jSONObject.toString());
            com.baidu.live.data.a aVar = new com.baidu.live.data.a();
            AlaLiveUserInfoData alaLiveUserInfoData = this.aGe.aKQ;
            aVar.userName = alaLiveUserInfoData.userName;
            aVar.aIX = alaLiveUserInfoData.isAdmin == 1;
            aVar.aIZ = this.aGe.aLb;
            aVar.aIW = alaLiveUserInfoData.isOfficial == 1;
            aVar.portrait = alaLiveUserInfoData.portrait;
            aVar.userId = String.valueOf(ExtraParamsManager.getDecryptUserId(alaLiveUserInfoData.userUk));
            aVar.level_id = alaLiveUserInfoData.levelId;
            LY.e(aVar);
            LY.setUserId(Long.parseLong(aVar.userId));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501072, LY));
    }

    protected b LY() {
        com.baidu.live.im.a aVar = new com.baidu.live.im.a();
        aVar.setBornTime(System.currentTimeMillis());
        aVar.setTime(System.currentTimeMillis());
        aVar.setMsgId(System.currentTimeMillis());
        if (TextUtils.isEmpty(String.valueOf(this.aGe.mLiveInfo.getGroupID()))) {
            return null;
        }
        aVar.hJ(String.valueOf(this.aGe.aKQ.userId));
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

    public void a(InterfaceC0934a interfaceC0934a) {
        this.oQG = interfaceC0934a;
    }

    public void ekC() {
        sendMessage(new HttpMessage(1031004));
    }

    public void Yc(String str) {
        String str2;
        String str3;
        String str4;
        if (this.aGe == null || this.aGe.mLiveInfo == null) {
            str2 = null;
            str3 = null;
            str4 = null;
        } else {
            str4 = String.valueOf(this.aGe.mLiveInfo.live_id);
            str2 = String.valueOf(this.aGe.mLiveInfo.room_id);
            str3 = String.valueOf(this.aGe.mLiveInfo.group_id);
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
        if (this.aGe == null || this.aGe.aLl == null) {
            return null;
        }
        return this.aGe.aLl.croom_id;
    }
}
