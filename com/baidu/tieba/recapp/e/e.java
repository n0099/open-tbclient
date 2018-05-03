package com.baidu.tieba.recapp.e;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.widget.CountDownTextView;
/* loaded from: classes3.dex */
public class e {
    public TbPageContext adf;
    protected final String gcL;
    protected com.baidu.tieba.recapp.report.a gcM;
    protected AdvertAppInfo gcN;
    protected final View mRootView;

    public e(View view2, String str) {
        this.mRootView = view2;
        this.gcL = str;
    }

    public void a(AdCard.f fVar) {
    }

    public void onChangeSkinType() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final <T> T rY(int i) {
        return (T) this.mRootView.findViewById(i);
    }

    public void bkj() {
        this.mRootView.setVisibility(0);
        if (this.gcM != null) {
            this.gcM.rS(303);
            com.baidu.tieba.recapp.report.b.bke().a(this.gcM);
        }
    }

    public void bkk() {
        this.mRootView.setVisibility(8);
    }

    public void e(com.baidu.tieba.recapp.report.a aVar) {
        this.gcM = aVar;
    }

    public void setAdvertAppInfo(AdvertAppInfo advertAppInfo) {
        this.gcN = advertAppInfo;
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
