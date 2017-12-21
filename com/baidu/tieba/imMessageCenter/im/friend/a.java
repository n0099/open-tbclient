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
    private ArrayList<BlackListItemData> acu;
    private View.OnClickListener bDC = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object tag = view.getTag();
            if (tag != null && (tag instanceof BlackListItemData)) {
                a.this.dYq.a(view, (BlackListItemData) tag);
            }
        }
    };
    private IMBlackListActivity dYq;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(IMBlackListActivity iMBlackListActivity) {
        this.dYq = iMBlackListActivity;
    }

    public void setData(ArrayList<BlackListItemData> arrayList) {
        this.acu = arrayList;
    }

    public void b(BlackListItemData blackListItemData) {
        if (this.acu != null) {
            this.acu.remove(blackListItemData);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.acu != null) {
            return this.acu.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.acu != null) {
            return this.acu.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0114a c0114a;
        BlackListItemData blackListItemData = (BlackListItemData) getItem(i);
        if (blackListItemData != null) {
            c0114a = a(view != null ? view.getTag() : null, blackListItemData);
        } else {
            c0114a = null;
        }
        if (c0114a != null) {
            return c0114a.rootView;
        }
        return null;
    }

    private C0114a aEa() {
        C0114a c0114a = new C0114a();
        c0114a.rootView = LayoutInflater.from(this.dYq.getPageContext().getContext()).inflate(d.h.im_black_list_item, (ViewGroup) null);
        c0114a.dYs = (HeadImageView) c0114a.rootView.findViewById(d.g.header_view);
        c0114a.dYs.setIsRound(true);
        c0114a.bWF = (TextView) c0114a.rootView.findViewById(d.g.user_name);
        c0114a.dYt = (Button) c0114a.rootView.findViewById(d.g.remove_button);
        c0114a.rootView.setTag(c0114a);
        c0114a.dYt.setOnClickListener(this.bDC);
        return c0114a;
    }

    private C0114a a(Object obj, BlackListItemData blackListItemData) {
        C0114a c0114a;
        if (obj == null) {
            c0114a = aEa();
        } else {
            c0114a = (C0114a) obj;
        }
        a(c0114a, blackListItemData.azh());
        c0114a.bWF.setText(blackListItemData.getUserName());
        c0114a.dYt.setTag(blackListItemData);
        this.dYq.getLayoutMode().t(c0114a.rootView);
        return c0114a;
    }

    private void a(C0114a c0114a, String str) {
        if (str != null) {
            c0114a.dYs.setTag(str);
            c0114a.dYs.startLoad(str, 12, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.imMessageCenter.im.friend.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0114a {
        public TextView bWF;
        public HeadImageView dYs;
        public Button dYt;
        public View rootView;

        private C0114a() {
        }
    }
}
