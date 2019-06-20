package com.baidu.tieba.write.b;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.R;
import com.baidu.tieba.write.b.b;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class c {
    private b jIe;
    private a jIf;
    private int joX;
    private Context mContext;
    private int mStatusBarHeight;
    private TextView mTitle;
    private b.a jIg = new b.a() { // from class: com.baidu.tieba.write.b.c.1
        @Override // com.baidu.tieba.write.b.b.a
        public void mu(int i) {
            c.this.joX = i;
            c.this.bdR();
            if (c.this.jIf != null) {
                c.this.jIf.Ct(c.this.joX);
            }
        }
    };
    private View.OnClickListener bYF = new View.OnClickListener() { // from class: com.baidu.tieba.write.b.c.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == c.this.mTitle) {
                if (c.this.jIe == null) {
                    c.this.jIe = new b(c.this.mContext);
                    c.this.jIe.setOnDismissListener(c.this.mOnDismissListener);
                    c.this.jIe.a(c.this.jIg);
                    c.this.jIe.qp(c.this.mStatusBarHeight);
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(new com.baidu.tieba.write.b.a(c.this.mContext.getString(R.string.write_zone_text_profession), 1));
                arrayList.add(new com.baidu.tieba.write.b.a(c.this.mContext.getString(R.string.write_zone_text_all), 0));
                c.this.jIe.setData(arrayList, c.this.joX);
                c.this.jIe.bm(c.this.mTitle);
                c.this.mTitle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(R.drawable.icon_album_retract), (Drawable) null);
            }
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.write.b.c.3
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (c.this.mTitle != null) {
                Drawable drawable = al.getDrawable(R.drawable.icon_album_spread);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                c.this.mTitle.setCompoundDrawables(null, null, drawable, null);
            }
        }
    };

    /* loaded from: classes3.dex */
    public interface a {
        void Ct(int i);
    }

    public c(Context context, TextView textView, int i, int i2) {
        this.mContext = context;
        this.mTitle = textView;
        this.joX = i;
        this.mStatusBarHeight = i2;
    }

    public void bdR() {
        if (cxI()) {
            switch (this.joX) {
                case 0:
                    this.mTitle.setText(R.string.write_zone_all);
                    break;
                case 1:
                    this.mTitle.setText(R.string.write_zone_profession);
                    break;
            }
            this.mTitle.setOnClickListener(this.bYF);
        }
    }

    public boolean cxI() {
        return this.joX == 0 || this.joX == 1;
    }

    public void a(a aVar) {
        this.jIf = aVar;
    }

    public void onChangeSkinType(int i) {
        if (cxI()) {
            al.f(this.mTitle, R.color.cp_cont_b, i);
            if (this.mTitle != null) {
                this.mTitle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(R.drawable.icon_album_spread), (Drawable) null);
            }
        }
    }
}
