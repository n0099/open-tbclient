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
/* loaded from: classes9.dex */
public class a {
    private int jkv;
    private TbPageContext mPageContext;
    private TextView nwP;
    private LinearLayout nwQ;
    private TextView nwR;
    private RoundRelativeLayout nxt;
    private TextView nxu;
    private TextView nxv;
    private TextView nxw;
    private TextView nxx;

    public a(TbPageContext tbPageContext, int i) {
        this.mPageContext = tbPageContext;
        this.jkv = i;
        initView();
    }

    private void initView() {
        dRt();
        this.nxu = (TextView) this.nxt.findViewById(R.id.buy_tbean_t_dou_num);
        this.nxv = (TextView) this.nxt.findViewById(R.id.buy_tbean_yinji_time);
        this.nxw = (TextView) this.nxt.findViewById(R.id.buy_tbean_price);
        this.nwQ = (LinearLayout) this.nxt.findViewById(R.id.buy_tbean_member_privilege_layout);
        this.nwP = (TextView) this.nxt.findViewById(R.id.buy_tbean_member_privilege);
        this.nwR = (TextView) this.nxt.findViewById(R.id.buy_tbean_member_prefix);
        this.nxx = (TextView) this.nxt.findViewById(R.id.buy_tbean_price_prefix);
    }

    public void a(b bVar) {
        if (bVar != null && bVar.nxo != null) {
            IconInfo iconInfo = bVar.nxo;
            this.nxu.setText(at.formatTosepara(iconInfo.non_member_t.intValue()));
            Drawable drawable = this.mPageContext.getResources().getDrawable(R.drawable.icon_huobi_tdou);
            int dimensionPixelSize = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds46);
            drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            this.nxu.setCompoundDrawablePadding(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds12));
            this.nxu.setCompoundDrawables(drawable, null, null, null);
            this.nxw.setText(String.valueOf(iconInfo.dubi.intValue() / 100));
            this.nxv.setText(this.mPageContext.getPageActivity().getString(R.string.icon_name_valid_day, new Object[]{iconInfo.name, Integer.valueOf(iconInfo.duration == null ? 0 : iconInfo.duration.intValue())}));
            if (bVar.nxn != null) {
                if (bVar.nxn.vip_extra_switch.intValue() == 1 && bVar.nxn.vip_extra_percent.intValue() > 0) {
                    this.nwP.setText(com.baidu.tieba.tbean.b.formatTBeanNum((bVar.nxo.non_member_t.intValue() * bVar.nxn.vip_extra_percent.intValue()) / 100));
                    Drawable drawable2 = this.mPageContext.getResources().getDrawable(R.drawable.icon_huobi_tdou);
                    int dimensionPixelSize2 = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds28);
                    drawable2.setBounds(0, 0, dimensionPixelSize2, dimensionPixelSize2);
                    this.nwP.setCompoundDrawablePadding(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds6));
                    this.nwP.setCompoundDrawables(drawable2, null, null, null);
                    this.nwQ.setVisibility(0);
                } else {
                    this.nwQ.setVisibility(8);
                }
            } else {
                this.nwQ.setVisibility(8);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void dRt() {
        int i = R.layout.grid_view_2_column_item_layout;
        if (this.jkv == 3) {
            i = R.layout.grid_view_3_column_item_layout;
        }
        this.nxt = (RoundRelativeLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(i, (ViewGroup) null);
        this.nxt.setRadius(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds6));
    }

    public View getView() {
        return this.nxt;
    }

    public void onChangeSkinType(int i) {
        if (i == 1 || i == 4) {
            this.nxt.setBgColorRes(R.color.CAM_X0201_1);
        } else {
            this.nxt.setBgColorRes(R.color.CAM_X0201);
        }
        ao.setViewTextColor(this.nxu, R.color.CAM_X0105, 1, i);
        ao.setViewTextColor(this.nxw, R.color.CAM_X0105, 1, i);
        ao.setViewTextColor(this.nxv, R.color.CAM_X0107, 1, i);
        ao.setViewTextColor(this.nwP, R.color.CAM_X0107, 1, i);
        ao.setViewTextColor(this.nwR, R.color.CAM_X0107, 1, i);
        ao.setViewTextColor(this.nxx, R.color.CAM_X0105, 1, i);
    }
}
