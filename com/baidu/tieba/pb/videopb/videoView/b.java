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
/* loaded from: classes6.dex */
public class b {
    private View.OnClickListener dbH;
    private TextView iIi;
    private k iIv;
    private int iPk;
    private int iPl;
    private TextView iVR;
    private TextView iVS;
    private View mRootView;
    private int iIt = 0;
    private int iVT = 0;
    private View.OnClickListener iIy = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.videoView.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.dbH != null) {
                b.this.dbH.onClick(view);
            }
            if (j.isNetWorkAvailable()) {
                if (view == null || !(view.getTag() instanceof Boolean) || ((Boolean) view.getTag()).booleanValue()) {
                    if (view != b.this.iVR) {
                        if (view == b.this.iVS) {
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
    private View.OnClickListener iIz = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.videoView.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.dbH != null) {
                b.this.dbH.onClick(view);
            }
        }
    };

    public b(View view) {
        if (view != null) {
            this.mRootView = view;
            this.iVR = (TextView) this.mRootView.findViewById(R.id.all_reply);
            this.iVR.setOnClickListener(this.iIy);
            this.iVS = (TextView) this.mRootView.findViewById(R.id.owner_reply);
            this.iVS.setOnClickListener(this.iIy);
            this.iIi = (TextView) this.mRootView.findViewById(R.id.pb_sort_type);
            this.iIi.setOnClickListener(this.iIz);
            if (com.baidu.tbadk.util.a.aPa().aGp()) {
                aP(2, "");
            } else {
                aP(0, "");
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void setSelection(int i) {
        this.iVT = i;
        if (i == 0) {
            this.iVR.setTypeface(Typeface.defaultFromStyle(1));
            this.iVS.setTypeface(Typeface.defaultFromStyle(0));
            this.iVR.setTextColor(this.iPl);
            this.iVS.setTextColor(this.iPk);
        } else if (i == 1) {
            this.iVR.setTypeface(Typeface.defaultFromStyle(0));
            this.iVS.setTypeface(Typeface.defaultFromStyle(1));
            this.iVR.setTextColor(this.iPk);
            this.iVS.setTextColor(this.iPl);
        }
    }

    public void onChangeSkinType(int i) {
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_h);
        this.iPl = am.getColor(R.color.cp_cont_b);
        this.iPk = am.getColor(R.color.cp_cont_j);
        setSelection(this.iVT);
        am.setViewTextColor(this.iIi, (int) R.color.cp_cont_j);
        this.iIi.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.aDW().a(R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null);
    }

    public void pP(boolean z) {
        if (z) {
            setSelection(1);
        } else {
            setSelection(0);
        }
    }

    public void aP(int i, String str) {
        this.iIt = i;
        this.iIi.setVisibility(0);
        if (str.length() > 0) {
            this.iIi.setText(str);
        } else if (this.iIt == 0) {
            this.iIi.setText(R.string.sort_type_new);
        } else if (this.iIt == 1) {
            this.iIi.setText(R.string.sort_type_old);
        } else if (this.iIt == 2) {
            this.iIi.setText(R.string.sort_type_hot);
        }
    }

    public void a(k kVar) {
        this.iIv = kVar;
        if (kVar != null) {
            if (kVar.zJ == k.ixe) {
                this.iVR.setClickable(true);
                this.iVR.setText(TbadkCoreApplication.getInst().getString(R.string.all_reply));
                this.iVS.setVisibility(0);
                pP(kVar.ixj);
                aP(kVar.sortType, kVar.ixi);
            }
            if (kVar.isDynamic) {
                this.iVS.setVisibility(8);
                this.iIi.setVisibility(8);
            } else {
                this.iVS.setVisibility(0);
                this.iIi.setVisibility(0);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void U(View.OnClickListener onClickListener) {
        this.dbH = onClickListener;
    }
}
