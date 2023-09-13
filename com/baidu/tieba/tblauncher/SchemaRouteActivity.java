package com.baidu.tieba.tblauncher;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import androidx.annotation.Nullable;
import com.baidu.adp.base.BdActivityStack;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.log.DefaultLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.prologue.business.data.BaseVM;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.launch.stats.SpeedStatsManager;
import com.baidu.searchbox.launch.stats.SpeedStatsStampTable;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.BdToken.BdUniDispatchSchemeController;
import com.baidu.tbadk.GrowthStatsUtil;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.browser.BrowserHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaTabFeedActivityConfig;
import com.baidu.tbadk.core.atomData.ForumRulesShowActivityConfig;
import com.baidu.tbadk.core.atomData.ForumSquareActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.atomData.HotUserRankActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.LogoActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.atomData.SignAllForumActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.atomData.VideoMiddlePageActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.atomData.VideoRecommentPlayActivityConfig;
import com.baidu.tbadk.core.dialog.yun.YunDialogManager;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.growthFunnel.GrowthFunnelHelper;
import com.baidu.tbadk.core.log.ActivityLog;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.NewUrlSchemaHelper;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.core.util.UrlSchemaJumpHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.util.schemeaction.SchemeActionHelper;
import com.baidu.tbadk.core.util.schemeaction.SchemeActionManager;
import com.baidu.tbadk.module.frs.FrsService;
import com.baidu.tbadk.util.WebviewHelper;
import com.baidu.tieba.a8a;
import com.baidu.tieba.du4;
import com.baidu.tieba.e85;
import com.baidu.tieba.le5;
import com.baidu.tieba.mw5;
import com.baidu.tieba.nt4;
import com.baidu.tieba.nx5;
import com.baidu.tieba.p19;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.rp5;
import com.baidu.tieba.s1a;
import com.baidu.tieba.tbadkCore.data.FlutterOpenData;
import com.baidu.tieba.tblauncher.dispatcher.EnterForumDispatcher;
import com.baidu.tieba.tblauncher.dispatcher.MessageCenterDispatcher;
import com.baidu.tieba.um5;
import com.baidu.tieba.util.TopicListUtil;
import com.baidu.tieba.video.UserItemData;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class SchemaRouteActivity extends BaseActivity {
    public static /* synthetic */ Interceptable $ic;
    public static String b;
    public transient /* synthetic */ FieldHolder $fh;
    public final BdUniDispatchSchemeController.OnSchemeParsedCallback a;

    /* JADX WARN: Removed duplicated region for block: B:124:0x03e3 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:125:0x03e4  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x03fb  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x04d0  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0537  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0541  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x05a8  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x061a  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0625  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x06b0  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0703  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x074c  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x075b  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x0767  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x0772  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x077d  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x0788  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x0793  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x079e  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x07a9  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x07ad  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x07cc  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x07e3  */
    /* JADX WARN: Removed duplicated region for block: B:297:0x09aa  */
    /* JADX WARN: Removed duplicated region for block: B:312:0x0645 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:324:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:326:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void o1(Intent intent) {
        String str;
        String str2;
        Uri parse;
        String str3;
        int i;
        String str4;
        JSONObject jSONObject;
        LoginActivityConfig loginActivityConfig;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, intent) == null) || intent == null) {
            return;
        }
        GrowthFunnelHelper.updateAppStartInfo(intent.getDataString(), false);
        q1(intent.getData());
        s1(intent.getData());
        String dataString = intent.getDataString();
        ActivityLog.getInstance().i("SchemaRouteActivity", "开始处理scheme：" + dataString);
        UtilHelper.clearClipBoardBySchemaParam(dataString);
        du4.e(intent.getData());
        du4.c(intent.getData());
        GrowthStatsUtil.statisticChannel(GrowthStatsUtil.SPLASH_SOURCE.THIRD_PARTY, dataString);
        a8a.d().a(intent.getData());
        if (TextUtils.isEmpty(dataString)) {
            return;
        }
        if (e85.a().d()) {
            e85.a().i(1);
        }
        if (SchemeActionHelper.isTieBaAppSchemeHeader(dataString)) {
            nt4.w().M(true);
            if (!BdActivityStack.getInst().isActivityExist("MainTabActivity")) {
                if (p1(dataString)) {
                    UrlManager.getInstance().dealOneLink(getPageContext(), new String[]{dataString}, true);
                    return;
                }
                b = dataString;
                sendMessage(new CustomMessage(2002001, new LogoActivityConfig(getActivity())));
                return;
            }
            SchemeActionManager.getInstance().doSchemeAction(getPageContext(), dataString);
        } else if (!dataString.contains("tbfrs") && !dataString.contains("unidispatch/frs")) {
            if (!dataString.contains("tbpb") && !dataString.contains(PbModel.UNIDISPATCH_PB)) {
                if (dataString.contains("tbwebview")) {
                    Uri data = intent.getData();
                    if (BdUniDispatchSchemeController.isUniScheme(data)) {
                        BdUniDispatchSchemeController.getInstance().parseWebViewScheme(dataString, data, this.a);
                    } else {
                        BrowserHelper.startWebActivity(getActivity(), data);
                    }
                    nt4.w().M(true);
                    return;
                } else if (!dataString.contains("tbtopicdetail") && !dataString.contains("unidispatch/topicdetail")) {
                    if (!dataString.contains("tbusercenter") && !dataString.contains("unidispatch/usercenter") && !dataString.contains("usercenter")) {
                        if (dataString.contains(UrlSchemaHelper.FROM_FORUM_SQUARE)) {
                            ForumSquareActivityConfig forumSquareActivityConfig = new ForumSquareActivityConfig(getActivity());
                            forumSquareActivityConfig.setUri(intent.getData());
                            sendMessage(new CustomMessage(2002001, forumSquareActivityConfig));
                            nt4.w().M(true);
                            return;
                        } else if (dataString.contains("unidispatch/hotuserrank")) {
                            HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(getActivity());
                            hotUserRankActivityConfig.setUri(intent.getData());
                            sendMessage(new CustomMessage(2002001, hotUserRankActivityConfig));
                            nt4.w().M(true);
                            return;
                        } else if (dataString.contains("unidispatch/openapp") || dataString.contains("donothing")) {
                            if (!BdActivityStack.getInst().isActivityExist("MainTabActivity")) {
                                sendMessage(new CustomMessage(2002001, new LogoActivityConfig(getActivity())));
                            }
                            nt4.w().M(true);
                            return;
                        } else {
                            if (dataString.contains(BdUniDispatchSchemeController.HOST + BdUniDispatchSchemeController.PATH_CHUSHOU_ALA_ROOM)) {
                                Uri parse2 = Uri.parse(dataString);
                                String queryParameter = parse2.getQueryParameter(BdUniDispatchSchemeController.PARAM_CHUSHOU_THIRD_LIVE_TYPE);
                                String queryParameter2 = parse2.getQueryParameter(BdUniDispatchSchemeController.PARAM_CHUSHOU_ROOM_ID);
                                UrlManager.getInstance().dealOneLink(getPageContext(), new String[]{"tiebachushou://liveroom?roomid=" + queryParameter2 + "&livetype=" + queryParameter});
                                nt4.w().M(true);
                                return;
                            }
                            if (dataString.contains(BdUniDispatchSchemeController.HOST + BdUniDispatchSchemeController.PATH_TIEBA_YY_ROOM)) {
                                String queryParameter3 = Uri.parse(dataString).getQueryParameter(BdUniDispatchSchemeController.PARAM_YY_URL);
                                if (queryParameter3 != null) {
                                    UrlManager.getInstance().dealOneLink(getPageContext(), new String[]{new String(Base64.decode(queryParameter3.getBytes(), 2))});
                                    nt4.w().M(true);
                                    return;
                                }
                                return;
                            } else if (dataString.contains(BdUniDispatchSchemeController.PATH_TIEBA_BAR_FRIEND)) {
                                UrlManager.getInstance().dealOneLink(getPageContext(), new String[]{BdUtilHelper.urlAddParam(dataString, "from=key_from_live_close_link")});
                                nt4.w().M(true);
                                return;
                            } else if (dataString.contains(BdUniDispatchSchemeController.PATH_BDP_LIVE_CHANNEL)) {
                                AlaTabFeedActivityConfig alaTabFeedActivityConfig = new AlaTabFeedActivityConfig(this);
                                alaTabFeedActivityConfig.setPageSource(le5.d(dataString));
                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, alaTabFeedActivityConfig));
                                return;
                            } else if (dataString.contains("unidispatch/onekeysign")) {
                                if (TbadkCoreApplication.isLogin()) {
                                    SignAllForumActivityConfig signAllForumActivityConfig = new SignAllForumActivityConfig(getPageContext().getPageActivity());
                                    signAllForumActivityConfig.setUri(intent.getData());
                                    sendMessage(new CustomMessage(2002001, signAllForumActivityConfig));
                                } else {
                                    sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(this).createNormalCfg(1)));
                                }
                                nt4.w().M(true);
                                return;
                            } else if (dataString.startsWith(UrlSchemaHelper.SCHEMA_LIVE_MY_CONCERN_LIST)) {
                                MainTabActivityConfig mainTabActivityConfig = new MainTabActivityConfig(this);
                                mainTabActivityConfig.setTargetScheme(dataString);
                                MessageManager.getInstance().sendMessage(new CustomMessage(2015002, mainTabActivityConfig));
                                return;
                            } else {
                                if (dataString.contains("unidispatch/forumRuleDetail")) {
                                    ForumRulesShowActivityConfig forumRulesShowActivityConfig = new ForumRulesShowActivityConfig(this, Uri.parse(dataString).getQueryParameter(BdUniDispatchSchemeController.PARAM_FORUM_ID), ForumRulesShowActivityConfig.FORUM_RULE_H5_FROM_SHOW);
                                    forumRulesShowActivityConfig.setRequestCode(25070);
                                    sendMessage(new CustomMessage(2002001, forumRulesShowActivityConfig));
                                }
                                if (dataString.contains("/categorylist")) {
                                    Uri parse3 = Uri.parse(dataString);
                                    String queryParameter4 = parse3.getQueryParameter(BdUniDispatchSchemeController.PARAM_ITEM_ID_CAMEL);
                                    String queryParameter5 = parse3.getQueryParameter(BdUniDispatchSchemeController.PARAM_TAB_ID_CAMEL);
                                    String queryParameter6 = parse3.getQueryParameter(BdUniDispatchSchemeController.PARAM_SORT_TYPE_CAMEL);
                                    String queryParameter7 = parse3.getQueryParameter(BdUniDispatchSchemeController.PARAM_RANK_TYPE_CAMEL);
                                    String queryParameter8 = parse3.getQueryParameter(BdUniDispatchSchemeController.PARAM_RANK_CODE_CAMEL);
                                    String queryParameter9 = parse3.getQueryParameter(BdUniDispatchSchemeController.PARAM_HOME_TAB_NAME_CAMEL);
                                    HashMap hashMap = new HashMap();
                                    hashMap.put("item_id", queryParameter4);
                                    hashMap.put("tab_id", queryParameter5);
                                    hashMap.put("sort_type", queryParameter6);
                                    hashMap.put("rank_type", queryParameter7);
                                    hashMap.put("rank_code", queryParameter8);
                                    hashMap.put("home_tab_name", queryParameter9);
                                    sendMessage(new CustomMessage(2002015, new FlutterOpenData(this, "ItemRecommendList", hashMap)));
                                }
                                if (!TextUtils.isEmpty(dataString) && dataString.startsWith("com.baidu.tieba://unidispatch/router/portal")) {
                                    String queryParameter10 = Uri.parse(dataString).getQueryParameter(BdUniDispatchSchemeController.PARAM_CHAT_ROOM_ID_CAMEL);
                                    if (queryParameter10 != null) {
                                        try {
                                            JSONObject jSONObject2 = new JSONObject(queryParameter10);
                                            str4 = jSONObject2.optString("page");
                                            try {
                                                jSONObject = jSONObject2.optJSONObject(YunDialogManager.PAGE_PARAMS_KEY);
                                            } catch (JSONException e) {
                                                e = e;
                                                e.printStackTrace();
                                                jSONObject = null;
                                                if ("im/groupChat".equals(str4)) {
                                                    long optLong = jSONObject.optLong("roomId");
                                                    String optString = jSONObject.optString(IntentConfig.BACK_SCHEME);
                                                    loginActivityConfig = new LoginActivityConfig(getApplicationContext(), true);
                                                    loginActivityConfig.setJumpToAfterDestroy(2);
                                                    loginActivityConfig.setBackScheme(dataString);
                                                    if (ViewHelper.checkUpIsLoginFromH5(loginActivityConfig)) {
                                                    }
                                                }
                                                if (dataString.contains("/itemDetailsPage")) {
                                                }
                                                if (dataString.contains("unidispatch/item")) {
                                                    String queryParameter11 = Uri.parse(dataString).getQueryParameter(BdUniDispatchSchemeController.PARAM_ITEM_ID);
                                                    HashMap hashMap2 = new HashMap();
                                                    hashMap2.put("itemID", String.valueOf(queryParameter11));
                                                    sendMessage(new CustomMessage(2002015, new FlutterOpenData(this, "GameItemDetailsPage", hashMap2)));
                                                }
                                                if (dataString.contains("unidispatch/login_page_test")) {
                                                    sendMessage(new CustomMessage(2002001, new LoginActivityConfig(this)));
                                                }
                                                if (dataString.contains("unidispatch/video_middle_page_qa")) {
                                                }
                                                if (dataString.contains("unidispatch/video_middle_light_page_qa")) {
                                                }
                                                if (dataString.contains("unidispatch/video_middle_vertical_page_qa")) {
                                                }
                                                if (dataString.startsWith("tiebaclient://passlogin")) {
                                                }
                                                if (dataString.contains("unidispatch/voiceRoom")) {
                                                }
                                                if (dataString.contains("unidispatch/searchResultPage")) {
                                                }
                                                if (dataString.contains("unidispatch/videoTopicPage")) {
                                                }
                                                if (dataString.contains(UrlSchemaHelper.SCHEMA_TYPE_HOT_TOPIC_RANK_LIST)) {
                                                }
                                                if (dataString.startsWith(UrlSchemaHelper.SCHEMA_GAME_PLAY_PERSON_CHAT)) {
                                                }
                                                if (dataString.startsWith(UrlSchemaHelper.SCHEMA_GAME_PLAY_ALBUM)) {
                                                }
                                                if (dataString.startsWith(UrlSchemaHelper.SCHEMA_GAME_PLAY_SKILL_DETAIL)) {
                                                }
                                                if (dataString.startsWith("com.baidu.tieba://unidispatch/GameGodsDetailPage")) {
                                                }
                                                if (dataString.startsWith(UrlSchemaHelper.SCHEMA_GAME_PLAY_ORDER_PAGE)) {
                                                }
                                                if (dataString.startsWith(UrlSchemaHelper.SCHEMA_GAME_PLAY_MAIN_PAGE)) {
                                                }
                                                if (dataString.startsWith(UrlSchemaHelper.SCHEMA_GAME_PLAY_DISPATCH_PAGE)) {
                                                }
                                                if (!dataString.startsWith(UrlSchemaHelper.SCHEMA_GAME_PLAY_UNPAID_PAGE)) {
                                                }
                                                if (dataString.contains(UrlSchemaHelper.SCHEMA_YY_NATIVE_PAY_PANNEL)) {
                                                }
                                                if (TextUtils.isEmpty(dataString)) {
                                                }
                                            }
                                        } catch (JSONException e2) {
                                            e = e2;
                                            str4 = null;
                                        }
                                    } else {
                                        jSONObject = null;
                                        str4 = null;
                                    }
                                    if ("im/groupChat".equals(str4) && jSONObject != null) {
                                        long optLong2 = jSONObject.optLong("roomId");
                                        String optString2 = jSONObject.optString(IntentConfig.BACK_SCHEME);
                                        loginActivityConfig = new LoginActivityConfig(getApplicationContext(), true);
                                        loginActivityConfig.setJumpToAfterDestroy(2);
                                        loginActivityConfig.setBackScheme(dataString);
                                        if (ViewHelper.checkUpIsLoginFromH5(loginActivityConfig)) {
                                            return;
                                        }
                                        rp5.a().a(getActivity(), optLong2, -1, optString2);
                                        return;
                                    }
                                }
                                if (dataString.contains("/itemDetailsPage")) {
                                    Uri parse4 = Uri.parse(dataString);
                                    String queryParameter12 = parse4.getQueryParameter(BdUniDispatchSchemeController.PARAM_FORUM_NAME);
                                    if (!StringUtils.isNull(queryParameter12)) {
                                        v1(dataString);
                                        String str5 = "com.baidu.tieba://unidispatch/itemDetailsPage?name=" + queryParameter12 + "&from=" + FrsActivityConfig.FRS_FROM_ITEM;
                                        FrsActivityConfig frsActivityConfig = new FrsActivityConfig(getActivity());
                                        frsActivityConfig.setUri(Uri.parse(str5));
                                        sendMessage(new CustomMessage(2003000, frsActivityConfig));
                                        nt4.w().M(true);
                                    } else {
                                        String queryParameter13 = parse4.getQueryParameter(BdUniDispatchSchemeController.PARAM_ITEM_ID_CAMEL);
                                        HashMap hashMap3 = new HashMap();
                                        hashMap3.put("itemID", String.valueOf(queryParameter13));
                                        sendMessage(new CustomMessage(2002015, new FlutterOpenData(this, "GameItemDetailsPage", hashMap3)));
                                    }
                                }
                                if (dataString.contains("unidispatch/item") && !dataString.contains("/itemDetailsPage")) {
                                    String queryParameter112 = Uri.parse(dataString).getQueryParameter(BdUniDispatchSchemeController.PARAM_ITEM_ID);
                                    HashMap hashMap22 = new HashMap();
                                    hashMap22.put("itemID", String.valueOf(queryParameter112));
                                    sendMessage(new CustomMessage(2002015, new FlutterOpenData(this, "GameItemDetailsPage", hashMap22)));
                                }
                                if (dataString.contains("unidispatch/login_page_test") && !TbadkCoreApplication.isLogin()) {
                                    sendMessage(new CustomMessage(2002001, new LoginActivityConfig(this)));
                                }
                                if (dataString.contains("unidispatch/video_middle_page_qa")) {
                                    str3 = "video_url";
                                } else {
                                    Uri parse5 = Uri.parse(dataString);
                                    String queryParameter14 = parse5.getQueryParameter(BdUniDispatchSchemeController.PARAM_TID);
                                    String queryParameter15 = parse5.getQueryParameter(BdUniDispatchSchemeController.PARAM_FORUM_ID);
                                    String queryParameter16 = parse5.getQueryParameter("title");
                                    parse5.getQueryParameter(NativeUnifiedADAppInfoImpl.Keys.AUTHOR_NAME);
                                    parse5.getQueryParameter("author_nick_name");
                                    parse5.getQueryParameter("author_is_god");
                                    parse5.getQueryParameter("author_is_bigv");
                                    parse5.getQueryParameter("author_portrait");
                                    String queryParameter17 = parse5.getQueryParameter("video_thumbnail_url");
                                    String queryParameter18 = parse5.getQueryParameter("video_url");
                                    ArrayList arrayList = new ArrayList();
                                    str3 = "video_url";
                                    VideoItemData videoItemData = new VideoItemData();
                                    videoItemData.thread_id = queryParameter14;
                                    videoItemData.forum_id = queryParameter15;
                                    videoItemData.title = queryParameter16;
                                    videoItemData.thumbnail_url = queryParameter17;
                                    videoItemData.video_url = queryParameter18;
                                    arrayList.add(videoItemData);
                                    VideoPlayActivityConfig videoPlayActivityConfig = new VideoPlayActivityConfig(this, arrayList, "from_nani_video", VideoMiddlePageActivityConfig.FROM_SCHEME_QA);
                                    videoPlayActivityConfig.setUri(intent.getData());
                                    videoPlayActivityConfig.setUri(intent.getData());
                                    sendMessage(new CustomMessage(2002001, videoPlayActivityConfig));
                                }
                                if (dataString.contains("unidispatch/video_middle_light_page_qa")) {
                                    Uri parse6 = Uri.parse(dataString);
                                    String queryParameter19 = parse6.getQueryParameter(BdUniDispatchSchemeController.PARAM_TID);
                                    String queryParameter20 = parse6.getQueryParameter(BdUniDispatchSchemeController.PARAM_FORUM_ID);
                                    String queryParameter21 = parse6.getQueryParameter("title");
                                    parse6.getQueryParameter(NativeUnifiedADAppInfoImpl.Keys.AUTHOR_NAME);
                                    parse6.getQueryParameter("author_nick_name");
                                    parse6.getQueryParameter("author_is_god");
                                    parse6.getQueryParameter("author_is_bigv");
                                    parse6.getQueryParameter("author_portrait");
                                    String queryParameter22 = parse6.getQueryParameter("video_thumbnail_url");
                                    String queryParameter23 = parse6.getQueryParameter(str3);
                                    ArrayList arrayList2 = new ArrayList();
                                    VideoItemData videoItemData2 = new VideoItemData();
                                    videoItemData2.thread_id = queryParameter19;
                                    videoItemData2.forum_id = queryParameter20;
                                    videoItemData2.title = queryParameter21;
                                    videoItemData2.thumbnail_url = queryParameter22;
                                    videoItemData2.video_url = queryParameter23;
                                    arrayList2.add(videoItemData2);
                                    VideoPlayActivityConfig videoPlayActivityConfig2 = new VideoPlayActivityConfig(this, arrayList2, "from_nani_video", VideoMiddlePageActivityConfig.FROM_SCHEME_QA);
                                    videoPlayActivityConfig2.setUri(intent.getData());
                                    sendMessage(new CustomMessage(2002001, videoPlayActivityConfig2));
                                }
                                if (dataString.contains("unidispatch/video_middle_vertical_page_qa")) {
                                    i = 2002001;
                                } else {
                                    Uri parse7 = Uri.parse(dataString);
                                    String queryParameter24 = parse7.getQueryParameter(BdUniDispatchSchemeController.PARAM_TID);
                                    String queryParameter25 = parse7.getQueryParameter(BdUniDispatchSchemeController.PARAM_FORUM_ID);
                                    String queryParameter26 = parse7.getQueryParameter("title");
                                    String queryParameter27 = parse7.getQueryParameter("author_uid");
                                    String queryParameter28 = parse7.getQueryParameter(NativeUnifiedADAppInfoImpl.Keys.AUTHOR_NAME);
                                    String queryParameter29 = parse7.getQueryParameter("author_nick_name");
                                    String queryParameter30 = parse7.getQueryParameter("author_portrait");
                                    String queryParameter31 = parse7.getQueryParameter("video_thumbnail_url");
                                    String queryParameter32 = parse7.getQueryParameter(str3);
                                    ArrayList arrayList3 = new ArrayList();
                                    VideoItemData videoItemData3 = new VideoItemData();
                                    videoItemData3.thread_id = queryParameter24;
                                    videoItemData3.forum_id = queryParameter25;
                                    videoItemData3.title = queryParameter26;
                                    UserItemData userItemData = new UserItemData();
                                    userItemData.user_id = queryParameter27;
                                    userItemData.user_name = queryParameter28;
                                    userItemData.name_show = queryParameter29;
                                    userItemData.portrait = queryParameter30;
                                    videoItemData3.author_info = userItemData;
                                    videoItemData3.thumbnail_url = queryParameter31;
                                    videoItemData3.video_url = queryParameter32;
                                    arrayList3.add(videoItemData3);
                                    VideoPlayActivityConfig videoPlayActivityConfig3 = new VideoPlayActivityConfig(this, arrayList3, "from_nani_video", VideoMiddlePageActivityConfig.FROM_SCHEME_QA);
                                    videoPlayActivityConfig3.setParamIsVertail(true);
                                    videoPlayActivityConfig3.setUri(intent.getData());
                                    i = 2002001;
                                    sendMessage(new CustomMessage(2002001, videoPlayActivityConfig3));
                                }
                                if (dataString.startsWith("tiebaclient://passlogin")) {
                                    LoginActivityConfig loginActivityConfig2 = new LoginActivityConfig(this);
                                    loginActivityConfig2.setAutoLogin(dataString);
                                    sendMessage(new CustomMessage(i, loginActivityConfig2));
                                    nt4.w().M(true);
                                }
                                if (dataString.contains("unidispatch/voiceRoom")) {
                                    try {
                                        Uri parse8 = Uri.parse(dataString);
                                        HashMap hashMap4 = new HashMap();
                                        for (String str6 : parse8.getQueryParameterNames()) {
                                            hashMap4.put(str6, parse8.getQueryParameter(str6));
                                        }
                                        if (hashMap4.containsKey("room_id")) {
                                            ((FrsService) ServiceManager.getService(FrsService.Companion.getServiceReference())).navToVoiceRoom(TbadkCoreApplication.getInst().getCurrentPageContext(this), JavaTypesHelper.toLong((String) hashMap4.get("room_id"), 0L), hashMap4);
                                        }
                                    } catch (Exception unused) {
                                        if (BdBaseApplication.getInst().isDebugMode()) {
                                            BdLog.e("Yuyinfang schema parse exception");
                                        }
                                    }
                                }
                                if (dataString.contains("unidispatch/searchResultPage")) {
                                    String queryParameter33 = Uri.parse(dataString).getQueryParameter(BdUniDispatchSchemeController.PARAM_QUERY);
                                    IntentConfig intentConfig = new IntentConfig(this);
                                    if (!StringUtils.isNull(queryParameter33)) {
                                        intentConfig.getIntent().putExtra(IntentConfig.SEARCH_PAGE_QUERY_CONTENT_KEY, queryParameter33);
                                        MessageManager.getInstance().sendMessage(new CustomMessage(2015003, intentConfig));
                                    } else {
                                        sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
                                    }
                                }
                                if (dataString.contains("unidispatch/videoTopicPage")) {
                                    Uri parse9 = Uri.parse(dataString);
                                    String queryParameter34 = parse9.getQueryParameter("topic_id");
                                    String queryParameter35 = parse9.getQueryParameter("topic_name");
                                    String queryParameter36 = parse9.getQueryParameter("is_video_topic");
                                    if (!TextUtils.isEmpty(queryParameter34)) {
                                        if (StringHelper.equals(queryParameter36, "1")) {
                                            new HotTopicActivityConfig(getPageContext().getPageActivity()).createNormalConfig(queryParameter34, queryParameter35, queryParameter36, null).start();
                                        } else {
                                            nx5.f(getPageContext(), queryParameter34, queryParameter35);
                                        }
                                    }
                                }
                                if (dataString.contains(UrlSchemaHelper.SCHEMA_TYPE_HOT_TOPIC_RANK_LIST)) {
                                    TopicListUtil.openWebTopicListPage(getPageContext());
                                }
                                if (dataString.startsWith(UrlSchemaHelper.SCHEMA_GAME_PLAY_PERSON_CHAT)) {
                                    s1a.e(this, dataString, true);
                                }
                                if (dataString.startsWith(UrlSchemaHelper.SCHEMA_GAME_PLAY_ALBUM)) {
                                    s1a.a(this, dataString);
                                }
                                if (dataString.startsWith(UrlSchemaHelper.SCHEMA_GAME_PLAY_SKILL_DETAIL)) {
                                    s1a.d(this, dataString);
                                }
                                if (dataString.startsWith("com.baidu.tieba://unidispatch/GameGodsDetailPage")) {
                                    s1a.b(this, dataString);
                                }
                                if (dataString.startsWith(UrlSchemaHelper.SCHEMA_GAME_PLAY_ORDER_PAGE)) {
                                    s1a.c(this, dataString);
                                }
                                if (dataString.startsWith(UrlSchemaHelper.SCHEMA_GAME_PLAY_MAIN_PAGE)) {
                                    UrlSchemaJumpHelper.jumpGamePlayPage(this, dataString);
                                }
                                if (dataString.startsWith(UrlSchemaHelper.SCHEMA_GAME_PLAY_DISPATCH_PAGE)) {
                                    UrlSchemaJumpHelper.jumpDispatchOrderPage(this, dataString);
                                }
                                if (!dataString.startsWith(UrlSchemaHelper.SCHEMA_GAME_PLAY_UNPAID_PAGE)) {
                                    UrlSchemaJumpHelper.jumpUnPaidOrderPage(this, dataString);
                                } else if (dataString.startsWith(UrlSchemaHelper.SCHEMA_MESSAGE_CENTER_PAGE)) {
                                    UrlSchemaJumpHelper.jumpMessageCenterPage(this, dataString);
                                } else if (dataString.startsWith(UrlSchemaHelper.SCHEMA_GAME_PLAY_UNPAID_LIST_PAGE)) {
                                    UrlSchemaJumpHelper.jumpUnPaidListPage(this, dataString);
                                }
                                if (dataString.contains(UrlSchemaHelper.SCHEMA_YY_NATIVE_PAY_PANNEL)) {
                                    UrlManager.getInstance().dealOneLink(getPageContext(), new String[]{dataString});
                                }
                                if (TextUtils.isEmpty(dataString)) {
                                    if (dataString.contains(UrlSchemaHelper.SCHEMA_GAME_RECOMMENT_PAGE) || dataString.contains(NewUrlSchemaHelper.Jump.JUMP_TO_VIDEO_SQUARE) || dataString.contains(UrlSchemaHelper.SCHEMA_TYPE_TB_CLIENT) || dataString.contains(UrlSchemaHelper.SCHEMA_LIVE_SDK) || dataString.contains(UrlSchemaHelper.SCHEMA_CHUSHOU_LIVE_SDK) || dataString.contains(UrlSchemaHelper.SCHEMA_TYPE_TB_CLIENT_ZM) || dataString.contains(UrlSchemaHelper.SCHEMA_TYPE_TB_LAUNCH) || dataString.contains("com.baidu.tieba://unidispatch/homepage") || dataString.contains("com.baidu.tieba://unidispatch/activitypage") || dataString.contains("com.baidu.tieba://unidispatch/minePage") || dataString.contains(MessageCenterDispatcher.url) || dataString.contains(EnterForumDispatcher.url) || dataString.contains("com.baidu.tieba://unidispatch/recommendforum") || dataString.contains("com.baidu.tieba://deeplink") || dataString.contains("com.baidu.tieba://unidispatch/videotab") || dataString.contains(UrlSchemaHelper.SCHEMA_TYPE_HOMEPAGE_ANYTAB)) {
                                        p19.G(dataString);
                                        MessageManager.getInstance().sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(TbadkCoreApplication.getInst()).createUriCfg(intent.getData())));
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                        }
                    }
                    PersonPolymericActivityConfig personPolymericActivityConfig = new PersonPolymericActivityConfig(getActivity());
                    personPolymericActivityConfig.setUri(intent.getData());
                    sendMessage(new CustomMessage(2002001, personPolymericActivityConfig));
                    nt4.w().M(true);
                    return;
                } else {
                    nx5.f(getPageContext(), WebviewHelper.getMatchStringFromURL(dataString, "topic_id="), null);
                    nt4.w().M(true);
                    return;
                }
            }
            try {
                parse = Uri.parse(dataString);
            } catch (Exception e3) {
                e = e3;
                str = null;
            }
            if (parse != null) {
                str = parse.getQueryParameter("thread_id");
                try {
                    if (TextUtils.isEmpty(str)) {
                        str2 = parse.getQueryParameter("tid");
                    }
                } catch (Exception e4) {
                    e = e4;
                    if (!TbadkCoreApplication.getInst().isDebugMode()) {
                        DefaultLog.getInstance().e("SchemaRouteActivity", "通用路由解析tid异常 " + e.getMessage());
                        str2 = str;
                        if ("tbpb://tieba.baidu.com".equals(dataString)) {
                        }
                        if (BdActivityStack.getInst().isActivityExist("MainTabActivity")) {
                        }
                    } else {
                        throw new IllegalStateException("通用路由解析tid异常");
                    }
                }
                str2 = str;
            } else {
                str2 = null;
            }
            if ("tbpb://tieba.baidu.com".equals(dataString) && !TextUtils.isEmpty(str2)) {
                String queryParameter37 = intent.getData().getQueryParameter("obj_param1");
                if (!BdUniDispatchSchemeController.PARAM_VIDEO.equals(queryParameter37) && !"2".equals(queryParameter37)) {
                    PbActivityConfig createCfgFromUri = PbActivityConfig.createCfgFromUri(getActivity(), intent.getData());
                    createCfgFromUri.setSimilarFrom(1);
                    sendMessage(new CustomMessage(2004001, createCfgFromUri));
                } else {
                    ArrayList arrayList4 = new ArrayList();
                    VideoItemData videoItemData4 = new VideoItemData();
                    videoItemData4.thread_id = str2;
                    arrayList4.add(videoItemData4);
                    new VideoRecommentPlayActivityConfig(this, arrayList4, null, VideoRecommentPlayActivityConfig.FROM_PB_VIDEO_SCHEME).setUri(intent.getData()).start();
                }
                nt4.w().M(true);
            } else if (BdActivityStack.getInst().isActivityExist("MainTabActivity")) {
                sendMessage(new CustomMessage(2002001, new LogoActivityConfig(getActivity())));
            }
        } else {
            FrsActivityConfig frsActivityConfig2 = new FrsActivityConfig(getActivity());
            frsActivityConfig2.setUri(intent.getData());
            Uri parse10 = Uri.parse(dataString);
            if (dataString.contains(FrsActivityConfig.IS_SHOW_IM_GROUP_LIST)) {
                frsActivityConfig2.setIsShowImGroupList(JavaTypesHelper.toInt(parse10.getQueryParameter(FrsActivityConfig.IS_SHOW_IM_GROUP_LIST), 0));
            }
            if (dataString.contains(FrsActivityConfig.LOCATE_ROOM_ID)) {
                frsActivityConfig2.setGroupListLocateRoomId(JavaTypesHelper.toLong(parse10.getQueryParameter(FrsActivityConfig.LOCATE_ROOM_ID), -1L));
            }
            sendMessage(new CustomMessage(2003000, frsActivityConfig2));
            nt4.w().M(true);
        }
    }

    /* loaded from: classes8.dex */
    public class a implements BdUniDispatchSchemeController.OnSchemeParsedCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SchemaRouteActivity a;

        public a(SchemaRouteActivity schemaRouteActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {schemaRouteActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = schemaRouteActivity;
        }

        @Override // com.baidu.tbadk.BdToken.BdUniDispatchSchemeController.OnSchemeParsedCallback
        public void onCallBack(HashMap<String, Object> hashMap) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, hashMap) == null) && hashMap != null && (hashMap.get(BdUniDispatchSchemeController.PARAM_URL) instanceof String)) {
                TbWebViewActivityConfig activityConfig = BrowserHelper.getActivityConfig(this.a.getActivity(), null, (String) hashMap.get(BdUniDispatchSchemeController.PARAM_URL), true);
                activityConfig.setIsFromSchema(true);
                activityConfig.setUri((Uri) hashMap.get(BdUniDispatchSchemeController.PARAM_URI));
                this.a.sendMessage(new CustomMessage(2002001, activityConfig));
            }
        }
    }

    public SchemaRouteActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new a(this);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.pageStayDuration.IPageStayDuration
    public List<String> getCurrentPageSourceKeyList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return getIntent().getStringArrayListExtra("obj_source");
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.PUSH_SCHEME_MID_ACTIVITY_ONCREATE_START_STAMP_KEY);
            if (TbadkCoreApplication.getInst().getStartType() == 2) {
                um5.a = true;
            }
            p19.o = true;
            GrowthFunnelHelper.updateAppStartInfoForActivity(this);
            super.onCreate(bundle);
            t1();
            if (PermissionUtil.isAgreePrivacyPolicy()) {
                o1(getIntent());
            }
            BaseVM.m(1);
            TbSingleton.getInstance().setPushOrSchemeLog(true);
            finish();
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.PUSH_SCHEME_MID_ACTIVITY_ONCREATE_END_STAMP_KEY);
        }
    }

    public final boolean p1(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            Uri parse = Uri.parse(str);
            if (parse == null) {
                return false;
            }
            try {
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (!"flutter/peiWanPage".equalsIgnoreCase(new JSONObject(parse.getQueryParameter("params")).optString("page"))) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void q1(Uri uri) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, uri) != null) || uri == null || !BdUniDispatchSchemeController.isUniScheme(uri)) {
            return;
        }
        String queryParameter = uri.getQueryParameter("obj_locate");
        if (!TextUtils.isEmpty(queryParameter) && queryParameter.startsWith("mdp")) {
            UtilHelper.clearClipBoard();
        }
    }

    public final void s1(Uri uri) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, uri) != null) || uri == null) {
            return;
        }
        mw5.d(uri.getQueryParameter(TiebaStatic.Params.WISE_SAMPLE_ID));
    }

    public final void v1(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, str) == null) && !StringUtils.isNull(str)) {
            String queryParameter = Uri.parse(str).getQueryParameter(BdUniDispatchSchemeController.PARAM_SOURCE);
            if (!StringUtils.isNull(queryParameter)) {
                TbSingleton.getInstance().setFromWhichSearchSource(queryParameter);
            }
        }
    }

    public final void t1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && !BdActivityStack.getInst().isActivityExist("MainTabActivity")) {
            int loadInt = TbadkSettings.getInst().loadInt("skin_", 0);
            if (loadInt == 1) {
                TbadkCoreApplication.getInst().setSkinTypeValue(4);
                TbadkCoreApplication.getInst().SendSkinTypeBroadcast(4);
            } else if (SharedPrefHelper.getInstance().getBoolean("key_is_follow_system_mode", false)) {
                SkinManager.setDayOrDarkSkinTypeWithSystemMode(false, true);
            } else {
                TbadkCoreApplication.getInst().setSkinTypeValue(loadInt);
                TbadkCoreApplication.getInst().SendSkinTypeBroadcast(loadInt);
            }
        }
    }
}
