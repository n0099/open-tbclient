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
    private w aDh;
    private BlueCircleProgressDialog bDt;
    private com.baidu.live.tieba.model.a hsm;
    private a.InterfaceC0214a hsn = new a.InterfaceC0214a() { // from class: com.baidu.tieba.yuyinala.liveroom.share.a.2
    };
    private Handler mHandler = new Handler();
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        cgx();
    }

    public void c(w wVar, boolean z) {
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            BdUtilHelper.showToast(TbadkCoreApplication.getInst().getContext(), a.h.sdk_neterror);
        } else if (wVar != null && wVar.aHk != null && wVar.mLiveInfo != null) {
            this.aDh = wVar;
            if (TbadkCoreApplication.IS_SDK) {
                x xVar = new x();
                if (this.mPageContext != null) {
                    xVar.activity = this.mPageContext.getPageActivity();
                }
                xVar.alaLiveShowData = this.aDh;
                MessageManager.getInstance().sendMessage(new CustomMessage(2913077, xVar));
            }
        }
    }

    private void cgx() {
        this.mPageContext.registerListener(new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_RES_ZIP_DOWNLOADED_STATUS) { // from class: com.baidu.tieba.yuyinala.liveroom.share.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    long longValue = ((Long) customResponsedMessage.getData()).longValue();
                    Log.i("AlaLiveViewController", "@@ initShareInterface.onMessage liveOwnerUid = " + longValue);
                    if (a.this.aDh != null && a.this.aDh.aHk != null && a.this.aDh.aHk.userId == longValue) {
                        Log.i("AlaLiveViewController", "@@ initShareInterface live_id = " + a.this.aDh.mLiveInfo.live_id);
                        a.this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.share.a.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HttpMessage httpMessage = new HttpMessage(1031078);
                                httpMessage.addParam("live_id", a.this.aDh.mLiveInfo.live_id);
                                MessageManager.getInstance().sendMessage(httpMessage);
                            }
                        });
                    }
                    a.this.aa(a.this.aDh);
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
            if (wVar != null && wVar.aHZ != null) {
                jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, wVar.aHZ.croom_id);
            }
        } catch (JSONException e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1395, "click", UbcStatConstant.Page.VOICE_ROOM, LogConfig.VALUE_LIVE_SHARE_TO).setContentExt(jSONObject));
    }

    private void cgz() {
        if (this.bDt != null) {
            this.bDt.setDialogVisiable(false);
        }
    }

    public void CD() {
        cgz();
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.hsm != null) {
            this.hsm.SG();
        }
    }

    public void onDestroy() {
        cgz();
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.hsm != null) {
            this.hsm.SG();
            this.hsm.onDestroy();
        }
    }
}
