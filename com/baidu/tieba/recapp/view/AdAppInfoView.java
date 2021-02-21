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
/* loaded from: classes8.dex */
public class AdAppInfoView extends FrameLayout {
    private AdvertAppInfo kTV;
    protected View.OnClickListener mClickListener;
    protected TextView mVersionView;
    protected TextView mYn;
    protected AdStarRatingBar mYo;
    protected TextView mYp;
    protected TextView mYq;
    protected TextView mYr;
    protected RelativeLayout mYs;
    protected c mYt;

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
                if (AdAppInfoView.this.mYt != null) {
                    String str = "";
                    String str2 = "";
                    int id = view.getId();
                    if (id == R.id.ad_privacy) {
                        if (AdAppInfoView.this.mYt.eKT != null) {
                            str = AdAppInfoView.this.mYt.eKT.url;
                            str2 = "app_privacy";
                        }
                    } else if (id == R.id.ad_permission) {
                        if (AdAppInfoView.this.mYt.eKU != null) {
                            str = AdAppInfoView.this.mYt.eKU.url;
                            str2 = "app_permission";
                        }
                    } else if (id == R.id.ad_author_full_name) {
                        l.showToast(AdAppInfoView.this.getContext(), AdAppInfoView.this.mYt.eKR);
                        return;
                    }
                    t.i(AdAppInfoView.this.getContext(), str, null, null);
                    AdAppInfoView.this.Se(str2);
                }
            }
        };
        init();
    }

    protected void init() {
        LayoutInflater.from(getContext()).inflate(getLayoutId(), this);
        this.mYn = (TextView) findViewById(R.id.ad_name);
        this.mYo = (AdStarRatingBar) findViewById(R.id.ad_rating);
        this.mVersionView = (TextView) findViewById(R.id.ad_version);
        this.mYp = (TextView) findViewById(R.id.ad_author_full_name);
        this.mYq = (TextView) findViewById(R.id.ad_privacy);
        this.mYr = (TextView) findViewById(R.id.ad_permission);
        this.mYs = (RelativeLayout) findViewById(R.id.download_button_container);
        this.mYq.setOnClickListener(this.mClickListener);
        this.mYr.setOnClickListener(this.mClickListener);
    }

    protected int getLayoutId() {
        return R.layout.ad_app_info_view;
    }

    public void setAppInfo(c cVar) {
        if (cVar == null || !c.a(cVar)) {
            this.mYt = null;
            return;
        }
        this.mYt = cVar;
        if (!TextUtils.isEmpty(cVar.appName)) {
            this.mYn.setVisibility(0);
            this.mYn.setText(cVar.appName);
        } else {
            this.mYn.setVisibility(8);
        }
        if (cVar.eKS < 0.0f || cVar.eKS > 5.0f) {
            this.mYo.setVisibility(8);
        } else {
            this.mYo.setVisibility(0);
            this.mYo.setRating(cVar.eKS);
        }
        if (!TextUtils.isEmpty(cVar.version)) {
            this.mVersionView.setVisibility(0);
            this.mVersionView.setText(cVar.version);
        } else {
            this.mVersionView.setVisibility(8);
        }
        if (!TextUtils.isEmpty(cVar.eKR)) {
            this.mYp.setVisibility(0);
            this.mYp.setText(cVar.eKR);
            dED();
        } else {
            this.mYp.setVisibility(8);
        }
        if (cVar.eKT != null && !TextUtils.isEmpty(cVar.eKT.url) && !TextUtils.isEmpty(cVar.eKT.desc)) {
            this.mYq.setVisibility(0);
            this.mYq.setText(cVar.eKT.desc);
        } else {
            this.mYq.setVisibility(8);
        }
        if (cVar.eKU != null && !TextUtils.isEmpty(cVar.eKU.url) && !TextUtils.isEmpty(cVar.eKU.desc)) {
            this.mYr.setVisibility(0);
            this.mYr.setText(cVar.eKU.desc);
            return;
        }
        this.mYr.setVisibility(8);
    }

    private void dED() {
        final ViewTreeObserver viewTreeObserver = this.mYp.getViewTreeObserver();
        if (viewTreeObserver != null) {
            viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.recapp.view.AdAppInfoView.2
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                @SuppressLint({"NewApi"})
                public void onGlobalLayout() {
                    int lineCount;
                    Layout layout = AdAppInfoView.this.mYp.getLayout();
                    if (layout != null && (lineCount = layout.getLineCount()) > 0 && layout.getEllipsisCount(lineCount - 1) > 0) {
                        AdAppInfoView.this.mYp.setOnClickListener(AdAppInfoView.this.mClickListener);
                    }
                    if (viewTreeObserver.isAlive()) {
                        viewTreeObserver.removeOnGlobalLayoutListener(this);
                    }
                }
            });
        }
    }

    public RelativeLayout getDownloadButtonContainer() {
        return this.mYs;
    }

    public void setAd(AdvertAppInfo advertAppInfo) {
        this.kTV = advertAppInfo;
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.mYn, R.color.CAM_X0107);
        ap.setViewTextColor(this.mVersionView, R.color.CAM_X0109);
        ap.setViewTextColor(this.mYp, R.color.CAM_X0109);
        ap.setViewTextColor(this.mYq, R.color.CAM_X0109);
        ap.setViewTextColor(this.mYr, R.color.CAM_X0109);
        this.mYo.onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Se(String str) {
        if (this.kTV != null && !TextUtils.isEmpty(str)) {
            com.baidu.tieba.recapp.report.c b2 = h.b(this.kTV, 102, 0);
            b2.Sd(str);
            e.dEu().a(b2);
        }
    }
}
