package com.baidu.tieba.recapp.e;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.widget.CountDownTextView;
/* loaded from: classes3.dex */
public class e {
    public TbPageContext ceu;
    protected final String iNr;
    protected com.baidu.tieba.recapp.report.b iNs;
    protected AdvertAppInfo iNt;
    protected com.baidu.tieba.lego.card.b.b iNu;
    protected final View mRootView;

    public e(View view, String str) {
        this.mRootView = view;
        this.iNr = str;
    }

    public void a(AdCard.f fVar) {
    }

    public void onChangeSkinType() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final <T> T yv(int i) {
        return (T) this.mRootView.findViewById(i);
    }

    public void cgN() {
        this.mRootView.setVisibility(0);
        if (this.iNs != null) {
            this.iNs.yo(303);
            com.baidu.tieba.recapp.report.c.cgG().a(this.iNs);
        }
    }

    public void cgO() {
        this.mRootView.setVisibility(8);
    }

    public void e(com.baidu.tieba.recapp.report.b bVar) {
        this.iNs = bVar;
    }

    public void c(com.baidu.tieba.lego.card.b.b bVar) {
        this.iNu = bVar;
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        this.ceu = tbPageContext;
    }

    public void setDownloadAppCallback(com.baidu.tieba.lego.card.c cVar) {
    }

    public void setTimeoutListener(CountDownTextView.b bVar) {
    }

    public void qg(boolean z) {
    }

    public void setAdvertAppInfo(AdvertAppInfo advertAppInfo) {
        this.iNt = advertAppInfo;
    }
}
