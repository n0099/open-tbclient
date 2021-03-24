package com.baidu.wallet.base.widget.clickListener;

import android.view.View;
/* loaded from: classes5.dex */
public abstract class ReDouAndNetErrClickListener implements View.OnClickListener {
    public abstract void doClick(View view);

    @Override // android.view.View.OnClickListener
    public void onClick(final View view) {
        new ReDoubleOnClickListener() { // from class: com.baidu.wallet.base.widget.clickListener.ReDouAndNetErrClickListener.1
            @Override // com.baidu.wallet.base.widget.clickListener.ReDoubleOnClickListener
            public void doClick(View view2) {
                new ReNetErrorClickListener() { // from class: com.baidu.wallet.base.widget.clickListener.ReDouAndNetErrClickListener.1.1
                    @Override // com.baidu.wallet.base.widget.clickListener.ReNetErrorClickListener
                    public void doClick(View view3) {
                        ReDouAndNetErrClickListener.this.doClick(view3);
                    }
                }.onClick(view);
            }
        }.onClick(view);
    }
}
