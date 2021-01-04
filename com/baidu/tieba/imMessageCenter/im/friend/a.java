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
    private ArrayList<BlackListItemData> eYq;
    private View.OnClickListener foD = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object tag = view.getTag();
            if (tag != null && (tag instanceof BlackListItemData)) {
                a.this.kLm.a(view, (BlackListItemData) tag);
            }
        }
    };
    private IMBlackListActivity kLm;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(IMBlackListActivity iMBlackListActivity) {
        this.kLm = iMBlackListActivity;
    }

    public void setData(ArrayList<BlackListItemData> arrayList) {
        this.eYq = arrayList;
    }

    public void b(BlackListItemData blackListItemData) {
        if (this.eYq != null) {
            this.eYq.remove(blackListItemData);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eYq != null) {
            return this.eYq.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.eYq != null) {
            return this.eYq.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0772a c0772a;
        BlackListItemData blackListItemData = (BlackListItemData) getItem(i);
        if (blackListItemData != null) {
            c0772a = a(view != null ? view.getTag() : null, blackListItemData);
        } else {
            c0772a = null;
        }
        if (c0772a != null) {
            return c0772a.rootView;
        }
        return null;
    }

    private C0772a dap() {
        C0772a c0772a = new C0772a();
        c0772a.rootView = LayoutInflater.from(this.kLm.getPageContext().getContext()).inflate(R.layout.im_black_list_item, (ViewGroup) null);
        c0772a.kLo = (HeadImageView) c0772a.rootView.findViewById(R.id.header_view);
        c0772a.kLo.setIsRound(true);
        c0772a.hYe = (TextView) c0772a.rootView.findViewById(R.id.user_name);
        c0772a.kLp = (Button) c0772a.rootView.findViewById(R.id.remove_button);
        c0772a.rootView.setTag(c0772a);
        c0772a.kLp.setOnClickListener(this.foD);
        return c0772a;
    }

    private C0772a a(Object obj, BlackListItemData blackListItemData) {
        C0772a c0772a;
        if (obj == null) {
            c0772a = dap();
        } else {
            c0772a = (C0772a) obj;
        }
        a(c0772a, blackListItemData.abM());
        c0772a.hYe.setText(blackListItemData.bCB());
        c0772a.kLp.setTag(blackListItemData);
        this.kLm.getLayoutMode().onModeChanged(c0772a.rootView);
        return c0772a;
    }

    private void a(C0772a c0772a, String str) {
        if (str != null) {
            c0772a.kLo.setTag(str);
            c0772a.kLo.startLoad(str, 12, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.imMessageCenter.im.friend.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0772a {
        public TextView hYe;
        public HeadImageView kLo;
        public Button kLp;
        public View rootView;

        private C0772a() {
        }
    }
}
