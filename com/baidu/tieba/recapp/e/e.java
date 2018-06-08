package com.baidu.tieba.recapp.e;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.widget.CountDownTextView;
/* loaded from: classes3.dex */
public class e {
    protected final String gpk;
    protected com.baidu.tieba.recapp.report.a gpl;
    protected AdvertAppInfo gpm;
    protected com.baidu.tieba.lego.card.b.b gpn;
    public TbPageContext mContext;
    protected final View mRootView;

    public e(View view, String str) {
        this.mRootView = view;
        this.gpk = str;
    }

    public void a(AdCard.f fVar) {
    }

    public void onChangeSkinType() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final <T> T sj(int i) {
        return (T) this.mRootView.findViewById(i);
    }

    public void bpg() {
        this.mRootView.setVisibility(0);
        if (this.gpl != null) {
            this.gpl.sd(303);
            com.baidu.tieba.recapp.report.b.bpc().a(this.gpl);
        }
    }

    public void bph() {
        this.mRootView.setVisibility(8);
    }

    public void e(com.baidu.tieba.recapp.report.a aVar) {
        this.gpl = aVar;
    }

    public void c(com.baidu.tieba.lego.card.b.b bVar) {
        this.gpn = bVar;
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        this.mContext = tbPageContext;
    }

    public void setDownloadAppCallback(com.baidu.tieba.lego.card.c cVar) {
    }

    public void setTimeoutListener(CountDownTextView.b bVar) {
    }

    public void lM(boolean z) {
    }

    public void setAdvertAppInfo(AdvertAppInfo advertAppInfo) {
        this.gpm = advertAppInfo;
    }
}
