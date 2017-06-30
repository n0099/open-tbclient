package com.baidu.tieba.pb.video;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.view.HeadImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements View.OnClickListener {
    final /* synthetic */ h eJN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.eJN = hVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ImageView imageView;
        HeadImageView headImageView;
        TextView textView;
        ImageView imageView2;
        TextView textView2;
        imageView = this.eJN.eJC;
        if (view != imageView) {
            headImageView = this.eJN.eJx;
            if (view != headImageView) {
                textView = this.eJN.eJy;
                if (view != textView) {
                    imageView2 = this.eJN.eJD;
                    if (view != imageView2) {
                        textView2 = this.eJN.eJA;
                        if (view != textView2) {
                            return;
                        }
                        this.eJN.aSL();
                        return;
                    }
                }
            }
            this.eJN.bf(view);
            return;
        }
        this.eJN.be(view);
    }
}
