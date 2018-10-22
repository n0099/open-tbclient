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
    private ImageView fbA;
    private TextView fbB;
    private int fbC;
    private int fbD;
    private int fbE;
    private ViewGroup fbv;
    private TextView fbw;
    private TextView fbx;
    private ImageView fby;
    private TextView fbz;

    public a(Context context) {
        this.fbv = (ViewGroup) LayoutInflater.from(context).inflate(e.h.label_recommend_header, (ViewGroup) null);
        this.fbw = (TextView) this.fbv.findViewById(e.g.choose_like_label);
        this.fbx = (TextView) this.fbv.findViewById(e.g.recommend_interest_thread);
        this.fby = (ImageView) this.fbv.findViewById(e.g.male_icon);
        this.fbz = (TextView) this.fbv.findViewById(e.g.male_text);
        this.fbA = (ImageView) this.fbv.findViewById(e.g.female_icon);
        this.fbB = (TextView) this.fbv.findViewById(e.g.female_text);
        this.fby.setOnClickListener(this);
        this.fbA.setOnClickListener(this);
        onChangeSkinType();
    }

    private void onChangeSkinType() {
        al.h(this.fbw, e.d.cp_cont_b);
        al.h(this.fbx, e.d.cp_cont_d);
        al.c(this.fby, e.f.img_lable_boy_n);
        al.h(this.fbz, e.d.cp_cont_d);
        al.c(this.fbA, e.f.img_lable_girl_n);
        al.h(this.fbB, e.d.cp_cont_d);
    }

    public void setData(List<com.baidu.tieba.interestlabel.b.a> list) {
        if (v.I(list) == 2) {
            this.fbC = list.get(0).labelId;
            this.fbD = list.get(1).labelId;
        }
    }

    public ViewGroup aVT() {
        return this.fbv;
    }

    public int aVU() {
        return this.fbE;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        if (view == this.fby) {
            z = true;
        } else {
            z = view == this.fbA ? false : false;
        }
        this.fbE = z ? this.fbC : this.fbD;
        al.c(this.fby, z ? e.f.img_lable_boy_s : e.f.img_lable_boy_n);
        al.h(this.fbz, z ? e.d.cp_link_tip_a : e.d.cp_cont_d);
        al.c(this.fbA, z ? e.f.img_lable_girl_n : e.f.img_lable_girl_s);
        al.h(this.fbB, z ? e.d.cp_cont_d : e.d.cp_cont_h);
    }
}
