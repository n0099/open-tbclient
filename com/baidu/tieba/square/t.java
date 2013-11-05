package com.baidu.tieba.square;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.tieba.util.UtilHelper;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class t extends com.baidu.adp.widget.ListView.e {

    /* renamed from: a  reason: collision with root package name */
    private Activity f2376a;
    private com.baidu.tieba.data.av b;
    private com.baidu.tieba.util.a c;
    private com.baidu.tieba.util.a d;
    private View.OnClickListener e;

    public t(Activity activity) {
        super(activity);
        this.f2376a = null;
        this.b = null;
        this.e = new u(this);
        this.f2376a = activity;
        int b = UtilHelper.b(this.f2376a, UtilHelper.a((Context) this.f2376a));
        int a2 = UtilHelper.a(this.f2376a, b - 20);
        int a3 = UtilHelper.a(this.f2376a, ((b - 20) * 90) / 300);
        this.c = new com.baidu.tieba.util.a(this.f2376a);
        this.c.a(a2, a3);
        int a4 = UtilHelper.a(this.f2376a, (b - 26) / 2);
        int a5 = UtilHelper.a(this.f2376a, (((b - 26) / 2) * 90) / 147);
        this.d = new com.baidu.tieba.util.a(this.f2376a);
        this.d.a(a4, a5);
    }

    @Override // com.baidu.adp.widget.ListView.e, android.widget.Adapter
    public int getCount() {
        return 1;
    }

    @Override // com.baidu.adp.widget.ListView.e, android.widget.Adapter
    public Object getItem(int i) {
        return Integer.valueOf(i);
    }

    @Override // com.baidu.adp.widget.ListView.e, android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // com.baidu.adp.widget.ListView.e, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.square_recommend, (ViewGroup) null);
            w wVar = new w(null);
            wVar.f2379a = (ImageView) view.findViewById(R.id.banner_big);
            wVar.b = (ImageView) view.findViewById(R.id.banner_small_left);
            wVar.c = (ImageView) view.findViewById(R.id.banner_small_right);
            wVar.f2379a.setOnClickListener(this.e);
            wVar.b.setOnClickListener(this.e);
            wVar.c.setOnClickListener(this.e);
            view.setTag(wVar);
        }
        d(view);
        return view;
    }

    private void d(View view) {
        if (this.b != null) {
            w wVar = (w) view.getTag();
            com.baidu.tieba.data.aw a2 = this.b.a();
            if (a2 == null || a2.a() == null || a2.a().equals("")) {
                wVar.f2379a.setVisibility(8);
            } else {
                wVar.f2379a.setVisibility(0);
                a(this.c, this.b.a(), wVar.f2379a);
            }
            a(this.d, this.b.b(), wVar.b);
            a(this.d, this.b.c(), wVar.c);
        }
    }

    public void a(com.baidu.tieba.data.av avVar) {
        this.b = avVar;
        notifyDataSetChanged();
    }

    public void a(int i) {
        notifyDataSetChanged();
    }

    private void a(com.baidu.tieba.util.a aVar, com.baidu.tieba.data.aw awVar, ImageView imageView) {
        com.baidu.adp.widget.ImageView.e d = aVar.d(awVar.a());
        if (d != null) {
            a(imageView, d.f());
            return;
        }
        com.baidu.adp.widget.ImageView.e a2 = aVar.a(awVar.a(), new v(this, imageView));
        if (a2 != null) {
            a(imageView, a2.f());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImageView imageView, Bitmap bitmap) {
        imageView.setImageBitmap(bitmap);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.invalidate();
    }
}
