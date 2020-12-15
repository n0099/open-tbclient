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
/* loaded from: classes26.dex */
public class a extends BaseAdapter implements BdSwitchView.a {
    private TbPageContext eNx;
    private ArrayList<OfficialAccountPushInfo> eOt;
    private BdSwitchView.a mYA;

    public a(TbPageContext tbPageContext) {
        this.eNx = tbPageContext;
    }

    public void setData(ArrayList<OfficialAccountPushInfo> arrayList) {
        this.eOt = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eOt == null) {
            return 0;
        }
        return this.eOt.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.eOt == null || i < 0 || i >= this.eOt.size()) {
            return null;
        }
        return this.eOt.get(i);
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
        C0860a c0860a;
        if (view == null) {
            view = LayoutInflater.from(this.eNx.getPageActivity()).inflate(R.layout.official_account_push_item, viewGroup, false);
            c0860a = new C0860a();
            c0860a.mYB = (MsgSettingItemView) view.findViewById(R.id.item_official_account_push);
            view.setTag(c0860a);
        } else {
            c0860a = (C0860a) view.getTag();
        }
        OfficialAccountPushInfo officialAccountPushInfo = (OfficialAccountPushInfo) getItem(i);
        if (au.isEmpty(officialAccountPushInfo.name)) {
            c0860a.mYB.setVisibility(8);
        } else {
            c0860a.mYB.setVisibility(0);
            c0860a.mYB.setText(officialAccountPushInfo.name);
            if (officialAccountPushInfo.is_on == 1) {
                c0860a.mYB.getSwitchView().turnOnNoCallback();
            } else {
                c0860a.mYB.getSwitchView().turnOffNoCallback();
            }
            c0860a.mYB.setLineVisibility(true);
            c0860a.mYB.onChangeSkinType(this.eNx, TbadkCoreApplication.getInst().getSkinType());
            c0860a.mYB.getSwitchView().setOnSwitchStateChangeListener(this);
            c0860a.mYB.getSwitchView().setTag(officialAccountPushInfo);
        }
        return view;
    }

    public void setSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.mYA = aVar;
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (this.mYA != null) {
            this.mYA.a(view, switchState);
        }
    }

    /* renamed from: com.baidu.tieba.setting.officialAccountPush.a$a  reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    public class C0860a {
        MsgSettingItemView mYB;

        public C0860a() {
        }
    }
}
