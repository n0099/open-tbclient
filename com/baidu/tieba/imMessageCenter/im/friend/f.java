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
    private ArrayList<com.baidu.tieba.im.data.a> Xb;
    private View.OnClickListener aUk = new g(this);
    private IMBlackListActivity dxw;

    /* JADX INFO: Access modifiers changed from: protected */
    public f(IMBlackListActivity iMBlackListActivity) {
        this.dxw = iMBlackListActivity;
    }

    public void setData(ArrayList<com.baidu.tieba.im.data.a> arrayList) {
        this.Xb = arrayList;
    }

    public void b(com.baidu.tieba.im.data.a aVar) {
        if (this.Xb != null) {
            this.Xb.remove(aVar);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.Xb != null) {
            return this.Xb.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.Xb != null) {
            return this.Xb.get(i);
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
            return aVar.aBq;
        }
        return null;
    }

    private a aAG() {
        a aVar = new a(this, null);
        aVar.aBq = LayoutInflater.from(this.dxw.getPageContext().getContext()).inflate(r.h.im_black_list_item, (ViewGroup) null);
        aVar.dxy = (HeadImageView) aVar.aBq.findViewById(r.g.header_view);
        aVar.dxy.setIsRound(true);
        aVar.aYg = (TextView) aVar.aBq.findViewById(r.g.user_name);
        aVar.dxz = (Button) aVar.aBq.findViewById(r.g.remove_button);
        aVar.aBq.setTag(aVar);
        aVar.dxz.setOnClickListener(this.aUk);
        return aVar;
    }

    private a a(Object obj, com.baidu.tieba.im.data.a aVar) {
        a aVar2;
        if (obj == null) {
            aVar2 = aAG();
        } else {
            aVar2 = (a) obj;
        }
        a(aVar2, aVar.aur());
        aVar2.aYg.setText(aVar.getUserName());
        aVar2.dxz.setTag(aVar);
        this.dxw.getLayoutMode().x(aVar2.aBq);
        return aVar2;
    }

    private void a(a aVar, String str) {
        if (str != null) {
            aVar.dxy.setTag(str);
            aVar.dxy.c(str, 12, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public View aBq;
        public TextView aYg;
        public HeadImageView dxy;
        public Button dxz;

        private a() {
        }

        /* synthetic */ a(f fVar, a aVar) {
            this();
        }
    }
}
