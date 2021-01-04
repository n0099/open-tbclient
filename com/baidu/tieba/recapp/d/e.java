package com.baidu.tieba.recapp.d;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.widget.CountDownTextView;
/* loaded from: classes8.dex */
public class e {
    public TbPageContext eXu;
    protected final View mRootView;
    protected final String mTd;
    protected com.baidu.tieba.recapp.report.c mTe;
    protected AdvertAppInfo mTf;
    protected com.baidu.tieba.lego.card.a.b mTg;

    public e(View view, String str) {
        this.mRootView = view;
        this.mTd = str;
    }

    public void a(AdCard.f fVar) {
    }

    public void onChangeSkinType() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final <T> T Jr(int i) {
        return (T) this.mRootView.findViewById(i);
    }

    public void dGc() {
        this.mRootView.setVisibility(0);
        if (this.mTe != null) {
            this.mTe.Jk(303);
            com.baidu.tieba.recapp.report.e.dFV().a(this.mTe);
        }
    }

    public void dGd() {
        this.mRootView.setVisibility(8);
    }

    public void e(com.baidu.tieba.recapp.report.c cVar) {
        this.mTe = cVar;
    }

    public void c(com.baidu.tieba.lego.card.a.b bVar) {
        this.mTg = bVar;
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        this.eXu = tbPageContext;
    }

    public void setDownloadAppCallback(com.baidu.tieba.lego.card.c cVar) {
    }

    public void setTimeoutListener(CountDownTextView.b bVar) {
    }

    public void xo(boolean z) {
    }

    public void setAdvertAppInfo(AdvertAppInfo advertAppInfo) {
        this.mTf = advertAppInfo;
    }
}
