package com.baidu.tieba.setting.officialAccountPush;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.R;
import com.baidu.tieba.setting.more.MsgSettingItemView;
import java.util.ArrayList;
/* loaded from: classes20.dex */
public class a extends BaseAdapter implements BdSwitchView.a {
    private TbPageContext dVN;
    private ArrayList<OfficialAccountPushInfo> dWx;
    private BdSwitchView.a lAy;

    public a(TbPageContext tbPageContext) {
        this.dVN = tbPageContext;
    }

    public void setData(ArrayList<OfficialAccountPushInfo> arrayList) {
        this.dWx = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.dWx == null) {
            return 0;
        }
        return this.dWx.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.dWx == null || i < 0 || i >= this.dWx.size()) {
            return null;
        }
        return this.dWx.get(i);
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
        C0744a c0744a;
        if (view == null) {
            view = LayoutInflater.from(this.dVN.getPageActivity()).inflate(R.layout.official_account_push_item, viewGroup, false);
            c0744a = new C0744a();
            c0744a.lAz = (MsgSettingItemView) view.findViewById(R.id.item_official_account_push);
            view.setTag(c0744a);
        } else {
            c0744a = (C0744a) view.getTag();
        }
        OfficialAccountPushInfo officialAccountPushInfo = (OfficialAccountPushInfo) getItem(i);
        if (as.isEmpty(officialAccountPushInfo.name)) {
            c0744a.lAz.setVisibility(8);
        } else {
            c0744a.lAz.setVisibility(0);
            c0744a.lAz.setText(officialAccountPushInfo.name);
            if (officialAccountPushInfo.is_on == 1) {
                c0744a.lAz.getSwitchView().turnOnNoCallback();
            } else {
                c0744a.lAz.getSwitchView().turnOffNoCallback();
            }
            c0744a.lAz.setLineVisibility(true);
            c0744a.lAz.onChangeSkinType(this.dVN, TbadkCoreApplication.getInst().getSkinType());
            c0744a.lAz.getSwitchView().setOnSwitchStateChangeListener(this);
            c0744a.lAz.getSwitchView().setTag(officialAccountPushInfo);
        }
        return view;
    }

    public void setSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.lAy = aVar;
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (this.lAy != null) {
            this.lAy.a(view, switchState);
        }
    }

    /* renamed from: com.baidu.tieba.setting.officialAccountPush.a$a  reason: collision with other inner class name */
    /* loaded from: classes20.dex */
    public class C0744a {
        MsgSettingItemView lAz;

        public C0744a() {
        }
    }
}
