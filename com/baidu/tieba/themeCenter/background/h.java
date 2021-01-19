package com.baidu.tieba.themeCenter.background;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class h {
    private TbPageContext<?> eSJ;
    private TextView fej;
    private TbImageView ldO;
    private View mRootView;
    private TextView nxv;

    public h(TbPageContext<?> tbPageContext) {
        this.eSJ = tbPageContext;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.eSJ.getPageActivity()).inflate(R.layout.background_preview_bottom, (ViewGroup) null);
        this.nxv = (TextView) this.mRootView.findViewById(R.id.text_bg_name);
        this.ldO = (TbImageView) this.mRootView.findViewById(R.id.bg_permission_icon);
        this.fej = (TextView) this.mRootView.findViewById(R.id.text_bg_description);
        onChangeSkinType();
    }

    public void f(DressItemData dressItemData) {
        if (dressItemData != null) {
            this.nxv.setText(dressItemData.getTitle());
            this.ldO.startLoad(dressItemData.getPermissionImgUrl(), 10, false);
            this.fej.setText(dressItemData.getDescription());
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void onChangeSkinType() {
        com.baidu.tbadk.r.a.a(this.eSJ, this.mRootView);
    }
}
