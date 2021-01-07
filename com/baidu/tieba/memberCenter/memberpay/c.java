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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.R;
import com.baidu.tieba.memberCenter.memberpay.f;
import java.util.List;
/* loaded from: classes9.dex */
public class c extends BaseAdapter {
    private int aGJ;
    private int dividerWidth;
    private int itemHeight;
    private LayoutInflater layoutInflater;
    private List<f.d> mList;
    private int screenWidth;

    public c(TbPageContext<?> tbPageContext) {
        this.layoutInflater = LayoutInflater.from(tbPageContext.getPageActivity());
        this.screenWidth = l.getEquipmentWidth(tbPageContext.getPageActivity());
        this.aGJ = (this.screenWidth - tbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds120)) / 3;
        this.itemHeight = tbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds360);
        this.dividerWidth = tbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds44);
    }

    public void setData(List<f.d> list) {
        this.mList = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return x.getCount(this.mList);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: FO */
    public f.d getItem(int i) {
        return (f.d) x.getItem(this.mList, i);
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
        if (dVar == null || dVar.lmA < 0) {
            return;
        }
        aVar.lmh.setText(bB(dVar.mTitle, 7));
        if (TextUtils.isEmpty(dVar.mDiscount)) {
            aVar.lmg.setVisibility(4);
        } else {
            aVar.lmg.setVisibility(0);
            aVar.lmg.setText(bB(dVar.mDiscount, 10));
        }
        aVar.lmf.setText("" + (dVar.lmA / 100));
        if (TextUtils.isEmpty(dVar.mTagName)) {
            aVar.lme.setVisibility(4);
        } else {
            aVar.lme.setVisibility(0);
            aVar.lme.setText(dVar.mTagName);
        }
        if (i == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar.lmb.getLayoutParams();
            layoutParams.width = this.aGJ;
            layoutParams.height = this.itemHeight;
            layoutParams.leftMargin = this.dividerWidth;
            aVar.lmb.setLayoutParams(layoutParams);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) aVar.lmb.getLayoutParams();
            layoutParams2.width = this.aGJ;
            layoutParams2.height = this.itemHeight;
            layoutParams2.leftMargin = 0;
            aVar.lmb.setLayoutParams(layoutParams2);
        }
        ao.setViewTextColor(aVar.lmd, R.color.CAM_X0301);
        ao.setViewTextColor(aVar.lme, R.color.CAM_X0101);
        ao.setBackgroundResource(aVar.lme, R.drawable.member_price_tag_bg_shape);
        ao.setViewTextColor(aVar.lmf, R.color.CAM_X0301);
        ao.setViewTextColor(aVar.lmg, R.color.CAM_X0109);
        ao.setViewTextColor(aVar.lmh, R.color.CAM_X0105);
        a(dVar, aVar);
    }

    private String bB(String str, int i) {
        if (str.length() > i) {
            return str.substring(0, i - 1) + StringHelper.STRING_MORE;
        }
        return str;
    }

    private void a(f.d dVar, a aVar) {
        if (dVar != null && aVar != null) {
            if (dVar.isChecked) {
                ao.setBackgroundResource(aVar.lmc, R.drawable.member_price_bg_shape_s);
            } else {
                ao.setBackgroundResource(aVar.lmc, R.drawable.member_price_bg_shape_n);
            }
        }
    }

    public void a(f.d dVar) {
        if (dVar != null && this.mList != null) {
            for (int i = 0; i < this.mList.size(); i++) {
                this.mList.get(i).isChecked = false;
                if (this.mList.get(i).lmv.equals(dVar.lmv)) {
                    this.mList.get(i).isChecked = true;
                }
            }
            notifyDataSetChanged();
        }
    }

    public f.d dhv() {
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
        private RelativeLayout lmb;
        private LinearLayout lmc;
        private TextView lmd;
        private TextView lme;
        private TextView lmf;
        private TextView lmg;
        private TextView lmh;

        public a(View view) {
            this.lmb = (RelativeLayout) view.findViewById(R.id.root);
            this.lmc = (LinearLayout) view.findViewById(R.id.container);
            this.lmd = (TextView) view.findViewById(R.id.tv_price_money_label);
            this.lme = (TextView) view.findViewById(R.id.tv_price_tag);
            this.lmf = (TextView) view.findViewById(R.id.tv_price_money);
            this.lmg = (TextView) view.findViewById(R.id.tv_price_sale);
            this.lmh = (TextView) view.findViewById(R.id.tv_month);
        }
    }
}
