package com.baidu.tieba.motu_gallery;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.slidingmenu.lib.R;
import java.io.FileNotFoundException;
/* loaded from: classes.dex */
public class w extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    ImageView f2042a;
    Uri b;
    Context c;
    Bitmap d;

    public w(Context context) {
        super(context);
        this.c = context;
        a();
    }

    private void a() {
        ((LayoutInflater) this.c.getSystemService("layout_inflater")).inflate(R.layout.motu_albums_selected_item, this);
        this.f2042a = (ImageView) findViewById(R.id.image);
    }

    public Uri getUri() {
        return this.b;
    }

    public boolean a(Uri uri) {
        boolean z = true;
        this.b = uri;
        int dimension = (int) this.c.getResources().getDimension(R.dimen.jigsawSelectedImageWidth);
        if (uri != null) {
            try {
                this.d = b.b(this.c, uri, dimension, dimension);
            } catch (OtherException e) {
                e.printStackTrace();
                z = false;
            } catch (FileNotFoundException e2) {
                e2.printStackTrace();
                z = false;
            } catch (OutOfMemoryError e3) {
                e3.printStackTrace();
                z = false;
            }
        }
        if (this.d != null) {
            this.f2042a.setImageBitmap(this.d);
        } else {
            z = false;
        }
        if (!z) {
            x.a(R.string.open_error);
        }
        return z;
    }
}
