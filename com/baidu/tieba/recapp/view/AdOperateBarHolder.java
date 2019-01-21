package com.baidu.tieba.recapp.view;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.lego.card.a;
import com.baidu.tieba.lego.card.c;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.recapp.lego.model.postad.PostAdBaseData;
/* loaded from: classes3.dex */
public abstract class AdOperateBarHolder<M extends ICardInfo> {
    protected a frw;
    protected c frx;
    protected final int gVR;
    protected TbPageContext mPageContext;
    protected final View mRootView;

    public AdOperateBarHolder(TbPageContext tbPageContext, int i, View view) {
        this.mPageContext = tbPageContext;
        this.gVR = i;
        this.mRootView = view;
    }

    public void onChangeSkinType() {
    }

    public void update(M m) {
        setTag(m);
    }

    public final void setVisibility(int i) {
        this.mRootView.setVisibility(i);
    }

    public final Context getContext() {
        return this.mRootView.getContext();
    }

    public final Resources getResources() {
        return this.mRootView.getResources();
    }

    public final <T> void setTag(T t) {
        this.mRootView.setTag(t);
    }

    public final <T> void setTag(int i, T t) {
        this.mRootView.setTag(i, t);
    }

    public final <T> T getTag() {
        return (T) this.mRootView.getTag();
    }

    public final <T> T getTag(int i) {
        return (T) this.mRootView.getTag(i);
    }

    public static boolean isOperateValid(PostAdBaseData.a aVar) {
        return aVar != null;
    }

    public void setAfterClickSchemeListener(a aVar) {
        this.frw = aVar;
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void setDownloadAppCallback(c cVar) {
        this.frx = cVar;
    }
}
