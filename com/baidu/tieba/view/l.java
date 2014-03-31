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
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.IconData;
import com.baidu.tieba.voice.PlayVoiceBnt;
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes.dex */
public final class l {
    private final Context a;
    private final View.OnClickListener h;
    private int b = 200;
    private boolean c = true;
    private boolean d = false;
    private float e = 0.4f;
    private LinkedList<IconData> f = null;
    private LinkedList<IconData> g = null;
    private final n i = new n(this, (byte) 0);

    public l(Context context) {
        this.a = context;
        this.h = new m(this, context);
    }

    public final void a(int i, boolean z, float f) {
        this.b = i;
        this.c = z;
        this.e = f;
    }

    public final void a(boolean z) {
        this.d = z;
    }

    public final void a(View view, com.baidu.tieba.data.q qVar) {
        o oVar;
        int i;
        int i2 = 0;
        if (view.getTag() != null && (oVar = (o) view.getTag()) != null) {
            oVar.c.setText(String.valueOf(qVar.c()) + this.a.getResources().getString(com.baidu.tieba.a.k.forum_name_suffix));
            oVar.c.setTag(qVar.c());
            if (qVar.j() > 0) {
                Drawable drawable = view.getResources().getDrawable(com.baidu.tieba.a.g.icon_elite);
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                ImageSpan imageSpan = new ImageSpan(drawable, 1);
                SpannableString spannableString = new SpannableString("  " + ((Object) qVar.e()));
                spannableString.setSpan(imageSpan, 0, 1, 18);
                oVar.d.setText(spannableString);
            } else {
                oVar.d.setText(qVar.e());
            }
            this.f = qVar.m();
            if (oVar.o != null) {
                oVar.o.a(this.f, 3, this.a.getResources().getDimensionPixelSize(com.baidu.tieba.a.f.forumfeed_icon_width), this.a.getResources().getDimensionPixelSize(com.baidu.tieba.a.f.forumfeed_icon_height), this.a.getResources().getDimensionPixelSize(com.baidu.tieba.a.f.forumfeed_icon_margin));
            }
            this.g = qVar.a();
            if (oVar.p != null) {
                oVar.p.a(this.g, 2, this.a.getResources().getDimensionPixelSize(com.baidu.tieba.a.f.small_icon_width), this.a.getResources().getDimensionPixelSize(com.baidu.tieba.a.f.small_icon_height), this.a.getResources().getDimensionPixelSize(com.baidu.tieba.a.f.small_icon_margin));
            }
            int l = TbadkApplication.j().l();
            if (this.g != null && this.g.size() > 0) {
                oVar.f.setPadding(0, 0, 0, 0);
                if (l == 1) {
                    oVar.f.setTextColor(this.a.getResources().getColor(com.baidu.tieba.a.e.frs_lv_item_user_name_vip_1));
                } else {
                    oVar.f.setTextColor(this.a.getResources().getColor(com.baidu.tieba.a.e.frs_lv_item_user_name_vip));
                }
            } else {
                oVar.f.setPadding(this.a.getResources().getDimensionPixelSize(com.baidu.tieba.a.f.listview_item_padding), 0, 0, 0);
                if (l == 1) {
                    oVar.f.setTextColor(this.a.getResources().getColor(com.baidu.tieba.a.e.listview_item_author_time_text_1));
                } else {
                    oVar.f.setTextColor(this.a.getResources().getColor(com.baidu.tieba.a.e.listview_item_author_time_text));
                }
            }
            oVar.f.setText(qVar.g());
            oVar.h.setText(String.valueOf(qVar.f()));
            oVar.g.setText(bc.a(qVar.h() * 1000));
            if (qVar.i() != null && qVar.i().trim().length() > 0) {
                oVar.e.setText(qVar.i());
                oVar.e.setVisibility(0);
            } else {
                oVar.e.setText((CharSequence) null);
                oVar.e.setVisibility(8);
            }
            oVar.k = qVar.b();
            oVar.l = qVar.d();
            ArrayList<VoiceData.VoiceModel> l2 = qVar.l();
            if (l2 != null && l2.size() > 0) {
                oVar.j.setVisibility(0);
                VoiceData.VoiceModel voiceModel = l2.get(0);
                oVar.j.setVoiceModel(voiceModel);
                oVar.j.setTag(voiceModel);
                oVar.j.a();
            } else {
                oVar.j.setVisibility(8);
            }
            if (com.baidu.tbadk.core.h.a().f()) {
                oVar.i.setVisibility(0);
                ArrayList<com.baidu.tbadk.core.data.j> k = qVar.k();
                if (k != null) {
                    if (k.size() > 0) {
                        int size = k.size();
                        int i3 = size > 3 ? 3 : size;
                        if (i3 > 0) {
                            com.baidu.tbadk.core.data.j[] jVarArr = new com.baidu.tbadk.core.data.j[i3];
                            int i4 = 0;
                            while (i2 < k.size() && i4 < i3) {
                                if (k.get(i2).b() == 3 || k.get(i2).b() == 5) {
                                    jVarArr[i4] = k.get(i2);
                                    i = i4 + 1;
                                } else {
                                    i = i4;
                                }
                                i2++;
                                i4 = i;
                            }
                            oVar.i.setShowBig(this.c);
                            oVar.i.setData(jVarArr);
                            oVar.i.setImageFrom("other");
                            oVar.i.setFromCDN(this.d);
                        }
                    } else {
                        oVar.i.setVisibility(8);
                    }
                }
            } else {
                oVar.i.setVisibility(8);
            }
            oVar.n = this.c;
            view.setTag(oVar);
        }
    }

    public final View a() {
        o oVar = new o(this);
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.a).inflate(com.baidu.tieba.a.i.forum_feed_item, (ViewGroup) null);
        oVar.a = (LinearLayout) linearLayout.findViewById(com.baidu.tieba.a.h.layoutForumTop);
        oVar.b = (RelativeLayout) linearLayout.findViewById(com.baidu.tieba.a.h.layoutForumBottom);
        oVar.c = (TextView) linearLayout.findViewById(com.baidu.tieba.a.h.textHomeListFrsName);
        oVar.d = (TextView) linearLayout.findViewById(com.baidu.tieba.a.h.textHomeListTitle);
        oVar.e = (TextView) linearLayout.findViewById(com.baidu.tieba.a.h.textHomeListAbstract);
        oVar.f = (TextView) linearLayout.findViewById(com.baidu.tieba.a.h.textHomeListAuthor);
        oVar.o = (UserIconBox) linearLayout.findViewById(com.baidu.tieba.a.h.user_icon_box);
        oVar.p = (UserIconBox) linearLayout.findViewById(com.baidu.tieba.a.h.user_tshow_icon_box);
        oVar.g = (TextView) linearLayout.findViewById(com.baidu.tieba.a.h.textHomeListTime);
        oVar.h = (TextView) linearLayout.findViewById(com.baidu.tieba.a.h.textHomeListRplyNum);
        oVar.i = (CommonImageLayout) linearLayout.findViewById(com.baidu.tieba.a.h.layoutFeedImage);
        oVar.j = (PlayVoiceBnt) linearLayout.findViewById(com.baidu.tieba.a.h.abstract_voice);
        oVar.c.setOnClickListener(this.h);
        linearLayout.setOnClickListener(this.h);
        linearLayout.setTag(oVar);
        return linearLayout;
    }

    public final void a(int i, View view) {
        o oVar;
        if (view != null && (oVar = (o) view.getTag()) != null && oVar.m != i) {
            switch (i) {
                case 1:
                    Resources resources = this.a.getResources();
                    oVar.a.setBackgroundResource(com.baidu.tieba.a.g.forumfeed_frs_list_item_top_bg_1);
                    ba.e((View) oVar.c, com.baidu.tieba.a.g.bg_label_1);
                    oVar.h.setCompoundDrawablesWithIntrinsicBounds(resources.getDrawable(com.baidu.tieba.a.g.icon_little_comment_s_1), (Drawable) null, (Drawable) null, (Drawable) null);
                    oVar.b.setBackgroundResource(com.baidu.tieba.a.g.forumfeed_frs_list_item_foot_bg_1);
                    break;
                default:
                    Resources resources2 = this.a.getResources();
                    oVar.a.setBackgroundResource(com.baidu.tieba.a.g.forumfeed_frs_list_item_top_bg);
                    ba.e((View) oVar.c, com.baidu.tieba.a.g.bg_label);
                    oVar.h.setCompoundDrawablesWithIntrinsicBounds(resources2.getDrawable(com.baidu.tieba.a.g.icon_little_comment_s), (Drawable) null, (Drawable) null, (Drawable) null);
                    oVar.b.setBackgroundResource(com.baidu.tieba.a.g.forumfeed_frs_list_item_foot_bg);
                    break;
            }
            oVar.m = i;
        }
    }
}
