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
/* loaded from: classes7.dex */
public class a implements View.OnClickListener {
    private ViewGroup fwE;
    private TextView hPa;
    private TextView hPb;
    private ImageView hPc;
    private TextView hPd;
    private ImageView hPe;
    private TextView hPf;
    private int hPg;
    private int hPh;
    private int hPi;

    public a(Context context) {
        this.fwE = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.label_recommend_header, (ViewGroup) null);
        this.hPa = (TextView) this.fwE.findViewById(R.id.choose_like_label);
        this.hPb = (TextView) this.fwE.findViewById(R.id.recommend_interest_thread);
        this.hPc = (ImageView) this.fwE.findViewById(R.id.male_icon);
        this.hPd = (TextView) this.fwE.findViewById(R.id.male_text);
        this.hPe = (ImageView) this.fwE.findViewById(R.id.female_icon);
        this.hPf = (TextView) this.fwE.findViewById(R.id.female_text);
        this.hPc.setOnClickListener(this);
        this.hPe.setOnClickListener(this);
        onChangeSkinType();
    }

    private void onChangeSkinType() {
        am.setViewTextColor(this.hPa, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.hPb, (int) R.color.cp_cont_d);
        am.setImageResource(this.hPc, R.drawable.img_lable_boy_n);
        am.setViewTextColor(this.hPd, (int) R.color.cp_cont_d);
        am.setImageResource(this.hPe, R.drawable.img_lable_girl_n);
        am.setViewTextColor(this.hPf, (int) R.color.cp_cont_d);
    }

    public void setData(List<com.baidu.tieba.interestlabel.b.a> list) {
        if (v.getCount(list) == 2) {
            this.hPg = list.get(0).labelId;
            this.hPh = list.get(1).labelId;
        }
    }

    public ViewGroup bYs() {
        return this.fwE;
    }

    public int bYt() {
        return this.hPi;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        int i = R.color.cp_cont_d;
        if (view == this.hPc) {
            z = true;
        } else {
            z = view == this.hPe ? false : false;
        }
        this.hPi = z ? this.hPg : this.hPh;
        am.setImageResource(this.hPc, z ? R.drawable.img_lable_boy_s : R.drawable.img_lable_boy_n);
        am.setViewTextColor(this.hPd, z ? R.color.cp_link_tip_a : R.color.cp_cont_d);
        am.setImageResource(this.hPe, z ? R.drawable.img_lable_girl_n : R.drawable.img_lable_girl_s);
        TextView textView = this.hPf;
        if (!z) {
            i = R.color.cp_cont_h;
        }
        am.setViewTextColor(textView, i);
    }
}
