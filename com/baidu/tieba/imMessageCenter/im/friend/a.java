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
    private ArrayList<BlackListItemData> aQH;
    private View.OnClickListener crS = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object tag = view.getTag();
            if (tag != null && (tag instanceof BlackListItemData)) {
                a.this.eKt.a(view, (BlackListItemData) tag);
            }
        }
    };
    private IMBlackListActivity eKt;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(IMBlackListActivity iMBlackListActivity) {
        this.eKt = iMBlackListActivity;
    }

    public void setData(ArrayList<BlackListItemData> arrayList) {
        this.aQH = arrayList;
    }

    public void b(BlackListItemData blackListItemData) {
        if (this.aQH != null) {
            this.aQH.remove(blackListItemData);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aQH != null) {
            return this.aQH.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aQH != null) {
            return this.aQH.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0126a c0126a;
        BlackListItemData blackListItemData = (BlackListItemData) getItem(i);
        if (blackListItemData != null) {
            c0126a = a(view != null ? view.getTag() : null, blackListItemData);
        } else {
            c0126a = null;
        }
        if (c0126a != null) {
            return c0126a.rootView;
        }
        return null;
    }

    private C0126a aLb() {
        C0126a c0126a = new C0126a();
        c0126a.rootView = LayoutInflater.from(this.eKt.getPageContext().getContext()).inflate(d.h.im_black_list_item, (ViewGroup) null);
        c0126a.eKv = (HeadImageView) c0126a.rootView.findViewById(d.g.header_view);
        c0126a.eKv.setIsRound(true);
        c0126a.cLm = (TextView) c0126a.rootView.findViewById(d.g.user_name);
        c0126a.eKw = (Button) c0126a.rootView.findViewById(d.g.remove_button);
        c0126a.rootView.setTag(c0126a);
        c0126a.eKw.setOnClickListener(this.crS);
        return c0126a;
    }

    private C0126a a(Object obj, BlackListItemData blackListItemData) {
        C0126a c0126a;
        if (obj == null) {
            c0126a = aLb();
        } else {
            c0126a = (C0126a) obj;
        }
        a(c0126a, blackListItemData.aGi());
        c0126a.cLm.setText(blackListItemData.getUserName());
        c0126a.eKw.setTag(blackListItemData);
        this.eKt.getLayoutMode().aM(c0126a.rootView);
        return c0126a;
    }

    private void a(C0126a c0126a, String str) {
        if (str != null) {
            c0126a.eKv.setTag(str);
            c0126a.eKv.startLoad(str, 12, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.imMessageCenter.im.friend.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0126a {
        public TextView cLm;
        public HeadImageView eKv;
        public Button eKw;
        public View rootView;

        private C0126a() {
        }
    }
}
