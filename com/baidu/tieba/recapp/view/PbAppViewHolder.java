package com.baidu.tieba.recapp.view;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.l;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.data.q;
/* loaded from: classes.dex */
public class PbAppViewHolder extends BaseAppViewHolder {
    public PbAppViewHolder(View view) {
        super(view);
        this.dCQ = (TextView) view.findViewById(t.g.recommend_title);
        this.dCR = (TextView) view.findViewById(t.g.recommend_content);
        this.dCS = (HeadImageView) view.findViewById(t.g.recommend_icon);
        this.dCO = (TextView) view.findViewById(t.g.recommend_btn);
        this.dCU = view.findViewById(t.g.divider_line);
        this.dCS.setClickable(false);
    }

    @Override // com.baidu.tieba.recapp.PbRecBaseViewHolder
    public void update(q qVar, int i, boolean z) {
        super.update(qVar, i, z);
        if (qVar != null) {
            this.dCQ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ar.getDrawable(t.f.icon_extend), (Drawable) null);
            this.dCQ.setText(qVar.aMh());
            if (StringUtils.isNull(qVar.aMj())) {
                this.dCR.setVisibility(8);
            } else {
                this.dCR.setVisibility(0);
                this.dCR.setText(getFixedChineseString(qVar.aMj()));
            }
            if (!l.rn().rp()) {
                ViewGroup.LayoutParams layoutParams = this.dCS.getLayoutParams();
                layoutParams.width = (int) this.azA.getResources().getDimension(t.e.ds30);
                this.dCS.setLayoutParams(layoutParams);
                this.dCS.setVisibility(4);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.dCR.getLayoutParams();
                marginLayoutParams.leftMargin = (int) this.azA.getResources().getDimension(t.e.ds50);
                this.dCR.setLayoutParams(marginLayoutParams);
            } else {
                ViewGroup.LayoutParams layoutParams2 = this.dCS.getLayoutParams();
                layoutParams2.width = (int) this.azA.getResources().getDimension(t.e.ds60);
                this.dCS.setLayoutParams(layoutParams2);
                this.dCS.setVisibility(0);
                if (!TextUtils.isEmpty(qVar.aMi())) {
                    this.dCS.d(qVar.aMi(), z ? 17 : 18, false);
                }
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.dCR.getLayoutParams();
                marginLayoutParams2.leftMargin = (int) this.azA.getResources().getDimension(t.e.ds80);
                this.dCR.setLayoutParams(marginLayoutParams2);
            }
            this.dCO.setTag(this);
            this.azA.setBackgroundDrawable(null);
            a(null, i);
        }
    }

    @Override // com.baidu.tieba.recapp.view.BaseAppViewHolder
    protected void aEP() {
        if (this.dCO != null && this.azA != null) {
            ar.k(this.dCO, t.f.frs_praise_btn_bg);
            ar.b(this.dCO, t.d.cp_cont_b, 1);
        }
    }

    @Override // com.baidu.tieba.recapp.view.BaseAppViewHolder
    protected int aEQ() {
        return t.j.download;
    }
}
