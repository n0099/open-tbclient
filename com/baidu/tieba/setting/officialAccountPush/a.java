package com.baidu.tieba.setting.officialAccountPush;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.R;
import com.baidu.tieba.setting.more.MsgSettingItemView;
import java.util.ArrayList;
/* loaded from: classes13.dex */
public class a extends BaseAdapter implements BdSwitchView.a {
    private TbPageContext dPv;
    private ArrayList<OfficialAccountPushInfo> dQf;
    private BdSwitchView.a lte;

    public a(TbPageContext tbPageContext) {
        this.dPv = tbPageContext;
    }

    public void setData(ArrayList<OfficialAccountPushInfo> arrayList) {
        this.dQf = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.dQf == null) {
            return 0;
        }
        return this.dQf.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.dQf == null || i < 0 || i >= this.dQf.size()) {
            return null;
        }
        return this.dQf.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (getItem(i) != null) {
            return i;
        }
        return -1L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0734a c0734a;
        if (view == null) {
            view = LayoutInflater.from(this.dPv.getPageActivity()).inflate(R.layout.official_account_push_item, viewGroup, false);
            c0734a = new C0734a();
            c0734a.ltf = (MsgSettingItemView) view.findViewById(R.id.item_official_account_push);
            view.setTag(c0734a);
        } else {
            c0734a = (C0734a) view.getTag();
        }
        OfficialAccountPushInfo officialAccountPushInfo = (OfficialAccountPushInfo) getItem(i);
        if (ar.isEmpty(officialAccountPushInfo.name)) {
            c0734a.ltf.setVisibility(8);
        } else {
            c0734a.ltf.setVisibility(0);
            c0734a.ltf.setText(officialAccountPushInfo.name);
            if (officialAccountPushInfo.is_on == 1) {
                c0734a.ltf.getSwitchView().turnOnNoCallback();
            } else {
                c0734a.ltf.getSwitchView().turnOffNoCallback();
            }
            c0734a.ltf.setLineVisibility(true);
            c0734a.ltf.onChangeSkinType(this.dPv, TbadkCoreApplication.getInst().getSkinType());
            c0734a.ltf.getSwitchView().setOnSwitchStateChangeListener(this);
            c0734a.ltf.getSwitchView().setTag(officialAccountPushInfo);
        }
        return view;
    }

    public void setSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.lte = aVar;
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (this.lte != null) {
            this.lte.a(view, switchState);
        }
    }

    /* renamed from: com.baidu.tieba.setting.officialAccountPush.a$a  reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public class C0734a {
        MsgSettingItemView ltf;

        public C0734a() {
        }
    }
}
