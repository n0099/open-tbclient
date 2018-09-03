package com.baidu.tieba.recapp.e;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.widget.CountDownTextView;
/* loaded from: classes3.dex */
public class e {
    protected final String gus;
    protected com.baidu.tieba.recapp.report.b gut;
    protected AdvertAppInfo guu;
    protected com.baidu.tieba.lego.card.b.b guv;
    public TbPageContext mContext;
    protected final View mRootView;

    public e(View view, String str) {
        this.mRootView = view;
        this.gus = str;
    }

    public void a(AdCard.f fVar) {
    }

    public void onChangeSkinType() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final <T> T sr(int i) {
        return (T) this.mRootView.findViewById(i);
    }

    public void bon() {
        this.mRootView.setVisibility(0);
        if (this.gut != null) {
            this.gut.sl(303);
            com.baidu.tieba.recapp.report.c.boj().a(this.gut);
        }
    }

    public void boo() {
        this.mRootView.setVisibility(8);
    }

    public void e(com.baidu.tieba.recapp.report.b bVar) {
        this.gut = bVar;
    }

    public void c(com.baidu.tieba.lego.card.b.b bVar) {
        this.guv = bVar;
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
        this.guu = advertAppInfo;
    }
}
