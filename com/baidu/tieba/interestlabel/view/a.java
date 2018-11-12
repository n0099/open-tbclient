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
    private ViewGroup fcP;
    private TextView fcQ;
    private TextView fcR;
    private ImageView fcS;
    private TextView fcT;
    private ImageView fcU;
    private TextView fcV;
    private int fcW;
    private int fcX;
    private int fcY;

    public a(Context context) {
        this.fcP = (ViewGroup) LayoutInflater.from(context).inflate(e.h.label_recommend_header, (ViewGroup) null);
        this.fcQ = (TextView) this.fcP.findViewById(e.g.choose_like_label);
        this.fcR = (TextView) this.fcP.findViewById(e.g.recommend_interest_thread);
        this.fcS = (ImageView) this.fcP.findViewById(e.g.male_icon);
        this.fcT = (TextView) this.fcP.findViewById(e.g.male_text);
        this.fcU = (ImageView) this.fcP.findViewById(e.g.female_icon);
        this.fcV = (TextView) this.fcP.findViewById(e.g.female_text);
        this.fcS.setOnClickListener(this);
        this.fcU.setOnClickListener(this);
        onChangeSkinType();
    }

    private void onChangeSkinType() {
        al.h(this.fcQ, e.d.cp_cont_b);
        al.h(this.fcR, e.d.cp_cont_d);
        al.c(this.fcS, e.f.img_lable_boy_n);
        al.h(this.fcT, e.d.cp_cont_d);
        al.c(this.fcU, e.f.img_lable_girl_n);
        al.h(this.fcV, e.d.cp_cont_d);
    }

    public void setData(List<com.baidu.tieba.interestlabel.b.a> list) {
        if (v.H(list) == 2) {
            this.fcW = list.get(0).labelId;
            this.fcX = list.get(1).labelId;
        }
    }

    public ViewGroup aVq() {
        return this.fcP;
    }

    public int aVr() {
        return this.fcY;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        if (view == this.fcS) {
            z = true;
        } else {
            z = view == this.fcU ? false : false;
        }
        this.fcY = z ? this.fcW : this.fcX;
        al.c(this.fcS, z ? e.f.img_lable_boy_s : e.f.img_lable_boy_n);
        al.h(this.fcT, z ? e.d.cp_link_tip_a : e.d.cp_cont_d);
        al.c(this.fcU, z ? e.f.img_lable_girl_n : e.f.img_lable_girl_s);
        al.h(this.fcV, z ? e.d.cp_cont_d : e.d.cp_cont_h);
    }
}
