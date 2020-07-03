package com.baidu.tieba.interestlabel.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes10.dex */
public class a implements View.OnClickListener {
    private ViewGroup gJH;
    private TextView jnk;
    private TextView jnl;
    private ImageView jnm;
    private TextView jnn;
    private ImageView jno;
    private TextView jnp;
    private int jnq;
    private int jnr;
    private int jns;

    public a(Context context) {
        this.gJH = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.label_recommend_header, (ViewGroup) null);
        this.jnk = (TextView) this.gJH.findViewById(R.id.choose_like_label);
        this.jnl = (TextView) this.gJH.findViewById(R.id.recommend_interest_thread);
        this.jnm = (ImageView) this.gJH.findViewById(R.id.male_icon);
        this.jnn = (TextView) this.gJH.findViewById(R.id.male_text);
        this.jno = (ImageView) this.gJH.findViewById(R.id.female_icon);
        this.jnp = (TextView) this.gJH.findViewById(R.id.female_text);
        this.jnm.setOnClickListener(this);
        this.jno.setOnClickListener(this);
        onChangeSkinType();
    }

    private void onChangeSkinType() {
        an.setViewTextColor(this.jnk, (int) R.color.cp_cont_b);
        an.setViewTextColor(this.jnl, (int) R.color.cp_cont_d);
        an.setImageResource(this.jnm, R.drawable.img_lable_boy_n);
        an.setViewTextColor(this.jnn, (int) R.color.cp_cont_d);
        an.setImageResource(this.jno, R.drawable.img_lable_girl_n);
        an.setViewTextColor(this.jnp, (int) R.color.cp_cont_d);
    }

    public void setData(List<com.baidu.tieba.interestlabel.b.a> list) {
        if (w.getCount(list) == 2) {
            this.jnq = list.get(0).labelId;
            this.jnr = list.get(1).labelId;
        }
    }

    public ViewGroup cwz() {
        return this.gJH;
    }

    public int cwA() {
        return this.jns;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        int i = R.color.cp_cont_d;
        if (view == this.jnm) {
            z = true;
        } else {
            z = view == this.jno ? false : false;
        }
        this.jns = z ? this.jnq : this.jnr;
        an.setImageResource(this.jnm, z ? R.drawable.img_lable_boy_s : R.drawable.img_lable_boy_n);
        an.setViewTextColor(this.jnn, z ? R.color.cp_link_tip_a : R.color.cp_cont_d);
        an.setImageResource(this.jno, z ? R.drawable.img_lable_girl_n : R.drawable.img_lable_girl_s);
        TextView textView = this.jnp;
        if (!z) {
            i = R.color.cp_cont_h;
        }
        an.setViewTextColor(textView, i);
    }
}
