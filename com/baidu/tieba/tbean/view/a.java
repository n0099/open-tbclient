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
    private int jlJ;
    private TbPageContext mPageContext;
    private RoundRelativeLayout nCX;
    private TextView nCY;
    private TextView nCZ;
    private TextView nCt;
    private LinearLayout nCu;
    private TextView nCv;
    private TextView nDa;
    private TextView nDb;

    public a(TbPageContext tbPageContext, int i) {
        this.mPageContext = tbPageContext;
        this.jlJ = i;
        initView();
    }

    private void initView() {
        dPU();
        this.nCY = (TextView) this.nCX.findViewById(R.id.buy_tbean_t_dou_num);
        this.nCZ = (TextView) this.nCX.findViewById(R.id.buy_tbean_yinji_time);
        this.nDa = (TextView) this.nCX.findViewById(R.id.buy_tbean_price);
        this.nCu = (LinearLayout) this.nCX.findViewById(R.id.buy_tbean_member_privilege_layout);
        this.nCt = (TextView) this.nCX.findViewById(R.id.buy_tbean_member_privilege);
        this.nCv = (TextView) this.nCX.findViewById(R.id.buy_tbean_member_prefix);
        this.nDb = (TextView) this.nCX.findViewById(R.id.buy_tbean_price_prefix);
    }

    public void a(b bVar) {
        if (bVar != null && bVar.nCS != null) {
            IconInfo iconInfo = bVar.nCS;
            this.nCY.setText(au.formatTosepara(iconInfo.non_member_t.intValue()));
            Drawable drawable = this.mPageContext.getResources().getDrawable(R.drawable.icon_huobi_tdou);
            int dimensionPixelSize = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds46);
            drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            this.nCY.setCompoundDrawablePadding(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds12));
            this.nCY.setCompoundDrawables(drawable, null, null, null);
            this.nDa.setText(String.valueOf(iconInfo.dubi.intValue() / 100));
            this.nCZ.setText(this.mPageContext.getPageActivity().getString(R.string.icon_name_valid_day, new Object[]{iconInfo.name, Integer.valueOf(iconInfo.duration == null ? 0 : iconInfo.duration.intValue())}));
            if (bVar.nCR != null) {
                if (bVar.nCR.vip_extra_switch.intValue() == 1 && bVar.nCR.vip_extra_percent.intValue() > 0) {
                    this.nCt.setText(com.baidu.tieba.tbean.b.formatTBeanNum((bVar.nCS.non_member_t.intValue() * bVar.nCR.vip_extra_percent.intValue()) / 100));
                    Drawable drawable2 = this.mPageContext.getResources().getDrawable(R.drawable.icon_huobi_tdou);
                    int dimensionPixelSize2 = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds28);
                    drawable2.setBounds(0, 0, dimensionPixelSize2, dimensionPixelSize2);
                    this.nCt.setCompoundDrawablePadding(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds6));
                    this.nCt.setCompoundDrawables(drawable2, null, null, null);
                    this.nCu.setVisibility(0);
                } else {
                    this.nCu.setVisibility(8);
                }
            } else {
                this.nCu.setVisibility(8);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void dPU() {
        int i = R.layout.grid_view_2_column_item_layout;
        if (this.jlJ == 3) {
            i = R.layout.grid_view_3_column_item_layout;
        }
        this.nCX = (RoundRelativeLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(i, (ViewGroup) null);
        this.nCX.setRadius(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds6));
    }

    public View getView() {
        return this.nCX;
    }

    public void onChangeSkinType(int i) {
        if (i == 1 || i == 4) {
            this.nCX.setBgColorRes(R.color.CAM_X0201_1);
        } else {
            this.nCX.setBgColorRes(R.color.CAM_X0201);
        }
        ap.setViewTextColor(this.nCY, R.color.CAM_X0105, 1, i);
        ap.setViewTextColor(this.nDa, R.color.CAM_X0105, 1, i);
        ap.setViewTextColor(this.nCZ, R.color.CAM_X0107, 1, i);
        ap.setViewTextColor(this.nCt, R.color.CAM_X0107, 1, i);
        ap.setViewTextColor(this.nCv, R.color.CAM_X0107, 1, i);
        ap.setViewTextColor(this.nDb, R.color.CAM_X0105, 1, i);
    }
}
