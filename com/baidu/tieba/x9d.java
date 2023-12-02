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
import tbclient.BusinessMix;
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
/* loaded from: classes9.dex */
public class x9d extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull ThreadInfo threadInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, threadInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "id", threadInfo.id);
            ktc.a(jSONObject, "tid", threadInfo.tid);
            ktc.a(jSONObject, "title", threadInfo.title);
            ktc.a(jSONObject, "reply_num", threadInfo.reply_num);
            ktc.a(jSONObject, "view_num", threadInfo.view_num);
            ktc.a(jSONObject, "last_time", threadInfo.last_time);
            ktc.a(jSONObject, "last_time_int", threadInfo.last_time_int);
            ktc.a(jSONObject, "thread_types", threadInfo.thread_types);
            ktc.a(jSONObject, "is_top", threadInfo.is_top);
            ktc.a(jSONObject, "is_good", threadInfo.is_good);
            ktc.a(jSONObject, "is_vote", threadInfo.is_vote);
            ktc.a(jSONObject, "is_bakan", threadInfo.is_bakan);
            ktc.a(jSONObject, "is_protal", threadInfo.is_protal);
            ktc.a(jSONObject, "is_meizhi", threadInfo.is_meizhi);
            ktc.a(jSONObject, "is_voice_thread", threadInfo.is_voice_thread);
            ktc.a(jSONObject, "is_activity", threadInfo.is_activity);
            ktc.a(jSONObject, "is_notice", threadInfo.is_notice);
            User user = threadInfo.author;
            if (user != null) {
                ktc.a(jSONObject, NotificationCompat.CarExtender.KEY_AUTHOR, pad.b(user));
            }
            User user2 = threadInfo.last_replyer;
            if (user2 != null) {
                ktc.a(jSONObject, "last_replyer", pad.b(user2));
            }
            ktc.a(jSONObject, "comment_num", threadInfo.comment_num);
            if (threadInfo._abstract != null) {
                JSONArray jSONArray = new JSONArray();
                for (Abstract r3 : threadInfo._abstract) {
                    jSONArray.put(ntc.b(r3));
                }
                ktc.a(jSONObject, "abstract", jSONArray);
            }
            if (threadInfo.media != null) {
                JSONArray jSONArray2 = new JSONArray();
                for (Media media : threadInfo.media) {
                    jSONArray2.put(b5d.b(media));
                }
                ktc.a(jSONObject, "media", jSONArray2);
            }
            if (threadInfo.voice_info != null) {
                JSONArray jSONArray3 = new JSONArray();
                for (Voice voice : threadInfo.voice_info) {
                    jSONArray3.put(ibd.b(voice));
                }
                ktc.a(jSONObject, "voice_info", jSONArray3);
            }
            ktc.a(jSONObject, "meizhi_pic", threadInfo.meizhi_pic);
            if (threadInfo.media_num != null) {
                JSONArray jSONArray4 = new JSONArray();
                for (MediaNum mediaNum : threadInfo.media_num) {
                    jSONArray4.put(c5d.b(mediaNum));
                }
                ktc.a(jSONObject, "media_num", jSONArray4);
            }
            ktc.a(jSONObject, "thread_type", threadInfo.thread_type);
            ktc.a(jSONObject, "fid", threadInfo.fid);
            ktc.a(jSONObject, "fname", threadInfo.fname);
            ktc.a(jSONObject, "live_post_type", threadInfo.live_post_type);
            ktc.a(jSONObject, "is_livepost", threadInfo.is_livepost);
            ktc.a(jSONObject, "show_commented", threadInfo.show_commented);
            ktc.a(jSONObject, "click_url", threadInfo.click_url);
            ktc.a(jSONObject, "video", threadInfo.video);
            ktc.a(jSONObject, "video_swf", threadInfo.video_swf);
            ktc.a(jSONObject, FileUtils.VIDEO_COVER_DIR, threadInfo.video_cover);
            ktc.a(jSONObject, "video_id", threadInfo.video_id);
            ktc.a(jSONObject, "video_mobile_url", threadInfo.video_mobile_url);
            ktc.a(jSONObject, "is_ntitle", threadInfo.is_ntitle);
            ktc.a(jSONObject, "is_bub", threadInfo.is_bub);
            ktc.a(jSONObject, "first_post_id", threadInfo.first_post_id);
            Zan zan = threadInfo.zan;
            if (zan != null) {
                ktc.a(jSONObject, FeedData.TYPE_ZAN, tbd.b(zan));
            }
            ktc.a(jSONObject, "is_global_top", threadInfo.is_global_top);
            ktc.a(jSONObject, "is_pic", threadInfo.is_pic);
            if (threadInfo.post_list != null) {
                JSONArray jSONArray5 = new JSONArray();
                for (PostList postList : threadInfo.post_list) {
                    jSONArray5.put(t6d.b(postList));
                }
                ktc.a(jSONObject, "post_list", jSONArray5);
            }
            ktc.a(jSONObject, "create_time", threadInfo.create_time);
            ktc.a(jSONObject, "repost_num", threadInfo.repost_num);
            Topic topic = threadInfo.topic;
            if (topic != null) {
                ktc.a(jSONObject, "topic", jad.b(topic));
            }
            ktc.a(jSONObject, "has_commented", threadInfo.has_commented);
            ktc.a(jSONObject, "from", threadInfo.from);
            ktc.a(jSONObject, TableDefine.BusiSessionColumns.COLUMN_COLLECT_STATUS, threadInfo.collect_status);
            ktc.a(jSONObject, "collect_mark_pid", threadInfo.collect_mark_pid);
            ktc.a(jSONObject, "post_id", threadInfo.post_id);
            ktc.a(jSONObject, "time", threadInfo.time);
            ktc.a(jSONObject, "is_membertop", threadInfo.is_membertop);
            AnchorInfo anchorInfo = threadInfo.anchor_info;
            if (anchorInfo != null) {
                ktc.a(jSONObject, "anchor_info", muc.b(anchorInfo));
            }
            ktc.a(jSONObject, "author_id", threadInfo.author_id);
            ktc.a(jSONObject, "valid_post_num", threadInfo.valid_post_num);
            ktc.a(jSONObject, "isLzDeleteAll", threadInfo.isLzDeleteAll);
            ktc.a(jSONObject, "is_ad", threadInfo.is_ad);
            ktc.a(jSONObject, "ecom", threadInfo.ecom);
            ktc.a(jSONObject, "pids", threadInfo.pids);
            Lbs lbs = threadInfo.location;
            if (lbs != null) {
                ktc.a(jSONObject, "location", o4d.b(lbs));
            }
            Guess guess = threadInfo.guess;
            if (guess != null) {
                ktc.a(jSONObject, "guess", t3d.b(guess));
            }
            ktc.a(jSONObject, "timeline", threadInfo.timeline);
            if (threadInfo.act_info != null) {
                JSONArray jSONArray6 = new JSONArray();
                for (ActInfo actInfo : threadInfo.act_info) {
                    jSONArray6.put(qtc.b(actInfo));
                }
                ktc.a(jSONObject, "act_info", jSONArray6);
            }
            ktc.a(jSONObject, "hot_weight", threadInfo.hot_weight);
            ktc.a(jSONObject, "livecover_src", threadInfo.livecover_src);
            ktc.a(jSONObject, "storecount", threadInfo.storecount);
            ktc.a(jSONObject, "post_num", threadInfo.post_num);
            HotTWThreadInfo hotTWThreadInfo = threadInfo.hotTWInfo;
            if (hotTWThreadInfo != null) {
                ktc.a(jSONObject, "hotTWInfo", w3d.b(hotTWThreadInfo));
            }
            ZhiBoInfoTW zhiBoInfoTW = threadInfo.twzhibo_info;
            if (zhiBoInfoTW != null) {
                ktc.a(jSONObject, "twzhibo_info", ubd.b(zhiBoInfoTW));
            }
            ktc.a(jSONObject, MangaCategoryActivityConfig.CATEGORY_NAME, threadInfo.category_name);
            PollInfo pollInfo = threadInfo.poll_info;
            if (pollInfo != null) {
                ktc.a(jSONObject, "poll_info", m6d.b(pollInfo));
            }
            JNews jNews = threadInfo.jid;
            if (jNews != null) {
                ktc.a(jSONObject, "jid", k4d.b(jNews));
            }
            ktc.a(jSONObject, "is_novel", threadInfo.is_novel);
            ktc.a(jSONObject, "is_novel_thank", threadInfo.is_novel_thank);
            ktc.a(jSONObject, "is_novel_reward", threadInfo.is_novel_reward);
            VideoInfo videoInfo = threadInfo.video_info;
            if (videoInfo != null) {
                ktc.a(jSONObject, WriteActivityConfig.VIDEO_INFO, cbd.b(videoInfo));
            }
            ktc.a(jSONObject, "push_end_time", threadInfo.push_end_time);
            ktc.a(jSONObject, "is_copythread", threadInfo.is_copythread);
            ktc.a(jSONObject, "operator_flag", threadInfo.operator_flag);
            TaskInfo taskInfo = threadInfo.task_info;
            if (taskInfo != null) {
                ktc.a(jSONObject, "task_info", k9d.b(taskInfo));
            }
            ktc.a(jSONObject, "pic_num", threadInfo.pic_num);
            ktc.a(jSONObject, "is_godthread_recommend", threadInfo.is_godthread_recommend);
            YulePostActivity yulePostActivity = threadInfo.yule_post_activity;
            if (yulePostActivity != null) {
                ktc.a(jSONObject, "yule_post_activity", rbd.b(yulePostActivity));
            }
            AppCode appCode = threadInfo.app_code;
            if (appCode != null) {
                ktc.a(jSONObject, "app_code", quc.b(appCode));
            }
            if (threadInfo.ext_tails != null) {
                JSONArray jSONArray7 = new JSONArray();
                for (TailInfo tailInfo : threadInfo.ext_tails) {
                    jSONArray7.put(j9d.b(tailInfo));
                }
                ktc.a(jSONObject, "ext_tails", jSONArray7);
            }
            PushStatus pushStatus = threadInfo.push_status;
            if (pushStatus != null) {
                ktc.a(jSONObject, PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_PUSH_STATUS, b7d.b(pushStatus));
            }
            CartoonThread cartoonThread = threadInfo.cartoon_info;
            if (cartoonThread != null) {
                ktc.a(jSONObject, "cartoon_info", rvc.b(cartoonThread));
            }
            ktc.a(jSONObject, "lego_card", threadInfo.lego_card);
            TogetherHi togetherHi = threadInfo.high_together;
            if (togetherHi != null) {
                ktc.a(jSONObject, "high_together", iad.b(togetherHi));
            }
            VideoActive videoActive = threadInfo.videoactive_info;
            if (videoActive != null) {
                ktc.a(jSONObject, "videoactive_info", xad.b(videoActive));
            }
            ktc.a(jSONObject, "is_deal", threadInfo.is_deal);
            DealInfo dealInfo = threadInfo.deal_info;
            if (dealInfo != null) {
                ktc.a(jSONObject, "deal_info", hwc.b(dealInfo));
            }
            AnimationThread animationThread = threadInfo.animation_info;
            if (animationThread != null) {
                ktc.a(jSONObject, LegoListActivityConfig.ANIMATION_INFO, nuc.b(animationThread));
            }
            SkinInfo skinInfo = threadInfo.skin_info;
            if (skinInfo != null) {
                ktc.a(jSONObject, "skin_info", l8d.b(skinInfo));
            }
            PsInfo psInfo = threadInfo.ps_info;
            if (psInfo != null) {
                ktc.a(jSONObject, "ps_info", y6d.b(psInfo));
            }
            BookThread bookThread = threadInfo.book_chapter;
            if (bookThread != null) {
                ktc.a(jSONObject, "book_chapter", ivc.b(bookThread));
            }
            ktc.a(jSONObject, "is_book_chapter", threadInfo.is_book_chapter);
            ktc.a(jSONObject, "recom_source", threadInfo.recom_source);
            ktc.a(jSONObject, TiebaStatic.Params.RECOM_WEIGHT, threadInfo.recom_weight);
            ktc.a(jSONObject, "last_read_pid", threadInfo.last_read_pid);
            ktc.a(jSONObject, "cheak_repeat", threadInfo.cheak_repeat);
            ktc.a(jSONObject, "ab_tag", threadInfo.ab_tag);
            ktc.a(jSONObject, "recom_reason", threadInfo.recom_reason);
            AdInfo adInfo = threadInfo.video_ad_info;
            if (adInfo != null) {
                ktc.a(jSONObject, "video_ad_info", wtc.b(adInfo));
            }
            if (threadInfo.rich_title != null) {
                JSONArray jSONArray8 = new JSONArray();
                for (PbContent pbContent : threadInfo.rich_title) {
                    jSONArray8.put(z5d.b(pbContent));
                }
                ktc.a(jSONObject, "rich_title", jSONArray8);
            }
            if (threadInfo.rich_abstract != null) {
                JSONArray jSONArray9 = new JSONArray();
                for (PbContent pbContent2 : threadInfo.rich_abstract) {
                    jSONArray9.put(z5d.b(pbContent2));
                }
                ktc.a(jSONObject, "rich_abstract", jSONArray9);
            }
            AlaLiveInfo alaLiveInfo = threadInfo.ala_info;
            if (alaLiveInfo != null) {
                ktc.a(jSONObject, "ala_info", huc.b(alaLiveInfo));
            }
            ktc.a(jSONObject, "is_operate_thread", threadInfo.is_operate_thread);
            ktc.a(jSONObject, "is_tbread_dispatch", threadInfo.is_tbread_dispatch);
            TbreadDispatch tbreadDispatch = threadInfo.tbread_dispatch_info;
            if (tbreadDispatch != null) {
                ktc.a(jSONObject, "tbread_dispatch_info", n9d.b(tbreadDispatch));
            }
            AppInfo appInfo = threadInfo.app_info;
            if (appInfo != null) {
                ktc.a(jSONObject, "app_info", suc.b(appInfo));
            }
            if (threadInfo.report_info != null) {
                JSONArray jSONArray10 = new JSONArray();
                for (ReportInfo reportInfo : threadInfo.report_info) {
                    jSONArray10.put(q7d.b(reportInfo));
                }
                ktc.a(jSONObject, "report_info", jSONArray10);
            }
            VideoChannelInfo videoChannelInfo = threadInfo.video_channel_info;
            if (videoChannelInfo != null) {
                ktc.a(jSONObject, "video_channel_info", yad.b(videoChannelInfo));
            }
            if (threadInfo.dislike_info != null) {
                JSONArray jSONArray11 = new JSONArray();
                for (DislikeInfo dislikeInfo : threadInfo.dislike_info) {
                    jSONArray11.put(nwc.b(dislikeInfo));
                }
                ktc.a(jSONObject, "dislike_info", jSONArray11);
            }
            if (threadInfo.declare_list != null) {
                JSONArray jSONArray12 = new JSONArray();
                for (DeclareInfo declareInfo : threadInfo.declare_list) {
                    jSONArray12.put(jwc.b(declareInfo));
                }
                ktc.a(jSONObject, "declare_list", jSONArray12);
            }
            if (threadInfo.multiple_forum_list != null) {
                JSONArray jSONArray13 = new JSONArray();
                for (MultipleForum multipleForum : threadInfo.multiple_forum_list) {
                    jSONArray13.put(g5d.b(multipleForum));
                }
                ktc.a(jSONObject, "multiple_forum_list", jSONArray13);
            }
            ktc.a(jSONObject, "is_multiforum_thread", threadInfo.is_multiforum_thread);
            ktc.a(jSONObject, "agree_num", threadInfo.agree_num);
            Post post = threadInfo.top_agree_post;
            if (post != null) {
                ktc.a(jSONObject, "top_agree_post", s6d.b(post));
            }
            Agree agree = threadInfo.agree;
            if (agree != null) {
                ktc.a(jSONObject, "agree", buc.b(agree));
            }
            ktc.a(jSONObject, "is_partial_visible", threadInfo.is_partial_visible);
            ktc.a(jSONObject, "is_link_thread", threadInfo.is_link_thread);
            LinkThreadInfo linkThreadInfo = threadInfo.link_info;
            if (linkThreadInfo != null) {
                ktc.a(jSONObject, "link_info", u4d.b(linkThreadInfo));
            }
            ktc.a(jSONObject, "freq_num", threadInfo.freq_num);
            ktc.a(jSONObject, IMUserExtraData.KEY_IS_GOD, threadInfo.is_god);
            ActivityInfo activityInfo = threadInfo.activity_info;
            if (activityInfo != null) {
                ktc.a(jSONObject, "activity_info", ttc.b(activityInfo));
            }
            Media media2 = threadInfo.pic_info;
            if (media2 != null) {
                ktc.a(jSONObject, "pic_info", b5d.b(media2));
            }
            ktc.a(jSONObject, "is_story_audit", threadInfo.is_story_audit);
            ktc.a(jSONObject, "share_num", threadInfo.share_num);
            ktc.a(jSONObject, "is_called", threadInfo.is_called);
            ktc.a(jSONObject, "tieba_game_information_source", threadInfo.tieba_game_information_source);
            ktc.a(jSONObject, "audit_time", threadInfo.audit_time);
            ktc.a(jSONObject, "middle_page_num", threadInfo.middle_page_num);
            ktc.a(jSONObject, "middle_page_pass_flag", threadInfo.middle_page_pass_flag);
            OriginThreadInfo originThreadInfo = threadInfo.origin_thread_info;
            if (originThreadInfo != null) {
                ktc.a(jSONObject, "origin_thread_info", u5d.b(originThreadInfo));
            }
            if (threadInfo.first_post_content != null) {
                JSONArray jSONArray14 = new JSONArray();
                for (PbContent pbContent3 : threadInfo.first_post_content) {
                    jSONArray14.put(z5d.b(pbContent3));
                }
                ktc.a(jSONObject, "first_post_content", jSONArray14);
            }
            ktc.a(jSONObject, VideoPlayActivityConfig.IS_SHARE_THREAD, threadInfo.is_share_thread);
            ktc.a(jSONObject, TiebaStatic.Params.RECOM_EXTRA, threadInfo.recom_extra);
            ktc.a(jSONObject, "trans_num", threadInfo.trans_num);
            ktc.a(jSONObject, "multi_forum_text", threadInfo.multi_forum_text);
            StarRankIcon starRankIcon = threadInfo.star_rank_icon;
            if (starRankIcon != null) {
                ktc.a(jSONObject, "star_rank_icon", t8d.b(starRankIcon));
            }
            ktc.a(jSONObject, "is_topic", threadInfo.is_topic);
            ktc.a(jSONObject, "topic_user_name", threadInfo.topic_user_name);
            ktc.a(jSONObject, "topic_h5_url", threadInfo.topic_h5_url);
            ktc.a(jSONObject, "presentation_style", threadInfo.presentation_style);
            OriForumInfo oriForumInfo = threadInfo.ori_forum_info;
            if (oriForumInfo != null) {
                ktc.a(jSONObject, "ori_forum_info", t5d.b(oriForumInfo));
            }
            ktc.a(jSONObject, "is_videobiggie_recomthread", threadInfo.is_videobiggie_recomthread);
            ktc.a(jSONObject, "daily_paper_time", threadInfo.daily_paper_time);
            SimpleForum simpleForum = threadInfo.forum_info;
            if (simpleForum != null) {
                ktc.a(jSONObject, "forum_info", j8d.b(simpleForum));
            }
            SmartApp smartApp = threadInfo.naws_info;
            if (smartApp != null) {
                ktc.a(jSONObject, "naws_info", m8d.b(smartApp));
            }
            VideoDesc videoDesc = threadInfo.video_segment;
            if (videoDesc != null) {
                ktc.a(jSONObject, "video_segment", zad.b(videoDesc));
            }
            ktc.a(jSONObject, "is_top_img", threadInfo.is_top_img);
            ktc.a(jSONObject, "t_share_img", threadInfo.t_share_img);
            TopicModule topicModule = threadInfo.topic_module;
            if (topicModule != null) {
                ktc.a(jSONObject, "topic_module", kad.b(topicModule));
            }
            ktc.a(jSONObject, ImageViewerConfig.IS_BJH, threadInfo.is_bjh);
            ktc.a(jSONObject, "article_cover", threadInfo.article_cover);
            ktc.a(jSONObject, "bjh_content_tag", threadInfo.bjh_content_tag);
            ktc.a(jSONObject, "nid", threadInfo.nid);
            ktc.a(jSONObject, "is_headlinepost", threadInfo.is_headlinepost);
            Baijiahao baijiahao = threadInfo.baijiahao;
            if (baijiahao != null) {
                ktc.a(jSONObject, Constants.PAGE_BAIJIAHAO_NAME, yuc.b(baijiahao));
            }
            ktc.a(jSONObject, "is_s_card", threadInfo.is_s_card);
            ktc.a(jSONObject, "scard_packet_id", threadInfo.scard_packet_id);
            ktc.a(jSONObject, "thread_share_link", threadInfo.thread_share_link);
            ktc.a(jSONObject, "if_comment", threadInfo.if_comment);
            ktc.a(jSONObject, "if_comment_info", threadInfo.if_comment_info);
            ktc.a(jSONObject, "tab_id", threadInfo.tab_id);
            ktc.a(jSONObject, "tab_name", threadInfo.tab_name);
            ktc.a(jSONObject, "wonderful_post_info", threadInfo.wonderful_post_info);
            if (threadInfo.pb_link_info != null) {
                JSONArray jSONArray15 = new JSONArray();
                for (PbLinkInfo pbLinkInfo : threadInfo.pb_link_info) {
                    jSONArray15.put(b6d.b(pbLinkInfo));
                }
                ktc.a(jSONObject, "pb_link_info", jSONArray15);
            }
            Item item = threadInfo.item;
            if (item != null) {
                ktc.a(jSONObject, "item", b4d.b(item));
            }
            if (threadInfo.item_star != null) {
                JSONArray jSONArray16 = new JSONArray();
                for (HeadItem headItem : threadInfo.item_star) {
                    jSONArray16.put(u3d.b(headItem));
                }
                ktc.a(jSONObject, "item_star", jSONArray16);
            }
            ktc.a(jSONObject, "is_deleted", threadInfo.is_deleted);
            ktc.a(jSONObject, "hot_num", threadInfo.hot_num);
            if (threadInfo.pb_goods_info != null) {
                JSONArray jSONArray17 = new JSONArray();
                for (PbGoodsInfo pbGoodsInfo : threadInfo.pb_goods_info) {
                    jSONArray17.put(a6d.b(pbGoodsInfo));
                }
                ktc.a(jSONObject, "pb_goods_info", jSONArray17);
            }
            ktc.a(jSONObject, "is_local", threadInfo.is_local);
            ktc.a(jSONObject, "pb_entry", threadInfo.pb_entry);
            ktc.a(jSONObject, "is_author_view", threadInfo.is_author_view);
            ktc.a(jSONObject, "forum_user_live_msg", threadInfo.forum_user_live_msg);
            ForumFriendWatchingInfo forumFriendWatchingInfo = threadInfo.forum_friend_watching_info;
            if (forumFriendWatchingInfo != null) {
                ktc.a(jSONObject, "forum_friend_watching_info", jyc.b(forumFriendWatchingInfo));
            }
            WorksInfo worksInfo = threadInfo.works_info;
            if (worksInfo != null) {
                ktc.a(jSONObject, "works_info", pbd.b(worksInfo));
            }
            ktc.a(jSONObject, "collect_num", threadInfo.collect_num);
            if (threadInfo.thread_recommend_infos != null) {
                JSONArray jSONArray18 = new JSONArray();
                for (ThreadRecommendInfo threadRecommendInfo : threadInfo.thread_recommend_infos) {
                    jSONArray18.put(z9d.b(threadRecommendInfo));
                }
                ktc.a(jSONObject, "thread_recommend_infos", jSONArray18);
            }
            ktc.a(jSONObject, "recom_tag_icon", threadInfo.recom_tag_icon);
            ktc.a(jSONObject, "is_tiebaplus_ad", threadInfo.is_tiebaplus_ad);
            ktc.a(jSONObject, "tiebaplus_order_id", threadInfo.tiebaplus_order_id);
            ktc.a(jSONObject, "tiebaplus_token", threadInfo.tiebaplus_token);
            ktc.a(jSONObject, "tiebaplus_extra_param", threadInfo.tiebaplus_extra_param);
            ktc.a(jSONObject, "tiebaplus_cant_delete", threadInfo.tiebaplus_cant_delete);
            ktc.a(jSONObject, "is_frs_mask", threadInfo.is_frs_mask);
            VoiceRoom voiceRoom = threadInfo.voice_room;
            if (voiceRoom != null) {
                ktc.a(jSONObject, "voice_room", jbd.b(voiceRoom));
            }
            ktc.a(jSONObject, "tab_show_mode", threadInfo.tab_show_mode);
            TiebaPlusAd tiebaPlusAd = threadInfo.tiebaplus_ad;
            if (tiebaPlusAd != null) {
                ktc.a(jSONObject, "tiebaplus_ad", cad.b(tiebaPlusAd));
            }
            RecommendTip recommendTip = threadInfo.recommend_tip;
            if (recommendTip != null) {
                ktc.a(jSONObject, "recommend_tip", o7d.b(recommendTip));
            }
            EditInfo editInfo = threadInfo.edit_info;
            if (editInfo != null) {
                ktc.a(jSONObject, "edit_info", rwc.b(editInfo));
            }
            ktc.a(jSONObject, "is_pictxt", threadInfo.is_pictxt);
            ktc.a(jSONObject, "exposure_monitor_url", threadInfo.exposure_monitor_url);
            ktc.a(jSONObject, "click_monitor_url", threadInfo.click_monitor_url);
            ThreadRecommendTag threadRecommendTag = threadInfo.thread_recommend_tag;
            if (threadRecommendTag != null) {
                ktc.a(jSONObject, "thread_recommend_tag", aad.b(threadRecommendTag));
            }
            CustomFigure customFigure = threadInfo.custom_figure;
            if (customFigure != null) {
                ktc.a(jSONObject, "custom_figure", ewc.b(customFigure));
            }
            CustomState customState = threadInfo.custom_state;
            if (customState != null) {
                ktc.a(jSONObject, "custom_state", fwc.b(customState));
            }
            ktc.a(jSONObject, "is_highlight", threadInfo.is_highlight);
            ktc.a(jSONObject, "is_xiuxiu_thread", threadInfo.is_xiuxiu_thread);
            ThreadAblum threadAblum = threadInfo.ablum_info;
            if (threadAblum != null) {
                ktc.a(jSONObject, "ablum_info", w9d.b(threadAblum));
            }
            ktc.a(jSONObject, "show_ad_subscript", threadInfo.show_ad_subscript);
            ktc.a(jSONObject, "target_scheme", threadInfo.target_scheme);
            ktc.a(jSONObject, "convert_btn_type", threadInfo.convert_btn_type);
            ktc.a(jSONObject, "is_excellent_thread", threadInfo.is_excellent_thread);
            ktc.a(jSONObject, "literature_flag", threadInfo.literature_flag);
            if (threadInfo.hot_post_list != null) {
                JSONArray jSONArray19 = new JSONArray();
                for (Post post2 : threadInfo.hot_post_list) {
                    jSONArray19.put(s6d.b(post2));
                }
                ktc.a(jSONObject, "hot_post_list", jSONArray19);
            }
            RobotEntrance robotEntrance = threadInfo.robot_entrance;
            if (robotEntrance != null) {
                ktc.a(jSONObject, "robot_entrance", t7d.b(robotEntrance));
            }
            ClickBackCard clickBackCard = threadInfo.click_back_card;
            if (clickBackCard != null) {
                ktc.a(jSONObject, "click_back_card", zvc.b(clickBackCard));
            }
            PeiwanInfo peiwanInfo = threadInfo.peiwan_info;
            if (peiwanInfo != null) {
                ktc.a(jSONObject, "peiwan_info", f6d.b(peiwanInfo));
            }
            ktc.a(jSONObject, "head_type", threadInfo.head_type);
            ktc.a(jSONObject, "disable_share", threadInfo.disable_share);
            ktc.a(jSONObject, "disable_share_toast", threadInfo.disable_share_toast);
            ktc.a(jSONObject, "share_url", threadInfo.share_url);
            ktc.a(jSONObject, "top_thread_set_time", threadInfo.top_thread_set_time);
            BusinessMix businessMix = threadInfo.business_mix;
            if (businessMix != null) {
                ktc.a(jSONObject, "business_mix", nvc.c(businessMix));
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
