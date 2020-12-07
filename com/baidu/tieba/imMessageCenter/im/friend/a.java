package com.baidu.tieba.imMessageCenter.im.friend;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.BlackListItemData;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes22.dex */
public class a extends BaseAdapter {
    private ArrayList<BlackListItemData> eOt;
    private View.OnClickListener feV = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object tag = view.getTag();
            if (tag != null && (tag instanceof BlackListItemData)) {
                a.this.kGb.a(view, (BlackListItemData) tag);
            }
        }
    };
    private IMBlackListActivity kGb;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(IMBlackListActivity iMBlackListActivity) {
        this.kGb = iMBlackListActivity;
    }

    public void setData(ArrayList<BlackListItemData> arrayList) {
        this.eOt = arrayList;
    }

    public void b(BlackListItemData blackListItemData) {
        if (this.eOt != null) {
            this.eOt.remove(blackListItemData);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eOt != null) {
            return this.eOt.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.eOt != null) {
            return this.eOt.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0788a c0788a;
        BlackListItemData blackListItemData = (BlackListItemData) getItem(i);
        if (blackListItemData != null) {
            c0788a = a(view != null ? view.getTag() : null, blackListItemData);
        } else {
            c0788a = null;
        }
        if (c0788a != null) {
            return c0788a.rootView;
        }
        return null;
    }

    private C0788a daL() {
        C0788a c0788a = new C0788a();
        c0788a.rootView = LayoutInflater.from(this.kGb.getPageContext().getContext()).inflate(R.layout.im_black_list_item, (ViewGroup) null);
        c0788a.kGd = (HeadImageView) c0788a.rootView.findViewById(R.id.header_view);
        c0788a.kGd.setIsRound(true);
        c0788a.hLB = (TextView) c0788a.rootView.findViewById(R.id.user_name);
        c0788a.kGe = (Button) c0788a.rootView.findViewById(R.id.remove_button);
        c0788a.rootView.setTag(c0788a);
        c0788a.kGe.setOnClickListener(this.feV);
        return c0788a;
    }

    private C0788a a(Object obj, BlackListItemData blackListItemData) {
        C0788a c0788a;
        if (obj == null) {
            c0788a = daL();
        } else {
            c0788a = (C0788a) obj;
        }
        a(c0788a, blackListItemData.ZZ());
        c0788a.hLB.setText(blackListItemData.bAh());
        c0788a.kGe.setTag(blackListItemData);
        this.kGb.getLayoutMode().onModeChanged(c0788a.rootView);
        return c0788a;
    }

    private void a(C0788a c0788a, String str) {
        if (str != null) {
            c0788a.kGd.setTag(str);
            c0788a.kGd.startLoad(str, 12, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.imMessageCenter.im.friend.a$a  reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public class C0788a {
        public TextView hLB;
        public HeadImageView kGd;
        public Button kGe;
        public View rootView;

        private C0788a() {
        }
    }
}
