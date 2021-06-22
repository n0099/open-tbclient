package com.baidu.tieba.tblauncher;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumRulesShowActivityConfig;
import com.baidu.tbadk.core.atomData.ForumSquareActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.HotUserRankActivityConfig;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
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
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import com.baidu.tieba.video.UserItemData;
import com.baidu.tieba.video.VideoItemData;
import d.a.c.a.b;
import d.a.n0.a.d;
import d.a.n0.a.g;
import d.a.n0.a.x;
import d.a.o0.e3.h0.m;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class SchemaRouteActivity extends BaseActivity {
    public final g.b mOnSchemeParsedCallback = new a();

    /* loaded from: classes5.dex */
    public class a implements g.b {
        public a() {
        }

        @Override // d.a.n0.a.g.b
        public void onCallBack(HashMap<String, Object> hashMap) {
            if (hashMap != null && (hashMap.get(g.v) instanceof String)) {
                TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(SchemaRouteActivity.this.getActivity(), null, (String) hashMap.get(g.v), true);
                tbWebViewActivityConfig.setIsFromSchema(true);
                tbWebViewActivityConfig.setUri((Uri) hashMap.get(g.I));
                SchemaRouteActivity.this.sendMessage(new CustomMessage(2002001, tbWebViewActivityConfig));
            }
        }
    }

    private void checkSchema(Intent intent) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        if (intent == null) {
            return;
        }
        clearClipBoardIfNeed(intent.getData());
        String dataString = intent.getDataString();
        UtilHelper.clearClipBoardBySchemaParam(dataString);
        x.e(intent.getData());
        x.c(intent.getData());
        if (!TextUtils.isEmpty(dataString) && (dataString.contains("invoke_frs") || dataString.contains("tbfrs") || dataString.contains("unidispatch/frs"))) {
            FrsActivityConfig frsActivityConfig = new FrsActivityConfig(getActivity());
            frsActivityConfig.setUri(intent.getData());
            sendMessage(new CustomMessage(2003000, frsActivityConfig));
            d.y().L(true);
        } else if (!TextUtils.isEmpty(dataString) && (dataString.contains("tbpb") || dataString.contains("unidispatch/pb"))) {
            if ("tbpb://tieba.baidu.com".equals(dataString)) {
                if (b.f().h("MainTabActivity")) {
                    return;
                }
                sendMessage(new CustomMessage(2002001, new LogoActivityConfig((Context) getActivity(), false)));
                return;
            }
            PbActivityConfig pbActivityConfig = new PbActivityConfig(getActivity());
            pbActivityConfig.setUri(intent.getData());
            if (dataString.contains("isLocateToComment") && dataString.contains("isLocateToComment=1")) {
                pbActivityConfig.setJumpToCommentArea(true);
            }
            sendMessage(new CustomMessage(2004001, pbActivityConfig));
            d.y().L(true);
        } else if (!TextUtils.isEmpty(dataString) && dataString.contains("tbwebview")) {
            Uri data = intent.getData();
            if (g.c(data)) {
                g.b().j(dataString, data, this.mOnSchemeParsedCallback);
            } else {
                TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(getActivity());
                tbWebViewActivityConfig.setUri(intent.getData());
                sendMessage(new CustomMessage(2002001, tbWebViewActivityConfig));
            }
            d.y().L(true);
        } else if (!TextUtils.isEmpty(dataString) && (dataString.contains("tbtopicdetail") || dataString.contains("unidispatch/topicdetail"))) {
            TopicDetailActivityConfig topicDetailActivityConfig = new TopicDetailActivityConfig(getActivity());
            topicDetailActivityConfig.setUri(intent.getData());
            sendMessage(new CustomMessage(2002001, topicDetailActivityConfig));
            d.y().L(true);
        } else if (!TextUtils.isEmpty(dataString) && (dataString.contains("tbusercenter") || dataString.contains("unidispatch/usercenter") || dataString.contains("usercenter"))) {
            PersonPolymericActivityConfig personPolymericActivityConfig = new PersonPolymericActivityConfig(getActivity());
            personPolymericActivityConfig.setUri(intent.getData());
            sendMessage(new CustomMessage(2002001, personPolymericActivityConfig));
            d.y().L(true);
        } else if (!TextUtils.isEmpty(dataString) && dataString.contains(UrlSchemaHelper.FROM_FORUM_SQUARE)) {
            ForumSquareActivityConfig forumSquareActivityConfig = new ForumSquareActivityConfig(getActivity());
            forumSquareActivityConfig.setUri(intent.getData());
            sendMessage(new CustomMessage(2002001, forumSquareActivityConfig));
            d.y().L(true);
        } else if (!TextUtils.isEmpty(dataString) && dataString.contains("unidispatch/hotuserrank")) {
            HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(getActivity());
            hotUserRankActivityConfig.setUri(intent.getData());
            sendMessage(new CustomMessage(2002001, hotUserRankActivityConfig));
            d.y().L(true);
        } else if (!TextUtils.isEmpty(dataString) && (dataString.contains("unidispatch/openapp") || dataString.contains("donothing"))) {
            if (!b.f().h("MainTabActivity")) {
                sendMessage(new CustomMessage(2002001, new LogoActivityConfig((Context) getActivity(), false)));
            }
            d.y().L(true);
        } else {
            if (!TextUtils.isEmpty(dataString)) {
                if (dataString.contains(g.f52493b + g.k)) {
                    Uri parse = Uri.parse(dataString);
                    String queryParameter = parse.getQueryParameter(g.E);
                    String queryParameter2 = parse.getQueryParameter(g.F);
                    UrlManager urlManager = UrlManager.getInstance();
                    TbPageContext<?> pageContext = getPageContext();
                    urlManager.dealOneLink(pageContext, new String[]{"tiebachushou://liveroom?roomid=" + queryParameter2 + "&livetype=" + queryParameter});
                    d.y().L(true);
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
                d.y().L(true);
                return;
            }
            if (!TextUtils.isEmpty(dataString) && dataString.contains("unidispatch/forumRuleDetail")) {
                sendMessage(new CustomMessage(2002001, new ForumRulesShowActivityConfig(this, Uri.parse(dataString).getQueryParameter(g.J), ForumRulesShowActivityConfig.FORUM_RULE_H5_FROM_SHOW)));
            }
            if (!TextUtils.isEmpty(dataString) && dataString.contains("/categorylist")) {
                Uri parse2 = Uri.parse(dataString);
                String queryParameter3 = parse2.getQueryParameter(g.L);
                String queryParameter4 = parse2.getQueryParameter(g.Q);
                String queryParameter5 = parse2.getQueryParameter(g.M);
                String queryParameter6 = parse2.getQueryParameter(g.N);
                String queryParameter7 = parse2.getQueryParameter(g.O);
                String queryParameter8 = parse2.getQueryParameter(g.P);
                HashMap hashMap = new HashMap();
                hashMap.put(LegoListActivityConfig.ITEM_ID, queryParameter3);
                hashMap.put("tab_id", queryParameter4);
                hashMap.put("sort_type", queryParameter5);
                hashMap.put("rank_type", queryParameter6);
                hashMap.put("rank_code", queryParameter7);
                hashMap.put("home_tab_name", queryParameter8);
                sendMessage(new CustomMessage(2002015, new m(this, "ItemRecommendList", hashMap)));
            }
            if (!TextUtils.isEmpty(dataString) && dataString.contains("/itemDetailsPage")) {
                String queryParameter9 = Uri.parse(dataString).getQueryParameter(g.L);
                HashMap hashMap2 = new HashMap();
                hashMap2.put("itemID", String.valueOf(queryParameter9));
                sendMessage(new CustomMessage(2002015, new m(this, "GameItemDetailsPage", hashMap2)));
            }
            if (!TextUtils.isEmpty(dataString) && dataString.contains("unidispatch/item") && !dataString.contains("/itemDetailsPage")) {
                String queryParameter10 = Uri.parse(dataString).getQueryParameter(g.K);
                HashMap hashMap3 = new HashMap();
                hashMap3.put("itemID", String.valueOf(queryParameter10));
                sendMessage(new CustomMessage(2002015, new m(this, "GameItemDetailsPage", hashMap3)));
            }
            if (!TextUtils.isEmpty(dataString) && dataString.contains("unidispatch/login_page_test") && !TbadkCoreApplication.isLogin()) {
                sendMessage(new CustomMessage(2002001, new LoginActivityConfig(this)));
            }
            if (TextUtils.isEmpty(dataString) || !dataString.contains("unidispatch/video_middle_page_qa")) {
                str = "author_is_bigv";
                str2 = "video_url";
                str3 = "author_portrait";
                str4 = "author_name";
            } else {
                Uri parse3 = Uri.parse(dataString);
                String queryParameter11 = parse3.getQueryParameter(g.o);
                String queryParameter12 = parse3.getQueryParameter(g.J);
                String queryParameter13 = parse3.getQueryParameter("title");
                String queryParameter14 = parse3.getQueryParameter("author_name");
                str4 = "author_name";
                String queryParameter15 = parse3.getQueryParameter("author_nick_name");
                String queryParameter16 = parse3.getQueryParameter("author_is_god");
                String queryParameter17 = parse3.getQueryParameter("author_is_bigv");
                str = "author_is_bigv";
                String queryParameter18 = parse3.getQueryParameter("author_portrait");
                str3 = "author_portrait";
                String queryParameter19 = parse3.getQueryParameter("video_thumbnail_url");
                String queryParameter20 = parse3.getQueryParameter("video_url");
                str2 = "video_url";
                VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
                videoSerializeVideoThreadInfo.threadId = queryParameter11;
                videoSerializeVideoThreadInfo.forumId = queryParameter12;
                videoSerializeVideoThreadInfo.title = queryParameter13;
                VideoSerializeVideoThreadInfo.VideoAggregationAuthorData videoAggregationAuthorData = new VideoSerializeVideoThreadInfo.VideoAggregationAuthorData();
                videoSerializeVideoThreadInfo.author = videoAggregationAuthorData;
                videoAggregationAuthorData.userName = queryParameter14;
                videoAggregationAuthorData.userNickname = queryParameter15;
                if (!StringUtils.isNull(queryParameter16)) {
                    videoSerializeVideoThreadInfo.author.isGod = Boolean.parseBoolean(queryParameter16);
                }
                if (!StringUtils.isNull(queryParameter17)) {
                    videoSerializeVideoThreadInfo.author.isBigV = Boolean.parseBoolean(queryParameter17);
                }
                videoSerializeVideoThreadInfo.author.portrait = queryParameter18;
                VideoSerializeVideoThreadInfo.VideoAggregationVideoData videoAggregationVideoData = new VideoSerializeVideoThreadInfo.VideoAggregationVideoData();
                videoSerializeVideoThreadInfo.video = videoAggregationVideoData;
                videoAggregationVideoData.thumbnailUrl = queryParameter19;
                videoAggregationVideoData.videoUrl = queryParameter20;
                VideoMiddlePageActivityConfig videoMiddlePageActivityConfig = new VideoMiddlePageActivityConfig(this, VideoMiddlePageActivityConfig.FROM_SCHEME_QA, queryParameter11, videoSerializeVideoThreadInfo);
                videoMiddlePageActivityConfig.setUri(intent.getData());
                sendMessage(new CustomMessage(2002001, videoMiddlePageActivityConfig));
            }
            if (TextUtils.isEmpty(dataString) || !dataString.contains("unidispatch/video_middle_light_page_qa")) {
                str5 = "video_thumbnail_url";
                str6 = str4;
                str7 = "author_nick_name";
            } else {
                Uri parse4 = Uri.parse(dataString);
                String queryParameter21 = parse4.getQueryParameter(g.o);
                String queryParameter22 = parse4.getQueryParameter(g.J);
                String queryParameter23 = parse4.getQueryParameter("title");
                str6 = str4;
                String queryParameter24 = parse4.getQueryParameter(str6);
                String queryParameter25 = parse4.getQueryParameter("author_nick_name");
                String queryParameter26 = parse4.getQueryParameter("author_is_god");
                String queryParameter27 = parse4.getQueryParameter(str);
                str7 = "author_nick_name";
                String queryParameter28 = parse4.getQueryParameter(str3);
                String queryParameter29 = parse4.getQueryParameter("video_thumbnail_url");
                str5 = "video_thumbnail_url";
                String queryParameter30 = parse4.getQueryParameter(str2);
                VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo2 = new VideoSerializeVideoThreadInfo();
                videoSerializeVideoThreadInfo2.threadId = queryParameter21;
                videoSerializeVideoThreadInfo2.forumId = queryParameter22;
                videoSerializeVideoThreadInfo2.title = queryParameter23;
                VideoSerializeVideoThreadInfo.VideoAggregationAuthorData videoAggregationAuthorData2 = new VideoSerializeVideoThreadInfo.VideoAggregationAuthorData();
                videoSerializeVideoThreadInfo2.author = videoAggregationAuthorData2;
                videoAggregationAuthorData2.userName = queryParameter24;
                videoAggregationAuthorData2.userNickname = queryParameter25;
                if (!StringUtils.isNull(queryParameter26)) {
                    videoSerializeVideoThreadInfo2.author.isGod = Boolean.parseBoolean(queryParameter26);
                }
                if (!StringUtils.isNull(queryParameter27)) {
                    videoSerializeVideoThreadInfo2.author.isBigV = Boolean.parseBoolean(queryParameter27);
                }
                videoSerializeVideoThreadInfo2.author.portrait = queryParameter28;
                VideoSerializeVideoThreadInfo.VideoAggregationVideoData videoAggregationVideoData2 = new VideoSerializeVideoThreadInfo.VideoAggregationVideoData();
                videoSerializeVideoThreadInfo2.video = videoAggregationVideoData2;
                videoAggregationVideoData2.thumbnailUrl = queryParameter29;
                videoAggregationVideoData2.videoUrl = queryParameter30;
                VideoMiddlePageLightActivityConfig videoMiddlePageLightActivityConfig = new VideoMiddlePageLightActivityConfig(this, VideoMiddlePageActivityConfig.FROM_SCHEME_QA, queryParameter21, videoSerializeVideoThreadInfo2);
                videoMiddlePageLightActivityConfig.setUri(intent.getData());
                sendMessage(new CustomMessage(2002001, videoMiddlePageLightActivityConfig));
            }
            if (!TextUtils.isEmpty(dataString) && dataString.contains("unidispatch/video_middle_vertical_page_qa")) {
                Uri parse5 = Uri.parse(dataString);
                String queryParameter31 = parse5.getQueryParameter(g.o);
                String queryParameter32 = parse5.getQueryParameter(g.J);
                String queryParameter33 = parse5.getQueryParameter("title");
                String queryParameter34 = parse5.getQueryParameter("author_uid");
                String queryParameter35 = parse5.getQueryParameter(str6);
                String queryParameter36 = parse5.getQueryParameter(str7);
                String queryParameter37 = parse5.getQueryParameter(str3);
                String queryParameter38 = parse5.getQueryParameter(str5);
                String queryParameter39 = parse5.getQueryParameter(str2);
                ArrayList arrayList = new ArrayList();
                VideoItemData videoItemData = new VideoItemData();
                videoItemData.thread_id = queryParameter31;
                videoItemData.forum_id = queryParameter32;
                videoItemData.title = queryParameter33;
                UserItemData userItemData = new UserItemData();
                userItemData.user_id = queryParameter34;
                userItemData.user_name = queryParameter35;
                userItemData.name_show = queryParameter36;
                userItemData.portrait = queryParameter37;
                videoItemData.author_info = userItemData;
                videoItemData.thumbnail_url = queryParameter38;
                videoItemData.video_url = queryParameter39;
                arrayList.add(videoItemData);
                VideoPlayActivityConfig videoPlayActivityConfig = new VideoPlayActivityConfig(this, arrayList, VideoPlayActivityConfig.FROM_NANI_VIDEO, VideoMiddlePageActivityConfig.FROM_SCHEME_QA);
                videoPlayActivityConfig.setParamIsVertail(true);
                videoPlayActivityConfig.setUri(intent.getData());
                sendMessage(new CustomMessage(2002001, videoPlayActivityConfig));
            }
            if (TextUtils.isEmpty(dataString) || !dataString.startsWith("tiebaclient://passlogin")) {
                return;
            }
            LoginActivityConfig loginActivityConfig = new LoginActivityConfig(this);
            loginActivityConfig.setAutoLogin(dataString);
            sendMessage(new CustomMessage(2002001, loginActivityConfig));
            d.y().L(true);
        }
    }

    private void clearClipBoardIfNeed(Uri uri) {
        if (uri != null && g.c(uri)) {
            String queryParameter = uri.getQueryParameter("obj_locate");
            if (TextUtils.isEmpty(queryParameter) || !queryParameter.startsWith("mdp")) {
                return;
            }
            UtilHelper.clearClipBoard();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        checkSchema(getIntent());
        finish();
    }
}
