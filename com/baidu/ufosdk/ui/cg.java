package com.baidu.ufosdk.ui;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v4.internal.view.SupportMenu;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.adp.lib.cache.BdKVCache;
import com.baidu.live.tbadk.statics.AlaStaticKeys;
import com.baidu.searchbox.ugc.utils.UgcUBCUtils;
import com.baidu.tieba.R;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
/* loaded from: classes21.dex */
public final class cg extends BaseAdapter {
    final /* synthetic */ FeedbackInputActivity a;
    private Context b;

    public cg(FeedbackInputActivity feedbackInputActivity, Context context) {
        this.a = feedbackInputActivity;
        this.b = context;
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        return this.a.h.size();
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
        RelativeLayout relativeLayout;
        PackageManager packageManager;
        ApplicationInfo applicationInfo;
        String str;
        Handler handler;
        int i2;
        int i3;
        int i4;
        Handler handler2;
        eq eqVar;
        ArrayList arrayList;
        ArrayList arrayList2;
        eq eqVar2;
        ArrayList arrayList3;
        ArrayList arrayList4;
        eq eqVar3;
        Handler handler3;
        int i5 = ((Integer) ((Map) this.a.h.get(i)).get("from")).equals(0) ? ((String) ((Map) this.a.h.get(i)).get("contenttype")).contentEquals("1") ? 1 : ((String) ((Map) this.a.h.get(i)).get("contenttype")).contentEquals("2") ? 1 : 2 : ((Integer) ((Map) this.a.h.get(i)).get("from")).equals(1) ? ((String) ((Map) this.a.h.get(i)).get("contenttype")).contentEquals("1") ? 4 : ((String) ((Map) this.a.h.get(i)).get("contenttype")).contentEquals("2") ? 4 : (((Map) this.a.h.get(i)).get("content").toString().startsWith("http://bs.baidu.com") || ((Map) this.a.h.get(i)).get("content").toString().startsWith("https://bs.baidu.com")) ? 4 : ((String) ((Map) this.a.h.get(i)).get("contenttype")).contentEquals("-1") ? 5 : 3 : 3;
        cz czVar = new cz();
        db dbVar = new db();
        da daVar = new da();
        dc dcVar = new dc();
        dd ddVar = new dd();
        if (view == null || ((Integer) view.getTag(R.id.TAG_GIFT_ITEM)).intValue() != i5) {
            if (i5 == 1) {
                RelativeLayout relativeLayout2 = new RelativeLayout(this.b);
                RelativeLayout relativeLayout3 = new RelativeLayout(this.b);
                RelativeLayout relativeLayout4 = new RelativeLayout(this.b);
                relativeLayout2.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
                relativeLayout2.setBackgroundColor(com.baidu.ufosdk.b.z);
                relativeLayout3.setBackgroundColor(com.baidu.ufosdk.b.z);
                relativeLayout4.setBackgroundColor(com.baidu.ufosdk.b.z);
                relativeLayout4.setId(R.string.abc_search_hint);
                relativeLayout4.setClickable(false);
                TextView textView = new TextView(this.a);
                try {
                    textView.setBackgroundDrawable(com.baidu.ufosdk.f.o.a(this.a.getApplicationContext(), "ufo_date_bg.9.png"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                textView.setTextColor(-1);
                textView.setTextSize(com.baidu.ufosdk.b.Q);
                textView.setGravity(17);
                textView.setMovementMethod(LinkMovementMethod.getInstance());
                textView.setPadding(com.baidu.ufosdk.f.i.a(this.a.getApplicationContext(), 10.0f), com.baidu.ufosdk.f.i.a(this.a.getApplicationContext(), 2.0f) + 2, com.baidu.ufosdk.f.i.a(this.a.getApplicationContext(), 10.0f), com.baidu.ufosdk.f.i.a(this.a.getApplicationContext(), 2.0f));
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.setMargins(0, com.baidu.ufosdk.f.i.a(this.a.getApplicationContext(), 10.0f), 0, 0);
                layoutParams.addRule(14);
                relativeLayout4.addView(textView, layoutParams);
                ViewGroup.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
                relativeLayout4.setPadding(0, com.baidu.ufosdk.f.i.a(this.a.getApplicationContext(), 6.0f), 0, com.baidu.ufosdk.f.i.a(this.a.getApplicationContext(), 8.0f));
                relativeLayout2.addView(relativeLayout4, layoutParams2);
                dcVar.a = textView;
                dcVar.d = relativeLayout4;
                ImageView imageView = new ImageView(this.a);
                imageView.setId(R.string.abc_capital_off);
                RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(com.baidu.ufosdk.f.i.a(this.a.getApplicationContext(), 40.0f), com.baidu.ufosdk.f.i.a(this.a.getApplicationContext(), 40.0f));
                layoutParams3.addRule(11);
                layoutParams3.setMargins(com.baidu.ufosdk.f.i.a(this.a.getApplicationContext(), 6.0f), 0, com.baidu.ufosdk.f.i.a(this.a.getApplicationContext(), 8.0f), 0);
                relativeLayout3.addView(imageView, layoutParams3);
                dcVar.b = imageView;
                RelativeLayout relativeLayout5 = new RelativeLayout(this.a);
                try {
                    relativeLayout5.setBackgroundDrawable(com.baidu.ufosdk.f.o.a(this.a.getApplicationContext(), "ufo_me_send_bg.9.png"));
                    relativeLayout5.setPadding(com.baidu.ufosdk.f.i.a(this.a.getApplicationContext(), 1.0f), com.baidu.ufosdk.f.i.a(this.a.getApplicationContext(), 1.0f), 11, com.baidu.ufosdk.f.i.a(this.a.getApplicationContext(), 1.0f));
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                ImageView imageView2 = new ImageView(this.a);
                imageView2.setOnClickListener(new ch(this));
                imageView2.setScaleType(ImageView.ScaleType.FIT_XY);
                imageView2.setAdjustViewBounds(true);
                RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams4.setMargins(0, 0, 0, 0);
                relativeLayout5.addView(imageView2, layoutParams4);
                RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams5.setMargins(com.baidu.ufosdk.f.i.a(this.a.getApplicationContext(), 55.0f), 0, 0, 0);
                layoutParams5.addRule(0, imageView.getId());
                relativeLayout3.addView(relativeLayout5, layoutParams5);
                dcVar.c = imageView2;
                relativeLayout3.setPadding(0, 0, 0, com.baidu.ufosdk.f.i.a(this.a.getApplicationContext(), 20.0f));
                RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams6.addRule(3, relativeLayout4.getId());
                relativeLayout2.addView(relativeLayout3, layoutParams6);
                relativeLayout2.setOnClickListener(new cq(this));
                relativeLayout2.setTag(R.id.TAG_GIFT_VIEW_HOLDER, dcVar);
                relativeLayout2.setTag(R.id.TAG_GIFT_ITEM, Integer.valueOf(i5));
                relativeLayout = relativeLayout2;
            } else if (i5 == 2) {
                RelativeLayout relativeLayout6 = new RelativeLayout(this.b);
                RelativeLayout relativeLayout7 = new RelativeLayout(this.b);
                RelativeLayout relativeLayout8 = new RelativeLayout(this.b);
                ViewGroup.LayoutParams layoutParams7 = new AbsListView.LayoutParams(-1, -2);
                relativeLayout6.setBackgroundColor(com.baidu.ufosdk.b.z);
                relativeLayout7.setBackgroundColor(com.baidu.ufosdk.b.z);
                relativeLayout8.setBackgroundColor(com.baidu.ufosdk.b.z);
                relativeLayout6.setLayoutParams(layoutParams7);
                relativeLayout8.setId(R.string.abc_search_hint);
                relativeLayout8.setClickable(false);
                TextView textView2 = new TextView(this.a);
                try {
                    textView2.setBackgroundDrawable(com.baidu.ufosdk.f.o.a(this.a.getApplicationContext(), "ufo_date_bg.9.png"));
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
                textView2.setTextColor(-1);
                textView2.setTextSize(com.baidu.ufosdk.b.Q);
                textView2.setGravity(17);
                textView2.setMovementMethod(LinkMovementMethod.getInstance());
                textView2.setPadding(com.baidu.ufosdk.f.i.a(this.a.getApplicationContext(), 10.0f), com.baidu.ufosdk.f.i.a(this.a.getApplicationContext(), 2.0f) + 2, com.baidu.ufosdk.f.i.a(this.a.getApplicationContext(), 10.0f), com.baidu.ufosdk.f.i.a(this.a.getApplicationContext(), 2.0f));
                RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams8.setMargins(0, com.baidu.ufosdk.f.i.a(this.a.getApplicationContext(), 10.0f), 0, 0);
                layoutParams8.addRule(14);
                relativeLayout8.addView(textView2, layoutParams8);
                ViewGroup.LayoutParams layoutParams9 = new RelativeLayout.LayoutParams(-1, -2);
                relativeLayout8.setPadding(0, com.baidu.ufosdk.f.i.a(this.a.getApplicationContext(), 6.0f), 0, com.baidu.ufosdk.f.i.a(this.a.getApplicationContext(), 8.0f));
                relativeLayout6.addView(relativeLayout8, layoutParams9);
                ddVar.a = textView2;
                ddVar.d = relativeLayout8;
                ImageView imageView3 = new ImageView(this.a);
                imageView3.setId(R.string.abc_capital_off);
                RelativeLayout.LayoutParams layoutParams10 = new RelativeLayout.LayoutParams(com.baidu.ufosdk.f.i.a(this.a.getApplicationContext(), 40.0f), com.baidu.ufosdk.f.i.a(this.a.getApplicationContext(), 40.0f));
                layoutParams10.addRule(11);
                layoutParams10.setMargins(com.baidu.ufosdk.f.i.a(this.a.getApplicationContext(), 6.0f), 0, com.baidu.ufosdk.f.i.a(this.a.getApplicationContext(), 8.0f), 0);
                relativeLayout7.addView(imageView3, layoutParams10);
                ddVar.b = imageView3;
                TextView textView3 = new TextView(this.a);
                textView3.setTextColor(-13421773);
                textView3.setTextSize(com.baidu.ufosdk.b.R);
                textView3.setLineSpacing(4.0f, 1.0f);
                try {
                    textView3.setBackgroundDrawable(com.baidu.ufosdk.f.o.a(this.a.getApplicationContext(), "ufo_me_send_bg.9.png"));
                } catch (IOException e4) {
                    e4.printStackTrace();
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
                textView3.setGravity(16);
                textView3.setPadding(com.baidu.ufosdk.f.i.a(this.a.getApplicationContext(), 10.0f), com.baidu.ufosdk.f.i.a(this.a.getApplicationContext(), 8.0f), com.baidu.ufosdk.f.i.a(this.a.getApplicationContext(), 14.0f), com.baidu.ufosdk.f.i.a(this.a.getApplicationContext(), 8.0f));
                textView3.setLineSpacing(5.0f, 1.0f);
                textView3.setAutoLinkMask(1);
                textView3.setMovementMethod(LinkMovementMethod.getInstance());
                textView3.setOnLongClickListener(new cr(this));
                RelativeLayout.LayoutParams layoutParams11 = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams11.setMargins(com.baidu.ufosdk.f.i.a(this.a.getApplicationContext(), 55.0f), 0, 0, 0);
                layoutParams11.addRule(0, imageView3.getId());
                relativeLayout7.addView(textView3, layoutParams11);
                ddVar.c = textView3;
                relativeLayout7.setPadding(0, 0, 0, com.baidu.ufosdk.f.i.a(this.a.getApplicationContext(), 10.0f));
                RelativeLayout.LayoutParams layoutParams12 = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams12.addRule(3, relativeLayout8.getId());
                relativeLayout6.addView(relativeLayout7, layoutParams12);
                relativeLayout6.setOnClickListener(new cs(this));
                relativeLayout6.setTag(R.id.TAG_GIFT_VIEW_HOLDER, ddVar);
                relativeLayout6.setTag(R.id.TAG_GIFT_ITEM, Integer.valueOf(i5));
                relativeLayout = relativeLayout6;
            } else if (i5 == 3) {
                RelativeLayout relativeLayout9 = new RelativeLayout(this.b);
                RelativeLayout relativeLayout10 = new RelativeLayout(this.b);
                RelativeLayout relativeLayout11 = new RelativeLayout(this.b);
                ViewGroup.LayoutParams layoutParams13 = new AbsListView.LayoutParams(-1, -2);
                relativeLayout9.setBackgroundColor(com.baidu.ufosdk.b.z);
                relativeLayout10.setBackgroundColor(com.baidu.ufosdk.b.z);
                relativeLayout11.setBackgroundColor(com.baidu.ufosdk.b.z);
                relativeLayout9.setLayoutParams(layoutParams13);
                relativeLayout11.setId(R.string.abc_search_hint);
                relativeLayout11.setClickable(false);
                TextView textView4 = new TextView(this.a);
                try {
                    textView4.setBackgroundDrawable(com.baidu.ufosdk.f.o.a(this.a.getApplicationContext(), "ufo_date_bg.9.png"));
                } catch (Exception e6) {
                    e6.printStackTrace();
                }
                textView4.setTextColor(-1);
                textView4.setTextSize(com.baidu.ufosdk.b.Q);
                textView4.setGravity(17);
                textView4.setMovementMethod(LinkMovementMethod.getInstance());
                textView4.setPadding(com.baidu.ufosdk.f.i.a(this.a.getApplicationContext(), 10.0f), com.baidu.ufosdk.f.i.a(this.a.getApplicationContext(), 2.0f) + 2, com.baidu.ufosdk.f.i.a(this.a.getApplicationContext(), 10.0f), com.baidu.ufosdk.f.i.a(this.a.getApplicationContext(), 2.0f));
                RelativeLayout.LayoutParams layoutParams14 = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams14.setMargins(0, com.baidu.ufosdk.f.i.a(this.a.getApplicationContext(), 10.0f), 0, 0);
                layoutParams14.addRule(14);
                relativeLayout11.addView(textView4, layoutParams14);
                ViewGroup.LayoutParams layoutParams15 = new RelativeLayout.LayoutParams(-1, -2);
                relativeLayout11.setPadding(0, com.baidu.ufosdk.f.i.a(this.a.getApplicationContext(), 6.0f), 0, com.baidu.ufosdk.f.i.a(this.a.getApplicationContext(), 8.0f));
                relativeLayout9.addView(relativeLayout11, layoutParams15);
                dbVar.a = textView4;
                dbVar.d = relativeLayout11;
                ImageView imageView4 = new ImageView(this.a);
                imageView4.setId(R.string.abc_capital_off);
                RelativeLayout.LayoutParams layoutParams16 = new RelativeLayout.LayoutParams(com.baidu.ufosdk.f.i.a(this.a.getApplicationContext(), 40.0f), com.baidu.ufosdk.f.i.a(this.a.getApplicationContext(), 40.0f));
                layoutParams16.setMargins(com.baidu.ufosdk.f.i.a(this.a.getApplicationContext(), 8.0f), 0, com.baidu.ufosdk.f.i.a(this.a.getApplicationContext(), 4.0f), 0);
                layoutParams16.addRule(9);
                relativeLayout10.addView(imageView4, layoutParams16);
                dbVar.b = imageView4;
                LinearLayout linearLayout = new LinearLayout(this.b);
                linearLayout.setOrientation(1);
                linearLayout.setId(R.id.action_menu_divider);
                try {
                    linearLayout.setBackgroundDrawable(com.baidu.ufosdk.f.o.a(this.a.getApplicationContext(), "ufo_server_send_bg.9.png"));
                } catch (IOException e7) {
                    e7.printStackTrace();
                } catch (Exception e8) {
                    e8.printStackTrace();
                }
                TextView textView5 = new TextView(this.a);
                textView5.setId(R.id.action_button);
                textView5.setPadding(com.baidu.ufosdk.f.i.a(this.a.getApplicationContext(), 15.0f), com.baidu.ufosdk.f.i.a(this.a.getApplicationContext(), 8.0f), com.baidu.ufosdk.f.i.a(this.a.getApplicationContext(), 8.0f), com.baidu.ufosdk.f.i.a(this.a.getApplicationContext(), 8.0f));
                textView5.setGravity(16);
                textView5.setLineSpacing(5.0f, 1.0f);
                textView5.setTextColor(-13421773);
                textView5.setTextSize(com.baidu.ufosdk.b.R);
                textView5.setAutoLinkMask(1);
                textView5.setMovementMethod(LinkMovementMethod.getInstance());
                textView5.setOnLongClickListener(new ct(this));
                dbVar.c = textView5;
                linearLayout.addView(textView5, new LinearLayout.LayoutParams(-2, -2));
                RelativeLayout relativeLayout12 = new RelativeLayout(this.b);
                relativeLayout12.setVisibility(8);
                relativeLayout12.setBackgroundColor(-1);
                LinearLayout linearLayout2 = new LinearLayout(this.b);
                linearLayout2.setBackgroundColor(-1);
                linearLayout2.setOrientation(0);
                TextView textView6 = new TextView(this.b);
                textView6.setText("满意");
                textView6.setTextColor(-12814593);
                textView6.setTextSize(15.0f);
                textView6.setGravity(17);
                BitmapDrawable bitmapDrawable = new BitmapDrawable(com.baidu.ufosdk.f.m.a(this.a.getApplicationContext(), "ufo_solved.png"));
                bitmapDrawable.setBounds(com.baidu.ufosdk.f.i.a(this.a.getApplicationContext(), 20.0f), 0, com.baidu.ufosdk.f.i.a(this.a.getApplicationContext(), 40.0f), com.baidu.ufosdk.f.i.a(this.a.getApplicationContext(), 20.0f));
                textView6.setCompoundDrawables(bitmapDrawable, null, null, null);
                textView6.setBackgroundDrawable(com.baidu.ufosdk.f.m.a(this.a.getApplicationContext(), "ufo_bottom_button.9.png", "ufo_bottom_button_pressed.9.png"));
                LinearLayout.LayoutParams layoutParams17 = new LinearLayout.LayoutParams(-1, com.baidu.ufosdk.f.i.a(this.a.getApplicationContext(), 35.0f));
                layoutParams17.setMargins(0, 0, com.baidu.ufosdk.f.i.a(this.a.getApplicationContext(), 5.0f), 0);
                layoutParams17.weight = 1.0f;
                linearLayout2.addView(textView6, layoutParams17);
                TextView textView7 = new TextView(this.b);
                textView7.setText("不满意");
                textView7.setTextColor(SupportMenu.CATEGORY_MASK);
                textView7.setTextSize(15.0f);
                textView7.setGravity(17);
                BitmapDrawable bitmapDrawable2 = new BitmapDrawable(com.baidu.ufosdk.f.m.a(this.a.getApplicationContext(), "ufo_not_solved.png"));
                bitmapDrawable2.setBounds(com.baidu.ufosdk.f.i.a(this.a.getApplicationContext(), 13.0f), 0, com.baidu.ufosdk.f.i.a(this.a.getApplicationContext(), 33.0f), com.baidu.ufosdk.f.i.a(this.a.getApplicationContext(), 20.0f));
                textView7.setCompoundDrawables(bitmapDrawable2, null, null, null);
                textView7.setBackgroundDrawable(com.baidu.ufosdk.f.m.a(this.a.getApplicationContext(), "ufo_bottom_button.9.png", "ufo_bottom_button_pressed.9.png"));
                LinearLayout.LayoutParams layoutParams18 = new LinearLayout.LayoutParams(-1, com.baidu.ufosdk.f.i.a(this.a.getApplicationContext(), 35.0f));
                layoutParams18.setMargins(com.baidu.ufosdk.f.i.a(this.a.getApplicationContext(), 5.0f), 0, 0, 0);
                layoutParams18.weight = 1.0f;
                linearLayout2.addView(textView7, layoutParams18);
                relativeLayout12.addView(linearLayout2, new RelativeLayout.LayoutParams(-1, -1));
                dbVar.e = relativeLayout12;
                dbVar.f = textView6;
                dbVar.g = textView7;
                i iVar = new i(this.a);
                iVar.setVisibility(8);
                dbVar.h = iVar;
                ImageView imageView5 = new ImageView(this.a);
                imageView5.setId(R.string.sapi_sdk_common_loading_timeout);
                imageView5.setVisibility(8);
                dbVar.i = imageView5;
                LinearLayout.LayoutParams layoutParams19 = new LinearLayout.LayoutParams(-2, -2);
                layoutParams19.setMargins(com.baidu.ufosdk.f.i.a(this.a.getApplicationContext(), 16.0f), com.baidu.ufosdk.f.i.a(this.a.getApplicationContext(), 3.0f), com.baidu.ufosdk.f.i.a(this.a.getApplicationContext(), 16.0f), com.baidu.ufosdk.f.i.a(this.a.getApplicationContext(), 13.0f));
                linearLayout.addView(relativeLayout12, layoutParams19);
                LinearLayout.LayoutParams layoutParams20 = new LinearLayout.LayoutParams(-1, com.baidu.ufosdk.f.i.a(this.a.getApplicationContext(), 0.5f));
                layoutParams20.setMargins(com.baidu.ufosdk.f.i.a(this.a.getApplicationContext(), 16.0f), com.baidu.ufosdk.f.i.a(this.a.getApplicationContext(), 3.0f), com.baidu.ufosdk.f.i.a(this.a.getApplicationContext(), 16.0f), com.baidu.ufosdk.f.i.a(this.a.getApplicationContext(), 3.0f));
                linearLayout.addView(iVar, layoutParams20);
                LinearLayout.LayoutParams layoutParams21 = new LinearLayout.LayoutParams(com.baidu.ufosdk.f.i.a(this.a.getApplicationContext(), 20.0f), com.baidu.ufosdk.f.i.a(this.a.getApplicationContext(), 20.0f));
                layoutParams21.setMargins(com.baidu.ufosdk.f.i.a(this.a.getApplicationContext(), 16.0f), com.baidu.ufosdk.f.i.a(this.a.getApplicationContext(), 3.0f), com.baidu.ufosdk.f.i.a(this.a.getApplicationContext(), 16.0f), com.baidu.ufosdk.f.i.a(this.a.getApplicationContext(), 13.0f));
                linearLayout.addView(imageView5, layoutParams21);
                RelativeLayout.LayoutParams layoutParams22 = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams22.setMargins(0, 0, com.baidu.ufosdk.f.i.a(this.a.getApplicationContext(), 57.0f), 0);
                layoutParams22.addRule(1, imageView4.getId());
                relativeLayout10.addView(linearLayout, layoutParams22);
                TextView textView8 = new TextView(this.b);
                textView8.setVisibility(8);
                textView8.setText("填写不满意原因");
                textView8.setTextSize(15.0f);
                textView8.setTextColor(com.baidu.ufosdk.f.i.a(-12814593, -15644211, -12814593, -12814593));
                Drawable a = com.baidu.ufosdk.f.i.a(this.b, com.baidu.ufosdk.R.drawable.ufo_show_reason_normal);
                a.setBounds(com.baidu.ufosdk.f.i.a(this.b, 1.0f), com.baidu.ufosdk.f.i.a(this.b, 1.0f), com.baidu.ufosdk.f.i.a(this.b, 14.0f), com.baidu.ufosdk.f.i.a(this.b, 14.0f));
                textView8.setCompoundDrawables(null, null, a, null);
                RelativeLayout.LayoutParams layoutParams23 = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams23.addRule(3, linearLayout.getId());
                layoutParams23.addRule(1, imageView4.getId());
                layoutParams23.setMargins(com.baidu.ufosdk.f.i.a(this.a.getApplicationContext(), 3.0f), com.baidu.ufosdk.f.i.a(this.a.getApplicationContext(), 8.0f), com.baidu.ufosdk.f.i.a(this.a.getApplicationContext(), 16.0f), com.baidu.ufosdk.f.i.a(this.a.getApplicationContext(), 13.0f));
                relativeLayout10.addView(textView8, layoutParams23);
                dbVar.j = textView8;
                relativeLayout10.setPadding(0, 0, 0, com.baidu.ufosdk.f.i.a(this.a.getApplicationContext(), 10.0f));
                RelativeLayout.LayoutParams layoutParams24 = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams24.addRule(3, relativeLayout11.getId());
                relativeLayout9.addView(relativeLayout10, layoutParams24);
                relativeLayout9.setOnClickListener(new cu(this));
                relativeLayout9.setTag(R.id.TAG_GIFT_VIEW_HOLDER, dbVar);
                relativeLayout9.setTag(R.id.TAG_GIFT_ITEM, Integer.valueOf(i5));
                relativeLayout = relativeLayout9;
            } else if (i5 == 4) {
                RelativeLayout relativeLayout13 = new RelativeLayout(this.b);
                RelativeLayout relativeLayout14 = new RelativeLayout(this.b);
                RelativeLayout relativeLayout15 = new RelativeLayout(this.b);
                ViewGroup.LayoutParams layoutParams25 = new AbsListView.LayoutParams(-1, -2);
                relativeLayout13.setBackgroundColor(com.baidu.ufosdk.b.z);
                relativeLayout14.setBackgroundColor(com.baidu.ufosdk.b.z);
                relativeLayout15.setBackgroundColor(com.baidu.ufosdk.b.z);
                relativeLayout13.setLayoutParams(layoutParams25);
                relativeLayout15.setId(R.string.abc_search_hint);
                relativeLayout15.setClickable(false);
                TextView textView9 = new TextView(this.a);
                try {
                    textView9.setBackgroundDrawable(com.baidu.ufosdk.f.o.a(this.a.getApplicationContext(), "ufo_date_bg.9.png"));
                } catch (Exception e9) {
                    e9.printStackTrace();
                }
                textView9.setTextColor(-1);
                textView9.setTextSize(com.baidu.ufosdk.b.Q);
                textView9.setGravity(17);
                textView9.setMovementMethod(LinkMovementMethod.getInstance());
                textView9.setPadding(com.baidu.ufosdk.f.i.a(this.a.getApplicationContext(), 10.0f), com.baidu.ufosdk.f.i.a(this.a.getApplicationContext(), 2.0f) + 2, com.baidu.ufosdk.f.i.a(this.a.getApplicationContext(), 10.0f), com.baidu.ufosdk.f.i.a(this.a.getApplicationContext(), 2.0f));
                RelativeLayout.LayoutParams layoutParams26 = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams26.setMargins(0, com.baidu.ufosdk.f.i.a(this.a.getApplicationContext(), 10.0f), 0, 0);
                layoutParams26.addRule(14);
                relativeLayout15.addView(textView9, layoutParams26);
                ViewGroup.LayoutParams layoutParams27 = new RelativeLayout.LayoutParams(-1, -2);
                relativeLayout15.setPadding(0, com.baidu.ufosdk.f.i.a(this.a.getApplicationContext(), 6.0f), 0, com.baidu.ufosdk.f.i.a(this.a.getApplicationContext(), 8.0f));
                relativeLayout13.addView(relativeLayout15, layoutParams27);
                czVar.a = textView9;
                czVar.d = relativeLayout15;
                ImageView imageView6 = new ImageView(this.a);
                imageView6.setId(R.string.abc_capital_off);
                RelativeLayout.LayoutParams layoutParams28 = new RelativeLayout.LayoutParams(com.baidu.ufosdk.f.i.a(this.a.getApplicationContext(), 40.0f), com.baidu.ufosdk.f.i.a(this.a.getApplicationContext(), 40.0f));
                layoutParams28.setMargins(com.baidu.ufosdk.f.i.a(this.a.getApplicationContext(), 8.0f), 0, com.baidu.ufosdk.f.i.a(this.a.getApplicationContext(), 4.0f), 0);
                layoutParams28.addRule(9);
                relativeLayout14.addView(imageView6, layoutParams28);
                czVar.b = imageView6;
                RelativeLayout relativeLayout16 = new RelativeLayout(this.a);
                try {
                    relativeLayout16.setBackgroundDrawable(com.baidu.ufosdk.f.o.a(this.a.getApplicationContext(), "ufo_server_send_bg.9.png"));
                    relativeLayout16.setPadding(11, com.baidu.ufosdk.f.i.a(this.a.getApplicationContext(), 1.2f), com.baidu.ufosdk.f.i.a(this.a.getApplicationContext(), 1.0f), com.baidu.ufosdk.f.i.a(this.a.getApplicationContext(), 1.0f));
                } catch (Exception e10) {
                    e10.printStackTrace();
                }
                ImageView imageView7 = new ImageView(this.a);
                imageView7.setOnClickListener(new cv(this));
                imageView7.setScaleType(ImageView.ScaleType.FIT_XY);
                if (com.baidu.ufosdk.f.i.a() < 23) {
                    imageView7.setAdjustViewBounds(true);
                    RelativeLayout.LayoutParams layoutParams29 = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams29.setMargins(0, 0, 0, 0);
                    relativeLayout16.addView(imageView7, layoutParams29);
                } else {
                    RelativeLayout.LayoutParams layoutParams30 = new RelativeLayout.LayoutParams(com.baidu.ufosdk.f.i.a(this.a.getApplicationContext(), 80.0f), com.baidu.ufosdk.f.i.a(this.a.getApplicationContext(), 120.0f));
                    layoutParams30.setMargins(0, 0, 0, 0);
                    relativeLayout16.addView(imageView7, layoutParams30);
                }
                RelativeLayout.LayoutParams layoutParams31 = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams31.setMargins(0, 0, com.baidu.ufosdk.f.i.a(this.a.getApplicationContext(), 57.0f), 0);
                layoutParams31.addRule(1, imageView6.getId());
                relativeLayout14.addView(relativeLayout16, layoutParams31);
                czVar.c = imageView7;
                relativeLayout14.setPadding(0, 0, 0, com.baidu.ufosdk.f.i.a(this.a.getApplicationContext(), 10.0f));
                RelativeLayout.LayoutParams layoutParams32 = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams32.addRule(3, relativeLayout15.getId());
                relativeLayout13.addView(relativeLayout14, layoutParams32);
                relativeLayout13.setOnClickListener(new cw(this));
                relativeLayout13.setTag(R.id.TAG_GIFT_VIEW_HOLDER, czVar);
                relativeLayout13.setTag(R.id.TAG_GIFT_ITEM, Integer.valueOf(i5));
                relativeLayout = relativeLayout13;
            } else {
                relativeLayout = view;
                if (i5 == 5) {
                    RelativeLayout relativeLayout17 = new RelativeLayout(this.b);
                    RelativeLayout relativeLayout18 = new RelativeLayout(this.b);
                    RelativeLayout relativeLayout19 = new RelativeLayout(this.b);
                    ViewGroup.LayoutParams layoutParams33 = new AbsListView.LayoutParams(-1, -2);
                    relativeLayout17.setBackgroundColor(com.baidu.ufosdk.b.z);
                    relativeLayout18.setBackgroundColor(com.baidu.ufosdk.b.z);
                    relativeLayout19.setBackgroundColor(com.baidu.ufosdk.b.z);
                    relativeLayout17.setLayoutParams(layoutParams33);
                    relativeLayout19.setId(R.string.abc_search_hint);
                    relativeLayout19.setClickable(false);
                    TextView textView10 = new TextView(this.a);
                    try {
                        textView10.setBackgroundDrawable(com.baidu.ufosdk.f.o.a(this.a.getApplicationContext(), "ufo_date_bg.9.png"));
                    } catch (Exception e11) {
                        e11.printStackTrace();
                    }
                    textView10.setTextColor(-1);
                    textView10.setTextSize(com.baidu.ufosdk.b.Q);
                    textView10.setGravity(17);
                    textView10.setMovementMethod(LinkMovementMethod.getInstance());
                    textView10.setPadding(com.baidu.ufosdk.f.i.a(this.a.getApplicationContext(), 10.0f), com.baidu.ufosdk.f.i.a(this.a.getApplicationContext(), 2.0f) + 2, com.baidu.ufosdk.f.i.a(this.a.getApplicationContext(), 10.0f), com.baidu.ufosdk.f.i.a(this.a.getApplicationContext(), 2.0f));
                    RelativeLayout.LayoutParams layoutParams34 = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams34.setMargins(0, com.baidu.ufosdk.f.i.a(this.a.getApplicationContext(), 10.0f), 0, 0);
                    layoutParams34.addRule(14);
                    relativeLayout19.addView(textView10, layoutParams34);
                    ViewGroup.LayoutParams layoutParams35 = new RelativeLayout.LayoutParams(-1, -2);
                    relativeLayout19.setPadding(0, com.baidu.ufosdk.f.i.a(this.a.getApplicationContext(), 6.0f), 0, com.baidu.ufosdk.f.i.a(this.a.getApplicationContext(), 8.0f));
                    relativeLayout17.addView(relativeLayout19, layoutParams35);
                    daVar.a = textView10;
                    daVar.g = relativeLayout19;
                    ImageView imageView8 = new ImageView(this.a);
                    imageView8.setId(R.string.abc_capital_off);
                    RelativeLayout.LayoutParams layoutParams36 = new RelativeLayout.LayoutParams(com.baidu.ufosdk.f.i.a(this.a.getApplicationContext(), 40.0f), com.baidu.ufosdk.f.i.a(this.a.getApplicationContext(), 40.0f));
                    layoutParams36.setMargins(com.baidu.ufosdk.f.i.a(this.a.getApplicationContext(), 8.0f), 0, com.baidu.ufosdk.f.i.a(this.a.getApplicationContext(), 4.0f), 0);
                    layoutParams36.addRule(9);
                    relativeLayout18.addView(imageView8, layoutParams36);
                    daVar.b = imageView8;
                    LinearLayout linearLayout3 = new LinearLayout(this.a);
                    linearLayout3.setOrientation(1);
                    linearLayout3.setId(R.id.action_bar_spinner);
                    try {
                        linearLayout3.setBackgroundDrawable(com.baidu.ufosdk.f.o.a(this.a.getApplicationContext(), "ufo_server_send_bg_type5.9.png"));
                    } catch (Exception e12) {
                        e12.printStackTrace();
                    }
                    linearLayout3.setPadding(10, 3, 2, 2);
                    TextView textView11 = new TextView(this.a);
                    textView11.setGravity(16);
                    textView11.setLineSpacing(5.0f, 1.0f);
                    textView11.setSingleLine(false);
                    textView11.setTextColor(-13421773);
                    textView11.setBackgroundColor(-657931);
                    textView11.setTextSize(com.baidu.ufosdk.b.R);
                    textView11.setPadding(com.baidu.ufosdk.f.i.a(this.a.getApplicationContext(), 10.0f), com.baidu.ufosdk.f.i.a(this.a.getApplicationContext(), 5.0f), 0, com.baidu.ufosdk.f.i.a(this.a.getApplicationContext(), 5.0f));
                    linearLayout3.addView(textView11, new LinearLayout.LayoutParams(-1, -2));
                    daVar.d = textView11;
                    ListView listView = new ListView(this.a);
                    listView.setBackgroundColor(com.baidu.ufosdk.b.D);
                    listView.setDivider(new ColorDrawable(com.baidu.ufosdk.b.I));
                    listView.setDividerHeight(0);
                    linearLayout3.addView(listView, new LinearLayout.LayoutParams(-1, -2));
                    daVar.c = listView;
                    View view2 = new View(this.a);
                    view2.setBackgroundColor(-657931);
                    view2.setVisibility(8);
                    linearLayout3.addView(view2, new LinearLayout.LayoutParams(-1, com.baidu.ufosdk.f.i.a(this.a.getApplicationContext(), 1.0f)));
                    LinearLayout linearLayout4 = new LinearLayout(this.a);
                    linearLayout4.setBackgroundColor(com.baidu.ufosdk.b.z);
                    TextView textView12 = new TextView(this.a);
                    textView12.setGravity(16);
                    textView12.setBackgroundColor(com.baidu.ufosdk.b.z);
                    textView12.setLineSpacing(5.0f, 1.0f);
                    textView12.setTextColor(-13421773);
                    textView12.setTextSize(com.baidu.ufosdk.b.R - 3.0f);
                    textView12.setAutoLinkMask(1);
                    LinearLayout.LayoutParams layoutParams37 = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams37.setMargins(com.baidu.ufosdk.f.i.a(this.a.getApplicationContext(), 5.0f), com.baidu.ufosdk.f.i.a(this.a.getApplicationContext(), 5.0f), com.baidu.ufosdk.f.i.a(this.a.getApplicationContext(), 15.0f), com.baidu.ufosdk.f.i.a(this.a.getApplicationContext(), 5.0f));
                    linearLayout4.addView(textView12, layoutParams37);
                    daVar.e = textView12;
                    RelativeLayout.LayoutParams layoutParams38 = new RelativeLayout.LayoutParams(-1, -2);
                    layoutParams38.setMargins(0, 0, com.baidu.ufosdk.f.i.a(this.a.getApplicationContext(), 57.0f), 0);
                    layoutParams38.addRule(1, imageView8.getId());
                    relativeLayout18.addView(linearLayout3, layoutParams38);
                    daVar.f = linearLayout3;
                    RelativeLayout.LayoutParams layoutParams39 = new RelativeLayout.LayoutParams(-1, -2);
                    layoutParams39.addRule(1, imageView8.getId());
                    layoutParams39.addRule(3, linearLayout3.getId());
                    relativeLayout18.addView(linearLayout4, layoutParams39);
                    relativeLayout18.setPadding(0, 0, 0, com.baidu.ufosdk.f.i.a(this.a.getApplicationContext(), 10.0f));
                    RelativeLayout.LayoutParams layoutParams40 = new RelativeLayout.LayoutParams(-1, -2);
                    layoutParams40.addRule(3, relativeLayout19.getId());
                    relativeLayout17.addView(relativeLayout18, layoutParams40);
                    relativeLayout17.setTag(R.id.TAG_GIFT_VIEW_HOLDER, daVar);
                    relativeLayout17.setTag(R.id.TAG_GIFT_ITEM, Integer.valueOf(i5));
                    relativeLayout = relativeLayout17;
                }
            }
        } else if (i5 == 1) {
            dcVar = (dc) view.getTag(R.id.TAG_GIFT_VIEW_HOLDER);
            relativeLayout = view;
        } else if (i5 == 2) {
            ddVar = (dd) view.getTag(R.id.TAG_GIFT_VIEW_HOLDER);
            relativeLayout = view;
        } else if (i5 == 3) {
            dbVar = (db) view.getTag(R.id.TAG_GIFT_VIEW_HOLDER);
            relativeLayout = view;
        } else if (i5 == 4) {
            czVar = (cz) view.getTag(R.id.TAG_GIFT_VIEW_HOLDER);
            relativeLayout = view;
        } else {
            relativeLayout = view;
            if (i5 == 5) {
                daVar = (da) view.getTag(R.id.TAG_GIFT_VIEW_HOLDER);
                relativeLayout = view;
            }
        }
        PackageManager packageManager2 = null;
        Bitmap bitmap = null;
        try {
            packageManager2 = this.b.getApplicationContext().getPackageManager();
            packageManager = packageManager2;
            applicationInfo = packageManager2.getApplicationInfo(this.b.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e13) {
            packageManager = packageManager2;
            applicationInfo = null;
        }
        if (packageManager != null) {
            Drawable applicationIcon = packageManager.getApplicationIcon(applicationInfo);
            bitmap = applicationIcon instanceof BitmapDrawable ? ((BitmapDrawable) applicationIcon).getBitmap() : FeedbackInputActivity.a(applicationIcon);
        }
        if (i5 == 1) {
            dcVar.d.setVisibility(0);
            if (i == 0) {
                dcVar.a.setText(com.baidu.ufosdk.f.i.a(Long.parseLong((String) ((Map) this.a.h.get(i)).get("time"))));
            } else {
                long parseLong = Long.parseLong((String) ((Map) this.a.h.get(i - 1)).get("time"));
                long parseLong2 = Long.parseLong((String) ((Map) this.a.h.get(i)).get("time"));
                if (parseLong - parseLong2 > BdKVCache.MILLS_1Hour || parseLong2 - parseLong > BdKVCache.MILLS_1Hour) {
                    dcVar.a.setText(com.baidu.ufosdk.f.i.c(parseLong2));
                    if (parseLong - parseLong2 > 86400000 || parseLong2 - parseLong > 86400000) {
                        dcVar.a.setText(com.baidu.ufosdk.f.i.a(parseLong2));
                    }
                } else {
                    dcVar.d.setVisibility(8);
                }
            }
            try {
                dcVar.b.setBackgroundDrawable(new BitmapDrawable(com.baidu.ufosdk.f.m.c(this.a.getApplicationContext())));
            } catch (Exception e14) {
                e14.printStackTrace();
            }
            if (((String) ((Map) this.a.h.get(i)).get("contenttype")).contentEquals("1")) {
                dcVar.c.setImageBitmap(com.baidu.ufosdk.f.m.a(this.b, "ufo_pic_defult_icon.png"));
                com.baidu.ufosdk.f.a a2 = com.baidu.ufosdk.f.a.a();
                Context applicationContext = this.a.getApplicationContext();
                ImageView imageView9 = dcVar.c;
                handler3 = this.a.aK;
                Bitmap a3 = a2.a(new com.baidu.ufosdk.f.n(applicationContext, imageView9, handler3), (String) ((Map) this.a.h.get(i)).get("content"));
                if (a3 != null) {
                    dcVar.c.setImageBitmap(a3);
                    if (a3.getHeight() > a3.getWidth()) {
                        dcVar.c.setMaxWidth(com.baidu.ufosdk.f.i.a(this.a.getApplicationContext(), 80.0f));
                        dcVar.c.setMaxHeight(com.baidu.ufosdk.f.i.a(this.a.getApplicationContext(), 120.0f));
                    } else {
                        dcVar.c.setMaxWidth(com.baidu.ufosdk.f.i.a(this.a.getApplicationContext(), 120.0f));
                        dcVar.c.setMaxHeight(com.baidu.ufosdk.f.i.a(this.a.getApplicationContext(), 80.0f));
                    }
                }
            } else if (((String) ((Map) this.a.h.get(i)).get("contenttype")).contentEquals("2") && dcVar.c != null) {
                Bitmap bitmap2 = (Bitmap) ((Map) this.a.h.get(i)).get("content");
                if (bitmap2.getHeight() > bitmap2.getWidth()) {
                    dcVar.c.setMaxWidth(com.baidu.ufosdk.f.i.a(this.a.getApplicationContext(), 80.0f));
                    dcVar.c.setMaxHeight(com.baidu.ufosdk.f.i.a(this.a.getApplicationContext(), 120.0f));
                } else {
                    dcVar.c.setMaxWidth(com.baidu.ufosdk.f.i.a(this.a.getApplicationContext(), 120.0f));
                    dcVar.c.setMaxHeight(com.baidu.ufosdk.f.i.a(this.a.getApplicationContext(), 80.0f));
                }
                dcVar.c.setImageBitmap(bitmap2);
            }
        } else if (i5 == 2) {
            ddVar.d.setVisibility(0);
            if (i == 0) {
                ddVar.a.setText(com.baidu.ufosdk.f.i.a(Long.parseLong((String) ((Map) this.a.h.get(i)).get("time"))));
            } else {
                long parseLong3 = Long.parseLong((String) ((Map) this.a.h.get(i - 1)).get("time"));
                long parseLong4 = Long.parseLong((String) ((Map) this.a.h.get(i)).get("time"));
                if (parseLong3 - parseLong4 > BdKVCache.MILLS_1Hour || parseLong4 - parseLong3 > BdKVCache.MILLS_1Hour) {
                    ddVar.a.setText(com.baidu.ufosdk.f.i.c(parseLong4));
                    if (parseLong3 - parseLong4 > 86400000 || parseLong4 - parseLong3 > 86400000) {
                        ddVar.a.setText(com.baidu.ufosdk.f.i.a(parseLong4));
                    }
                } else {
                    ddVar.d.setVisibility(8);
                }
            }
            try {
                ddVar.b.setBackgroundDrawable(new BitmapDrawable(com.baidu.ufosdk.f.m.c(this.a.getApplicationContext())));
            } catch (Exception e15) {
                e15.printStackTrace();
            }
            ddVar.c.setText((String) ((Map) this.a.h.get(i)).get("content"));
        } else if (i5 == 3) {
            dbVar.d.setVisibility(0);
            if (i == 0) {
                dbVar.a.setText(com.baidu.ufosdk.f.i.a(Long.parseLong((String) ((Map) this.a.h.get(i)).get("time"))));
            } else {
                long parseLong5 = Long.parseLong((String) ((Map) this.a.h.get(i - 1)).get("time"));
                long parseLong6 = Long.parseLong((String) ((Map) this.a.h.get(i)).get("time"));
                if (parseLong5 - parseLong6 > BdKVCache.MILLS_1Hour || parseLong6 - parseLong5 > BdKVCache.MILLS_1Hour) {
                    dbVar.a.setText(com.baidu.ufosdk.f.i.c(parseLong6));
                    if (parseLong5 - parseLong6 > 86400000 || parseLong6 - parseLong5 > 86400000) {
                        dbVar.a.setText(com.baidu.ufosdk.f.i.a(parseLong6));
                    }
                } else {
                    dbVar.d.setVisibility(8);
                }
            }
            if (bitmap != null) {
                try {
                    dbVar.b.setBackgroundDrawable(new BitmapDrawable(bitmap));
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
            }
            if (dbVar.c != null) {
                String str2 = (String) ((Map) this.a.h.get(i)).get("content");
                com.baidu.ufosdk.f.c.a(str2);
                if (str2.startsWith("http://bs.baidu.com") || str2.startsWith("https://bs.baidu.com")) {
                    com.baidu.ufosdk.f.a a4 = com.baidu.ufosdk.f.a.a();
                    Context applicationContext2 = this.a.getApplicationContext();
                    TextView textView13 = dbVar.c;
                    handler2 = this.a.aK;
                    Bitmap a5 = a4.a(new com.baidu.ufosdk.f.n(applicationContext2, textView13, handler2), str2);
                    if (a5 != null) {
                        ImageSpan imageSpan = new ImageSpan(this.a.getApplicationContext(), a5);
                        SpannableString spannableString = new SpannableString(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
                        spannableString.setSpan(imageSpan, 0, 4, 33);
                        dbVar.c.setText(spannableString.toString());
                    }
                } else if (str2.contains("<a") && str2.contains("</a>")) {
                    ArrayList arrayList5 = new ArrayList();
                    ArrayList arrayList6 = new ArrayList();
                    Matcher matcher = Pattern.compile("<a[^>]*>([^<]*)</a>").matcher(str2);
                    while (matcher.find()) {
                        com.baidu.ufosdk.f.c.a("提取内容：" + matcher.group(1));
                        arrayList5.add(matcher.group(1));
                    }
                    Matcher matcher2 = Pattern.compile("[h|H][r|R][e|E][f|F] *= *'.*?'").matcher(str2);
                    while (matcher2.find()) {
                        com.baidu.ufosdk.f.c.a("提取链接：" + matcher2.group());
                        arrayList6.add(matcher2.group());
                    }
                    if (arrayList6.size() != arrayList5.size()) {
                        com.baidu.ufosdk.f.c.a("返回内容：" + str2);
                        if (str2.contains("\\\"")) {
                            com.baidu.ufosdk.f.c.a("包含\\\"");
                            str2 = str2.replace("\\\"", "(=^o^=)Y");
                        }
                        Matcher matcher3 = Pattern.compile("[h|H][r|R][e|E][f|F] *= *\".*?\"").matcher(str2);
                        while (matcher3.find()) {
                            com.baidu.ufosdk.f.c.a("提取链接：" + matcher3.group());
                            arrayList6.add(matcher3.group());
                        }
                    }
                    if (arrayList5.size() == arrayList6.size()) {
                        String str3 = str2.endsWith("</a>") ? str2 + " " : str2;
                        try {
                            String[] split = str3.split("<a.*?</a>");
                            dbVar.c.setText("");
                            for (int i6 = 0; i6 < split.length; i6++) {
                                dbVar.c.append(new SpannableString(split[i6]));
                                if (i6 < split.length - 1) {
                                    SpannableString spannableString2 = new SpannableString((CharSequence) arrayList5.get(i6));
                                    eqVar3 = this.a.aM;
                                    spannableString2.setSpan(new ep((String) arrayList6.get(i6), eqVar3), 0, ((String) arrayList5.get(i6)).length(), 33);
                                    dbVar.c.append(spannableString2);
                                }
                            }
                            dbVar.c.setMovementMethod(LinkMovementMethod.getInstance());
                        } catch (Exception e17) {
                            com.baidu.ufosdk.f.c.a("处理连接出错！", e17);
                            dbVar.c.setText(str3.contains("(=^o^=)Y") ? str3.replace("(=^o^=)Y", "\\\"") : str3);
                        }
                    } else {
                        if (str2.contains("(=^o^=)Y")) {
                            str2 = str2.replace("(=^o^=)Y", "\\\"");
                        }
                        dbVar.c.setText(str2);
                    }
                } else if (str2.contains("人工反馈")) {
                    com.baidu.ufosdk.f.c.a("lastIndexof : 人工反馈: " + str2.lastIndexOf("人工反馈"));
                    if (this.a.H) {
                        this.a.u = false;
                    } else {
                        this.a.u = true;
                    }
                    SpannableString spannableString3 = new SpannableString(str2);
                    eqVar2 = this.a.aM;
                    spannableString3.setSpan(new ep("人工反馈", eqVar2), str2.lastIndexOf("人工反馈"), str2.lastIndexOf("人工反馈") + 4, 33);
                    if (this.a.H) {
                        dbVar.c.setText(str2);
                    } else {
                        dbVar.c.setText(spannableString3);
                        dbVar.c.setMovementMethod(LinkMovementMethod.getInstance());
                    }
                    arrayList3 = this.a.aw;
                    if (arrayList3 == null) {
                        this.a.aw = new ArrayList();
                        arrayList4 = this.a.aw;
                        arrayList4.add(dbVar.c);
                    }
                } else if (str2.contains("我的反馈")) {
                    com.baidu.ufosdk.f.c.a("indexof : 我的反馈: " + str2.lastIndexOf("我的反馈"));
                    if (this.a.H) {
                        this.a.u = false;
                    } else {
                        this.a.u = true;
                    }
                    SpannableString spannableString4 = new SpannableString(str2);
                    eqVar = this.a.aM;
                    spannableString4.setSpan(new ep("我的反馈", eqVar), str2.lastIndexOf("我的反馈"), str2.lastIndexOf("我的反馈") + 4, 33);
                    if (this.a.H) {
                        dbVar.c.setText(str2);
                    } else {
                        dbVar.c.setText(spannableString4);
                        dbVar.c.setMovementMethod(LinkMovementMethod.getInstance());
                        dbVar.c.setHighlightColor(0);
                    }
                    arrayList = this.a.aw;
                    if (arrayList == null) {
                        this.a.aw = new ArrayList();
                        arrayList2 = this.a.aw;
                        arrayList2.add(dbVar.c);
                    }
                } else {
                    dbVar.c.setText(str2);
                }
            }
            try {
                i2 = ((Integer) ((Map) this.a.h.get(i)).get(UgcUBCUtils.UGC_TYPE_ASK)).intValue();
            } catch (Exception e18) {
                i2 = 0;
            }
            if (i2 == 0) {
                dbVar.e.setVisibility(8);
                dbVar.h.setVisibility(8);
                dbVar.i.setVisibility(8);
                dbVar.j.setVisibility(8);
            } else if (i2 == 1) {
                dbVar.h.setVisibility(8);
                dbVar.i.setVisibility(8);
                dbVar.j.setVisibility(8);
                dbVar.e.setVisibility(0);
                dbVar.g.setClickable(true);
                dbVar.f.setClickable(true);
                dbVar.f.setBackgroundDrawable(com.baidu.ufosdk.f.m.a(this.a.getApplicationContext(), "ufo_bottom_button.9.png", "ufo_bottom_button_pressed.9.png"));
                dbVar.g.setBackgroundDrawable(com.baidu.ufosdk.f.m.a(this.a.getApplicationContext(), "ufo_bottom_button.9.png", "ufo_bottom_button_pressed.9.png"));
            } else if (i2 == 2) {
                com.baidu.ufosdk.f.c.a(">>>>>>>已解决 ask=2");
                dbVar.e.setVisibility(0);
                dbVar.j.setVisibility(8);
                dbVar.g.setClickable(false);
                dbVar.f.setClickable(false);
                dbVar.h.setVisibility(8);
                dbVar.i.setVisibility(8);
                dbVar.f.setBackgroundDrawable(com.baidu.ufosdk.f.m.a(this.a.getApplicationContext(), "ufo_bottom_button_pressed.9.png", "ufo_bottom_button_pressed.9.png"));
                dbVar.g.setBackgroundDrawable(com.baidu.ufosdk.f.m.a(this.a.getApplicationContext(), "ufo_bottom_button.9.png", "ufo_bottom_button.9.png"));
            } else if (i2 == 3) {
                com.baidu.ufosdk.f.c.a(">>>>>>>未解决 ask=3");
                dbVar.e.setVisibility(0);
                dbVar.j.setVisibility(8);
                dbVar.f.setClickable(false);
                dbVar.g.setClickable(false);
                dbVar.h.setVisibility(8);
                dbVar.i.setVisibility(8);
                dbVar.g.setBackgroundDrawable(com.baidu.ufosdk.f.m.a(this.a.getApplicationContext(), "ufo_bottom_button_pressed.9.png", "ufo_bottom_button_pressed.9.png"));
                dbVar.f.setBackgroundDrawable(com.baidu.ufosdk.f.m.a(this.a.getApplicationContext(), "ufo_bottom_button.9.png", "ufo_bottom_button.9.png"));
            } else if (i2 == 9) {
                i3 = this.a.aG;
                if (i3 != 0) {
                    dbVar.j.setVisibility(0);
                }
                dbVar.e.setVisibility(8);
                dbVar.h.setVisibility(0);
                dbVar.i.setVisibility(0);
                dbVar.i.setBackgroundDrawable(new BitmapDrawable(com.baidu.ufosdk.f.m.a(this.a.getApplicationContext(), "ufo_not_solved.png")));
            } else if (i2 == 11) {
                dbVar.j.setVisibility(8);
                dbVar.e.setVisibility(8);
                dbVar.h.setVisibility(0);
                dbVar.i.setVisibility(0);
                dbVar.i.setBackgroundDrawable(new BitmapDrawable(com.baidu.ufosdk.f.m.a(this.a.getApplicationContext(), "ufo_solved.png")));
            }
            if (i2 == 3 || i2 == 9) {
                i4 = this.a.aG;
                if (i4 != 0) {
                    dbVar.j.setVisibility(0);
                    if (((Map) this.a.h.get(i)).containsKey("isClicked")) {
                        dbVar.j.setTextColor(com.baidu.ufosdk.f.i.a(2134669055, -15644211, 2134669055, 2134669055));
                        Drawable a6 = com.baidu.ufosdk.f.i.a(this.b, com.baidu.ufosdk.R.drawable.ufo_show_reason_pressed);
                        a6.setAlpha(127);
                        a6.setBounds(com.baidu.ufosdk.f.i.a(this.b, 1.0f), com.baidu.ufosdk.f.i.a(this.b, 1.0f), com.baidu.ufosdk.f.i.a(this.b, 14.0f), com.baidu.ufosdk.f.i.a(this.b, 14.0f));
                        dbVar.j.setCompoundDrawables(null, null, a6, null);
                    } else {
                        dbVar.j.setTextColor(com.baidu.ufosdk.f.i.a(-12814593, -15644211, -12814593, -12814593));
                        Drawable a7 = com.baidu.ufosdk.f.i.a(this.b, com.baidu.ufosdk.R.drawable.ufo_show_reason_normal);
                        a7.setBounds(com.baidu.ufosdk.f.i.a(this.b, 1.0f), com.baidu.ufosdk.f.i.a(this.b, 1.0f), com.baidu.ufosdk.f.i.a(this.b, 14.0f), com.baidu.ufosdk.f.i.a(this.b, 14.0f));
                        dbVar.j.setCompoundDrawables(null, null, a7, null);
                    }
                    String str4 = (String) ((Map) this.a.h.get(i)).get("discontent_reason");
                    JSONArray jSONArray = (JSONArray) ((Map) this.a.h.get(i)).get("discontent_labels");
                    if (TextUtils.isEmpty(str4) && (jSONArray == null || jSONArray.length() == 0)) {
                        dbVar.j.setText("填写不满意原因");
                    } else {
                        dbVar.j.setText("查看不满意原因");
                    }
                    dbVar.j.setOnClickListener(new cx(this, str4, jSONArray, i));
                }
            }
            if (i2 == 1) {
                dbVar.f.setOnClickListener(new ci(this, i));
                dbVar.g.setOnClickListener(new ck(this, i));
            } else {
                dbVar.f.setClickable(false);
                dbVar.f.setOnClickListener(null);
                dbVar.g.setClickable(false);
                dbVar.g.setOnClickListener(null);
            }
        } else if (i5 == 4) {
            czVar.d.setVisibility(0);
            if (i == 0) {
                czVar.a.setText(com.baidu.ufosdk.f.i.a(Long.parseLong((String) ((Map) this.a.h.get(i)).get("time"))));
            } else {
                long parseLong7 = Long.parseLong((String) ((Map) this.a.h.get(i - 1)).get("time"));
                long parseLong8 = Long.parseLong((String) ((Map) this.a.h.get(i)).get("time"));
                if (parseLong7 - parseLong8 > BdKVCache.MILLS_1Hour || parseLong8 - parseLong7 > BdKVCache.MILLS_1Hour) {
                    czVar.a.setText(com.baidu.ufosdk.f.i.c(parseLong8));
                    if (parseLong7 - parseLong8 > 86400000 || parseLong8 - parseLong7 > 86400000) {
                        czVar.a.setText(com.baidu.ufosdk.f.i.a(parseLong8));
                    }
                } else {
                    czVar.d.setVisibility(8);
                }
            }
            if (bitmap != null) {
                try {
                    czVar.b.setBackgroundDrawable(new BitmapDrawable(bitmap));
                } catch (Exception e19) {
                    e19.printStackTrace();
                }
            }
            if (((String) ((Map) this.a.h.get(i)).get("contenttype")).contentEquals("1") || ((Map) this.a.h.get(i)).get("content").toString().startsWith("http://bs.baidu.com") || ((Map) this.a.h.get(i)).get("content").toString().startsWith("https://bs.baidu.com")) {
                czVar.c.setImageBitmap(com.baidu.ufosdk.f.m.a(this.b, "ufo_pic_defult_icon.png"));
                com.baidu.ufosdk.f.a a8 = com.baidu.ufosdk.f.a.a();
                Context applicationContext3 = this.a.getApplicationContext();
                ImageView imageView10 = czVar.c;
                handler = this.a.aK;
                Bitmap a9 = a8.a(new com.baidu.ufosdk.f.n(applicationContext3, imageView10, handler), (String) ((Map) this.a.h.get(i)).get("content"));
                if (a9 != null) {
                    czVar.c.setImageBitmap(a9);
                    if (a9.getHeight() > a9.getWidth()) {
                        czVar.c.setMaxWidth(com.baidu.ufosdk.f.i.a(this.a.getApplicationContext(), 80.0f));
                        czVar.c.setMaxHeight(com.baidu.ufosdk.f.i.a(this.a.getApplicationContext(), 120.0f));
                    } else {
                        czVar.c.setMaxWidth(com.baidu.ufosdk.f.i.a(this.a.getApplicationContext(), 120.0f));
                        czVar.c.setMaxHeight(com.baidu.ufosdk.f.i.a(this.a.getApplicationContext(), 80.0f));
                    }
                }
            } else if (((String) ((Map) this.a.h.get(i)).get("contenttype")).contentEquals("2") && czVar.c != null) {
                Bitmap bitmap3 = (Bitmap) ((Map) this.a.h.get(i)).get("content");
                if (bitmap3.getHeight() > bitmap3.getWidth()) {
                    czVar.c.setMaxWidth(com.baidu.ufosdk.f.i.a(this.a.getApplicationContext(), 80.0f));
                    czVar.c.setMaxHeight(com.baidu.ufosdk.f.i.a(this.a.getApplicationContext(), 120.0f));
                } else {
                    czVar.c.setMaxWidth(com.baidu.ufosdk.f.i.a(this.a.getApplicationContext(), 120.0f));
                    czVar.c.setMaxHeight(com.baidu.ufosdk.f.i.a(this.a.getApplicationContext(), 80.0f));
                }
                czVar.c.setImageBitmap(bitmap3);
            }
        } else if (i5 == 5) {
            daVar.g.setVisibility(0);
            if (i == 0) {
                daVar.a.setText(com.baidu.ufosdk.f.i.a(Long.parseLong((String) ((Map) this.a.h.get(i)).get("time"))));
            } else {
                long parseLong9 = Long.parseLong((String) ((Map) this.a.h.get(i - 1)).get("time"));
                long parseLong10 = Long.parseLong((String) ((Map) this.a.h.get(i)).get("time"));
                if (parseLong9 - parseLong10 > BdKVCache.MILLS_1Hour || parseLong10 - parseLong9 > BdKVCache.MILLS_1Hour) {
                    daVar.a.setText(com.baidu.ufosdk.f.i.c(parseLong10));
                    if (parseLong9 - parseLong10 > 86400000 || parseLong10 - parseLong9 > 86400000) {
                        daVar.a.setText(com.baidu.ufosdk.f.i.a(parseLong10));
                    }
                } else {
                    daVar.g.setVisibility(8);
                }
            }
            if (bitmap != null) {
                try {
                    daVar.b.setBackgroundDrawable(new BitmapDrawable(bitmap));
                } catch (Exception e20) {
                    e20.printStackTrace();
                }
            }
            fd fdVar = new fd(this.a, (JSONArray) ((Map) this.a.h.get(i)).get("content"), ((Integer) ((Map) this.a.h.get(i)).get("subtype")).intValue(), this.a.H);
            if (((Integer) ((Map) this.a.h.get(i)).get("subtype")).intValue() == 1) {
                daVar.d.setText("请选择问题发生的场景");
                daVar.e.setVisibility(8);
            } else {
                try {
                    str = (String) ((Map) this.a.h.get(i)).get(AlaStaticKeys.ALA_STATIC_VALUE_TIP);
                } catch (Exception e21) {
                    str = "";
                }
                if (TextUtils.isEmpty(str)) {
                    str = "您是不是要问以下问题？";
                }
                daVar.d.setText(str);
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("没有想要的，进入人工反馈");
                spannableStringBuilder.setSpan(new ForegroundColorSpan(com.baidu.ufosdk.b.v), "没有想要的，进入人工反馈".length() - 4, "没有想要的，进入人工反馈".length(), 33);
                if (this.a.H) {
                    daVar.e.setText("没有想要的，进入人工反馈");
                } else {
                    daVar.e.setText(spannableStringBuilder);
                }
                daVar.e.setVisibility(0);
                daVar.e.setOnClickListener(new cm(this));
            }
            daVar.c.setAdapter((ListAdapter) fdVar);
            daVar.c.setOnItemClickListener(new co(this, i));
            FeedbackInputActivity.a(daVar.c);
        }
        return relativeLayout;
    }
}
