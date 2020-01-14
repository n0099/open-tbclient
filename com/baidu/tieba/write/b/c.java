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
/* loaded from: classes11.dex */
public class c {
    private b kNX;
    private a kNY;
    private int kvm;
    private Context mContext;
    private int mStatusBarHeight;
    private TextView mTitle;
    private b.a kNZ = new b.a() { // from class: com.baidu.tieba.write.b.c.1
        @Override // com.baidu.tieba.write.b.b.a
        public void onItemClick(int i) {
            c.this.kvm = i;
            c.this.bwO();
            if (c.this.kNY != null) {
                c.this.kNY.Ed(c.this.kvm);
            }
        }
    };
    private View.OnClickListener dbS = new View.OnClickListener() { // from class: com.baidu.tieba.write.b.c.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == c.this.mTitle) {
                if (c.this.kNX == null) {
                    c.this.kNX = new b(c.this.mContext);
                    c.this.kNX.setOnDismissListener(c.this.mOnDismissListener);
                    c.this.kNX.a(c.this.kNZ);
                    c.this.kNX.rS(c.this.mStatusBarHeight);
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(new com.baidu.tieba.write.b.a(c.this.mContext.getString(R.string.write_zone_text_profession), 1));
                arrayList.add(new com.baidu.tieba.write.b.a(c.this.mContext.getString(R.string.write_zone_text_all), 0));
                c.this.kNX.setData(arrayList, c.this.kvm);
                c.this.kNX.R(c.this.mTitle);
                c.this.mTitle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.aEp().a(R.drawable.icon_pure_fold12_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null), (Drawable) null);
            }
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.write.b.c.3
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (c.this.mTitle != null) {
                Drawable a2 = SvgManager.aEp().a(R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null);
                if (a2 != null) {
                    a2.setBounds(0, 0, a2.getMinimumWidth(), a2.getMinimumHeight());
                }
                c.this.mTitle.setCompoundDrawables(null, null, a2, null);
            }
        }
    };

    /* loaded from: classes11.dex */
    public interface a {
        void Ed(int i);
    }

    public c(Context context, TextView textView, int i, int i2) {
        this.mContext = context;
        this.mTitle = textView;
        this.kvm = i;
        this.mStatusBarHeight = i2;
    }

    public void bwO() {
        if (cTE()) {
            switch (this.kvm) {
                case 0:
                    this.mTitle.setText(R.string.write_zone_all);
                    break;
                case 1:
                    this.mTitle.setText(R.string.write_zone_profession);
                    break;
            }
            this.mTitle.setOnClickListener(this.dbS);
        }
    }

    public boolean cTE() {
        return this.kvm == 0 || this.kvm == 1;
    }

    public void a(a aVar) {
        this.kNY = aVar;
    }

    public void onChangeSkinType(int i) {
        if (cTE()) {
            am.setViewTextColor(this.mTitle, R.color.cp_cont_b, i);
            if (this.mTitle != null) {
                this.mTitle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.aEp().a(R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null), (Drawable) null);
            }
        }
    }
}
