package com.baidu.tieba.pb.chosen.a;

import android.content.Context;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a extends BaseAdapter {
    private Context context;
    private List<com.baidu.tieba.pb.c.a.d> list = new ArrayList();
    private int maxWidth;
    private int padding;

    /* renamed from: com.baidu.tieba.pb.chosen.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0079a {
        TbImageView aEB;
    }

    public a(Context context) {
        this.maxWidth = 0;
        this.padding = 0;
        this.context = context;
        this.maxWidth = com.baidu.adp.lib.util.k.K(context) - (((int) context.getResources().getDimension(n.d.ds30)) * 2);
        this.padding = context.getResources().getDimensionPixelSize(n.d.ds32);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.list == null) {
            return 0;
        }
        return this.list.size();
    }

    public void bo(List<com.baidu.tieba.pb.c.a.d> list) {
        this.list.clear();
        if (list != null && list.size() > 0) {
            this.list.addAll(list);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: jL */
    public com.baidu.tieba.pb.c.a.d getItem(int i) {
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
        com.baidu.tieba.pb.c.a.d dVar = this.list.get(i);
        if (dVar == null) {
            return super.getItemViewType(i);
        }
        if (dVar.getType() == 0) {
            return 0;
        }
        if (dVar.getType() == 3) {
            return 1;
        }
        return super.getItemViewType(i);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        int itemViewType = getItemViewType(i);
        if (itemViewType == 0) {
            return e(i, view);
        }
        if (itemViewType != 1) {
            return null;
        }
        return d(i, view);
    }

    private View d(int i, View view) {
        C0079a c0079a;
        if (view == null || !(view.getTag() instanceof C0079a)) {
            view = LayoutInflater.from(this.context).inflate(n.g.chosen_pb_image_item, (ViewGroup) null);
            c0079a = new C0079a();
            c0079a.aEB = (TbImageView) view.findViewById(n.f.pb_chosen_list_image);
            view.setTag(c0079a);
        } else {
            c0079a = (C0079a) view.getTag();
        }
        com.baidu.tieba.pb.c.a.d item = getItem(i);
        if (item instanceof com.baidu.tieba.pb.c.a.e) {
            com.baidu.tieba.pb.c.a.e eVar = (com.baidu.tieba.pb.c.a.e) item;
            ViewGroup.LayoutParams layoutParams = c0079a.aEB.getLayoutParams();
            int i2 = this.maxWidth;
            int kh = eVar.kh(i2);
            if (layoutParams == null) {
                layoutParams = new AbsListView.LayoutParams(i2, kh);
            } else {
                layoutParams.height = kh;
                layoutParams.width = i2;
            }
            c0079a.aEB.setLayoutParams(layoutParams);
            c0079a.aEB.d(eVar.getSrc(), 17, false);
        }
        return view;
    }

    private View e(int i, View view) {
        TextView textView;
        if (view instanceof TextView) {
            textView = (TextView) view;
        } else {
            textView = new TextView(this.context);
            textView.setTextSize(0, this.context.getResources().getDimensionPixelSize(n.d.fontsize32));
            textView.setLineSpacing(0.0f, 1.2f);
            textView.setMovementMethod(LinkMovementMethod.getInstance());
            textView.setPadding(this.padding, 0, this.padding, 0);
        }
        com.baidu.tieba.pb.c.a.d item = getItem(i);
        if (item instanceof com.baidu.tieba.pb.c.a.g) {
            com.baidu.tieba.pb.c.a.g gVar = (com.baidu.tieba.pb.c.a.g) item;
            textView.setText(gVar.amV());
            switch (gVar.amX()) {
                case 1:
                    textView.setGravity(17);
                    break;
                case 2:
                    textView.setGravity(5);
                    break;
                default:
                    textView.setGravity(3);
                    break;
            }
            if (!StringUtils.isNull(gVar.amY())) {
                if (!as.a(textView, gVar.amY())) {
                    as.b(textView, n.c.cp_cont_b, 1);
                }
            } else {
                as.b(textView, n.c.cp_cont_b, 1);
            }
            if (gVar.getTextSize() > 0) {
                textView.setTextSize(0, gVar.getTextSize());
            }
        }
        return textView;
    }
}
