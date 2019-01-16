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
    private ViewGroup fns;
    private TextView fnt;
    private TextView fnu;
    private ImageView fnv;
    private TextView fnw;
    private ImageView fnx;
    private TextView fny;
    private int fnz;

    public a(Context context) {
        this.fns = (ViewGroup) LayoutInflater.from(context).inflate(e.h.label_recommend_header, (ViewGroup) null);
        this.fnt = (TextView) this.fns.findViewById(e.g.choose_like_label);
        this.fnu = (TextView) this.fns.findViewById(e.g.recommend_interest_thread);
        this.fnv = (ImageView) this.fns.findViewById(e.g.male_icon);
        this.fnw = (TextView) this.fns.findViewById(e.g.male_text);
        this.fnx = (ImageView) this.fns.findViewById(e.g.female_icon);
        this.fny = (TextView) this.fns.findViewById(e.g.female_text);
        this.fnv.setOnClickListener(this);
        this.fnx.setOnClickListener(this);
        onChangeSkinType();
    }

    private void onChangeSkinType() {
        al.h(this.fnt, e.d.cp_cont_b);
        al.h(this.fnu, e.d.cp_cont_d);
        al.c(this.fnv, e.f.img_lable_boy_n);
        al.h(this.fnw, e.d.cp_cont_d);
        al.c(this.fnx, e.f.img_lable_girl_n);
        al.h(this.fny, e.d.cp_cont_d);
    }

    public void setData(List<com.baidu.tieba.interestlabel.b.a> list) {
        if (v.H(list) == 2) {
            this.fnz = list.get(0).labelId;
            this.fnA = list.get(1).labelId;
        }
    }

    public ViewGroup aYv() {
        return this.fns;
    }

    public int aYw() {
        return this.fnB;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        if (view == this.fnv) {
            z = true;
        } else {
            z = view == this.fnx ? false : false;
        }
        this.fnB = z ? this.fnz : this.fnA;
        al.c(this.fnv, z ? e.f.img_lable_boy_s : e.f.img_lable_boy_n);
        al.h(this.fnw, z ? e.d.cp_link_tip_a : e.d.cp_cont_d);
        al.c(this.fnx, z ? e.f.img_lable_girl_n : e.f.img_lable_girl_s);
        al.h(this.fny, z ? e.d.cp_cont_d : e.d.cp_cont_h);
    }
}
