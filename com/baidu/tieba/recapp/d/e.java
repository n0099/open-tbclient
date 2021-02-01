package com.baidu.tieba.recapp.d;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.widget.CountDownTextView;
/* loaded from: classes8.dex */
public class e {
    public TbPageContext eUY;
    protected final View mRootView;
    protected final String mXJ;
    protected com.baidu.tieba.recapp.report.c mXK;
    protected AdvertAppInfo mXL;
    protected com.baidu.tieba.lego.card.a.b mXM;

    public e(View view, String str) {
        this.mRootView = view;
        this.mXJ = str;
    }

    public void a(AdCard.f fVar) {
    }

    public void onChangeSkinType() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final <T> T Id(int i) {
        return (T) this.mRootView.findViewById(i);
    }

    public void dEt() {
        this.mRootView.setVisibility(0);
        if (this.mXK != null) {
            this.mXK.HW(303);
            com.baidu.tieba.recapp.report.e.dEm().a(this.mXK);
        }
    }

    public void dEu() {
        this.mRootView.setVisibility(8);
    }

    public void e(com.baidu.tieba.recapp.report.c cVar) {
        this.mXK = cVar;
    }

    public void c(com.baidu.tieba.lego.card.a.b bVar) {
        this.mXM = bVar;
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        this.eUY = tbPageContext;
    }

    public void setDownloadAppCallback(com.baidu.tieba.lego.card.c cVar) {
    }

    public void setTimeoutListener(CountDownTextView.b bVar) {
    }

    public void xD(boolean z) {
    }

    public void setAdvertAppInfo(AdvertAppInfo advertAppInfo) {
        this.mXL = advertAppInfo;
    }
}
