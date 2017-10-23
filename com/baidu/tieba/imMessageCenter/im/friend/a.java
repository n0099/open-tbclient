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
    private ArrayList<BlackListItemData> abD;
    private View.OnClickListener cKh = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object tag = view.getTag();
            if (tag != null && (tag instanceof BlackListItemData)) {
                a.this.dHz.a(view, (BlackListItemData) tag);
            }
        }
    };
    private IMBlackListActivity dHz;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(IMBlackListActivity iMBlackListActivity) {
        this.dHz = iMBlackListActivity;
    }

    public void setData(ArrayList<BlackListItemData> arrayList) {
        this.abD = arrayList;
    }

    public void b(BlackListItemData blackListItemData) {
        if (this.abD != null) {
            this.abD.remove(blackListItemData);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.abD != null) {
            return this.abD.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.abD != null) {
            return this.abD.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0101a c0101a;
        BlackListItemData blackListItemData = (BlackListItemData) getItem(i);
        if (blackListItemData != null) {
            c0101a = a(view != null ? view.getTag() : null, blackListItemData);
        } else {
            c0101a = null;
        }
        if (c0101a != null) {
            return c0101a.rootView;
        }
        return null;
    }

    private C0101a azS() {
        C0101a c0101a = new C0101a();
        c0101a.rootView = LayoutInflater.from(this.dHz.getPageContext().getContext()).inflate(d.j.im_black_list_item, (ViewGroup) null);
        c0101a.dHB = (HeadImageView) c0101a.rootView.findViewById(d.h.header_view);
        c0101a.dHB.setIsRound(true);
        c0101a.bHb = (TextView) c0101a.rootView.findViewById(d.h.user_name);
        c0101a.dHC = (Button) c0101a.rootView.findViewById(d.h.remove_button);
        c0101a.rootView.setTag(c0101a);
        c0101a.dHC.setOnClickListener(this.cKh);
        return c0101a;
    }

    private C0101a a(Object obj, BlackListItemData blackListItemData) {
        C0101a c0101a;
        if (obj == null) {
            c0101a = azS();
        } else {
            c0101a = (C0101a) obj;
        }
        a(c0101a, blackListItemData.auM());
        c0101a.bHb.setText(blackListItemData.getUserName());
        c0101a.dHC.setTag(blackListItemData);
        this.dHz.getLayoutMode().t(c0101a.rootView);
        return c0101a;
    }

    private void a(C0101a c0101a, String str) {
        if (str != null) {
            c0101a.dHB.setTag(str);
            c0101a.dHB.c(str, 12, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.imMessageCenter.im.friend.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0101a {
        public TextView bHb;
        public HeadImageView dHB;
        public Button dHC;
        public View rootView;

        private C0101a() {
        }
    }
}
