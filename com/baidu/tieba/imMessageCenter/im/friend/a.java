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
/* loaded from: classes2.dex */
public class a extends BaseAdapter {
    private ArrayList<BlackListItemData> eXu;
    private View.OnClickListener fnL = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object tag = view.getTag();
            if (tag != null && (tag instanceof BlackListItemData)) {
                a.this.kRb.a(view, (BlackListItemData) tag);
            }
        }
    };
    private IMBlackListActivity kRb;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(IMBlackListActivity iMBlackListActivity) {
        this.kRb = iMBlackListActivity;
    }

    public void setData(ArrayList<BlackListItemData> arrayList) {
        this.eXu = arrayList;
    }

    public void b(BlackListItemData blackListItemData) {
        if (this.eXu != null) {
            this.eXu.remove(blackListItemData);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eXu != null) {
            return this.eXu.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.eXu != null) {
            return this.eXu.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0773a c0773a;
        BlackListItemData blackListItemData = (BlackListItemData) getItem(i);
        if (blackListItemData != null) {
            c0773a = a(view != null ? view.getTag() : null, blackListItemData);
        } else {
            c0773a = null;
        }
        if (c0773a != null) {
            return c0773a.rootView;
        }
        return null;
    }

    private C0773a cYK() {
        C0773a c0773a = new C0773a();
        c0773a.rootView = LayoutInflater.from(this.kRb.getPageContext().getContext()).inflate(R.layout.im_black_list_item, (ViewGroup) null);
        c0773a.kRd = (HeadImageView) c0773a.rootView.findViewById(R.id.header_view);
        c0773a.kRd.setIsRound(true);
        c0773a.hZP = (TextView) c0773a.rootView.findViewById(R.id.user_name);
        c0773a.kRe = (Button) c0773a.rootView.findViewById(R.id.remove_button);
        c0773a.rootView.setTag(c0773a);
        c0773a.kRe.setOnClickListener(this.fnL);
        return c0773a;
    }

    private C0773a a(Object obj, BlackListItemData blackListItemData) {
        C0773a c0773a;
        if (obj == null) {
            c0773a = cYK();
        } else {
            c0773a = (C0773a) obj;
        }
        a(c0773a, blackListItemData.ZR());
        c0773a.hZP.setText(blackListItemData.bzd());
        c0773a.kRe.setTag(blackListItemData);
        this.kRb.getLayoutMode().onModeChanged(c0773a.rootView);
        return c0773a;
    }

    private void a(C0773a c0773a, String str) {
        if (str != null) {
            c0773a.kRd.setTag(str);
            c0773a.kRd.startLoad(str, 12, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.imMessageCenter.im.friend.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0773a {
        public TextView hZP;
        public HeadImageView kRd;
        public Button kRe;
        public View rootView;

        private C0773a() {
        }
    }
}
