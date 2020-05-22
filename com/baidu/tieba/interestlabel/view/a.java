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
    private ViewGroup gwI;
    private TextView iVk;
    private TextView iVl;
    private ImageView iVm;
    private TextView iVn;
    private ImageView iVo;
    private TextView iVp;
    private int iVq;
    private int iVr;
    private int iVs;

    public a(Context context) {
        this.gwI = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.label_recommend_header, (ViewGroup) null);
        this.iVk = (TextView) this.gwI.findViewById(R.id.choose_like_label);
        this.iVl = (TextView) this.gwI.findViewById(R.id.recommend_interest_thread);
        this.iVm = (ImageView) this.gwI.findViewById(R.id.male_icon);
        this.iVn = (TextView) this.gwI.findViewById(R.id.male_text);
        this.iVo = (ImageView) this.gwI.findViewById(R.id.female_icon);
        this.iVp = (TextView) this.gwI.findViewById(R.id.female_text);
        this.iVm.setOnClickListener(this);
        this.iVo.setOnClickListener(this);
        onChangeSkinType();
    }

    private void onChangeSkinType() {
        am.setViewTextColor(this.iVk, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.iVl, (int) R.color.cp_cont_d);
        am.setImageResource(this.iVm, R.drawable.img_lable_boy_n);
        am.setViewTextColor(this.iVn, (int) R.color.cp_cont_d);
        am.setImageResource(this.iVo, R.drawable.img_lable_girl_n);
        am.setViewTextColor(this.iVp, (int) R.color.cp_cont_d);
    }

    public void setData(List<com.baidu.tieba.interestlabel.b.a> list) {
        if (v.getCount(list) == 2) {
            this.iVq = list.get(0).labelId;
            this.iVr = list.get(1).labelId;
        }
    }

    public ViewGroup csA() {
        return this.gwI;
    }

    public int csB() {
        return this.iVs;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        int i = R.color.cp_cont_d;
        if (view == this.iVm) {
            z = true;
        } else {
            z = view == this.iVo ? false : false;
        }
        this.iVs = z ? this.iVq : this.iVr;
        am.setImageResource(this.iVm, z ? R.drawable.img_lable_boy_s : R.drawable.img_lable_boy_n);
        am.setViewTextColor(this.iVn, z ? R.color.cp_link_tip_a : R.color.cp_cont_d);
        am.setImageResource(this.iVo, z ? R.drawable.img_lable_girl_n : R.drawable.img_lable_girl_s);
        TextView textView = this.iVp;
        if (!z) {
            i = R.color.cp_cont_h;
        }
        am.setViewTextColor(textView, i);
    }
}
