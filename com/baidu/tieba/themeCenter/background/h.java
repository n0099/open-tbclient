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
    private TbPageContext<?> eXu;
    private TextView fiU;
    private TbImageView liu;
    private View mRootView;
    private TextView nBZ;

    public h(TbPageContext<?> tbPageContext) {
        this.eXu = tbPageContext;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.eXu.getPageActivity()).inflate(R.layout.background_preview_bottom, (ViewGroup) null);
        this.nBZ = (TextView) this.mRootView.findViewById(R.id.text_bg_name);
        this.liu = (TbImageView) this.mRootView.findViewById(R.id.bg_permission_icon);
        this.fiU = (TextView) this.mRootView.findViewById(R.id.text_bg_description);
        onChangeSkinType();
    }

    public void f(DressItemData dressItemData) {
        if (dressItemData != null) {
            this.nBZ.setText(dressItemData.getTitle());
            this.liu.startLoad(dressItemData.getPermissionImgUrl(), 10, false);
            this.fiU.setText(dressItemData.getDescription());
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void onChangeSkinType() {
        com.baidu.tbadk.r.a.a(this.eXu, this.mRootView);
    }
}
