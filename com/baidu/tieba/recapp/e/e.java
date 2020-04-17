package com.baidu.tieba.recapp.e;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.widget.CountDownTextView;
/* loaded from: classes13.dex */
public class e {
    public TbPageContext duG;
    protected final String kxs;
    protected com.baidu.tieba.recapp.report.c kxt;
    protected AdvertAppInfo kxu;
    protected com.baidu.tieba.lego.card.b.b kxv;
    protected final View mRootView;

    public e(View view, String str) {
        this.mRootView = view;
        this.kxs = str;
    }

    public void a(AdCard.f fVar) {
    }

    public void onChangeSkinType() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final <T> T BN(int i) {
        return (T) this.mRootView.findViewById(i);
    }

    public void cOs() {
        this.mRootView.setVisibility(0);
        if (this.kxt != null) {
            this.kxt.BG(303);
            com.baidu.tieba.recapp.report.d.cOl().a(this.kxt);
        }
    }

    public void cOt() {
        this.mRootView.setVisibility(8);
    }

    public void e(com.baidu.tieba.recapp.report.c cVar) {
        this.kxt = cVar;
    }

    public void c(com.baidu.tieba.lego.card.b.b bVar) {
        this.kxv = bVar;
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        this.duG = tbPageContext;
    }

    public void setDownloadAppCallback(com.baidu.tieba.lego.card.c cVar) {
    }

    public void setTimeoutListener(CountDownTextView.b bVar) {
    }

    public void tl(boolean z) {
    }

    public void setAdvertAppInfo(AdvertAppInfo advertAppInfo) {
        this.kxu = advertAppInfo;
    }
}
