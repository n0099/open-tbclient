package com.baidu.tieba.recapp.e;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.widget.CountDownTextView;
/* loaded from: classes13.dex */
public class e {
    public TbPageContext duK;
    protected final String kxw;
    protected com.baidu.tieba.recapp.report.c kxx;
    protected AdvertAppInfo kxy;
    protected com.baidu.tieba.lego.card.b.b kxz;
    protected final View mRootView;

    public e(View view, String str) {
        this.mRootView = view;
        this.kxw = str;
    }

    public void a(AdCard.f fVar) {
    }

    public void onChangeSkinType() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final <T> T BN(int i) {
        return (T) this.mRootView.findViewById(i);
    }

    public void cOq() {
        this.mRootView.setVisibility(0);
        if (this.kxx != null) {
            this.kxx.BG(303);
            com.baidu.tieba.recapp.report.d.cOj().a(this.kxx);
        }
    }

    public void cOr() {
        this.mRootView.setVisibility(8);
    }

    public void e(com.baidu.tieba.recapp.report.c cVar) {
        this.kxx = cVar;
    }

    public void c(com.baidu.tieba.lego.card.b.b bVar) {
        this.kxz = bVar;
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        this.duK = tbPageContext;
    }

    public void setDownloadAppCallback(com.baidu.tieba.lego.card.c cVar) {
    }

    public void setTimeoutListener(CountDownTextView.b bVar) {
    }

    public void tl(boolean z) {
    }

    public void setAdvertAppInfo(AdvertAppInfo advertAppInfo) {
        this.kxy = advertAppInfo;
    }
}
