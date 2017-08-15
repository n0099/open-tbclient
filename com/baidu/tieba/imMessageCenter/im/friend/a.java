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
    private ArrayList<BlackListItemData> acH;
    private View.OnClickListener cCt = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object tag = view.getTag();
            if (tag != null && (tag instanceof BlackListItemData)) {
                a.this.dDZ.a(view, (BlackListItemData) tag);
            }
        }
    };
    private IMBlackListActivity dDZ;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(IMBlackListActivity iMBlackListActivity) {
        this.dDZ = iMBlackListActivity;
    }

    public void setData(ArrayList<BlackListItemData> arrayList) {
        this.acH = arrayList;
    }

    public void b(BlackListItemData blackListItemData) {
        if (this.acH != null) {
            this.acH.remove(blackListItemData);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.acH != null) {
            return this.acH.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.acH != null) {
            return this.acH.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0100a c0100a;
        BlackListItemData blackListItemData = (BlackListItemData) getItem(i);
        if (blackListItemData != null) {
            c0100a = a(view != null ? view.getTag() : null, blackListItemData);
        } else {
            c0100a = null;
        }
        if (c0100a != null) {
            return c0100a.rootView;
        }
        return null;
    }

    private C0100a azr() {
        C0100a c0100a = new C0100a();
        c0100a.rootView = LayoutInflater.from(this.dDZ.getPageContext().getContext()).inflate(d.j.im_black_list_item, (ViewGroup) null);
        c0100a.dEb = (HeadImageView) c0100a.rootView.findViewById(d.h.header_view);
        c0100a.dEb.setIsRound(true);
        c0100a.bHa = (TextView) c0100a.rootView.findViewById(d.h.user_name);
        c0100a.dEc = (Button) c0100a.rootView.findViewById(d.h.remove_button);
        c0100a.rootView.setTag(c0100a);
        c0100a.dEc.setOnClickListener(this.cCt);
        return c0100a;
    }

    private C0100a a(Object obj, BlackListItemData blackListItemData) {
        C0100a c0100a;
        if (obj == null) {
            c0100a = azr();
        } else {
            c0100a = (C0100a) obj;
        }
        a(c0100a, blackListItemData.auo());
        c0100a.bHa.setText(blackListItemData.getUserName());
        c0100a.dEc.setTag(blackListItemData);
        this.dDZ.getLayoutMode().t(c0100a.rootView);
        return c0100a;
    }

    private void a(C0100a c0100a, String str) {
        if (str != null) {
            c0100a.dEb.setTag(str);
            c0100a.dEb.c(str, 12, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.imMessageCenter.im.friend.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0100a {
        public TextView bHa;
        public HeadImageView dEb;
        public Button dEc;
        public View rootView;

        private C0100a() {
        }
    }
}
