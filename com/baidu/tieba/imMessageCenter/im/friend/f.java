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
    private ArrayList<com.baidu.tieba.im.data.a> SV;
    private View.OnClickListener aKO = new g(this);
    private IMBlackListActivity dbN;

    /* JADX INFO: Access modifiers changed from: protected */
    public f(IMBlackListActivity iMBlackListActivity) {
        this.dbN = iMBlackListActivity;
    }

    public void setData(ArrayList<com.baidu.tieba.im.data.a> arrayList) {
        this.SV = arrayList;
    }

    public void b(com.baidu.tieba.im.data.a aVar) {
        if (this.SV != null) {
            this.SV.remove(aVar);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.SV != null) {
            return this.SV.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.SV != null) {
            return this.SV.get(i);
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
            return aVar.axa;
        }
        return null;
    }

    private a asL() {
        a aVar = new a(this, null);
        aVar.axa = LayoutInflater.from(this.dbN.getPageContext().getContext()).inflate(u.h.im_black_list_item, (ViewGroup) null);
        aVar.dbP = (HeadImageView) aVar.axa.findViewById(u.g.header_view);
        aVar.dbP.setIsRound(true);
        aVar.aOX = (TextView) aVar.axa.findViewById(u.g.user_name);
        aVar.dbQ = (Button) aVar.axa.findViewById(u.g.remove_button);
        aVar.axa.setTag(aVar);
        aVar.dbQ.setOnClickListener(this.aKO);
        return aVar;
    }

    private a a(Object obj, com.baidu.tieba.im.data.a aVar) {
        a aVar2;
        if (obj == null) {
            aVar2 = asL();
        } else {
            aVar2 = (a) obj;
        }
        a(aVar2, aVar.amw());
        aVar2.aOX.setText(aVar.getUserName());
        aVar2.dbQ.setTag(aVar);
        this.dbN.getLayoutMode().w(aVar2.axa);
        return aVar2;
    }

    private void a(a aVar, String str) {
        if (str != null) {
            aVar.dbP.setTag(str);
            aVar.dbP.c(str, 12, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public TextView aOX;
        public View axa;
        public HeadImageView dbP;
        public Button dbQ;

        private a() {
        }

        /* synthetic */ a(f fVar, a aVar) {
            this();
        }
    }
}
