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
    private ArrayList<com.baidu.tieba.im.data.a> Xf;
    private IMBlackListActivity bMK;
    private View.OnClickListener bML = new g(this);

    /* JADX INFO: Access modifiers changed from: protected */
    public f(IMBlackListActivity iMBlackListActivity) {
        this.bMK = iMBlackListActivity;
    }

    public void setData(ArrayList<com.baidu.tieba.im.data.a> arrayList) {
        this.Xf = arrayList;
    }

    public void b(com.baidu.tieba.im.data.a aVar) {
        if (this.Xf != null) {
            this.Xf.remove(aVar);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.Xf != null) {
            return this.Xf.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.Xf != null) {
            return this.Xf.get(i);
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

    private a Zg() {
        a aVar = new a(this, null);
        aVar.rootView = LayoutInflater.from(this.bMK.getPageContext().getContext()).inflate(i.g.im_black_list_item, (ViewGroup) null);
        aVar.bMN = (HeadImageView) aVar.rootView.findViewById(i.f.header_view);
        aVar.bMN.setIsRound(true);
        aVar.aHN = (TextView) aVar.rootView.findViewById(i.f.user_name);
        aVar.bMO = (Button) aVar.rootView.findViewById(i.f.remove_button);
        aVar.rootView.setTag(aVar);
        aVar.bMO.setOnClickListener(this.bML);
        return aVar;
    }

    private a a(Object obj, com.baidu.tieba.im.data.a aVar) {
        a aVar2;
        if (obj == null) {
            aVar2 = Zg();
        } else {
            aVar2 = (a) obj;
        }
        a(aVar2, aVar.Tu());
        aVar2.aHN.setText(aVar.getUserName());
        aVar2.bMO.setTag(aVar);
        this.bMK.getLayoutMode().k(aVar2.rootView);
        return aVar2;
    }

    private void a(a aVar, String str) {
        if (str != null) {
            aVar.bMN.setTag(str);
            aVar.bMN.d(str, 12, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public TextView aHN;
        public HeadImageView bMN;
        public Button bMO;
        public View rootView;

        private a() {
        }

        /* synthetic */ a(f fVar, a aVar) {
            this();
        }
    }
}
