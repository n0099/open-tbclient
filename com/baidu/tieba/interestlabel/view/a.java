package com.baidu.tieba.interestlabel.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes3.dex */
public class a implements View.OnClickListener {
    private ViewGroup esn;
    private TextView eso;
    private TextView esp;
    private ImageView esq;
    private TextView esr;
    private ImageView ess;
    private TextView est;
    private int esu;
    private int esv;
    private int esw;

    public a(Context context) {
        this.esn = (ViewGroup) LayoutInflater.from(context).inflate(d.i.label_recommend_header, (ViewGroup) null);
        this.eso = (TextView) this.esn.findViewById(d.g.choose_like_label);
        this.esp = (TextView) this.esn.findViewById(d.g.recommend_interest_thread);
        this.esq = (ImageView) this.esn.findViewById(d.g.male_icon);
        this.esr = (TextView) this.esn.findViewById(d.g.male_text);
        this.ess = (ImageView) this.esn.findViewById(d.g.female_icon);
        this.est = (TextView) this.esn.findViewById(d.g.female_text);
        this.esq.setOnClickListener(this);
        this.ess.setOnClickListener(this);
        onChangeSkinType();
    }

    private void onChangeSkinType() {
        ak.h(this.eso, d.C0126d.cp_cont_b);
        ak.h(this.esp, d.C0126d.cp_cont_d);
        ak.c(this.esq, d.f.img_lable_boy_n);
        ak.h(this.esr, d.C0126d.cp_cont_d);
        ak.c(this.ess, d.f.img_lable_girl_n);
        ak.h(this.est, d.C0126d.cp_cont_d);
    }

    public void setData(List<com.baidu.tieba.interestlabel.b.a> list) {
        if (v.v(list) == 2) {
            this.esu = list.get(0).labelId;
            this.esv = list.get(1).labelId;
        }
    }

    public ViewGroup aJT() {
        return this.esn;
    }

    public int aJU() {
        return this.esw;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        boolean z;
        if (view2 == this.esq) {
            z = true;
        } else {
            z = view2 == this.ess ? false : false;
        }
        this.esw = z ? this.esu : this.esv;
        ak.c(this.esq, z ? d.f.img_lable_boy_s : d.f.img_lable_boy_n);
        ak.h(this.esr, z ? d.C0126d.cp_link_tip_a : d.C0126d.cp_cont_d);
        ak.c(this.ess, z ? d.f.img_lable_girl_n : d.f.img_lable_girl_s);
        ak.h(this.est, z ? d.C0126d.cp_cont_d : d.C0126d.cp_cont_h);
    }
}
