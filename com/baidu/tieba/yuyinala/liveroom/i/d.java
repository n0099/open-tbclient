package com.baidu.tieba.yuyinala.liveroom.i;

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
import com.baidu.live.data.ap;
import com.baidu.live.data.bl;
import com.baidu.live.data.w;
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
import com.baidu.tieba.yuyinala.liveroom.i.a;
import com.baidu.tieba.yuyinala.liveroom.messages.AlaGetVerifyStrategyResponseHttpMessage;
import com.baidu.tieba.yuyinala.liveroom.messages.AlaUpdateLiveTbResponseMessage;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class d extends BdBaseModel {
    private w aES;
    private Handler hoY;
    private HttpMessageListener hpG;
    private ap hpc;
    private int hph;
    private BdAlertDialog hpo;
    private HttpMessageListener hpw;
    private BdPageContext<?> mPageContext;
    private AlaGetVerifyStrategyResponseHttpMessage nXL;
    private a.InterfaceC0906a nXv;

    public d(BdPageContext<?> bdPageContext) {
        super(bdPageContext);
        this.hoY = new Handler();
        this.hph = 1;
        this.hpG = new HttpMessageListener(1031030) { // from class: com.baidu.tieba.yuyinala.liveroom.i.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaUpdateLiveTbResponseMessage) && httpResponsedMessage.getOrginalMessage().getTag() == d.this.unique_id) {
                    if (httpResponsedMessage.getError() != 0 || httpResponsedMessage.hasError()) {
                        UbcStatisticManager.getInstance().logSendResponse(new UbcStatisticItem("1534", "create_live", UbcStatConstant.Page.VOICE_CREATE_ROOM, null), httpResponsedMessage, true);
                    }
                    d.this.hpc = ((AlaUpdateLiveTbResponseMessage) httpResponsedMessage).cfM();
                    if (d.this.hpc != null) {
                        if (d.this.hpc.mErrorCode == 0) {
                            JSONObject jSONObject = new JSONObject();
                            JSONObject jSONObject2 = new JSONObject();
                            try {
                                jSONObject2.put(LogConfig.VALUE_LIVE_HK_RECORD_START, d.this.hpc.aNT);
                                jSONObject2.put("user_verify", d.this.hpc.aNV);
                                jSONObject2.put("certify", d.this.hpc.aNX);
                                if (d.this.hpc.mLiveSdkInfo != null && d.this.hpc.mLiveSdkInfo.mCastIds != null) {
                                    jSONObject2.put(YuyinAlaLiveRoomActivityConfig.SDK_AUDIO_ROOM_CHAT_CAST_ID, d.this.hpc.mLiveSdkInfo.mCastIds.chatMCastId);
                                    jSONObject2.put("ensure_mcast_id", d.this.hpc.mLiveSdkInfo.mCastIds.ensureMCastId);
                                }
                                jSONObject.put("result", jSONObject2);
                            } catch (JSONException e) {
                                BdLog.e(e);
                            }
                            UbcStatisticManager.getInstance().logSendResponse(new UbcStatisticItem("1534", UbcStatConstant.ContentType.UBC_TYPE_CREATE_LIVE_SUCC, UbcStatConstant.Page.VOICE_CREATE_ROOM, null).setContentExt(jSONObject), httpResponsedMessage, true);
                        }
                        if (d.this.hpc.aNT != 1 || d.this.hpc.aNV != 1) {
                            d.this.hoY.postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.i.d.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    d.this.cgi();
                                }
                            }, 200L);
                            return;
                        } else if (d.this.hpc.mErrorCode != 0) {
                            if (d.this.hpc.mErrorCode == 220012) {
                                d.this.b(d.this.hpc.mErrorCode, d.this.hpc.mErrorMsg, 6, d.this.aES);
                                return;
                            }
                        } else {
                            d.this.aES = new w();
                            d.this.aES.bp(true);
                            d.this.aES.mLiveInfo = d.this.hpc.mLiveInfo;
                            d.this.aES.isHost = true;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913081, d.this.aES));
                        }
                    }
                    d.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 6, d.this.aES);
                    if (d.this.aES != null && d.this.aES.mLiveInfo != null) {
                        d.this.t(d.this.aES.mLiveInfo.user_id, d.this.aES.mLiveInfo.live_id);
                    }
                }
            }
        };
        this.hpw = new HttpMessageListener(1031028) { // from class: com.baidu.tieba.yuyinala.liveroom.i.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof AlaGetVerifyStrategyResponseHttpMessage) {
                    SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.i.d.2.1
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
                            jSONObject2.put(LogConfig.VALUE_LIVE_HK_RECORD_START, alaGetVerifyStrategyResponseHttpMessage.hot);
                            jSONObject2.put("user_verify", alaGetVerifyStrategyResponseHttpMessage.hov);
                            jSONObject2.put("certify", alaGetVerifyStrategyResponseHttpMessage.hoy);
                            jSONObject.put("result", jSONObject2);
                        } catch (JSONException e) {
                            BdLog.e(e);
                        }
                        UbcStatisticManager.getInstance().logSendResponse(new UbcStatisticItem("1534", UbcStatConstant.ContentType.UBC_TYPE_CREATE_STRATEGY_SUCC, UbcStatConstant.Page.VOICE_CREATE_ROOM, null).setContentExt(jSONObject), httpResponsedMessage, true);
                    }
                    if (httpResponsedMessage.getError() == 0) {
                        if (alaGetVerifyStrategyResponseHttpMessage.hov != 1 || alaGetVerifyStrategyResponseHttpMessage.hot != 1 || alaGetVerifyStrategyResponseHttpMessage.hoy != 1) {
                            d.this.nXL = alaGetVerifyStrategyResponseHttpMessage;
                            if (alaGetVerifyStrategyResponseHttpMessage.hoy != 1) {
                                d.this.hoY.postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.i.d.2.2
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        d.this.cgh();
                                    }
                                }, 200L);
                                return;
                            } else if (alaGetVerifyStrategyResponseHttpMessage.hov != 1 || alaGetVerifyStrategyResponseHttpMessage.hot != 1) {
                                d.this.hoY.postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.i.d.2.3
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        d.this.ex(alaGetVerifyStrategyResponseHttpMessage.hoB, alaGetVerifyStrategyResponseHttpMessage.hoC);
                                    }
                                }, 200L);
                                return;
                            } else {
                                return;
                            }
                        }
                        d.this.nXL = null;
                    }
                }
            }
        };
        this.mPageContext = bdPageContext;
        initTasks();
        registerListener(this.hpG);
        registerListener(this.hpw);
    }

    public void a(a.InterfaceC0906a interfaceC0906a) {
        this.nXv = interfaceC0906a;
    }

    public void cgf() {
        MessageManager.getInstance().sendMessage(new HttpMessage(1031028));
        UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem("1526", UbcStatConstant.ContentType.UBC_TYPE_STRATEGY, UbcStatConstant.Page.VOICE_CREATE_ROOM, null));
    }

    public ap cgm() {
        return this.hpc;
    }

    public void b(String str, String str2, String str3, int i, double d, double d2, String str4, String str5, int i2, String str6, String str7, String str8, int i3, int i4, int i5, int i6, String str9, String str10) {
        if (!cgq()) {
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
            httpMessage.addParam("is_prettify", bl.b(com.baidu.live.aa.a.PQ().btT) ? 1 : 2);
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
    public void t(long j, long j2) {
        HttpMessage httpMessage = new HttpMessage(1031071);
        httpMessage.addParam("user_id", j);
        httpMessage.addParam("live_id", j2);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    private boolean cgq() {
        return !ListUtils.isEmpty(MessageManager.getInstance().findMessage(1031030, getUniqueId()));
    }

    private void initTasks() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1031030, TbConfig.SERVER_ADDRESS + "ala/audio/updateLive");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(AlaUpdateLiveTbResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, String str, int i2, Object obj) {
        if (this.nXv != null) {
            this.nXv.a(i, str, i2, obj);
        }
    }

    public void cgi() {
        if (this.hpo != null) {
            this.hpo.dismiss();
            this.hpo = null;
        }
        String string = this.mPageContext.getString(a.h.ala_live_no_permission_tip);
        this.hpo = new BdAlertDialog(this.mPageContext.getPageActivity());
        this.hpo.setAutoNight(false);
        this.hpo.setMessage(string);
        this.hpo.setPositiveButton(this.mPageContext.getString(a.h.sdk_dialog_ok), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.i.d.3
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                d.this.b(bdAlertDialog);
            }
        });
        this.hpo.setCancelable(false);
        this.hpo.setCanceledOnTouchOutside(false);
        this.hpo.isShowTitleAndMessage();
        this.hpo.create(this.mPageContext);
        this.hpo.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(BdAlertDialog bdAlertDialog) {
        bdAlertDialog.dismiss();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913086));
        this.mPageContext.getPageActivity().finish();
        this.nXL = null;
        this.hpo = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ex(String str, String str2) {
        if (this.hpo != null) {
            this.hpo.dismiss();
            this.hpo = null;
        }
        String string = this.mPageContext.getString(a.h.ala_live_no_permission);
        this.hpo = new BdAlertDialog(this.mPageContext.getPageActivity());
        this.hpo.setAutoNight(false);
        if (StringUtils.isNull(str) || StringUtils.isNull(str2)) {
            str2 = string;
        } else {
            this.hpo.setTitle(str);
        }
        this.hpo.setMessage(str2);
        if (TbadkCoreApplication.getInst().isOther()) {
            this.hpo.setPositiveButton(this.mPageContext.getString(a.h.sdk_know), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.i.d.4
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    d.this.Hv();
                }
            });
        } else {
            this.hpo.setPositiveButton(this.mPageContext.getString(a.h.dialog_to_appeal), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.i.d.5
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    if (TbadkCoreApplication.getInst().isTieba()) {
                        String str3 = com.baidu.live.aa.a.PQ().bod.aMH;
                        if (!TextUtils.isEmpty(str3)) {
                            BrowserHelper.startInternalWebActivity(d.this.mPageContext.getPageActivity(), str3);
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
                    d.this.Hv();
                }
            });
            this.hpo.setNegativeButton(this.mPageContext.getString(a.h.sdk_dialog_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.i.d.6
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    d.this.Hv();
                }
            });
        }
        this.hpo.setCancelable(false);
        this.hpo.setCanceledOnTouchOutside(false);
        this.hpo.setTitleShowCenter(true);
        this.hpo.setMessageShowCenter(true);
        this.hpo.isShowTitleAndMessage();
        this.hpo.create(this.mPageContext);
        this.hpo.show();
    }

    public void cgh() {
        if (this.hpo != null) {
            this.hpo.dismiss();
            this.hpo = null;
        }
        String string = this.mPageContext.getString(a.h.ala_live_no_auth);
        this.hpo = new BdAlertDialog(this.mPageContext.getPageActivity());
        this.hpo.setAutoNight(false);
        this.hpo.setMessage(string);
        if (TbadkCoreApplication.getInst().isRegistedIntent(FaceRecognitionActivityConfig.class) && RealAuthenManager.getInstance().getRealAuthen() != null) {
            this.hpo.setPositiveButton(this.mPageContext.getString(a.h.dialog_to_auth), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.i.d.7
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    d.this.cgg();
                    d.this.Hv();
                }
            });
            this.hpo.setNegativeButton(this.mPageContext.getString(a.h.sdk_dialog_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.i.d.8
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    d.this.Hv();
                }
            });
        } else {
            this.hpo.setPositiveButton(this.mPageContext.getString(a.h.sdk_know), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.i.d.9
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    d.this.Hv();
                }
            });
        }
        this.hpo.setCancelable(false);
        this.hpo.setCanceledOnTouchOutside(false);
        this.hpo.setTitleShowCenter(true);
        this.hpo.setMessageShowCenter(true);
        this.hpo.isShowTitleAndMessage();
        this.hpo.create(this.mPageContext);
        this.hpo.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgg() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913222, new FaceRecognitionActivityConfig(this.mPageContext.getPageActivity(), "")));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hv() {
        if (this.hpo != null) {
            this.hpo.dismiss();
            this.hpo = null;
        }
        this.nXL = null;
    }
}
