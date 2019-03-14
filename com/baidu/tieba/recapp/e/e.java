package com.baidu.tieba.recapp.e;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.widget.CountDownTextView;
/* loaded from: classes3.dex */
public class e {
    protected final String imU;
    protected com.baidu.tieba.recapp.report.b imV;
    protected AdvertAppInfo imW;
    protected com.baidu.tieba.lego.card.b.b imX;
    public TbPageContext mContext;
    protected final View mRootView;

    public e(View view, String str) {
        this.mRootView = view;
        this.imU = str;
    }

    public void a(AdCard.f fVar) {
    }

    public void onChangeSkinType() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final <T> T yd(int i) {
        return (T) this.mRootView.findViewById(i);
    }

    public void bXI() {
        this.mRootView.setVisibility(0);
        if (this.imV != null) {
            this.imV.xW(303);
            com.baidu.tieba.recapp.report.c.bXE().a(this.imV);
        }
    }

    public void bXJ() {
        this.mRootView.setVisibility(8);
    }

    public void e(com.baidu.tieba.recapp.report.b bVar) {
        this.imV = bVar;
    }

    public void c(com.baidu.tieba.lego.card.b.b bVar) {
        this.imX = bVar;
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
        this.imW = advertAppInfo;
    }
}
