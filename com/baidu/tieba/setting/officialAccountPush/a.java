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
    private BdSwitchView.a ndT;

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
        C0876a c0876a;
        if (view == null) {
            view = LayoutInflater.from(this.eXu.getPageActivity()).inflate(R.layout.official_account_push_item, viewGroup, false);
            c0876a = new C0876a();
            c0876a.ndU = (MsgSettingItemView) view.findViewById(R.id.item_official_account_push);
            view.setTag(c0876a);
        } else {
            c0876a = (C0876a) view.getTag();
        }
        OfficialAccountPushInfo officialAccountPushInfo = (OfficialAccountPushInfo) getItem(i);
        if (at.isEmpty(officialAccountPushInfo.name)) {
            c0876a.ndU.setVisibility(8);
        } else {
            c0876a.ndU.setVisibility(0);
            c0876a.ndU.setText(officialAccountPushInfo.name);
            if (officialAccountPushInfo.is_on == 1) {
                c0876a.ndU.getSwitchView().turnOnNoCallback();
            } else {
                c0876a.ndU.getSwitchView().turnOffNoCallback();
            }
            c0876a.ndU.setLineVisibility(true);
            c0876a.ndU.onChangeSkinType(this.eXu, TbadkCoreApplication.getInst().getSkinType());
            c0876a.ndU.getSwitchView().setOnSwitchStateChangeListener(this);
            c0876a.ndU.getSwitchView().setTag(officialAccountPushInfo);
        }
        return view;
    }

    public void setSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.ndT = aVar;
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (this.ndT != null) {
            this.ndT.a(view, switchState);
        }
    }

    /* renamed from: com.baidu.tieba.setting.officialAccountPush.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0876a {
        MsgSettingItemView ndU;

        public C0876a() {
        }
    }
}
