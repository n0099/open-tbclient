package com.baidu.tieba.recapp.e;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.widget.CountDownTextView;
/* loaded from: classes3.dex */
public class e {
    public TbPageContext adf;
    protected final String gcO;
    protected com.baidu.tieba.recapp.report.a gcP;
    protected AdvertAppInfo gcQ;
    protected final View mRootView;

    public e(View view2, String str) {
        this.mRootView = view2;
        this.gcO = str;
    }

    public void a(AdCard.f fVar) {
    }

    public void onChangeSkinType() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final <T> T rZ(int i) {
        return (T) this.mRootView.findViewById(i);
    }

    public void bkj() {
        this.mRootView.setVisibility(0);
        if (this.gcP != null) {
            this.gcP.rT(303);
            com.baidu.tieba.recapp.report.b.bke().a(this.gcP);
        }
    }

    public void bkk() {
        this.mRootView.setVisibility(8);
    }

    public void e(com.baidu.tieba.recapp.report.a aVar) {
        this.gcP = aVar;
    }

    public void setAdvertAppInfo(AdvertAppInfo advertAppInfo) {
        this.gcQ = advertAppInfo;
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        this.adf = tbPageContext;
    }

    public void setDownloadAppCallback(com.baidu.tieba.lego.card.c cVar) {
    }

    public void setTimeoutListener(CountDownTextView.b bVar) {
    }

    public void lF(boolean z) {
    }
}
