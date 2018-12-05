package com.baidu.tieba.recapp.e;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.widget.CountDownTextView;
/* loaded from: classes3.dex */
public class e {
    protected final String gRB;
    protected com.baidu.tieba.recapp.report.b gRC;
    protected AdvertAppInfo gRD;
    protected com.baidu.tieba.lego.card.b.b gRE;
    public TbPageContext mContext;
    protected final View mRootView;

    public e(View view, String str) {
        this.mRootView = view;
        this.gRB = str;
    }

    public void a(AdCard.f fVar) {
    }

    public void onChangeSkinType() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final <T> T tZ(int i) {
        return (T) this.mRootView.findViewById(i);
    }

    public void bvy() {
        this.mRootView.setVisibility(0);
        if (this.gRC != null) {
            this.gRC.tT(303);
            com.baidu.tieba.recapp.report.c.bvu().a(this.gRC);
        }
    }

    public void bvz() {
        this.mRootView.setVisibility(8);
    }

    public void e(com.baidu.tieba.recapp.report.b bVar) {
        this.gRC = bVar;
    }

    public void c(com.baidu.tieba.lego.card.b.b bVar) {
        this.gRE = bVar;
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        this.mContext = tbPageContext;
    }

    public void setDownloadAppCallback(com.baidu.tieba.lego.card.c cVar) {
    }

    public void setTimeoutListener(CountDownTextView.b bVar) {
    }

    public void mM(boolean z) {
    }

    public void setAdvertAppInfo(AdvertAppInfo advertAppInfo) {
        this.gRD = advertAppInfo;
    }
}
