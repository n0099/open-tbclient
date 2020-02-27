package com.baidu.tieba.pb.videopb.videoView;

import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.data.j;
/* loaded from: classes9.dex */
public class b {
    private View.OnClickListener dfX;
    private TextView iNh;
    private j iNt;
    private int iUi;
    private int iUj;
    private TextView jba;
    private TextView jbb;
    private View mRootView;
    private int iNr = 0;
    private int jbc = 0;
    private View.OnClickListener iNw = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.videoView.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.dfX != null) {
                b.this.dfX.onClick(view);
            }
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                if (view == null || !(view.getTag() instanceof Boolean) || ((Boolean) view.getTag()).booleanValue()) {
                    if (view != b.this.jba) {
                        if (view == b.this.jbb) {
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
    private View.OnClickListener iNx = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.videoView.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.dfX != null) {
                b.this.dfX.onClick(view);
            }
        }
    };

    public b(View view) {
        if (view != null) {
            this.mRootView = view;
            this.jba = (TextView) this.mRootView.findViewById(R.id.all_reply);
            this.jba.setOnClickListener(this.iNw);
            this.jbb = (TextView) this.mRootView.findViewById(R.id.owner_reply);
            this.jbb.setOnClickListener(this.iNw);
            this.iNh = (TextView) this.mRootView.findViewById(R.id.pb_sort_type);
            this.iNh.setOnClickListener(this.iNx);
            if (com.baidu.tbadk.util.a.aRJ().aIW()) {
                aV(2, "");
            } else {
                aV(0, "");
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void setSelection(int i) {
        this.jbc = i;
        if (i == 0) {
            this.jba.setTypeface(Typeface.defaultFromStyle(1));
            this.jbb.setTypeface(Typeface.defaultFromStyle(0));
            this.jba.setTextColor(this.iUj);
            this.jbb.setTextColor(this.iUi);
        } else if (i == 1) {
            this.jba.setTypeface(Typeface.defaultFromStyle(0));
            this.jbb.setTypeface(Typeface.defaultFromStyle(1));
            this.jba.setTextColor(this.iUi);
            this.jbb.setTextColor(this.iUj);
        }
    }

    public void onChangeSkinType(int i) {
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_h);
        this.iUj = am.getColor(R.color.cp_cont_b);
        this.iUi = am.getColor(R.color.cp_cont_j);
        setSelection(this.jbc);
        am.setViewTextColor(this.iNh, (int) R.color.cp_cont_j);
        this.iNh.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.aGA().a(R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null);
    }

    public void qe(boolean z) {
        if (z) {
            setSelection(1);
        } else {
            setSelection(0);
        }
    }

    public void aV(int i, String str) {
        this.iNr = i;
        this.iNh.setVisibility(0);
        if (str.length() > 0) {
            this.iNh.setText(str);
        } else if (this.iNr == 0) {
            this.iNh.setText(R.string.sort_type_new);
        } else if (this.iNr == 1) {
            this.iNh.setText(R.string.sort_type_old);
        } else if (this.iNr == 2) {
            this.iNh.setText(R.string.sort_type_hot);
        }
    }

    public void a(j jVar) {
        this.iNt = jVar;
        if (jVar != null) {
            if (jVar.Ag == j.iCB) {
                this.jba.setClickable(true);
                this.jba.setText(TbadkCoreApplication.getInst().getString(R.string.all_reply));
                this.jbb.setVisibility(0);
                qe(jVar.iCG);
                aV(jVar.sortType, jVar.iCF);
            }
            if (jVar.isDynamic) {
                this.jbb.setVisibility(8);
                this.iNh.setVisibility(8);
            } else {
                this.jbb.setVisibility(0);
                this.iNh.setVisibility(0);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void T(View.OnClickListener onClickListener) {
        this.dfX = onClickListener;
    }
}
