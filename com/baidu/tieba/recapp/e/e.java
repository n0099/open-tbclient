package com.baidu.tieba.recapp.e;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.widget.CountDownTextView;
/* loaded from: classes3.dex */
public class e {
    public TbPageContext cfl;
    protected final String iOi;
    protected com.baidu.tieba.recapp.report.b iOj;
    protected AdvertAppInfo iOk;
    protected com.baidu.tieba.lego.card.b.b iOl;
    protected final View mRootView;

    public e(View view, String str) {
        this.mRootView = view;
        this.iOi = str;
    }

    public void a(AdCard.f fVar) {
    }

    public void onChangeSkinType() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final <T> T yw(int i) {
        return (T) this.mRootView.findViewById(i);
    }

    public void cgP() {
        this.mRootView.setVisibility(0);
        if (this.iOj != null) {
            this.iOj.yp(303);
            com.baidu.tieba.recapp.report.c.cgI().a(this.iOj);
        }
    }

    public void cgQ() {
        this.mRootView.setVisibility(8);
    }

    public void e(com.baidu.tieba.recapp.report.b bVar) {
        this.iOj = bVar;
    }

    public void c(com.baidu.tieba.lego.card.b.b bVar) {
        this.iOl = bVar;
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        this.cfl = tbPageContext;
    }

    public void setDownloadAppCallback(com.baidu.tieba.lego.card.c cVar) {
    }

    public void setTimeoutListener(CountDownTextView.b bVar) {
    }

    public void qg(boolean z) {
    }

    public void setAdvertAppInfo(AdvertAppInfo advertAppInfo) {
        this.iOk = advertAppInfo;
    }
}
