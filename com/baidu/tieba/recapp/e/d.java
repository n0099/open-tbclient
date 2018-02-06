package com.baidu.tieba.recapp.e;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.recapp.lego.model.AdCard;
/* loaded from: classes3.dex */
public class d {
    public TbPageContext aRR;
    protected final String gHN;
    protected com.baidu.tieba.recapp.report.a gHO;
    protected AdvertAppInfo gHP;
    protected final View mRootView;

    public d(View view, String str) {
        this.mRootView = view;
        this.gHN = str;
    }

    public void a(AdCard.e eVar) {
    }

    public void onChangeSkinType() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final <T> T ux(int i) {
        return (T) this.mRootView.findViewById(i);
    }

    public void bpc() {
        this.mRootView.setVisibility(0);
        if (this.gHO != null) {
            this.gHO.ur(303);
            com.baidu.tieba.recapp.report.b.boX().a(this.gHO);
        }
    }

    public void bpd() {
        this.mRootView.setVisibility(8);
    }

    public void e(com.baidu.tieba.recapp.report.a aVar) {
        this.gHO = aVar;
    }

    public void setAdvertAppInfo(AdvertAppInfo advertAppInfo) {
        this.gHP = advertAppInfo;
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        this.aRR = tbPageContext;
    }

    public void setDownloadAppCallback(com.baidu.tieba.lego.card.c cVar) {
    }
}
