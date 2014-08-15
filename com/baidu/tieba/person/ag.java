package com.baidu.tieba.person;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.LiveCardData;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.coreExtra.view.LiveBroadcastCard;
import com.baidu.tieba.person.PersonPostListData;
import com.baidu.tieba.view.CommonImageLayout;
import com.baidu.tieba.voice.PlayVoiceBnt;
/* loaded from: classes.dex */
public class ag {
    private final BaseFragmentActivity a;
    private boolean b = true;
    private boolean c = false;
    private final View.OnClickListener d = new ah(this);

    public ag(BaseFragmentActivity baseFragmentActivity) {
        this.a = baseFragmentActivity;
    }

    public void a(int i, boolean z, float f) {
        this.b = z;
    }

    public void a(boolean z) {
        this.c = z;
    }

    public void a(View view, PersonPostListData.PostList postList) {
        ai aiVar;
        int i = 0;
        if (view.getTag() != null && (aiVar = (ai) view.getTag()) != null) {
            String string = this.a.getResources().getString(com.baidu.tieba.x.forum_name_suffix);
            aiVar.c.setText(String.valueOf(postList.forum_name) + string);
            aiVar.c.setTag(postList.forum_name);
            aiVar.d.setText(postList.title);
            aiVar.c.setVisibility(8);
            aiVar.p.setVisibility(8);
            aiVar.f.setPadding(this.a.getResources().getDimensionPixelSize(com.baidu.tieba.s.listview_item_padding), 0, 0, 0);
            aiVar.f.setText(String.valueOf(postList.forum_name) + string);
            aiVar.h.setText(String.valueOf(postList.reply_num));
            aiVar.g.setText(com.baidu.tbadk.core.util.ba.a(postList.create_time * 1000));
            if (postList.abs != null && postList.abs.length > 0 && TextUtils.isEmpty(postList.abs[0].text)) {
                aiVar.e.setText(postList.abs[0].text);
                aiVar.e.setVisibility(0);
            } else {
                aiVar.e.setText((CharSequence) null);
                aiVar.e.setVisibility(8);
            }
            aiVar.k = new StringBuilder(String.valueOf(postList.forum_id)).toString();
            aiVar.l = new StringBuilder(String.valueOf(postList.thread_id)).toString();
            aiVar.j.setVisibility(8);
            LiveCardData a = a(postList.anchor_info);
            if (a.getAuthorId() != 0) {
                aiVar.i.setVisibility(8);
                aiVar.q.setVisibility(0);
                aiVar.r.setData(a);
            } else {
                aiVar.q.setVisibility(8);
                if (com.baidu.tbadk.core.h.a().f()) {
                    aiVar.i.setVisibility(0);
                    PersonPostListData.Media[] mediaArr = postList.media;
                    if (mediaArr != null) {
                        if (mediaArr.length > 0) {
                            int length = mediaArr.length;
                            int i2 = length > 3 ? 3 : length;
                            if (i2 > 0) {
                                MediaData[] mediaDataArr = new MediaData[i2];
                                for (int i3 = 0; i3 < mediaArr.length && i < i2; i3++) {
                                    if (mediaArr[i3].type == 3 || mediaArr[i3].type == 5) {
                                        MediaData mediaData = new MediaData();
                                        if (mediaArr[i3].type == 3) {
                                            mediaData.setPic(mediaArr[i3].water_pic);
                                            mediaData.setType(mediaArr[i3].type);
                                            mediaData.setVideo(mediaArr[i3].water_pic);
                                        } else {
                                            mediaData.setPic(mediaArr[i3].pic_url);
                                            mediaData.setType(mediaArr[i3].type);
                                            mediaData.setVideo(mediaArr[i3].video_url);
                                        }
                                        mediaDataArr[i] = mediaData;
                                        i++;
                                    }
                                }
                                aiVar.i.setShowBig(this.b);
                                aiVar.i.setData(mediaDataArr);
                                aiVar.i.setFromCDN(this.c);
                            }
                        } else {
                            aiVar.i.setVisibility(8);
                        }
                    }
                } else {
                    aiVar.i.setVisibility(8);
                }
            }
            aiVar.n = this.b;
            view.setTag(aiVar);
        }
    }

    private LiveCardData a(PersonPostListData.AnchorInfo anchorInfo) {
        LiveCardData liveCardData = new LiveCardData();
        liveCardData.setAuthorId(anchorInfo.author_id);
        liveCardData.setAuthorName(anchorInfo.author_name);
        liveCardData.setGroupId(anchorInfo.group_id);
        liveCardData.setIntro(anchorInfo.intro);
        liveCardData.setLikers(anchorInfo.likers);
        liveCardData.setListeners(anchorInfo.listeners);
        liveCardData.setName(anchorInfo.name);
        liveCardData.setPortrait(anchorInfo.portrait);
        liveCardData.setPublisherId(anchorInfo.publisher_id);
        liveCardData.setPublisherName(anchorInfo.publisher_name);
        liveCardData.setStartTime(anchorInfo.start_time);
        liveCardData.setStatus(anchorInfo.status);
        liveCardData.setPublisherPortrait(anchorInfo.publisherPortrait);
        return liveCardData;
    }

    public View a() {
        ai aiVar = new ai();
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.a).inflate(com.baidu.tieba.v.forum_feed_item, (ViewGroup) null);
        aiVar.a = (LinearLayout) linearLayout.findViewById(com.baidu.tieba.u.layoutForumTop);
        aiVar.b = (RelativeLayout) linearLayout.findViewById(com.baidu.tieba.u.layoutForumBottom);
        aiVar.c = (TextView) linearLayout.findViewById(com.baidu.tieba.u.textHomeListFrsName);
        aiVar.d = (TextView) linearLayout.findViewById(com.baidu.tieba.u.textHomeListTitle);
        aiVar.e = (TextView) linearLayout.findViewById(com.baidu.tieba.u.textHomeListAbstract);
        aiVar.f = (TextView) linearLayout.findViewById(com.baidu.tieba.u.textHomeListAuthor);
        aiVar.o = (UserIconBox) linearLayout.findViewById(com.baidu.tieba.u.user_icon_box);
        aiVar.p = (UserIconBox) linearLayout.findViewById(com.baidu.tieba.u.user_tshow_icon_box);
        aiVar.g = (TextView) linearLayout.findViewById(com.baidu.tieba.u.textHomeListTime);
        aiVar.h = (TextView) linearLayout.findViewById(com.baidu.tieba.u.textHomeListRplyNum);
        aiVar.i = (CommonImageLayout) linearLayout.findViewById(com.baidu.tieba.u.layoutFeedImage);
        aiVar.j = (PlayVoiceBnt) linearLayout.findViewById(com.baidu.tieba.u.abstract_voice);
        aiVar.q = (LinearLayout) linearLayout.findViewById(com.baidu.tieba.u.feed_item_live_card);
        aiVar.r = (LiveBroadcastCard) linearLayout.findViewById(com.baidu.tieba.u.feed_item_card);
        aiVar.c.setOnClickListener(this.d);
        linearLayout.setOnClickListener(this.d);
        linearLayout.setTag(aiVar);
        return linearLayout;
    }

    public void a(int i, View view) {
        ai aiVar;
        if (view != null && (aiVar = (ai) view.getTag()) != null && aiVar.m != i) {
            switch (i) {
                case 1:
                    b(aiVar);
                    break;
                default:
                    a(aiVar);
                    break;
            }
            aiVar.m = i;
        }
    }

    private void a(ai aiVar) {
        Resources resources = this.a.getResources();
        aiVar.a.setBackgroundResource(com.baidu.tieba.t.forumfeed_frs_list_item_top_bg);
        com.baidu.tbadk.core.util.ay.e((View) aiVar.c, com.baidu.tieba.t.bg_label);
        aiVar.h.setCompoundDrawablesWithIntrinsicBounds(resources.getDrawable(com.baidu.tieba.t.icon_pop_news), (Drawable) null, (Drawable) null, (Drawable) null);
        aiVar.b.setBackgroundResource(com.baidu.tieba.t.forumfeed_frs_list_item_foot_bg);
    }

    private void b(ai aiVar) {
        Resources resources = this.a.getResources();
        aiVar.a.setBackgroundResource(com.baidu.tieba.t.forumfeed_frs_list_item_top_bg_1);
        com.baidu.tbadk.core.util.ay.e((View) aiVar.c, com.baidu.tieba.t.bg_label_1);
        aiVar.h.setCompoundDrawablesWithIntrinsicBounds(resources.getDrawable(com.baidu.tieba.t.icon_pop_news_1), (Drawable) null, (Drawable) null, (Drawable) null);
        aiVar.b.setBackgroundResource(com.baidu.tieba.t.forumfeed_frs_list_item_foot_bg_1);
    }
}
