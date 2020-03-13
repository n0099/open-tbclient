package com.baidu.tieba.interestlabel.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes10.dex */
public class a implements View.OnClickListener {
    private ViewGroup fCC;
    private TextView hUP;
    private TextView hUQ;
    private ImageView hUR;
    private TextView hUS;
    private ImageView hUT;
    private TextView hUU;
    private int hUV;
    private int hUW;
    private int hUX;

    public a(Context context) {
        this.fCC = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.label_recommend_header, (ViewGroup) null);
        this.hUP = (TextView) this.fCC.findViewById(R.id.choose_like_label);
        this.hUQ = (TextView) this.fCC.findViewById(R.id.recommend_interest_thread);
        this.hUR = (ImageView) this.fCC.findViewById(R.id.male_icon);
        this.hUS = (TextView) this.fCC.findViewById(R.id.male_text);
        this.hUT = (ImageView) this.fCC.findViewById(R.id.female_icon);
        this.hUU = (TextView) this.fCC.findViewById(R.id.female_text);
        this.hUR.setOnClickListener(this);
        this.hUT.setOnClickListener(this);
        onChangeSkinType();
    }

    private void onChangeSkinType() {
        am.setViewTextColor(this.hUP, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.hUQ, (int) R.color.cp_cont_d);
        am.setImageResource(this.hUR, R.drawable.img_lable_boy_n);
        am.setViewTextColor(this.hUS, (int) R.color.cp_cont_d);
        am.setImageResource(this.hUT, R.drawable.img_lable_girl_n);
        am.setViewTextColor(this.hUU, (int) R.color.cp_cont_d);
    }

    public void setData(List<com.baidu.tieba.interestlabel.b.a> list) {
        if (v.getCount(list) == 2) {
            this.hUV = list.get(0).labelId;
            this.hUW = list.get(1).labelId;
        }
    }

    public ViewGroup cbf() {
        return this.fCC;
    }

    public int cbg() {
        return this.hUX;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        int i = R.color.cp_cont_d;
        if (view == this.hUR) {
            z = true;
        } else {
            z = view == this.hUT ? false : false;
        }
        this.hUX = z ? this.hUV : this.hUW;
        am.setImageResource(this.hUR, z ? R.drawable.img_lable_boy_s : R.drawable.img_lable_boy_n);
        am.setViewTextColor(this.hUS, z ? R.color.cp_link_tip_a : R.color.cp_cont_d);
        am.setImageResource(this.hUT, z ? R.drawable.img_lable_girl_n : R.drawable.img_lable_girl_s);
        TextView textView = this.hUU;
        if (!z) {
            i = R.color.cp_cont_h;
        }
        am.setViewTextColor(textView, i);
    }
}
