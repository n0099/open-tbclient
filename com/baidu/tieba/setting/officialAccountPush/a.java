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
/* loaded from: classes8.dex */
public class a extends BaseAdapter implements BdSwitchView.a {
    private TbPageContext eXu;
    private ArrayList<OfficialAccountPushInfo> eYq;
    private BdSwitchView.a ndU;

    public a(TbPageContext tbPageContext) {
        this.eXu = tbPageContext;
    }

    public void setData(ArrayList<OfficialAccountPushInfo> arrayList) {
        this.eYq = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eYq == null) {
            return 0;
        }
        return this.eYq.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.eYq == null || i < 0 || i >= this.eYq.size()) {
            return null;
        }
        return this.eYq.get(i);
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
        C0843a c0843a;
        if (view == null) {
            view = LayoutInflater.from(this.eXu.getPageActivity()).inflate(R.layout.official_account_push_item, viewGroup, false);
            c0843a = new C0843a();
            c0843a.ndV = (MsgSettingItemView) view.findViewById(R.id.item_official_account_push);
            view.setTag(c0843a);
        } else {
            c0843a = (C0843a) view.getTag();
        }
        OfficialAccountPushInfo officialAccountPushInfo = (OfficialAccountPushInfo) getItem(i);
        if (at.isEmpty(officialAccountPushInfo.name)) {
            c0843a.ndV.setVisibility(8);
        } else {
            c0843a.ndV.setVisibility(0);
            c0843a.ndV.setText(officialAccountPushInfo.name);
            if (officialAccountPushInfo.is_on == 1) {
                c0843a.ndV.getSwitchView().turnOnNoCallback();
            } else {
                c0843a.ndV.getSwitchView().turnOffNoCallback();
            }
            c0843a.ndV.setLineVisibility(true);
            c0843a.ndV.onChangeSkinType(this.eXu, TbadkCoreApplication.getInst().getSkinType());
            c0843a.ndV.getSwitchView().setOnSwitchStateChangeListener(this);
            c0843a.ndV.getSwitchView().setTag(officialAccountPushInfo);
        }
        return view;
    }

    public void setSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.ndU = aVar;
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (this.ndU != null) {
            this.ndU.a(view, switchState);
        }
    }

    /* renamed from: com.baidu.tieba.setting.officialAccountPush.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0843a {
        MsgSettingItemView ndV;

        public C0843a() {
        }
    }
}
