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
/* loaded from: classes2.dex */
public class f extends BaseAdapter {
    private ArrayList<BlackListItemData> aaI;
    private View.OnClickListener ckb = new g(this);
    private IMBlackListActivity dkn;

    /* JADX INFO: Access modifiers changed from: protected */
    public f(IMBlackListActivity iMBlackListActivity) {
        this.dkn = iMBlackListActivity;
    }

    public void setData(ArrayList<BlackListItemData> arrayList) {
        this.aaI = arrayList;
    }

    public void b(BlackListItemData blackListItemData) {
        if (this.aaI != null) {
            this.aaI.remove(blackListItemData);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aaI != null) {
            return this.aaI.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aaI != null) {
            return this.aaI.get(i);
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

    private a ato() {
        a aVar = new a(this, null);
        aVar.rootView = LayoutInflater.from(this.dkn.getPageContext().getContext()).inflate(w.j.im_black_list_item, (ViewGroup) null);
        aVar.dkp = (HeadImageView) aVar.rootView.findViewById(w.h.header_view);
        aVar.dkp.setIsRound(true);
        aVar.bAh = (TextView) aVar.rootView.findViewById(w.h.user_name);
        aVar.dkq = (Button) aVar.rootView.findViewById(w.h.remove_button);
        aVar.rootView.setTag(aVar);
        aVar.dkq.setOnClickListener(this.ckb);
        return aVar;
    }

    private a a(Object obj, BlackListItemData blackListItemData) {
        a aVar;
        if (obj == null) {
            aVar = ato();
        } else {
            aVar = (a) obj;
        }
        a(aVar, blackListItemData.aoe());
        aVar.bAh.setText(blackListItemData.getUserName());
        aVar.dkq.setTag(blackListItemData);
        this.dkn.getLayoutMode().t(aVar.rootView);
        return aVar;
    }

    private void a(a aVar, String str) {
        if (str != null) {
            aVar.dkp.setTag(str);
            aVar.dkp.c(str, 12, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a {
        public TextView bAh;
        public HeadImageView dkp;
        public Button dkq;
        public View rootView;

        private a() {
        }

        /* synthetic */ a(f fVar, a aVar) {
            this();
        }
    }
}
