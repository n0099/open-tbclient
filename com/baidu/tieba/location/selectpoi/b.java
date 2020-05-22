package com.baidu.tieba.location.selectpoi;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.location.a;
import com.baidu.tieba.tbadkCore.location.c;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class b extends BaseAdapter {
    private ArrayList<Object> data;
    private boolean isShowLocation;
    private SelectLocationActivity jfz;

    public b(SelectLocationActivity selectLocationActivity) {
        this.isShowLocation = true;
        this.jfz = selectLocationActivity;
        com.baidu.tieba.tbadkCore.location.a locationData = c.dec().getLocationData();
        this.isShowLocation = c.dec().ded() ? false : true;
        if (locationData != null) {
            this.data = i(locationData.deb(), locationData.dea());
        }
    }

    private ArrayList<Object> i(List<a.C0729a> list, String str) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        ArrayList<Object> arrayList = new ArrayList<>();
        a.C0729a c0729a = null;
        for (a.C0729a c0729a2 : list) {
            if (c0729a2 != null && !TextUtils.isEmpty(c0729a2.getName())) {
                if (TextUtils.equals(c0729a2.getName(), str)) {
                    c0729a = c0729a2;
                } else {
                    arrayList.add(c0729a2);
                }
            }
        }
        if (c0729a != null) {
            arrayList.add(0, c0729a);
        } else {
            a.C0729a c0729a3 = new a.C0729a();
            c0729a3.setName(str);
            arrayList.add(0, c0729a3);
        }
        if (this.jfz != null) {
            arrayList.add(0, this.jfz.getPageContext().getString(R.string.select_position_no_location));
        }
        return arrayList;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        Object item = getItem(i);
        if (item instanceof String) {
            return 0;
        }
        if (item instanceof a.C0729a) {
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
    public static class C0666b {
        View gpZ;
        ImageView jfA;
        TextView title;

        private C0666b() {
        }
    }

    private View c(View view, int i, boolean z) {
        C0666b c0666b;
        View view2;
        Object item = getItem(i);
        if (item instanceof String) {
            String str = (String) item;
            if (view == null || !(view.getTag() instanceof C0666b)) {
                View inflate = LayoutInflater.from(this.jfz.getPageContext().getPageActivity()).inflate(R.layout.select_location_nolocation_item, (ViewGroup) null);
                c0666b = new C0666b();
                c0666b.title = (TextView) inflate.findViewById(R.id.select_location_title);
                c0666b.jfA = (ImageView) inflate.findViewById(R.id.select_location_tick);
                c0666b.gpZ = inflate.findViewById(R.id.select_location_line);
                inflate.setTag(c0666b);
                view2 = inflate;
            } else {
                c0666b = (C0666b) view.getTag();
                view2 = view;
            }
            if (i == 0 && !this.isShowLocation) {
                c0666b.jfA.setVisibility(0);
                am.setImageResource(c0666b.jfA, R.drawable.icon_site_ok);
            } else {
                c0666b.jfA.setVisibility(4);
            }
            c0666b.title.setText(str);
            am.setBackgroundColor(c0666b.gpZ, R.color.cp_bg_line_c);
            am.setViewTextColor(c0666b.title, R.color.cp_link_tip_a, 1);
            am.setBackgroundResource(view2, R.drawable.home_recommend_item_bg);
            return view2;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class a {
        TextView dez;
        ImageView jfA;
        TextView jfs;

        private a() {
        }
    }

    private View d(View view, int i, boolean z) {
        a aVar;
        Object item = getItem(i);
        if (item instanceof a.C0729a) {
            a.C0729a c0729a = (a.C0729a) item;
            if (view == null || !(view.getTag() instanceof C0666b)) {
                view = LayoutInflater.from(this.jfz.getPageContext().getPageActivity()).inflate(R.layout.select_location_address_item, (ViewGroup) null);
                a aVar2 = new a();
                aVar2.dez = (TextView) view.findViewById(R.id.select_location_name);
                aVar2.jfs = (TextView) view.findViewById(R.id.select_location_address);
                aVar2.jfA = (ImageView) view.findViewById(R.id.select_location_tick);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            aVar.jfs.setText(c0729a.getAddr());
            if (this.isShowLocation && i == 1) {
                aVar.jfA.setVisibility(0);
                if (TextUtils.isEmpty(c0729a.getAddr())) {
                    aVar.jfs.setText(R.string.select_location_current);
                }
            } else {
                aVar.jfA.setVisibility(4);
            }
            aVar.dez.setText(c0729a.getName());
            this.jfz.getLayoutMode().setNightMode(z);
            this.jfz.getLayoutMode().onModeChanged(view);
            am.setBackgroundResource(view, R.drawable.home_recommend_item_bg);
            return view;
        }
        return null;
    }
}
