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
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> azq = new x(this);
    private TextView deB;
    private BackgroundPreviewActivity dfS;
    private BdExpandImageView dfT;
    private TbImageView dfU;
    private TbImageView dfV;
    private ImageView dfW;
    private TextView dfX;
    private View mRootView;

    public w(BackgroundPreviewActivity backgroundPreviewActivity) {
        this.dfS = backgroundPreviewActivity;
        this.mRootView = LayoutInflater.from(this.dfS.getPageContext().getPageActivity()).inflate(i.g.background_preview_header, (ViewGroup) null);
        this.mRootView.setLayoutParams(new AbsListView.LayoutParams(-1, this.dfS.getResources().getDimensionPixelSize(i.d.ds400)));
        initView();
    }

    private void initView() {
        this.dfT = (BdExpandImageView) this.mRootView.findViewById(i.f.expand_image);
        this.dfU = (TbImageView) this.mRootView.findViewById(i.f.user_head);
        this.dfV = (TbImageView) this.mRootView.findViewById(i.f.vip_icon);
        this.deB = (TextView) this.mRootView.findViewById(i.f.user_name);
        this.dfW = (ImageView) this.mRootView.findViewById(i.f.user_sex);
        this.dfX = (TextView) this.mRootView.findViewById(i.f.user_bar_age_num);
    }

    public void c(DressItemData dressItemData) {
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        com.baidu.adp.lib.f.c.ha().a(dressItemData.getExampleImgUrl(), 10, this.azq, 0, 0, null, new Object[0]);
        String portrait = currentAccountInfo.getPortrait();
        if (!TextUtils.isEmpty(portrait)) {
            this.dfU.d(portrait, 25, false);
        }
        String memberIconUrl = currentAccountInfo.getMemberIconUrl();
        if (!StringUtils.isNull(memberIconUrl)) {
            this.dfV.d(memberIconUrl, 10, false);
            this.dfV.setVisibility(0);
        }
        this.deB.setText(currentAccountInfo.getAccount());
        int sex = currentAccountInfo.getSex();
        if (sex == 1) {
            an.i(this.dfW, i.e.icon_pop_boy);
        } else if (sex == 2) {
            an.i(this.dfW, i.e.icon_pop_girl);
        } else {
            this.dfW.setVisibility(8);
        }
        this.dfX.setText(dressItemData.getPropsStateImg());
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void oO() {
        if (this.dfS.getPageContext() != null) {
            com.baidu.tbadk.h.a.a(this.dfS.getPageContext(), this.mRootView);
        }
    }
}
