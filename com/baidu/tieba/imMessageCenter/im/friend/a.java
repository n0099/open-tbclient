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
    private View.OnClickListener csv = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object tag = view.getTag();
            if (tag != null && (tag instanceof BlackListItemData)) {
                a.this.ffA.a(view, (BlackListItemData) tag);
            }
        }
    };
    private IMBlackListActivity ffA;
    private ArrayList<BlackListItemData> mData;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(IMBlackListActivity iMBlackListActivity) {
        this.ffA = iMBlackListActivity;
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

    private C0256a aWj() {
        C0256a c0256a = new C0256a();
        c0256a.rootView = LayoutInflater.from(this.ffA.getPageContext().getContext()).inflate(e.h.im_black_list_item, (ViewGroup) null);
        c0256a.ffC = (HeadImageView) c0256a.rootView.findViewById(e.g.header_view);
        c0256a.ffC.setIsRound(true);
        c0256a.clZ = (TextView) c0256a.rootView.findViewById(e.g.user_name);
        c0256a.ffD = (Button) c0256a.rootView.findViewById(e.g.remove_button);
        c0256a.rootView.setTag(c0256a);
        c0256a.ffD.setOnClickListener(this.csv);
        return c0256a;
    }

    private C0256a a(Object obj, BlackListItemData blackListItemData) {
        C0256a c0256a;
        if (obj == null) {
            c0256a = aWj();
        } else {
            c0256a = (C0256a) obj;
        }
        a(c0256a, blackListItemData.aRs());
        c0256a.clZ.setText(blackListItemData.Kt());
        c0256a.ffD.setTag(blackListItemData);
        this.ffA.getLayoutMode().onModeChanged(c0256a.rootView);
        return c0256a;
    }

    private void a(C0256a c0256a, String str) {
        if (str != null) {
            c0256a.ffC.setTag(str);
            c0256a.ffC.startLoad(str, 12, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.imMessageCenter.im.friend.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0256a {
        public TextView clZ;
        public HeadImageView ffC;
        public Button ffD;
        public View rootView;

        private C0256a() {
        }
    }
}
