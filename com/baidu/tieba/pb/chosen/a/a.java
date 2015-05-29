package com.baidu.tieba.pb.chosen.a;

import android.content.Context;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.adp.lib.util.n;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.o;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a extends BaseAdapter {
    private Context context;
    private List<com.baidu.tieba.pb.d.a.e> list = new ArrayList();
    private int maxWidth;

    public a(Context context) {
        this.maxWidth = 0;
        this.context = context;
        this.maxWidth = n.M(context) - (((int) context.getResources().getDimension(o.ds30)) * 2);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.list == null) {
            return 0;
        }
        return this.list.size();
    }

    public void aS(List<com.baidu.tieba.pb.d.a.e> list) {
        this.list.clear();
        if (list != null && list.size() > 0) {
            this.list.addAll(list);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: hu */
    public com.baidu.tieba.pb.d.a.e getItem(int i) {
        if (this.list == null || this.list.size() <= 0) {
            return null;
        }
        int size = this.list.size();
        if (i < 0 || i >= size) {
            return null;
        }
        return this.list.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.list == null || this.list.size() <= 0) {
            return super.getItemViewType(i);
        }
        if (i < 0 || i >= this.list.size()) {
            return super.getItemViewType(i);
        }
        com.baidu.tieba.pb.d.a.e eVar = this.list.get(i);
        if (eVar == null) {
            return super.getItemViewType(i);
        }
        if (eVar.getType() == 0) {
            return 0;
        }
        if (eVar.getType() == 3) {
            return 1;
        }
        return super.getItemViewType(i);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        int itemViewType = getItemViewType(i);
        if (itemViewType == 0) {
            return c(i, view);
        }
        if (itemViewType != 1) {
            return null;
        }
        return b(i, view);
    }

    private View b(int i, View view) {
        TbImageView tbImageView;
        if (view instanceof TbImageView) {
            tbImageView = (TbImageView) view;
        } else {
            tbImageView = new TbImageView(this.context);
        }
        com.baidu.tieba.pb.d.a.e item = getItem(i);
        if (item instanceof com.baidu.tieba.pb.d.a.f) {
            com.baidu.tieba.pb.d.a.f fVar = (com.baidu.tieba.pb.d.a.f) item;
            ViewGroup.LayoutParams layoutParams = tbImageView.getLayoutParams();
            int i2 = this.maxWidth;
            int hJ = fVar.hJ(i2);
            if (layoutParams == null) {
                layoutParams = new AbsListView.LayoutParams(i2, hJ);
            } else {
                layoutParams.height = hJ;
                layoutParams.width = i2;
            }
            tbImageView.setLayoutParams(layoutParams);
            tbImageView.c(fVar.getSrc(), 17, false);
        }
        return tbImageView;
    }

    private View c(int i, View view) {
        TextView textView;
        if (view instanceof TextView) {
            textView = (TextView) view;
        } else {
            textView = new TextView(this.context);
            textView.setTextSize(0, this.context.getResources().getDimensionPixelSize(o.fontsize32));
            textView.setLineSpacing(0.0f, 1.2f);
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
        ay.b(textView, com.baidu.tieba.n.cp_cont_b, 1);
        com.baidu.tieba.pb.d.a.e item = getItem(i);
        if (item instanceof com.baidu.tieba.pb.d.a.h) {
            textView.setText(((com.baidu.tieba.pb.d.a.h) item).adM());
        }
        return textView;
    }
}
