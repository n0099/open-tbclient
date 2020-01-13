package com.baidu.tieba.livesdk;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.adp.base.i;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.f.e;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.ala.AlaCmdConfigSocket;
import com.baidu.ala.atomdata.AlaAdminListActivityConfig;
import com.baidu.ala.atomdata.AlaFansFamilyActivityConfig;
import com.baidu.ala.atomdata.AlaForbiddenListActivityConfig;
import com.baidu.ala.atomdata.AlaLoveFamilyActivityConfig;
import com.baidu.ala.atomdata.AlaPersonCenterExpActivityConfig;
import com.baidu.ala.atomdata.AlaPersonCenterRealAuthenConfig;
import com.baidu.ala.atomdata.AlaSDKShareEmptyActivityConfig;
import com.baidu.ala.liveroom.messages.ALAPushAlertResponsedMessage;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.tbadk.ISdkInitCallback;
import com.baidu.live.tbadk.core.atomdata.BuyTBeanActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import com.baidu.live.tbadk.scheme.SchemeCallback;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.AlaMasterLiveRoomActivityConfig;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.util.ag;
import com.baidu.tieba.im.c;
import com.baidu.tieba.livesdk.share.AlaSDKShareEmptyActivity;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class AlaLiveSdkStatic {
    private static CustomMessageListener ibi;

    static {
        cbJ();
        cbK();
        cbM();
        cbP();
        cbL();
        cbO();
        cbN();
        c.b(AlaCmdConfigSocket.ALA_SOCKET_PUSH_ALERT, ALAPushAlertResponsedMessage.class, false);
        TbadkCoreApplication.getInst().RegisterIntent(AlaSDKShareEmptyActivityConfig.class, AlaSDKShareEmptyActivity.class);
        com.baidu.tieba.sdk.a.a(new ISdkInitCallback() { // from class: com.baidu.tieba.livesdk.AlaLiveSdkStatic.1
            @Override // com.baidu.live.tbadk.ISdkInitCallback
            public void initSdk() {
                AlaLiveSdkStatic.checkInit();
            }
        });
        ibi = new CustomMessageListener(CmdConfigCustom.MAINTAB_ADD_FRAGMENT) { // from class: com.baidu.tieba.livesdk.AlaLiveSdkStatic.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.livesdk.AlaLiveSdkStatic.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AlaLiveSdkStatic.checkInit();
                        e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.livesdk.AlaLiveSdkStatic.2.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                AlaLiveSdkStatic.vh();
                            }
                        }, 1000L);
                    }
                }, 100L);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void vh() {
        String clipBoardContent = UtilHelper.getClipBoardContent();
        if (!StringUtils.isNull(clipBoardContent) && clipBoardContent.startsWith("#bdtiebalive://") && clipBoardContent.endsWith("#")) {
            String replace = clipBoardContent.replace("#", "");
            if (!AlaLiveRoomActivityConfig.isAlreadyEnterLiveRoom) {
                ba.aEt().b((TbPageContext) i.ab(TbadkCoreApplication.getInst().getCurrentActivity()), new String[]{replace});
            }
            UtilHelper.clearClipBoard();
        }
    }

    private static void cbJ() {
        e.gx().post(new Runnable() { // from class: com.baidu.tieba.livesdk.AlaLiveSdkStatic.3
            @Override // java.lang.Runnable
            public void run() {
                MessageManager.getInstance().registerListener(AlaLiveSdkStatic.ibi);
            }
        });
    }

    public static void cbK() {
        ba.aEt().a(new ba.a() { // from class: com.baidu.tieba.livesdk.AlaLiveSdkStatic.4
            @Override // com.baidu.tbadk.core.util.ba.a
            public int deal(TbPageContext<?> tbPageContext, String[] strArr) {
                Map<String, String> paramPair;
                if (strArr == null || strArr[0] == null) {
                    return 3;
                }
                String lowerCase = strArr[0].toLowerCase();
                if (lowerCase.startsWith("http://tieba.baidu.com/ala/share?") || lowerCase.startsWith("https://tieba.baidu.com/ala/share?") || lowerCase.startsWith("http://tieba.baidu.com/ala/share/live") || lowerCase.startsWith("https://tieba.baidu.com/ala/share/live")) {
                    String paramStr = ba.getParamStr(lowerCase);
                    if (!StringUtils.isNull(paramStr) && (paramPair = ba.getParamPair(paramStr)) != null) {
                        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                        alaLiveInfoCoreData.liveID = com.baidu.adp.lib.f.b.toLong(paramPair.get("liveid"), 0L);
                        alaLiveInfoCoreData.userName = paramPair.get(BdStatsConstant.StatsKey.UNAME);
                        if (alaLiveInfoCoreData.liveID != 0 || !TextUtils.isEmpty(alaLiveInfoCoreData.userName)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, null, null, false, null)));
                        }
                    }
                    return 1;
                }
                return 3;
            }
        });
    }

    public static void cbL() {
        ba.aEt().a(new ba.a() { // from class: com.baidu.tieba.livesdk.AlaLiveSdkStatic.5
            @Override // com.baidu.tbadk.core.util.ba.a
            public int deal(final TbPageContext<?> tbPageContext, String[] strArr) {
                if (strArr == null || strArr[0] == null) {
                    return 3;
                }
                if (strArr[0].startsWith("bdtiebalive://")) {
                    AlaLiveSdkStatic.checkInit();
                    if (com.baidu.tieba.sdk.a.cCD().checkScheme(strArr[0])) {
                        com.baidu.tieba.sdk.a.cCD().openScheme(tbPageContext.getPageActivity(), strArr[0], new SchemeCallback() { // from class: com.baidu.tieba.livesdk.AlaLiveSdkStatic.5.1
                            @Override // com.baidu.live.tbadk.scheme.SchemeCallback
                            public void doJsCallback(int i, String str, JSONObject jSONObject, String str2) {
                                AlaLiveSdkStatic.a(tbPageContext, i, str, jSONObject, str2);
                            }
                        });
                        return 0;
                    }
                    return 3;
                }
                return 3;
            }
        });
    }

    private static void cbM() {
        ba.aEt().a(new ba.a() { // from class: com.baidu.tieba.livesdk.AlaLiveSdkStatic.6
            @Override // com.baidu.tbadk.core.util.ba.a
            public int deal(TbPageContext<?> tbPageContext, String[] strArr) {
                Map<String, String> paramPair;
                if (tbPageContext == null || strArr == null || strArr.length == 0) {
                    return 3;
                }
                String str = strArr[0];
                if (StringUtils.isNull(str)) {
                    return 3;
                }
                if (str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_TB_CLIENT)) {
                    if (tbPageContext != null && (paramPair = ba.getParamPair(ba.getParamStrBehindScheme(str))) != null) {
                        String str2 = paramPair.get("liveid");
                        String str3 = paramPair.get(BdStatsConstant.StatsKey.UNAME);
                        String str4 = paramPair.get("rtmpurl");
                        if (StringUtils.isNull(str2) && StringUtils.isNull(str3)) {
                            return 3;
                        }
                        try {
                            String decode = !StringUtils.isNull(str3) ? URLDecoder.decode(str3, "UTF-8") : str3;
                            String str5 = !StringUtils.isNull(str4) ? str4 : "";
                            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                            alaLiveInfoCoreData.liveID = com.baidu.adp.lib.f.b.toLong(str2, 0L);
                            alaLiveInfoCoreData.userName = decode;
                            alaLiveInfoCoreData.rtmpUrl = str5;
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, "safari_play", null, false, null)));
                        } catch (UnsupportedEncodingException e) {
                            e.printStackTrace();
                        }
                        return 0;
                    }
                } else if (str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_JUMP_LIVE_ROOM)) {
                    long j = com.baidu.adp.lib.f.b.toLong(ag.getMatchStringFromURL(str, "liveId="), 0L);
                    if (j == 0) {
                        return 3;
                    }
                    AlaLiveInfoCoreData alaLiveInfoCoreData2 = new AlaLiveInfoCoreData();
                    alaLiveInfoCoreData2.liveID = j;
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData2, "active_view_jump_live_room", "", false, "")));
                    return 1;
                }
                return 3;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(TbPageContext tbPageContext, int i, String str, JSONObject jSONObject, String str2) {
        try {
            if (TextUtils.isEmpty(str2)) {
                str2 = BuyTBeanActivityConfig.CALLBACK;
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("status", i);
            jSONObject2.put("message", str);
            if (jSONObject != null) {
                jSONObject2.put("data", jSONObject);
            }
            StringBuilder append = new StringBuilder("javascript:").append(str2).append("('").append(jSONObject2.toString()).append("');");
            CustomMessage customMessage = new CustomMessage(2921434);
            customMessage.setTag(tbPageContext.getUniqueId());
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921434, append.toString());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void cbN() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2921431, new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.livesdk.AlaLiveSdkStatic.7
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
                return new CustomResponsedMessage<>(2921431);
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void checkInit() {
        try {
            if (!a.cbR().Dw()) {
                a.cbR().init(TbadkCoreApplication.getInst());
            }
        } catch (Throwable th) {
            BdLog.e(th);
        }
    }

    private static void cbO() {
        MessageManager.getInstance().addMessageRule(new com.baidu.adp.framework.a.b(CmdConfigCustom.START_GO_ACTION) { // from class: com.baidu.tieba.livesdk.AlaLiveSdkStatic.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.a.f
            /* renamed from: d */
            public CustomMessage<?> b(CustomMessage<?> customMessage, CustomMessageTask customMessageTask) {
                if (customMessage != null && (customMessage.getData() instanceof AlaLiveRoomActivityConfig)) {
                    AlaLiveSdkStatic.checkInit();
                    AlaLiveSdkStatic.a((AlaLiveRoomActivityConfig) customMessage.getData());
                    return null;
                } else if (customMessage != null && (customMessage.getData() instanceof AlaMasterLiveRoomActivityConfig)) {
                    AlaLiveSdkStatic.checkInit();
                    AlaLiveSdkStatic.a((AlaMasterLiveRoomActivityConfig) customMessage.getData());
                    return null;
                } else if (customMessage != null && (customMessage.getData() instanceof AlaAdminListActivityConfig)) {
                    AlaLiveSdkStatic.checkInit();
                    AlaLiveSdkStatic.a((AlaAdminListActivityConfig) customMessage.getData());
                    return null;
                } else if (customMessage != null && (customMessage.getData() instanceof AlaFansFamilyActivityConfig)) {
                    AlaLiveSdkStatic.checkInit();
                    AlaLiveSdkStatic.a((AlaFansFamilyActivityConfig) customMessage.getData());
                    return null;
                } else if (customMessage != null && (customMessage.getData() instanceof AlaForbiddenListActivityConfig)) {
                    AlaLiveSdkStatic.checkInit();
                    AlaLiveSdkStatic.a((AlaForbiddenListActivityConfig) customMessage.getData());
                    return null;
                } else if (customMessage != null && (customMessage.getData() instanceof AlaLoveFamilyActivityConfig)) {
                    AlaLiveSdkStatic.checkInit();
                    AlaLiveSdkStatic.a((AlaLoveFamilyActivityConfig) customMessage.getData());
                    return null;
                } else if (customMessage != null && (customMessage.getData() instanceof AlaPersonCenterExpActivityConfig)) {
                    AlaLiveSdkStatic.checkInit();
                    AlaLiveSdkStatic.a((AlaPersonCenterExpActivityConfig) customMessage.getData());
                    return null;
                } else if (customMessage != null && (customMessage.getData() instanceof AlaPersonCenterRealAuthenConfig)) {
                    AlaLiveSdkStatic.checkInit();
                    AlaLiveSdkStatic.a((AlaPersonCenterRealAuthenConfig) customMessage.getData());
                    return null;
                } else {
                    return customMessage;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(AlaAdminListActivityConfig alaAdminListActivityConfig) {
        if (alaAdminListActivityConfig != null && alaAdminListActivityConfig.getIntent() != null) {
            com.baidu.tieba.sdk.a.cCD().bh(alaAdminListActivityConfig.getContext(), alaAdminListActivityConfig.getIntent().getStringExtra(AlaAdminListActivityConfig.ALA_LIVE_CUR_LIVE_ID));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(AlaForbiddenListActivityConfig alaForbiddenListActivityConfig) {
        if (alaForbiddenListActivityConfig != null && alaForbiddenListActivityConfig.getIntent() != null) {
            alaForbiddenListActivityConfig.getIntent();
            com.baidu.tieba.sdk.a.cCD().bi(alaForbiddenListActivityConfig.getContext(), "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(AlaPersonCenterExpActivityConfig alaPersonCenterExpActivityConfig) {
        if (alaPersonCenterExpActivityConfig != null && alaPersonCenterExpActivityConfig.getIntent() != null) {
            Intent intent = alaPersonCenterExpActivityConfig.getIntent();
            com.baidu.tieba.sdk.a.cCD().a(alaPersonCenterExpActivityConfig.getContext(), intent.getLongExtra(AlaPersonCenterExpActivityConfig.CURRENT_EXP, 0L), intent.getIntExtra("current_level", 0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(AlaPersonCenterRealAuthenConfig alaPersonCenterRealAuthenConfig) {
        if (alaPersonCenterRealAuthenConfig != null && alaPersonCenterRealAuthenConfig.getIntent() != null) {
            Intent intent = alaPersonCenterRealAuthenConfig.getIntent();
            com.baidu.tieba.sdk.a.cCD().v(alaPersonCenterRealAuthenConfig.getContext(), intent.getStringExtra(AlaPersonCenterRealAuthenConfig.REAL_AUTHEN_USER_ID), intent.getStringExtra(AlaPersonCenterRealAuthenConfig.REAL_AUTHEN_CERTIFY_STATUS));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(AlaLoveFamilyActivityConfig alaLoveFamilyActivityConfig) {
        if (alaLoveFamilyActivityConfig != null && alaLoveFamilyActivityConfig.getIntent() != null) {
            alaLoveFamilyActivityConfig.getIntent();
            com.baidu.tieba.sdk.a.cCD().fq(alaLoveFamilyActivityConfig.getContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(AlaFansFamilyActivityConfig alaFansFamilyActivityConfig) {
        if (alaFansFamilyActivityConfig != null && alaFansFamilyActivityConfig.getIntent() != null) {
            com.baidu.tieba.sdk.a.cCD().bj(alaFansFamilyActivityConfig.getContext(), alaFansFamilyActivityConfig.getIntent().getStringExtra("author_live_user_id"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(AlaMasterLiveRoomActivityConfig alaMasterLiveRoomActivityConfig) {
        com.baidu.tieba.sdk.a.cCD().fp(alaMasterLiveRoomActivityConfig.getContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(AlaLiveRoomActivityConfig alaLiveRoomActivityConfig) {
        if (alaLiveRoomActivityConfig != null && alaLiveRoomActivityConfig.getIntent() != null) {
            Intent intent = alaLiveRoomActivityConfig.getIntent();
            String stringExtra = intent.getStringExtra("live_from_type");
            AlaLiveInfoCoreData alaLiveInfoCoreData = (AlaLiveInfoCoreData) intent.getSerializableExtra("live_info_core");
            if (alaLiveInfoCoreData != null) {
                long j = alaLiveInfoCoreData.liveID;
                String str = alaLiveInfoCoreData.userName;
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("from", stringExtra);
                    jSONObject.put("cover", alaLiveInfoCoreData.liveCover);
                    jSONObject.put("enterLiveId", j);
                    jSONObject.put("live_url", alaLiveInfoCoreData.rtmpUrl);
                    jSONObject.put("obj_source", alaLiveRoomActivityConfig.getIntent().getStringArrayListExtra("obj_source"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                if (j != 0) {
                    com.baidu.tieba.sdk.a.cCD().a(alaLiveRoomActivityConfig.getContext(), j, true, "0", jSONObject);
                } else {
                    com.baidu.tieba.sdk.a.cCD().b(alaLiveRoomActivityConfig.getContext(), str, true, "0", jSONObject);
                }
            }
        }
    }

    private static void cbP() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2921364, new CustomMessageTask.CustomRunnable<Context>() { // from class: com.baidu.tieba.livesdk.AlaLiveSdkStatic.9
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Context> customMessage) {
                if (customMessage == null || customMessage.getData() == null || customMessage.getCmd() != 2921364) {
                    return null;
                }
                try {
                    AlaLiveSdkStatic.checkInit();
                    return new CustomResponsedMessage<>(2921364, new com.baidu.tieba.livesdk.i.a(customMessage.getData()));
                } catch (Exception e) {
                    return null;
                }
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }
}
