package com.baidu.tieba.motu_gallery;

import android.content.Context;
import android.net.Uri;
import android.provider.MediaStore;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.cyberplayer.sdk.internal.VersionUtils;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ c f2021a;
    final /* synthetic */ r b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(r rVar, c cVar) {
        this.b = rVar;
        this.f2021a = cVar;
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
        if (this.b.f2020a.f2003a.a(this.b.f2020a) >= 10) {
            x.b(R.string.jigsaw_image_most);
        } else if (!b.a(this.f2021a.b)) {
            x.b(R.string.photo_size_scale_range_error);
        } else {
            Uri parse = Uri.parse(String.valueOf(MediaStore.Images.Media.EXTERNAL_CONTENT_URI) + "/" + String.valueOf(this.f2021a.c));
            if (this.b.f2020a.f2003a.b(parse)) {
                this.b.f2020a.a(parse);
                return;
            }
            w wVar = new w(this.b.f2020a);
            context = this.b.b;
            int dimension = (int) context.getResources().getDimension(R.dimen.jigsawSelectedWidth);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimension, dimension);
            layoutParams.setMargins(dimension / 10, 0, 0, 0);
            wVar.setLayoutParams(layoutParams);
            try {
                if (wVar.a(parse)) {
                    if (this.b.f2020a.f2003a.a(this.b.f2020a, parse)) {
                        linearLayout2 = this.b.f2020a.m;
                        linearLayout2.addView(wVar);
                        textView = this.b.f2020a.o;
                        textView.setText(this.b.f2020a.f2003a.e(this.b.f2020a));
                    }
                    aVar.setIsSelected(true);
                    wVar.setOnClickListener(new t(this, wVar, aVar));
                } else {
                    x.a(R.string.open_error);
                }
                linearLayout = this.b.f2020a.m;
                linearLayout.invalidate();
                horizontalScrollView = this.b.f2020a.n;
                horizontalScrollView.invalidate();
                horizontalScrollView2 = this.b.f2020a.n;
                horizontalScrollView2.fling(VersionUtils.CUR_DEVELOPMENT);
            } catch (OutOfMemoryError e) {
                e.printStackTrace();
            }
        }
    }
}
