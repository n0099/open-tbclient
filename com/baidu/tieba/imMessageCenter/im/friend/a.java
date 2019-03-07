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
/* loaded from: classes4.dex */
public class a extends BaseAdapter {
    private ArrayList<BlackListItemData> aFH;
    private View.OnClickListener dHs = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object tag = view.getTag();
            if (tag != null && (tag instanceof BlackListItemData)) {
                a.this.gvH.a(view, (BlackListItemData) tag);
            }
        }
    };
    private IMBlackListActivity gvH;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(IMBlackListActivity iMBlackListActivity) {
        this.gvH = iMBlackListActivity;
    }

    public void setData(ArrayList<BlackListItemData> arrayList) {
        this.aFH = arrayList;
    }

    public void b(BlackListItemData blackListItemData) {
        if (this.aFH != null) {
            this.aFH.remove(blackListItemData);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aFH != null) {
            return this.aFH.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aFH != null) {
            return this.aFH.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0261a c0261a;
        BlackListItemData blackListItemData = (BlackListItemData) getItem(i);
        if (blackListItemData != null) {
            c0261a = a(view != null ? view.getTag() : null, blackListItemData);
        } else {
            c0261a = null;
        }
        if (c0261a != null) {
            return c0261a.rootView;
        }
        return null;
    }

    private C0261a bwO() {
        C0261a c0261a = new C0261a();
        c0261a.rootView = LayoutInflater.from(this.gvH.getPageContext().getContext()).inflate(d.h.im_black_list_item, (ViewGroup) null);
        c0261a.gvJ = (HeadImageView) c0261a.rootView.findViewById(d.g.header_view);
        c0261a.gvJ.setIsRound(true);
        c0261a.dBb = (TextView) c0261a.rootView.findViewById(d.g.user_name);
        c0261a.gvK = (Button) c0261a.rootView.findViewById(d.g.remove_button);
        c0261a.rootView.setTag(c0261a);
        c0261a.gvK.setOnClickListener(this.dHs);
        return c0261a;
    }

    private C0261a a(Object obj, BlackListItemData blackListItemData) {
        C0261a c0261a;
        if (obj == null) {
            c0261a = bwO();
        } else {
            c0261a = (C0261a) obj;
        }
        a(c0261a, blackListItemData.brX());
        c0261a.dBb.setText(blackListItemData.ajR());
        c0261a.gvK.setTag(blackListItemData);
        this.gvH.getLayoutMode().onModeChanged(c0261a.rootView);
        return c0261a;
    }

    private void a(C0261a c0261a, String str) {
        if (str != null) {
            c0261a.gvJ.setTag(str);
            c0261a.gvJ.startLoad(str, 12, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.imMessageCenter.im.friend.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0261a {
        public TextView dBb;
        public HeadImageView gvJ;
        public Button gvK;
        public View rootView;

        private C0261a() {
        }
    }
}
