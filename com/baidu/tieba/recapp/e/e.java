package com.baidu.tieba.recapp.e;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.widget.CountDownTextView;
/* loaded from: classes3.dex */
public class e {
    protected final String gJl;
    protected com.baidu.tieba.recapp.report.b gJm;
    protected AdvertAppInfo gJn;
    protected com.baidu.tieba.lego.card.b.b gJo;
    public TbPageContext mContext;
    protected final View mRootView;

    public e(View view, String str) {
        this.mRootView = view;
        this.gJl = str;
    }

    public void a(AdCard.f fVar) {
    }

    public void onChangeSkinType() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final <T> T tm(int i) {
        return (T) this.mRootView.findViewById(i);
    }

    public void buj() {
        this.mRootView.setVisibility(0);
        if (this.gJm != null) {
            this.gJm.tg(303);
            com.baidu.tieba.recapp.report.c.buf().a(this.gJm);
        }
    }

    public void buk() {
        this.mRootView.setVisibility(8);
    }

    public void e(com.baidu.tieba.recapp.report.b bVar) {
        this.gJm = bVar;
    }

    public void c(com.baidu.tieba.lego.card.b.b bVar) {
        this.gJo = bVar;
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        this.mContext = tbPageContext;
    }

    public void setDownloadAppCallback(com.baidu.tieba.lego.card.c cVar) {
    }

    public void setTimeoutListener(CountDownTextView.b bVar) {
    }

    public void my(boolean z) {
    }

    public void setAdvertAppInfo(AdvertAppInfo advertAppInfo) {
        this.gJn = advertAppInfo;
    }
}
