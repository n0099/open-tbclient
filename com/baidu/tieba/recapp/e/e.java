package com.baidu.tieba.recapp.e;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.widget.CountDownTextView;
/* loaded from: classes25.dex */
public class e {
    public TbPageContext ehG;
    protected final String lRo;
    protected com.baidu.tieba.recapp.report.c lRp;
    protected AdvertAppInfo lRq;
    protected com.baidu.tieba.lego.card.b.b lRr;
    protected final View mRootView;

    public e(View view, String str) {
        this.mRootView = view;
        this.lRo = str;
    }

    public void a(AdCard.f fVar) {
    }

    public void onChangeSkinType() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final <T> T GT(int i) {
        return (T) this.mRootView.findViewById(i);
    }

    public void dsc() {
        this.mRootView.setVisibility(0);
        if (this.lRp != null) {
            this.lRp.GM(303);
            com.baidu.tieba.recapp.report.d.drV().a(this.lRp);
        }
    }

    public void dsd() {
        this.mRootView.setVisibility(8);
    }

    public void e(com.baidu.tieba.recapp.report.c cVar) {
        this.lRp = cVar;
    }

    public void c(com.baidu.tieba.lego.card.b.b bVar) {
        this.lRr = bVar;
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        this.ehG = tbPageContext;
    }

    public void setDownloadAppCallback(com.baidu.tieba.lego.card.c cVar) {
    }

    public void setTimeoutListener(CountDownTextView.b bVar) {
    }

    public void vz(boolean z) {
    }

    public void setAdvertAppInfo(AdvertAppInfo advertAppInfo) {
        this.lRq = advertAppInfo;
    }
}
