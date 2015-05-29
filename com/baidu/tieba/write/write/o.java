package com.baidu.tieba.write.write;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.TbCheckBox;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class o extends BaseAdapter {
    private ArrayList<MetaData> Sk;
    private AtListActivity cBu;
    private boolean cBw;
    private com.baidu.tbadk.core.view.af mCheckBoxStateChangedListener;
    private final Context mContext;
    private q cBv = null;
    private ViewGroup bvE = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(q qVar) {
        this.cBv = qVar;
    }

    public o(AtListActivity atListActivity, boolean z) {
        this.cBw = true;
        this.cBu = atListActivity;
        this.mContext = this.cBu.getPageContext().getContext();
        this.cBw = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setData(ArrayList<MetaData> arrayList) {
        this.Sk = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setCheckBoxStateChangedListener(com.baidu.tbadk.core.view.af afVar) {
        this.mCheckBoxStateChangedListener = afVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.Sk == null) {
            return 0;
        }
        return this.Sk.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: jB */
    public MetaData getItem(int i) {
        if (this.Sk != null && i < this.Sk.size()) {
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
        p pVar;
        if (this.bvE == null) {
            this.bvE = viewGroup;
        }
        MetaData item = getItem(i);
        if (item != null) {
            pVar = a(view != null ? view.getTag() : null, item);
        } else {
            pVar = null;
        }
        if (pVar != null) {
            return pVar.rootView;
        }
        return null;
    }

    private p a(Object obj, MetaData metaData) {
        p pVar;
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        if (obj == null) {
            pVar = asQ();
        } else {
            pVar = (p) obj;
        }
        if (this.cBv != null) {
            this.cBv.a(pVar.rootView, metaData);
        }
        String portrait = metaData.getPortrait();
        pVar.aBm.setText(metaData.getName_show());
        pVar.bvG.setTagData(metaData);
        pVar.bvj.setTag(portrait);
        if (this.cBw) {
            pVar.bvG.setVisibility(0);
        } else {
            pVar.bvG.setVisibility(8);
        }
        pVar.bvj.c(portrait, 12, false);
        this.cBu.getPageContext().getLayoutMode().ab(skinType == 1);
        this.cBu.getPageContext().getLayoutMode().j(pVar.rootView);
        return pVar;
    }

    private p asQ() {
        p pVar = new p(this, null);
        pVar.rootView = com.baidu.adp.lib.g.b.hr().inflate(this.mContext, com.baidu.tieba.r.invite_friend_list_item, null);
        pVar.bvj = (HeadImageView) pVar.rootView.findViewById(com.baidu.tieba.q.photo);
        pVar.bvj.setIsRound(false);
        pVar.aBm = (TextView) pVar.rootView.findViewById(com.baidu.tieba.q.txt_user_name);
        pVar.bvG = (TbCheckBox) pVar.rootView.findViewById(com.baidu.tieba.q.ckb_select);
        if (this.mCheckBoxStateChangedListener != null) {
            pVar.bvG.setStatedChangedListener(this.mCheckBoxStateChangedListener);
        }
        pVar.rootView.setTag(pVar);
        return pVar;
    }
}
