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
import com.baidu.tieba.e;
import com.baidu.tieba.im.util.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class OfficialSecondMenuPopupWindow extends RelativeLayout {
    private int eZT;
    private a eZU;
    private int eZV;
    private int eZW;
    private b eZX;
    private Context mContext;
    private int mMaxWidth;
    private int mMinWidth;
    private int mWidth;

    /* loaded from: classes3.dex */
    public interface b {
        void a(int i, com.baidu.tieba.im.data.b bVar);
    }

    public void setOnItemClickListener(b bVar) {
        this.eZX = bVar;
    }

    public OfficialSecondMenuPopupWindow(Context context) {
        super(context);
        this.mContext = context;
        addView(m(new ArrayList<>(), -2));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 80;
        layoutParams.bottomMargin = e.r(this.mContext, e.C0210e.ds14);
        setLayoutParams(layoutParams);
        setBackgroundResource(e.f.bg_bottombar_meun_float);
        this.eZT = com.baidu.tieba.im.util.e.r(this.mContext, e.C0210e.ds36);
        this.mMinWidth = com.baidu.tieba.im.util.e.r(this.mContext, e.C0210e.ds200);
        this.mMaxWidth = com.baidu.tieba.im.util.e.r(this.mContext, e.C0210e.ds504);
    }

    private ListView m(List<com.baidu.tieba.im.data.b> list, int i) {
        ListView listView = new ListView(this.mContext);
        listView.setLayoutParams(new RelativeLayout.LayoutParams(i, -2));
        listView.setCacheColorHint(this.mContext.getResources().getColor(17170445));
        listView.setDivider(null);
        listView.setDividerHeight(0);
        this.eZU = new a(this.mContext, list);
        listView.setAdapter((ListAdapter) this.eZU);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.im.view.OfficialSecondMenuPopupWindow.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
                Object item = OfficialSecondMenuPopupWindow.this.eZU.getItem(i2);
                if (item instanceof com.baidu.tieba.im.data.b) {
                    com.baidu.tieba.im.data.b bVar = (com.baidu.tieba.im.data.b) item;
                    if (OfficialSecondMenuPopupWindow.this.eZX != null) {
                        OfficialSecondMenuPopupWindow.this.eZX.a(OfficialSecondMenuPopupWindow.this.eZV, bVar);
                    }
                }
            }
        });
        return listView;
    }

    public void setData(int i, int i2, List<com.baidu.tieba.im.data.b> list) {
        if (list != null) {
            this.eZW = i;
            this.eZV = i2;
            this.mWidth = cN(list);
            removeAllViews();
            addView(m(list, this.mWidth));
        }
    }

    private int cN(List<com.baidu.tieba.im.data.b> list) {
        Paint paint = new Paint(1);
        paint.setColor(this.mContext.getResources().getColor(17170443));
        paint.setTextSize(com.baidu.tieba.im.util.e.r(this.mContext, e.C0210e.ds32));
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
                return (int) Math.min(Math.max((this.eZT * 2) + f, this.mMinWidth), this.mMaxWidth);
            }
        }
    }

    public void aK(View view) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getLayoutParams();
        if (layoutParams != null) {
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            int width = (iArr == null || iArr.length != 2) ? 0 : (iArr[0] + (view.getWidth() / 2)) - (this.mWidth / 2);
            if (this.eZV == this.eZW - 1) {
                width = ((iArr[0] + view.getWidth()) - com.baidu.tieba.im.util.e.r(this.mContext, e.C0210e.ds20)) - this.mWidth;
            }
            if (width <= 0) {
                width = com.baidu.tieba.im.util.e.r(this.mContext, e.C0210e.ds20);
            }
            layoutParams.leftMargin = width;
            setLayoutParams(layoutParams);
            setVisibility(0);
            iV(true);
        }
    }

    public void axu() {
        setVisibility(8);
        iV(false);
    }

    public void aUB() {
        setVisibility(8);
    }

    public void iV(boolean z) {
        if (z) {
            startAnimation(AnimationUtils.loadAnimation(this.mContext, e.a.sub_menu_up));
        } else {
            startAnimation(AnimationUtils.loadAnimation(this.mContext, e.a.sub_menu_down));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class a extends BaseAdapter {
        private List<com.baidu.tieba.im.data.b> eZZ;
        private Context mContext;

        public a(Context context, List<com.baidu.tieba.im.data.b> list) {
            this.mContext = context;
            this.eZZ = list;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.eZZ == null) {
                return 0;
            }
            return (this.eZZ.size() * 2) - 1;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            int itemId = (int) getItemId(i);
            if (this.eZZ != null && itemId >= 0 && itemId < this.eZZ.size()) {
                return this.eZZ.get(itemId);
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
                C0253a c0253a = new C0253a();
                if (itemViewType == 0) {
                    TextView textView = new TextView(this.mContext);
                    textView.setLayoutParams(new AbsListView.LayoutParams(-1, com.baidu.tieba.im.util.e.r(this.mContext, e.C0210e.ds96)));
                    textView.setTextSize(0, com.baidu.tieba.im.util.e.r(this.mContext, e.C0210e.ds32));
                    textView.setTextColor(this.mContext.getResources().getColor(e.d.cp_cont_b));
                    textView.setGravity(17);
                    textView.setBackgroundResource(e.f.official_bar_menu_text_bg);
                    textView.setSingleLine();
                    textView.setEllipsize(TextUtils.TruncateAt.END);
                    c0253a.faa = textView;
                    linearLayout = textView;
                } else {
                    linearLayout = view;
                    if (itemViewType == 1) {
                        LinearLayout linearLayout2 = new LinearLayout(this.mContext);
                        linearLayout2.setLayoutParams(new AbsListView.LayoutParams(-1, com.baidu.tieba.im.util.e.r(this.mContext, e.C0210e.ds1)));
                        ImageView imageView = new ImageView(this.mContext);
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
                        layoutParams.setMargins(com.baidu.tieba.im.util.e.r(this.mContext, e.C0210e.ds30), 0, com.baidu.tieba.im.util.e.r(this.mContext, e.C0210e.ds30), 0);
                        imageView.setLayoutParams(layoutParams);
                        imageView.setBackgroundColor(this.mContext.getResources().getColor(e.d.cp_bg_line_b));
                        linearLayout2.addView(imageView);
                        linearLayout = linearLayout2;
                    }
                }
                linearLayout.setTag(c0253a);
                view2 = linearLayout;
            }
            C0253a c0253a2 = (C0253a) view2.getTag();
            if (itemViewType == 0) {
                c0253a2.faa.setText(((com.baidu.tieba.im.data.b) getItem(i)).getName());
            }
            return view2;
        }

        /* renamed from: com.baidu.tieba.im.view.OfficialSecondMenuPopupWindow$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        class C0253a {
            TextView faa;

            C0253a() {
            }
        }
    }
}
