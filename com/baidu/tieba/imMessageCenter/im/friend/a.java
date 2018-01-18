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
    private ArrayList<BlackListItemData> aQG;
    private View.OnClickListener csc = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object tag = view.getTag();
            if (tag != null && (tag instanceof BlackListItemData)) {
                a.this.eLT.a(view, (BlackListItemData) tag);
            }
        }
    };
    private IMBlackListActivity eLT;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(IMBlackListActivity iMBlackListActivity) {
        this.eLT = iMBlackListActivity;
    }

    public void setData(ArrayList<BlackListItemData> arrayList) {
        this.aQG = arrayList;
    }

    public void b(BlackListItemData blackListItemData) {
        if (this.aQG != null) {
            this.aQG.remove(blackListItemData);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aQG != null) {
            return this.aQG.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aQG != null) {
            return this.aQG.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0125a c0125a;
        BlackListItemData blackListItemData = (BlackListItemData) getItem(i);
        if (blackListItemData != null) {
            c0125a = a(view != null ? view.getTag() : null, blackListItemData);
        } else {
            c0125a = null;
        }
        if (c0125a != null) {
            return c0125a.rootView;
        }
        return null;
    }

    private C0125a aLg() {
        C0125a c0125a = new C0125a();
        c0125a.rootView = LayoutInflater.from(this.eLT.getPageContext().getContext()).inflate(d.h.im_black_list_item, (ViewGroup) null);
        c0125a.eLV = (HeadImageView) c0125a.rootView.findViewById(d.g.header_view);
        c0125a.eLV.setIsRound(true);
        c0125a.cPN = (TextView) c0125a.rootView.findViewById(d.g.user_name);
        c0125a.eLW = (Button) c0125a.rootView.findViewById(d.g.remove_button);
        c0125a.rootView.setTag(c0125a);
        c0125a.eLW.setOnClickListener(this.csc);
        return c0125a;
    }

    private C0125a a(Object obj, BlackListItemData blackListItemData) {
        C0125a c0125a;
        if (obj == null) {
            c0125a = aLg();
        } else {
            c0125a = (C0125a) obj;
        }
        a(c0125a, blackListItemData.aGn());
        c0125a.cPN.setText(blackListItemData.getUserName());
        c0125a.eLW.setTag(blackListItemData);
        this.eLT.getLayoutMode().aM(c0125a.rootView);
        return c0125a;
    }

    private void a(C0125a c0125a, String str) {
        if (str != null) {
            c0125a.eLV.setTag(str);
            c0125a.eLV.startLoad(str, 12, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.imMessageCenter.im.friend.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0125a {
        public TextView cPN;
        public HeadImageView eLV;
        public Button eLW;
        public View rootView;

        private C0125a() {
        }
    }
}
