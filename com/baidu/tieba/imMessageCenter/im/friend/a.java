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
    private ArrayList<BlackListItemData> aIL;
    private View.OnClickListener dWL = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object tag = view.getTag();
            if (tag != null && (tag instanceof BlackListItemData)) {
                a.this.gVG.a(view, (BlackListItemData) tag);
            }
        }
    };
    private IMBlackListActivity gVG;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(IMBlackListActivity iMBlackListActivity) {
        this.gVG = iMBlackListActivity;
    }

    public void setData(ArrayList<BlackListItemData> arrayList) {
        this.aIL = arrayList;
    }

    public void b(BlackListItemData blackListItemData) {
        if (this.aIL != null) {
            this.aIL.remove(blackListItemData);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aIL != null) {
            return this.aIL.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aIL != null) {
            return this.aIL.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0357a c0357a;
        BlackListItemData blackListItemData = (BlackListItemData) getItem(i);
        if (blackListItemData != null) {
            c0357a = a(view != null ? view.getTag() : null, blackListItemData);
        } else {
            c0357a = null;
        }
        if (c0357a != null) {
            return c0357a.rootView;
        }
        return null;
    }

    private C0357a bIg() {
        C0357a c0357a = new C0357a();
        c0357a.rootView = LayoutInflater.from(this.gVG.getPageContext().getContext()).inflate(R.layout.im_black_list_item, (ViewGroup) null);
        c0357a.gVI = (HeadImageView) c0357a.rootView.findViewById(R.id.header_view);
        c0357a.gVI.setIsRound(true);
        c0357a.evT = (TextView) c0357a.rootView.findViewById(R.id.user_name);
        c0357a.gVJ = (Button) c0357a.rootView.findViewById(R.id.remove_button);
        c0357a.rootView.setTag(c0357a);
        c0357a.gVJ.setOnClickListener(this.dWL);
        return c0357a;
    }

    private C0357a a(Object obj, BlackListItemData blackListItemData) {
        C0357a c0357a;
        if (obj == null) {
            c0357a = bIg();
        } else {
            c0357a = (C0357a) obj;
        }
        a(c0357a, blackListItemData.bDr());
        c0357a.evT.setText(blackListItemData.aqi());
        c0357a.gVJ.setTag(blackListItemData);
        this.gVG.getLayoutMode().onModeChanged(c0357a.rootView);
        return c0357a;
    }

    private void a(C0357a c0357a, String str) {
        if (str != null) {
            c0357a.gVI.setTag(str);
            c0357a.gVI.startLoad(str, 12, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.imMessageCenter.im.friend.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0357a {
        public TextView evT;
        public HeadImageView gVI;
        public Button gVJ;
        public View rootView;

        private C0357a() {
        }
    }
}
