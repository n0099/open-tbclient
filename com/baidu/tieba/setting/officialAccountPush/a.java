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
    private ArrayList<OfficialAccountPushInfo> aFH;
    private BdSwitchView.a dXB;
    private TbPageContext mContext;

    public a(TbPageContext tbPageContext) {
        this.mContext = tbPageContext;
    }

    public void setData(ArrayList<OfficialAccountPushInfo> arrayList) {
        this.aFH = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aFH == null) {
            return 0;
        }
        return this.aFH.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aFH == null || i < 0 || i >= this.aFH.size()) {
            return null;
        }
        return this.aFH.get(i);
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
        C0305a c0305a;
        if (view == null) {
            view = LayoutInflater.from(this.mContext.getPageActivity()).inflate(d.h.official_account_push_item, viewGroup, false);
            c0305a = new C0305a();
            c0305a.iuI = (MsgSettingItemView) view.findViewById(d.g.item_official_account_push);
            view.setTag(c0305a);
        } else {
            c0305a = (C0305a) view.getTag();
        }
        OfficialAccountPushInfo officialAccountPushInfo = (OfficialAccountPushInfo) getItem(i);
        if (ap.isEmpty(officialAccountPushInfo.name)) {
            c0305a.iuI.setVisibility(8);
        } else {
            c0305a.iuI.setVisibility(0);
            c0305a.iuI.setText(officialAccountPushInfo.name);
            if (officialAccountPushInfo.iuK == 1) {
                c0305a.iuI.getSwitchView().nY();
            } else {
                c0305a.iuI.getSwitchView().nZ();
            }
            c0305a.iuI.setLineVisibility(true);
            c0305a.iuI.onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
            c0305a.iuI.getSwitchView().setOnSwitchStateChangeListener(this);
            c0305a.iuI.getSwitchView().setTag(officialAccountPushInfo);
        }
        return view;
    }

    public void setSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.dXB = aVar;
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (this.dXB != null) {
            this.dXB.a(view, switchState);
        }
    }

    /* renamed from: com.baidu.tieba.setting.officialAccountPush.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0305a {
        MsgSettingItemView iuI;

        public C0305a() {
        }
    }
}
