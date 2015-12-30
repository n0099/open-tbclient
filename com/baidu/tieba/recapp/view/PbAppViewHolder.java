package com.baidu.tieba.recapp.view;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.m;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.n;
import com.baidu.tieba.tbadkCore.data.q;
/* loaded from: classes.dex */
public class PbAppViewHolder extends BaseAppViewHolder {
    public PbAppViewHolder(View view) {
        super(view);
        this.dnM = (TextView) view.findViewById(n.g.recommend_title);
        this.dnN = (TextView) view.findViewById(n.g.recommend_content);
        this.dnO = (HeadImageView) view.findViewById(n.g.recommend_icon);
        this.dnK = (TextView) view.findViewById(n.g.recommend_btn);
        this.dnQ = view.findViewById(n.g.divider_line);
        this.dnO.setClickable(false);
    }

    @Override // com.baidu.tieba.recapp.PbRecBaseViewHolder
    public void update(q qVar, int i, boolean z) {
        super.update(qVar, i, z);
        if (qVar != null) {
            this.dnM.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, as.getDrawable(n.f.icon_extend), (Drawable) null);
            this.dnM.setText(qVar.aFb());
            if (StringUtils.isNull(qVar.aFd())) {
                this.dnN.setVisibility(8);
            } else {
                this.dnN.setVisibility(0);
                this.dnN.setText(getFixedChineseString(qVar.aFd()));
            }
            if (!m.qQ().qS()) {
                ViewGroup.LayoutParams layoutParams = this.dnO.getLayoutParams();
                layoutParams.width = (int) this.rootView.getResources().getDimension(n.e.ds30);
                this.dnO.setLayoutParams(layoutParams);
                this.dnO.setVisibility(4);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.dnN.getLayoutParams();
                marginLayoutParams.leftMargin = (int) this.rootView.getResources().getDimension(n.e.ds50);
                this.dnN.setLayoutParams(marginLayoutParams);
            } else {
                ViewGroup.LayoutParams layoutParams2 = this.dnO.getLayoutParams();
                layoutParams2.width = (int) this.rootView.getResources().getDimension(n.e.ds60);
                this.dnO.setLayoutParams(layoutParams2);
                this.dnO.setVisibility(0);
                if (!TextUtils.isEmpty(qVar.aFc())) {
                    this.dnO.d(qVar.aFc(), z ? 17 : 18, false);
                }
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.dnN.getLayoutParams();
                marginLayoutParams2.leftMargin = (int) this.rootView.getResources().getDimension(n.e.ds80);
                this.dnN.setLayoutParams(marginLayoutParams2);
            }
            this.dnK.setTag(this);
            this.rootView.setBackgroundDrawable(null);
            a(null, i);
        }
    }

    @Override // com.baidu.tieba.recapp.view.BaseAppViewHolder
    protected void axS() {
        if (this.dnK != null && this.rootView != null) {
            as.i((View) this.dnK, n.f.frs_praise_btn_bg);
            as.b(this.dnK, n.d.cp_cont_b, 1);
        }
    }

    @Override // com.baidu.tieba.recapp.view.BaseAppViewHolder
    protected int axT() {
        return n.j.download;
    }
}
