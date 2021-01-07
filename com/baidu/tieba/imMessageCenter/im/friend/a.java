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
        C0781a c0781a;
        BlackListItemData blackListItemData = (BlackListItemData) getItem(i);
        if (blackListItemData != null) {
            c0781a = a(view != null ? view.getTag() : null, blackListItemData);
        } else {
            c0781a = null;
        }
        if (c0781a != null) {
            return c0781a.rootView;
        }
        return null;
    }

    private C0781a daq() {
        C0781a c0781a = new C0781a();
        c0781a.rootView = LayoutInflater.from(this.kLm.getPageContext().getContext()).inflate(R.layout.im_black_list_item, (ViewGroup) null);
        c0781a.kLo = (HeadImageView) c0781a.rootView.findViewById(R.id.header_view);
        c0781a.kLo.setIsRound(true);
        c0781a.hYe = (TextView) c0781a.rootView.findViewById(R.id.user_name);
        c0781a.kLp = (Button) c0781a.rootView.findViewById(R.id.remove_button);
        c0781a.rootView.setTag(c0781a);
        c0781a.kLp.setOnClickListener(this.foD);
        return c0781a;
    }

    private C0781a a(Object obj, BlackListItemData blackListItemData) {
        C0781a c0781a;
        if (obj == null) {
            c0781a = daq();
        } else {
            c0781a = (C0781a) obj;
        }
        a(c0781a, blackListItemData.abN());
        c0781a.hYe.setText(blackListItemData.bCC());
        c0781a.kLp.setTag(blackListItemData);
        this.kLm.getLayoutMode().onModeChanged(c0781a.rootView);
        return c0781a;
    }

    private void a(C0781a c0781a, String str) {
        if (str != null) {
            c0781a.kLo.setTag(str);
            c0781a.kLo.startLoad(str, 12, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.imMessageCenter.im.friend.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0781a {
        public TextView hYe;
        public HeadImageView kLo;
        public Button kLp;
        public View rootView;

        private C0781a() {
        }
    }
}
