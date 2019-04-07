package com.baidu.tieba.recapp.e;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.widget.CountDownTextView;
/* loaded from: classes3.dex */
public class e {
    protected final String imG;
    protected com.baidu.tieba.recapp.report.b imH;
    protected AdvertAppInfo imI;
    protected com.baidu.tieba.lego.card.b.b imJ;
    public TbPageContext mContext;
    protected final View mRootView;

    public e(View view, String str) {
        this.mRootView = view;
        this.imG = str;
    }

    public void a(AdCard.f fVar) {
    }

    public void onChangeSkinType() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final <T> T xZ(int i) {
        return (T) this.mRootView.findViewById(i);
    }

    public void bXE() {
        this.mRootView.setVisibility(0);
        if (this.imH != null) {
            this.imH.xS(303);
            com.baidu.tieba.recapp.report.c.bXA().a(this.imH);
        }
    }

    public void bXF() {
        this.mRootView.setVisibility(8);
    }

    public void e(com.baidu.tieba.recapp.report.b bVar) {
        this.imH = bVar;
    }

    public void c(com.baidu.tieba.lego.card.b.b bVar) {
        this.imJ = bVar;
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        this.mContext = tbPageContext;
    }

    public void setDownloadAppCallback(com.baidu.tieba.lego.card.c cVar) {
    }

    public void setTimeoutListener(CountDownTextView.b bVar) {
    }

    public void pp(boolean z) {
    }

    public void setAdvertAppInfo(AdvertAppInfo advertAppInfo) {
        this.imI = advertAppInfo;
    }
}
