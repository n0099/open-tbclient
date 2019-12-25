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
/* loaded from: classes6.dex */
public class a extends BaseAdapter {
    private ArrayList<BlackListItemData> cRE;
    private View.OnClickListener fai = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object tag = view.getTag();
            if (tag != null && (tag instanceof BlackListItemData)) {
                a.this.hGS.a(view, (BlackListItemData) tag);
            }
        }
    };
    private IMBlackListActivity hGS;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(IMBlackListActivity iMBlackListActivity) {
        this.hGS = iMBlackListActivity;
    }

    public void setData(ArrayList<BlackListItemData> arrayList) {
        this.cRE = arrayList;
    }

    public void b(BlackListItemData blackListItemData) {
        if (this.cRE != null) {
            this.cRE.remove(blackListItemData);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.cRE != null) {
            return this.cRE.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.cRE != null) {
            return this.cRE.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0527a c0527a;
        BlackListItemData blackListItemData = (BlackListItemData) getItem(i);
        if (blackListItemData != null) {
            c0527a = a(view != null ? view.getTag() : null, blackListItemData);
        } else {
            c0527a = null;
        }
        if (c0527a != null) {
            return c0527a.rootView;
        }
        return null;
    }

    private C0527a bWb() {
        C0527a c0527a = new C0527a();
        c0527a.rootView = LayoutInflater.from(this.hGS.getPageContext().getContext()).inflate(R.layout.im_black_list_item, (ViewGroup) null);
        c0527a.hGU = (HeadImageView) c0527a.rootView.findViewById(R.id.header_view);
        c0527a.hGU.setIsRound(true);
        c0527a.fmZ = (TextView) c0527a.rootView.findViewById(R.id.user_name);
        c0527a.hGV = (Button) c0527a.rootView.findViewById(R.id.remove_button);
        c0527a.rootView.setTag(c0527a);
        c0527a.hGV.setOnClickListener(this.fai);
        return c0527a;
    }

    private C0527a a(Object obj, BlackListItemData blackListItemData) {
        C0527a c0527a;
        if (obj == null) {
            c0527a = bWb();
        } else {
            c0527a = (C0527a) obj;
        }
        a(c0527a, blackListItemData.yV());
        c0527a.fmZ.setText(blackListItemData.aJz());
        c0527a.hGV.setTag(blackListItemData);
        this.hGS.getLayoutMode().onModeChanged(c0527a.rootView);
        return c0527a;
    }

    private void a(C0527a c0527a, String str) {
        if (str != null) {
            c0527a.hGU.setTag(str);
            c0527a.hGU.startLoad(str, 12, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.imMessageCenter.im.friend.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C0527a {
        public TextView fmZ;
        public HeadImageView hGU;
        public Button hGV;
        public View rootView;

        private C0527a() {
        }
    }
}
