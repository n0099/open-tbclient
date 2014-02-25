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
import com.baidu.tbadk.data.IconData;
import com.baidu.tieba.voice.PlayVoiceBnt;
import com.baidu.tieba.voice.VoiceManager;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class ai {
    private Context a;
    private View.OnClickListener h;
    private int b = 200;
    private boolean c = true;
    private boolean d = false;
    private float e = 0.4f;
    private LinkedList<IconData> f = null;
    private LinkedList<IconData> g = null;
    private ak i = new ak(this, null);

    public ai(Context context) {
        this.a = context;
        this.h = new aj(this, context);
    }

    public void a(int i, boolean z, float f) {
        this.b = i;
        this.c = z;
        this.e = f;
    }

    public void a(boolean z) {
        this.d = z;
    }

    public void a(View view, com.baidu.tieba.data.v vVar) {
        al alVar;
        int i;
        int i2 = 0;
        if (view.getTag() != null && (alVar = (al) view.getTag()) != null) {
            alVar.c.setText(String.valueOf(vVar.c()) + this.a.getResources().getString(R.string.forum_name_suffix));
            alVar.c.setTag(vVar.c());
            if (vVar.j() > 0) {
                alVar.d.setText(b(view, vVar));
            } else {
                alVar.d.setText(vVar.e());
            }
            this.f = vVar.m();
            if (alVar.o != null) {
                alVar.o.a(this.f, 3, this.a.getResources().getDimensionPixelSize(R.dimen.forumfeed_icon_width), this.a.getResources().getDimensionPixelSize(R.dimen.forumfeed_icon_height), this.a.getResources().getDimensionPixelSize(R.dimen.forumfeed_icon_margin));
            }
            this.g = vVar.a();
            if (alVar.p != null) {
                alVar.p.a(this.g, 2, this.a.getResources().getDimensionPixelSize(R.dimen.small_icon_width), this.a.getResources().getDimensionPixelSize(R.dimen.small_icon_height), this.a.getResources().getDimensionPixelSize(R.dimen.small_icon_margin));
            }
            if (this.g != null && this.g.size() > 0) {
                alVar.f.setPadding(0, 0, 0, 0);
            } else {
                alVar.f.setPadding(this.a.getResources().getDimensionPixelSize(R.dimen.listview_item_padding), 0, 0, 0);
            }
            alVar.f.setText(vVar.g());
            alVar.h.setText(String.valueOf(vVar.f()));
            alVar.g.setText(com.baidu.tieba.util.bs.a(vVar.h() * 1000));
            if (vVar.i() != null && vVar.i().trim().length() > 0) {
                alVar.e.setText(vVar.i());
                alVar.e.setVisibility(0);
            } else {
                alVar.e.setText((CharSequence) null);
                alVar.e.setVisibility(8);
            }
            alVar.k = vVar.b();
            alVar.l = vVar.d();
            ArrayList<VoiceManager.VoiceModel> l = vVar.l();
            if (l != null && l.size() > 0) {
                alVar.j.setVisibility(0);
                VoiceManager.VoiceModel voiceModel = l.get(0);
                alVar.j.setVoiceModel(voiceModel);
                alVar.j.setTag(voiceModel);
                alVar.j.c();
            } else {
                alVar.j.setVisibility(8);
            }
            if (com.baidu.tieba.h.a.a().f()) {
                alVar.i.setVisibility(0);
                ArrayList<com.baidu.tieba.data.ah> k = vVar.k();
                if (k != null) {
                    if (k.size() > 0) {
                        int size = k.size();
                        int i3 = size > 3 ? 3 : size;
                        if (i3 > 0) {
                            com.baidu.tieba.data.ah[] ahVarArr = new com.baidu.tieba.data.ah[i3];
                            int i4 = 0;
                            while (i2 < k.size() && i4 < i3) {
                                if (k.get(i2).a() == 3 || k.get(i2).a() == 5) {
                                    ahVarArr[i4] = k.get(i2);
                                    i = i4 + 1;
                                } else {
                                    i = i4;
                                }
                                i2++;
                                i4 = i;
                            }
                            alVar.i.setShowBig(this.c);
                            alVar.i.setData(ahVarArr);
                            alVar.i.setImageFrom("other");
                            alVar.i.setFromCDN(this.d);
                        }
                    } else {
                        alVar.i.setVisibility(8);
                    }
                }
            } else {
                alVar.i.setVisibility(8);
            }
            alVar.n = this.c;
            view.setTag(alVar);
        }
    }

    private SpannableString b(View view, com.baidu.tieba.data.v vVar) {
        Drawable drawable = view.getResources().getDrawable(R.drawable.icon_elite);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        ImageSpan imageSpan = new ImageSpan(drawable, 1);
        SpannableString spannableString = new SpannableString("  " + ((Object) vVar.e()));
        spannableString.setSpan(imageSpan, 0, 1, 18);
        return spannableString;
    }

    public View a() {
        al alVar = new al(this);
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.a).inflate(R.layout.forum_feed_item, (ViewGroup) null);
        alVar.a = (LinearLayout) linearLayout.findViewById(R.id.layoutForumTop);
        alVar.b = (RelativeLayout) linearLayout.findViewById(R.id.layoutForumBottom);
        alVar.c = (TextView) linearLayout.findViewById(R.id.textHomeListFrsName);
        alVar.d = (TextView) linearLayout.findViewById(R.id.textHomeListTitle);
        alVar.e = (TextView) linearLayout.findViewById(R.id.textHomeListAbstract);
        alVar.f = (TextView) linearLayout.findViewById(R.id.textHomeListAuthor);
        alVar.o = (UserIconBox) linearLayout.findViewById(R.id.user_icon_box);
        alVar.p = (UserIconBox) linearLayout.findViewById(R.id.user_tshow_icon_box);
        alVar.g = (TextView) linearLayout.findViewById(R.id.textHomeListTime);
        alVar.h = (TextView) linearLayout.findViewById(R.id.textHomeListRplyNum);
        alVar.i = (CommonImageLayout) linearLayout.findViewById(R.id.layoutFeedImage);
        alVar.j = (PlayVoiceBnt) linearLayout.findViewById(R.id.abstract_voice);
        alVar.c.setOnClickListener(this.h);
        linearLayout.setOnClickListener(this.h);
        linearLayout.setTag(alVar);
        return linearLayout;
    }

    public void a(int i, View view) {
        al alVar;
        if (view != null && (alVar = (al) view.getTag()) != null && alVar.m != i) {
            switch (i) {
                case 1:
                    b(alVar);
                    break;
                default:
                    a(alVar);
                    break;
            }
            alVar.m = i;
        }
    }

    private void a(al alVar) {
        Resources resources = this.a.getResources();
        alVar.a.setBackgroundResource(R.drawable.forumfeed_frs_list_item_top_bg);
        com.baidu.tieba.util.bq.e((View) alVar.c, (int) R.drawable.bg_label);
        alVar.h.setCompoundDrawablesWithIntrinsicBounds(resources.getDrawable(R.drawable.icon_little_comment_s), (Drawable) null, (Drawable) null, (Drawable) null);
        alVar.b.setBackgroundResource(R.drawable.forumfeed_frs_list_item_foot_bg);
    }

    private void b(al alVar) {
        Resources resources = this.a.getResources();
        alVar.a.setBackgroundResource(R.drawable.forumfeed_frs_list_item_top_bg_1);
        com.baidu.tieba.util.bq.e((View) alVar.c, (int) R.drawable.bg_label_1);
        alVar.h.setCompoundDrawablesWithIntrinsicBounds(resources.getDrawable(R.drawable.icon_little_comment_s_1), (Drawable) null, (Drawable) null, (Drawable) null);
        alVar.b.setBackgroundResource(R.drawable.forumfeed_frs_list_item_foot_bg_1);
    }
}
