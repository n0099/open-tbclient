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
/* loaded from: classes24.dex */
public class ShareDialogItemView extends LinearLayout {
    public static final int naH = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds104);
    private static final int naI = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_H_X005);
    private static final int naJ = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_H_X003);
    private static final int naK = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.T_X09);
    private Context context;
    private ImageView naL;
    private EMTextView naM;
    private LinearLayout.LayoutParams naN;
    private LinearLayout.LayoutParams naO;

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
        this.naL = new ImageView(this.context);
        setTag(Integer.valueOf(aVar.eOR));
        if (aVar instanceof com.baidu.tbadk.core.util.d.c) {
            com.baidu.tbadk.core.util.e.a.buz().qf(1).qg(R.color.CAM_X0213).bq(this.naL);
        }
        this.naL.setScaleType(ImageView.ScaleType.FIT_XY);
        this.naL.setImageDrawable(aVar.getDrawable());
        dLp();
    }

    public void setItemIcon(int i, int i2) {
        this.naL = new ImageView(this.context);
        setTag(Integer.valueOf(i));
        this.naL.setScaleType(ImageView.ScaleType.FIT_XY);
        com.baidu.tbadk.core.util.e.a.buz().qf(1).qg(R.color.CAM_X0207).bq(this.naL);
        this.naL.setImageDrawable(WebPManager.a(i, i2, (WebPManager.ResourceStateType) null));
        dLp();
    }

    public void setItemIcon(int i, int i2, int i3) {
        this.naL = new ImageView(this.context);
        setTag(Integer.valueOf(i3));
        this.naL.setScaleType(ImageView.ScaleType.FIT_XY);
        com.baidu.tbadk.core.util.e.a.buz().qf(1).qg(R.color.CAM_X0207).bq(this.naL);
        this.naL.setImageDrawable(WebPManager.a(i, i2, (WebPManager.ResourceStateType) null));
        dLp();
    }

    public void setItemIcon(com.baidu.tbadk.core.util.d.a aVar, int i) {
        this.naL = new ImageView(this.context);
        setTag(Integer.valueOf(i));
        if (aVar instanceof com.baidu.tbadk.core.util.d.c) {
            com.baidu.tbadk.core.util.e.a.buz().qf(1).qg(R.color.CAM_X0213).bq(this.naL);
        }
        this.naL.setScaleType(ImageView.ScaleType.FIT_XY);
        this.naL.setImageDrawable(aVar.getDrawable());
        dLp();
    }

    private void dLp() {
        this.naN = new LinearLayout.LayoutParams(naH, naH);
        this.naN.topMargin = naI;
        this.naN.bottomMargin = naJ;
        this.naN.gravity = 1;
    }

    public void setItemName(int i) {
        this.naM = new EMTextView(this.context);
        this.naM.setTextSize(0, naK);
        this.naM.setText(i);
        ap.setViewTextColor(this.naM, (int) R.color.CAM_X0107);
        this.naO = new LinearLayout.LayoutParams(-2, -2);
        this.naO.gravity = 1;
    }

    public ShareDialogItemView dLq() {
        setOrientation(1);
        addView(this.naL, this.naN);
        addView(this.naM, this.naO);
        return this;
    }
}
