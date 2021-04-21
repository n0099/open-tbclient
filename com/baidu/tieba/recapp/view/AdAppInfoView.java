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
import d.b.c.e.p.l;
import d.b.i0.r.q.c;
import d.b.j0.s2.f0.e;
import d.b.j0.s2.f0.h;
import d.b.j0.s2.w;
/* loaded from: classes4.dex */
public class AdAppInfoView extends FrameLayout {

    /* renamed from: e  reason: collision with root package name */
    public TextView f20525e;

    /* renamed from: f  reason: collision with root package name */
    public AdStarRatingBar f20526f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f20527g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f20528h;
    public TextView i;
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
        this.f20525e = (TextView) findViewById(R.id.ad_name);
        this.f20526f = (AdStarRatingBar) findViewById(R.id.ad_rating);
        this.f20527g = (TextView) findViewById(R.id.ad_version);
        this.f20528h = (TextView) findViewById(R.id.ad_author_full_name);
        this.i = (TextView) findViewById(R.id.ad_privacy);
        this.j = (TextView) findViewById(R.id.ad_permission);
        this.k = (TextView) findViewById(R.id.ad_tag);
        this.l = (RelativeLayout) findViewById(R.id.download_button_container);
        this.i.setOnClickListener(this.q);
        this.j.setOnClickListener(this.q);
    }

    public final void c() {
        final ViewTreeObserver viewTreeObserver = this.f20528h.getViewTreeObserver();
        if (viewTreeObserver == null) {
            return;
        }
        viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.recapp.view.AdAppInfoView.2
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            @SuppressLint({"NewApi"})
            public void onGlobalLayout() {
                int lineCount;
                Layout layout = AdAppInfoView.this.f20528h.getLayout();
                if (layout != null && (lineCount = layout.getLineCount()) > 0 && layout.getEllipsisCount(lineCount - 1) > 0) {
                    AdAppInfoView adAppInfoView = AdAppInfoView.this;
                    adAppInfoView.f20528h.setOnClickListener(adAppInfoView.q);
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
        d.b.j0.s2.f0.c b2 = h.b(this.n, 102, 0);
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
        SkinManager.setViewTextColor(this.f20525e, R.color.CAM_X0107);
        SkinManager.setViewTextColor(this.f20527g, this.p);
        SkinManager.setViewTextColor(this.f20528h, this.p);
        SkinManager.setViewTextColor(this.i, this.p);
        SkinManager.setViewTextColor(this.j, this.p);
        this.f20526f.onChangeSkinType();
    }

    public void setAd(AdvertAppInfo advertAppInfo) {
        this.n = advertAppInfo;
    }

    public void setAppInfo(c cVar) {
        if (cVar != null && c.c(cVar)) {
            this.m = cVar;
            if (this.f20525e != null) {
                if (!TextUtils.isEmpty(cVar.f51468b)) {
                    this.f20525e.setVisibility(0);
                    this.f20525e.setText(cVar.f51468b);
                } else {
                    this.f20525e.setVisibility(8);
                }
            }
            AdStarRatingBar adStarRatingBar = this.f20526f;
            if (adStarRatingBar != null) {
                float f2 = cVar.f51470d;
                if (f2 >= 0.0f && f2 <= 5.0f) {
                    adStarRatingBar.setVisibility(0);
                    this.f20526f.setRating(cVar.f51470d);
                } else {
                    this.f20526f.setVisibility(8);
                }
            }
            if (this.f20527g != null) {
                if (!TextUtils.isEmpty(cVar.f51471e)) {
                    this.f20527g.setVisibility(0);
                    this.f20527g.setText(cVar.f51471e);
                } else {
                    this.f20527g.setVisibility(8);
                }
            }
            if (this.f20528h != null) {
                if (!TextUtils.isEmpty(cVar.f51469c)) {
                    this.f20528h.setVisibility(0);
                    this.f20528h.setText(cVar.f51469c);
                    c();
                } else {
                    this.f20528h.setVisibility(8);
                }
            }
            if (this.i != null) {
                c.b bVar = cVar.f51472f;
                if (bVar != null && !TextUtils.isEmpty(bVar.f51477b) && !TextUtils.isEmpty(cVar.f51472f.f51476a)) {
                    this.i.setVisibility(0);
                    this.i.setText(cVar.f51472f.f51476a);
                } else {
                    this.i.setVisibility(8);
                }
            }
            if (this.i != null) {
                c.a aVar = cVar.f51473g;
                if (aVar != null && !TextUtils.isEmpty(aVar.f51475b) && !TextUtils.isEmpty(cVar.f51473g.f51474a)) {
                    this.j.setVisibility(0);
                    this.j.setText(cVar.f51473g.f51474a);
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

    public void setTextColor(int i) {
        this.p = i;
        this.f20526f.setTextColor(i);
    }

    public AdAppInfoView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AdAppInfoView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
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
                    c.b bVar = AdAppInfoView.this.m.f51472f;
                    if (bVar != null) {
                        str2 = bVar.f51477b;
                        str = "app_privacy";
                    }
                    str = "";
                } else {
                    if (id == R.id.ad_permission) {
                        c.a aVar = AdAppInfoView.this.m.f51473g;
                        if (aVar != null) {
                            str2 = aVar.f51475b;
                            str = "app_permission";
                        }
                    } else if (id == R.id.ad_author_full_name) {
                        l.L(AdAppInfoView.this.getContext(), AdAppInfoView.this.m.f51469c);
                        return;
                    }
                    str = "";
                }
                w.d(AdAppInfoView.this.getContext(), str2, null, null);
                AdAppInfoView.this.d(str);
            }
        };
        b(attributeSet);
    }
}
