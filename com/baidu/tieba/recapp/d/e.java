package com.baidu.tieba.recapp.d;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.widget.CountDownTextView;
/* loaded from: classes7.dex */
public class e {
    public TbPageContext eWx;
    protected final View mRootView;
    protected final String nau;
    protected com.baidu.tieba.recapp.report.c nav;
    protected AdvertAppInfo naw;
    protected com.baidu.tieba.lego.card.a.b nax;

    public e(View view, String str) {
        this.mRootView = view;
        this.nau = str;
    }

    public void a(AdCard.g gVar) {
    }

    public void onChangeSkinType() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final <T> T Ih(int i) {
        return (T) this.mRootView.findViewById(i);
    }

    public void dEJ() {
        this.mRootView.setVisibility(0);
        if (this.nav != null) {
            this.nav.Ia(303);
            com.baidu.tieba.recapp.report.e.dEC().a(this.nav);
        }
    }

    public void dEK() {
        this.mRootView.setVisibility(8);
    }

    public void e(com.baidu.tieba.recapp.report.c cVar) {
        this.nav = cVar;
    }

    public void c(com.baidu.tieba.lego.card.a.b bVar) {
        this.nax = bVar;
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        this.eWx = tbPageContext;
    }

    public void setDownloadAppCallback(com.baidu.tieba.lego.card.c cVar) {
    }

    public void setTimeoutListener(CountDownTextView.b bVar) {
    }

    public void xD(boolean z) {
    }

    public void setAdvertAppInfo(AdvertAppInfo advertAppInfo) {
        this.naw = advertAppInfo;
    }
}
