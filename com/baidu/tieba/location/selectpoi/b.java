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
    private SelectLocationActivity igr;
    private boolean isShowLocation;

    public b(SelectLocationActivity selectLocationActivity) {
        this.isShowLocation = true;
        this.igr = selectLocationActivity;
        com.baidu.tieba.tbadkCore.location.a locationData = c.cMb().getLocationData();
        this.isShowLocation = c.cMb().cMc() ? false : true;
        if (locationData != null) {
            this.data = i(locationData.cMa(), locationData.cLZ());
        }
    }

    private ArrayList<Object> i(List<a.C0614a> list, String str) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        ArrayList<Object> arrayList = new ArrayList<>();
        a.C0614a c0614a = null;
        for (a.C0614a c0614a2 : list) {
            if (c0614a2 != null && !TextUtils.isEmpty(c0614a2.getName())) {
                if (TextUtils.equals(c0614a2.getName(), str)) {
                    c0614a = c0614a2;
                } else {
                    arrayList.add(c0614a2);
                }
            }
        }
        if (c0614a != null) {
            arrayList.add(0, c0614a);
        } else {
            a.C0614a c0614a3 = new a.C0614a();
            c0614a3.setName(str);
            arrayList.add(0, c0614a3);
        }
        if (this.igr != null) {
            arrayList.add(0, this.igr.getPageContext().getString(R.string.select_position_no_location));
        }
        return arrayList;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        Object item = getItem(i);
        if (item instanceof String) {
            return 0;
        }
        if (item instanceof a.C0614a) {
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
    public static class C0557b {
        View fwA;
        ImageView igs;
        TextView title;

        private C0557b() {
        }
    }

    private View c(View view, int i, boolean z) {
        C0557b c0557b;
        View view2;
        Object item = getItem(i);
        if (item instanceof String) {
            String str = (String) item;
            if (view == null || !(view.getTag() instanceof C0557b)) {
                View inflate = LayoutInflater.from(this.igr.getPageContext().getPageActivity()).inflate(R.layout.select_location_nolocation_item, (ViewGroup) null);
                c0557b = new C0557b();
                c0557b.title = (TextView) inflate.findViewById(R.id.select_location_title);
                c0557b.igs = (ImageView) inflate.findViewById(R.id.select_location_tick);
                c0557b.fwA = inflate.findViewById(R.id.select_location_line);
                inflate.setTag(c0557b);
                view2 = inflate;
            } else {
                c0557b = (C0557b) view.getTag();
                view2 = view;
            }
            if (i == 0 && !this.isShowLocation) {
                c0557b.igs.setVisibility(0);
                am.setImageResource(c0557b.igs, R.drawable.icon_site_ok);
            } else {
                c0557b.igs.setVisibility(4);
            }
            c0557b.title.setText(str);
            am.setBackgroundColor(c0557b.fwA, R.color.cp_bg_line_c);
            am.setViewTextColor(c0557b.title, R.color.cp_link_tip_a, 1);
            am.setBackgroundResource(view2, R.drawable.home_recommend_item_bg);
            return view2;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class a {
        TextView cuv;
        TextView igk;
        ImageView igs;

        private a() {
        }
    }

    private View d(View view, int i, boolean z) {
        a aVar;
        Object item = getItem(i);
        if (item instanceof a.C0614a) {
            a.C0614a c0614a = (a.C0614a) item;
            if (view == null || !(view.getTag() instanceof C0557b)) {
                view = LayoutInflater.from(this.igr.getPageContext().getPageActivity()).inflate(R.layout.select_location_address_item, (ViewGroup) null);
                a aVar2 = new a();
                aVar2.cuv = (TextView) view.findViewById(R.id.select_location_name);
                aVar2.igk = (TextView) view.findViewById(R.id.select_location_address);
                aVar2.igs = (ImageView) view.findViewById(R.id.select_location_tick);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            aVar.igk.setText(c0614a.getAddr());
            if (this.isShowLocation && i == 1) {
                aVar.igs.setVisibility(0);
                if (TextUtils.isEmpty(c0614a.getAddr())) {
                    aVar.igk.setText(R.string.select_location_current);
                }
            } else {
                aVar.igs.setVisibility(4);
            }
            aVar.cuv.setText(c0614a.getName());
            this.igr.getLayoutMode().setNightMode(z);
            this.igr.getLayoutMode().onModeChanged(view);
            am.setBackgroundResource(view, R.drawable.home_recommend_item_bg);
            return view;
        }
        return null;
    }
}
