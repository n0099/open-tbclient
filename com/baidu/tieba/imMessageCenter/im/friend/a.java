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
/* loaded from: classes2.dex */
public class a extends BaseAdapter {
    private ArrayList<BlackListItemData> anX;
    private View.OnClickListener cev = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object tag = view.getTag();
            if (tag != null && (tag instanceof BlackListItemData)) {
                a.this.eMg.a(view, (BlackListItemData) tag);
            }
        }
    };
    private IMBlackListActivity eMg;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(IMBlackListActivity iMBlackListActivity) {
        this.eMg = iMBlackListActivity;
    }

    public void setData(ArrayList<BlackListItemData> arrayList) {
        this.anX = arrayList;
    }

    public void b(BlackListItemData blackListItemData) {
        if (this.anX != null) {
            this.anX.remove(blackListItemData);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.anX != null) {
            return this.anX.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.anX != null) {
            return this.anX.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0185a c0185a;
        BlackListItemData blackListItemData = (BlackListItemData) getItem(i);
        if (blackListItemData != null) {
            c0185a = a(view != null ? view.getTag() : null, blackListItemData);
        } else {
            c0185a = null;
        }
        if (c0185a != null) {
            return c0185a.rootView;
        }
        return null;
    }

    private C0185a aQt() {
        C0185a c0185a = new C0185a();
        c0185a.rootView = LayoutInflater.from(this.eMg.getPageContext().getContext()).inflate(e.h.im_black_list_item, (ViewGroup) null);
        c0185a.eMi = (HeadImageView) c0185a.rootView.findViewById(e.g.header_view);
        c0185a.eMi.setIsRound(true);
        c0185a.bYF = (TextView) c0185a.rootView.findViewById(e.g.user_name);
        c0185a.eMj = (Button) c0185a.rootView.findViewById(e.g.remove_button);
        c0185a.rootView.setTag(c0185a);
        c0185a.eMj.setOnClickListener(this.cev);
        return c0185a;
    }

    private C0185a a(Object obj, BlackListItemData blackListItemData) {
        C0185a c0185a;
        if (obj == null) {
            c0185a = aQt();
        } else {
            c0185a = (C0185a) obj;
        }
        a(c0185a, blackListItemData.aLB());
        c0185a.bYF.setText(blackListItemData.GM());
        c0185a.eMj.setTag(blackListItemData);
        this.eMg.getLayoutMode().onModeChanged(c0185a.rootView);
        return c0185a;
    }

    private void a(C0185a c0185a, String str) {
        if (str != null) {
            c0185a.eMi.setTag(str);
            c0185a.eMi.startLoad(str, 12, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.imMessageCenter.im.friend.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0185a {
        public TextView bYF;
        public HeadImageView eMi;
        public Button eMj;
        public View rootView;

        private C0185a() {
        }
    }
}
