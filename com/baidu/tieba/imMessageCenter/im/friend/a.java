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
    private ArrayList<BlackListItemData> acF;
    private View.OnClickListener cAw = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object tag = view.getTag();
            if (tag != null && (tag instanceof BlackListItemData)) {
                a.this.dCc.a(view, (BlackListItemData) tag);
            }
        }
    };
    private IMBlackListActivity dCc;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(IMBlackListActivity iMBlackListActivity) {
        this.dCc = iMBlackListActivity;
    }

    public void setData(ArrayList<BlackListItemData> arrayList) {
        this.acF = arrayList;
    }

    public void b(BlackListItemData blackListItemData) {
        if (this.acF != null) {
            this.acF.remove(blackListItemData);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.acF != null) {
            return this.acF.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.acF != null) {
            return this.acF.get(i);
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

    private C0099a ayK() {
        C0099a c0099a = new C0099a();
        c0099a.rootView = LayoutInflater.from(this.dCc.getPageContext().getContext()).inflate(d.j.im_black_list_item, (ViewGroup) null);
        c0099a.dCe = (HeadImageView) c0099a.rootView.findViewById(d.h.header_view);
        c0099a.dCe.setIsRound(true);
        c0099a.bGr = (TextView) c0099a.rootView.findViewById(d.h.user_name);
        c0099a.dCf = (Button) c0099a.rootView.findViewById(d.h.remove_button);
        c0099a.rootView.setTag(c0099a);
        c0099a.dCf.setOnClickListener(this.cAw);
        return c0099a;
    }

    private C0099a a(Object obj, BlackListItemData blackListItemData) {
        C0099a c0099a;
        if (obj == null) {
            c0099a = ayK();
        } else {
            c0099a = (C0099a) obj;
        }
        a(c0099a, blackListItemData.atH());
        c0099a.bGr.setText(blackListItemData.getUserName());
        c0099a.dCf.setTag(blackListItemData);
        this.dCc.getLayoutMode().t(c0099a.rootView);
        return c0099a;
    }

    private void a(C0099a c0099a, String str) {
        if (str != null) {
            c0099a.dCe.setTag(str);
            c0099a.dCe.c(str, 12, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.imMessageCenter.im.friend.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0099a {
        public TextView bGr;
        public HeadImageView dCe;
        public Button dCf;
        public View rootView;

        private C0099a() {
        }
    }
}
