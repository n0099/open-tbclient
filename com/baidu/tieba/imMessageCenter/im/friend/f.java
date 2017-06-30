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
    private ArrayList<BlackListItemData> aaJ;
    private View.OnClickListener crS = new g(this);
    private IMBlackListActivity dsj;

    /* JADX INFO: Access modifiers changed from: protected */
    public f(IMBlackListActivity iMBlackListActivity) {
        this.dsj = iMBlackListActivity;
    }

    public void setData(ArrayList<BlackListItemData> arrayList) {
        this.aaJ = arrayList;
    }

    public void b(BlackListItemData blackListItemData) {
        if (this.aaJ != null) {
            this.aaJ.remove(blackListItemData);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aaJ != null) {
            return this.aaJ.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aaJ != null) {
            return this.aaJ.get(i);
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

    private a awW() {
        a aVar = new a(this, null);
        aVar.rootView = LayoutInflater.from(this.dsj.getPageContext().getContext()).inflate(w.j.im_black_list_item, (ViewGroup) null);
        aVar.dsl = (HeadImageView) aVar.rootView.findViewById(w.h.header_view);
        aVar.dsl.setIsRound(true);
        aVar.bBa = (TextView) aVar.rootView.findViewById(w.h.user_name);
        aVar.dsm = (Button) aVar.rootView.findViewById(w.h.remove_button);
        aVar.rootView.setTag(aVar);
        aVar.dsm.setOnClickListener(this.crS);
        return aVar;
    }

    private a a(Object obj, BlackListItemData blackListItemData) {
        a aVar;
        if (obj == null) {
            aVar = awW();
        } else {
            aVar = (a) obj;
        }
        a(aVar, blackListItemData.arP());
        aVar.bBa.setText(blackListItemData.getUserName());
        aVar.dsm.setTag(blackListItemData);
        this.dsj.getLayoutMode().t(aVar.rootView);
        return aVar;
    }

    private void a(a aVar, String str) {
        if (str != null) {
            aVar.dsl.setTag(str);
            aVar.dsl.c(str, 12, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a {
        public TextView bBa;
        public HeadImageView dsl;
        public Button dsm;
        public View rootView;

        private a() {
        }

        /* synthetic */ a(f fVar, a aVar) {
            this();
        }
    }
}
