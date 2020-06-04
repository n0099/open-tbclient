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
    private BdSwitchView.a kZh;

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
        C0718a c0718a;
        if (view == null) {
            view = LayoutInflater.from(this.dIF.getPageActivity()).inflate(R.layout.official_account_push_item, viewGroup, false);
            c0718a = new C0718a();
            c0718a.kZi = (MsgSettingItemView) view.findViewById(R.id.item_official_account_push);
            view.setTag(c0718a);
        } else {
            c0718a = (C0718a) view.getTag();
        }
        OfficialAccountPushInfo officialAccountPushInfo = (OfficialAccountPushInfo) getItem(i);
        if (aq.isEmpty(officialAccountPushInfo.name)) {
            c0718a.kZi.setVisibility(8);
        } else {
            c0718a.kZi.setVisibility(0);
            c0718a.kZi.setText(officialAccountPushInfo.name);
            if (officialAccountPushInfo.is_on == 1) {
                c0718a.kZi.getSwitchView().turnOnNoCallback();
            } else {
                c0718a.kZi.getSwitchView().turnOffNoCallback();
            }
            c0718a.kZi.setLineVisibility(true);
            c0718a.kZi.onChangeSkinType(this.dIF, TbadkCoreApplication.getInst().getSkinType());
            c0718a.kZi.getSwitchView().setOnSwitchStateChangeListener(this);
            c0718a.kZi.getSwitchView().setTag(officialAccountPushInfo);
        }
        return view;
    }

    public void setSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.kZh = aVar;
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (this.kZh != null) {
            this.kZh.a(view, switchState);
        }
    }

    /* renamed from: com.baidu.tieba.setting.officialAccountPush.a$a  reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public class C0718a {
        MsgSettingItemView kZi;

        public C0718a() {
        }
    }
}
