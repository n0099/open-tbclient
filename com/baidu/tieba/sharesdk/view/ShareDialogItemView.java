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
    public static final int nln = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds104);
    private static final int nlo = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_H_X005);
    private static final int nlp = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_H_X003);
    protected static final int nlq = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.T_X09);
    private Context context;
    protected ImageView nlr;
    private EMTextView nls;
    private LinearLayout.LayoutParams nlt;
    private LinearLayout.LayoutParams nlu;

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
        this.nlr = new ImageView(this.context);
        setTag(Integer.valueOf(aVar.eWv));
        if (aVar instanceof com.baidu.tbadk.core.util.e.c) {
            com.baidu.tbadk.core.util.f.a.btv().oO(1).oP(R.color.CAM_X0213).bv(this.nlr);
        }
        this.nlr.setScaleType(ImageView.ScaleType.FIT_XY);
        this.nlr.setImageDrawable(aVar.getDrawable());
        dJB();
    }

    public void setItemIcon(int i, int i2) {
        this.nlr = new ImageView(this.context);
        setTag(Integer.valueOf(i));
        this.nlr.setScaleType(ImageView.ScaleType.FIT_XY);
        com.baidu.tbadk.core.util.f.a.btv().oO(1).oP(R.color.CAM_X0207).bv(this.nlr);
        this.nlr.setImageDrawable(WebPManager.a(i, i2, (WebPManager.ResourceStateType) null));
        dJB();
    }

    public void setItemIcon(int i, int i2, int i3) {
        this.nlr = new ImageView(this.context);
        setTag(Integer.valueOf(i3));
        this.nlr.setScaleType(ImageView.ScaleType.FIT_XY);
        com.baidu.tbadk.core.util.f.a.btv().oO(1).oP(R.color.CAM_X0207).bv(this.nlr);
        this.nlr.setImageDrawable(WebPManager.a(i, i2, (WebPManager.ResourceStateType) null));
        dJB();
    }

    public void setItemIcon(com.baidu.tbadk.core.util.e.a aVar, int i) {
        this.nlr = new ImageView(this.context);
        setTag(Integer.valueOf(i));
        if (aVar instanceof com.baidu.tbadk.core.util.e.c) {
            com.baidu.tbadk.core.util.f.a.btv().oO(1).oP(R.color.CAM_X0213).bv(this.nlr);
        }
        this.nlr.setScaleType(ImageView.ScaleType.FIT_XY);
        this.nlr.setImageDrawable(aVar.getDrawable());
        dJB();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dJB() {
        this.nlt = new LinearLayout.LayoutParams(nln, nln);
        this.nlt.topMargin = nlo;
        this.nlt.bottomMargin = nlp;
        this.nlt.gravity = 1;
    }

    public void setItemName(int i) {
        this.nls = new EMTextView(this.context);
        this.nls.setTextSize(0, nlq);
        this.nls.setText(i);
        ap.setViewTextColor(this.nls, R.color.CAM_X0107);
        this.nlu = new LinearLayout.LayoutParams(-2, -2);
        this.nlu.gravity = 1;
    }

    public ShareDialogItemView dJw() {
        setOrientation(1);
        addView(this.nlr, this.nlt);
        addView(this.nls, this.nlu);
        return this;
    }
}
