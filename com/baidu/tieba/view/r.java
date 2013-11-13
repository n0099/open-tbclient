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
import com.baidu.tieba.voice.PlayVoiceBnt;
import com.baidu.tieba.voice.VoiceManager;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class r {

    /* renamed from: a  reason: collision with root package name */
    private Context f2595a;
    private View.OnClickListener g;
    private int b = 200;
    private boolean c = true;
    private boolean d = false;
    private float e = 0.4f;
    private LinkedList<com.baidu.tieba.data.aa> f = null;
    private t h = new t(this, null);

    public r(Context context) {
        this.f2595a = context;
        this.g = new s(this, context);
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
        u uVar;
        int i;
        int i2 = 0;
        if (view.getTag() != null && (uVar = (u) view.getTag()) != null) {
            uVar.c.setText(wVar.b() + this.f2595a.getResources().getString(R.string.forum_name_suffix));
            uVar.c.setTag(wVar.b());
            if (wVar.i() > 0) {
                uVar.d.setText(b(view, wVar));
            } else {
                uVar.d.setText(wVar.d());
            }
            uVar.f.setText(wVar.f());
            this.f = wVar.l();
            if (uVar.o != null) {
                uVar.o.a(this.f, 3, this.f2595a.getResources().getDimensionPixelSize(R.dimen.forumfeed_icon_width), this.f2595a.getResources().getDimensionPixelSize(R.dimen.forumfeed_icon_height), this.f2595a.getResources().getDimensionPixelSize(R.dimen.forumfeed_icon_margin));
            }
            uVar.h.setText(String.valueOf(wVar.e()));
            uVar.g.setText(com.baidu.tieba.util.be.b(wVar.g() * 1000));
            if (wVar.h() != null && wVar.h().length() > 0) {
                uVar.e.setText(wVar.h());
                uVar.e.setVisibility(0);
            } else {
                uVar.e.setText((CharSequence) null);
                uVar.e.setVisibility(8);
            }
            uVar.k = wVar.a();
            uVar.l = wVar.c();
            ArrayList<VoiceManager.VoiceModel> k = wVar.k();
            if (k != null && k.size() > 0) {
                uVar.j.setVisibility(0);
                VoiceManager.VoiceModel voiceModel = k.get(0);
                uVar.j.setVoiceModel(voiceModel);
                uVar.j.setTag(voiceModel);
                uVar.j.c();
            } else {
                uVar.j.setVisibility(8);
            }
            if (com.baidu.tieba.d.a.a().f()) {
                uVar.i.setVisibility(0);
                ArrayList<com.baidu.tieba.data.aj> j = wVar.j();
                if (j != null) {
                    if (j.size() > 0) {
                        int size = j.size();
                        int i3 = size > 3 ? 3 : size;
                        if (i3 > 0) {
                            com.baidu.tieba.data.aj[] ajVarArr = new com.baidu.tieba.data.aj[i3];
                            int i4 = 0;
                            while (i2 < j.size() && i4 < i3) {
                                if (j.get(i2).a() == 3 || j.get(i2).a() == 5) {
                                    ajVarArr[i4] = j.get(i2);
                                    i = i4 + 1;
                                } else {
                                    i = i4;
                                }
                                i2++;
                                i4 = i;
                            }
                            uVar.i.setShowBig(this.c);
                            uVar.i.setData(ajVarArr);
                            uVar.i.setImageFrom("other");
                            uVar.i.setFromCDN(this.d);
                        }
                    } else {
                        uVar.i.setVisibility(8);
                    }
                }
            }
            uVar.n = this.c;
            view.setTag(uVar);
        }
    }

    private SpannableString b(View view, com.baidu.tieba.data.w wVar) {
        Drawable drawable = view.getResources().getDrawable(R.drawable.icon_elite);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        ImageSpan imageSpan = new ImageSpan(drawable, 1);
        SpannableString spannableString = new SpannableString("  " + ((Object) wVar.d()));
        spannableString.setSpan(imageSpan, 0, 1, 18);
        return spannableString;
    }

    public View a() {
        u uVar = new u(this);
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.f2595a).inflate(R.layout.forum_feed_item, (ViewGroup) null);
        uVar.f2598a = (LinearLayout) linearLayout.findViewById(R.id.layoutForumTop);
        uVar.b = (RelativeLayout) linearLayout.findViewById(R.id.layoutForumBottom);
        uVar.c = (TextView) linearLayout.findViewById(R.id.textHomeListFrsName);
        uVar.d = (TextView) linearLayout.findViewById(R.id.textHomeListTitle);
        uVar.e = (TextView) linearLayout.findViewById(R.id.textHomeListAbstract);
        uVar.f = (TextView) linearLayout.findViewById(R.id.textHomeListAuthor);
        uVar.o = (UserIconBox) linearLayout.findViewById(R.id.user_icon_box);
        uVar.g = (TextView) linearLayout.findViewById(R.id.textHomeListTime);
        uVar.h = (TextView) linearLayout.findViewById(R.id.textHomeListRplyNum);
        uVar.i = (CommonImageLayout) linearLayout.findViewById(R.id.layoutFeedImage);
        uVar.j = (PlayVoiceBnt) linearLayout.findViewById(R.id.abstract_voice);
        uVar.c.setOnClickListener(this.g);
        linearLayout.setOnClickListener(this.g);
        linearLayout.setTag(uVar);
        return linearLayout;
    }

    public void a(int i, View view) {
        u uVar;
        if (view != null && (uVar = (u) view.getTag()) != null && uVar.m != i) {
            switch (i) {
                case 1:
                    b(uVar);
                    break;
                default:
                    a(uVar);
                    break;
            }
            uVar.m = i;
        }
    }

    private void a(u uVar) {
        Resources resources = this.f2595a.getResources();
        uVar.f2598a.setBackgroundResource(R.drawable.forumfeed_frs_list_item_top_bg);
        com.baidu.tieba.util.bd.e((View) uVar.c, (int) R.drawable.bg_label);
        uVar.h.setCompoundDrawablesWithIntrinsicBounds(resources.getDrawable(R.drawable.icon_little_comment_s), (Drawable) null, (Drawable) null, (Drawable) null);
        uVar.b.setBackgroundResource(R.drawable.forumfeed_frs_list_item_foot_bg);
    }

    private void b(u uVar) {
        Resources resources = this.f2595a.getResources();
        uVar.f2598a.setBackgroundResource(R.drawable.forumfeed_frs_list_item_top_bg_1);
        com.baidu.tieba.util.bd.e((View) uVar.c, (int) R.drawable.bg_label_1);
        uVar.h.setCompoundDrawablesWithIntrinsicBounds(resources.getDrawable(R.drawable.icon_little_comment_s_1), (Drawable) null, (Drawable) null, (Drawable) null);
        uVar.b.setBackgroundResource(R.drawable.forumfeed_frs_list_item_foot_bg_1);
    }
}
