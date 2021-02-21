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
    private ArrayList<BlackListItemData> eVV;
    private View.OnClickListener fml = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object tag = view.getTag();
            if (tag != null && (tag instanceof BlackListItemData)) {
                a.this.kOZ.a(view, (BlackListItemData) tag);
            }
        }
    };
    private IMBlackListActivity kOZ;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(IMBlackListActivity iMBlackListActivity) {
        this.kOZ = iMBlackListActivity;
    }

    public void setData(ArrayList<BlackListItemData> arrayList) {
        this.eVV = arrayList;
    }

    public void b(BlackListItemData blackListItemData) {
        if (this.eVV != null) {
            this.eVV.remove(blackListItemData);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eVV != null) {
            return this.eVV.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.eVV != null) {
            return this.eVV.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0767a c0767a;
        BlackListItemData blackListItemData = (BlackListItemData) getItem(i);
        if (blackListItemData != null) {
            c0767a = a(view != null ? view.getTag() : null, blackListItemData);
        } else {
            c0767a = null;
        }
        if (c0767a != null) {
            return c0767a.rootView;
        }
        return null;
    }

    private C0767a cYD() {
        C0767a c0767a = new C0767a();
        c0767a.rootView = LayoutInflater.from(this.kOZ.getPageContext().getContext()).inflate(R.layout.im_black_list_item, (ViewGroup) null);
        c0767a.kPb = (HeadImageView) c0767a.rootView.findViewById(R.id.header_view);
        c0767a.kPb.setIsRound(true);
        c0767a.hYg = (TextView) c0767a.rootView.findViewById(R.id.user_name);
        c0767a.kPc = (Button) c0767a.rootView.findViewById(R.id.remove_button);
        c0767a.rootView.setTag(c0767a);
        c0767a.kPc.setOnClickListener(this.fml);
        return c0767a;
    }

    private C0767a a(Object obj, BlackListItemData blackListItemData) {
        C0767a c0767a;
        if (obj == null) {
            c0767a = cYD();
        } else {
            c0767a = (C0767a) obj;
        }
        a(c0767a, blackListItemData.ZO());
        c0767a.hYg.setText(blackListItemData.bza());
        c0767a.kPc.setTag(blackListItemData);
        this.kOZ.getLayoutMode().onModeChanged(c0767a.rootView);
        return c0767a;
    }

    private void a(C0767a c0767a, String str) {
        if (str != null) {
            c0767a.kPb.setTag(str);
            c0767a.kPb.startLoad(str, 12, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.imMessageCenter.im.friend.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0767a {
        public TextView hYg;
        public HeadImageView kPb;
        public Button kPc;
        public View rootView;

        private C0767a() {
        }
    }
}
