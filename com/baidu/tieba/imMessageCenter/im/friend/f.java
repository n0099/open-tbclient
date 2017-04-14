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
    private ArrayList<BlackListItemData> abn;
    private View.OnClickListener ceA = new g(this);
    private IMBlackListActivity diz;

    /* JADX INFO: Access modifiers changed from: protected */
    public f(IMBlackListActivity iMBlackListActivity) {
        this.diz = iMBlackListActivity;
    }

    public void setData(ArrayList<BlackListItemData> arrayList) {
        this.abn = arrayList;
    }

    public void b(BlackListItemData blackListItemData) {
        if (this.abn != null) {
            this.abn.remove(blackListItemData);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.abn != null) {
            return this.abn.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.abn != null) {
            return this.abn.get(i);
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

    private a auw() {
        a aVar = new a(this, null);
        aVar.rootView = LayoutInflater.from(this.diz.getPageContext().getContext()).inflate(w.j.im_black_list_item, (ViewGroup) null);
        aVar.diB = (HeadImageView) aVar.rootView.findViewById(w.h.header_view);
        aVar.diB.setIsRound(true);
        aVar.bsf = (TextView) aVar.rootView.findViewById(w.h.user_name);
        aVar.diC = (Button) aVar.rootView.findViewById(w.h.remove_button);
        aVar.rootView.setTag(aVar);
        aVar.diC.setOnClickListener(this.ceA);
        return aVar;
    }

    private a a(Object obj, BlackListItemData blackListItemData) {
        a aVar;
        if (obj == null) {
            aVar = auw();
        } else {
            aVar = (a) obj;
        }
        a(aVar, blackListItemData.apk());
        aVar.bsf.setText(blackListItemData.getUserName());
        aVar.diC.setTag(blackListItemData);
        this.diz.getLayoutMode().t(aVar.rootView);
        return aVar;
    }

    private void a(a aVar, String str) {
        if (str != null) {
            aVar.diB.setTag(str);
            aVar.diB.c(str, 12, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public TextView bsf;
        public HeadImageView diB;
        public Button diC;
        public View rootView;

        private a() {
        }

        /* synthetic */ a(f fVar, a aVar) {
            this();
        }
    }
}
