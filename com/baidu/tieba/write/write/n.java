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
    private ArrayList<MetaData> auC;
    private com.baidu.tbadk.core.view.aa bsC;
    private AtListActivity cwJ;
    private boolean cwL;
    private final Context mContext;
    private p cwK = null;
    private ViewGroup bsE = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(p pVar) {
        this.cwK = pVar;
    }

    public n(AtListActivity atListActivity, boolean z) {
        this.cwL = true;
        this.cwJ = atListActivity;
        this.mContext = this.cwJ.getPageContext().getContext();
        this.cwL = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(ArrayList<MetaData> arrayList) {
        this.auC = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(com.baidu.tbadk.core.view.aa aaVar) {
        this.bsC = aaVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.auC == null) {
            return 0;
        }
        return this.auC.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: jc */
    public MetaData getItem(int i) {
        if (this.auC != null && i < this.auC.size()) {
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
        o oVar;
        if (this.bsE == null) {
            this.bsE = viewGroup;
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
            oVar = aqL();
        } else {
            oVar = (o) obj;
        }
        if (this.cwK != null) {
            this.cwK.a(oVar.rootView, metaData);
        }
        String portrait = metaData.getPortrait();
        oVar.azt.setText(metaData.getName_show());
        oVar.bsG.setTagData(metaData);
        oVar.bsi.setTag(portrait);
        if (this.cwL) {
            oVar.bsG.setVisibility(0);
        } else {
            oVar.bsG.setVisibility(8);
        }
        oVar.bsi.c(portrait, 12, false);
        this.cwJ.getPageContext().getLayoutMode().X(skinType == 1);
        this.cwJ.getPageContext().getLayoutMode().h(oVar.rootView);
        return oVar;
    }

    private o aqL() {
        o oVar = new o(this, null);
        oVar.rootView = com.baidu.adp.lib.g.b.hH().inflate(this.mContext, com.baidu.tieba.w.invite_friend_list_item, null);
        oVar.bsi = (HeadImageView) oVar.rootView.findViewById(com.baidu.tieba.v.photo);
        oVar.bsi.setIsRound(false);
        oVar.azt = (TextView) oVar.rootView.findViewById(com.baidu.tieba.v.txt_user_name);
        oVar.bsG = (TbCheckBox) oVar.rootView.findViewById(com.baidu.tieba.v.ckb_select);
        if (this.bsC != null) {
            oVar.bsG.setStatedChangedListener(this.bsC);
        }
        oVar.rootView.setTag(oVar);
        return oVar;
    }
}
