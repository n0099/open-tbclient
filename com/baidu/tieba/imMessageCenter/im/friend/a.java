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
/* loaded from: classes22.dex */
public class a extends BaseAdapter {
    private ArrayList<BlackListItemData> eCX;
    private View.OnClickListener eSC = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object tag = view.getTag();
            if (tag != null && (tag instanceof BlackListItemData)) {
                a.this.kma.a(view, (BlackListItemData) tag);
            }
        }
    };
    private IMBlackListActivity kma;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(IMBlackListActivity iMBlackListActivity) {
        this.kma = iMBlackListActivity;
    }

    public void setData(ArrayList<BlackListItemData> arrayList) {
        this.eCX = arrayList;
    }

    public void b(BlackListItemData blackListItemData) {
        if (this.eCX != null) {
            this.eCX.remove(blackListItemData);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eCX != null) {
            return this.eCX.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.eCX != null) {
            return this.eCX.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0756a c0756a;
        BlackListItemData blackListItemData = (BlackListItemData) getItem(i);
        if (blackListItemData != null) {
            c0756a = a(view != null ? view.getTag() : null, blackListItemData);
        } else {
            c0756a = null;
        }
        if (c0756a != null) {
            return c0756a.rootView;
        }
        return null;
    }

    private C0756a cTs() {
        C0756a c0756a = new C0756a();
        c0756a.rootView = LayoutInflater.from(this.kma.getPageContext().getContext()).inflate(R.layout.im_black_list_item, (ViewGroup) null);
        c0756a.kmc = (HeadImageView) c0756a.rootView.findViewById(R.id.header_view);
        c0756a.kmc.setIsRound(true);
        c0756a.hws = (TextView) c0756a.rootView.findViewById(R.id.user_name);
        c0756a.kmd = (Button) c0756a.rootView.findViewById(R.id.remove_button);
        c0756a.rootView.setTag(c0756a);
        c0756a.kmd.setOnClickListener(this.eSC);
        return c0756a;
    }

    private C0756a a(Object obj, BlackListItemData blackListItemData) {
        C0756a c0756a;
        if (obj == null) {
            c0756a = cTs();
        } else {
            c0756a = (C0756a) obj;
        }
        a(c0756a, blackListItemData.VG());
        c0756a.hws.setText(blackListItemData.buS());
        c0756a.kmd.setTag(blackListItemData);
        this.kma.getLayoutMode().onModeChanged(c0756a.rootView);
        return c0756a;
    }

    private void a(C0756a c0756a, String str) {
        if (str != null) {
            c0756a.kmc.setTag(str);
            c0756a.kmc.startLoad(str, 12, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.imMessageCenter.im.friend.a$a  reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public class C0756a {
        public TextView hws;
        public HeadImageView kmc;
        public Button kmd;
        public View rootView;

        private C0756a() {
        }
    }
}
