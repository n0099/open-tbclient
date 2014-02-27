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
public final class s implements View.OnClickListener {
    final /* synthetic */ r a;
    private final /* synthetic */ c b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(r rVar, c cVar) {
        this.a = rVar;
        this.b = cVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        JigsawAlbumListActivity jigsawAlbumListActivity;
        JigsawAlbumListActivity jigsawAlbumListActivity2;
        JigsawAlbumListActivity jigsawAlbumListActivity3;
        JigsawAlbumListActivity jigsawAlbumListActivity4;
        Context context;
        JigsawAlbumListActivity jigsawAlbumListActivity5;
        LinearLayout linearLayout;
        JigsawAlbumListActivity jigsawAlbumListActivity6;
        HorizontalScrollView horizontalScrollView;
        JigsawAlbumListActivity jigsawAlbumListActivity7;
        HorizontalScrollView horizontalScrollView2;
        JigsawAlbumListActivity jigsawAlbumListActivity8;
        JigsawAlbumListActivity jigsawAlbumListActivity9;
        JigsawAlbumListActivity jigsawAlbumListActivity10;
        LinearLayout linearLayout2;
        JigsawAlbumListActivity jigsawAlbumListActivity11;
        TextView textView;
        JigsawAlbumListActivity jigsawAlbumListActivity12;
        JigsawAlbumListActivity jigsawAlbumListActivity13;
        JigsawAlbumListActivity jigsawAlbumListActivity14;
        a aVar = (a) view;
        jigsawAlbumListActivity = this.a.a;
        u uVar = jigsawAlbumListActivity.a;
        jigsawAlbumListActivity2 = this.a.a;
        if (uVar.a(jigsawAlbumListActivity2) >= 10) {
            x.b(R.string.jigsaw_image_most);
        } else if (!b.a(this.b.b)) {
            x.b(R.string.photo_size_scale_range_error);
        } else {
            Uri parse = Uri.parse(String.valueOf(String.valueOf(MediaStore.Images.Media.EXTERNAL_CONTENT_URI)) + "/" + String.valueOf(this.b.c));
            jigsawAlbumListActivity3 = this.a.a;
            if (jigsawAlbumListActivity3.a.b(parse)) {
                jigsawAlbumListActivity14 = this.a.a;
                JigsawAlbumListActivity.a(jigsawAlbumListActivity14, parse);
                return;
            }
            jigsawAlbumListActivity4 = this.a.a;
            w wVar = new w(jigsawAlbumListActivity4);
            context = this.a.b;
            int dimension = (int) context.getResources().getDimension(R.dimen.jigsawSelectedWidth);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimension, dimension);
            layoutParams.setMargins(dimension / 10, 0, 0, 0);
            wVar.setLayoutParams(layoutParams);
            try {
                if (wVar.a(parse)) {
                    jigsawAlbumListActivity8 = this.a.a;
                    u uVar2 = jigsawAlbumListActivity8.a;
                    jigsawAlbumListActivity9 = this.a.a;
                    if (uVar2.a(jigsawAlbumListActivity9, parse)) {
                        jigsawAlbumListActivity10 = this.a.a;
                        linearLayout2 = jigsawAlbumListActivity10.m;
                        linearLayout2.addView(wVar);
                        jigsawAlbumListActivity11 = this.a.a;
                        textView = jigsawAlbumListActivity11.o;
                        jigsawAlbumListActivity12 = this.a.a;
                        u uVar3 = jigsawAlbumListActivity12.a;
                        jigsawAlbumListActivity13 = this.a.a;
                        textView.setText(uVar3.c(jigsawAlbumListActivity13));
                    }
                    aVar.setIsSelected(true);
                    wVar.setOnClickListener(new t(this, wVar, aVar));
                } else {
                    x.a(R.string.open_error);
                }
                jigsawAlbumListActivity5 = this.a.a;
                linearLayout = jigsawAlbumListActivity5.m;
                linearLayout.invalidate();
                jigsawAlbumListActivity6 = this.a.a;
                horizontalScrollView = jigsawAlbumListActivity6.n;
                horizontalScrollView.invalidate();
                jigsawAlbumListActivity7 = this.a.a;
                horizontalScrollView2 = jigsawAlbumListActivity7.n;
                horizontalScrollView2.fling(10000);
            } catch (OutOfMemoryError e) {
                e.printStackTrace();
            }
        }
    }
}
