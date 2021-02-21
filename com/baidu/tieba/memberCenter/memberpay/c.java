package com.baidu.tieba.memberCenter.memberpay;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import com.baidu.tieba.memberCenter.memberpay.f;
import java.util.List;
/* loaded from: classes9.dex */
public class c extends BaseAdapter {
    private int aDJ;
    private int dividerWidth;
    private int itemHeight;
    private LayoutInflater layoutInflater;
    private List<f.d> mList;
    private int screenWidth;

    public c(TbPageContext<?> tbPageContext) {
        this.layoutInflater = LayoutInflater.from(tbPageContext.getPageActivity());
        this.screenWidth = l.getEquipmentWidth(tbPageContext.getPageActivity());
        this.aDJ = (this.screenWidth - tbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds120)) / 3;
        this.itemHeight = tbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds360);
        this.dividerWidth = tbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds44);
    }

    public void setData(List<f.d> list) {
        this.mList = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return y.getCount(this.mList);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: EA */
    public f.d getItem(int i) {
        return (f.d) y.getItem(this.mList, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.layoutInflater.inflate(R.layout.member_pay_price_list_item, (ViewGroup) null);
            view.setTag(new a(view));
        }
        a(i, getItem(i), (a) view.getTag());
        return view;
    }

    private void a(int i, f.d dVar, a aVar) {
        if (dVar == null || dVar.lqq < 0) {
            return;
        }
        aVar.lpX.setText(bC(dVar.mTitle, 7));
        if (TextUtils.isEmpty(dVar.mDiscount)) {
            aVar.lpW.setVisibility(4);
        } else {
            aVar.lpW.setVisibility(0);
            aVar.lpW.setText(bC(dVar.mDiscount, 10));
        }
        aVar.lpV.setText("" + (dVar.lqq / 100));
        if (TextUtils.isEmpty(dVar.mTagName)) {
            aVar.lpU.setVisibility(4);
        } else {
            aVar.lpU.setVisibility(0);
            aVar.lpU.setText(dVar.mTagName);
        }
        if (i == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar.lpR.getLayoutParams();
            layoutParams.width = this.aDJ;
            layoutParams.height = this.itemHeight;
            layoutParams.leftMargin = this.dividerWidth;
            aVar.lpR.setLayoutParams(layoutParams);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) aVar.lpR.getLayoutParams();
            layoutParams2.width = this.aDJ;
            layoutParams2.height = this.itemHeight;
            layoutParams2.leftMargin = 0;
            aVar.lpR.setLayoutParams(layoutParams2);
        }
        ap.setViewTextColor(aVar.lpT, R.color.CAM_X0301);
        ap.setViewTextColor(aVar.lpU, R.color.CAM_X0101);
        ap.setBackgroundResource(aVar.lpU, R.drawable.member_price_tag_bg_shape);
        ap.setViewTextColor(aVar.lpV, R.color.CAM_X0301);
        ap.setViewTextColor(aVar.lpW, R.color.CAM_X0109);
        ap.setViewTextColor(aVar.lpX, R.color.CAM_X0105);
        a(dVar, aVar);
    }

    private String bC(String str, int i) {
        if (str.length() > i) {
            return str.substring(0, i - 1) + StringHelper.STRING_MORE;
        }
        return str;
    }

    private void a(f.d dVar, a aVar) {
        if (dVar != null && aVar != null) {
            if (dVar.isChecked) {
                ap.setBackgroundResource(aVar.lpS, R.drawable.member_price_bg_shape_s);
            } else {
                ap.setBackgroundResource(aVar.lpS, R.drawable.member_price_bg_shape_n);
            }
        }
    }

    public void a(f.d dVar) {
        if (dVar != null && this.mList != null) {
            for (int i = 0; i < this.mList.size(); i++) {
                this.mList.get(i).isChecked = false;
                if (this.mList.get(i).lql.equals(dVar.lql)) {
                    this.mList.get(i).isChecked = true;
                }
            }
            notifyDataSetChanged();
        }
    }

    public f.d dfK() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.mList.size()) {
                if (!this.mList.get(i2).isChecked) {
                    i = i2 + 1;
                } else {
                    return this.mList.get(i2);
                }
            } else {
                return null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes9.dex */
    public class a {
        private RelativeLayout lpR;
        private LinearLayout lpS;
        private TextView lpT;
        private TextView lpU;
        private TextView lpV;
        private TextView lpW;
        private TextView lpX;

        public a(View view) {
            this.lpR = (RelativeLayout) view.findViewById(R.id.root);
            this.lpS = (LinearLayout) view.findViewById(R.id.container);
            this.lpT = (TextView) view.findViewById(R.id.tv_price_money_label);
            this.lpU = (TextView) view.findViewById(R.id.tv_price_tag);
            this.lpV = (TextView) view.findViewById(R.id.tv_price_money);
            this.lpW = (TextView) view.findViewById(R.id.tv_price_sale);
            this.lpX = (TextView) view.findViewById(R.id.tv_month);
        }
    }
}
