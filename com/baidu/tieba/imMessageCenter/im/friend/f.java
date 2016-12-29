package com.baidu.tieba.imMessageCenter.im.friend;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.r;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends BaseAdapter {
    private ArrayList<com.baidu.tieba.im.data.a> Wv;
    private View.OnClickListener aTB = new g(this);
    private IMBlackListActivity dau;

    /* JADX INFO: Access modifiers changed from: protected */
    public f(IMBlackListActivity iMBlackListActivity) {
        this.dau = iMBlackListActivity;
    }

    public void setData(ArrayList<com.baidu.tieba.im.data.a> arrayList) {
        this.Wv = arrayList;
    }

    public void b(com.baidu.tieba.im.data.a aVar) {
        if (this.Wv != null) {
            this.Wv.remove(aVar);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.Wv != null) {
            return this.Wv.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.Wv != null) {
            return this.Wv.get(i);
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
            return aVar.aAK;
        }
        return null;
    }

    private a auc() {
        a aVar = new a(this, null);
        aVar.aAK = LayoutInflater.from(this.dau.getPageContext().getContext()).inflate(r.h.im_black_list_item, (ViewGroup) null);
        aVar.daw = (HeadImageView) aVar.aAK.findViewById(r.g.header_view);
        aVar.daw.setIsRound(true);
        aVar.bbH = (TextView) aVar.aAK.findViewById(r.g.user_name);
        aVar.dax = (Button) aVar.aAK.findViewById(r.g.remove_button);
        aVar.aAK.setTag(aVar);
        aVar.dax.setOnClickListener(this.aTB);
        return aVar;
    }

    private a a(Object obj, com.baidu.tieba.im.data.a aVar) {
        a aVar2;
        if (obj == null) {
            aVar2 = auc();
        } else {
            aVar2 = (a) obj;
        }
        a(aVar2, aVar.aoQ());
        aVar2.bbH.setText(aVar.getUserName());
        aVar2.dax.setTag(aVar);
        this.dau.getLayoutMode().x(aVar2.aAK);
        return aVar2;
    }

    private void a(a aVar, String str) {
        if (str != null) {
            aVar.daw.setTag(str);
            aVar.daw.c(str, 12, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public View aAK;
        public TextView bbH;
        public HeadImageView daw;
        public Button dax;

        private a() {
        }

        /* synthetic */ a(f fVar, a aVar) {
            this();
        }
    }
}
