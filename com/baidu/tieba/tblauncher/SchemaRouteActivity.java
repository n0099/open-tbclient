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
import d.b.b.a.b;
import d.b.h0.a.c;
import d.b.h0.a.f;
import d.b.h0.a.v;
import d.b.i0.c3.h0.m;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class SchemaRouteActivity extends BaseActivity {
    public final f.b mOnSchemeParsedCallback = new a();

    /* loaded from: classes5.dex */
    public class a implements f.b {
        public a() {
        }

        @Override // d.b.h0.a.f.b
        public void onCallBack(HashMap<String, Object> hashMap) {
            if (hashMap != null && (hashMap.get(f.v) instanceof String)) {
                TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(SchemaRouteActivity.this.getActivity(), null, (String) hashMap.get(f.v), true);
                tbWebViewActivityConfig.setIsFromSchema(true);
                tbWebViewActivityConfig.setUri((Uri) hashMap.get(f.I));
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
        v.c(intent.getData());
        v.a(intent.getData());
        if (!TextUtils.isEmpty(dataString) && (dataString.contains("invoke_frs") || dataString.contains("tbfrs") || dataString.contains("unidispatch/frs"))) {
            FrsActivityConfig frsActivityConfig = new FrsActivityConfig(getActivity());
            frsActivityConfig.setUri(intent.getData());
            sendMessage(new CustomMessage(2003000, frsActivityConfig));
            c.y().L(true);
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
            c.y().L(true);
        } else if (!TextUtils.isEmpty(dataString) && dataString.contains("tbwebview")) {
            Uri data = intent.getData();
            if (f.c(data)) {
                f.b().j(dataString, data, this.mOnSchemeParsedCallback);
            } else {
                TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(getActivity());
                tbWebViewActivityConfig.setUri(intent.getData());
                sendMessage(new CustomMessage(2002001, tbWebViewActivityConfig));
            }
            c.y().L(true);
        } else if (!TextUtils.isEmpty(dataString) && (dataString.contains("tbtopicdetail") || dataString.contains("unidispatch/topicdetail"))) {
            TopicDetailActivityConfig topicDetailActivityConfig = new TopicDetailActivityConfig(getActivity());
            topicDetailActivityConfig.setUri(intent.getData());
            sendMessage(new CustomMessage(2002001, topicDetailActivityConfig));
            c.y().L(true);
        } else if (!TextUtils.isEmpty(dataString) && (dataString.contains("tbusercenter") || dataString.contains("unidispatch/usercenter") || dataString.contains("usercenter"))) {
            PersonPolymericActivityConfig personPolymericActivityConfig = new PersonPolymericActivityConfig(getActivity());
            personPolymericActivityConfig.setUri(intent.getData());
            sendMessage(new CustomMessage(2002001, personPolymericActivityConfig));
            c.y().L(true);
        } else if (!TextUtils.isEmpty(dataString) && dataString.contains(UrlSchemaHelper.FROM_FORUM_SQUARE)) {
            ForumSquareActivityConfig forumSquareActivityConfig = new ForumSquareActivityConfig(getActivity());
            forumSquareActivityConfig.setUri(intent.getData());
            sendMessage(new CustomMessage(2002001, forumSquareActivityConfig));
            c.y().L(true);
        } else if (!TextUtils.isEmpty(dataString) && dataString.contains("unidispatch/hotuserrank")) {
            HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(getActivity());
            hotUserRankActivityConfig.setUri(intent.getData());
            sendMessage(new CustomMessage(2002001, hotUserRankActivityConfig));
            c.y().L(true);
        } else if (!TextUtils.isEmpty(dataString) && (dataString.contains("unidispatch/openapp") || dataString.contains("donothing"))) {
            if (!b.f().h("MainTabActivity")) {
                sendMessage(new CustomMessage(2002001, new LogoActivityConfig((Context) getActivity(), false)));
            }
            c.y().L(true);
        } else {
            if (!TextUtils.isEmpty(dataString)) {
                if (dataString.contains(f.f49576b + f.k)) {
                    Uri parse = Uri.parse(dataString);
                    String queryParameter = parse.getQueryParameter(f.E);
                    String queryParameter2 = parse.getQueryParameter(f.F);
                    UrlManager urlManager = UrlManager.getInstance();
                    TbPageContext<?> pageContext = getPageContext();
                    urlManager.dealOneLink(pageContext, new String[]{"tiebachushou://liveroom?roomid=" + queryParameter2 + "&livetype=" + queryParameter});
                    c.y().L(true);
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
                c.y().L(true);
                return;
            }
            if (!TextUtils.isEmpty(dataString) && dataString.contains("unidispatch/forumRuleDetail")) {
                sendMessage(new CustomMessage(2002001, new ForumRulesShowActivityConfig(this, Uri.parse(dataString).getQueryParameter(f.J), ForumRulesShowActivityConfig.FORUM_RULE_H5_FROM_SHOW)));
            }
            if (!TextUtils.isEmpty(dataString) && dataString.contains("unidispatch/item")) {
                String queryParameter3 = Uri.parse(dataString).getQueryParameter(f.K);
                HashMap hashMap = new HashMap();
                hashMap.put("itemID", String.valueOf(queryParameter3));
                sendMessage(new CustomMessage(2002015, new m(this, "GameItemDetailsPage", hashMap)));
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
                Uri parse2 = Uri.parse(dataString);
                String queryParameter4 = parse2.getQueryParameter(f.o);
                String queryParameter5 = parse2.getQueryParameter(f.J);
                String queryParameter6 = parse2.getQueryParameter("title");
                String queryParameter7 = parse2.getQueryParameter("author_name");
                str4 = "author_name";
                String queryParameter8 = parse2.getQueryParameter("author_nick_name");
                String queryParameter9 = parse2.getQueryParameter("author_is_god");
                String queryParameter10 = parse2.getQueryParameter("author_is_bigv");
                str = "author_is_bigv";
                String queryParameter11 = parse2.getQueryParameter("author_portrait");
                str3 = "author_portrait";
                String queryParameter12 = parse2.getQueryParameter("video_thumbnail_url");
                String queryParameter13 = parse2.getQueryParameter("video_url");
                str2 = "video_url";
                VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
                videoSerializeVideoThreadInfo.threadId = queryParameter4;
                videoSerializeVideoThreadInfo.forumId = queryParameter5;
                videoSerializeVideoThreadInfo.title = queryParameter6;
                VideoSerializeVideoThreadInfo.VideoAggregationAuthorData videoAggregationAuthorData = new VideoSerializeVideoThreadInfo.VideoAggregationAuthorData();
                videoSerializeVideoThreadInfo.author = videoAggregationAuthorData;
                videoAggregationAuthorData.userName = queryParameter7;
                videoAggregationAuthorData.userNickname = queryParameter8;
                if (!StringUtils.isNull(queryParameter9)) {
                    videoSerializeVideoThreadInfo.author.isGod = Boolean.parseBoolean(queryParameter9);
                }
                if (!StringUtils.isNull(queryParameter10)) {
                    videoSerializeVideoThreadInfo.author.isBigV = Boolean.parseBoolean(queryParameter10);
                }
                videoSerializeVideoThreadInfo.author.portrait = queryParameter11;
                VideoSerializeVideoThreadInfo.VideoAggregationVideoData videoAggregationVideoData = new VideoSerializeVideoThreadInfo.VideoAggregationVideoData();
                videoSerializeVideoThreadInfo.video = videoAggregationVideoData;
                videoAggregationVideoData.thumbnailUrl = queryParameter12;
                videoAggregationVideoData.videoUrl = queryParameter13;
                sendMessage(new CustomMessage(2002001, new VideoMiddlePageActivityConfig(this, VideoMiddlePageActivityConfig.FROM_SCHEME_QA, queryParameter4, videoSerializeVideoThreadInfo)));
            }
            if (TextUtils.isEmpty(dataString) || !dataString.contains("unidispatch/video_middle_light_page_qa")) {
                str5 = str4;
                str6 = "video_thumbnail_url";
                str7 = "author_nick_name";
            } else {
                Uri parse3 = Uri.parse(dataString);
                String queryParameter14 = parse3.getQueryParameter(f.o);
                String queryParameter15 = parse3.getQueryParameter(f.J);
                String queryParameter16 = parse3.getQueryParameter("title");
                str5 = str4;
                String queryParameter17 = parse3.getQueryParameter(str5);
                String queryParameter18 = parse3.getQueryParameter("author_nick_name");
                String queryParameter19 = parse3.getQueryParameter("author_is_god");
                String queryParameter20 = parse3.getQueryParameter(str);
                str7 = "author_nick_name";
                String queryParameter21 = parse3.getQueryParameter(str3);
                String queryParameter22 = parse3.getQueryParameter("video_thumbnail_url");
                str6 = "video_thumbnail_url";
                String queryParameter23 = parse3.getQueryParameter(str2);
                VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo2 = new VideoSerializeVideoThreadInfo();
                videoSerializeVideoThreadInfo2.threadId = queryParameter14;
                videoSerializeVideoThreadInfo2.forumId = queryParameter15;
                videoSerializeVideoThreadInfo2.title = queryParameter16;
                VideoSerializeVideoThreadInfo.VideoAggregationAuthorData videoAggregationAuthorData2 = new VideoSerializeVideoThreadInfo.VideoAggregationAuthorData();
                videoSerializeVideoThreadInfo2.author = videoAggregationAuthorData2;
                videoAggregationAuthorData2.userName = queryParameter17;
                videoAggregationAuthorData2.userNickname = queryParameter18;
                if (!StringUtils.isNull(queryParameter19)) {
                    videoSerializeVideoThreadInfo2.author.isGod = Boolean.parseBoolean(queryParameter19);
                }
                if (!StringUtils.isNull(queryParameter20)) {
                    videoSerializeVideoThreadInfo2.author.isBigV = Boolean.parseBoolean(queryParameter20);
                }
                videoSerializeVideoThreadInfo2.author.portrait = queryParameter21;
                VideoSerializeVideoThreadInfo.VideoAggregationVideoData videoAggregationVideoData2 = new VideoSerializeVideoThreadInfo.VideoAggregationVideoData();
                videoSerializeVideoThreadInfo2.video = videoAggregationVideoData2;
                videoAggregationVideoData2.thumbnailUrl = queryParameter22;
                videoAggregationVideoData2.videoUrl = queryParameter23;
                sendMessage(new CustomMessage(2002001, new VideoMiddlePageLightActivityConfig(this, VideoMiddlePageActivityConfig.FROM_SCHEME_QA, queryParameter14, videoSerializeVideoThreadInfo2)));
            }
            if (TextUtils.isEmpty(dataString) || !dataString.contains("unidispatch/video_middle_vertical_page_qa")) {
                return;
            }
            Uri parse4 = Uri.parse(dataString);
            String queryParameter24 = parse4.getQueryParameter(f.o);
            String queryParameter25 = parse4.getQueryParameter(f.J);
            String queryParameter26 = parse4.getQueryParameter("title");
            String queryParameter27 = parse4.getQueryParameter("author_uid");
            String queryParameter28 = parse4.getQueryParameter(str5);
            String queryParameter29 = parse4.getQueryParameter(str7);
            String queryParameter30 = parse4.getQueryParameter(str3);
            String queryParameter31 = parse4.getQueryParameter(str6);
            String queryParameter32 = parse4.getQueryParameter(str2);
            ArrayList arrayList = new ArrayList();
            VideoItemData videoItemData = new VideoItemData();
            videoItemData.thread_id = queryParameter24;
            videoItemData.forum_id = queryParameter25;
            videoItemData.title = queryParameter26;
            UserItemData userItemData = new UserItemData();
            userItemData.user_id = queryParameter27;
            userItemData.user_name = queryParameter28;
            userItemData.name_show = queryParameter29;
            userItemData.portrait = queryParameter30;
            videoItemData.author_info = userItemData;
            videoItemData.thumbnail_url = queryParameter31;
            videoItemData.video_url = queryParameter32;
            arrayList.add(videoItemData);
            VideoPlayActivityConfig videoPlayActivityConfig = new VideoPlayActivityConfig(this, arrayList, VideoPlayActivityConfig.FROM_NANI_VIDEO, VideoMiddlePageActivityConfig.FROM_SCHEME_QA);
            videoPlayActivityConfig.setParamIsVertail(true);
            sendMessage(new CustomMessage(2002001, videoPlayActivityConfig));
        }
    }

    private void clearClipBoardIfNeed(Uri uri) {
        if (uri != null && f.c(uri)) {
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
