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
    private ArrayList<BlackListItemData> dQf;
    private View.OnClickListener efJ = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object tag = view.getTag();
            if (tag != null && (tag instanceof BlackListItemData)) {
                a.this.jez.a(view, (BlackListItemData) tag);
            }
        }
    };
    private IMBlackListActivity jez;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(IMBlackListActivity iMBlackListActivity) {
        this.jez = iMBlackListActivity;
    }

    public void setData(ArrayList<BlackListItemData> arrayList) {
        this.dQf = arrayList;
    }

    public void b(BlackListItemData blackListItemData) {
        if (this.dQf != null) {
            this.dQf.remove(blackListItemData);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.dQf != null) {
            return this.dQf.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.dQf != null) {
            return this.dQf.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0661a c0661a;
        BlackListItemData blackListItemData = (BlackListItemData) getItem(i);
        if (blackListItemData != null) {
            c0661a = a(view != null ? view.getTag() : null, blackListItemData);
        } else {
            c0661a = null;
        }
        if (c0661a != null) {
            return c0661a.rootView;
        }
        return null;
    }

    private C0661a cuc() {
        C0661a c0661a = new C0661a();
        c0661a.rootView = LayoutInflater.from(this.jez.getPageContext().getContext()).inflate(R.layout.im_black_list_item, (ViewGroup) null);
        c0661a.jeB = (HeadImageView) c0661a.rootView.findViewById(R.id.header_view);
        c0661a.jeB.setIsRound(true);
        c0661a.gzP = (TextView) c0661a.rootView.findViewById(R.id.user_name);
        c0661a.jeC = (Button) c0661a.rootView.findViewById(R.id.remove_button);
        c0661a.rootView.setTag(c0661a);
        c0661a.jeC.setOnClickListener(this.efJ);
        return c0661a;
    }

    private C0661a a(Object obj, BlackListItemData blackListItemData) {
        C0661a c0661a;
        if (obj == null) {
            c0661a = cuc();
        } else {
            c0661a = (C0661a) obj;
        }
        a(c0661a, blackListItemData.KV());
        c0661a.gzP.setText(blackListItemData.bdc());
        c0661a.jeC.setTag(blackListItemData);
        this.jez.getLayoutMode().onModeChanged(c0661a.rootView);
        return c0661a;
    }

    private void a(C0661a c0661a, String str) {
        if (str != null) {
            c0661a.jeB.setTag(str);
            c0661a.jeB.startLoad(str, 12, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.imMessageCenter.im.friend.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C0661a {
        public TextView gzP;
        public HeadImageView jeB;
        public Button jeC;
        public View rootView;

        private C0661a() {
        }
    }
}
