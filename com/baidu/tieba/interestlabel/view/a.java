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
    private ViewGroup ghL;
    private TextView iGg;
    private TextView iGh;
    private ImageView iGi;
    private TextView iGj;
    private ImageView iGk;
    private TextView iGl;
    private int iGm;
    private int iGn;
    private int iGo;

    public a(Context context) {
        this.ghL = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.label_recommend_header, (ViewGroup) null);
        this.iGg = (TextView) this.ghL.findViewById(R.id.choose_like_label);
        this.iGh = (TextView) this.ghL.findViewById(R.id.recommend_interest_thread);
        this.iGi = (ImageView) this.ghL.findViewById(R.id.male_icon);
        this.iGj = (TextView) this.ghL.findViewById(R.id.male_text);
        this.iGk = (ImageView) this.ghL.findViewById(R.id.female_icon);
        this.iGl = (TextView) this.ghL.findViewById(R.id.female_text);
        this.iGi.setOnClickListener(this);
        this.iGk.setOnClickListener(this);
        onChangeSkinType();
    }

    private void onChangeSkinType() {
        am.setViewTextColor(this.iGg, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.iGh, (int) R.color.cp_cont_d);
        am.setImageResource(this.iGi, R.drawable.img_lable_boy_n);
        am.setViewTextColor(this.iGj, (int) R.color.cp_cont_d);
        am.setImageResource(this.iGk, R.drawable.img_lable_girl_n);
        am.setViewTextColor(this.iGl, (int) R.color.cp_cont_d);
    }

    public void setData(List<com.baidu.tieba.interestlabel.b.a> list) {
        if (v.getCount(list) == 2) {
            this.iGm = list.get(0).labelId;
            this.iGn = list.get(1).labelId;
        }
    }

    public ViewGroup clZ() {
        return this.ghL;
    }

    public int cma() {
        return this.iGo;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        int i = R.color.cp_cont_d;
        if (view == this.iGi) {
            z = true;
        } else {
            z = view == this.iGk ? false : false;
        }
        this.iGo = z ? this.iGm : this.iGn;
        am.setImageResource(this.iGi, z ? R.drawable.img_lable_boy_s : R.drawable.img_lable_boy_n);
        am.setViewTextColor(this.iGj, z ? R.color.cp_link_tip_a : R.color.cp_cont_d);
        am.setImageResource(this.iGk, z ? R.drawable.img_lable_girl_n : R.drawable.img_lable_girl_s);
        TextView textView = this.iGl;
        if (!z) {
            i = R.color.cp_cont_h;
        }
        am.setViewTextColor(textView, i);
    }
}
