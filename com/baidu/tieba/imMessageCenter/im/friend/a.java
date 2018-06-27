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
    private ArrayList<BlackListItemData> alT;
    private View.OnClickListener bXw = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object tag = view.getTag();
            if (tag != null && (tag instanceof BlackListItemData)) {
                a.this.eBb.a(view, (BlackListItemData) tag);
            }
        }
    };
    private IMBlackListActivity eBb;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(IMBlackListActivity iMBlackListActivity) {
        this.eBb = iMBlackListActivity;
    }

    public void setData(ArrayList<BlackListItemData> arrayList) {
        this.alT = arrayList;
    }

    public void b(BlackListItemData blackListItemData) {
        if (this.alT != null) {
            this.alT.remove(blackListItemData);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.alT != null) {
            return this.alT.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.alT != null) {
            return this.alT.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0184a c0184a;
        BlackListItemData blackListItemData = (BlackListItemData) getItem(i);
        if (blackListItemData != null) {
            c0184a = a(view != null ? view.getTag() : null, blackListItemData);
        } else {
            c0184a = null;
        }
        if (c0184a != null) {
            return c0184a.rootView;
        }
        return null;
    }

    private C0184a aNh() {
        C0184a c0184a = new C0184a();
        c0184a.rootView = LayoutInflater.from(this.eBb.getPageContext().getContext()).inflate(d.i.im_black_list_item, (ViewGroup) null);
        c0184a.eBd = (HeadImageView) c0184a.rootView.findViewById(d.g.header_view);
        c0184a.eBd.setIsRound(true);
        c0184a.bRW = (TextView) c0184a.rootView.findViewById(d.g.user_name);
        c0184a.eBe = (Button) c0184a.rootView.findViewById(d.g.remove_button);
        c0184a.rootView.setTag(c0184a);
        c0184a.eBe.setOnClickListener(this.bXw);
        return c0184a;
    }

    private C0184a a(Object obj, BlackListItemData blackListItemData) {
        C0184a c0184a;
        if (obj == null) {
            c0184a = aNh();
        } else {
            c0184a = (C0184a) obj;
        }
        a(c0184a, blackListItemData.aIo());
        c0184a.bRW.setText(blackListItemData.FA());
        c0184a.eBe.setTag(blackListItemData);
        this.eBb.getLayoutMode().onModeChanged(c0184a.rootView);
        return c0184a;
    }

    private void a(C0184a c0184a, String str) {
        if (str != null) {
            c0184a.eBd.setTag(str);
            c0184a.eBd.startLoad(str, 12, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.imMessageCenter.im.friend.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0184a {
        public TextView bRW;
        public HeadImageView eBd;
        public Button eBe;
        public View rootView;

        private C0184a() {
        }
    }
}
