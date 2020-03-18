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
    private View.OnClickListener dgy;
    private TextView iOW;
    private j iPi;
    private int iVX;
    private int iVY;
    private TextView jcN;
    private TextView jcO;
    private View mRootView;
    private int iPg = 0;
    private int jcP = 0;
    private View.OnClickListener iPl = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.videoView.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.dgy != null) {
                b.this.dgy.onClick(view);
            }
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                if (view == null || !(view.getTag() instanceof Boolean) || ((Boolean) view.getTag()).booleanValue()) {
                    if (view != b.this.jcN) {
                        if (view == b.this.jcO) {
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
    private View.OnClickListener iPm = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.videoView.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.dgy != null) {
                b.this.dgy.onClick(view);
            }
        }
    };

    public b(View view) {
        if (view != null) {
            this.mRootView = view;
            this.jcN = (TextView) this.mRootView.findViewById(R.id.all_reply);
            this.jcN.setOnClickListener(this.iPl);
            this.jcO = (TextView) this.mRootView.findViewById(R.id.owner_reply);
            this.jcO.setOnClickListener(this.iPl);
            this.iOW = (TextView) this.mRootView.findViewById(R.id.pb_sort_type);
            this.iOW.setOnClickListener(this.iPm);
            if (com.baidu.tbadk.util.a.aRQ().aJd()) {
                aV(2, "");
            } else {
                aV(0, "");
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void setSelection(int i) {
        this.jcP = i;
        if (i == 0) {
            this.jcN.setTypeface(Typeface.defaultFromStyle(1));
            this.jcO.setTypeface(Typeface.defaultFromStyle(0));
            this.jcN.setTextColor(this.iVY);
            this.jcO.setTextColor(this.iVX);
        } else if (i == 1) {
            this.jcN.setTypeface(Typeface.defaultFromStyle(0));
            this.jcO.setTypeface(Typeface.defaultFromStyle(1));
            this.jcN.setTextColor(this.iVX);
            this.jcO.setTextColor(this.iVY);
        }
    }

    public void onChangeSkinType(int i) {
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_h);
        this.iVY = am.getColor(R.color.cp_cont_b);
        this.iVX = am.getColor(R.color.cp_cont_j);
        setSelection(this.jcP);
        am.setViewTextColor(this.iOW, (int) R.color.cp_cont_j);
        this.iOW.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.aGG().a(R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null);
    }

    public void qk(boolean z) {
        if (z) {
            setSelection(1);
        } else {
            setSelection(0);
        }
    }

    public void aV(int i, String str) {
        this.iPg = i;
        this.iOW.setVisibility(0);
        if (str.length() > 0) {
            this.iOW.setText(str);
        } else if (this.iPg == 0) {
            this.iOW.setText(R.string.sort_type_new);
        } else if (this.iPg == 1) {
            this.iOW.setText(R.string.sort_type_old);
        } else if (this.iPg == 2) {
            this.iOW.setText(R.string.sort_type_hot);
        }
    }

    public void a(j jVar) {
        this.iPi = jVar;
        if (jVar != null) {
            if (jVar.Ag == j.iEq) {
                this.jcN.setClickable(true);
                this.jcN.setText(TbadkCoreApplication.getInst().getString(R.string.all_reply));
                this.jcO.setVisibility(0);
                qk(jVar.iEv);
                aV(jVar.sortType, jVar.iEu);
            }
            if (jVar.isDynamic) {
                this.jcO.setVisibility(8);
                this.iOW.setVisibility(8);
            } else {
                this.jcO.setVisibility(0);
                this.iOW.setVisibility(0);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void T(View.OnClickListener onClickListener) {
        this.dgy = onClickListener;
    }
}
