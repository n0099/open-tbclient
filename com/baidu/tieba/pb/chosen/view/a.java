package com.baidu.tieba.pb.chosen.view;

import android.content.Context;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.b.a.g;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    private Context context;
    private List<com.baidu.tieba.pb.b.a.d> list = new ArrayList();
    private int maxWidth;
    private int padding;

    /* renamed from: com.baidu.tieba.pb.chosen.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0190a {
        TbImageView etV;
    }

    public a(Context context) {
        this.maxWidth = 0;
        this.padding = 0;
        this.context = context;
        this.maxWidth = l.af(context) - (((int) context.getResources().getDimension(d.e.ds30)) * 2);
        this.padding = context.getResources().getDimensionPixelSize(d.e.ds32);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.list == null) {
            return 0;
        }
        return this.list.size();
    }

    public void cL(List<com.baidu.tieba.pb.b.a.d> list) {
        this.list.clear();
        if (list != null && list.size() > 0) {
            this.list.addAll(list);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: pT */
    public com.baidu.tieba.pb.b.a.d getItem(int i) {
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
        com.baidu.tieba.pb.b.a.d dVar = this.list.get(i);
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
    public View getView(int i, View view2, ViewGroup viewGroup) {
        int itemViewType = getItemViewType(i);
        if (itemViewType == 0) {
            return g(i, view2);
        }
        if (itemViewType != 1) {
            return null;
        }
        return f(i, view2);
    }

    private View f(int i, View view2) {
        C0190a c0190a;
        if (view2 == null || !(view2.getTag() instanceof C0190a)) {
            view2 = LayoutInflater.from(this.context).inflate(d.i.chosen_pb_image_item, (ViewGroup) null);
            c0190a = new C0190a();
            c0190a.etV = (TbImageView) view2.findViewById(d.g.pb_chosen_list_image);
            view2.setTag(c0190a);
        } else {
            c0190a = (C0190a) view2.getTag();
        }
        com.baidu.tieba.pb.b.a.d item = getItem(i);
        if (item instanceof com.baidu.tieba.pb.b.a.e) {
            com.baidu.tieba.pb.b.a.e eVar = (com.baidu.tieba.pb.b.a.e) item;
            if (StringUtils.isNull(eVar.fvz) || "1".equals(eVar.fvz)) {
                c0190a.etV.setVisibility(8);
            } else {
                c0190a.etV.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = c0190a.etV.getLayoutParams();
                int i2 = this.maxWidth;
                int qL = eVar.qL(i2);
                if (layoutParams == null) {
                    layoutParams = new AbsListView.LayoutParams(i2, qL);
                } else {
                    layoutParams.height = qL;
                    layoutParams.width = i2;
                }
                c0190a.etV.setLayoutParams(layoutParams);
                c0190a.etV.startLoad(eVar.getSrc(), 17, false);
            }
        }
        return view2;
    }

    private View g(int i, View view2) {
        TextView textView;
        if (view2 instanceof TextView) {
            textView = (TextView) view2;
        } else {
            textView = new TextView(this.context);
            textView.setTextSize(0, this.context.getResources().getDimensionPixelSize(d.e.fontsize32));
            textView.setLineSpacing(0.0f, 1.2f);
            textView.setMovementMethod(LinkMovementMethod.getInstance());
            textView.setPadding(this.padding, 0, this.padding, 0);
        }
        com.baidu.tieba.pb.b.a.d item = getItem(i);
        if (item instanceof g) {
            g gVar = (g) item;
            textView.setText(gVar.bcg());
            switch (gVar.bci()) {
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
            if (!StringUtils.isNull(gVar.bcj())) {
                if (!ak.a(textView, gVar.bcj())) {
                    ak.c(textView, d.C0126d.cp_cont_b, 1);
                }
            } else {
                ak.c(textView, d.C0126d.cp_cont_b, 1);
            }
            if (gVar.getTextSize() > 0) {
                textView.setTextSize(0, gVar.getTextSize());
            }
        }
        return textView;
    }
}
