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
import com.baidu.tieba.im.util.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes20.dex */
public class OfficialSecondMenuPopupWindow extends RelativeLayout {
    private int jkU;
    private a jkV;
    private int jkW;
    private int jkX;
    private b jkY;
    private Context mContext;
    private int mMaxWidth;
    private int mMinWidth;
    private int mWidth;

    /* loaded from: classes20.dex */
    public interface b {
        void a(int i, com.baidu.tieba.im.data.b bVar);
    }

    public void setOnItemClickListener(b bVar) {
        this.jkY = bVar;
    }

    public OfficialSecondMenuPopupWindow(Context context) {
        super(context);
        this.mContext = context;
        addView(k(new ArrayList<>(), -2));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 80;
        layoutParams.bottomMargin = e.z(this.mContext, R.dimen.ds14);
        setLayoutParams(layoutParams);
        setBackgroundResource(R.drawable.bg_bottombar_meun_float);
        this.jkU = e.z(this.mContext, R.dimen.ds36);
        this.mMinWidth = e.z(this.mContext, R.dimen.ds200);
        this.mMaxWidth = e.z(this.mContext, R.dimen.ds504);
    }

    private ListView k(List<com.baidu.tieba.im.data.b> list, int i) {
        ListView listView = new ListView(this.mContext);
        listView.setLayoutParams(new RelativeLayout.LayoutParams(i, -2));
        listView.setCacheColorHint(this.mContext.getResources().getColor(17170445));
        listView.setDivider(null);
        listView.setDividerHeight(0);
        this.jkV = new a(this.mContext, list);
        listView.setAdapter((ListAdapter) this.jkV);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.im.view.OfficialSecondMenuPopupWindow.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
                Object item = OfficialSecondMenuPopupWindow.this.jkV.getItem(i2);
                if (item instanceof com.baidu.tieba.im.data.b) {
                    com.baidu.tieba.im.data.b bVar = (com.baidu.tieba.im.data.b) item;
                    if (OfficialSecondMenuPopupWindow.this.jkY != null) {
                        OfficialSecondMenuPopupWindow.this.jkY.a(OfficialSecondMenuPopupWindow.this.jkW, bVar);
                    }
                }
            }
        });
        return listView;
    }

    public void setData(int i, int i2, List<com.baidu.tieba.im.data.b> list) {
        if (list != null) {
            this.jkX = i;
            this.jkW = i2;
            this.mWidth = dK(list);
            removeAllViews();
            addView(k(list, this.mWidth));
        }
    }

    private int dK(List<com.baidu.tieba.im.data.b> list) {
        Paint paint = new Paint(1);
        paint.setColor(this.mContext.getResources().getColor(17170443));
        paint.setTextSize(e.z(this.mContext, R.dimen.ds32));
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
                return (int) Math.min(Math.max((this.jkU * 2) + f, this.mMinWidth), this.mMaxWidth);
            }
        }
    }

    public void O(View view) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getLayoutParams();
        if (layoutParams != null) {
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            int width = (iArr == null || iArr.length != 2) ? 0 : (iArr[0] + (view.getWidth() / 2)) - (this.mWidth / 2);
            if (this.jkW == this.jkX - 1) {
                width = ((iArr[0] + view.getWidth()) - e.z(this.mContext, R.dimen.ds20)) - this.mWidth;
            }
            if (width <= 0) {
                width = e.z(this.mContext, R.dimen.ds20);
            }
            layoutParams.leftMargin = width;
            setLayoutParams(layoutParams);
            setVisibility(0);
            qs(true);
        }
    }

    public void Jj() {
        setVisibility(8);
        qs(false);
    }

    public void cxK() {
        setVisibility(8);
    }

    public void qs(boolean z) {
        if (z) {
            startAnimation(AnimationUtils.loadAnimation(this.mContext, R.anim.sub_menu_up));
        } else {
            startAnimation(AnimationUtils.loadAnimation(this.mContext, R.anim.sub_menu_down));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes20.dex */
    public static class a extends BaseAdapter {
        private List<com.baidu.tieba.im.data.b> jla;
        private Context mContext;

        public a(Context context, List<com.baidu.tieba.im.data.b> list) {
            this.mContext = context;
            this.jla = list;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.jla == null) {
                return 0;
            }
            return (this.jla.size() * 2) - 1;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            int itemId = (int) getItemId(i);
            if (this.jla != null && itemId >= 0 && itemId < this.jla.size()) {
                return this.jla.get(itemId);
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
                C0670a c0670a = new C0670a();
                if (itemViewType == 0) {
                    TextView textView = new TextView(this.mContext);
                    textView.setLayoutParams(new AbsListView.LayoutParams(-1, e.z(this.mContext, R.dimen.ds96)));
                    textView.setTextSize(0, e.z(this.mContext, R.dimen.ds32));
                    textView.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_b));
                    textView.setGravity(17);
                    textView.setBackgroundResource(R.drawable.official_bar_menu_text_bg);
                    textView.setSingleLine();
                    textView.setEllipsize(TextUtils.TruncateAt.END);
                    c0670a.jlb = textView;
                    linearLayout = textView;
                } else {
                    linearLayout = view;
                    if (itemViewType == 1) {
                        LinearLayout linearLayout2 = new LinearLayout(this.mContext);
                        linearLayout2.setLayoutParams(new AbsListView.LayoutParams(-1, e.z(this.mContext, R.dimen.ds1)));
                        ImageView imageView = new ImageView(this.mContext);
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
                        layoutParams.setMargins(e.z(this.mContext, R.dimen.ds30), 0, e.z(this.mContext, R.dimen.ds30), 0);
                        imageView.setLayoutParams(layoutParams);
                        imageView.setBackgroundColor(this.mContext.getResources().getColor(R.color.cp_bg_line_c));
                        linearLayout2.addView(imageView);
                        linearLayout = linearLayout2;
                    }
                }
                linearLayout.setTag(c0670a);
                view2 = linearLayout;
            }
            C0670a c0670a2 = (C0670a) view2.getTag();
            if (itemViewType == 0) {
                c0670a2.jlb.setText(((com.baidu.tieba.im.data.b) getItem(i)).getName());
            }
            return view2;
        }

        /* renamed from: com.baidu.tieba.im.view.OfficialSecondMenuPopupWindow$a$a  reason: collision with other inner class name */
        /* loaded from: classes20.dex */
        class C0670a {
            TextView jlb;

            C0670a() {
            }
        }
    }
}
