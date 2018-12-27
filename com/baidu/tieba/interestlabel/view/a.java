package com.baidu.tieba.interestlabel.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.e;
import java.util.List;
/* loaded from: classes3.dex */
public class a implements View.OnClickListener {
    private TextView fmA;
    private ImageView fmB;
    private TextView fmC;
    private ImageView fmD;
    private TextView fmE;
    private int fmF;
    private int fmG;
    private int fmH;
    private ViewGroup fmy;
    private TextView fmz;

    public a(Context context) {
        this.fmy = (ViewGroup) LayoutInflater.from(context).inflate(e.h.label_recommend_header, (ViewGroup) null);
        this.fmz = (TextView) this.fmy.findViewById(e.g.choose_like_label);
        this.fmA = (TextView) this.fmy.findViewById(e.g.recommend_interest_thread);
        this.fmB = (ImageView) this.fmy.findViewById(e.g.male_icon);
        this.fmC = (TextView) this.fmy.findViewById(e.g.male_text);
        this.fmD = (ImageView) this.fmy.findViewById(e.g.female_icon);
        this.fmE = (TextView) this.fmy.findViewById(e.g.female_text);
        this.fmB.setOnClickListener(this);
        this.fmD.setOnClickListener(this);
        onChangeSkinType();
    }

    private void onChangeSkinType() {
        al.h(this.fmz, e.d.cp_cont_b);
        al.h(this.fmA, e.d.cp_cont_d);
        al.c(this.fmB, e.f.img_lable_boy_n);
        al.h(this.fmC, e.d.cp_cont_d);
        al.c(this.fmD, e.f.img_lable_girl_n);
        al.h(this.fmE, e.d.cp_cont_d);
    }

    public void setData(List<com.baidu.tieba.interestlabel.b.a> list) {
        if (v.H(list) == 2) {
            this.fmF = list.get(0).labelId;
            this.fmG = list.get(1).labelId;
        }
    }

    public ViewGroup aXV() {
        return this.fmy;
    }

    public int aXW() {
        return this.fmH;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        if (view == this.fmB) {
            z = true;
        } else {
            z = view == this.fmD ? false : false;
        }
        this.fmH = z ? this.fmF : this.fmG;
        al.c(this.fmB, z ? e.f.img_lable_boy_s : e.f.img_lable_boy_n);
        al.h(this.fmC, z ? e.d.cp_link_tip_a : e.d.cp_cont_d);
        al.c(this.fmD, z ? e.f.img_lable_girl_n : e.f.img_lable_girl_s);
        al.h(this.fmE, z ? e.d.cp_cont_d : e.d.cp_cont_h);
    }
}
