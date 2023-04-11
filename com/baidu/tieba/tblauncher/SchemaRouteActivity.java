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
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.util.schemeaction.SchemeActionHelper;
import com.baidu.tbadk.core.util.schemeaction.SchemeActionManager;
import com.baidu.tbadk.switchs.NewWebHotTopicPageSwitch;
import com.baidu.tieba.aq4;
import com.baidu.tieba.e35;
import com.baidu.tieba.f99;
import com.baidu.tieba.fd9;
import com.baidu.tieba.gg;
import com.baidu.tieba.h95;
import com.baidu.tieba.i35;
import com.baidu.tieba.ii;
import com.baidu.tieba.ii5;
import com.baidu.tieba.it4;
import com.baidu.tieba.mt9;
import com.baidu.tieba.nf5;
import com.baidu.tieba.p45;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pp5;
import com.baidu.tieba.qc8;
import com.baidu.tieba.sq5;
import com.baidu.tieba.tbadkCore.data.FlutterOpenData;
import com.baidu.tieba.tblauncher.dispatcher.EnterForumDispatcher;
import com.baidu.tieba.tblauncher.dispatcher.MessageCenterDispatcher;
import com.baidu.tieba.tq4;
import com.baidu.tieba.ur5;
import com.baidu.tieba.video.UserItemData;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.w8;
import com.baidu.tieba.yh5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class SchemaRouteActivity extends BaseActivity {
    public static /* synthetic */ Interceptable $ic;
    public static String b;
    public transient /* synthetic */ FieldHolder $fh;
    public final BdUniDispatchSchemeController.b a;

    /* JADX WARN: Removed duplicated region for block: B:128:0x03e6 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:129:0x03e7  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0400  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x04d1  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0538  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0542  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x05a9  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x061b  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0626  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x06b1  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0704  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x0754  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0763  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x076f  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x077a  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x0785  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x0790  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x079b  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x07a6  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x07b1  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x07b5  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x07d4  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x07eb  */
    /* JADX WARN: Removed duplicated region for block: B:304:0x0646 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:310:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void x1(Intent intent) {
        String str;
        int i;
        String str2;
        JSONObject jSONObject;
        JSONObject jSONObject2;
        LoginActivityConfig loginActivityConfig;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, intent) == null) || intent == null) {
            return;
        }
        e35.r(intent.getDataString(), false);
        A1(intent.getData());
        B1(intent.getData());
        String dataString = intent.getDataString();
        UtilHelper.clearClipBoardBySchemaParam(dataString);
        tq4.e(intent.getData());
        tq4.c(intent.getData());
        GrowthStatsUtil.statisticChannel(GrowthStatsUtil.SPLASH_SOURCE.THIRD_PARTY, dataString);
        fd9.d().a(intent.getData());
        if (TextUtils.isEmpty(dataString)) {
            return;
        }
        if (i35.a().d()) {
            i35.a().i(1);
        }
        if (SchemeActionHelper.isTieBaAppSchemeHeader(dataString)) {
            aq4.w().M(true);
            if (!w8.f().h("MainTabActivity")) {
                if (z1(dataString)) {
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
                        it4.r(getActivity(), data);
                    }
                    aq4.w().M(true);
                } else if (!dataString.contains("tbtopicdetail") && !dataString.contains("unidispatch/topicdetail")) {
                    if (!dataString.contains("tbusercenter") && !dataString.contains("unidispatch/usercenter") && !dataString.contains("usercenter")) {
                        if (dataString.contains(UrlSchemaHelper.FROM_FORUM_SQUARE)) {
                            ForumSquareActivityConfig forumSquareActivityConfig = new ForumSquareActivityConfig(getActivity());
                            forumSquareActivityConfig.setUri(intent.getData());
                            sendMessage(new CustomMessage(2002001, forumSquareActivityConfig));
                            aq4.w().M(true);
                            return;
                        } else if (dataString.contains("unidispatch/hotuserrank")) {
                            HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(getActivity());
                            hotUserRankActivityConfig.setUri(intent.getData());
                            sendMessage(new CustomMessage(2002001, hotUserRankActivityConfig));
                            aq4.w().M(true);
                            return;
                        } else if (dataString.contains("unidispatch/openapp") || dataString.contains("donothing")) {
                            if (!w8.f().h("MainTabActivity")) {
                                sendMessage(new CustomMessage(2002001, new LogoActivityConfig(getActivity())));
                            }
                            aq4.w().M(true);
                            return;
                        } else {
                            if (dataString.contains(BdUniDispatchSchemeController.HOST + BdUniDispatchSchemeController.PATH_CHUSHOU_ALA_ROOM)) {
                                Uri parse = Uri.parse(dataString);
                                String queryParameter = parse.getQueryParameter(BdUniDispatchSchemeController.PARAM_CHUSHOU_THIRD_LIVE_TYPE);
                                String queryParameter2 = parse.getQueryParameter(BdUniDispatchSchemeController.PARAM_CHUSHOU_ROOM_ID);
                                UrlManager.getInstance().dealOneLink(getPageContext(), new String[]{"tiebachushou://liveroom?roomid=" + queryParameter2 + "&livetype=" + queryParameter});
                                aq4.w().M(true);
                                return;
                            }
                            if (dataString.contains(BdUniDispatchSchemeController.HOST + BdUniDispatchSchemeController.PATH_TIEBA_YY_ROOM)) {
                                String queryParameter3 = Uri.parse(dataString).getQueryParameter(BdUniDispatchSchemeController.PARAM_YY_URL);
                                if (queryParameter3 != null) {
                                    UrlManager.getInstance().dealOneLink(getPageContext(), new String[]{new String(Base64.decode(queryParameter3.getBytes(), 2))});
                                    aq4.w().M(true);
                                    return;
                                }
                                return;
                            } else if (dataString.contains(BdUniDispatchSchemeController.PATH_TIEBA_BAR_FRIEND)) {
                                UrlManager.getInstance().dealOneLink(getPageContext(), new String[]{ii.T(dataString, "from=key_from_live_close_link")});
                                aq4.w().M(true);
                                return;
                            } else if (dataString.contains(BdUniDispatchSchemeController.PATH_BDP_LIVE_CHANNEL)) {
                                AlaTabFeedActivityConfig alaTabFeedActivityConfig = new AlaTabFeedActivityConfig(this);
                                alaTabFeedActivityConfig.setPageSource(h95.d(dataString));
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
                                aq4.w().M(true);
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
                                if (!TextUtils.isEmpty(dataString) && dataString.startsWith("com.baidu.tieba://unidispatch/router/portal")) {
                                    String queryParameter10 = Uri.parse(dataString).getQueryParameter(BdUniDispatchSchemeController.PARAM_CHAT_ROOM_ID_CAMEL);
                                    if (queryParameter10 != null) {
                                        try {
                                            jSONObject2 = new JSONObject(queryParameter10);
                                            str2 = jSONObject2.optString("page");
                                        } catch (JSONException e) {
                                            e = e;
                                            str2 = null;
                                        }
                                        try {
                                            jSONObject = jSONObject2.optJSONObject("pageParams");
                                        } catch (JSONException e2) {
                                            e = e2;
                                            e.printStackTrace();
                                            jSONObject = null;
                                            if ("im/groupChat".equals(str2)) {
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
                                    } else {
                                        jSONObject = null;
                                        str2 = null;
                                    }
                                    if ("im/groupChat".equals(str2) && jSONObject != null) {
                                        long optLong2 = jSONObject.optLong("roomId");
                                        String optString2 = jSONObject.optString(IntentConfig.BACK_SCHEME);
                                        loginActivityConfig = new LoginActivityConfig(getApplicationContext(), true);
                                        loginActivityConfig.setJumpToAfterDestroy(2);
                                        loginActivityConfig.setBackScheme(dataString);
                                        if (ViewHelper.checkUpIsLoginFromH5(loginActivityConfig)) {
                                            return;
                                        }
                                        ii5.a().a(getActivity(), optLong2, -1, optString2);
                                        return;
                                    }
                                }
                                if (dataString.contains("/itemDetailsPage")) {
                                    Uri parse3 = Uri.parse(dataString);
                                    String queryParameter12 = parse3.getQueryParameter(BdUniDispatchSchemeController.PARAM_FORUM_NAME);
                                    if (!StringUtils.isNull(queryParameter12)) {
                                        E1(dataString);
                                        String str3 = "com.baidu.tieba://unidispatch/itemDetailsPage?name=" + queryParameter12 + "&from=" + FrsActivityConfig.FRS_FROM_ITEM;
                                        FrsActivityConfig frsActivityConfig = new FrsActivityConfig(getActivity());
                                        frsActivityConfig.setUri(Uri.parse(str3));
                                        sendMessage(new CustomMessage(2003000, frsActivityConfig));
                                        aq4.w().M(true);
                                    } else {
                                        String queryParameter13 = parse3.getQueryParameter(BdUniDispatchSchemeController.PARAM_ITEM_ID_CAMEL);
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
                                    str = "video_url";
                                } else {
                                    Uri parse4 = Uri.parse(dataString);
                                    String queryParameter14 = parse4.getQueryParameter(BdUniDispatchSchemeController.PARAM_TID);
                                    String queryParameter15 = parse4.getQueryParameter(BdUniDispatchSchemeController.PARAM_FORUM_ID);
                                    String queryParameter16 = parse4.getQueryParameter("title");
                                    parse4.getQueryParameter("author_name");
                                    parse4.getQueryParameter("author_nick_name");
                                    parse4.getQueryParameter("author_is_god");
                                    parse4.getQueryParameter("author_is_bigv");
                                    parse4.getQueryParameter("author_portrait");
                                    String queryParameter17 = parse4.getQueryParameter("video_thumbnail_url");
                                    String queryParameter18 = parse4.getQueryParameter("video_url");
                                    ArrayList arrayList = new ArrayList();
                                    str = "video_url";
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
                                    Uri parse5 = Uri.parse(dataString);
                                    String queryParameter19 = parse5.getQueryParameter(BdUniDispatchSchemeController.PARAM_TID);
                                    String queryParameter20 = parse5.getQueryParameter(BdUniDispatchSchemeController.PARAM_FORUM_ID);
                                    String queryParameter21 = parse5.getQueryParameter("title");
                                    parse5.getQueryParameter("author_name");
                                    parse5.getQueryParameter("author_nick_name");
                                    parse5.getQueryParameter("author_is_god");
                                    parse5.getQueryParameter("author_is_bigv");
                                    parse5.getQueryParameter("author_portrait");
                                    String queryParameter22 = parse5.getQueryParameter("video_thumbnail_url");
                                    String queryParameter23 = parse5.getQueryParameter(str);
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
                                    Uri parse6 = Uri.parse(dataString);
                                    String queryParameter24 = parse6.getQueryParameter(BdUniDispatchSchemeController.PARAM_TID);
                                    String queryParameter25 = parse6.getQueryParameter(BdUniDispatchSchemeController.PARAM_FORUM_ID);
                                    String queryParameter26 = parse6.getQueryParameter("title");
                                    String queryParameter27 = parse6.getQueryParameter("author_uid");
                                    String queryParameter28 = parse6.getQueryParameter("author_name");
                                    String queryParameter29 = parse6.getQueryParameter("author_nick_name");
                                    String queryParameter30 = parse6.getQueryParameter("author_portrait");
                                    String queryParameter31 = parse6.getQueryParameter("video_thumbnail_url");
                                    String queryParameter32 = parse6.getQueryParameter(str);
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
                                    aq4.w().M(true);
                                }
                                if (dataString.contains("unidispatch/voiceRoom")) {
                                    try {
                                        Uri parse7 = Uri.parse(dataString);
                                        HashMap hashMap4 = new HashMap();
                                        for (String str4 : parse7.getQueryParameterNames()) {
                                            hashMap4.put(str4, parse7.getQueryParameter(str4));
                                        }
                                        if (hashMap4.containsKey("room_id")) {
                                            ((yh5) ServiceManager.getService(yh5.a.a())).a(TbadkCoreApplication.getInst().getCurrentPageContext(this), gg.g((String) hashMap4.get("room_id"), 0L), hashMap4);
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
                                    Uri parse8 = Uri.parse(dataString);
                                    String queryParameter34 = parse8.getQueryParameter("topic_id");
                                    String queryParameter35 = parse8.getQueryParameter(IntentConfig.TOPIC_NAME);
                                    String queryParameter36 = parse8.getQueryParameter("is_video_topic");
                                    if (!TextUtils.isEmpty(queryParameter34)) {
                                        if (!StringHelper.equals(queryParameter36, "1") && NewWebHotTopicPageSwitch.isOn()) {
                                            sq5.e(getPageContext(), queryParameter34, queryParameter35);
                                        } else {
                                            new HotTopicActivityConfig(getPageContext().getPageActivity()).createNormalConfig(queryParameter34, queryParameter35, queryParameter36, null).start();
                                        }
                                    }
                                }
                                if (dataString.contains(UrlSchemaHelper.SCHEMA_TYPE_HOT_TOPIC_RANK_LIST)) {
                                    mt9.c(getPageContext());
                                }
                                if (dataString.startsWith(UrlSchemaHelper.SCHEMA_GAME_PLAY_PERSON_CHAT)) {
                                    f99.e(this, dataString, true);
                                }
                                if (dataString.startsWith(UrlSchemaHelper.SCHEMA_GAME_PLAY_ALBUM)) {
                                    f99.a(this, dataString);
                                }
                                if (dataString.startsWith(UrlSchemaHelper.SCHEMA_GAME_PLAY_SKILL_DETAIL)) {
                                    f99.d(this, dataString);
                                }
                                if (dataString.startsWith("com.baidu.tieba://unidispatch/GameGodsDetailPage")) {
                                    f99.b(this, dataString);
                                }
                                if (dataString.startsWith(UrlSchemaHelper.SCHEMA_GAME_PLAY_ORDER_PAGE)) {
                                    f99.c(this, dataString);
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
                                        qc8.G(dataString);
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
                    aq4.w().M(true);
                } else {
                    if (NewWebHotTopicPageSwitch.isOn()) {
                        sq5.e(getPageContext(), ur5.c(dataString, "topic_id="), null);
                    } else {
                        TopicDetailActivityConfig topicDetailActivityConfig = new TopicDetailActivityConfig(getActivity());
                        topicDetailActivityConfig.setUri(intent.getData());
                        sendMessage(new CustomMessage(2002001, topicDetailActivityConfig));
                    }
                    aq4.w().M(true);
                }
            } else if ("tbpb://tieba.baidu.com".equals(dataString)) {
                if (w8.f().h("MainTabActivity")) {
                    return;
                }
                sendMessage(new CustomMessage(2002001, new LogoActivityConfig(getActivity())));
            } else {
                String queryParameter37 = intent.getData().getQueryParameter("obj_param1");
                if (!BdUniDispatchSchemeController.PARAM_VIDEO.equals(queryParameter37) && !"2".equals(queryParameter37)) {
                    sendMessage(new CustomMessage(2004001, PbActivityConfig.createCfgFromUri(getActivity(), intent.getData())));
                } else {
                    String queryParameter38 = intent.getData().getQueryParameter("tid");
                    ArrayList arrayList4 = new ArrayList();
                    VideoItemData videoItemData4 = new VideoItemData();
                    videoItemData4.thread_id = queryParameter38;
                    arrayList4.add(videoItemData4);
                    new VideoRecommentPlayActivityConfig(this, arrayList4, null, VideoRecommentPlayActivityConfig.FROM_PB_VIDEO_SCHEME).setUri(intent.getData()).start();
                }
                aq4.w().M(true);
            }
        } else {
            FrsActivityConfig frsActivityConfig2 = new FrsActivityConfig(getActivity());
            frsActivityConfig2.setUri(intent.getData());
            Uri parse9 = Uri.parse(dataString);
            if (dataString.contains(FrsActivityConfig.IS_SHOW_IM_GROUP_LIST)) {
                frsActivityConfig2.setIsShowImGroupList(gg.e(parse9.getQueryParameter(FrsActivityConfig.IS_SHOW_IM_GROUP_LIST), 0));
            }
            if (dataString.contains(FrsActivityConfig.LOCATE_ROOM_ID)) {
                frsActivityConfig2.setGroupListLocateRoomId(gg.g(parse9.getQueryParameter(FrsActivityConfig.LOCATE_ROOM_ID), -1L));
            }
            sendMessage(new CustomMessage(2003000, frsActivityConfig2));
            aq4.w().M(true);
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
                TbWebViewActivityConfig g = it4.g(this.a.getActivity(), null, (String) hashMap.get(BdUniDispatchSchemeController.PARAM_URL), true);
                g.setIsFromSchema(true);
                g.setUri((Uri) hashMap.get(BdUniDispatchSchemeController.PARAM_URI));
                this.a.sendMessage(new CustomMessage(2002001, g));
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

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tieba.ll5
    public List<String> getCurrentPageSourceKeyList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return getIntent().getStringArrayListExtra("obj_source");
        }
        return (List) invokeV.objValue;
    }

    public final void A1(Uri uri) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, uri) != null) || uri == null || !BdUniDispatchSchemeController.isUniScheme(uri)) {
            return;
        }
        String queryParameter = uri.getQueryParameter("obj_locate");
        if (!TextUtils.isEmpty(queryParameter) && queryParameter.startsWith("mdp")) {
            UtilHelper.clearClipBoard();
        }
    }

    public final void B1(Uri uri) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, uri) != null) || uri == null) {
            return;
        }
        pp5.d(uri.getQueryParameter(TiebaStatic.Params.WISE_SAMPLE_ID));
    }

    public final void E1(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, str) == null) && !StringUtils.isNull(str)) {
            String queryParameter = Uri.parse(str).getQueryParameter(BdUniDispatchSchemeController.PARAM_SOURCE);
            if (!StringUtils.isNull(queryParameter)) {
                TbSingleton.getInstance().setFromWhichSearchSource(queryParameter);
            }
        }
    }

    public final void C1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && !w8.f().h("MainTabActivity")) {
            int loadInt = TbadkSettings.getInst().loadInt("skin_", 0);
            if (loadInt == 1) {
                TbadkCoreApplication.getInst().setSkinTypeValue(4);
                TbadkCoreApplication.getInst().SendSkinTypeBroadcast(4);
            } else if (p45.m().i("key_is_follow_system_mode", false)) {
                SkinManager.setDayOrDarkSkinTypeWithSystemMode(false, true);
            } else {
                TbadkCoreApplication.getInst().setSkinTypeValue(loadInt);
                TbadkCoreApplication.getInst().SendSkinTypeBroadcast(loadInt);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.PUSH_SCHEME_MID_ACTIVITY_ONCREATE_START_STAMP_KEY);
            if (TbadkCoreApplication.getInst().getStartType() == 2) {
                nf5.a = true;
            }
            qc8.o = true;
            e35.t(this);
            super.onCreate(bundle);
            C1();
            if (PermissionUtil.isAgreePrivacyPolicy()) {
                x1(getIntent());
            }
            BaseVM.m(1);
            TbSingleton.getInstance().setPushOrSchemeLog(true);
            finish();
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.PUSH_SCHEME_MID_ACTIVITY_ONCREATE_END_STAMP_KEY);
        }
    }

    public final boolean z1(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
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
}
