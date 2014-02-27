package com.baidu.tieba.person;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.person.PersonPostListData;
import com.baidu.tieba.view.CommonImageLayout;
import com.baidu.tieba.view.UserIconBox;
import com.baidu.tieba.voice.PlayVoiceBnt;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public final class az {
    private Context a;
    private boolean b = true;
    private boolean c = false;
    private View.OnClickListener d = new ba(this);

    public az(Context context) {
        this.a = context;
    }

    public final void a(boolean z) {
        this.b = z;
    }

    public final void b(boolean z) {
        this.c = z;
    }

    public final void a(View view, PersonPostListData.PostList postList) {
        bb bbVar;
        int i = 0;
        if (view.getTag() != null && (bbVar = (bb) view.getTag()) != null) {
            String string = this.a.getResources().getString(R.string.forum_name_suffix);
            bbVar.c.setText(String.valueOf(postList.forum_name) + string);
            bbVar.c.setTag(postList.forum_name);
            bbVar.d.setText(postList.title);
            bbVar.c.setVisibility(8);
            bbVar.p.setVisibility(8);
            bbVar.f.setPadding(this.a.getResources().getDimensionPixelSize(R.dimen.listview_item_padding), 0, 0, 0);
            bbVar.f.setText(String.valueOf(postList.forum_name) + string);
            bbVar.h.setText(String.valueOf(postList.reply_num));
            bbVar.g.setText(com.baidu.tieba.util.bs.a(postList.create_time * 1000));
            if (postList.abs != null && postList.abs.length > 0 && TextUtils.isEmpty(postList.abs[0].text)) {
                bbVar.e.setText(postList.abs[0].text);
                bbVar.e.setVisibility(0);
            } else {
                bbVar.e.setText((CharSequence) null);
                bbVar.e.setVisibility(8);
            }
            bbVar.k = new StringBuilder(String.valueOf(postList.forum_id)).toString();
            bbVar.l = new StringBuilder(String.valueOf(postList.thread_id)).toString();
            bbVar.j.setVisibility(8);
            if (com.baidu.tieba.h.a.a().f()) {
                bbVar.i.setVisibility(0);
                PersonPostListData.Media[] mediaArr = postList.media;
                if (mediaArr != null) {
                    if (mediaArr.length > 0) {
                        int length = mediaArr.length;
                        int i2 = length > 3 ? 3 : length;
                        if (i2 > 0) {
                            com.baidu.tieba.data.ah[] ahVarArr = new com.baidu.tieba.data.ah[i2];
                            for (int i3 = 0; i3 < mediaArr.length && i < i2; i3++) {
                                if (mediaArr[i3].type == 3 || mediaArr[i3].type == 5) {
                                    com.baidu.tieba.data.ah ahVar = new com.baidu.tieba.data.ah();
                                    if (mediaArr[i3].type == 3) {
                                        ahVar.a(mediaArr[i3].water_pic);
                                        ahVar.a(mediaArr[i3].type);
                                        ahVar.b(mediaArr[i3].water_pic);
                                    } else {
                                        ahVar.a(mediaArr[i3].pic_url);
                                        ahVar.a(mediaArr[i3].type);
                                        ahVar.b(mediaArr[i3].video_url);
                                    }
                                    ahVarArr[i] = ahVar;
                                    i++;
                                }
                            }
                            bbVar.i.setShowBig(this.b);
                            bbVar.i.setData(ahVarArr);
                            bbVar.i.setImageFrom("other");
                            bbVar.i.setFromCDN(this.c);
                        }
                    } else {
                        bbVar.i.setVisibility(8);
                    }
                }
            } else {
                bbVar.i.setVisibility(8);
            }
            bbVar.n = this.b;
            view.setTag(bbVar);
        }
    }

    public final View a() {
        bb bbVar = new bb();
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.a).inflate(R.layout.forum_feed_item, (ViewGroup) null);
        bbVar.a = (LinearLayout) linearLayout.findViewById(R.id.layoutForumTop);
        bbVar.b = (RelativeLayout) linearLayout.findViewById(R.id.layoutForumBottom);
        bbVar.c = (TextView) linearLayout.findViewById(R.id.textHomeListFrsName);
        bbVar.d = (TextView) linearLayout.findViewById(R.id.textHomeListTitle);
        bbVar.e = (TextView) linearLayout.findViewById(R.id.textHomeListAbstract);
        bbVar.f = (TextView) linearLayout.findViewById(R.id.textHomeListAuthor);
        bbVar.o = (UserIconBox) linearLayout.findViewById(R.id.user_icon_box);
        bbVar.p = (UserIconBox) linearLayout.findViewById(R.id.user_tshow_icon_box);
        bbVar.g = (TextView) linearLayout.findViewById(R.id.textHomeListTime);
        bbVar.h = (TextView) linearLayout.findViewById(R.id.textHomeListRplyNum);
        bbVar.i = (CommonImageLayout) linearLayout.findViewById(R.id.layoutFeedImage);
        bbVar.j = (PlayVoiceBnt) linearLayout.findViewById(R.id.abstract_voice);
        bbVar.c.setOnClickListener(this.d);
        linearLayout.setOnClickListener(this.d);
        linearLayout.setTag(bbVar);
        return linearLayout;
    }

    public final void a(int i, View view) {
        bb bbVar;
        if (view != null && (bbVar = (bb) view.getTag()) != null && bbVar.m != i) {
            switch (i) {
                case 1:
                    Resources resources = this.a.getResources();
                    bbVar.a.setBackgroundResource(R.drawable.forumfeed_frs_list_item_top_bg_1);
                    com.baidu.tieba.util.bq.e((View) bbVar.c, (int) R.drawable.bg_label_1);
                    bbVar.h.setCompoundDrawablesWithIntrinsicBounds(resources.getDrawable(R.drawable.icon_little_comment_s_1), (Drawable) null, (Drawable) null, (Drawable) null);
                    bbVar.b.setBackgroundResource(R.drawable.forumfeed_frs_list_item_foot_bg_1);
                    break;
                default:
                    Resources resources2 = this.a.getResources();
                    bbVar.a.setBackgroundResource(R.drawable.forumfeed_frs_list_item_top_bg);
                    com.baidu.tieba.util.bq.e((View) bbVar.c, (int) R.drawable.bg_label);
                    bbVar.h.setCompoundDrawablesWithIntrinsicBounds(resources2.getDrawable(R.drawable.icon_little_comment_s), (Drawable) null, (Drawable) null, (Drawable) null);
                    bbVar.b.setBackgroundResource(R.drawable.forumfeed_frs_list_item_foot_bg);
                    break;
            }
            bbVar.m = i;
        }
    }
}
