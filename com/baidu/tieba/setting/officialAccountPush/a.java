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
/* loaded from: classes26.dex */
public class a extends BaseAdapter implements BdSwitchView.a {
    private TbPageContext etO;
    private ArrayList<OfficialAccountPushInfo> euy;
    private BdSwitchView.a mrg;

    public a(TbPageContext tbPageContext) {
        this.etO = tbPageContext;
    }

    public void setData(ArrayList<OfficialAccountPushInfo> arrayList) {
        this.euy = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.euy == null) {
            return 0;
        }
        return this.euy.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.euy == null || i < 0 || i >= this.euy.size()) {
            return null;
        }
        return this.euy.get(i);
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
        C0812a c0812a;
        if (view == null) {
            view = LayoutInflater.from(this.etO.getPageActivity()).inflate(R.layout.official_account_push_item, viewGroup, false);
            c0812a = new C0812a();
            c0812a.mrh = (MsgSettingItemView) view.findViewById(R.id.item_official_account_push);
            view.setTag(c0812a);
        } else {
            c0812a = (C0812a) view.getTag();
        }
        OfficialAccountPushInfo officialAccountPushInfo = (OfficialAccountPushInfo) getItem(i);
        if (at.isEmpty(officialAccountPushInfo.name)) {
            c0812a.mrh.setVisibility(8);
        } else {
            c0812a.mrh.setVisibility(0);
            c0812a.mrh.setText(officialAccountPushInfo.name);
            if (officialAccountPushInfo.is_on == 1) {
                c0812a.mrh.getSwitchView().turnOnNoCallback();
            } else {
                c0812a.mrh.getSwitchView().turnOffNoCallback();
            }
            c0812a.mrh.setLineVisibility(true);
            c0812a.mrh.onChangeSkinType(this.etO, TbadkCoreApplication.getInst().getSkinType());
            c0812a.mrh.getSwitchView().setOnSwitchStateChangeListener(this);
            c0812a.mrh.getSwitchView().setTag(officialAccountPushInfo);
        }
        return view;
    }

    public void setSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.mrg = aVar;
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (this.mrg != null) {
            this.mrg.a(view, switchState);
        }
    }

    /* renamed from: com.baidu.tieba.setting.officialAccountPush.a$a  reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    public class C0812a {
        MsgSettingItemView mrh;

        public C0812a() {
        }
    }
}
