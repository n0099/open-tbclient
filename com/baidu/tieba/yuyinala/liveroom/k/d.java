package com.baidu.tieba.yuyinala.liveroom.k;

import android.os.Handler;
import android.text.TextUtils;
import com.baidu.android.imsdk.BIMManager;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.base.BdPageContext;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.lib.safe.SafeHandler;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.data.ab;
import com.baidu.live.data.aw;
import com.baidu.live.data.bt;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.browser.BrowserHelper;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.FaceRecognitionActivityConfig;
import com.baidu.live.tbadk.core.atomdata.YuyinAlaLiveRoomActivityConfig;
import com.baidu.live.tbadk.core.dialog.BdAlertDialog;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.extraparams.interfaces.IExtraParams;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.tbadk.realAuthen.RealAuthenManager;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.tieba.yuyinala.liveroom.k.a;
import com.baidu.tieba.yuyinala.liveroom.messages.AlaGetVerifyStrategyResponseHttpMessage;
import com.baidu.tieba.yuyinala.liveroom.messages.AlaUpdateLiveTbResponseMessage;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class d extends BdBaseModel {
    private ab aDd;
    private BdPageContext<?> bkx;
    private HttpMessageListener hKB;
    private HttpMessageListener hKL;
    private Handler hKd;
    private aw hKh;
    private int hKm;
    private BdAlertDialog hKt;
    private a.InterfaceC0928a oxa;
    private AlaGetVerifyStrategyResponseHttpMessage oxs;

    public d(BdPageContext<?> bdPageContext) {
        super(bdPageContext);
        this.hKd = new Handler();
        this.hKm = 1;
        this.hKL = new HttpMessageListener(1031030) { // from class: com.baidu.tieba.yuyinala.liveroom.k.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaUpdateLiveTbResponseMessage) && httpResponsedMessage.getOrginalMessage().getTag() == d.this.unique_id) {
                    if (httpResponsedMessage.getError() != 0 || httpResponsedMessage.hasError()) {
                        UbcStatisticManager.getInstance().logSendResponse(new UbcStatisticItem("1534", "create_live", UbcStatConstant.Page.VOICE_CREATE_ROOM, null), httpResponsedMessage, true);
                    }
                    d.this.hKh = ((AlaUpdateLiveTbResponseMessage) httpResponsedMessage).ciV();
                    if (d.this.hKh != null) {
                        if (d.this.hKh.mErrorCode == 0) {
                            JSONObject jSONObject = new JSONObject();
                            JSONObject jSONObject2 = new JSONObject();
                            try {
                                jSONObject2.put(LogConfig.VALUE_LIVE_HK_RECORD_START, d.this.hKh.aOd);
                                jSONObject2.put("user_verify", d.this.hKh.aOf);
                                jSONObject2.put("certify", d.this.hKh.aOh);
                                if (d.this.hKh.mLiveSdkInfo != null && d.this.hKh.mLiveSdkInfo.mCastIds != null) {
                                    jSONObject2.put(YuyinAlaLiveRoomActivityConfig.SDK_AUDIO_ROOM_CHAT_CAST_ID, d.this.hKh.mLiveSdkInfo.mCastIds.chatMCastId);
                                    jSONObject2.put("ensure_mcast_id", d.this.hKh.mLiveSdkInfo.mCastIds.ensureMCastId);
                                }
                                jSONObject.put("result", jSONObject2);
                            } catch (JSONException e) {
                                BdLog.e(e);
                            }
                            UbcStatisticManager.getInstance().logSendResponse(new UbcStatisticItem("1534", UbcStatConstant.ContentType.UBC_TYPE_CREATE_LIVE_SUCC, UbcStatConstant.Page.VOICE_CREATE_ROOM, null).setContentExt(jSONObject), httpResponsedMessage, true);
                        }
                        if (d.this.hKh.aOd != 1 || d.this.hKh.aOf != 1) {
                            d.this.hKd.postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.k.d.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    d.this.cjr();
                                }
                            }, 200L);
                            return;
                        } else if (d.this.hKh.mErrorCode != 0) {
                            if (d.this.hKh.mErrorCode == 220012) {
                                d.this.b(d.this.hKh.mErrorCode, d.this.hKh.mErrorMsg, 6, d.this.aDd);
                                return;
                            }
                        } else {
                            d.this.aDd = new ab();
                            d.this.aDd.bx(true);
                            d.this.aDd.mLiveInfo = d.this.hKh.mLiveInfo;
                            d.this.aDd.isHost = true;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913081, d.this.aDd));
                        }
                    }
                    d.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 6, d.this.aDd);
                    if (d.this.aDd != null && d.this.aDd.mLiveInfo != null) {
                        d.this.A(d.this.aDd.mLiveInfo.user_id, d.this.aDd.mLiveInfo.live_id);
                    }
                    com.baidu.live.d.xc().putLong("audio_enter_live_timestamp", System.currentTimeMillis() / 1000);
                }
            }
        };
        this.hKB = new HttpMessageListener(1031028) { // from class: com.baidu.tieba.yuyinala.liveroom.k.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof AlaGetVerifyStrategyResponseHttpMessage) {
                    SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.k.d.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            MessageManager.getInstance().unRegisterStickyMode(1031028);
                        }
                    });
                    final AlaGetVerifyStrategyResponseHttpMessage alaGetVerifyStrategyResponseHttpMessage = (AlaGetVerifyStrategyResponseHttpMessage) httpResponsedMessage;
                    d.this.b(alaGetVerifyStrategyResponseHttpMessage.getError(), alaGetVerifyStrategyResponseHttpMessage.getErrorString(), 7, alaGetVerifyStrategyResponseHttpMessage);
                    if (httpResponsedMessage.getError() != 0 || httpResponsedMessage.hasError()) {
                        UbcStatisticManager.getInstance().logSendResponse(new UbcStatisticItem("1534", UbcStatConstant.ContentType.UBC_TYPE_STRATEGY, UbcStatConstant.Page.VOICE_CREATE_ROOM, null), httpResponsedMessage, true);
                    } else {
                        JSONObject jSONObject = new JSONObject();
                        JSONObject jSONObject2 = new JSONObject();
                        try {
                            jSONObject2.put(LogConfig.VALUE_LIVE_HK_RECORD_START, alaGetVerifyStrategyResponseHttpMessage.hJy);
                            jSONObject2.put("user_verify", alaGetVerifyStrategyResponseHttpMessage.hJA);
                            jSONObject2.put("certify", alaGetVerifyStrategyResponseHttpMessage.hJD);
                            jSONObject.put("result", jSONObject2);
                        } catch (JSONException e) {
                            BdLog.e(e);
                        }
                        UbcStatisticManager.getInstance().logSendResponse(new UbcStatisticItem("1534", UbcStatConstant.ContentType.UBC_TYPE_CREATE_STRATEGY_SUCC, UbcStatConstant.Page.VOICE_CREATE_ROOM, null).setContentExt(jSONObject), httpResponsedMessage, true);
                    }
                    if (httpResponsedMessage.getError() == 0) {
                        if (alaGetVerifyStrategyResponseHttpMessage.hJA != 1 || alaGetVerifyStrategyResponseHttpMessage.hJy != 1 || alaGetVerifyStrategyResponseHttpMessage.hJD != 1) {
                            d.this.oxs = alaGetVerifyStrategyResponseHttpMessage;
                            if (alaGetVerifyStrategyResponseHttpMessage.hJD != 1) {
                                d.this.hKd.postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.k.d.2.2
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        d.this.cjq();
                                    }
                                }, 200L);
                                return;
                            } else if (alaGetVerifyStrategyResponseHttpMessage.hJA != 1 || alaGetVerifyStrategyResponseHttpMessage.hJy != 1) {
                                d.this.hKd.postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.k.d.2.3
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        d.this.ez(alaGetVerifyStrategyResponseHttpMessage.hJG, alaGetVerifyStrategyResponseHttpMessage.hJH);
                                    }
                                }, 200L);
                                return;
                            } else {
                                return;
                            }
                        }
                        d.this.oxs = null;
                    }
                }
            }
        };
        this.bkx = bdPageContext;
        initTasks();
        registerListener(this.hKL);
        registerListener(this.hKB);
    }

    public void a(a.InterfaceC0928a interfaceC0928a) {
        this.oxa = interfaceC0928a;
    }

    public void cjo() {
        MessageManager.getInstance().sendMessage(new HttpMessage(1031028));
        UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem("1526", UbcStatConstant.ContentType.UBC_TYPE_STRATEGY, UbcStatConstant.Page.VOICE_CREATE_ROOM, null));
    }

    public aw cjv() {
        return this.hKh;
    }

    public void b(String str, String str2, String str3, int i, double d, double d2, String str4, String str5, int i2, String str6, String str7, String str8, int i3, int i4, int i5, int i6, String str9, String str10) {
        if (!cjz()) {
            HttpMessage httpMessage = new HttpMessage(1031030);
            httpMessage.addParam("forum_name", str);
            httpMessage.addParam("forum_id", str2);
            httpMessage.addParam("description", str3);
            httpMessage.addParam(DpStatConstants.KEY_ROOM_NAME, str3);
            httpMessage.addParam("is_location", i);
            httpMessage.addParam("lat", Double.toString(d));
            httpMessage.addParam("lng", Double.toString(d2));
            httpMessage.addParam("location_name", str4);
            httpMessage.addParam("location_name_md5", str5);
            httpMessage.addParam("is_to_tb_some", i2);
            httpMessage.addParam("cover", str6);
            httpMessage.addParam("vcode", str7);
            httpMessage.addParam("vcode_md5", str8);
            httpMessage.addParam("is_test_live", i3);
            httpMessage.addParam(UbcStatConstant.KEY_LIVE_TYPE, i4);
            httpMessage.addParam("open_type", 2);
            httpMessage.addParam("screen_direction", i5);
            httpMessage.addParam("ar_sdk_version", TbConfig.AR_SDK_VERSION);
            httpMessage.addParam("is_prettify", bt.b(com.baidu.live.ae.a.Qj().bAS) ? 1 : 2);
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isMobileBaidu() || TbadkCoreApplication.getInst().isTieba()) {
                httpMessage.addParam("im_sdk_version", BIMManager.getVersion() + "");
                httpMessage.addParam("app_id", AccountManager.getAppid(TbadkCoreApplication.getInst().getContext()) + "");
            }
            if (i6 > 0) {
                httpMessage.addParam("clarity", i6);
            }
            if (str9 != null) {
                httpMessage.addParam("game_id", str9);
            }
            if (str10 != null) {
                httpMessage.addParam("game_name", str10);
            }
            sendMessage(httpMessage);
            UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem("1526", "create_live", UbcStatConstant.Page.VOICE_CREATE_ROOM, null));
        }
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    protected boolean loadData() {
        return false;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(long j, long j2) {
        HttpMessage httpMessage = new HttpMessage(1031071);
        httpMessage.addParam("user_id", j);
        httpMessage.addParam("live_id", j2);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    private boolean cjz() {
        return !ListUtils.isEmpty(MessageManager.getInstance().findMessage(1031030, getUniqueId()));
    }

    private void initTasks() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1031030, com.baidu.live.a.avJ + "ala/audio/updateLive");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(AlaUpdateLiveTbResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, String str, int i2, Object obj) {
        if (this.oxa != null) {
            this.oxa.a(i, str, i2, obj);
        }
    }

    public void cjr() {
        if (this.hKt != null) {
            this.hKt.dismiss();
            this.hKt = null;
        }
        String string = this.bkx.getString(a.h.ala_live_no_permission_tip);
        this.hKt = new BdAlertDialog(this.bkx.getPageActivity());
        this.hKt.setAutoNight(false);
        this.hKt.setMessage(string);
        this.hKt.setPositiveButton(this.bkx.getString(a.h.sdk_dialog_ok), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.k.d.3
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                d.this.b(bdAlertDialog);
            }
        });
        this.hKt.setCancelable(false);
        this.hKt.setCanceledOnTouchOutside(false);
        this.hKt.isShowTitleAndMessage();
        this.hKt.create(this.bkx);
        this.hKt.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(BdAlertDialog bdAlertDialog) {
        bdAlertDialog.dismiss();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913086));
        this.bkx.getPageActivity().finish();
        this.oxs = null;
        this.hKt = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ez(String str, String str2) {
        if (this.hKt != null) {
            this.hKt.dismiss();
            this.hKt = null;
        }
        String string = this.bkx.getString(a.h.ala_live_no_permission);
        this.hKt = new BdAlertDialog(this.bkx.getPageActivity());
        this.hKt.setAutoNight(false);
        if (StringUtils.isNull(str) || StringUtils.isNull(str2)) {
            str2 = string;
        } else {
            this.hKt.setTitle(str);
        }
        this.hKt.setMessage(str2);
        if (TbadkCoreApplication.getInst().isOther()) {
            this.hKt.setPositiveButton(this.bkx.getString(a.h.sdk_know), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.k.d.4
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    d.this.FA();
                }
            });
        } else {
            this.hKt.setPositiveButton(this.bkx.getString(a.h.dialog_to_appeal), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.k.d.5
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    if (TbadkCoreApplication.getInst().isTieba()) {
                        String str3 = com.baidu.live.ae.a.Qj().buX.aMs;
                        if (!TextUtils.isEmpty(str3)) {
                            BrowserHelper.startInternalWebActivity(d.this.bkx.getPageActivity(), str3);
                        }
                    } else {
                        IExtraParams buildParamsExtra = ExtraParamsManager.getInstance().buildParamsExtra();
                        if (buildParamsExtra != null) {
                            try {
                                HashMap hashMap = new HashMap();
                                hashMap.put(ExtraParamsManager.KEY_GO_FEED_BACK, "");
                                buildParamsExtra.process(hashMap);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    d.this.FA();
                }
            });
            this.hKt.setNegativeButton(this.bkx.getString(a.h.sdk_dialog_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.k.d.6
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    d.this.FA();
                }
            });
        }
        this.hKt.setCancelable(false);
        this.hKt.setCanceledOnTouchOutside(false);
        this.hKt.setTitleShowCenter(true);
        this.hKt.setMessageShowCenter(true);
        this.hKt.isShowTitleAndMessage();
        this.hKt.create(this.bkx);
        this.hKt.show();
    }

    public void cjq() {
        if (this.hKt != null) {
            this.hKt.dismiss();
            this.hKt = null;
        }
        String string = this.bkx.getString(a.h.ala_live_no_auth);
        this.hKt = new BdAlertDialog(this.bkx.getPageActivity());
        this.hKt.setAutoNight(false);
        this.hKt.setMessage(string);
        if (TbadkCoreApplication.getInst().isRegistedIntent(FaceRecognitionActivityConfig.class) && RealAuthenManager.getInstance().getRealAuthen() != null) {
            this.hKt.setPositiveButton(this.bkx.getString(a.h.dialog_to_auth), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.k.d.7
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    d.this.cjp();
                    d.this.FA();
                }
            });
            this.hKt.setNegativeButton(this.bkx.getString(a.h.sdk_dialog_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.k.d.8
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    d.this.FA();
                }
            });
        } else {
            this.hKt.setPositiveButton(this.bkx.getString(a.h.sdk_know), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.k.d.9
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    d.this.FA();
                }
            });
        }
        this.hKt.setCancelable(false);
        this.hKt.setCanceledOnTouchOutside(false);
        this.hKt.setTitleShowCenter(true);
        this.hKt.setMessageShowCenter(true);
        this.hKt.isShowTitleAndMessage();
        this.hKt.create(this.bkx);
        this.hKt.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cjp() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913222, new FaceRecognitionActivityConfig(this.bkx.getPageActivity(), "")));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FA() {
        if (this.hKt != null) {
            this.hKt.dismiss();
            this.hKt = null;
        }
        this.oxs = null;
    }
}
