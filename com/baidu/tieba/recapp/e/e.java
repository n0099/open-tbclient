package com.baidu.tieba.recapp.e;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.widget.CountDownTextView;
/* loaded from: classes20.dex */
public class e {
    public TbPageContext efn;
    protected final String lIh;
    protected com.baidu.tieba.recapp.report.c lIi;
    protected AdvertAppInfo lIj;
    protected com.baidu.tieba.lego.card.b.b lIk;
    protected final View mRootView;

    public e(View view, String str) {
        this.mRootView = view;
        this.lIh = str;
    }

    public void a(AdCard.f fVar) {
    }

    public void onChangeSkinType() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final <T> T Gs(int i) {
        return (T) this.mRootView.findViewById(i);
    }

    public void dop() {
        this.mRootView.setVisibility(0);
        if (this.lIi != null) {
            this.lIi.Gl(303);
            com.baidu.tieba.recapp.report.d.doi().a(this.lIi);
        }
    }

    public void doq() {
        this.mRootView.setVisibility(8);
    }

    public void e(com.baidu.tieba.recapp.report.c cVar) {
        this.lIi = cVar;
    }

    public void c(com.baidu.tieba.lego.card.b.b bVar) {
        this.lIk = bVar;
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        this.efn = tbPageContext;
    }

    public void setDownloadAppCallback(com.baidu.tieba.lego.card.c cVar) {
    }

    public void setTimeoutListener(CountDownTextView.b bVar) {
    }

    public void vp(boolean z) {
    }

    public void setAdvertAppInfo(AdvertAppInfo advertAppInfo) {
        this.lIj = advertAppInfo;
    }
}
