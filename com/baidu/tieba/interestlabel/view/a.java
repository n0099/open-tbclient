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
    private ViewGroup ghR;
    private TextView iGm;
    private TextView iGn;
    private ImageView iGo;
    private TextView iGp;
    private ImageView iGq;
    private TextView iGr;
    private int iGs;
    private int iGt;
    private int iGu;

    public a(Context context) {
        this.ghR = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.label_recommend_header, (ViewGroup) null);
        this.iGm = (TextView) this.ghR.findViewById(R.id.choose_like_label);
        this.iGn = (TextView) this.ghR.findViewById(R.id.recommend_interest_thread);
        this.iGo = (ImageView) this.ghR.findViewById(R.id.male_icon);
        this.iGp = (TextView) this.ghR.findViewById(R.id.male_text);
        this.iGq = (ImageView) this.ghR.findViewById(R.id.female_icon);
        this.iGr = (TextView) this.ghR.findViewById(R.id.female_text);
        this.iGo.setOnClickListener(this);
        this.iGq.setOnClickListener(this);
        onChangeSkinType();
    }

    private void onChangeSkinType() {
        am.setViewTextColor(this.iGm, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.iGn, (int) R.color.cp_cont_d);
        am.setImageResource(this.iGo, R.drawable.img_lable_boy_n);
        am.setViewTextColor(this.iGp, (int) R.color.cp_cont_d);
        am.setImageResource(this.iGq, R.drawable.img_lable_girl_n);
        am.setViewTextColor(this.iGr, (int) R.color.cp_cont_d);
    }

    public void setData(List<com.baidu.tieba.interestlabel.b.a> list) {
        if (v.getCount(list) == 2) {
            this.iGs = list.get(0).labelId;
            this.iGt = list.get(1).labelId;
        }
    }

    public ViewGroup clX() {
        return this.ghR;
    }

    public int clY() {
        return this.iGu;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        int i = R.color.cp_cont_d;
        if (view == this.iGo) {
            z = true;
        } else {
            z = view == this.iGq ? false : false;
        }
        this.iGu = z ? this.iGs : this.iGt;
        am.setImageResource(this.iGo, z ? R.drawable.img_lable_boy_s : R.drawable.img_lable_boy_n);
        am.setViewTextColor(this.iGp, z ? R.color.cp_link_tip_a : R.color.cp_cont_d);
        am.setImageResource(this.iGq, z ? R.drawable.img_lable_girl_n : R.drawable.img_lable_girl_s);
        TextView textView = this.iGr;
        if (!z) {
            i = R.color.cp_cont_h;
        }
        am.setViewTextColor(textView, i);
    }
}
