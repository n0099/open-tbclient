package com.baidu.tieba.write.b;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
import com.baidu.tieba.write.b.b;
import java.util.ArrayList;
/* loaded from: classes13.dex */
public class c {
    private b kOD;
    private a kOE;
    private int kwj;
    private Context mContext;
    private int mStatusBarHeight;
    private TextView mTitle;
    private b.a kOF = new b.a() { // from class: com.baidu.tieba.write.b.c.1
        @Override // com.baidu.tieba.write.b.b.a
        public void onItemClick(int i) {
            c.this.kwj = i;
            c.this.byt();
            if (c.this.kOE != null) {
                c.this.kOE.Ei(c.this.kwj);
            }
        }
    };
    private View.OnClickListener dfX = new View.OnClickListener() { // from class: com.baidu.tieba.write.b.c.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == c.this.mTitle) {
                if (c.this.kOD == null) {
                    c.this.kOD = new b(c.this.mContext);
                    c.this.kOD.setOnDismissListener(c.this.mOnDismissListener);
                    c.this.kOD.a(c.this.kOF);
                    c.this.kOD.rY(c.this.mStatusBarHeight);
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(new com.baidu.tieba.write.b.a(c.this.mContext.getString(R.string.write_zone_text_profession), 1));
                arrayList.add(new com.baidu.tieba.write.b.a(c.this.mContext.getString(R.string.write_zone_text_all), 0));
                c.this.kOD.setData(arrayList, c.this.kwj);
                c.this.kOD.R(c.this.mTitle);
                c.this.mTitle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.aGA().a(R.drawable.icon_pure_fold12_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null), (Drawable) null);
            }
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.write.b.c.3
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (c.this.mTitle != null) {
                Drawable a2 = SvgManager.aGA().a(R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null);
                if (a2 != null) {
                    a2.setBounds(0, 0, a2.getMinimumWidth(), a2.getMinimumHeight());
                }
                c.this.mTitle.setCompoundDrawables(null, null, a2, null);
            }
        }
    };

    /* loaded from: classes13.dex */
    public interface a {
        void Ei(int i);
    }

    public c(Context context, TextView textView, int i, int i2) {
        this.mContext = context;
        this.mTitle = textView;
        this.kwj = i;
        this.mStatusBarHeight = i2;
    }

    public void byt() {
        if (cUS()) {
            switch (this.kwj) {
                case 0:
                    this.mTitle.setText(R.string.write_zone_all);
                    break;
                case 1:
                    this.mTitle.setText(R.string.write_zone_profession);
                    break;
            }
            this.mTitle.setOnClickListener(this.dfX);
        }
    }

    public boolean cUS() {
        return this.kwj == 0 || this.kwj == 1;
    }

    public void a(a aVar) {
        this.kOE = aVar;
    }

    public void onChangeSkinType(int i) {
        if (cUS()) {
            am.setViewTextColor(this.mTitle, R.color.cp_cont_b, i);
            if (this.mTitle != null) {
                this.mTitle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.aGA().a(R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null), (Drawable) null);
            }
        }
    }
}
