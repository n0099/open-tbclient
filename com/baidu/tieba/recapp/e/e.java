package com.baidu.tieba.recapp.e;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.widget.CountDownTextView;
/* loaded from: classes3.dex */
public class e {
    protected final String iPn;
    protected com.baidu.tieba.recapp.report.b iPo;
    protected AdvertAppInfo iPp;
    protected com.baidu.tieba.lego.card.b.b iPq;
    public TbPageContext mContext;
    protected final View mRootView;

    public e(View view, String str) {
        this.mRootView = view;
        this.iPn = str;
    }

    public void a(AdCard.f fVar) {
    }

    public void onChangeSkinType() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final <T> T zQ(int i) {
        return (T) this.mRootView.findViewById(i);
    }

    public void cjI() {
        this.mRootView.setVisibility(0);
        if (this.iPo != null) {
            this.iPo.zJ(303);
            com.baidu.tieba.recapp.report.c.cjE().a(this.iPo);
        }
    }

    public void cjJ() {
        this.mRootView.setVisibility(8);
    }

    public void e(com.baidu.tieba.recapp.report.b bVar) {
        this.iPo = bVar;
    }

    public void c(com.baidu.tieba.lego.card.b.b bVar) {
        this.iPq = bVar;
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        this.mContext = tbPageContext;
    }

    public void setDownloadAppCallback(com.baidu.tieba.lego.card.c cVar) {
    }

    public void setTimeoutListener(CountDownTextView.b bVar) {
    }

    public void qx(boolean z) {
    }

    public void setAdvertAppInfo(AdvertAppInfo advertAppInfo) {
        this.iPp = advertAppInfo;
    }
}
