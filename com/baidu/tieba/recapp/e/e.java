package com.baidu.tieba.recapp.e;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.widget.CountDownTextView;
/* loaded from: classes20.dex */
public class e {
    public TbPageContext efr;
    protected final String lIu;
    protected com.baidu.tieba.recapp.report.c lIv;
    protected AdvertAppInfo lIw;
    protected com.baidu.tieba.lego.card.b.b lIx;
    protected final View mRootView;

    public e(View view, String str) {
        this.mRootView = view;
        this.lIu = str;
    }

    public void a(AdCard.f fVar) {
    }

    public void onChangeSkinType() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final <T> T Gs(int i) {
        return (T) this.mRootView.findViewById(i);
    }

    public void dos() {
        this.mRootView.setVisibility(0);
        if (this.lIv != null) {
            this.lIv.Gl(303);
            com.baidu.tieba.recapp.report.d.dol().a(this.lIv);
        }
    }

    public void dot() {
        this.mRootView.setVisibility(8);
    }

    public void e(com.baidu.tieba.recapp.report.c cVar) {
        this.lIv = cVar;
    }

    public void c(com.baidu.tieba.lego.card.b.b bVar) {
        this.lIx = bVar;
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        this.efr = tbPageContext;
    }

    public void setDownloadAppCallback(com.baidu.tieba.lego.card.c cVar) {
    }

    public void setTimeoutListener(CountDownTextView.b bVar) {
    }

    public void vr(boolean z) {
    }

    public void setAdvertAppInfo(AdvertAppInfo advertAppInfo) {
        this.lIw = advertAppInfo;
    }
}
