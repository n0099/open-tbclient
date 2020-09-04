package com.baidu.tieba.setting.officialAccountPush;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.R;
import com.baidu.tieba.setting.more.MsgSettingItemView;
import java.util.ArrayList;
/* loaded from: classes20.dex */
public class a extends BaseAdapter implements BdSwitchView.a {
    private TbPageContext efr;
    private ArrayList<OfficialAccountPushInfo> egb;
    private BdSwitchView.a lSs;

    public a(TbPageContext tbPageContext) {
        this.efr = tbPageContext;
    }

    public void setData(ArrayList<OfficialAccountPushInfo> arrayList) {
        this.egb = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.egb == null) {
            return 0;
        }
        return this.egb.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.egb == null || i < 0 || i >= this.egb.size()) {
            return null;
        }
        return this.egb.get(i);
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
        C0797a c0797a;
        if (view == null) {
            view = LayoutInflater.from(this.efr.getPageActivity()).inflate(R.layout.official_account_push_item, viewGroup, false);
            c0797a = new C0797a();
            c0797a.lSt = (MsgSettingItemView) view.findViewById(R.id.item_official_account_push);
            view.setTag(c0797a);
        } else {
            c0797a = (C0797a) view.getTag();
        }
        OfficialAccountPushInfo officialAccountPushInfo = (OfficialAccountPushInfo) getItem(i);
        if (at.isEmpty(officialAccountPushInfo.name)) {
            c0797a.lSt.setVisibility(8);
        } else {
            c0797a.lSt.setVisibility(0);
            c0797a.lSt.setText(officialAccountPushInfo.name);
            if (officialAccountPushInfo.is_on == 1) {
                c0797a.lSt.getSwitchView().turnOnNoCallback();
            } else {
                c0797a.lSt.getSwitchView().turnOffNoCallback();
            }
            c0797a.lSt.setLineVisibility(true);
            c0797a.lSt.onChangeSkinType(this.efr, TbadkCoreApplication.getInst().getSkinType());
            c0797a.lSt.getSwitchView().setOnSwitchStateChangeListener(this);
            c0797a.lSt.getSwitchView().setTag(officialAccountPushInfo);
        }
        return view;
    }

    public void setSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.lSs = aVar;
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (this.lSs != null) {
            this.lSs.a(view, switchState);
        }
    }

    /* renamed from: com.baidu.tieba.setting.officialAccountPush.a$a  reason: collision with other inner class name */
    /* loaded from: classes20.dex */
    public class C0797a {
        MsgSettingItemView lSt;

        public C0797a() {
        }
    }
}
