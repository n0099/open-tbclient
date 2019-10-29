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
/* loaded from: classes3.dex */
public class a extends BaseAdapter implements BdSwitchView.a {
    private ArrayList<OfficialAccountPushInfo> bbZ;
    private TbPageContext cfl;
    private BdSwitchView.a iWL;

    public a(TbPageContext tbPageContext) {
        this.cfl = tbPageContext;
    }

    public void setData(ArrayList<OfficialAccountPushInfo> arrayList) {
        this.bbZ = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bbZ == null) {
            return 0;
        }
        return this.bbZ.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.bbZ == null || i < 0 || i >= this.bbZ.size()) {
            return null;
        }
        return this.bbZ.get(i);
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
        C0511a c0511a;
        if (view == null) {
            view = LayoutInflater.from(this.cfl.getPageActivity()).inflate(R.layout.official_account_push_item, viewGroup, false);
            c0511a = new C0511a();
            c0511a.iWM = (MsgSettingItemView) view.findViewById(R.id.item_official_account_push);
            view.setTag(c0511a);
        } else {
            c0511a = (C0511a) view.getTag();
        }
        OfficialAccountPushInfo officialAccountPushInfo = (OfficialAccountPushInfo) getItem(i);
        if (aq.isEmpty(officialAccountPushInfo.name)) {
            c0511a.iWM.setVisibility(8);
        } else {
            c0511a.iWM.setVisibility(0);
            c0511a.iWM.setText(officialAccountPushInfo.name);
            if (officialAccountPushInfo.iWO == 1) {
                c0511a.iWM.getSwitchView().turnOnNoCallback();
            } else {
                c0511a.iWM.getSwitchView().turnOffNoCallback();
            }
            c0511a.iWM.setLineVisibility(true);
            c0511a.iWM.onChangeSkinType(this.cfl, TbadkCoreApplication.getInst().getSkinType());
            c0511a.iWM.getSwitchView().setOnSwitchStateChangeListener(this);
            c0511a.iWM.getSwitchView().setTag(officialAccountPushInfo);
        }
        return view;
    }

    public void setSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.iWL = aVar;
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (this.iWL != null) {
            this.iWL.a(view, switchState);
        }
    }

    /* renamed from: com.baidu.tieba.setting.officialAccountPush.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0511a {
        MsgSettingItemView iWM;

        public C0511a() {
        }
    }
}
