package com.baidu.ufosdk.ui;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.List;
import java.util.Map;
/* loaded from: classes22.dex */
public final class du extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FeedbackListActivity f3839a;
    private Context b;

    public du(FeedbackListActivity feedbackListActivity, Context context) {
        this.f3839a = feedbackListActivity;
        this.b = context;
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        List list;
        list = this.f3839a.e;
        return list.size();
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i) {
        return null;
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        dt dtVar;
        RelativeLayout relativeLayout;
        List list;
        List list2;
        List list3;
        List list4;
        List list5;
        List list6;
        List list7;
        List list8;
        List list9;
        List list10;
        List list11;
        if (view == null) {
            dt dtVar2 = new dt(this.f3839a);
            RelativeLayout relativeLayout2 = new RelativeLayout(this.b);
            relativeLayout2.setBackgroundDrawable(null);
            relativeLayout2.setLayoutParams(new AbsListView.LayoutParams(-1, com.baidu.ufosdk.f.i.a(this.f3839a.getApplicationContext(), 80.0f)));
            TextView textView = new TextView(this.b);
            textView.setId(2132344840);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.baidu.ufosdk.f.i.a(this.f3839a.getApplicationContext(), 6.0f), com.baidu.ufosdk.f.i.a(this.f3839a.getApplicationContext(), 6.0f));
            layoutParams.setMargins(com.baidu.ufosdk.f.i.a(this.f3839a.getApplicationContext(), 8.0f), com.baidu.ufosdk.f.i.a(this.f3839a.getApplicationContext(), 15.0f), 0, 0);
            layoutParams.addRule(10);
            layoutParams.addRule(9);
            relativeLayout2.addView(textView, layoutParams);
            TextView textView2 = new TextView(this.b);
            textView2.setId(2132344842);
            textView2.setTextColor(-13421773);
            textView2.setLineSpacing(4.0f, 1.0f);
            textView2.setMaxLines(1);
            textView2.setEllipsize(TextUtils.TruncateAt.END);
            textView2.setTextSize(14.0f);
            textView2.setPadding(0, 0, 0, 0);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams2.setMargins(com.baidu.ufosdk.f.i.a(this.f3839a.getApplicationContext(), 24.0f), com.baidu.ufosdk.f.i.a(this.f3839a.getApplicationContext(), 16.0f), com.baidu.ufosdk.f.i.a(this.f3839a.getApplicationContext(), 60.0f), 0);
            layoutParams2.addRule(10);
            layoutParams2.addRule(9);
            relativeLayout2.addView(textView2, layoutParams2);
            TextView textView3 = new TextView(this.b);
            textView3.setTextSize(11.0f);
            textView3.setTextColor(-6710887);
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams3.setMargins(0, com.baidu.ufosdk.f.i.a(this.f3839a.getApplicationContext(), 9.0f), com.baidu.ufosdk.f.i.a(this.f3839a.getApplicationContext(), 9.0f), 0);
            layoutParams3.addRule(10);
            layoutParams3.addRule(11);
            relativeLayout2.addView(textView3, layoutParams3);
            TextView textView4 = new TextView(this.b);
            textView4.setId(2132344843);
            textView4.setTextSize(12.0f);
            textView4.setLines(1);
            textView4.setGravity(16);
            textView4.setEllipsize(TextUtils.TruncateAt.END);
            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
            textView4.setTextColor(-6710887);
            textView4.setPadding(0, 0, 0, 0);
            layoutParams4.addRule(9);
            layoutParams4.addRule(3, textView2.getId());
            layoutParams4.setMargins(com.baidu.ufosdk.f.i.a(this.f3839a.getApplicationContext(), 24.0f), com.baidu.ufosdk.f.i.a(this.f3839a.getApplicationContext(), 8.0f), com.baidu.ufosdk.f.i.a(this.f3839a.getApplicationContext(), 60.0f), com.baidu.ufosdk.f.i.a(this.f3839a.getApplicationContext(), 0.0f));
            relativeLayout2.addView(textView4, layoutParams4);
            Context applicationContext = this.f3839a.getApplicationContext();
            int i2 = com.baidu.ufosdk.b.D;
            StateListDrawable stateListDrawable = new StateListDrawable();
            ColorDrawable colorDrawable = new ColorDrawable(i2);
            stateListDrawable.addState(new int[]{16842919}, new BitmapDrawable(com.baidu.ufosdk.f.m.a(applicationContext, "ufo_list_press.png")));
            stateListDrawable.addState(new int[0], colorDrawable);
            relativeLayout2.setBackgroundDrawable(stateListDrawable);
            dtVar2.f3838a = textView2;
            dtVar2.b = textView;
            dtVar2.c = textView3;
            dtVar2.d = textView4;
            relativeLayout2.setTag(dtVar2);
            dtVar = dtVar2;
            relativeLayout = relativeLayout2;
        } else {
            dtVar = (dt) view.getTag();
            relativeLayout = view;
        }
        TextView textView5 = dtVar.f3838a;
        list = this.f3839a.e;
        textView5.setText((String) ((Map) list.get(i)).get("content"));
        TextView textView6 = dtVar.c;
        list2 = this.f3839a.e;
        textView6.setText(FeedbackListActivity.a((String) ((Map) list2.get(i)).get("time")));
        list3 = this.f3839a.e;
        if (((String) ((Map) list3.get(i)).get("replied")).equals("1")) {
            TextView textView7 = dtVar.d;
            StringBuilder sb = new StringBuilder("[已回复] ");
            list11 = this.f3839a.e;
            textView7.setText(sb.append((String) ((Map) list11.get(i)).get("lastmsg")).toString());
        } else {
            list4 = this.f3839a.e;
            if (((String) ((Map) list4.get(i)).get("replied")).equals("0")) {
                TextView textView8 = dtVar.d;
                StringBuilder sb2 = new StringBuilder("[待回复] ");
                list9 = this.f3839a.e;
                textView8.setText(sb2.append((String) ((Map) list9.get(i)).get("lastmsg")).toString());
            } else {
                list5 = this.f3839a.e;
                if (((String) ((Map) list5.get(i)).get("replied")).equals("2")) {
                    TextView textView9 = dtVar.d;
                    StringBuilder sb3 = new StringBuilder("[邀请评价] ");
                    list8 = this.f3839a.e;
                    textView9.setText(sb3.append((String) ((Map) list8.get(i)).get("lastmsg")).toString());
                } else {
                    list6 = this.f3839a.e;
                    if (((String) ((Map) list6.get(i)).get("replied")).equals("3")) {
                        TextView textView10 = dtVar.d;
                        StringBuilder sb4 = new StringBuilder("[已评价] ");
                        list7 = this.f3839a.e;
                        textView10.setText(sb4.append((String) ((Map) list7.get(i)).get("lastmsg")).toString());
                    }
                }
            }
        }
        list10 = this.f3839a.e;
        if (((String) ((Map) list10.get(i)).get("newmsg")).equals("0")) {
            dtVar.b.setBackgroundDrawable(null);
        } else {
            dtVar.b.setBackgroundDrawable(new BitmapDrawable(FeedbackListActivity.o(this.f3839a)));
        }
        return relativeLayout;
    }
}
