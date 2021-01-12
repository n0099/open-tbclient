package com.baidu.tieba.tbean.view;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.R;
import com.baidu.tieba.tbean.b.b;
import tbclient.GetIconList.IconInfo;
/* loaded from: classes8.dex */
public class a {
    private int jfO;
    private TbPageContext mPageContext;
    private RoundRelativeLayout nsN;
    private TextView nsO;
    private TextView nsP;
    private TextView nsQ;
    private TextView nsR;
    private TextView nsj;
    private LinearLayout nsk;
    private TextView nsl;

    public a(TbPageContext tbPageContext, int i) {
        this.mPageContext = tbPageContext;
        this.jfO = i;
        initView();
    }

    private void initView() {
        dNB();
        this.nsO = (TextView) this.nsN.findViewById(R.id.buy_tbean_t_dou_num);
        this.nsP = (TextView) this.nsN.findViewById(R.id.buy_tbean_yinji_time);
        this.nsQ = (TextView) this.nsN.findViewById(R.id.buy_tbean_price);
        this.nsk = (LinearLayout) this.nsN.findViewById(R.id.buy_tbean_member_privilege_layout);
        this.nsj = (TextView) this.nsN.findViewById(R.id.buy_tbean_member_privilege);
        this.nsl = (TextView) this.nsN.findViewById(R.id.buy_tbean_member_prefix);
        this.nsR = (TextView) this.nsN.findViewById(R.id.buy_tbean_price_prefix);
    }

    public void a(b bVar) {
        if (bVar != null && bVar.nsI != null) {
            IconInfo iconInfo = bVar.nsI;
            this.nsO.setText(at.formatTosepara(iconInfo.non_member_t.intValue()));
            Drawable drawable = this.mPageContext.getResources().getDrawable(R.drawable.icon_huobi_tdou);
            int dimensionPixelSize = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds46);
            drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            this.nsO.setCompoundDrawablePadding(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds12));
            this.nsO.setCompoundDrawables(drawable, null, null, null);
            this.nsQ.setText(String.valueOf(iconInfo.dubi.intValue() / 100));
            this.nsP.setText(this.mPageContext.getPageActivity().getString(R.string.icon_name_valid_day, new Object[]{iconInfo.name, Integer.valueOf(iconInfo.duration == null ? 0 : iconInfo.duration.intValue())}));
            if (bVar.nsH != null) {
                if (bVar.nsH.vip_extra_switch.intValue() == 1 && bVar.nsH.vip_extra_percent.intValue() > 0) {
                    this.nsj.setText(com.baidu.tieba.tbean.b.formatTBeanNum((bVar.nsI.non_member_t.intValue() * bVar.nsH.vip_extra_percent.intValue()) / 100));
                    Drawable drawable2 = this.mPageContext.getResources().getDrawable(R.drawable.icon_huobi_tdou);
                    int dimensionPixelSize2 = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds28);
                    drawable2.setBounds(0, 0, dimensionPixelSize2, dimensionPixelSize2);
                    this.nsj.setCompoundDrawablePadding(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds6));
                    this.nsj.setCompoundDrawables(drawable2, null, null, null);
                    this.nsk.setVisibility(0);
                } else {
                    this.nsk.setVisibility(8);
                }
            } else {
                this.nsk.setVisibility(8);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void dNB() {
        int i = R.layout.grid_view_2_column_item_layout;
        if (this.jfO == 3) {
            i = R.layout.grid_view_3_column_item_layout;
        }
        this.nsN = (RoundRelativeLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(i, (ViewGroup) null);
        this.nsN.setRadius(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds6));
    }

    public View getView() {
        return this.nsN;
    }

    public void onChangeSkinType(int i) {
        if (i == 1 || i == 4) {
            this.nsN.setBgColorRes(R.color.CAM_X0201_1);
        } else {
            this.nsN.setBgColorRes(R.color.CAM_X0201);
        }
        ao.setViewTextColor(this.nsO, R.color.CAM_X0105, 1, i);
        ao.setViewTextColor(this.nsQ, R.color.CAM_X0105, 1, i);
        ao.setViewTextColor(this.nsP, R.color.CAM_X0107, 1, i);
        ao.setViewTextColor(this.nsj, R.color.CAM_X0107, 1, i);
        ao.setViewTextColor(this.nsl, R.color.CAM_X0107, 1, i);
        ao.setViewTextColor(this.nsR, R.color.CAM_X0105, 1, i);
    }
}
