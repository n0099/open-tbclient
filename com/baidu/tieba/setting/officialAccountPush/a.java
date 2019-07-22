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
    private BdSwitchView.a ema;
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
        C0399a c0399a;
        if (view == null) {
            view = LayoutInflater.from(this.mContext.getPageActivity()).inflate(R.layout.official_account_push_item, viewGroup, false);
            c0399a = new C0399a();
            c0399a.iTy = (MsgSettingItemView) view.findViewById(R.id.item_official_account_push);
            view.setTag(c0399a);
        } else {
            c0399a = (C0399a) view.getTag();
        }
        OfficialAccountPushInfo officialAccountPushInfo = (OfficialAccountPushInfo) getItem(i);
        if (aq.isEmpty(officialAccountPushInfo.name)) {
            c0399a.iTy.setVisibility(8);
        } else {
            c0399a.iTy.setVisibility(0);
            c0399a.iTy.setText(officialAccountPushInfo.name);
            if (officialAccountPushInfo.iTA == 1) {
                c0399a.iTy.getSwitchView().nk();
            } else {
                c0399a.iTy.getSwitchView().nl();
            }
            c0399a.iTy.setLineVisibility(true);
            c0399a.iTy.onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
            c0399a.iTy.getSwitchView().setOnSwitchStateChangeListener(this);
            c0399a.iTy.getSwitchView().setTag(officialAccountPushInfo);
        }
        return view;
    }

    public void setSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.ema = aVar;
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (this.ema != null) {
            this.ema.a(view, switchState);
        }
    }

    /* renamed from: com.baidu.tieba.setting.officialAccountPush.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0399a {
        MsgSettingItemView iTy;

        public C0399a() {
        }
    }
}
