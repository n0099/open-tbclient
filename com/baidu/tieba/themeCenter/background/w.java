package com.baidu.tieba.themeCenter.background;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdExpandImageView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class w {
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> azf = new x(this);
    private TextView deb;
    private BackgroundPreviewActivity dfs;
    private BdExpandImageView dft;
    private TbImageView dfu;
    private TbImageView dfv;
    private ImageView dfw;
    private TextView dfx;
    private View mRootView;

    public w(BackgroundPreviewActivity backgroundPreviewActivity) {
        this.dfs = backgroundPreviewActivity;
        this.mRootView = LayoutInflater.from(this.dfs.getPageContext().getPageActivity()).inflate(i.g.background_preview_header, (ViewGroup) null);
        this.mRootView.setLayoutParams(new AbsListView.LayoutParams(-1, this.dfs.getResources().getDimensionPixelSize(i.d.ds400)));
        initView();
    }

    private void initView() {
        this.dft = (BdExpandImageView) this.mRootView.findViewById(i.f.expand_image);
        this.dfu = (TbImageView) this.mRootView.findViewById(i.f.user_head);
        this.dfv = (TbImageView) this.mRootView.findViewById(i.f.vip_icon);
        this.deb = (TextView) this.mRootView.findViewById(i.f.user_name);
        this.dfw = (ImageView) this.mRootView.findViewById(i.f.user_sex);
        this.dfx = (TextView) this.mRootView.findViewById(i.f.user_bar_age_num);
    }

    public void c(DressItemData dressItemData) {
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        com.baidu.adp.lib.f.c.ha().a(dressItemData.getExampleImgUrl(), 10, this.azf, 0, 0, null, new Object[0]);
        String portrait = currentAccountInfo.getPortrait();
        if (!TextUtils.isEmpty(portrait)) {
            this.dfu.d(portrait, 25, false);
        }
        String memberIconUrl = currentAccountInfo.getMemberIconUrl();
        if (!StringUtils.isNull(memberIconUrl)) {
            this.dfv.d(memberIconUrl, 10, false);
            this.dfv.setVisibility(0);
        }
        this.deb.setText(currentAccountInfo.getAccount());
        int sex = currentAccountInfo.getSex();
        if (sex == 1) {
            am.i(this.dfw, i.e.icon_pop_boy);
        } else if (sex == 2) {
            am.i(this.dfw, i.e.icon_pop_girl);
        } else {
            this.dfw.setVisibility(8);
        }
        this.dfx.setText(dressItemData.getPropsStateImg());
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void oO() {
        if (this.dfs.getPageContext() != null) {
            com.baidu.tbadk.h.a.a(this.dfs.getPageContext(), this.mRootView);
        }
    }
}
