package com.baidu.tieba.recapp.e;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.widget.CountDownTextView;
/* loaded from: classes13.dex */
public class e {
    public TbPageContext cVg;
    protected final String jMi;
    protected com.baidu.tieba.recapp.report.b jMj;
    protected AdvertAppInfo jMk;
    protected com.baidu.tieba.lego.card.b.b jMl;
    protected final View mRootView;

    public e(View view, String str) {
        this.mRootView = view;
        this.jMi = str;
    }

    public void a(AdCard.f fVar) {
    }

    public void onChangeSkinType() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final <T> T Bf(int i) {
        return (T) this.mRootView.findViewById(i);
    }

    public void cDu() {
        this.mRootView.setVisibility(0);
        if (this.jMj != null) {
            this.jMj.AY(303);
            com.baidu.tieba.recapp.report.c.cDn().a(this.jMj);
        }
    }

    public void cDv() {
        this.mRootView.setVisibility(8);
    }

    public void e(com.baidu.tieba.recapp.report.b bVar) {
        this.jMj = bVar;
    }

    public void c(com.baidu.tieba.lego.card.b.b bVar) {
        this.jMl = bVar;
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        this.cVg = tbPageContext;
    }

    public void setDownloadAppCallback(com.baidu.tieba.lego.card.c cVar) {
    }

    public void setTimeoutListener(CountDownTextView.b bVar) {
    }

    public void se(boolean z) {
    }

    public void setAdvertAppInfo(AdvertAppInfo advertAppInfo) {
        this.jMk = advertAppInfo;
    }
}
