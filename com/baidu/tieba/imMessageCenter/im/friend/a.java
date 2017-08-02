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
    private ArrayList<BlackListItemData> abi;
    private View.OnClickListener czb = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object tag = view.getTag();
            if (tag != null && (tag instanceof BlackListItemData)) {
                a.this.dAL.a(view, (BlackListItemData) tag);
            }
        }
    };
    private IMBlackListActivity dAL;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(IMBlackListActivity iMBlackListActivity) {
        this.dAL = iMBlackListActivity;
    }

    public void setData(ArrayList<BlackListItemData> arrayList) {
        this.abi = arrayList;
    }

    public void b(BlackListItemData blackListItemData) {
        if (this.abi != null) {
            this.abi.remove(blackListItemData);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.abi != null) {
            return this.abi.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.abi != null) {
            return this.abi.get(i);
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

    private C0100a ayz() {
        C0100a c0100a = new C0100a();
        c0100a.rootView = LayoutInflater.from(this.dAL.getPageContext().getContext()).inflate(d.j.im_black_list_item, (ViewGroup) null);
        c0100a.dAN = (HeadImageView) c0100a.rootView.findViewById(d.h.header_view);
        c0100a.dAN.setIsRound(true);
        c0100a.bFh = (TextView) c0100a.rootView.findViewById(d.h.user_name);
        c0100a.dAO = (Button) c0100a.rootView.findViewById(d.h.remove_button);
        c0100a.rootView.setTag(c0100a);
        c0100a.dAO.setOnClickListener(this.czb);
        return c0100a;
    }

    private C0100a a(Object obj, BlackListItemData blackListItemData) {
        C0100a c0100a;
        if (obj == null) {
            c0100a = ayz();
        } else {
            c0100a = (C0100a) obj;
        }
        a(c0100a, blackListItemData.atv());
        c0100a.bFh.setText(blackListItemData.getUserName());
        c0100a.dAO.setTag(blackListItemData);
        this.dAL.getLayoutMode().t(c0100a.rootView);
        return c0100a;
    }

    private void a(C0100a c0100a, String str) {
        if (str != null) {
            c0100a.dAN.setTag(str);
            c0100a.dAN.c(str, 12, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.imMessageCenter.im.friend.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0100a {
        public TextView bFh;
        public HeadImageView dAN;
        public Button dAO;
        public View rootView;

        private C0100a() {
        }
    }
}
