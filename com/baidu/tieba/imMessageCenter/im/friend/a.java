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
    private ArrayList<BlackListItemData> bbH;
    private View.OnClickListener ejU = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object tag = view.getTag();
            if (tag != null && (tag instanceof BlackListItemData)) {
                a.this.gSP.a(view, (BlackListItemData) tag);
            }
        }
    };
    private IMBlackListActivity gSP;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(IMBlackListActivity iMBlackListActivity) {
        this.gSP = iMBlackListActivity;
    }

    public void setData(ArrayList<BlackListItemData> arrayList) {
        this.bbH = arrayList;
    }

    public void b(BlackListItemData blackListItemData) {
        if (this.bbH != null) {
            this.bbH.remove(blackListItemData);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bbH != null) {
            return this.bbH.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.bbH != null) {
            return this.bbH.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0441a c0441a;
        BlackListItemData blackListItemData = (BlackListItemData) getItem(i);
        if (blackListItemData != null) {
            c0441a = a(view != null ? view.getTag() : null, blackListItemData);
        } else {
            c0441a = null;
        }
        if (c0441a != null) {
            return c0441a.rootView;
        }
        return null;
    }

    private C0441a bEP() {
        C0441a c0441a = new C0441a();
        c0441a.rootView = LayoutInflater.from(this.gSP.getPageContext().getContext()).inflate(R.layout.im_black_list_item, (ViewGroup) null);
        c0441a.gSR = (HeadImageView) c0441a.rootView.findViewById(R.id.header_view);
        c0441a.gSR.setIsRound(true);
        c0441a.evA = (TextView) c0441a.rootView.findViewById(R.id.user_name);
        c0441a.gSS = (Button) c0441a.rootView.findViewById(R.id.remove_button);
        c0441a.rootView.setTag(c0441a);
        c0441a.gSS.setOnClickListener(this.ejU);
        return c0441a;
    }

    private C0441a a(Object obj, BlackListItemData blackListItemData) {
        C0441a c0441a;
        if (obj == null) {
            c0441a = bEP();
        } else {
            c0441a = (C0441a) obj;
        }
        a(c0441a, blackListItemData.wX());
        c0441a.evA.setText(blackListItemData.asa());
        c0441a.gSS.setTag(blackListItemData);
        this.gSP.getLayoutMode().onModeChanged(c0441a.rootView);
        return c0441a;
    }

    private void a(C0441a c0441a, String str) {
        if (str != null) {
            c0441a.gSR.setTag(str);
            c0441a.gSR.startLoad(str, 12, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.imMessageCenter.im.friend.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0441a {
        public TextView evA;
        public HeadImageView gSR;
        public Button gSS;
        public View rootView;

        private C0441a() {
        }
    }
}
