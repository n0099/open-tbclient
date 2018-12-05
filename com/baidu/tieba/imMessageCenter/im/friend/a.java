package com.baidu.tieba.imMessageCenter.im.friend;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.e;
import com.baidu.tieba.im.data.BlackListItemData;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class a extends BaseAdapter {
    private View.OnClickListener crg = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object tag = view.getTag();
            if (tag != null && (tag instanceof BlackListItemData)) {
                a.this.fbW.a(view, (BlackListItemData) tag);
            }
        }
    };
    private IMBlackListActivity fbW;
    private ArrayList<BlackListItemData> mData;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(IMBlackListActivity iMBlackListActivity) {
        this.fbW = iMBlackListActivity;
    }

    public void setData(ArrayList<BlackListItemData> arrayList) {
        this.mData = arrayList;
    }

    public void b(BlackListItemData blackListItemData) {
        if (this.mData != null) {
            this.mData.remove(blackListItemData);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.mData != null) {
            return this.mData.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.mData != null) {
            return this.mData.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0256a c0256a;
        BlackListItemData blackListItemData = (BlackListItemData) getItem(i);
        if (blackListItemData != null) {
            c0256a = a(view != null ? view.getTag() : null, blackListItemData);
        } else {
            c0256a = null;
        }
        if (c0256a != null) {
            return c0256a.rootView;
        }
        return null;
    }

    private C0256a aUW() {
        C0256a c0256a = new C0256a();
        c0256a.rootView = LayoutInflater.from(this.fbW.getPageContext().getContext()).inflate(e.h.im_black_list_item, (ViewGroup) null);
        c0256a.fbY = (HeadImageView) c0256a.rootView.findViewById(e.g.header_view);
        c0256a.fbY.setIsRound(true);
        c0256a.clh = (TextView) c0256a.rootView.findViewById(e.g.user_name);
        c0256a.fbZ = (Button) c0256a.rootView.findViewById(e.g.remove_button);
        c0256a.rootView.setTag(c0256a);
        c0256a.fbZ.setOnClickListener(this.crg);
        return c0256a;
    }

    private C0256a a(Object obj, BlackListItemData blackListItemData) {
        C0256a c0256a;
        if (obj == null) {
            c0256a = aUW();
        } else {
            c0256a = (C0256a) obj;
        }
        a(c0256a, blackListItemData.aQf());
        c0256a.clh.setText(blackListItemData.Kd());
        c0256a.fbZ.setTag(blackListItemData);
        this.fbW.getLayoutMode().onModeChanged(c0256a.rootView);
        return c0256a;
    }

    private void a(C0256a c0256a, String str) {
        if (str != null) {
            c0256a.fbY.setTag(str);
            c0256a.fbY.startLoad(str, 12, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.imMessageCenter.im.friend.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0256a {
        public TextView clh;
        public HeadImageView fbY;
        public Button fbZ;
        public View rootView;

        private C0256a() {
        }
    }
}
