package com.baidu.tieba.yuyinala.liveroom.share;

import android.os.Handler;
import android.util.Log;
import com.baidu.ala.AlaCmdConfigCustom;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.w;
import com.baidu.live.data.x;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.view.BlueCircleProgressDialog;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.tieba.model.a;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    private w aES;
    private BlueCircleProgressDialog bFe;
    private com.baidu.live.tieba.model.a hsF;
    private a.InterfaceC0216a hsG = new a.InterfaceC0216a() { // from class: com.baidu.tieba.yuyinala.liveroom.share.a.2
    };
    private Handler mHandler = new Handler();
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        che();
    }

    public void c(w wVar, boolean z) {
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            BdUtilHelper.showToast(TbadkCoreApplication.getInst().getContext(), a.h.sdk_neterror);
        } else if (wVar != null && wVar.aIV != null && wVar.mLiveInfo != null) {
            this.aES = wVar;
            if (TbadkCoreApplication.IS_SDK) {
                x xVar = new x();
                if (this.mPageContext != null) {
                    xVar.activity = this.mPageContext.getPageActivity();
                }
                xVar.alaLiveShowData = this.aES;
                MessageManager.getInstance().sendMessage(new CustomMessage(2913077, xVar));
            }
        }
    }

    private void che() {
        this.mPageContext.registerListener(new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_RES_ZIP_DOWNLOADED_STATUS) { // from class: com.baidu.tieba.yuyinala.liveroom.share.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    long longValue = ((Long) customResponsedMessage.getData()).longValue();
                    Log.i("AlaLiveViewController", "@@ initShareInterface.onMessage liveOwnerUid = " + longValue);
                    if (a.this.aES != null && a.this.aES.aIV != null && a.this.aES.aIV.userId == longValue) {
                        Log.i("AlaLiveViewController", "@@ initShareInterface live_id = " + a.this.aES.mLiveInfo.live_id);
                        a.this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.share.a.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HttpMessage httpMessage = new HttpMessage(1031078);
                                httpMessage.addParam("live_id", a.this.aES.mLiveInfo.live_id);
                                MessageManager.getInstance().sendMessage(httpMessage);
                            }
                        });
                    }
                    a.this.aa(a.this.aES);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aa(w wVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_SUBPAGE, "moretab");
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            if (wVar != null && wVar.aJK != null) {
                jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, wVar.aJK.croom_id);
            }
        } catch (JSONException e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1395, "click", UbcStatConstant.Page.VOICE_ROOM, LogConfig.VALUE_LIVE_SHARE_TO).setContentExt(jSONObject));
    }

    private void chg() {
        if (this.bFe != null) {
            this.bFe.setDialogVisiable(false);
        }
    }

    public void Dm() {
        chg();
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.hsF != null) {
            this.hsF.Tp();
        }
    }

    public void onDestroy() {
        chg();
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.hsF != null) {
            this.hsF.Tp();
            this.hsF.onDestroy();
        }
    }
}
