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
/* loaded from: classes25.dex */
public class a extends BaseAdapter implements BdSwitchView.a {
    private TbPageContext ehG;
    private ArrayList<OfficialAccountPushInfo> eiq;
    private BdSwitchView.a mbC;

    public a(TbPageContext tbPageContext) {
        this.ehG = tbPageContext;
    }

    public void setData(ArrayList<OfficialAccountPushInfo> arrayList) {
        this.eiq = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eiq == null) {
            return 0;
        }
        return this.eiq.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.eiq == null || i < 0 || i >= this.eiq.size()) {
            return null;
        }
        return this.eiq.get(i);
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
        C0794a c0794a;
        if (view == null) {
            view = LayoutInflater.from(this.ehG.getPageActivity()).inflate(R.layout.official_account_push_item, viewGroup, false);
            c0794a = new C0794a();
            c0794a.mbD = (MsgSettingItemView) view.findViewById(R.id.item_official_account_push);
            view.setTag(c0794a);
        } else {
            c0794a = (C0794a) view.getTag();
        }
        OfficialAccountPushInfo officialAccountPushInfo = (OfficialAccountPushInfo) getItem(i);
        if (at.isEmpty(officialAccountPushInfo.name)) {
            c0794a.mbD.setVisibility(8);
        } else {
            c0794a.mbD.setVisibility(0);
            c0794a.mbD.setText(officialAccountPushInfo.name);
            if (officialAccountPushInfo.is_on == 1) {
                c0794a.mbD.getSwitchView().turnOnNoCallback();
            } else {
                c0794a.mbD.getSwitchView().turnOffNoCallback();
            }
            c0794a.mbD.setLineVisibility(true);
            c0794a.mbD.onChangeSkinType(this.ehG, TbadkCoreApplication.getInst().getSkinType());
            c0794a.mbD.getSwitchView().setOnSwitchStateChangeListener(this);
            c0794a.mbD.getSwitchView().setTag(officialAccountPushInfo);
        }
        return view;
    }

    public void setSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.mbC = aVar;
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (this.mbC != null) {
            this.mbC.a(view, switchState);
        }
    }

    /* renamed from: com.baidu.tieba.setting.officialAccountPush.a$a  reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    public class C0794a {
        MsgSettingItemView mbD;

        public C0794a() {
        }
    }
}
