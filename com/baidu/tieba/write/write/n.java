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
    private ArrayList<MetaData> VL;
    private TbCheckBox.a dia;
    private AtListActivity fKC;
    private boolean fKE;
    private final Context mContext;
    private b fKD = null;
    private ViewGroup cFj = null;

    /* loaded from: classes.dex */
    public interface b {
        void a(View view, MetaData metaData);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b bVar) {
        this.fKD = bVar;
    }

    public n(AtListActivity atListActivity, boolean z) {
        this.fKE = true;
        this.fKC = atListActivity;
        this.mContext = this.fKC.getPageContext().getContext();
        this.fKE = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setData(ArrayList<MetaData> arrayList) {
        this.VL = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(TbCheckBox.a aVar) {
        this.dia = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.VL == null) {
            return 0;
        }
        return this.VL.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: tj */
    public MetaData getItem(int i) {
        if (this.VL != null && i < this.VL.size()) {
            return this.VL.get(i);
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
        if (this.cFj == null) {
            this.cFj = viewGroup;
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
            aVar = bow();
        } else {
            aVar = (a) obj;
        }
        if (this.fKD != null) {
            this.fKD.a(aVar.rootView, metaData);
        }
        String portrait = metaData.getPortrait();
        aVar.blu.setText(metaData.getName_show());
        aVar.did.setTagData(metaData);
        aVar.dhK.setTag(portrait);
        if (this.fKE) {
            aVar.did.setVisibility(0);
        } else {
            aVar.did.setVisibility(8);
        }
        aVar.dhK.c(portrait, 12, false);
        this.fKC.getPageContext().getLayoutMode().ai(skinType == 1);
        this.fKC.getPageContext().getLayoutMode().v(aVar.rootView);
        return aVar;
    }

    private a bow() {
        a aVar = new a(this, null);
        aVar.rootView = LayoutInflater.from(this.mContext).inflate(r.j.invite_friend_list_item, (ViewGroup) null);
        aVar.dhK = (HeadImageView) aVar.rootView.findViewById(r.h.photo);
        aVar.dhK.setIsRound(false);
        aVar.blu = (TextView) aVar.rootView.findViewById(r.h.txt_user_name);
        aVar.did = (TbCheckBox) aVar.rootView.findViewById(r.h.ckb_select);
        if (this.dia != null) {
            aVar.did.setStatedChangedListener(this.dia);
        }
        aVar.rootView.setTag(aVar);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public TextView blu;
        public HeadImageView dhK;
        public TbCheckBox did;
        public View rootView;

        private a() {
        }

        /* synthetic */ a(n nVar, a aVar) {
            this();
        }
    }
}
