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
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.coreExtra.view.LiveBroadcastCard;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.editortool.ab;
import com.baidu.tieba.voice.PlayVoiceBnt;
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class k {
    private final Context a;
    private int b = Constants.MEDIA_INFO;
    private boolean c = true;
    private boolean d = false;
    private float e = 0.4f;
    private LinkedList<IconData> f = null;
    private LinkedList<IconData> g = null;
    private final View.OnClickListener h;
    private ab i;

    public k(Context context) {
        this.a = context;
        this.i = new ab(this.a);
        this.h = new l(this, context);
    }

    public void a(int i, boolean z, float f) {
        this.b = i;
        this.c = z;
        this.e = f;
    }

    public void a(boolean z) {
        this.d = z;
    }

    public void a(View view, com.baidu.tieba.data.q qVar) {
        m mVar;
        int i;
        int i2 = 0;
        if (view.getTag() != null && (mVar = (m) view.getTag()) != null) {
            mVar.c.setText(String.valueOf(qVar.c()) + this.a.getResources().getString(com.baidu.tieba.u.forum_name_suffix));
            mVar.c.setTag(qVar.c());
            this.f = qVar.m();
            if (mVar.o != null) {
                mVar.o.a(this.f, 3, this.a.getResources().getDimensionPixelSize(com.baidu.tieba.p.forumfeed_icon_width), this.a.getResources().getDimensionPixelSize(com.baidu.tieba.p.forumfeed_icon_height), this.a.getResources().getDimensionPixelSize(com.baidu.tieba.p.forumfeed_icon_margin));
            }
            this.g = qVar.a();
            if (mVar.p != null) {
                mVar.p.a(this.g, 2, this.a.getResources().getDimensionPixelSize(com.baidu.tieba.p.small_icon_width), this.a.getResources().getDimensionPixelSize(com.baidu.tieba.p.small_icon_height), this.a.getResources().getDimensionPixelSize(com.baidu.tieba.p.small_icon_margin));
            }
            int skinType = TbadkApplication.m252getInst().getSkinType();
            if (this.g != null && this.g.size() > 0) {
                mVar.f.setPadding(0, 0, 0, 0);
                if (skinType == 1) {
                    mVar.f.setTextColor(this.a.getResources().getColor(com.baidu.tieba.o.frs_lv_item_user_name_vip_1));
                } else {
                    mVar.f.setTextColor(this.a.getResources().getColor(com.baidu.tieba.o.frs_lv_item_user_name_vip));
                }
            } else {
                mVar.f.setPadding(this.a.getResources().getDimensionPixelSize(com.baidu.tieba.p.listview_item_padding), 0, 0, 0);
                if (skinType == 1) {
                    mVar.f.setTextColor(this.a.getResources().getColor(com.baidu.tieba.o.listview_item_author_time_text_1));
                } else {
                    mVar.f.setTextColor(this.a.getResources().getColor(com.baidu.tieba.o.listview_item_author_time_text));
                }
            }
            mVar.f.setText(qVar.g());
            mVar.h.setText(String.valueOf(qVar.f()));
            mVar.g.setText(be.a(qVar.h() * 1000));
            if (qVar.i() != null && qVar.i().trim().length() > 0) {
                mVar.e.setText(qVar.i());
                mVar.e.setVisibility(0);
            } else {
                mVar.e.setText((CharSequence) null);
                mVar.e.setVisibility(8);
            }
            mVar.k = qVar.b();
            mVar.l = qVar.d();
            ArrayList<VoiceData.VoiceModel> l = qVar.l();
            if (l != null && l.size() > 0) {
                mVar.j.setVisibility(0);
                VoiceData.VoiceModel voiceModel = l.get(0);
                mVar.j.setVoiceModel(voiceModel);
                mVar.j.setTag(voiceModel);
                mVar.j.c();
            } else {
                mVar.j.setVisibility(8);
            }
            LiveCardData n = qVar.n();
            if (qVar.o()) {
                mVar.i.setVisibility(8);
                mVar.d.setText(c(view, qVar));
                mVar.q.setVisibility(0);
                mVar.r.a(n, this.i);
            } else {
                mVar.q.setVisibility(8);
                if (qVar.j() > 0) {
                    mVar.d.setText(b(view, qVar));
                } else {
                    mVar.d.setText(qVar.e());
                }
                if (com.baidu.tbadk.core.h.a().f()) {
                    mVar.i.setVisibility(0);
                    ArrayList<com.baidu.tbadk.core.data.k> k = qVar.k();
                    if (k != null) {
                        if (k.size() > 0) {
                            int size = k.size();
                            int i3 = size > 3 ? 3 : size;
                            if (i3 > 0) {
                                com.baidu.tbadk.core.data.k[] kVarArr = new com.baidu.tbadk.core.data.k[i3];
                                int i4 = 0;
                                while (i2 < k.size() && i4 < i3) {
                                    if (k.get(i2).b() == 3 || k.get(i2).b() == 5) {
                                        kVarArr[i4] = k.get(i2);
                                        i = i4 + 1;
                                    } else {
                                        i = i4;
                                    }
                                    i2++;
                                    i4 = i;
                                }
                                mVar.i.setShowBig(this.c);
                                mVar.i.setData(kVarArr);
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
            }
            mVar.n = this.c;
            view.setTag(mVar);
        }
    }

    private SpannableString b(View view, com.baidu.tieba.data.q qVar) {
        Drawable drawable = view.getResources().getDrawable(com.baidu.tieba.q.icon_elite);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        ImageSpan imageSpan = new ImageSpan(drawable, 1);
        SpannableString spannableString = new SpannableString("  " + ((Object) qVar.e()));
        spannableString.setSpan(imageSpan, 0, 1, 18);
        return spannableString;
    }

    private SpannableString c(View view, com.baidu.tieba.data.q qVar) {
        Drawable drawable;
        if (TbadkApplication.m252getInst().getSkinType() == 1) {
            drawable = view.getResources().getDrawable(com.baidu.tieba.q.icon_live_on_1);
        } else {
            drawable = view.getResources().getDrawable(com.baidu.tieba.q.icon_live_on);
        }
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        ImageSpan imageSpan = new ImageSpan(drawable, 1);
        SpannableString spannableString = new SpannableString("  " + ((Object) qVar.e()));
        spannableString.setSpan(imageSpan, 0, 1, 18);
        return spannableString;
    }

    public View a() {
        m mVar = new m(this);
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.a).inflate(com.baidu.tieba.s.forum_feed_item, (ViewGroup) null);
        mVar.a = (LinearLayout) linearLayout.findViewById(com.baidu.tieba.r.layoutForumTop);
        mVar.b = (RelativeLayout) linearLayout.findViewById(com.baidu.tieba.r.layoutForumBottom);
        mVar.c = (TextView) linearLayout.findViewById(com.baidu.tieba.r.textHomeListFrsName);
        mVar.d = (TextView) linearLayout.findViewById(com.baidu.tieba.r.textHomeListTitle);
        mVar.e = (TextView) linearLayout.findViewById(com.baidu.tieba.r.textHomeListAbstract);
        mVar.f = (TextView) linearLayout.findViewById(com.baidu.tieba.r.textHomeListAuthor);
        mVar.o = (UserIconBox) linearLayout.findViewById(com.baidu.tieba.r.user_icon_box);
        mVar.p = (UserIconBox) linearLayout.findViewById(com.baidu.tieba.r.user_tshow_icon_box);
        mVar.g = (TextView) linearLayout.findViewById(com.baidu.tieba.r.textHomeListTime);
        mVar.h = (TextView) linearLayout.findViewById(com.baidu.tieba.r.textHomeListRplyNum);
        mVar.i = (CommonImageLayout) linearLayout.findViewById(com.baidu.tieba.r.layoutFeedImage);
        mVar.j = (PlayVoiceBnt) linearLayout.findViewById(com.baidu.tieba.r.abstract_voice);
        mVar.q = (LinearLayout) linearLayout.findViewById(com.baidu.tieba.r.feed_item_live_card);
        mVar.r = (LiveBroadcastCard) linearLayout.findViewById(com.baidu.tieba.r.feed_item_card);
        mVar.c.setOnClickListener(this.h);
        linearLayout.setOnClickListener(this.h);
        linearLayout.setTag(mVar);
        return linearLayout;
    }

    public void a(int i, View view) {
        m mVar;
        if (view != null && (mVar = (m) view.getTag()) != null && mVar.m != i) {
            switch (i) {
                case 1:
                    b(mVar);
                    break;
                default:
                    a(mVar);
                    break;
            }
            mVar.m = i;
        }
    }

    private void a(m mVar) {
        Resources resources = this.a.getResources();
        mVar.a.setBackgroundResource(com.baidu.tieba.q.forumfeed_frs_list_item_top_bg);
        bc.e((View) mVar.c, com.baidu.tieba.q.bg_label);
        mVar.h.setCompoundDrawablesWithIntrinsicBounds(resources.getDrawable(com.baidu.tieba.q.icon_little_comment_s), (Drawable) null, (Drawable) null, (Drawable) null);
        mVar.b.setBackgroundResource(com.baidu.tieba.q.forumfeed_frs_list_item_foot_bg);
    }

    private void b(m mVar) {
        Resources resources = this.a.getResources();
        mVar.a.setBackgroundResource(com.baidu.tieba.q.forumfeed_frs_list_item_top_bg_1);
        bc.e((View) mVar.c, com.baidu.tieba.q.bg_label_1);
        mVar.h.setCompoundDrawablesWithIntrinsicBounds(resources.getDrawable(com.baidu.tieba.q.icon_little_comment_s_1), (Drawable) null, (Drawable) null, (Drawable) null);
        mVar.b.setBackgroundResource(com.baidu.tieba.q.forumfeed_frs_list_item_foot_bg_1);
    }
}
