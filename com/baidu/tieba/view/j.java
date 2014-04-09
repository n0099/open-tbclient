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
public final class j {
    private final Context a;
    private final View.OnClickListener h;
    private int b = 200;
    private boolean c = true;
    private boolean d = false;
    private float e = 0.4f;
    private LinkedList<IconData> f = null;
    private LinkedList<IconData> g = null;
    private final l i = new l(this, (byte) 0);

    public j(Context context) {
        this.a = context;
        this.h = new k(this, context);
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
        m mVar;
        int i;
        int i2 = 0;
        if (view.getTag() != null && (mVar = (m) view.getTag()) != null) {
            mVar.c.setText(String.valueOf(qVar.c()) + this.a.getResources().getString(com.baidu.tieba.a.k.forum_name_suffix));
            mVar.c.setTag(qVar.c());
            if (qVar.j() > 0) {
                Drawable drawable = view.getResources().getDrawable(com.baidu.tieba.a.g.icon_elite);
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                ImageSpan imageSpan = new ImageSpan(drawable, 1);
                SpannableString spannableString = new SpannableString("  " + ((Object) qVar.e()));
                spannableString.setSpan(imageSpan, 0, 1, 18);
                mVar.d.setText(spannableString);
            } else {
                mVar.d.setText(qVar.e());
            }
            this.f = qVar.m();
            if (mVar.o != null) {
                mVar.o.a(this.f, 3, this.a.getResources().getDimensionPixelSize(com.baidu.tieba.a.f.forumfeed_icon_width), this.a.getResources().getDimensionPixelSize(com.baidu.tieba.a.f.forumfeed_icon_height), this.a.getResources().getDimensionPixelSize(com.baidu.tieba.a.f.forumfeed_icon_margin));
            }
            this.g = qVar.a();
            if (mVar.p != null) {
                mVar.p.a(this.g, 2, this.a.getResources().getDimensionPixelSize(com.baidu.tieba.a.f.small_icon_width), this.a.getResources().getDimensionPixelSize(com.baidu.tieba.a.f.small_icon_height), this.a.getResources().getDimensionPixelSize(com.baidu.tieba.a.f.small_icon_margin));
            }
            int l = TbadkApplication.j().l();
            if (this.g != null && this.g.size() > 0) {
                mVar.f.setPadding(0, 0, 0, 0);
                if (l == 1) {
                    mVar.f.setTextColor(this.a.getResources().getColor(com.baidu.tieba.a.e.frs_lv_item_user_name_vip_1));
                } else {
                    mVar.f.setTextColor(this.a.getResources().getColor(com.baidu.tieba.a.e.frs_lv_item_user_name_vip));
                }
            } else {
                mVar.f.setPadding(this.a.getResources().getDimensionPixelSize(com.baidu.tieba.a.f.listview_item_padding), 0, 0, 0);
                if (l == 1) {
                    mVar.f.setTextColor(this.a.getResources().getColor(com.baidu.tieba.a.e.listview_item_author_time_text_1));
                } else {
                    mVar.f.setTextColor(this.a.getResources().getColor(com.baidu.tieba.a.e.listview_item_author_time_text));
                }
            }
            mVar.f.setText(qVar.g());
            mVar.h.setText(String.valueOf(qVar.f()));
            mVar.g.setText(bc.a(qVar.h() * 1000));
            if (qVar.i() != null && qVar.i().trim().length() > 0) {
                mVar.e.setText(qVar.i());
                mVar.e.setVisibility(0);
            } else {
                mVar.e.setText((CharSequence) null);
                mVar.e.setVisibility(8);
            }
            mVar.k = qVar.b();
            mVar.l = qVar.d();
            ArrayList<VoiceData.VoiceModel> l2 = qVar.l();
            if (l2 != null && l2.size() > 0) {
                mVar.j.setVisibility(0);
                VoiceData.VoiceModel voiceModel = l2.get(0);
                mVar.j.setVoiceModel(voiceModel);
                mVar.j.setTag(voiceModel);
                mVar.j.a();
            } else {
                mVar.j.setVisibility(8);
            }
            if (com.baidu.tbadk.core.h.a().f()) {
                mVar.i.setVisibility(0);
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
                            mVar.i.setShowBig(this.c);
                            mVar.i.setData(jVarArr);
                            mVar.i.setImageFrom("other");
                            mVar.i.setFromCDN(this.d);
                        }
                    } else {
                        mVar.i.setVisibility(8);
                    }
                }
            } else {
                mVar.i.setVisibility(8);
            }
            mVar.n = this.c;
            view.setTag(mVar);
        }
    }

    public final View a() {
        m mVar = new m(this);
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.a).inflate(com.baidu.tieba.a.i.forum_feed_item, (ViewGroup) null);
        mVar.a = (LinearLayout) linearLayout.findViewById(com.baidu.tieba.a.h.layoutForumTop);
        mVar.b = (RelativeLayout) linearLayout.findViewById(com.baidu.tieba.a.h.layoutForumBottom);
        mVar.c = (TextView) linearLayout.findViewById(com.baidu.tieba.a.h.textHomeListFrsName);
        mVar.d = (TextView) linearLayout.findViewById(com.baidu.tieba.a.h.textHomeListTitle);
        mVar.e = (TextView) linearLayout.findViewById(com.baidu.tieba.a.h.textHomeListAbstract);
        mVar.f = (TextView) linearLayout.findViewById(com.baidu.tieba.a.h.textHomeListAuthor);
        mVar.o = (UserIconBox) linearLayout.findViewById(com.baidu.tieba.a.h.user_icon_box);
        mVar.p = (UserIconBox) linearLayout.findViewById(com.baidu.tieba.a.h.user_tshow_icon_box);
        mVar.g = (TextView) linearLayout.findViewById(com.baidu.tieba.a.h.textHomeListTime);
        mVar.h = (TextView) linearLayout.findViewById(com.baidu.tieba.a.h.textHomeListRplyNum);
        mVar.i = (CommonImageLayout) linearLayout.findViewById(com.baidu.tieba.a.h.layoutFeedImage);
        mVar.j = (PlayVoiceBnt) linearLayout.findViewById(com.baidu.tieba.a.h.abstract_voice);
        mVar.c.setOnClickListener(this.h);
        linearLayout.setOnClickListener(this.h);
        linearLayout.setTag(mVar);
        return linearLayout;
    }

    public final void a(int i, View view) {
        m mVar;
        if (view != null && (mVar = (m) view.getTag()) != null && mVar.m != i) {
            switch (i) {
                case 1:
                    Resources resources = this.a.getResources();
                    mVar.a.setBackgroundResource(com.baidu.tieba.a.g.forumfeed_frs_list_item_top_bg_1);
                    ba.e((View) mVar.c, com.baidu.tieba.a.g.bg_label_1);
                    mVar.h.setCompoundDrawablesWithIntrinsicBounds(resources.getDrawable(com.baidu.tieba.a.g.icon_little_comment_s_1), (Drawable) null, (Drawable) null, (Drawable) null);
                    mVar.b.setBackgroundResource(com.baidu.tieba.a.g.forumfeed_frs_list_item_foot_bg_1);
                    break;
                default:
                    Resources resources2 = this.a.getResources();
                    mVar.a.setBackgroundResource(com.baidu.tieba.a.g.forumfeed_frs_list_item_top_bg);
                    ba.e((View) mVar.c, com.baidu.tieba.a.g.bg_label);
                    mVar.h.setCompoundDrawablesWithIntrinsicBounds(resources2.getDrawable(com.baidu.tieba.a.g.icon_little_comment_s), (Drawable) null, (Drawable) null, (Drawable) null);
                    mVar.b.setBackgroundResource(com.baidu.tieba.a.g.forumfeed_frs_list_item_foot_bg);
                    break;
            }
            mVar.m = i;
        }
    }
}
