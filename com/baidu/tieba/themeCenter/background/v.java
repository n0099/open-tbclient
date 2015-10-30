package com.baidu.tieba.themeCenter.background;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class v {
    private TbImageView dex;
    private TextView dfQ;
    private TextView dfR;
    private TbPageContext<?> mContext;
    private View mRootView;

    public v(TbPageContext<?> tbPageContext) {
        this.mContext = tbPageContext;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mContext.getPageActivity()).inflate(i.g.background_preview_bottom, (ViewGroup) null);
        this.dfQ = (TextView) this.mRootView.findViewById(i.f.text_bg_name);
        this.dex = (TbImageView) this.mRootView.findViewById(i.f.bg_permission_icon);
        this.dfR = (TextView) this.mRootView.findViewById(i.f.text_bg_description);
        sZ();
    }

    public void c(DressItemData dressItemData) {
        if (dressItemData != null) {
            this.dfQ.setText(dressItemData.getTitle());
            this.dex.d(dressItemData.getPermissionImgUrl(), 10, false);
            this.dfR.setText(dressItemData.getDescription());
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void sZ() {
        com.baidu.tbadk.h.a.a(this.mContext, this.mRootView);
    }
}
