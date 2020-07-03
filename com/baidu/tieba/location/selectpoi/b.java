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
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.location.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class b extends BaseAdapter {
    private TbPageContext<SelectLocationActivity> dPv;
    private ArrayList<Object> data;
    private boolean isShowLocation;

    public b(TbPageContext<SelectLocationActivity> tbPageContext) {
        this.dPv = tbPageContext;
        com.baidu.tieba.tbadkCore.location.a locationData = com.baidu.tieba.tbadkCore.location.c.diD().getLocationData();
        this.isShowLocation = !com.baidu.tieba.tbadkCore.location.c.diD().diE();
        if (locationData != null) {
            this.data = h(locationData.diC(), locationData.diB());
        }
    }

    private ArrayList<Object> h(List<a.C0746a> list, String str) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        ArrayList<Object> arrayList = new ArrayList<>();
        a.C0746a c0746a = null;
        for (a.C0746a c0746a2 : list) {
            if (c0746a2 != null && !TextUtils.isEmpty(c0746a2.getName())) {
                if (TextUtils.equals(c0746a2.getName(), str)) {
                    c0746a = c0746a2;
                } else {
                    arrayList.add(c0746a2);
                }
            }
        }
        if (c0746a != null) {
            arrayList.add(0, c0746a);
        } else {
            a.C0746a c0746a3 = new a.C0746a();
            c0746a3.setName(str);
            arrayList.add(0, c0746a3);
        }
        if (this.dPv != null) {
            arrayList.add(0, this.dPv.getString(R.string.select_position_no_location));
        }
        return arrayList;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        Object item = getItem(i);
        if (item instanceof String) {
            return 0;
        }
        if (item instanceof a.C0746a) {
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
    /* loaded from: classes10.dex */
    public static class C0679b {
        View gCZ;
        ImageView jxv;
        TextView title;

        private C0679b() {
        }
    }

    private View c(View view, int i, boolean z) {
        C0679b c0679b;
        View view2;
        Object item = getItem(i);
        if (item instanceof String) {
            String str = (String) item;
            if (view == null || !(view.getTag() instanceof C0679b)) {
                View inflate = LayoutInflater.from(this.dPv.getPageActivity()).inflate(R.layout.select_location_nolocation_item, (ViewGroup) null);
                c0679b = new C0679b();
                c0679b.title = (TextView) inflate.findViewById(R.id.select_location_title);
                c0679b.jxv = (ImageView) inflate.findViewById(R.id.select_location_tick);
                c0679b.gCZ = inflate.findViewById(R.id.select_location_line);
                inflate.setTag(c0679b);
                view2 = inflate;
            } else {
                c0679b = (C0679b) view.getTag();
                view2 = view;
            }
            if (i == 0 && !this.isShowLocation) {
                c0679b.jxv.setVisibility(0);
                an.setImageResource(c0679b.jxv, R.drawable.icon_site_ok);
            } else {
                c0679b.jxv.setVisibility(4);
            }
            c0679b.title.setText(str);
            an.setBackgroundColor(c0679b.gCZ, R.color.cp_bg_line_c);
            an.setViewTextColor(c0679b.title, R.color.cp_link_tip_a, 1);
            an.setBackgroundResource(view2, R.drawable.home_recommend_item_bg);
            return view2;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class a {
        TextView djl;
        TextView jxr;
        ImageView jxv;

        private a() {
        }
    }

    private View d(View view, int i, boolean z) {
        a aVar;
        Object item = getItem(i);
        if (item instanceof a.C0746a) {
            a.C0746a c0746a = (a.C0746a) item;
            if (view == null || !(view.getTag() instanceof C0679b)) {
                view = LayoutInflater.from(this.dPv.getPageActivity()).inflate(R.layout.select_location_address_item, (ViewGroup) null);
                a aVar2 = new a();
                aVar2.djl = (TextView) view.findViewById(R.id.select_location_name);
                aVar2.jxr = (TextView) view.findViewById(R.id.select_location_address);
                aVar2.jxv = (ImageView) view.findViewById(R.id.select_location_tick);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            aVar.jxr.setText(c0746a.getAddr());
            if (this.isShowLocation && i == 1) {
                aVar.jxv.setVisibility(0);
                if (TextUtils.isEmpty(c0746a.getAddr())) {
                    aVar.jxr.setText(R.string.select_location_current);
                }
            } else {
                aVar.jxv.setVisibility(4);
            }
            aVar.djl.setText(c0746a.getName());
            this.dPv.getLayoutMode().setNightMode(z);
            this.dPv.getLayoutMode().onModeChanged(view);
            an.setBackgroundResource(view, R.drawable.home_recommend_item_bg);
            return view;
        }
        return null;
    }
}
