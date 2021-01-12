package com.baidu.tieba.setting.officialAccountPush;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.R;
import com.baidu.tieba.setting.more.MsgSettingItemView;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class a extends BaseAdapter implements BdSwitchView.a {
    private TbPageContext eSJ;
    private ArrayList<OfficialAccountPushInfo> eTF;
    private BdSwitchView.a mZo;

    public a(TbPageContext tbPageContext) {
        this.eSJ = tbPageContext;
    }

    public void setData(ArrayList<OfficialAccountPushInfo> arrayList) {
        this.eTF = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eTF == null) {
            return 0;
        }
        return this.eTF.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.eTF == null || i < 0 || i >= this.eTF.size()) {
            return null;
        }
        return this.eTF.get(i);
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
        C0859a c0859a;
        if (view == null) {
            view = LayoutInflater.from(this.eSJ.getPageActivity()).inflate(R.layout.official_account_push_item, viewGroup, false);
            c0859a = new C0859a();
            c0859a.mZp = (MsgSettingItemView) view.findViewById(R.id.item_official_account_push);
            view.setTag(c0859a);
        } else {
            c0859a = (C0859a) view.getTag();
        }
        OfficialAccountPushInfo officialAccountPushInfo = (OfficialAccountPushInfo) getItem(i);
        if (at.isEmpty(officialAccountPushInfo.name)) {
            c0859a.mZp.setVisibility(8);
        } else {
            c0859a.mZp.setVisibility(0);
            c0859a.mZp.setText(officialAccountPushInfo.name);
            if (officialAccountPushInfo.is_on == 1) {
                c0859a.mZp.getSwitchView().turnOnNoCallback();
            } else {
                c0859a.mZp.getSwitchView().turnOffNoCallback();
            }
            c0859a.mZp.setLineVisibility(true);
            c0859a.mZp.onChangeSkinType(this.eSJ, TbadkCoreApplication.getInst().getSkinType());
            c0859a.mZp.getSwitchView().setOnSwitchStateChangeListener(this);
            c0859a.mZp.getSwitchView().setTag(officialAccountPushInfo);
        }
        return view;
    }

    public void setSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.mZo = aVar;
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (this.mZo != null) {
            this.mZo.a(view, switchState);
        }
    }

    /* renamed from: com.baidu.tieba.setting.officialAccountPush.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0859a {
        MsgSettingItemView mZp;

        public C0859a() {
        }
    }
}
