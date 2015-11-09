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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class w {
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> aye = new x(this);
    private TextView dgh;
    private TbImageView dhA;
    private TbImageView dhB;
    private ImageView dhC;
    private TextView dhD;
    private BackgroundPreviewActivity dhy;
    private BdExpandImageView dhz;
    private View mRootView;

    public w(BackgroundPreviewActivity backgroundPreviewActivity) {
        this.dhy = backgroundPreviewActivity;
        this.mRootView = LayoutInflater.from(this.dhy.getPageContext().getPageActivity()).inflate(i.g.background_preview_header, (ViewGroup) null);
        this.mRootView.setLayoutParams(new AbsListView.LayoutParams(-1, this.dhy.getResources().getDimensionPixelSize(i.d.ds400)));
        initView();
    }

    private void initView() {
        this.dhz = (BdExpandImageView) this.mRootView.findViewById(i.f.expand_image);
        this.dhA = (TbImageView) this.mRootView.findViewById(i.f.user_head);
        this.dhB = (TbImageView) this.mRootView.findViewById(i.f.vip_icon);
        this.dgh = (TextView) this.mRootView.findViewById(i.f.user_name);
        this.dhC = (ImageView) this.mRootView.findViewById(i.f.user_sex);
        this.dhD = (TextView) this.mRootView.findViewById(i.f.user_bar_age_num);
    }

    public void c(DressItemData dressItemData) {
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        com.baidu.adp.lib.f.c.hb().a(dressItemData.getExampleImgUrl(), 10, this.aye, 0, 0, null, new Object[0]);
        String portrait = currentAccountInfo.getPortrait();
        if (!TextUtils.isEmpty(portrait)) {
            this.dhA.d(portrait, 25, false);
        }
        String memberIconUrl = currentAccountInfo.getMemberIconUrl();
        if (!StringUtils.isNull(memberIconUrl)) {
            this.dhB.d(memberIconUrl, 10, false);
            this.dhB.setVisibility(0);
        }
        this.dgh.setText(currentAccountInfo.getAccount());
        int sex = currentAccountInfo.getSex();
        if (sex == 1) {
            an.i(this.dhC, i.e.icon_pop_boy);
        } else if (sex == 2) {
            an.i(this.dhC, i.e.icon_pop_girl);
        } else {
            this.dhC.setVisibility(8);
        }
        this.dhD.setText(dressItemData.getPropsStateImg());
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void oP() {
        if (this.dhy.getPageContext() != null) {
            com.baidu.tbadk.h.a.a(this.dhy.getPageContext(), this.mRootView);
        }
    }
}
