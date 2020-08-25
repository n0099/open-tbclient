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
/* loaded from: classes17.dex */
public class a implements View.OnClickListener {
    private ViewGroup hcd;
    private TextView jLl;
    private TextView jLm;
    private ImageView jLn;
    private TextView jLo;
    private ImageView jLp;
    private TextView jLq;
    private int jLr;
    private int jLs;
    private int jLt;

    public a(Context context) {
        this.hcd = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.label_recommend_header, (ViewGroup) null);
        this.jLl = (TextView) this.hcd.findViewById(R.id.choose_like_label);
        this.jLm = (TextView) this.hcd.findViewById(R.id.recommend_interest_thread);
        this.jLn = (ImageView) this.hcd.findViewById(R.id.male_icon);
        this.jLo = (TextView) this.hcd.findViewById(R.id.male_text);
        this.jLp = (ImageView) this.hcd.findViewById(R.id.female_icon);
        this.jLq = (TextView) this.hcd.findViewById(R.id.female_text);
        this.jLn.setOnClickListener(this);
        this.jLp.setOnClickListener(this);
        onChangeSkinType();
    }

    private void onChangeSkinType() {
        ap.setViewTextColor(this.jLl, R.color.cp_cont_b);
        ap.setViewTextColor(this.jLm, R.color.cp_cont_d);
        ap.setImageResource(this.jLn, R.drawable.img_lable_boy_n);
        ap.setViewTextColor(this.jLo, R.color.cp_cont_d);
        ap.setImageResource(this.jLp, R.drawable.img_lable_girl_n);
        ap.setViewTextColor(this.jLq, R.color.cp_cont_d);
    }

    public void setData(List<com.baidu.tieba.interestlabel.b.a> list) {
        if (y.getCount(list) == 2) {
            this.jLr = list.get(0).labelId;
            this.jLs = list.get(1).labelId;
        }
    }

    public ViewGroup cLq() {
        return this.hcd;
    }

    public int cLr() {
        return this.jLt;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        if (view == this.jLn) {
            z = true;
        } else {
            z = view == this.jLp ? false : false;
        }
        this.jLt = z ? this.jLr : this.jLs;
        ap.setImageResource(this.jLn, z ? R.drawable.img_lable_boy_s : R.drawable.img_lable_boy_n);
        ap.setViewTextColor(this.jLo, z ? R.color.cp_link_tip_a : R.color.cp_cont_d);
        ap.setImageResource(this.jLp, z ? R.drawable.img_lable_girl_n : R.drawable.img_lable_girl_s);
        ap.setViewTextColor(this.jLq, z ? R.color.cp_cont_d : R.color.cp_cont_h);
    }
}
