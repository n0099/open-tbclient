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
    private TbPageContext duG;
    private ArrayList<OfficialAccountPushInfo> dvq;
    private BdSwitchView.a kFS;

    public a(TbPageContext tbPageContext) {
        this.duG = tbPageContext;
    }

    public void setData(ArrayList<OfficialAccountPushInfo> arrayList) {
        this.dvq = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.dvq == null) {
            return 0;
        }
        return this.dvq.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.dvq == null || i < 0 || i >= this.dvq.size()) {
            return null;
        }
        return this.dvq.get(i);
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
        C0643a c0643a;
        if (view == null) {
            view = LayoutInflater.from(this.duG.getPageActivity()).inflate(R.layout.official_account_push_item, viewGroup, false);
            c0643a = new C0643a();
            c0643a.kFT = (MsgSettingItemView) view.findViewById(R.id.item_official_account_push);
            view.setTag(c0643a);
        } else {
            c0643a = (C0643a) view.getTag();
        }
        OfficialAccountPushInfo officialAccountPushInfo = (OfficialAccountPushInfo) getItem(i);
        if (aq.isEmpty(officialAccountPushInfo.name)) {
            c0643a.kFT.setVisibility(8);
        } else {
            c0643a.kFT.setVisibility(0);
            c0643a.kFT.setText(officialAccountPushInfo.name);
            if (officialAccountPushInfo.is_on == 1) {
                c0643a.kFT.getSwitchView().turnOnNoCallback();
            } else {
                c0643a.kFT.getSwitchView().turnOffNoCallback();
            }
            c0643a.kFT.setLineVisibility(true);
            c0643a.kFT.onChangeSkinType(this.duG, TbadkCoreApplication.getInst().getSkinType());
            c0643a.kFT.getSwitchView().setOnSwitchStateChangeListener(this);
            c0643a.kFT.getSwitchView().setTag(officialAccountPushInfo);
        }
        return view;
    }

    public void setSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.kFS = aVar;
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (this.kFS != null) {
            this.kFS.a(view, switchState);
        }
    }

    /* renamed from: com.baidu.tieba.setting.officialAccountPush.a$a  reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public class C0643a {
        MsgSettingItemView kFT;

        public C0643a() {
        }
    }
}
