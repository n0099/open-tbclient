package com.baidu.tieba.themeCenter.background;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class h {
    private TbPageContext<?> eUY;
    private TextView fgy;
    private TbImageView lmf;
    private View mRootView;
    private TextView nHF;

    public h(TbPageContext<?> tbPageContext) {
        this.eUY = tbPageContext;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.eUY.getPageActivity()).inflate(R.layout.background_preview_bottom, (ViewGroup) null);
        this.nHF = (TextView) this.mRootView.findViewById(R.id.text_bg_name);
        this.lmf = (TbImageView) this.mRootView.findViewById(R.id.bg_permission_icon);
        this.fgy = (TextView) this.mRootView.findViewById(R.id.text_bg_description);
        onChangeSkinType();
    }

    public void f(DressItemData dressItemData) {
        if (dressItemData != null) {
            this.nHF.setText(dressItemData.getTitle());
            this.lmf.startLoad(dressItemData.getPermissionImgUrl(), 10, false);
            this.fgy.setText(dressItemData.getDescription());
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void onChangeSkinType() {
        com.baidu.tbadk.r.a.a(this.eUY, this.mRootView);
    }
}
