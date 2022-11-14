package com.baidu.tieba.tblauncher;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import androidx.annotation.Nullable;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaTabFeedActivityConfig;
import com.baidu.tbadk.core.atomData.Anniversary18thActivityConfig;
import com.baidu.tbadk.core.atomData.ForumRulesShowActivityConfig;
import com.baidu.tbadk.core.atomData.ForumSquareActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.HotRanklistActivityConfig;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.atomData.HotUserRankActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.LogoActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.atomData.SignAllForumActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.atomData.TopicDetailActivityConfig;
import com.baidu.tbadk.core.atomData.VideoMiddlePageActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.atomData.VideoRecommentPlayActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.NewUrlSchemaHelper;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.core.util.UrlSchemaJumpHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.schemeaction.SchemeActionHelper;
import com.baidu.tbadk.core.util.schemeaction.SchemeActionManager;
import com.baidu.tbadk.switchs.NewWebHotTopicPageSwitch;
import com.baidu.tieba.cb5;
import com.baidu.tieba.ej5;
import com.baidu.tieba.ek5;
import com.baidu.tieba.en4;
import com.baidu.tieba.ex4;
import com.baidu.tieba.fi5;
import com.baidu.tieba.g35;
import com.baidu.tieba.g95;
import com.baidu.tieba.ix4;
import com.baidu.tieba.lm4;
import com.baidu.tieba.mi8;
import com.baidu.tieba.n9;
import com.baidu.tieba.oh7;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.qe8;
import com.baidu.tieba.tbadkCore.data.FlutterOpenData;
import com.baidu.tieba.tblauncher.dispatcher.EnterForumDispatcher;
import com.baidu.tieba.tblauncher.dispatcher.MessageCenterDispatcher;
import com.baidu.tieba.video.UserItemData;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.xg;
import com.baidu.tieba.yi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes6.dex */
public class SchemaRouteActivity extends BaseActivity {
    public static /* synthetic */ Interceptable $ic;
    public static String b;
    public transient /* synthetic */ FieldHolder $fh;
    public final BdUniDispatchSchemeController.b a;

    public final void x1(Intent intent) {
        boolean z;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        int i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, intent) == null) || intent == null) {
            return;
        }
        ex4.s(intent.getDataString(), false);
        y1(intent.getData());
        z1(intent.getData());
        String dataString = intent.getDataString();
        UtilHelper.clearClipBoardBySchemaParam(dataString);
        en4.e(intent.getData());
        en4.c(intent.getData());
        GrowthStatsUtil.statisticChannel(GrowthStatsUtil.SPLASH_SOURCE.THIRD_PARTY, dataString);
        mi8.d().a(intent.getData());
        if (TextUtils.isEmpty(dataString)) {
            return;
        }
        if (ix4.a().d()) {
            ix4.a().i(1);
        }
        if (SchemeActionHelper.isTieBaAppSchemeHeader(dataString)) {
            lm4.w().L(true);
            if (!n9.g().i("MainTabActivity")) {
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
                        TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(getActivity());
                        tbWebViewActivityConfig.setUri(intent.getData());
                        sendMessage(new CustomMessage(2002001, tbWebViewActivityConfig));
                    }
                    lm4.w().L(true);
                } else if (!dataString.contains("tbtopicdetail") && !dataString.contains("unidispatch/topicdetail")) {
                    if (!dataString.contains("tbusercenter") && !dataString.contains("unidispatch/usercenter") && !dataString.contains("usercenter")) {
                        if (dataString.contains(UrlSchemaHelper.FROM_FORUM_SQUARE)) {
                            ForumSquareActivityConfig forumSquareActivityConfig = new ForumSquareActivityConfig(getActivity());
                            forumSquareActivityConfig.setUri(intent.getData());
                            sendMessage(new CustomMessage(2002001, forumSquareActivityConfig));
                            lm4.w().L(true);
                            return;
                        } else if (dataString.contains("unidispatch/hotuserrank")) {
                            HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(getActivity());
                            hotUserRankActivityConfig.setUri(intent.getData());
                            sendMessage(new CustomMessage(2002001, hotUserRankActivityConfig));
                            lm4.w().L(true);
                            return;
                        } else if (dataString.contains("unidispatch/openapp") || dataString.contains("donothing")) {
                            if (!n9.g().i("MainTabActivity")) {
                                sendMessage(new CustomMessage(2002001, new LogoActivityConfig(getActivity())));
                            }
                            lm4.w().L(true);
                            return;
                        } else {
                            if (dataString.contains(BdUniDispatchSchemeController.HOST + BdUniDispatchSchemeController.PATH_CHUSHOU_ALA_ROOM)) {
                                Uri parse = Uri.parse(dataString);
                                String queryParameter = parse.getQueryParameter(BdUniDispatchSchemeController.PARAM_CHUSHOU_THIRD_LIVE_TYPE);
                                String queryParameter2 = parse.getQueryParameter(BdUniDispatchSchemeController.PARAM_CHUSHOU_ROOM_ID);
                                UrlManager.getInstance().dealOneLink(getPageContext(), new String[]{"tiebachushou://liveroom?roomid=" + queryParameter2 + "&livetype=" + queryParameter});
                                lm4.w().L(true);
                                return;
                            }
                            if (dataString.contains(BdUniDispatchSchemeController.HOST + BdUniDispatchSchemeController.PATH_TIEBA_YY_ROOM)) {
                                String queryParameter3 = Uri.parse(dataString).getQueryParameter(BdUniDispatchSchemeController.PARAM_YY_URL);
                                if (queryParameter3 != null) {
                                    UrlManager.getInstance().dealOneLink(getPageContext(), new String[]{new String(Base64.decode(queryParameter3.getBytes(), 2))});
                                    lm4.w().L(true);
                                    return;
                                }
                                return;
                            } else if (dataString.contains(BdUniDispatchSchemeController.PATH_TIEBA_BAR_FRIEND)) {
                                UrlManager.getInstance().dealOneLink(getPageContext(), new String[]{yi.S(dataString, "from=key_from_live_close_link")});
                                lm4.w().L(true);
                                return;
                            } else if (dataString.contains(BdUniDispatchSchemeController.PATH_BDP_LIVE_CHANNEL)) {
                                AlaTabFeedActivityConfig alaTabFeedActivityConfig = new AlaTabFeedActivityConfig(this);
                                alaTabFeedActivityConfig.setPageSource(g35.d(dataString));
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
                                lm4.w().L(true);
                                return;
                            } else if (dataString.startsWith(UrlSchemaHelper.SCHEMA_LIVE_MY_CONCERN_LIST)) {
                                MainTabActivityConfig mainTabActivityConfig = new MainTabActivityConfig(this);
                                mainTabActivityConfig.setTargetScheme(dataString);
                                MessageManager.getInstance().sendMessage(new CustomMessage(2015002, mainTabActivityConfig));
                                return;
                            } else {
                                if (dataString.contains(BdUniDispatchSchemeController.HOST + BdUniDispatchSchemeController.PATH_VIDEO_SYNTHESIS_PAGE)) {
                                    Anniversary18thActivityConfig.open(this);
                                    return;
                                }
                                if (dataString.contains("unidispatch/forumRuleDetail")) {
                                    ForumRulesShowActivityConfig forumRulesShowActivityConfig = new ForumRulesShowActivityConfig(this, Uri.parse(dataString).getQueryParameter(BdUniDispatchSchemeController.PARAM_FORUM_ID), ForumRulesShowActivityConfig.FORUM_RULE_H5_FROM_SHOW);
                                    forumRulesShowActivityConfig.setRequestCode(25070);
                                    sendMessage(new CustomMessage(2002001, forumRulesShowActivityConfig));
                                }
                                if (dataString.contains("/categorylist")) {
                                    Uri parse2 = Uri.parse(dataString);
                                    String queryParameter4 = parse2.getQueryParameter(BdUniDispatchSchemeController.PARAM_ITEM_ID_CAMEL);
                                    String queryParameter5 = parse2.getQueryParameter(BdUniDispatchSchemeController.PARAM_TAB_ID_CAMEL);
                                    String queryParameter6 = parse2.getQueryParameter(BdUniDispatchSchemeController.PARAM_SORT_TYPE_CAMEL);
                                    String queryParameter7 = parse2.getQueryParameter(BdUniDispatchSchemeController.PARAM_RANK_TYPE_CAMEL);
                                    String queryParameter8 = parse2.getQueryParameter(BdUniDispatchSchemeController.PARAM_RANK_CODE_CAMEL);
                                    String queryParameter9 = parse2.getQueryParameter(BdUniDispatchSchemeController.PARAM_HOME_TAB_NAME_CAMEL);
                                    HashMap hashMap = new HashMap();
                                    hashMap.put("item_id", queryParameter4);
                                    hashMap.put(TiebaStatic.Params.TAB_ID, queryParameter5);
                                    hashMap.put("sort_type", queryParameter6);
                                    hashMap.put("rank_type", queryParameter7);
                                    hashMap.put("rank_code", queryParameter8);
                                    hashMap.put("home_tab_name", queryParameter9);
                                    sendMessage(new CustomMessage(2002015, new FlutterOpenData(this, "ItemRecommendList", hashMap)));
                                }
                                if (dataString.contains("/itemDetailsPage")) {
                                    Uri parse3 = Uri.parse(dataString);
                                    String queryParameter10 = parse3.getQueryParameter(BdUniDispatchSchemeController.PARAM_FORUM_NAME);
                                    if (!StringUtils.isNull(queryParameter10)) {
                                        B1(dataString);
                                        String str6 = "com.baidu.tieba://unidispatch/itemDetailsPage?name=" + queryParameter10 + "&from=" + FrsActivityConfig.FRS_FROM_ITEM;
                                        FrsActivityConfig frsActivityConfig = new FrsActivityConfig(getActivity());
                                        frsActivityConfig.setUri(Uri.parse(str6));
                                        sendMessage(new CustomMessage(2003000, frsActivityConfig));
                                        lm4.w().L(true);
                                    } else {
                                        String queryParameter11 = parse3.getQueryParameter(BdUniDispatchSchemeController.PARAM_ITEM_ID_CAMEL);
                                        HashMap hashMap2 = new HashMap();
                                        hashMap2.put("itemID", String.valueOf(queryParameter11));
                                        sendMessage(new CustomMessage(2002015, new FlutterOpenData(this, "GameItemDetailsPage", hashMap2)));
                                    }
                                }
                                if (dataString.contains("unidispatch/item") && !dataString.contains("/itemDetailsPage")) {
                                    String queryParameter12 = Uri.parse(dataString).getQueryParameter(BdUniDispatchSchemeController.PARAM_ITEM_ID);
                                    HashMap hashMap3 = new HashMap();
                                    hashMap3.put("itemID", String.valueOf(queryParameter12));
                                    sendMessage(new CustomMessage(2002015, new FlutterOpenData(this, "GameItemDetailsPage", hashMap3)));
                                }
                                if (dataString.contains("unidispatch/login_page_test") && !TbadkCoreApplication.isLogin()) {
                                    sendMessage(new CustomMessage(2002001, new LoginActivityConfig(this)));
                                }
                                if (dataString.contains("unidispatch/video_middle_page_qa")) {
                                    Uri parse4 = Uri.parse(dataString);
                                    String queryParameter13 = parse4.getQueryParameter(BdUniDispatchSchemeController.PARAM_TID);
                                    String queryParameter14 = parse4.getQueryParameter(BdUniDispatchSchemeController.PARAM_FORUM_ID);
                                    String queryParameter15 = parse4.getQueryParameter("title");
                                    parse4.getQueryParameter("author_name");
                                    parse4.getQueryParameter("author_nick_name");
                                    parse4.getQueryParameter("author_is_god");
                                    parse4.getQueryParameter("author_is_bigv");
                                    parse4.getQueryParameter("author_portrait");
                                    str3 = "author_portrait";
                                    String queryParameter16 = parse4.getQueryParameter("video_thumbnail_url");
                                    String queryParameter17 = parse4.getQueryParameter("video_url");
                                    str = "video_url";
                                    ArrayList arrayList = new ArrayList();
                                    str2 = "video_thumbnail_url";
                                    VideoItemData videoItemData = new VideoItemData();
                                    videoItemData.thread_id = queryParameter13;
                                    videoItemData.forum_id = queryParameter14;
                                    videoItemData.title = queryParameter15;
                                    videoItemData.thumbnail_url = queryParameter16;
                                    videoItemData.video_url = queryParameter17;
                                    arrayList.add(videoItemData);
                                    VideoPlayActivityConfig videoPlayActivityConfig = new VideoPlayActivityConfig(this, arrayList, "from_nani_video", VideoMiddlePageActivityConfig.FROM_SCHEME_QA);
                                    videoPlayActivityConfig.setUri(intent.getData());
                                    videoPlayActivityConfig.setUri(intent.getData());
                                    sendMessage(new CustomMessage(2002001, videoPlayActivityConfig));
                                } else {
                                    str = "video_url";
                                    str2 = "video_thumbnail_url";
                                    str3 = "author_portrait";
                                }
                                if (dataString.contains("unidispatch/video_middle_light_page_qa")) {
                                    Uri parse5 = Uri.parse(dataString);
                                    String queryParameter18 = parse5.getQueryParameter(BdUniDispatchSchemeController.PARAM_TID);
                                    String queryParameter19 = parse5.getQueryParameter(BdUniDispatchSchemeController.PARAM_FORUM_ID);
                                    String queryParameter20 = parse5.getQueryParameter("title");
                                    parse5.getQueryParameter("author_name");
                                    parse5.getQueryParameter("author_nick_name");
                                    parse5.getQueryParameter("author_is_god");
                                    parse5.getQueryParameter("author_is_bigv");
                                    str4 = str3;
                                    parse5.getQueryParameter(str4);
                                    str5 = str2;
                                    String queryParameter21 = parse5.getQueryParameter(str5);
                                    String queryParameter22 = parse5.getQueryParameter(str);
                                    ArrayList arrayList2 = new ArrayList();
                                    VideoItemData videoItemData2 = new VideoItemData();
                                    videoItemData2.thread_id = queryParameter18;
                                    videoItemData2.forum_id = queryParameter19;
                                    videoItemData2.title = queryParameter20;
                                    videoItemData2.thumbnail_url = queryParameter21;
                                    videoItemData2.video_url = queryParameter22;
                                    arrayList2.add(videoItemData2);
                                    VideoPlayActivityConfig videoPlayActivityConfig2 = new VideoPlayActivityConfig(this, arrayList2, "from_nani_video", VideoMiddlePageActivityConfig.FROM_SCHEME_QA);
                                    videoPlayActivityConfig2.setUri(intent.getData());
                                    sendMessage(new CustomMessage(2002001, videoPlayActivityConfig2));
                                } else {
                                    str4 = str3;
                                    str5 = str2;
                                }
                                if (dataString.contains("unidispatch/video_middle_vertical_page_qa")) {
                                    Uri parse6 = Uri.parse(dataString);
                                    String queryParameter23 = parse6.getQueryParameter(BdUniDispatchSchemeController.PARAM_TID);
                                    String queryParameter24 = parse6.getQueryParameter(BdUniDispatchSchemeController.PARAM_FORUM_ID);
                                    String queryParameter25 = parse6.getQueryParameter("title");
                                    String queryParameter26 = parse6.getQueryParameter("author_uid");
                                    String queryParameter27 = parse6.getQueryParameter("author_name");
                                    String queryParameter28 = parse6.getQueryParameter("author_nick_name");
                                    String queryParameter29 = parse6.getQueryParameter(str4);
                                    String queryParameter30 = parse6.getQueryParameter(str5);
                                    String queryParameter31 = parse6.getQueryParameter(str);
                                    ArrayList arrayList3 = new ArrayList();
                                    VideoItemData videoItemData3 = new VideoItemData();
                                    videoItemData3.thread_id = queryParameter23;
                                    videoItemData3.forum_id = queryParameter24;
                                    videoItemData3.title = queryParameter25;
                                    UserItemData userItemData = new UserItemData();
                                    userItemData.user_id = queryParameter26;
                                    userItemData.user_name = queryParameter27;
                                    userItemData.name_show = queryParameter28;
                                    userItemData.portrait = queryParameter29;
                                    videoItemData3.author_info = userItemData;
                                    videoItemData3.thumbnail_url = queryParameter30;
                                    videoItemData3.video_url = queryParameter31;
                                    arrayList3.add(videoItemData3);
                                    VideoPlayActivityConfig videoPlayActivityConfig3 = new VideoPlayActivityConfig(this, arrayList3, "from_nani_video", VideoMiddlePageActivityConfig.FROM_SCHEME_QA);
                                    videoPlayActivityConfig3.setParamIsVertail(true);
                                    videoPlayActivityConfig3.setUri(intent.getData());
                                    i = 2002001;
                                    sendMessage(new CustomMessage(2002001, videoPlayActivityConfig3));
                                } else {
                                    i = 2002001;
                                }
                                if (dataString.startsWith("tiebaclient://passlogin")) {
                                    LoginActivityConfig loginActivityConfig = new LoginActivityConfig(this);
                                    loginActivityConfig.setAutoLogin(dataString);
                                    sendMessage(new CustomMessage(i, loginActivityConfig));
                                    lm4.w().L(true);
                                }
                                if (dataString.contains("unidispatch/voiceRoom")) {
                                    try {
                                        Uri parse7 = Uri.parse(dataString);
                                        HashMap hashMap4 = new HashMap();
                                        for (String str7 : parse7.getQueryParameterNames()) {
                                            hashMap4.put(str7, parse7.getQueryParameter(str7));
                                        }
                                        if (hashMap4.containsKey("room_id")) {
                                            ((cb5) ServiceManager.getService(cb5.a.a())).a(TbadkCoreApplication.getInst().getCurrentPageContext(this), xg.g((String) hashMap4.get("room_id"), 0L));
                                        }
                                    } catch (Exception unused) {
                                        if (BdBaseApplication.getInst().isDebugMode()) {
                                            BdLog.e("Yuyinfang schema parse exception");
                                        }
                                    }
                                }
                                if (dataString.contains("unidispatch/searchResultPage")) {
                                    String queryParameter32 = Uri.parse(dataString).getQueryParameter(BdUniDispatchSchemeController.PARAM_QUERY);
                                    IntentConfig intentConfig = new IntentConfig(this);
                                    if (!StringUtils.isNull(queryParameter32)) {
                                        intentConfig.getIntent().putExtra(IntentConfig.SEARCH_PAGE_QUERY_CONTENT_KEY, queryParameter32);
                                        MessageManager.getInstance().sendMessage(new CustomMessage(2015003, intentConfig));
                                    } else {
                                        sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
                                    }
                                }
                                if (dataString.contains("unidispatch/videoTopicPage")) {
                                    Uri parse8 = Uri.parse(dataString);
                                    String queryParameter33 = parse8.getQueryParameter("topic_id");
                                    String queryParameter34 = parse8.getQueryParameter(IntentConfig.TOPIC_NAME);
                                    String queryParameter35 = parse8.getQueryParameter("is_video_topic");
                                    if (!TextUtils.isEmpty(queryParameter33)) {
                                        if (!StringHelper.equals(queryParameter35, "1") && NewWebHotTopicPageSwitch.isOn()) {
                                            ej5.e(getPageContext(), queryParameter33, queryParameter34);
                                        } else {
                                            new HotTopicActivityConfig(getPageContext().getPageActivity()).createNormalConfig(queryParameter33, queryParameter34, queryParameter35, null).start();
                                        }
                                    }
                                }
                                if (dataString.contains(UrlSchemaHelper.SCHEMA_TYPE_HOT_TOPIC_RANK_LIST)) {
                                    new HotRanklistActivityConfig(this).createNormalConfig("default", "all").start();
                                }
                                if (dataString.startsWith(UrlSchemaHelper.SCHEMA_GAME_PLAY_PERSON_CHAT)) {
                                    qe8.e(this, dataString, true);
                                }
                                if (dataString.startsWith(UrlSchemaHelper.SCHEMA_GAME_PLAY_ALBUM)) {
                                    qe8.a(this, dataString);
                                }
                                if (dataString.startsWith(UrlSchemaHelper.SCHEMA_GAME_PLAY_SKILL_DETAIL)) {
                                    qe8.d(this, dataString);
                                }
                                if (dataString.startsWith("com.baidu.tieba://unidispatch/GameGodsDetailPage")) {
                                    qe8.b(this, dataString);
                                }
                                if (dataString.startsWith(UrlSchemaHelper.SCHEMA_GAME_PLAY_ORDER_PAGE)) {
                                    qe8.c(this, dataString);
                                }
                                if (dataString.startsWith(UrlSchemaHelper.SCHEMA_GAME_PLAY_MAIN_PAGE)) {
                                    UrlSchemaJumpHelper.jumpGamePlayPage(this, dataString);
                                }
                                if (dataString.startsWith(UrlSchemaHelper.SCHEMA_GAME_PLAY_DISPATCH_PAGE)) {
                                    UrlSchemaJumpHelper.jumpDispatchOrderPage(this, dataString);
                                }
                                if (dataString.startsWith(UrlSchemaHelper.SCHEMA_GAME_PLAY_UNPAID_PAGE)) {
                                    UrlSchemaJumpHelper.jumpUnPaidOrderPage(this, dataString);
                                } else if (dataString.startsWith(UrlSchemaHelper.SCHEMA_MESSAGE_CENTER_PAGE)) {
                                    UrlSchemaJumpHelper.jumpMessageCenterPage(this, dataString);
                                } else if (dataString.startsWith(UrlSchemaHelper.SCHEMA_GAME_PLAY_UNPAID_LIST_PAGE)) {
                                    UrlSchemaJumpHelper.jumpUnPaidListPage(this, dataString);
                                }
                                if (TextUtils.isEmpty(dataString)) {
                                    return;
                                }
                                if (dataString.contains(UrlSchemaHelper.SCHEMA_GAME_RECOMMENT_PAGE) || dataString.contains(NewUrlSchemaHelper.Jump.JUMP_TO_VIDEO_SQUARE) || dataString.contains(UrlSchemaHelper.SCHEMA_TYPE_TB_CLIENT) || dataString.contains(UrlSchemaHelper.SCHEMA_LIVE_SDK) || dataString.contains(UrlSchemaHelper.SCHEMA_CHUSHOU_LIVE_SDK) || dataString.contains(UrlSchemaHelper.SCHEMA_TYPE_TB_CLIENT_ZM) || dataString.contains(UrlSchemaHelper.SCHEMA_TYPE_TB_LAUNCH) || dataString.contains("com.baidu.tieba://unidispatch/homepage") || dataString.contains("com.baidu.tieba://unidispatch/activitypage") || dataString.contains("com.baidu.tieba://unidispatch/minePage") || dataString.contains(MessageCenterDispatcher.url) || dataString.contains(EnterForumDispatcher.url) || dataString.contains("com.baidu.tieba://unidispatch/recommendforum") || dataString.contains("com.baidu.tieba://deeplink") || dataString.contains("com.baidu.tieba://unidispatch/videotab") || dataString.contains(UrlSchemaHelper.SCHEMA_TYPE_HOMEPAGE_ANYTAB)) {
                                    oh7.H(dataString);
                                    MessageManager.getInstance().sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(TbadkCoreApplication.getInst()).createUriCfg(intent.getData())));
                                    return;
                                }
                                return;
                            }
                        }
                    }
                    PersonPolymericActivityConfig personPolymericActivityConfig = new PersonPolymericActivityConfig(getActivity());
                    personPolymericActivityConfig.setUri(intent.getData());
                    sendMessage(new CustomMessage(2002001, personPolymericActivityConfig));
                    lm4.w().L(true);
                } else {
                    if (NewWebHotTopicPageSwitch.isOn()) {
                        ej5.e(getPageContext(), ek5.c(dataString, "topic_id="), null);
                    } else {
                        TopicDetailActivityConfig topicDetailActivityConfig = new TopicDetailActivityConfig(getActivity());
                        topicDetailActivityConfig.setUri(intent.getData());
                        sendMessage(new CustomMessage(2002001, topicDetailActivityConfig));
                    }
                    lm4.w().L(true);
                }
            } else if ("tbpb://tieba.baidu.com".equals(dataString)) {
                if (n9.g().i("MainTabActivity")) {
                    return;
                }
                sendMessage(new CustomMessage(2002001, new LogoActivityConfig(getActivity())));
            } else {
                String queryParameter36 = intent.getData().getQueryParameter("obj_param1");
                if (!BdUniDispatchSchemeController.PARAM_VIDEO.equals(queryParameter36) && !"2".equals(queryParameter36)) {
                    sendMessage(new CustomMessage(2004001, PbActivityConfig.createCfgFromUri(getActivity(), intent.getData())));
                    z = true;
                } else {
                    String queryParameter37 = intent.getData().getQueryParameter("tid");
                    ArrayList arrayList4 = new ArrayList();
                    VideoItemData videoItemData4 = new VideoItemData();
                    videoItemData4.thread_id = queryParameter37;
                    arrayList4.add(videoItemData4);
                    VideoRecommentPlayActivityConfig videoRecommentPlayActivityConfig = new VideoRecommentPlayActivityConfig(this, arrayList4, null, VideoRecommentPlayActivityConfig.FROM_PB_VIDEO_SCHEME);
                    z = true;
                    videoRecommentPlayActivityConfig.setParamIsVertail(true);
                    videoRecommentPlayActivityConfig.setUri(intent.getData());
                    sendMessage(new CustomMessage(2002001, videoRecommentPlayActivityConfig));
                }
                lm4.w().L(z);
            }
        } else {
            FrsActivityConfig frsActivityConfig2 = new FrsActivityConfig(getActivity());
            frsActivityConfig2.setUri(intent.getData());
            sendMessage(new CustomMessage(2003000, frsActivityConfig2));
            lm4.w().L(true);
        }
    }

    /* loaded from: classes6.dex */
    public class a implements BdUniDispatchSchemeController.b {
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

        @Override // com.baidu.tbadk.BdToken.BdUniDispatchSchemeController.b
        public void a(HashMap<String, Object> hashMap) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, hashMap) == null) && hashMap != null && (hashMap.get(BdUniDispatchSchemeController.PARAM_URL) instanceof String)) {
                TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(this.a.getActivity(), null, (String) hashMap.get(BdUniDispatchSchemeController.PARAM_URL), true);
                tbWebViewActivityConfig.setIsFromSchema(true);
                tbWebViewActivityConfig.setUri((Uri) hashMap.get(BdUniDispatchSchemeController.PARAM_URI));
                this.a.sendMessage(new CustomMessage(2002001, tbWebViewActivityConfig));
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

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tieba.ce5
    public List<String> getCurrentPageSourceKeyList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return getIntent().getStringArrayListExtra("obj_source");
        }
        return (List) invokeV.objValue;
    }

    public final void A1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && !n9.g().i("MainTabActivity")) {
            int loadInt = TbadkSettings.getInst().loadInt("skin_", 0);
            if (loadInt != 1) {
                SkinManager.setDayOrDarkSkinTypeWithSystemMode(false, true);
                return;
            }
            TbadkCoreApplication.getInst().setSkinTypeValue(loadInt);
            TbadkCoreApplication.getInst().SendSkinTypeBroadcast(loadInt);
        }
    }

    public final void B1(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) && !StringUtils.isNull(str)) {
            String queryParameter = Uri.parse(str).getQueryParameter(BdUniDispatchSchemeController.PARAM_SOURCE);
            if (!StringUtils.isNull(queryParameter)) {
                TbSingleton.getInstance().setFromWhichSearchSource(queryParameter);
            }
        }
    }

    public final void y1(Uri uri) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, uri) != null) || uri == null || !BdUniDispatchSchemeController.isUniScheme(uri)) {
            return;
        }
        String queryParameter = uri.getQueryParameter("obj_locate");
        if (!TextUtils.isEmpty(queryParameter) && queryParameter.startsWith("mdp")) {
            UtilHelper.clearClipBoard();
        }
    }

    public final void z1(Uri uri) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, uri) != null) || uri == null) {
            return;
        }
        fi5.d(uri.getQueryParameter(TiebaStatic.Params.WISE_SAMPLE_ID));
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.PUSH_SCHEME_MID_ACTIVITY_ONCREATE_START_STAMP_KEY);
            if (TbadkCoreApplication.getInst().getStartType() == 2) {
                g95.a = true;
            }
            oh7.o = true;
            ex4.u(this);
            super.onCreate(bundle);
            A1();
            if (PermissionUtil.isAgreePrivacyPolicy()) {
                x1(getIntent());
            }
            BaseVM.m(1);
            TbSingleton.getInstance().setPushOrSchemeLog(true);
            finish();
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.PUSH_SCHEME_MID_ACTIVITY_ONCREATE_END_STAMP_KEY);
        }
    }
}
