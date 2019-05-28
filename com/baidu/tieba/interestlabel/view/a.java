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
    private TextView gUH;
    private TextView gUI;
    private ImageView gUJ;
    private TextView gUK;
    private ImageView gUL;
    private TextView gUM;
    private int gUN;
    private int gUO;
    private int gUP;

    public a(Context context) {
        this.epX = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.label_recommend_header, (ViewGroup) null);
        this.gUH = (TextView) this.epX.findViewById(R.id.choose_like_label);
        this.gUI = (TextView) this.epX.findViewById(R.id.recommend_interest_thread);
        this.gUJ = (ImageView) this.epX.findViewById(R.id.male_icon);
        this.gUK = (TextView) this.epX.findViewById(R.id.male_text);
        this.gUL = (ImageView) this.epX.findViewById(R.id.female_icon);
        this.gUM = (TextView) this.epX.findViewById(R.id.female_text);
        this.gUJ.setOnClickListener(this);
        this.gUL.setOnClickListener(this);
        onChangeSkinType();
    }

    private void onChangeSkinType() {
        al.j(this.gUH, R.color.cp_cont_b);
        al.j(this.gUI, R.color.cp_cont_d);
        al.c(this.gUJ, (int) R.drawable.img_lable_boy_n);
        al.j(this.gUK, R.color.cp_cont_d);
        al.c(this.gUL, (int) R.drawable.img_lable_girl_n);
        al.j(this.gUM, R.color.cp_cont_d);
    }

    public void setData(List<com.baidu.tieba.interestlabel.b.a> list) {
        if (v.Z(list) == 2) {
            this.gUN = list.get(0).labelId;
            this.gUO = list.get(1).labelId;
        }
    }

    public ViewGroup bGL() {
        return this.epX;
    }

    public int bGM() {
        return this.gUP;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        int i = R.color.cp_cont_d;
        if (view == this.gUJ) {
            z = true;
        } else {
            z = view == this.gUL ? false : false;
        }
        this.gUP = z ? this.gUN : this.gUO;
        al.c(this.gUJ, z ? R.drawable.img_lable_boy_s : R.drawable.img_lable_boy_n);
        al.j(this.gUK, z ? R.color.cp_link_tip_a : R.color.cp_cont_d);
        al.c(this.gUL, z ? R.drawable.img_lable_girl_n : R.drawable.img_lable_girl_s);
        TextView textView = this.gUM;
        if (!z) {
            i = R.color.cp_cont_h;
        }
        al.j(textView, i);
    }
}
