package com.baidu.tieba.square;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tieba.square.CarouselRecommendView;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class u extends BaseAdapter implements com.baidu.tieba.view.ah {

    /* renamed from: a  reason: collision with root package name */
    private Context f2436a;
    private CarouselRecommendView.CarouselRecommendPagerAdapter b = null;
    private ArrayList<aw> c = new ArrayList<>();
    private CarouselRecommendView d;

    public u(Context context) {
        this.f2436a = null;
        this.d = null;
        this.f2436a = context;
        this.d = new CarouselRecommendView(context);
    }

    public void a(ArrayList<aw> arrayList) {
        this.c = arrayList;
        this.d.a(arrayList);
        this.b = this.d.getPagerAdapter();
        notifyDataSetChanged();
    }

    public void a() {
        if (this.d != null) {
            this.d.a();
        }
    }

    public void b() {
        if (this.d != null) {
            this.d.b();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return (this.c != null ? this.c.size() + 0 : 0) > 0 ? 1 : 0;
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
        return this.d;
    }

    @Override // com.baidu.tieba.view.ah
    public void d() {
        if (this.b != null) {
            this.b.d();
        }
    }

    @Override // com.baidu.tieba.view.ah
    public void a(View view, int i, int i2) {
        if (this.b != null) {
            this.b.a(this.d, 0, 0);
        }
    }
}
