package com.baidu.tieba.interestlabel.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes17.dex */
public class a implements View.OnClickListener {
    private ViewGroup gPn;
    private TextView jvO;
    private TextView jvP;
    private ImageView jvQ;
    private TextView jvR;
    private ImageView jvS;
    private TextView jvT;
    private int jvU;
    private int jvV;
    private int jvW;

    public a(Context context) {
        this.gPn = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.label_recommend_header, (ViewGroup) null);
        this.jvO = (TextView) this.gPn.findViewById(R.id.choose_like_label);
        this.jvP = (TextView) this.gPn.findViewById(R.id.recommend_interest_thread);
        this.jvQ = (ImageView) this.gPn.findViewById(R.id.male_icon);
        this.jvR = (TextView) this.gPn.findViewById(R.id.male_text);
        this.jvS = (ImageView) this.gPn.findViewById(R.id.female_icon);
        this.jvT = (TextView) this.gPn.findViewById(R.id.female_text);
        this.jvQ.setOnClickListener(this);
        this.jvS.setOnClickListener(this);
        onChangeSkinType();
    }

    private void onChangeSkinType() {
        ao.setViewTextColor(this.jvO, R.color.cp_cont_b);
        ao.setViewTextColor(this.jvP, R.color.cp_cont_d);
        ao.setImageResource(this.jvQ, R.drawable.img_lable_boy_n);
        ao.setViewTextColor(this.jvR, R.color.cp_cont_d);
        ao.setImageResource(this.jvS, R.drawable.img_lable_girl_n);
        ao.setViewTextColor(this.jvT, R.color.cp_cont_d);
    }

    public void setData(List<com.baidu.tieba.interestlabel.b.a> list) {
        if (x.getCount(list) == 2) {
            this.jvU = list.get(0).labelId;
            this.jvV = list.get(1).labelId;
        }
    }

    public ViewGroup cAy() {
        return this.gPn;
    }

    public int cAz() {
        return this.jvW;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        if (view == this.jvQ) {
            z = true;
        } else {
            z = view == this.jvS ? false : false;
        }
        this.jvW = z ? this.jvU : this.jvV;
        ao.setImageResource(this.jvQ, z ? R.drawable.img_lable_boy_s : R.drawable.img_lable_boy_n);
        ao.setViewTextColor(this.jvR, z ? R.color.cp_link_tip_a : R.color.cp_cont_d);
        ao.setImageResource(this.jvS, z ? R.drawable.img_lable_girl_n : R.drawable.img_lable_girl_s);
        ao.setViewTextColor(this.jvT, z ? R.color.cp_cont_d : R.color.cp_cont_h);
    }
}
