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
    private int aIg;
    private int aIh;
    private View.OnClickListener dFV;
    private TextView jMV;
    private TextView jMW;
    private TextView jzf;
    private j jzr;
    private View mRootView;
    private int jzp = 0;
    private int jMX = 0;
    private View.OnClickListener jzu = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.videoView.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.dFV != null) {
                b.this.dFV.onClick(view);
            }
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                if (view == null || !(view.getTag() instanceof Boolean) || ((Boolean) view.getTag()).booleanValue()) {
                    if (view != b.this.jMV) {
                        if (view == b.this.jMW) {
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
    private View.OnClickListener jzv = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.videoView.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.dFV != null) {
                b.this.dFV.onClick(view);
            }
        }
    };

    public b(View view) {
        if (view != null) {
            this.mRootView = view;
            this.jMV = (TextView) this.mRootView.findViewById(R.id.all_reply);
            this.jMV.setOnClickListener(this.jzu);
            this.jMW = (TextView) this.mRootView.findViewById(R.id.owner_reply);
            this.jMW.setOnClickListener(this.jzu);
            this.jzf = (TextView) this.mRootView.findViewById(R.id.pb_sort_type);
            this.jzf.setOnClickListener(this.jzv);
            if (com.baidu.tbadk.util.a.aZZ().aRA()) {
                bk(2, "");
            } else {
                bk(0, "");
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void setSelection(int i) {
        this.jMX = i;
        if (i == 0) {
            this.jMV.setTypeface(Typeface.defaultFromStyle(1));
            this.jMW.setTypeface(Typeface.defaultFromStyle(0));
            this.jMV.setTextColor(this.aIg);
            this.jMW.setTextColor(this.aIh);
        } else if (i == 1) {
            this.jMV.setTypeface(Typeface.defaultFromStyle(0));
            this.jMW.setTypeface(Typeface.defaultFromStyle(1));
            this.jMV.setTextColor(this.aIh);
            this.jMW.setTextColor(this.aIg);
        }
    }

    public void onChangeSkinType(int i) {
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_h);
        this.aIg = am.getColor(R.color.cp_cont_b);
        this.aIh = am.getColor(R.color.cp_cont_j);
        setSelection(this.jMX);
        am.setViewTextColor(this.jzf, (int) R.color.cp_cont_j);
        this.jzf.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.aOU().a(R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null);
    }

    public void ro(boolean z) {
        if (z) {
            setSelection(1);
        } else {
            setSelection(0);
        }
    }

    public void bk(int i, String str) {
        this.jzp = i;
        this.jzf.setVisibility(0);
        if (str.length() > 0) {
            this.jzf.setText(str);
        } else if (this.jzp == 0) {
            this.jzf.setText(R.string.sort_type_new);
        } else if (this.jzp == 1) {
            this.jzf.setText(R.string.sort_type_old);
        } else if (this.jzp == 2) {
            this.jzf.setText(R.string.sort_type_hot);
        }
    }

    public void a(j jVar) {
        this.jzr = jVar;
        if (jVar != null) {
            if (jVar.Tv == j.jow) {
                this.jMV.setClickable(true);
                this.jMV.setText(TbadkCoreApplication.getInst().getString(R.string.all_reply));
                this.jMW.setVisibility(0);
                ro(jVar.joB);
                bk(jVar.sortType, jVar.joA);
            }
            if (jVar.isDynamic) {
                this.jMW.setVisibility(8);
                this.jzf.setVisibility(8);
            } else {
                this.jMW.setVisibility(0);
                this.jzf.setVisibility(0);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void U(View.OnClickListener onClickListener) {
        this.dFV = onClickListener;
    }
}
