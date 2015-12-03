package com.baidu.tieba.themeCenter.background;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdExpandImageView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class w {
    private final com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> aAj = new x(this);
    private TextView cnP;
    private BackgroundPreviewActivity dFe;
    private BdExpandImageView dFf;
    private TbImageView dFg;
    private TbImageView dFh;
    private ImageView dFi;
    private TextView dFj;
    private View mRootView;

    public w(BackgroundPreviewActivity backgroundPreviewActivity) {
        this.dFe = backgroundPreviewActivity;
        this.mRootView = LayoutInflater.from(this.dFe.getPageContext().getPageActivity()).inflate(n.g.background_preview_header, (ViewGroup) null);
        this.mRootView.setLayoutParams(new AbsListView.LayoutParams(-1, this.dFe.getResources().getDimensionPixelSize(n.d.ds400)));
        initView();
    }

    private void initView() {
        this.dFf = (BdExpandImageView) this.mRootView.findViewById(n.f.expand_image);
        this.dFg = (TbImageView) this.mRootView.findViewById(n.f.user_head);
        this.dFh = (TbImageView) this.mRootView.findViewById(n.f.vip_icon);
        this.cnP = (TextView) this.mRootView.findViewById(n.f.user_name);
        this.dFi = (ImageView) this.mRootView.findViewById(n.f.user_sex);
        this.dFj = (TextView) this.mRootView.findViewById(n.f.user_bar_age_num);
    }

    public void d(DressItemData dressItemData) {
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        com.baidu.adp.lib.g.c.hd().a(dressItemData.getExampleImgUrl(), 10, this.aAj, 0, 0, null, new Object[0]);
        String portrait = currentAccountInfo.getPortrait();
        if (!TextUtils.isEmpty(portrait)) {
            this.dFg.d(portrait, 25, false);
        }
        if (currentAccountInfo.getVipInfo() != null) {
            this.dFh.d(currentAccountInfo.getVipInfo().getVipIconUrl(), 10, false);
            this.dFh.setVisibility(0);
        }
        this.cnP.setText(currentAccountInfo.getAccount());
        int sex = currentAccountInfo.getSex();
        if (sex == 1) {
            as.i(this.dFi, n.e.icon_pop_boy);
        } else if (sex == 2) {
            as.i(this.dFi, n.e.icon_pop_girl);
        } else {
            this.dFi.setVisibility(8);
        }
        this.dFj.setText(dressItemData.getPropsStateImg());
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void oV() {
        if (this.dFe.getPageContext() != null) {
            com.baidu.tbadk.i.a.a(this.dFe.getPageContext(), this.mRootView);
        }
    }
}
