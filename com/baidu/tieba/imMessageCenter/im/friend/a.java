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
    private ArrayList<BlackListItemData> aFL;
    private View.OnClickListener dGE = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object tag = view.getTag();
            if (tag != null && (tag instanceof BlackListItemData)) {
                a.this.gvu.a(view, (BlackListItemData) tag);
            }
        }
    };
    private IMBlackListActivity gvu;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(IMBlackListActivity iMBlackListActivity) {
        this.gvu = iMBlackListActivity;
    }

    public void setData(ArrayList<BlackListItemData> arrayList) {
        this.aFL = arrayList;
    }

    public void b(BlackListItemData blackListItemData) {
        if (this.aFL != null) {
            this.aFL.remove(blackListItemData);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aFL != null) {
            return this.aFL.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aFL != null) {
            return this.aFL.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0324a c0324a;
        BlackListItemData blackListItemData = (BlackListItemData) getItem(i);
        if (blackListItemData != null) {
            c0324a = a(view != null ? view.getTag() : null, blackListItemData);
        } else {
            c0324a = null;
        }
        if (c0324a != null) {
            return c0324a.rootView;
        }
        return null;
    }

    private C0324a bwL() {
        C0324a c0324a = new C0324a();
        c0324a.rootView = LayoutInflater.from(this.gvu.getPageContext().getContext()).inflate(d.h.im_black_list_item, (ViewGroup) null);
        c0324a.gvw = (HeadImageView) c0324a.rootView.findViewById(d.g.header_view);
        c0324a.gvw.setIsRound(true);
        c0324a.eeA = (TextView) c0324a.rootView.findViewById(d.g.user_name);
        c0324a.gvx = (Button) c0324a.rootView.findViewById(d.g.remove_button);
        c0324a.rootView.setTag(c0324a);
        c0324a.gvx.setOnClickListener(this.dGE);
        return c0324a;
    }

    private C0324a a(Object obj, BlackListItemData blackListItemData) {
        C0324a c0324a;
        if (obj == null) {
            c0324a = bwL();
        } else {
            c0324a = (C0324a) obj;
        }
        a(c0324a, blackListItemData.brU());
        c0324a.eeA.setText(blackListItemData.ajN());
        c0324a.gvx.setTag(blackListItemData);
        this.gvu.getLayoutMode().onModeChanged(c0324a.rootView);
        return c0324a;
    }

    private void a(C0324a c0324a, String str) {
        if (str != null) {
            c0324a.gvw.setTag(str);
            c0324a.gvw.startLoad(str, 12, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.imMessageCenter.im.friend.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0324a {
        public TextView eeA;
        public HeadImageView gvw;
        public Button gvx;
        public View rootView;

        private C0324a() {
        }
    }
}
