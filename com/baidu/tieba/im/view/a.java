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
import com.baidu.tieba.d;
import com.baidu.tieba.im.util.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends RelativeLayout {
    private int HF;
    private int eOc;
    private C0178a eOd;
    private int eOe;
    private int eOf;
    private b eOg;
    private Context mContext;
    private int mMaxWidth;
    private int mWidth;

    /* loaded from: classes3.dex */
    public interface b {
        void a(int i, com.baidu.tieba.im.data.b bVar);
    }

    public void setOnItemClickListener(b bVar) {
        this.eOg = bVar;
    }

    public a(Context context) {
        super(context);
        this.mContext = context;
        addView(m(new ArrayList<>(), -2));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 80;
        layoutParams.bottomMargin = e.C(this.mContext, d.e.ds14);
        setLayoutParams(layoutParams);
        setBackgroundResource(d.f.bg_bottombar_meun_float);
        this.eOc = e.C(this.mContext, d.e.ds36);
        this.HF = e.C(this.mContext, d.e.ds200);
        this.mMaxWidth = e.C(this.mContext, d.e.ds504);
    }

    private ListView m(List<com.baidu.tieba.im.data.b> list, int i) {
        ListView listView = new ListView(this.mContext);
        listView.setLayoutParams(new RelativeLayout.LayoutParams(i, -2));
        listView.setCacheColorHint(this.mContext.getResources().getColor(17170445));
        listView.setDivider(null);
        listView.setDividerHeight(0);
        this.eOd = new C0178a(this.mContext, list);
        listView.setAdapter((ListAdapter) this.eOd);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.im.view.a.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
                Object item = a.this.eOd.getItem(i2);
                if (item instanceof com.baidu.tieba.im.data.b) {
                    com.baidu.tieba.im.data.b bVar = (com.baidu.tieba.im.data.b) item;
                    if (a.this.eOg != null) {
                        a.this.eOg.a(a.this.eOe, bVar);
                    }
                }
            }
        });
        return listView;
    }

    public void a(int i, int i2, List<com.baidu.tieba.im.data.b> list) {
        if (list != null) {
            this.eOf = i;
            this.eOe = i2;
            this.mWidth = cq(list);
            removeAllViews();
            addView(m(list, this.mWidth));
        }
    }

    private int cq(List<com.baidu.tieba.im.data.b> list) {
        Paint paint = new Paint(1);
        paint.setColor(this.mContext.getResources().getColor(17170443));
        paint.setTextSize(e.C(this.mContext, d.e.ds32));
        int i = 0;
        float f = 0.0f;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                float measureText = paint.measureText(list.get(i2).getName());
                if (measureText > f) {
                    f = measureText;
                }
                i = i2 + 1;
            } else {
                return (int) Math.min(Math.max((this.eOc * 2) + f, this.HF), this.mMaxWidth);
            }
        }
    }

    public void bK(View view) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getLayoutParams();
        if (layoutParams != null) {
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            int width = (iArr == null || iArr.length != 2) ? 0 : (iArr[0] + (view.getWidth() / 2)) - (this.mWidth / 2);
            if (this.eOe == this.eOf - 1) {
                width = ((iArr[0] + view.getWidth()) - e.C(this.mContext, d.e.ds20)) - this.mWidth;
            }
            if (width <= 0) {
                width = e.C(this.mContext, d.e.ds20);
            }
            layoutParams.leftMargin = width;
            setLayoutParams(layoutParams);
            setVisibility(0);
            hU(true);
        }
    }

    public void asK() {
        setVisibility(8);
        hU(false);
    }

    public void aMo() {
        setVisibility(8);
    }

    public void hU(boolean z) {
        if (z) {
            startAnimation(AnimationUtils.loadAnimation(this.mContext, d.a.sub_menu_up));
        } else {
            startAnimation(AnimationUtils.loadAnimation(this.mContext, d.a.sub_menu_down));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.im.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0178a extends BaseAdapter {
        private List<com.baidu.tieba.im.data.b> eOi;
        private Context mContext;

        public C0178a(Context context, List<com.baidu.tieba.im.data.b> list) {
            this.mContext = context;
            this.eOi = list;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.eOi == null) {
                return 0;
            }
            return (this.eOi.size() * 2) - 1;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            int itemId = (int) getItemId(i);
            if (this.eOi != null && itemId >= 0 && itemId < this.eOi.size()) {
                return this.eOi.get(itemId);
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

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getViewTypeCount() {
            return 2;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            LinearLayout linearLayout;
            int itemViewType = getItemViewType(i);
            View view2 = view;
            if (view == null) {
                C0179a c0179a = new C0179a();
                if (itemViewType == 0) {
                    TextView textView = new TextView(this.mContext);
                    textView.setLayoutParams(new AbsListView.LayoutParams(-1, e.C(this.mContext, d.e.ds96)));
                    textView.setTextSize(0, e.C(this.mContext, d.e.ds32));
                    textView.setTextColor(this.mContext.getResources().getColor(d.C0140d.cp_cont_b));
                    textView.setGravity(17);
                    textView.setBackgroundResource(d.f.official_bar_menu_text_bg);
                    textView.setSingleLine();
                    textView.setEllipsize(TextUtils.TruncateAt.END);
                    c0179a.eOj = textView;
                    linearLayout = textView;
                } else {
                    linearLayout = view;
                    if (itemViewType == 1) {
                        LinearLayout linearLayout2 = new LinearLayout(this.mContext);
                        linearLayout2.setLayoutParams(new AbsListView.LayoutParams(-1, e.C(this.mContext, d.e.ds1)));
                        ImageView imageView = new ImageView(this.mContext);
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
                        layoutParams.setMargins(e.C(this.mContext, d.e.ds30), 0, e.C(this.mContext, d.e.ds30), 0);
                        imageView.setLayoutParams(layoutParams);
                        imageView.setBackgroundColor(this.mContext.getResources().getColor(d.C0140d.cp_bg_line_b));
                        linearLayout2.addView(imageView);
                        linearLayout = linearLayout2;
                    }
                }
                linearLayout.setTag(c0179a);
                view2 = linearLayout;
            }
            C0179a c0179a2 = (C0179a) view2.getTag();
            if (itemViewType == 0) {
                c0179a2.eOj.setText(((com.baidu.tieba.im.data.b) getItem(i)).getName());
            }
            return view2;
        }

        /* renamed from: com.baidu.tieba.im.view.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        class C0179a {
            TextView eOj;

            C0179a() {
            }
        }
    }
}
