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
    private ArrayList<BlackListItemData> dJp;
    private View.OnClickListener fZh = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object tag = view.getTag();
            if (tag != null && (tag instanceof BlackListItemData)) {
                a.this.iMK.a(view, (BlackListItemData) tag);
            }
        }
    };
    private IMBlackListActivity iMK;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(IMBlackListActivity iMBlackListActivity) {
        this.iMK = iMBlackListActivity;
    }

    public void setData(ArrayList<BlackListItemData> arrayList) {
        this.dJp = arrayList;
    }

    public void b(BlackListItemData blackListItemData) {
        if (this.dJp != null) {
            this.dJp.remove(blackListItemData);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.dJp != null) {
            return this.dJp.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.dJp != null) {
            return this.dJp.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0648a c0648a;
        BlackListItemData blackListItemData = (BlackListItemData) getItem(i);
        if (blackListItemData != null) {
            c0648a = a(view != null ? view.getTag() : null, blackListItemData);
        } else {
            c0648a = null;
        }
        if (c0648a != null) {
            return c0648a.rootView;
        }
        return null;
    }

    private C0648a cqe() {
        C0648a c0648a = new C0648a();
        c0648a.rootView = LayoutInflater.from(this.iMK.getPageContext().getContext()).inflate(R.layout.im_black_list_item, (ViewGroup) null);
        c0648a.iMM = (HeadImageView) c0648a.rootView.findViewById(R.id.header_view);
        c0648a.iMM.setIsRound(true);
        c0648a.gmQ = (TextView) c0648a.rootView.findViewById(R.id.user_name);
        c0648a.iMN = (Button) c0648a.rootView.findViewById(R.id.remove_button);
        c0648a.rootView.setTag(c0648a);
        c0648a.iMN.setOnClickListener(this.fZh);
        return c0648a;
    }

    private C0648a a(Object obj, BlackListItemData blackListItemData) {
        C0648a c0648a;
        if (obj == null) {
            c0648a = cqe();
        } else {
            c0648a = (C0648a) obj;
        }
        a(c0648a, blackListItemData.JM());
        c0648a.gmQ.setText(blackListItemData.baZ());
        c0648a.iMN.setTag(blackListItemData);
        this.iMK.getLayoutMode().onModeChanged(c0648a.rootView);
        return c0648a;
    }

    private void a(C0648a c0648a, String str) {
        if (str != null) {
            c0648a.iMM.setTag(str);
            c0648a.iMM.startLoad(str, 12, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.imMessageCenter.im.friend.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C0648a {
        public TextView gmQ;
        public HeadImageView iMM;
        public Button iMN;
        public View rootView;

        private C0648a() {
        }
    }
}
