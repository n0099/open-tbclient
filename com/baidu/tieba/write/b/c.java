package com.baidu.tieba.write.b;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.d;
import com.baidu.tieba.write.b.b;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class c {
    private int iWo;
    private b jpq;
    private a jpr;
    private Context mContext;
    private int mStatusBarHeight;
    private TextView mTitle;
    private b.a jps = new b.a() { // from class: com.baidu.tieba.write.b.c.1
        @Override // com.baidu.tieba.write.b.b.a
        public void lI(int i) {
            c.this.iWo = i;
            c.this.aWG();
            if (c.this.jpr != null) {
                c.this.jpr.Bo(c.this.iWo);
            }
        }
    };
    private View.OnClickListener bQJ = new View.OnClickListener() { // from class: com.baidu.tieba.write.b.c.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == c.this.mTitle) {
                if (c.this.jpq == null) {
                    c.this.jpq = new b(c.this.mContext);
                    c.this.jpq.setOnDismissListener(c.this.mOnDismissListener);
                    c.this.jpq.a(c.this.jps);
                    c.this.jpq.po(c.this.mStatusBarHeight);
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(new com.baidu.tieba.write.b.a(c.this.mContext.getString(d.j.write_zone_text_profession), 1));
                arrayList.add(new com.baidu.tieba.write.b.a(c.this.mContext.getString(d.j.write_zone_text_all), 0));
                c.this.jpq.setData(arrayList, c.this.iWo);
                c.this.jpq.bg(c.this.mTitle);
                c.this.mTitle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(d.f.icon_album_retract), (Drawable) null);
            }
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.write.b.c.3
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (c.this.mTitle != null) {
                Drawable drawable = al.getDrawable(d.f.icon_album_spread);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                c.this.mTitle.setCompoundDrawables(null, null, drawable, null);
            }
        }
    };

    /* loaded from: classes3.dex */
    public interface a {
        void Bo(int i);
    }

    public c(Context context, TextView textView, int i, int i2) {
        this.mContext = context;
        this.mTitle = textView;
        this.iWo = i;
        this.mStatusBarHeight = i2;
    }

    public void aWG() {
        if (cpA()) {
            switch (this.iWo) {
                case 0:
                    this.mTitle.setText(d.j.write_zone_all);
                    break;
                case 1:
                    this.mTitle.setText(d.j.write_zone_profession);
                    break;
            }
            this.mTitle.setOnClickListener(this.bQJ);
        }
    }

    public boolean cpA() {
        return this.iWo == 0 || this.iWo == 1;
    }

    public void a(a aVar) {
        this.jpr = aVar;
    }

    public void onChangeSkinType(int i) {
        if (cpA()) {
            al.d(this.mTitle, d.C0236d.cp_cont_b, i);
            if (this.mTitle != null) {
                this.mTitle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(d.f.icon_album_spread), (Drawable) null);
            }
        }
    }
}
