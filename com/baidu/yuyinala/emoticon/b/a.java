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
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.yuyinala.emoticon.AlaEmoticonListDialogData;
import com.baidu.yuyinala.emoticon.message.AlaEmoticonListResponseMessage;
import com.baidu.yuyinala.emoticon.message.AlaSendEmoticonResponseMessage;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a extends BdBaseModel {
    private static a ovn;
    private w aDh;
    private AlaEmoticonListDialogData ovl = new AlaEmoticonListDialogData();
    private InterfaceC0940a ovm;

    /* renamed from: com.baidu.yuyinala.emoticon.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0940a {
        void WW(String str);

        void a(AlaEmoticonListDialogData alaEmoticonListDialogData);
    }

    public static a av(w wVar) {
        if (ovn == null) {
            ovn = new a(wVar);
        }
        return ovn;
    }

    public void y(w wVar) {
        this.aDh = wVar;
    }

    private a(w wVar) {
        this.aDh = wVar;
        registerListener(new HttpMessageListener(1031004) { // from class: com.baidu.yuyinala.emoticon.b.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof AlaEmoticonListResponseMessage) {
                    AlaEmoticonListResponseMessage alaEmoticonListResponseMessage = (AlaEmoticonListResponseMessage) httpResponsedMessage;
                    a.this.ovl.setEmoticonList(alaEmoticonListResponseMessage.getEmoticonList());
                    a.this.ovl.setSendIntervalTime(alaEmoticonListResponseMessage.getSendIntervalTime());
                    a.this.ovl.setNetError(!alaEmoticonListResponseMessage.isSuccess());
                    if (a.this.ovm != null) {
                        a.this.ovm.a(a.this.ovl);
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
                    } else if (a.this.ovm != null) {
                        if (httpResponsedMessage.getError() == 149010) {
                            a.this.ovm.WW(((AlaSendEmoticonResponseMessage) httpResponsedMessage).getUserMsg());
                        } else {
                            a.this.ovm.WW(null);
                        }
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaSendEmoticonResponseMessage alaSendEmoticonResponseMessage) {
        com.baidu.live.im.data.a Kz = Kz();
        Kz.setMsgType(13);
        try {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("compression_img", alaSendEmoticonResponseMessage.ovj);
            jSONObject2.put("prototype_img", alaSendEmoticonResponseMessage.ovi);
            jSONObject2.put("result_img", alaSendEmoticonResponseMessage.ovk);
            jSONObject.put("user_uk", this.aDh.aHG.userUk);
            jSONObject.put("content_type", "audio_emoticon");
            jSONObject.put("emoticon_info", jSONObject2);
            Kz.setContent(jSONObject.toString());
            com.baidu.live.data.a aVar = new com.baidu.live.data.a();
            AlaLiveUserInfoData alaLiveUserInfoData = this.aDh.aHG;
            aVar.userName = alaLiveUserInfoData.userName;
            aVar.aFT = alaLiveUserInfoData.isAdmin == 1;
            aVar.aFV = this.aDh.aHP;
            aVar.aFS = alaLiveUserInfoData.isOfficial == 1;
            aVar.portrait = alaLiveUserInfoData.portrait;
            aVar.userId = String.valueOf(ExtraParamsManager.getDecryptUserId(alaLiveUserInfoData.userUk));
            aVar.level_id = alaLiveUserInfoData.levelId;
            Kz.e(aVar);
            Kz.setUserId(Long.parseLong(aVar.userId));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501072, Kz));
    }

    protected com.baidu.live.im.data.a Kz() {
        com.baidu.live.im.a aVar = new com.baidu.live.im.a();
        aVar.setBornTime(System.currentTimeMillis());
        aVar.setTime(System.currentTimeMillis());
        aVar.setMsgId(System.currentTimeMillis());
        if (TextUtils.isEmpty(String.valueOf(this.aDh.mLiveInfo.getGroupID()))) {
            return null;
        }
        aVar.hy(String.valueOf(this.aDh.aHG.userId));
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

    public void a(InterfaceC0940a interfaceC0940a) {
        this.ovm = interfaceC0940a;
    }

    public void eeF() {
        sendMessage(new HttpMessage(1031004));
    }

    public void WX(String str) {
        String str2;
        String str3;
        String str4 = null;
        if (this.aDh == null || this.aDh.mLiveInfo == null) {
            str2 = null;
            str3 = null;
        } else {
            str3 = String.valueOf(this.aDh.mLiveInfo.live_id);
            str4 = String.valueOf(this.aDh.mLiveInfo.room_id);
            str2 = String.valueOf(this.aDh.mLiveInfo.group_id);
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
        if (this.aDh == null || this.aDh.aHZ == null) {
            return null;
        }
        return this.aDh.aHZ.croom_id;
    }
}
