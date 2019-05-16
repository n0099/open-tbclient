package com.baidu.tieba.recapp.e;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.widget.CountDownTextView;
/* loaded from: classes3.dex */
public class e {
    protected final String iFs;
    protected com.baidu.tieba.recapp.report.b iFt;
    protected AdvertAppInfo iFu;
    protected com.baidu.tieba.lego.card.b.b iFv;
    public TbPageContext mContext;
    protected final View mRootView;

    public e(View view, String str) {
        this.mRootView = view;
        this.iFs = str;
    }

    public void a(AdCard.f fVar) {
    }

    public void onChangeSkinType() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final <T> T zg(int i) {
        return (T) this.mRootView.findViewById(i);
    }

    public void cfI() {
        this.mRootView.setVisibility(0);
        if (this.iFt != null) {
            this.iFt.yZ(303);
            com.baidu.tieba.recapp.report.c.cfE().a(this.iFt);
        }
    }

    public void cfJ() {
        this.mRootView.setVisibility(8);
    }

    public void e(com.baidu.tieba.recapp.report.b bVar) {
        this.iFt = bVar;
    }

    public void c(com.baidu.tieba.lego.card.b.b bVar) {
        this.iFv = bVar;
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
        this.iFu = advertAppInfo;
    }
}
