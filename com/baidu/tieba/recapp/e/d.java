package com.baidu.tieba.recapp.e;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.recapp.lego.model.AdCard;
/* loaded from: classes3.dex */
public class d {
    public TbPageContext aRI;
    protected final String gHO;
    protected com.baidu.tieba.recapp.report.a gHP;
    protected AdvertAppInfo gHQ;
    protected final View mRootView;

    public d(View view, String str) {
        this.mRootView = view;
        this.gHO = str;
    }

    public void a(AdCard.e eVar) {
    }

    public void onChangeSkinType() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final <T> T uy(int i) {
        return (T) this.mRootView.findViewById(i);
    }

    public void bpc() {
        this.mRootView.setVisibility(0);
        if (this.gHP != null) {
            this.gHP.us(303);
            com.baidu.tieba.recapp.report.b.boX().a(this.gHP);
        }
    }

    public void bpd() {
        this.mRootView.setVisibility(8);
    }

    public void e(com.baidu.tieba.recapp.report.a aVar) {
        this.gHP = aVar;
    }

    public void setAdvertAppInfo(AdvertAppInfo advertAppInfo) {
        this.gHQ = advertAppInfo;
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        this.aRI = tbPageContext;
    }

    public void setDownloadAppCallback(com.baidu.tieba.lego.card.c cVar) {
    }
}
