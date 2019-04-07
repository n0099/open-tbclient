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
    private int iVU;
    private b joX;
    private a joY;
    private Context mContext;
    private int mStatusBarHeight;
    private TextView mTitle;
    private b.a joZ = new b.a() { // from class: com.baidu.tieba.write.b.c.1
        @Override // com.baidu.tieba.write.b.b.a
        public void lH(int i) {
            c.this.iVU = i;
            c.this.aWD();
            if (c.this.joY != null) {
                c.this.joY.Bk(c.this.iVU);
            }
        }
    };
    private View.OnClickListener bQM = new View.OnClickListener() { // from class: com.baidu.tieba.write.b.c.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == c.this.mTitle) {
                if (c.this.joX == null) {
                    c.this.joX = new b(c.this.mContext);
                    c.this.joX.setOnDismissListener(c.this.mOnDismissListener);
                    c.this.joX.a(c.this.joZ);
                    c.this.joX.pj(c.this.mStatusBarHeight);
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(new com.baidu.tieba.write.b.a(c.this.mContext.getString(d.j.write_zone_text_profession), 1));
                arrayList.add(new com.baidu.tieba.write.b.a(c.this.mContext.getString(d.j.write_zone_text_all), 0));
                c.this.joX.setData(arrayList, c.this.iVU);
                c.this.joX.bg(c.this.mTitle);
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
        void Bk(int i);
    }

    public c(Context context, TextView textView, int i, int i2) {
        this.mContext = context;
        this.mTitle = textView;
        this.iVU = i;
        this.mStatusBarHeight = i2;
    }

    public void aWD() {
        if (cpB()) {
            switch (this.iVU) {
                case 0:
                    this.mTitle.setText(d.j.write_zone_all);
                    break;
                case 1:
                    this.mTitle.setText(d.j.write_zone_profession);
                    break;
            }
            this.mTitle.setOnClickListener(this.bQM);
        }
    }

    public boolean cpB() {
        return this.iVU == 0 || this.iVU == 1;
    }

    public void a(a aVar) {
        this.joY = aVar;
    }

    public void onChangeSkinType(int i) {
        if (cpB()) {
            al.d(this.mTitle, d.C0277d.cp_cont_b, i);
            if (this.mTitle != null) {
                this.mTitle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(d.f.icon_album_spread), (Drawable) null);
            }
        }
    }
}
