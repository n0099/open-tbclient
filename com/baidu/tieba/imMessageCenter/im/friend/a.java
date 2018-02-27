package com.baidu.tieba.imMessageCenter.im.friend;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.im.data.BlackListItemData;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class a extends BaseAdapter {
    private ArrayList<BlackListItemData> aRX;
    private View.OnClickListener cwi = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object tag = view.getTag();
            if (tag != null && (tag instanceof BlackListItemData)) {
                a.this.eQl.a(view, (BlackListItemData) tag);
            }
        }
    };
    private IMBlackListActivity eQl;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(IMBlackListActivity iMBlackListActivity) {
        this.eQl = iMBlackListActivity;
    }

    public void setData(ArrayList<BlackListItemData> arrayList) {
        this.aRX = arrayList;
    }

    public void b(BlackListItemData blackListItemData) {
        if (this.aRX != null) {
            this.aRX.remove(blackListItemData);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aRX != null) {
            return this.aRX.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aRX != null) {
            return this.aRX.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0183a c0183a;
        BlackListItemData blackListItemData = (BlackListItemData) getItem(i);
        if (blackListItemData != null) {
            c0183a = a(view != null ? view.getTag() : null, blackListItemData);
        } else {
            c0183a = null;
        }
        if (c0183a != null) {
            return c0183a.rootView;
        }
        return null;
    }

    private C0183a aMM() {
        C0183a c0183a = new C0183a();
        c0183a.rootView = LayoutInflater.from(this.eQl.getPageContext().getContext()).inflate(d.h.im_black_list_item, (ViewGroup) null);
        c0183a.eQn = (HeadImageView) c0183a.rootView.findViewById(d.g.header_view);
        c0183a.eQn.setIsRound(true);
        c0183a.cqi = (TextView) c0183a.rootView.findViewById(d.g.user_name);
        c0183a.eQo = (Button) c0183a.rootView.findViewById(d.g.remove_button);
        c0183a.rootView.setTag(c0183a);
        c0183a.eQo.setOnClickListener(this.cwi);
        return c0183a;
    }

    private C0183a a(Object obj, BlackListItemData blackListItemData) {
        C0183a c0183a;
        if (obj == null) {
            c0183a = aMM();
        } else {
            c0183a = (C0183a) obj;
        }
        a(c0183a, blackListItemData.aHO());
        c0183a.cqi.setText(blackListItemData.getUserName());
        c0183a.eQo.setTag(blackListItemData);
        this.eQl.getLayoutMode().aM(c0183a.rootView);
        return c0183a;
    }

    private void a(C0183a c0183a, String str) {
        if (str != null) {
            c0183a.eQn.setTag(str);
            c0183a.eQn.startLoad(str, 12, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.imMessageCenter.im.friend.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0183a {
        public TextView cqi;
        public HeadImageView eQn;
        public Button eQo;
        public View rootView;

        private C0183a() {
        }
    }
}
