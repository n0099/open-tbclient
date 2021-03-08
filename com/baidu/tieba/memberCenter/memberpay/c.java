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
/* loaded from: classes8.dex */
public class c extends BaseAdapter {
    private int aFj;
    private int dividerWidth;
    private int itemHeight;
    private LayoutInflater layoutInflater;
    private List<f.d> mList;
    private int screenWidth;

    public c(TbPageContext<?> tbPageContext) {
        this.layoutInflater = LayoutInflater.from(tbPageContext.getPageActivity());
        this.screenWidth = l.getEquipmentWidth(tbPageContext.getPageActivity());
        this.aFj = (this.screenWidth - tbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds120)) / 3;
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
    /* renamed from: ED */
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
        if (dVar == null || dVar.lss < 0) {
            return;
        }
        aVar.lrZ.setText(bC(dVar.mTitle, 7));
        if (TextUtils.isEmpty(dVar.mDiscount)) {
            aVar.lrY.setVisibility(4);
        } else {
            aVar.lrY.setVisibility(0);
            aVar.lrY.setText(bC(dVar.mDiscount, 10));
        }
        aVar.lrX.setText("" + (dVar.lss / 100));
        if (TextUtils.isEmpty(dVar.mTagName)) {
            aVar.lrW.setVisibility(4);
        } else {
            aVar.lrW.setVisibility(0);
            aVar.lrW.setText(dVar.mTagName);
        }
        if (i == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar.lrT.getLayoutParams();
            layoutParams.width = this.aFj;
            layoutParams.height = this.itemHeight;
            layoutParams.leftMargin = this.dividerWidth;
            aVar.lrT.setLayoutParams(layoutParams);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) aVar.lrT.getLayoutParams();
            layoutParams2.width = this.aFj;
            layoutParams2.height = this.itemHeight;
            layoutParams2.leftMargin = 0;
            aVar.lrT.setLayoutParams(layoutParams2);
        }
        ap.setViewTextColor(aVar.lrV, R.color.CAM_X0301);
        ap.setViewTextColor(aVar.lrW, R.color.CAM_X0101);
        ap.setBackgroundResource(aVar.lrW, R.drawable.member_price_tag_bg_shape);
        ap.setViewTextColor(aVar.lrX, R.color.CAM_X0301);
        ap.setViewTextColor(aVar.lrY, R.color.CAM_X0109);
        ap.setViewTextColor(aVar.lrZ, R.color.CAM_X0105);
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
                ap.setBackgroundResource(aVar.lrU, R.drawable.member_price_bg_shape_s);
            } else {
                ap.setBackgroundResource(aVar.lrU, R.drawable.member_price_bg_shape_n);
            }
        }
    }

    public void a(f.d dVar) {
        if (dVar != null && this.mList != null) {
            for (int i = 0; i < this.mList.size(); i++) {
                this.mList.get(i).isChecked = false;
                if (this.mList.get(i).lsn.equals(dVar.lsn)) {
                    this.mList.get(i).isChecked = true;
                }
            }
            notifyDataSetChanged();
        }
    }

    public f.d dfT() {
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
    /* loaded from: classes8.dex */
    public class a {
        private RelativeLayout lrT;
        private LinearLayout lrU;
        private TextView lrV;
        private TextView lrW;
        private TextView lrX;
        private TextView lrY;
        private TextView lrZ;

        public a(View view) {
            this.lrT = (RelativeLayout) view.findViewById(R.id.root);
            this.lrU = (LinearLayout) view.findViewById(R.id.container);
            this.lrV = (TextView) view.findViewById(R.id.tv_price_money_label);
            this.lrW = (TextView) view.findViewById(R.id.tv_price_tag);
            this.lrX = (TextView) view.findViewById(R.id.tv_price_money);
            this.lrY = (TextView) view.findViewById(R.id.tv_price_sale);
            this.lrZ = (TextView) view.findViewById(R.id.tv_month);
        }
    }
}
