package com.baidu.tieba.recapp.e;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.widget.CountDownTextView;
/* loaded from: classes26.dex */
public class e {
    public TbPageContext eCn;
    protected final View mRootView;
    protected final String mtf;
    protected com.baidu.tieba.recapp.report.c mtg;
    protected AdvertAppInfo mth;
    protected com.baidu.tieba.lego.card.b.b mti;

    public e(View view, String str) {
        this.mRootView = view;
        this.mtf = str;
    }

    public void a(AdCard.f fVar) {
    }

    public void onChangeSkinType() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final <T> T HS(int i) {
        return (T) this.mRootView.findViewById(i);
    }

    public void dyU() {
        this.mRootView.setVisibility(0);
        if (this.mtg != null) {
            this.mtg.HL(303);
            com.baidu.tieba.recapp.report.d.dyN().a(this.mtg);
        }
    }

    public void dyV() {
        this.mRootView.setVisibility(8);
    }

    public void e(com.baidu.tieba.recapp.report.c cVar) {
        this.mtg = cVar;
    }

    public void c(com.baidu.tieba.lego.card.b.b bVar) {
        this.mti = bVar;
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        this.eCn = tbPageContext;
    }

    public void setDownloadAppCallback(com.baidu.tieba.lego.card.c cVar) {
    }

    public void setTimeoutListener(CountDownTextView.b bVar) {
    }

    public void wx(boolean z) {
    }

    public void setAdvertAppInfo(AdvertAppInfo advertAppInfo) {
        this.mth = advertAppInfo;
    }
}
