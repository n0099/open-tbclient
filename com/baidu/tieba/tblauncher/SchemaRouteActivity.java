package com.baidu.tieba.tblauncher;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.d.a.b;
import c.a.r0.a.d;
import c.a.r0.a.g;
import c.a.r0.a.w;
import c.a.r0.d1.i;
import c.a.s0.v3.j0.n;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.tbadk.BaseActivity;
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
import com.baidu.tbadk.core.atomData.VideoMiddlePageLightActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.atomData.VideoRecommentPlayActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.schemeaction.SchemeActionManager;
import com.baidu.tbadk.core.util.schemeaction.SchemeActionParser;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import com.baidu.tieba.video.UserItemData;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes12.dex */
public class SchemaRouteActivity extends BaseActivity {
    public static /* synthetic */ Interceptable $ic;
    public static String targetSchemeAction;
    public transient /* synthetic */ FieldHolder $fh;
    public final g.b mOnSchemeParsedCallback;

    /* loaded from: classes12.dex */
    public class a implements g.b {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = schemaRouteActivity;
        }

        @Override // c.a.r0.a.g.b
        public void onCallBack(HashMap<String, Object> hashMap) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, hashMap) == null) && hashMap != null && (hashMap.get(g.B) instanceof String)) {
                TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(this.a.getActivity(), null, (String) hashMap.get(g.B), true);
                tbWebViewActivityConfig.setIsFromSchema(true);
                tbWebViewActivityConfig.setUri((Uri) hashMap.get(g.P));
                this.a.sendMessage(new CustomMessage(2002001, tbWebViewActivityConfig));
            }
        }
    }

    public SchemaRouteActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mOnSchemeParsedCallback = new a(this);
    }

    private void checkSchema(Intent intent) {
        Object obj;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, this, intent) == null) || intent == null) {
            return;
        }
        c.a.r0.s.z.a.o(intent.getDataString(), false);
        clearClipBoardIfNeed(intent.getData());
        parserWiseSampleId(intent.getData());
        String dataString = intent.getDataString();
        UtilHelper.clearClipBoardBySchemaParam(dataString);
        w.e(intent.getData());
        w.c(intent.getData());
        GrowthStatsUtil.statisticChannel(GrowthStatsUtil.SPLASH_SOURCE.THIRD_PARTY, dataString);
        if (!TextUtils.isEmpty(dataString) && SchemeActionParser.isTieBaAppSchemeHeader(dataString)) {
            d.y().N(true);
            if (!b.g().i("MainTabActivity")) {
                targetSchemeAction = dataString;
                sendMessage(new CustomMessage(2002001, new LogoActivityConfig((Context) getActivity(), false)));
                return;
            }
            SchemeActionManager.getInstance().doSchemeAction(getPageContext(), dataString);
        } else if (!TextUtils.isEmpty(dataString) && (dataString.contains("tbfrs") || dataString.contains("unidispatch/frs"))) {
            FrsActivityConfig frsActivityConfig = new FrsActivityConfig(getActivity());
            frsActivityConfig.setUri(intent.getData());
            sendMessage(new CustomMessage(2003000, frsActivityConfig));
            d.y().N(true);
        } else if (!TextUtils.isEmpty(dataString) && (dataString.contains("tbpb") || dataString.contains("unidispatch/pb"))) {
            if ("tbpb://tieba.baidu.com".equals(dataString)) {
                if (b.g().i("MainTabActivity")) {
                    return;
                }
                sendMessage(new CustomMessage(2002001, new LogoActivityConfig((Context) getActivity(), false)));
                return;
            }
            String queryParameter = intent.getData().getQueryParameter("obj_param1");
            if (!g.g0.equals(queryParameter) && !"2".equals(queryParameter)) {
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
            d.y().N(true);
        } else if (!TextUtils.isEmpty(dataString) && dataString.contains("tbwebview")) {
            Uri data = intent.getData();
            if (g.c(data)) {
                g.b().j(dataString, data, this.mOnSchemeParsedCallback);
            } else {
                TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(getActivity());
                tbWebViewActivityConfig.setUri(intent.getData());
                sendMessage(new CustomMessage(2002001, tbWebViewActivityConfig));
            }
            d.y().N(true);
        } else if (!TextUtils.isEmpty(dataString) && (dataString.contains("tbtopicdetail") || dataString.contains("unidispatch/topicdetail"))) {
            TopicDetailActivityConfig topicDetailActivityConfig = new TopicDetailActivityConfig(getActivity());
            topicDetailActivityConfig.setUri(intent.getData());
            sendMessage(new CustomMessage(2002001, topicDetailActivityConfig));
            d.y().N(true);
        } else if (!TextUtils.isEmpty(dataString) && (dataString.contains("tbusercenter") || dataString.contains("unidispatch/usercenter") || dataString.contains("usercenter"))) {
            PersonPolymericActivityConfig personPolymericActivityConfig = new PersonPolymericActivityConfig(getActivity());
            personPolymericActivityConfig.setUri(intent.getData());
            sendMessage(new CustomMessage(2002001, personPolymericActivityConfig));
            d.y().N(true);
        } else if (!TextUtils.isEmpty(dataString) && dataString.contains(UrlSchemaHelper.FROM_FORUM_SQUARE)) {
            ForumSquareActivityConfig forumSquareActivityConfig = new ForumSquareActivityConfig(getActivity());
            forumSquareActivityConfig.setUri(intent.getData());
            sendMessage(new CustomMessage(2002001, forumSquareActivityConfig));
            d.y().N(true);
        } else if (!TextUtils.isEmpty(dataString) && dataString.contains("unidispatch/hotuserrank")) {
            HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(getActivity());
            hotUserRankActivityConfig.setUri(intent.getData());
            sendMessage(new CustomMessage(2002001, hotUserRankActivityConfig));
            d.y().N(true);
        } else if (!TextUtils.isEmpty(dataString) && (dataString.contains("unidispatch/openapp") || dataString.contains("donothing"))) {
            if (!b.g().i("MainTabActivity")) {
                sendMessage(new CustomMessage(2002001, new LogoActivityConfig((Context) getActivity(), false)));
            }
            d.y().N(true);
        } else {
            if (!TextUtils.isEmpty(dataString)) {
                if (dataString.contains(g.f11953b + g.f11962k)) {
                    Uri parse = Uri.parse(dataString);
                    String queryParameter3 = parse.getQueryParameter(g.K);
                    String queryParameter4 = parse.getQueryParameter(g.L);
                    UrlManager.getInstance().dealOneLink(getPageContext(), new String[]{"tiebachushou://liveroom?roomid=" + queryParameter4 + "&livetype=" + queryParameter3});
                    d.y().N(true);
                    return;
                }
            }
            if (!TextUtils.isEmpty(dataString)) {
                if (dataString.contains(g.f11953b + g.l)) {
                    String queryParameter5 = Uri.parse(dataString).getQueryParameter(g.M);
                    if (queryParameter5 != null) {
                        UrlManager.getInstance().dealOneLink(getPageContext(), new String[]{new String(Base64.decode(queryParameter5.getBytes(), 2))});
                        d.y().N(true);
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
                d.y().N(true);
            } else if (!TextUtils.isEmpty(dataString) && dataString.startsWith(UrlSchemaHelper.SCHEMA_LIVE_MY_CONCERN_LIST)) {
                MainTabActivityConfig mainTabActivityConfig = new MainTabActivityConfig(this);
                mainTabActivityConfig.setTargetScheme(dataString);
                MessageManager.getInstance().sendMessage(new CustomMessage(2015002, mainTabActivityConfig));
            } else {
                if (!TextUtils.isEmpty(dataString)) {
                    if (dataString.contains(g.f11953b + g.q)) {
                        Anniversary18thActivityConfig.open(this);
                        return;
                    }
                }
                if (!TextUtils.isEmpty(dataString) && dataString.contains("unidispatch/forumRuleDetail")) {
                    sendMessage(new CustomMessage(2002001, new ForumRulesShowActivityConfig(this, Uri.parse(dataString).getQueryParameter(g.Q), ForumRulesShowActivityConfig.FORUM_RULE_H5_FROM_SHOW)));
                }
                if (!TextUtils.isEmpty(dataString) && dataString.contains("/categorylist")) {
                    Uri parse2 = Uri.parse(dataString);
                    String queryParameter6 = parse2.getQueryParameter(g.S);
                    String queryParameter7 = parse2.getQueryParameter(g.X);
                    String queryParameter8 = parse2.getQueryParameter(g.T);
                    String queryParameter9 = parse2.getQueryParameter(g.U);
                    String queryParameter10 = parse2.getQueryParameter(g.V);
                    String queryParameter11 = parse2.getQueryParameter(g.W);
                    HashMap hashMap = new HashMap();
                    hashMap.put("item_id", queryParameter6);
                    hashMap.put("tab_id", queryParameter7);
                    hashMap.put("sort_type", queryParameter8);
                    hashMap.put("rank_type", queryParameter9);
                    hashMap.put("rank_code", queryParameter10);
                    hashMap.put("home_tab_name", queryParameter11);
                    sendMessage(new CustomMessage(2002015, new n(this, "ItemRecommendList", hashMap)));
                }
                if (!TextUtils.isEmpty(dataString) && dataString.contains("/itemDetailsPage")) {
                    Uri parse3 = Uri.parse(dataString);
                    String queryParameter12 = parse3.getQueryParameter(g.a0);
                    if (!StringUtils.isNull(queryParameter12)) {
                        setSearchSource(dataString);
                        String str8 = "com.baidu.tieba://unidispatch/itemDetailsPage?name=" + queryParameter12 + "&from=" + FrsActivityConfig.FRS_FROM_ITEM;
                        FrsActivityConfig frsActivityConfig2 = new FrsActivityConfig(getActivity());
                        frsActivityConfig2.setUri(Uri.parse(str8));
                        sendMessage(new CustomMessage(2003000, frsActivityConfig2));
                        d.y().N(true);
                    } else {
                        String queryParameter13 = parse3.getQueryParameter(g.S);
                        HashMap hashMap2 = new HashMap();
                        hashMap2.put("itemID", String.valueOf(queryParameter13));
                        sendMessage(new CustomMessage(2002015, new n(this, "GameItemDetailsPage", hashMap2)));
                    }
                }
                if (!TextUtils.isEmpty(dataString) && dataString.contains("unidispatch/item") && !dataString.contains("/itemDetailsPage")) {
                    String queryParameter14 = Uri.parse(dataString).getQueryParameter(g.R);
                    HashMap hashMap3 = new HashMap();
                    hashMap3.put("itemID", String.valueOf(queryParameter14));
                    sendMessage(new CustomMessage(2002015, new n(this, "GameItemDetailsPage", hashMap3)));
                }
                if (!TextUtils.isEmpty(dataString) && dataString.contains("unidispatch/login_page_test") && !TbadkCoreApplication.isLogin()) {
                    sendMessage(new CustomMessage(2002001, new LoginActivityConfig(this)));
                }
                if (TextUtils.isEmpty(dataString) || !dataString.contains("unidispatch/video_middle_page_qa")) {
                    obj = "room_id";
                    str = "author_is_bigv";
                    str2 = "video_url";
                    str3 = "author_portrait";
                    str4 = "author_name";
                } else {
                    Uri parse4 = Uri.parse(dataString);
                    String queryParameter15 = parse4.getQueryParameter(g.u);
                    String queryParameter16 = parse4.getQueryParameter(g.Q);
                    String queryParameter17 = parse4.getQueryParameter("title");
                    obj = "room_id";
                    String queryParameter18 = parse4.getQueryParameter("author_name");
                    str4 = "author_name";
                    String queryParameter19 = parse4.getQueryParameter("author_nick_name");
                    String queryParameter20 = parse4.getQueryParameter("author_is_god");
                    String queryParameter21 = parse4.getQueryParameter("author_is_bigv");
                    str = "author_is_bigv";
                    String queryParameter22 = parse4.getQueryParameter("author_portrait");
                    str3 = "author_portrait";
                    String queryParameter23 = parse4.getQueryParameter("video_thumbnail_url");
                    String queryParameter24 = parse4.getQueryParameter("video_url");
                    str2 = "video_url";
                    VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
                    videoSerializeVideoThreadInfo.threadId = queryParameter15;
                    videoSerializeVideoThreadInfo.forumId = queryParameter16;
                    videoSerializeVideoThreadInfo.title = queryParameter17;
                    VideoSerializeVideoThreadInfo.VideoAggregationAuthorData videoAggregationAuthorData = new VideoSerializeVideoThreadInfo.VideoAggregationAuthorData();
                    videoSerializeVideoThreadInfo.author = videoAggregationAuthorData;
                    videoAggregationAuthorData.userName = queryParameter18;
                    videoAggregationAuthorData.userNickname = queryParameter19;
                    if (!StringUtils.isNull(queryParameter20)) {
                        videoSerializeVideoThreadInfo.author.isGod = Boolean.parseBoolean(queryParameter20);
                    }
                    if (!StringUtils.isNull(queryParameter21)) {
                        videoSerializeVideoThreadInfo.author.isBigV = Boolean.parseBoolean(queryParameter21);
                    }
                    videoSerializeVideoThreadInfo.author.portrait = queryParameter22;
                    VideoSerializeVideoThreadInfo.VideoAggregationVideoData videoAggregationVideoData = new VideoSerializeVideoThreadInfo.VideoAggregationVideoData();
                    videoSerializeVideoThreadInfo.video = videoAggregationVideoData;
                    videoAggregationVideoData.thumbnailUrl = queryParameter23;
                    videoAggregationVideoData.videoUrl = queryParameter24;
                    VideoMiddlePageActivityConfig videoMiddlePageActivityConfig = new VideoMiddlePageActivityConfig(this, VideoMiddlePageActivityConfig.FROM_SCHEME_QA, queryParameter15, videoSerializeVideoThreadInfo);
                    videoMiddlePageActivityConfig.setUri(intent.getData());
                    sendMessage(new CustomMessage(2002001, videoMiddlePageActivityConfig));
                }
                if (TextUtils.isEmpty(dataString) || !dataString.contains("unidispatch/video_middle_light_page_qa")) {
                    str5 = "video_thumbnail_url";
                    str6 = str4;
                    str7 = "author_nick_name";
                } else {
                    Uri parse5 = Uri.parse(dataString);
                    String queryParameter25 = parse5.getQueryParameter(g.u);
                    String queryParameter26 = parse5.getQueryParameter(g.Q);
                    String queryParameter27 = parse5.getQueryParameter("title");
                    str6 = str4;
                    String queryParameter28 = parse5.getQueryParameter(str6);
                    String queryParameter29 = parse5.getQueryParameter("author_nick_name");
                    String queryParameter30 = parse5.getQueryParameter("author_is_god");
                    String queryParameter31 = parse5.getQueryParameter(str);
                    str7 = "author_nick_name";
                    String queryParameter32 = parse5.getQueryParameter(str3);
                    String queryParameter33 = parse5.getQueryParameter("video_thumbnail_url");
                    str5 = "video_thumbnail_url";
                    String queryParameter34 = parse5.getQueryParameter(str2);
                    VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo2 = new VideoSerializeVideoThreadInfo();
                    videoSerializeVideoThreadInfo2.threadId = queryParameter25;
                    videoSerializeVideoThreadInfo2.forumId = queryParameter26;
                    videoSerializeVideoThreadInfo2.title = queryParameter27;
                    VideoSerializeVideoThreadInfo.VideoAggregationAuthorData videoAggregationAuthorData2 = new VideoSerializeVideoThreadInfo.VideoAggregationAuthorData();
                    videoSerializeVideoThreadInfo2.author = videoAggregationAuthorData2;
                    videoAggregationAuthorData2.userName = queryParameter28;
                    videoAggregationAuthorData2.userNickname = queryParameter29;
                    if (!StringUtils.isNull(queryParameter30)) {
                        videoSerializeVideoThreadInfo2.author.isGod = Boolean.parseBoolean(queryParameter30);
                    }
                    if (!StringUtils.isNull(queryParameter31)) {
                        videoSerializeVideoThreadInfo2.author.isBigV = Boolean.parseBoolean(queryParameter31);
                    }
                    videoSerializeVideoThreadInfo2.author.portrait = queryParameter32;
                    VideoSerializeVideoThreadInfo.VideoAggregationVideoData videoAggregationVideoData2 = new VideoSerializeVideoThreadInfo.VideoAggregationVideoData();
                    videoSerializeVideoThreadInfo2.video = videoAggregationVideoData2;
                    videoAggregationVideoData2.thumbnailUrl = queryParameter33;
                    videoAggregationVideoData2.videoUrl = queryParameter34;
                    VideoMiddlePageLightActivityConfig videoMiddlePageLightActivityConfig = new VideoMiddlePageLightActivityConfig(this, VideoMiddlePageActivityConfig.FROM_SCHEME_QA, queryParameter25, videoSerializeVideoThreadInfo2);
                    videoMiddlePageLightActivityConfig.setUri(intent.getData());
                    sendMessage(new CustomMessage(2002001, videoMiddlePageLightActivityConfig));
                }
                if (!TextUtils.isEmpty(dataString) && dataString.contains("unidispatch/video_middle_vertical_page_qa")) {
                    Uri parse6 = Uri.parse(dataString);
                    String queryParameter35 = parse6.getQueryParameter(g.u);
                    String queryParameter36 = parse6.getQueryParameter(g.Q);
                    String queryParameter37 = parse6.getQueryParameter("title");
                    String queryParameter38 = parse6.getQueryParameter("author_uid");
                    String queryParameter39 = parse6.getQueryParameter(str6);
                    String queryParameter40 = parse6.getQueryParameter(str7);
                    String queryParameter41 = parse6.getQueryParameter(str3);
                    String queryParameter42 = parse6.getQueryParameter(str5);
                    String queryParameter43 = parse6.getQueryParameter(str2);
                    ArrayList arrayList2 = new ArrayList();
                    VideoItemData videoItemData2 = new VideoItemData();
                    videoItemData2.thread_id = queryParameter35;
                    videoItemData2.forum_id = queryParameter36;
                    videoItemData2.title = queryParameter37;
                    UserItemData userItemData = new UserItemData();
                    userItemData.user_id = queryParameter38;
                    userItemData.user_name = queryParameter39;
                    userItemData.name_show = queryParameter40;
                    userItemData.portrait = queryParameter41;
                    videoItemData2.author_info = userItemData;
                    videoItemData2.thumbnail_url = queryParameter42;
                    videoItemData2.video_url = queryParameter43;
                    arrayList2.add(videoItemData2);
                    VideoPlayActivityConfig videoPlayActivityConfig = new VideoPlayActivityConfig(this, arrayList2, "from_nani_video", VideoMiddlePageActivityConfig.FROM_SCHEME_QA);
                    videoPlayActivityConfig.setParamIsVertail(true);
                    videoPlayActivityConfig.setUri(intent.getData());
                    sendMessage(new CustomMessage(2002001, videoPlayActivityConfig));
                }
                if (!TextUtils.isEmpty(dataString) && dataString.startsWith("tiebaclient://passlogin")) {
                    LoginActivityConfig loginActivityConfig = new LoginActivityConfig(this);
                    loginActivityConfig.setAutoLogin(dataString);
                    sendMessage(new CustomMessage(2002001, loginActivityConfig));
                    d.y().N(true);
                }
                if (!TextUtils.isEmpty(dataString) && dataString.contains("unidispatch/voiceRoom")) {
                    try {
                        Uri parse7 = Uri.parse(dataString);
                        HashMap hashMap4 = new HashMap();
                        for (String str9 : parse7.getQueryParameterNames()) {
                            hashMap4.put(str9, parse7.getQueryParameter(str9));
                        }
                        Object obj2 = obj;
                        if (hashMap4.containsKey(obj2)) {
                            ((c.a.r0.j0.c.a) ServiceManager.getService(c.a.r0.j0.c.a.a.a())).a(TbadkCoreApplication.getInst().getCurrentPageContext(this), c.a.d.f.m.b.g((String) hashMap4.get(obj2), 0L));
                        }
                    } catch (Exception unused) {
                        if (BdBaseApplication.getInst().isDebugMode()) {
                            BdLog.e("Yuyinfang schema parse exception");
                        }
                    }
                }
                if (!TextUtils.isEmpty(dataString) && dataString.contains("unidispatch/searchResultPage")) {
                    String queryParameter44 = Uri.parse(dataString).getQueryParameter(g.Y);
                    IntentConfig intentConfig = new IntentConfig(this);
                    if (!StringUtils.isNull(queryParameter44)) {
                        intentConfig.getIntent().putExtra(IntentConfig.SEARCH_PAGE_QUERY_CONTENT_KEY, queryParameter44);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2015003, intentConfig));
                    } else {
                        sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
                    }
                }
                if (!TextUtils.isEmpty(dataString) && dataString.contains("unidispatch/videoTopicPage")) {
                    Uri parse8 = Uri.parse(dataString);
                    String queryParameter45 = parse8.getQueryParameter("topic_id");
                    String queryParameter46 = parse8.getQueryParameter(IntentConfig.TOPIC_NAME);
                    String queryParameter47 = parse8.getQueryParameter("is_video_topic");
                    if (!TextUtils.isEmpty(queryParameter45)) {
                        new HotTopicActivityConfig(getPageContext().getPageActivity()).createNormalConfig(queryParameter45, queryParameter46, queryParameter47, null).start();
                    }
                }
                if (TextUtils.isEmpty(dataString) || !dataString.contains(UrlSchemaHelper.SCHEMA_TYPE_HOT_TOPIC_RANK_LIST)) {
                    return;
                }
                new HotRanklistActivityConfig(this).createNormalConfig("default", "all").start();
            }
        }
    }

    private void clearClipBoardIfNeed(Uri uri) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, this, uri) == null) && uri != null && g.c(uri)) {
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
        i.d(uri.getQueryParameter(TiebaStatic.Params.WISE_SAMPLE_ID));
    }

    private void setDayOrDarkSkin() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) || b.g().i("MainTabActivity")) {
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
        String queryParameter = Uri.parse(str).getQueryParameter(g.Z);
        if (StringUtils.isNull(queryParameter)) {
            return;
        }
        TbSingleton.getInstance().setFromWhichSearchSource(queryParameter);
    }

    @Override // com.baidu.tbadk.BaseActivity, c.a.r0.p0.a
    public List<String> getCurrentPageSourceKeyList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? getIntent().getStringArrayListExtra("obj_source") : (List) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            if (TbadkCoreApplication.getInst().getStartType() == 2) {
                c.a.r0.b0.a.a = true;
            }
            super.onCreate(bundle);
            setDayOrDarkSkin();
            checkSchema(getIntent());
            finish();
        }
    }
}
