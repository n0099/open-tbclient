package com.baidu.tieba.setting.officialAccountPush;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
import com.baidu.tieba.setting.more.MsgSettingItemView;
import java.util.ArrayList;
/* loaded from: classes10.dex */
public class a extends BaseAdapter implements BdSwitchView.a {
    private TbPageContext cQU;
    private ArrayList<OfficialAccountPushInfo> cRE;
    private BdSwitchView.a jQq;

    public a(TbPageContext tbPageContext) {
        this.cQU = tbPageContext;
    }

    public void setData(ArrayList<OfficialAccountPushInfo> arrayList) {
        this.cRE = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.cRE == null) {
            return 0;
        }
        return this.cRE.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.cRE == null || i < 0 || i >= this.cRE.size()) {
            return null;
        }
        return this.cRE.get(i);
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
        C0590a c0590a;
        if (view == null) {
            view = LayoutInflater.from(this.cQU.getPageActivity()).inflate(R.layout.official_account_push_item, viewGroup, false);
            c0590a = new C0590a();
            c0590a.jQr = (MsgSettingItemView) view.findViewById(R.id.item_official_account_push);
            view.setTag(c0590a);
        } else {
            c0590a = (C0590a) view.getTag();
        }
        OfficialAccountPushInfo officialAccountPushInfo = (OfficialAccountPushInfo) getItem(i);
        if (aq.isEmpty(officialAccountPushInfo.name)) {
            c0590a.jQr.setVisibility(8);
        } else {
            c0590a.jQr.setVisibility(0);
            c0590a.jQr.setText(officialAccountPushInfo.name);
            if (officialAccountPushInfo.is_on == 1) {
                c0590a.jQr.getSwitchView().turnOnNoCallback();
            } else {
                c0590a.jQr.getSwitchView().turnOffNoCallback();
            }
            c0590a.jQr.setLineVisibility(true);
            c0590a.jQr.onChangeSkinType(this.cQU, TbadkCoreApplication.getInst().getSkinType());
            c0590a.jQr.getSwitchView().setOnSwitchStateChangeListener(this);
            c0590a.jQr.getSwitchView().setTag(officialAccountPushInfo);
        }
        return view;
    }

    public void setSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.jQq = aVar;
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (this.jQq != null) {
            this.jQq.a(view, switchState);
        }
    }

    /* renamed from: com.baidu.tieba.setting.officialAccountPush.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public class C0590a {
        MsgSettingItemView jQr;

        public C0590a() {
        }
    }
}
