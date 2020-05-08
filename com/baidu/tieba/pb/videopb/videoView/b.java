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
    private int aIm;
    private int aIn;
    private View.OnClickListener dFZ;
    private TextView jMZ;
    private TextView jNa;
    private TextView jzj;
    private j jzv;
    private View mRootView;
    private int jzt = 0;
    private int jNb = 0;
    private View.OnClickListener jzy = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.videoView.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.dFZ != null) {
                b.this.dFZ.onClick(view);
            }
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                if (view == null || !(view.getTag() instanceof Boolean) || ((Boolean) view.getTag()).booleanValue()) {
                    if (view != b.this.jMZ) {
                        if (view == b.this.jNa) {
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
    private View.OnClickListener jzz = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.videoView.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.dFZ != null) {
                b.this.dFZ.onClick(view);
            }
        }
    };

    public b(View view) {
        if (view != null) {
            this.mRootView = view;
            this.jMZ = (TextView) this.mRootView.findViewById(R.id.all_reply);
            this.jMZ.setOnClickListener(this.jzy);
            this.jNa = (TextView) this.mRootView.findViewById(R.id.owner_reply);
            this.jNa.setOnClickListener(this.jzy);
            this.jzj = (TextView) this.mRootView.findViewById(R.id.pb_sort_type);
            this.jzj.setOnClickListener(this.jzz);
            if (com.baidu.tbadk.util.a.aZX().aRx()) {
                bk(2, "");
            } else {
                bk(0, "");
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void setSelection(int i) {
        this.jNb = i;
        if (i == 0) {
            this.jMZ.setTypeface(Typeface.defaultFromStyle(1));
            this.jNa.setTypeface(Typeface.defaultFromStyle(0));
            this.jMZ.setTextColor(this.aIm);
            this.jNa.setTextColor(this.aIn);
        } else if (i == 1) {
            this.jMZ.setTypeface(Typeface.defaultFromStyle(0));
            this.jNa.setTypeface(Typeface.defaultFromStyle(1));
            this.jMZ.setTextColor(this.aIn);
            this.jNa.setTextColor(this.aIm);
        }
    }

    public void onChangeSkinType(int i) {
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_h);
        this.aIm = am.getColor(R.color.cp_cont_b);
        this.aIn = am.getColor(R.color.cp_cont_j);
        setSelection(this.jNb);
        am.setViewTextColor(this.jzj, (int) R.color.cp_cont_j);
        this.jzj.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.aOR().a(R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null);
    }

    public void ro(boolean z) {
        if (z) {
            setSelection(1);
        } else {
            setSelection(0);
        }
    }

    public void bk(int i, String str) {
        this.jzt = i;
        this.jzj.setVisibility(0);
        if (str.length() > 0) {
            this.jzj.setText(str);
        } else if (this.jzt == 0) {
            this.jzj.setText(R.string.sort_type_new);
        } else if (this.jzt == 1) {
            this.jzj.setText(R.string.sort_type_old);
        } else if (this.jzt == 2) {
            this.jzj.setText(R.string.sort_type_hot);
        }
    }

    public void a(j jVar) {
        this.jzv = jVar;
        if (jVar != null) {
            if (jVar.Ty == j.joA) {
                this.jMZ.setClickable(true);
                this.jMZ.setText(TbadkCoreApplication.getInst().getString(R.string.all_reply));
                this.jNa.setVisibility(0);
                ro(jVar.joF);
                bk(jVar.sortType, jVar.joE);
            }
            if (jVar.isDynamic) {
                this.jNa.setVisibility(8);
                this.jzj.setVisibility(8);
            } else {
                this.jNa.setVisibility(0);
                this.jzj.setVisibility(0);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void U(View.OnClickListener onClickListener) {
        this.dFZ = onClickListener;
    }
}
