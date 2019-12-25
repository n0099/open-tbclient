package com.baidu.tieba.recapp.e;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.widget.CountDownTextView;
/* loaded from: classes10.dex */
public class e {
    public TbPageContext cQU;
    protected final String jHF;
    protected com.baidu.tieba.recapp.report.b jHG;
    protected AdvertAppInfo jHH;
    protected com.baidu.tieba.lego.card.b.b jHI;
    protected final View mRootView;

    public e(View view, String str) {
        this.mRootView = view;
        this.jHF = str;
    }

    public void a(AdCard.f fVar) {
    }

    public void onChangeSkinType() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final <T> T AR(int i) {
        return (T) this.mRootView.findViewById(i);
    }

    public void cAQ() {
        this.mRootView.setVisibility(0);
        if (this.jHG != null) {
            this.jHG.AK(303);
            com.baidu.tieba.recapp.report.c.cAJ().a(this.jHG);
        }
    }

    public void cAR() {
        this.mRootView.setVisibility(8);
    }

    public void e(com.baidu.tieba.recapp.report.b bVar) {
        this.jHG = bVar;
    }

    public void c(com.baidu.tieba.lego.card.b.b bVar) {
        this.jHI = bVar;
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        this.cQU = tbPageContext;
    }

    public void setDownloadAppCallback(com.baidu.tieba.lego.card.c cVar) {
    }

    public void setTimeoutListener(CountDownTextView.b bVar) {
    }

    public void rP(boolean z) {
    }

    public void setAdvertAppInfo(AdvertAppInfo advertAppInfo) {
        this.jHH = advertAppInfo;
    }
}
