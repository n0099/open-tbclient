package com.baidu.tieba.interestlabel.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes3.dex */
public class b implements View.OnClickListener {
    private ImageView eXA;
    private TextView eXB;
    private int eXC;
    private int eXD;
    private int eXE;
    private ViewGroup eXv;
    private TextView eXw;
    private TextView eXx;
    private ImageView eXy;
    private TextView eXz;

    public b(Context context) {
        this.eXv = (ViewGroup) LayoutInflater.from(context).inflate(d.h.label_recommend_header, (ViewGroup) null);
        this.eXw = (TextView) this.eXv.findViewById(d.g.choose_like_label);
        this.eXx = (TextView) this.eXv.findViewById(d.g.recommend_interest_thread);
        this.eXy = (ImageView) this.eXv.findViewById(d.g.male_icon);
        this.eXz = (TextView) this.eXv.findViewById(d.g.male_text);
        this.eXA = (ImageView) this.eXv.findViewById(d.g.female_icon);
        this.eXB = (TextView) this.eXv.findViewById(d.g.female_text);
        this.eXy.setOnClickListener(this);
        this.eXA.setOnClickListener(this);
        onChangeSkinType();
    }

    private void onChangeSkinType() {
        aj.r(this.eXw, d.C0141d.cp_cont_b);
        aj.r(this.eXx, d.C0141d.cp_cont_d);
        aj.c(this.eXy, d.f.img_lable_boy_n);
        aj.r(this.eXz, d.C0141d.cp_cont_d);
        aj.c(this.eXA, d.f.img_lable_girl_n);
        aj.r(this.eXB, d.C0141d.cp_cont_d);
    }

    public void setData(List<com.baidu.tieba.interestlabel.b.a> list) {
        if (v.D(list) == 2) {
            this.eXC = list.get(0).labelId;
            this.eXD = list.get(1).labelId;
        }
    }

    public ViewGroup aOQ() {
        return this.eXv;
    }

    public int aOR() {
        return this.eXE;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        if (view == this.eXy) {
            z = true;
        } else {
            z = view == this.eXA ? false : false;
        }
        this.eXE = z ? this.eXC : this.eXD;
        aj.c(this.eXy, z ? d.f.img_lable_boy_s : d.f.img_lable_boy_n);
        aj.r(this.eXz, z ? d.C0141d.cp_link_tip_a : d.C0141d.cp_cont_d);
        aj.c(this.eXA, z ? d.f.img_lable_girl_n : d.f.img_lable_girl_s);
        aj.r(this.eXB, z ? d.C0141d.cp_cont_d : d.C0141d.cp_cont_h);
    }
}
