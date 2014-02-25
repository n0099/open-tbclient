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
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class ae extends RelativeLayout {
    private static ArrayList<ae> b = new ArrayList<>();
    private static final Pattern i = Pattern.compile("(/p/){1}(\\d+)");
    View.OnClickListener a;
    private TextView c;
    private Context d;
    private com.baidu.tieba.util.i e;
    private com.baidu.tieba.data.x f;
    private boolean g;
    private ah h;

    public ae(Context context) {
        super(context);
        this.e = null;
        this.f = null;
        this.g = false;
        this.a = new af(this);
        a(context);
    }

    public void a(Context context) {
        this.d = context;
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.frs_bannerview, this);
        this.c = (TextView) findViewById(R.id.btn_close);
        this.c.setOnClickListener(this.a);
        setOnClickListener(this.a);
    }

    public void setBannerCloseListener(ah ahVar) {
        this.h = ahVar;
    }

    public void setData(com.baidu.tieba.data.x xVar) {
        this.f = xVar;
        if (this.g) {
            setVisibility(8);
            return;
        }
        setVisibility(8);
        if (xVar != null && !TextUtils.isEmpty(xVar.b())) {
            setImageUrl(xVar.b());
        }
    }

    public void setImageUrl(String str) {
        if (this.e == null) {
            this.e = new com.baidu.tieba.util.i(this.d);
            this.e.a(720, 100);
            this.e.d(true);
        }
        this.e.b(str, new ag(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setImg(com.baidu.adp.widget.ImageView.b bVar) {
        Bitmap h;
        if (bVar != null && (h = bVar.h()) != null) {
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
