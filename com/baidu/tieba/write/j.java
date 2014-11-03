package com.baidu.tieba.write;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.TbCheckBox;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class j extends BaseAdapter {
    private com.baidu.tbadk.core.view.w aWd;
    private ArrayList<MetaData> aeE;
    private boolean bSW;
    private final Context mContext;
    private l bSV = null;
    private ViewGroup aWf = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(l lVar) {
        this.bSV = lVar;
    }

    public j(Context context, boolean z) {
        this.bSW = true;
        this.mContext = context;
        this.bSW = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setData(ArrayList<MetaData> arrayList) {
        this.aeE = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(com.baidu.tbadk.core.view.w wVar) {
        this.aWd = wVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aeE == null) {
            return 0;
        }
        return this.aeE.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: hE */
    public MetaData getItem(int i) {
        if (this.aeE != null && i < this.aeE.size()) {
            return this.aeE.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        k kVar;
        if (this.aWf == null) {
            this.aWf = viewGroup;
        }
        MetaData item = getItem(i);
        if (item != null) {
            kVar = a(view != null ? view.getTag() : null, item);
        } else {
            kVar = null;
        }
        if (kVar != null) {
            return kVar.Xm;
        }
        return null;
    }

    private k a(Object obj, MetaData metaData) {
        k kVar;
        int skinType = TbadkApplication.m251getInst().getSkinType();
        if (obj == null) {
            kVar = afe();
        } else {
            kVar = (k) obj;
        }
        if (this.bSV != null) {
            this.bSV.a(kVar.Xm, metaData);
        }
        String portrait = metaData.getPortrait();
        kVar.aEq.setText(metaData.getName_show());
        kVar.aWh.setTagData(metaData);
        kVar.aVK.setTag(portrait);
        if (this.bSW) {
            kVar.aWh.setVisibility(0);
        } else {
            kVar.aWh.setVisibility(8);
        }
        kVar.aVK.c(portrait, 12, false);
        if (this.mContext instanceof AtListActivity) {
            ((AtListActivity) this.mContext).getLayoutMode().L(skinType == 1);
            ((AtListActivity) this.mContext).getLayoutMode().h(kVar.Xm);
        }
        return kVar;
    }

    private k afe() {
        k kVar = new k(this, null);
        kVar.Xm = com.baidu.adp.lib.g.b.ek().inflate(this.mContext, com.baidu.tieba.w.invite_friend_list_item, null);
        kVar.aVK = (HeadImageView) kVar.Xm.findViewById(com.baidu.tieba.v.photo);
        kVar.aVK.setIsRound(false);
        kVar.aEq = (TextView) kVar.Xm.findViewById(com.baidu.tieba.v.txt_user_name);
        kVar.aWh = (TbCheckBox) kVar.Xm.findViewById(com.baidu.tieba.v.ckb_select);
        if (this.aWd != null) {
            kVar.aWh.setStatedChangedListener(this.aWd);
        }
        kVar.Xm.setTag(kVar);
        return kVar;
    }
}
