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
/* loaded from: classes21.dex */
public class a extends BaseAdapter {
    private ArrayList<BlackListItemData> eHj;
    private View.OnClickListener eXy = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object tag = view.getTag();
            if (tag != null && (tag instanceof BlackListItemData)) {
                a.this.ksG.a(view, (BlackListItemData) tag);
            }
        }
    };
    private IMBlackListActivity ksG;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(IMBlackListActivity iMBlackListActivity) {
        this.ksG = iMBlackListActivity;
    }

    public void setData(ArrayList<BlackListItemData> arrayList) {
        this.eHj = arrayList;
    }

    public void b(BlackListItemData blackListItemData) {
        if (this.eHj != null) {
            this.eHj.remove(blackListItemData);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eHj != null) {
            return this.eHj.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.eHj != null) {
            return this.eHj.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0772a c0772a;
        BlackListItemData blackListItemData = (BlackListItemData) getItem(i);
        if (blackListItemData != null) {
            c0772a = a(view != null ? view.getTag() : null, blackListItemData);
        } else {
            c0772a = null;
        }
        if (c0772a != null) {
            return c0772a.rootView;
        }
        return null;
    }

    private C0772a cVz() {
        C0772a c0772a = new C0772a();
        c0772a.rootView = LayoutInflater.from(this.ksG.getPageContext().getContext()).inflate(R.layout.im_black_list_item, (ViewGroup) null);
        c0772a.ksI = (HeadImageView) c0772a.rootView.findViewById(R.id.header_view);
        c0772a.ksI.setIsRound(true);
        c0772a.hBW = (TextView) c0772a.rootView.findViewById(R.id.user_name);
        c0772a.ksJ = (Button) c0772a.rootView.findViewById(R.id.remove_button);
        c0772a.rootView.setTag(c0772a);
        c0772a.ksJ.setOnClickListener(this.eXy);
        return c0772a;
    }

    private C0772a a(Object obj, BlackListItemData blackListItemData) {
        C0772a c0772a;
        if (obj == null) {
            c0772a = cVz();
        } else {
            c0772a = (C0772a) obj;
        }
        a(c0772a, blackListItemData.Xw());
        c0772a.hBW.setText(blackListItemData.bwH());
        c0772a.ksJ.setTag(blackListItemData);
        this.ksG.getLayoutMode().onModeChanged(c0772a.rootView);
        return c0772a;
    }

    private void a(C0772a c0772a, String str) {
        if (str != null) {
            c0772a.ksI.setTag(str);
            c0772a.ksI.startLoad(str, 12, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.imMessageCenter.im.friend.a$a  reason: collision with other inner class name */
    /* loaded from: classes21.dex */
    public class C0772a {
        public TextView hBW;
        public HeadImageView ksI;
        public Button ksJ;
        public View rootView;

        private C0772a() {
        }
    }
}
