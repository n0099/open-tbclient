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
    private ViewGroup hQu;
    private TextView kBl;
    private TextView kBm;
    private ImageView kBn;
    private TextView kBo;
    private ImageView kBp;
    private TextView kBq;
    private int kBr;
    private int kBs;
    private int kBt;

    public a(Context context) {
        this.hQu = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.label_recommend_header, (ViewGroup) null);
        this.kBl = (TextView) this.hQu.findViewById(R.id.choose_like_label);
        this.kBm = (TextView) this.hQu.findViewById(R.id.recommend_interest_thread);
        this.kBn = (ImageView) this.hQu.findViewById(R.id.male_icon);
        this.kBo = (TextView) this.hQu.findViewById(R.id.male_text);
        this.kBp = (ImageView) this.hQu.findViewById(R.id.female_icon);
        this.kBq = (TextView) this.hQu.findViewById(R.id.female_text);
        this.kBn.setOnClickListener(this);
        this.kBp.setOnClickListener(this);
        onChangeSkinType();
    }

    private void onChangeSkinType() {
        ap.setViewTextColor(this.kBl, R.color.cp_cont_b);
        ap.setViewTextColor(this.kBm, R.color.cp_cont_d);
        ap.setImageResource(this.kBn, R.drawable.img_lable_boy_n);
        ap.setViewTextColor(this.kBo, R.color.cp_cont_d);
        ap.setImageResource(this.kBp, R.drawable.img_lable_girl_n);
        ap.setViewTextColor(this.kBq, R.color.cp_cont_d);
    }

    public void setData(List<com.baidu.tieba.interestlabel.b.a> list) {
        if (y.getCount(list) == 2) {
            this.kBr = list.get(0).labelId;
            this.kBs = list.get(1).labelId;
        }
    }

    public ViewGroup cYn() {
        return this.hQu;
    }

    public int cYo() {
        return this.kBt;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        if (view == this.kBn) {
            z = true;
        } else {
            z = view == this.kBp ? false : false;
        }
        this.kBt = z ? this.kBr : this.kBs;
        ap.setImageResource(this.kBn, z ? R.drawable.img_lable_boy_s : R.drawable.img_lable_boy_n);
        ap.setViewTextColor(this.kBo, z ? R.color.cp_link_tip_a : R.color.cp_cont_d);
        ap.setImageResource(this.kBp, z ? R.drawable.img_lable_girl_n : R.drawable.img_lable_girl_s);
        ap.setViewTextColor(this.kBq, z ? R.color.cp_cont_d : R.color.cp_cont_h);
    }
}
