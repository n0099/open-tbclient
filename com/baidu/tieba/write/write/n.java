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
import com.baidu.tieba.r;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class n extends BaseAdapter {
    private ArrayList<MetaData> Xb;
    private TbCheckBox.a dxO;
    private AtListActivity gnE;
    private boolean gnG;
    private final Context mContext;
    private b gnF = null;
    private ViewGroup cSX = null;

    /* loaded from: classes.dex */
    public interface b {
        void a(View view, MetaData metaData);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b bVar) {
        this.gnF = bVar;
    }

    public n(AtListActivity atListActivity, boolean z) {
        this.gnG = true;
        this.gnE = atListActivity;
        this.mContext = this.gnE.getPageContext().getContext();
        this.gnG = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setData(ArrayList<MetaData> arrayList) {
        this.Xb = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(TbCheckBox.a aVar) {
        this.dxO = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.Xb == null) {
            return 0;
        }
        return this.Xb.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: tZ */
    public MetaData getItem(int i) {
        if (this.Xb != null && i < this.Xb.size()) {
            return this.Xb.get(i);
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
        if (this.cSX == null) {
            this.cSX = viewGroup;
        }
        MetaData item = getItem(i);
        if (item != null) {
            aVar = a(view != null ? view.getTag() : null, item);
        } else {
            aVar = null;
        }
        if (aVar != null) {
            return aVar.aBq;
        }
        return null;
    }

    private a a(Object obj, MetaData metaData) {
        a aVar;
        int skinType = TbadkCoreApplication.m9getInst().getSkinType();
        if (obj == null) {
            aVar = bwa();
        } else {
            aVar = (a) obj;
        }
        if (this.gnF != null) {
            this.gnF.a(aVar.aBq, metaData);
        }
        String portrait = metaData.getPortrait();
        aVar.aYg.setText(metaData.getName_show());
        aVar.dxR.setTagData(metaData);
        aVar.dxy.setTag(portrait);
        if (this.gnG) {
            aVar.dxR.setVisibility(0);
        } else {
            aVar.dxR.setVisibility(8);
        }
        aVar.dxy.c(portrait, 12, false);
        this.gnE.getPageContext().getLayoutMode().ai(skinType == 1);
        this.gnE.getPageContext().getLayoutMode().x(aVar.aBq);
        return aVar;
    }

    private a bwa() {
        a aVar = new a(this, null);
        aVar.aBq = LayoutInflater.from(this.mContext).inflate(r.h.invite_friend_list_item, (ViewGroup) null);
        aVar.dxy = (HeadImageView) aVar.aBq.findViewById(r.g.photo);
        aVar.dxy.setIsRound(false);
        aVar.aYg = (TextView) aVar.aBq.findViewById(r.g.txt_user_name);
        aVar.dxR = (TbCheckBox) aVar.aBq.findViewById(r.g.ckb_select);
        if (this.dxO != null) {
            aVar.dxR.setStatedChangedListener(this.dxO);
        }
        aVar.aBq.setTag(aVar);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public View aBq;
        public TextView aYg;
        public TbCheckBox dxR;
        public HeadImageView dxy;

        private a() {
        }

        /* synthetic */ a(n nVar, a aVar) {
            this();
        }
    }
}
