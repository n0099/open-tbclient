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
    private b jSJ;
    private a jSK;
    private int jyH;
    private Context mContext;
    private int mStatusBarHeight;
    private TextView mTitle;
    private b.a jSL = new b.a() { // from class: com.baidu.tieba.write.b.c.1
        @Override // com.baidu.tieba.write.b.b.a
        public void mG(int i) {
            c.this.jyH = i;
            c.this.bgA();
            if (c.this.jSK != null) {
                c.this.jSK.Dg(c.this.jyH);
            }
        }
    };
    private View.OnClickListener caG = new View.OnClickListener() { // from class: com.baidu.tieba.write.b.c.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == c.this.mTitle) {
                if (c.this.jSJ == null) {
                    c.this.jSJ = new b(c.this.mContext);
                    c.this.jSJ.setOnDismissListener(c.this.mOnDismissListener);
                    c.this.jSJ.a(c.this.jSL);
                    c.this.jSJ.qM(c.this.mStatusBarHeight);
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(new com.baidu.tieba.write.b.a(c.this.mContext.getString(R.string.write_zone_text_profession), 1));
                arrayList.add(new com.baidu.tieba.write.b.a(c.this.mContext.getString(R.string.write_zone_text_all), 0));
                c.this.jSJ.setData(arrayList, c.this.jyH);
                c.this.jSJ.bo(c.this.mTitle);
                c.this.mTitle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.ajv().a(R.drawable.icon_pure_list_arrow12_up_n_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null), (Drawable) null);
            }
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.write.b.c.3
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (c.this.mTitle != null) {
                Drawable a2 = SvgManager.ajv().a(R.drawable.icon_pure_list_arrow12_down_n_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null);
                if (a2 != null) {
                    a2.setBounds(0, 0, a2.getMinimumWidth(), a2.getMinimumHeight());
                }
                c.this.mTitle.setCompoundDrawables(null, null, a2, null);
            }
        }
    };

    /* loaded from: classes3.dex */
    public interface a {
        void Dg(int i);
    }

    public c(Context context, TextView textView, int i, int i2) {
        this.mContext = context;
        this.mTitle = textView;
        this.jyH = i;
        this.mStatusBarHeight = i2;
    }

    public void bgA() {
        if (cBP()) {
            switch (this.jyH) {
                case 0:
                    this.mTitle.setText(R.string.write_zone_all);
                    break;
                case 1:
                    this.mTitle.setText(R.string.write_zone_profession);
                    break;
            }
            this.mTitle.setOnClickListener(this.caG);
        }
    }

    public boolean cBP() {
        return this.jyH == 0 || this.jyH == 1;
    }

    public void a(a aVar) {
        this.jSK = aVar;
    }

    public void onChangeSkinType(int i) {
        if (cBP()) {
            am.f(this.mTitle, R.color.cp_cont_b, i);
            if (this.mTitle != null) {
                this.mTitle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.ajv().a(R.drawable.icon_pure_list_arrow12_down_n_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null), (Drawable) null);
            }
        }
    }
}
