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
    private TbImageView cnN;
    private TextView dFc;
    private TextView dFd;
    private TbPageContext<?> mContext;
    private View mRootView;

    public v(TbPageContext<?> tbPageContext) {
        this.mContext = tbPageContext;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mContext.getPageActivity()).inflate(n.g.background_preview_bottom, (ViewGroup) null);
        this.dFc = (TextView) this.mRootView.findViewById(n.f.text_bg_name);
        this.cnN = (TbImageView) this.mRootView.findViewById(n.f.bg_permission_icon);
        this.dFd = (TextView) this.mRootView.findViewById(n.f.text_bg_description);
        tH();
    }

    public void d(DressItemData dressItemData) {
        if (dressItemData != null) {
            this.dFc.setText(dressItemData.getTitle());
            this.cnN.d(dressItemData.getPermissionImgUrl(), 10, false);
            this.dFd.setText(dressItemData.getDescription());
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void tH() {
        com.baidu.tbadk.i.a.a(this.mContext, this.mRootView);
    }
}
