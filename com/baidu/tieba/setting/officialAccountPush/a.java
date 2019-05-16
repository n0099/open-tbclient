package com.baidu.tieba.setting.officialAccountPush;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import com.baidu.tieba.setting.more.MsgSettingItemView;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class a extends BaseAdapter implements BdSwitchView.a {
    private ArrayList<OfficialAccountPushInfo> aHF;
    private BdSwitchView.a ehv;
    private TbPageContext mContext;

    public a(TbPageContext tbPageContext) {
        this.mContext = tbPageContext;
    }

    public void setData(ArrayList<OfficialAccountPushInfo> arrayList) {
        this.aHF = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aHF == null) {
            return 0;
        }
        return this.aHF.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aHF == null || i < 0 || i >= this.aHF.size()) {
            return null;
        }
        return this.aHF.get(i);
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
        C0400a c0400a;
        if (view == null) {
            view = LayoutInflater.from(this.mContext.getPageActivity()).inflate(R.layout.official_account_push_item, viewGroup, false);
            c0400a = new C0400a();
            c0400a.iNa = (MsgSettingItemView) view.findViewById(R.id.item_official_account_push);
            view.setTag(c0400a);
        } else {
            c0400a = (C0400a) view.getTag();
        }
        OfficialAccountPushInfo officialAccountPushInfo = (OfficialAccountPushInfo) getItem(i);
        if (ap.isEmpty(officialAccountPushInfo.name)) {
            c0400a.iNa.setVisibility(8);
        } else {
            c0400a.iNa.setVisibility(0);
            c0400a.iNa.setText(officialAccountPushInfo.name);
            if (officialAccountPushInfo.iNc == 1) {
                c0400a.iNa.getSwitchView().mT();
            } else {
                c0400a.iNa.getSwitchView().mU();
            }
            c0400a.iNa.setLineVisibility(true);
            c0400a.iNa.onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
            c0400a.iNa.getSwitchView().setOnSwitchStateChangeListener(this);
            c0400a.iNa.getSwitchView().setTag(officialAccountPushInfo);
        }
        return view;
    }

    public void setSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.ehv = aVar;
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (this.ehv != null) {
            this.ehv.a(view, switchState);
        }
    }

    /* renamed from: com.baidu.tieba.setting.officialAccountPush.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0400a {
        MsgSettingItemView iNa;

        public C0400a() {
        }
    }
}
