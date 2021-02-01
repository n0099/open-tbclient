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
/* loaded from: classes9.dex */
public class a {
    private int jlv;
    private TbPageContext mPageContext;
    private TextView nBT;
    private LinearLayout nBU;
    private TextView nBV;
    private TextView nCA;
    private TextView nCB;
    private RoundRelativeLayout nCx;
    private TextView nCy;
    private TextView nCz;

    public a(TbPageContext tbPageContext, int i) {
        this.mPageContext = tbPageContext;
        this.jlv = i;
        initView();
    }

    private void initView() {
        dPM();
        this.nCy = (TextView) this.nCx.findViewById(R.id.buy_tbean_t_dou_num);
        this.nCz = (TextView) this.nCx.findViewById(R.id.buy_tbean_yinji_time);
        this.nCA = (TextView) this.nCx.findViewById(R.id.buy_tbean_price);
        this.nBU = (LinearLayout) this.nCx.findViewById(R.id.buy_tbean_member_privilege_layout);
        this.nBT = (TextView) this.nCx.findViewById(R.id.buy_tbean_member_privilege);
        this.nBV = (TextView) this.nCx.findViewById(R.id.buy_tbean_member_prefix);
        this.nCB = (TextView) this.nCx.findViewById(R.id.buy_tbean_price_prefix);
    }

    public void a(b bVar) {
        if (bVar != null && bVar.nCs != null) {
            IconInfo iconInfo = bVar.nCs;
            this.nCy.setText(au.formatTosepara(iconInfo.non_member_t.intValue()));
            Drawable drawable = this.mPageContext.getResources().getDrawable(R.drawable.icon_huobi_tdou);
            int dimensionPixelSize = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds46);
            drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            this.nCy.setCompoundDrawablePadding(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds12));
            this.nCy.setCompoundDrawables(drawable, null, null, null);
            this.nCA.setText(String.valueOf(iconInfo.dubi.intValue() / 100));
            this.nCz.setText(this.mPageContext.getPageActivity().getString(R.string.icon_name_valid_day, new Object[]{iconInfo.name, Integer.valueOf(iconInfo.duration == null ? 0 : iconInfo.duration.intValue())}));
            if (bVar.nCr != null) {
                if (bVar.nCr.vip_extra_switch.intValue() == 1 && bVar.nCr.vip_extra_percent.intValue() > 0) {
                    this.nBT.setText(com.baidu.tieba.tbean.b.formatTBeanNum((bVar.nCs.non_member_t.intValue() * bVar.nCr.vip_extra_percent.intValue()) / 100));
                    Drawable drawable2 = this.mPageContext.getResources().getDrawable(R.drawable.icon_huobi_tdou);
                    int dimensionPixelSize2 = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds28);
                    drawable2.setBounds(0, 0, dimensionPixelSize2, dimensionPixelSize2);
                    this.nBT.setCompoundDrawablePadding(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds6));
                    this.nBT.setCompoundDrawables(drawable2, null, null, null);
                    this.nBU.setVisibility(0);
                } else {
                    this.nBU.setVisibility(8);
                }
            } else {
                this.nBU.setVisibility(8);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void dPM() {
        int i = R.layout.grid_view_2_column_item_layout;
        if (this.jlv == 3) {
            i = R.layout.grid_view_3_column_item_layout;
        }
        this.nCx = (RoundRelativeLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(i, (ViewGroup) null);
        this.nCx.setRadius(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds6));
    }

    public View getView() {
        return this.nCx;
    }

    public void onChangeSkinType(int i) {
        if (i == 1 || i == 4) {
            this.nCx.setBgColorRes(R.color.CAM_X0201_1);
        } else {
            this.nCx.setBgColorRes(R.color.CAM_X0201);
        }
        ap.setViewTextColor(this.nCy, R.color.CAM_X0105, 1, i);
        ap.setViewTextColor(this.nCA, R.color.CAM_X0105, 1, i);
        ap.setViewTextColor(this.nCz, R.color.CAM_X0107, 1, i);
        ap.setViewTextColor(this.nBT, R.color.CAM_X0107, 1, i);
        ap.setViewTextColor(this.nBV, R.color.CAM_X0107, 1, i);
        ap.setViewTextColor(this.nCB, R.color.CAM_X0105, 1, i);
    }
}
