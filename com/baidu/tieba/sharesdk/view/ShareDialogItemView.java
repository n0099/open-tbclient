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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes7.dex */
public class ShareDialogItemView extends LinearLayout {
    public static final int nnR = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds104);
    private static final int nnS = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_H_X005);
    private static final int nnT = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_H_X003);
    protected static final int nnU = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.T_X09);
    private Context context;
    protected ImageView nnV;
    private EMTextView nnW;
    private LinearLayout.LayoutParams nnX;
    private LinearLayout.LayoutParams nnY;

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
        this.nnV = new ImageView(this.context);
        setTag(Integer.valueOf(aVar.eXU));
        if (aVar instanceof com.baidu.tbadk.core.util.e.c) {
            com.baidu.tbadk.core.util.f.a.bty().oP(1).oQ(R.color.CAM_X0213).bv(this.nnV);
        }
        this.nnV.setScaleType(ImageView.ScaleType.FIT_XY);
        this.nnV.setImageDrawable(aVar.getDrawable());
        dJR();
    }

    public void setItemIcon(int i, int i2) {
        this.nnV = new ImageView(this.context);
        setTag(Integer.valueOf(i));
        this.nnV.setScaleType(ImageView.ScaleType.FIT_XY);
        com.baidu.tbadk.core.util.f.a.bty().oP(1).oQ(R.color.CAM_X0207).bv(this.nnV);
        this.nnV.setImageDrawable(WebPManager.a(i, i2, (WebPManager.ResourceStateType) null));
        dJR();
    }

    public void setItemIcon(int i, int i2, int i3) {
        this.nnV = new ImageView(this.context);
        setTag(Integer.valueOf(i3));
        this.nnV.setScaleType(ImageView.ScaleType.FIT_XY);
        com.baidu.tbadk.core.util.f.a.bty().oP(1).oQ(R.color.CAM_X0207).bv(this.nnV);
        this.nnV.setImageDrawable(WebPManager.a(i, i2, (WebPManager.ResourceStateType) null));
        dJR();
    }

    public void setItemIcon(com.baidu.tbadk.core.util.e.a aVar, int i) {
        this.nnV = new ImageView(this.context);
        setTag(Integer.valueOf(i));
        if (aVar instanceof com.baidu.tbadk.core.util.e.c) {
            com.baidu.tbadk.core.util.f.a.bty().oP(1).oQ(R.color.CAM_X0213).bv(this.nnV);
        }
        this.nnV.setScaleType(ImageView.ScaleType.FIT_XY);
        this.nnV.setImageDrawable(aVar.getDrawable());
        dJR();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dJR() {
        this.nnX = new LinearLayout.LayoutParams(nnR, nnR);
        this.nnX.topMargin = nnS;
        this.nnX.bottomMargin = nnT;
        this.nnX.gravity = 1;
    }

    public void setItemName(int i) {
        this.nnW = new EMTextView(this.context);
        this.nnW.setTextSize(0, nnU);
        this.nnW.setText(i);
        ap.setViewTextColor(this.nnW, R.color.CAM_X0107);
        this.nnY = new LinearLayout.LayoutParams(-2, -2);
        this.nnY.gravity = 1;
    }

    public ShareDialogItemView dJM() {
        setOrientation(1);
        addView(this.nnV, this.nnX);
        addView(this.nnW, this.nnY);
        return this;
    }
}
