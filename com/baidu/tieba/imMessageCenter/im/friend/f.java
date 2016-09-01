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
    private ArrayList<com.baidu.tieba.im.data.a> Wt;
    private View.OnClickListener aRb = new g(this);
    private IMBlackListActivity dqs;

    /* JADX INFO: Access modifiers changed from: protected */
    public f(IMBlackListActivity iMBlackListActivity) {
        this.dqs = iMBlackListActivity;
    }

    public void setData(ArrayList<com.baidu.tieba.im.data.a> arrayList) {
        this.Wt = arrayList;
    }

    public void b(com.baidu.tieba.im.data.a aVar) {
        if (this.Wt != null) {
            this.Wt.remove(aVar);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.Wt != null) {
            return this.Wt.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.Wt != null) {
            return this.Wt.get(i);
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
            return aVar.aAV;
        }
        return null;
    }

    private a ayl() {
        a aVar = new a(this, null);
        aVar.aAV = LayoutInflater.from(this.dqs.getPageContext().getContext()).inflate(t.h.im_black_list_item, (ViewGroup) null);
        aVar.dqu = (HeadImageView) aVar.aAV.findViewById(t.g.header_view);
        aVar.dqu.setIsRound(true);
        aVar.aVl = (TextView) aVar.aAV.findViewById(t.g.user_name);
        aVar.dqv = (Button) aVar.aAV.findViewById(t.g.remove_button);
        aVar.aAV.setTag(aVar);
        aVar.dqv.setOnClickListener(this.aRb);
        return aVar;
    }

    private a a(Object obj, com.baidu.tieba.im.data.a aVar) {
        a aVar2;
        if (obj == null) {
            aVar2 = ayl();
        } else {
            aVar2 = (a) obj;
        }
        a(aVar2, aVar.arV());
        aVar2.aVl.setText(aVar.getUserName());
        aVar2.dqv.setTag(aVar);
        this.dqs.getLayoutMode().x(aVar2.aAV);
        return aVar2;
    }

    private void a(a aVar, String str) {
        if (str != null) {
            aVar.dqu.setTag(str);
            aVar.dqu.c(str, 12, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public View aAV;
        public TextView aVl;
        public HeadImageView dqu;
        public Button dqv;

        private a() {
        }

        /* synthetic */ a(f fVar, a aVar) {
            this();
        }
    }
}
