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
    private View.OnClickListener cdN = new g(this);
    private IMBlackListActivity deT;

    /* JADX INFO: Access modifiers changed from: protected */
    public f(IMBlackListActivity iMBlackListActivity) {
        this.deT = iMBlackListActivity;
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

    private a ass() {
        a aVar = new a(this, null);
        aVar.rootView = LayoutInflater.from(this.deT.getPageContext().getContext()).inflate(w.j.im_black_list_item, (ViewGroup) null);
        aVar.deV = (HeadImageView) aVar.rootView.findViewById(w.h.header_view);
        aVar.deV.setIsRound(true);
        aVar.but = (TextView) aVar.rootView.findViewById(w.h.user_name);
        aVar.deW = (Button) aVar.rootView.findViewById(w.h.remove_button);
        aVar.rootView.setTag(aVar);
        aVar.deW.setOnClickListener(this.cdN);
        return aVar;
    }

    private a a(Object obj, BlackListItemData blackListItemData) {
        a aVar;
        if (obj == null) {
            aVar = ass();
        } else {
            aVar = (a) obj;
        }
        a(aVar, blackListItemData.ane());
        aVar.but.setText(blackListItemData.getUserName());
        aVar.deW.setTag(blackListItemData);
        this.deT.getLayoutMode().t(aVar.rootView);
        return aVar;
    }

    private void a(a aVar, String str) {
        if (str != null) {
            aVar.deV.setTag(str);
            aVar.deV.c(str, 12, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a {
        public TextView but;
        public HeadImageView deV;
        public Button deW;
        public View rootView;

        private a() {
        }

        /* synthetic */ a(f fVar, a aVar) {
            this();
        }
    }
}
