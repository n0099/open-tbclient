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
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.voice.PlayVoiceBnt;
import com.baidu.tieba.voice.VoiceManager;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes.dex */
public class q {

    /* renamed from: a  reason: collision with root package name */
    private Context f2538a;
    private View.OnClickListener e;
    private int b = 200;
    private boolean c = true;
    private float d = 0.4f;
    private s f = new s(this, null);

    public q(Context context) {
        this.f2538a = context;
        this.e = new r(this, context);
    }

    public void a(int i, boolean z, float f) {
        this.b = i;
        this.c = z;
        this.d = f;
    }

    public void a(View view, com.baidu.tieba.data.x xVar) {
        w wVar;
        if (view.getTag() != null && (wVar = (w) view.getTag()) != null) {
            wVar.c.setText(xVar.b() + this.f2538a.getResources().getString(R.string.forum_name_suffix));
            wVar.c.setTag(xVar.b());
            if (xVar.i() > 0) {
                wVar.d.setText(b(view, xVar));
            } else {
                wVar.d.setText(xVar.d());
            }
            wVar.f.setText(xVar.f());
            wVar.h.setText(String.valueOf(xVar.e()));
            wVar.g.setText(com.baidu.tieba.util.bc.h(new Date(xVar.g() * 1000)));
            if (xVar.h() != null && xVar.h().length() > 0) {
                wVar.e.setText(xVar.h());
                wVar.e.setVisibility(0);
            } else {
                wVar.e.setText((CharSequence) null);
                wVar.e.setVisibility(8);
            }
            wVar.k = xVar.a();
            wVar.l = xVar.c();
            ArrayList<VoiceManager.VoiceModel> k = xVar.k();
            if (k != null && k.size() > 0) {
                wVar.j.setVisibility(0);
                VoiceManager.VoiceModel voiceModel = k.get(0);
                wVar.j.setVoiceModel(voiceModel);
                wVar.j.setTag(voiceModel);
                wVar.j.c();
            } else {
                wVar.j.setVisibility(8);
            }
            int childCount = wVar.i.getChildCount();
            ArrayList<com.baidu.tieba.data.ai> j = xVar.j();
            if (j != null) {
                int size = j.size();
                int i = size <= 3 ? size : 3;
                if (i == childCount) {
                    for (int i2 = 0; i2 < i; i2++) {
                        LinearLayout linearLayout = (LinearLayout) wVar.i.getChildAt(i2);
                        if (linearLayout != null) {
                            this.f.a(this.f2538a, linearLayout, this.b, this.c, wVar.n != this.c, this.d, j.get(i2), i, i2);
                        }
                    }
                } else {
                    wVar.i.removeAllViews();
                    for (int i3 = 0; i3 < i; i3++) {
                        wVar.i.addView(this.f.a(this.f2538a, this.b, this.c, this.d, j.get(i3), i, i3));
                    }
                }
            }
            wVar.n = this.c;
            view.setTag(wVar);
        }
    }

    private SpannableString b(View view, com.baidu.tieba.data.x xVar) {
        Drawable drawable = view.getResources().getDrawable(R.drawable.icon_elite);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        ImageSpan imageSpan = new ImageSpan(drawable, 1);
        SpannableString spannableString = new SpannableString("  " + ((Object) xVar.d()));
        spannableString.setSpan(imageSpan, 0, 1, 18);
        return spannableString;
    }

    public View a() {
        w wVar = new w(this);
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.f2538a).inflate(R.layout.forum_feed_item, (ViewGroup) null);
        wVar.f2544a = (LinearLayout) linearLayout.findViewById(R.id.layoutForumTop);
        wVar.b = (RelativeLayout) linearLayout.findViewById(R.id.layoutForumBottom);
        wVar.c = (TextView) linearLayout.findViewById(R.id.textHomeListFrsName);
        wVar.d = (TextView) linearLayout.findViewById(R.id.textHomeListTitle);
        wVar.e = (TextView) linearLayout.findViewById(R.id.textHomeListAbstract);
        wVar.f = (TextView) linearLayout.findViewById(R.id.textHomeListAuthor);
        wVar.g = (TextView) linearLayout.findViewById(R.id.textHomeListTime);
        wVar.h = (TextView) linearLayout.findViewById(R.id.textHomeListRplyNum);
        wVar.i = (LinearLayout) linearLayout.findViewById(R.id.layoutFeedImage);
        wVar.j = (PlayVoiceBnt) linearLayout.findViewById(R.id.abstract_voice);
        wVar.c.setOnClickListener(this.e);
        linearLayout.setOnClickListener(this.e);
        linearLayout.setTag(wVar);
        return linearLayout;
    }

    public void a(int i, View view) {
        w wVar;
        if (view != null && (wVar = (w) view.getTag()) != null && wVar.m != i) {
            switch (i) {
                case 1:
                    b(wVar);
                    break;
                default:
                    a(wVar);
                    break;
            }
            wVar.m = i;
        }
    }

    private void a(w wVar) {
        Resources resources = this.f2538a.getResources();
        com.baidu.tieba.util.bb.e((View) wVar.c, (int) R.drawable.bg_forum_feed_label);
        wVar.e.setTextSize(12.0f);
        wVar.f.setCompoundDrawablesWithIntrinsicBounds(resources.getDrawable(R.drawable.ff_icon_little_people), (Drawable) null, (Drawable) null, (Drawable) null);
        wVar.f.setPadding(UtilHelper.a(this.f2538a, 11.0f), 0, 0, 0);
        wVar.h.setCompoundDrawablesWithIntrinsicBounds(resources.getDrawable(R.drawable.icon_forum_feed_little_comment_s), (Drawable) null, (Drawable) null, (Drawable) null);
        wVar.b.setBackgroundDrawable(resources.getDrawable(R.drawable.bg_list_bottom));
    }

    private void b(w wVar) {
        Resources resources = this.f2538a.getResources();
        com.baidu.tieba.util.bb.e((View) wVar.c, (int) R.drawable.bg_forum_feed_label_1);
        wVar.e.setTextSize(14.0f);
        wVar.f.setCompoundDrawablesWithIntrinsicBounds(resources.getDrawable(R.drawable.ff_icon_little_people_1), (Drawable) null, (Drawable) null, (Drawable) null);
        wVar.f.setPadding(UtilHelper.a(this.f2538a, 11.0f), 0, 0, 0);
        wVar.h.setCompoundDrawablesWithIntrinsicBounds(resources.getDrawable(R.drawable.icon_forum_feed_little_comment_s_1), (Drawable) null, (Drawable) null, (Drawable) null);
        wVar.b.setBackgroundDrawable(resources.getDrawable(R.drawable.bg_list_bottom_1));
    }
}
