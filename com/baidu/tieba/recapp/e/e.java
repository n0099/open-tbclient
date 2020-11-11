package com.baidu.tieba.recapp.e;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.widget.CountDownTextView;
/* loaded from: classes26.dex */
public class e {
    public TbPageContext eIc;
    protected final View mRootView;
    protected final String mzb;
    protected com.baidu.tieba.recapp.report.c mzc;
    protected AdvertAppInfo mzd;
    protected com.baidu.tieba.lego.card.b.b mze;

    public e(View view, String str) {
        this.mRootView = view;
        this.mzb = str;
    }

    public void a(AdCard.f fVar) {
    }

    public void onChangeSkinType() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final <T> T If(int i) {
        return (T) this.mRootView.findViewById(i);
    }

    public void dBw() {
        this.mRootView.setVisibility(0);
        if (this.mzc != null) {
            this.mzc.HY(303);
            com.baidu.tieba.recapp.report.d.dBp().a(this.mzc);
        }
    }

    public void dBx() {
        this.mRootView.setVisibility(8);
    }

    public void e(com.baidu.tieba.recapp.report.c cVar) {
        this.mzc = cVar;
    }

    public void c(com.baidu.tieba.lego.card.b.b bVar) {
        this.mze = bVar;
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        this.eIc = tbPageContext;
    }

    public void setDownloadAppCallback(com.baidu.tieba.lego.card.c cVar) {
    }

    public void setTimeoutListener(CountDownTextView.b bVar) {
    }

    public void wG(boolean z) {
    }

    public void setAdvertAppInfo(AdvertAppInfo advertAppInfo) {
        this.mzd = advertAppInfo;
    }
}
