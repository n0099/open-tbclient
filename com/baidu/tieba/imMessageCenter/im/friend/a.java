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
    private ArrayList<BlackListItemData> acr;
    private View.OnClickListener bDy = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object tag = view.getTag();
            if (tag != null && (tag instanceof BlackListItemData)) {
                a.this.dYm.a(view, (BlackListItemData) tag);
            }
        }
    };
    private IMBlackListActivity dYm;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(IMBlackListActivity iMBlackListActivity) {
        this.dYm = iMBlackListActivity;
    }

    public void setData(ArrayList<BlackListItemData> arrayList) {
        this.acr = arrayList;
    }

    public void b(BlackListItemData blackListItemData) {
        if (this.acr != null) {
            this.acr.remove(blackListItemData);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.acr != null) {
            return this.acr.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.acr != null) {
            return this.acr.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0115a c0115a;
        BlackListItemData blackListItemData = (BlackListItemData) getItem(i);
        if (blackListItemData != null) {
            c0115a = a(view != null ? view.getTag() : null, blackListItemData);
        } else {
            c0115a = null;
        }
        if (c0115a != null) {
            return c0115a.rootView;
        }
        return null;
    }

    private C0115a aEa() {
        C0115a c0115a = new C0115a();
        c0115a.rootView = LayoutInflater.from(this.dYm.getPageContext().getContext()).inflate(d.h.im_black_list_item, (ViewGroup) null);
        c0115a.dYo = (HeadImageView) c0115a.rootView.findViewById(d.g.header_view);
        c0115a.dYo.setIsRound(true);
        c0115a.bWB = (TextView) c0115a.rootView.findViewById(d.g.user_name);
        c0115a.dYp = (Button) c0115a.rootView.findViewById(d.g.remove_button);
        c0115a.rootView.setTag(c0115a);
        c0115a.dYp.setOnClickListener(this.bDy);
        return c0115a;
    }

    private C0115a a(Object obj, BlackListItemData blackListItemData) {
        C0115a c0115a;
        if (obj == null) {
            c0115a = aEa();
        } else {
            c0115a = (C0115a) obj;
        }
        a(c0115a, blackListItemData.azh());
        c0115a.bWB.setText(blackListItemData.getUserName());
        c0115a.dYp.setTag(blackListItemData);
        this.dYm.getLayoutMode().t(c0115a.rootView);
        return c0115a;
    }

    private void a(C0115a c0115a, String str) {
        if (str != null) {
            c0115a.dYo.setTag(str);
            c0115a.dYo.startLoad(str, 12, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.imMessageCenter.im.friend.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0115a {
        public TextView bWB;
        public HeadImageView dYo;
        public Button dYp;
        public View rootView;

        private C0115a() {
        }
    }
}
