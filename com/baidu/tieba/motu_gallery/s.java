package com.baidu.tieba.motu_gallery;

import android.content.Context;
import android.net.Uri;
import android.provider.MediaStore;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements View.OnClickListener {
    final /* synthetic */ c a;
    final /* synthetic */ r b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(r rVar, c cVar) {
        this.b = rVar;
        this.a = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        LinearLayout linearLayout;
        HorizontalScrollView horizontalScrollView;
        HorizontalScrollView horizontalScrollView2;
        LinearLayout linearLayout2;
        TextView textView;
        a aVar = (a) view;
        if (this.b.a.a.a(this.b.a) >= 10) {
            x.b(R.string.jigsaw_image_most);
        } else if (!b.a(this.a.b)) {
            x.b(R.string.photo_size_scale_range_error);
        } else {
            Uri parse = Uri.parse(String.valueOf(MediaStore.Images.Media.EXTERNAL_CONTENT_URI) + "/" + String.valueOf(this.a.c));
            if (this.b.a.a.b(parse)) {
                this.b.a.a(parse);
                return;
            }
            w wVar = new w(this.b.a);
            context = this.b.b;
            int dimension = (int) context.getResources().getDimension(R.dimen.jigsawSelectedWidth);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimension, dimension);
            layoutParams.setMargins(dimension / 10, 0, 0, 0);
            wVar.setLayoutParams(layoutParams);
            try {
                if (wVar.a(parse)) {
                    if (this.b.a.a.a(this.b.a, parse)) {
                        linearLayout2 = this.b.a.m;
                        linearLayout2.addView(wVar);
                        textView = this.b.a.o;
                        textView.setText(this.b.a.a.e(this.b.a));
                    }
                    aVar.setIsSelected(true);
                    wVar.setOnClickListener(new t(this, wVar, aVar));
                } else {
                    x.a(R.string.open_error);
                }
                linearLayout = this.b.a.m;
                linearLayout.invalidate();
                horizontalScrollView = this.b.a.n;
                horizontalScrollView.invalidate();
                horizontalScrollView2 = this.b.a.n;
                horizontalScrollView2.fling(10000);
            } catch (OutOfMemoryError e) {
                e.printStackTrace();
            }
        }
    }
}
