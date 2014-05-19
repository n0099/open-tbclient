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
import com.baidu.tbadk.core.data.LiveCardData;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.coreExtra.view.LiveBroadcastCard;
import com.baidu.tieba.person.PersonPostListData;
import com.baidu.tieba.view.CommonImageLayout;
import com.baidu.tieba.voice.PlayVoiceBnt;
/* loaded from: classes.dex */
public class y {
    com.baidu.tbadk.editortool.ab a;
    private final com.baidu.tbadk.core.e b;
    private boolean c = true;
    private boolean d = false;
    private final View.OnClickListener e = new z(this);

    public y(com.baidu.tbadk.core.e eVar) {
        this.b = eVar;
        this.a = new com.baidu.tbadk.editortool.ab(this.b);
    }

    public void a(int i, boolean z, float f) {
        this.c = z;
    }

    public void a(boolean z) {
        this.d = z;
    }

    public void a(View view, PersonPostListData.PostList postList) {
        aa aaVar;
        int i = 0;
        if (view.getTag() != null && (aaVar = (aa) view.getTag()) != null) {
            String string = this.b.getResources().getString(com.baidu.tieba.u.forum_name_suffix);
            aaVar.c.setText(String.valueOf(postList.forum_name) + string);
            aaVar.c.setTag(postList.forum_name);
            aaVar.d.setText(postList.title);
            aaVar.c.setVisibility(8);
            aaVar.p.setVisibility(8);
            aaVar.f.setPadding(this.b.getResources().getDimensionPixelSize(com.baidu.tieba.p.listview_item_padding), 0, 0, 0);
            aaVar.f.setText(String.valueOf(postList.forum_name) + string);
            aaVar.h.setText(String.valueOf(postList.reply_num));
            aaVar.g.setText(com.baidu.tbadk.core.util.be.a(postList.create_time * 1000));
            if (postList.abs != null && postList.abs.length > 0 && TextUtils.isEmpty(postList.abs[0].text)) {
                aaVar.e.setText(postList.abs[0].text);
                aaVar.e.setVisibility(0);
            } else {
                aaVar.e.setText((CharSequence) null);
                aaVar.e.setVisibility(8);
            }
            aaVar.k = new StringBuilder(String.valueOf(postList.forum_id)).toString();
            aaVar.l = new StringBuilder(String.valueOf(postList.thread_id)).toString();
            aaVar.j.setVisibility(8);
            LiveCardData a = a(postList.anchor_info);
            if (a.getAuthorId() != 0) {
                aaVar.i.setVisibility(8);
                aaVar.q.setVisibility(0);
                aaVar.r.a(a, this.a);
            } else {
                aaVar.q.setVisibility(8);
                if (com.baidu.tbadk.core.h.a().f()) {
                    aaVar.i.setVisibility(0);
                    PersonPostListData.Media[] mediaArr = postList.media;
                    if (mediaArr != null) {
                        if (mediaArr.length > 0) {
                            int length = mediaArr.length;
                            int i2 = length > 3 ? 3 : length;
                            if (i2 > 0) {
                                com.baidu.tbadk.core.data.k[] kVarArr = new com.baidu.tbadk.core.data.k[i2];
                                for (int i3 = 0; i3 < mediaArr.length && i < i2; i3++) {
                                    if (mediaArr[i3].type == 3 || mediaArr[i3].type == 5) {
                                        com.baidu.tbadk.core.data.k kVar = new com.baidu.tbadk.core.data.k();
                                        if (mediaArr[i3].type == 3) {
                                            kVar.a(mediaArr[i3].water_pic);
                                            kVar.a(mediaArr[i3].type);
                                            kVar.b(mediaArr[i3].water_pic);
                                        } else {
                                            kVar.a(mediaArr[i3].pic_url);
                                            kVar.a(mediaArr[i3].type);
                                            kVar.b(mediaArr[i3].video_url);
                                        }
                                        kVarArr[i] = kVar;
                                        i++;
                                    }
                                }
                                aaVar.i.setShowBig(this.c);
                                aaVar.i.setData(kVarArr);
                                aaVar.i.setImageFrom("other");
                                aaVar.i.setFromCDN(this.d);
                            }
                        } else {
                            aaVar.i.setVisibility(8);
                        }
                    }
                } else {
                    aaVar.i.setVisibility(8);
                }
            }
            aaVar.n = this.c;
            view.setTag(aaVar);
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
        aa aaVar = new aa();
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.b).inflate(com.baidu.tieba.s.forum_feed_item, (ViewGroup) null);
        aaVar.a = (LinearLayout) linearLayout.findViewById(com.baidu.tieba.r.layoutForumTop);
        aaVar.b = (RelativeLayout) linearLayout.findViewById(com.baidu.tieba.r.layoutForumBottom);
        aaVar.c = (TextView) linearLayout.findViewById(com.baidu.tieba.r.textHomeListFrsName);
        aaVar.d = (TextView) linearLayout.findViewById(com.baidu.tieba.r.textHomeListTitle);
        aaVar.e = (TextView) linearLayout.findViewById(com.baidu.tieba.r.textHomeListAbstract);
        aaVar.f = (TextView) linearLayout.findViewById(com.baidu.tieba.r.textHomeListAuthor);
        aaVar.o = (UserIconBox) linearLayout.findViewById(com.baidu.tieba.r.user_icon_box);
        aaVar.p = (UserIconBox) linearLayout.findViewById(com.baidu.tieba.r.user_tshow_icon_box);
        aaVar.g = (TextView) linearLayout.findViewById(com.baidu.tieba.r.textHomeListTime);
        aaVar.h = (TextView) linearLayout.findViewById(com.baidu.tieba.r.textHomeListRplyNum);
        aaVar.i = (CommonImageLayout) linearLayout.findViewById(com.baidu.tieba.r.layoutFeedImage);
        aaVar.j = (PlayVoiceBnt) linearLayout.findViewById(com.baidu.tieba.r.abstract_voice);
        aaVar.q = (LinearLayout) linearLayout.findViewById(com.baidu.tieba.r.feed_item_live_card);
        aaVar.r = (LiveBroadcastCard) linearLayout.findViewById(com.baidu.tieba.r.feed_item_card);
        aaVar.c.setOnClickListener(this.e);
        linearLayout.setOnClickListener(this.e);
        linearLayout.setTag(aaVar);
        return linearLayout;
    }

    public void a(int i, View view) {
        aa aaVar;
        if (view != null && (aaVar = (aa) view.getTag()) != null && aaVar.m != i) {
            switch (i) {
                case 1:
                    b(aaVar);
                    break;
                default:
                    a(aaVar);
                    break;
            }
            aaVar.m = i;
        }
    }

    private void a(aa aaVar) {
        Resources resources = this.b.getResources();
        aaVar.a.setBackgroundResource(com.baidu.tieba.q.forumfeed_frs_list_item_top_bg);
        com.baidu.tbadk.core.util.bc.e((View) aaVar.c, com.baidu.tieba.q.bg_label);
        aaVar.h.setCompoundDrawablesWithIntrinsicBounds(resources.getDrawable(com.baidu.tieba.q.icon_little_comment_s), (Drawable) null, (Drawable) null, (Drawable) null);
        aaVar.b.setBackgroundResource(com.baidu.tieba.q.forumfeed_frs_list_item_foot_bg);
    }

    private void b(aa aaVar) {
        Resources resources = this.b.getResources();
        aaVar.a.setBackgroundResource(com.baidu.tieba.q.forumfeed_frs_list_item_top_bg_1);
        com.baidu.tbadk.core.util.bc.e((View) aaVar.c, com.baidu.tieba.q.bg_label_1);
        aaVar.h.setCompoundDrawablesWithIntrinsicBounds(resources.getDrawable(com.baidu.tieba.q.icon_little_comment_s_1), (Drawable) null, (Drawable) null, (Drawable) null);
        aaVar.b.setBackgroundResource(com.baidu.tieba.q.forumfeed_frs_list_item_foot_bg_1);
    }
}
