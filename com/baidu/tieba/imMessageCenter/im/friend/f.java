package com.baidu.tieba.imMessageCenter.im.friend;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.u;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends BaseAdapter {
    private ArrayList<com.baidu.tieba.im.data.a> TD;
    private View.OnClickListener aLH = new g(this);
    private IMBlackListActivity deL;

    /* JADX INFO: Access modifiers changed from: protected */
    public f(IMBlackListActivity iMBlackListActivity) {
        this.deL = iMBlackListActivity;
    }

    public void setData(ArrayList<com.baidu.tieba.im.data.a> arrayList) {
        this.TD = arrayList;
    }

    public void b(com.baidu.tieba.im.data.a aVar) {
        if (this.TD != null) {
            this.TD.remove(aVar);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.TD != null) {
            return this.TD.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.TD != null) {
            return this.TD.get(i);
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
        com.baidu.tieba.im.data.a aVar2 = (com.baidu.tieba.im.data.a) getItem(i);
        if (aVar2 != null) {
            aVar = a(view != null ? view.getTag() : null, aVar2);
        } else {
            aVar = null;
        }
        if (aVar != null) {
            return aVar.axO;
        }
        return null;
    }

    private a atx() {
        a aVar = new a(this, null);
        aVar.axO = LayoutInflater.from(this.deL.getPageContext().getContext()).inflate(u.h.im_black_list_item, (ViewGroup) null);
        aVar.deN = (HeadImageView) aVar.axO.findViewById(u.g.header_view);
        aVar.deN.setIsRound(true);
        aVar.aPR = (TextView) aVar.axO.findViewById(u.g.user_name);
        aVar.deO = (Button) aVar.axO.findViewById(u.g.remove_button);
        aVar.axO.setTag(aVar);
        aVar.deO.setOnClickListener(this.aLH);
        return aVar;
    }

    private a a(Object obj, com.baidu.tieba.im.data.a aVar) {
        a aVar2;
        if (obj == null) {
            aVar2 = atx();
        } else {
            aVar2 = (a) obj;
        }
        a(aVar2, aVar.ang());
        aVar2.aPR.setText(aVar.getUserName());
        aVar2.deO.setTag(aVar);
        this.deL.getLayoutMode().w(aVar2.axO);
        return aVar2;
    }

    private void a(a aVar, String str) {
        if (str != null) {
            aVar.deN.setTag(str);
            aVar.deN.c(str, 12, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public TextView aPR;
        public View axO;
        public HeadImageView deN;
        public Button deO;

        private a() {
        }

        /* synthetic */ a(f fVar, a aVar) {
            this();
        }
    }
}
