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
                a.this.kOL.a(view, (BlackListItemData) tag);
            }
        }
    };
    private IMBlackListActivity kOL;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(IMBlackListActivity iMBlackListActivity) {
        this.kOL = iMBlackListActivity;
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
        C0766a c0766a;
        BlackListItemData blackListItemData = (BlackListItemData) getItem(i);
        if (blackListItemData != null) {
            c0766a = a(view != null ? view.getTag() : null, blackListItemData);
        } else {
            c0766a = null;
        }
        if (c0766a != null) {
            return c0766a.rootView;
        }
        return null;
    }

    private C0766a cYw() {
        C0766a c0766a = new C0766a();
        c0766a.rootView = LayoutInflater.from(this.kOL.getPageContext().getContext()).inflate(R.layout.im_black_list_item, (ViewGroup) null);
        c0766a.kON = (HeadImageView) c0766a.rootView.findViewById(R.id.header_view);
        c0766a.kON.setIsRound(true);
        c0766a.hXS = (TextView) c0766a.rootView.findViewById(R.id.user_name);
        c0766a.kOO = (Button) c0766a.rootView.findViewById(R.id.remove_button);
        c0766a.rootView.setTag(c0766a);
        c0766a.kOO.setOnClickListener(this.fml);
        return c0766a;
    }

    private C0766a a(Object obj, BlackListItemData blackListItemData) {
        C0766a c0766a;
        if (obj == null) {
            c0766a = cYw();
        } else {
            c0766a = (C0766a) obj;
        }
        a(c0766a, blackListItemData.ZO());
        c0766a.hXS.setText(blackListItemData.bza());
        c0766a.kOO.setTag(blackListItemData);
        this.kOL.getLayoutMode().onModeChanged(c0766a.rootView);
        return c0766a;
    }

    private void a(C0766a c0766a, String str) {
        if (str != null) {
            c0766a.kON.setTag(str);
            c0766a.kON.startLoad(str, 12, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.imMessageCenter.im.friend.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0766a {
        public TextView hXS;
        public HeadImageView kON;
        public Button kOO;
        public View rootView;

        private C0766a() {
        }
    }
}
