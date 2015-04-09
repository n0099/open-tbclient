package com.baidu.tieba.imMessageCenter.im.friend;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.tbadk.core.view.HeadImageView;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends BaseAdapter {
    private ArrayList<com.baidu.tieba.im.data.a> auK;
    private IMBlackListActivity bsv;
    private View.OnClickListener bsw = new g(this);

    /* JADX INFO: Access modifiers changed from: protected */
    public f(IMBlackListActivity iMBlackListActivity) {
        this.bsv = iMBlackListActivity;
    }

    public void p(ArrayList<com.baidu.tieba.im.data.a> arrayList) {
        this.auK = arrayList;
    }

    public void b(com.baidu.tieba.im.data.a aVar) {
        if (this.auK != null) {
            this.auK.remove(aVar);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.auK != null) {
            return this.auK.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.auK != null) {
            return this.auK.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        h hVar;
        com.baidu.tieba.im.data.a aVar = (com.baidu.tieba.im.data.a) getItem(i);
        if (aVar != null) {
            hVar = a(view != null ? view.getTag() : null, aVar);
        } else {
            hVar = null;
        }
        if (hVar != null) {
            return hVar.rootView;
        }
        return null;
    }

    private h Vx() {
        h hVar = new h(this, null);
        hVar.rootView = com.baidu.adp.lib.g.b.hH().inflate(this.bsv.getPageContext().getContext(), com.baidu.tieba.w.im_black_list_item, null);
        hVar.bsy = (HeadImageView) hVar.rootView.findViewById(com.baidu.tieba.v.header_view);
        hVar.bsy.setIsRound(true);
        hVar.azB = (TextView) hVar.rootView.findViewById(com.baidu.tieba.v.user_name);
        hVar.bsz = (Button) hVar.rootView.findViewById(com.baidu.tieba.v.remove_button);
        hVar.rootView.setTag(hVar);
        hVar.bsz.setOnClickListener(this.bsw);
        return hVar;
    }

    private h a(Object obj, com.baidu.tieba.im.data.a aVar) {
        h hVar;
        if (obj == null) {
            hVar = Vx();
        } else {
            hVar = (h) obj;
        }
        a(hVar, aVar.PL());
        hVar.azB.setText(aVar.getUserName());
        hVar.bsz.setTag(aVar);
        this.bsv.getLayoutMode().h(hVar.rootView);
        return hVar;
    }

    private void a(h hVar, String str) {
        if (str != null) {
            hVar.bsy.setTag(str);
            hVar.bsy.c(str, 12, false);
        }
    }
}
