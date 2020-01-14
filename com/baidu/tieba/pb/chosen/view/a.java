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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.b.a.g;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class a extends BaseAdapter {
    private Context context;
    private List<com.baidu.tieba.pb.b.a.d> list = new ArrayList();
    private int maxWidth;
    private int padding;

    /* renamed from: com.baidu.tieba.pb.chosen.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0565a {
        TbImageView Ei;
    }

    public a(Context context) {
        this.maxWidth = 0;
        this.padding = 0;
        this.context = context;
        this.maxWidth = l.getEquipmentWidth(context) - (((int) context.getResources().getDimension(R.dimen.ds30)) * 2);
        this.padding = context.getResources().getDimensionPixelSize(R.dimen.ds32);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.list == null) {
            return 0;
        }
        return this.list.size();
    }

    public void dI(List<com.baidu.tieba.pb.b.a.d> list) {
        this.list.clear();
        if (list != null && list.size() > 0) {
            this.list.addAll(list);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: yr */
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
    public View getView(int i, View view, ViewGroup viewGroup) {
        int itemViewType = getItemViewType(i);
        if (itemViewType == 0) {
            return i(i, view);
        }
        if (itemViewType != 1) {
            return null;
        }
        return h(i, view);
    }

    private View h(int i, View view) {
        C0565a c0565a;
        if (view == null || !(view.getTag() instanceof C0565a)) {
            view = LayoutInflater.from(this.context).inflate(R.layout.chosen_pb_image_item, (ViewGroup) null);
            c0565a = new C0565a();
            c0565a.Ei = (TbImageView) view.findViewById(R.id.pb_chosen_list_image);
            view.setTag(c0565a);
        } else {
            c0565a = (C0565a) view.getTag();
        }
        com.baidu.tieba.pb.b.a.d item = getItem(i);
        if (item instanceof com.baidu.tieba.pb.b.a.e) {
            com.baidu.tieba.pb.b.a.e eVar = (com.baidu.tieba.pb.b.a.e) item;
            if (StringUtils.isNull(eVar.iVv) || "1".equals(eVar.iVv)) {
                c0565a.Ei.setVisibility(8);
            } else {
                c0565a.Ei.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = c0565a.Ei.getLayoutParams();
                int i2 = this.maxWidth;
                int zl = eVar.zl(i2);
                if (layoutParams == null) {
                    layoutParams = new AbsListView.LayoutParams(i2, zl);
                } else {
                    layoutParams.height = zl;
                    layoutParams.width = i2;
                }
                c0565a.Ei.setLayoutParams(layoutParams);
                c0565a.Ei.startLoad(eVar.getSrc(), 17, false);
            }
        }
        return view;
    }

    private View i(int i, View view) {
        TextView textView;
        if (view instanceof TextView) {
            textView = (TextView) view;
        } else {
            textView = new TextView(this.context);
            textView.setTextSize(0, this.context.getResources().getDimensionPixelSize(R.dimen.fontsize32));
            textView.setLineSpacing(0.0f, 1.2f);
            textView.setMovementMethod(LinkMovementMethod.getInstance());
            textView.setPadding(this.padding, 0, this.padding, 0);
        }
        com.baidu.tieba.pb.b.a.d item = getItem(i);
        if (item instanceof g) {
            g gVar = (g) item;
            textView.setText(gVar.cqO());
            switch (gVar.cqQ()) {
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
            if (!StringUtils.isNull(gVar.cqR())) {
                if (!am.setViewTextColor(textView, gVar.cqR())) {
                    am.setViewTextColor(textView, R.color.cp_cont_b, 1);
                }
            } else {
                am.setViewTextColor(textView, R.color.cp_cont_b, 1);
            }
            if (gVar.getTextSize() > 0) {
                textView.setTextSize(0, gVar.getTextSize());
            }
        }
        return textView;
    }
}
