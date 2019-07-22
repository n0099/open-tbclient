package com.baidu.tieba.write.b;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
import com.baidu.tieba.write.b.b;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class c {
    private b jPf;
    private a jPg;
    private int jve;
    private Context mContext;
    private int mStatusBarHeight;
    private TextView mTitle;
    private b.a jPh = new b.a() { // from class: com.baidu.tieba.write.b.c.1
        @Override // com.baidu.tieba.write.b.b.a
        public void mB(int i) {
            c.this.jve = i;
            c.this.bfT();
            if (c.this.jPg != null) {
                c.this.jPg.Da(c.this.jve);
            }
        }
    };
    private View.OnClickListener bZH = new View.OnClickListener() { // from class: com.baidu.tieba.write.b.c.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == c.this.mTitle) {
                if (c.this.jPf == null) {
                    c.this.jPf = new b(c.this.mContext);
                    c.this.jPf.setOnDismissListener(c.this.mOnDismissListener);
                    c.this.jPf.a(c.this.jPh);
                    c.this.jPf.qH(c.this.mStatusBarHeight);
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(new com.baidu.tieba.write.b.a(c.this.mContext.getString(R.string.write_zone_text_profession), 1));
                arrayList.add(new com.baidu.tieba.write.b.a(c.this.mContext.getString(R.string.write_zone_text_all), 0));
                c.this.jPf.setData(arrayList, c.this.jve);
                c.this.jPf.bo(c.this.mTitle);
                c.this.mTitle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_album_retract), (Drawable) null);
            }
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.write.b.c.3
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (c.this.mTitle != null) {
                Drawable drawable = am.getDrawable(R.drawable.icon_album_spread);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                c.this.mTitle.setCompoundDrawables(null, null, drawable, null);
            }
        }
    };

    /* loaded from: classes3.dex */
    public interface a {
        void Da(int i);
    }

    public c(Context context, TextView textView, int i, int i2) {
        this.mContext = context;
        this.mTitle = textView;
        this.jve = i;
        this.mStatusBarHeight = i2;
    }

    public void bfT() {
        if (cAG()) {
            switch (this.jve) {
                case 0:
                    this.mTitle.setText(R.string.write_zone_all);
                    break;
                case 1:
                    this.mTitle.setText(R.string.write_zone_profession);
                    break;
            }
            this.mTitle.setOnClickListener(this.bZH);
        }
    }

    public boolean cAG() {
        return this.jve == 0 || this.jve == 1;
    }

    public void a(a aVar) {
        this.jPg = aVar;
    }

    public void onChangeSkinType(int i) {
        if (cAG()) {
            am.f(this.mTitle, R.color.cp_cont_b, i);
            if (this.mTitle != null) {
                this.mTitle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_album_spread), (Drawable) null);
            }
        }
    }
}
