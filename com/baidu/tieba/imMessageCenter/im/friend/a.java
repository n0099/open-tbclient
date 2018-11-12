package com.baidu.tieba.imMessageCenter.im.friend;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.e;
import com.baidu.tieba.im.data.BlackListItemData;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class a extends BaseAdapter {
    private View.OnClickListener cnl = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object tag = view.getTag();
            if (tag != null && (tag instanceof BlackListItemData)) {
                a.this.eVh.a(view, (BlackListItemData) tag);
            }
        }
    };
    private IMBlackListActivity eVh;
    private ArrayList<BlackListItemData> mData;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(IMBlackListActivity iMBlackListActivity) {
        this.eVh = iMBlackListActivity;
    }

    public void setData(ArrayList<BlackListItemData> arrayList) {
        this.mData = arrayList;
    }

    public void b(BlackListItemData blackListItemData) {
        if (this.mData != null) {
            this.mData.remove(blackListItemData);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.mData != null) {
            return this.mData.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.mData != null) {
            return this.mData.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0245a c0245a;
        BlackListItemData blackListItemData = (BlackListItemData) getItem(i);
        if (blackListItemData != null) {
            c0245a = a(view != null ? view.getTag() : null, blackListItemData);
        } else {
            c0245a = null;
        }
        if (c0245a != null) {
            return c0245a.rootView;
        }
        return null;
    }

    private C0245a aTe() {
        C0245a c0245a = new C0245a();
        c0245a.rootView = LayoutInflater.from(this.eVh.getPageContext().getContext()).inflate(e.h.im_black_list_item, (ViewGroup) null);
        c0245a.eVj = (HeadImageView) c0245a.rootView.findViewById(e.g.header_view);
        c0245a.eVj.setIsRound(true);
        c0245a.chp = (TextView) c0245a.rootView.findViewById(e.g.user_name);
        c0245a.eVk = (Button) c0245a.rootView.findViewById(e.g.remove_button);
        c0245a.rootView.setTag(c0245a);
        c0245a.eVk.setOnClickListener(this.cnl);
        return c0245a;
    }

    private C0245a a(Object obj, BlackListItemData blackListItemData) {
        C0245a c0245a;
        if (obj == null) {
            c0245a = aTe();
        } else {
            c0245a = (C0245a) obj;
        }
        a(c0245a, blackListItemData.aOn());
        c0245a.chp.setText(blackListItemData.IZ());
        c0245a.eVk.setTag(blackListItemData);
        this.eVh.getLayoutMode().onModeChanged(c0245a.rootView);
        return c0245a;
    }

    private void a(C0245a c0245a, String str) {
        if (str != null) {
            c0245a.eVj.setTag(str);
            c0245a.eVj.startLoad(str, 12, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.imMessageCenter.im.friend.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0245a {
        public TextView chp;
        public HeadImageView eVj;
        public Button eVk;
        public View rootView;

        private C0245a() {
        }
    }
}
