package com.baidu.tieba.recapp.e;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.widget.CountDownTextView;
/* loaded from: classes3.dex */
public class e {
    protected final String iMR;
    protected com.baidu.tieba.recapp.report.b iMS;
    protected AdvertAppInfo iMT;
    protected com.baidu.tieba.lego.card.b.b iMU;
    public TbPageContext mContext;
    protected final View mRootView;

    public e(View view, String str) {
        this.mRootView = view;
        this.iMR = str;
    }

    public void a(AdCard.f fVar) {
    }

    public void onChangeSkinType() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final <T> T zN(int i) {
        return (T) this.mRootView.findViewById(i);
    }

    public void ciU() {
        this.mRootView.setVisibility(0);
        if (this.iMS != null) {
            this.iMS.zG(303);
            com.baidu.tieba.recapp.report.c.ciQ().a(this.iMS);
        }
    }

    public void ciV() {
        this.mRootView.setVisibility(8);
    }

    public void e(com.baidu.tieba.recapp.report.b bVar) {
        this.iMS = bVar;
    }

    public void c(com.baidu.tieba.lego.card.b.b bVar) {
        this.iMU = bVar;
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        this.mContext = tbPageContext;
    }

    public void setDownloadAppCallback(com.baidu.tieba.lego.card.c cVar) {
    }

    public void setTimeoutListener(CountDownTextView.b bVar) {
    }

    public void qu(boolean z) {
    }

    public void setAdvertAppInfo(AdvertAppInfo advertAppInfo) {
        this.iMT = advertAppInfo;
    }
}
