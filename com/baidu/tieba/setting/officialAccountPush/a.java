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
/* loaded from: classes13.dex */
public class a extends BaseAdapter implements BdSwitchView.a {
    private TbPageContext dIF;
    private ArrayList<OfficialAccountPushInfo> dJp;
    private BdSwitchView.a kXY;

    public a(TbPageContext tbPageContext) {
        this.dIF = tbPageContext;
    }

    public void setData(ArrayList<OfficialAccountPushInfo> arrayList) {
        this.dJp = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.dJp == null) {
            return 0;
        }
        return this.dJp.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.dJp == null || i < 0 || i >= this.dJp.size()) {
            return null;
        }
        return this.dJp.get(i);
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
        C0717a c0717a;
        if (view == null) {
            view = LayoutInflater.from(this.dIF.getPageActivity()).inflate(R.layout.official_account_push_item, viewGroup, false);
            c0717a = new C0717a();
            c0717a.kXZ = (MsgSettingItemView) view.findViewById(R.id.item_official_account_push);
            view.setTag(c0717a);
        } else {
            c0717a = (C0717a) view.getTag();
        }
        OfficialAccountPushInfo officialAccountPushInfo = (OfficialAccountPushInfo) getItem(i);
        if (aq.isEmpty(officialAccountPushInfo.name)) {
            c0717a.kXZ.setVisibility(8);
        } else {
            c0717a.kXZ.setVisibility(0);
            c0717a.kXZ.setText(officialAccountPushInfo.name);
            if (officialAccountPushInfo.is_on == 1) {
                c0717a.kXZ.getSwitchView().turnOnNoCallback();
            } else {
                c0717a.kXZ.getSwitchView().turnOffNoCallback();
            }
            c0717a.kXZ.setLineVisibility(true);
            c0717a.kXZ.onChangeSkinType(this.dIF, TbadkCoreApplication.getInst().getSkinType());
            c0717a.kXZ.getSwitchView().setOnSwitchStateChangeListener(this);
            c0717a.kXZ.getSwitchView().setTag(officialAccountPushInfo);
        }
        return view;
    }

    public void setSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.kXY = aVar;
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (this.kXY != null) {
            this.kXY.a(view, switchState);
        }
    }

    /* renamed from: com.baidu.tieba.setting.officialAccountPush.a$a  reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public class C0717a {
        MsgSettingItemView kXZ;

        public C0717a() {
        }
    }
}
