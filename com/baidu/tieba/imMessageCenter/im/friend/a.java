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
    private ArrayList<BlackListItemData> abO;
    private View.OnClickListener cIJ = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object tag = view.getTag();
            if (tag != null && (tag instanceof BlackListItemData)) {
                a.this.dKD.a(view, (BlackListItemData) tag);
            }
        }
    };
    private IMBlackListActivity dKD;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(IMBlackListActivity iMBlackListActivity) {
        this.dKD = iMBlackListActivity;
    }

    public void setData(ArrayList<BlackListItemData> arrayList) {
        this.abO = arrayList;
    }

    public void b(BlackListItemData blackListItemData) {
        if (this.abO != null) {
            this.abO.remove(blackListItemData);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.abO != null) {
            return this.abO.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.abO != null) {
            return this.abO.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0102a c0102a;
        BlackListItemData blackListItemData = (BlackListItemData) getItem(i);
        if (blackListItemData != null) {
            c0102a = a(view != null ? view.getTag() : null, blackListItemData);
        } else {
            c0102a = null;
        }
        if (c0102a != null) {
            return c0102a.rootView;
        }
        return null;
    }

    private C0102a aBb() {
        C0102a c0102a = new C0102a();
        c0102a.rootView = LayoutInflater.from(this.dKD.getPageContext().getContext()).inflate(d.j.im_black_list_item, (ViewGroup) null);
        c0102a.dKF = (HeadImageView) c0102a.rootView.findViewById(d.h.header_view);
        c0102a.dKF.setIsRound(true);
        c0102a.bEL = (TextView) c0102a.rootView.findViewById(d.h.user_name);
        c0102a.dKG = (Button) c0102a.rootView.findViewById(d.h.remove_button);
        c0102a.rootView.setTag(c0102a);
        c0102a.dKG.setOnClickListener(this.cIJ);
        return c0102a;
    }

    private C0102a a(Object obj, BlackListItemData blackListItemData) {
        C0102a c0102a;
        if (obj == null) {
            c0102a = aBb();
        } else {
            c0102a = (C0102a) obj;
        }
        a(c0102a, blackListItemData.avV());
        c0102a.bEL.setText(blackListItemData.getUserName());
        c0102a.dKG.setTag(blackListItemData);
        this.dKD.getLayoutMode().t(c0102a.rootView);
        return c0102a;
    }

    private void a(C0102a c0102a, String str) {
        if (str != null) {
            c0102a.dKF.setTag(str);
            c0102a.dKF.c(str, 12, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.imMessageCenter.im.friend.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0102a {
        public TextView bEL;
        public HeadImageView dKF;
        public Button dKG;
        public View rootView;

        private C0102a() {
        }
    }
}
