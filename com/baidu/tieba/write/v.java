package com.baidu.tieba.write;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.img.ImageFileInfo;
import com.slidingmenu.lib.R;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class v extends HorizontalScrollView {
    private int a;
    private int b;
    private int c;
    private Runnable d;
    private Context e;
    private TbImageView[] f;
    private Map<TbImageView, TextView> g;
    private View h;
    private View i;
    private z j;
    private com.baidu.tieba.img.e k;
    private boolean l;
    private String m;
    private boolean n;
    private int o;

    public v(Context context, z zVar, String str) {
        super(context);
        this.a = 0;
        this.b = 0;
        this.c = 60;
        this.d = new w(this);
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = true;
        this.m = "normal";
        this.n = false;
        this.o = 0;
        this.e = context;
        this.j = zVar;
        if (str != null) {
            this.m = str;
        }
        b();
    }

    private void b() {
        this.a = (int) this.e.getResources().getDimension(R.dimen.ds4);
        this.b = (int) this.e.getResources().getDimension(R.dimen.ds30);
        this.c = (int) this.e.getResources().getDimension(R.dimen.motu_preview_size);
        LinearLayout linearLayout = new LinearLayout(this.e);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        linearLayout.setGravity(16);
        linearLayout.setOrientation(0);
        linearLayout.setPadding(this.b, linearLayout.getPaddingTop(), linearLayout.getPaddingRight(), linearLayout.getPaddingBottom());
        setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        addView(linearLayout);
        String[] stringArray = this.e.getResources().getStringArray(R.array.fiter_name);
        this.f = new TbImageView[stringArray.length];
        this.g = new HashMap();
        LayoutInflater from = LayoutInflater.from(this.e);
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
            TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.filter_immage);
            tbImageView.setDefaultResource(0);
            tbImageView.setNightDefaultResource(0);
            tbImageView.setPadding(this.a, this.a, this.a, this.a);
            tbImageView.setOnClickListener(new x(this));
            if (substring.equals(this.m)) {
                this.h = inflate;
                this.i = tbImageView;
                tbImageView.setBackgroundResource(R.drawable.bg_choose_filter);
                textView.setSelected(true);
            }
            this.f[i2] = tbImageView;
            this.g.put(tbImageView, textView);
            linearLayout.addView(inflate);
            i++;
            i2++;
        }
        this.k = new com.baidu.tieba.img.e(this.e);
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.h != null) {
            post(this.d);
        }
    }

    public String getSelectedFilter() {
        TextView textView;
        return (this.i == null || (textView = this.g.get(this.i)) == null) ? "normal" : (String) textView.getTag();
    }

    public void setCanbeClick(boolean z) {
        this.l = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view) {
        if (this.l && view != this.i) {
            if (this.i != null) {
                this.i.setBackgroundDrawable(null);
                TextView textView = this.g.get(this.i);
                if (textView != null) {
                    textView.setSelected(false);
                }
            }
            this.i = view;
            view.setBackgroundResource(R.drawable.bg_choose_filter);
            TextView textView2 = this.g.get(this.i);
            if (textView2 != null) {
                textView2.setSelected(true);
            }
            this.m = (String) textView2.getTag();
            if (this.j != null) {
                this.j.a(this.m);
            }
        }
    }

    public void a(ImageFileInfo imageFileInfo) {
        TbImageView[] tbImageViewArr;
        String str;
        if (this.n) {
            a();
        }
        this.n = true;
        for (TbImageView tbImageView : this.f) {
            tbImageView.setDefaultResource(0);
            tbImageView.setNightDefaultResource(0);
            ImageFileInfo imageFileInfo2 = new ImageFileInfo();
            imageFileInfo2.setFilePath(imageFileInfo.getFilePath());
            imageFileInfo2.addPageAction(com.baidu.tieba.img.effects.d.a(this.c, this.c));
            imageFileInfo2.addPageAction(com.baidu.tieba.img.effects.f.a(5.0f));
            TextView textView = this.g.get(tbImageView);
            if (textView != null && (str = (String) textView.getTag()) != null && !str.equals("normal")) {
                imageFileInfo2.addPageAction(com.baidu.tieba.img.effects.a.a(str));
            }
            tbImageView.setTag(imageFileInfo2.toCachedKey(false));
            if (this.k.a(imageFileInfo2, false) != null) {
                tbImageView.invalidate();
                tbImageView.setDefaultResource(0);
                tbImageView.setNightDefaultResource(0);
                this.o++;
                if (this.o >= this.f.length) {
                    this.n = false;
                }
            } else {
                this.k.a(imageFileInfo2, new y(this, tbImageView), false);
            }
        }
    }

    public void a() {
        if (this.k != null) {
            this.k.b();
            this.o = 0;
            this.n = false;
        }
    }
}
