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
    private ViewGroup fDk;
    private TextView hWp;
    private TextView hWq;
    private ImageView hWr;
    private TextView hWs;
    private ImageView hWt;
    private TextView hWu;
    private int hWv;
    private int hWw;
    private int hWx;

    public a(Context context) {
        this.fDk = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.label_recommend_header, (ViewGroup) null);
        this.hWp = (TextView) this.fDk.findViewById(R.id.choose_like_label);
        this.hWq = (TextView) this.fDk.findViewById(R.id.recommend_interest_thread);
        this.hWr = (ImageView) this.fDk.findViewById(R.id.male_icon);
        this.hWs = (TextView) this.fDk.findViewById(R.id.male_text);
        this.hWt = (ImageView) this.fDk.findViewById(R.id.female_icon);
        this.hWu = (TextView) this.fDk.findViewById(R.id.female_text);
        this.hWr.setOnClickListener(this);
        this.hWt.setOnClickListener(this);
        onChangeSkinType();
    }

    private void onChangeSkinType() {
        am.setViewTextColor(this.hWp, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.hWq, (int) R.color.cp_cont_d);
        am.setImageResource(this.hWr, R.drawable.img_lable_boy_n);
        am.setViewTextColor(this.hWs, (int) R.color.cp_cont_d);
        am.setImageResource(this.hWt, R.drawable.img_lable_girl_n);
        am.setViewTextColor(this.hWu, (int) R.color.cp_cont_d);
    }

    public void setData(List<com.baidu.tieba.interestlabel.b.a> list) {
        if (v.getCount(list) == 2) {
            this.hWv = list.get(0).labelId;
            this.hWw = list.get(1).labelId;
        }
    }

    public ViewGroup cby() {
        return this.fDk;
    }

    public int cbz() {
        return this.hWx;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        int i = R.color.cp_cont_d;
        if (view == this.hWr) {
            z = true;
        } else {
            z = view == this.hWt ? false : false;
        }
        this.hWx = z ? this.hWv : this.hWw;
        am.setImageResource(this.hWr, z ? R.drawable.img_lable_boy_s : R.drawable.img_lable_boy_n);
        am.setViewTextColor(this.hWs, z ? R.color.cp_link_tip_a : R.color.cp_cont_d);
        am.setImageResource(this.hWt, z ? R.drawable.img_lable_girl_n : R.drawable.img_lable_girl_s);
        TextView textView = this.hWu;
        if (!z) {
            i = R.color.cp_cont_h;
        }
        am.setViewTextColor(textView, i);
    }
}
