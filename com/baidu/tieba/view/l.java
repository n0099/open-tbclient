package com.baidu.tieba.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.lightapp.plugin.videoplayer.coreplayer.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.LiveCardData;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.bk;
import com.baidu.tbadk.core.util.bm;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.coreExtra.view.LiveBroadcastCard;
import com.baidu.tbadk.data.IconData;
import com.baidu.tieba.voice.PlayVoiceBnt;
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class l {
    private final Context a;
    private int b = Constants.MEDIA_INFO;
    private boolean c = true;
    private boolean d = false;
    private float e = 0.4f;
    private LinkedList<IconData> f = null;
    private LinkedList<IconData> g = null;
    private final View.OnClickListener h;

    public l(Context context) {
        this.a = context;
        this.h = new m(this, context);
    }

    public void a(int i, boolean z, float f) {
        this.b = i;
        this.c = z;
        this.e = f;
    }

    public void a(boolean z) {
        this.d = z;
    }

    public void a(View view, com.baidu.tieba.data.r rVar) {
        n nVar;
        int i;
        int i2 = 0;
        if (view.getTag() != null && (nVar = (n) view.getTag()) != null) {
            nVar.c.setText(String.valueOf(rVar.c()) + this.a.getResources().getString(com.baidu.tieba.y.forum_name_suffix));
            nVar.c.setTag(rVar.c());
            this.f = rVar.m();
            if (nVar.o != null) {
                nVar.o.a(this.f, 3, this.a.getResources().getDimensionPixelSize(com.baidu.tieba.t.forumfeed_icon_width), this.a.getResources().getDimensionPixelSize(com.baidu.tieba.t.forumfeed_icon_height), this.a.getResources().getDimensionPixelSize(com.baidu.tieba.t.forumfeed_icon_margin));
            }
            this.g = rVar.a();
            if (nVar.p != null) {
                nVar.p.a(this.g, 2, this.a.getResources().getDimensionPixelSize(com.baidu.tieba.t.small_icon_width), this.a.getResources().getDimensionPixelSize(com.baidu.tieba.t.small_icon_height), this.a.getResources().getDimensionPixelSize(com.baidu.tieba.t.small_icon_margin));
            }
            int skinType = TbadkApplication.m252getInst().getSkinType();
            if (this.g != null && this.g.size() > 0) {
                nVar.f.setPadding(0, 0, 0, 0);
                if (skinType == 1) {
                    nVar.f.setTextColor(this.a.getResources().getColor(com.baidu.tieba.s.cp_cont_h_1));
                } else {
                    nVar.f.setTextColor(this.a.getResources().getColor(com.baidu.tieba.s.cp_cont_h));
                }
            } else {
                nVar.f.setPadding(this.a.getResources().getDimensionPixelSize(com.baidu.tieba.t.listview_item_padding), 0, 0, 0);
                if (skinType == 1) {
                    nVar.f.setTextColor(this.a.getResources().getColor(com.baidu.tieba.s.listview_item_author_time_text_1));
                } else {
                    nVar.f.setTextColor(this.a.getResources().getColor(com.baidu.tieba.s.listview_item_author_time_text));
                }
            }
            nVar.f.setText(rVar.g());
            nVar.h.setText(String.valueOf(rVar.f()));
            nVar.g.setText(bm.a(rVar.h() * 1000));
            if (rVar.i() != null && rVar.i().trim().length() > 0) {
                nVar.e.setText(rVar.i());
                nVar.e.setVisibility(0);
            } else {
                nVar.e.setText((CharSequence) null);
                nVar.e.setVisibility(8);
            }
            nVar.k = rVar.b();
            nVar.l = rVar.d();
            ArrayList<VoiceData.VoiceModel> l = rVar.l();
            if (l != null && l.size() > 0) {
                nVar.j.setVisibility(0);
                VoiceData.VoiceModel voiceModel = l.get(0);
                nVar.j.setVoiceModel(voiceModel);
                nVar.j.setTag(voiceModel);
                nVar.j.c();
            } else {
                nVar.j.setVisibility(8);
            }
            LiveCardData n = rVar.n();
            if (rVar.o()) {
                nVar.i.setVisibility(8);
                nVar.d.setText(c(view, rVar));
                nVar.q.setVisibility(0);
                nVar.r.setData(n);
            } else {
                nVar.q.setVisibility(8);
                if (rVar.j() > 0) {
                    nVar.d.setText(b(view, rVar));
                } else {
                    nVar.d.setText(rVar.e());
                }
                if (com.baidu.tbadk.core.h.a().f()) {
                    nVar.i.setVisibility(0);
                    ArrayList<MediaData> k = rVar.k();
                    if (k != null) {
                        if (k.size() > 0) {
                            int size = k.size();
                            int i3 = size > 3 ? 3 : size;
                            if (i3 > 0) {
                                MediaData[] mediaDataArr = new MediaData[i3];
                                int i4 = 0;
                                while (i2 < k.size() && i4 < i3) {
                                    if (k.get(i2).getType() == 3 || k.get(i2).getType() == 5) {
                                        mediaDataArr[i4] = k.get(i2);
                                        i = i4 + 1;
                                    } else {
                                        i = i4;
                                    }
                                    i2++;
                                    i4 = i;
                                }
                                nVar.i.setShowBig(this.c);
                                nVar.i.setData(mediaDataArr);
                                nVar.i.setImageFrom("other");
                                nVar.i.setFromCDN(this.d);
                            }
                        } else {
                            nVar.i.setVisibility(8);
                        }
                    }
                } else {
                    nVar.i.setVisibility(8);
                }
            }
            nVar.n = this.c;
            view.setTag(nVar);
        }
    }

    private SpannableString b(View view, com.baidu.tieba.data.r rVar) {
        Drawable drawable = view.getResources().getDrawable(com.baidu.tieba.u.icon_elite);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        ImageSpan imageSpan = new ImageSpan(drawable, 1);
        SpannableString spannableString = new SpannableString("  " + ((Object) rVar.e()));
        spannableString.setSpan(imageSpan, 0, 1, 18);
        return spannableString;
    }

    private SpannableString c(View view, com.baidu.tieba.data.r rVar) {
        Drawable drawable;
        if (TbadkApplication.m252getInst().getSkinType() == 1) {
            drawable = view.getResources().getDrawable(com.baidu.tieba.u.icon_live_on_1);
        } else {
            drawable = view.getResources().getDrawable(com.baidu.tieba.u.icon_live_on);
        }
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        ImageSpan imageSpan = new ImageSpan(drawable, 1);
        SpannableString spannableString = new SpannableString("  " + ((Object) rVar.e()));
        spannableString.setSpan(imageSpan, 0, 1, 18);
        return spannableString;
    }

    public View a() {
        n nVar = new n(this);
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.a).inflate(com.baidu.tieba.w.forum_feed_item, (ViewGroup) null);
        nVar.a = (LinearLayout) linearLayout.findViewById(com.baidu.tieba.v.layoutForumTop);
        nVar.b = (RelativeLayout) linearLayout.findViewById(com.baidu.tieba.v.layoutForumBottom);
        nVar.c = (TextView) linearLayout.findViewById(com.baidu.tieba.v.textHomeListFrsName);
        nVar.d = (TextView) linearLayout.findViewById(com.baidu.tieba.v.textHomeListTitle);
        nVar.e = (TextView) linearLayout.findViewById(com.baidu.tieba.v.textHomeListAbstract);
        nVar.f = (TextView) linearLayout.findViewById(com.baidu.tieba.v.textHomeListAuthor);
        nVar.o = (UserIconBox) linearLayout.findViewById(com.baidu.tieba.v.user_icon_box);
        nVar.p = (UserIconBox) linearLayout.findViewById(com.baidu.tieba.v.user_tshow_icon_box);
        nVar.g = (TextView) linearLayout.findViewById(com.baidu.tieba.v.textHomeListTime);
        nVar.h = (TextView) linearLayout.findViewById(com.baidu.tieba.v.textHomeListRplyNum);
        nVar.i = (CommonImageLayout) linearLayout.findViewById(com.baidu.tieba.v.layoutFeedImage);
        nVar.j = (PlayVoiceBnt) linearLayout.findViewById(com.baidu.tieba.v.abstract_voice);
        nVar.q = (LinearLayout) linearLayout.findViewById(com.baidu.tieba.v.feed_item_live_card);
        nVar.r = (LiveBroadcastCard) linearLayout.findViewById(com.baidu.tieba.v.feed_item_card);
        nVar.c.setOnClickListener(this.h);
        linearLayout.setOnClickListener(this.h);
        linearLayout.setTag(nVar);
        return linearLayout;
    }

    public void a(int i, View view) {
        n nVar;
        if (view != null && (nVar = (n) view.getTag()) != null && nVar.m != i) {
            switch (i) {
                case 1:
                    b(nVar);
                    break;
                default:
                    a(nVar);
                    break;
            }
            nVar.m = i;
        }
    }

    private void a(n nVar) {
        Resources resources = this.a.getResources();
        nVar.a.setBackgroundResource(com.baidu.tieba.u.forumfeed_frs_list_item_top_bg);
        bk.e((View) nVar.c, com.baidu.tieba.u.bg_label);
        nVar.h.setCompoundDrawablesWithIntrinsicBounds(resources.getDrawable(com.baidu.tieba.u.icon_little_comment_s), (Drawable) null, (Drawable) null, (Drawable) null);
        nVar.b.setBackgroundResource(com.baidu.tieba.u.forumfeed_frs_list_item_foot_bg);
    }

    private void b(n nVar) {
        Resources resources = this.a.getResources();
        nVar.a.setBackgroundResource(com.baidu.tieba.u.forumfeed_frs_list_item_top_bg_1);
        bk.e((View) nVar.c, com.baidu.tieba.u.bg_label_1);
        nVar.h.setCompoundDrawablesWithIntrinsicBounds(resources.getDrawable(com.baidu.tieba.u.icon_little_comment_s_1), (Drawable) null, (Drawable) null, (Drawable) null);
        nVar.b.setBackgroundResource(com.baidu.tieba.u.forumfeed_frs_list_item_foot_bg_1);
    }
}
