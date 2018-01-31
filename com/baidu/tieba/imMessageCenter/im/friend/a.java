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
    private ArrayList<BlackListItemData> aQJ;
    private View.OnClickListener csl = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object tag = view.getTag();
            if (tag != null && (tag instanceof BlackListItemData)) {
                a.this.eMo.a(view, (BlackListItemData) tag);
            }
        }
    };
    private IMBlackListActivity eMo;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(IMBlackListActivity iMBlackListActivity) {
        this.eMo = iMBlackListActivity;
    }

    public void setData(ArrayList<BlackListItemData> arrayList) {
        this.aQJ = arrayList;
    }

    public void b(BlackListItemData blackListItemData) {
        if (this.aQJ != null) {
            this.aQJ.remove(blackListItemData);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aQJ != null) {
            return this.aQJ.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aQJ != null) {
            return this.aQJ.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0126a c0126a;
        BlackListItemData blackListItemData = (BlackListItemData) getItem(i);
        if (blackListItemData != null) {
            c0126a = a(view != null ? view.getTag() : null, blackListItemData);
        } else {
            c0126a = null;
        }
        if (c0126a != null) {
            return c0126a.rootView;
        }
        return null;
    }

    private C0126a aLl() {
        C0126a c0126a = new C0126a();
        c0126a.rootView = LayoutInflater.from(this.eMo.getPageContext().getContext()).inflate(d.h.im_black_list_item, (ViewGroup) null);
        c0126a.eMq = (HeadImageView) c0126a.rootView.findViewById(d.g.header_view);
        c0126a.eMq.setIsRound(true);
        c0126a.cQi = (TextView) c0126a.rootView.findViewById(d.g.user_name);
        c0126a.eMr = (Button) c0126a.rootView.findViewById(d.g.remove_button);
        c0126a.rootView.setTag(c0126a);
        c0126a.eMr.setOnClickListener(this.csl);
        return c0126a;
    }

    private C0126a a(Object obj, BlackListItemData blackListItemData) {
        C0126a c0126a;
        if (obj == null) {
            c0126a = aLl();
        } else {
            c0126a = (C0126a) obj;
        }
        a(c0126a, blackListItemData.aGs());
        c0126a.cQi.setText(blackListItemData.getUserName());
        c0126a.eMr.setTag(blackListItemData);
        this.eMo.getLayoutMode().aM(c0126a.rootView);
        return c0126a;
    }

    private void a(C0126a c0126a, String str) {
        if (str != null) {
            c0126a.eMq.setTag(str);
            c0126a.eMq.startLoad(str, 12, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.imMessageCenter.im.friend.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0126a {
        public TextView cQi;
        public HeadImageView eMq;
        public Button eMr;
        public View rootView;

        private C0126a() {
        }
    }
}
