package com.baidu.tieba.interestlabel.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes5.dex */
public class a implements View.OnClickListener {
    private TextView gDA;
    private ImageView gDB;
    private TextView gDC;
    private ImageView gDD;
    private TextView gDE;
    private int gDF;
    private int gDG;
    private int gDH;
    private ViewGroup gDy;
    private TextView gDz;

    public a(Context context) {
        this.gDy = (ViewGroup) LayoutInflater.from(context).inflate(d.h.label_recommend_header, (ViewGroup) null);
        this.gDz = (TextView) this.gDy.findViewById(d.g.choose_like_label);
        this.gDA = (TextView) this.gDy.findViewById(d.g.recommend_interest_thread);
        this.gDB = (ImageView) this.gDy.findViewById(d.g.male_icon);
        this.gDC = (TextView) this.gDy.findViewById(d.g.male_text);
        this.gDD = (ImageView) this.gDy.findViewById(d.g.female_icon);
        this.gDE = (TextView) this.gDy.findViewById(d.g.female_text);
        this.gDB.setOnClickListener(this);
        this.gDD.setOnClickListener(this);
        onChangeSkinType();
    }

    private void onChangeSkinType() {
        al.j(this.gDz, d.C0277d.cp_cont_b);
        al.j(this.gDA, d.C0277d.cp_cont_d);
        al.c(this.gDB, d.f.img_lable_boy_n);
        al.j(this.gDC, d.C0277d.cp_cont_d);
        al.c(this.gDD, d.f.img_lable_girl_n);
        al.j(this.gDE, d.C0277d.cp_cont_d);
    }

    public void setData(List<com.baidu.tieba.interestlabel.b.a> list) {
        if (v.S(list) == 2) {
            this.gDF = list.get(0).labelId;
            this.gDG = list.get(1).labelId;
        }
    }

    public ViewGroup bzb() {
        return this.gDy;
    }

    public int bzc() {
        return this.gDH;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        if (view == this.gDB) {
            z = true;
        } else {
            z = view == this.gDD ? false : false;
        }
        this.gDH = z ? this.gDF : this.gDG;
        al.c(this.gDB, z ? d.f.img_lable_boy_s : d.f.img_lable_boy_n);
        al.j(this.gDC, z ? d.C0277d.cp_link_tip_a : d.C0277d.cp_cont_d);
        al.c(this.gDD, z ? d.f.img_lable_girl_n : d.f.img_lable_girl_s);
        al.j(this.gDE, z ? d.C0277d.cp_cont_d : d.C0277d.cp_cont_h);
    }
}
