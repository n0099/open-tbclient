package com.baidu.tieba.themeCenter.background;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class v {
    private TbImageView crQ;
    private TextView dME;
    private TextView dMF;
    private TbPageContext<?> mContext;
    private View mRootView;

    public v(TbPageContext<?> tbPageContext) {
        this.mContext = tbPageContext;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mContext.getPageActivity()).inflate(n.h.background_preview_bottom, (ViewGroup) null);
        this.dME = (TextView) this.mRootView.findViewById(n.g.text_bg_name);
        this.crQ = (TbImageView) this.mRootView.findViewById(n.g.bg_permission_icon);
        this.dMF = (TextView) this.mRootView.findViewById(n.g.text_bg_description);
        tr();
    }

    public void d(DressItemData dressItemData) {
        if (dressItemData != null) {
            this.dME.setText(dressItemData.getTitle());
            this.crQ.d(dressItemData.getPermissionImgUrl(), 10, false);
            this.dMF.setText(dressItemData.getDescription());
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void tr() {
        com.baidu.tbadk.i.a.a(this.mContext, this.mRootView);
    }
}
