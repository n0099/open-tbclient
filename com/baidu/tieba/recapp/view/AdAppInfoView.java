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
import com.baidu.tieba.recapp.s;
/* loaded from: classes8.dex */
public class AdAppInfoView extends FrameLayout {
    private AdvertAppInfo kTH;
    protected View.OnClickListener mClickListener;
    protected TextView mVersionView;
    protected TextView mXN;
    protected AdStarRatingBar mXO;
    protected TextView mXP;
    protected TextView mXQ;
    protected TextView mXR;
    protected RelativeLayout mXS;
    protected c mXT;

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
                if (AdAppInfoView.this.mXT != null) {
                    String str = "";
                    String str2 = "";
                    int id = view.getId();
                    if (id == R.id.ad_privacy) {
                        if (AdAppInfoView.this.mXT.eKT != null) {
                            str = AdAppInfoView.this.mXT.eKT.url;
                            str2 = "app_privacy";
                        }
                    } else if (id == R.id.ad_permission) {
                        if (AdAppInfoView.this.mXT.eKU != null) {
                            str = AdAppInfoView.this.mXT.eKU.url;
                            str2 = "app_permission";
                        }
                    } else if (id == R.id.ad_author_full_name) {
                        l.showToast(AdAppInfoView.this.getContext(), AdAppInfoView.this.mXT.eKR);
                        return;
                    }
                    s.x(AdAppInfoView.this.getContext(), str, null);
                    AdAppInfoView.this.RS(str2);
                }
            }
        };
        init();
    }

    protected void init() {
        LayoutInflater.from(getContext()).inflate(getLayoutId(), this);
        this.mXN = (TextView) findViewById(R.id.ad_name);
        this.mXO = (AdStarRatingBar) findViewById(R.id.ad_rating);
        this.mVersionView = (TextView) findViewById(R.id.ad_version);
        this.mXP = (TextView) findViewById(R.id.ad_author_full_name);
        this.mXQ = (TextView) findViewById(R.id.ad_privacy);
        this.mXR = (TextView) findViewById(R.id.ad_permission);
        this.mXS = (RelativeLayout) findViewById(R.id.download_button_container);
        this.mXQ.setOnClickListener(this.mClickListener);
        this.mXR.setOnClickListener(this.mClickListener);
    }

    protected int getLayoutId() {
        return R.layout.ad_app_info_view;
    }

    public void setAppInfo(c cVar) {
        if (cVar == null || !c.a(cVar)) {
            this.mXT = null;
            return;
        }
        this.mXT = cVar;
        if (!TextUtils.isEmpty(cVar.appName)) {
            this.mXN.setVisibility(0);
            this.mXN.setText(cVar.appName);
        } else {
            this.mXN.setVisibility(8);
        }
        if (cVar.eKS < 0.0f || cVar.eKS > 5.0f) {
            this.mXO.setVisibility(8);
        } else {
            this.mXO.setVisibility(0);
            this.mXO.setRating(cVar.eKS);
        }
        if (!TextUtils.isEmpty(cVar.version)) {
            this.mVersionView.setVisibility(0);
            this.mVersionView.setText(cVar.version);
        } else {
            this.mVersionView.setVisibility(8);
        }
        if (!TextUtils.isEmpty(cVar.eKR)) {
            this.mXP.setVisibility(0);
            this.mXP.setText(cVar.eKR);
            dEv();
        } else {
            this.mXP.setVisibility(8);
        }
        if (cVar.eKT != null && !TextUtils.isEmpty(cVar.eKT.url) && !TextUtils.isEmpty(cVar.eKT.desc)) {
            this.mXQ.setVisibility(0);
            this.mXQ.setText(cVar.eKT.desc);
        } else {
            this.mXQ.setVisibility(8);
        }
        if (cVar.eKU != null && !TextUtils.isEmpty(cVar.eKU.url) && !TextUtils.isEmpty(cVar.eKU.desc)) {
            this.mXR.setVisibility(0);
            this.mXR.setText(cVar.eKU.desc);
            return;
        }
        this.mXR.setVisibility(8);
    }

    private void dEv() {
        final ViewTreeObserver viewTreeObserver = this.mXP.getViewTreeObserver();
        if (viewTreeObserver != null) {
            viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.recapp.view.AdAppInfoView.2
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                @SuppressLint({"NewApi"})
                public void onGlobalLayout() {
                    int lineCount;
                    Layout layout = AdAppInfoView.this.mXP.getLayout();
                    if (layout != null && (lineCount = layout.getLineCount()) > 0 && layout.getEllipsisCount(lineCount - 1) > 0) {
                        AdAppInfoView.this.mXP.setOnClickListener(AdAppInfoView.this.mClickListener);
                    }
                    if (viewTreeObserver.isAlive()) {
                        viewTreeObserver.removeOnGlobalLayoutListener(this);
                    }
                }
            });
        }
    }

    public RelativeLayout getDownloadButtonContainer() {
        return this.mXS;
    }

    public void setAd(AdvertAppInfo advertAppInfo) {
        this.kTH = advertAppInfo;
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.mXN, R.color.CAM_X0107);
        ap.setViewTextColor(this.mVersionView, R.color.CAM_X0109);
        ap.setViewTextColor(this.mXP, R.color.CAM_X0109);
        ap.setViewTextColor(this.mXQ, R.color.CAM_X0109);
        ap.setViewTextColor(this.mXR, R.color.CAM_X0109);
        this.mXO.onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void RS(String str) {
        if (this.kTH != null && !TextUtils.isEmpty(str)) {
            com.baidu.tieba.recapp.report.c b2 = h.b(this.kTH, 102, 0);
            b2.RR(str);
            e.dEm().a(b2);
        }
    }
}
