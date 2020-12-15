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
import com.baidu.live.data.aq;
import com.baidu.live.data.bm;
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
    private w aFN;
    private BdAlertDialog hyB;
    private HttpMessageListener hyJ;
    private HttpMessageListener hyT;
    private Handler hyl;
    private aq hyp;
    private int hyu;
    private BdPageContext<?> mPageContext;
    private a.InterfaceC0926a ooa;
    private AlaGetVerifyStrategyResponseHttpMessage ooq;

    public d(BdPageContext<?> bdPageContext) {
        super(bdPageContext);
        this.hyl = new Handler();
        this.hyu = 1;
        this.hyT = new HttpMessageListener(1031030) { // from class: com.baidu.tieba.yuyinala.liveroom.i.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaUpdateLiveTbResponseMessage) && httpResponsedMessage.getOrginalMessage().getTag() == d.this.unique_id) {
                    if (httpResponsedMessage.getError() != 0 || httpResponsedMessage.hasError()) {
                        UbcStatisticManager.getInstance().logSendResponse(new UbcStatisticItem("1534", "create_live", UbcStatConstant.Page.VOICE_CREATE_ROOM, null), httpResponsedMessage, true);
                    }
                    d.this.hyp = ((AlaUpdateLiveTbResponseMessage) httpResponsedMessage).cja();
                    if (d.this.hyp != null) {
                        if (d.this.hyp.mErrorCode == 0) {
                            JSONObject jSONObject = new JSONObject();
                            JSONObject jSONObject2 = new JSONObject();
                            try {
                                jSONObject2.put(LogConfig.VALUE_LIVE_HK_RECORD_START, d.this.hyp.aPf);
                                jSONObject2.put("user_verify", d.this.hyp.aPh);
                                jSONObject2.put("certify", d.this.hyp.aPj);
                                if (d.this.hyp.mLiveSdkInfo != null && d.this.hyp.mLiveSdkInfo.mCastIds != null) {
                                    jSONObject2.put(YuyinAlaLiveRoomActivityConfig.SDK_AUDIO_ROOM_CHAT_CAST_ID, d.this.hyp.mLiveSdkInfo.mCastIds.chatMCastId);
                                    jSONObject2.put("ensure_mcast_id", d.this.hyp.mLiveSdkInfo.mCastIds.ensureMCastId);
                                }
                                jSONObject.put("result", jSONObject2);
                            } catch (JSONException e) {
                                BdLog.e(e);
                            }
                            UbcStatisticManager.getInstance().logSendResponse(new UbcStatisticItem("1534", UbcStatConstant.ContentType.UBC_TYPE_CREATE_LIVE_SUCC, UbcStatConstant.Page.VOICE_CREATE_ROOM, null).setContentExt(jSONObject), httpResponsedMessage, true);
                        }
                        if (d.this.hyp.aPf != 1 || d.this.hyp.aPh != 1) {
                            d.this.hyl.postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.i.d.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    d.this.cjw();
                                }
                            }, 200L);
                            return;
                        } else if (d.this.hyp.mErrorCode != 0) {
                            if (d.this.hyp.mErrorCode == 220012) {
                                d.this.b(d.this.hyp.mErrorCode, d.this.hyp.mErrorMsg, 6, d.this.aFN);
                                return;
                            }
                        } else {
                            d.this.aFN = new w();
                            d.this.aFN.bz(true);
                            d.this.aFN.mLiveInfo = d.this.hyp.mLiveInfo;
                            d.this.aFN.isHost = true;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913081, d.this.aFN));
                        }
                    }
                    d.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 6, d.this.aFN);
                    if (d.this.aFN != null && d.this.aFN.mLiveInfo != null) {
                        d.this.t(d.this.aFN.mLiveInfo.user_id, d.this.aFN.mLiveInfo.live_id);
                    }
                }
            }
        };
        this.hyJ = new HttpMessageListener(1031028) { // from class: com.baidu.tieba.yuyinala.liveroom.i.d.2
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
                            jSONObject2.put(LogConfig.VALUE_LIVE_HK_RECORD_START, alaGetVerifyStrategyResponseHttpMessage.hxG);
                            jSONObject2.put("user_verify", alaGetVerifyStrategyResponseHttpMessage.hxI);
                            jSONObject2.put("certify", alaGetVerifyStrategyResponseHttpMessage.hxL);
                            jSONObject.put("result", jSONObject2);
                        } catch (JSONException e) {
                            BdLog.e(e);
                        }
                        UbcStatisticManager.getInstance().logSendResponse(new UbcStatisticItem("1534", UbcStatConstant.ContentType.UBC_TYPE_CREATE_STRATEGY_SUCC, UbcStatConstant.Page.VOICE_CREATE_ROOM, null).setContentExt(jSONObject), httpResponsedMessage, true);
                    }
                    if (httpResponsedMessage.getError() == 0) {
                        if (alaGetVerifyStrategyResponseHttpMessage.hxI != 1 || alaGetVerifyStrategyResponseHttpMessage.hxG != 1 || alaGetVerifyStrategyResponseHttpMessage.hxL != 1) {
                            d.this.ooq = alaGetVerifyStrategyResponseHttpMessage;
                            if (alaGetVerifyStrategyResponseHttpMessage.hxL != 1) {
                                d.this.hyl.postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.i.d.2.2
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        d.this.cjv();
                                    }
                                }, 200L);
                                return;
                            } else if (alaGetVerifyStrategyResponseHttpMessage.hxI != 1 || alaGetVerifyStrategyResponseHttpMessage.hxG != 1) {
                                d.this.hyl.postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.i.d.2.3
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        d.this.eC(alaGetVerifyStrategyResponseHttpMessage.hxO, alaGetVerifyStrategyResponseHttpMessage.hxP);
                                    }
                                }, 200L);
                                return;
                            } else {
                                return;
                            }
                        }
                        d.this.ooq = null;
                    }
                }
            }
        };
        this.mPageContext = bdPageContext;
        initTasks();
        registerListener(this.hyT);
        registerListener(this.hyJ);
    }

    public void a(a.InterfaceC0926a interfaceC0926a) {
        this.ooa = interfaceC0926a;
    }

    public void cjt() {
        MessageManager.getInstance().sendMessage(new HttpMessage(1031028));
        UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem("1526", UbcStatConstant.ContentType.UBC_TYPE_STRATEGY, UbcStatConstant.Page.VOICE_CREATE_ROOM, null));
    }

    public aq cjA() {
        return this.hyp;
    }

    public void b(String str, String str2, String str3, int i, double d, double d2, String str4, String str5, int i2, String str6, String str7, String str8, int i3, int i4, int i5, int i6, String str9, String str10) {
        if (!cjE()) {
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
            httpMessage.addParam("is_prettify", bm.b(com.baidu.live.ae.a.RB().bxq) ? 1 : 2);
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

    private boolean cjE() {
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
        if (this.ooa != null) {
            this.ooa.a(i, str, i2, obj);
        }
    }

    public void cjw() {
        if (this.hyB != null) {
            this.hyB.dismiss();
            this.hyB = null;
        }
        String string = this.mPageContext.getString(a.h.ala_live_no_permission_tip);
        this.hyB = new BdAlertDialog(this.mPageContext.getPageActivity());
        this.hyB.setAutoNight(false);
        this.hyB.setMessage(string);
        this.hyB.setPositiveButton(this.mPageContext.getString(a.h.sdk_dialog_ok), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.i.d.3
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                d.this.b(bdAlertDialog);
            }
        });
        this.hyB.setCancelable(false);
        this.hyB.setCanceledOnTouchOutside(false);
        this.hyB.isShowTitleAndMessage();
        this.hyB.create(this.mPageContext);
        this.hyB.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(BdAlertDialog bdAlertDialog) {
        bdAlertDialog.dismiss();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913086));
        this.mPageContext.getPageActivity().finish();
        this.ooq = null;
        this.hyB = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eC(String str, String str2) {
        if (this.hyB != null) {
            this.hyB.dismiss();
            this.hyB = null;
        }
        String string = this.mPageContext.getString(a.h.ala_live_no_permission);
        this.hyB = new BdAlertDialog(this.mPageContext.getPageActivity());
        this.hyB.setAutoNight(false);
        if (StringUtils.isNull(str) || StringUtils.isNull(str2)) {
            str2 = string;
        } else {
            this.hyB.setTitle(str);
        }
        this.hyB.setMessage(str2);
        if (TbadkCoreApplication.getInst().isOther()) {
            this.hyB.setPositiveButton(this.mPageContext.getString(a.h.sdk_know), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.i.d.4
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    d.this.ID();
                }
            });
        } else {
            this.hyB.setPositiveButton(this.mPageContext.getString(a.h.dialog_to_appeal), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.i.d.5
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    if (TbadkCoreApplication.getInst().isTieba()) {
                        String str3 = com.baidu.live.ae.a.RB().brA.aNR;
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
                    d.this.ID();
                }
            });
            this.hyB.setNegativeButton(this.mPageContext.getString(a.h.sdk_dialog_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.i.d.6
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    d.this.ID();
                }
            });
        }
        this.hyB.setCancelable(false);
        this.hyB.setCanceledOnTouchOutside(false);
        this.hyB.setTitleShowCenter(true);
        this.hyB.setMessageShowCenter(true);
        this.hyB.isShowTitleAndMessage();
        this.hyB.create(this.mPageContext);
        this.hyB.show();
    }

    public void cjv() {
        if (this.hyB != null) {
            this.hyB.dismiss();
            this.hyB = null;
        }
        String string = this.mPageContext.getString(a.h.ala_live_no_auth);
        this.hyB = new BdAlertDialog(this.mPageContext.getPageActivity());
        this.hyB.setAutoNight(false);
        this.hyB.setMessage(string);
        if (TbadkCoreApplication.getInst().isRegistedIntent(FaceRecognitionActivityConfig.class) && RealAuthenManager.getInstance().getRealAuthen() != null) {
            this.hyB.setPositiveButton(this.mPageContext.getString(a.h.dialog_to_auth), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.i.d.7
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    d.this.cju();
                    d.this.ID();
                }
            });
            this.hyB.setNegativeButton(this.mPageContext.getString(a.h.sdk_dialog_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.i.d.8
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    d.this.ID();
                }
            });
        } else {
            this.hyB.setPositiveButton(this.mPageContext.getString(a.h.sdk_know), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.i.d.9
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    d.this.ID();
                }
            });
        }
        this.hyB.setCancelable(false);
        this.hyB.setCanceledOnTouchOutside(false);
        this.hyB.setTitleShowCenter(true);
        this.hyB.setMessageShowCenter(true);
        this.hyB.isShowTitleAndMessage();
        this.hyB.create(this.mPageContext);
        this.hyB.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cju() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913222, new FaceRecognitionActivityConfig(this.mPageContext.getPageActivity(), "")));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ID() {
        if (this.hyB != null) {
            this.hyB.dismiss();
            this.hyB = null;
        }
        this.ooq = null;
    }
}
