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
/* loaded from: classes16.dex */
public class a extends BaseAdapter {
    private ArrayList<BlackListItemData> dWx;
    private View.OnClickListener elT = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object tag = view.getTag();
            if (tag != null && (tag instanceof BlackListItemData)) {
                a.this.jmX.a(view, (BlackListItemData) tag);
            }
        }
    };
    private IMBlackListActivity jmX;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(IMBlackListActivity iMBlackListActivity) {
        this.jmX = iMBlackListActivity;
    }

    public void setData(ArrayList<BlackListItemData> arrayList) {
        this.dWx = arrayList;
    }

    public void b(BlackListItemData blackListItemData) {
        if (this.dWx != null) {
            this.dWx.remove(blackListItemData);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.dWx != null) {
            return this.dWx.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.dWx != null) {
            return this.dWx.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0673a c0673a;
        BlackListItemData blackListItemData = (BlackListItemData) getItem(i);
        if (blackListItemData != null) {
            c0673a = a(view != null ? view.getTag() : null, blackListItemData);
        } else {
            c0673a = null;
        }
        if (c0673a != null) {
            return c0673a.rootView;
        }
        return null;
    }

    private C0673a cyf() {
        C0673a c0673a = new C0673a();
        c0673a.rootView = LayoutInflater.from(this.jmX.getPageContext().getContext()).inflate(R.layout.im_black_list_item, (ViewGroup) null);
        c0673a.jmZ = (HeadImageView) c0673a.rootView.findViewById(R.id.header_view);
        c0673a.jmZ.setIsRound(true);
        c0673a.gFm = (TextView) c0673a.rootView.findViewById(R.id.user_name);
        c0673a.jna = (Button) c0673a.rootView.findViewById(R.id.remove_button);
        c0673a.rootView.setTag(c0673a);
        c0673a.jna.setOnClickListener(this.elT);
        return c0673a;
    }

    private C0673a a(Object obj, BlackListItemData blackListItemData) {
        C0673a c0673a;
        if (obj == null) {
            c0673a = cyf();
        } else {
            c0673a = (C0673a) obj;
        }
        a(c0673a, blackListItemData.Lc());
        c0673a.gFm.setText(blackListItemData.bgJ());
        c0673a.jna.setTag(blackListItemData);
        this.jmX.getLayoutMode().onModeChanged(c0673a.rootView);
        return c0673a;
    }

    private void a(C0673a c0673a, String str) {
        if (str != null) {
            c0673a.jmZ.setTag(str);
            c0673a.jmZ.startLoad(str, 12, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.imMessageCenter.im.friend.a$a  reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    public class C0673a {
        public TextView gFm;
        public HeadImageView jmZ;
        public Button jna;
        public View rootView;

        private C0673a() {
        }
    }
}
