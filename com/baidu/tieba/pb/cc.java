package com.baidu.tieba.pb;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
class cc implements View.OnClickListener {
    final /* synthetic */ ca a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cc(ca caVar) {
        this.a = caVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        Context context2;
        if (view.getTag() instanceof LinearLayout) {
            LinearLayout linearLayout = (LinearLayout) view.getTag();
            if (linearLayout.getVisibility() == 0) {
                linearLayout.setVisibility(8);
                context2 = this.a.a;
                ((Button) view).setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, context2.getResources().getDrawable(R.drawable.manage_btn_left), (Drawable) null);
                return;
            }
            linearLayout.setVisibility(0);
            context = this.a.a;
            ((Button) view).setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, context.getResources().getDrawable(R.drawable.manage_btn_down), (Drawable) null);
        }
    }
}
