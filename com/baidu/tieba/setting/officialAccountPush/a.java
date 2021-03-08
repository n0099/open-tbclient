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
/* loaded from: classes7.dex */
public class a extends BaseAdapter implements BdSwitchView.a {
    private TbPageContext eWx;
    private ArrayList<OfficialAccountPushInfo> eXu;
    private BdSwitchView.a nlB;

    public a(TbPageContext tbPageContext) {
        this.eWx = tbPageContext;
    }

    public void setData(ArrayList<OfficialAccountPushInfo> arrayList) {
        this.eXu = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eXu == null) {
            return 0;
        }
        return this.eXu.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.eXu == null || i < 0 || i >= this.eXu.size()) {
            return null;
        }
        return this.eXu.get(i);
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
        C0870a c0870a;
        if (view == null) {
            view = LayoutInflater.from(this.eWx.getPageActivity()).inflate(R.layout.official_account_push_item, viewGroup, false);
            c0870a = new C0870a();
            c0870a.nlC = (MsgSettingItemView) view.findViewById(R.id.item_official_account_push);
            view.setTag(c0870a);
        } else {
            c0870a = (C0870a) view.getTag();
        }
        OfficialAccountPushInfo officialAccountPushInfo = (OfficialAccountPushInfo) getItem(i);
        if (au.isEmpty(officialAccountPushInfo.name)) {
            c0870a.nlC.setVisibility(8);
        } else {
            c0870a.nlC.setVisibility(0);
            c0870a.nlC.setText(officialAccountPushInfo.name);
            if (officialAccountPushInfo.is_on == 1) {
                c0870a.nlC.getSwitchView().turnOnNoCallback();
            } else {
                c0870a.nlC.getSwitchView().turnOffNoCallback();
            }
            c0870a.nlC.setLineVisibility(true);
            c0870a.nlC.onChangeSkinType(this.eWx, TbadkCoreApplication.getInst().getSkinType());
            c0870a.nlC.getSwitchView().setOnSwitchStateChangeListener(this);
            c0870a.nlC.getSwitchView().setTag(officialAccountPushInfo);
        }
        return view;
    }

    public void setSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.nlB = aVar;
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (this.nlB != null) {
            this.nlB.a(view, switchState);
        }
    }

    /* renamed from: com.baidu.tieba.setting.officialAccountPush.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0870a {
        MsgSettingItemView nlC;

        public C0870a() {
        }
    }
}
