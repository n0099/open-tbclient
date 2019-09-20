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
/* loaded from: classes3.dex */
public class a extends BaseAdapter implements BdSwitchView.a {
    private ArrayList<OfficialAccountPushInfo> aIL;
    private BdSwitchView.a enT;
    private TbPageContext mContext;

    public a(TbPageContext tbPageContext) {
        this.mContext = tbPageContext;
    }

    public void setData(ArrayList<OfficialAccountPushInfo> arrayList) {
        this.aIL = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aIL == null) {
            return 0;
        }
        return this.aIL.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aIL == null || i < 0 || i >= this.aIL.size()) {
            return null;
        }
        return this.aIL.get(i);
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
        C0416a c0416a;
        if (view == null) {
            view = LayoutInflater.from(this.mContext.getPageActivity()).inflate(R.layout.official_account_push_item, viewGroup, false);
            c0416a = new C0416a();
            c0416a.iWX = (MsgSettingItemView) view.findViewById(R.id.item_official_account_push);
            view.setTag(c0416a);
        } else {
            c0416a = (C0416a) view.getTag();
        }
        OfficialAccountPushInfo officialAccountPushInfo = (OfficialAccountPushInfo) getItem(i);
        if (aq.isEmpty(officialAccountPushInfo.name)) {
            c0416a.iWX.setVisibility(8);
        } else {
            c0416a.iWX.setVisibility(0);
            c0416a.iWX.setText(officialAccountPushInfo.name);
            if (officialAccountPushInfo.iWZ == 1) {
                c0416a.iWX.getSwitchView().nk();
            } else {
                c0416a.iWX.getSwitchView().nl();
            }
            c0416a.iWX.setLineVisibility(true);
            c0416a.iWX.onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
            c0416a.iWX.getSwitchView().setOnSwitchStateChangeListener(this);
            c0416a.iWX.getSwitchView().setTag(officialAccountPushInfo);
        }
        return view;
    }

    public void setSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.enT = aVar;
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (this.enT != null) {
            this.enT.a(view, switchState);
        }
    }

    /* renamed from: com.baidu.tieba.setting.officialAccountPush.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0416a {
        MsgSettingItemView iWX;

        public C0416a() {
        }
    }
}
