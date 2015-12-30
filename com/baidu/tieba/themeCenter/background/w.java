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
    private final com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> aBQ = new x(this);
    private TextView crS;
    private BackgroundPreviewActivity dMG;
    private BdExpandImageView dMH;
    private TbImageView dMI;
    private TbImageView dMJ;
    private ImageView dMK;
    private TextView dML;
    private View mRootView;

    public w(BackgroundPreviewActivity backgroundPreviewActivity) {
        this.dMG = backgroundPreviewActivity;
        this.mRootView = LayoutInflater.from(this.dMG.getPageContext().getPageActivity()).inflate(n.h.background_preview_header, (ViewGroup) null);
        this.mRootView.setLayoutParams(new AbsListView.LayoutParams(-1, this.dMG.getResources().getDimensionPixelSize(n.e.ds400)));
        initView();
    }

    private void initView() {
        this.dMH = (BdExpandImageView) this.mRootView.findViewById(n.g.expand_image);
        this.dMI = (TbImageView) this.mRootView.findViewById(n.g.user_head);
        this.dMJ = (TbImageView) this.mRootView.findViewById(n.g.vip_icon);
        this.crS = (TextView) this.mRootView.findViewById(n.g.user_name);
        this.dMK = (ImageView) this.mRootView.findViewById(n.g.user_sex);
        this.dML = (TextView) this.mRootView.findViewById(n.g.user_bar_age_num);
    }

    public void d(DressItemData dressItemData) {
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        com.baidu.adp.lib.g.c.hd().a(dressItemData.getExampleImgUrl(), 10, this.aBQ, 0, 0, null, new Object[0]);
        String portrait = currentAccountInfo.getPortrait();
        if (!TextUtils.isEmpty(portrait)) {
            this.dMI.d(portrait, 25, false);
        }
        if (currentAccountInfo.getVipInfo() != null) {
            this.dMJ.d(currentAccountInfo.getVipInfo().getVipIconUrl(), 10, false);
            this.dMJ.setVisibility(0);
        }
        this.crS.setText(currentAccountInfo.getAccount());
        int sex = currentAccountInfo.getSex();
        if (sex == 1) {
            as.i(this.dMK, n.f.icon_pop_boy);
        } else if (sex == 2) {
            as.i(this.dMK, n.f.icon_pop_girl);
        } else {
            this.dMK.setVisibility(8);
        }
        this.dML.setText(dressItemData.getPropsStateImg());
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void ot() {
        if (this.dMG.getPageContext() != null) {
            com.baidu.tbadk.i.a.a(this.dMG.getPageContext(), this.mRootView);
        }
    }
}
