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
/* loaded from: classes3.dex */
public class c {
    private b jPE;
    private a jPF;
    private int jxI;
    private Context mContext;
    private int mStatusBarHeight;
    private TextView mTitle;
    private b.a jPG = new b.a() { // from class: com.baidu.tieba.write.b.c.1
        @Override // com.baidu.tieba.write.b.b.a
        public void lK(int i) {
            c.this.jxI = i;
            c.this.ber();
            if (c.this.jPF != null) {
                c.this.jPF.BB(c.this.jxI);
            }
        }
    };
    private View.OnClickListener cot = new View.OnClickListener() { // from class: com.baidu.tieba.write.b.c.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == c.this.mTitle) {
                if (c.this.jPE == null) {
                    c.this.jPE = new b(c.this.mContext);
                    c.this.jPE.setOnDismissListener(c.this.mOnDismissListener);
                    c.this.jPE.a(c.this.jPG);
                    c.this.jPE.pH(c.this.mStatusBarHeight);
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(new com.baidu.tieba.write.b.a(c.this.mContext.getString(R.string.write_zone_text_profession), 1));
                arrayList.add(new com.baidu.tieba.write.b.a(c.this.mContext.getString(R.string.write_zone_text_all), 0));
                c.this.jPE.setData(arrayList, c.this.jxI);
                c.this.jPE.O(c.this.mTitle);
                c.this.mTitle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.amL().a(R.drawable.icon_pure_list_arrow12_up_n_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null), (Drawable) null);
            }
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.write.b.c.3
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (c.this.mTitle != null) {
                Drawable a2 = SvgManager.amL().a(R.drawable.icon_pure_list_arrow12_down_n_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null);
                if (a2 != null) {
                    a2.setBounds(0, 0, a2.getMinimumWidth(), a2.getMinimumHeight());
                }
                c.this.mTitle.setCompoundDrawables(null, null, a2, null);
            }
        }
    };

    /* loaded from: classes3.dex */
    public interface a {
        void BB(int i);
    }

    public c(Context context, TextView textView, int i, int i2) {
        this.mContext = context;
        this.mTitle = textView;
        this.jxI = i;
        this.mStatusBarHeight = i2;
    }

    public void ber() {
        if (cyx()) {
            switch (this.jxI) {
                case 0:
                    this.mTitle.setText(R.string.write_zone_all);
                    break;
                case 1:
                    this.mTitle.setText(R.string.write_zone_profession);
                    break;
            }
            this.mTitle.setOnClickListener(this.cot);
        }
    }

    public boolean cyx() {
        return this.jxI == 0 || this.jxI == 1;
    }

    public void a(a aVar) {
        this.jPF = aVar;
    }

    public void onChangeSkinType(int i) {
        if (cyx()) {
            am.setViewTextColor(this.mTitle, R.color.cp_cont_b, i);
            if (this.mTitle != null) {
                this.mTitle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.amL().a(R.drawable.icon_pure_list_arrow12_down_n_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null), (Drawable) null);
            }
        }
    }
}
