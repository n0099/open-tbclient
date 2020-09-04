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
    private ViewGroup hch;
    private TextView jLr;
    private TextView jLs;
    private ImageView jLt;
    private TextView jLu;
    private ImageView jLv;
    private TextView jLw;
    private int jLx;
    private int jLy;
    private int jLz;

    public a(Context context) {
        this.hch = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.label_recommend_header, (ViewGroup) null);
        this.jLr = (TextView) this.hch.findViewById(R.id.choose_like_label);
        this.jLs = (TextView) this.hch.findViewById(R.id.recommend_interest_thread);
        this.jLt = (ImageView) this.hch.findViewById(R.id.male_icon);
        this.jLu = (TextView) this.hch.findViewById(R.id.male_text);
        this.jLv = (ImageView) this.hch.findViewById(R.id.female_icon);
        this.jLw = (TextView) this.hch.findViewById(R.id.female_text);
        this.jLt.setOnClickListener(this);
        this.jLv.setOnClickListener(this);
        onChangeSkinType();
    }

    private void onChangeSkinType() {
        ap.setViewTextColor(this.jLr, R.color.cp_cont_b);
        ap.setViewTextColor(this.jLs, R.color.cp_cont_d);
        ap.setImageResource(this.jLt, R.drawable.img_lable_boy_n);
        ap.setViewTextColor(this.jLu, R.color.cp_cont_d);
        ap.setImageResource(this.jLv, R.drawable.img_lable_girl_n);
        ap.setViewTextColor(this.jLw, R.color.cp_cont_d);
    }

    public void setData(List<com.baidu.tieba.interestlabel.b.a> list) {
        if (y.getCount(list) == 2) {
            this.jLx = list.get(0).labelId;
            this.jLy = list.get(1).labelId;
        }
    }

    public ViewGroup cLr() {
        return this.hch;
    }

    public int cLs() {
        return this.jLz;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        if (view == this.jLt) {
            z = true;
        } else {
            z = view == this.jLv ? false : false;
        }
        this.jLz = z ? this.jLx : this.jLy;
        ap.setImageResource(this.jLt, z ? R.drawable.img_lable_boy_s : R.drawable.img_lable_boy_n);
        ap.setViewTextColor(this.jLu, z ? R.color.cp_link_tip_a : R.color.cp_cont_d);
        ap.setImageResource(this.jLv, z ? R.drawable.img_lable_girl_n : R.drawable.img_lable_girl_s);
        ap.setViewTextColor(this.jLw, z ? R.color.cp_cont_d : R.color.cp_cont_h);
    }
}
