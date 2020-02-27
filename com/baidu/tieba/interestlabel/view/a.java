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
    private ViewGroup fCn;
    private TextView hUB;
    private TextView hUC;
    private ImageView hUD;
    private TextView hUE;
    private ImageView hUF;
    private TextView hUG;
    private int hUH;
    private int hUI;
    private int hUJ;

    public a(Context context) {
        this.fCn = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.label_recommend_header, (ViewGroup) null);
        this.hUB = (TextView) this.fCn.findViewById(R.id.choose_like_label);
        this.hUC = (TextView) this.fCn.findViewById(R.id.recommend_interest_thread);
        this.hUD = (ImageView) this.fCn.findViewById(R.id.male_icon);
        this.hUE = (TextView) this.fCn.findViewById(R.id.male_text);
        this.hUF = (ImageView) this.fCn.findViewById(R.id.female_icon);
        this.hUG = (TextView) this.fCn.findViewById(R.id.female_text);
        this.hUD.setOnClickListener(this);
        this.hUF.setOnClickListener(this);
        onChangeSkinType();
    }

    private void onChangeSkinType() {
        am.setViewTextColor(this.hUB, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.hUC, (int) R.color.cp_cont_d);
        am.setImageResource(this.hUD, R.drawable.img_lable_boy_n);
        am.setViewTextColor(this.hUE, (int) R.color.cp_cont_d);
        am.setImageResource(this.hUF, R.drawable.img_lable_girl_n);
        am.setViewTextColor(this.hUG, (int) R.color.cp_cont_d);
    }

    public void setData(List<com.baidu.tieba.interestlabel.b.a> list) {
        if (v.getCount(list) == 2) {
            this.hUH = list.get(0).labelId;
            this.hUI = list.get(1).labelId;
        }
    }

    public ViewGroup cbc() {
        return this.fCn;
    }

    public int cbd() {
        return this.hUJ;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        int i = R.color.cp_cont_d;
        if (view == this.hUD) {
            z = true;
        } else {
            z = view == this.hUF ? false : false;
        }
        this.hUJ = z ? this.hUH : this.hUI;
        am.setImageResource(this.hUD, z ? R.drawable.img_lable_boy_s : R.drawable.img_lable_boy_n);
        am.setViewTextColor(this.hUE, z ? R.color.cp_link_tip_a : R.color.cp_cont_d);
        am.setImageResource(this.hUF, z ? R.drawable.img_lable_girl_n : R.drawable.img_lable_girl_s);
        TextView textView = this.hUG;
        if (!z) {
            i = R.color.cp_cont_h;
        }
        am.setViewTextColor(textView, i);
    }
}
