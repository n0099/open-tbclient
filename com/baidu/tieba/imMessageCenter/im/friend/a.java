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
    private View.OnClickListener cmW = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object tag = view.getTag();
            if (tag != null && (tag instanceof BlackListItemData)) {
                a.this.eTO.a(view, (BlackListItemData) tag);
            }
        }
    };
    private IMBlackListActivity eTO;
    private ArrayList<BlackListItemData> mData;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(IMBlackListActivity iMBlackListActivity) {
        this.eTO = iMBlackListActivity;
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
        C0219a c0219a;
        BlackListItemData blackListItemData = (BlackListItemData) getItem(i);
        if (blackListItemData != null) {
            c0219a = a(view != null ? view.getTag() : null, blackListItemData);
        } else {
            c0219a = null;
        }
        if (c0219a != null) {
            return c0219a.rootView;
        }
        return null;
    }

    private C0219a aTH() {
        C0219a c0219a = new C0219a();
        c0219a.rootView = LayoutInflater.from(this.eTO.getPageContext().getContext()).inflate(e.h.im_black_list_item, (ViewGroup) null);
        c0219a.eTQ = (HeadImageView) c0219a.rootView.findViewById(e.g.header_view);
        c0219a.eTQ.setIsRound(true);
        c0219a.chf = (TextView) c0219a.rootView.findViewById(e.g.user_name);
        c0219a.eTR = (Button) c0219a.rootView.findViewById(e.g.remove_button);
        c0219a.rootView.setTag(c0219a);
        c0219a.eTR.setOnClickListener(this.cmW);
        return c0219a;
    }

    private C0219a a(Object obj, BlackListItemData blackListItemData) {
        C0219a c0219a;
        if (obj == null) {
            c0219a = aTH();
        } else {
            c0219a = (C0219a) obj;
        }
        a(c0219a, blackListItemData.aOQ());
        c0219a.chf.setText(blackListItemData.IN());
        c0219a.eTR.setTag(blackListItemData);
        this.eTO.getLayoutMode().onModeChanged(c0219a.rootView);
        return c0219a;
    }

    private void a(C0219a c0219a, String str) {
        if (str != null) {
            c0219a.eTQ.setTag(str);
            c0219a.eTQ.startLoad(str, 12, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.imMessageCenter.im.friend.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0219a {
        public TextView chf;
        public HeadImageView eTQ;
        public Button eTR;
        public View rootView;

        private C0219a() {
        }
    }
}
