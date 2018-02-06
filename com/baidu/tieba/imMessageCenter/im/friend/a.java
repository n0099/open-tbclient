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
    private ArrayList<BlackListItemData> aSi;
    private View.OnClickListener cwu = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object tag = view.getTag();
            if (tag != null && (tag instanceof BlackListItemData)) {
                a.this.eQx.a(view, (BlackListItemData) tag);
            }
        }
    };
    private IMBlackListActivity eQx;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(IMBlackListActivity iMBlackListActivity) {
        this.eQx = iMBlackListActivity;
    }

    public void setData(ArrayList<BlackListItemData> arrayList) {
        this.aSi = arrayList;
    }

    public void b(BlackListItemData blackListItemData) {
        if (this.aSi != null) {
            this.aSi.remove(blackListItemData);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aSi != null) {
            return this.aSi.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aSi != null) {
            return this.aSi.get(i);
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

    private C0182a aMN() {
        C0182a c0182a = new C0182a();
        c0182a.rootView = LayoutInflater.from(this.eQx.getPageContext().getContext()).inflate(d.h.im_black_list_item, (ViewGroup) null);
        c0182a.eQz = (HeadImageView) c0182a.rootView.findViewById(d.g.header_view);
        c0182a.eQz.setIsRound(true);
        c0182a.cqu = (TextView) c0182a.rootView.findViewById(d.g.user_name);
        c0182a.eQA = (Button) c0182a.rootView.findViewById(d.g.remove_button);
        c0182a.rootView.setTag(c0182a);
        c0182a.eQA.setOnClickListener(this.cwu);
        return c0182a;
    }

    private C0182a a(Object obj, BlackListItemData blackListItemData) {
        C0182a c0182a;
        if (obj == null) {
            c0182a = aMN();
        } else {
            c0182a = (C0182a) obj;
        }
        a(c0182a, blackListItemData.aHP());
        c0182a.cqu.setText(blackListItemData.getUserName());
        c0182a.eQA.setTag(blackListItemData);
        this.eQx.getLayoutMode().aM(c0182a.rootView);
        return c0182a;
    }

    private void a(C0182a c0182a, String str) {
        if (str != null) {
            c0182a.eQz.setTag(str);
            c0182a.eQz.startLoad(str, 12, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.imMessageCenter.im.friend.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0182a {
        public TextView cqu;
        public Button eQA;
        public HeadImageView eQz;
        public View rootView;

        private C0182a() {
        }
    }
}
