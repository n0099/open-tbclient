package com.baidu.tieba.write;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class FeedBackTopListView extends LinearLayout {
    private Context a;
    private LayoutInflater b;
    private ArrayList<com.baidu.tbadk.core.data.n> c;
    private int d;

    public FeedBackTopListView(Context context) {
        this(context, null);
    }

    public FeedBackTopListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = -1;
        this.a = context;
        this.b = (LayoutInflater) context.getSystemService("layout_inflater");
        this.d = TbadkApplication.m252getInst().getSkinType();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setData(ArrayList<com.baidu.tbadk.core.data.n> arrayList) {
        int i = 0;
        if (arrayList == null || arrayList.size() == 0) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        if (arrayList.size() > 3) {
            this.c = new ArrayList<>(arrayList.subList(0, 3));
        } else {
            this.c = arrayList;
        }
        while (true) {
            int i2 = i;
            if (i2 < this.c.size()) {
                addView(a(this.c.get(i2), i2));
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private View a(com.baidu.tbadk.core.data.n nVar, int i) {
        BitmapDrawable bitmapDrawable;
        if (nVar == null) {
            return null;
        }
        View inflate = this.b.inflate(com.baidu.tieba.v.frs_top_item, (ViewGroup) null);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(com.baidu.tieba.u.frs_top_item);
        TextView textView = (TextView) inflate.findViewById(com.baidu.tieba.u.frs_top_title);
        View findViewById = inflate.findViewById(com.baidu.tieba.u.frs_top_divider);
        String i2 = nVar.i();
        textView.setText(nVar.j());
        ((BaseActivity) this.a).getLayoutMode().a(this.d == 1);
        ((BaseActivity) this.a).getLayoutMode().a(inflate);
        if (this.d == 1) {
            bitmapDrawable = (BitmapDrawable) this.a.getResources().getDrawable(com.baidu.tieba.t.icon_notice_1);
            linearLayout.setBackgroundResource(com.baidu.tieba.t.bg_frs_top_middle_selector_1);
        } else {
            bitmapDrawable = (BitmapDrawable) this.a.getResources().getDrawable(com.baidu.tieba.t.icon_notice);
            linearLayout.setBackgroundResource(com.baidu.tieba.t.bg_frs_top_middle_selector);
        }
        if (bitmapDrawable != null) {
            bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight());
        }
        if (i == this.c.size() - 1) {
            findViewById.setVisibility(8);
        } else {
            findViewById.setVisibility(0);
        }
        textView.setCompoundDrawables(bitmapDrawable, null, null, null);
        linearLayout.setOnClickListener(new q(this, i2));
        return inflate;
    }
}
