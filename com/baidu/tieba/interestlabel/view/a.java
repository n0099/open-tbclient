package com.baidu.tieba.interestlabel.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes23.dex */
public class a implements View.OnClickListener {
    private ViewGroup hKx;
    private TextView kvq;
    private TextView kvr;
    private ImageView kvs;
    private TextView kvt;
    private ImageView kvu;
    private TextView kvv;
    private int kvw;
    private int kvx;
    private int kvy;

    public a(Context context) {
        this.hKx = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.label_recommend_header, (ViewGroup) null);
        this.kvq = (TextView) this.hKx.findViewById(R.id.choose_like_label);
        this.kvr = (TextView) this.hKx.findViewById(R.id.recommend_interest_thread);
        this.kvs = (ImageView) this.hKx.findViewById(R.id.male_icon);
        this.kvt = (TextView) this.hKx.findViewById(R.id.male_text);
        this.kvu = (ImageView) this.hKx.findViewById(R.id.female_icon);
        this.kvv = (TextView) this.hKx.findViewById(R.id.female_text);
        this.kvs.setOnClickListener(this);
        this.kvu.setOnClickListener(this);
        onChangeSkinType();
    }

    private void onChangeSkinType() {
        ap.setViewTextColor(this.kvq, R.color.cp_cont_b);
        ap.setViewTextColor(this.kvr, R.color.cp_cont_d);
        ap.setImageResource(this.kvs, R.drawable.img_lable_boy_n);
        ap.setViewTextColor(this.kvt, R.color.cp_cont_d);
        ap.setImageResource(this.kvu, R.drawable.img_lable_girl_n);
        ap.setViewTextColor(this.kvv, R.color.cp_cont_d);
    }

    public void setData(List<com.baidu.tieba.interestlabel.b.a> list) {
        if (y.getCount(list) == 2) {
            this.kvw = list.get(0).labelId;
            this.kvx = list.get(1).labelId;
        }
    }

    public ViewGroup cVM() {
        return this.hKx;
    }

    public int cVN() {
        return this.kvy;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        if (view == this.kvs) {
            z = true;
        } else {
            z = view == this.kvu ? false : false;
        }
        this.kvy = z ? this.kvw : this.kvx;
        ap.setImageResource(this.kvs, z ? R.drawable.img_lable_boy_s : R.drawable.img_lable_boy_n);
        ap.setViewTextColor(this.kvt, z ? R.color.cp_link_tip_a : R.color.cp_cont_d);
        ap.setImageResource(this.kvu, z ? R.drawable.img_lable_girl_n : R.drawable.img_lable_girl_s);
        ap.setViewTextColor(this.kvv, z ? R.color.cp_cont_d : R.color.cp_cont_h);
    }
}
