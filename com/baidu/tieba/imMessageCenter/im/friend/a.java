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
    private ArrayList<BlackListItemData> acc;
    private View.OnClickListener bwS = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object tag = view.getTag();
            if (tag != null && (tag instanceof BlackListItemData)) {
                a.this.dPs.a(view, (BlackListItemData) tag);
            }
        }
    };
    private IMBlackListActivity dPs;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(IMBlackListActivity iMBlackListActivity) {
        this.dPs = iMBlackListActivity;
    }

    public void setData(ArrayList<BlackListItemData> arrayList) {
        this.acc = arrayList;
    }

    public void b(BlackListItemData blackListItemData) {
        if (this.acc != null) {
            this.acc.remove(blackListItemData);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.acc != null) {
            return this.acc.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.acc != null) {
            return this.acc.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0099a c0099a;
        BlackListItemData blackListItemData = (BlackListItemData) getItem(i);
        if (blackListItemData != null) {
            c0099a = a(view != null ? view.getTag() : null, blackListItemData);
        } else {
            c0099a = null;
        }
        if (c0099a != null) {
            return c0099a.rootView;
        }
        return null;
    }

    private C0099a aCr() {
        C0099a c0099a = new C0099a();
        c0099a.rootView = LayoutInflater.from(this.dPs.getPageContext().getContext()).inflate(d.h.im_black_list_item, (ViewGroup) null);
        c0099a.dPu = (HeadImageView) c0099a.rootView.findViewById(d.g.header_view);
        c0099a.dPu.setIsRound(true);
        c0099a.bOy = (TextView) c0099a.rootView.findViewById(d.g.user_name);
        c0099a.dPv = (Button) c0099a.rootView.findViewById(d.g.remove_button);
        c0099a.rootView.setTag(c0099a);
        c0099a.dPv.setOnClickListener(this.bwS);
        return c0099a;
    }

    private C0099a a(Object obj, BlackListItemData blackListItemData) {
        C0099a c0099a;
        if (obj == null) {
            c0099a = aCr();
        } else {
            c0099a = (C0099a) obj;
        }
        a(c0099a, blackListItemData.axy());
        c0099a.bOy.setText(blackListItemData.getUserName());
        c0099a.dPv.setTag(blackListItemData);
        this.dPs.getLayoutMode().t(c0099a.rootView);
        return c0099a;
    }

    private void a(C0099a c0099a, String str) {
        if (str != null) {
            c0099a.dPu.setTag(str);
            c0099a.dPu.startLoad(str, 12, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.imMessageCenter.im.friend.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0099a {
        public TextView bOy;
        public HeadImageView dPu;
        public Button dPv;
        public View rootView;

        private C0099a() {
        }
    }
}
