package com.baidu.tieba.recapp.e;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.widget.CountDownTextView;
/* loaded from: classes13.dex */
public class e {
    public TbPageContext cVi;
    protected final String jMw;
    protected com.baidu.tieba.recapp.report.b jMx;
    protected AdvertAppInfo jMy;
    protected com.baidu.tieba.lego.card.b.b jMz;
    protected final View mRootView;

    public e(View view, String str) {
        this.mRootView = view;
        this.jMw = str;
    }

    public void a(AdCard.f fVar) {
    }

    public void onChangeSkinType() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final <T> T Bf(int i) {
        return (T) this.mRootView.findViewById(i);
    }

    public void cDx() {
        this.mRootView.setVisibility(0);
        if (this.jMx != null) {
            this.jMx.AY(303);
            com.baidu.tieba.recapp.report.c.cDq().a(this.jMx);
        }
    }

    public void cDy() {
        this.mRootView.setVisibility(8);
    }

    public void e(com.baidu.tieba.recapp.report.b bVar) {
        this.jMx = bVar;
    }

    public void c(com.baidu.tieba.lego.card.b.b bVar) {
        this.jMz = bVar;
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        this.cVi = tbPageContext;
    }

    public void setDownloadAppCallback(com.baidu.tieba.lego.card.c cVar) {
    }

    public void setTimeoutListener(CountDownTextView.b bVar) {
    }

    public void se(boolean z) {
    }

    public void setAdvertAppInfo(AdvertAppInfo advertAppInfo) {
        this.jMy = advertAppInfo;
    }
}
