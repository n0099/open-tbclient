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
/* loaded from: classes8.dex */
public class ShareDialogItemView extends LinearLayout {
    public static final int nlN = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds104);
    private static final int nlO = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_H_X005);
    private static final int nlP = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_H_X003);
    protected static final int nlQ = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.T_X09);
    private Context context;
    protected ImageView nlR;
    private EMTextView nlS;
    private LinearLayout.LayoutParams nlT;
    private LinearLayout.LayoutParams nlU;

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
        this.nlR = new ImageView(this.context);
        setTag(Integer.valueOf(aVar.eWv));
        if (aVar instanceof com.baidu.tbadk.core.util.e.c) {
            com.baidu.tbadk.core.util.f.a.btv().oO(1).oP(R.color.CAM_X0213).bv(this.nlR);
        }
        this.nlR.setScaleType(ImageView.ScaleType.FIT_XY);
        this.nlR.setImageDrawable(aVar.getDrawable());
        dJJ();
    }

    public void setItemIcon(int i, int i2) {
        this.nlR = new ImageView(this.context);
        setTag(Integer.valueOf(i));
        this.nlR.setScaleType(ImageView.ScaleType.FIT_XY);
        com.baidu.tbadk.core.util.f.a.btv().oO(1).oP(R.color.CAM_X0207).bv(this.nlR);
        this.nlR.setImageDrawable(WebPManager.a(i, i2, (WebPManager.ResourceStateType) null));
        dJJ();
    }

    public void setItemIcon(int i, int i2, int i3) {
        this.nlR = new ImageView(this.context);
        setTag(Integer.valueOf(i3));
        this.nlR.setScaleType(ImageView.ScaleType.FIT_XY);
        com.baidu.tbadk.core.util.f.a.btv().oO(1).oP(R.color.CAM_X0207).bv(this.nlR);
        this.nlR.setImageDrawable(WebPManager.a(i, i2, (WebPManager.ResourceStateType) null));
        dJJ();
    }

    public void setItemIcon(com.baidu.tbadk.core.util.e.a aVar, int i) {
        this.nlR = new ImageView(this.context);
        setTag(Integer.valueOf(i));
        if (aVar instanceof com.baidu.tbadk.core.util.e.c) {
            com.baidu.tbadk.core.util.f.a.btv().oO(1).oP(R.color.CAM_X0213).bv(this.nlR);
        }
        this.nlR.setScaleType(ImageView.ScaleType.FIT_XY);
        this.nlR.setImageDrawable(aVar.getDrawable());
        dJJ();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dJJ() {
        this.nlT = new LinearLayout.LayoutParams(nlN, nlN);
        this.nlT.topMargin = nlO;
        this.nlT.bottomMargin = nlP;
        this.nlT.gravity = 1;
    }

    public void setItemName(int i) {
        this.nlS = new EMTextView(this.context);
        this.nlS.setTextSize(0, nlQ);
        this.nlS.setText(i);
        ap.setViewTextColor(this.nlS, R.color.CAM_X0107);
        this.nlU = new LinearLayout.LayoutParams(-2, -2);
        this.nlU.gravity = 1;
    }

    public ShareDialogItemView dJE() {
        setOrientation(1);
        addView(this.nlR, this.nlT);
        addView(this.nlS, this.nlU);
        return this;
    }
}
