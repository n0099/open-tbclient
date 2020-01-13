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
/* loaded from: classes11.dex */
public class a extends BaseAdapter implements BdSwitchView.a {
    private ArrayList<OfficialAccountPushInfo> cRO;
    private TbPageContext cRe;
    private BdSwitchView.a jTT;

    public a(TbPageContext tbPageContext) {
        this.cRe = tbPageContext;
    }

    public void setData(ArrayList<OfficialAccountPushInfo> arrayList) {
        this.cRO = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.cRO == null) {
            return 0;
        }
        return this.cRO.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.cRO == null || i < 0 || i >= this.cRO.size()) {
            return null;
        }
        return this.cRO.get(i);
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
        C0595a c0595a;
        if (view == null) {
            view = LayoutInflater.from(this.cRe.getPageActivity()).inflate(R.layout.official_account_push_item, viewGroup, false);
            c0595a = new C0595a();
            c0595a.jTU = (MsgSettingItemView) view.findViewById(R.id.item_official_account_push);
            view.setTag(c0595a);
        } else {
            c0595a = (C0595a) view.getTag();
        }
        OfficialAccountPushInfo officialAccountPushInfo = (OfficialAccountPushInfo) getItem(i);
        if (aq.isEmpty(officialAccountPushInfo.name)) {
            c0595a.jTU.setVisibility(8);
        } else {
            c0595a.jTU.setVisibility(0);
            c0595a.jTU.setText(officialAccountPushInfo.name);
            if (officialAccountPushInfo.is_on == 1) {
                c0595a.jTU.getSwitchView().turnOnNoCallback();
            } else {
                c0595a.jTU.getSwitchView().turnOffNoCallback();
            }
            c0595a.jTU.setLineVisibility(true);
            c0595a.jTU.onChangeSkinType(this.cRe, TbadkCoreApplication.getInst().getSkinType());
            c0595a.jTU.getSwitchView().setOnSwitchStateChangeListener(this);
            c0595a.jTU.getSwitchView().setTag(officialAccountPushInfo);
        }
        return view;
    }

    public void setSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.jTT = aVar;
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (this.jTT != null) {
            this.jTT.a(view, switchState);
        }
    }

    /* renamed from: com.baidu.tieba.setting.officialAccountPush.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public class C0595a {
        MsgSettingItemView jTU;

        public C0595a() {
        }
    }
}
