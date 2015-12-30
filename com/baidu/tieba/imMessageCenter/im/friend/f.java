package com.baidu.tieba.imMessageCenter.im.friend;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.n;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends BaseAdapter {
    private ArrayList<com.baidu.tieba.im.data.a> YA;
    private IMBlackListActivity cgu;
    private View.OnClickListener cgv = new g(this);

    /* JADX INFO: Access modifiers changed from: protected */
    public f(IMBlackListActivity iMBlackListActivity) {
        this.cgu = iMBlackListActivity;
    }

    public void setData(ArrayList<com.baidu.tieba.im.data.a> arrayList) {
        this.YA = arrayList;
    }

    public void b(com.baidu.tieba.im.data.a aVar) {
        if (this.YA != null) {
            this.YA.remove(aVar);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.YA != null) {
            return this.YA.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.YA != null) {
            return this.YA.get(i);
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
            return aVar.rootView;
        }
        return null;
    }

    private a adM() {
        a aVar = new a(this, null);
        aVar.rootView = LayoutInflater.from(this.cgu.getPageContext().getContext()).inflate(n.h.im_black_list_item, (ViewGroup) null);
        aVar.cgx = (HeadImageView) aVar.rootView.findViewById(n.g.header_view);
        aVar.cgx.setIsRound(true);
        aVar.aLp = (TextView) aVar.rootView.findViewById(n.g.user_name);
        aVar.cgy = (Button) aVar.rootView.findViewById(n.g.remove_button);
        aVar.rootView.setTag(aVar);
        aVar.cgy.setOnClickListener(this.cgv);
        return aVar;
    }

    private a a(Object obj, com.baidu.tieba.im.data.a aVar) {
        a aVar2;
        if (obj == null) {
            aVar2 = adM();
        } else {
            aVar2 = (a) obj;
        }
        a(aVar2, aVar.XY());
        aVar2.aLp.setText(aVar.getUserName());
        aVar2.cgy.setTag(aVar);
        this.cgu.getLayoutMode().k(aVar2.rootView);
        return aVar2;
    }

    private void a(a aVar, String str) {
        if (str != null) {
            aVar.cgx.setTag(str);
            aVar.cgx.d(str, 12, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public TextView aLp;
        public HeadImageView cgx;
        public Button cgy;
        public View rootView;

        private a() {
        }

        /* synthetic */ a(f fVar, a aVar) {
            this();
        }
    }
}
