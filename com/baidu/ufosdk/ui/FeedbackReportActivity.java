package com.baidu.ufosdk.ui;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.statistic.StatisticConstants;
import com.baidu.browser.sailor.feature.upload.BdUploadHandler;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.searchbox.account.contants.LoginConstants;
import com.baidu.searchbox.fluency.tracer.FpsTracer;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.tts.jni.TtsLogLoad;
import com.baidu.ufosdk.FeedbackManager;
import com.baidu.ufosdk.IFeedbackMethodCallback;
import com.baidu.ufosdk.a1;
import com.baidu.ufosdk.d0;
import com.baidu.ufosdk.e0;
import com.baidu.ufosdk.e1;
import com.baidu.ufosdk.g0;
import com.baidu.ufosdk.h0;
import com.baidu.ufosdk.i0;
import com.baidu.ufosdk.j1;
import com.baidu.ufosdk.p1;
import com.baidu.ufosdk.q1;
import com.baidu.ufosdk.s1;
import com.baidu.ufosdk.t1;
import com.baidu.ufosdk.z0;
import com.yy.hiidostatis.defs.obj.ParamableElem;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.eventtype.PayUVEventType;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
@SuppressLint({"SetJavaScriptEnabled"})
@TargetApi(11)
/* loaded from: classes9.dex */
public class FeedbackReportActivity extends Activity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public boolean B;
    public boolean C;
    public boolean D;
    public JSONArray E;
    public Dialog F;
    public IFeedbackMethodCallback G;
    @SuppressLint({"HandlerLeak"})
    public Handler H;
    public ScrollView I;
    public String J;
    public LinearLayout K;
    public TextView L;
    public String M;
    public int N;
    public String O;
    public String P;
    public String Q;
    public String R;
    public h0 S;

    /* renamed from: T  reason: collision with root package name */
    public byte[] f1193T;
    public e0 U;
    public SharedPreferences.Editor a;
    public SharedPreferences b;
    public int c;
    public String d;
    public boolean e;
    public EditText f;
    public RelativeLayout g;
    public ImageView h;
    public Button i;
    public TextView j;
    public LinearLayout k;
    public int l;
    public boolean m;
    public boolean n;
    public TextView o;
    public TextView p;
    public TextView q;
    public RelativeLayout r;
    public EditText s;
    public EditText t;
    public TextView u;
    public LinearLayout v;
    public List<byte[]> w;
    public Boolean x;
    public String y;
    public View z;

    public final void c() {
        SpannableString spannableString;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            LinearLayout linearLayout = new LinearLayout(this);
            this.K = linearLayout;
            linearLayout.setId(2030632967);
            this.K.setOrientation(1);
            this.K.setBackgroundColor(this.e ? -15329770 : -1);
            TextView textView = new TextView(this);
            this.L = textView;
            textView.setBackgroundColor(this.e ? -15329770 : -1);
            this.L.setTextColor(this.e ? -11711155 : -16777216);
            SpannableString spannableString2 = new SpannableString("举报内容问题*");
            spannableString2.setSpan(new ForegroundColorSpan(-1293499), 6, 7, 34);
            this.L.setText(spannableString2);
            this.L.setTextSize(16.0f);
            this.L.setGravity(16);
            this.L.setPadding(p1.a(getApplicationContext(), 15.0f), p1.a(getApplicationContext(), 0.0f), 0, 0);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, p1.a(getApplicationContext(), 41.0f));
            layoutParams.setMargins(0, p1.a(getApplicationContext(), 7.0f), 0, 0);
            this.K.addView(this.L, layoutParams);
            LinearLayout linearLayout2 = new LinearLayout(this);
            linearLayout2.setOrientation(0);
            linearLayout2.setBackgroundDrawable(null);
            ArrayList arrayList = new ArrayList();
            arrayList.add("违法");
            arrayList.add("谣言");
            arrayList.add("色情");
            arrayList.add("恐怖恶心");
            arrayList.add("广告");
            arrayList.add("题文不符");
            arrayList.add("新闻过期");
            arrayList.add("抄袭");
            arrayList.add("其他");
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add("播放问题");
            arrayList2.add("标题内容不符");
            arrayList2.add("广告");
            arrayList2.add("低俗色情");
            arrayList2.add("疑似抄袭");
            arrayList2.add("过期旧闻");
            arrayList2.add("虚假谣言");
            arrayList2.add("违法反动");
            arrayList2.add("其他");
            ArrayList arrayList3 = new ArrayList();
            arrayList3.add("违法违规");
            arrayList3.add("低俗色情");
            arrayList3.add("政治敏感");
            arrayList3.add("广告侵权");
            arrayList3.add("夸大宣传");
            arrayList3.add("题文不符");
            arrayList3.add("虚假欺诈");
            arrayList3.add("体验不好");
            arrayList3.add("其他");
            ArrayList arrayList4 = new ArrayList();
            arrayList4.add("播放问题");
            arrayList4.add("低俗色情");
            arrayList4.add("令人不适");
            arrayList4.add("骗点击");
            arrayList4.add("侮辱谩骂");
            arrayList4.add("疑似抄袭");
            arrayList4.add("广告");
            arrayList4.add("违法反动");
            arrayList4.add("其他");
            ArrayList arrayList5 = new ArrayList();
            arrayList5.add("色情");
            arrayList5.add("违法犯罪");
            arrayList5.add("欺诈");
            arrayList5.add("骚扰");
            arrayList5.add("虚假信息");
            arrayList5.add("侵权");
            arrayList5.add("类目不符");
            arrayList5.add("其他");
            ArrayList arrayList6 = new ArrayList();
            arrayList6.add("与搜索词无关");
            arrayList6.add("标题内容不符");
            arrayList6.add("内容质量差");
            arrayList6.add("播放问题");
            arrayList6.add("广告问题");
            arrayList6.add("低俗色情");
            arrayList6.add("视频侵权");
            arrayList6.add("其他问题");
            ArrayList arrayList7 = new ArrayList();
            arrayList7.add("谣言");
            arrayList7.add("低俗色情");
            arrayList7.add("恐怖恶心");
            arrayList7.add("广告");
            arrayList7.add("题文不符");
            arrayList7.add("新闻过期");
            arrayList7.add("违法反动");
            arrayList7.add("加载速度慢");
            arrayList7.add("其他");
            ArrayList arrayList8 = new ArrayList();
            arrayList8.add("播放问题");
            arrayList8.add("题文不符");
            arrayList8.add("广告");
            arrayList8.add("恐怖恶心");
            arrayList8.add("低俗色情");
            arrayList8.add("新闻过期");
            arrayList8.add("谣言");
            arrayList8.add("违法反动");
            arrayList8.add("其他");
            ArrayList arrayList9 = new ArrayList();
            arrayList9.add("题文不符");
            arrayList9.add("恐怖恶心");
            arrayList9.add("广告");
            arrayList9.add("低俗色情");
            arrayList9.add("违法反动");
            arrayList9.add("加载速度慢");
            arrayList9.add("死链");
            arrayList9.add("其他");
            ArrayList arrayList10 = new ArrayList();
            arrayList10.add("内容质量差");
            arrayList10.add("标题与视频不符");
            arrayList10.add("低俗色情");
            arrayList10.add("封面令人反感");
            arrayList10.add("播放问题");
            arrayList10.add("广告营销");
            arrayList10.add("违法反动");
            arrayList10.add("其他");
            ArrayList arrayList11 = new ArrayList();
            arrayList11.add("内容质量差");
            arrayList11.add("过期旧闻");
            arrayList11.add("低俗色情");
            arrayList11.add("广告与营销");
            arrayList11.add("恶意抄袭");
            arrayList11.add("错别字多");
            arrayList11.add("违法犯罪");
            arrayList11.add("其他");
            ArrayList arrayList12 = new ArrayList();
            arrayList12.add("与搜索词无关");
            arrayList12.add("标题内容不符");
            arrayList12.add("内容质量差");
            arrayList12.add("播放问题");
            arrayList12.add("广告问题");
            arrayList12.add("低俗色情");
            arrayList12.add("视频侵权");
            arrayList12.add("其他内容");
            ArrayList arrayList13 = new ArrayList();
            arrayList13.add("播放问题");
            arrayList13.add("封面内容不符");
            arrayList13.add("明显广告");
            arrayList13.add("视频涉黄涉反");
            arrayList13.add("疑似抄袭");
            arrayList13.add("视频与搜索词无关");
            ArrayList arrayList14 = new ArrayList();
            arrayList14.add("垃圾广告内容");
            arrayList14.add("违规违法内容");
            arrayList14.add("淫秽色情信息");
            arrayList14.add("不友善内容");
            arrayList14.add("内容不专业");
            arrayList14.add("涉嫌侵权");
            arrayList14.add("其他");
            ArrayList arrayList15 = new ArrayList();
            arrayList15.add("淫秽色情");
            arrayList15.add("政治有害");
            arrayList15.add("违法违禁品");
            arrayList15.add("血腥暴力");
            arrayList15.add("其他违规内容");
            ArrayList arrayList16 = new ArrayList();
            arrayList16.add("播放问题");
            arrayList16.add("标题内容不符");
            arrayList16.add("广告");
            arrayList16.add("低俗色情");
            arrayList16.add("疑似抄袭");
            arrayList16.add("过期旧闻");
            arrayList16.add("虚假谣言");
            arrayList16.add("违法反动");
            ArrayList arrayList17 = new ArrayList();
            arrayList17.add(arrayList);
            arrayList17.add(arrayList2);
            arrayList17.add(arrayList3);
            arrayList17.add(arrayList4);
            arrayList17.add(arrayList5);
            arrayList17.add(arrayList6);
            arrayList17.add(arrayList7);
            arrayList17.add(arrayList8);
            arrayList17.add(arrayList9);
            arrayList17.add(arrayList10);
            arrayList17.add(arrayList11);
            arrayList17.add(arrayList12);
            arrayList17.add(arrayList13);
            arrayList17.add(arrayList14);
            arrayList17.add(arrayList15);
            arrayList17.add(arrayList16);
            d dVar = new d(this);
            int i = this.c;
            if (i == 32600 || i == 33490 || i == 33101) {
                this.S = new h0((ArrayList) arrayList17.get(1), this, dVar, Boolean.valueOf(this.e));
            } else if (i == 32601) {
                this.S = new h0((ArrayList) arrayList17.get(2), this, dVar, Boolean.valueOf(this.e));
            } else if (i == 33086 || i == 33491) {
                this.S = new h0((ArrayList) arrayList17.get(3), this, dVar, Boolean.valueOf(this.e));
            } else if (i == 33212) {
                this.S = new h0((ArrayList) arrayList17.get(4), this, dVar, Boolean.valueOf(this.e));
            } else if (i == 33394) {
                this.S = new h0((ArrayList) arrayList17.get(5), this, dVar, Boolean.valueOf(this.e));
            } else if (i == 33398) {
                this.S = new h0((ArrayList) arrayList17.get(6), this, dVar, Boolean.valueOf(this.e));
            } else if (i == 33397) {
                this.S = new h0((ArrayList) arrayList17.get(7), this, dVar, Boolean.valueOf(this.e));
            } else if (i == 33396) {
                this.S = new h0((ArrayList) arrayList17.get(8), this, dVar, Boolean.valueOf(this.e));
            } else if (i == 33362 || i == 33492 || i == 33895) {
                this.S = new h0((ArrayList) arrayList17.get(9), this, dVar, Boolean.valueOf(this.e));
            } else if (i == 33361 || i == 33493 || i == 33894) {
                this.S = new h0((ArrayList) arrayList17.get(10), this, dVar, Boolean.valueOf(this.e));
            } else if (i == 33823) {
                this.S = new h0((ArrayList) arrayList17.get(11), this, dVar, Boolean.valueOf(this.e));
            } else if (this.D) {
                this.S = new h0((ArrayList) arrayList17.get(12), this, dVar, Boolean.valueOf(this.e));
            } else if (i == 33712 || i == 33711 || i == 33710) {
                this.S = new h0((ArrayList) arrayList17.get(13), this, dVar, Boolean.valueOf(this.e));
            } else if (i == 33717) {
                this.S = new h0((ArrayList) arrayList17.get(14), this, dVar, Boolean.valueOf(this.e));
            } else if (i == 33131) {
                this.S = new h0((ArrayList) arrayList17.get(15), this, dVar, Boolean.valueOf(this.e));
            } else {
                this.S = new h0((ArrayList) arrayList17.get(0), this, dVar, Boolean.valueOf(this.e));
            }
            h0 h0Var = this.S;
            if (h0Var != null) {
                LinearLayout linearLayout3 = new LinearLayout(h0Var.c);
                linearLayout3.setOrientation(1);
                linearLayout3.setBackgroundColor(h0Var.f ? -15132391 : -1);
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -1);
                layoutParams2.setMargins(p1.a(h0Var.c, 15.0f), p1.a(h0Var.c, 0.0f), p1.a(h0Var.c, 15.0f), p1.a(h0Var.c, 14.0f));
                int size = h0Var.a.size();
                if (h0Var.h && q1.a()) {
                    size = h0Var.a.size() - 1;
                }
                for (int i2 = 0; i2 < size; i2++) {
                    CustomCheckBox customCheckBox = new CustomCheckBox(h0Var.c, h0Var.f);
                    customCheckBox.setTextColor(h0Var.f ? -10066330 : -13421773);
                    customCheckBox.setText(h0Var.a.get(i2));
                    customCheckBox.setTextSize(14.0f);
                    linearLayout3.addView(customCheckBox, layoutParams2);
                    customCheckBox.setOnClickListener(new g0(h0Var, customCheckBox));
                }
                View a2 = this.S.a();
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
                layoutParams3.weight = 1.0f;
                linearLayout2.addView(linearLayout3, layoutParams3);
                linearLayout2.addView(a2, layoutParams3);
                LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -2);
                layoutParams4.setMargins(0, p1.a(getApplicationContext(), 6.0f), 0, p1.a(getApplicationContext(), 2.0f));
                this.K.addView(linearLayout2, layoutParams4);
                if (this.S.h && q1.a()) {
                    LinearLayout a3 = this.S.a("侵权(侵犯名誉、肖像、隐私权等)");
                    LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams5.setMargins(p1.a((Context) this, 15.0f), 0, 0, p1.a(getApplicationContext(), 5.0f));
                    this.K.addView(a3, layoutParams5);
                }
                RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams6.addRule(10);
                this.r.addView(this.K, layoutParams6);
                LinearLayout linearLayout4 = new LinearLayout(this);
                this.k = linearLayout4;
                linearLayout4.setVisibility(8);
                this.k.setId(2030632978);
                this.k.setOrientation(1);
                this.k.setBackgroundColor(this.e ? -15329770 : -1);
                TextView textView2 = new TextView(this);
                textView2.setBackgroundColor(this.e ? -15329770 : -1);
                textView2.setTextColor(this.e ? -11711155 : -16777216);
                if (TextUtils.equals("com.baidu.haokan", com.baidu.ufosdk.c.a())) {
                    spannableString = new SpannableString(this.D ? "原创作品链接*" : "原创视频链接*");
                } else {
                    spannableString = new SpannableString("原创文章链接*");
                }
                spannableString.setSpan(new ForegroundColorSpan(-1293499), 6, 7, 34);
                textView2.setText(spannableString);
                textView2.setPadding(p1.a(getApplicationContext(), 14.0f), p1.a(getApplicationContext(), 2.0f), 0, 0);
                textView2.setTextSize(16.0f);
                textView2.setGravity(16);
                this.k.addView(textView2, new LinearLayout.LayoutParams(-1, p1.a(getApplicationContext(), 41.0f)));
                float a4 = p1.a((Context) this, 3.0f);
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setColor(this.e ? -15132391 : -1);
                gradientDrawable.setCornerRadius(a4);
                gradientDrawable.setStroke(3, this.e ? -14540254 : -3355444);
                EditText editText = new EditText(this);
                this.f = editText;
                editText.setBackgroundDrawable(gradientDrawable);
                this.f.setTextColor(this.e ? -10066330 : -13421773);
                this.f.setTextSize(15.0f);
                this.f.setGravity(16);
                this.f.setSingleLine();
                this.f.setPadding(p1.a(getApplicationContext(), 11.0f), p1.a(getApplicationContext(), 5.0f), p1.a(getApplicationContext(), 11.0f), p1.a(getApplicationContext(), 5.0f));
                LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(-1, p1.a(getApplicationContext(), 41.0f));
                layoutParams7.setMargins(p1.a(getApplicationContext(), 15.0f), 0, p1.a(getApplicationContext(), 15.0f), 0);
                this.k.addView(this.f, layoutParams7);
                RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams8.addRule(3, this.K.getId());
                this.r.setPadding(0, 0, 0, p1.a(getApplicationContext(), 30.0f));
                this.r.addView(this.k, layoutParams8);
                LinearLayout linearLayout5 = new LinearLayout(this);
                linearLayout5.setId(2030632976);
                linearLayout5.setOrientation(1);
                linearLayout5.setBackgroundColor(this.e ? -15329770 : -1);
                TextView textView3 = new TextView(this);
                this.o = textView3;
                textView3.setText("上传问题截图");
                this.o.setBackgroundColor(this.e ? -15329770 : -1);
                this.o.setTextColor(this.e ? -11711155 : -16777216);
                this.o.setTextSize(16.0f);
                this.o.setGravity(16);
                this.o.setPadding(p1.a(getApplicationContext(), 15.0f), 0, 0, 0);
                linearLayout5.addView(this.o, new LinearLayout.LayoutParams(-1, p1.a(getApplicationContext(), 41.0f)));
                LinearLayout linearLayout6 = new LinearLayout(this);
                this.v = linearLayout6;
                linearLayout6.setOrientation(0);
                this.v.setPadding(p1.a(getApplicationContext(), 8.0f), p1.a(getApplicationContext(), 0.0f), 0, p1.a(getApplicationContext(), 0.0f));
                LinearLayout.LayoutParams layoutParams9 = new LinearLayout.LayoutParams(p1.a(getApplicationContext(), 350.0f), p1.a(getApplicationContext(), 77.0f));
                this.w.add(p1.a(this, this.e));
                d();
                linearLayout5.addView(this.v, layoutParams9);
                RelativeLayout.LayoutParams layoutParams10 = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams10.addRule(3, this.k.getId());
                this.r.addView(linearLayout5, layoutParams10);
                LinearLayout linearLayout7 = new LinearLayout(this);
                linearLayout7.setId(2030632968);
                linearLayout7.setOrientation(1);
                linearLayout7.setBackgroundColor(this.e ? -15329770 : -1);
                TextView textView4 = new TextView(this);
                this.p = textView4;
                textView4.setBackgroundColor(this.e ? -15329770 : -1);
                this.p.setTextColor(this.e ? -11711155 : -16777216);
                this.p.setText("更多问题及建议");
                this.p.setPadding(p1.a(getApplicationContext(), 15.0f), p1.a(getApplicationContext(), 0.0f), 0, 0);
                this.p.setTextSize(16.0f);
                this.p.setGravity(16);
                LinearLayout.LayoutParams layoutParams11 = new LinearLayout.LayoutParams(-1, p1.a(getApplicationContext(), 41.0f));
                layoutParams11.setMargins(0, p1.a(getApplicationContext(), 16.0f), 0, 0);
                linearLayout7.addView(this.p, layoutParams11);
                RelativeLayout relativeLayout = new RelativeLayout(this);
                float a5 = p1.a((Context) this, 3.0f);
                GradientDrawable gradientDrawable2 = new GradientDrawable();
                gradientDrawable2.setColor(this.e ? -15132391 : -1);
                gradientDrawable2.setCornerRadius(a5);
                gradientDrawable2.setStroke(3, this.e ? -14540254 : -3355444);
                relativeLayout.setBackgroundDrawable(gradientDrawable2);
                EditText editText2 = new EditText(this);
                this.s = editText2;
                editText2.setId(2030632969);
                this.s.setBackgroundColor(this.e ? -15132391 : -1);
                this.s.setTextColor(this.e ? -10066330 : -13421773);
                this.s.setTextSize(14.0f);
                if (this.m) {
                    this.s.setHint("请描述广告问题，我们会尽快处理");
                } else if (this.n) {
                    this.s.setHint("请描述问题或建议，侵权请指明涉嫌侵权的小程序哪些内容侵犯了您的合法权益");
                } else {
                    this.s.setHint("请描述问题或建议，抄袭请附链接和截图");
                }
                this.s.setHintTextColor(this.e ? -11711155 : -6710887);
                this.s.setGravity(3);
                this.s.setPadding(p1.a(getApplicationContext(), 10.0f), p1.a(getApplicationContext(), 5.0f), p1.a(getApplicationContext(), 10.0f), p1.a(getApplicationContext(), 5.0f));
                RelativeLayout.LayoutParams layoutParams12 = new RelativeLayout.LayoutParams(-1, p1.a(getApplicationContext(), 62.0f));
                layoutParams12.setMargins(p1.a((Context) this, 2.0f), p1.a((Context) this, 3.0f), p1.a((Context) this, 2.0f), p1.a((Context) this, 3.0f));
                relativeLayout.addView(this.s, layoutParams12);
                TextView textView5 = new TextView(this);
                this.u = textView5;
                textView5.setBackgroundColor(this.e ? -15132391 : -1);
                this.u.setTextSize(11.0f);
                this.u.setTextColor(this.e ? -11711155 : -5131855);
                this.u.setText("4-200字");
                RelativeLayout.LayoutParams layoutParams13 = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams13.addRule(3, this.s.getId());
                layoutParams13.addRule(11);
                this.u.setPadding(0, 0, p1.a(getApplicationContext(), 7.0f), 0);
                relativeLayout.setPadding(0, 0, p1.a(getApplicationContext(), 1.0f), p1.a(getApplicationContext(), 7.0f));
                relativeLayout.addView(this.u, layoutParams13);
                LinearLayout.LayoutParams layoutParams14 = new LinearLayout.LayoutParams(-1, -2);
                layoutParams14.setMargins(p1.a(getApplicationContext(), 15.0f), 0, p1.a(getApplicationContext(), 15.0f), 0);
                linearLayout7.addView(relativeLayout, layoutParams14);
                RelativeLayout.LayoutParams layoutParams15 = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams15.addRule(3, linearLayout5.getId());
                this.r.addView(linearLayout7, layoutParams15);
                LinearLayout linearLayout8 = new LinearLayout(this);
                linearLayout8.setId(2030632977);
                linearLayout8.setOrientation(1);
                linearLayout8.setBackgroundColor(this.e ? -15329770 : -1);
                TextView textView6 = new TextView(this);
                this.q = textView6;
                textView6.setBackgroundColor(this.e ? -15329770 : -1);
                this.q.setTextColor(this.e ? -11711155 : -16777216);
                this.q.setText("联系方式");
                this.q.setPadding(p1.a(getApplicationContext(), 15.0f), p1.a(getApplicationContext(), 2.0f), 0, 0);
                this.q.setTextSize(16.0f);
                this.q.setGravity(16);
                LinearLayout.LayoutParams layoutParams16 = new LinearLayout.LayoutParams(-1, p1.a(getApplicationContext(), 41.0f));
                layoutParams16.setMargins(0, p1.a(getApplicationContext(), 17.0f), 0, 0);
                linearLayout8.addView(this.q, layoutParams16);
                float a6 = p1.a((Context) this, 3.0f);
                GradientDrawable gradientDrawable3 = new GradientDrawable();
                gradientDrawable3.setColor(this.e ? -15132391 : -1);
                gradientDrawable3.setCornerRadius(a6);
                gradientDrawable3.setStroke(3, this.e ? -14540254 : -3355444);
                EditText editText3 = new EditText(this);
                this.t = editText3;
                editText3.setBackgroundDrawable(gradientDrawable3);
                this.t.setTextColor(this.e ? -10066330 : -13421773);
                this.t.setTextSize(14.0f);
                this.t.setGravity(16);
                this.t.setHint("请留下您的邮箱/手机/QQ号");
                this.t.setHintTextColor(this.e ? -11711155 : -6710887);
                this.t.setSingleLine();
                this.t.setPadding(p1.a(getApplicationContext(), 11.0f), p1.a(getApplicationContext(), 5.0f), p1.a(getApplicationContext(), 11.0f), p1.a(getApplicationContext(), 5.0f));
                LinearLayout.LayoutParams layoutParams17 = new LinearLayout.LayoutParams(-1, p1.a(getApplicationContext(), 40.0f));
                layoutParams17.setMargins(p1.a(getApplicationContext(), 13.0f), 0, p1.a(getApplicationContext(), 13.0f), 0);
                linearLayout8.addView(this.t, layoutParams17);
                RelativeLayout.LayoutParams layoutParams18 = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams18.addRule(3, linearLayout7.getId());
                this.r.setPadding(0, 0, 0, p1.a(getApplicationContext(), 30.0f));
                this.r.addView(linearLayout8, layoutParams18);
                this.s.addTextChangedListener(new e(this));
                this.t.addTextChangedListener(new f(this));
                return;
            }
            throw null;
        }
    }

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FeedbackReportActivity a;

        public a(FeedbackReportActivity feedbackReportActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {feedbackReportActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = feedbackReportActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                FeedbackReportActivity feedbackReportActivity = this.a;
                if (feedbackReportActivity.A) {
                    return;
                }
                feedbackReportActivity.w.remove(((Integer) view2.getTag()).intValue());
                if (this.a.w.size() == 1) {
                    byte[] a = p1.a(this.a.getApplicationContext(), this.a.e);
                    if (a == null) {
                        return;
                    }
                    this.a.w.set(0, a);
                }
                this.a.d();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FeedbackReportActivity a;

        public b(FeedbackReportActivity feedbackReportActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {feedbackReportActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = feedbackReportActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                FeedbackReportActivity feedbackReportActivity = this.a;
                if (feedbackReportActivity.A) {
                    return;
                }
                feedbackReportActivity.N = ((Integer) view2.getTag()).intValue();
                if (p1.a() >= 23) {
                    FeedbackReportActivity.a(this.a);
                } else {
                    FeedbackReportActivity.a(this.a);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FeedbackReportActivity a;

        public c(FeedbackReportActivity feedbackReportActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {feedbackReportActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = feedbackReportActivity;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                super.handleMessage(message);
                int i2 = message.what;
                if (i2 != 12) {
                    if (i2 != 13) {
                        if (i2 != 14) {
                            if (i2 == 15) {
                                try {
                                    ((InputMethodManager) this.a.s.getContext().getSystemService("input_method")).showSoftInput(this.a.s, 0);
                                    return;
                                } catch (Exception unused) {
                                    return;
                                }
                            } else if (i2 == 16) {
                                if (this.a.getCurrentFocus() != null && this.a.getCurrentFocus().getWindowToken() != null) {
                                    ((InputMethodManager) this.a.getSystemService("input_method")).hideSoftInputFromWindow(this.a.getCurrentFocus().getWindowToken(), 2);
                                    return;
                                }
                                return;
                            } else if (i2 != 17) {
                                return;
                            } else {
                                this.a.A = false;
                                this.a.z.setVisibility(8);
                                return;
                            }
                        }
                        this.a.A = false;
                        FeedbackReportActivity feedbackReportActivity = this.a;
                        feedbackReportActivity.v.removeAllViews();
                        ArrayList arrayList = new ArrayList();
                        feedbackReportActivity.w = arrayList;
                        arrayList.add(p1.a(feedbackReportActivity, feedbackReportActivity.e));
                        feedbackReportActivity.d();
                        FeedbackReportActivity feedbackReportActivity2 = this.a;
                        if (!feedbackReportActivity2.B) {
                            feedbackReportActivity2.x = Boolean.FALSE;
                            if (!TextUtils.isEmpty(feedbackReportActivity2.y) && TextUtils.isEmpty(this.a.d)) {
                                FeedbackReportActivity feedbackReportActivity3 = this.a;
                                feedbackReportActivity3.a.putString(feedbackReportActivity3.y, "");
                            }
                            if (!TextUtils.isEmpty(this.a.d)) {
                                FeedbackReportActivity feedbackReportActivity4 = this.a;
                                feedbackReportActivity4.a.putString(feedbackReportActivity4.d, "");
                            }
                            this.a.a.commit();
                            this.a.z.setVisibility(8);
                            if (this.a.G != null) {
                                JSONObject jSONObject = new JSONObject();
                                try {
                                    jSONObject.put("result", "success");
                                    jSONObject.put("reasonOne", this.a.E.toString());
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                                this.a.G.onMessageSubmit(jSONObject.toString());
                            }
                            this.a.finish();
                            return;
                        }
                        feedbackReportActivity2.B = false;
                        return;
                    }
                    this.a.A = false;
                    this.a.z.setVisibility(8);
                    FeedbackReportActivity feedbackReportActivity5 = this.a;
                    Button button = feedbackReportActivity5.i;
                    if (feedbackReportActivity5.e) {
                        i = -15387825;
                    } else {
                        i = -12814593;
                    }
                    button.setTextColor(i);
                    if (this.a.G != null) {
                        JSONObject jSONObject2 = new JSONObject();
                        try {
                            jSONObject2.put("result", "fail");
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                        this.a.G.onMessageSubmit(jSONObject2.toString());
                    }
                    this.a.finish();
                    return;
                }
                this.a.A = false;
                FeedbackReportActivity feedbackReportActivity6 = this.a;
                feedbackReportActivity6.v.removeAllViews();
                ArrayList arrayList2 = new ArrayList();
                feedbackReportActivity6.w = arrayList2;
                arrayList2.add(p1.a(feedbackReportActivity6, feedbackReportActivity6.e));
                feedbackReportActivity6.d();
                FeedbackReportActivity feedbackReportActivity7 = this.a;
                if (!feedbackReportActivity7.B) {
                    feedbackReportActivity7.x = Boolean.FALSE;
                    if (!TextUtils.isEmpty(feedbackReportActivity7.y) && TextUtils.isEmpty(this.a.d)) {
                        FeedbackReportActivity feedbackReportActivity8 = this.a;
                        feedbackReportActivity8.a.putString(feedbackReportActivity8.y, "");
                    }
                    if (!TextUtils.isEmpty(this.a.d)) {
                        FeedbackReportActivity feedbackReportActivity9 = this.a;
                        feedbackReportActivity9.a.putString(feedbackReportActivity9.d, "");
                    }
                    this.a.a.commit();
                    this.a.z.setVisibility(8);
                    this.a.finish();
                    return;
                }
                feedbackReportActivity7.B = false;
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d implements i0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FeedbackReportActivity a;

        public d(FeedbackReportActivity feedbackReportActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {feedbackReportActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = feedbackReportActivity;
        }

        /* JADX WARN: Removed duplicated region for block: B:64:0x01fc  */
        /* JADX WARN: Removed duplicated region for block: B:65:0x0204  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void a(ArrayList<String> arrayList, int i) {
            int i2;
            float f;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, arrayList, i) == null) {
                String str = "CheckGroup回调函数：selectedData.size() = " + arrayList.size();
                String str2 = "CheckGroup是否选中抄袭 : " + i;
                FeedbackReportActivity feedbackReportActivity = this.a;
                feedbackReportActivity.l = i;
                if (i == 1) {
                    SpannableString spannableString = new SpannableString("上传问题截图*(请上传该文章在其他平台带发布时间的截图)");
                    spannableString.setSpan(new ForegroundColorSpan(-1293499), 6, 7, 34);
                    spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#999999")), 7, spannableString.length(), 34);
                    spannableString.setSpan(new AbsoluteSizeSpan(12, true), 7, spannableString.length(), 34);
                    this.a.o.setText(spannableString);
                } else if (feedbackReportActivity.m && i == 2) {
                    feedbackReportActivity.o.setText("上传截图");
                } else {
                    FeedbackReportActivity feedbackReportActivity2 = this.a;
                    if (feedbackReportActivity2.n && feedbackReportActivity2.l == 5) {
                        SpannableString spannableString2 = new SpannableString("上传问题截图*(若您认为您的商标权、名誉权、肖像权、著作权等被人侵犯，请上传您的身份证明、权属证明，以及问题截图)");
                        spannableString2.setSpan(new ForegroundColorSpan(-1293499), 6, 7, 34);
                        spannableString2.setSpan(new ForegroundColorSpan(Color.parseColor("#999999")), 7, spannableString2.length(), 34);
                        spannableString2.setSpan(new AbsoluteSizeSpan(12, true), 7, spannableString2.length(), 34);
                        this.a.o.setText(spannableString2);
                    } else {
                        FeedbackReportActivity feedbackReportActivity3 = this.a;
                        if (feedbackReportActivity3.n && feedbackReportActivity3.l == 4) {
                            SpannableString spannableString3 = new SpannableString("上传问题截图*");
                            spannableString3.setSpan(new ForegroundColorSpan(-1293499), 6, 7, 34);
                            spannableString3.setSpan(new ForegroundColorSpan(Color.parseColor("#999999")), 7, spannableString3.length(), 34);
                            spannableString3.setSpan(new AbsoluteSizeSpan(12, true), 7, spannableString3.length(), 34);
                            this.a.o.setText(spannableString3);
                        } else {
                            FeedbackReportActivity feedbackReportActivity4 = this.a;
                            if (feedbackReportActivity4.l == 1001) {
                                Dialog dialog = feedbackReportActivity4.F;
                                if (dialog != null) {
                                    dialog.show();
                                }
                            } else {
                                feedbackReportActivity4.o.setText("上传问题截图");
                            }
                        }
                    }
                }
                FeedbackReportActivity feedbackReportActivity5 = this.a;
                LinearLayout linearLayout = feedbackReportActivity5.k;
                if (feedbackReportActivity5.l == 1) {
                    i2 = 0;
                } else {
                    i2 = 8;
                }
                linearLayout.setVisibility(i2);
                FeedbackReportActivity feedbackReportActivity6 = this.a;
                if (feedbackReportActivity6.m) {
                    int i3 = feedbackReportActivity6.l;
                    if (i3 != 2 && i3 != 3) {
                        feedbackReportActivity6.p.setText("更多问题及建议");
                    } else {
                        SpannableString spannableString4 = new SpannableString("更多问题及建议*");
                        spannableString4.setSpan(new ForegroundColorSpan(-1293499), 7, 8, 34);
                        this.a.p.setText(spannableString4);
                    }
                } else {
                    feedbackReportActivity6.p.setText("更多问题及建议");
                }
                FeedbackReportActivity feedbackReportActivity7 = this.a;
                if (feedbackReportActivity7.m) {
                    int i4 = feedbackReportActivity7.l;
                    if (i4 == 2) {
                        feedbackReportActivity7.s.setHint("为保障您的合法权益，请详细描述问题并留下您的联系方式，我们会尽快联系您。若您遭受经济损失，也可以联系我们：保障平台：baozhang.baidu.com；邮箱：bzjh@baidu.com；服务热线：400-921-9999");
                        this.a.s.setTextSize(10.0f);
                    } else if (i4 == 3) {
                        feedbackReportActivity7.s.setHint("为保护您的合法权益，违法违规、广告侵权、体验不好等举报，请详细描述问题，我们会尽快处理");
                        this.a.s.setTextSize(14.0f);
                    } else {
                        feedbackReportActivity7.s.setHint("请描述广告问题，我们会尽快处理");
                        this.a.s.setTextSize(14.0f);
                    }
                } else if (feedbackReportActivity7.n) {
                    feedbackReportActivity7.s.setHint("请描述问题或建议，侵权请指明涉嫌侵权的小程序哪些内容侵犯了您的合法权益");
                    this.a.s.setTextSize(14.0f);
                } else {
                    feedbackReportActivity7.s.setHint("请描述问题或建议，抄袭请附链接和截图");
                    this.a.s.setTextSize(14.0f);
                }
                FeedbackReportActivity feedbackReportActivity8 = this.a;
                if (!feedbackReportActivity8.m || feedbackReportActivity8.l != 2) {
                    FeedbackReportActivity feedbackReportActivity9 = this.a;
                    if (!feedbackReportActivity9.n || feedbackReportActivity9.l != 5) {
                        this.a.q.setText("联系方式");
                        if (arrayList.size() <= 0) {
                            this.a.i.setAlpha(1.0f);
                            return;
                        } else if (this.a.s.getText().toString().trim().length() >= 4) {
                            this.a.i.setAlpha(1.0f);
                            return;
                        } else {
                            FeedbackReportActivity feedbackReportActivity10 = this.a;
                            Button button = feedbackReportActivity10.i;
                            if (feedbackReportActivity10.e) {
                                f = 0.5f;
                            } else {
                                f = 0.3f;
                            }
                            button.setAlpha(f);
                            return;
                        }
                    }
                }
                SpannableString spannableString5 = new SpannableString("联系方式*");
                spannableString5.setSpan(new ForegroundColorSpan(-1293499), 4, 5, 34);
                this.a.q.setText(spannableString5);
                if (arrayList.size() <= 0) {
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class e implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public final /* synthetic */ FeedbackReportActivity b;

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i, i2, i3) == null) {
            }
        }

        public e(FeedbackReportActivity feedbackReportActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {feedbackReportActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = feedbackReportActivity;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                this.b.s.setTextSize(14.0f);
                int length = this.b.s.getText().toString().trim().length();
                if (editable.length() <= 4) {
                    TextView textView = this.b.u;
                    textView.setText("4-200字");
                } else {
                    TextView textView2 = this.b.u;
                    textView2.setText(String.valueOf(editable.length()) + "-200字");
                }
                if (length > 200) {
                    this.b.u.setTextColor(-568497);
                    this.b.C = true;
                } else {
                    this.b.u.setTextColor(-5131855);
                    this.b.C = false;
                }
                int i = this.a;
                float f = 0.5f;
                if (i != 0) {
                    if (i == 1 && this.b.s.getText().toString().trim().length() < 4) {
                        if (this.b.S.d.size() > 0) {
                            this.b.i.setAlpha(1.0f);
                            return;
                        }
                        FeedbackReportActivity feedbackReportActivity = this.b;
                        Button button = feedbackReportActivity.i;
                        if (!feedbackReportActivity.e) {
                            f = 0.3f;
                        }
                        button.setAlpha(f);
                    }
                } else if (this.b.s.getText().toString().trim().length() >= 4) {
                    this.b.i.setAlpha(1.0f);
                } else if (this.b.S.d.size() > 0) {
                    this.b.i.setAlpha(1.0f);
                } else {
                    FeedbackReportActivity feedbackReportActivity2 = this.b;
                    Button button2 = feedbackReportActivity2.i;
                    if (!feedbackReportActivity2.e) {
                        f = 0.3f;
                    }
                    button2.setAlpha(f);
                }
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i, i2, i3) == null) {
                if (this.b.s.getText().toString().trim().length() < 4) {
                    this.a = 0;
                } else {
                    this.a = 1;
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class f implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FeedbackReportActivity a;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i, i2, i3) == null) {
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i, i2, i3) == null) {
            }
        }

        public f(FeedbackReportActivity feedbackReportActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {feedbackReportActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = feedbackReportActivity;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            EditText editText;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, editable) != null) || (editText = this.a.t) == null) {
                return;
            }
            if (editText.getText().toString().trim().length() > 30) {
                FeedbackReportActivity feedbackReportActivity = this.a;
                feedbackReportActivity.t.setText(feedbackReportActivity.J);
                Toast.makeText(this.a, t1.a(PayUVEventType.PAY_SPLIT_ORDER_CLOSE_BTN_CLICK), 1).show();
                FeedbackReportActivity feedbackReportActivity2 = this.a;
                feedbackReportActivity2.t.setSelection(feedbackReportActivity2.J.length());
            }
            FeedbackReportActivity feedbackReportActivity3 = this.a;
            feedbackReportActivity3.J = feedbackReportActivity3.t.getText().toString();
        }
    }

    /* loaded from: classes9.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FeedbackReportActivity a;

        public g(FeedbackReportActivity feedbackReportActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {feedbackReportActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = feedbackReportActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.U.a();
                if (TextUtils.isEmpty(this.a.U.b)) {
                    this.a.H.obtainMessage(4, null).sendToTarget();
                } else {
                    this.a.H.obtainMessage(1, null).sendToTarget();
                }
                Context applicationContext = this.a.getApplicationContext();
                String str = this.a.U.a;
                String g = com.baidu.ufosdk.b.g(applicationContext);
                if (g != null) {
                    this.a.H.obtainMessage(0, g).sendToTarget();
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FeedbackReportActivity a;

        public h(FeedbackReportActivity feedbackReportActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {feedbackReportActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = feedbackReportActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Context applicationContext = this.a.getApplicationContext();
                String str = this.a.U.a;
                String g = com.baidu.ufosdk.b.g(applicationContext);
                if (g != null) {
                    this.a.H.obtainMessage(0, g).sendToTarget();
                }
            }
        }
    }

    public FeedbackReportActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = 0;
        this.d = "";
        this.e = false;
        this.l = 0;
        this.m = false;
        this.n = false;
        this.x = Boolean.TRUE;
        this.A = false;
        this.B = false;
        this.D = false;
        this.E = new JSONArray();
        this.H = new c(this);
        this.M = "举报/反馈";
        this.N = -1;
        this.O = "";
        this.P = "";
        this.Q = "menu";
        this.R = "";
    }

    public final String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            ArrayList<String> arrayList = this.S.d;
            String str = "";
            for (int i = 0; i < arrayList.size(); i++) {
                if (i == arrayList.size() - 1) {
                    str = str + arrayList.get(i);
                } else {
                    str = str + arrayList.get(i) + ParamableElem.DIVIDE_PARAM;
                }
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    public static Bitmap a(Bitmap bitmap, int i) {
        InterceptResult invokeLI;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, bitmap, i)) == null) {
            if (bitmap == null || i <= 0) {
                return null;
            }
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            if (width > i && height > i) {
                int max = (Math.max(width, height) * i) / Math.min(width, height);
                if (width > height) {
                    i2 = max;
                } else {
                    i2 = i;
                }
                if (width > height) {
                    max = i;
                }
                try {
                    Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, i2, max, true);
                    Bitmap createBitmap = Bitmap.createBitmap(createScaledBitmap, (i2 - i) / 2, (max - i) / 2, i, i);
                    createScaledBitmap.recycle();
                    return createBitmap;
                } catch (Exception unused) {
                    return null;
                }
            }
            return bitmap;
        }
        return (Bitmap) invokeLI.objValue;
    }

    public static void a(FeedbackReportActivity feedbackReportActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, feedbackReportActivity) == null) {
            if (feedbackReportActivity != null) {
                if (!com.baidu.ufosdk.b.n()) {
                    Intent intent = new Intent("android.intent.action.GET_CONTENT");
                    intent.addCategory("android.intent.category.OPENABLE");
                    intent.setType(BdUploadHandler.IMAGE_MIME_TYPE);
                    if (feedbackReportActivity.N == feedbackReportActivity.w.size() - 1) {
                        if (feedbackReportActivity.getCurrentFocus() != null && feedbackReportActivity.getCurrentFocus().getWindowToken() != null) {
                            ((InputMethodManager) feedbackReportActivity.getSystemService("input_method")).hideSoftInputFromWindow(feedbackReportActivity.getCurrentFocus().getWindowToken(), 2);
                        }
                        try {
                            feedbackReportActivity.startActivityForResult(intent, feedbackReportActivity.N);
                            try {
                                feedbackReportActivity.overridePendingTransition(p1.a(feedbackReportActivity.getApplicationContext(), "ufo_slide_in_from_bottom"), 0);
                                return;
                            } catch (Exception unused) {
                                return;
                            }
                        } catch (ActivityNotFoundException unused2) {
                            Toast.makeText(feedbackReportActivity, t1.a("0"), 1).show();
                            return;
                        }
                    }
                    return;
                }
                return;
            }
            throw null;
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, keyEvent)) == null) {
            if (i == 4) {
                try {
                    this.B = true;
                    a();
                    return true;
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            return super.onKeyDown(i, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    public final void a() {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.z.getVisibility() == 0) {
                this.z.setVisibility(8);
                Button button = this.i;
                if (this.e) {
                    i = -15387825;
                } else {
                    i = -12814593;
                }
                button.setTextColor(i);
                this.A = false;
                return;
            }
            finish();
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (this.f != null) {
                this.f = null;
            }
            if (this.s != null) {
                this.s = null;
            }
            if (this.t != null) {
                this.t = null;
            }
            IFeedbackMethodCallback iFeedbackMethodCallback = this.G;
            if (iFeedbackMethodCallback != null) {
                iFeedbackMethodCallback.onDestory();
                FeedbackManager.getInstance(this).setFeedbackCallback(null);
                this.G = null;
            }
            super.onDestroy();
        }
    }

    public boolean a(Context context, String str, String str2, String str3, String str4, String str5, Handler handler) {
        InterceptResult invokeCommon;
        char c2;
        String str6;
        String a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{context, str, str2, str3, str4, str5, handler})) == null) {
            ArrayList<String> arrayList = this.S.d;
            for (int i = 0; i < arrayList.size(); i++) {
                this.E.put(arrayList.get(i));
            }
            String str7 = s1.f;
            String str8 = "url is " + str7;
            HashMap hashMap = new HashMap();
            hashMap.put("clientid", str);
            String str9 = this.R;
            if (str9 != null && str9.length() > 0) {
                hashMap.put("appid", this.R);
            } else if (q1.a()) {
                hashMap.put("appid", "215939");
            } else {
                hashMap.put("appid", this.U.b);
            }
            hashMap.put("devid", this.U.c);
            hashMap.put("id", str2);
            if (p1.a(str4)) {
                c2 = 1;
            } else if (p1.b(str4)) {
                c2 = 2;
            } else if (p1.c(str4)) {
                c2 = 3;
            } else {
                c2 = 0;
            }
            String str10 = "contactWay is " + str4;
            if (c2 == 0) {
                hashMap.put("contact_way", str4);
            } else if (c2 == 1) {
                hashMap.put("email", str4);
            } else if (c2 == 2) {
                hashMap.put("tel", str4);
            } else if (c2 == 3) {
                hashMap.put(LoginConstants.QQ_LOGIN, str4);
            } else {
                hashMap.put("contact_way", str4);
            }
            hashMap.put("brand", "");
            hashMap.put("model", "");
            hashMap.put("sdkvn", "4.1.9.1");
            hashMap.put(TtsLogLoad.KEY_OS, "android");
            hashMap.put("appvn", com.baidu.ufosdk.c.b());
            hashMap.put("uid", com.baidu.ufosdk.b.c());
            hashMap.put(DpStatConstants.KEY_USER_ID, com.baidu.ufosdk.b.c());
            hashMap.put("username", com.baidu.ufosdk.b.b());
            hashMap.put("osvn", "");
            try {
                JSONObject jSONObject = new JSONObject(com.baidu.ufosdk.b.g());
                if (!TextUtils.isEmpty(this.f.getText())) {
                    jSONObject.put("extend_url", this.f.getText().toString());
                    String jSONObject2 = jSONObject.toString();
                    com.baidu.ufosdk.b.a();
                    com.baidu.ufosdk.b.d.setExtraData(jSONObject2);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            hashMap.put("extra", com.baidu.ufosdk.b.g());
            hashMap.put("extend_feedback_channel", Integer.valueOf(this.c));
            hashMap.put("resource_id", this.O);
            hashMap.put("daily_type", "24961");
            if (this.Q.equals("menu")) {
                str6 = "框架";
            } else {
                str6 = "落地页";
            }
            hashMap.put("third_source", str6);
            hashMap.put("content", "[举报]" + b() + "/" + str3);
            hashMap.put("extend_keyword", b());
            StringBuilder sb = new StringBuilder();
            sb.append("举报问题选择：");
            sb.append(b());
            sb.toString();
            if (q1.a() && TextUtils.isEmpty(this.P)) {
                hashMap.put("remark", "百家号");
            } else if (!TextUtils.isEmpty(this.P)) {
                hashMap.put("remark", this.P);
            }
            hashMap.put("baiducuid", com.baidu.ufosdk.b.f());
            if (!TextUtils.isEmpty(this.d)) {
                hashMap.put("faq_id", this.d);
            }
            hashMap.put("phonetime", String.valueOf(System.currentTimeMillis()));
            hashMap.put(FpsTracer.UBC_KEY_NET_TYPE, p1.b(context));
            hashMap.put("screenSize", com.baidu.ufosdk.b.h(context));
            hashMap.put("ip_location", com.baidu.ufosdk.b.k());
            String b2 = com.baidu.ufosdk.b.b(com.baidu.ufosdk.b.a(hashMap));
            try {
                HashMap hashMap2 = new HashMap();
                hashMap2.put("sdk_encrypt", b2);
                if (!TextUtils.isEmpty(str5)) {
                    hashMap2.put(StatisticConstants.SCREENSHOT, str5);
                }
                a2 = d0.a(str7, d0.a(hashMap2));
            } catch (Exception unused) {
                com.baidu.ufosdk.b.a(t1.a("18"), 1);
                handler.obtainMessage(13).sendToTarget();
            }
            if (!TextUtils.isEmpty(a2)) {
                JSONObject jSONObject3 = new JSONObject(com.baidu.ufosdk.b.a(a2));
                String str11 = "response is -----------------> " + jSONObject3.toString();
                int intValue = ((Integer) jSONObject3.get("errno")).intValue();
                if (intValue == 0) {
                    com.baidu.ufosdk.b.a(context, System.currentTimeMillis());
                    if (str2.contains("newMessage")) {
                        handler.obtainMessage(14, String.valueOf(jSONObject3.get("id"))).sendToTarget();
                    } else {
                        handler.obtainMessage(12).sendToTarget();
                    }
                    com.baidu.ufosdk.b.a((Context) this, 0, true, "");
                } else if (intValue == 4) {
                    String str12 = (String) jSONObject3.get("errmsg");
                    com.baidu.ufosdk.b.a(str12, 1);
                    handler.obtainMessage(17, str12).sendToTarget();
                }
                return true;
            }
            com.baidu.ufosdk.b.a(t1.a("18"), 1);
            this.A = false;
            com.baidu.ufosdk.b.a((Context) this, 1, false, "");
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public final void d() {
        LinearLayout linearLayout;
        Bitmap bitmap;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048580, this) != null) || (linearLayout = this.v) == null) {
            return;
        }
        linearLayout.removeAllViews();
        for (int i = 0; i < this.w.size(); i++) {
            RelativeLayout relativeLayout = new RelativeLayout(this);
            if (i != this.w.size() - 1) {
                e1 e1Var = new e1(this);
                e1Var.setTag(Integer.valueOf(i));
                e1Var.setBackgroundDrawable(null);
                e1Var.setPadding(0, 0, 0, 0);
                e1Var.setScaleType(ImageView.ScaleType.CENTER_CROP);
                e1Var.setMaxHeight(p1.a(getApplicationContext(), 77.0f));
                e1Var.setMinimumHeight(p1.a(getApplicationContext(), 77.0f));
                e1Var.setMaxWidth(p1.a(getApplicationContext(), 77.0f));
                e1Var.setMinimumWidth(p1.a(getApplicationContext(), 77.0f));
                relativeLayout.addView(e1Var, new RelativeLayout.LayoutParams(p1.a(getApplicationContext(), 77.0f), p1.a(getApplicationContext(), 77.0f)));
                try {
                    if (this.w.get(i) != null) {
                        bitmap = BitmapFactory.decodeByteArray(this.w.get(i), 0, this.w.get(i).length);
                        if (bitmap == null) {
                            return;
                        }
                    } else {
                        bitmap = null;
                    }
                    if (bitmap != null && a(bitmap, p1.a(getApplicationContext(), 45.0f)) != null) {
                        e1Var.setImageBitmap(bitmap);
                        ImageButton imageButton = new ImageButton(this);
                        imageButton.setTag(Integer.valueOf(i));
                        imageButton.setBackgroundDrawable(null);
                        imageButton.setPadding(p1.a(getApplicationContext(), 2.0f), p1.a(getApplicationContext(), 0.0f), p1.a(getApplicationContext(), 0.0f), p1.a(getApplicationContext(), 2.0f));
                        imageButton.setScaleType(ImageView.ScaleType.FIT_XY);
                        Bitmap b2 = p1.b(getApplicationContext(), "ufo_delete_little_icon.png");
                        if (b2 == null) {
                            return;
                        }
                        imageButton.setImageBitmap(b2);
                        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(p1.a(getApplicationContext(), 19.0f), p1.a(getApplicationContext(), 19.0f));
                        layoutParams.addRule(11);
                        layoutParams.addRule(10);
                        layoutParams.setMargins(0, 0, 0, 0);
                        relativeLayout.addView(imageButton, layoutParams);
                        imageButton.setOnClickListener(new a(this));
                    } else {
                        return;
                    }
                } catch (OutOfMemoryError unused) {
                    System.gc();
                    return;
                }
            } else {
                ImageView imageView = new ImageView(this);
                imageView.setTag(Integer.valueOf(i));
                imageView.setBackgroundDrawable(null);
                imageView.setPadding(0, 0, 0, 0);
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                imageView.setMaxHeight(p1.a(getApplicationContext(), 77.0f));
                imageView.setMinimumHeight(p1.a(getApplicationContext(), 77.0f));
                imageView.setMaxWidth(p1.a(getApplicationContext(), 77.0f));
                imageView.setMinimumWidth(p1.a(getApplicationContext(), 77.0f));
                relativeLayout.addView(imageView, new RelativeLayout.LayoutParams(p1.a(getApplicationContext(), 77.0f), p1.a(getApplicationContext(), 77.0f)));
                try {
                    Bitmap decodeByteArray = BitmapFactory.decodeByteArray(this.w.get(i), 0, this.w.get(i).length);
                    if (decodeByteArray != null && a(decodeByteArray, p1.a(getApplicationContext(), 45.0f)) != null) {
                        imageView.setImageBitmap(decodeByteArray);
                        imageView.setOnClickListener(new b(this));
                    } else {
                        return;
                    }
                } catch (OutOfMemoryError unused2) {
                    System.gc();
                    return;
                }
            }
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(p1.a(getApplicationContext(), 77.0f), p1.a(getApplicationContext(), 77.0f));
            layoutParams2.setMargins(p1.a(getApplicationContext(), 7.0f), 0, 0, 0);
            layoutParams2.gravity = 80;
            this.v.addView(relativeLayout, layoutParams2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:65:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0126  */
    @Override // android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onActivityResult(int i, int i2, Intent intent) {
        Uri uri;
        byte[] bArr;
        InputStream openInputStream;
        byte[] bArr2;
        Exception e2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048581, this, i, i2, intent) == null) {
            String str = " --*^o^*-- requestCode = " + i + "; resultCode = " + i2;
            if (i2 != -1 || intent == null) {
                return;
            }
            byte[] bArr3 = null;
            try {
                uri = intent.getData();
            } catch (Exception unused) {
                uri = null;
            }
            if (uri == null) {
                return;
            }
            try {
                openInputStream = getContentResolver().openInputStream(uri);
                try {
                } catch (Exception e3) {
                    bArr2 = null;
                    e2 = e3;
                }
            } catch (Exception e4) {
                e = e4;
            }
            if (openInputStream.available() < 3145728) {
                byte[] bArr4 = new byte[1024];
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                while (true) {
                    int read = openInputStream.read(bArr4);
                    i3 = 0;
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr4, 0, read);
                }
                bArr2 = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                openInputStream.close();
                try {
                } catch (Exception e5) {
                    e2 = e5;
                    byte[] bArr5 = bArr2;
                    e = e2;
                    bArr3 = bArr5;
                    System.out.println(e.getMessage());
                    bArr = bArr3;
                    if (i != this.w.size() - 1) {
                    }
                    d();
                    return;
                }
                if (bArr2 == null) {
                    Toast.makeText(this, t1.a("21"), 1).show();
                    return;
                }
                try {
                    Cursor query = getContentResolver().query(uri, null, null, null, null);
                    if (query != null) {
                        query.moveToFirst();
                        String string = query.getString(query.getColumnIndex("orientation"));
                        if (string != null) {
                            i3 = Integer.parseInt(string);
                        }
                        query.close();
                    }
                } catch (Exception unused2) {
                }
                bArr = com.baidu.ufosdk.b.a(bArr2, i3);
                if (bArr == null) {
                    Toast.makeText(this, t1.a("21"), 1).show();
                    return;
                } else if (bArr.length > 1048576) {
                    Toast.makeText(this, t1.a("21"), 1).show();
                    return;
                } else if (bArr.length == 0) {
                    Toast.makeText(this, "图片错误，请重新选择一张。", 1).show();
                    return;
                } else {
                    if (p1.d(this) < 35000) {
                        Toast.makeText(this, "内存不足，图片读取失败，请尝试清理内存稍后再试.", 1).show();
                        System.gc();
                        return;
                    }
                    if (i != this.w.size() - 1) {
                        if (bArr != null && bArr.length != 0) {
                            this.w.set(i, bArr);
                            this.w.add(p1.a(this, this.e));
                        } else {
                            Toast.makeText(this, "图片错误，请重新选择一张。", 1).show();
                        }
                    } else {
                        Toast.makeText(this, "内存不足，图片读取失败，请尝试清理内存稍后再试.", 1).show();
                        this.w.clear();
                        this.w.add(p1.a(this, this.e));
                    }
                    d();
                    return;
                }
            }
            Toast.makeText(this, t1.a("21"), 1).show();
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        boolean z;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        float f2;
        int i6;
        int i7;
        int i8;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bundle) == null) {
            super.onCreate(bundle);
            requestWindowFeature(1);
            setRequestedOrientation(1);
            if (com.baidu.ufosdk.b.m() == 1) {
                z = true;
            } else {
                z = false;
            }
            this.e = z;
            getWindow().setSoftInputMode(32);
            if (Build.VERSION.SDK_INT >= 21 && !this.e) {
                Window window = getWindow();
                window.addFlags(Integer.MIN_VALUE);
                window.getDecorView().setSystemUiVisibility(1280);
                if (Build.VERSION.SDK_INT >= 23) {
                    window.getDecorView().setSystemUiVisibility(8192);
                }
                window.getDecorView().setBackgroundColor(-1);
                window.setStatusBarColor(0);
            }
            this.b = getSharedPreferences("UfoSharePreference", 0);
            this.U = e0.a(this);
            this.G = FeedbackManager.getInstance(this).getFeedbackCallback();
            String string = this.b.getString("cryptContactData", "");
            if (string != null && string.trim().length() > 0) {
                this.J = com.baidu.ufosdk.b.a(string);
            } else {
                this.J = "";
            }
            this.a = this.b.edit();
            this.d = getIntent().getStringExtra("faq_id");
            this.y = getIntent().getStringExtra("msgid");
            getIntent().getIntExtra("product_type", -1);
            this.f1193T = getIntent().getByteArrayExtra("shot");
            if (TextUtils.isEmpty(this.y)) {
                this.y = "newMessage";
            }
            if (TextUtils.isEmpty(this.d)) {
                this.d = "";
            }
            this.a.putBoolean("ADD_PIC_FLAG", true);
            this.a.commit();
            int intExtra = getIntent().getIntExtra("feedback_channel", 0);
            this.c = intExtra;
            if (intExtra == 32601) {
                this.m = true;
            } else if (intExtra == 33212) {
                this.n = true;
            } else if (intExtra == 33487 || intExtra == 33496 || intExtra == 33497 || intExtra == 33506 || intExtra == 33509) {
                this.D = true;
            }
            String stringExtra = getIntent().getStringExtra("nid");
            if (stringExtra != null) {
                this.O = stringExtra;
            }
            this.P = getIntent().getStringExtra("tpl");
            String stringExtra2 = getIntent().getStringExtra("entrance");
            if (stringExtra2 != null) {
                this.Q = stringExtra2;
            }
            String stringExtra3 = getIntent().getStringExtra("appid");
            if (stringExtra3 != null) {
                this.R = stringExtra3;
            }
            this.I = new ScrollView(this);
            RelativeLayout relativeLayout = new RelativeLayout(this);
            this.g = relativeLayout;
            relativeLayout.setId(2030567428);
            RelativeLayout relativeLayout2 = new RelativeLayout(this);
            relativeLayout2.setId(2030632963);
            RelativeLayout relativeLayout3 = this.g;
            if (this.e) {
                i = -15329770;
            } else {
                i = -1;
            }
            relativeLayout3.setBackgroundColor(i);
            new RelativeLayout.LayoutParams(-1, -1);
            new LinearLayout.LayoutParams(-2, -2);
            LinearLayout linearLayout = new LinearLayout(this);
            linearLayout.setId(2030632962);
            if (this.e) {
                i2 = -15132391;
            } else {
                i2 = -1;
            }
            linearLayout.setBackgroundColor(i2);
            linearLayout.setOrientation(0);
            linearLayout.setGravity(16);
            LinearLayout linearLayout2 = new LinearLayout(this);
            linearLayout2.setGravity(16);
            linearLayout2.setOrientation(0);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(p1.a(getApplicationContext(), 19.0f), p1.a(getApplicationContext(), 19.0f));
            layoutParams.setMargins(p1.a(getApplicationContext(), 10.0f), 0, p1.a(getApplicationContext(), 10.0f), 0);
            ImageView imageView = new ImageView(this);
            this.h = imageView;
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.h.setBackgroundDrawable(new BitmapDrawable(p1.b(getApplicationContext(), "ufo_back_icon_browser.png")));
            linearLayout2.addView(this.h, layoutParams);
            if (com.baidu.ufosdk.b.e() == 0) {
                layoutParams = new LinearLayout.LayoutParams(p1.a(getApplicationContext(), 35.0f), -1);
                layoutParams.setMargins(p1.a(getApplicationContext(), 10.0f), 0, 0, 0);
                linearLayout.addView(linearLayout2, layoutParams);
            }
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, p1.a(getApplicationContext(), 42.0f));
            layoutParams2.addRule(12);
            this.g.addView(linearLayout, layoutParams2);
            View view2 = new View(this);
            view2.setId(126910482);
            if (this.e) {
                i3 = -14540254;
            } else {
                i3 = -1644826;
            }
            view2.setBackgroundColor(i3);
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, p1.a(getApplicationContext(), 0.5f));
            layoutParams3.addRule(2, linearLayout.getId());
            this.g.addView(view2, layoutParams3);
            TextView textView = new TextView(this);
            this.j = textView;
            textView.setId(2030567426);
            this.j.setText(this.M);
            TextView textView2 = this.j;
            if (this.e) {
                i4 = -10066330;
            } else {
                i4 = -16777216;
            }
            textView2.setTextColor(i4);
            this.j.setTextSize(16.0f);
            this.j.setTypeface(Typeface.defaultFromStyle(1));
            this.j.setGravity(17);
            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -1);
            layoutParams4.addRule(13);
            relativeLayout2.addView(this.j, layoutParams4);
            if (com.baidu.ufosdk.b.e() == 1) {
                RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, -1);
                layoutParams5.addRule(9);
                layoutParams5.addRule(15);
                layoutParams.setMargins(p1.a(getApplicationContext(), 10.0f), 0, 0, 0);
                relativeLayout2.addView(linearLayout2, layoutParams5);
                view2.setVisibility(8);
                linearLayout.setVisibility(8);
            }
            this.i = new Button(this);
            if (getIntent().getIntExtra("continue", 0) == 1) {
                this.i.setVisibility(4);
            }
            this.i.setText("提交");
            this.i.setId(2030632966);
            Button button = this.i;
            if (this.e) {
                i5 = -15387825;
            } else {
                i5 = -12814593;
            }
            button.setTextColor(i5);
            Button button2 = this.i;
            if (this.e) {
                f2 = 0.5f;
            } else {
                f2 = 0.3f;
            }
            button2.setAlpha(f2);
            this.i.setTextSize(14.0f);
            this.i.setGravity(17);
            this.i.setBackgroundColor(16777215);
            this.i.setPadding(p1.a(getApplicationContext(), 10.0f), 0, p1.a(getApplicationContext(), 10.0f), 0);
            RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams6.addRule(11);
            layoutParams6.addRule(15);
            relativeLayout2.addView(this.i, layoutParams6);
            if (this.e) {
                i6 = -15132391;
            } else {
                i6 = -1;
            }
            relativeLayout2.setBackgroundColor(i6);
            RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-1, p1.a(getApplicationContext(), 38.0f));
            layoutParams7.addRule(10);
            this.g.addView(relativeLayout2, layoutParams7);
            new LinearLayout.LayoutParams(-1, -1).weight = 1.0f;
            View view3 = new View(this);
            view3.setId(126910480);
            if (this.e) {
                i7 = -14540254;
            } else {
                i7 = -1644826;
            }
            view3.setBackgroundColor(i7);
            RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(-1, p1.a(getApplicationContext(), 0.5f));
            layoutParams8.addRule(3, relativeLayout2.getId());
            this.g.addView(view3, layoutParams8);
            RelativeLayout relativeLayout4 = new RelativeLayout(this);
            this.r = relativeLayout4;
            relativeLayout4.setId(2030567429);
            RelativeLayout relativeLayout5 = this.r;
            if (this.e) {
                i8 = -15329770;
            } else {
                i8 = -1;
            }
            relativeLayout5.setBackgroundColor(i8);
            RelativeLayout.LayoutParams layoutParams9 = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams9.addRule(3, view3.getId());
            layoutParams9.addRule(2, view2.getId());
            this.I.addView(this.r);
            this.g.addView(this.I, layoutParams9);
            this.z = p1.c(this, t1.a("25"));
            RelativeLayout.LayoutParams layoutParams10 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams10.addRule(13);
            this.r.addView(this.z, layoutParams10);
            this.z.setVisibility(8);
            this.h.setOnClickListener(new z0(this));
            this.i.setOnClickListener(new a1(this));
            this.F = new j1(this, this.e);
            ArrayList arrayList = new ArrayList();
            this.w = arrayList;
            byte[] bArr = this.f1193T;
            if (bArr != null && bArr.length > 0) {
                arrayList.add(bArr);
            }
            c();
            setContentView(this.g);
        }
    }

    @Override // android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onPause();
            String obj = this.t.getText().toString();
            if (obj != null && obj.trim().length() > 0) {
                this.a.putString("cryptContactData", com.baidu.ufosdk.b.b(obj));
            } else {
                this.a.putString("cryptContactData", "");
            }
            if (this.x.booleanValue()) {
                if (!TextUtils.isEmpty(this.d)) {
                    this.a.putString(this.d, this.s.getText().toString());
                } else {
                    this.a.putString(this.y, this.s.getText().toString());
                }
            }
            this.a.commit();
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onResume();
            if (this.m) {
                int i = this.l;
                if (i == 2) {
                    this.s.setHint("为保障您的合法权益，请详细描述问题并留下您的联系方式，我们会尽快联系您。若您遭受经济损失，也可以联系我们：保障平台：baozhang.baidu.com；邮箱：bzjh@baidu.com；服务热线：400-921-9999");
                    this.s.setTextSize(10.0f);
                } else if (i == 3) {
                    this.s.setHint("为保护您的合法权益，违法违规、广告侵权、体验不好等举报，请详细描述问题，我们会尽快处理");
                    this.s.setTextSize(14.0f);
                } else {
                    this.s.setHint("请描述广告问题，我们会尽快处理");
                    this.s.setTextSize(14.0f);
                }
            } else if (this.n) {
                this.s.setHint("请描述问题或建议，侵权请指明涉嫌侵权的小程序哪些内容侵犯了您的合法权益");
                this.s.setTextSize(14.0f);
            } else {
                this.s.setHint("请描述问题或建议，抄袭请附链接和截图");
                this.s.setTextSize(14.0f);
            }
            p1.a((RelativeLayout) this.z, t1.a("25"));
            this.i.setTextSize(14.0f);
            this.x = Boolean.TRUE;
            String str = this.y;
            if (str == null) {
                this.y = "newMessage";
            } else if (str.length() == 0) {
                this.y = "newMessage";
            }
            String string = this.b.getString("cryptContactData", "");
            if (string != null && string.trim().length() > 0) {
                this.t.setText(com.baidu.ufosdk.b.a(string));
            } else {
                this.t.setText("");
            }
            if (TextUtils.isEmpty(this.U.b)) {
                new Thread(new g(this)).start();
            } else {
                new Thread(new h(this)).start();
            }
        }
    }
}
