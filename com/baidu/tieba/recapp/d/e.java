package com.baidu.tieba.recapp.d;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.widget.CountDownTextView;
/* loaded from: classes7.dex */
public class e {
    public TbPageContext eSJ;
    protected final String mOu;
    protected com.baidu.tieba.recapp.report.c mOv;
    protected AdvertAppInfo mOw;
    protected com.baidu.tieba.lego.card.a.b mOx;
    protected final View mRootView;

    public e(View view, String str) {
        this.mRootView = view;
        this.mOu = str;
    }

    public void a(AdCard.f fVar) {
    }

    public void onChangeSkinType() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final <T> T HK(int i) {
        return (T) this.mRootView.findViewById(i);
    }

    public void dCl() {
        this.mRootView.setVisibility(0);
        if (this.mOv != null) {
            this.mOv.HD(303);
            com.baidu.tieba.recapp.report.e.dCe().a(this.mOv);
        }
    }

    public void dCm() {
        this.mRootView.setVisibility(8);
    }

    public void e(com.baidu.tieba.recapp.report.c cVar) {
        this.mOv = cVar;
    }

    public void c(com.baidu.tieba.lego.card.a.b bVar) {
        this.mOx = bVar;
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        this.eSJ = tbPageContext;
    }

    public void setDownloadAppCallback(com.baidu.tieba.lego.card.c cVar) {
    }

    public void setTimeoutListener(CountDownTextView.b bVar) {
    }

    public void xk(boolean z) {
    }

    public void setAdvertAppInfo(AdvertAppInfo advertAppInfo) {
        this.mOw = advertAppInfo;
    }
}
