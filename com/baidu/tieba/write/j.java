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
    private com.baidu.tbadk.core.view.w aVP;
    private ArrayList<MetaData> aew;
    private boolean bSH;
    private final Context mContext;
    private l bSG = null;
    private ViewGroup aVR = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(l lVar) {
        this.bSG = lVar;
    }

    public j(Context context, boolean z) {
        this.bSH = true;
        this.mContext = context;
        this.bSH = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setData(ArrayList<MetaData> arrayList) {
        this.aew = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(com.baidu.tbadk.core.view.w wVar) {
        this.aVP = wVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aew == null) {
            return 0;
        }
        return this.aew.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: hE */
    public MetaData getItem(int i) {
        if (this.aew != null && i < this.aew.size()) {
            return this.aew.get(i);
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
        if (this.aVR == null) {
            this.aVR = viewGroup;
        }
        MetaData item = getItem(i);
        if (item != null) {
            kVar = a(view != null ? view.getTag() : null, item);
        } else {
            kVar = null;
        }
        if (kVar != null) {
            return kVar.Xi;
        }
        return null;
    }

    private k a(Object obj, MetaData metaData) {
        k kVar;
        int skinType = TbadkApplication.m251getInst().getSkinType();
        if (obj == null) {
            kVar = afb();
        } else {
            kVar = (k) obj;
        }
        if (this.bSG != null) {
            this.bSG.a(kVar.Xi, metaData);
        }
        String portrait = metaData.getPortrait();
        kVar.aEg.setText(metaData.getName_show());
        kVar.aVT.setTagData(metaData);
        kVar.aVw.setTag(portrait);
        if (this.bSH) {
            kVar.aVT.setVisibility(0);
        } else {
            kVar.aVT.setVisibility(8);
        }
        kVar.aVw.c(portrait, 12, false);
        if (this.mContext instanceof AtListActivity) {
            ((AtListActivity) this.mContext).getLayoutMode().L(skinType == 1);
            ((AtListActivity) this.mContext).getLayoutMode().h(kVar.Xi);
        }
        return kVar;
    }

    private k afb() {
        k kVar = new k(this, null);
        kVar.Xi = com.baidu.adp.lib.g.b.ek().inflate(this.mContext, com.baidu.tieba.w.invite_friend_list_item, null);
        kVar.aVw = (HeadImageView) kVar.Xi.findViewById(com.baidu.tieba.v.photo);
        kVar.aVw.setIsRound(false);
        kVar.aEg = (TextView) kVar.Xi.findViewById(com.baidu.tieba.v.txt_user_name);
        kVar.aVT = (TbCheckBox) kVar.Xi.findViewById(com.baidu.tieba.v.ckb_select);
        if (this.aVP != null) {
            kVar.aVT.setStatedChangedListener(this.aVP);
        }
        kVar.Xi.setTag(kVar);
        return kVar;
    }
}
