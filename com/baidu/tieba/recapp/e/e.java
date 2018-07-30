package com.baidu.tieba.recapp.e;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.widget.CountDownTextView;
/* loaded from: classes3.dex */
public class e {
    protected final String gup;
    protected com.baidu.tieba.recapp.report.b guq;
    protected AdvertAppInfo gur;
    protected com.baidu.tieba.lego.card.b.b gus;
    public TbPageContext mContext;
    protected final View mRootView;

    public e(View view, String str) {
        this.mRootView = view;
        this.gup = str;
    }

    public void a(AdCard.f fVar) {
    }

    public void onChangeSkinType() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final <T> T sr(int i) {
        return (T) this.mRootView.findViewById(i);
    }

    public void bom() {
        this.mRootView.setVisibility(0);
        if (this.guq != null) {
            this.guq.sl(303);
            com.baidu.tieba.recapp.report.c.boi().a(this.guq);
        }
    }

    public void bon() {
        this.mRootView.setVisibility(8);
    }

    public void e(com.baidu.tieba.recapp.report.b bVar) {
        this.guq = bVar;
    }

    public void c(com.baidu.tieba.lego.card.b.b bVar) {
        this.gus = bVar;
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        this.mContext = tbPageContext;
    }

    public void setDownloadAppCallback(com.baidu.tieba.lego.card.c cVar) {
    }

    public void setTimeoutListener(CountDownTextView.b bVar) {
    }

    public void lH(boolean z) {
    }

    public void setAdvertAppInfo(AdvertAppInfo advertAppInfo) {
        this.gur = advertAppInfo;
    }
}
