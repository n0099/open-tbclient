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
/* loaded from: classes4.dex */
public class a extends BaseAdapter {
    private ArrayList<BlackListItemData> aIn;
    private View.OnClickListener dUT = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object tag = view.getTag();
            if (tag != null && (tag instanceof BlackListItemData)) {
                a.this.gSV.a(view, (BlackListItemData) tag);
            }
        }
    };
    private IMBlackListActivity gSV;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(IMBlackListActivity iMBlackListActivity) {
        this.gSV = iMBlackListActivity;
    }

    public void setData(ArrayList<BlackListItemData> arrayList) {
        this.aIn = arrayList;
    }

    public void b(BlackListItemData blackListItemData) {
        if (this.aIn != null) {
            this.aIn.remove(blackListItemData);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aIn != null) {
            return this.aIn.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aIn != null) {
            return this.aIn.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0346a c0346a;
        BlackListItemData blackListItemData = (BlackListItemData) getItem(i);
        if (blackListItemData != null) {
            c0346a = a(view != null ? view.getTag() : null, blackListItemData);
        } else {
            c0346a = null;
        }
        if (c0346a != null) {
            return c0346a.rootView;
        }
        return null;
    }

    private C0346a bHe() {
        C0346a c0346a = new C0346a();
        c0346a.rootView = LayoutInflater.from(this.gSV.getPageContext().getContext()).inflate(R.layout.im_black_list_item, (ViewGroup) null);
        c0346a.gSX = (HeadImageView) c0346a.rootView.findViewById(R.id.header_view);
        c0346a.gSX.setIsRound(true);
        c0346a.euc = (TextView) c0346a.rootView.findViewById(R.id.user_name);
        c0346a.gSY = (Button) c0346a.rootView.findViewById(R.id.remove_button);
        c0346a.rootView.setTag(c0346a);
        c0346a.gSY.setOnClickListener(this.dUT);
        return c0346a;
    }

    private C0346a a(Object obj, BlackListItemData blackListItemData) {
        C0346a c0346a;
        if (obj == null) {
            c0346a = bHe();
        } else {
            c0346a = (C0346a) obj;
        }
        a(c0346a, blackListItemData.bCp());
        c0346a.euc.setText(blackListItemData.apU());
        c0346a.gSY.setTag(blackListItemData);
        this.gSV.getLayoutMode().onModeChanged(c0346a.rootView);
        return c0346a;
    }

    private void a(C0346a c0346a, String str) {
        if (str != null) {
            c0346a.gSX.setTag(str);
            c0346a.gSX.startLoad(str, 12, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.imMessageCenter.im.friend.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0346a {
        public TextView euc;
        public HeadImageView gSX;
        public Button gSY;
        public View rootView;

        private C0346a() {
        }
    }
}
