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
    private b jIb;
    private a jIc;
    private int joT;
    private Context mContext;
    private int mStatusBarHeight;
    private TextView mTitle;
    private b.a jId = new b.a() { // from class: com.baidu.tieba.write.b.c.1
        @Override // com.baidu.tieba.write.b.b.a
        public void mu(int i) {
            c.this.joT = i;
            c.this.bdR();
            if (c.this.jIc != null) {
                c.this.jIc.Ct(c.this.joT);
            }
        }
    };
    private View.OnClickListener bYE = new View.OnClickListener() { // from class: com.baidu.tieba.write.b.c.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == c.this.mTitle) {
                if (c.this.jIb == null) {
                    c.this.jIb = new b(c.this.mContext);
                    c.this.jIb.setOnDismissListener(c.this.mOnDismissListener);
                    c.this.jIb.a(c.this.jId);
                    c.this.jIb.qp(c.this.mStatusBarHeight);
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(new com.baidu.tieba.write.b.a(c.this.mContext.getString(R.string.write_zone_text_profession), 1));
                arrayList.add(new com.baidu.tieba.write.b.a(c.this.mContext.getString(R.string.write_zone_text_all), 0));
                c.this.jIb.setData(arrayList, c.this.joT);
                c.this.jIb.bm(c.this.mTitle);
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
        this.joT = i;
        this.mStatusBarHeight = i2;
    }

    public void bdR() {
        if (cxJ()) {
            switch (this.joT) {
                case 0:
                    this.mTitle.setText(R.string.write_zone_all);
                    break;
                case 1:
                    this.mTitle.setText(R.string.write_zone_profession);
                    break;
            }
            this.mTitle.setOnClickListener(this.bYE);
        }
    }

    public boolean cxJ() {
        return this.joT == 0 || this.joT == 1;
    }

    public void a(a aVar) {
        this.jIc = aVar;
    }

    public void onChangeSkinType(int i) {
        if (cxJ()) {
            al.f(this.mTitle, R.color.cp_cont_b, i);
            if (this.mTitle != null) {
                this.mTitle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(R.drawable.icon_album_spread), (Drawable) null);
            }
        }
    }
}
