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
    public static final int naF = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds104);
    private static final int naG = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_H_X005);
    private static final int naH = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_H_X003);
    private static final int naI = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.T_X09);
    private Context context;
    private ImageView naJ;
    private EMTextView naK;
    private LinearLayout.LayoutParams naL;
    private LinearLayout.LayoutParams naM;

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
        this.naJ = new ImageView(this.context);
        setTag(Integer.valueOf(aVar.eOR));
        if (aVar instanceof com.baidu.tbadk.core.util.d.c) {
            com.baidu.tbadk.core.util.e.a.buz().qf(1).qg(R.color.CAM_X0213).bq(this.naJ);
        }
        this.naJ.setScaleType(ImageView.ScaleType.FIT_XY);
        this.naJ.setImageDrawable(aVar.getDrawable());
        dLo();
    }

    public void setItemIcon(int i, int i2) {
        this.naJ = new ImageView(this.context);
        setTag(Integer.valueOf(i));
        this.naJ.setScaleType(ImageView.ScaleType.FIT_XY);
        com.baidu.tbadk.core.util.e.a.buz().qf(1).qg(R.color.CAM_X0207).bq(this.naJ);
        this.naJ.setImageDrawable(WebPManager.a(i, i2, (WebPManager.ResourceStateType) null));
        dLo();
    }

    public void setItemIcon(int i, int i2, int i3) {
        this.naJ = new ImageView(this.context);
        setTag(Integer.valueOf(i3));
        this.naJ.setScaleType(ImageView.ScaleType.FIT_XY);
        com.baidu.tbadk.core.util.e.a.buz().qf(1).qg(R.color.CAM_X0207).bq(this.naJ);
        this.naJ.setImageDrawable(WebPManager.a(i, i2, (WebPManager.ResourceStateType) null));
        dLo();
    }

    public void setItemIcon(com.baidu.tbadk.core.util.d.a aVar, int i) {
        this.naJ = new ImageView(this.context);
        setTag(Integer.valueOf(i));
        if (aVar instanceof com.baidu.tbadk.core.util.d.c) {
            com.baidu.tbadk.core.util.e.a.buz().qf(1).qg(R.color.CAM_X0213).bq(this.naJ);
        }
        this.naJ.setScaleType(ImageView.ScaleType.FIT_XY);
        this.naJ.setImageDrawable(aVar.getDrawable());
        dLo();
    }

    private void dLo() {
        this.naL = new LinearLayout.LayoutParams(naF, naF);
        this.naL.topMargin = naG;
        this.naL.bottomMargin = naH;
        this.naL.gravity = 1;
    }

    public void setItemName(int i) {
        this.naK = new EMTextView(this.context);
        this.naK.setTextSize(0, naI);
        this.naK.setText(i);
        ap.setViewTextColor(this.naK, (int) R.color.CAM_X0107);
        this.naM = new LinearLayout.LayoutParams(-2, -2);
        this.naM.gravity = 1;
    }

    public ShareDialogItemView dLp() {
        setOrientation(1);
        addView(this.naJ, this.naL);
        addView(this.naK, this.naM);
        return this;
    }
}
