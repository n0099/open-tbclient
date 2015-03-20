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
    private ArrayList<com.baidu.tieba.im.data.a> auC;
    private IMBlackListActivity bsf;
    private View.OnClickListener bsg = new g(this);

    /* JADX INFO: Access modifiers changed from: protected */
    public f(IMBlackListActivity iMBlackListActivity) {
        this.bsf = iMBlackListActivity;
    }

    public void p(ArrayList<com.baidu.tieba.im.data.a> arrayList) {
        this.auC = arrayList;
    }

    public void b(com.baidu.tieba.im.data.a aVar) {
        if (this.auC != null) {
            this.auC.remove(aVar);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.auC != null) {
            return this.auC.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.auC != null) {
            return this.auC.get(i);
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

    private h Vk() {
        h hVar = new h(this, null);
        hVar.rootView = com.baidu.adp.lib.g.b.hH().inflate(this.bsf.getPageContext().getContext(), com.baidu.tieba.w.im_black_list_item, null);
        hVar.bsi = (HeadImageView) hVar.rootView.findViewById(com.baidu.tieba.v.header_view);
        hVar.bsi.setIsRound(true);
        hVar.azt = (TextView) hVar.rootView.findViewById(com.baidu.tieba.v.user_name);
        hVar.bsj = (Button) hVar.rootView.findViewById(com.baidu.tieba.v.remove_button);
        hVar.rootView.setTag(hVar);
        hVar.bsj.setOnClickListener(this.bsg);
        return hVar;
    }

    private h a(Object obj, com.baidu.tieba.im.data.a aVar) {
        h hVar;
        if (obj == null) {
            hVar = Vk();
        } else {
            hVar = (h) obj;
        }
        a(hVar, aVar.Py());
        hVar.azt.setText(aVar.getUserName());
        hVar.bsj.setTag(aVar);
        this.bsf.getLayoutMode().h(hVar.rootView);
        return hVar;
    }

    private void a(h hVar, String str) {
        if (str != null) {
            hVar.bsi.setTag(str);
            hVar.bsi.c(str, 12, false);
        }
    }
}
