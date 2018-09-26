package com.baidu.tieba.setting.officialAccountPush;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.e;
import com.baidu.tieba.setting.more.MsgSettingItemView;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class a extends BaseAdapter implements BdSwitchView.a {
    private ArrayList<OfficialAccountPushInfo> anX;
    private BdSwitchView.a cuC;
    private TbPageContext mContext;

    public a(TbPageContext tbPageContext) {
        this.mContext = tbPageContext;
    }

    public void setData(ArrayList<OfficialAccountPushInfo> arrayList) {
        this.anX = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.anX == null) {
            return 0;
        }
        return this.anX.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.anX == null || i < 0 || i >= this.anX.size()) {
            return null;
        }
        return this.anX.get(i);
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
        C0236a c0236a;
        if (view == null) {
            view = LayoutInflater.from(this.mContext.getPageActivity()).inflate(e.h.official_account_push_item, viewGroup, false);
            c0236a = new C0236a();
            c0236a.gIT = (MsgSettingItemView) view.findViewById(e.g.item_official_account_push);
            view.setTag(c0236a);
        } else {
            c0236a = (C0236a) view.getTag();
        }
        OfficialAccountPushInfo officialAccountPushInfo = (OfficialAccountPushInfo) getItem(i);
        if (ao.isEmpty(officialAccountPushInfo.name)) {
            c0236a.gIT.setVisibility(8);
        } else {
            c0236a.gIT.setVisibility(0);
            c0236a.gIT.setText(officialAccountPushInfo.name);
            if (officialAccountPushInfo.gIV == 1) {
                c0236a.gIT.getSwitchView().nI();
            } else {
                c0236a.gIT.getSwitchView().nJ();
            }
            c0236a.gIT.setLineVisibility(true);
            c0236a.gIT.d(this.mContext, TbadkCoreApplication.getInst().getSkinType());
            c0236a.gIT.getSwitchView().setOnSwitchStateChangeListener(this);
            c0236a.gIT.getSwitchView().setTag(officialAccountPushInfo);
        }
        return view;
    }

    public void setSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.cuC = aVar;
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (this.cuC != null) {
            this.cuC.a(view, switchState);
        }
    }

    /* renamed from: com.baidu.tieba.setting.officialAccountPush.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0236a {
        MsgSettingItemView gIT;

        public C0236a() {
        }
    }
}
