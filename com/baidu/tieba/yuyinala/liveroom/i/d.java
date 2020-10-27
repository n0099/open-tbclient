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
import com.baidu.live.data.ao;
import com.baidu.live.data.bk;
import com.baidu.live.data.w;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.browser.BrowserHelper;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.FaceRecognitionActivityConfig;
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
    private w aEc;
    private HttpMessageListener hjF;
    private HttpMessageListener hjP;
    private Handler hjh;
    private ao hjl;
    private int hjq;
    private BdAlertDialog hjx;
    private BdPageContext<?> mPageContext;
    private AlaGetVerifyStrategyResponseHttpMessage nQB;
    private a.InterfaceC0890a nQm;

    public d(BdPageContext<?> bdPageContext) {
        super(bdPageContext);
        this.hjh = new Handler();
        this.hjq = 1;
        this.hjP = new HttpMessageListener(1031030) { // from class: com.baidu.tieba.yuyinala.liveroom.i.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaUpdateLiveTbResponseMessage) && httpResponsedMessage.getOrginalMessage().getTag() == d.this.unique_id) {
                    if (httpResponsedMessage.getError() != 0 || httpResponsedMessage.hasError()) {
                        UbcStatisticManager.getInstance().logSendResponse(new UbcStatisticItem("1534", "create_live", UbcStatConstant.Page.VOICE_CREATE_ROOM, null), httpResponsedMessage, true);
                    }
                    d.this.hjl = ((AlaUpdateLiveTbResponseMessage) httpResponsedMessage).cdl();
                    if (d.this.hjl != null) {
                        if (d.this.hjl.mErrorCode == 0) {
                            JSONObject jSONObject = new JSONObject();
                            JSONObject jSONObject2 = new JSONObject();
                            try {
                                jSONObject2.put(LogConfig.VALUE_LIVE_HK_RECORD_START, d.this.hjl.aMR);
                                jSONObject2.put("user_verify", d.this.hjl.aMT);
                                jSONObject2.put("certify", d.this.hjl.aMV);
                                if (d.this.hjl.mLiveSdkInfo != null && d.this.hjl.mLiveSdkInfo.mCastIds != null) {
                                    jSONObject2.put("chat_mcast_id", d.this.hjl.mLiveSdkInfo.mCastIds.chatMCastId);
                                    jSONObject2.put("ensure_mcast_id", d.this.hjl.mLiveSdkInfo.mCastIds.ensureMCastId);
                                }
                                jSONObject.put("result", jSONObject2);
                            } catch (JSONException e) {
                                BdLog.e(e);
                            }
                            UbcStatisticManager.getInstance().logSendResponse(new UbcStatisticItem("1534", UbcStatConstant.ContentType.UBC_TYPE_CREATE_LIVE_SUCC, UbcStatConstant.Page.VOICE_CREATE_ROOM, null).setContentExt(jSONObject), httpResponsedMessage, true);
                        }
                        if (d.this.hjl.aMR != 1 || d.this.hjl.aMT != 1) {
                            d.this.hjh.postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.i.d.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    d.this.cdH();
                                }
                            }, 200L);
                            return;
                        } else if (d.this.hjl.mErrorCode != 0) {
                            if (d.this.hjl.mErrorCode == 220012) {
                                d.this.b(d.this.hjl.mErrorCode, d.this.hjl.mErrorMsg, 6, d.this.aEc);
                                return;
                            }
                        } else {
                            d.this.aEc = new w();
                            d.this.aEc.bo(true);
                            d.this.aEc.mLiveInfo = d.this.hjl.mLiveInfo;
                            d.this.aEc.isHost = true;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913081, d.this.aEc));
                        }
                    }
                    d.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 6, d.this.aEc);
                    if (d.this.aEc != null && d.this.aEc.mLiveInfo != null) {
                        d.this.s(d.this.aEc.mLiveInfo.user_id, d.this.aEc.mLiveInfo.live_id);
                    }
                }
            }
        };
        this.hjF = new HttpMessageListener(1031028) { // from class: com.baidu.tieba.yuyinala.liveroom.i.d.2
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
                            jSONObject2.put(LogConfig.VALUE_LIVE_HK_RECORD_START, alaGetVerifyStrategyResponseHttpMessage.hiC);
                            jSONObject2.put("user_verify", alaGetVerifyStrategyResponseHttpMessage.hiE);
                            jSONObject2.put("certify", alaGetVerifyStrategyResponseHttpMessage.hiH);
                            jSONObject.put("result", jSONObject2);
                        } catch (JSONException e) {
                            BdLog.e(e);
                        }
                        UbcStatisticManager.getInstance().logSendResponse(new UbcStatisticItem("1534", UbcStatConstant.ContentType.UBC_TYPE_CREATE_STRATEGY_SUCC, UbcStatConstant.Page.VOICE_CREATE_ROOM, null).setContentExt(jSONObject), httpResponsedMessage, true);
                    }
                    if (httpResponsedMessage.getError() == 0) {
                        if (alaGetVerifyStrategyResponseHttpMessage.hiE != 1 || alaGetVerifyStrategyResponseHttpMessage.hiC != 1 || alaGetVerifyStrategyResponseHttpMessage.hiH != 1) {
                            d.this.nQB = alaGetVerifyStrategyResponseHttpMessage;
                            if (alaGetVerifyStrategyResponseHttpMessage.hiH != 1) {
                                d.this.hjh.postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.i.d.2.2
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        d.this.cdG();
                                    }
                                }, 200L);
                                return;
                            } else if (alaGetVerifyStrategyResponseHttpMessage.hiE != 1 || alaGetVerifyStrategyResponseHttpMessage.hiC != 1) {
                                d.this.hjh.postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.i.d.2.3
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        d.this.ex(alaGetVerifyStrategyResponseHttpMessage.hiK, alaGetVerifyStrategyResponseHttpMessage.hiL);
                                    }
                                }, 200L);
                                return;
                            } else {
                                return;
                            }
                        }
                        d.this.nQB = null;
                    }
                }
            }
        };
        this.mPageContext = bdPageContext;
        initTasks();
        registerListener(this.hjP);
        registerListener(this.hjF);
    }

    public void a(a.InterfaceC0890a interfaceC0890a) {
        this.nQm = interfaceC0890a;
    }

    public void cdE() {
        MessageManager.getInstance().sendMessage(new HttpMessage(1031028));
        UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem("1526", UbcStatConstant.ContentType.UBC_TYPE_STRATEGY, UbcStatConstant.Page.VOICE_CREATE_ROOM, null));
    }

    public ao cdL() {
        return this.hjl;
    }

    public void b(String str, String str2, String str3, int i, double d, double d2, String str4, String str5, int i2, String str6, String str7, String str8, int i3, int i4, int i5, int i6, String str9, String str10) {
        if (!cdP()) {
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
            httpMessage.addParam("is_prettify", bk.b(com.baidu.live.z.a.Pq().bsy) ? 1 : 2);
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
    public void s(long j, long j2) {
        HttpMessage httpMessage = new HttpMessage(1031071);
        httpMessage.addParam("user_id", j);
        httpMessage.addParam("live_id", j2);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    private boolean cdP() {
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
        if (this.nQm != null) {
            this.nQm.a(i, str, i2, obj);
        }
    }

    public void cdH() {
        if (this.hjx != null) {
            this.hjx.dismiss();
            this.hjx = null;
        }
        String string = this.mPageContext.getString(a.i.ala_live_no_permission_tip);
        this.hjx = new BdAlertDialog(this.mPageContext.getPageActivity());
        this.hjx.setAutoNight(false);
        this.hjx.setMessage(string);
        this.hjx.setPositiveButton(this.mPageContext.getString(a.i.sdk_dialog_ok), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.i.d.3
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                d.this.b(bdAlertDialog);
            }
        });
        this.hjx.setCancelable(false);
        this.hjx.setCanceledOnTouchOutside(false);
        this.hjx.isShowTitleAndMessage();
        this.hjx.create(this.mPageContext);
        this.hjx.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(BdAlertDialog bdAlertDialog) {
        bdAlertDialog.dismiss();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913086));
        this.mPageContext.getPageActivity().finish();
        this.nQB = null;
        this.hjx = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ex(String str, String str2) {
        if (this.hjx != null) {
            this.hjx.dismiss();
            this.hjx = null;
        }
        String string = this.mPageContext.getString(a.i.ala_live_no_permission);
        this.hjx = new BdAlertDialog(this.mPageContext.getPageActivity());
        this.hjx.setAutoNight(false);
        if (StringUtils.isNull(str) || StringUtils.isNull(str2)) {
            str2 = string;
        } else {
            this.hjx.setTitle(str);
        }
        this.hjx.setMessage(str2);
        if (TbadkCoreApplication.getInst().isOther()) {
            this.hjx.setPositiveButton(this.mPageContext.getString(a.i.sdk_know), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.i.d.4
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    d.this.GU();
                }
            });
        } else {
            this.hjx.setPositiveButton(this.mPageContext.getString(a.i.dialog_to_appeal), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.i.d.5
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    if (TbadkCoreApplication.getInst().isTieba()) {
                        String str3 = com.baidu.live.z.a.Pq().bmJ.aLH;
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
                    d.this.GU();
                }
            });
            this.hjx.setNegativeButton(this.mPageContext.getString(a.i.sdk_dialog_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.i.d.6
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    d.this.GU();
                }
            });
        }
        this.hjx.setCancelable(false);
        this.hjx.setCanceledOnTouchOutside(false);
        this.hjx.setTitleShowCenter(true);
        this.hjx.setMessageShowCenter(true);
        this.hjx.isShowTitleAndMessage();
        this.hjx.create(this.mPageContext);
        this.hjx.show();
    }

    public void cdG() {
        if (this.hjx != null) {
            this.hjx.dismiss();
            this.hjx = null;
        }
        String string = this.mPageContext.getString(a.i.ala_live_no_auth);
        this.hjx = new BdAlertDialog(this.mPageContext.getPageActivity());
        this.hjx.setAutoNight(false);
        this.hjx.setMessage(string);
        if (TbadkCoreApplication.getInst().isRegistedIntent(FaceRecognitionActivityConfig.class) && RealAuthenManager.getInstance().getRealAuthen() != null) {
            this.hjx.setPositiveButton(this.mPageContext.getString(a.i.dialog_to_auth), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.i.d.7
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    d.this.cdF();
                    d.this.GU();
                }
            });
            this.hjx.setNegativeButton(this.mPageContext.getString(a.i.sdk_dialog_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.i.d.8
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    d.this.GU();
                }
            });
        } else {
            this.hjx.setPositiveButton(this.mPageContext.getString(a.i.sdk_know), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.i.d.9
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    d.this.GU();
                }
            });
        }
        this.hjx.setCancelable(false);
        this.hjx.setCanceledOnTouchOutside(false);
        this.hjx.setTitleShowCenter(true);
        this.hjx.setMessageShowCenter(true);
        this.hjx.isShowTitleAndMessage();
        this.hjx.create(this.mPageContext);
        this.hjx.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cdF() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913222, new FaceRecognitionActivityConfig(this.mPageContext.getPageActivity(), "")));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GU() {
        if (this.hjx != null) {
            this.hjx.dismiss();
            this.hjx = null;
        }
        this.nQB = null;
    }
}
