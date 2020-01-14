package com.baidu.tieba.pb.videopb.videoView;

import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.data.k;
/* loaded from: classes7.dex */
public class b {
    private View.OnClickListener dbS;
    private TextView iLM;
    private k iLZ;
    private int iSO;
    private int iSP;
    private TextView iZA;
    private TextView iZz;
    private View mRootView;
    private int iLX = 0;
    private int iZB = 0;
    private View.OnClickListener iMc = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.videoView.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.dbS != null) {
                b.this.dbS.onClick(view);
            }
            if (j.isNetWorkAvailable()) {
                if (view == null || !(view.getTag() instanceof Boolean) || ((Boolean) view.getTag()).booleanValue()) {
                    if (view != b.this.iZz) {
                        if (view == b.this.iZA) {
                            b.this.setSelection(1);
                            return;
                        }
                        return;
                    }
                    b.this.setSelection(0);
                }
            }
        }
    };
    private View.OnClickListener iMd = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.videoView.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.dbS != null) {
                b.this.dbS.onClick(view);
            }
        }
    };

    public b(View view) {
        if (view != null) {
            this.mRootView = view;
            this.iZz = (TextView) this.mRootView.findViewById(R.id.all_reply);
            this.iZz.setOnClickListener(this.iMc);
            this.iZA = (TextView) this.mRootView.findViewById(R.id.owner_reply);
            this.iZA.setOnClickListener(this.iMc);
            this.iLM = (TextView) this.mRootView.findViewById(R.id.pb_sort_type);
            this.iLM.setOnClickListener(this.iMd);
            if (com.baidu.tbadk.util.a.aPt().aGI()) {
                aV(2, "");
            } else {
                aV(0, "");
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void setSelection(int i) {
        this.iZB = i;
        if (i == 0) {
            this.iZz.setTypeface(Typeface.defaultFromStyle(1));
            this.iZA.setTypeface(Typeface.defaultFromStyle(0));
            this.iZz.setTextColor(this.iSP);
            this.iZA.setTextColor(this.iSO);
        } else if (i == 1) {
            this.iZz.setTypeface(Typeface.defaultFromStyle(0));
            this.iZA.setTypeface(Typeface.defaultFromStyle(1));
            this.iZz.setTextColor(this.iSO);
            this.iZA.setTextColor(this.iSP);
        }
    }

    public void onChangeSkinType(int i) {
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_h);
        this.iSP = am.getColor(R.color.cp_cont_b);
        this.iSO = am.getColor(R.color.cp_cont_j);
        setSelection(this.iZB);
        am.setViewTextColor(this.iLM, (int) R.color.cp_cont_j);
        this.iLM.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.aEp().a(R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null);
    }

    public void qb(boolean z) {
        if (z) {
            setSelection(1);
        } else {
            setSelection(0);
        }
    }

    public void aV(int i, String str) {
        this.iLX = i;
        this.iLM.setVisibility(0);
        if (str.length() > 0) {
            this.iLM.setText(str);
        } else if (this.iLX == 0) {
            this.iLM.setText(R.string.sort_type_new);
        } else if (this.iLX == 1) {
            this.iLM.setText(R.string.sort_type_old);
        } else if (this.iLX == 2) {
            this.iLM.setText(R.string.sort_type_hot);
        }
    }

    public void a(k kVar) {
        this.iLZ = kVar;
        if (kVar != null) {
            if (kVar.zN == k.iAI) {
                this.iZz.setClickable(true);
                this.iZz.setText(TbadkCoreApplication.getInst().getString(R.string.all_reply));
                this.iZA.setVisibility(0);
                qb(kVar.iAN);
                aV(kVar.sortType, kVar.iAM);
            }
            if (kVar.isDynamic) {
                this.iZA.setVisibility(8);
                this.iLM.setVisibility(8);
            } else {
                this.iZA.setVisibility(0);
                this.iLM.setVisibility(0);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void T(View.OnClickListener onClickListener) {
        this.dbS = onClickListener;
    }
}
