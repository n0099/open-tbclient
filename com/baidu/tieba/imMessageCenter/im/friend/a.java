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
    private ArrayList<BlackListItemData> dvu;
    private View.OnClickListener fLj = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object tag = view.getTag();
            if (tag != null && (tag instanceof BlackListItemData)) {
                a.this.iye.a(view, (BlackListItemData) tag);
            }
        }
    };
    private IMBlackListActivity iye;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(IMBlackListActivity iMBlackListActivity) {
        this.iye = iMBlackListActivity;
    }

    public void setData(ArrayList<BlackListItemData> arrayList) {
        this.dvu = arrayList;
    }

    public void b(BlackListItemData blackListItemData) {
        if (this.dvu != null) {
            this.dvu.remove(blackListItemData);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.dvu != null) {
            return this.dvu.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.dvu != null) {
            return this.dvu.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0598a c0598a;
        BlackListItemData blackListItemData = (BlackListItemData) getItem(i);
        if (blackListItemData != null) {
            c0598a = a(view != null ? view.getTag() : null, blackListItemData);
        } else {
            c0598a = null;
        }
        if (c0598a != null) {
            return c0598a.rootView;
        }
        return null;
    }

    private C0598a cjG() {
        C0598a c0598a = new C0598a();
        c0598a.rootView = LayoutInflater.from(this.iye.getPageContext().getContext()).inflate(R.layout.im_black_list_item, (ViewGroup) null);
        c0598a.iyg = (HeadImageView) c0598a.rootView.findViewById(R.id.header_view);
        c0598a.iyg.setIsRound(true);
        c0598a.fXY = (TextView) c0598a.rootView.findViewById(R.id.user_name);
        c0598a.iyh = (Button) c0598a.rootView.findViewById(R.id.remove_button);
        c0598a.rootView.setTag(c0598a);
        c0598a.iyh.setOnClickListener(this.fLj);
        return c0598a;
    }

    private C0598a a(Object obj, BlackListItemData blackListItemData) {
        C0598a c0598a;
        if (obj == null) {
            c0598a = cjG();
        } else {
            c0598a = (C0598a) obj;
        }
        a(c0598a, blackListItemData.HT());
        c0598a.fXY.setText(blackListItemData.aUP());
        c0598a.iyh.setTag(blackListItemData);
        this.iye.getLayoutMode().onModeChanged(c0598a.rootView);
        return c0598a;
    }

    private void a(C0598a c0598a, String str) {
        if (str != null) {
            c0598a.iyg.setTag(str);
            c0598a.iyg.startLoad(str, 12, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.imMessageCenter.im.friend.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C0598a {
        public TextView fXY;
        public HeadImageView iyg;
        public Button iyh;
        public View rootView;

        private C0598a() {
        }
    }
}
