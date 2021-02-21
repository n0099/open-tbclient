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
    protected final String mYj;
    protected com.baidu.tieba.recapp.report.c mYk;
    protected AdvertAppInfo mYl;
    protected com.baidu.tieba.lego.card.a.b mYm;

    public e(View view, String str) {
        this.mRootView = view;
        this.mYj = str;
    }

    public void a(AdCard.f fVar) {
    }

    public void onChangeSkinType() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final <T> T Id(int i) {
        return (T) this.mRootView.findViewById(i);
    }

    public void dEB() {
        this.mRootView.setVisibility(0);
        if (this.mYk != null) {
            this.mYk.HW(303);
            com.baidu.tieba.recapp.report.e.dEu().a(this.mYk);
        }
    }

    public void dEC() {
        this.mRootView.setVisibility(8);
    }

    public void e(com.baidu.tieba.recapp.report.c cVar) {
        this.mYk = cVar;
    }

    public void c(com.baidu.tieba.lego.card.a.b bVar) {
        this.mYm = bVar;
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
        this.mYl = advertAppInfo;
    }
}
