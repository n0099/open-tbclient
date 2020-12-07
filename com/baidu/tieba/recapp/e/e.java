package com.baidu.tieba.recapp.e;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.widget.CountDownTextView;
/* loaded from: classes26.dex */
public class e {
    public TbPageContext eNx;
    protected final String mNR;
    protected com.baidu.tieba.recapp.report.c mNS;
    protected AdvertAppInfo mNT;
    protected com.baidu.tieba.lego.card.b.b mNU;
    protected final View mRootView;

    public e(View view, String str) {
        this.mRootView = view;
        this.mNR = str;
    }

    public void a(AdCard.f fVar) {
    }

    public void onChangeSkinType() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final <T> T Jx(int i) {
        return (T) this.mRootView.findViewById(i);
    }

    public void dGm() {
        this.mRootView.setVisibility(0);
        if (this.mNS != null) {
            this.mNS.Jq(303);
            com.baidu.tieba.recapp.report.d.dGf().a(this.mNS);
        }
    }

    public void dGn() {
        this.mRootView.setVisibility(8);
    }

    public void e(com.baidu.tieba.recapp.report.c cVar) {
        this.mNS = cVar;
    }

    public void c(com.baidu.tieba.lego.card.b.b bVar) {
        this.mNU = bVar;
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        this.eNx = tbPageContext;
    }

    public void setDownloadAppCallback(com.baidu.tieba.lego.card.c cVar) {
    }

    public void setTimeoutListener(CountDownTextView.b bVar) {
    }

    public void xn(boolean z) {
    }

    public void setAdvertAppInfo(AdvertAppInfo advertAppInfo) {
        this.mNT = advertAppInfo;
    }
}
