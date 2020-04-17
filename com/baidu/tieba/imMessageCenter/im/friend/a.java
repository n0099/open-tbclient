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
    private ArrayList<BlackListItemData> dvq;
    private View.OnClickListener fLe = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object tag = view.getTag();
            if (tag != null && (tag instanceof BlackListItemData)) {
                a.this.ixY.a(view, (BlackListItemData) tag);
            }
        }
    };
    private IMBlackListActivity ixY;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(IMBlackListActivity iMBlackListActivity) {
        this.ixY = iMBlackListActivity;
    }

    public void setData(ArrayList<BlackListItemData> arrayList) {
        this.dvq = arrayList;
    }

    public void b(BlackListItemData blackListItemData) {
        if (this.dvq != null) {
            this.dvq.remove(blackListItemData);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.dvq != null) {
            return this.dvq.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.dvq != null) {
            return this.dvq.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0577a c0577a;
        BlackListItemData blackListItemData = (BlackListItemData) getItem(i);
        if (blackListItemData != null) {
            c0577a = a(view != null ? view.getTag() : null, blackListItemData);
        } else {
            c0577a = null;
        }
        if (c0577a != null) {
            return c0577a.rootView;
        }
        return null;
    }

    private C0577a cjH() {
        C0577a c0577a = new C0577a();
        c0577a.rootView = LayoutInflater.from(this.ixY.getPageContext().getContext()).inflate(R.layout.im_black_list_item, (ViewGroup) null);
        c0577a.iya = (HeadImageView) c0577a.rootView.findViewById(R.id.header_view);
        c0577a.iya.setIsRound(true);
        c0577a.fXT = (TextView) c0577a.rootView.findViewById(R.id.user_name);
        c0577a.iyb = (Button) c0577a.rootView.findViewById(R.id.remove_button);
        c0577a.rootView.setTag(c0577a);
        c0577a.iyb.setOnClickListener(this.fLe);
        return c0577a;
    }

    private C0577a a(Object obj, BlackListItemData blackListItemData) {
        C0577a c0577a;
        if (obj == null) {
            c0577a = cjH();
        } else {
            c0577a = (C0577a) obj;
        }
        a(c0577a, blackListItemData.HU());
        c0577a.fXT.setText(blackListItemData.aUR());
        c0577a.iyb.setTag(blackListItemData);
        this.ixY.getLayoutMode().onModeChanged(c0577a.rootView);
        return c0577a;
    }

    private void a(C0577a c0577a, String str) {
        if (str != null) {
            c0577a.iya.setTag(str);
            c0577a.iya.startLoad(str, 12, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.imMessageCenter.im.friend.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C0577a {
        public TextView fXT;
        public HeadImageView iya;
        public Button iyb;
        public View rootView;

        private C0577a() {
        }
    }
}
