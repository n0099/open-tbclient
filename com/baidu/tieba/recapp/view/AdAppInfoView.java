package com.baidu.tieba.recapp.view;

import android.annotation.SuppressLint;
import android.content.Context;
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
import d.b.b.e.p.l;
import d.b.h0.r.q.c;
import d.b.i0.r2.b0.e;
import d.b.i0.r2.b0.h;
import d.b.i0.r2.t;
/* loaded from: classes5.dex */
public class AdAppInfoView extends FrameLayout {

    /* renamed from: e  reason: collision with root package name */
    public TextView f20832e;

    /* renamed from: f  reason: collision with root package name */
    public AdStarRatingBar f20833f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f20834g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f20835h;
    public TextView i;
    public TextView j;
    public RelativeLayout k;
    public c l;
    public AdvertAppInfo m;
    public View.OnClickListener n;

    public AdAppInfoView(@NonNull Context context) {
        this(context, null);
    }

    public void b() {
        LayoutInflater.from(getContext()).inflate(getLayoutId(), this);
        this.f20832e = (TextView) findViewById(R.id.ad_name);
        this.f20833f = (AdStarRatingBar) findViewById(R.id.ad_rating);
        this.f20834g = (TextView) findViewById(R.id.ad_version);
        this.f20835h = (TextView) findViewById(R.id.ad_author_full_name);
        this.i = (TextView) findViewById(R.id.ad_privacy);
        this.j = (TextView) findViewById(R.id.ad_permission);
        this.k = (RelativeLayout) findViewById(R.id.download_button_container);
        this.i.setOnClickListener(this.n);
        this.j.setOnClickListener(this.n);
    }

    public final void c() {
        final ViewTreeObserver viewTreeObserver = this.f20835h.getViewTreeObserver();
        if (viewTreeObserver == null) {
            return;
        }
        viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.recapp.view.AdAppInfoView.2
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            @SuppressLint({"NewApi"})
            public void onGlobalLayout() {
                int lineCount;
                Layout layout = AdAppInfoView.this.f20835h.getLayout();
                if (layout != null && (lineCount = layout.getLineCount()) > 0 && layout.getEllipsisCount(lineCount - 1) > 0) {
                    AdAppInfoView adAppInfoView = AdAppInfoView.this;
                    adAppInfoView.f20835h.setOnClickListener(adAppInfoView.n);
                }
                if (viewTreeObserver.isAlive()) {
                    viewTreeObserver.removeOnGlobalLayoutListener(this);
                }
            }
        });
    }

    public final void d(String str) {
        if (this.m == null || TextUtils.isEmpty(str)) {
            return;
        }
        d.b.i0.r2.b0.c b2 = h.b(this.m, 102, 0);
        b2.c(str);
        e.b().d(b2);
    }

    public RelativeLayout getDownloadButtonContainer() {
        return this.k;
    }

    public int getLayoutId() {
        return R.layout.ad_app_info_view;
    }

    public void onChangeSkinType() {
        SkinManager.setViewTextColor(this.f20832e, R.color.CAM_X0107);
        SkinManager.setViewTextColor(this.f20834g, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.f20835h, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.i, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.j, R.color.CAM_X0109);
        this.f20833f.onChangeSkinType();
    }

    public void setAd(AdvertAppInfo advertAppInfo) {
        this.m = advertAppInfo;
    }

    public void setAppInfo(c cVar) {
        if (cVar != null && c.c(cVar)) {
            this.l = cVar;
            if (!TextUtils.isEmpty(cVar.f50724b)) {
                this.f20832e.setVisibility(0);
                this.f20832e.setText(cVar.f50724b);
            } else {
                this.f20832e.setVisibility(8);
            }
            float f2 = cVar.f50726d;
            if (f2 >= 0.0f && f2 <= 5.0f) {
                this.f20833f.setVisibility(0);
                this.f20833f.setRating(cVar.f50726d);
            } else {
                this.f20833f.setVisibility(8);
            }
            if (!TextUtils.isEmpty(cVar.f50727e)) {
                this.f20834g.setVisibility(0);
                this.f20834g.setText(cVar.f50727e);
            } else {
                this.f20834g.setVisibility(8);
            }
            if (!TextUtils.isEmpty(cVar.f50725c)) {
                this.f20835h.setVisibility(0);
                this.f20835h.setText(cVar.f50725c);
                c();
            } else {
                this.f20835h.setVisibility(8);
            }
            c.b bVar = cVar.f50728f;
            if (bVar != null && !TextUtils.isEmpty(bVar.f50733b) && !TextUtils.isEmpty(cVar.f50728f.f50732a)) {
                this.i.setVisibility(0);
                this.i.setText(cVar.f50728f.f50732a);
            } else {
                this.i.setVisibility(8);
            }
            c.a aVar = cVar.f50729g;
            if (aVar != null && !TextUtils.isEmpty(aVar.f50731b) && !TextUtils.isEmpty(cVar.f50729g.f50730a)) {
                this.j.setVisibility(0);
                this.j.setText(cVar.f50729g.f50730a);
                return;
            }
            this.j.setVisibility(8);
            return;
        }
        this.l = null;
    }

    public AdAppInfoView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AdAppInfoView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.n = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdAppInfoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                if (AdAppInfoView.this.l == null) {
                    return;
                }
                int id = view.getId();
                String str2 = "";
                if (id == R.id.ad_privacy) {
                    c.b bVar = AdAppInfoView.this.l.f50728f;
                    if (bVar != null) {
                        str2 = bVar.f50733b;
                        str = "app_privacy";
                    }
                    str = "";
                } else {
                    if (id == R.id.ad_permission) {
                        c.a aVar = AdAppInfoView.this.l.f50729g;
                        if (aVar != null) {
                            str2 = aVar.f50731b;
                            str = "app_permission";
                        }
                    } else if (id == R.id.ad_author_full_name) {
                        l.L(AdAppInfoView.this.getContext(), AdAppInfoView.this.l.f50725c);
                        return;
                    }
                    str = "";
                }
                t.d(AdAppInfoView.this.getContext(), str2, null, null);
                AdAppInfoView.this.d(str);
            }
        };
        b();
    }
}
