package com.baidu.tieba.recapp.e;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.widget.CountDownTextView;
/* loaded from: classes3.dex */
public class e {
    protected final String iLN;
    protected com.baidu.tieba.recapp.report.b iLO;
    protected AdvertAppInfo iLP;
    protected com.baidu.tieba.lego.card.b.b iLQ;
    public TbPageContext mContext;
    protected final View mRootView;

    public e(View view, String str) {
        this.mRootView = view;
        this.iLN = str;
    }

    public void a(AdCard.f fVar) {
    }

    public void onChangeSkinType() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final <T> T zL(int i) {
        return (T) this.mRootView.findViewById(i);
    }

    public void ciC() {
        this.mRootView.setVisibility(0);
        if (this.iLO != null) {
            this.iLO.zE(303);
            com.baidu.tieba.recapp.report.c.ciy().a(this.iLO);
        }
    }

    public void ciD() {
        this.mRootView.setVisibility(8);
    }

    public void e(com.baidu.tieba.recapp.report.b bVar) {
        this.iLO = bVar;
    }

    public void c(com.baidu.tieba.lego.card.b.b bVar) {
        this.iLQ = bVar;
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        this.mContext = tbPageContext;
    }

    public void setDownloadAppCallback(com.baidu.tieba.lego.card.c cVar) {
    }

    public void setTimeoutListener(CountDownTextView.b bVar) {
    }

    public void qt(boolean z) {
    }

    public void setAdvertAppInfo(AdvertAppInfo advertAppInfo) {
        this.iLP = advertAppInfo;
    }
}
