package com.baidu.tieba.im.view;

import android.content.Context;
import android.graphics.Paint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class OfficialSecondMenuPopupWindow extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public int f18129e;

    /* renamed from: f  reason: collision with root package name */
    public int f18130f;

    /* renamed from: g  reason: collision with root package name */
    public int f18131g;

    /* renamed from: h  reason: collision with root package name */
    public int f18132h;

    /* renamed from: i  reason: collision with root package name */
    public Context f18133i;
    public b j;
    public int k;
    public int l;
    public c m;

    /* loaded from: classes4.dex */
    public class a implements AdapterView.OnItemClickListener {
        public a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            Object item = OfficialSecondMenuPopupWindow.this.j.getItem(i2);
            if (item instanceof d.a.j0.e1.g.b) {
                d.a.j0.e1.g.b bVar = (d.a.j0.e1.g.b) item;
                if (OfficialSecondMenuPopupWindow.this.m != null) {
                    OfficialSecondMenuPopupWindow.this.m.onItemClick(OfficialSecondMenuPopupWindow.this.k, bVar);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class b extends BaseAdapter {

        /* renamed from: e  reason: collision with root package name */
        public Context f18135e;

        /* renamed from: f  reason: collision with root package name */
        public List<d.a.j0.e1.g.b> f18136f;

        /* loaded from: classes4.dex */
        public class a {

            /* renamed from: a  reason: collision with root package name */
            public TextView f18137a;

            public a(b bVar) {
            }
        }

        public b(Context context, List<d.a.j0.e1.g.b> list) {
            this.f18135e = context;
            this.f18136f = list;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            List<d.a.j0.e1.g.b> list = this.f18136f;
            if (list == null) {
                return 0;
            }
            return (list.size() * 2) - 1;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i2) {
            int itemId = (int) getItemId(i2);
            List<d.a.j0.e1.g.b> list = this.f18136f;
            if (list != null && itemId >= 0 && itemId < list.size()) {
                return this.f18136f.get(itemId);
            }
            return null;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i2) {
            if (i2 % 2 == 1) {
                return -1L;
            }
            return i2 / 2;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getItemViewType(int i2) {
            return getItemId(i2) == -1 ? 1 : 0;
        }

        @Override // android.widget.Adapter
        public View getView(int i2, View view, ViewGroup viewGroup) {
            LinearLayout linearLayout;
            int itemViewType = getItemViewType(i2);
            View view2 = view;
            if (view == null) {
                a aVar = new a(this);
                if (itemViewType == 0) {
                    TextView textView = new TextView(this.f18135e);
                    textView.setLayoutParams(new AbsListView.LayoutParams(-1, d.a.j0.e1.w.c.d(this.f18135e, R.dimen.ds96)));
                    textView.setTextSize(0, d.a.j0.e1.w.c.d(this.f18135e, R.dimen.ds32));
                    textView.setTextColor(this.f18135e.getResources().getColor(R.color.CAM_X0105));
                    textView.setGravity(17);
                    textView.setBackgroundResource(R.drawable.official_bar_menu_text_bg);
                    textView.setSingleLine();
                    textView.setEllipsize(TextUtils.TruncateAt.END);
                    aVar.f18137a = textView;
                    linearLayout = textView;
                } else {
                    linearLayout = view;
                    if (itemViewType == 1) {
                        LinearLayout linearLayout2 = new LinearLayout(this.f18135e);
                        linearLayout2.setLayoutParams(new AbsListView.LayoutParams(-1, d.a.j0.e1.w.c.d(this.f18135e, R.dimen.ds1)));
                        ImageView imageView = new ImageView(this.f18135e);
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
                        layoutParams.setMargins(d.a.j0.e1.w.c.d(this.f18135e, R.dimen.ds30), 0, d.a.j0.e1.w.c.d(this.f18135e, R.dimen.ds30), 0);
                        imageView.setLayoutParams(layoutParams);
                        imageView.setBackgroundColor(this.f18135e.getResources().getColor(R.color.CAM_X0204));
                        linearLayout2.addView(imageView);
                        linearLayout = linearLayout2;
                    }
                }
                linearLayout.setTag(aVar);
                view2 = linearLayout;
            }
            a aVar2 = (a) view2.getTag();
            if (itemViewType == 0) {
                aVar2.f18137a.setText(((d.a.j0.e1.g.b) getItem(i2)).d());
            }
            return view2;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getViewTypeCount() {
            return 2;
        }
    }

    /* loaded from: classes4.dex */
    public interface c {
        void onItemClick(int i2, d.a.j0.e1.g.b bVar);
    }

    public OfficialSecondMenuPopupWindow(Context context) {
        super(context);
        this.f18133i = context;
        addView(e(new ArrayList<>(), -2));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 80;
        layoutParams.bottomMargin = d.a.j0.e1.w.c.d(this.f18133i, R.dimen.ds14);
        setLayoutParams(layoutParams);
        setBackgroundResource(R.drawable.bg_bottombar_meun_float);
        this.f18129e = d.a.j0.e1.w.c.d(this.f18133i, R.dimen.ds36);
        this.f18131g = d.a.j0.e1.w.c.d(this.f18133i, R.dimen.ds200);
        this.f18130f = d.a.j0.e1.w.c.d(this.f18133i, R.dimen.ds504);
    }

    public void d(boolean z) {
        if (z) {
            startAnimation(AnimationUtils.loadAnimation(this.f18133i, R.anim.sub_menu_up));
        } else {
            startAnimation(AnimationUtils.loadAnimation(this.f18133i, R.anim.sub_menu_down));
        }
    }

    public final ListView e(List<d.a.j0.e1.g.b> list, int i2) {
        ListView listView = new ListView(this.f18133i);
        listView.setLayoutParams(new RelativeLayout.LayoutParams(i2, -2));
        listView.setCacheColorHint(this.f18133i.getResources().getColor(17170445));
        listView.setDivider(null);
        listView.setDividerHeight(0);
        b bVar = new b(this.f18133i, list);
        this.j = bVar;
        listView.setAdapter((ListAdapter) bVar);
        listView.setOnItemClickListener(new a());
        return listView;
    }

    public final int f(List<d.a.j0.e1.g.b> list) {
        Paint paint = new Paint(1);
        paint.setColor(this.f18133i.getResources().getColor(17170443));
        paint.setTextSize(d.a.j0.e1.w.c.d(this.f18133i, R.dimen.ds32));
        float f2 = 0.0f;
        for (int i2 = 0; i2 < list.size(); i2++) {
            float measureText = paint.measureText(list.get(i2).d());
            if (measureText > f2) {
                f2 = measureText;
            }
        }
        return (int) Math.min(Math.max((this.f18129e * 2) + f2, this.f18131g), this.f18130f);
    }

    public void g() {
        setVisibility(8);
        d(false);
    }

    public void h() {
        setVisibility(8);
    }

    public void i(View view) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getLayoutParams();
        if (layoutParams != null) {
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            int width = (iArr[0] + (view.getWidth() / 2)) - (this.f18132h / 2);
            if (this.k == this.l - 1) {
                width = ((iArr[0] + view.getWidth()) - d.a.j0.e1.w.c.d(this.f18133i, R.dimen.ds20)) - this.f18132h;
            }
            if (width <= 0) {
                width = d.a.j0.e1.w.c.d(this.f18133i, R.dimen.ds20);
            }
            layoutParams.leftMargin = width;
            setLayoutParams(layoutParams);
            setVisibility(0);
            d(true);
        }
    }

    public void setData(int i2, int i3, List<d.a.j0.e1.g.b> list) {
        if (list == null) {
            return;
        }
        this.l = i2;
        this.k = i3;
        this.f18132h = f(list);
        removeAllViews();
        addView(e(list, this.f18132h));
    }

    public void setOnItemClickListener(c cVar) {
        this.m = cVar;
    }
}
