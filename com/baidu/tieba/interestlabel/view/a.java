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
    private ViewGroup epW;
    private TextView gUE;
    private TextView gUF;
    private ImageView gUG;
    private TextView gUH;
    private ImageView gUI;
    private TextView gUJ;
    private int gUK;
    private int gUL;
    private int gUM;

    public a(Context context) {
        this.epW = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.label_recommend_header, (ViewGroup) null);
        this.gUE = (TextView) this.epW.findViewById(R.id.choose_like_label);
        this.gUF = (TextView) this.epW.findViewById(R.id.recommend_interest_thread);
        this.gUG = (ImageView) this.epW.findViewById(R.id.male_icon);
        this.gUH = (TextView) this.epW.findViewById(R.id.male_text);
        this.gUI = (ImageView) this.epW.findViewById(R.id.female_icon);
        this.gUJ = (TextView) this.epW.findViewById(R.id.female_text);
        this.gUG.setOnClickListener(this);
        this.gUI.setOnClickListener(this);
        onChangeSkinType();
    }

    private void onChangeSkinType() {
        al.j(this.gUE, R.color.cp_cont_b);
        al.j(this.gUF, R.color.cp_cont_d);
        al.c(this.gUG, (int) R.drawable.img_lable_boy_n);
        al.j(this.gUH, R.color.cp_cont_d);
        al.c(this.gUI, (int) R.drawable.img_lable_girl_n);
        al.j(this.gUJ, R.color.cp_cont_d);
    }

    public void setData(List<com.baidu.tieba.interestlabel.b.a> list) {
        if (v.Z(list) == 2) {
            this.gUK = list.get(0).labelId;
            this.gUL = list.get(1).labelId;
        }
    }

    public ViewGroup bGI() {
        return this.epW;
    }

    public int bGJ() {
        return this.gUM;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        int i = R.color.cp_cont_d;
        if (view == this.gUG) {
            z = true;
        } else {
            z = view == this.gUI ? false : false;
        }
        this.gUM = z ? this.gUK : this.gUL;
        al.c(this.gUG, z ? R.drawable.img_lable_boy_s : R.drawable.img_lable_boy_n);
        al.j(this.gUH, z ? R.color.cp_link_tip_a : R.color.cp_cont_d);
        al.c(this.gUI, z ? R.drawable.img_lable_girl_n : R.drawable.img_lable_girl_s);
        TextView textView = this.gUJ;
        if (!z) {
            i = R.color.cp_cont_h;
        }
        al.j(textView, i);
    }
}
