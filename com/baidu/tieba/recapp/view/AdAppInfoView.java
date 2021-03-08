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
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.c;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.report.e;
import com.baidu.tieba.recapp.report.h;
import com.baidu.tieba.recapp.t;
/* loaded from: classes7.dex */
public class AdAppInfoView extends FrameLayout {
    private AdvertAppInfo kVX;
    protected View.OnClickListener mClickListener;
    protected TextView mVersionView;
    protected TextView naA;
    protected TextView naB;
    protected TextView naC;
    protected RelativeLayout naD;
    protected c naE;
    protected TextView nay;
    protected AdStarRatingBar naz;

    public AdAppInfoView(@NonNull Context context) {
        this(context, null);
    }

    public AdAppInfoView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AdAppInfoView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdAppInfoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdAppInfoView.this.naE != null) {
                    String str = "";
                    String str2 = "";
                    int id = view.getId();
                    if (id == R.id.ad_privacy) {
                        if (AdAppInfoView.this.naE.eMu != null) {
                            str = AdAppInfoView.this.naE.eMu.url;
                            str2 = "app_privacy";
                        }
                    } else if (id == R.id.ad_permission) {
                        if (AdAppInfoView.this.naE.eMv != null) {
                            str = AdAppInfoView.this.naE.eMv.url;
                            str2 = "app_permission";
                        }
                    } else if (id == R.id.ad_author_full_name) {
                        l.showToast(AdAppInfoView.this.getContext(), AdAppInfoView.this.naE.eMs);
                        return;
                    }
                    t.i(AdAppInfoView.this.getContext(), str, null, null);
                    AdAppInfoView.this.Sk(str2);
                }
            }
        };
        init();
    }

    protected void init() {
        LayoutInflater.from(getContext()).inflate(getLayoutId(), this);
        this.nay = (TextView) findViewById(R.id.ad_name);
        this.naz = (AdStarRatingBar) findViewById(R.id.ad_rating);
        this.mVersionView = (TextView) findViewById(R.id.ad_version);
        this.naA = (TextView) findViewById(R.id.ad_author_full_name);
        this.naB = (TextView) findViewById(R.id.ad_privacy);
        this.naC = (TextView) findViewById(R.id.ad_permission);
        this.naD = (RelativeLayout) findViewById(R.id.download_button_container);
        this.naB.setOnClickListener(this.mClickListener);
        this.naC.setOnClickListener(this.mClickListener);
    }

    protected int getLayoutId() {
        return R.layout.ad_app_info_view;
    }

    public void setAppInfo(c cVar) {
        if (cVar == null || !c.a(cVar)) {
            this.naE = null;
            return;
        }
        this.naE = cVar;
        if (!TextUtils.isEmpty(cVar.appName)) {
            this.nay.setVisibility(0);
            this.nay.setText(cVar.appName);
        } else {
            this.nay.setVisibility(8);
        }
        if (cVar.eMt < 0.0f || cVar.eMt > 5.0f) {
            this.naz.setVisibility(8);
        } else {
            this.naz.setVisibility(0);
            this.naz.setRating(cVar.eMt);
        }
        if (!TextUtils.isEmpty(cVar.version)) {
            this.mVersionView.setVisibility(0);
            this.mVersionView.setText(cVar.version);
        } else {
            this.mVersionView.setVisibility(8);
        }
        if (!TextUtils.isEmpty(cVar.eMs)) {
            this.naA.setVisibility(0);
            this.naA.setText(cVar.eMs);
            dEL();
        } else {
            this.naA.setVisibility(8);
        }
        if (cVar.eMu != null && !TextUtils.isEmpty(cVar.eMu.url) && !TextUtils.isEmpty(cVar.eMu.desc)) {
            this.naB.setVisibility(0);
            this.naB.setText(cVar.eMu.desc);
        } else {
            this.naB.setVisibility(8);
        }
        if (cVar.eMv != null && !TextUtils.isEmpty(cVar.eMv.url) && !TextUtils.isEmpty(cVar.eMv.desc)) {
            this.naC.setVisibility(0);
            this.naC.setText(cVar.eMv.desc);
            return;
        }
        this.naC.setVisibility(8);
    }

    private void dEL() {
        final ViewTreeObserver viewTreeObserver = this.naA.getViewTreeObserver();
        if (viewTreeObserver != null) {
            viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.recapp.view.AdAppInfoView.2
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                @SuppressLint({"NewApi"})
                public void onGlobalLayout() {
                    int lineCount;
                    Layout layout = AdAppInfoView.this.naA.getLayout();
                    if (layout != null && (lineCount = layout.getLineCount()) > 0 && layout.getEllipsisCount(lineCount - 1) > 0) {
                        AdAppInfoView.this.naA.setOnClickListener(AdAppInfoView.this.mClickListener);
                    }
                    if (viewTreeObserver.isAlive()) {
                        viewTreeObserver.removeOnGlobalLayoutListener(this);
                    }
                }
            });
        }
    }

    public RelativeLayout getDownloadButtonContainer() {
        return this.naD;
    }

    public void setAd(AdvertAppInfo advertAppInfo) {
        this.kVX = advertAppInfo;
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.nay, R.color.CAM_X0107);
        ap.setViewTextColor(this.mVersionView, R.color.CAM_X0109);
        ap.setViewTextColor(this.naA, R.color.CAM_X0109);
        ap.setViewTextColor(this.naB, R.color.CAM_X0109);
        ap.setViewTextColor(this.naC, R.color.CAM_X0109);
        this.naz.onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Sk(String str) {
        if (this.kVX != null && !TextUtils.isEmpty(str)) {
            com.baidu.tieba.recapp.report.c b = h.b(this.kVX, 102, 0);
            b.Sj(str);
            e.dEC().a(b);
        }
    }
}
