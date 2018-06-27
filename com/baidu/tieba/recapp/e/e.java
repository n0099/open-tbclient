package com.baidu.tieba.recapp.e;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.widget.CountDownTextView;
/* loaded from: classes3.dex */
public class e {
    protected final String gtc;
    protected com.baidu.tieba.recapp.report.a gtd;
    protected AdvertAppInfo gte;
    protected com.baidu.tieba.lego.card.b.b gtf;
    public TbPageContext mContext;
    protected final View mRootView;

    public e(View view, String str) {
        this.mRootView = view;
        this.gtc = str;
    }

    public void a(AdCard.f fVar) {
    }

    public void onChangeSkinType() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final <T> T st(int i) {
        return (T) this.mRootView.findViewById(i);
    }

    public void bpH() {
        this.mRootView.setVisibility(0);
        if (this.gtd != null) {
            this.gtd.sn(303);
            com.baidu.tieba.recapp.report.b.bpD().a(this.gtd);
        }
    }

    public void bpI() {
        this.mRootView.setVisibility(8);
    }

    public void e(com.baidu.tieba.recapp.report.a aVar) {
        this.gtd = aVar;
    }

    public void c(com.baidu.tieba.lego.card.b.b bVar) {
        this.gtf = bVar;
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        this.mContext = tbPageContext;
    }

    public void setDownloadAppCallback(com.baidu.tieba.lego.card.c cVar) {
    }

    public void setTimeoutListener(CountDownTextView.b bVar) {
    }

    public void lW(boolean z) {
    }

    public void setAdvertAppInfo(AdvertAppInfo advertAppInfo) {
        this.gte = advertAppInfo;
    }
}
