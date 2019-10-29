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
    private ArrayList<BlackListItemData> bbZ;
    private View.OnClickListener ekL = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object tag = view.getTag();
            if (tag != null && (tag instanceof BlackListItemData)) {
                a.this.gTG.a(view, (BlackListItemData) tag);
            }
        }
    };
    private IMBlackListActivity gTG;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(IMBlackListActivity iMBlackListActivity) {
        this.gTG = iMBlackListActivity;
    }

    public void setData(ArrayList<BlackListItemData> arrayList) {
        this.bbZ = arrayList;
    }

    public void b(BlackListItemData blackListItemData) {
        if (this.bbZ != null) {
            this.bbZ.remove(blackListItemData);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bbZ != null) {
            return this.bbZ.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.bbZ != null) {
            return this.bbZ.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0446a c0446a;
        BlackListItemData blackListItemData = (BlackListItemData) getItem(i);
        if (blackListItemData != null) {
            c0446a = a(view != null ? view.getTag() : null, blackListItemData);
        } else {
            c0446a = null;
        }
        if (c0446a != null) {
            return c0446a.rootView;
        }
        return null;
    }

    private C0446a bER() {
        C0446a c0446a = new C0446a();
        c0446a.rootView = LayoutInflater.from(this.gTG.getPageContext().getContext()).inflate(R.layout.im_black_list_item, (ViewGroup) null);
        c0446a.gTI = (HeadImageView) c0446a.rootView.findViewById(R.id.header_view);
        c0446a.gTI.setIsRound(true);
        c0446a.ewr = (TextView) c0446a.rootView.findViewById(R.id.user_name);
        c0446a.gTJ = (Button) c0446a.rootView.findViewById(R.id.remove_button);
        c0446a.rootView.setTag(c0446a);
        c0446a.gTJ.setOnClickListener(this.ekL);
        return c0446a;
    }

    private C0446a a(Object obj, BlackListItemData blackListItemData) {
        C0446a c0446a;
        if (obj == null) {
            c0446a = bER();
        } else {
            c0446a = (C0446a) obj;
        }
        a(c0446a, blackListItemData.wW());
        c0446a.ewr.setText(blackListItemData.asc());
        c0446a.gTJ.setTag(blackListItemData);
        this.gTG.getLayoutMode().onModeChanged(c0446a.rootView);
        return c0446a;
    }

    private void a(C0446a c0446a, String str) {
        if (str != null) {
            c0446a.gTI.setTag(str);
            c0446a.gTI.startLoad(str, 12, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.imMessageCenter.im.friend.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0446a {
        public TextView ewr;
        public HeadImageView gTI;
        public Button gTJ;
        public View rootView;

        private C0446a() {
        }
    }
}
