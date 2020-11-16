package com.baidu.tieba.recapp.e;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.widget.CountDownTextView;
/* loaded from: classes25.dex */
public class e {
    public TbPageContext eGu;
    protected final View mRootView;
    protected final String mzG;
    protected com.baidu.tieba.recapp.report.c mzH;
    protected AdvertAppInfo mzI;
    protected com.baidu.tieba.lego.card.b.b mzJ;

    public e(View view, String str) {
        this.mRootView = view;
        this.mzG = str;
    }

    public void a(AdCard.f fVar) {
    }

    public void onChangeSkinType() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final <T> T IG(int i) {
        return (T) this.mRootView.findViewById(i);
    }

    public void dBa() {
        this.mRootView.setVisibility(0);
        if (this.mzH != null) {
            this.mzH.Iz(303);
            com.baidu.tieba.recapp.report.d.dAT().a(this.mzH);
        }
    }

    public void dBb() {
        this.mRootView.setVisibility(8);
    }

    public void e(com.baidu.tieba.recapp.report.c cVar) {
        this.mzH = cVar;
    }

    public void c(com.baidu.tieba.lego.card.b.b bVar) {
        this.mzJ = bVar;
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        this.eGu = tbPageContext;
    }

    public void setDownloadAppCallback(com.baidu.tieba.lego.card.c cVar) {
    }

    public void setTimeoutListener(CountDownTextView.b bVar) {
    }

    public void wJ(boolean z) {
    }

    public void setAdvertAppInfo(AdvertAppInfo advertAppInfo) {
        this.mzI = advertAppInfo;
    }
}
