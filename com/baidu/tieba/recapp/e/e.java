package com.baidu.tieba.recapp.e;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.widget.CountDownTextView;
/* loaded from: classes11.dex */
public class e {
    public TbPageContext cRe;
    protected final String jLh;
    protected com.baidu.tieba.recapp.report.b jLi;
    protected AdvertAppInfo jLj;
    protected com.baidu.tieba.lego.card.b.b jLk;
    protected final View mRootView;

    public e(View view, String str) {
        this.mRootView = view;
        this.jLh = str;
    }

    public void a(AdCard.f fVar) {
    }

    public void onChangeSkinType() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final <T> T AW(int i) {
        return (T) this.mRootView.findViewById(i);
    }

    public void cBW() {
        this.mRootView.setVisibility(0);
        if (this.jLi != null) {
            this.jLi.AP(303);
            com.baidu.tieba.recapp.report.c.cBP().a(this.jLi);
        }
    }

    public void cBX() {
        this.mRootView.setVisibility(8);
    }

    public void e(com.baidu.tieba.recapp.report.b bVar) {
        this.jLi = bVar;
    }

    public void c(com.baidu.tieba.lego.card.b.b bVar) {
        this.jLk = bVar;
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        this.cRe = tbPageContext;
    }

    public void setDownloadAppCallback(com.baidu.tieba.lego.card.c cVar) {
    }

    public void setTimeoutListener(CountDownTextView.b bVar) {
    }

    public void sb(boolean z) {
    }

    public void setAdvertAppInfo(AdvertAppInfo advertAppInfo) {
        this.jLj = advertAppInfo;
    }
}
