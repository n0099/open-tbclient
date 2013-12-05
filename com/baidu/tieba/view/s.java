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
public class s {

    /* renamed from: a  reason: collision with root package name */
    private Context f2696a;
    private View.OnClickListener g;
    private int b = 200;
    private boolean c = true;
    private boolean d = false;
    private float e = 0.4f;
    private LinkedList<IconData> f = null;
    private u h = new u(this, null);

    public s(Context context) {
        this.f2696a = context;
        this.g = new t(this, context);
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
        v vVar;
        int i;
        int i2 = 0;
        if (view.getTag() != null && (vVar = (v) view.getTag()) != null) {
            vVar.c.setText(wVar.b() + this.f2696a.getResources().getString(R.string.forum_name_suffix));
            vVar.c.setTag(wVar.b());
            if (wVar.i() > 0) {
                vVar.d.setText(b(view, wVar));
            } else {
                vVar.d.setText(wVar.d());
            }
            vVar.f.setText(wVar.f());
            this.f = wVar.l();
            if (vVar.o != null) {
                vVar.o.a(this.f, 3, this.f2696a.getResources().getDimensionPixelSize(R.dimen.forumfeed_icon_width), this.f2696a.getResources().getDimensionPixelSize(R.dimen.forumfeed_icon_height), this.f2696a.getResources().getDimensionPixelSize(R.dimen.forumfeed_icon_margin));
            }
            vVar.h.setText(String.valueOf(wVar.e()));
            vVar.g.setText(com.baidu.tieba.util.bb.b(wVar.g() * 1000));
            if (wVar.h() != null && wVar.h().trim().length() > 0) {
                vVar.e.setText(wVar.h());
                vVar.e.setVisibility(0);
            } else {
                vVar.e.setText((CharSequence) null);
                vVar.e.setVisibility(8);
            }
            vVar.k = wVar.a();
            vVar.l = wVar.c();
            ArrayList<VoiceManager.VoiceModel> k = wVar.k();
            if (k != null && k.size() > 0) {
                vVar.j.setVisibility(0);
                VoiceManager.VoiceModel voiceModel = k.get(0);
                vVar.j.setVoiceModel(voiceModel);
                vVar.j.setTag(voiceModel);
                vVar.j.c();
            } else {
                vVar.j.setVisibility(8);
            }
            if (com.baidu.tieba.d.a.a().f()) {
                vVar.i.setVisibility(0);
                ArrayList<com.baidu.tieba.data.ai> j = wVar.j();
                if (j != null) {
                    if (j.size() > 0) {
                        int size = j.size();
                        int i3 = size > 3 ? 3 : size;
                        if (i3 > 0) {
                            com.baidu.tieba.data.ai[] aiVarArr = new com.baidu.tieba.data.ai[i3];
                            int i4 = 0;
                            while (i2 < j.size() && i4 < i3) {
                                if (j.get(i2).a() == 3 || j.get(i2).a() == 5) {
                                    aiVarArr[i4] = j.get(i2);
                                    i = i4 + 1;
                                } else {
                                    i = i4;
                                }
                                i2++;
                                i4 = i;
                            }
                            vVar.i.setShowBig(this.c);
                            vVar.i.setData(aiVarArr);
                            vVar.i.setImageFrom("other");
                            vVar.i.setFromCDN(this.d);
                        }
                    } else {
                        vVar.i.setVisibility(8);
                    }
                }
            } else {
                vVar.i.setVisibility(8);
            }
            vVar.n = this.c;
            view.setTag(vVar);
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
        v vVar = new v(this);
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.f2696a).inflate(R.layout.forum_feed_item, (ViewGroup) null);
        vVar.f2699a = (LinearLayout) linearLayout.findViewById(R.id.layoutForumTop);
        vVar.b = (RelativeLayout) linearLayout.findViewById(R.id.layoutForumBottom);
        vVar.c = (TextView) linearLayout.findViewById(R.id.textHomeListFrsName);
        vVar.d = (TextView) linearLayout.findViewById(R.id.textHomeListTitle);
        vVar.e = (TextView) linearLayout.findViewById(R.id.textHomeListAbstract);
        vVar.f = (TextView) linearLayout.findViewById(R.id.textHomeListAuthor);
        vVar.o = (UserIconBox) linearLayout.findViewById(R.id.user_icon_box);
        vVar.g = (TextView) linearLayout.findViewById(R.id.textHomeListTime);
        vVar.h = (TextView) linearLayout.findViewById(R.id.textHomeListRplyNum);
        vVar.i = (CommonImageLayout) linearLayout.findViewById(R.id.layoutFeedImage);
        vVar.j = (PlayVoiceBnt) linearLayout.findViewById(R.id.abstract_voice);
        vVar.c.setOnClickListener(this.g);
        linearLayout.setOnClickListener(this.g);
        linearLayout.setTag(vVar);
        return linearLayout;
    }

    public void a(int i, View view) {
        v vVar;
        if (view != null && (vVar = (v) view.getTag()) != null && vVar.m != i) {
            switch (i) {
                case 1:
                    b(vVar);
                    break;
                default:
                    a(vVar);
                    break;
            }
            vVar.m = i;
        }
    }

    private void a(v vVar) {
        Resources resources = this.f2696a.getResources();
        vVar.f2699a.setBackgroundResource(R.drawable.forumfeed_frs_list_item_top_bg);
        com.baidu.tieba.util.ba.e((View) vVar.c, (int) R.drawable.bg_label);
        vVar.h.setCompoundDrawablesWithIntrinsicBounds(resources.getDrawable(R.drawable.icon_little_comment_s), (Drawable) null, (Drawable) null, (Drawable) null);
        vVar.b.setBackgroundResource(R.drawable.forumfeed_frs_list_item_foot_bg);
    }

    private void b(v vVar) {
        Resources resources = this.f2696a.getResources();
        vVar.f2699a.setBackgroundResource(R.drawable.forumfeed_frs_list_item_top_bg_1);
        com.baidu.tieba.util.ba.e((View) vVar.c, (int) R.drawable.bg_label_1);
        vVar.h.setCompoundDrawablesWithIntrinsicBounds(resources.getDrawable(R.drawable.icon_little_comment_s_1), (Drawable) null, (Drawable) null, (Drawable) null);
        vVar.b.setBackgroundResource(R.drawable.forumfeed_frs_list_item_foot_bg_1);
    }
}
