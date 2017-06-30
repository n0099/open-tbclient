package com.baidu.tieba.write.album;

import android.graphics.drawable.Drawable;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap implements PopupWindow.OnDismissListener {
    final /* synthetic */ ac ggh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(ac acVar) {
        this.ggh = acVar;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        int i;
        int i2;
        TextView textView;
        i = this.ggh.gfU;
        if (i <= 50) {
            i2 = w.g.d_ic_post_gallery_spread_n;
        } else {
            i2 = w.g.ic_post_gallery_spread_n;
        }
        Drawable drawable = this.ggh.getResources().getDrawable(i2);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        textView = this.ggh.bWL;
        textView.setCompoundDrawables(null, null, drawable, null);
    }
}
