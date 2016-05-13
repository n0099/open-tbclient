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
    private ArrayList<com.baidu.tieba.im.data.a> SE;
    private View.OnClickListener bxd = new g(this);
    private IMBlackListActivity cwx;

    /* JADX INFO: Access modifiers changed from: protected */
    public f(IMBlackListActivity iMBlackListActivity) {
        this.cwx = iMBlackListActivity;
    }

    public void setData(ArrayList<com.baidu.tieba.im.data.a> arrayList) {
        this.SE = arrayList;
    }

    public void b(com.baidu.tieba.im.data.a aVar) {
        if (this.SE != null) {
            this.SE.remove(aVar);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.SE != null) {
            return this.SE.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.SE != null) {
            return this.SE.get(i);
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
            return aVar.awk;
        }
        return null;
    }

    private a aky() {
        a aVar = new a(this, null);
        aVar.awk = LayoutInflater.from(this.cwx.getPageContext().getContext()).inflate(t.h.im_black_list_item, (ViewGroup) null);
        aVar.cwz = (HeadImageView) aVar.awk.findViewById(t.g.header_view);
        aVar.cwz.setIsRound(true);
        aVar.aLz = (TextView) aVar.awk.findViewById(t.g.user_name);
        aVar.cwA = (Button) aVar.awk.findViewById(t.g.remove_button);
        aVar.awk.setTag(aVar);
        aVar.cwA.setOnClickListener(this.bxd);
        return aVar;
    }

    private a a(Object obj, com.baidu.tieba.im.data.a aVar) {
        a aVar2;
        if (obj == null) {
            aVar2 = aky();
        } else {
            aVar2 = (a) obj;
        }
        a(aVar2, aVar.aeh());
        aVar2.aLz.setText(aVar.getUserName());
        aVar2.cwA.setTag(aVar);
        this.cwx.getLayoutMode().x(aVar2.awk);
        return aVar2;
    }

    private void a(a aVar, String str) {
        if (str != null) {
            aVar.cwz.setTag(str);
            aVar.cwz.c(str, 12, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public TextView aLz;
        public View awk;
        public Button cwA;
        public HeadImageView cwz;

        private a() {
        }

        /* synthetic */ a(f fVar, a aVar) {
            this();
        }
    }
}
