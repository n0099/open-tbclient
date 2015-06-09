package com.baidu.tieba.recapp.view;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.n;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.o;
import com.baidu.tieba.p;
import com.baidu.tieba.q;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.data.i;
/* loaded from: classes.dex */
public class PbAppNewViewHolder extends BaseAppViewHolder {
    protected TbImageView cbr;
    protected TextView cbs;
    protected ViewGroup cbt;

    public PbAppNewViewHolder(View view) {
        super(view);
        this.cbn = (TextView) view.findViewById(q.recommend_title);
        this.cbp = (HeadImageView) view.findViewById(q.recommend_icon);
        this.cbm = (TextView) view.findViewById(q.recommend_btn);
        this.cbo = (TextView) view.findViewById(q.recommend_content);
        this.cbr = (TbImageView) view.findViewById(q.recommend_img);
        this.cbs = (TextView) view.findViewById(q.recommend_time);
        this.cbq = view.findViewById(q.divider_line);
        this.cbt = (ViewGroup) view.findViewById(q.layout);
        this.cbp.setClickable(false);
    }

    @Override // com.baidu.tieba.recapp.PbRecBaseViewHolder
    public void update(i iVar, int i, boolean z) {
        super.update(iVar, i, z);
        if (iVar != null) {
            this.cbn.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ay.getDrawable(p.icon_extend), (Drawable) null);
            this.cbn.setText(iVar.aon());
            if (!n.qc().qe()) {
                ViewGroup.LayoutParams layoutParams = this.cbp.getLayoutParams();
                layoutParams.width = (int) this.rootView.getResources().getDimension(o.ds30);
                this.cbp.setLayoutParams(layoutParams);
                this.cbp.setVisibility(4);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.cbt.getLayoutParams();
                marginLayoutParams.leftMargin = (int) this.rootView.getResources().getDimension(o.ds50);
                this.cbt.setLayoutParams(marginLayoutParams);
            } else {
                ViewGroup.LayoutParams layoutParams2 = this.cbp.getLayoutParams();
                layoutParams2.width = (int) this.rootView.getResources().getDimension(o.ds60);
                this.cbp.setLayoutParams(layoutParams2);
                this.cbp.setVisibility(0);
                if (!TextUtils.isEmpty(iVar.aoo())) {
                    this.cbp.c(iVar.aoo(), z ? 17 : 18, false);
                }
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.cbt.getLayoutParams();
                marginLayoutParams2.leftMargin = (int) this.rootView.getResources().getDimension(o.ds80);
                this.cbt.setLayoutParams(marginLayoutParams2);
            }
            String o = bb.o(iVar.aor());
            if (o == null) {
                o = "";
            }
            this.cbs.setText(o);
            if (StringUtils.isNull(iVar.aop())) {
                this.cbo.setVisibility(8);
            } else {
                this.cbo.setVisibility(0);
                this.cbo.setText(getFixedChineseString(iVar.aop()));
            }
            ViewGroup.LayoutParams layoutParams3 = this.cbr.getLayoutParams();
            layoutParams3.width = (int) (this.rootView.getResources().getDimension(o.ds594) - this.rootView.getResources().getDimension(o.ds20));
            layoutParams3.height = (int) (this.rootView.getResources().getDimension(o.ds260) - this.rootView.getResources().getDimension(o.ds10));
            this.cbr.setLayoutParams(layoutParams3);
            if (!StringUtils.isNull(iVar.aoq()) && n.qc().qg()) {
                this.cbr.setVisibility(0);
                this.cbr.c(iVar.aoq(), z ? 17 : 18, false);
            } else {
                this.cbr.setVisibility(8);
            }
            this.cbm.setTag(this);
            this.rootView.setBackgroundDrawable(null);
            ahn();
            if (iVar.aow()) {
                this.cbm.setVisibility(8);
            } else {
                this.cbm.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tieba.recapp.view.BaseAppViewHolder
    protected void aho() {
        if (this.cbm != null && this.rootView != null) {
            ay.i((View) this.cbm, p.btn_appdownload);
            ay.b(this.cbm, com.baidu.tieba.n.cp_cont_i, 1);
        }
    }

    @Override // com.baidu.tieba.recapp.view.BaseAppViewHolder
    protected void ahp() {
        if (this.cbm != null && this.rootView != null) {
            ay.i((View) this.cbm, p.btn_content_download_d);
            ay.b(this.cbm, com.baidu.tieba.n.faceshop_downloaded_text, 1);
        }
    }

    @Override // com.baidu.tieba.recapp.view.BaseAppViewHolder
    protected int ahq() {
        return t.pb_app_download;
    }
}
