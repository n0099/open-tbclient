package com.baidu.tieba.recapp.e;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.widget.CountDownTextView;
/* loaded from: classes13.dex */
public class e {
    public TbPageContext cVv;
    protected final String jNY;
    protected com.baidu.tieba.recapp.report.b jNZ;
    protected AdvertAppInfo jOa;
    protected com.baidu.tieba.lego.card.b.b jOb;
    protected final View mRootView;

    public e(View view, String str) {
        this.mRootView = view;
        this.jNY = str;
    }

    public void a(AdCard.f fVar) {
    }

    public void onChangeSkinType() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final <T> T Bn(int i) {
        return (T) this.mRootView.findViewById(i);
    }

    public void cDR() {
        this.mRootView.setVisibility(0);
        if (this.jNZ != null) {
            this.jNZ.Bg(303);
            com.baidu.tieba.recapp.report.c.cDK().a(this.jNZ);
        }
    }

    public void cDS() {
        this.mRootView.setVisibility(8);
    }

    public void e(com.baidu.tieba.recapp.report.b bVar) {
        this.jNZ = bVar;
    }

    public void c(com.baidu.tieba.lego.card.b.b bVar) {
        this.jOb = bVar;
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        this.cVv = tbPageContext;
    }

    public void setDownloadAppCallback(com.baidu.tieba.lego.card.c cVar) {
    }

    public void setTimeoutListener(CountDownTextView.b bVar) {
    }

    public void sk(boolean z) {
    }

    public void setAdvertAppInfo(AdvertAppInfo advertAppInfo) {
        this.jOa = advertAppInfo;
    }
}
