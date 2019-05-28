package com.baidu.tieba.recapp.e;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.widget.CountDownTextView;
/* loaded from: classes3.dex */
public class e {
    protected final String iFu;
    protected com.baidu.tieba.recapp.report.b iFv;
    protected AdvertAppInfo iFw;
    protected com.baidu.tieba.lego.card.b.b iFx;
    public TbPageContext mContext;
    protected final View mRootView;

    public e(View view, String str) {
        this.mRootView = view;
        this.iFu = str;
    }

    public void a(AdCard.f fVar) {
    }

    public void onChangeSkinType() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final <T> T zg(int i) {
        return (T) this.mRootView.findViewById(i);
    }

    public void cfK() {
        this.mRootView.setVisibility(0);
        if (this.iFv != null) {
            this.iFv.yZ(303);
            com.baidu.tieba.recapp.report.c.cfG().a(this.iFv);
        }
    }

    public void cfL() {
        this.mRootView.setVisibility(8);
    }

    public void e(com.baidu.tieba.recapp.report.b bVar) {
        this.iFv = bVar;
    }

    public void c(com.baidu.tieba.lego.card.b.b bVar) {
        this.iFx = bVar;
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        this.mContext = tbPageContext;
    }

    public void setDownloadAppCallback(com.baidu.tieba.lego.card.c cVar) {
    }

    public void setTimeoutListener(CountDownTextView.b bVar) {
    }

    public void qd(boolean z) {
    }

    public void setAdvertAppInfo(AdvertAppInfo advertAppInfo) {
        this.iFw = advertAppInfo;
    }
}
