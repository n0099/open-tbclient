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
    private ArrayList<OfficialAccountPushInfo> cVR;
    private TbPageContext cVh;
    private BdSwitchView.a jUV;

    public a(TbPageContext tbPageContext) {
        this.cVh = tbPageContext;
    }

    public void setData(ArrayList<OfficialAccountPushInfo> arrayList) {
        this.cVR = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.cVR == null) {
            return 0;
        }
        return this.cVR.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.cVR == null || i < 0 || i >= this.cVR.size()) {
            return null;
        }
        return this.cVR.get(i);
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
        C0602a c0602a;
        if (view == null) {
            view = LayoutInflater.from(this.cVh.getPageActivity()).inflate(R.layout.official_account_push_item, viewGroup, false);
            c0602a = new C0602a();
            c0602a.jUW = (MsgSettingItemView) view.findViewById(R.id.item_official_account_push);
            view.setTag(c0602a);
        } else {
            c0602a = (C0602a) view.getTag();
        }
        OfficialAccountPushInfo officialAccountPushInfo = (OfficialAccountPushInfo) getItem(i);
        if (aq.isEmpty(officialAccountPushInfo.name)) {
            c0602a.jUW.setVisibility(8);
        } else {
            c0602a.jUW.setVisibility(0);
            c0602a.jUW.setText(officialAccountPushInfo.name);
            if (officialAccountPushInfo.is_on == 1) {
                c0602a.jUW.getSwitchView().turnOnNoCallback();
            } else {
                c0602a.jUW.getSwitchView().turnOffNoCallback();
            }
            c0602a.jUW.setLineVisibility(true);
            c0602a.jUW.onChangeSkinType(this.cVh, TbadkCoreApplication.getInst().getSkinType());
            c0602a.jUW.getSwitchView().setOnSwitchStateChangeListener(this);
            c0602a.jUW.getSwitchView().setTag(officialAccountPushInfo);
        }
        return view;
    }

    public void setSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.jUV = aVar;
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (this.jUV != null) {
            this.jUV.a(view, switchState);
        }
    }

    /* renamed from: com.baidu.tieba.setting.officialAccountPush.a$a  reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public class C0602a {
        MsgSettingItemView jUW;

        public C0602a() {
        }
    }
}
