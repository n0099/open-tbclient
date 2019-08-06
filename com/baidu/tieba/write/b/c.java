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
    private b jQm;
    private a jQn;
    private int jwl;
    private Context mContext;
    private int mStatusBarHeight;
    private TextView mTitle;
    private b.a jQo = new b.a() { // from class: com.baidu.tieba.write.b.c.1
        @Override // com.baidu.tieba.write.b.b.a
        public void mC(int i) {
            c.this.jwl = i;
            c.this.bfV();
            if (c.this.jQn != null) {
                c.this.jQn.Dc(c.this.jwl);
            }
        }
    };
    private View.OnClickListener bZN = new View.OnClickListener() { // from class: com.baidu.tieba.write.b.c.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == c.this.mTitle) {
                if (c.this.jQm == null) {
                    c.this.jQm = new b(c.this.mContext);
                    c.this.jQm.setOnDismissListener(c.this.mOnDismissListener);
                    c.this.jQm.a(c.this.jQo);
                    c.this.jQm.qJ(c.this.mStatusBarHeight);
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(new com.baidu.tieba.write.b.a(c.this.mContext.getString(R.string.write_zone_text_profession), 1));
                arrayList.add(new com.baidu.tieba.write.b.a(c.this.mContext.getString(R.string.write_zone_text_all), 0));
                c.this.jQm.setData(arrayList, c.this.jwl);
                c.this.jQm.bo(c.this.mTitle);
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
        void Dc(int i);
    }

    public c(Context context, TextView textView, int i, int i2) {
        this.mContext = context;
        this.mTitle = textView;
        this.jwl = i;
        this.mStatusBarHeight = i2;
    }

    public void bfV() {
        if (cBb()) {
            switch (this.jwl) {
                case 0:
                    this.mTitle.setText(R.string.write_zone_all);
                    break;
                case 1:
                    this.mTitle.setText(R.string.write_zone_profession);
                    break;
            }
            this.mTitle.setOnClickListener(this.bZN);
        }
    }

    public boolean cBb() {
        return this.jwl == 0 || this.jwl == 1;
    }

    public void a(a aVar) {
        this.jQn = aVar;
    }

    public void onChangeSkinType(int i) {
        if (cBb()) {
            am.f(this.mTitle, R.color.cp_cont_b, i);
            if (this.mTitle != null) {
                this.mTitle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_album_spread), (Drawable) null);
            }
        }
    }
}
