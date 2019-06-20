package com.baidu.tieba.interestlabel.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes5.dex */
public class a implements View.OnClickListener {
    private ViewGroup epX;
    private TextView gUJ;
    private TextView gUK;
    private ImageView gUL;
    private TextView gUM;
    private ImageView gUN;
    private TextView gUO;
    private int gUP;
    private int gUQ;
    private int gUR;

    public a(Context context) {
        this.epX = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.label_recommend_header, (ViewGroup) null);
        this.gUJ = (TextView) this.epX.findViewById(R.id.choose_like_label);
        this.gUK = (TextView) this.epX.findViewById(R.id.recommend_interest_thread);
        this.gUL = (ImageView) this.epX.findViewById(R.id.male_icon);
        this.gUM = (TextView) this.epX.findViewById(R.id.male_text);
        this.gUN = (ImageView) this.epX.findViewById(R.id.female_icon);
        this.gUO = (TextView) this.epX.findViewById(R.id.female_text);
        this.gUL.setOnClickListener(this);
        this.gUN.setOnClickListener(this);
        onChangeSkinType();
    }

    private void onChangeSkinType() {
        al.j(this.gUJ, R.color.cp_cont_b);
        al.j(this.gUK, R.color.cp_cont_d);
        al.c(this.gUL, (int) R.drawable.img_lable_boy_n);
        al.j(this.gUM, R.color.cp_cont_d);
        al.c(this.gUN, (int) R.drawable.img_lable_girl_n);
        al.j(this.gUO, R.color.cp_cont_d);
    }

    public void setData(List<com.baidu.tieba.interestlabel.b.a> list) {
        if (v.Z(list) == 2) {
            this.gUP = list.get(0).labelId;
            this.gUQ = list.get(1).labelId;
        }
    }

    public ViewGroup bGM() {
        return this.epX;
    }

    public int bGN() {
        return this.gUR;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        int i = R.color.cp_cont_d;
        if (view == this.gUL) {
            z = true;
        } else {
            z = view == this.gUN ? false : false;
        }
        this.gUR = z ? this.gUP : this.gUQ;
        al.c(this.gUL, z ? R.drawable.img_lable_boy_s : R.drawable.img_lable_boy_n);
        al.j(this.gUM, z ? R.color.cp_link_tip_a : R.color.cp_cont_d);
        al.c(this.gUN, z ? R.drawable.img_lable_girl_n : R.drawable.img_lable_girl_s);
        TextView textView = this.gUO;
        if (!z) {
            i = R.color.cp_cont_h;
        }
        al.j(textView, i);
    }
}
