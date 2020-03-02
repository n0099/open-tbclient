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
    private View.OnClickListener dfY;
    private TextView iNj;
    private j iNv;
    private int iUk;
    private int iUl;
    private TextView jbc;
    private TextView jbd;
    private View mRootView;
    private int iNt = 0;
    private int jbe = 0;
    private View.OnClickListener iNy = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.videoView.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.dfY != null) {
                b.this.dfY.onClick(view);
            }
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                if (view == null || !(view.getTag() instanceof Boolean) || ((Boolean) view.getTag()).booleanValue()) {
                    if (view != b.this.jbc) {
                        if (view == b.this.jbd) {
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
    private View.OnClickListener iNz = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.videoView.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.dfY != null) {
                b.this.dfY.onClick(view);
            }
        }
    };

    public b(View view) {
        if (view != null) {
            this.mRootView = view;
            this.jbc = (TextView) this.mRootView.findViewById(R.id.all_reply);
            this.jbc.setOnClickListener(this.iNy);
            this.jbd = (TextView) this.mRootView.findViewById(R.id.owner_reply);
            this.jbd.setOnClickListener(this.iNy);
            this.iNj = (TextView) this.mRootView.findViewById(R.id.pb_sort_type);
            this.iNj.setOnClickListener(this.iNz);
            if (com.baidu.tbadk.util.a.aRL().aIY()) {
                aV(2, "");
            } else {
                aV(0, "");
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void setSelection(int i) {
        this.jbe = i;
        if (i == 0) {
            this.jbc.setTypeface(Typeface.defaultFromStyle(1));
            this.jbd.setTypeface(Typeface.defaultFromStyle(0));
            this.jbc.setTextColor(this.iUl);
            this.jbd.setTextColor(this.iUk);
        } else if (i == 1) {
            this.jbc.setTypeface(Typeface.defaultFromStyle(0));
            this.jbd.setTypeface(Typeface.defaultFromStyle(1));
            this.jbc.setTextColor(this.iUk);
            this.jbd.setTextColor(this.iUl);
        }
    }

    public void onChangeSkinType(int i) {
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_h);
        this.iUl = am.getColor(R.color.cp_cont_b);
        this.iUk = am.getColor(R.color.cp_cont_j);
        setSelection(this.jbe);
        am.setViewTextColor(this.iNj, (int) R.color.cp_cont_j);
        this.iNj.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.aGC().a(R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null);
    }

    public void qe(boolean z) {
        if (z) {
            setSelection(1);
        } else {
            setSelection(0);
        }
    }

    public void aV(int i, String str) {
        this.iNt = i;
        this.iNj.setVisibility(0);
        if (str.length() > 0) {
            this.iNj.setText(str);
        } else if (this.iNt == 0) {
            this.iNj.setText(R.string.sort_type_new);
        } else if (this.iNt == 1) {
            this.iNj.setText(R.string.sort_type_old);
        } else if (this.iNt == 2) {
            this.iNj.setText(R.string.sort_type_hot);
        }
    }

    public void a(j jVar) {
        this.iNv = jVar;
        if (jVar != null) {
            if (jVar.Ag == j.iCD) {
                this.jbc.setClickable(true);
                this.jbc.setText(TbadkCoreApplication.getInst().getString(R.string.all_reply));
                this.jbd.setVisibility(0);
                qe(jVar.iCI);
                aV(jVar.sortType, jVar.iCH);
            }
            if (jVar.isDynamic) {
                this.jbd.setVisibility(8);
                this.iNj.setVisibility(8);
            } else {
                this.jbd.setVisibility(0);
                this.iNj.setVisibility(0);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void T(View.OnClickListener onClickListener) {
        this.dfY = onClickListener;
    }
}
