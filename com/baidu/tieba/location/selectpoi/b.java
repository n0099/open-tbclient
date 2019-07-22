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
/* loaded from: classes5.dex */
public class b extends BaseAdapter {
    private ArrayList<Object> data;
    private SelectLocationActivity hkp;
    private boolean isShowLocation;

    public b(SelectLocationActivity selectLocationActivity) {
        this.isShowLocation = true;
        this.hkp = selectLocationActivity;
        com.baidu.tieba.tbadkCore.location.a locationData = c.cpV().getLocationData();
        this.isShowLocation = c.cpV().cpW() ? false : true;
        if (locationData != null) {
            this.data = j(locationData.cpU(), locationData.cpT());
        }
    }

    private ArrayList<Object> j(List<a.C0409a> list, String str) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        ArrayList<Object> arrayList = new ArrayList<>();
        a.C0409a c0409a = null;
        for (a.C0409a c0409a2 : list) {
            if (c0409a2 != null && !TextUtils.isEmpty(c0409a2.getName())) {
                if (TextUtils.equals(c0409a2.getName(), str)) {
                    c0409a = c0409a2;
                } else {
                    arrayList.add(c0409a2);
                }
            }
        }
        if (c0409a != null) {
            arrayList.add(0, c0409a);
        } else {
            a.C0409a c0409a3 = new a.C0409a();
            c0409a3.setName(str);
            arrayList.add(0, c0409a3);
        }
        if (this.hkp != null) {
            arrayList.add(0, this.hkp.getPageContext().getString(R.string.select_position_no_location));
        }
        return arrayList;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        Object item = getItem(i);
        if (item instanceof String) {
            return 0;
        }
        if (item instanceof a.C0409a) {
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
    /* loaded from: classes5.dex */
    public static class C0353b {
        View enc;
        ImageView hkq;
        TextView title;

        private C0353b() {
        }
    }

    private View c(View view, int i, boolean z) {
        C0353b c0353b;
        View view2;
        Object item = getItem(i);
        if (item instanceof String) {
            String str = (String) item;
            if (view == null || !(view.getTag() instanceof C0353b)) {
                View inflate = LayoutInflater.from(this.hkp.getPageContext().getPageActivity()).inflate(R.layout.select_location_nolocation_item, (ViewGroup) null);
                c0353b = new C0353b();
                c0353b.title = (TextView) inflate.findViewById(R.id.select_location_title);
                c0353b.hkq = (ImageView) inflate.findViewById(R.id.select_location_tick);
                c0353b.enc = inflate.findViewById(R.id.select_location_line);
                inflate.setTag(c0353b);
                view2 = inflate;
            } else {
                c0353b = (C0353b) view.getTag();
                view2 = view;
            }
            if (i == 0 && !this.isShowLocation) {
                c0353b.hkq.setVisibility(0);
                am.c(c0353b.hkq, (int) R.drawable.icon_site_ok);
            } else {
                c0353b.hkq.setVisibility(4);
            }
            c0353b.title.setText(str);
            am.l(c0353b.enc, R.color.cp_bg_line_b);
            am.f(c0353b.title, R.color.cp_link_tip_a, 1);
            am.k(view2, R.drawable.home_recommend_item_bg);
            return view2;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class a {
        TextView bmT;
        TextView hki;
        ImageView hkq;

        private a() {
        }
    }

    private View d(View view, int i, boolean z) {
        a aVar;
        Object item = getItem(i);
        if (item instanceof a.C0409a) {
            a.C0409a c0409a = (a.C0409a) item;
            if (view == null || !(view.getTag() instanceof C0353b)) {
                view = LayoutInflater.from(this.hkp.getPageContext().getPageActivity()).inflate(R.layout.select_location_address_item, (ViewGroup) null);
                a aVar2 = new a();
                aVar2.bmT = (TextView) view.findViewById(R.id.select_location_name);
                aVar2.hki = (TextView) view.findViewById(R.id.select_location_address);
                aVar2.hkq = (ImageView) view.findViewById(R.id.select_location_tick);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            aVar.hki.setText(c0409a.getAddr());
            if (this.isShowLocation && i == 1) {
                aVar.hkq.setVisibility(0);
                if (TextUtils.isEmpty(c0409a.getAddr())) {
                    aVar.hki.setText(R.string.select_location_current);
                }
            } else {
                aVar.hkq.setVisibility(4);
            }
            aVar.bmT.setText(c0409a.getName());
            this.hkp.getLayoutMode().setNightMode(z);
            this.hkp.getLayoutMode().onModeChanged(view);
            am.k(view, R.drawable.home_recommend_item_bg);
            return view;
        }
        return null;
    }
}
