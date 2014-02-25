package com.baidu.tieba.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class GroupBannerView extends RelativeLayout {
    View.OnClickListener a;
    private Button b;
    private Context c;
    private com.baidu.tieba.util.i d;
    private boolean e;
    private float f;
    private String g;

    public GroupBannerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.d = null;
        this.e = false;
        this.f = 0.1388889f;
        this.a = new az(this);
        a(context);
    }

    public GroupBannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = null;
        this.e = false;
        this.f = 0.1388889f;
        this.a = new az(this);
        a(context);
    }

    public GroupBannerView(Context context) {
        super(context);
        this.d = null;
        this.e = false;
        this.f = 0.1388889f;
        this.a = new az(this);
        a(context);
    }

    public void a(Context context) {
        this.c = context;
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.group_bannerview, this);
        this.b = (Button) findViewById(R.id.btn_close);
        this.b.setOnClickListener(this.a);
        setOnClickListener(this.a);
    }

    public void a(String str, String str2) {
        this.g = str2;
        if (this.e) {
            setVisibility(8);
            return;
        }
        setVisibility(8);
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            layoutParams.height = (int) ((BdUtilHelper.b(getContext()) * this.f) + 0.5d);
            setLayoutParams(layoutParams);
            setImageUrl(str);
        }
    }

    public void setImageUrl(String str) {
        if (this.d == null) {
            this.d = new com.baidu.tieba.util.i(this.c);
            this.d.a(720, 100);
            this.d.d(true);
        }
        this.d.b(str, new ba(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setImg(com.baidu.adp.widget.ImageView.b bVar) {
        Bitmap h;
        if (bVar != null && (h = bVar.h()) != null) {
            setBackgroundDrawable(new BitmapDrawable(h));
        }
    }
}
