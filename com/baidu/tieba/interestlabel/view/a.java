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
    private ViewGroup fjH;
    private TextView fjI;
    private TextView fjJ;
    private ImageView fjK;
    private TextView fjL;
    private ImageView fjM;
    private TextView fjN;
    private int fjO;
    private int fjP;
    private int fjQ;

    public a(Context context) {
        this.fjH = (ViewGroup) LayoutInflater.from(context).inflate(e.h.label_recommend_header, (ViewGroup) null);
        this.fjI = (TextView) this.fjH.findViewById(e.g.choose_like_label);
        this.fjJ = (TextView) this.fjH.findViewById(e.g.recommend_interest_thread);
        this.fjK = (ImageView) this.fjH.findViewById(e.g.male_icon);
        this.fjL = (TextView) this.fjH.findViewById(e.g.male_text);
        this.fjM = (ImageView) this.fjH.findViewById(e.g.female_icon);
        this.fjN = (TextView) this.fjH.findViewById(e.g.female_text);
        this.fjK.setOnClickListener(this);
        this.fjM.setOnClickListener(this);
        onChangeSkinType();
    }

    private void onChangeSkinType() {
        al.h(this.fjI, e.d.cp_cont_b);
        al.h(this.fjJ, e.d.cp_cont_d);
        al.c(this.fjK, e.f.img_lable_boy_n);
        al.h(this.fjL, e.d.cp_cont_d);
        al.c(this.fjM, e.f.img_lable_girl_n);
        al.h(this.fjN, e.d.cp_cont_d);
    }

    public void setData(List<com.baidu.tieba.interestlabel.b.a> list) {
        if (v.H(list) == 2) {
            this.fjO = list.get(0).labelId;
            this.fjP = list.get(1).labelId;
        }
    }

    public ViewGroup aXi() {
        return this.fjH;
    }

    public int aXj() {
        return this.fjQ;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        if (view == this.fjK) {
            z = true;
        } else {
            z = view == this.fjM ? false : false;
        }
        this.fjQ = z ? this.fjO : this.fjP;
        al.c(this.fjK, z ? e.f.img_lable_boy_s : e.f.img_lable_boy_n);
        al.h(this.fjL, z ? e.d.cp_link_tip_a : e.d.cp_cont_d);
        al.c(this.fjM, z ? e.f.img_lable_girl_n : e.f.img_lable_girl_s);
        al.h(this.fjN, z ? e.d.cp_cont_d : e.d.cp_cont_h);
    }
}
