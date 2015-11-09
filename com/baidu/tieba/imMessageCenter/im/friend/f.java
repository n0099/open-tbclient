package com.baidu.tieba.imMessageCenter.im.friend;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.i;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends BaseAdapter {
    private ArrayList<com.baidu.tieba.im.data.a> Xk;
    private IMBlackListActivity bNq;
    private View.OnClickListener bNr = new g(this);

    /* JADX INFO: Access modifiers changed from: protected */
    public f(IMBlackListActivity iMBlackListActivity) {
        this.bNq = iMBlackListActivity;
    }

    public void setData(ArrayList<com.baidu.tieba.im.data.a> arrayList) {
        this.Xk = arrayList;
    }

    public void b(com.baidu.tieba.im.data.a aVar) {
        if (this.Xk != null) {
            this.Xk.remove(aVar);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.Xk != null) {
            return this.Xk.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.Xk != null) {
            return this.Xk.get(i);
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

    private a Zx() {
        a aVar = new a(this, null);
        aVar.rootView = LayoutInflater.from(this.bNq.getPageContext().getContext()).inflate(i.g.im_black_list_item, (ViewGroup) null);
        aVar.bNt = (HeadImageView) aVar.rootView.findViewById(i.f.header_view);
        aVar.bNt.setIsRound(true);
        aVar.aGS = (TextView) aVar.rootView.findViewById(i.f.user_name);
        aVar.bNu = (Button) aVar.rootView.findViewById(i.f.remove_button);
        aVar.rootView.setTag(aVar);
        aVar.bNu.setOnClickListener(this.bNr);
        return aVar;
    }

    private a a(Object obj, com.baidu.tieba.im.data.a aVar) {
        a aVar2;
        if (obj == null) {
            aVar2 = Zx();
        } else {
            aVar2 = (a) obj;
        }
        a(aVar2, aVar.TM());
        aVar2.aGS.setText(aVar.getUserName());
        aVar2.bNu.setTag(aVar);
        this.bNq.getLayoutMode().k(aVar2.rootView);
        return aVar2;
    }

    private void a(a aVar, String str) {
        if (str != null) {
            aVar.bNt.setTag(str);
            aVar.bNt.d(str, 12, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public TextView aGS;
        public HeadImageView bNt;
        public Button bNu;
        public View rootView;

        private a() {
        }

        /* synthetic */ a(f fVar, a aVar) {
            this();
        }
    }
}
