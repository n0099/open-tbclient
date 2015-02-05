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
    private ArrayList<MetaData> amM;
    private com.baidu.tbadk.core.view.ai bbQ;
    private boolean cfA;
    private AtListActivity cfy;
    private final Context mContext;
    private l cfz = null;
    private ViewGroup aqs = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(l lVar) {
        this.cfz = lVar;
    }

    public j(AtListActivity atListActivity, boolean z) {
        this.cfA = true;
        this.cfy = atListActivity;
        this.mContext = this.cfy.getPageContext().getContext();
        this.cfA = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s(ArrayList<MetaData> arrayList) {
        this.amM = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(com.baidu.tbadk.core.view.ai aiVar) {
        this.bbQ = aiVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.amM == null) {
            return 0;
        }
        return this.amM.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: ir */
    public MetaData getItem(int i) {
        if (this.amM != null && i < this.amM.size()) {
            return this.amM.get(i);
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
        if (this.aqs == null) {
            this.aqs = viewGroup;
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
            kVar = aka();
        } else {
            kVar = (k) obj;
        }
        if (this.cfz != null) {
            this.cfz.a(kVar.rootView, metaData);
        }
        String portrait = metaData.getPortrait();
        kVar.aHc.setText(metaData.getName_show());
        kVar.bbT.setTagData(metaData);
        kVar.bbx.setTag(portrait);
        if (this.cfA) {
            kVar.bbT.setVisibility(0);
        } else {
            kVar.bbT.setVisibility(8);
        }
        kVar.bbx.d(portrait, 12, false);
        this.cfy.getPageContext().getLayoutMode().ab(skinType == 1);
        this.cfy.getPageContext().getLayoutMode().h(kVar.rootView);
        return kVar;
    }

    private k aka() {
        k kVar = new k(this, null);
        kVar.rootView = com.baidu.adp.lib.g.b.ei().inflate(this.mContext, com.baidu.tieba.x.invite_friend_list_item, null);
        kVar.bbx = (HeadImageView) kVar.rootView.findViewById(com.baidu.tieba.w.photo);
        kVar.bbx.setIsRound(false);
        kVar.aHc = (TextView) kVar.rootView.findViewById(com.baidu.tieba.w.txt_user_name);
        kVar.bbT = (TbCheckBox) kVar.rootView.findViewById(com.baidu.tieba.w.ckb_select);
        if (this.bbQ != null) {
            kVar.bbT.setStatedChangedListener(this.bbQ);
        }
        kVar.rootView.setTag(kVar);
        return kVar;
    }
}
