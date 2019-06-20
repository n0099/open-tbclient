package com.baidu.tieba.recapp.e;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.widget.CountDownTextView;
/* loaded from: classes3.dex */
public class e {
    protected final String iFv;
    protected com.baidu.tieba.recapp.report.b iFw;
    protected AdvertAppInfo iFx;
    protected com.baidu.tieba.lego.card.b.b iFy;
    public TbPageContext mContext;
    protected final View mRootView;

    public e(View view, String str) {
        this.mRootView = view;
        this.iFv = str;
    }

    public void a(AdCard.f fVar) {
    }

    public void onChangeSkinType() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final <T> T zg(int i) {
        return (T) this.mRootView.findViewById(i);
    }

    public void cfL() {
        this.mRootView.setVisibility(0);
        if (this.iFw != null) {
            this.iFw.yZ(303);
            com.baidu.tieba.recapp.report.c.cfH().a(this.iFw);
        }
    }

    public void cfM() {
        this.mRootView.setVisibility(8);
    }

    public void e(com.baidu.tieba.recapp.report.b bVar) {
        this.iFw = bVar;
    }

    public void c(com.baidu.tieba.lego.card.b.b bVar) {
        this.iFy = bVar;
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        this.mContext = tbPageContext;
    }

    public void setDownloadAppCallback(com.baidu.tieba.lego.card.c cVar) {
    }

    public void setTimeoutListener(CountDownTextView.b bVar) {
    }

    public void qe(boolean z) {
    }

    public void setAdvertAppInfo(AdvertAppInfo advertAppInfo) {
        this.iFx = advertAppInfo;
    }
}
