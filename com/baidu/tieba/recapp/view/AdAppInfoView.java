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
import d.a.n0.r.q.c;
import d.a.o0.t2.i0.e;
import d.a.o0.t2.i0.g;
import d.a.o0.t2.y;
/* loaded from: classes5.dex */
public class AdAppInfoView extends FrameLayout {

    /* renamed from: e  reason: collision with root package name */
    public TextView f20395e;

    /* renamed from: f  reason: collision with root package name */
    public AdStarRatingBar f20396f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f20397g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f20398h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f20399i;
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
        this.f20395e = (TextView) findViewById(R.id.ad_name);
        this.f20396f = (AdStarRatingBar) findViewById(R.id.ad_rating);
        this.f20397g = (TextView) findViewById(R.id.ad_version);
        this.f20398h = (TextView) findViewById(R.id.ad_author_full_name);
        this.f20399i = (TextView) findViewById(R.id.ad_privacy);
        this.j = (TextView) findViewById(R.id.ad_permission);
        this.k = (TextView) findViewById(R.id.ad_tag);
        this.l = (RelativeLayout) findViewById(R.id.download_button_container);
        this.f20399i.setOnClickListener(this.q);
        this.j.setOnClickListener(this.q);
    }

    public final void c() {
        final ViewTreeObserver viewTreeObserver = this.f20398h.getViewTreeObserver();
        if (viewTreeObserver == null) {
            return;
        }
        viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.recapp.view.AdAppInfoView.2
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            @SuppressLint({"NewApi"})
            public void onGlobalLayout() {
                int lineCount;
                Layout layout = AdAppInfoView.this.f20398h.getLayout();
                if (layout != null && (lineCount = layout.getLineCount()) > 0 && layout.getEllipsisCount(lineCount - 1) > 0) {
                    AdAppInfoView adAppInfoView = AdAppInfoView.this;
                    adAppInfoView.f20398h.setOnClickListener(adAppInfoView.q);
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
        d.a.o0.t2.i0.c b2 = g.b(this.n, 102, 0);
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
        SkinManager.setViewTextColor(this.f20395e, R.color.CAM_X0107);
        SkinManager.setViewTextColor(this.f20397g, this.p);
        SkinManager.setViewTextColor(this.f20398h, this.p);
        SkinManager.setViewTextColor(this.f20399i, this.p);
        SkinManager.setViewTextColor(this.j, this.p);
        this.f20396f.onChangeSkinType();
    }

    public void setAd(AdvertAppInfo advertAppInfo) {
        this.n = advertAppInfo;
    }

    public void setAppInfo(c cVar) {
        if (cVar != null && c.c(cVar)) {
            this.m = cVar;
            if (this.f20395e != null) {
                if (!TextUtils.isEmpty(cVar.f53738b)) {
                    this.f20395e.setVisibility(0);
                    this.f20395e.setText(cVar.f53738b);
                } else {
                    this.f20395e.setVisibility(8);
                }
            }
            AdStarRatingBar adStarRatingBar = this.f20396f;
            if (adStarRatingBar != null) {
                float f2 = cVar.f53740d;
                if (f2 >= 0.0f && f2 <= 5.0f) {
                    adStarRatingBar.setVisibility(0);
                    this.f20396f.setRating(cVar.f53740d);
                } else {
                    this.f20396f.setVisibility(8);
                }
            }
            if (this.f20397g != null) {
                if (!TextUtils.isEmpty(cVar.f53741e)) {
                    this.f20397g.setVisibility(0);
                    this.f20397g.setText(cVar.f53741e);
                } else {
                    this.f20397g.setVisibility(8);
                }
            }
            if (this.f20398h != null) {
                if (!TextUtils.isEmpty(cVar.f53739c)) {
                    this.f20398h.setVisibility(0);
                    this.f20398h.setText(cVar.f53739c);
                    c();
                } else {
                    this.f20398h.setVisibility(8);
                }
            }
            if (this.f20399i != null) {
                c.b bVar = cVar.f53742f;
                if (bVar != null && !TextUtils.isEmpty(bVar.f53747b) && !TextUtils.isEmpty(cVar.f53742f.f53746a)) {
                    this.f20399i.setVisibility(0);
                    this.f20399i.setText(cVar.f53742f.f53746a);
                } else {
                    this.f20399i.setVisibility(8);
                }
            }
            if (this.f20399i != null) {
                c.a aVar = cVar.f53743g;
                if (aVar != null && !TextUtils.isEmpty(aVar.f53745b) && !TextUtils.isEmpty(cVar.f53743g.f53744a)) {
                    this.j.setVisibility(0);
                    this.j.setText(cVar.f53743g.f53744a);
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
        this.f20396f.setTextColor(i2);
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
                    c.b bVar = AdAppInfoView.this.m.f53742f;
                    if (bVar != null) {
                        str2 = bVar.f53747b;
                        str = "app_privacy";
                    }
                    str = "";
                } else {
                    if (id == R.id.ad_permission) {
                        c.a aVar = AdAppInfoView.this.m.f53743g;
                        if (aVar != null) {
                            str2 = aVar.f53745b;
                            str = "app_permission";
                        }
                    } else if (id == R.id.ad_author_full_name) {
                        l.M(AdAppInfoView.this.getContext(), AdAppInfoView.this.m.f53739c);
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
