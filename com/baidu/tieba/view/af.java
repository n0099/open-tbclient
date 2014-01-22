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
import com.baidu.tieba.data.IconData;
import com.baidu.tieba.voice.PlayVoiceBnt;
import com.baidu.tieba.voice.VoiceManager;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class af {
    private Context a;
    private View.OnClickListener h;
    private int b = 200;
    private boolean c = true;
    private boolean d = false;
    private float e = 0.4f;
    private LinkedList<IconData> f = null;
    private LinkedList<IconData> g = null;
    private ah i = new ah(this, null);

    public af(Context context) {
        this.a = context;
        this.h = new ag(this, context);
    }

    public void a(int i, boolean z, float f) {
        this.b = i;
        this.c = z;
        this.e = f;
    }

    public void a(boolean z) {
        this.d = z;
    }

    public void a(View view, com.baidu.tieba.data.w wVar) {
        ai aiVar;
        int i;
        int i2 = 0;
        if (view.getTag() != null && (aiVar = (ai) view.getTag()) != null) {
            aiVar.c.setText(wVar.c() + this.a.getResources().getString(R.string.forum_name_suffix));
            aiVar.c.setTag(wVar.c());
            if (wVar.j() > 0) {
                aiVar.d.setText(b(view, wVar));
            } else {
                aiVar.d.setText(wVar.e());
            }
            this.f = wVar.m();
            if (aiVar.o != null) {
                aiVar.o.a(this.f, 3, this.a.getResources().getDimensionPixelSize(R.dimen.forumfeed_icon_width), this.a.getResources().getDimensionPixelSize(R.dimen.forumfeed_icon_height), this.a.getResources().getDimensionPixelSize(R.dimen.forumfeed_icon_margin));
            }
            this.g = wVar.a();
            if (aiVar.p != null) {
                aiVar.p.a(this.g, 2, this.a.getResources().getDimensionPixelSize(R.dimen.small_icon_width), this.a.getResources().getDimensionPixelSize(R.dimen.small_icon_height), this.a.getResources().getDimensionPixelSize(R.dimen.small_icon_margin));
            }
            if (this.g != null && this.g.size() > 0) {
                aiVar.f.setPadding(0, 0, 0, 0);
            } else {
                aiVar.f.setPadding(this.a.getResources().getDimensionPixelSize(R.dimen.listview_item_padding), 0, 0, 0);
            }
            aiVar.f.setText(wVar.g());
            aiVar.h.setText(String.valueOf(wVar.f()));
            aiVar.g.setText(com.baidu.tieba.util.bu.a(wVar.h() * 1000));
            if (wVar.i() != null && wVar.i().trim().length() > 0) {
                aiVar.e.setText(wVar.i());
                aiVar.e.setVisibility(0);
            } else {
                aiVar.e.setText((CharSequence) null);
                aiVar.e.setVisibility(8);
            }
            aiVar.k = wVar.b();
            aiVar.l = wVar.d();
            ArrayList<VoiceManager.VoiceModel> l = wVar.l();
            if (l != null && l.size() > 0) {
                aiVar.j.setVisibility(0);
                VoiceManager.VoiceModel voiceModel = l.get(0);
                aiVar.j.setVoiceModel(voiceModel);
                aiVar.j.setTag(voiceModel);
                aiVar.j.c();
            } else {
                aiVar.j.setVisibility(8);
            }
            if (com.baidu.tieba.e.a.a().f()) {
                aiVar.i.setVisibility(0);
                ArrayList<com.baidu.tieba.data.aj> k = wVar.k();
                if (k != null) {
                    if (k.size() > 0) {
                        int size = k.size();
                        int i3 = size > 3 ? 3 : size;
                        if (i3 > 0) {
                            com.baidu.tieba.data.aj[] ajVarArr = new com.baidu.tieba.data.aj[i3];
                            int i4 = 0;
                            while (i2 < k.size() && i4 < i3) {
                                if (k.get(i2).a() == 3 || k.get(i2).a() == 5) {
                                    ajVarArr[i4] = k.get(i2);
                                    i = i4 + 1;
                                } else {
                                    i = i4;
                                }
                                i2++;
                                i4 = i;
                            }
                            aiVar.i.setShowBig(this.c);
                            aiVar.i.setData(ajVarArr);
                            aiVar.i.setImageFrom("other");
                            aiVar.i.setFromCDN(this.d);
                        }
                    } else {
                        aiVar.i.setVisibility(8);
                    }
                }
            } else {
                aiVar.i.setVisibility(8);
            }
            aiVar.n = this.c;
            view.setTag(aiVar);
        }
    }

    private SpannableString b(View view, com.baidu.tieba.data.w wVar) {
        Drawable drawable = view.getResources().getDrawable(R.drawable.icon_elite);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        ImageSpan imageSpan = new ImageSpan(drawable, 1);
        SpannableString spannableString = new SpannableString("  " + ((Object) wVar.e()));
        spannableString.setSpan(imageSpan, 0, 1, 18);
        return spannableString;
    }

    public View a() {
        ai aiVar = new ai(this);
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.a).inflate(R.layout.forum_feed_item, (ViewGroup) null);
        aiVar.a = (LinearLayout) linearLayout.findViewById(R.id.layoutForumTop);
        aiVar.b = (RelativeLayout) linearLayout.findViewById(R.id.layoutForumBottom);
        aiVar.c = (TextView) linearLayout.findViewById(R.id.textHomeListFrsName);
        aiVar.d = (TextView) linearLayout.findViewById(R.id.textHomeListTitle);
        aiVar.e = (TextView) linearLayout.findViewById(R.id.textHomeListAbstract);
        aiVar.f = (TextView) linearLayout.findViewById(R.id.textHomeListAuthor);
        aiVar.o = (UserIconBox) linearLayout.findViewById(R.id.user_icon_box);
        aiVar.p = (UserIconBox) linearLayout.findViewById(R.id.user_tshow_icon_box);
        aiVar.g = (TextView) linearLayout.findViewById(R.id.textHomeListTime);
        aiVar.h = (TextView) linearLayout.findViewById(R.id.textHomeListRplyNum);
        aiVar.i = (CommonImageLayout) linearLayout.findViewById(R.id.layoutFeedImage);
        aiVar.j = (PlayVoiceBnt) linearLayout.findViewById(R.id.abstract_voice);
        aiVar.c.setOnClickListener(this.h);
        linearLayout.setOnClickListener(this.h);
        linearLayout.setTag(aiVar);
        return linearLayout;
    }

    public void a(int i, View view) {
        ai aiVar;
        if (view != null && (aiVar = (ai) view.getTag()) != null && aiVar.m != i) {
            switch (i) {
                case 1:
                    b(aiVar);
                    break;
                default:
                    a(aiVar);
                    break;
            }
            aiVar.m = i;
        }
    }

    private void a(ai aiVar) {
        Resources resources = this.a.getResources();
        aiVar.a.setBackgroundResource(R.drawable.forumfeed_frs_list_item_top_bg);
        com.baidu.tieba.util.bs.e((View) aiVar.c, (int) R.drawable.bg_label);
        aiVar.h.setCompoundDrawablesWithIntrinsicBounds(resources.getDrawable(R.drawable.icon_little_comment_s), (Drawable) null, (Drawable) null, (Drawable) null);
        aiVar.b.setBackgroundResource(R.drawable.forumfeed_frs_list_item_foot_bg);
    }

    private void b(ai aiVar) {
        Resources resources = this.a.getResources();
        aiVar.a.setBackgroundResource(R.drawable.forumfeed_frs_list_item_top_bg_1);
        com.baidu.tieba.util.bs.e((View) aiVar.c, (int) R.drawable.bg_label_1);
        aiVar.h.setCompoundDrawablesWithIntrinsicBounds(resources.getDrawable(R.drawable.icon_little_comment_s_1), (Drawable) null, (Drawable) null, (Drawable) null);
        aiVar.b.setBackgroundResource(R.drawable.forumfeed_frs_list_item_foot_bg_1);
    }
}
