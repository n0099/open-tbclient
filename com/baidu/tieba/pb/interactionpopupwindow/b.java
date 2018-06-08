package com.baidu.tieba.pb.interactionpopupwindow;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.pb.interactionpopupwindow.IBaseDialogData;
/* loaded from: classes.dex */
public abstract class b<D extends IBaseDialogData> implements g<D> {
    private ViewGroup fpL;
    protected int mSkinType = 3;
    protected TbPageContext<?> mTbPageContext;

    public b(TbPageContext<?> tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.fpL = (ViewGroup) LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(getLayout(), (ViewGroup) null, false);
        initView();
    }

    public TbPageContext<?> aiH() {
        return this.mTbPageContext;
    }

    @Override // com.baidu.tieba.pb.interactionpopupwindow.g
    public ViewGroup getViewGroup() {
        return this.fpL;
    }
}
