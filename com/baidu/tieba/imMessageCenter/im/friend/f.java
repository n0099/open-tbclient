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
    private ArrayList<com.baidu.tieba.im.data.a> Sk;
    private IMBlackListActivity bvh;
    private View.OnClickListener mItemClickListener = new g(this);

    /* JADX INFO: Access modifiers changed from: protected */
    public f(IMBlackListActivity iMBlackListActivity) {
        this.bvh = iMBlackListActivity;
    }

    public void setData(ArrayList<com.baidu.tieba.im.data.a> arrayList) {
        this.Sk = arrayList;
    }

    public void b(com.baidu.tieba.im.data.a aVar) {
        if (this.Sk != null) {
            this.Sk.remove(aVar);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.Sk != null) {
            return this.Sk.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.Sk != null) {
            return this.Sk.get(i);
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

    private h WP() {
        h hVar = new h(this, null);
        hVar.rootView = com.baidu.adp.lib.g.b.hr().inflate(this.bvh.getPageContext().getContext(), com.baidu.tieba.r.im_black_list_item, null);
        hVar.bvj = (HeadImageView) hVar.rootView.findViewById(com.baidu.tieba.q.header_view);
        hVar.bvj.setIsRound(true);
        hVar.aBm = (TextView) hVar.rootView.findViewById(com.baidu.tieba.q.user_name);
        hVar.bvk = (Button) hVar.rootView.findViewById(com.baidu.tieba.q.remove_button);
        hVar.rootView.setTag(hVar);
        hVar.bvk.setOnClickListener(this.mItemClickListener);
        return hVar;
    }

    private h a(Object obj, com.baidu.tieba.im.data.a aVar) {
        h hVar;
        if (obj == null) {
            hVar = WP();
        } else {
            hVar = (h) obj;
        }
        a(hVar, aVar.Ra());
        hVar.aBm.setText(aVar.getUserName());
        hVar.bvk.setTag(aVar);
        this.bvh.getLayoutMode().j(hVar.rootView);
        return hVar;
    }

    private void a(h hVar, String str) {
        if (str != null) {
            hVar.bvj.setTag(str);
            hVar.bvj.c(str, 12, false);
        }
    }
}
