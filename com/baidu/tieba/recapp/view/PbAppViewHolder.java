package com.baidu.tieba.recapp.view;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.l;
import com.baidu.tbadk.core.util.bc;
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
        this.bML = (TextView) view.findViewById(w.recommend_title);
        this.bMM = (TextView) view.findViewById(w.recommend_content);
        this.bMN = (HeadImageView) view.findViewById(w.recommend_icon);
        this.bMK = (TextView) view.findViewById(w.recommend_btn);
        this.bMO = view.findViewById(w.divider_line);
        view.setTag(this);
        this.bMN.setClickable(false);
    }

    @Override // com.baidu.tieba.recapp.PbRecBaseViewHolder
    public void update(j jVar, int i, boolean z) {
        super.update(jVar, i, z);
        if (jVar != null) {
            this.bML.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, bc.getDrawable(v.icon_extend), (Drawable) null);
            this.bML.setText(jVar.agY());
            if (StringUtils.isNull(jVar.aha())) {
                this.bMM.setVisibility(8);
            } else {
                this.bMM.setVisibility(0);
                this.bMM.setText(getFixedChineseString(jVar.aha()));
            }
            if (!l.lV().lX()) {
                ViewGroup.LayoutParams layoutParams = this.bMN.getLayoutParams();
                layoutParams.width = (int) this.rootView.getResources().getDimension(u.ds30);
                this.bMN.setLayoutParams(layoutParams);
                this.bMN.setVisibility(4);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.bMM.getLayoutParams();
                marginLayoutParams.leftMargin = (int) this.rootView.getResources().getDimension(u.ds50);
                this.bMM.setLayoutParams(marginLayoutParams);
            } else {
                ViewGroup.LayoutParams layoutParams2 = this.bMN.getLayoutParams();
                layoutParams2.width = (int) this.rootView.getResources().getDimension(u.ds60);
                this.bMN.setLayoutParams(layoutParams2);
                this.bMN.setVisibility(0);
                if (!TextUtils.isEmpty(jVar.agZ())) {
                    this.bMN.d(jVar.agZ(), z ? 17 : 18, false);
                }
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.bMM.getLayoutParams();
                marginLayoutParams2.leftMargin = (int) this.rootView.getResources().getDimension(u.ds80);
                this.bMM.setLayoutParams(marginLayoutParams2);
            }
            this.bMK.setTag(this);
            this.rootView.setBackgroundDrawable(null);
            acm();
        }
    }

    @Override // com.baidu.tieba.recapp.view.BaseAppViewHolder
    protected void acn() {
        if (this.bMK != null && this.rootView != null) {
            bc.i((View) this.bMK, v.frs_praise_btn_bg);
            bc.b(this.bMK, t.cp_cont_b, 1);
        }
    }

    @Override // com.baidu.tieba.recapp.view.BaseAppViewHolder
    protected void aco() {
        if (this.bMK != null && this.rootView != null) {
            bc.i((View) this.bMK, v.frs_praise_btn_bg);
            bc.b(this.bMK, t.cp_cont_b, 1);
        }
    }

    @Override // com.baidu.tieba.recapp.view.BaseAppViewHolder
    protected int acp() {
        return z.download;
    }
}
