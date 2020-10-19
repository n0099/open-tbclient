package com.baidu.tieba.recapp.e;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.widget.CountDownTextView;
/* loaded from: classes26.dex */
public class e {
    public TbPageContext etO;
    protected final View mRootView;
    protected final String mgG;
    protected com.baidu.tieba.recapp.report.c mgH;
    protected AdvertAppInfo mgI;
    protected com.baidu.tieba.lego.card.b.b mgJ;

    public e(View view, String str) {
        this.mRootView = view;
        this.mgG = str;
    }

    public void a(AdCard.f fVar) {
    }

    public void onChangeSkinType() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final <T> T Hz(int i) {
        return (T) this.mRootView.findViewById(i);
    }

    public void dvN() {
        this.mRootView.setVisibility(0);
        if (this.mgH != null) {
            this.mgH.Hs(303);
            com.baidu.tieba.recapp.report.d.dvG().a(this.mgH);
        }
    }

    public void dvO() {
        this.mRootView.setVisibility(8);
    }

    public void e(com.baidu.tieba.recapp.report.c cVar) {
        this.mgH = cVar;
    }

    public void c(com.baidu.tieba.lego.card.b.b bVar) {
        this.mgJ = bVar;
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        this.etO = tbPageContext;
    }

    public void setDownloadAppCallback(com.baidu.tieba.lego.card.c cVar) {
    }

    public void setTimeoutListener(CountDownTextView.b bVar) {
    }

    public void wg(boolean z) {
    }

    public void setAdvertAppInfo(AdvertAppInfo advertAppInfo) {
        this.mgI = advertAppInfo;
    }
}
