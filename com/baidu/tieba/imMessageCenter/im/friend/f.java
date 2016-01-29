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
    private ArrayList<com.baidu.tieba.im.data.a> YX;
    private IMBlackListActivity ckU;
    private View.OnClickListener ckV = new g(this);

    /* JADX INFO: Access modifiers changed from: protected */
    public f(IMBlackListActivity iMBlackListActivity) {
        this.ckU = iMBlackListActivity;
    }

    public void setData(ArrayList<com.baidu.tieba.im.data.a> arrayList) {
        this.YX = arrayList;
    }

    public void b(com.baidu.tieba.im.data.a aVar) {
        if (this.YX != null) {
            this.YX.remove(aVar);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.YX != null) {
            return this.YX.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.YX != null) {
            return this.YX.get(i);
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
            return aVar.azA;
        }
        return null;
    }

    private a agW() {
        a aVar = new a(this, null);
        aVar.azA = LayoutInflater.from(this.ckU.getPageContext().getContext()).inflate(t.h.im_black_list_item, (ViewGroup) null);
        aVar.ckX = (HeadImageView) aVar.azA.findViewById(t.g.header_view);
        aVar.ckX.setIsRound(true);
        aVar.aMu = (TextView) aVar.azA.findViewById(t.g.user_name);
        aVar.ckY = (Button) aVar.azA.findViewById(t.g.remove_button);
        aVar.azA.setTag(aVar);
        aVar.ckY.setOnClickListener(this.ckV);
        return aVar;
    }

    private a a(Object obj, com.baidu.tieba.im.data.a aVar) {
        a aVar2;
        if (obj == null) {
            aVar2 = agW();
        } else {
            aVar2 = (a) obj;
        }
        a(aVar2, aVar.aaJ());
        aVar2.aMu.setText(aVar.getUserName());
        aVar2.ckY.setTag(aVar);
        this.ckU.getLayoutMode().x(aVar2.azA);
        return aVar2;
    }

    private void a(a aVar, String str) {
        if (str != null) {
            aVar.ckX.setTag(str);
            aVar.ckX.d(str, 12, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public TextView aMu;
        public View azA;
        public HeadImageView ckX;
        public Button ckY;

        private a() {
        }

        /* synthetic */ a(f fVar, a aVar) {
            this();
        }
    }
}
