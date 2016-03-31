package com.baidu.tieba.imMessageCenter.im.friend;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.t;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends BaseAdapter {
    private ArrayList<com.baidu.tieba.im.data.a> Xq;
    private View.OnClickListener bKS = new g(this);
    private IMBlackListActivity cvA;

    /* JADX INFO: Access modifiers changed from: protected */
    public f(IMBlackListActivity iMBlackListActivity) {
        this.cvA = iMBlackListActivity;
    }

    public void setData(ArrayList<com.baidu.tieba.im.data.a> arrayList) {
        this.Xq = arrayList;
    }

    public void b(com.baidu.tieba.im.data.a aVar) {
        if (this.Xq != null) {
            this.Xq.remove(aVar);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.Xq != null) {
            return this.Xq.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.Xq != null) {
            return this.Xq.get(i);
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
            return aVar.aAh;
        }
        return null;
    }

    private a akq() {
        a aVar = new a(this, null);
        aVar.aAh = LayoutInflater.from(this.cvA.getPageContext().getContext()).inflate(t.h.im_black_list_item, (ViewGroup) null);
        aVar.cvC = (HeadImageView) aVar.aAh.findViewById(t.g.header_view);
        aVar.cvC.setIsRound(true);
        aVar.aPp = (TextView) aVar.aAh.findViewById(t.g.user_name);
        aVar.cvD = (Button) aVar.aAh.findViewById(t.g.remove_button);
        aVar.aAh.setTag(aVar);
        aVar.cvD.setOnClickListener(this.bKS);
        return aVar;
    }

    private a a(Object obj, com.baidu.tieba.im.data.a aVar) {
        a aVar2;
        if (obj == null) {
            aVar2 = akq();
        } else {
            aVar2 = (a) obj;
        }
        a(aVar2, aVar.aef());
        aVar2.aPp.setText(aVar.getUserName());
        aVar2.cvD.setTag(aVar);
        this.cvA.getLayoutMode().x(aVar2.aAh);
        return aVar2;
    }

    private void a(a aVar, String str) {
        if (str != null) {
            aVar.cvC.setTag(str);
            aVar.cvC.c(str, 12, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public View aAh;
        public TextView aPp;
        public HeadImageView cvC;
        public Button cvD;

        private a() {
        }

        /* synthetic */ a(f fVar, a aVar) {
            this();
        }
    }
}
