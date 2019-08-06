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
    private ArrayList<OfficialAccountPushInfo> aIn;
    private BdSwitchView.a emh;
    private TbPageContext mContext;

    public a(TbPageContext tbPageContext) {
        this.mContext = tbPageContext;
    }

    public void setData(ArrayList<OfficialAccountPushInfo> arrayList) {
        this.aIn = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aIn == null) {
            return 0;
        }
        return this.aIn.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aIn == null || i < 0 || i >= this.aIn.size()) {
            return null;
        }
        return this.aIn.get(i);
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
        C0405a c0405a;
        if (view == null) {
            view = LayoutInflater.from(this.mContext.getPageActivity()).inflate(R.layout.official_account_push_item, viewGroup, false);
            c0405a = new C0405a();
            c0405a.iUC = (MsgSettingItemView) view.findViewById(R.id.item_official_account_push);
            view.setTag(c0405a);
        } else {
            c0405a = (C0405a) view.getTag();
        }
        OfficialAccountPushInfo officialAccountPushInfo = (OfficialAccountPushInfo) getItem(i);
        if (aq.isEmpty(officialAccountPushInfo.name)) {
            c0405a.iUC.setVisibility(8);
        } else {
            c0405a.iUC.setVisibility(0);
            c0405a.iUC.setText(officialAccountPushInfo.name);
            if (officialAccountPushInfo.iUE == 1) {
                c0405a.iUC.getSwitchView().nk();
            } else {
                c0405a.iUC.getSwitchView().nl();
            }
            c0405a.iUC.setLineVisibility(true);
            c0405a.iUC.onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
            c0405a.iUC.getSwitchView().setOnSwitchStateChangeListener(this);
            c0405a.iUC.getSwitchView().setTag(officialAccountPushInfo);
        }
        return view;
    }

    public void setSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.emh = aVar;
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (this.emh != null) {
            this.emh.a(view, switchState);
        }
    }

    /* renamed from: com.baidu.tieba.setting.officialAccountPush.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0405a {
        MsgSettingItemView iUC;

        public C0405a() {
        }
    }
}
