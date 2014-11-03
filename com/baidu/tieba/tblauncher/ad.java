package com.baidu.tieba.tblauncher;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class ad extends CustomMessageListener {
    final /* synthetic */ MainTabActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ad(MainTabActivity mainTabActivity, int i) {
        super(i);
        this.this$0 = mainTabActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x002a, code lost:
        if (r1 <= 0) goto L9;
     */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        boolean z;
        int i;
        TextView textView;
        boolean z2;
        TextView textView2;
        MainTabActivity mainTabActivity;
        TextView textView3;
        Drawable drawable;
        ImageView imageView;
        boolean z3;
        int i2;
        int i3;
        boolean z4 = false;
        this.this$0.bPh = 0;
        this.this$0.bPm = false;
        z = this.this$0.bPn;
        if (!z) {
            z3 = this.this$0.adC;
            if (!z3) {
                i2 = this.this$0.bPg;
                if (i2 <= 0) {
                    i3 = this.this$0.bPi;
                }
            }
        }
        z4 = true;
        if (!z4) {
            imageView = this.this$0.bPa;
            imageView.setVisibility(8);
        }
        i = this.this$0.bPg;
        if (i > 0) {
            z2 = this.this$0.bPk;
            if (z2) {
                textView2 = this.this$0.bOM;
                mainTabActivity = this.this$0.bPd;
                textView2.setCompoundDrawablePadding(com.baidu.adp.lib.util.m.dip2px(mainTabActivity, 4.0f));
                textView3 = this.this$0.bOM;
                drawable = this.this$0.bON;
                textView3.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, drawable, (Drawable) null);
                return;
            }
        }
        textView = this.this$0.bOM;
        textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
    }
}
