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
/* loaded from: classes8.dex */
public class b extends BaseAdapter {
    private ArrayList<Object> data;
    private SelectLocationActivity icC;
    private boolean isShowLocation;

    public b(SelectLocationActivity selectLocationActivity) {
        this.isShowLocation = true;
        this.icC = selectLocationActivity;
        com.baidu.tieba.tbadkCore.location.a locationData = c.cKg().getLocationData();
        this.isShowLocation = c.cKg().cKh() ? false : true;
        if (locationData != null) {
            this.data = i(locationData.cKf(), locationData.cKe());
        }
    }

    private ArrayList<Object> i(List<a.C0605a> list, String str) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        ArrayList<Object> arrayList = new ArrayList<>();
        a.C0605a c0605a = null;
        for (a.C0605a c0605a2 : list) {
            if (c0605a2 != null && !TextUtils.isEmpty(c0605a2.getName())) {
                if (TextUtils.equals(c0605a2.getName(), str)) {
                    c0605a = c0605a2;
                } else {
                    arrayList.add(c0605a2);
                }
            }
        }
        if (c0605a != null) {
            arrayList.add(0, c0605a);
        } else {
            a.C0605a c0605a3 = new a.C0605a();
            c0605a3.setName(str);
            arrayList.add(0, c0605a3);
        }
        if (this.icC != null) {
            arrayList.add(0, this.icC.getPageContext().getString(R.string.select_position_no_location));
        }
        return arrayList;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        Object item = getItem(i);
        if (item instanceof String) {
            return 0;
        }
        if (item instanceof a.C0605a) {
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
    /* loaded from: classes8.dex */
    public static class C0550b {
        View fte;
        ImageView icD;
        TextView title;

        private C0550b() {
        }
    }

    private View c(View view, int i, boolean z) {
        C0550b c0550b;
        View view2;
        Object item = getItem(i);
        if (item instanceof String) {
            String str = (String) item;
            if (view == null || !(view.getTag() instanceof C0550b)) {
                View inflate = LayoutInflater.from(this.icC.getPageContext().getPageActivity()).inflate(R.layout.select_location_nolocation_item, (ViewGroup) null);
                c0550b = new C0550b();
                c0550b.title = (TextView) inflate.findViewById(R.id.select_location_title);
                c0550b.icD = (ImageView) inflate.findViewById(R.id.select_location_tick);
                c0550b.fte = inflate.findViewById(R.id.select_location_line);
                inflate.setTag(c0550b);
                view2 = inflate;
            } else {
                c0550b = (C0550b) view.getTag();
                view2 = view;
            }
            if (i == 0 && !this.isShowLocation) {
                c0550b.icD.setVisibility(0);
                am.setImageResource(c0550b.icD, R.drawable.icon_site_ok);
            } else {
                c0550b.icD.setVisibility(4);
            }
            c0550b.title.setText(str);
            am.setBackgroundColor(c0550b.fte, R.color.cp_bg_line_c);
            am.setViewTextColor(c0550b.title, R.color.cp_link_tip_a, 1);
            am.setBackgroundResource(view2, R.drawable.home_recommend_item_bg);
            return view2;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public static class a {
        TextView cqf;
        ImageView icD;
        TextView icv;

        private a() {
        }
    }

    private View d(View view, int i, boolean z) {
        a aVar;
        Object item = getItem(i);
        if (item instanceof a.C0605a) {
            a.C0605a c0605a = (a.C0605a) item;
            if (view == null || !(view.getTag() instanceof C0550b)) {
                view = LayoutInflater.from(this.icC.getPageContext().getPageActivity()).inflate(R.layout.select_location_address_item, (ViewGroup) null);
                a aVar2 = new a();
                aVar2.cqf = (TextView) view.findViewById(R.id.select_location_name);
                aVar2.icv = (TextView) view.findViewById(R.id.select_location_address);
                aVar2.icD = (ImageView) view.findViewById(R.id.select_location_tick);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            aVar.icv.setText(c0605a.getAddr());
            if (this.isShowLocation && i == 1) {
                aVar.icD.setVisibility(0);
                if (TextUtils.isEmpty(c0605a.getAddr())) {
                    aVar.icv.setText(R.string.select_location_current);
                }
            } else {
                aVar.icD.setVisibility(4);
            }
            aVar.cqf.setText(c0605a.getName());
            this.icC.getLayoutMode().setNightMode(z);
            this.icC.getLayoutMode().onModeChanged(view);
            am.setBackgroundResource(view, R.drawable.home_recommend_item_bg);
            return view;
        }
        return null;
    }
}
