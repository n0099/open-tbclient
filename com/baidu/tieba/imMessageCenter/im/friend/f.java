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
    private ArrayList<BlackListItemData> aaY;
    private View.OnClickListener cga = new g(this);
    private IMBlackListActivity dka;

    /* JADX INFO: Access modifiers changed from: protected */
    public f(IMBlackListActivity iMBlackListActivity) {
        this.dka = iMBlackListActivity;
    }

    public void setData(ArrayList<BlackListItemData> arrayList) {
        this.aaY = arrayList;
    }

    public void b(BlackListItemData blackListItemData) {
        if (this.aaY != null) {
            this.aaY.remove(blackListItemData);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aaY != null) {
            return this.aaY.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aaY != null) {
            return this.aaY.get(i);
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

    private a auD() {
        a aVar = new a(this, null);
        aVar.rootView = LayoutInflater.from(this.dka.getPageContext().getContext()).inflate(w.j.im_black_list_item, (ViewGroup) null);
        aVar.dkc = (HeadImageView) aVar.rootView.findViewById(w.h.header_view);
        aVar.dkc.setIsRound(true);
        aVar.bsn = (TextView) aVar.rootView.findViewById(w.h.user_name);
        aVar.dkd = (Button) aVar.rootView.findViewById(w.h.remove_button);
        aVar.rootView.setTag(aVar);
        aVar.dkd.setOnClickListener(this.cga);
        return aVar;
    }

    private a a(Object obj, BlackListItemData blackListItemData) {
        a aVar;
        if (obj == null) {
            aVar = auD();
        } else {
            aVar = (a) obj;
        }
        a(aVar, blackListItemData.apr());
        aVar.bsn.setText(blackListItemData.getUserName());
        aVar.dkd.setTag(blackListItemData);
        this.dka.getLayoutMode().t(aVar.rootView);
        return aVar;
    }

    private void a(a aVar, String str) {
        if (str != null) {
            aVar.dkc.setTag(str);
            aVar.dkc.c(str, 12, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public TextView bsn;
        public HeadImageView dkc;
        public Button dkd;
        public View rootView;

        private a() {
        }

        /* synthetic */ a(f fVar, a aVar) {
            this();
        }
    }
}
