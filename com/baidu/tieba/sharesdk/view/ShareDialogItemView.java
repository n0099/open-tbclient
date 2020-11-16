package com.baidu.tieba.sharesdk.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes23.dex */
public class ShareDialogItemView extends LinearLayout {
    public static final int mMC = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds104);
    private static final int mMD = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_H_X005);
    private static final int mME = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_H_X003);
    private static final int mMF = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.T_X09);
    private Context context;
    private ImageView mMG;
    private EMTextView mMH;
    private LinearLayout.LayoutParams mMI;
    private LinearLayout.LayoutParams mMJ;

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

    public void setItemIcon(com.baidu.tbadk.core.util.d.a aVar) {
        this.mMG = new ImageView(this.context);
        setTag(Integer.valueOf(aVar.eHH));
        if (aVar instanceof com.baidu.tbadk.core.util.d.c) {
            com.baidu.tbadk.core.util.e.a.brc().pF(1).pG(R.color.CAM_X0213).bn(this.mMG);
        }
        this.mMG.setScaleType(ImageView.ScaleType.FIT_XY);
        this.mMG.setImageDrawable(aVar.getDrawable());
        dGa();
    }

    public void setItemIcon(int i, int i2) {
        this.mMG = new ImageView(this.context);
        setTag(Integer.valueOf(i));
        this.mMG.setScaleType(ImageView.ScaleType.FIT_XY);
        com.baidu.tbadk.core.util.e.a.brc().pF(1).pG(R.color.CAM_X0207).bn(this.mMG);
        this.mMG.setImageDrawable(WebPManager.a(i, i2, (WebPManager.ResourceStateType) null));
        dGa();
    }

    public void setItemIcon(int i, int i2, int i3) {
        this.mMG = new ImageView(this.context);
        setTag(Integer.valueOf(i3));
        this.mMG.setScaleType(ImageView.ScaleType.FIT_XY);
        com.baidu.tbadk.core.util.e.a.brc().pF(1).pG(R.color.CAM_X0207).bn(this.mMG);
        this.mMG.setImageDrawable(WebPManager.a(i, i2, (WebPManager.ResourceStateType) null));
        dGa();
    }

    public void setItemIcon(com.baidu.tbadk.core.util.d.a aVar, int i) {
        this.mMG = new ImageView(this.context);
        setTag(Integer.valueOf(i));
        if (aVar instanceof com.baidu.tbadk.core.util.d.c) {
            com.baidu.tbadk.core.util.e.a.brc().pF(1).pG(R.color.CAM_X0213).bn(this.mMG);
        }
        this.mMG.setScaleType(ImageView.ScaleType.FIT_XY);
        this.mMG.setImageDrawable(aVar.getDrawable());
        dGa();
    }

    private void dGa() {
        this.mMI = new LinearLayout.LayoutParams(mMC, mMC);
        this.mMI.topMargin = mMD;
        this.mMI.bottomMargin = mME;
        this.mMI.gravity = 1;
    }

    public void setItemName(int i) {
        this.mMH = new EMTextView(this.context);
        this.mMH.setTextSize(0, mMF);
        this.mMH.setText(i);
        ap.setViewTextColor(this.mMH, R.color.CAM_X0107);
        this.mMJ = new LinearLayout.LayoutParams(-2, -2);
        this.mMJ.gravity = 1;
    }

    public ShareDialogItemView dGb() {
        setOrientation(1);
        addView(this.mMG, this.mMI);
        addView(this.mMH, this.mMJ);
        return this;
    }
}
