package com.baidu.tieba.tblauncher;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.launch.stats.SpeedStatsManager;
import com.baidu.searchbox.launch.stats.SpeedStatsStampTable;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.BdToken.BdUniDispatchSchemeController;
import com.baidu.tbadk.GrowthStatsUtil;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.TbadkCoreApplication;
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
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.schemeaction.SchemeActionHelper;
import com.baidu.tbadk.core.util.schemeaction.SchemeActionManager;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.tbadkCore.data.FlutterOpenData;
import com.baidu.tieba.video.UserItemData;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.fi4;
import com.repackage.ib5;
import com.repackage.j45;
import com.repackage.jg;
import com.repackage.kr4;
import com.repackage.l97;
import com.repackage.mh4;
import com.repackage.or4;
import com.repackage.q25;
import com.repackage.s98;
import com.repackage.x8;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes4.dex */
public class SchemaRouteActivity extends BaseActivity {
    public static /* synthetic */ Interceptable $ic;
    public static String targetSchemeAction;
    public transient /* synthetic */ FieldHolder $fh;
    public final BdUniDispatchSchemeController.b mOnSchemeParsedCallback;

    /* loaded from: classes4.dex */
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
        this.mOnSchemeParsedCallback = new a(this);
    }

    private void checkSchema(Intent intent) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, this, intent) == null) || intent == null) {
            return;
        }
        kr4.t(intent.getDataString(), false);
        clearClipBoardIfNeed(intent.getData());
        parserWiseSampleId(intent.getData());
        String dataString = intent.getDataString();
        UtilHelper.clearClipBoardBySchemaParam(dataString);
        fi4.e(intent.getData());
        fi4.c(intent.getData());
        GrowthStatsUtil.statisticChannel(GrowthStatsUtil.SPLASH_SOURCE.THIRD_PARTY, dataString);
        s98.d().a(intent.getData());
        if (!TextUtils.isEmpty(dataString) && or4.a().d()) {
            or4.a().i(1);
        }
        if (!TextUtils.isEmpty(dataString) && SchemeActionHelper.isTieBaAppSchemeHeader(dataString)) {
            mh4.x().M(true);
            if (!x8.g().i("MainTabActivity")) {
                targetSchemeAction = dataString;
                sendMessage(new CustomMessage(2002001, new LogoActivityConfig(getActivity())));
                return;
            }
            SchemeActionManager.getInstance().doSchemeAction(getPageContext(), dataString);
        } else if (!TextUtils.isEmpty(dataString) && (dataString.contains("tbfrs") || dataString.contains("unidispatch/frs"))) {
            FrsActivityConfig frsActivityConfig = new FrsActivityConfig(getActivity());
            frsActivityConfig.setUri(intent.getData());
            sendMessage(new CustomMessage(2003000, frsActivityConfig));
            mh4.x().M(true);
        } else if (!TextUtils.isEmpty(dataString) && (dataString.contains("tbpb") || dataString.contains(PbModel.UNIDISPATCH_PB))) {
            if ("tbpb://tieba.baidu.com".equals(dataString)) {
                if (x8.g().i("MainTabActivity")) {
                    return;
                }
                sendMessage(new CustomMessage(2002001, new LogoActivityConfig(getActivity())));
                return;
            }
            String queryParameter = intent.getData().getQueryParameter("obj_param1");
            if (!BdUniDispatchSchemeController.PARAM_VIDEO.equals(queryParameter) && !"2".equals(queryParameter)) {
                sendMessage(new CustomMessage(2004001, PbActivityConfig.createCfgFromUri(getActivity(), intent.getData())));
            } else {
                String queryParameter2 = intent.getData().getQueryParameter("tid");
                ArrayList arrayList = new ArrayList();
                VideoItemData videoItemData = new VideoItemData();
                videoItemData.thread_id = queryParameter2;
                arrayList.add(videoItemData);
                VideoRecommentPlayActivityConfig videoRecommentPlayActivityConfig = new VideoRecommentPlayActivityConfig(this, arrayList, null, VideoRecommentPlayActivityConfig.FROM_PB_VIDEO_SCHEME);
                videoRecommentPlayActivityConfig.setParamIsVertail(true);
                videoRecommentPlayActivityConfig.setUri(intent.getData());
                sendMessage(new CustomMessage(2002001, videoRecommentPlayActivityConfig));
            }
            mh4.x().M(true);
        } else if (!TextUtils.isEmpty(dataString) && dataString.contains("tbwebview")) {
            Uri data = intent.getData();
            if (BdUniDispatchSchemeController.isUniScheme(data)) {
                BdUniDispatchSchemeController.getInstance().parseWebViewScheme(dataString, data, this.mOnSchemeParsedCallback);
            } else {
                TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(getActivity());
                tbWebViewActivityConfig.setUri(intent.getData());
                sendMessage(new CustomMessage(2002001, tbWebViewActivityConfig));
            }
            mh4.x().M(true);
        } else if (!TextUtils.isEmpty(dataString) && (dataString.contains("tbtopicdetail") || dataString.contains("unidispatch/topicdetail"))) {
            TopicDetailActivityConfig topicDetailActivityConfig = new TopicDetailActivityConfig(getActivity());
            topicDetailActivityConfig.setUri(intent.getData());
            sendMessage(new CustomMessage(2002001, topicDetailActivityConfig));
            mh4.x().M(true);
        } else if (!TextUtils.isEmpty(dataString) && (dataString.contains("tbusercenter") || dataString.contains("unidispatch/usercenter") || dataString.contains("usercenter"))) {
            PersonPolymericActivityConfig personPolymericActivityConfig = new PersonPolymericActivityConfig(getActivity());
            personPolymericActivityConfig.setUri(intent.getData());
            sendMessage(new CustomMessage(2002001, personPolymericActivityConfig));
            mh4.x().M(true);
        } else if (!TextUtils.isEmpty(dataString) && dataString.contains(UrlSchemaHelper.FROM_FORUM_SQUARE)) {
            ForumSquareActivityConfig forumSquareActivityConfig = new ForumSquareActivityConfig(getActivity());
            forumSquareActivityConfig.setUri(intent.getData());
            sendMessage(new CustomMessage(2002001, forumSquareActivityConfig));
            mh4.x().M(true);
        } else if (!TextUtils.isEmpty(dataString) && dataString.contains("unidispatch/hotuserrank")) {
            HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(getActivity());
            hotUserRankActivityConfig.setUri(intent.getData());
            sendMessage(new CustomMessage(2002001, hotUserRankActivityConfig));
            mh4.x().M(true);
        } else if (!TextUtils.isEmpty(dataString) && (dataString.contains("unidispatch/openapp") || dataString.contains("donothing"))) {
            if (!x8.g().i("MainTabActivity")) {
                sendMessage(new CustomMessage(2002001, new LogoActivityConfig(getActivity())));
            }
            mh4.x().M(true);
        } else {
            if (!TextUtils.isEmpty(dataString)) {
                if (dataString.contains(BdUniDispatchSchemeController.HOST + BdUniDispatchSchemeController.PATH_CHUSHOU_ALA_ROOM)) {
                    Uri parse = Uri.parse(dataString);
                    String queryParameter3 = parse.getQueryParameter(BdUniDispatchSchemeController.PARAM_CHUSHOU_THIRD_LIVE_TYPE);
                    String queryParameter4 = parse.getQueryParameter(BdUniDispatchSchemeController.PARAM_CHUSHOU_ROOM_ID);
                    UrlManager.getInstance().dealOneLink(getPageContext(), new String[]{"tiebachushou://liveroom?roomid=" + queryParameter4 + "&livetype=" + queryParameter3});
                    mh4.x().M(true);
                    return;
                }
            }
            if (!TextUtils.isEmpty(dataString)) {
                if (dataString.contains(BdUniDispatchSchemeController.HOST + BdUniDispatchSchemeController.PATH_TIEBA_YY_ROOM)) {
                    String queryParameter5 = Uri.parse(dataString).getQueryParameter(BdUniDispatchSchemeController.PARAM_YY_URL);
                    if (queryParameter5 != null) {
                        UrlManager.getInstance().dealOneLink(getPageContext(), new String[]{new String(Base64.decode(queryParameter5.getBytes(), 2))});
                        mh4.x().M(true);
                        return;
                    }
                    return;
                }
            }
            if (!TextUtils.isEmpty(dataString) && dataString.contains("unidispatch/onekeysign")) {
                if (TbadkCoreApplication.isLogin()) {
                    SignAllForumActivityConfig signAllForumActivityConfig = new SignAllForumActivityConfig(getPageContext().getPageActivity());
                    signAllForumActivityConfig.setUri(intent.getData());
                    sendMessage(new CustomMessage(2002001, signAllForumActivityConfig));
                } else {
                    sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(this).createNormalCfg(1)));
                }
                mh4.x().M(true);
            } else if (!TextUtils.isEmpty(dataString) && dataString.startsWith(UrlSchemaHelper.SCHEMA_LIVE_MY_CONCERN_LIST)) {
                MainTabActivityConfig mainTabActivityConfig = new MainTabActivityConfig(this);
                mainTabActivityConfig.setTargetScheme(dataString);
                MessageManager.getInstance().sendMessage(new CustomMessage(2015002, mainTabActivityConfig));
            } else {
                if (!TextUtils.isEmpty(dataString)) {
                    if (dataString.contains(BdUniDispatchSchemeController.HOST + BdUniDispatchSchemeController.PATH_VIDEO_SYNTHESIS_PAGE)) {
                        Anniversary18thActivityConfig.open(this);
                        return;
                    }
                }
                if (!TextUtils.isEmpty(dataString) && dataString.contains("unidispatch/forumRuleDetail")) {
                    ForumRulesShowActivityConfig forumRulesShowActivityConfig = new ForumRulesShowActivityConfig(this, Uri.parse(dataString).getQueryParameter(BdUniDispatchSchemeController.PARAM_FORUM_ID), ForumRulesShowActivityConfig.FORUM_RULE_H5_FROM_SHOW);
                    forumRulesShowActivityConfig.setRequestCode(25070);
                    sendMessage(new CustomMessage(2002001, forumRulesShowActivityConfig));
                }
                if (!TextUtils.isEmpty(dataString) && dataString.contains("/categorylist")) {
                    Uri parse2 = Uri.parse(dataString);
                    String queryParameter6 = parse2.getQueryParameter(BdUniDispatchSchemeController.PARAM_ITEM_ID_CAMEL);
                    String queryParameter7 = parse2.getQueryParameter(BdUniDispatchSchemeController.PARAM_TAB_ID_CAMEL);
                    String queryParameter8 = parse2.getQueryParameter(BdUniDispatchSchemeController.PARAM_SORT_TYPE_CAMEL);
                    String queryParameter9 = parse2.getQueryParameter(BdUniDispatchSchemeController.PARAM_RANK_TYPE_CAMEL);
                    String queryParameter10 = parse2.getQueryParameter(BdUniDispatchSchemeController.PARAM_RANK_CODE_CAMEL);
                    String queryParameter11 = parse2.getQueryParameter(BdUniDispatchSchemeController.PARAM_HOME_TAB_NAME_CAMEL);
                    HashMap hashMap = new HashMap();
                    hashMap.put("item_id", queryParameter6);
                    hashMap.put("tab_id", queryParameter7);
                    hashMap.put("sort_type", queryParameter8);
                    hashMap.put("rank_type", queryParameter9);
                    hashMap.put("rank_code", queryParameter10);
                    hashMap.put("home_tab_name", queryParameter11);
                    sendMessage(new CustomMessage(2002015, new FlutterOpenData(this, "ItemRecommendList", hashMap)));
                }
                if (!TextUtils.isEmpty(dataString) && dataString.contains("/itemDetailsPage")) {
                    Uri parse3 = Uri.parse(dataString);
                    String queryParameter12 = parse3.getQueryParameter(BdUniDispatchSchemeController.PARAM_FORUM_NAME);
                    if (!StringUtils.isNull(queryParameter12)) {
                        setSearchSource(dataString);
                        String str6 = "com.baidu.tieba://unidispatch/itemDetailsPage?name=" + queryParameter12 + "&from=" + FrsActivityConfig.FRS_FROM_ITEM;
                        FrsActivityConfig frsActivityConfig2 = new FrsActivityConfig(getActivity());
                        frsActivityConfig2.setUri(Uri.parse(str6));
                        sendMessage(new CustomMessage(2003000, frsActivityConfig2));
                        mh4.x().M(true);
                    } else {
                        String queryParameter13 = parse3.getQueryParameter(BdUniDispatchSchemeController.PARAM_ITEM_ID_CAMEL);
                        HashMap hashMap2 = new HashMap();
                        hashMap2.put("itemID", String.valueOf(queryParameter13));
                        sendMessage(new CustomMessage(2002015, new FlutterOpenData(this, "GameItemDetailsPage", hashMap2)));
                    }
                }
                if (!TextUtils.isEmpty(dataString) && dataString.contains("unidispatch/item") && !dataString.contains("/itemDetailsPage")) {
                    String queryParameter14 = Uri.parse(dataString).getQueryParameter(BdUniDispatchSchemeController.PARAM_ITEM_ID);
                    HashMap hashMap3 = new HashMap();
                    hashMap3.put("itemID", String.valueOf(queryParameter14));
                    sendMessage(new CustomMessage(2002015, new FlutterOpenData(this, "GameItemDetailsPage", hashMap3)));
                }
                if (!TextUtils.isEmpty(dataString) && dataString.contains("unidispatch/login_page_test") && !TbadkCoreApplication.isLogin()) {
                    sendMessage(new CustomMessage(2002001, new LoginActivityConfig(this)));
                }
                if (TextUtils.isEmpty(dataString) || !dataString.contains("unidispatch/video_middle_page_qa")) {
                    str = "video_url";
                    str2 = "video_thumbnail_url";
                    str3 = "author_portrait";
                } else {
                    Uri parse4 = Uri.parse(dataString);
                    String queryParameter15 = parse4.getQueryParameter(BdUniDispatchSchemeController.PARAM_TID);
                    String queryParameter16 = parse4.getQueryParameter(BdUniDispatchSchemeController.PARAM_FORUM_ID);
                    String queryParameter17 = parse4.getQueryParameter("title");
                    parse4.getQueryParameter("author_name");
                    parse4.getQueryParameter("author_nick_name");
                    parse4.getQueryParameter("author_is_god");
                    parse4.getQueryParameter("author_is_bigv");
                    parse4.getQueryParameter("author_portrait");
                    str3 = "author_portrait";
                    String queryParameter18 = parse4.getQueryParameter("video_thumbnail_url");
                    String queryParameter19 = parse4.getQueryParameter("video_url");
                    str = "video_url";
                    ArrayList arrayList2 = new ArrayList();
                    str2 = "video_thumbnail_url";
                    VideoItemData videoItemData2 = new VideoItemData();
                    videoItemData2.thread_id = queryParameter15;
                    videoItemData2.forum_id = queryParameter16;
                    videoItemData2.title = queryParameter17;
                    videoItemData2.thumbnail_url = queryParameter18;
                    videoItemData2.video_url = queryParameter19;
                    arrayList2.add(videoItemData2);
                    VideoPlayActivityConfig videoPlayActivityConfig = new VideoPlayActivityConfig(this, arrayList2, "from_nani_video", VideoMiddlePageActivityConfig.FROM_SCHEME_QA);
                    videoPlayActivityConfig.setUri(intent.getData());
                    videoPlayActivityConfig.setUri(intent.getData());
                    sendMessage(new CustomMessage(2002001, videoPlayActivityConfig));
                }
                if (TextUtils.isEmpty(dataString) || !dataString.contains("unidispatch/video_middle_light_page_qa")) {
                    str4 = str3;
                    str5 = str2;
                } else {
                    Uri parse5 = Uri.parse(dataString);
                    String queryParameter20 = parse5.getQueryParameter(BdUniDispatchSchemeController.PARAM_TID);
                    String queryParameter21 = parse5.getQueryParameter(BdUniDispatchSchemeController.PARAM_FORUM_ID);
                    String queryParameter22 = parse5.getQueryParameter("title");
                    parse5.getQueryParameter("author_name");
                    parse5.getQueryParameter("author_nick_name");
                    parse5.getQueryParameter("author_is_god");
                    parse5.getQueryParameter("author_is_bigv");
                    str4 = str3;
                    parse5.getQueryParameter(str4);
                    str5 = str2;
                    String queryParameter23 = parse5.getQueryParameter(str5);
                    String queryParameter24 = parse5.getQueryParameter(str);
                    ArrayList arrayList3 = new ArrayList();
                    VideoItemData videoItemData3 = new VideoItemData();
                    videoItemData3.thread_id = queryParameter20;
                    videoItemData3.forum_id = queryParameter21;
                    videoItemData3.title = queryParameter22;
                    videoItemData3.thumbnail_url = queryParameter23;
                    videoItemData3.video_url = queryParameter24;
                    arrayList3.add(videoItemData3);
                    VideoPlayActivityConfig videoPlayActivityConfig2 = new VideoPlayActivityConfig(this, arrayList3, "from_nani_video", VideoMiddlePageActivityConfig.FROM_SCHEME_QA);
                    videoPlayActivityConfig2.setUri(intent.getData());
                    sendMessage(new CustomMessage(2002001, videoPlayActivityConfig2));
                }
                if (!TextUtils.isEmpty(dataString) && dataString.contains("unidispatch/video_middle_vertical_page_qa")) {
                    Uri parse6 = Uri.parse(dataString);
                    String queryParameter25 = parse6.getQueryParameter(BdUniDispatchSchemeController.PARAM_TID);
                    String queryParameter26 = parse6.getQueryParameter(BdUniDispatchSchemeController.PARAM_FORUM_ID);
                    String queryParameter27 = parse6.getQueryParameter("title");
                    String queryParameter28 = parse6.getQueryParameter("author_uid");
                    String queryParameter29 = parse6.getQueryParameter("author_name");
                    String queryParameter30 = parse6.getQueryParameter("author_nick_name");
                    String queryParameter31 = parse6.getQueryParameter(str4);
                    String queryParameter32 = parse6.getQueryParameter(str5);
                    String queryParameter33 = parse6.getQueryParameter(str);
                    ArrayList arrayList4 = new ArrayList();
                    VideoItemData videoItemData4 = new VideoItemData();
                    videoItemData4.thread_id = queryParameter25;
                    videoItemData4.forum_id = queryParameter26;
                    videoItemData4.title = queryParameter27;
                    UserItemData userItemData = new UserItemData();
                    userItemData.user_id = queryParameter28;
                    userItemData.user_name = queryParameter29;
                    userItemData.name_show = queryParameter30;
                    userItemData.portrait = queryParameter31;
                    videoItemData4.author_info = userItemData;
                    videoItemData4.thumbnail_url = queryParameter32;
                    videoItemData4.video_url = queryParameter33;
                    arrayList4.add(videoItemData4);
                    VideoPlayActivityConfig videoPlayActivityConfig3 = new VideoPlayActivityConfig(this, arrayList4, "from_nani_video", VideoMiddlePageActivityConfig.FROM_SCHEME_QA);
                    videoPlayActivityConfig3.setParamIsVertail(true);
                    videoPlayActivityConfig3.setUri(intent.getData());
                    sendMessage(new CustomMessage(2002001, videoPlayActivityConfig3));
                }
                if (!TextUtils.isEmpty(dataString) && dataString.startsWith("tiebaclient://passlogin")) {
                    LoginActivityConfig loginActivityConfig = new LoginActivityConfig(this);
                    loginActivityConfig.setAutoLogin(dataString);
                    sendMessage(new CustomMessage(2002001, loginActivityConfig));
                    mh4.x().M(true);
                }
                if (!TextUtils.isEmpty(dataString) && dataString.contains("unidispatch/voiceRoom")) {
                    try {
                        Uri parse7 = Uri.parse(dataString);
                        HashMap hashMap4 = new HashMap();
                        for (String str7 : parse7.getQueryParameterNames()) {
                            hashMap4.put(str7, parse7.getQueryParameter(str7));
                        }
                        if (hashMap4.containsKey("room_id")) {
                            ((j45) ServiceManager.getService(j45.a.a())).a(TbadkCoreApplication.getInst().getCurrentPageContext(this), jg.g((String) hashMap4.get("room_id"), 0L));
                        }
                    } catch (Exception unused) {
                        if (BdBaseApplication.getInst().isDebugMode()) {
                            BdLog.e("Yuyinfang schema parse exception");
                        }
                    }
                }
                if (!TextUtils.isEmpty(dataString) && dataString.contains("unidispatch/searchResultPage")) {
                    String queryParameter34 = Uri.parse(dataString).getQueryParameter(BdUniDispatchSchemeController.PARAM_QUERY);
                    IntentConfig intentConfig = new IntentConfig(this);
                    if (!StringUtils.isNull(queryParameter34)) {
                        intentConfig.getIntent().putExtra(IntentConfig.SEARCH_PAGE_QUERY_CONTENT_KEY, queryParameter34);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2015003, intentConfig));
                    } else {
                        sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
                    }
                }
                if (!TextUtils.isEmpty(dataString) && dataString.contains("unidispatch/videoTopicPage")) {
                    Uri parse8 = Uri.parse(dataString);
                    String queryParameter35 = parse8.getQueryParameter("topic_id");
                    String queryParameter36 = parse8.getQueryParameter(IntentConfig.TOPIC_NAME);
                    String queryParameter37 = parse8.getQueryParameter("is_video_topic");
                    if (!TextUtils.isEmpty(queryParameter35)) {
                        new HotTopicActivityConfig(getPageContext().getPageActivity()).createNormalConfig(queryParameter35, queryParameter36, queryParameter37, null).start();
                    }
                }
                if (!TextUtils.isEmpty(dataString) && dataString.contains(UrlSchemaHelper.SCHEMA_TYPE_HOT_TOPIC_RANK_LIST)) {
                    new HotRanklistActivityConfig(this).createNormalConfig("default", "all").start();
                }
                if (TextUtils.isEmpty(dataString)) {
                    return;
                }
                if (dataString.contains("tbmaintab://tieba.baidu.com") || dataString.contains(NewUrlSchemaHelper.Jump.JUMP_TO_VIDEO_SQUARE) || dataString.contains(UrlSchemaHelper.SCHEMA_TYPE_TB_CLIENT) || dataString.contains(UrlSchemaHelper.SCHEMA_LIVE_SDK) || dataString.contains(UrlSchemaHelper.SCHEMA_CHUSHOU_LIVE_SDK) || dataString.contains(UrlSchemaHelper.SCHEMA_TYPE_TB_CLIENT_ZM) || dataString.contains(UrlSchemaHelper.SCHEMA_TYPE_TB_LAUNCH) || dataString.contains("com.baidu.tieba://unidispatch/homepage") || dataString.contains("com.baidu.tieba://unidispatch/activitypage") || dataString.contains("com.baidu.tieba://unidispatch/minePage") || dataString.contains("com.baidu.tieba://unidispatch/messageCenter") || dataString.contains("com.baidu.tieba://unidispatch/enterforum") || dataString.contains("com.baidu.tieba://unidispatch/recommendforum") || dataString.contains("com.baidu.tieba://deeplink") || dataString.contains("com.baidu.tieba://unidispatch/videotab") || dataString.contains("com.baidu.tieba://unidispatch/hometab")) {
                    l97.E(dataString);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(TbadkCoreApplication.getInst()).createUriCfg(intent.getData())));
                }
            }
        }
    }

    private void clearClipBoardIfNeed(Uri uri) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, this, uri) == null) && uri != null && BdUniDispatchSchemeController.isUniScheme(uri)) {
            String queryParameter = uri.getQueryParameter("obj_locate");
            if (TextUtils.isEmpty(queryParameter) || !queryParameter.startsWith("mdp")) {
                return;
            }
            UtilHelper.clearClipBoard();
        }
    }

    private void parserWiseSampleId(Uri uri) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, this, uri) == null) || uri == null) {
            return;
        }
        ib5.d(uri.getQueryParameter(TiebaStatic.Params.WISE_SAMPLE_ID));
    }

    private void setDayOrDarkSkin() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) || x8.g().i("MainTabActivity")) {
            return;
        }
        int loadInt = TbadkSettings.getInst().loadInt("skin_", 0);
        if (loadInt != 1) {
            SkinManager.setDayOrDarkSkinTypeWithSystemMode(false, true);
            return;
        }
        TbadkCoreApplication.getInst().setSkinTypeValue(loadInt);
        TbadkCoreApplication.getInst().SendSkinTypeBroadcast(loadInt);
    }

    private void setSearchSource(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65541, this, str) == null) || StringUtils.isNull(str)) {
            return;
        }
        String queryParameter = Uri.parse(str).getQueryParameter(BdUniDispatchSchemeController.PARAM_SOURCE);
        if (StringUtils.isNull(queryParameter)) {
            return;
        }
        TbSingleton.getInstance().setFromWhichSearchSource(queryParameter);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.repackage.f75
    public List<String> getCurrentPageSourceKeyList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? getIntent().getStringArrayListExtra("obj_source") : (List) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.PUSH_SCHEME_MID_ACTIVITY_ONCREATE_START_STAMP_KEY);
            if (TbadkCoreApplication.getInst().getStartType() == 2) {
                q25.a = true;
            }
            l97.o = true;
            kr4.v(this);
            super.onCreate(bundle);
            setDayOrDarkSkin();
            if (PermissionUtil.isAgreePrivacyPolicy()) {
                checkSchema(getIntent());
            }
            finish();
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.PUSH_SCHEME_MID_ACTIVITY_ONCREATE_END_STAMP_KEY);
        }
    }
}
