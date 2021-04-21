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
    public int f17801e;

    /* renamed from: f  reason: collision with root package name */
    public int f17802f;

    /* renamed from: g  reason: collision with root package name */
    public int f17803g;

    /* renamed from: h  reason: collision with root package name */
    public int f17804h;
    public Context i;
    public b j;
    public int k;
    public int l;
    public c m;

    /* loaded from: classes4.dex */
    public class a implements AdapterView.OnItemClickListener {
        public a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            Object item = OfficialSecondMenuPopupWindow.this.j.getItem(i);
            if (item instanceof d.b.j0.e1.g.b) {
                d.b.j0.e1.g.b bVar = (d.b.j0.e1.g.b) item;
                if (OfficialSecondMenuPopupWindow.this.m != null) {
                    OfficialSecondMenuPopupWindow.this.m.onItemClick(OfficialSecondMenuPopupWindow.this.k, bVar);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class b extends BaseAdapter {

        /* renamed from: e  reason: collision with root package name */
        public Context f17806e;

        /* renamed from: f  reason: collision with root package name */
        public List<d.b.j0.e1.g.b> f17807f;

        /* loaded from: classes4.dex */
        public class a {

            /* renamed from: a  reason: collision with root package name */
            public TextView f17808a;

            public a(b bVar) {
            }
        }

        public b(Context context, List<d.b.j0.e1.g.b> list) {
            this.f17806e = context;
            this.f17807f = list;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            List<d.b.j0.e1.g.b> list = this.f17807f;
            if (list == null) {
                return 0;
            }
            return (list.size() * 2) - 1;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            int itemId = (int) getItemId(i);
            List<d.b.j0.e1.g.b> list = this.f17807f;
            if (list != null && itemId >= 0 && itemId < list.size()) {
                return this.f17807f.get(itemId);
            }
            return null;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            if (i % 2 == 1) {
                return -1L;
            }
            return i / 2;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getItemViewType(int i) {
            return getItemId(i) == -1 ? 1 : 0;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            LinearLayout linearLayout;
            int itemViewType = getItemViewType(i);
            View view2 = view;
            if (view == null) {
                a aVar = new a(this);
                if (itemViewType == 0) {
                    TextView textView = new TextView(this.f17806e);
                    textView.setLayoutParams(new AbsListView.LayoutParams(-1, d.b.j0.e1.w.c.d(this.f17806e, R.dimen.ds96)));
                    textView.setTextSize(0, d.b.j0.e1.w.c.d(this.f17806e, R.dimen.ds32));
                    textView.setTextColor(this.f17806e.getResources().getColor(R.color.CAM_X0105));
                    textView.setGravity(17);
                    textView.setBackgroundResource(R.drawable.official_bar_menu_text_bg);
                    textView.setSingleLine();
                    textView.setEllipsize(TextUtils.TruncateAt.END);
                    aVar.f17808a = textView;
                    linearLayout = textView;
                } else {
                    linearLayout = view;
                    if (itemViewType == 1) {
                        LinearLayout linearLayout2 = new LinearLayout(this.f17806e);
                        linearLayout2.setLayoutParams(new AbsListView.LayoutParams(-1, d.b.j0.e1.w.c.d(this.f17806e, R.dimen.ds1)));
                        ImageView imageView = new ImageView(this.f17806e);
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
                        layoutParams.setMargins(d.b.j0.e1.w.c.d(this.f17806e, R.dimen.ds30), 0, d.b.j0.e1.w.c.d(this.f17806e, R.dimen.ds30), 0);
                        imageView.setLayoutParams(layoutParams);
                        imageView.setBackgroundColor(this.f17806e.getResources().getColor(R.color.CAM_X0204));
                        linearLayout2.addView(imageView);
                        linearLayout = linearLayout2;
                    }
                }
                linearLayout.setTag(aVar);
                view2 = linearLayout;
            }
            a aVar2 = (a) view2.getTag();
            if (itemViewType == 0) {
                aVar2.f17808a.setText(((d.b.j0.e1.g.b) getItem(i)).d());
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
        void onItemClick(int i, d.b.j0.e1.g.b bVar);
    }

    public OfficialSecondMenuPopupWindow(Context context) {
        super(context);
        this.i = context;
        addView(e(new ArrayList<>(), -2));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 80;
        layoutParams.bottomMargin = d.b.j0.e1.w.c.d(this.i, R.dimen.ds14);
        setLayoutParams(layoutParams);
        setBackgroundResource(R.drawable.bg_bottombar_meun_float);
        this.f17801e = d.b.j0.e1.w.c.d(this.i, R.dimen.ds36);
        this.f17803g = d.b.j0.e1.w.c.d(this.i, R.dimen.ds200);
        this.f17802f = d.b.j0.e1.w.c.d(this.i, R.dimen.ds504);
    }

    public void d(boolean z) {
        if (z) {
            startAnimation(AnimationUtils.loadAnimation(this.i, R.anim.sub_menu_up));
        } else {
            startAnimation(AnimationUtils.loadAnimation(this.i, R.anim.sub_menu_down));
        }
    }

    public final ListView e(List<d.b.j0.e1.g.b> list, int i) {
        ListView listView = new ListView(this.i);
        listView.setLayoutParams(new RelativeLayout.LayoutParams(i, -2));
        listView.setCacheColorHint(this.i.getResources().getColor(17170445));
        listView.setDivider(null);
        listView.setDividerHeight(0);
        b bVar = new b(this.i, list);
        this.j = bVar;
        listView.setAdapter((ListAdapter) bVar);
        listView.setOnItemClickListener(new a());
        return listView;
    }

    public final int f(List<d.b.j0.e1.g.b> list) {
        Paint paint = new Paint(1);
        paint.setColor(this.i.getResources().getColor(17170443));
        paint.setTextSize(d.b.j0.e1.w.c.d(this.i, R.dimen.ds32));
        float f2 = 0.0f;
        for (int i = 0; i < list.size(); i++) {
            float measureText = paint.measureText(list.get(i).d());
            if (measureText > f2) {
                f2 = measureText;
            }
        }
        return (int) Math.min(Math.max((this.f17801e * 2) + f2, this.f17803g), this.f17802f);
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
            int width = (iArr[0] + (view.getWidth() / 2)) - (this.f17804h / 2);
            if (this.k == this.l - 1) {
                width = ((iArr[0] + view.getWidth()) - d.b.j0.e1.w.c.d(this.i, R.dimen.ds20)) - this.f17804h;
            }
            if (width <= 0) {
                width = d.b.j0.e1.w.c.d(this.i, R.dimen.ds20);
            }
            layoutParams.leftMargin = width;
            setLayoutParams(layoutParams);
            setVisibility(0);
            d(true);
        }
    }

    public void setData(int i, int i2, List<d.b.j0.e1.g.b> list) {
        if (list == null) {
            return;
        }
        this.l = i;
        this.k = i2;
        this.f17804h = f(list);
        removeAllViews();
        addView(e(list, this.f17804h));
    }

    public void setOnItemClickListener(c cVar) {
        this.m = cVar;
    }
}
