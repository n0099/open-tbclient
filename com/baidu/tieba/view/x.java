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
import com.baidu.browser.webpool.BdWebPoolView;
import com.baidu.tieba.data.IconData;
import com.baidu.tieba.voice.PlayVoiceBnt;
import com.baidu.tieba.voice.VoiceManager;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class x {
    private Context a;
    private View.OnClickListener h;
    private int b = BdWebPoolView.DELAYED_TIME;
    private boolean c = true;
    private boolean d = false;
    private float e = 0.4f;
    private LinkedList<IconData> f = null;
    private LinkedList<IconData> g = null;
    private z i = new z(this, null);

    public x(Context context) {
        this.a = context;
        this.h = new y(this, context);
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
        aa aaVar;
        int i;
        int i2 = 0;
        if (view.getTag() != null && (aaVar = (aa) view.getTag()) != null) {
            aaVar.c.setText(wVar.c() + this.a.getResources().getString(R.string.forum_name_suffix));
            aaVar.c.setTag(wVar.c());
            if (wVar.j() > 0) {
                aaVar.d.setText(b(view, wVar));
            } else {
                aaVar.d.setText(wVar.e());
            }
            this.f = wVar.m();
            if (aaVar.o != null) {
                aaVar.o.a(this.f, 3, this.a.getResources().getDimensionPixelSize(R.dimen.forumfeed_icon_width), this.a.getResources().getDimensionPixelSize(R.dimen.forumfeed_icon_height), this.a.getResources().getDimensionPixelSize(R.dimen.forumfeed_icon_margin));
            }
            this.g = wVar.a();
            if (aaVar.p != null) {
                aaVar.p.a(this.g, 2, this.a.getResources().getDimensionPixelSize(R.dimen.small_icon_width), this.a.getResources().getDimensionPixelSize(R.dimen.small_icon_height), this.a.getResources().getDimensionPixelSize(R.dimen.small_icon_margin));
            }
            if (this.g != null && this.g.size() > 0) {
                aaVar.f.setPadding(0, 0, 0, 0);
            } else {
                aaVar.f.setPadding(this.a.getResources().getDimensionPixelSize(R.dimen.listview_item_padding), 0, 0, 0);
            }
            aaVar.f.setText(wVar.g());
            aaVar.h.setText(String.valueOf(wVar.f()));
            aaVar.g.setText(com.baidu.tieba.util.bm.b(wVar.h() * 1000));
            if (wVar.i() != null && wVar.i().trim().length() > 0) {
                aaVar.e.setText(wVar.i());
                aaVar.e.setVisibility(0);
            } else {
                aaVar.e.setText((CharSequence) null);
                aaVar.e.setVisibility(8);
            }
            aaVar.k = wVar.b();
            aaVar.l = wVar.d();
            ArrayList<VoiceManager.VoiceModel> l = wVar.l();
            if (l != null && l.size() > 0) {
                aaVar.j.setVisibility(0);
                VoiceManager.VoiceModel voiceModel = l.get(0);
                aaVar.j.setVoiceModel(voiceModel);
                aaVar.j.setTag(voiceModel);
                aaVar.j.c();
            } else {
                aaVar.j.setVisibility(8);
            }
            if (com.baidu.tieba.e.a.a().f()) {
                aaVar.i.setVisibility(0);
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
                            aaVar.i.setShowBig(this.c);
                            aaVar.i.setData(ajVarArr);
                            aaVar.i.setImageFrom("other");
                            aaVar.i.setFromCDN(this.d);
                        }
                    } else {
                        aaVar.i.setVisibility(8);
                    }
                }
            } else {
                aaVar.i.setVisibility(8);
            }
            aaVar.n = this.c;
            view.setTag(aaVar);
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
        aa aaVar = new aa(this);
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.a).inflate(R.layout.forum_feed_item, (ViewGroup) null);
        aaVar.a = (LinearLayout) linearLayout.findViewById(R.id.layoutForumTop);
        aaVar.b = (RelativeLayout) linearLayout.findViewById(R.id.layoutForumBottom);
        aaVar.c = (TextView) linearLayout.findViewById(R.id.textHomeListFrsName);
        aaVar.d = (TextView) linearLayout.findViewById(R.id.textHomeListTitle);
        aaVar.e = (TextView) linearLayout.findViewById(R.id.textHomeListAbstract);
        aaVar.f = (TextView) linearLayout.findViewById(R.id.textHomeListAuthor);
        aaVar.o = (UserIconBox) linearLayout.findViewById(R.id.user_icon_box);
        aaVar.p = (UserIconBox) linearLayout.findViewById(R.id.user_tshow_icon_box);
        aaVar.g = (TextView) linearLayout.findViewById(R.id.textHomeListTime);
        aaVar.h = (TextView) linearLayout.findViewById(R.id.textHomeListRplyNum);
        aaVar.i = (CommonImageLayout) linearLayout.findViewById(R.id.layoutFeedImage);
        aaVar.j = (PlayVoiceBnt) linearLayout.findViewById(R.id.abstract_voice);
        aaVar.c.setOnClickListener(this.h);
        linearLayout.setOnClickListener(this.h);
        linearLayout.setTag(aaVar);
        return linearLayout;
    }

    public void a(int i, View view) {
        aa aaVar;
        if (view != null && (aaVar = (aa) view.getTag()) != null && aaVar.m != i) {
            switch (i) {
                case 1:
                    b(aaVar);
                    break;
                default:
                    a(aaVar);
                    break;
            }
            aaVar.m = i;
        }
    }

    private void a(aa aaVar) {
        Resources resources = this.a.getResources();
        aaVar.a.setBackgroundResource(R.drawable.forumfeed_frs_list_item_top_bg);
        com.baidu.tieba.util.bl.e((View) aaVar.c, (int) R.drawable.bg_label);
        aaVar.h.setCompoundDrawablesWithIntrinsicBounds(resources.getDrawable(R.drawable.icon_little_comment_s), (Drawable) null, (Drawable) null, (Drawable) null);
        aaVar.b.setBackgroundResource(R.drawable.forumfeed_frs_list_item_foot_bg);
    }

    private void b(aa aaVar) {
        Resources resources = this.a.getResources();
        aaVar.a.setBackgroundResource(R.drawable.forumfeed_frs_list_item_top_bg_1);
        com.baidu.tieba.util.bl.e((View) aaVar.c, (int) R.drawable.bg_label_1);
        aaVar.h.setCompoundDrawablesWithIntrinsicBounds(resources.getDrawable(R.drawable.icon_little_comment_s_1), (Drawable) null, (Drawable) null, (Drawable) null);
        aaVar.b.setBackgroundResource(R.drawable.forumfeed_frs_list_item_foot_bg_1);
    }
}
