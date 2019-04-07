package com.baidu.tieba.setting.officialAccountPush;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.d;
import com.baidu.tieba.setting.more.MsgSettingItemView;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class a extends BaseAdapter implements BdSwitchView.a {
    private ArrayList<OfficialAccountPushInfo> aFL;
    private BdSwitchView.a dWV;
    private TbPageContext mContext;

    public a(TbPageContext tbPageContext) {
        this.mContext = tbPageContext;
    }

    public void setData(ArrayList<OfficialAccountPushInfo> arrayList) {
        this.aFL = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aFL == null) {
            return 0;
        }
        return this.aFL.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aFL == null || i < 0 || i >= this.aFL.size()) {
            return null;
        }
        return this.aFL.get(i);
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
        C0381a c0381a;
        if (view == null) {
            view = LayoutInflater.from(this.mContext.getPageActivity()).inflate(d.h.official_account_push_item, viewGroup, false);
            c0381a = new C0381a();
            c0381a.iul = (MsgSettingItemView) view.findViewById(d.g.item_official_account_push);
            view.setTag(c0381a);
        } else {
            c0381a = (C0381a) view.getTag();
        }
        OfficialAccountPushInfo officialAccountPushInfo = (OfficialAccountPushInfo) getItem(i);
        if (ap.isEmpty(officialAccountPushInfo.name)) {
            c0381a.iul.setVisibility(8);
        } else {
            c0381a.iul.setVisibility(0);
            c0381a.iul.setText(officialAccountPushInfo.name);
            if (officialAccountPushInfo.iun == 1) {
                c0381a.iul.getSwitchView().nY();
            } else {
                c0381a.iul.getSwitchView().nZ();
            }
            c0381a.iul.setLineVisibility(true);
            c0381a.iul.onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
            c0381a.iul.getSwitchView().setOnSwitchStateChangeListener(this);
            c0381a.iul.getSwitchView().setTag(officialAccountPushInfo);
        }
        return view;
    }

    public void setSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.dWV = aVar;
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (this.dWV != null) {
            this.dWV.a(view, switchState);
        }
    }

    /* renamed from: com.baidu.tieba.setting.officialAccountPush.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0381a {
        MsgSettingItemView iul;

        public C0381a() {
        }
    }
}
