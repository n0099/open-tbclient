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
    private ArrayList<BlackListItemData> egb;
    private View.OnClickListener evS = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object tag = view.getTag();
            if (tag != null && (tag instanceof BlackListItemData)) {
                a.this.jCb.a(view, (BlackListItemData) tag);
            }
        }
    };
    private IMBlackListActivity jCb;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(IMBlackListActivity iMBlackListActivity) {
        this.jCb = iMBlackListActivity;
    }

    public void setData(ArrayList<BlackListItemData> arrayList) {
        this.egb = arrayList;
    }

    public void b(BlackListItemData blackListItemData) {
        if (this.egb != null) {
            this.egb.remove(blackListItemData);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.egb != null) {
            return this.egb.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.egb != null) {
            return this.egb.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0725a c0725a;
        BlackListItemData blackListItemData = (BlackListItemData) getItem(i);
        if (blackListItemData != null) {
            c0725a = a(view != null ? view.getTag() : null, blackListItemData);
        } else {
            c0725a = null;
        }
        if (c0725a != null) {
            return c0725a.rootView;
        }
        return null;
    }

    private C0725a cIX() {
        C0725a c0725a = new C0725a();
        c0725a.rootView = LayoutInflater.from(this.jCb.getPageContext().getContext()).inflate(R.layout.im_black_list_item, (ViewGroup) null);
        c0725a.jCd = (HeadImageView) c0725a.rootView.findViewById(R.id.header_view);
        c0725a.jCd.setIsRound(true);
        c0725a.gRS = (TextView) c0725a.rootView.findViewById(R.id.user_name);
        c0725a.jCe = (Button) c0725a.rootView.findViewById(R.id.remove_button);
        c0725a.rootView.setTag(c0725a);
        c0725a.jCe.setOnClickListener(this.evS);
        return c0725a;
    }

    private C0725a a(Object obj, BlackListItemData blackListItemData) {
        C0725a c0725a;
        if (obj == null) {
            c0725a = cIX();
        } else {
            c0725a = (C0725a) obj;
        }
        a(c0725a, blackListItemData.Rc());
        c0725a.gRS.setText(blackListItemData.bpv());
        c0725a.jCe.setTag(blackListItemData);
        this.jCb.getLayoutMode().onModeChanged(c0725a.rootView);
        return c0725a;
    }

    private void a(C0725a c0725a, String str) {
        if (str != null) {
            c0725a.jCd.setTag(str);
            c0725a.jCd.startLoad(str, 12, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.imMessageCenter.im.friend.a$a  reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    public class C0725a {
        public TextView gRS;
        public HeadImageView jCd;
        public Button jCe;
        public View rootView;

        private C0725a() {
        }
    }
}
