package com.baidu.tieba.recapp.e;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.widget.CountDownTextView;
/* loaded from: classes13.dex */
public class e {
    public TbPageContext dIF;
    protected final String kPp;
    protected com.baidu.tieba.recapp.report.c kPq;
    protected AdvertAppInfo kPr;
    protected com.baidu.tieba.lego.card.b.b kPs;
    protected final View mRootView;

    public e(View view, String str) {
        this.mRootView = view;
        this.kPp = str;
    }

    public void a(AdCard.f fVar) {
    }

    public void onChangeSkinType() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final <T> T Cx(int i) {
        return (T) this.mRootView.findViewById(i);
    }

    public void cVr() {
        this.mRootView.setVisibility(0);
        if (this.kPq != null) {
            this.kPq.Cq(303);
            com.baidu.tieba.recapp.report.d.cVk().a(this.kPq);
        }
    }

    public void cVs() {
        this.mRootView.setVisibility(8);
    }

    public void e(com.baidu.tieba.recapp.report.c cVar) {
        this.kPq = cVar;
    }

    public void c(com.baidu.tieba.lego.card.b.b bVar) {
        this.kPs = bVar;
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
        this.kPr = advertAppInfo;
    }
}
