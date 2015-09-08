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
    private ArrayList<com.baidu.tieba.im.data.a> Xn;
    private IMBlackListActivity bJF;
    private View.OnClickListener bJG = new g(this);

    /* JADX INFO: Access modifiers changed from: protected */
    public f(IMBlackListActivity iMBlackListActivity) {
        this.bJF = iMBlackListActivity;
    }

    public void setData(ArrayList<com.baidu.tieba.im.data.a> arrayList) {
        this.Xn = arrayList;
    }

    public void b(com.baidu.tieba.im.data.a aVar) {
        if (this.Xn != null) {
            this.Xn.remove(aVar);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.Xn != null) {
            return this.Xn.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.Xn != null) {
            return this.Xn.get(i);
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

    private a Yy() {
        a aVar = new a(this, null);
        aVar.rootView = LayoutInflater.from(this.bJF.getPageContext().getContext()).inflate(i.g.im_black_list_item, (ViewGroup) null);
        aVar.bJI = (HeadImageView) aVar.rootView.findViewById(i.f.header_view);
        aVar.bJI.setIsRound(true);
        aVar.aIV = (TextView) aVar.rootView.findViewById(i.f.user_name);
        aVar.bJJ = (Button) aVar.rootView.findViewById(i.f.remove_button);
        aVar.rootView.setTag(aVar);
        aVar.bJJ.setOnClickListener(this.bJG);
        return aVar;
    }

    private a a(Object obj, com.baidu.tieba.im.data.a aVar) {
        a aVar2;
        if (obj == null) {
            aVar2 = Yy();
        } else {
            aVar2 = (a) obj;
        }
        a(aVar2, aVar.SL());
        aVar2.aIV.setText(aVar.getUserName());
        aVar2.bJJ.setTag(aVar);
        this.bJF.getLayoutMode().k(aVar2.rootView);
        return aVar2;
    }

    private void a(a aVar, String str) {
        if (str != null) {
            aVar.bJI.setTag(str);
            aVar.bJI.d(str, 12, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public TextView aIV;
        public HeadImageView bJI;
        public Button bJJ;
        public View rootView;

        private a() {
        }

        /* synthetic */ a(f fVar, a aVar) {
            this();
        }
    }
}
