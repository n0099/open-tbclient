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
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.coreExtra.view.LiveBroadcastCard;
import com.baidu.tbadk.data.IconData;
import com.baidu.tieba.voice.PlayVoiceBnt;
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class j {
    private final Context a;
    private int b = Constants.MEDIA_INFO;
    private boolean c = true;
    private boolean d = false;
    private float e = 0.4f;
    private LinkedList<IconData> f = null;
    private LinkedList<IconData> g = null;
    private final View.OnClickListener h;

    public j(Context context) {
        this.a = context;
        this.h = new k(this, context);
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
        l lVar;
        int i;
        int i2 = 0;
        if (view.getTag() != null && (lVar = (l) view.getTag()) != null) {
            lVar.c.setText(String.valueOf(qVar.c()) + this.a.getResources().getString(com.baidu.tieba.x.forum_name_suffix));
            lVar.c.setTag(qVar.c());
            this.f = qVar.m();
            if (lVar.o != null) {
                lVar.o.a(this.f, 3, this.a.getResources().getDimensionPixelSize(com.baidu.tieba.s.forumfeed_icon_width), this.a.getResources().getDimensionPixelSize(com.baidu.tieba.s.forumfeed_icon_height), this.a.getResources().getDimensionPixelSize(com.baidu.tieba.s.forumfeed_icon_margin));
            }
            this.g = qVar.a();
            if (lVar.p != null) {
                lVar.p.a(this.g, 2, this.a.getResources().getDimensionPixelSize(com.baidu.tieba.s.small_icon_width), this.a.getResources().getDimensionPixelSize(com.baidu.tieba.s.small_icon_height), this.a.getResources().getDimensionPixelSize(com.baidu.tieba.s.small_icon_margin));
            }
            int skinType = TbadkApplication.m252getInst().getSkinType();
            if (this.g != null && this.g.size() > 0) {
                lVar.f.setPadding(0, 0, 0, 0);
                if (skinType == 1) {
                    lVar.f.setTextColor(this.a.getResources().getColor(com.baidu.tieba.r.cp_cont_h_1));
                } else {
                    lVar.f.setTextColor(this.a.getResources().getColor(com.baidu.tieba.r.cp_cont_h));
                }
            } else {
                lVar.f.setPadding(this.a.getResources().getDimensionPixelSize(com.baidu.tieba.s.listview_item_padding), 0, 0, 0);
                if (skinType == 1) {
                    lVar.f.setTextColor(this.a.getResources().getColor(com.baidu.tieba.r.listview_item_author_time_text_1));
                } else {
                    lVar.f.setTextColor(this.a.getResources().getColor(com.baidu.tieba.r.listview_item_author_time_text));
                }
            }
            lVar.f.setText(qVar.g());
            lVar.h.setText(String.valueOf(qVar.f()));
            lVar.g.setText(ba.a(qVar.h() * 1000));
            if (qVar.i() != null && qVar.i().trim().length() > 0) {
                lVar.e.setText(qVar.i());
                lVar.e.setVisibility(0);
            } else {
                lVar.e.setText((CharSequence) null);
                lVar.e.setVisibility(8);
            }
            lVar.k = qVar.b();
            lVar.l = qVar.d();
            ArrayList<VoiceData.VoiceModel> l = qVar.l();
            if (l != null && l.size() > 0) {
                lVar.j.setVisibility(0);
                VoiceData.VoiceModel voiceModel = l.get(0);
                lVar.j.setVoiceModel(voiceModel);
                lVar.j.setTag(voiceModel);
                lVar.j.c();
            } else {
                lVar.j.setVisibility(8);
            }
            LiveCardData n = qVar.n();
            if (qVar.o()) {
                lVar.i.setVisibility(8);
                lVar.d.setText(c(view, qVar));
                lVar.q.setVisibility(0);
                lVar.r.setData(n);
            } else {
                lVar.q.setVisibility(8);
                if (qVar.j() > 0) {
                    lVar.d.setText(b(view, qVar));
                } else {
                    lVar.d.setText(qVar.e());
                }
                if (com.baidu.tbadk.core.h.a().f()) {
                    lVar.i.setVisibility(0);
                    ArrayList<MediaData> k = qVar.k();
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
                                lVar.i.setShowBig(this.c);
                                lVar.i.setData(mediaDataArr);
                                lVar.i.setFromCDN(this.d);
                            }
                        } else {
                            lVar.i.setVisibility(8);
                        }
                    }
                } else {
                    lVar.i.setVisibility(8);
                }
            }
            lVar.n = this.c;
            view.setTag(lVar);
        }
    }

    private SpannableString b(View view, com.baidu.tieba.data.q qVar) {
        Drawable drawable = view.getResources().getDrawable(com.baidu.tieba.t.icon_elite);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        ImageSpan imageSpan = new ImageSpan(drawable, 1);
        SpannableString spannableString = new SpannableString("  " + ((Object) qVar.e()));
        spannableString.setSpan(imageSpan, 0, 1, 18);
        return spannableString;
    }

    private SpannableString c(View view, com.baidu.tieba.data.q qVar) {
        Drawable drawable;
        if (TbadkApplication.m252getInst().getSkinType() == 1) {
            drawable = view.getResources().getDrawable(com.baidu.tieba.t.icon_live_on_1);
        } else {
            drawable = view.getResources().getDrawable(com.baidu.tieba.t.icon_live_on);
        }
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        ImageSpan imageSpan = new ImageSpan(drawable, 1);
        SpannableString spannableString = new SpannableString("  " + ((Object) qVar.e()));
        spannableString.setSpan(imageSpan, 0, 1, 18);
        return spannableString;
    }

    public View a() {
        l lVar = new l(this);
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.a).inflate(com.baidu.tieba.v.forum_feed_item, (ViewGroup) null);
        lVar.a = (LinearLayout) linearLayout.findViewById(com.baidu.tieba.u.layoutForumTop);
        lVar.b = (RelativeLayout) linearLayout.findViewById(com.baidu.tieba.u.layoutForumBottom);
        lVar.c = (TextView) linearLayout.findViewById(com.baidu.tieba.u.textHomeListFrsName);
        lVar.d = (TextView) linearLayout.findViewById(com.baidu.tieba.u.textHomeListTitle);
        lVar.e = (TextView) linearLayout.findViewById(com.baidu.tieba.u.textHomeListAbstract);
        lVar.f = (TextView) linearLayout.findViewById(com.baidu.tieba.u.textHomeListAuthor);
        lVar.o = (UserIconBox) linearLayout.findViewById(com.baidu.tieba.u.user_icon_box);
        lVar.p = (UserIconBox) linearLayout.findViewById(com.baidu.tieba.u.user_tshow_icon_box);
        lVar.g = (TextView) linearLayout.findViewById(com.baidu.tieba.u.textHomeListTime);
        lVar.h = (TextView) linearLayout.findViewById(com.baidu.tieba.u.textHomeListRplyNum);
        lVar.i = (CommonImageLayout) linearLayout.findViewById(com.baidu.tieba.u.layoutFeedImage);
        lVar.j = (PlayVoiceBnt) linearLayout.findViewById(com.baidu.tieba.u.abstract_voice);
        lVar.q = (LinearLayout) linearLayout.findViewById(com.baidu.tieba.u.feed_item_live_card);
        lVar.r = (LiveBroadcastCard) linearLayout.findViewById(com.baidu.tieba.u.feed_item_card);
        lVar.c.setOnClickListener(this.h);
        linearLayout.setOnClickListener(this.h);
        linearLayout.setTag(lVar);
        return linearLayout;
    }

    public void a(int i, View view) {
        l lVar;
        if (view != null && (lVar = (l) view.getTag()) != null && lVar.m != i) {
            switch (i) {
                case 1:
                    b(lVar);
                    break;
                default:
                    a(lVar);
                    break;
            }
            lVar.m = i;
        }
    }

    private void a(l lVar) {
        Resources resources = this.a.getResources();
        lVar.a.setBackgroundResource(com.baidu.tieba.t.forumfeed_frs_list_item_top_bg);
        ay.e((View) lVar.c, com.baidu.tieba.t.bg_label);
        lVar.h.setCompoundDrawablesWithIntrinsicBounds(resources.getDrawable(com.baidu.tieba.t.icon_little_comment_s), (Drawable) null, (Drawable) null, (Drawable) null);
        lVar.b.setBackgroundResource(com.baidu.tieba.t.forumfeed_frs_list_item_foot_bg);
    }

    private void b(l lVar) {
        Resources resources = this.a.getResources();
        lVar.a.setBackgroundResource(com.baidu.tieba.t.forumfeed_frs_list_item_top_bg_1);
        ay.e((View) lVar.c, com.baidu.tieba.t.bg_label_1);
        lVar.h.setCompoundDrawablesWithIntrinsicBounds(resources.getDrawable(com.baidu.tieba.t.icon_little_comment_s_1), (Drawable) null, (Drawable) null, (Drawable) null);
        lVar.b.setBackgroundResource(com.baidu.tieba.t.forumfeed_frs_list_item_foot_bg_1);
    }
}
