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
/* loaded from: classes8.dex */
public class a implements View.OnClickListener {
    private ViewGroup fzP;
    private TextView hSD;
    private TextView hSE;
    private ImageView hSF;
    private TextView hSG;
    private ImageView hSH;
    private TextView hSI;
    private int hSJ;
    private int hSK;
    private int hSL;

    public a(Context context) {
        this.fzP = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.label_recommend_header, (ViewGroup) null);
        this.hSD = (TextView) this.fzP.findViewById(R.id.choose_like_label);
        this.hSE = (TextView) this.fzP.findViewById(R.id.recommend_interest_thread);
        this.hSF = (ImageView) this.fzP.findViewById(R.id.male_icon);
        this.hSG = (TextView) this.fzP.findViewById(R.id.male_text);
        this.hSH = (ImageView) this.fzP.findViewById(R.id.female_icon);
        this.hSI = (TextView) this.fzP.findViewById(R.id.female_text);
        this.hSF.setOnClickListener(this);
        this.hSH.setOnClickListener(this);
        onChangeSkinType();
    }

    private void onChangeSkinType() {
        am.setViewTextColor(this.hSD, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.hSE, (int) R.color.cp_cont_d);
        am.setImageResource(this.hSF, R.drawable.img_lable_boy_n);
        am.setViewTextColor(this.hSG, (int) R.color.cp_cont_d);
        am.setImageResource(this.hSH, R.drawable.img_lable_girl_n);
        am.setViewTextColor(this.hSI, (int) R.color.cp_cont_d);
    }

    public void setData(List<com.baidu.tieba.interestlabel.b.a> list) {
        if (v.getCount(list) == 2) {
            this.hSJ = list.get(0).labelId;
            this.hSK = list.get(1).labelId;
        }
    }

    public ViewGroup bZB() {
        return this.fzP;
    }

    public int bZC() {
        return this.hSL;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        int i = R.color.cp_cont_d;
        if (view == this.hSF) {
            z = true;
        } else {
            z = view == this.hSH ? false : false;
        }
        this.hSL = z ? this.hSJ : this.hSK;
        am.setImageResource(this.hSF, z ? R.drawable.img_lable_boy_s : R.drawable.img_lable_boy_n);
        am.setViewTextColor(this.hSG, z ? R.color.cp_link_tip_a : R.color.cp_cont_d);
        am.setImageResource(this.hSH, z ? R.drawable.img_lable_girl_n : R.drawable.img_lable_girl_s);
        TextView textView = this.hSI;
        if (!z) {
            i = R.color.cp_cont_h;
        }
        am.setViewTextColor(textView, i);
    }
}
