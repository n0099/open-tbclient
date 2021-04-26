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
import com.baidu.mobads.container.widget.ConfirmDialog;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
public final class du extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedbackListActivity f23597a;

    /* renamed from: b  reason: collision with root package name */
    public Context f23598b;

    public du(FeedbackListActivity feedbackListActivity, Context context) {
        this.f23597a = feedbackListActivity;
        this.f23598b = context;
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        List list;
        list = this.f23597a.f23428e;
        return list.size();
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i2) {
        return null;
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i2) {
        return 0L;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x02cb  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x02d9  */
    @Override // android.widget.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final View getView(int i2, View view, ViewGroup viewGroup) {
        dt dtVar;
        RelativeLayout relativeLayout;
        List list;
        List list2;
        List list3;
        List list4;
        List list5;
        List list6;
        TextView textView;
        StringBuilder sb;
        List list7;
        TextView textView2;
        BitmapDrawable bitmapDrawable;
        List list8;
        if (view == null) {
            dtVar = new dt(this.f23597a);
            RelativeLayout relativeLayout2 = new RelativeLayout(this.f23598b);
            relativeLayout2.setBackgroundDrawable(null);
            relativeLayout2.setLayoutParams(new AbsListView.LayoutParams(-1, com.baidu.ufosdk.f.i.a(this.f23597a.getApplicationContext(), 80.0f)));
            TextView textView3 = new TextView(this.f23598b);
            textView3.setId(2132344840);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.baidu.ufosdk.f.i.a(this.f23597a.getApplicationContext(), 6.0f), com.baidu.ufosdk.f.i.a(this.f23597a.getApplicationContext(), 6.0f));
            layoutParams.setMargins(com.baidu.ufosdk.f.i.a(this.f23597a.getApplicationContext(), 8.0f), com.baidu.ufosdk.f.i.a(this.f23597a.getApplicationContext(), 15.0f), 0, 0);
            layoutParams.addRule(10);
            layoutParams.addRule(9);
            relativeLayout2.addView(textView3, layoutParams);
            TextView textView4 = new TextView(this.f23598b);
            textView4.setId(2132344842);
            textView4.setTextColor(-13421773);
            textView4.setLineSpacing(4.0f, 1.0f);
            textView4.setMaxLines(1);
            textView4.setEllipsize(TextUtils.TruncateAt.END);
            textView4.setTextSize(14.0f);
            textView4.setPadding(0, 0, 0, 0);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams2.setMargins(com.baidu.ufosdk.f.i.a(this.f23597a.getApplicationContext(), 24.0f), com.baidu.ufosdk.f.i.a(this.f23597a.getApplicationContext(), 16.0f), com.baidu.ufosdk.f.i.a(this.f23597a.getApplicationContext(), 60.0f), 0);
            layoutParams2.addRule(10);
            layoutParams2.addRule(9);
            relativeLayout2.addView(textView4, layoutParams2);
            TextView textView5 = new TextView(this.f23598b);
            textView5.setTextSize(11.0f);
            textView5.setTextColor(ConfirmDialog.APP_DESC_COLOR_DEFAULT);
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams3.setMargins(0, com.baidu.ufosdk.f.i.a(this.f23597a.getApplicationContext(), 9.0f), com.baidu.ufosdk.f.i.a(this.f23597a.getApplicationContext(), 9.0f), 0);
            layoutParams3.addRule(10);
            layoutParams3.addRule(11);
            relativeLayout2.addView(textView5, layoutParams3);
            TextView textView6 = new TextView(this.f23598b);
            textView6.setId(2132344843);
            textView6.setTextSize(12.0f);
            textView6.setLines(1);
            textView6.setGravity(16);
            textView6.setEllipsize(TextUtils.TruncateAt.END);
            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
            textView6.setTextColor(ConfirmDialog.APP_DESC_COLOR_DEFAULT);
            textView6.setPadding(0, 0, 0, 0);
            layoutParams4.addRule(9);
            layoutParams4.addRule(3, textView4.getId());
            layoutParams4.setMargins(com.baidu.ufosdk.f.i.a(this.f23597a.getApplicationContext(), 24.0f), com.baidu.ufosdk.f.i.a(this.f23597a.getApplicationContext(), 8.0f), com.baidu.ufosdk.f.i.a(this.f23597a.getApplicationContext(), 60.0f), com.baidu.ufosdk.f.i.a(this.f23597a.getApplicationContext(), 0.0f));
            relativeLayout2.addView(textView6, layoutParams4);
            Context applicationContext = this.f23597a.getApplicationContext();
            int i3 = com.baidu.ufosdk.b.D;
            StateListDrawable stateListDrawable = new StateListDrawable();
            ColorDrawable colorDrawable = new ColorDrawable(i3);
            stateListDrawable.addState(new int[]{16842919}, new BitmapDrawable(com.baidu.ufosdk.f.m.a(applicationContext, "ufo_list_press.png")));
            stateListDrawable.addState(new int[0], colorDrawable);
            relativeLayout2.setBackgroundDrawable(stateListDrawable);
            dtVar.f23592a = textView4;
            dtVar.f23593b = textView3;
            dtVar.f23594c = textView5;
            dtVar.f23595d = textView6;
            relativeLayout2.setTag(dtVar);
            relativeLayout = relativeLayout2;
        } else {
            dtVar = (dt) view.getTag();
            relativeLayout = view;
        }
        TextView textView7 = dtVar.f23592a;
        list = this.f23597a.f23428e;
        textView7.setText((String) ((Map) list.get(i2)).get("content"));
        TextView textView8 = dtVar.f23594c;
        list2 = this.f23597a.f23428e;
        textView8.setText(FeedbackListActivity.a((String) ((Map) list2.get(i2)).get("time")));
        list3 = this.f23597a.f23428e;
        if (((String) ((Map) list3.get(i2)).get("replied")).equals("1")) {
            textView = dtVar.f23595d;
            sb = new StringBuilder("[已回复] ");
        } else {
            list4 = this.f23597a.f23428e;
            if (((String) ((Map) list4.get(i2)).get("replied")).equals("0")) {
                textView = dtVar.f23595d;
                sb = new StringBuilder("[待回复] ");
            } else {
                list5 = this.f23597a.f23428e;
                if (!((String) ((Map) list5.get(i2)).get("replied")).equals("2")) {
                    list6 = this.f23597a.f23428e;
                    if (((String) ((Map) list6.get(i2)).get("replied")).equals("3")) {
                        textView = dtVar.f23595d;
                        sb = new StringBuilder("[已评价] ");
                    }
                    list7 = this.f23597a.f23428e;
                    if (((String) ((Map) list7.get(i2)).get("newmsg")).equals("0")) {
                        textView2 = dtVar.f23593b;
                        bitmapDrawable = new BitmapDrawable(FeedbackListActivity.o(this.f23597a));
                    } else {
                        textView2 = dtVar.f23593b;
                        bitmapDrawable = null;
                    }
                    textView2.setBackgroundDrawable(bitmapDrawable);
                    return relativeLayout;
                }
                textView = dtVar.f23595d;
                sb = new StringBuilder("[邀请评价] ");
            }
        }
        list8 = this.f23597a.f23428e;
        sb.append((String) ((Map) list8.get(i2)).get("lastmsg"));
        textView.setText(sb.toString());
        list7 = this.f23597a.f23428e;
        if (((String) ((Map) list7.get(i2)).get("newmsg")).equals("0")) {
        }
        textView2.setBackgroundDrawable(bitmapDrawable);
        return relativeLayout;
    }
}
