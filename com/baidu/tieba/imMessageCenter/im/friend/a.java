package com.baidu.tieba.imMessageCenter.im.friend;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.BlackListItemData;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes9.dex */
public class a extends BaseAdapter {
    private ArrayList<BlackListItemData> cVQ;
    private View.OnClickListener fgf = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object tag = view.getTag();
            if (tag != null && (tag instanceof BlackListItemData)) {
                a.this.hMt.a(view, (BlackListItemData) tag);
            }
        }
    };
    private IMBlackListActivity hMt;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(IMBlackListActivity iMBlackListActivity) {
        this.hMt = iMBlackListActivity;
    }

    public void setData(ArrayList<BlackListItemData> arrayList) {
        this.cVQ = arrayList;
    }

    public void b(BlackListItemData blackListItemData) {
        if (this.cVQ != null) {
            this.cVQ.remove(blackListItemData);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.cVQ != null) {
            return this.cVQ.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.cVQ != null) {
            return this.cVQ.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0539a c0539a;
        BlackListItemData blackListItemData = (BlackListItemData) getItem(i);
        if (blackListItemData != null) {
            c0539a = a(view != null ? view.getTag() : null, blackListItemData);
        } else {
            c0539a = null;
        }
        if (c0539a != null) {
            return c0539a.rootView;
        }
        return null;
    }

    private C0539a bYL() {
        C0539a c0539a = new C0539a();
        c0539a.rootView = LayoutInflater.from(this.hMt.getPageContext().getContext()).inflate(R.layout.im_black_list_item, (ViewGroup) null);
        c0539a.hMv = (HeadImageView) c0539a.rootView.findViewById(R.id.header_view);
        c0539a.hMv.setIsRound(true);
        c0539a.fsL = (TextView) c0539a.rootView.findViewById(R.id.user_name);
        c0539a.hMw = (Button) c0539a.rootView.findViewById(R.id.remove_button);
        c0539a.rootView.setTag(c0539a);
        c0539a.hMw.setOnClickListener(this.fgf);
        return c0539a;
    }

    private C0539a a(Object obj, BlackListItemData blackListItemData) {
        C0539a c0539a;
        if (obj == null) {
            c0539a = bYL();
        } else {
            c0539a = (C0539a) obj;
        }
        a(c0539a, blackListItemData.BH());
        c0539a.fsL.setText(blackListItemData.aMn());
        c0539a.hMw.setTag(blackListItemData);
        this.hMt.getLayoutMode().onModeChanged(c0539a.rootView);
        return c0539a;
    }

    private void a(C0539a c0539a, String str) {
        if (str != null) {
            c0539a.hMv.setTag(str);
            c0539a.hMv.startLoad(str, 12, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.imMessageCenter.im.friend.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C0539a {
        public TextView fsL;
        public HeadImageView hMv;
        public Button hMw;
        public View rootView;

        private C0539a() {
        }
    }
}
