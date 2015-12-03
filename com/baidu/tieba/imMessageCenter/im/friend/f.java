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
    private ArrayList<com.baidu.tieba.im.data.a> XX;
    private IMBlackListActivity ccu;
    private View.OnClickListener ccv = new g(this);

    /* JADX INFO: Access modifiers changed from: protected */
    public f(IMBlackListActivity iMBlackListActivity) {
        this.ccu = iMBlackListActivity;
    }

    public void setData(ArrayList<com.baidu.tieba.im.data.a> arrayList) {
        this.XX = arrayList;
    }

    public void b(com.baidu.tieba.im.data.a aVar) {
        if (this.XX != null) {
            this.XX.remove(aVar);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.XX != null) {
            return this.XX.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.XX != null) {
            return this.XX.get(i);
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

    private a acD() {
        a aVar = new a(this, null);
        aVar.rootView = LayoutInflater.from(this.ccu.getPageContext().getContext()).inflate(n.g.im_black_list_item, (ViewGroup) null);
        aVar.ccx = (HeadImageView) aVar.rootView.findViewById(n.f.header_view);
        aVar.ccx.setIsRound(true);
        aVar.aJR = (TextView) aVar.rootView.findViewById(n.f.user_name);
        aVar.ccy = (Button) aVar.rootView.findViewById(n.f.remove_button);
        aVar.rootView.setTag(aVar);
        aVar.ccy.setOnClickListener(this.ccv);
        return aVar;
    }

    private a a(Object obj, com.baidu.tieba.im.data.a aVar) {
        a aVar2;
        if (obj == null) {
            aVar2 = acD();
        } else {
            aVar2 = (a) obj;
        }
        a(aVar2, aVar.WS());
        aVar2.aJR.setText(aVar.getUserName());
        aVar2.ccy.setTag(aVar);
        this.ccu.getLayoutMode().k(aVar2.rootView);
        return aVar2;
    }

    private void a(a aVar, String str) {
        if (str != null) {
            aVar.ccx.setTag(str);
            aVar.ccx.d(str, 12, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public TextView aJR;
        public HeadImageView ccx;
        public Button ccy;
        public View rootView;

        private a() {
        }

        /* synthetic */ a(f fVar, a aVar) {
            this();
        }
    }
}
