package com.baidu.tieba.write;

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
public class j extends BaseAdapter {
    private ArrayList<MetaData> amP;
    private com.baidu.tbadk.core.view.ai bbR;
    private boolean cfB;
    private AtListActivity cfz;
    private final Context mContext;
    private l cfA = null;
    private ViewGroup aqv = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(l lVar) {
        this.cfA = lVar;
    }

    public j(AtListActivity atListActivity, boolean z) {
        this.cfB = true;
        this.cfz = atListActivity;
        this.mContext = this.cfz.getPageContext().getContext();
        this.cfB = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s(ArrayList<MetaData> arrayList) {
        this.amP = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(com.baidu.tbadk.core.view.ai aiVar) {
        this.bbR = aiVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.amP == null) {
            return 0;
        }
        return this.amP.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: ir */
    public MetaData getItem(int i) {
        if (this.amP != null && i < this.amP.size()) {
            return this.amP.get(i);
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
        if (this.aqv == null) {
            this.aqv = viewGroup;
        }
        MetaData item = getItem(i);
        if (item != null) {
            kVar = a(view != null ? view.getTag() : null, item);
        } else {
            kVar = null;
        }
        if (kVar != null) {
            return kVar.rootView;
        }
        return null;
    }

    private k a(Object obj, MetaData metaData) {
        k kVar;
        int skinType = TbadkCoreApplication.m255getInst().getSkinType();
        if (obj == null) {
            kVar = akf();
        } else {
            kVar = (k) obj;
        }
        if (this.cfA != null) {
            this.cfA.a(kVar.rootView, metaData);
        }
        String portrait = metaData.getPortrait();
        kVar.aHf.setText(metaData.getName_show());
        kVar.bbU.setTagData(metaData);
        kVar.bby.setTag(portrait);
        if (this.cfB) {
            kVar.bbU.setVisibility(0);
        } else {
            kVar.bbU.setVisibility(8);
        }
        kVar.bby.d(portrait, 12, false);
        this.cfz.getPageContext().getLayoutMode().ab(skinType == 1);
        this.cfz.getPageContext().getLayoutMode().h(kVar.rootView);
        return kVar;
    }

    private k akf() {
        k kVar = new k(this, null);
        kVar.rootView = com.baidu.adp.lib.g.b.ei().inflate(this.mContext, com.baidu.tieba.x.invite_friend_list_item, null);
        kVar.bby = (HeadImageView) kVar.rootView.findViewById(com.baidu.tieba.w.photo);
        kVar.bby.setIsRound(false);
        kVar.aHf = (TextView) kVar.rootView.findViewById(com.baidu.tieba.w.txt_user_name);
        kVar.bbU = (TbCheckBox) kVar.rootView.findViewById(com.baidu.tieba.w.ckb_select);
        if (this.bbR != null) {
            kVar.bbU.setStatedChangedListener(this.bbR);
        }
        kVar.rootView.setTag(kVar);
        return kVar;
    }
}
