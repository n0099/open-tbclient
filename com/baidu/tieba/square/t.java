package com.baidu.tieba.square;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tieba.data.av;
import com.baidu.tieba.data.aw;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.view.HeadImageView;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class t extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    private Activity f1755a;
    private com.baidu.tieba.util.a h;
    private com.baidu.tieba.util.a i;
    private LinearLayout b = null;
    private av c = null;
    private HeadImageView d = null;
    private HeadImageView e = null;
    private HeadImageView f = null;
    private LinearLayout g = null;
    private View.OnClickListener j = new u(this);

    public t(Activity activity) {
        this.f1755a = null;
        this.f1755a = activity;
        int b = UtilHelper.b(activity, UtilHelper.a((Context) activity));
        int a2 = UtilHelper.a(activity, b - 20);
        int a3 = UtilHelper.a(activity, ((b - 20) * 90) / 300);
        this.h = new com.baidu.tieba.util.a(activity);
        this.h.a(a2, a3);
        int a4 = UtilHelper.a(activity, (b - 26) / 2);
        int a5 = UtilHelper.a(activity, (((b - 26) / 2) * 90) / 147);
        this.i = new com.baidu.tieba.util.a(activity);
        this.i.a(a4, a5);
        a();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return Integer.valueOf(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        return this.b;
    }

    private void a() {
        this.b = (LinearLayout) LayoutInflater.from(this.f1755a).inflate(R.layout.square_recommend, (ViewGroup) null);
        this.d = (HeadImageView) this.b.findViewById(R.id.banner_big);
        this.e = (HeadImageView) this.b.findViewById(R.id.banner_small_left);
        this.f = (HeadImageView) this.b.findViewById(R.id.banner_small_right);
        this.g = (LinearLayout) this.b.findViewById(R.id.square_recommend_box);
        this.d.setOnClickListener(this.j);
        this.e.setOnClickListener(this.j);
        this.f.setOnClickListener(this.j);
    }

    public void a(av avVar) {
        this.c = avVar;
        a(this.d, this.c == null ? null : this.c.a());
        b();
    }

    private void a(HeadImageView headImageView, aw awVar) {
        if (awVar == null || awVar.a() == null || awVar.a().equals("")) {
            headImageView.setVisibility(8);
        } else {
            headImageView.setVisibility(0);
        }
    }

    public void a(int i) {
        notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(HeadImageView headImageView, Bitmap bitmap) {
        headImageView.setImageBitmap(bitmap);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        headImageView.invalidate();
        this.g.setVisibility(0);
    }

    private void b() {
        a(this.h, this.c.a(), this.d);
        a(this.i, this.c.b(), this.e);
        a(this.i, this.c.c(), this.f);
    }

    private void a(com.baidu.tieba.util.a aVar, aw awVar, HeadImageView headImageView) {
        com.baidu.adp.widget.a.b d = aVar.d(awVar.a());
        if (d != null) {
            a(headImageView, d.f());
        } else {
            aVar.a(awVar.a(), new v(this, headImageView));
        }
    }
}
