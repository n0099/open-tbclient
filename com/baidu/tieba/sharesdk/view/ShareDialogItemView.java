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
    public static final int ngl = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds104);
    private static final int ngm = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_H_X005);
    private static final int ngn = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_H_X003);
    protected static final int ngo = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.T_X09);
    private Context context;
    protected ImageView ngp;
    private EMTextView ngq;
    private LinearLayout.LayoutParams ngr;
    private LinearLayout.LayoutParams ngs;

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
        this.ngp = new ImageView(this.context);
        setTag(Integer.valueOf(aVar.eYQ));
        if (aVar instanceof com.baidu.tbadk.core.util.e.c) {
            com.baidu.tbadk.core.util.f.a.bwU().qq(1).qr(R.color.CAM_X0213).bz(this.ngp);
        }
        this.ngp.setScaleType(ImageView.ScaleType.FIT_XY);
        this.ngp.setImageDrawable(aVar.getDrawable());
        dLh();
    }

    public void setItemIcon(int i, int i2) {
        this.ngp = new ImageView(this.context);
        setTag(Integer.valueOf(i));
        this.ngp.setScaleType(ImageView.ScaleType.FIT_XY);
        com.baidu.tbadk.core.util.f.a.bwU().qq(1).qr(R.color.CAM_X0207).bz(this.ngp);
        this.ngp.setImageDrawable(WebPManager.a(i, i2, (WebPManager.ResourceStateType) null));
        dLh();
    }

    public void setItemIcon(int i, int i2, int i3) {
        this.ngp = new ImageView(this.context);
        setTag(Integer.valueOf(i3));
        this.ngp.setScaleType(ImageView.ScaleType.FIT_XY);
        com.baidu.tbadk.core.util.f.a.bwU().qq(1).qr(R.color.CAM_X0207).bz(this.ngp);
        this.ngp.setImageDrawable(WebPManager.a(i, i2, (WebPManager.ResourceStateType) null));
        dLh();
    }

    public void setItemIcon(com.baidu.tbadk.core.util.e.a aVar, int i) {
        this.ngp = new ImageView(this.context);
        setTag(Integer.valueOf(i));
        if (aVar instanceof com.baidu.tbadk.core.util.e.c) {
            com.baidu.tbadk.core.util.f.a.bwU().qq(1).qr(R.color.CAM_X0213).bz(this.ngp);
        }
        this.ngp.setScaleType(ImageView.ScaleType.FIT_XY);
        this.ngp.setImageDrawable(aVar.getDrawable());
        dLh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dLh() {
        this.ngr = new LinearLayout.LayoutParams(ngl, ngl);
        this.ngr.topMargin = ngm;
        this.ngr.bottomMargin = ngn;
        this.ngr.gravity = 1;
    }

    public void setItemName(int i) {
        this.ngq = new EMTextView(this.context);
        this.ngq.setTextSize(0, ngo);
        this.ngq.setText(i);
        ao.setViewTextColor(this.ngq, R.color.CAM_X0107);
        this.ngs = new LinearLayout.LayoutParams(-2, -2);
        this.ngs.gravity = 1;
    }

    public ShareDialogItemView dLc() {
        setOrientation(1);
        addView(this.ngp, this.ngr);
        addView(this.ngq, this.ngs);
        return this;
    }
}
