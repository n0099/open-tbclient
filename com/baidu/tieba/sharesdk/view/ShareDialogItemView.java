package com.baidu.tieba.sharesdk.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class ShareDialogItemView extends LinearLayout {
    public static final int ngk = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds104);
    private static final int ngl = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_H_X005);
    private static final int ngm = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_H_X003);
    protected static final int ngn = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.T_X09);
    private Context context;
    protected ImageView ngo;
    private EMTextView ngp;
    private LinearLayout.LayoutParams ngq;
    private LinearLayout.LayoutParams ngr;

    public ShareDialogItemView(Context context) {
        this(context, null);
    }

    public ShareDialogItemView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ShareDialogItemView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.context = context;
    }

    public void setItemIcon(com.baidu.tbadk.core.util.e.a aVar) {
        this.ngo = new ImageView(this.context);
        setTag(Integer.valueOf(aVar.eYQ));
        if (aVar instanceof com.baidu.tbadk.core.util.e.c) {
            com.baidu.tbadk.core.util.f.a.bwV().qq(1).qr(R.color.CAM_X0213).bz(this.ngo);
        }
        this.ngo.setScaleType(ImageView.ScaleType.FIT_XY);
        this.ngo.setImageDrawable(aVar.getDrawable());
        dLi();
    }

    public void setItemIcon(int i, int i2) {
        this.ngo = new ImageView(this.context);
        setTag(Integer.valueOf(i));
        this.ngo.setScaleType(ImageView.ScaleType.FIT_XY);
        com.baidu.tbadk.core.util.f.a.bwV().qq(1).qr(R.color.CAM_X0207).bz(this.ngo);
        this.ngo.setImageDrawable(WebPManager.a(i, i2, (WebPManager.ResourceStateType) null));
        dLi();
    }

    public void setItemIcon(int i, int i2, int i3) {
        this.ngo = new ImageView(this.context);
        setTag(Integer.valueOf(i3));
        this.ngo.setScaleType(ImageView.ScaleType.FIT_XY);
        com.baidu.tbadk.core.util.f.a.bwV().qq(1).qr(R.color.CAM_X0207).bz(this.ngo);
        this.ngo.setImageDrawable(WebPManager.a(i, i2, (WebPManager.ResourceStateType) null));
        dLi();
    }

    public void setItemIcon(com.baidu.tbadk.core.util.e.a aVar, int i) {
        this.ngo = new ImageView(this.context);
        setTag(Integer.valueOf(i));
        if (aVar instanceof com.baidu.tbadk.core.util.e.c) {
            com.baidu.tbadk.core.util.f.a.bwV().qq(1).qr(R.color.CAM_X0213).bz(this.ngo);
        }
        this.ngo.setScaleType(ImageView.ScaleType.FIT_XY);
        this.ngo.setImageDrawable(aVar.getDrawable());
        dLi();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dLi() {
        this.ngq = new LinearLayout.LayoutParams(ngk, ngk);
        this.ngq.topMargin = ngl;
        this.ngq.bottomMargin = ngm;
        this.ngq.gravity = 1;
    }

    public void setItemName(int i) {
        this.ngp = new EMTextView(this.context);
        this.ngp.setTextSize(0, ngn);
        this.ngp.setText(i);
        ao.setViewTextColor(this.ngp, R.color.CAM_X0107);
        this.ngr = new LinearLayout.LayoutParams(-2, -2);
        this.ngr.gravity = 1;
    }

    public ShareDialogItemView dLd() {
        setOrientation(1);
        addView(this.ngo, this.ngq);
        addView(this.ngp, this.ngr);
        return this;
    }
}
