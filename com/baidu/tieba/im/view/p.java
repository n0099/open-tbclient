package com.baidu.tieba.im.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p extends BaseAdapter {
    private Context a;
    private List<com.baidu.tieba.im.data.l> b;

    public p(Context context, List<com.baidu.tieba.im.data.l> list) {
        this.a = context;
        this.b = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.b == null) {
            return 0;
        }
        return (this.b.size() * 2) - 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        int itemId = (int) getItemId(i);
        if (this.b != null && itemId >= 0 && itemId < this.b.size()) {
            return this.b.get(itemId);
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

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v3, types: [android.view.View] */
    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        TextView textView;
        int itemViewType = getItemViewType(i);
        View view2 = view;
        if (view == null) {
            q qVar = new q(this);
            if (itemViewType == 0) {
                TextView textView2 = new TextView(this.a);
                textView2.setLayoutParams(new AbsListView.LayoutParams(-1, com.baidu.tieba.im.e.r.a(this.a, com.baidu.tieba.t.ds96)));
                textView2.setTextSize(0, com.baidu.tieba.im.e.r.a(this.a, com.baidu.tieba.t.ds32));
                textView2.setTextColor(this.a.getResources().getColor(com.baidu.tieba.s.official_bar_menu_text_color));
                textView2.setGravity(17);
                textView2.setBackgroundResource(com.baidu.tieba.u.official_bar_menu_text_bg);
                textView2.setSingleLine();
                textView2.setEllipsize(TextUtils.TruncateAt.END);
                qVar.a = textView2;
                textView = textView2;
            } else {
                textView = view;
                if (itemViewType == 1) {
                    ImageView imageView = new ImageView(this.a);
                    imageView.setLayoutParams(new AbsListView.LayoutParams(-1, com.baidu.tieba.im.e.r.a(this.a, com.baidu.tieba.t.ds1)));
                    imageView.setBackgroundColor(this.a.getResources().getColor(com.baidu.tieba.s.official_bar_menu_bottom_line));
                    textView = imageView;
                }
            }
            textView.setTag(qVar);
            view2 = textView;
        }
        q qVar2 = (q) view2.getTag();
        if (itemViewType == 0) {
            qVar2.a.setText(((com.baidu.tieba.im.data.l) getItem(i)).b());
        }
        return view2;
    }
}
