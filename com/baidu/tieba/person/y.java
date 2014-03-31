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
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tieba.person.PersonPostListData;
import com.baidu.tieba.view.CommonImageLayout;
import com.baidu.tieba.voice.PlayVoiceBnt;
/* loaded from: classes.dex */
public final class y {
    private final com.baidu.tbadk.core.e a;
    private boolean b = true;
    private boolean c = false;
    private final View.OnClickListener d = new z(this);

    public y(com.baidu.tbadk.core.e eVar) {
        this.a = eVar;
    }

    public final void a(boolean z) {
        this.b = z;
    }

    public final void b(boolean z) {
        this.c = z;
    }

    public final void a(View view, PersonPostListData.PostList postList) {
        aa aaVar;
        int i = 0;
        if (view.getTag() != null && (aaVar = (aa) view.getTag()) != null) {
            String string = this.a.getResources().getString(com.baidu.tieba.a.k.forum_name_suffix);
            aaVar.c.setText(String.valueOf(postList.forum_name) + string);
            aaVar.c.setTag(postList.forum_name);
            aaVar.d.setText(postList.title);
            aaVar.c.setVisibility(8);
            aaVar.p.setVisibility(8);
            aaVar.f.setPadding(this.a.getResources().getDimensionPixelSize(com.baidu.tieba.a.f.listview_item_padding), 0, 0, 0);
            aaVar.f.setText(String.valueOf(postList.forum_name) + string);
            aaVar.h.setText(String.valueOf(postList.reply_num));
            aaVar.g.setText(com.baidu.tbadk.core.util.bc.a(postList.create_time * 1000));
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
            if (com.baidu.tbadk.core.h.a().f()) {
                aaVar.i.setVisibility(0);
                PersonPostListData.Media[] mediaArr = postList.media;
                if (mediaArr != null) {
                    if (mediaArr.length > 0) {
                        int length = mediaArr.length;
                        int i2 = length > 3 ? 3 : length;
                        if (i2 > 0) {
                            com.baidu.tbadk.core.data.j[] jVarArr = new com.baidu.tbadk.core.data.j[i2];
                            for (int i3 = 0; i3 < mediaArr.length && i < i2; i3++) {
                                if (mediaArr[i3].type == 3 || mediaArr[i3].type == 5) {
                                    com.baidu.tbadk.core.data.j jVar = new com.baidu.tbadk.core.data.j();
                                    if (mediaArr[i3].type == 3) {
                                        jVar.a(mediaArr[i3].water_pic);
                                        jVar.a(mediaArr[i3].type);
                                        jVar.b(mediaArr[i3].water_pic);
                                    } else {
                                        jVar.a(mediaArr[i3].pic_url);
                                        jVar.a(mediaArr[i3].type);
                                        jVar.b(mediaArr[i3].video_url);
                                    }
                                    jVarArr[i] = jVar;
                                    i++;
                                }
                            }
                            aaVar.i.setShowBig(this.b);
                            aaVar.i.setData(jVarArr);
                            aaVar.i.setImageFrom("other");
                            aaVar.i.setFromCDN(this.c);
                        }
                    } else {
                        aaVar.i.setVisibility(8);
                    }
                }
            } else {
                aaVar.i.setVisibility(8);
            }
            aaVar.n = this.b;
            view.setTag(aaVar);
        }
    }

    public final View a() {
        aa aaVar = new aa();
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.a).inflate(com.baidu.tieba.a.i.forum_feed_item, (ViewGroup) null);
        aaVar.a = (LinearLayout) linearLayout.findViewById(com.baidu.tieba.a.h.layoutForumTop);
        aaVar.b = (RelativeLayout) linearLayout.findViewById(com.baidu.tieba.a.h.layoutForumBottom);
        aaVar.c = (TextView) linearLayout.findViewById(com.baidu.tieba.a.h.textHomeListFrsName);
        aaVar.d = (TextView) linearLayout.findViewById(com.baidu.tieba.a.h.textHomeListTitle);
        aaVar.e = (TextView) linearLayout.findViewById(com.baidu.tieba.a.h.textHomeListAbstract);
        aaVar.f = (TextView) linearLayout.findViewById(com.baidu.tieba.a.h.textHomeListAuthor);
        aaVar.o = (UserIconBox) linearLayout.findViewById(com.baidu.tieba.a.h.user_icon_box);
        aaVar.p = (UserIconBox) linearLayout.findViewById(com.baidu.tieba.a.h.user_tshow_icon_box);
        aaVar.g = (TextView) linearLayout.findViewById(com.baidu.tieba.a.h.textHomeListTime);
        aaVar.h = (TextView) linearLayout.findViewById(com.baidu.tieba.a.h.textHomeListRplyNum);
        aaVar.i = (CommonImageLayout) linearLayout.findViewById(com.baidu.tieba.a.h.layoutFeedImage);
        aaVar.j = (PlayVoiceBnt) linearLayout.findViewById(com.baidu.tieba.a.h.abstract_voice);
        aaVar.c.setOnClickListener(this.d);
        linearLayout.setOnClickListener(this.d);
        linearLayout.setTag(aaVar);
        return linearLayout;
    }

    public final void a(int i, View view) {
        aa aaVar;
        if (view != null && (aaVar = (aa) view.getTag()) != null && aaVar.m != i) {
            switch (i) {
                case 1:
                    Resources resources = this.a.getResources();
                    aaVar.a.setBackgroundResource(com.baidu.tieba.a.g.forumfeed_frs_list_item_top_bg_1);
                    com.baidu.tbadk.core.util.ba.e((View) aaVar.c, com.baidu.tieba.a.g.bg_label_1);
                    aaVar.h.setCompoundDrawablesWithIntrinsicBounds(resources.getDrawable(com.baidu.tieba.a.g.icon_little_comment_s_1), (Drawable) null, (Drawable) null, (Drawable) null);
                    aaVar.b.setBackgroundResource(com.baidu.tieba.a.g.forumfeed_frs_list_item_foot_bg_1);
                    break;
                default:
                    Resources resources2 = this.a.getResources();
                    aaVar.a.setBackgroundResource(com.baidu.tieba.a.g.forumfeed_frs_list_item_top_bg);
                    com.baidu.tbadk.core.util.ba.e((View) aaVar.c, com.baidu.tieba.a.g.bg_label);
                    aaVar.h.setCompoundDrawablesWithIntrinsicBounds(resources2.getDrawable(com.baidu.tieba.a.g.icon_little_comment_s), (Drawable) null, (Drawable) null, (Drawable) null);
                    aaVar.b.setBackgroundResource(com.baidu.tieba.a.g.forumfeed_frs_list_item_foot_bg);
                    break;
            }
            aaVar.m = i;
        }
    }
}
