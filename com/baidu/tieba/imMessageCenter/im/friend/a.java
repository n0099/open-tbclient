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
    private View.OnClickListener eKg = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object tag = view.getTag();
            if (tag != null && (tag instanceof BlackListItemData)) {
                a.this.jZA.a(view, (BlackListItemData) tag);
            }
        }
    };
    private ArrayList<BlackListItemData> euy;
    private IMBlackListActivity jZA;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(IMBlackListActivity iMBlackListActivity) {
        this.jZA = iMBlackListActivity;
    }

    public void setData(ArrayList<BlackListItemData> arrayList) {
        this.euy = arrayList;
    }

    public void b(BlackListItemData blackListItemData) {
        if (this.euy != null) {
            this.euy.remove(blackListItemData);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.euy != null) {
            return this.euy.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.euy != null) {
            return this.euy.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0740a c0740a;
        BlackListItemData blackListItemData = (BlackListItemData) getItem(i);
        if (blackListItemData != null) {
            c0740a = a(view != null ? view.getTag() : null, blackListItemData);
        } else {
            c0740a = null;
        }
        if (c0740a != null) {
            return c0740a.rootView;
        }
        return null;
    }

    private C0740a cQl() {
        C0740a c0740a = new C0740a();
        c0740a.rootView = LayoutInflater.from(this.jZA.getPageContext().getContext()).inflate(R.layout.im_black_list_item, (ViewGroup) null);
        c0740a.jZC = (HeadImageView) c0740a.rootView.findViewById(R.id.header_view);
        c0740a.jZC.setIsRound(true);
        c0740a.hkx = (TextView) c0740a.rootView.findViewById(R.id.user_name);
        c0740a.jZD = (Button) c0740a.rootView.findViewById(R.id.remove_button);
        c0740a.rootView.setTag(c0740a);
        c0740a.jZD.setOnClickListener(this.eKg);
        return c0740a;
    }

    private C0740a a(Object obj, BlackListItemData blackListItemData) {
        C0740a c0740a;
        if (obj == null) {
            c0740a = cQl();
        } else {
            c0740a = (C0740a) obj;
        }
        a(c0740a, blackListItemData.TM());
        c0740a.hkx.setText(blackListItemData.bsZ());
        c0740a.jZD.setTag(blackListItemData);
        this.jZA.getLayoutMode().onModeChanged(c0740a.rootView);
        return c0740a;
    }

    private void a(C0740a c0740a, String str) {
        if (str != null) {
            c0740a.jZC.setTag(str);
            c0740a.jZC.startLoad(str, 12, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.imMessageCenter.im.friend.a$a  reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public class C0740a {
        public TextView hkx;
        public HeadImageView jZC;
        public Button jZD;
        public View rootView;

        private C0740a() {
        }
    }
}
