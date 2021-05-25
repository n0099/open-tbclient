package com.baidu.tieba.recapp.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.R$styleable;
import d.a.c.e.p.l;
import d.a.m0.r.q.c;
import d.a.n0.t2.i0.e;
import d.a.n0.t2.i0.g;
import d.a.n0.t2.y;
/* loaded from: classes5.dex */
public class AdAppInfoView extends FrameLayout {

    /* renamed from: e  reason: collision with root package name */
    public TextView f20236e;

    /* renamed from: f  reason: collision with root package name */
    public AdStarRatingBar f20237f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f20238g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f20239h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f20240i;
    public TextView j;
    public TextView k;
    public RelativeLayout l;
    public c m;
    public AdvertAppInfo n;
    public int o;
    public int p;
    public View.OnClickListener q;

    public AdAppInfoView(@NonNull Context context) {
        this(context, null);
    }

    private void setLayoutByAttrs(AttributeSet attributeSet) {
        if (attributeSet == null) {
            return;
        }
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.SimpleAdInfoView);
        this.o = obtainStyledAttributes.getResourceId(R$styleable.SimpleAdInfoView_layoutId, this.o);
        obtainStyledAttributes.recycle();
    }

    public void b(AttributeSet attributeSet) {
        setLayoutByAttrs(attributeSet);
        LayoutInflater.from(getContext()).inflate(getLayoutId(), this);
        this.f20236e = (TextView) findViewById(R.id.ad_name);
        this.f20237f = (AdStarRatingBar) findViewById(R.id.ad_rating);
        this.f20238g = (TextView) findViewById(R.id.ad_version);
        this.f20239h = (TextView) findViewById(R.id.ad_author_full_name);
        this.f20240i = (TextView) findViewById(R.id.ad_privacy);
        this.j = (TextView) findViewById(R.id.ad_permission);
        this.k = (TextView) findViewById(R.id.ad_tag);
        this.l = (RelativeLayout) findViewById(R.id.download_button_container);
        this.f20240i.setOnClickListener(this.q);
        this.j.setOnClickListener(this.q);
    }

    public final void c() {
        final ViewTreeObserver viewTreeObserver = this.f20239h.getViewTreeObserver();
        if (viewTreeObserver == null) {
            return;
        }
        viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.recapp.view.AdAppInfoView.2
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            @SuppressLint({"NewApi"})
            public void onGlobalLayout() {
                int lineCount;
                Layout layout = AdAppInfoView.this.f20239h.getLayout();
                if (layout != null && (lineCount = layout.getLineCount()) > 0 && layout.getEllipsisCount(lineCount - 1) > 0) {
                    AdAppInfoView adAppInfoView = AdAppInfoView.this;
                    adAppInfoView.f20239h.setOnClickListener(adAppInfoView.q);
                }
                if (viewTreeObserver.isAlive()) {
                    viewTreeObserver.removeOnGlobalLayoutListener(this);
                }
            }
        });
    }

    public final void d(String str) {
        if (this.n == null || TextUtils.isEmpty(str)) {
            return;
        }
        d.a.n0.t2.i0.c b2 = g.b(this.n, 102, 0);
        b2.c(str);
        e.b().d(b2);
    }

    public RelativeLayout getDownloadButtonContainer() {
        return this.l;
    }

    public int getLayoutId() {
        return this.o;
    }

    public void onChangeSkinType() {
        SkinManager.setViewTextColor(this.f20236e, R.color.CAM_X0107);
        SkinManager.setViewTextColor(this.f20238g, this.p);
        SkinManager.setViewTextColor(this.f20239h, this.p);
        SkinManager.setViewTextColor(this.f20240i, this.p);
        SkinManager.setViewTextColor(this.j, this.p);
        this.f20237f.onChangeSkinType();
    }

    public void setAd(AdvertAppInfo advertAppInfo) {
        this.n = advertAppInfo;
    }

    public void setAppInfo(c cVar) {
        if (cVar != null && c.c(cVar)) {
            this.m = cVar;
            if (this.f20236e != null) {
                if (!TextUtils.isEmpty(cVar.f49955b)) {
                    this.f20236e.setVisibility(0);
                    this.f20236e.setText(cVar.f49955b);
                } else {
                    this.f20236e.setVisibility(8);
                }
            }
            AdStarRatingBar adStarRatingBar = this.f20237f;
            if (adStarRatingBar != null) {
                float f2 = cVar.f49957d;
                if (f2 >= 0.0f && f2 <= 5.0f) {
                    adStarRatingBar.setVisibility(0);
                    this.f20237f.setRating(cVar.f49957d);
                } else {
                    this.f20237f.setVisibility(8);
                }
            }
            if (this.f20238g != null) {
                if (!TextUtils.isEmpty(cVar.f49958e)) {
                    this.f20238g.setVisibility(0);
                    this.f20238g.setText(cVar.f49958e);
                } else {
                    this.f20238g.setVisibility(8);
                }
            }
            if (this.f20239h != null) {
                if (!TextUtils.isEmpty(cVar.f49956c)) {
                    this.f20239h.setVisibility(0);
                    this.f20239h.setText(cVar.f49956c);
                    c();
                } else {
                    this.f20239h.setVisibility(8);
                }
            }
            if (this.f20240i != null) {
                c.b bVar = cVar.f49959f;
                if (bVar != null && !TextUtils.isEmpty(bVar.f49964b) && !TextUtils.isEmpty(cVar.f49959f.f49963a)) {
                    this.f20240i.setVisibility(0);
                    this.f20240i.setText(cVar.f49959f.f49963a);
                } else {
                    this.f20240i.setVisibility(8);
                }
            }
            if (this.f20240i != null) {
                c.a aVar = cVar.f49960g;
                if (aVar != null && !TextUtils.isEmpty(aVar.f49962b) && !TextUtils.isEmpty(cVar.f49960g.f49961a)) {
                    this.j.setVisibility(0);
                    this.j.setText(cVar.f49960g.f49961a);
                } else {
                    this.j.setVisibility(8);
                }
            }
            TextView textView = this.k;
            if (textView != null) {
                textView.setVisibility(0);
                return;
            }
            return;
        }
        this.m = null;
    }

    public void setTextColor(int i2) {
        this.p = i2;
        this.f20237f.setTextColor(i2);
    }

    public AdAppInfoView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AdAppInfoView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.o = R.layout.ad_app_info_view;
        this.p = R.color.CAM_X0109;
        this.q = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdAppInfoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                if (AdAppInfoView.this.m == null) {
                    return;
                }
                int id = view.getId();
                String str2 = "";
                if (id == R.id.ad_privacy) {
                    c.b bVar = AdAppInfoView.this.m.f49959f;
                    if (bVar != null) {
                        str2 = bVar.f49964b;
                        str = "app_privacy";
                    }
                    str = "";
                } else {
                    if (id == R.id.ad_permission) {
                        c.a aVar = AdAppInfoView.this.m.f49960g;
                        if (aVar != null) {
                            str2 = aVar.f49962b;
                            str = "app_permission";
                        }
                    } else if (id == R.id.ad_author_full_name) {
                        l.M(AdAppInfoView.this.getContext(), AdAppInfoView.this.m.f49956c);
                        return;
                    }
                    str = "";
                }
                y.d(AdAppInfoView.this.getContext(), str2, null, null);
                AdAppInfoView.this.d(str);
            }
        };
        b(attributeSet);
    }
}
