package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.minivideo.plugin.capture.utils.FileUtils;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tbadk.core.atomData.MangaCategoryActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.IMUserExtraData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.immessagecenter.mention.FeedData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.Abstract;
import tbclient.ActInfo;
import tbclient.ActivityInfo;
import tbclient.AdInfo;
import tbclient.Agree;
import tbclient.AlaLiveInfo;
import tbclient.AnchorInfo;
import tbclient.AnimationThread;
import tbclient.AppCode;
import tbclient.AppInfo;
import tbclient.Baijiahao;
import tbclient.BookThread;
import tbclient.CartoonThread;
import tbclient.ClickBackCard;
import tbclient.CustomFigure;
import tbclient.CustomState;
import tbclient.DealInfo;
import tbclient.DeclareInfo;
import tbclient.DislikeInfo;
import tbclient.EditInfo;
import tbclient.ForumFriendWatchingInfo;
import tbclient.Guess;
import tbclient.HeadItem;
import tbclient.HotTWThreadInfo;
import tbclient.Item;
import tbclient.JNews;
import tbclient.Lbs;
import tbclient.LinkThreadInfo;
import tbclient.Media;
import tbclient.MediaNum;
import tbclient.MultipleForum;
import tbclient.OriForumInfo;
import tbclient.OriginThreadInfo;
import tbclient.PbContent;
import tbclient.PbGoodsInfo;
import tbclient.PbLinkInfo;
import tbclient.PeiwanInfo;
import tbclient.PollInfo;
import tbclient.Post;
import tbclient.PostList;
import tbclient.PsInfo;
import tbclient.PushStatus;
import tbclient.RecommendTip;
import tbclient.ReportInfo;
import tbclient.RobotEntrance;
import tbclient.SimpleForum;
import tbclient.SkinInfo;
import tbclient.SmartApp;
import tbclient.StarRankIcon;
import tbclient.TailInfo;
import tbclient.TaskInfo;
import tbclient.TbreadDispatch;
import tbclient.ThreadAblum;
import tbclient.ThreadInfo;
import tbclient.ThreadRecommendInfo;
import tbclient.ThreadRecommendTag;
import tbclient.TiebaPlusAd;
import tbclient.TogetherHi;
import tbclient.Topic;
import tbclient.TopicModule;
import tbclient.User;
import tbclient.VideoActive;
import tbclient.VideoChannelInfo;
import tbclient.VideoDesc;
import tbclient.VideoInfo;
import tbclient.Voice;
import tbclient.VoiceRoom;
import tbclient.WorksInfo;
import tbclient.YulePostActivity;
import tbclient.Zan;
import tbclient.ZhiBoInfoTW;
/* loaded from: classes8.dex */
public class v4d extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull ThreadInfo threadInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, threadInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "id", threadInfo.id);
            qoc.a(jSONObject, "tid", threadInfo.tid);
            qoc.a(jSONObject, "title", threadInfo.title);
            qoc.a(jSONObject, "reply_num", threadInfo.reply_num);
            qoc.a(jSONObject, "view_num", threadInfo.view_num);
            qoc.a(jSONObject, "last_time", threadInfo.last_time);
            qoc.a(jSONObject, "last_time_int", threadInfo.last_time_int);
            qoc.a(jSONObject, "thread_types", threadInfo.thread_types);
            qoc.a(jSONObject, "is_top", threadInfo.is_top);
            qoc.a(jSONObject, "is_good", threadInfo.is_good);
            qoc.a(jSONObject, "is_vote", threadInfo.is_vote);
            qoc.a(jSONObject, "is_bakan", threadInfo.is_bakan);
            qoc.a(jSONObject, "is_protal", threadInfo.is_protal);
            qoc.a(jSONObject, "is_meizhi", threadInfo.is_meizhi);
            qoc.a(jSONObject, "is_voice_thread", threadInfo.is_voice_thread);
            qoc.a(jSONObject, "is_activity", threadInfo.is_activity);
            qoc.a(jSONObject, "is_notice", threadInfo.is_notice);
            User user = threadInfo.author;
            if (user != null) {
                qoc.a(jSONObject, NotificationCompat.CarExtender.KEY_AUTHOR, n5d.b(user));
            }
            User user2 = threadInfo.last_replyer;
            if (user2 != null) {
                qoc.a(jSONObject, "last_replyer", n5d.b(user2));
            }
            qoc.a(jSONObject, "comment_num", threadInfo.comment_num);
            if (threadInfo._abstract != null) {
                JSONArray jSONArray = new JSONArray();
                for (Abstract r3 : threadInfo._abstract) {
                    jSONArray.put(toc.b(r3));
                }
                qoc.a(jSONObject, "abstract", jSONArray);
            }
            if (threadInfo.media != null) {
                JSONArray jSONArray2 = new JSONArray();
                for (Media media : threadInfo.media) {
                    jSONArray2.put(zzc.b(media));
                }
                qoc.a(jSONObject, "media", jSONArray2);
            }
            if (threadInfo.voice_info != null) {
                JSONArray jSONArray3 = new JSONArray();
                for (Voice voice : threadInfo.voice_info) {
                    jSONArray3.put(f6d.b(voice));
                }
                qoc.a(jSONObject, "voice_info", jSONArray3);
            }
            qoc.a(jSONObject, "meizhi_pic", threadInfo.meizhi_pic);
            if (threadInfo.media_num != null) {
                JSONArray jSONArray4 = new JSONArray();
                for (MediaNum mediaNum : threadInfo.media_num) {
                    jSONArray4.put(a0d.b(mediaNum));
                }
                qoc.a(jSONObject, "media_num", jSONArray4);
            }
            qoc.a(jSONObject, "thread_type", threadInfo.thread_type);
            qoc.a(jSONObject, "fid", threadInfo.fid);
            qoc.a(jSONObject, "fname", threadInfo.fname);
            qoc.a(jSONObject, "live_post_type", threadInfo.live_post_type);
            qoc.a(jSONObject, "is_livepost", threadInfo.is_livepost);
            qoc.a(jSONObject, "show_commented", threadInfo.show_commented);
            qoc.a(jSONObject, "click_url", threadInfo.click_url);
            qoc.a(jSONObject, "video", threadInfo.video);
            qoc.a(jSONObject, "video_swf", threadInfo.video_swf);
            qoc.a(jSONObject, FileUtils.VIDEO_COVER_DIR, threadInfo.video_cover);
            qoc.a(jSONObject, "video_id", threadInfo.video_id);
            qoc.a(jSONObject, "video_mobile_url", threadInfo.video_mobile_url);
            qoc.a(jSONObject, "is_ntitle", threadInfo.is_ntitle);
            qoc.a(jSONObject, "is_bub", threadInfo.is_bub);
            qoc.a(jSONObject, "first_post_id", threadInfo.first_post_id);
            Zan zan = threadInfo.zan;
            if (zan != null) {
                qoc.a(jSONObject, FeedData.TYPE_ZAN, q6d.b(zan));
            }
            qoc.a(jSONObject, "is_global_top", threadInfo.is_global_top);
            qoc.a(jSONObject, "is_pic", threadInfo.is_pic);
            if (threadInfo.post_list != null) {
                JSONArray jSONArray5 = new JSONArray();
                for (PostList postList : threadInfo.post_list) {
                    jSONArray5.put(r1d.b(postList));
                }
                qoc.a(jSONObject, "post_list", jSONArray5);
            }
            qoc.a(jSONObject, "create_time", threadInfo.create_time);
            qoc.a(jSONObject, "repost_num", threadInfo.repost_num);
            Topic topic = threadInfo.topic;
            if (topic != null) {
                qoc.a(jSONObject, "topic", h5d.b(topic));
            }
            qoc.a(jSONObject, "has_commented", threadInfo.has_commented);
            qoc.a(jSONObject, "from", threadInfo.from);
            qoc.a(jSONObject, TableDefine.BusiSessionColumns.COLUMN_COLLECT_STATUS, threadInfo.collect_status);
            qoc.a(jSONObject, "collect_mark_pid", threadInfo.collect_mark_pid);
            qoc.a(jSONObject, "post_id", threadInfo.post_id);
            qoc.a(jSONObject, "time", threadInfo.time);
            qoc.a(jSONObject, "is_membertop", threadInfo.is_membertop);
            AnchorInfo anchorInfo = threadInfo.anchor_info;
            if (anchorInfo != null) {
                qoc.a(jSONObject, "anchor_info", qpc.b(anchorInfo));
            }
            qoc.a(jSONObject, "author_id", threadInfo.author_id);
            qoc.a(jSONObject, "valid_post_num", threadInfo.valid_post_num);
            qoc.a(jSONObject, "isLzDeleteAll", threadInfo.isLzDeleteAll);
            qoc.a(jSONObject, "is_ad", threadInfo.is_ad);
            qoc.a(jSONObject, "ecom", threadInfo.ecom);
            qoc.a(jSONObject, "pids", threadInfo.pids);
            Lbs lbs = threadInfo.location;
            if (lbs != null) {
                qoc.a(jSONObject, "location", mzc.b(lbs));
            }
            Guess guess = threadInfo.guess;
            if (guess != null) {
                qoc.a(jSONObject, "guess", ryc.b(guess));
            }
            qoc.a(jSONObject, "timeline", threadInfo.timeline);
            if (threadInfo.act_info != null) {
                JSONArray jSONArray6 = new JSONArray();
                for (ActInfo actInfo : threadInfo.act_info) {
                    jSONArray6.put(woc.b(actInfo));
                }
                qoc.a(jSONObject, "act_info", jSONArray6);
            }
            qoc.a(jSONObject, "hot_weight", threadInfo.hot_weight);
            qoc.a(jSONObject, "livecover_src", threadInfo.livecover_src);
            qoc.a(jSONObject, "storecount", threadInfo.storecount);
            qoc.a(jSONObject, "post_num", threadInfo.post_num);
            HotTWThreadInfo hotTWThreadInfo = threadInfo.hotTWInfo;
            if (hotTWThreadInfo != null) {
                qoc.a(jSONObject, "hotTWInfo", uyc.b(hotTWThreadInfo));
            }
            ZhiBoInfoTW zhiBoInfoTW = threadInfo.twzhibo_info;
            if (zhiBoInfoTW != null) {
                qoc.a(jSONObject, "twzhibo_info", r6d.b(zhiBoInfoTW));
            }
            qoc.a(jSONObject, MangaCategoryActivityConfig.CATEGORY_NAME, threadInfo.category_name);
            PollInfo pollInfo = threadInfo.poll_info;
            if (pollInfo != null) {
                qoc.a(jSONObject, "poll_info", k1d.b(pollInfo));
            }
            JNews jNews = threadInfo.jid;
            if (jNews != null) {
                qoc.a(jSONObject, "jid", izc.b(jNews));
            }
            qoc.a(jSONObject, "is_novel", threadInfo.is_novel);
            qoc.a(jSONObject, "is_novel_thank", threadInfo.is_novel_thank);
            qoc.a(jSONObject, "is_novel_reward", threadInfo.is_novel_reward);
            VideoInfo videoInfo = threadInfo.video_info;
            if (videoInfo != null) {
                qoc.a(jSONObject, WriteActivityConfig.VIDEO_INFO, z5d.b(videoInfo));
            }
            qoc.a(jSONObject, "push_end_time", threadInfo.push_end_time);
            qoc.a(jSONObject, "is_copythread", threadInfo.is_copythread);
            qoc.a(jSONObject, "operator_flag", threadInfo.operator_flag);
            TaskInfo taskInfo = threadInfo.task_info;
            if (taskInfo != null) {
                qoc.a(jSONObject, "task_info", i4d.b(taskInfo));
            }
            qoc.a(jSONObject, "pic_num", threadInfo.pic_num);
            qoc.a(jSONObject, "is_godthread_recommend", threadInfo.is_godthread_recommend);
            YulePostActivity yulePostActivity = threadInfo.yule_post_activity;
            if (yulePostActivity != null) {
                qoc.a(jSONObject, "yule_post_activity", o6d.b(yulePostActivity));
            }
            AppCode appCode = threadInfo.app_code;
            if (appCode != null) {
                qoc.a(jSONObject, "app_code", upc.b(appCode));
            }
            if (threadInfo.ext_tails != null) {
                JSONArray jSONArray7 = new JSONArray();
                for (TailInfo tailInfo : threadInfo.ext_tails) {
                    jSONArray7.put(h4d.b(tailInfo));
                }
                qoc.a(jSONObject, "ext_tails", jSONArray7);
            }
            PushStatus pushStatus = threadInfo.push_status;
            if (pushStatus != null) {
                qoc.a(jSONObject, PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_PUSH_STATUS, z1d.b(pushStatus));
            }
            CartoonThread cartoonThread = threadInfo.cartoon_info;
            if (cartoonThread != null) {
                qoc.a(jSONObject, "cartoon_info", uqc.b(cartoonThread));
            }
            qoc.a(jSONObject, "lego_card", threadInfo.lego_card);
            TogetherHi togetherHi = threadInfo.high_together;
            if (togetherHi != null) {
                qoc.a(jSONObject, "high_together", g5d.b(togetherHi));
            }
            VideoActive videoActive = threadInfo.videoactive_info;
            if (videoActive != null) {
                qoc.a(jSONObject, "videoactive_info", v5d.b(videoActive));
            }
            qoc.a(jSONObject, "is_deal", threadInfo.is_deal);
            DealInfo dealInfo = threadInfo.deal_info;
            if (dealInfo != null) {
                qoc.a(jSONObject, "deal_info", krc.b(dealInfo));
            }
            AnimationThread animationThread = threadInfo.animation_info;
            if (animationThread != null) {
                qoc.a(jSONObject, LegoListActivityConfig.ANIMATION_INFO, rpc.b(animationThread));
            }
            SkinInfo skinInfo = threadInfo.skin_info;
            if (skinInfo != null) {
                qoc.a(jSONObject, "skin_info", j3d.b(skinInfo));
            }
            PsInfo psInfo = threadInfo.ps_info;
            if (psInfo != null) {
                qoc.a(jSONObject, "ps_info", w1d.b(psInfo));
            }
            BookThread bookThread = threadInfo.book_chapter;
            if (bookThread != null) {
                qoc.a(jSONObject, "book_chapter", mqc.b(bookThread));
            }
            qoc.a(jSONObject, "is_book_chapter", threadInfo.is_book_chapter);
            qoc.a(jSONObject, "recom_source", threadInfo.recom_source);
            qoc.a(jSONObject, TiebaStatic.Params.RECOM_WEIGHT, threadInfo.recom_weight);
            qoc.a(jSONObject, "last_read_pid", threadInfo.last_read_pid);
            qoc.a(jSONObject, "cheak_repeat", threadInfo.cheak_repeat);
            qoc.a(jSONObject, "ab_tag", threadInfo.ab_tag);
            qoc.a(jSONObject, "recom_reason", threadInfo.recom_reason);
            AdInfo adInfo = threadInfo.video_ad_info;
            if (adInfo != null) {
                qoc.a(jSONObject, "video_ad_info", cpc.b(adInfo));
            }
            if (threadInfo.rich_title != null) {
                JSONArray jSONArray8 = new JSONArray();
                for (PbContent pbContent : threadInfo.rich_title) {
                    jSONArray8.put(x0d.b(pbContent));
                }
                qoc.a(jSONObject, "rich_title", jSONArray8);
            }
            if (threadInfo.rich_abstract != null) {
                JSONArray jSONArray9 = new JSONArray();
                for (PbContent pbContent2 : threadInfo.rich_abstract) {
                    jSONArray9.put(x0d.b(pbContent2));
                }
                qoc.a(jSONObject, "rich_abstract", jSONArray9);
            }
            AlaLiveInfo alaLiveInfo = threadInfo.ala_info;
            if (alaLiveInfo != null) {
                qoc.a(jSONObject, "ala_info", lpc.b(alaLiveInfo));
            }
            qoc.a(jSONObject, "is_operate_thread", threadInfo.is_operate_thread);
            qoc.a(jSONObject, "is_tbread_dispatch", threadInfo.is_tbread_dispatch);
            TbreadDispatch tbreadDispatch = threadInfo.tbread_dispatch_info;
            if (tbreadDispatch != null) {
                qoc.a(jSONObject, "tbread_dispatch_info", l4d.b(tbreadDispatch));
            }
            AppInfo appInfo = threadInfo.app_info;
            if (appInfo != null) {
                qoc.a(jSONObject, "app_info", wpc.b(appInfo));
            }
            if (threadInfo.report_info != null) {
                JSONArray jSONArray10 = new JSONArray();
                for (ReportInfo reportInfo : threadInfo.report_info) {
                    jSONArray10.put(o2d.b(reportInfo));
                }
                qoc.a(jSONObject, "report_info", jSONArray10);
            }
            VideoChannelInfo videoChannelInfo = threadInfo.video_channel_info;
            if (videoChannelInfo != null) {
                qoc.a(jSONObject, "video_channel_info", w5d.b(videoChannelInfo));
            }
            if (threadInfo.dislike_info != null) {
                JSONArray jSONArray11 = new JSONArray();
                for (DislikeInfo dislikeInfo : threadInfo.dislike_info) {
                    jSONArray11.put(qrc.b(dislikeInfo));
                }
                qoc.a(jSONObject, "dislike_info", jSONArray11);
            }
            if (threadInfo.declare_list != null) {
                JSONArray jSONArray12 = new JSONArray();
                for (DeclareInfo declareInfo : threadInfo.declare_list) {
                    jSONArray12.put(mrc.b(declareInfo));
                }
                qoc.a(jSONObject, "declare_list", jSONArray12);
            }
            if (threadInfo.multiple_forum_list != null) {
                JSONArray jSONArray13 = new JSONArray();
                for (MultipleForum multipleForum : threadInfo.multiple_forum_list) {
                    jSONArray13.put(e0d.b(multipleForum));
                }
                qoc.a(jSONObject, "multiple_forum_list", jSONArray13);
            }
            qoc.a(jSONObject, "is_multiforum_thread", threadInfo.is_multiforum_thread);
            qoc.a(jSONObject, "agree_num", threadInfo.agree_num);
            Post post = threadInfo.top_agree_post;
            if (post != null) {
                qoc.a(jSONObject, "top_agree_post", q1d.b(post));
            }
            Agree agree = threadInfo.agree;
            if (agree != null) {
                qoc.a(jSONObject, "agree", hpc.b(agree));
            }
            qoc.a(jSONObject, "is_partial_visible", threadInfo.is_partial_visible);
            qoc.a(jSONObject, "is_link_thread", threadInfo.is_link_thread);
            LinkThreadInfo linkThreadInfo = threadInfo.link_info;
            if (linkThreadInfo != null) {
                qoc.a(jSONObject, "link_info", szc.b(linkThreadInfo));
            }
            qoc.a(jSONObject, "freq_num", threadInfo.freq_num);
            qoc.a(jSONObject, IMUserExtraData.KEY_IS_GOD, threadInfo.is_god);
            ActivityInfo activityInfo = threadInfo.activity_info;
            if (activityInfo != null) {
                qoc.a(jSONObject, "activity_info", zoc.b(activityInfo));
            }
            Media media2 = threadInfo.pic_info;
            if (media2 != null) {
                qoc.a(jSONObject, "pic_info", zzc.b(media2));
            }
            qoc.a(jSONObject, "is_story_audit", threadInfo.is_story_audit);
            qoc.a(jSONObject, "share_num", threadInfo.share_num);
            qoc.a(jSONObject, "is_called", threadInfo.is_called);
            qoc.a(jSONObject, "tieba_game_information_source", threadInfo.tieba_game_information_source);
            qoc.a(jSONObject, "audit_time", threadInfo.audit_time);
            qoc.a(jSONObject, "middle_page_num", threadInfo.middle_page_num);
            qoc.a(jSONObject, "middle_page_pass_flag", threadInfo.middle_page_pass_flag);
            OriginThreadInfo originThreadInfo = threadInfo.origin_thread_info;
            if (originThreadInfo != null) {
                qoc.a(jSONObject, "origin_thread_info", s0d.b(originThreadInfo));
            }
            if (threadInfo.first_post_content != null) {
                JSONArray jSONArray14 = new JSONArray();
                for (PbContent pbContent3 : threadInfo.first_post_content) {
                    jSONArray14.put(x0d.b(pbContent3));
                }
                qoc.a(jSONObject, "first_post_content", jSONArray14);
            }
            qoc.a(jSONObject, VideoPlayActivityConfig.IS_SHARE_THREAD, threadInfo.is_share_thread);
            qoc.a(jSONObject, TiebaStatic.Params.RECOM_EXTRA, threadInfo.recom_extra);
            qoc.a(jSONObject, "trans_num", threadInfo.trans_num);
            qoc.a(jSONObject, "multi_forum_text", threadInfo.multi_forum_text);
            StarRankIcon starRankIcon = threadInfo.star_rank_icon;
            if (starRankIcon != null) {
                qoc.a(jSONObject, "star_rank_icon", r3d.b(starRankIcon));
            }
            qoc.a(jSONObject, "is_topic", threadInfo.is_topic);
            qoc.a(jSONObject, "topic_user_name", threadInfo.topic_user_name);
            qoc.a(jSONObject, "topic_h5_url", threadInfo.topic_h5_url);
            qoc.a(jSONObject, "presentation_style", threadInfo.presentation_style);
            OriForumInfo oriForumInfo = threadInfo.ori_forum_info;
            if (oriForumInfo != null) {
                qoc.a(jSONObject, "ori_forum_info", r0d.b(oriForumInfo));
            }
            qoc.a(jSONObject, "is_videobiggie_recomthread", threadInfo.is_videobiggie_recomthread);
            qoc.a(jSONObject, "daily_paper_time", threadInfo.daily_paper_time);
            SimpleForum simpleForum = threadInfo.forum_info;
            if (simpleForum != null) {
                qoc.a(jSONObject, "forum_info", h3d.b(simpleForum));
            }
            SmartApp smartApp = threadInfo.naws_info;
            if (smartApp != null) {
                qoc.a(jSONObject, "naws_info", k3d.b(smartApp));
            }
            VideoDesc videoDesc = threadInfo.video_segment;
            if (videoDesc != null) {
                qoc.a(jSONObject, "video_segment", x5d.b(videoDesc));
            }
            qoc.a(jSONObject, "is_top_img", threadInfo.is_top_img);
            qoc.a(jSONObject, "t_share_img", threadInfo.t_share_img);
            TopicModule topicModule = threadInfo.topic_module;
            if (topicModule != null) {
                qoc.a(jSONObject, "topic_module", i5d.b(topicModule));
            }
            qoc.a(jSONObject, ImageViewerConfig.IS_BJH, threadInfo.is_bjh);
            qoc.a(jSONObject, "article_cover", threadInfo.article_cover);
            qoc.a(jSONObject, "bjh_content_tag", threadInfo.bjh_content_tag);
            qoc.a(jSONObject, "nid", threadInfo.nid);
            qoc.a(jSONObject, "is_headlinepost", threadInfo.is_headlinepost);
            Baijiahao baijiahao = threadInfo.baijiahao;
            if (baijiahao != null) {
                qoc.a(jSONObject, Constants.PAGE_BAIJIAHAO_NAME, cqc.b(baijiahao));
            }
            qoc.a(jSONObject, "is_s_card", threadInfo.is_s_card);
            qoc.a(jSONObject, "scard_packet_id", threadInfo.scard_packet_id);
            qoc.a(jSONObject, "thread_share_link", threadInfo.thread_share_link);
            qoc.a(jSONObject, "if_comment", threadInfo.if_comment);
            qoc.a(jSONObject, "if_comment_info", threadInfo.if_comment_info);
            qoc.a(jSONObject, "tab_id", threadInfo.tab_id);
            qoc.a(jSONObject, "tab_name", threadInfo.tab_name);
            qoc.a(jSONObject, "wonderful_post_info", threadInfo.wonderful_post_info);
            if (threadInfo.pb_link_info != null) {
                JSONArray jSONArray15 = new JSONArray();
                for (PbLinkInfo pbLinkInfo : threadInfo.pb_link_info) {
                    jSONArray15.put(z0d.b(pbLinkInfo));
                }
                qoc.a(jSONObject, "pb_link_info", jSONArray15);
            }
            Item item = threadInfo.item;
            if (item != null) {
                qoc.a(jSONObject, "item", zyc.b(item));
            }
            if (threadInfo.item_star != null) {
                JSONArray jSONArray16 = new JSONArray();
                for (HeadItem headItem : threadInfo.item_star) {
                    jSONArray16.put(syc.b(headItem));
                }
                qoc.a(jSONObject, "item_star", jSONArray16);
            }
            qoc.a(jSONObject, "is_deleted", threadInfo.is_deleted);
            qoc.a(jSONObject, "hot_num", threadInfo.hot_num);
            if (threadInfo.pb_goods_info != null) {
                JSONArray jSONArray17 = new JSONArray();
                for (PbGoodsInfo pbGoodsInfo : threadInfo.pb_goods_info) {
                    jSONArray17.put(y0d.b(pbGoodsInfo));
                }
                qoc.a(jSONObject, "pb_goods_info", jSONArray17);
            }
            qoc.a(jSONObject, "is_local", threadInfo.is_local);
            qoc.a(jSONObject, "pb_entry", threadInfo.pb_entry);
            qoc.a(jSONObject, "is_author_view", threadInfo.is_author_view);
            qoc.a(jSONObject, "forum_user_live_msg", threadInfo.forum_user_live_msg);
            ForumFriendWatchingInfo forumFriendWatchingInfo = threadInfo.forum_friend_watching_info;
            if (forumFriendWatchingInfo != null) {
                qoc.a(jSONObject, "forum_friend_watching_info", mtc.b(forumFriendWatchingInfo));
            }
            WorksInfo worksInfo = threadInfo.works_info;
            if (worksInfo != null) {
                qoc.a(jSONObject, "works_info", m6d.b(worksInfo));
            }
            qoc.a(jSONObject, "collect_num", threadInfo.collect_num);
            if (threadInfo.thread_recommend_infos != null) {
                JSONArray jSONArray18 = new JSONArray();
                for (ThreadRecommendInfo threadRecommendInfo : threadInfo.thread_recommend_infos) {
                    jSONArray18.put(x4d.b(threadRecommendInfo));
                }
                qoc.a(jSONObject, "thread_recommend_infos", jSONArray18);
            }
            qoc.a(jSONObject, "recom_tag_icon", threadInfo.recom_tag_icon);
            qoc.a(jSONObject, "is_tiebaplus_ad", threadInfo.is_tiebaplus_ad);
            qoc.a(jSONObject, "tiebaplus_order_id", threadInfo.tiebaplus_order_id);
            qoc.a(jSONObject, "tiebaplus_token", threadInfo.tiebaplus_token);
            qoc.a(jSONObject, "tiebaplus_extra_param", threadInfo.tiebaplus_extra_param);
            qoc.a(jSONObject, "tiebaplus_cant_delete", threadInfo.tiebaplus_cant_delete);
            qoc.a(jSONObject, "is_frs_mask", threadInfo.is_frs_mask);
            VoiceRoom voiceRoom = threadInfo.voice_room;
            if (voiceRoom != null) {
                qoc.a(jSONObject, "voice_room", g6d.b(voiceRoom));
            }
            qoc.a(jSONObject, "tab_show_mode", threadInfo.tab_show_mode);
            TiebaPlusAd tiebaPlusAd = threadInfo.tiebaplus_ad;
            if (tiebaPlusAd != null) {
                qoc.a(jSONObject, "tiebaplus_ad", a5d.b(tiebaPlusAd));
            }
            RecommendTip recommendTip = threadInfo.recommend_tip;
            if (recommendTip != null) {
                qoc.a(jSONObject, "recommend_tip", m2d.b(recommendTip));
            }
            EditInfo editInfo = threadInfo.edit_info;
            if (editInfo != null) {
                qoc.a(jSONObject, "edit_info", urc.b(editInfo));
            }
            qoc.a(jSONObject, "is_pictxt", threadInfo.is_pictxt);
            qoc.a(jSONObject, "exposure_monitor_url", threadInfo.exposure_monitor_url);
            qoc.a(jSONObject, "click_monitor_url", threadInfo.click_monitor_url);
            ThreadRecommendTag threadRecommendTag = threadInfo.thread_recommend_tag;
            if (threadRecommendTag != null) {
                qoc.a(jSONObject, "thread_recommend_tag", y4d.b(threadRecommendTag));
            }
            CustomFigure customFigure = threadInfo.custom_figure;
            if (customFigure != null) {
                qoc.a(jSONObject, "custom_figure", hrc.b(customFigure));
            }
            CustomState customState = threadInfo.custom_state;
            if (customState != null) {
                qoc.a(jSONObject, "custom_state", irc.b(customState));
            }
            qoc.a(jSONObject, "is_highlight", threadInfo.is_highlight);
            qoc.a(jSONObject, "is_xiuxiu_thread", threadInfo.is_xiuxiu_thread);
            ThreadAblum threadAblum = threadInfo.ablum_info;
            if (threadAblum != null) {
                qoc.a(jSONObject, "ablum_info", u4d.b(threadAblum));
            }
            qoc.a(jSONObject, "show_ad_subscript", threadInfo.show_ad_subscript);
            qoc.a(jSONObject, "target_scheme", threadInfo.target_scheme);
            qoc.a(jSONObject, "convert_btn_type", threadInfo.convert_btn_type);
            qoc.a(jSONObject, "is_excellent_thread", threadInfo.is_excellent_thread);
            qoc.a(jSONObject, "literature_flag", threadInfo.literature_flag);
            if (threadInfo.hot_post_list != null) {
                JSONArray jSONArray19 = new JSONArray();
                for (Post post2 : threadInfo.hot_post_list) {
                    jSONArray19.put(q1d.b(post2));
                }
                qoc.a(jSONObject, "hot_post_list", jSONArray19);
            }
            RobotEntrance robotEntrance = threadInfo.robot_entrance;
            if (robotEntrance != null) {
                qoc.a(jSONObject, "robot_entrance", r2d.b(robotEntrance));
            }
            ClickBackCard clickBackCard = threadInfo.click_back_card;
            if (clickBackCard != null) {
                qoc.a(jSONObject, "click_back_card", crc.b(clickBackCard));
            }
            PeiwanInfo peiwanInfo = threadInfo.peiwan_info;
            if (peiwanInfo != null) {
                qoc.a(jSONObject, "peiwan_info", d1d.b(peiwanInfo));
            }
            qoc.a(jSONObject, "head_type", threadInfo.head_type);
            qoc.a(jSONObject, "disable_share", threadInfo.disable_share);
            qoc.a(jSONObject, "disable_share_toast", threadInfo.disable_share_toast);
            qoc.a(jSONObject, "share_url", threadInfo.share_url);
            qoc.a(jSONObject, "top_thread_set_time", threadInfo.top_thread_set_time);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
