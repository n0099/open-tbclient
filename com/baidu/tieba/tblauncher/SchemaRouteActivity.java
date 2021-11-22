package com.baidu.tieba.tblauncher;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import b.a.e.a.b;
import b.a.q0.a.d;
import b.a.q0.a.g;
import b.a.q0.a.w;
import b.a.r0.m3.j0.n;
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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumRulesShowActivityConfig;
import com.baidu.tbadk.core.atomData.ForumSquareActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
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
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.core.util.UtilHelper;
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
/* loaded from: classes9.dex */
public class SchemaRouteActivity extends BaseActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final g.b mOnSchemeParsedCallback;

    /* loaded from: classes9.dex */
    public class a implements g.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SchemaRouteActivity f55349a;

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
            this.f55349a = schemaRouteActivity;
        }

        @Override // b.a.q0.a.g.b
        public void onCallBack(HashMap<String, Object> hashMap) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, hashMap) == null) && hashMap != null && (hashMap.get(g.A) instanceof String)) {
                TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(this.f55349a.getActivity(), null, (String) hashMap.get(g.A), true);
                tbWebViewActivityConfig.setIsFromSchema(true);
                tbWebViewActivityConfig.setUri((Uri) hashMap.get(g.O));
                this.f55349a.sendMessage(new CustomMessage(2002001, tbWebViewActivityConfig));
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
        b.a.q0.s.y.a.d(intent.getDataString(), false);
        clearClipBoardIfNeed(intent.getData());
        parserWiseSampleId(intent.getData());
        String dataString = intent.getDataString();
        UtilHelper.clearClipBoardBySchemaParam(dataString);
        w.e(intent.getData());
        w.c(intent.getData());
        GrowthStatsUtil.statisticChannel(GrowthStatsUtil.SPLASH_SOURCE.THIRD_PARTY, dataString);
        if (!TextUtils.isEmpty(dataString) && (dataString.contains("invoke_frs") || dataString.contains("tbfrs") || dataString.contains("unidispatch/frs"))) {
            FrsActivityConfig frsActivityConfig = new FrsActivityConfig(getActivity());
            frsActivityConfig.setUri(intent.getData());
            sendMessage(new CustomMessage(2003000, frsActivityConfig));
            d.y().M(true);
        } else if (!TextUtils.isEmpty(dataString) && (dataString.contains("tbpb") || dataString.contains("unidispatch/pb"))) {
            if ("tbpb://tieba.baidu.com".equals(dataString)) {
                if (b.g().i("MainTabActivity")) {
                    return;
                }
                sendMessage(new CustomMessage(2002001, new LogoActivityConfig((Context) getActivity(), false)));
                return;
            }
            sendMessage(new CustomMessage(2004001, PbActivityConfig.createCfgFromUri(getActivity(), intent.getData())));
            d.y().M(true);
        } else if (!TextUtils.isEmpty(dataString) && dataString.contains("tbwebview")) {
            Uri data = intent.getData();
            if (g.c(data)) {
                g.b().j(dataString, data, this.mOnSchemeParsedCallback);
            } else {
                TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(getActivity());
                tbWebViewActivityConfig.setUri(intent.getData());
                sendMessage(new CustomMessage(2002001, tbWebViewActivityConfig));
            }
            d.y().M(true);
        } else if (!TextUtils.isEmpty(dataString) && (dataString.contains("tbtopicdetail") || dataString.contains("unidispatch/topicdetail"))) {
            TopicDetailActivityConfig topicDetailActivityConfig = new TopicDetailActivityConfig(getActivity());
            topicDetailActivityConfig.setUri(intent.getData());
            sendMessage(new CustomMessage(2002001, topicDetailActivityConfig));
            d.y().M(true);
        } else if (!TextUtils.isEmpty(dataString) && (dataString.contains("tbusercenter") || dataString.contains("unidispatch/usercenter") || dataString.contains("usercenter"))) {
            PersonPolymericActivityConfig personPolymericActivityConfig = new PersonPolymericActivityConfig(getActivity());
            personPolymericActivityConfig.setUri(intent.getData());
            sendMessage(new CustomMessage(2002001, personPolymericActivityConfig));
            d.y().M(true);
        } else if (!TextUtils.isEmpty(dataString) && dataString.contains(UrlSchemaHelper.FROM_FORUM_SQUARE)) {
            ForumSquareActivityConfig forumSquareActivityConfig = new ForumSquareActivityConfig(getActivity());
            forumSquareActivityConfig.setUri(intent.getData());
            sendMessage(new CustomMessage(2002001, forumSquareActivityConfig));
            d.y().M(true);
        } else if (!TextUtils.isEmpty(dataString) && dataString.contains("unidispatch/hotuserrank")) {
            HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(getActivity());
            hotUserRankActivityConfig.setUri(intent.getData());
            sendMessage(new CustomMessage(2002001, hotUserRankActivityConfig));
            d.y().M(true);
        } else if (!TextUtils.isEmpty(dataString) && (dataString.contains("unidispatch/openapp") || dataString.contains("donothing"))) {
            if (!b.g().i("MainTabActivity")) {
                sendMessage(new CustomMessage(2002001, new LogoActivityConfig((Context) getActivity(), false)));
            }
            d.y().M(true);
        } else {
            if (!TextUtils.isEmpty(dataString)) {
                if (dataString.contains(g.f12529b + g.k)) {
                    Uri parse = Uri.parse(dataString);
                    String queryParameter = parse.getQueryParameter(g.J);
                    String queryParameter2 = parse.getQueryParameter(g.K);
                    UrlManager.getInstance().dealOneLink(getPageContext(), new String[]{"tiebachushou://liveroom?roomid=" + queryParameter2 + "&livetype=" + queryParameter});
                    d.y().M(true);
                    return;
                }
            }
            if (!TextUtils.isEmpty(dataString)) {
                if (dataString.contains(g.f12529b + g.l)) {
                    String queryParameter3 = Uri.parse(dataString).getQueryParameter(g.L);
                    if (queryParameter3 != null) {
                        UrlManager.getInstance().dealOneLink(getPageContext(), new String[]{new String(Base64.decode(queryParameter3.getBytes(), 2))});
                        d.y().M(true);
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
                d.y().M(true);
            } else if (!TextUtils.isEmpty(dataString) && dataString.startsWith(UrlSchemaHelper.SCHEMA_LIVE_MY_CONCERN_LIST)) {
                MainTabActivityConfig mainTabActivityConfig = new MainTabActivityConfig(this);
                mainTabActivityConfig.setTargetScheme(dataString);
                MessageManager.getInstance().sendMessage(new CustomMessage(2015002, mainTabActivityConfig));
            } else {
                if (!TextUtils.isEmpty(dataString) && dataString.contains("unidispatch/forumRuleDetail")) {
                    sendMessage(new CustomMessage(2002001, new ForumRulesShowActivityConfig(this, Uri.parse(dataString).getQueryParameter(g.P), ForumRulesShowActivityConfig.FORUM_RULE_H5_FROM_SHOW)));
                }
                if (!TextUtils.isEmpty(dataString) && dataString.contains("/categorylist")) {
                    Uri parse2 = Uri.parse(dataString);
                    String queryParameter4 = parse2.getQueryParameter(g.R);
                    String queryParameter5 = parse2.getQueryParameter(g.W);
                    String queryParameter6 = parse2.getQueryParameter(g.S);
                    String queryParameter7 = parse2.getQueryParameter(g.T);
                    String queryParameter8 = parse2.getQueryParameter(g.U);
                    String queryParameter9 = parse2.getQueryParameter(g.V);
                    HashMap hashMap = new HashMap();
                    hashMap.put("item_id", queryParameter4);
                    hashMap.put("tab_id", queryParameter5);
                    hashMap.put("sort_type", queryParameter6);
                    hashMap.put("rank_type", queryParameter7);
                    hashMap.put("rank_code", queryParameter8);
                    hashMap.put("home_tab_name", queryParameter9);
                    sendMessage(new CustomMessage(2002015, new n(this, "ItemRecommendList", hashMap)));
                }
                if (!TextUtils.isEmpty(dataString) && dataString.contains("/itemDetailsPage")) {
                    Uri parse3 = Uri.parse(dataString);
                    String queryParameter10 = parse3.getQueryParameter(g.Z);
                    if (!StringUtils.isNull(queryParameter10)) {
                        setSearchSource(dataString);
                        String str8 = "com.baidu.tieba://unidispatch/itemDetailsPage?name=" + queryParameter10 + "&from=" + FrsActivityConfig.FRS_FROM_ITEM;
                        FrsActivityConfig frsActivityConfig2 = new FrsActivityConfig(getActivity());
                        frsActivityConfig2.setUri(Uri.parse(str8));
                        sendMessage(new CustomMessage(2003000, frsActivityConfig2));
                        d.y().M(true);
                    } else {
                        String queryParameter11 = parse3.getQueryParameter(g.R);
                        HashMap hashMap2 = new HashMap();
                        hashMap2.put("itemID", String.valueOf(queryParameter11));
                        sendMessage(new CustomMessage(2002015, new n(this, "GameItemDetailsPage", hashMap2)));
                    }
                }
                if (!TextUtils.isEmpty(dataString) && dataString.contains("unidispatch/item") && !dataString.contains("/itemDetailsPage")) {
                    String queryParameter12 = Uri.parse(dataString).getQueryParameter(g.Q);
                    HashMap hashMap3 = new HashMap();
                    hashMap3.put("itemID", String.valueOf(queryParameter12));
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
                    String queryParameter13 = parse4.getQueryParameter(g.t);
                    String queryParameter14 = parse4.getQueryParameter(g.P);
                    String queryParameter15 = parse4.getQueryParameter("title");
                    obj = "room_id";
                    String queryParameter16 = parse4.getQueryParameter("author_name");
                    str4 = "author_name";
                    String queryParameter17 = parse4.getQueryParameter("author_nick_name");
                    String queryParameter18 = parse4.getQueryParameter("author_is_god");
                    String queryParameter19 = parse4.getQueryParameter("author_is_bigv");
                    str = "author_is_bigv";
                    String queryParameter20 = parse4.getQueryParameter("author_portrait");
                    str3 = "author_portrait";
                    String queryParameter21 = parse4.getQueryParameter("video_thumbnail_url");
                    String queryParameter22 = parse4.getQueryParameter("video_url");
                    str2 = "video_url";
                    VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
                    videoSerializeVideoThreadInfo.threadId = queryParameter13;
                    videoSerializeVideoThreadInfo.forumId = queryParameter14;
                    videoSerializeVideoThreadInfo.title = queryParameter15;
                    VideoSerializeVideoThreadInfo.VideoAggregationAuthorData videoAggregationAuthorData = new VideoSerializeVideoThreadInfo.VideoAggregationAuthorData();
                    videoSerializeVideoThreadInfo.author = videoAggregationAuthorData;
                    videoAggregationAuthorData.userName = queryParameter16;
                    videoAggregationAuthorData.userNickname = queryParameter17;
                    if (!StringUtils.isNull(queryParameter18)) {
                        videoSerializeVideoThreadInfo.author.isGod = Boolean.parseBoolean(queryParameter18);
                    }
                    if (!StringUtils.isNull(queryParameter19)) {
                        videoSerializeVideoThreadInfo.author.isBigV = Boolean.parseBoolean(queryParameter19);
                    }
                    videoSerializeVideoThreadInfo.author.portrait = queryParameter20;
                    VideoSerializeVideoThreadInfo.VideoAggregationVideoData videoAggregationVideoData = new VideoSerializeVideoThreadInfo.VideoAggregationVideoData();
                    videoSerializeVideoThreadInfo.video = videoAggregationVideoData;
                    videoAggregationVideoData.thumbnailUrl = queryParameter21;
                    videoAggregationVideoData.videoUrl = queryParameter22;
                    VideoMiddlePageActivityConfig videoMiddlePageActivityConfig = new VideoMiddlePageActivityConfig(this, VideoMiddlePageActivityConfig.FROM_SCHEME_QA, queryParameter13, videoSerializeVideoThreadInfo);
                    videoMiddlePageActivityConfig.setUri(intent.getData());
                    sendMessage(new CustomMessage(2002001, videoMiddlePageActivityConfig));
                }
                if (TextUtils.isEmpty(dataString) || !dataString.contains("unidispatch/video_middle_light_page_qa")) {
                    str5 = "video_thumbnail_url";
                    str6 = str4;
                    str7 = "author_nick_name";
                } else {
                    Uri parse5 = Uri.parse(dataString);
                    String queryParameter23 = parse5.getQueryParameter(g.t);
                    String queryParameter24 = parse5.getQueryParameter(g.P);
                    String queryParameter25 = parse5.getQueryParameter("title");
                    str6 = str4;
                    String queryParameter26 = parse5.getQueryParameter(str6);
                    String queryParameter27 = parse5.getQueryParameter("author_nick_name");
                    String queryParameter28 = parse5.getQueryParameter("author_is_god");
                    String queryParameter29 = parse5.getQueryParameter(str);
                    str7 = "author_nick_name";
                    String queryParameter30 = parse5.getQueryParameter(str3);
                    String queryParameter31 = parse5.getQueryParameter("video_thumbnail_url");
                    str5 = "video_thumbnail_url";
                    String queryParameter32 = parse5.getQueryParameter(str2);
                    VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo2 = new VideoSerializeVideoThreadInfo();
                    videoSerializeVideoThreadInfo2.threadId = queryParameter23;
                    videoSerializeVideoThreadInfo2.forumId = queryParameter24;
                    videoSerializeVideoThreadInfo2.title = queryParameter25;
                    VideoSerializeVideoThreadInfo.VideoAggregationAuthorData videoAggregationAuthorData2 = new VideoSerializeVideoThreadInfo.VideoAggregationAuthorData();
                    videoSerializeVideoThreadInfo2.author = videoAggregationAuthorData2;
                    videoAggregationAuthorData2.userName = queryParameter26;
                    videoAggregationAuthorData2.userNickname = queryParameter27;
                    if (!StringUtils.isNull(queryParameter28)) {
                        videoSerializeVideoThreadInfo2.author.isGod = Boolean.parseBoolean(queryParameter28);
                    }
                    if (!StringUtils.isNull(queryParameter29)) {
                        videoSerializeVideoThreadInfo2.author.isBigV = Boolean.parseBoolean(queryParameter29);
                    }
                    videoSerializeVideoThreadInfo2.author.portrait = queryParameter30;
                    VideoSerializeVideoThreadInfo.VideoAggregationVideoData videoAggregationVideoData2 = new VideoSerializeVideoThreadInfo.VideoAggregationVideoData();
                    videoSerializeVideoThreadInfo2.video = videoAggregationVideoData2;
                    videoAggregationVideoData2.thumbnailUrl = queryParameter31;
                    videoAggregationVideoData2.videoUrl = queryParameter32;
                    VideoMiddlePageLightActivityConfig videoMiddlePageLightActivityConfig = new VideoMiddlePageLightActivityConfig(this, VideoMiddlePageActivityConfig.FROM_SCHEME_QA, queryParameter23, videoSerializeVideoThreadInfo2);
                    videoMiddlePageLightActivityConfig.setUri(intent.getData());
                    sendMessage(new CustomMessage(2002001, videoMiddlePageLightActivityConfig));
                }
                if (!TextUtils.isEmpty(dataString) && dataString.contains("unidispatch/video_middle_vertical_page_qa")) {
                    Uri parse6 = Uri.parse(dataString);
                    String queryParameter33 = parse6.getQueryParameter(g.t);
                    String queryParameter34 = parse6.getQueryParameter(g.P);
                    String queryParameter35 = parse6.getQueryParameter("title");
                    String queryParameter36 = parse6.getQueryParameter("author_uid");
                    String queryParameter37 = parse6.getQueryParameter(str6);
                    String queryParameter38 = parse6.getQueryParameter(str7);
                    String queryParameter39 = parse6.getQueryParameter(str3);
                    String queryParameter40 = parse6.getQueryParameter(str5);
                    String queryParameter41 = parse6.getQueryParameter(str2);
                    ArrayList arrayList = new ArrayList();
                    VideoItemData videoItemData = new VideoItemData();
                    videoItemData.thread_id = queryParameter33;
                    videoItemData.forum_id = queryParameter34;
                    videoItemData.title = queryParameter35;
                    UserItemData userItemData = new UserItemData();
                    userItemData.user_id = queryParameter36;
                    userItemData.user_name = queryParameter37;
                    userItemData.name_show = queryParameter38;
                    userItemData.portrait = queryParameter39;
                    videoItemData.author_info = userItemData;
                    videoItemData.thumbnail_url = queryParameter40;
                    videoItemData.video_url = queryParameter41;
                    arrayList.add(videoItemData);
                    VideoPlayActivityConfig videoPlayActivityConfig = new VideoPlayActivityConfig(this, arrayList, "from_nani_video", VideoMiddlePageActivityConfig.FROM_SCHEME_QA);
                    videoPlayActivityConfig.setParamIsVertail(true);
                    videoPlayActivityConfig.setUri(intent.getData());
                    sendMessage(new CustomMessage(2002001, videoPlayActivityConfig));
                }
                if (!TextUtils.isEmpty(dataString) && dataString.startsWith("tiebaclient://passlogin")) {
                    LoginActivityConfig loginActivityConfig = new LoginActivityConfig(this);
                    loginActivityConfig.setAutoLogin(dataString);
                    sendMessage(new CustomMessage(2002001, loginActivityConfig));
                    d.y().M(true);
                }
                if (TextUtils.isEmpty(dataString) || !dataString.contains("unidispatch/voiceRoom")) {
                    return;
                }
                try {
                    Uri parse7 = Uri.parse(dataString);
                    HashMap hashMap4 = new HashMap();
                    for (String str9 : parse7.getQueryParameterNames()) {
                        hashMap4.put(str9, parse7.getQueryParameter(str9));
                    }
                    Object obj2 = obj;
                    if (hashMap4.containsKey(obj2)) {
                        ((b.a.q0.i0.c.a) ServiceManager.getService(b.a.q0.i0.c.a.f13386a.a())).a(TbadkCoreApplication.getInst().getCurrentPageContext(this), b.a.e.f.m.b.g((String) hashMap4.get(obj2), 0L));
                    }
                } catch (Exception unused) {
                    if (BdBaseApplication.getInst().isDebugMode()) {
                        BdLog.e("Yuyinfang schema parse exception");
                    }
                }
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
        b.a.q0.c1.g.d(uri.getQueryParameter(TiebaStatic.Params.WISE_SAMPLE_ID));
    }

    private void setSearchSource(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, str) == null) || StringUtils.isNull(str)) {
            return;
        }
        String queryParameter = Uri.parse(str).getQueryParameter(g.Y);
        if (StringUtils.isNull(queryParameter)) {
            return;
        }
        TbSingleton.getInstance().setFromWhichSearchSource(queryParameter);
    }

    @Override // com.baidu.tbadk.BaseActivity, b.a.q0.o0.a
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
                b.a.q0.b0.a.f12715a = true;
            }
            super.onCreate(bundle);
            checkSchema(getIntent());
            finish();
        }
    }
}
