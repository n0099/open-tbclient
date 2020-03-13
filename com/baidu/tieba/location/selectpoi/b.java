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
    private SelectLocationActivity ieR;
    private boolean isShowLocation;

    public b(SelectLocationActivity selectLocationActivity) {
        this.isShowLocation = true;
        this.ieR = selectLocationActivity;
        com.baidu.tieba.tbadkCore.location.a locationData = c.cLH().getLocationData();
        this.isShowLocation = c.cLH().cLI() ? false : true;
        if (locationData != null) {
            this.data = i(locationData.cLG(), locationData.cLF());
        }
    }

    private ArrayList<Object> i(List<a.C0613a> list, String str) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        ArrayList<Object> arrayList = new ArrayList<>();
        a.C0613a c0613a = null;
        for (a.C0613a c0613a2 : list) {
            if (c0613a2 != null && !TextUtils.isEmpty(c0613a2.getName())) {
                if (TextUtils.equals(c0613a2.getName(), str)) {
                    c0613a = c0613a2;
                } else {
                    arrayList.add(c0613a2);
                }
            }
        }
        if (c0613a != null) {
            arrayList.add(0, c0613a);
        } else {
            a.C0613a c0613a3 = new a.C0613a();
            c0613a3.setName(str);
            arrayList.add(0, c0613a3);
        }
        if (this.ieR != null) {
            arrayList.add(0, this.ieR.getPageContext().getString(R.string.select_position_no_location));
        }
        return arrayList;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        Object item = getItem(i);
        if (item instanceof String) {
            return 0;
        }
        if (item instanceof a.C0613a) {
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
    public static class C0556b {
        View fvU;
        ImageView ieS;
        TextView title;

        private C0556b() {
        }
    }

    private View c(View view, int i, boolean z) {
        C0556b c0556b;
        View view2;
        Object item = getItem(i);
        if (item instanceof String) {
            String str = (String) item;
            if (view == null || !(view.getTag() instanceof C0556b)) {
                View inflate = LayoutInflater.from(this.ieR.getPageContext().getPageActivity()).inflate(R.layout.select_location_nolocation_item, (ViewGroup) null);
                c0556b = new C0556b();
                c0556b.title = (TextView) inflate.findViewById(R.id.select_location_title);
                c0556b.ieS = (ImageView) inflate.findViewById(R.id.select_location_tick);
                c0556b.fvU = inflate.findViewById(R.id.select_location_line);
                inflate.setTag(c0556b);
                view2 = inflate;
            } else {
                c0556b = (C0556b) view.getTag();
                view2 = view;
            }
            if (i == 0 && !this.isShowLocation) {
                c0556b.ieS.setVisibility(0);
                am.setImageResource(c0556b.ieS, R.drawable.icon_site_ok);
            } else {
                c0556b.ieS.setVisibility(4);
            }
            c0556b.title.setText(str);
            am.setBackgroundColor(c0556b.fvU, R.color.cp_bg_line_c);
            am.setViewTextColor(c0556b.title, R.color.cp_link_tip_a, 1);
            am.setBackgroundResource(view2, R.drawable.home_recommend_item_bg);
            return view2;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class a {
        TextView cui;
        TextView ieK;
        ImageView ieS;

        private a() {
        }
    }

    private View d(View view, int i, boolean z) {
        a aVar;
        Object item = getItem(i);
        if (item instanceof a.C0613a) {
            a.C0613a c0613a = (a.C0613a) item;
            if (view == null || !(view.getTag() instanceof C0556b)) {
                view = LayoutInflater.from(this.ieR.getPageContext().getPageActivity()).inflate(R.layout.select_location_address_item, (ViewGroup) null);
                a aVar2 = new a();
                aVar2.cui = (TextView) view.findViewById(R.id.select_location_name);
                aVar2.ieK = (TextView) view.findViewById(R.id.select_location_address);
                aVar2.ieS = (ImageView) view.findViewById(R.id.select_location_tick);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            aVar.ieK.setText(c0613a.getAddr());
            if (this.isShowLocation && i == 1) {
                aVar.ieS.setVisibility(0);
                if (TextUtils.isEmpty(c0613a.getAddr())) {
                    aVar.ieK.setText(R.string.select_location_current);
                }
            } else {
                aVar.ieS.setVisibility(4);
            }
            aVar.cui.setText(c0613a.getName());
            this.ieR.getLayoutMode().setNightMode(z);
            this.ieR.getLayoutMode().onModeChanged(view);
            am.setBackgroundResource(view, R.drawable.home_recommend_item_bg);
            return view;
        }
        return null;
    }
}
