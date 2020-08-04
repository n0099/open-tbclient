package com.baidu.tieba.location.selectpoi;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.location.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes17.dex */
public class b extends BaseAdapter {
    private TbPageContext<SelectLocationActivity> dVN;
    private ArrayList<Object> data;
    private boolean isShowLocation;

    public b(TbPageContext<SelectLocationActivity> tbPageContext) {
        this.dVN = tbPageContext;
        com.baidu.tieba.tbadkCore.location.a locationData = com.baidu.tieba.tbadkCore.location.c.dlN().getLocationData();
        this.isShowLocation = !com.baidu.tieba.tbadkCore.location.c.dlN().dlO();
        if (locationData != null) {
            this.data = i(locationData.dlM(), locationData.dlL());
        }
    }

    private ArrayList<Object> i(List<a.C0756a> list, String str) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        ArrayList<Object> arrayList = new ArrayList<>();
        a.C0756a c0756a = null;
        for (a.C0756a c0756a2 : list) {
            if (c0756a2 != null && !TextUtils.isEmpty(c0756a2.getName())) {
                if (TextUtils.equals(c0756a2.getName(), str)) {
                    c0756a = c0756a2;
                } else {
                    arrayList.add(c0756a2);
                }
            }
        }
        if (c0756a != null) {
            arrayList.add(0, c0756a);
        } else {
            a.C0756a c0756a3 = new a.C0756a();
            c0756a3.setName(str);
            arrayList.add(0, c0756a3);
        }
        if (this.dVN != null) {
            arrayList.add(0, this.dVN.getString(R.string.select_position_no_location));
        }
        return arrayList;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        Object item = getItem(i);
        if (item instanceof String) {
            return 0;
        }
        if (item instanceof a.C0756a) {
            return 1;
        }
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.data == null) {
            return 0;
        }
        return this.data.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.data == null || i < 0 || i >= this.data.size()) {
            return null;
        }
        return this.data.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        int itemViewType = getItemViewType(i);
        boolean z = TbadkCoreApplication.getInst().getSkinType() == 1;
        switch (itemViewType) {
            case 0:
                return c(view, i, z);
            case 1:
                return d(view, i, z);
            default:
                return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.location.selectpoi.b$b  reason: collision with other inner class name */
    /* loaded from: classes17.dex */
    public static class C0690b {
        View gIw;
        ImageView jGb;
        TextView title;

        private C0690b() {
        }
    }

    private View c(View view, int i, boolean z) {
        C0690b c0690b;
        View view2;
        Object item = getItem(i);
        if (item instanceof String) {
            String str = (String) item;
            if (view == null || !(view.getTag() instanceof C0690b)) {
                View inflate = LayoutInflater.from(this.dVN.getPageActivity()).inflate(R.layout.select_location_nolocation_item, (ViewGroup) null);
                c0690b = new C0690b();
                c0690b.title = (TextView) inflate.findViewById(R.id.select_location_title);
                c0690b.jGb = (ImageView) inflate.findViewById(R.id.select_location_tick);
                c0690b.gIw = inflate.findViewById(R.id.select_location_line);
                inflate.setTag(c0690b);
                view2 = inflate;
            } else {
                c0690b = (C0690b) view.getTag();
                view2 = view;
            }
            if (i == 0 && !this.isShowLocation) {
                c0690b.jGb.setVisibility(0);
                ao.setImageResource(c0690b.jGb, R.drawable.icon_site_ok);
            } else {
                c0690b.jGb.setVisibility(4);
            }
            c0690b.title.setText(str);
            ao.setBackgroundColor(c0690b.gIw, R.color.cp_bg_line_c);
            ao.setViewTextColor(c0690b.title, R.color.cp_link_tip_a, 1);
            ao.setBackgroundResource(view2, R.drawable.home_recommend_item_bg);
            return view2;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes17.dex */
    public static class a {
        TextView dpg;
        TextView jFX;
        ImageView jGb;

        private a() {
        }
    }

    private View d(View view, int i, boolean z) {
        a aVar;
        Object item = getItem(i);
        if (item instanceof a.C0756a) {
            a.C0756a c0756a = (a.C0756a) item;
            if (view == null || !(view.getTag() instanceof C0690b)) {
                view = LayoutInflater.from(this.dVN.getPageActivity()).inflate(R.layout.select_location_address_item, (ViewGroup) null);
                a aVar2 = new a();
                aVar2.dpg = (TextView) view.findViewById(R.id.select_location_name);
                aVar2.jFX = (TextView) view.findViewById(R.id.select_location_address);
                aVar2.jGb = (ImageView) view.findViewById(R.id.select_location_tick);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            aVar.jFX.setText(c0756a.getAddr());
            if (this.isShowLocation && i == 1) {
                aVar.jGb.setVisibility(0);
                if (TextUtils.isEmpty(c0756a.getAddr())) {
                    aVar.jFX.setText(R.string.select_location_current);
                }
            } else {
                aVar.jGb.setVisibility(4);
            }
            aVar.dpg.setText(c0756a.getName());
            this.dVN.getLayoutMode().setNightMode(z);
            this.dVN.getLayoutMode().onModeChanged(view);
            ao.setBackgroundResource(view, R.drawable.home_recommend_item_bg);
            return view;
        }
        return null;
    }
}
