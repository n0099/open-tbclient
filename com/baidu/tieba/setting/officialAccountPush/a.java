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
/* loaded from: classes25.dex */
public class a extends BaseAdapter implements BdSwitchView.a {
    private TbPageContext eGu;
    private ArrayList<OfficialAccountPushInfo> eHj;
    private BdSwitchView.a mKw;

    public a(TbPageContext tbPageContext) {
        this.eGu = tbPageContext;
    }

    public void setData(ArrayList<OfficialAccountPushInfo> arrayList) {
        this.eHj = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eHj == null) {
            return 0;
        }
        return this.eHj.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.eHj == null || i < 0 || i >= this.eHj.size()) {
            return null;
        }
        return this.eHj.get(i);
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
        C0845a c0845a;
        if (view == null) {
            view = LayoutInflater.from(this.eGu.getPageActivity()).inflate(R.layout.official_account_push_item, viewGroup, false);
            c0845a = new C0845a();
            c0845a.mKx = (MsgSettingItemView) view.findViewById(R.id.item_official_account_push);
            view.setTag(c0845a);
        } else {
            c0845a = (C0845a) view.getTag();
        }
        OfficialAccountPushInfo officialAccountPushInfo = (OfficialAccountPushInfo) getItem(i);
        if (au.isEmpty(officialAccountPushInfo.name)) {
            c0845a.mKx.setVisibility(8);
        } else {
            c0845a.mKx.setVisibility(0);
            c0845a.mKx.setText(officialAccountPushInfo.name);
            if (officialAccountPushInfo.is_on == 1) {
                c0845a.mKx.getSwitchView().turnOnNoCallback();
            } else {
                c0845a.mKx.getSwitchView().turnOffNoCallback();
            }
            c0845a.mKx.setLineVisibility(true);
            c0845a.mKx.onChangeSkinType(this.eGu, TbadkCoreApplication.getInst().getSkinType());
            c0845a.mKx.getSwitchView().setOnSwitchStateChangeListener(this);
            c0845a.mKx.getSwitchView().setTag(officialAccountPushInfo);
        }
        return view;
    }

    public void setSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.mKw = aVar;
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (this.mKw != null) {
            this.mKw.a(view, switchState);
        }
    }

    /* renamed from: com.baidu.tieba.setting.officialAccountPush.a$a  reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    public class C0845a {
        MsgSettingItemView mKx;

        public C0845a() {
        }
    }
}
