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
public class n extends BaseAdapter {
    private ArrayList<MetaData> auK;
    private com.baidu.tbadk.core.view.aa bsS;
    private AtListActivity cxc;
    private boolean cxe;
    private final Context mContext;
    private p cxd = null;
    private ViewGroup bsU = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(p pVar) {
        this.cxd = pVar;
    }

    public n(AtListActivity atListActivity, boolean z) {
        this.cxe = true;
        this.cxc = atListActivity;
        this.mContext = this.cxc.getPageContext().getContext();
        this.cxe = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(ArrayList<MetaData> arrayList) {
        this.auK = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(com.baidu.tbadk.core.view.aa aaVar) {
        this.bsS = aaVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.auK == null) {
            return 0;
        }
        return this.auK.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: jf */
    public MetaData getItem(int i) {
        if (this.auK != null && i < this.auK.size()) {
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
        o oVar;
        if (this.bsU == null) {
            this.bsU = viewGroup;
        }
        MetaData item = getItem(i);
        if (item != null) {
            oVar = a(view != null ? view.getTag() : null, item);
        } else {
            oVar = null;
        }
        if (oVar != null) {
            return oVar.rootView;
        }
        return null;
    }

    private o a(Object obj, MetaData metaData) {
        o oVar;
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        if (obj == null) {
            oVar = ara();
        } else {
            oVar = (o) obj;
        }
        if (this.cxd != null) {
            this.cxd.a(oVar.rootView, metaData);
        }
        String portrait = metaData.getPortrait();
        oVar.azB.setText(metaData.getName_show());
        oVar.bsW.setTagData(metaData);
        oVar.bsy.setTag(portrait);
        if (this.cxe) {
            oVar.bsW.setVisibility(0);
        } else {
            oVar.bsW.setVisibility(8);
        }
        oVar.bsy.c(portrait, 12, false);
        this.cxc.getPageContext().getLayoutMode().X(skinType == 1);
        this.cxc.getPageContext().getLayoutMode().h(oVar.rootView);
        return oVar;
    }

    private o ara() {
        o oVar = new o(this, null);
        oVar.rootView = com.baidu.adp.lib.g.b.hH().inflate(this.mContext, com.baidu.tieba.w.invite_friend_list_item, null);
        oVar.bsy = (HeadImageView) oVar.rootView.findViewById(com.baidu.tieba.v.photo);
        oVar.bsy.setIsRound(false);
        oVar.azB = (TextView) oVar.rootView.findViewById(com.baidu.tieba.v.txt_user_name);
        oVar.bsW = (TbCheckBox) oVar.rootView.findViewById(com.baidu.tieba.v.ckb_select);
        if (this.bsS != null) {
            oVar.bsW.setStatedChangedListener(this.bsS);
        }
        oVar.rootView.setTag(oVar);
        return oVar;
    }
}
