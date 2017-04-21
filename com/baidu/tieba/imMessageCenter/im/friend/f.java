package com.baidu.tieba.imMessageCenter.im.friend;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.im.data.BlackListItemData;
import com.baidu.tieba.w;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends BaseAdapter {
    private ArrayList<BlackListItemData> abo;
    private View.OnClickListener cgR = new g(this);
    private IMBlackListActivity dkQ;

    /* JADX INFO: Access modifiers changed from: protected */
    public f(IMBlackListActivity iMBlackListActivity) {
        this.dkQ = iMBlackListActivity;
    }

    public void setData(ArrayList<BlackListItemData> arrayList) {
        this.abo = arrayList;
    }

    public void b(BlackListItemData blackListItemData) {
        if (this.abo != null) {
            this.abo.remove(blackListItemData);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.abo != null) {
            return this.abo.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.abo != null) {
            return this.abo.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        BlackListItemData blackListItemData = (BlackListItemData) getItem(i);
        if (blackListItemData != null) {
            aVar = a(view != null ? view.getTag() : null, blackListItemData);
        } else {
            aVar = null;
        }
        if (aVar != null) {
            return aVar.rootView;
        }
        return null;
    }

    private a avx() {
        a aVar = new a(this, null);
        aVar.rootView = LayoutInflater.from(this.dkQ.getPageContext().getContext()).inflate(w.j.im_black_list_item, (ViewGroup) null);
        aVar.dkS = (HeadImageView) aVar.rootView.findViewById(w.h.header_view);
        aVar.dkS.setIsRound(true);
        aVar.bux = (TextView) aVar.rootView.findViewById(w.h.user_name);
        aVar.dkT = (Button) aVar.rootView.findViewById(w.h.remove_button);
        aVar.rootView.setTag(aVar);
        aVar.dkT.setOnClickListener(this.cgR);
        return aVar;
    }

    private a a(Object obj, BlackListItemData blackListItemData) {
        a aVar;
        if (obj == null) {
            aVar = avx();
        } else {
            aVar = (a) obj;
        }
        a(aVar, blackListItemData.aql());
        aVar.bux.setText(blackListItemData.getUserName());
        aVar.dkT.setTag(blackListItemData);
        this.dkQ.getLayoutMode().t(aVar.rootView);
        return aVar;
    }

    private void a(a aVar, String str) {
        if (str != null) {
            aVar.dkS.setTag(str);
            aVar.dkS.c(str, 12, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public TextView bux;
        public HeadImageView dkS;
        public Button dkT;
        public View rootView;

        private a() {
        }

        /* synthetic */ a(f fVar, a aVar) {
            this();
        }
    }
}
