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
    private ArrayList<OfficialAccountPushInfo> cVS;
    private TbPageContext cVi;
    private BdSwitchView.a jVh;

    public a(TbPageContext tbPageContext) {
        this.cVi = tbPageContext;
    }

    public void setData(ArrayList<OfficialAccountPushInfo> arrayList) {
        this.cVS = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.cVS == null) {
            return 0;
        }
        return this.cVS.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.cVS == null || i < 0 || i >= this.cVS.size()) {
            return null;
        }
        return this.cVS.get(i);
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
        C0602a c0602a;
        if (view == null) {
            view = LayoutInflater.from(this.cVi.getPageActivity()).inflate(R.layout.official_account_push_item, viewGroup, false);
            c0602a = new C0602a();
            c0602a.jVi = (MsgSettingItemView) view.findViewById(R.id.item_official_account_push);
            view.setTag(c0602a);
        } else {
            c0602a = (C0602a) view.getTag();
        }
        OfficialAccountPushInfo officialAccountPushInfo = (OfficialAccountPushInfo) getItem(i);
        if (aq.isEmpty(officialAccountPushInfo.name)) {
            c0602a.jVi.setVisibility(8);
        } else {
            c0602a.jVi.setVisibility(0);
            c0602a.jVi.setText(officialAccountPushInfo.name);
            if (officialAccountPushInfo.is_on == 1) {
                c0602a.jVi.getSwitchView().turnOnNoCallback();
            } else {
                c0602a.jVi.getSwitchView().turnOffNoCallback();
            }
            c0602a.jVi.setLineVisibility(true);
            c0602a.jVi.onChangeSkinType(this.cVi, TbadkCoreApplication.getInst().getSkinType());
            c0602a.jVi.getSwitchView().setOnSwitchStateChangeListener(this);
            c0602a.jVi.getSwitchView().setTag(officialAccountPushInfo);
        }
        return view;
    }

    public void setSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.jVh = aVar;
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (this.jVh != null) {
            this.jVh.a(view, switchState);
        }
    }

    /* renamed from: com.baidu.tieba.setting.officialAccountPush.a$a  reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public class C0602a {
        MsgSettingItemView jVi;

        public C0602a() {
        }
    }
}
