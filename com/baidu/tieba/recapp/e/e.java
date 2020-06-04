package com.baidu.tieba.recapp.e;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.widget.CountDownTextView;
/* loaded from: classes13.dex */
public class e {
    public TbPageContext dIF;
    protected AdvertAppInfo kQA;
    protected com.baidu.tieba.lego.card.b.b kQB;
    protected final String kQy;
    protected com.baidu.tieba.recapp.report.c kQz;
    protected final View mRootView;

    public e(View view, String str) {
        this.mRootView = view;
        this.kQy = str;
    }

    public void a(AdCard.f fVar) {
    }

    public void onChangeSkinType() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final <T> T Cz(int i) {
        return (T) this.mRootView.findViewById(i);
    }

    public void cVH() {
        this.mRootView.setVisibility(0);
        if (this.kQz != null) {
            this.kQz.Cs(303);
            com.baidu.tieba.recapp.report.d.cVA().a(this.kQz);
        }
    }

    public void cVI() {
        this.mRootView.setVisibility(8);
    }

    public void e(com.baidu.tieba.recapp.report.c cVar) {
        this.kQz = cVar;
    }

    public void c(com.baidu.tieba.lego.card.b.b bVar) {
        this.kQB = bVar;
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        this.dIF = tbPageContext;
    }

    public void setDownloadAppCallback(com.baidu.tieba.lego.card.c cVar) {
    }

    public void setTimeoutListener(CountDownTextView.b bVar) {
    }

    public void tJ(boolean z) {
    }

    public void setAdvertAppInfo(AdvertAppInfo advertAppInfo) {
        this.kQA = advertAppInfo;
    }
}
