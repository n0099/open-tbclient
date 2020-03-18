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
    private TbPageContext cVv;
    private ArrayList<OfficialAccountPushInfo> cWf;
    private BdSwitchView.a jWJ;

    public a(TbPageContext tbPageContext) {
        this.cVv = tbPageContext;
    }

    public void setData(ArrayList<OfficialAccountPushInfo> arrayList) {
        this.cWf = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.cWf == null) {
            return 0;
        }
        return this.cWf.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.cWf == null || i < 0 || i >= this.cWf.size()) {
            return null;
        }
        return this.cWf.get(i);
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
        C0603a c0603a;
        if (view == null) {
            view = LayoutInflater.from(this.cVv.getPageActivity()).inflate(R.layout.official_account_push_item, viewGroup, false);
            c0603a = new C0603a();
            c0603a.jWK = (MsgSettingItemView) view.findViewById(R.id.item_official_account_push);
            view.setTag(c0603a);
        } else {
            c0603a = (C0603a) view.getTag();
        }
        OfficialAccountPushInfo officialAccountPushInfo = (OfficialAccountPushInfo) getItem(i);
        if (aq.isEmpty(officialAccountPushInfo.name)) {
            c0603a.jWK.setVisibility(8);
        } else {
            c0603a.jWK.setVisibility(0);
            c0603a.jWK.setText(officialAccountPushInfo.name);
            if (officialAccountPushInfo.is_on == 1) {
                c0603a.jWK.getSwitchView().turnOnNoCallback();
            } else {
                c0603a.jWK.getSwitchView().turnOffNoCallback();
            }
            c0603a.jWK.setLineVisibility(true);
            c0603a.jWK.onChangeSkinType(this.cVv, TbadkCoreApplication.getInst().getSkinType());
            c0603a.jWK.getSwitchView().setOnSwitchStateChangeListener(this);
            c0603a.jWK.getSwitchView().setTag(officialAccountPushInfo);
        }
        return view;
    }

    public void setSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.jWJ = aVar;
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (this.jWJ != null) {
            this.jWJ.a(view, switchState);
        }
    }

    /* renamed from: com.baidu.tieba.setting.officialAccountPush.a$a  reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public class C0603a {
        MsgSettingItemView jWK;

        public C0603a() {
        }
    }
}
