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
public class u4d extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull ThreadInfo threadInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, threadInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "id", threadInfo.id);
            poc.a(jSONObject, "tid", threadInfo.tid);
            poc.a(jSONObject, "title", threadInfo.title);
            poc.a(jSONObject, "reply_num", threadInfo.reply_num);
            poc.a(jSONObject, "view_num", threadInfo.view_num);
            poc.a(jSONObject, "last_time", threadInfo.last_time);
            poc.a(jSONObject, "last_time_int", threadInfo.last_time_int);
            poc.a(jSONObject, "thread_types", threadInfo.thread_types);
            poc.a(jSONObject, "is_top", threadInfo.is_top);
            poc.a(jSONObject, "is_good", threadInfo.is_good);
            poc.a(jSONObject, "is_vote", threadInfo.is_vote);
            poc.a(jSONObject, "is_bakan", threadInfo.is_bakan);
            poc.a(jSONObject, "is_protal", threadInfo.is_protal);
            poc.a(jSONObject, "is_meizhi", threadInfo.is_meizhi);
            poc.a(jSONObject, "is_voice_thread", threadInfo.is_voice_thread);
            poc.a(jSONObject, "is_activity", threadInfo.is_activity);
            poc.a(jSONObject, "is_notice", threadInfo.is_notice);
            User user = threadInfo.author;
            if (user != null) {
                poc.a(jSONObject, NotificationCompat.CarExtender.KEY_AUTHOR, m5d.b(user));
            }
            User user2 = threadInfo.last_replyer;
            if (user2 != null) {
                poc.a(jSONObject, "last_replyer", m5d.b(user2));
            }
            poc.a(jSONObject, "comment_num", threadInfo.comment_num);
            if (threadInfo._abstract != null) {
                JSONArray jSONArray = new JSONArray();
                for (Abstract r3 : threadInfo._abstract) {
                    jSONArray.put(soc.b(r3));
                }
                poc.a(jSONObject, "abstract", jSONArray);
            }
            if (threadInfo.media != null) {
                JSONArray jSONArray2 = new JSONArray();
                for (Media media : threadInfo.media) {
                    jSONArray2.put(yzc.b(media));
                }
                poc.a(jSONObject, "media", jSONArray2);
            }
            if (threadInfo.voice_info != null) {
                JSONArray jSONArray3 = new JSONArray();
                for (Voice voice : threadInfo.voice_info) {
                    jSONArray3.put(e6d.b(voice));
                }
                poc.a(jSONObject, "voice_info", jSONArray3);
            }
            poc.a(jSONObject, "meizhi_pic", threadInfo.meizhi_pic);
            if (threadInfo.media_num != null) {
                JSONArray jSONArray4 = new JSONArray();
                for (MediaNum mediaNum : threadInfo.media_num) {
                    jSONArray4.put(zzc.b(mediaNum));
                }
                poc.a(jSONObject, "media_num", jSONArray4);
            }
            poc.a(jSONObject, "thread_type", threadInfo.thread_type);
            poc.a(jSONObject, "fid", threadInfo.fid);
            poc.a(jSONObject, "fname", threadInfo.fname);
            poc.a(jSONObject, "live_post_type", threadInfo.live_post_type);
            poc.a(jSONObject, "is_livepost", threadInfo.is_livepost);
            poc.a(jSONObject, "show_commented", threadInfo.show_commented);
            poc.a(jSONObject, "click_url", threadInfo.click_url);
            poc.a(jSONObject, "video", threadInfo.video);
            poc.a(jSONObject, "video_swf", threadInfo.video_swf);
            poc.a(jSONObject, FileUtils.VIDEO_COVER_DIR, threadInfo.video_cover);
            poc.a(jSONObject, "video_id", threadInfo.video_id);
            poc.a(jSONObject, "video_mobile_url", threadInfo.video_mobile_url);
            poc.a(jSONObject, "is_ntitle", threadInfo.is_ntitle);
            poc.a(jSONObject, "is_bub", threadInfo.is_bub);
            poc.a(jSONObject, "first_post_id", threadInfo.first_post_id);
            Zan zan = threadInfo.zan;
            if (zan != null) {
                poc.a(jSONObject, FeedData.TYPE_ZAN, p6d.b(zan));
            }
            poc.a(jSONObject, "is_global_top", threadInfo.is_global_top);
            poc.a(jSONObject, "is_pic", threadInfo.is_pic);
            if (threadInfo.post_list != null) {
                JSONArray jSONArray5 = new JSONArray();
                for (PostList postList : threadInfo.post_list) {
                    jSONArray5.put(q1d.b(postList));
                }
                poc.a(jSONObject, "post_list", jSONArray5);
            }
            poc.a(jSONObject, "create_time", threadInfo.create_time);
            poc.a(jSONObject, "repost_num", threadInfo.repost_num);
            Topic topic = threadInfo.topic;
            if (topic != null) {
                poc.a(jSONObject, "topic", g5d.b(topic));
            }
            poc.a(jSONObject, "has_commented", threadInfo.has_commented);
            poc.a(jSONObject, "from", threadInfo.from);
            poc.a(jSONObject, TableDefine.BusiSessionColumns.COLUMN_COLLECT_STATUS, threadInfo.collect_status);
            poc.a(jSONObject, "collect_mark_pid", threadInfo.collect_mark_pid);
            poc.a(jSONObject, "post_id", threadInfo.post_id);
            poc.a(jSONObject, "time", threadInfo.time);
            poc.a(jSONObject, "is_membertop", threadInfo.is_membertop);
            AnchorInfo anchorInfo = threadInfo.anchor_info;
            if (anchorInfo != null) {
                poc.a(jSONObject, "anchor_info", ppc.b(anchorInfo));
            }
            poc.a(jSONObject, "author_id", threadInfo.author_id);
            poc.a(jSONObject, "valid_post_num", threadInfo.valid_post_num);
            poc.a(jSONObject, "isLzDeleteAll", threadInfo.isLzDeleteAll);
            poc.a(jSONObject, "is_ad", threadInfo.is_ad);
            poc.a(jSONObject, "ecom", threadInfo.ecom);
            poc.a(jSONObject, "pids", threadInfo.pids);
            Lbs lbs = threadInfo.location;
            if (lbs != null) {
                poc.a(jSONObject, "location", lzc.b(lbs));
            }
            Guess guess = threadInfo.guess;
            if (guess != null) {
                poc.a(jSONObject, "guess", qyc.b(guess));
            }
            poc.a(jSONObject, "timeline", threadInfo.timeline);
            if (threadInfo.act_info != null) {
                JSONArray jSONArray6 = new JSONArray();
                for (ActInfo actInfo : threadInfo.act_info) {
                    jSONArray6.put(voc.b(actInfo));
                }
                poc.a(jSONObject, "act_info", jSONArray6);
            }
            poc.a(jSONObject, "hot_weight", threadInfo.hot_weight);
            poc.a(jSONObject, "livecover_src", threadInfo.livecover_src);
            poc.a(jSONObject, "storecount", threadInfo.storecount);
            poc.a(jSONObject, "post_num", threadInfo.post_num);
            HotTWThreadInfo hotTWThreadInfo = threadInfo.hotTWInfo;
            if (hotTWThreadInfo != null) {
                poc.a(jSONObject, "hotTWInfo", tyc.b(hotTWThreadInfo));
            }
            ZhiBoInfoTW zhiBoInfoTW = threadInfo.twzhibo_info;
            if (zhiBoInfoTW != null) {
                poc.a(jSONObject, "twzhibo_info", q6d.b(zhiBoInfoTW));
            }
            poc.a(jSONObject, MangaCategoryActivityConfig.CATEGORY_NAME, threadInfo.category_name);
            PollInfo pollInfo = threadInfo.poll_info;
            if (pollInfo != null) {
                poc.a(jSONObject, "poll_info", j1d.b(pollInfo));
            }
            JNews jNews = threadInfo.jid;
            if (jNews != null) {
                poc.a(jSONObject, "jid", hzc.b(jNews));
            }
            poc.a(jSONObject, "is_novel", threadInfo.is_novel);
            poc.a(jSONObject, "is_novel_thank", threadInfo.is_novel_thank);
            poc.a(jSONObject, "is_novel_reward", threadInfo.is_novel_reward);
            VideoInfo videoInfo = threadInfo.video_info;
            if (videoInfo != null) {
                poc.a(jSONObject, WriteActivityConfig.VIDEO_INFO, y5d.b(videoInfo));
            }
            poc.a(jSONObject, "push_end_time", threadInfo.push_end_time);
            poc.a(jSONObject, "is_copythread", threadInfo.is_copythread);
            poc.a(jSONObject, "operator_flag", threadInfo.operator_flag);
            TaskInfo taskInfo = threadInfo.task_info;
            if (taskInfo != null) {
                poc.a(jSONObject, "task_info", h4d.b(taskInfo));
            }
            poc.a(jSONObject, "pic_num", threadInfo.pic_num);
            poc.a(jSONObject, "is_godthread_recommend", threadInfo.is_godthread_recommend);
            YulePostActivity yulePostActivity = threadInfo.yule_post_activity;
            if (yulePostActivity != null) {
                poc.a(jSONObject, "yule_post_activity", n6d.b(yulePostActivity));
            }
            AppCode appCode = threadInfo.app_code;
            if (appCode != null) {
                poc.a(jSONObject, "app_code", tpc.b(appCode));
            }
            if (threadInfo.ext_tails != null) {
                JSONArray jSONArray7 = new JSONArray();
                for (TailInfo tailInfo : threadInfo.ext_tails) {
                    jSONArray7.put(g4d.b(tailInfo));
                }
                poc.a(jSONObject, "ext_tails", jSONArray7);
            }
            PushStatus pushStatus = threadInfo.push_status;
            if (pushStatus != null) {
                poc.a(jSONObject, PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_PUSH_STATUS, y1d.b(pushStatus));
            }
            CartoonThread cartoonThread = threadInfo.cartoon_info;
            if (cartoonThread != null) {
                poc.a(jSONObject, "cartoon_info", tqc.b(cartoonThread));
            }
            poc.a(jSONObject, "lego_card", threadInfo.lego_card);
            TogetherHi togetherHi = threadInfo.high_together;
            if (togetherHi != null) {
                poc.a(jSONObject, "high_together", f5d.b(togetherHi));
            }
            VideoActive videoActive = threadInfo.videoactive_info;
            if (videoActive != null) {
                poc.a(jSONObject, "videoactive_info", u5d.b(videoActive));
            }
            poc.a(jSONObject, "is_deal", threadInfo.is_deal);
            DealInfo dealInfo = threadInfo.deal_info;
            if (dealInfo != null) {
                poc.a(jSONObject, "deal_info", jrc.b(dealInfo));
            }
            AnimationThread animationThread = threadInfo.animation_info;
            if (animationThread != null) {
                poc.a(jSONObject, LegoListActivityConfig.ANIMATION_INFO, qpc.b(animationThread));
            }
            SkinInfo skinInfo = threadInfo.skin_info;
            if (skinInfo != null) {
                poc.a(jSONObject, "skin_info", i3d.b(skinInfo));
            }
            PsInfo psInfo = threadInfo.ps_info;
            if (psInfo != null) {
                poc.a(jSONObject, "ps_info", v1d.b(psInfo));
            }
            BookThread bookThread = threadInfo.book_chapter;
            if (bookThread != null) {
                poc.a(jSONObject, "book_chapter", lqc.b(bookThread));
            }
            poc.a(jSONObject, "is_book_chapter", threadInfo.is_book_chapter);
            poc.a(jSONObject, "recom_source", threadInfo.recom_source);
            poc.a(jSONObject, TiebaStatic.Params.RECOM_WEIGHT, threadInfo.recom_weight);
            poc.a(jSONObject, "last_read_pid", threadInfo.last_read_pid);
            poc.a(jSONObject, "cheak_repeat", threadInfo.cheak_repeat);
            poc.a(jSONObject, "ab_tag", threadInfo.ab_tag);
            poc.a(jSONObject, "recom_reason", threadInfo.recom_reason);
            AdInfo adInfo = threadInfo.video_ad_info;
            if (adInfo != null) {
                poc.a(jSONObject, "video_ad_info", bpc.b(adInfo));
            }
            if (threadInfo.rich_title != null) {
                JSONArray jSONArray8 = new JSONArray();
                for (PbContent pbContent : threadInfo.rich_title) {
                    jSONArray8.put(w0d.b(pbContent));
                }
                poc.a(jSONObject, "rich_title", jSONArray8);
            }
            if (threadInfo.rich_abstract != null) {
                JSONArray jSONArray9 = new JSONArray();
                for (PbContent pbContent2 : threadInfo.rich_abstract) {
                    jSONArray9.put(w0d.b(pbContent2));
                }
                poc.a(jSONObject, "rich_abstract", jSONArray9);
            }
            AlaLiveInfo alaLiveInfo = threadInfo.ala_info;
            if (alaLiveInfo != null) {
                poc.a(jSONObject, "ala_info", kpc.b(alaLiveInfo));
            }
            poc.a(jSONObject, "is_operate_thread", threadInfo.is_operate_thread);
            poc.a(jSONObject, "is_tbread_dispatch", threadInfo.is_tbread_dispatch);
            TbreadDispatch tbreadDispatch = threadInfo.tbread_dispatch_info;
            if (tbreadDispatch != null) {
                poc.a(jSONObject, "tbread_dispatch_info", k4d.b(tbreadDispatch));
            }
            AppInfo appInfo = threadInfo.app_info;
            if (appInfo != null) {
                poc.a(jSONObject, "app_info", vpc.b(appInfo));
            }
            if (threadInfo.report_info != null) {
                JSONArray jSONArray10 = new JSONArray();
                for (ReportInfo reportInfo : threadInfo.report_info) {
                    jSONArray10.put(n2d.b(reportInfo));
                }
                poc.a(jSONObject, "report_info", jSONArray10);
            }
            VideoChannelInfo videoChannelInfo = threadInfo.video_channel_info;
            if (videoChannelInfo != null) {
                poc.a(jSONObject, "video_channel_info", v5d.b(videoChannelInfo));
            }
            if (threadInfo.dislike_info != null) {
                JSONArray jSONArray11 = new JSONArray();
                for (DislikeInfo dislikeInfo : threadInfo.dislike_info) {
                    jSONArray11.put(prc.b(dislikeInfo));
                }
                poc.a(jSONObject, "dislike_info", jSONArray11);
            }
            if (threadInfo.declare_list != null) {
                JSONArray jSONArray12 = new JSONArray();
                for (DeclareInfo declareInfo : threadInfo.declare_list) {
                    jSONArray12.put(lrc.b(declareInfo));
                }
                poc.a(jSONObject, "declare_list", jSONArray12);
            }
            if (threadInfo.multiple_forum_list != null) {
                JSONArray jSONArray13 = new JSONArray();
                for (MultipleForum multipleForum : threadInfo.multiple_forum_list) {
                    jSONArray13.put(d0d.b(multipleForum));
                }
                poc.a(jSONObject, "multiple_forum_list", jSONArray13);
            }
            poc.a(jSONObject, "is_multiforum_thread", threadInfo.is_multiforum_thread);
            poc.a(jSONObject, "agree_num", threadInfo.agree_num);
            Post post = threadInfo.top_agree_post;
            if (post != null) {
                poc.a(jSONObject, "top_agree_post", p1d.b(post));
            }
            Agree agree = threadInfo.agree;
            if (agree != null) {
                poc.a(jSONObject, "agree", gpc.b(agree));
            }
            poc.a(jSONObject, "is_partial_visible", threadInfo.is_partial_visible);
            poc.a(jSONObject, "is_link_thread", threadInfo.is_link_thread);
            LinkThreadInfo linkThreadInfo = threadInfo.link_info;
            if (linkThreadInfo != null) {
                poc.a(jSONObject, "link_info", rzc.b(linkThreadInfo));
            }
            poc.a(jSONObject, "freq_num", threadInfo.freq_num);
            poc.a(jSONObject, IMUserExtraData.KEY_IS_GOD, threadInfo.is_god);
            ActivityInfo activityInfo = threadInfo.activity_info;
            if (activityInfo != null) {
                poc.a(jSONObject, "activity_info", yoc.b(activityInfo));
            }
            Media media2 = threadInfo.pic_info;
            if (media2 != null) {
                poc.a(jSONObject, "pic_info", yzc.b(media2));
            }
            poc.a(jSONObject, "is_story_audit", threadInfo.is_story_audit);
            poc.a(jSONObject, "share_num", threadInfo.share_num);
            poc.a(jSONObject, "is_called", threadInfo.is_called);
            poc.a(jSONObject, "tieba_game_information_source", threadInfo.tieba_game_information_source);
            poc.a(jSONObject, "audit_time", threadInfo.audit_time);
            poc.a(jSONObject, "middle_page_num", threadInfo.middle_page_num);
            poc.a(jSONObject, "middle_page_pass_flag", threadInfo.middle_page_pass_flag);
            OriginThreadInfo originThreadInfo = threadInfo.origin_thread_info;
            if (originThreadInfo != null) {
                poc.a(jSONObject, "origin_thread_info", r0d.b(originThreadInfo));
            }
            if (threadInfo.first_post_content != null) {
                JSONArray jSONArray14 = new JSONArray();
                for (PbContent pbContent3 : threadInfo.first_post_content) {
                    jSONArray14.put(w0d.b(pbContent3));
                }
                poc.a(jSONObject, "first_post_content", jSONArray14);
            }
            poc.a(jSONObject, VideoPlayActivityConfig.IS_SHARE_THREAD, threadInfo.is_share_thread);
            poc.a(jSONObject, TiebaStatic.Params.RECOM_EXTRA, threadInfo.recom_extra);
            poc.a(jSONObject, "trans_num", threadInfo.trans_num);
            poc.a(jSONObject, "multi_forum_text", threadInfo.multi_forum_text);
            StarRankIcon starRankIcon = threadInfo.star_rank_icon;
            if (starRankIcon != null) {
                poc.a(jSONObject, "star_rank_icon", q3d.b(starRankIcon));
            }
            poc.a(jSONObject, "is_topic", threadInfo.is_topic);
            poc.a(jSONObject, "topic_user_name", threadInfo.topic_user_name);
            poc.a(jSONObject, "topic_h5_url", threadInfo.topic_h5_url);
            poc.a(jSONObject, "presentation_style", threadInfo.presentation_style);
            OriForumInfo oriForumInfo = threadInfo.ori_forum_info;
            if (oriForumInfo != null) {
                poc.a(jSONObject, "ori_forum_info", q0d.b(oriForumInfo));
            }
            poc.a(jSONObject, "is_videobiggie_recomthread", threadInfo.is_videobiggie_recomthread);
            poc.a(jSONObject, "daily_paper_time", threadInfo.daily_paper_time);
            SimpleForum simpleForum = threadInfo.forum_info;
            if (simpleForum != null) {
                poc.a(jSONObject, "forum_info", g3d.b(simpleForum));
            }
            SmartApp smartApp = threadInfo.naws_info;
            if (smartApp != null) {
                poc.a(jSONObject, "naws_info", j3d.b(smartApp));
            }
            VideoDesc videoDesc = threadInfo.video_segment;
            if (videoDesc != null) {
                poc.a(jSONObject, "video_segment", w5d.b(videoDesc));
            }
            poc.a(jSONObject, "is_top_img", threadInfo.is_top_img);
            poc.a(jSONObject, "t_share_img", threadInfo.t_share_img);
            TopicModule topicModule = threadInfo.topic_module;
            if (topicModule != null) {
                poc.a(jSONObject, "topic_module", h5d.b(topicModule));
            }
            poc.a(jSONObject, ImageViewerConfig.IS_BJH, threadInfo.is_bjh);
            poc.a(jSONObject, "article_cover", threadInfo.article_cover);
            poc.a(jSONObject, "bjh_content_tag", threadInfo.bjh_content_tag);
            poc.a(jSONObject, "nid", threadInfo.nid);
            poc.a(jSONObject, "is_headlinepost", threadInfo.is_headlinepost);
            Baijiahao baijiahao = threadInfo.baijiahao;
            if (baijiahao != null) {
                poc.a(jSONObject, Constants.PAGE_BAIJIAHAO_NAME, bqc.b(baijiahao));
            }
            poc.a(jSONObject, "is_s_card", threadInfo.is_s_card);
            poc.a(jSONObject, "scard_packet_id", threadInfo.scard_packet_id);
            poc.a(jSONObject, "thread_share_link", threadInfo.thread_share_link);
            poc.a(jSONObject, "if_comment", threadInfo.if_comment);
            poc.a(jSONObject, "if_comment_info", threadInfo.if_comment_info);
            poc.a(jSONObject, "tab_id", threadInfo.tab_id);
            poc.a(jSONObject, "tab_name", threadInfo.tab_name);
            poc.a(jSONObject, "wonderful_post_info", threadInfo.wonderful_post_info);
            if (threadInfo.pb_link_info != null) {
                JSONArray jSONArray15 = new JSONArray();
                for (PbLinkInfo pbLinkInfo : threadInfo.pb_link_info) {
                    jSONArray15.put(y0d.b(pbLinkInfo));
                }
                poc.a(jSONObject, "pb_link_info", jSONArray15);
            }
            Item item = threadInfo.item;
            if (item != null) {
                poc.a(jSONObject, "item", yyc.b(item));
            }
            if (threadInfo.item_star != null) {
                JSONArray jSONArray16 = new JSONArray();
                for (HeadItem headItem : threadInfo.item_star) {
                    jSONArray16.put(ryc.b(headItem));
                }
                poc.a(jSONObject, "item_star", jSONArray16);
            }
            poc.a(jSONObject, "is_deleted", threadInfo.is_deleted);
            poc.a(jSONObject, "hot_num", threadInfo.hot_num);
            if (threadInfo.pb_goods_info != null) {
                JSONArray jSONArray17 = new JSONArray();
                for (PbGoodsInfo pbGoodsInfo : threadInfo.pb_goods_info) {
                    jSONArray17.put(x0d.b(pbGoodsInfo));
                }
                poc.a(jSONObject, "pb_goods_info", jSONArray17);
            }
            poc.a(jSONObject, "is_local", threadInfo.is_local);
            poc.a(jSONObject, "pb_entry", threadInfo.pb_entry);
            poc.a(jSONObject, "is_author_view", threadInfo.is_author_view);
            poc.a(jSONObject, "forum_user_live_msg", threadInfo.forum_user_live_msg);
            ForumFriendWatchingInfo forumFriendWatchingInfo = threadInfo.forum_friend_watching_info;
            if (forumFriendWatchingInfo != null) {
                poc.a(jSONObject, "forum_friend_watching_info", ltc.b(forumFriendWatchingInfo));
            }
            WorksInfo worksInfo = threadInfo.works_info;
            if (worksInfo != null) {
                poc.a(jSONObject, "works_info", l6d.b(worksInfo));
            }
            poc.a(jSONObject, "collect_num", threadInfo.collect_num);
            if (threadInfo.thread_recommend_infos != null) {
                JSONArray jSONArray18 = new JSONArray();
                for (ThreadRecommendInfo threadRecommendInfo : threadInfo.thread_recommend_infos) {
                    jSONArray18.put(w4d.b(threadRecommendInfo));
                }
                poc.a(jSONObject, "thread_recommend_infos", jSONArray18);
            }
            poc.a(jSONObject, "recom_tag_icon", threadInfo.recom_tag_icon);
            poc.a(jSONObject, "is_tiebaplus_ad", threadInfo.is_tiebaplus_ad);
            poc.a(jSONObject, "tiebaplus_order_id", threadInfo.tiebaplus_order_id);
            poc.a(jSONObject, "tiebaplus_token", threadInfo.tiebaplus_token);
            poc.a(jSONObject, "tiebaplus_extra_param", threadInfo.tiebaplus_extra_param);
            poc.a(jSONObject, "tiebaplus_cant_delete", threadInfo.tiebaplus_cant_delete);
            poc.a(jSONObject, "is_frs_mask", threadInfo.is_frs_mask);
            VoiceRoom voiceRoom = threadInfo.voice_room;
            if (voiceRoom != null) {
                poc.a(jSONObject, "voice_room", f6d.b(voiceRoom));
            }
            poc.a(jSONObject, "tab_show_mode", threadInfo.tab_show_mode);
            TiebaPlusAd tiebaPlusAd = threadInfo.tiebaplus_ad;
            if (tiebaPlusAd != null) {
                poc.a(jSONObject, "tiebaplus_ad", z4d.b(tiebaPlusAd));
            }
            RecommendTip recommendTip = threadInfo.recommend_tip;
            if (recommendTip != null) {
                poc.a(jSONObject, "recommend_tip", l2d.b(recommendTip));
            }
            EditInfo editInfo = threadInfo.edit_info;
            if (editInfo != null) {
                poc.a(jSONObject, "edit_info", trc.b(editInfo));
            }
            poc.a(jSONObject, "is_pictxt", threadInfo.is_pictxt);
            poc.a(jSONObject, "exposure_monitor_url", threadInfo.exposure_monitor_url);
            poc.a(jSONObject, "click_monitor_url", threadInfo.click_monitor_url);
            ThreadRecommendTag threadRecommendTag = threadInfo.thread_recommend_tag;
            if (threadRecommendTag != null) {
                poc.a(jSONObject, "thread_recommend_tag", x4d.b(threadRecommendTag));
            }
            CustomFigure customFigure = threadInfo.custom_figure;
            if (customFigure != null) {
                poc.a(jSONObject, "custom_figure", grc.b(customFigure));
            }
            CustomState customState = threadInfo.custom_state;
            if (customState != null) {
                poc.a(jSONObject, "custom_state", hrc.b(customState));
            }
            poc.a(jSONObject, "is_highlight", threadInfo.is_highlight);
            poc.a(jSONObject, "is_xiuxiu_thread", threadInfo.is_xiuxiu_thread);
            ThreadAblum threadAblum = threadInfo.ablum_info;
            if (threadAblum != null) {
                poc.a(jSONObject, "ablum_info", t4d.b(threadAblum));
            }
            poc.a(jSONObject, "show_ad_subscript", threadInfo.show_ad_subscript);
            poc.a(jSONObject, "target_scheme", threadInfo.target_scheme);
            poc.a(jSONObject, "convert_btn_type", threadInfo.convert_btn_type);
            poc.a(jSONObject, "is_excellent_thread", threadInfo.is_excellent_thread);
            poc.a(jSONObject, "literature_flag", threadInfo.literature_flag);
            if (threadInfo.hot_post_list != null) {
                JSONArray jSONArray19 = new JSONArray();
                for (Post post2 : threadInfo.hot_post_list) {
                    jSONArray19.put(p1d.b(post2));
                }
                poc.a(jSONObject, "hot_post_list", jSONArray19);
            }
            RobotEntrance robotEntrance = threadInfo.robot_entrance;
            if (robotEntrance != null) {
                poc.a(jSONObject, "robot_entrance", q2d.b(robotEntrance));
            }
            ClickBackCard clickBackCard = threadInfo.click_back_card;
            if (clickBackCard != null) {
                poc.a(jSONObject, "click_back_card", brc.b(clickBackCard));
            }
            PeiwanInfo peiwanInfo = threadInfo.peiwan_info;
            if (peiwanInfo != null) {
                poc.a(jSONObject, "peiwan_info", c1d.b(peiwanInfo));
            }
            poc.a(jSONObject, "head_type", threadInfo.head_type);
            poc.a(jSONObject, "disable_share", threadInfo.disable_share);
            poc.a(jSONObject, "disable_share_toast", threadInfo.disable_share_toast);
            poc.a(jSONObject, "share_url", threadInfo.share_url);
            poc.a(jSONObject, "top_thread_set_time", threadInfo.top_thread_set_time);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
