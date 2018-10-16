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
    private TextView fbA;
    private int fbB;
    private int fbC;
    private int fbD;
    private ViewGroup fbu;
    private TextView fbv;
    private TextView fbw;
    private ImageView fbx;
    private TextView fby;
    private ImageView fbz;

    public a(Context context) {
        this.fbu = (ViewGroup) LayoutInflater.from(context).inflate(e.h.label_recommend_header, (ViewGroup) null);
        this.fbv = (TextView) this.fbu.findViewById(e.g.choose_like_label);
        this.fbw = (TextView) this.fbu.findViewById(e.g.recommend_interest_thread);
        this.fbx = (ImageView) this.fbu.findViewById(e.g.male_icon);
        this.fby = (TextView) this.fbu.findViewById(e.g.male_text);
        this.fbz = (ImageView) this.fbu.findViewById(e.g.female_icon);
        this.fbA = (TextView) this.fbu.findViewById(e.g.female_text);
        this.fbx.setOnClickListener(this);
        this.fbz.setOnClickListener(this);
        onChangeSkinType();
    }

    private void onChangeSkinType() {
        al.h(this.fbv, e.d.cp_cont_b);
        al.h(this.fbw, e.d.cp_cont_d);
        al.c(this.fbx, e.f.img_lable_boy_n);
        al.h(this.fby, e.d.cp_cont_d);
        al.c(this.fbz, e.f.img_lable_girl_n);
        al.h(this.fbA, e.d.cp_cont_d);
    }

    public void setData(List<com.baidu.tieba.interestlabel.b.a> list) {
        if (v.I(list) == 2) {
            this.fbB = list.get(0).labelId;
            this.fbC = list.get(1).labelId;
        }
    }

    public ViewGroup aVT() {
        return this.fbu;
    }

    public int aVU() {
        return this.fbD;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        if (view == this.fbx) {
            z = true;
        } else {
            z = view == this.fbz ? false : false;
        }
        this.fbD = z ? this.fbB : this.fbC;
        al.c(this.fbx, z ? e.f.img_lable_boy_s : e.f.img_lable_boy_n);
        al.h(this.fby, z ? e.d.cp_link_tip_a : e.d.cp_cont_d);
        al.c(this.fbz, z ? e.f.img_lable_girl_n : e.f.img_lable_girl_s);
        al.h(this.fbA, z ? e.d.cp_cont_d : e.d.cp_cont_h);
    }
}
