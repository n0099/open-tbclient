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
    private ArrayList<BlackListItemData> acx;
    private View.OnClickListener bDu = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object tag = view.getTag();
            if (tag != null && (tag instanceof BlackListItemData)) {
                a.this.dXh.a(view, (BlackListItemData) tag);
            }
        }
    };
    private IMBlackListActivity dXh;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(IMBlackListActivity iMBlackListActivity) {
        this.dXh = iMBlackListActivity;
    }

    public void setData(ArrayList<BlackListItemData> arrayList) {
        this.acx = arrayList;
    }

    public void b(BlackListItemData blackListItemData) {
        if (this.acx != null) {
            this.acx.remove(blackListItemData);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.acx != null) {
            return this.acx.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.acx != null) {
            return this.acx.get(i);
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

    private C0100a aDR() {
        C0100a c0100a = new C0100a();
        c0100a.rootView = LayoutInflater.from(this.dXh.getPageContext().getContext()).inflate(d.h.im_black_list_item, (ViewGroup) null);
        c0100a.dXj = (HeadImageView) c0100a.rootView.findViewById(d.g.header_view);
        c0100a.dXj.setIsRound(true);
        c0100a.bWx = (TextView) c0100a.rootView.findViewById(d.g.user_name);
        c0100a.dXk = (Button) c0100a.rootView.findViewById(d.g.remove_button);
        c0100a.rootView.setTag(c0100a);
        c0100a.dXk.setOnClickListener(this.bDu);
        return c0100a;
    }

    private C0100a a(Object obj, BlackListItemData blackListItemData) {
        C0100a c0100a;
        if (obj == null) {
            c0100a = aDR();
        } else {
            c0100a = (C0100a) obj;
        }
        a(c0100a, blackListItemData.ayY());
        c0100a.bWx.setText(blackListItemData.getUserName());
        c0100a.dXk.setTag(blackListItemData);
        this.dXh.getLayoutMode().t(c0100a.rootView);
        return c0100a;
    }

    private void a(C0100a c0100a, String str) {
        if (str != null) {
            c0100a.dXj.setTag(str);
            c0100a.dXj.startLoad(str, 12, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.imMessageCenter.im.friend.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0100a {
        public TextView bWx;
        public HeadImageView dXj;
        public Button dXk;
        public View rootView;

        private C0100a() {
        }
    }
}
