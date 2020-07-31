package com.baidu.tieba.recapp.e;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.widget.CountDownTextView;
/* loaded from: classes20.dex */
public class e {
    public TbPageContext dVN;
    protected final String lrK;
    protected com.baidu.tieba.recapp.report.c lrL;
    protected AdvertAppInfo lrM;
    protected com.baidu.tieba.lego.card.b.b lrN;
    protected final View mRootView;

    public e(View view, String str) {
        this.mRootView = view;
        this.lrK = str;
    }

    public void a(AdCard.f fVar) {
    }

    public void onChangeSkinType() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final <T> T DX(int i) {
        return (T) this.mRootView.findViewById(i);
    }

    public void ddf() {
        this.mRootView.setVisibility(0);
        if (this.lrL != null) {
            this.lrL.DQ(303);
            com.baidu.tieba.recapp.report.d.dcY().a(this.lrL);
        }
    }

    public void ddg() {
        this.mRootView.setVisibility(8);
    }

    public void e(com.baidu.tieba.recapp.report.c cVar) {
        this.lrL = cVar;
    }

    public void c(com.baidu.tieba.lego.card.b.b bVar) {
        this.lrN = bVar;
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        this.dVN = tbPageContext;
    }

    public void setDownloadAppCallback(com.baidu.tieba.lego.card.c cVar) {
    }

    public void setTimeoutListener(CountDownTextView.b bVar) {
    }

    public void uC(boolean z) {
    }

    public void setAdvertAppInfo(AdvertAppInfo advertAppInfo) {
        this.lrM = advertAppInfo;
    }
}
