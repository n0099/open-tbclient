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
    private com.baidu.tbadk.core.view.ai bav;
    private AtListActivity cea;
    private boolean cec;
    private final Context mContext;
    private ArrayList<MetaData> mData;
    private l ceb = null;
    private ViewGroup bax = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(l lVar) {
        this.ceb = lVar;
    }

    public j(AtListActivity atListActivity, boolean z) {
        this.cec = true;
        this.cea = atListActivity;
        this.mContext = this.cea.getPageContext().getContext();
        this.cec = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r(ArrayList<MetaData> arrayList) {
        this.mData = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(com.baidu.tbadk.core.view.ai aiVar) {
        this.bav = aiVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.mData == null) {
            return 0;
        }
        return this.mData.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: im */
    public MetaData getItem(int i) {
        if (this.mData != null && i < this.mData.size()) {
            return this.mData.get(i);
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
        if (this.bax == null) {
            this.bax = viewGroup;
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
            kVar = ajI();
        } else {
            kVar = (k) obj;
        }
        if (this.ceb != null) {
            this.ceb.a(kVar.rootView, metaData);
        }
        String portrait = metaData.getPortrait();
        kVar.aFV.setText(metaData.getName_show());
        kVar.baz.setTagData(metaData);
        kVar.bab.setTag(portrait);
        if (this.cec) {
            kVar.baz.setVisibility(0);
        } else {
            kVar.baz.setVisibility(8);
        }
        kVar.bab.d(portrait, 12, false);
        this.cea.getPageContext().getLayoutMode().ab(skinType == 1);
        this.cea.getPageContext().getLayoutMode().h(kVar.rootView);
        return kVar;
    }

    private k ajI() {
        k kVar = new k(this, null);
        kVar.rootView = com.baidu.adp.lib.g.b.ek().inflate(this.mContext, com.baidu.tieba.x.invite_friend_list_item, null);
        kVar.bab = (HeadImageView) kVar.rootView.findViewById(com.baidu.tieba.w.photo);
        kVar.bab.setIsRound(false);
        kVar.aFV = (TextView) kVar.rootView.findViewById(com.baidu.tieba.w.txt_user_name);
        kVar.baz = (TbCheckBox) kVar.rootView.findViewById(com.baidu.tieba.w.ckb_select);
        if (this.bav != null) {
            kVar.baz.setStatedChangedListener(this.bav);
        }
        kVar.rootView.setTag(kVar);
        return kVar;
    }
}
