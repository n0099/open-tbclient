package com.baidu.tieba.write;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public final class v extends HorizontalScrollView {
    private int a;
    private int b;
    private Runnable c;
    private Context d;
    private ImageView[] e;
    private View f;
    private View g;
    private y h;
    private boolean i;
    private String j;

    public v(Context context, y yVar, String str) {
        super(context);
        this.a = 0;
        this.b = 0;
        this.c = new w(this);
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = true;
        this.j = "normal";
        this.d = context;
        this.h = yVar;
        if (str != null) {
            this.j = str;
        }
        a();
    }

    private void a() {
        this.a = (int) this.d.getResources().getDimension(R.dimen.ds4);
        this.b = (int) this.d.getResources().getDimension(R.dimen.ds30);
        LinearLayout linearLayout = new LinearLayout(this.d);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        linearLayout.setGravity(16);
        linearLayout.setOrientation(0);
        linearLayout.setPadding(this.b, linearLayout.getPaddingTop(), linearLayout.getPaddingRight(), linearLayout.getPaddingBottom());
        setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        addView(linearLayout);
        String[] stringArray = this.d.getResources().getStringArray(R.array.fiter_name);
        this.e = new ImageView[stringArray.length];
        LayoutInflater from = LayoutInflater.from(this.d);
        int length = stringArray.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            String str = stringArray[i];
            String substring = str.substring(0, str.indexOf("|"));
            String substring2 = str.substring(str.indexOf("|") + 1);
            View inflate = from.inflate(R.layout.filter_item, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.filter_text);
            textView.setText(substring2);
            textView.setTag(substring);
            ImageView imageView = (ImageView) inflate.findViewById(R.id.filter_immage);
            imageView.setPadding(this.a, this.a, this.a, this.a);
            imageView.setTag(textView);
            imageView.setOnClickListener(new x(this));
            if (substring.equals(this.j)) {
                this.f = inflate;
                this.g = imageView;
                imageView.setBackgroundResource(R.drawable.bg_choose_filter);
                textView.setSelected(true);
            }
            imageView.setImageResource(a(substring));
            this.e[i2] = imageView;
            linearLayout.addView(inflate);
            i++;
            i2++;
        }
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    protected final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f != null) {
            post(this.c);
        }
    }

    public final String getSelectedFilter() {
        return this.g != null ? (String) ((View) this.g.getTag()).getTag() : "normal";
    }

    public final void setCanbeClick(boolean z) {
        this.i = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void b(v vVar, View view) {
        if (!vVar.i || view == vVar.g) {
            return;
        }
        if (vVar.g != null) {
            vVar.g.setBackgroundDrawable(null);
            ((TextView) vVar.g.getTag()).setSelected(false);
        }
        vVar.g = view;
        view.setBackgroundResource(R.drawable.bg_choose_filter);
        TextView textView = (TextView) view.getTag();
        textView.setSelected(true);
        vVar.j = (String) textView.getTag();
        if (vVar.h != null) {
            vVar.h.a(vVar.j);
        }
    }

    public static int a(String str) {
        if (str == null || str.equals("normal")) {
            return R.drawable.motu_filter_normal;
        }
        if (str.equals("skin")) {
            return R.drawable.motu_filter_skin;
        }
        if (str.equals("lomo")) {
            return R.drawable.motu_filter_lomo;
        }
        if (str.equals("classichdr")) {
            return R.drawable.motu_filter_classichdr;
        }
        if (str.equals("nashiv")) {
            return R.drawable.motu_filter_nashiv;
        }
        if (str.equals("fleeting")) {
            return R.drawable.motu_filter_fleeting;
        }
        if (str.equals("bluetone")) {
            return R.drawable.motu_filter_bluetone;
        }
        if (str.equals("elegant")) {
            return R.drawable.motu_filter_elegant;
        }
        return str.equals("gray") ? R.drawable.motu_filter_gray : R.drawable.motu_filter_normal;
    }
}
