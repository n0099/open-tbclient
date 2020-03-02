package com.baidu.tieba.recapp.e;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.widget.CountDownTextView;
/* loaded from: classes13.dex */
public class e {
    public TbPageContext cVh;
    protected final String jMk;
    protected com.baidu.tieba.recapp.report.b jMl;
    protected AdvertAppInfo jMm;
    protected com.baidu.tieba.lego.card.b.b jMn;
    protected final View mRootView;

    public e(View view, String str) {
        this.mRootView = view;
        this.jMk = str;
    }

    public void a(AdCard.f fVar) {
    }

    public void onChangeSkinType() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final <T> T Bf(int i) {
        return (T) this.mRootView.findViewById(i);
    }

    public void cDw() {
        this.mRootView.setVisibility(0);
        if (this.jMl != null) {
            this.jMl.AY(303);
            com.baidu.tieba.recapp.report.c.cDp().a(this.jMl);
        }
    }

    public void cDx() {
        this.mRootView.setVisibility(8);
    }

    public void e(com.baidu.tieba.recapp.report.b bVar) {
        this.jMl = bVar;
    }

    public void c(com.baidu.tieba.lego.card.b.b bVar) {
        this.jMn = bVar;
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        this.cVh = tbPageContext;
    }

    public void setDownloadAppCallback(com.baidu.tieba.lego.card.c cVar) {
    }

    public void setTimeoutListener(CountDownTextView.b bVar) {
    }

    public void se(boolean z) {
    }

    public void setAdvertAppInfo(AdvertAppInfo advertAppInfo) {
        this.jMm = advertAppInfo;
    }
}
