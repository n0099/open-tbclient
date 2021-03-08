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
    private TbPageContext<?> eWx;
    private TextView fhX;
    private TbImageView lok;
    private View mRootView;
    private TextView nJL;

    public h(TbPageContext<?> tbPageContext) {
        this.eWx = tbPageContext;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.eWx.getPageActivity()).inflate(R.layout.background_preview_bottom, (ViewGroup) null);
        this.nJL = (TextView) this.mRootView.findViewById(R.id.text_bg_name);
        this.lok = (TbImageView) this.mRootView.findViewById(R.id.bg_permission_icon);
        this.fhX = (TextView) this.mRootView.findViewById(R.id.text_bg_description);
        onChangeSkinType();
    }

    public void f(DressItemData dressItemData) {
        if (dressItemData != null) {
            this.nJL.setText(dressItemData.getTitle());
            this.lok.startLoad(dressItemData.getPermissionImgUrl(), 10, false);
            this.fhX.setText(dressItemData.getDescription());
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void onChangeSkinType() {
        com.baidu.tbadk.r.a.a(this.eWx, this.mRootView);
    }
}
