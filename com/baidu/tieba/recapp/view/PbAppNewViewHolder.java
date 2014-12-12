package com.baidu.tieba.recapp.view;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.l;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.b.j;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.z;
/* loaded from: classes.dex */
public class PbAppNewViewHolder extends BaseAppViewHolder {
    protected TbImageView bLf;
    protected TextView bLg;
    protected ViewGroup bLh;

    public PbAppNewViewHolder(View view) {
        super(view);
        this.bLb = (TextView) view.findViewById(w.recommend_title);
        this.bLd = (HeadImageView) view.findViewById(w.recommend_icon);
        this.bLa = (TextView) view.findViewById(w.recommend_btn);
        this.bLc = (TextView) view.findViewById(w.recommend_content);
        this.bLf = (TbImageView) view.findViewById(w.recommend_img);
        this.bLg = (TextView) view.findViewById(w.recommend_time);
        this.bLe = view.findViewById(w.divider_line);
        this.bLh = (ViewGroup) view.findViewById(w.layout);
        this.bLd.setClickable(false);
    }

    @Override // com.baidu.tieba.recapp.PbRecBaseViewHolder
    public void update(j jVar, int i, boolean z) {
        super.update(jVar, i, z);
        if (jVar != null) {
            this.bLb.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ax.getDrawable(v.icon_extend), (Drawable) null);
            this.bLb.setText(jVar.agy());
            if (!l.mc().me()) {
                ViewGroup.LayoutParams layoutParams = this.bLd.getLayoutParams();
                layoutParams.width = (int) this.rootView.getResources().getDimension(u.ds30);
                this.bLd.setLayoutParams(layoutParams);
                this.bLd.setVisibility(4);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.bLh.getLayoutParams();
                marginLayoutParams.leftMargin = (int) this.rootView.getResources().getDimension(u.ds50);
                this.bLh.setLayoutParams(marginLayoutParams);
            } else {
                ViewGroup.LayoutParams layoutParams2 = this.bLd.getLayoutParams();
                layoutParams2.width = (int) this.rootView.getResources().getDimension(u.ds60);
                this.bLd.setLayoutParams(layoutParams2);
                this.bLd.setVisibility(0);
                if (!TextUtils.isEmpty(jVar.agz())) {
                    this.bLd.d(jVar.agz(), z ? 17 : 18, false);
                }
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.bLh.getLayoutParams();
                marginLayoutParams2.leftMargin = (int) this.rootView.getResources().getDimension(u.ds80);
                this.bLh.setLayoutParams(marginLayoutParams2);
            }
            String n = ba.n(jVar.agC());
            if (n == null) {
                n = "";
            }
            this.bLg.setText(n);
            if (StringUtils.isNull(jVar.agA())) {
                this.bLc.setVisibility(8);
            } else {
                this.bLc.setVisibility(0);
                this.bLc.setText(getFixedChineseString(jVar.agA()));
            }
            ViewGroup.LayoutParams layoutParams3 = this.bLf.getLayoutParams();
            layoutParams3.width = (int) (this.rootView.getResources().getDimension(u.ds594) - this.rootView.getResources().getDimension(u.ds20));
            layoutParams3.height = (int) (this.rootView.getResources().getDimension(u.ds260) - this.rootView.getResources().getDimension(u.ds10));
            this.bLf.setLayoutParams(layoutParams3);
            if (!StringUtils.isNull(jVar.agB()) && l.mc().mg()) {
                this.bLf.setVisibility(0);
                this.bLf.d(jVar.agB(), z ? 17 : 18, false);
            } else {
                this.bLf.setVisibility(8);
            }
            this.bLa.setTag(this);
            this.rootView.setBackgroundDrawable(null);
            abN();
            if (jVar.agN()) {
                this.bLa.setVisibility(8);
            } else {
                this.bLa.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tieba.recapp.view.BaseAppViewHolder
    protected void abO() {
        if (this.bLa != null && this.rootView != null) {
            ax.i((View) this.bLa, v.btn_appdownload);
            ax.b(this.bLa, t.cp_cont_i, 1);
        }
    }

    @Override // com.baidu.tieba.recapp.view.BaseAppViewHolder
    protected void abP() {
        if (this.bLa != null && this.rootView != null) {
            ax.i((View) this.bLa, v.btn_content_download_d);
            ax.b(this.bLa, t.faceshop_downloaded_text, 1);
        }
    }

    @Override // com.baidu.tieba.recapp.view.BaseAppViewHolder
    protected int abQ() {
        return z.pb_app_download;
    }
}
