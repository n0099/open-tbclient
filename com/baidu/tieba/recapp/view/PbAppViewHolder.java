package com.baidu.tieba.recapp.view;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.l;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.b.j;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.z;
/* loaded from: classes.dex */
public class PbAppViewHolder extends BaseAppViewHolder {
    public PbAppViewHolder(View view) {
        super(view);
        this.bLb = (TextView) view.findViewById(w.recommend_title);
        this.bLc = (TextView) view.findViewById(w.recommend_content);
        this.bLd = (HeadImageView) view.findViewById(w.recommend_icon);
        this.bLa = (TextView) view.findViewById(w.recommend_btn);
        this.bLe = view.findViewById(w.divider_line);
        view.setTag(this);
        this.bLd.setClickable(false);
    }

    @Override // com.baidu.tieba.recapp.PbRecBaseViewHolder
    public void update(j jVar, int i, boolean z) {
        super.update(jVar, i, z);
        if (jVar != null) {
            this.bLb.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ax.getDrawable(v.icon_extend), (Drawable) null);
            this.bLb.setText(jVar.agy());
            if (StringUtils.isNull(jVar.agA())) {
                this.bLc.setVisibility(8);
            } else {
                this.bLc.setVisibility(0);
                this.bLc.setText(getFixedChineseString(jVar.agA()));
            }
            if (!l.mc().me()) {
                ViewGroup.LayoutParams layoutParams = this.bLd.getLayoutParams();
                layoutParams.width = (int) this.rootView.getResources().getDimension(u.ds30);
                this.bLd.setLayoutParams(layoutParams);
                this.bLd.setVisibility(4);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.bLc.getLayoutParams();
                marginLayoutParams.leftMargin = (int) this.rootView.getResources().getDimension(u.ds50);
                this.bLc.setLayoutParams(marginLayoutParams);
            } else {
                ViewGroup.LayoutParams layoutParams2 = this.bLd.getLayoutParams();
                layoutParams2.width = (int) this.rootView.getResources().getDimension(u.ds60);
                this.bLd.setLayoutParams(layoutParams2);
                this.bLd.setVisibility(0);
                if (!TextUtils.isEmpty(jVar.agz())) {
                    this.bLd.d(jVar.agz(), z ? 17 : 18, false);
                }
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.bLc.getLayoutParams();
                marginLayoutParams2.leftMargin = (int) this.rootView.getResources().getDimension(u.ds80);
                this.bLc.setLayoutParams(marginLayoutParams2);
            }
            this.bLa.setTag(this);
            this.rootView.setBackgroundDrawable(null);
            abN();
        }
    }

    @Override // com.baidu.tieba.recapp.view.BaseAppViewHolder
    protected void abO() {
        if (this.bLa != null && this.rootView != null) {
            ax.i((View) this.bLa, v.frs_praise_btn_bg);
            ax.b(this.bLa, t.cp_cont_b, 1);
        }
    }

    @Override // com.baidu.tieba.recapp.view.BaseAppViewHolder
    protected void abP() {
        if (this.bLa != null && this.rootView != null) {
            ax.i((View) this.bLa, v.frs_praise_btn_bg);
            ax.b(this.bLa, t.cp_cont_b, 1);
        }
    }

    @Override // com.baidu.tieba.recapp.view.BaseAppViewHolder
    protected int abQ() {
        return z.download;
    }
}
