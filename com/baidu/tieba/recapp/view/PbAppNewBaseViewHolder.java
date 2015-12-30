package com.baidu.tieba.recapp.view;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.m;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.AppDownloadView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.n;
import com.baidu.tieba.tbadkCore.data.q;
/* loaded from: classes.dex */
public class PbAppNewBaseViewHolder extends BaseAppViewHolder {
    protected TextView dnR;
    protected ViewGroup dnS;

    public PbAppNewBaseViewHolder(View view) {
        super(view);
        this.dnM = (TextView) view.findViewById(n.g.recommend_title);
        this.dnO = (HeadImageView) view.findViewById(n.g.recommend_icon);
        this.dnK = (TextView) view.findViewById(n.g.recommend_btn);
        this.dnL = (TextView) view.findViewById(n.g.pb_app_push);
        this.dnN = (TextView) view.findViewById(n.g.recommend_content);
        this.dnR = (TextView) view.findViewById(n.g.recommend_time);
        this.dnP = (AppDownloadView) view.findViewById(n.g.recommend_app_download_view);
        this.dnQ = view.findViewById(n.g.divider_line);
        this.dnS = (ViewGroup) view.findViewById(n.g.layout);
        this.dnO.setClickable(false);
    }

    @Override // com.baidu.tieba.recapp.PbRecBaseViewHolder
    public void update(q qVar, int i, boolean z) {
        super.update(qVar, i, z);
        if (qVar != null) {
            this.dnM.setText(ax.d(qVar.aFb().trim(), 7, "..."));
            if (!m.qQ().qS()) {
                ViewGroup.LayoutParams layoutParams = this.dnO.getLayoutParams();
                layoutParams.width = (int) this.rootView.getResources().getDimension(n.e.ds30);
                this.dnO.setLayoutParams(layoutParams);
                this.dnO.setVisibility(4);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.dnS.getLayoutParams();
                marginLayoutParams.leftMargin = (int) this.rootView.getResources().getDimension(n.e.ds50);
                this.dnS.setLayoutParams(marginLayoutParams);
            } else {
                ViewGroup.LayoutParams layoutParams2 = this.dnO.getLayoutParams();
                layoutParams2.width = (int) this.rootView.getResources().getDimension(n.e.ds60);
                this.dnO.setLayoutParams(layoutParams2);
                this.dnO.setVisibility(0);
                if (!TextUtils.isEmpty(qVar.aFc())) {
                    this.dnO.d(qVar.aFc(), z ? 17 : 18, false);
                }
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.dnS.getLayoutParams();
                marginLayoutParams2.leftMargin = (int) this.rootView.getResources().getDimension(n.e.ds80);
                this.dnS.setLayoutParams(marginLayoutParams2);
            }
            String s = ax.s(qVar.aFe());
            if (s == null) {
                s = "";
            }
            this.dnR.setText(s);
            if (StringUtils.isNull(qVar.aFd())) {
                this.dnN.setVisibility(8);
            } else {
                this.dnN.setVisibility(0);
                this.dnN.setText(getFixedChineseString(qVar.aFd()));
            }
            this.dnK.setTag(this);
            this.rootView.setBackgroundDrawable(null);
            if (qVar.aFh()) {
                this.dnK.setVisibility(8);
                this.dnL.setVisibility(0);
                this.dnM.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            } else {
                this.dnK.setVisibility(0);
                this.dnL.setVisibility(8);
                this.dnM.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, as.getDrawable(n.f.icon_extend), (Drawable) null);
            }
            a(qVar, i);
        }
    }

    @Override // com.baidu.tieba.recapp.view.BaseAppViewHolder
    protected void axS() {
        if (this.dnK != null && this.rootView != null) {
            as.i((View) this.dnK, n.f.btn_appdownload);
            as.b(this.dnK, n.d.cp_cont_i, 1);
        }
    }

    @Override // com.baidu.tieba.recapp.view.BaseAppViewHolder
    protected int axT() {
        return n.j.pb_app_download;
    }
}
