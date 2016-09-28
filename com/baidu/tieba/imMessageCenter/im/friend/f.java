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
    private ArrayList<com.baidu.tieba.im.data.a> WD;
    private View.OnClickListener aSj = new g(this);
    private IMBlackListActivity drP;

    /* JADX INFO: Access modifiers changed from: protected */
    public f(IMBlackListActivity iMBlackListActivity) {
        this.drP = iMBlackListActivity;
    }

    public void setData(ArrayList<com.baidu.tieba.im.data.a> arrayList) {
        this.WD = arrayList;
    }

    public void b(com.baidu.tieba.im.data.a aVar) {
        if (this.WD != null) {
            this.WD.remove(aVar);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.WD != null) {
            return this.WD.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.WD != null) {
            return this.WD.get(i);
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
            return aVar.aAy;
        }
        return null;
    }

    private a ayJ() {
        a aVar = new a(this, null);
        aVar.aAy = LayoutInflater.from(this.drP.getPageContext().getContext()).inflate(r.h.im_black_list_item, (ViewGroup) null);
        aVar.drR = (HeadImageView) aVar.aAy.findViewById(r.g.header_view);
        aVar.drR.setIsRound(true);
        aVar.aVU = (TextView) aVar.aAy.findViewById(r.g.user_name);
        aVar.drS = (Button) aVar.aAy.findViewById(r.g.remove_button);
        aVar.aAy.setTag(aVar);
        aVar.drS.setOnClickListener(this.aSj);
        return aVar;
    }

    private a a(Object obj, com.baidu.tieba.im.data.a aVar) {
        a aVar2;
        if (obj == null) {
            aVar2 = ayJ();
        } else {
            aVar2 = (a) obj;
        }
        a(aVar2, aVar.asu());
        aVar2.aVU.setText(aVar.getUserName());
        aVar2.drS.setTag(aVar);
        this.drP.getLayoutMode().x(aVar2.aAy);
        return aVar2;
    }

    private void a(a aVar, String str) {
        if (str != null) {
            aVar.drR.setTag(str);
            aVar.drR.c(str, 12, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public View aAy;
        public TextView aVU;
        public HeadImageView drR;
        public Button drS;

        private a() {
        }

        /* synthetic */ a(f fVar, a aVar) {
            this();
        }
    }
}
