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
    private TbPageContext duK;
    private ArrayList<OfficialAccountPushInfo> dvu;
    private BdSwitchView.a kFW;

    public a(TbPageContext tbPageContext) {
        this.duK = tbPageContext;
    }

    public void setData(ArrayList<OfficialAccountPushInfo> arrayList) {
        this.dvu = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.dvu == null) {
            return 0;
        }
        return this.dvu.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.dvu == null || i < 0 || i >= this.dvu.size()) {
            return null;
        }
        return this.dvu.get(i);
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
        C0664a c0664a;
        if (view == null) {
            view = LayoutInflater.from(this.duK.getPageActivity()).inflate(R.layout.official_account_push_item, viewGroup, false);
            c0664a = new C0664a();
            c0664a.kFX = (MsgSettingItemView) view.findViewById(R.id.item_official_account_push);
            view.setTag(c0664a);
        } else {
            c0664a = (C0664a) view.getTag();
        }
        OfficialAccountPushInfo officialAccountPushInfo = (OfficialAccountPushInfo) getItem(i);
        if (aq.isEmpty(officialAccountPushInfo.name)) {
            c0664a.kFX.setVisibility(8);
        } else {
            c0664a.kFX.setVisibility(0);
            c0664a.kFX.setText(officialAccountPushInfo.name);
            if (officialAccountPushInfo.is_on == 1) {
                c0664a.kFX.getSwitchView().turnOnNoCallback();
            } else {
                c0664a.kFX.getSwitchView().turnOffNoCallback();
            }
            c0664a.kFX.setLineVisibility(true);
            c0664a.kFX.onChangeSkinType(this.duK, TbadkCoreApplication.getInst().getSkinType());
            c0664a.kFX.getSwitchView().setOnSwitchStateChangeListener(this);
            c0664a.kFX.getSwitchView().setTag(officialAccountPushInfo);
        }
        return view;
    }

    public void setSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.kFW = aVar;
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (this.kFW != null) {
            this.kFW.a(view, switchState);
        }
    }

    /* renamed from: com.baidu.tieba.setting.officialAccountPush.a$a  reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public class C0664a {
        MsgSettingItemView kFX;

        public C0664a() {
        }
    }
}
