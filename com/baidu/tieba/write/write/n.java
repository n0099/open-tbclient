package com.baidu.tieba.write.write;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tieba.w;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class n extends BaseAdapter {
    private ArrayList<MetaData> abo;
    private TbCheckBox.a dli;
    private AtListActivity fTb;
    private boolean fTd;
    private final Context mContext;
    private b fTc = null;
    private ViewGroup cHu = null;

    /* loaded from: classes.dex */
    public interface b {
        void a(View view, MetaData metaData);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b bVar) {
        this.fTc = bVar;
    }

    public n(AtListActivity atListActivity, boolean z) {
        this.fTd = true;
        this.fTb = atListActivity;
        this.mContext = this.fTb.getPageContext().getContext();
        this.fTd = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setData(ArrayList<MetaData> arrayList) {
        this.abo = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(TbCheckBox.a aVar) {
        this.dli = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.abo == null) {
            return 0;
        }
        return this.abo.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: tm */
    public MetaData getItem(int i) {
        if (this.abo != null && i < this.abo.size()) {
            return this.abo.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (this.cHu == null) {
            this.cHu = viewGroup;
        }
        MetaData item = getItem(i);
        if (item != null) {
            aVar = a(view != null ? view.getTag() : null, item);
        } else {
            aVar = null;
        }
        if (aVar != null) {
            return aVar.rootView;
        }
        return null;
    }

    private a a(Object obj, MetaData metaData) {
        a aVar;
        int skinType = TbadkCoreApplication.m9getInst().getSkinType();
        if (obj == null) {
            aVar = bpT();
        } else {
            aVar = (a) obj;
        }
        if (this.fTc != null) {
            this.fTc.a(aVar.rootView, metaData);
        }
        String portrait = metaData.getPortrait();
        aVar.bux.setText(metaData.getName_show());
        aVar.dll.setTagData(metaData);
        aVar.dkS.setTag(portrait);
        if (this.fTd) {
            aVar.dll.setVisibility(0);
        } else {
            aVar.dll.setVisibility(8);
        }
        aVar.dkS.c(portrait, 12, false);
        this.fTb.getPageContext().getLayoutMode().aj(skinType == 1);
        this.fTb.getPageContext().getLayoutMode().t(aVar.rootView);
        return aVar;
    }

    private a bpT() {
        a aVar = new a(this, null);
        aVar.rootView = LayoutInflater.from(this.mContext).inflate(w.j.invite_friend_list_item, (ViewGroup) null);
        aVar.dkS = (HeadImageView) aVar.rootView.findViewById(w.h.photo);
        aVar.dkS.setIsRound(false);
        aVar.bux = (TextView) aVar.rootView.findViewById(w.h.txt_user_name);
        aVar.dll = (TbCheckBox) aVar.rootView.findViewById(w.h.ckb_select);
        if (this.dli != null) {
            aVar.dll.setStatedChangedListener(this.dli);
        }
        aVar.rootView.setTag(aVar);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public TextView bux;
        public HeadImageView dkS;
        public TbCheckBox dll;
        public View rootView;

        private a() {
        }

        /* synthetic */ a(n nVar, a aVar) {
            this();
        }
    }
}
