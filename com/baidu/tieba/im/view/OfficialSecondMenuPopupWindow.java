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
public class OfficialSecondMenuPopupWindow extends RelativeLayout {
    private int evh;
    private a evi;
    private int evj;
    private int evk;
    private b evl;
    private Context mContext;
    private int mMaxWidth;
    private int mMinWidth;
    private int mWidth;

    /* loaded from: classes3.dex */
    public interface b {
        void a(int i, com.baidu.tieba.im.data.b bVar);
    }

    public void setOnItemClickListener(b bVar) {
        this.evl = bVar;
    }

    public OfficialSecondMenuPopupWindow(Context context) {
        super(context);
        this.mContext = context;
        addView(j(new ArrayList<>(), -2));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 80;
        layoutParams.bottomMargin = e.n(this.mContext, d.e.ds14);
        setLayoutParams(layoutParams);
        setBackgroundResource(d.f.bg_bottombar_meun_float);
        this.evh = e.n(this.mContext, d.e.ds36);
        this.mMinWidth = e.n(this.mContext, d.e.ds200);
        this.mMaxWidth = e.n(this.mContext, d.e.ds504);
    }

    private ListView j(List<com.baidu.tieba.im.data.b> list, int i) {
        ListView listView = new ListView(this.mContext);
        listView.setLayoutParams(new RelativeLayout.LayoutParams(i, -2));
        listView.setCacheColorHint(this.mContext.getResources().getColor(17170445));
        listView.setDivider(null);
        listView.setDividerHeight(0);
        this.evi = new a(this.mContext, list);
        listView.setAdapter((ListAdapter) this.evi);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.im.view.OfficialSecondMenuPopupWindow.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
                Object item = OfficialSecondMenuPopupWindow.this.evi.getItem(i2);
                if (item instanceof com.baidu.tieba.im.data.b) {
                    com.baidu.tieba.im.data.b bVar = (com.baidu.tieba.im.data.b) item;
                    if (OfficialSecondMenuPopupWindow.this.evl != null) {
                        OfficialSecondMenuPopupWindow.this.evl.a(OfficialSecondMenuPopupWindow.this.evj, bVar);
                    }
                }
            }
        });
        return listView;
    }

    public void setData(int i, int i2, List<com.baidu.tieba.im.data.b> list) {
        if (list != null) {
            this.evk = i;
            this.evj = i2;
            this.mWidth = cr(list);
            removeAllViews();
            addView(j(list, this.mWidth));
        }
    }

    private int cr(List<com.baidu.tieba.im.data.b> list) {
        Paint paint = new Paint(1);
        paint.setColor(this.mContext.getResources().getColor(17170443));
        paint.setTextSize(e.n(this.mContext, d.e.ds32));
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
                return (int) Math.min(Math.max((this.evh * 2) + f, this.mMinWidth), this.mMaxWidth);
            }
        }
    }

    public void ap(View view) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getLayoutParams();
        if (layoutParams != null) {
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            int width = (iArr == null || iArr.length != 2) ? 0 : (iArr[0] + (view.getWidth() / 2)) - (this.mWidth / 2);
            if (this.evj == this.evk - 1) {
                width = ((iArr[0] + view.getWidth()) - e.n(this.mContext, d.e.ds20)) - this.mWidth;
            }
            if (width <= 0) {
                width = e.n(this.mContext, d.e.ds20);
            }
            layoutParams.leftMargin = width;
            setLayoutParams(layoutParams);
            setVisibility(0);
            hG(true);
        }
    }

    public void arf() {
        setVisibility(8);
        hG(false);
    }

    public void aMh() {
        setVisibility(8);
    }

    public void hG(boolean z) {
        if (z) {
            startAnimation(AnimationUtils.loadAnimation(this.mContext, d.a.sub_menu_up));
        } else {
            startAnimation(AnimationUtils.loadAnimation(this.mContext, d.a.sub_menu_down));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class a extends BaseAdapter {
        private List<com.baidu.tieba.im.data.b> evn;
        private Context mContext;

        public a(Context context, List<com.baidu.tieba.im.data.b> list) {
            this.mContext = context;
            this.evn = list;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.evn == null) {
                return 0;
            }
            return (this.evn.size() * 2) - 1;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            int itemId = (int) getItemId(i);
            if (this.evn != null && itemId >= 0 && itemId < this.evn.size()) {
                return this.evn.get(itemId);
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
                    textView.setLayoutParams(new AbsListView.LayoutParams(-1, e.n(this.mContext, d.e.ds96)));
                    textView.setTextSize(0, e.n(this.mContext, d.e.ds32));
                    textView.setTextColor(this.mContext.getResources().getColor(d.C0141d.cp_cont_b));
                    textView.setGravity(17);
                    textView.setBackgroundResource(d.f.official_bar_menu_text_bg);
                    textView.setSingleLine();
                    textView.setEllipsize(TextUtils.TruncateAt.END);
                    c0179a.evo = textView;
                    linearLayout = textView;
                } else {
                    linearLayout = view;
                    if (itemViewType == 1) {
                        LinearLayout linearLayout2 = new LinearLayout(this.mContext);
                        linearLayout2.setLayoutParams(new AbsListView.LayoutParams(-1, e.n(this.mContext, d.e.ds1)));
                        ImageView imageView = new ImageView(this.mContext);
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
                        layoutParams.setMargins(e.n(this.mContext, d.e.ds30), 0, e.n(this.mContext, d.e.ds30), 0);
                        imageView.setLayoutParams(layoutParams);
                        imageView.setBackgroundColor(this.mContext.getResources().getColor(d.C0141d.cp_bg_line_b));
                        linearLayout2.addView(imageView);
                        linearLayout = linearLayout2;
                    }
                }
                linearLayout.setTag(c0179a);
                view2 = linearLayout;
            }
            C0179a c0179a2 = (C0179a) view2.getTag();
            if (itemViewType == 0) {
                c0179a2.evo.setText(((com.baidu.tieba.im.data.b) getItem(i)).getName());
            }
            return view2;
        }

        /* renamed from: com.baidu.tieba.im.view.OfficialSecondMenuPopupWindow$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        class C0179a {
            TextView evo;

            C0179a() {
            }
        }
    }
}
