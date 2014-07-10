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
public class ah {
    private final BaseFragmentActivity a;
    private boolean b = true;
    private boolean c = false;
    private final View.OnClickListener d = new ai(this);

    public ah(BaseFragmentActivity baseFragmentActivity) {
        this.a = baseFragmentActivity;
    }

    public void a(int i, boolean z, float f) {
        this.b = z;
    }

    public void a(boolean z) {
        this.c = z;
    }

    public void a(View view, PersonPostListData.PostList postList) {
        aj ajVar;
        int i = 0;
        if (view.getTag() != null && (ajVar = (aj) view.getTag()) != null) {
            String string = this.a.getResources().getString(com.baidu.tieba.y.forum_name_suffix);
            ajVar.c.setText(String.valueOf(postList.forum_name) + string);
            ajVar.c.setTag(postList.forum_name);
            ajVar.d.setText(postList.title);
            ajVar.c.setVisibility(8);
            ajVar.p.setVisibility(8);
            ajVar.f.setPadding(this.a.getResources().getDimensionPixelSize(com.baidu.tieba.t.listview_item_padding), 0, 0, 0);
            ajVar.f.setText(String.valueOf(postList.forum_name) + string);
            ajVar.h.setText(String.valueOf(postList.reply_num));
            ajVar.g.setText(com.baidu.tbadk.core.util.bm.a(postList.create_time * 1000));
            if (postList.abs != null && postList.abs.length > 0 && TextUtils.isEmpty(postList.abs[0].text)) {
                ajVar.e.setText(postList.abs[0].text);
                ajVar.e.setVisibility(0);
            } else {
                ajVar.e.setText((CharSequence) null);
                ajVar.e.setVisibility(8);
            }
            ajVar.k = new StringBuilder(String.valueOf(postList.forum_id)).toString();
            ajVar.l = new StringBuilder(String.valueOf(postList.thread_id)).toString();
            ajVar.j.setVisibility(8);
            LiveCardData a = a(postList.anchor_info);
            if (a.getAuthorId() != 0) {
                ajVar.i.setVisibility(8);
                ajVar.q.setVisibility(0);
                ajVar.r.setData(a);
            } else {
                ajVar.q.setVisibility(8);
                if (com.baidu.tbadk.core.h.a().f()) {
                    ajVar.i.setVisibility(0);
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
                                ajVar.i.setShowBig(this.b);
                                ajVar.i.setData(mediaDataArr);
                                ajVar.i.setImageFrom("other");
                                ajVar.i.setFromCDN(this.c);
                            }
                        } else {
                            ajVar.i.setVisibility(8);
                        }
                    }
                } else {
                    ajVar.i.setVisibility(8);
                }
            }
            ajVar.n = this.b;
            view.setTag(ajVar);
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
        aj ajVar = new aj();
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.a).inflate(com.baidu.tieba.w.forum_feed_item, (ViewGroup) null);
        ajVar.a = (LinearLayout) linearLayout.findViewById(com.baidu.tieba.v.layoutForumTop);
        ajVar.b = (RelativeLayout) linearLayout.findViewById(com.baidu.tieba.v.layoutForumBottom);
        ajVar.c = (TextView) linearLayout.findViewById(com.baidu.tieba.v.textHomeListFrsName);
        ajVar.d = (TextView) linearLayout.findViewById(com.baidu.tieba.v.textHomeListTitle);
        ajVar.e = (TextView) linearLayout.findViewById(com.baidu.tieba.v.textHomeListAbstract);
        ajVar.f = (TextView) linearLayout.findViewById(com.baidu.tieba.v.textHomeListAuthor);
        ajVar.o = (UserIconBox) linearLayout.findViewById(com.baidu.tieba.v.user_icon_box);
        ajVar.p = (UserIconBox) linearLayout.findViewById(com.baidu.tieba.v.user_tshow_icon_box);
        ajVar.g = (TextView) linearLayout.findViewById(com.baidu.tieba.v.textHomeListTime);
        ajVar.h = (TextView) linearLayout.findViewById(com.baidu.tieba.v.textHomeListRplyNum);
        ajVar.i = (CommonImageLayout) linearLayout.findViewById(com.baidu.tieba.v.layoutFeedImage);
        ajVar.j = (PlayVoiceBnt) linearLayout.findViewById(com.baidu.tieba.v.abstract_voice);
        ajVar.q = (LinearLayout) linearLayout.findViewById(com.baidu.tieba.v.feed_item_live_card);
        ajVar.r = (LiveBroadcastCard) linearLayout.findViewById(com.baidu.tieba.v.feed_item_card);
        ajVar.c.setOnClickListener(this.d);
        linearLayout.setOnClickListener(this.d);
        linearLayout.setTag(ajVar);
        return linearLayout;
    }

    public void a(int i, View view) {
        aj ajVar;
        if (view != null && (ajVar = (aj) view.getTag()) != null && ajVar.m != i) {
            switch (i) {
                case 1:
                    b(ajVar);
                    break;
                default:
                    a(ajVar);
                    break;
            }
            ajVar.m = i;
        }
    }

    private void a(aj ajVar) {
        Resources resources = this.a.getResources();
        ajVar.a.setBackgroundResource(com.baidu.tieba.u.forumfeed_frs_list_item_top_bg);
        com.baidu.tbadk.core.util.bk.e((View) ajVar.c, com.baidu.tieba.u.bg_label);
        ajVar.h.setCompoundDrawablesWithIntrinsicBounds(resources.getDrawable(com.baidu.tieba.u.icon_pop_news), (Drawable) null, (Drawable) null, (Drawable) null);
        ajVar.b.setBackgroundResource(com.baidu.tieba.u.forumfeed_frs_list_item_foot_bg);
    }

    private void b(aj ajVar) {
        Resources resources = this.a.getResources();
        ajVar.a.setBackgroundResource(com.baidu.tieba.u.forumfeed_frs_list_item_top_bg_1);
        com.baidu.tbadk.core.util.bk.e((View) ajVar.c, com.baidu.tieba.u.bg_label_1);
        ajVar.h.setCompoundDrawablesWithIntrinsicBounds(resources.getDrawable(com.baidu.tieba.u.icon_pop_news_1), (Drawable) null, (Drawable) null, (Drawable) null);
        ajVar.b.setBackgroundResource(com.baidu.tieba.u.forumfeed_frs_list_item_foot_bg_1);
    }
}
