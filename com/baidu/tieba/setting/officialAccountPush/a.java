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
    private ArrayList<OfficialAccountPushInfo> eCX;
    private TbPageContext eCn;
    private BdSwitchView.a mDL;

    public a(TbPageContext tbPageContext) {
        this.eCn = tbPageContext;
    }

    public void setData(ArrayList<OfficialAccountPushInfo> arrayList) {
        this.eCX = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eCX == null) {
            return 0;
        }
        return this.eCX.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.eCX == null || i < 0 || i >= this.eCX.size()) {
            return null;
        }
        return this.eCX.get(i);
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
        C0827a c0827a;
        if (view == null) {
            view = LayoutInflater.from(this.eCn.getPageActivity()).inflate(R.layout.official_account_push_item, viewGroup, false);
            c0827a = new C0827a();
            c0827a.mDM = (MsgSettingItemView) view.findViewById(R.id.item_official_account_push);
            view.setTag(c0827a);
        } else {
            c0827a = (C0827a) view.getTag();
        }
        OfficialAccountPushInfo officialAccountPushInfo = (OfficialAccountPushInfo) getItem(i);
        if (at.isEmpty(officialAccountPushInfo.name)) {
            c0827a.mDM.setVisibility(8);
        } else {
            c0827a.mDM.setVisibility(0);
            c0827a.mDM.setText(officialAccountPushInfo.name);
            if (officialAccountPushInfo.is_on == 1) {
                c0827a.mDM.getSwitchView().turnOnNoCallback();
            } else {
                c0827a.mDM.getSwitchView().turnOffNoCallback();
            }
            c0827a.mDM.setLineVisibility(true);
            c0827a.mDM.onChangeSkinType(this.eCn, TbadkCoreApplication.getInst().getSkinType());
            c0827a.mDM.getSwitchView().setOnSwitchStateChangeListener(this);
            c0827a.mDM.getSwitchView().setTag(officialAccountPushInfo);
        }
        return view;
    }

    public void setSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.mDL = aVar;
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (this.mDL != null) {
            this.mDL.a(view, switchState);
        }
    }

    /* renamed from: com.baidu.tieba.setting.officialAccountPush.a$a  reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    public class C0827a {
        MsgSettingItemView mDM;

        public C0827a() {
        }
    }
}
