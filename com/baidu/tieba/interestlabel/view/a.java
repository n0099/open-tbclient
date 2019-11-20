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
/* loaded from: classes5.dex */
public class a implements View.OnClickListener {
    private ViewGroup eEG;
    private TextView haS;
    private TextView haT;
    private ImageView haU;
    private TextView haV;
    private ImageView haW;
    private TextView haX;
    private int haY;
    private int haZ;
    private int hba;

    public a(Context context) {
        this.eEG = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.label_recommend_header, (ViewGroup) null);
        this.haS = (TextView) this.eEG.findViewById(R.id.choose_like_label);
        this.haT = (TextView) this.eEG.findViewById(R.id.recommend_interest_thread);
        this.haU = (ImageView) this.eEG.findViewById(R.id.male_icon);
        this.haV = (TextView) this.eEG.findViewById(R.id.male_text);
        this.haW = (ImageView) this.eEG.findViewById(R.id.female_icon);
        this.haX = (TextView) this.eEG.findViewById(R.id.female_text);
        this.haU.setOnClickListener(this);
        this.haW.setOnClickListener(this);
        onChangeSkinType();
    }

    private void onChangeSkinType() {
        am.setViewTextColor(this.haS, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.haT, (int) R.color.cp_cont_d);
        am.setImageResource(this.haU, R.drawable.img_lable_boy_n);
        am.setViewTextColor(this.haV, (int) R.color.cp_cont_d);
        am.setImageResource(this.haW, R.drawable.img_lable_girl_n);
        am.setViewTextColor(this.haX, (int) R.color.cp_cont_d);
    }

    public void setData(List<com.baidu.tieba.interestlabel.b.a> list) {
        if (v.getCount(list) == 2) {
            this.haY = list.get(0).labelId;
            this.haZ = list.get(1).labelId;
        }
    }

    public ViewGroup bHc() {
        return this.eEG;
    }

    public int bHd() {
        return this.hba;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        int i = R.color.cp_cont_d;
        if (view == this.haU) {
            z = true;
        } else {
            z = view == this.haW ? false : false;
        }
        this.hba = z ? this.haY : this.haZ;
        am.setImageResource(this.haU, z ? R.drawable.img_lable_boy_s : R.drawable.img_lable_boy_n);
        am.setViewTextColor(this.haV, z ? R.color.cp_link_tip_a : R.color.cp_cont_d);
        am.setImageResource(this.haW, z ? R.drawable.img_lable_girl_n : R.drawable.img_lable_girl_s);
        TextView textView = this.haX;
        if (!z) {
            i = R.color.cp_cont_h;
        }
        am.setViewTextColor(textView, i);
    }
}
