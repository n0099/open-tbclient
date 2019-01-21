package com.baidu.tieba.recapp.e;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.widget.CountDownTextView;
/* loaded from: classes3.dex */
public class e {
    protected com.baidu.tieba.recapp.report.b gVA;
    protected AdvertAppInfo gVB;
    protected com.baidu.tieba.lego.card.b.b gVC;
    protected final String gVz;
    public TbPageContext mContext;
    protected final View mRootView;

    public e(View view, String str) {
        this.mRootView = view;
        this.gVz = str;
    }

    public void a(AdCard.f fVar) {
    }

    public void onChangeSkinType() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final <T> T up(int i) {
        return (T) this.mRootView.findViewById(i);
    }

    public void bwS() {
        this.mRootView.setVisibility(0);
        if (this.gVA != null) {
            this.gVA.uj(303);
            com.baidu.tieba.recapp.report.c.bwO().a(this.gVA);
        }
    }

    public void bwT() {
        this.mRootView.setVisibility(8);
    }

    public void e(com.baidu.tieba.recapp.report.b bVar) {
        this.gVA = bVar;
    }

    public void c(com.baidu.tieba.lego.card.b.b bVar) {
        this.gVC = bVar;
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        this.mContext = tbPageContext;
    }

    public void setDownloadAppCallback(com.baidu.tieba.lego.card.c cVar) {
    }

    public void setTimeoutListener(CountDownTextView.b bVar) {
    }

    public void mQ(boolean z) {
    }

    public void setAdvertAppInfo(AdvertAppInfo advertAppInfo) {
        this.gVB = advertAppInfo;
    }
}
