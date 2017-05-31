package com.baidu.tieba.pb.video;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.view.HeadImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements View.OnClickListener {
    final /* synthetic */ h eAp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.eAp = hVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ImageView imageView;
        HeadImageView headImageView;
        TextView textView;
        ImageView imageView2;
        TextView textView2;
        imageView = this.eAp.eAe;
        if (view != imageView) {
            headImageView = this.eAp.ezZ;
            if (view != headImageView) {
                textView = this.eAp.eAa;
                if (view != textView) {
                    imageView2 = this.eAp.eAf;
                    if (view != imageView2) {
                        textView2 = this.eAp.eAc;
                        if (view != textView2) {
                            return;
                        }
                        this.eAp.aOM();
                        return;
                    }
                }
            }
            this.eAp.bc(view);
            return;
        }
        this.eAp.bb(view);
    }
}
