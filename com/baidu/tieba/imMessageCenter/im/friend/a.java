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
    private ArrayList<BlackListItemData> alt;
    private View.OnClickListener bVm = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object tag = view.getTag();
            if (tag != null && (tag instanceof BlackListItemData)) {
                a.this.exk.a(view, (BlackListItemData) tag);
            }
        }
    };
    private IMBlackListActivity exk;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(IMBlackListActivity iMBlackListActivity) {
        this.exk = iMBlackListActivity;
    }

    public void setData(ArrayList<BlackListItemData> arrayList) {
        this.alt = arrayList;
    }

    public void b(BlackListItemData blackListItemData) {
        if (this.alt != null) {
            this.alt.remove(blackListItemData);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.alt != null) {
            return this.alt.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.alt != null) {
            return this.alt.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0182a c0182a;
        BlackListItemData blackListItemData = (BlackListItemData) getItem(i);
        if (blackListItemData != null) {
            c0182a = a(view != null ? view.getTag() : null, blackListItemData);
        } else {
            c0182a = null;
        }
        if (c0182a != null) {
            return c0182a.rootView;
        }
        return null;
    }

    private C0182a aMB() {
        C0182a c0182a = new C0182a();
        c0182a.rootView = LayoutInflater.from(this.exk.getPageContext().getContext()).inflate(d.i.im_black_list_item, (ViewGroup) null);
        c0182a.exm = (HeadImageView) c0182a.rootView.findViewById(d.g.header_view);
        c0182a.exm.setIsRound(true);
        c0182a.bPN = (TextView) c0182a.rootView.findViewById(d.g.user_name);
        c0182a.exn = (Button) c0182a.rootView.findViewById(d.g.remove_button);
        c0182a.rootView.setTag(c0182a);
        c0182a.exn.setOnClickListener(this.bVm);
        return c0182a;
    }

    private C0182a a(Object obj, BlackListItemData blackListItemData) {
        C0182a c0182a;
        if (obj == null) {
            c0182a = aMB();
        } else {
            c0182a = (C0182a) obj;
        }
        a(c0182a, blackListItemData.aHH());
        c0182a.bPN.setText(blackListItemData.Fi());
        c0182a.exn.setTag(blackListItemData);
        this.exk.getLayoutMode().onModeChanged(c0182a.rootView);
        return c0182a;
    }

    private void a(C0182a c0182a, String str) {
        if (str != null) {
            c0182a.exm.setTag(str);
            c0182a.exm.startLoad(str, 12, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.imMessageCenter.im.friend.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0182a {
        public TextView bPN;
        public HeadImageView exm;
        public Button exn;
        public View rootView;

        private C0182a() {
        }
    }
}
