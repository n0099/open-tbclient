package com.baidu.tieba.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ab extends RelativeLayout {
    private static ArrayList<ab> b = new ArrayList<>();
    View.OnClickListener a;
    private TextView c;
    private Context d;
    private com.baidu.tieba.util.i e;
    private com.baidu.tieba.data.y f;
    private boolean g;
    private ae h;

    public ab(Context context) {
        super(context);
        this.e = null;
        this.f = null;
        this.g = false;
        this.a = new ac(this);
        a(context);
    }

    public void a(Context context) {
        this.d = context;
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.frs_bannerview, this);
        this.c = (TextView) findViewById(R.id.btn_close);
        this.c.setOnClickListener(this.a);
        setOnClickListener(this.a);
    }

    public void setBannerCloseListener(ae aeVar) {
        this.h = aeVar;
    }

    public void setData(com.baidu.tieba.data.y yVar) {
        this.f = yVar;
        if (this.g) {
            setVisibility(8);
        } else if (yVar != null && yVar != null && yVar.a() == 1 && !TextUtils.isEmpty(yVar.b())) {
            setVisibility(0);
            setImageUrl(yVar.b());
        } else {
            setVisibility(8);
        }
    }

    public void setImageUrl(String str) {
        if (this.e == null) {
            this.e = new com.baidu.tieba.util.i(this.d);
            this.e.d(true);
        }
        this.e.b(str, new ad(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setImg(com.baidu.adp.widget.ImageView.d dVar) {
        Bitmap h;
        if (dVar != null && (h = dVar.h()) != null) {
            setBackgroundDrawable(new BitmapDrawable(h));
        }
    }

    public void a() {
        if (this.e != null) {
            this.e.d();
            this.e = null;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        b.add(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b.remove(this);
    }
}
