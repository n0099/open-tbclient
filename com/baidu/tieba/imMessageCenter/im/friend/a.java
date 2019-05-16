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
    private ArrayList<BlackListItemData> aHF;
    private View.OnClickListener dRe = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object tag = view.getTag();
            if (tag != null && (tag instanceof BlackListItemData)) {
                a.this.gMI.a(view, (BlackListItemData) tag);
            }
        }
    };
    private IMBlackListActivity gMI;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(IMBlackListActivity iMBlackListActivity) {
        this.gMI = iMBlackListActivity;
    }

    public void setData(ArrayList<BlackListItemData> arrayList) {
        this.aHF = arrayList;
    }

    public void b(BlackListItemData blackListItemData) {
        if (this.aHF != null) {
            this.aHF.remove(blackListItemData);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aHF != null) {
            return this.aHF.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aHF != null) {
            return this.aHF.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0341a c0341a;
        BlackListItemData blackListItemData = (BlackListItemData) getItem(i);
        if (blackListItemData != null) {
            c0341a = a(view != null ? view.getTag() : null, blackListItemData);
        } else {
            c0341a = null;
        }
        if (c0341a != null) {
            return c0341a.rootView;
        }
        return null;
    }

    private C0341a bEt() {
        C0341a c0341a = new C0341a();
        c0341a.rootView = LayoutInflater.from(this.gMI.getPageContext().getContext()).inflate(R.layout.im_black_list_item, (ViewGroup) null);
        c0341a.gMK = (HeadImageView) c0341a.rootView.findViewById(R.id.header_view);
        c0341a.gMK.setIsRound(true);
        c0341a.epd = (TextView) c0341a.rootView.findViewById(R.id.user_name);
        c0341a.gML = (Button) c0341a.rootView.findViewById(R.id.remove_button);
        c0341a.rootView.setTag(c0341a);
        c0341a.gML.setOnClickListener(this.dRe);
        return c0341a;
    }

    private C0341a a(Object obj, BlackListItemData blackListItemData) {
        C0341a c0341a;
        if (obj == null) {
            c0341a = bEt();
        } else {
            c0341a = (C0341a) obj;
        }
        a(c0341a, blackListItemData.bzG());
        c0341a.epd.setText(blackListItemData.aoO());
        c0341a.gML.setTag(blackListItemData);
        this.gMI.getLayoutMode().onModeChanged(c0341a.rootView);
        return c0341a;
    }

    private void a(C0341a c0341a, String str) {
        if (str != null) {
            c0341a.gMK.setTag(str);
            c0341a.gMK.startLoad(str, 12, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.imMessageCenter.im.friend.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0341a {
        public TextView epd;
        public HeadImageView gMK;
        public Button gML;
        public View rootView;

        private C0341a() {
        }
    }
}
