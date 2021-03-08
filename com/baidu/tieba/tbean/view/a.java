package com.baidu.tieba.tbean.view;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.R;
import com.baidu.tieba.tbean.b.b;
import tbclient.GetIconList.IconInfo;
/* loaded from: classes8.dex */
public class a {
    private int jnt;
    private TbPageContext mPageContext;
    private TextView nEA;
    private TextView nEy;
    private LinearLayout nEz;
    private RoundRelativeLayout nFc;
    private TextView nFd;
    private TextView nFe;
    private TextView nFf;
    private TextView nFg;

    public a(TbPageContext tbPageContext, int i) {
        this.mPageContext = tbPageContext;
        this.jnt = i;
        initView();
    }

    private void initView() {
        dQd();
        this.nFd = (TextView) this.nFc.findViewById(R.id.buy_tbean_t_dou_num);
        this.nFe = (TextView) this.nFc.findViewById(R.id.buy_tbean_yinji_time);
        this.nFf = (TextView) this.nFc.findViewById(R.id.buy_tbean_price);
        this.nEz = (LinearLayout) this.nFc.findViewById(R.id.buy_tbean_member_privilege_layout);
        this.nEy = (TextView) this.nFc.findViewById(R.id.buy_tbean_member_privilege);
        this.nEA = (TextView) this.nFc.findViewById(R.id.buy_tbean_member_prefix);
        this.nFg = (TextView) this.nFc.findViewById(R.id.buy_tbean_price_prefix);
    }

    public void a(b bVar) {
        if (bVar != null && bVar.nEX != null) {
            IconInfo iconInfo = bVar.nEX;
            this.nFd.setText(au.formatTosepara(iconInfo.non_member_t.intValue()));
            Drawable drawable = this.mPageContext.getResources().getDrawable(R.drawable.icon_huobi_tdou);
            int dimensionPixelSize = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds46);
            drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            this.nFd.setCompoundDrawablePadding(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds12));
            this.nFd.setCompoundDrawables(drawable, null, null, null);
            this.nFf.setText(String.valueOf(iconInfo.dubi.intValue() / 100));
            this.nFe.setText(this.mPageContext.getPageActivity().getString(R.string.icon_name_valid_day, new Object[]{iconInfo.name, Integer.valueOf(iconInfo.duration == null ? 0 : iconInfo.duration.intValue())}));
            if (bVar.nEW != null) {
                if (bVar.nEW.vip_extra_switch.intValue() == 1 && bVar.nEW.vip_extra_percent.intValue() > 0) {
                    this.nEy.setText(com.baidu.tieba.tbean.b.formatTBeanNum((bVar.nEX.non_member_t.intValue() * bVar.nEW.vip_extra_percent.intValue()) / 100));
                    Drawable drawable2 = this.mPageContext.getResources().getDrawable(R.drawable.icon_huobi_tdou);
                    int dimensionPixelSize2 = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds28);
                    drawable2.setBounds(0, 0, dimensionPixelSize2, dimensionPixelSize2);
                    this.nEy.setCompoundDrawablePadding(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds6));
                    this.nEy.setCompoundDrawables(drawable2, null, null, null);
                    this.nEz.setVisibility(0);
                } else {
                    this.nEz.setVisibility(8);
                }
            } else {
                this.nEz.setVisibility(8);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void dQd() {
        int i = R.layout.grid_view_2_column_item_layout;
        if (this.jnt == 3) {
            i = R.layout.grid_view_3_column_item_layout;
        }
        this.nFc = (RoundRelativeLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(i, (ViewGroup) null);
        this.nFc.setRadius(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds6));
    }

    public View getView() {
        return this.nFc;
    }

    public void onChangeSkinType(int i) {
        if (i == 1 || i == 4) {
            this.nFc.setBgColorRes(R.color.CAM_X0201_1);
        } else {
            this.nFc.setBgColorRes(R.color.CAM_X0201);
        }
        ap.setViewTextColor(this.nFd, R.color.CAM_X0105, 1, i);
        ap.setViewTextColor(this.nFf, R.color.CAM_X0105, 1, i);
        ap.setViewTextColor(this.nFe, R.color.CAM_X0107, 1, i);
        ap.setViewTextColor(this.nEy, R.color.CAM_X0107, 1, i);
        ap.setViewTextColor(this.nEA, R.color.CAM_X0107, 1, i);
        ap.setViewTextColor(this.nFg, R.color.CAM_X0105, 1, i);
    }
}
