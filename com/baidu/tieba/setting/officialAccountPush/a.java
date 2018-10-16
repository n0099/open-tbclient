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
    private BdSwitchView.a cDf;
    private TbPageContext mContext;
    private ArrayList<OfficialAccountPushInfo> mData;

    public a(TbPageContext tbPageContext) {
        this.mContext = tbPageContext;
    }

    public void setData(ArrayList<OfficialAccountPushInfo> arrayList) {
        this.mData = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.mData == null) {
            return 0;
        }
        return this.mData.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.mData == null || i < 0 || i >= this.mData.size()) {
            return null;
        }
        return this.mData.get(i);
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
        C0271a c0271a;
        if (view == null) {
            view = LayoutInflater.from(this.mContext.getPageActivity()).inflate(e.h.official_account_push_item, viewGroup, false);
            c0271a = new C0271a();
            c0271a.gQr = (MsgSettingItemView) view.findViewById(e.g.item_official_account_push);
            view.setTag(c0271a);
        } else {
            c0271a = (C0271a) view.getTag();
        }
        OfficialAccountPushInfo officialAccountPushInfo = (OfficialAccountPushInfo) getItem(i);
        if (ao.isEmpty(officialAccountPushInfo.name)) {
            c0271a.gQr.setVisibility(8);
        } else {
            c0271a.gQr.setVisibility(0);
            c0271a.gQr.setText(officialAccountPushInfo.name);
            if (officialAccountPushInfo.gQt == 1) {
                c0271a.gQr.getSwitchView().nS();
            } else {
                c0271a.gQr.getSwitchView().nT();
            }
            c0271a.gQr.setLineVisibility(true);
            c0271a.gQr.d(this.mContext, TbadkCoreApplication.getInst().getSkinType());
            c0271a.gQr.getSwitchView().setOnSwitchStateChangeListener(this);
            c0271a.gQr.getSwitchView().setTag(officialAccountPushInfo);
        }
        return view;
    }

    public void setSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.cDf = aVar;
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (this.cDf != null) {
            this.cDf.a(view, switchState);
        }
    }

    /* renamed from: com.baidu.tieba.setting.officialAccountPush.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0271a {
        MsgSettingItemView gQr;

        public C0271a() {
        }
    }
}
