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
/* loaded from: classes7.dex */
public class ShareDialogItemView extends LinearLayout {
    public static final int nbF = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds104);
    private static final int nbG = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_H_X005);
    private static final int nbH = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_H_X003);
    protected static final int nbI = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.T_X09);
    private Context context;
    protected ImageView nbJ;
    private EMTextView nbK;
    private LinearLayout.LayoutParams nbL;
    private LinearLayout.LayoutParams nbM;

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
        this.nbJ = new ImageView(this.context);
        setTag(Integer.valueOf(aVar.eUf));
        if (aVar instanceof com.baidu.tbadk.core.util.e.c) {
            com.baidu.tbadk.core.util.f.a.btb().oJ(1).oK(R.color.CAM_X0213).bz(this.nbJ);
        }
        this.nbJ.setScaleType(ImageView.ScaleType.FIT_XY);
        this.nbJ.setImageDrawable(aVar.getDrawable());
        dHq();
    }

    public void setItemIcon(int i, int i2) {
        this.nbJ = new ImageView(this.context);
        setTag(Integer.valueOf(i));
        this.nbJ.setScaleType(ImageView.ScaleType.FIT_XY);
        com.baidu.tbadk.core.util.f.a.btb().oJ(1).oK(R.color.CAM_X0207).bz(this.nbJ);
        this.nbJ.setImageDrawable(WebPManager.a(i, i2, (WebPManager.ResourceStateType) null));
        dHq();
    }

    public void setItemIcon(int i, int i2, int i3) {
        this.nbJ = new ImageView(this.context);
        setTag(Integer.valueOf(i3));
        this.nbJ.setScaleType(ImageView.ScaleType.FIT_XY);
        com.baidu.tbadk.core.util.f.a.btb().oJ(1).oK(R.color.CAM_X0207).bz(this.nbJ);
        this.nbJ.setImageDrawable(WebPManager.a(i, i2, (WebPManager.ResourceStateType) null));
        dHq();
    }

    public void setItemIcon(com.baidu.tbadk.core.util.e.a aVar, int i) {
        this.nbJ = new ImageView(this.context);
        setTag(Integer.valueOf(i));
        if (aVar instanceof com.baidu.tbadk.core.util.e.c) {
            com.baidu.tbadk.core.util.f.a.btb().oJ(1).oK(R.color.CAM_X0213).bz(this.nbJ);
        }
        this.nbJ.setScaleType(ImageView.ScaleType.FIT_XY);
        this.nbJ.setImageDrawable(aVar.getDrawable());
        dHq();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dHq() {
        this.nbL = new LinearLayout.LayoutParams(nbF, nbF);
        this.nbL.topMargin = nbG;
        this.nbL.bottomMargin = nbH;
        this.nbL.gravity = 1;
    }

    public void setItemName(int i) {
        this.nbK = new EMTextView(this.context);
        this.nbK.setTextSize(0, nbI);
        this.nbK.setText(i);
        ao.setViewTextColor(this.nbK, R.color.CAM_X0107);
        this.nbM = new LinearLayout.LayoutParams(-2, -2);
        this.nbM.gravity = 1;
    }

    public ShareDialogItemView dHl() {
        setOrientation(1);
        addView(this.nbJ, this.nbL);
        addView(this.nbK, this.nbM);
        return this;
    }
}
