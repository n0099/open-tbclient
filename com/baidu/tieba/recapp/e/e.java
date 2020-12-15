package com.baidu.tieba.recapp.e;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.widget.CountDownTextView;
/* loaded from: classes26.dex */
public class e {
    public TbPageContext eNx;
    protected final String mNT;
    protected com.baidu.tieba.recapp.report.c mNU;
    protected AdvertAppInfo mNV;
    protected com.baidu.tieba.lego.card.b.b mNW;
    protected final View mRootView;

    public e(View view, String str) {
        this.mRootView = view;
        this.mNT = str;
    }

    public void a(AdCard.f fVar) {
    }

    public void onChangeSkinType() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final <T> T Jx(int i) {
        return (T) this.mRootView.findViewById(i);
    }

    public void dGn() {
        this.mRootView.setVisibility(0);
        if (this.mNU != null) {
            this.mNU.Jq(303);
            com.baidu.tieba.recapp.report.d.dGg().a(this.mNU);
        }
    }

    public void dGo() {
        this.mRootView.setVisibility(8);
    }

    public void e(com.baidu.tieba.recapp.report.c cVar) {
        this.mNU = cVar;
    }

    public void c(com.baidu.tieba.lego.card.b.b bVar) {
        this.mNW = bVar;
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
        this.mNV = advertAppInfo;
    }
}
