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
    private ArrayList<BlackListItemData> eIM;
    private View.OnClickListener eYr = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object tag = view.getTag();
            if (tag != null && (tag instanceof BlackListItemData)) {
                a.this.krW.a(view, (BlackListItemData) tag);
            }
        }
    };
    private IMBlackListActivity krW;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(IMBlackListActivity iMBlackListActivity) {
        this.krW = iMBlackListActivity;
    }

    public void setData(ArrayList<BlackListItemData> arrayList) {
        this.eIM = arrayList;
    }

    public void b(BlackListItemData blackListItemData) {
        if (this.eIM != null) {
            this.eIM.remove(blackListItemData);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eIM != null) {
            return this.eIM.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.eIM != null) {
            return this.eIM.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0770a c0770a;
        BlackListItemData blackListItemData = (BlackListItemData) getItem(i);
        if (blackListItemData != null) {
            c0770a = a(view != null ? view.getTag() : null, blackListItemData);
        } else {
            c0770a = null;
        }
        if (c0770a != null) {
            return c0770a.rootView;
        }
        return null;
    }

    private C0770a cVT() {
        C0770a c0770a = new C0770a();
        c0770a.rootView = LayoutInflater.from(this.krW.getPageContext().getContext()).inflate(R.layout.im_black_list_item, (ViewGroup) null);
        c0770a.krY = (HeadImageView) c0770a.rootView.findViewById(R.id.header_view);
        c0770a.krY.setIsRound(true);
        c0770a.hCp = (TextView) c0770a.rootView.findViewById(R.id.user_name);
        c0770a.krZ = (Button) c0770a.rootView.findViewById(R.id.remove_button);
        c0770a.rootView.setTag(c0770a);
        c0770a.krZ.setOnClickListener(this.eYr);
        return c0770a;
    }

    private C0770a a(Object obj, BlackListItemData blackListItemData) {
        C0770a c0770a;
        if (obj == null) {
            c0770a = cVT();
        } else {
            c0770a = (C0770a) obj;
        }
        a(c0770a, blackListItemData.Yf());
        c0770a.hCp.setText(blackListItemData.bxr());
        c0770a.krZ.setTag(blackListItemData);
        this.krW.getLayoutMode().onModeChanged(c0770a.rootView);
        return c0770a;
    }

    private void a(C0770a c0770a, String str) {
        if (str != null) {
            c0770a.krY.setTag(str);
            c0770a.krY.startLoad(str, 12, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.imMessageCenter.im.friend.a$a  reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public class C0770a {
        public TextView hCp;
        public HeadImageView krY;
        public Button krZ;
        public View rootView;

        private C0770a() {
        }
    }
}
