package com.baidu.tieba.recapp.e;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.widget.CountDownTextView;
/* loaded from: classes3.dex */
public class e {
    protected final String gdR;
    protected com.baidu.tieba.recapp.report.a gdS;
    protected AdvertAppInfo gdT;
    public TbPageContext mContext;
    protected final View mRootView;

    public e(View view2, String str) {
        this.mRootView = view2;
        this.gdR = str;
    }

    public void a(AdCard.f fVar) {
    }

    public void onChangeSkinType() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final <T> T rX(int i) {
        return (T) this.mRootView.findViewById(i);
    }

    public void bki() {
        this.mRootView.setVisibility(0);
        if (this.gdS != null) {
            this.gdS.rR(303);
            com.baidu.tieba.recapp.report.b.bkd().a(this.gdS);
        }
    }

    public void bkj() {
        this.mRootView.setVisibility(8);
    }

    public void e(com.baidu.tieba.recapp.report.a aVar) {
        this.gdS = aVar;
    }

    public void setAdvertAppInfo(AdvertAppInfo advertAppInfo) {
        this.gdT = advertAppInfo;
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        this.mContext = tbPageContext;
    }

    public void setDownloadAppCallback(com.baidu.tieba.lego.card.c cVar) {
    }

    public void setTimeoutListener(CountDownTextView.b bVar) {
    }

    public void lG(boolean z) {
    }
}
