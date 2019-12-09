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
    private ArrayList<OfficialAccountPushInfo> bbH;
    private TbPageContext ceu;
    private BdSwitchView.a iVU;

    public a(TbPageContext tbPageContext) {
        this.ceu = tbPageContext;
    }

    public void setData(ArrayList<OfficialAccountPushInfo> arrayList) {
        this.bbH = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bbH == null) {
            return 0;
        }
        return this.bbH.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.bbH == null || i < 0 || i >= this.bbH.size()) {
            return null;
        }
        return this.bbH.get(i);
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
        C0506a c0506a;
        if (view == null) {
            view = LayoutInflater.from(this.ceu.getPageActivity()).inflate(R.layout.official_account_push_item, viewGroup, false);
            c0506a = new C0506a();
            c0506a.iVV = (MsgSettingItemView) view.findViewById(R.id.item_official_account_push);
            view.setTag(c0506a);
        } else {
            c0506a = (C0506a) view.getTag();
        }
        OfficialAccountPushInfo officialAccountPushInfo = (OfficialAccountPushInfo) getItem(i);
        if (aq.isEmpty(officialAccountPushInfo.name)) {
            c0506a.iVV.setVisibility(8);
        } else {
            c0506a.iVV.setVisibility(0);
            c0506a.iVV.setText(officialAccountPushInfo.name);
            if (officialAccountPushInfo.iVX == 1) {
                c0506a.iVV.getSwitchView().turnOnNoCallback();
            } else {
                c0506a.iVV.getSwitchView().turnOffNoCallback();
            }
            c0506a.iVV.setLineVisibility(true);
            c0506a.iVV.onChangeSkinType(this.ceu, TbadkCoreApplication.getInst().getSkinType());
            c0506a.iVV.getSwitchView().setOnSwitchStateChangeListener(this);
            c0506a.iVV.getSwitchView().setTag(officialAccountPushInfo);
        }
        return view;
    }

    public void setSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.iVU = aVar;
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (this.iVU != null) {
            this.iVU.a(view, switchState);
        }
    }

    /* renamed from: com.baidu.tieba.setting.officialAccountPush.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0506a {
        MsgSettingItemView iVV;

        public C0506a() {
        }
    }
}
