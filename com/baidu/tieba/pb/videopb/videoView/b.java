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
    private View.OnClickListener dgl;
    private j iNH;
    private TextView iNv;
    private int iUw;
    private int iUx;
    private TextView jbo;
    private TextView jbp;
    private View mRootView;
    private int iNF = 0;
    private int jbq = 0;
    private View.OnClickListener iNK = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.videoView.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.dgl != null) {
                b.this.dgl.onClick(view);
            }
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                if (view == null || !(view.getTag() instanceof Boolean) || ((Boolean) view.getTag()).booleanValue()) {
                    if (view != b.this.jbo) {
                        if (view == b.this.jbp) {
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
    private View.OnClickListener iNL = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.videoView.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.dgl != null) {
                b.this.dgl.onClick(view);
            }
        }
    };

    public b(View view) {
        if (view != null) {
            this.mRootView = view;
            this.jbo = (TextView) this.mRootView.findViewById(R.id.all_reply);
            this.jbo.setOnClickListener(this.iNK);
            this.jbp = (TextView) this.mRootView.findViewById(R.id.owner_reply);
            this.jbp.setOnClickListener(this.iNK);
            this.iNv = (TextView) this.mRootView.findViewById(R.id.pb_sort_type);
            this.iNv.setOnClickListener(this.iNL);
            if (com.baidu.tbadk.util.a.aRM().aIZ()) {
                aV(2, "");
            } else {
                aV(0, "");
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void setSelection(int i) {
        this.jbq = i;
        if (i == 0) {
            this.jbo.setTypeface(Typeface.defaultFromStyle(1));
            this.jbp.setTypeface(Typeface.defaultFromStyle(0));
            this.jbo.setTextColor(this.iUx);
            this.jbp.setTextColor(this.iUw);
        } else if (i == 1) {
            this.jbo.setTypeface(Typeface.defaultFromStyle(0));
            this.jbp.setTypeface(Typeface.defaultFromStyle(1));
            this.jbo.setTextColor(this.iUw);
            this.jbp.setTextColor(this.iUx);
        }
    }

    public void onChangeSkinType(int i) {
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_h);
        this.iUx = am.getColor(R.color.cp_cont_b);
        this.iUw = am.getColor(R.color.cp_cont_j);
        setSelection(this.jbq);
        am.setViewTextColor(this.iNv, (int) R.color.cp_cont_j);
        this.iNv.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.aGC().a(R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null);
    }

    public void qe(boolean z) {
        if (z) {
            setSelection(1);
        } else {
            setSelection(0);
        }
    }

    public void aV(int i, String str) {
        this.iNF = i;
        this.iNv.setVisibility(0);
        if (str.length() > 0) {
            this.iNv.setText(str);
        } else if (this.iNF == 0) {
            this.iNv.setText(R.string.sort_type_new);
        } else if (this.iNF == 1) {
            this.iNv.setText(R.string.sort_type_old);
        } else if (this.iNF == 2) {
            this.iNv.setText(R.string.sort_type_hot);
        }
    }

    public void a(j jVar) {
        this.iNH = jVar;
        if (jVar != null) {
            if (jVar.Ag == j.iCP) {
                this.jbo.setClickable(true);
                this.jbo.setText(TbadkCoreApplication.getInst().getString(R.string.all_reply));
                this.jbp.setVisibility(0);
                qe(jVar.iCU);
                aV(jVar.sortType, jVar.iCT);
            }
            if (jVar.isDynamic) {
                this.jbp.setVisibility(8);
                this.iNv.setVisibility(8);
            } else {
                this.jbp.setVisibility(0);
                this.iNv.setVisibility(0);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void T(View.OnClickListener onClickListener) {
        this.dgl = onClickListener;
    }
}
