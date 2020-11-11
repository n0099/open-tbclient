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
    private ArrayList<OfficialAccountPushInfo> eIM;
    private TbPageContext eIc;
    private BdSwitchView.a mJN;

    public a(TbPageContext tbPageContext) {
        this.eIc = tbPageContext;
    }

    public void setData(ArrayList<OfficialAccountPushInfo> arrayList) {
        this.eIM = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eIM == null) {
            return 0;
        }
        return this.eIM.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.eIM == null || i < 0 || i >= this.eIM.size()) {
            return null;
        }
        return this.eIM.get(i);
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
        C0842a c0842a;
        if (view == null) {
            view = LayoutInflater.from(this.eIc.getPageActivity()).inflate(R.layout.official_account_push_item, viewGroup, false);
            c0842a = new C0842a();
            c0842a.mJO = (MsgSettingItemView) view.findViewById(R.id.item_official_account_push);
            view.setTag(c0842a);
        } else {
            c0842a = (C0842a) view.getTag();
        }
        OfficialAccountPushInfo officialAccountPushInfo = (OfficialAccountPushInfo) getItem(i);
        if (at.isEmpty(officialAccountPushInfo.name)) {
            c0842a.mJO.setVisibility(8);
        } else {
            c0842a.mJO.setVisibility(0);
            c0842a.mJO.setText(officialAccountPushInfo.name);
            if (officialAccountPushInfo.is_on == 1) {
                c0842a.mJO.getSwitchView().turnOnNoCallback();
            } else {
                c0842a.mJO.getSwitchView().turnOffNoCallback();
            }
            c0842a.mJO.setLineVisibility(true);
            c0842a.mJO.onChangeSkinType(this.eIc, TbadkCoreApplication.getInst().getSkinType());
            c0842a.mJO.getSwitchView().setOnSwitchStateChangeListener(this);
            c0842a.mJO.getSwitchView().setTag(officialAccountPushInfo);
        }
        return view;
    }

    public void setSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.mJN = aVar;
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (this.mJN != null) {
            this.mJN.a(view, switchState);
        }
    }

    /* renamed from: com.baidu.tieba.setting.officialAccountPush.a$a  reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    public class C0842a {
        MsgSettingItemView mJO;

        public C0842a() {
        }
    }
}
