package com.baidu.tieba.recapp.e;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.recapp.lego.model.AdCard;
/* loaded from: classes3.dex */
public class d {
    public TbPageContext aRG;
    protected AdvertAppInfo gHA;
    protected final String gHy;
    protected com.baidu.tieba.recapp.report.a gHz;
    protected final View mRootView;

    public d(View view, String str) {
        this.mRootView = view;
        this.gHy = str;
    }

    public void a(AdCard.e eVar) {
    }

    public void onChangeSkinType() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final <T> T uy(int i) {
        return (T) this.mRootView.findViewById(i);
    }

    public void bpb() {
        this.mRootView.setVisibility(0);
        if (this.gHz != null) {
            this.gHz.us(303);
            com.baidu.tieba.recapp.report.b.boW().a(this.gHz);
        }
    }

    public void bpc() {
        this.mRootView.setVisibility(8);
    }

    public void e(com.baidu.tieba.recapp.report.a aVar) {
        this.gHz = aVar;
    }

    public void setAdvertAppInfo(AdvertAppInfo advertAppInfo) {
        this.gHA = advertAppInfo;
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        this.aRG = tbPageContext;
    }

    public void setDownloadAppCallback(com.baidu.tieba.lego.card.c cVar) {
    }
}
