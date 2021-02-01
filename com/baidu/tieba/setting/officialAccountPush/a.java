package com.baidu.tieba.setting.officialAccountPush;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.R;
import com.baidu.tieba.setting.more.MsgSettingItemView;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class a extends BaseAdapter implements BdSwitchView.a {
    private TbPageContext eUY;
    private ArrayList<OfficialAccountPushInfo> eVV;
    private BdSwitchView.a niX;

    public a(TbPageContext tbPageContext) {
        this.eUY = tbPageContext;
    }

    public void setData(ArrayList<OfficialAccountPushInfo> arrayList) {
        this.eVV = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eVV == null) {
            return 0;
        }
        return this.eVV.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.eVV == null || i < 0 || i >= this.eVV.size()) {
            return null;
        }
        return this.eVV.get(i);
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
        C0862a c0862a;
        if (view == null) {
            view = LayoutInflater.from(this.eUY.getPageActivity()).inflate(R.layout.official_account_push_item, viewGroup, false);
            c0862a = new C0862a();
            c0862a.niY = (MsgSettingItemView) view.findViewById(R.id.item_official_account_push);
            view.setTag(c0862a);
        } else {
            c0862a = (C0862a) view.getTag();
        }
        OfficialAccountPushInfo officialAccountPushInfo = (OfficialAccountPushInfo) getItem(i);
        if (au.isEmpty(officialAccountPushInfo.name)) {
            c0862a.niY.setVisibility(8);
        } else {
            c0862a.niY.setVisibility(0);
            c0862a.niY.setText(officialAccountPushInfo.name);
            if (officialAccountPushInfo.is_on == 1) {
                c0862a.niY.getSwitchView().turnOnNoCallback();
            } else {
                c0862a.niY.getSwitchView().turnOffNoCallback();
            }
            c0862a.niY.setLineVisibility(true);
            c0862a.niY.onChangeSkinType(this.eUY, TbadkCoreApplication.getInst().getSkinType());
            c0862a.niY.getSwitchView().setOnSwitchStateChangeListener(this);
            c0862a.niY.getSwitchView().setTag(officialAccountPushInfo);
        }
        return view;
    }

    public void setSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.niX = aVar;
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (this.niX != null) {
            this.niX.a(view, switchState);
        }
    }

    /* renamed from: com.baidu.tieba.setting.officialAccountPush.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0862a {
        MsgSettingItemView niY;

        public C0862a() {
        }
    }
}
