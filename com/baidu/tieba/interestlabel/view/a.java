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
    private int fnA;
    private int fnB;
    private int fnC;
    private ViewGroup fnt;
    private TextView fnu;
    private TextView fnv;
    private ImageView fnw;
    private TextView fnx;
    private ImageView fny;
    private TextView fnz;

    public a(Context context) {
        this.fnt = (ViewGroup) LayoutInflater.from(context).inflate(e.h.label_recommend_header, (ViewGroup) null);
        this.fnu = (TextView) this.fnt.findViewById(e.g.choose_like_label);
        this.fnv = (TextView) this.fnt.findViewById(e.g.recommend_interest_thread);
        this.fnw = (ImageView) this.fnt.findViewById(e.g.male_icon);
        this.fnx = (TextView) this.fnt.findViewById(e.g.male_text);
        this.fny = (ImageView) this.fnt.findViewById(e.g.female_icon);
        this.fnz = (TextView) this.fnt.findViewById(e.g.female_text);
        this.fnw.setOnClickListener(this);
        this.fny.setOnClickListener(this);
        onChangeSkinType();
    }

    private void onChangeSkinType() {
        al.h(this.fnu, e.d.cp_cont_b);
        al.h(this.fnv, e.d.cp_cont_d);
        al.c(this.fnw, e.f.img_lable_boy_n);
        al.h(this.fnx, e.d.cp_cont_d);
        al.c(this.fny, e.f.img_lable_girl_n);
        al.h(this.fnz, e.d.cp_cont_d);
    }

    public void setData(List<com.baidu.tieba.interestlabel.b.a> list) {
        if (v.H(list) == 2) {
            this.fnA = list.get(0).labelId;
            this.fnB = list.get(1).labelId;
        }
    }

    public ViewGroup aYv() {
        return this.fnt;
    }

    public int aYw() {
        return this.fnC;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        if (view == this.fnw) {
            z = true;
        } else {
            z = view == this.fny ? false : false;
        }
        this.fnC = z ? this.fnA : this.fnB;
        al.c(this.fnw, z ? e.f.img_lable_boy_s : e.f.img_lable_boy_n);
        al.h(this.fnx, z ? e.d.cp_link_tip_a : e.d.cp_cont_d);
        al.c(this.fny, z ? e.f.img_lable_girl_n : e.f.img_lable_girl_s);
        al.h(this.fnz, z ? e.d.cp_cont_d : e.d.cp_cont_h);
    }
}
