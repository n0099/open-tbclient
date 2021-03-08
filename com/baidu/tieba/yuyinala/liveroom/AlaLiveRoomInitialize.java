package com.baidu.tieba.yuyinala.liveroom;

import com.baidu.ala.atomdata.AlaSDKShareEmptyActivityConfig;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.framework.task.CustomMessageTask;
import com.baidu.live.adp.framework.task.HttpMessageTask;
import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.adp.lib.safe.SafeHandler;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.audiolive.c;
import com.baidu.live.d;
import com.baidu.live.gift.ag;
import com.baidu.live.gift.ak;
import com.baidu.live.im.message.YuyinImBarragePayResponseMessage;
import com.baidu.live.message.AudioGetLiveActivityHttpResponseMessage;
import com.baidu.live.message.GetYuyinSuperCustomerInfoHttpResponseMessage;
import com.baidu.live.o.b;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.YuyinAlaLiveRoomActivityConfig;
import com.baidu.live.tbadk.core.dialog.BdAlertDialog;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.core.util.UrlManager;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.live.tbadk.util.WebviewHelper;
import com.baidu.tieba.yuyinala.liveroom.messages.AlaGetVerifyStrategyResponseHttpMessage;
import com.baidu.tieba.yuyinala.liveroom.messages.AlaMGetLiveStatusHttpResponseMessage;
import com.baidu.tieba.yuyinala.liveroom.messages.YuyinGetLiveInfoHttpResponseMessage;
import com.baidu.tieba.yuyinala.liveroom.share.AlaShareMsgCallHttpResonpnseMessage;
import com.baidu.tieba.yuyinala.liveroom.turntable.lucky.TurnTableLuckyMomentsResponseMessage;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes10.dex */
public class AlaLiveRoomInitialize {
    private static CustomMessageListener hqJ;
    private static CustomMessageListener hqK;
    private static CustomMessageListener hqM;
    private static CustomMessageListener hqO;
    private static HttpMessageListener oud;
    private static boolean hqE = false;
    private static boolean hqF = false;
    private static BdAlertDialog hqG = null;
    private static BdUniqueId gQz = BdUniqueId.gen();

    static {
        bZq();
        eaD();
        initTasks();
        bZr();
        bZH();
        bZI();
        hqJ = new CustomMessageListener(2913020) { // from class: com.baidu.tieba.yuyinala.liveroom.AlaLiveRoomInitialize.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            }
        };
        hqK = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.yuyinala.liveroom.AlaLiveRoomInitialize.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            }
        };
        hqM = new CustomMessageListener(CmdConfigCustom.CMD_LIVE_VIDEO_CLOSED_QUERY) { // from class: com.baidu.tieba.yuyinala.liveroom.AlaLiveRoomInitialize.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getOrginalMessage() instanceof com.baidu.live.tieba.a.a)) {
                    com.baidu.live.tieba.a.a aVar = (com.baidu.live.tieba.a.a) customResponsedMessage.getOrginalMessage();
                    List<Object> originData = aVar.getOriginData();
                    List<Long> ids = aVar.getIds();
                    if (!ListUtils.isEmpty(originData) && !ListUtils.isEmpty(ids)) {
                        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isLiveSwitchUnabled()) {
                            com.baidu.live.liveroom.messages.a aVar2 = new com.baidu.live.liveroom.messages.a();
                            aVar2.setOriginData(originData);
                            aVar2.setListIds(ids);
                            aVar2.setTag(AlaLiveRoomInitialize.gQz);
                            aVar2.setParams();
                            MessageManager.getInstance().sendMessageFromBackground(aVar);
                        }
                    }
                }
            }
        };
        oud = new HttpMessageListener(1031044) { // from class: com.baidu.tieba.yuyinala.liveroom.AlaLiveRoomInitialize.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getOrginalMessage().getTag() == AlaLiveRoomInitialize.gQz) {
                    List<Long> list = null;
                    if (httpResponsedMessage instanceof AlaMGetLiveStatusHttpResponseMessage) {
                        list = ((AlaMGetLiveStatusHttpResponseMessage) httpResponsedMessage).getClosedIds();
                    }
                    if (ListUtils.isEmpty(list)) {
                    }
                }
            }
        };
        hqO = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE_STICKY) { // from class: com.baidu.tieba.yuyinala.liveroom.AlaLiveRoomInitialize.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                boolean unused = AlaLiveRoomInitialize.hqE = true;
                SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.AlaLiveRoomInitialize.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        MessageManager.getInstance().unRegisterListener(AlaLiveRoomInitialize.hqO);
                    }
                });
            }
        };
    }

    private static void bZq() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1031002, com.baidu.live.a.axj + "ala/audio/live/getLiveActivity");
        tbHttpMessageTask.setResponsedClass(AudioGetLiveActivityHttpResponseMessage.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.GET);
        tbHttpMessageTask.setRetry(1);
        HashMap hashMap = new HashMap();
        hashMap.put("_client_version", TbConfig.getSubappVersionName());
        tbHttpMessageTask.setCommonParams(hashMap);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void initTasks() {
        bZs();
        bZt();
        bZv();
        if (TbadkCoreApplication.getInst().isMainProcess(true)) {
        }
        bZz();
        bZA();
        bZB();
        bZC();
        bZK();
    }

    private static void bZr() {
        if (TbadkCoreApplication.getInst().isMainProcess(true)) {
            MessageManager.getInstance().registerListener(hqJ);
            MessageManager.getInstance().registerListener(hqK);
            MessageManager.getInstance().registerListener(oud);
            MessageManager.getInstance().registerListener(hqM);
            MessageManager.getInstance().registerListener(hqO);
        }
    }

    private static void bZs() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1031024, com.baidu.live.a.axj + "ala/audio/getLiveInfo");
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(YuyinGetLiveInfoHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        tbHttpMessageTask.setRetry(1);
    }

    private static void bZt() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1031044, com.baidu.live.a.axj + "ala/audio/mgetLiveStatus");
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(AlaMGetLiveStatusHttpResponseMessage.class);
        tbHttpMessageTask.setRetry(1);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void bZv() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1031028, com.baidu.live.a.axj + "ala/audio/sys/strategy");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(AlaGetVerifyStrategyResponseHttpMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        MessageManager.getInstance().registerStickyMode(1031028);
    }

    private static void bZz() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1031062, TbConfig.SERVER_ADDRESS + "ala/live/sendNoticeIm");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        tbHttpMessageTask.setResponsedClass(JsonHttpResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        com.baidu.live.q.a.init();
    }

    private static void bZA() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1031078, TbConfig.SERVER_ADDRESS + "ala/share/shareMsg");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(AlaShareMsgCallHttpResonpnseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void bZB() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1031047, TbConfig.SERVER_HOST + "liveserver/pay/barrage");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        tbHttpMessageTask.setResponsedClass(YuyinImBarragePayResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void bZC() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1031063, TbConfig.SERVER_HOST + "liveserver/rotaryTable/getLuckyMomentsInfoForMobile");
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.GET);
        tbHttpMessageTask.setRetry(1);
        tbHttpMessageTask.setResponsedClass(TurnTableLuckyMomentsResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void bZH() {
        UrlManager.getInstance().addListener(new UrlManager.UrlDealListener() { // from class: com.baidu.tieba.yuyinala.liveroom.AlaLiveRoomInitialize.6
            @Override // com.baidu.live.tbadk.core.util.UrlManager.UrlDealListener
            public int deal(TbPageContext<?> tbPageContext, String[] strArr) {
                Map<String, String> paramPair;
                if (tbPageContext == null || strArr == null || strArr.length == 0) {
                    return 3;
                }
                String str = strArr[0];
                if (StringUtils.isNull(str)) {
                    return 3;
                }
                if (str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_TB_CLIENT_ZM)) {
                    long j = d.xf().getLong("zm_cert_id", 0L);
                    if (j != 0) {
                        b bVar = new b();
                        bVar.hv(Long.toString(j));
                        bVar.release();
                    }
                    d.xf().putLong("zm_cert_id", 0L);
                    return 0;
                }
                if (str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_TB_CLIENT)) {
                    if (tbPageContext != null && (paramPair = UrlManager.getParamPair(UrlManager.getParamStrBehindScheme(str))) != null) {
                        String str2 = paramPair.get(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID);
                        String str3 = paramPair.get(BdStatsConstant.StatsKey.UNAME);
                        String str4 = paramPair.get("rtmpurl");
                        if (StringUtils.isNull(str2)) {
                            if (!StringUtils.isNull(str3)) {
                                try {
                                    String decode = URLDecoder.decode(str3, "UTF-8");
                                    if (StringUtils.isNull(str4)) {
                                        str4 = "";
                                    }
                                    YuyinAlaLiveRoomActivityConfig yuyinAlaLiveRoomActivityConfig = new YuyinAlaLiveRoomActivityConfig(tbPageContext.getPageActivity());
                                    yuyinAlaLiveRoomActivityConfig.addExtraByUrl(str4, decode, "safari_play");
                                    MessageManager.getInstance().sendMessage(new CustomMessage(2501018, yuyinAlaLiveRoomActivityConfig));
                                    return 0;
                                } catch (UnsupportedEncodingException e) {
                                    e.printStackTrace();
                                    return 0;
                                }
                            }
                            tbPageContext.showToast(tbPageContext.getResources().getString(a.h.ala_entry_live_failed));
                            return 0;
                        }
                        Long valueOf = Long.valueOf(Long.parseLong(str2));
                        if (valueOf.longValue() <= 0) {
                            tbPageContext.showToast(tbPageContext.getResources().getString(a.h.yuyin_live_over_name));
                            return 0;
                        }
                        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                        alaLiveInfoCoreData.liveID = valueOf.longValue();
                        try {
                            if (!StringUtils.isNull(str4)) {
                                alaLiveInfoCoreData.rtmpUrl = URLDecoder.decode(str4, "UTF-8");
                            }
                        } catch (UnsupportedEncodingException e2) {
                            e2.printStackTrace();
                        }
                        if (!StringUtils.isNull(str3)) {
                            alaLiveInfoCoreData.userName = str3;
                        }
                        YuyinAlaLiveRoomActivityConfig yuyinAlaLiveRoomActivityConfig2 = new YuyinAlaLiveRoomActivityConfig(tbPageContext.getPageActivity());
                        yuyinAlaLiveRoomActivityConfig2.addExtraByScheme(alaLiveInfoCoreData, "safari_play", "", false, "");
                        MessageManager.getInstance().sendMessage(new CustomMessage(2501018, yuyinAlaLiveRoomActivityConfig2));
                        return 0;
                    }
                } else if (str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_LIVE_SHARE)) {
                    if (TbadkCoreApplication.isLogin()) {
                        TiebaInitialize.log("c12744");
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913062));
                    return 1;
                } else if (str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_JUMP_LIVE_ROOM)) {
                    long j2 = JavaTypesHelper.toLong(WebviewHelper.getMatchStringFromURL(str, "liveId="), 0L);
                    String matchStringFromURL = WebviewHelper.getMatchStringFromURL(str, "uname=");
                    if (j2 == 0) {
                        if (StringUtils.isNull(matchStringFromURL)) {
                            return 3;
                        }
                        YuyinAlaLiveRoomActivityConfig yuyinAlaLiveRoomActivityConfig3 = new YuyinAlaLiveRoomActivityConfig(tbPageContext.getPageActivity());
                        yuyinAlaLiveRoomActivityConfig3.addExtraByUrl("", matchStringFromURL, "active_view_jump_live_room");
                        MessageManager.getInstance().sendMessage(new CustomMessage(2501018, yuyinAlaLiveRoomActivityConfig3));
                        return 1;
                    }
                    YuyinAlaLiveRoomActivityConfig yuyinAlaLiveRoomActivityConfig4 = new YuyinAlaLiveRoomActivityConfig(tbPageContext.getPageActivity());
                    yuyinAlaLiveRoomActivityConfig4.addExtraByLiveId(j2, "", "active_view_jump_live_room");
                    MessageManager.getInstance().sendMessage(new CustomMessage(2501018, yuyinAlaLiveRoomActivityConfig4));
                    return 1;
                }
                return 3;
            }
        });
    }

    private static void bZI() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2501065, new CustomMessageTask.CustomRunnable<ak>() { // from class: com.baidu.tieba.yuyinala.liveroom.AlaLiveRoomInitialize.7
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<ag> run(CustomMessage<ak> customMessage) {
                return new CustomResponsedMessage<>(2501065, new com.baidu.tieba.yuyinala.liveroom.m.a(customMessage.getData()));
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void bZK() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1031064, TbConfig.SERVER_HOST + "liveserver/liveactivity/getsupercustomerinfo");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.GET);
        tbHttpMessageTask.setResponsedClass(GetYuyinSuperCustomerInfoHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void eaD() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2501056, new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.yuyinala.liveroom.AlaLiveRoomInitialize.8
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<c> run(CustomMessage<Object> customMessage) {
                return new CustomResponsedMessage<>(2501056, new com.baidu.tieba.yuyinala.player.a());
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }
}
