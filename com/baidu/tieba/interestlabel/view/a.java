package com.baidu.tieba.interestlabel.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes10.dex */
public class a implements View.OnClickListener {
    private ViewGroup gwT;
    private TextView iVX;
    private TextView iVY;
    private ImageView iVZ;
    private TextView iWa;
    private ImageView iWb;
    private TextView iWc;
    private int iWd;
    private int iWe;
    private int iWf;

    public a(Context context) {
        this.gwT = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.label_recommend_header, (ViewGroup) null);
        this.iVX = (TextView) this.gwT.findViewById(R.id.choose_like_label);
        this.iVY = (TextView) this.gwT.findViewById(R.id.recommend_interest_thread);
        this.iVZ = (ImageView) this.gwT.findViewById(R.id.male_icon);
        this.iWa = (TextView) this.gwT.findViewById(R.id.male_text);
        this.iWb = (ImageView) this.gwT.findViewById(R.id.female_icon);
        this.iWc = (TextView) this.gwT.findViewById(R.id.female_text);
        this.iVZ.setOnClickListener(this);
        this.iWb.setOnClickListener(this);
        onChangeSkinType();
    }

    private void onChangeSkinType() {
        am.setViewTextColor(this.iVX, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.iVY, (int) R.color.cp_cont_d);
        am.setImageResource(this.iVZ, R.drawable.img_lable_boy_n);
        am.setViewTextColor(this.iWa, (int) R.color.cp_cont_d);
        am.setImageResource(this.iWb, R.drawable.img_lable_girl_n);
        am.setViewTextColor(this.iWc, (int) R.color.cp_cont_d);
    }

    public void setData(List<com.baidu.tieba.interestlabel.b.a> list) {
        if (v.getCount(list) == 2) {
            this.iWd = list.get(0).labelId;
            this.iWe = list.get(1).labelId;
        }
    }

    public ViewGroup csJ() {
        return this.gwT;
    }

    public int csK() {
        return this.iWf;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        int i = R.color.cp_cont_d;
        if (view == this.iVZ) {
            z = true;
        } else {
            z = view == this.iWb ? false : false;
        }
        this.iWf = z ? this.iWd : this.iWe;
        am.setImageResource(this.iVZ, z ? R.drawable.img_lable_boy_s : R.drawable.img_lable_boy_n);
        am.setViewTextColor(this.iWa, z ? R.color.cp_link_tip_a : R.color.cp_cont_d);
        am.setImageResource(this.iWb, z ? R.drawable.img_lable_girl_n : R.drawable.img_lable_girl_s);
        TextView textView = this.iWc;
        if (!z) {
            i = R.color.cp_cont_h;
        }
        am.setViewTextColor(textView, i);
    }
}
