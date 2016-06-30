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
import com.baidu.tieba.u;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class n extends BaseAdapter {
    private ArrayList<MetaData> SV;
    private TbCheckBox.a dcg;
    private AtListActivity fHV;
    private boolean fHX;
    private final Context mContext;
    private b fHW = null;
    private ViewGroup dci = null;

    /* loaded from: classes.dex */
    public interface b {
        void a(View view, MetaData metaData);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b bVar) {
        this.fHW = bVar;
    }

    public n(AtListActivity atListActivity, boolean z) {
        this.fHX = true;
        this.fHV = atListActivity;
        this.mContext = this.fHV.getPageContext().getContext();
        this.fHX = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setData(ArrayList<MetaData> arrayList) {
        this.SV = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(TbCheckBox.a aVar) {
        this.dcg = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.SV == null) {
            return 0;
        }
        return this.SV.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: sA */
    public MetaData getItem(int i) {
        if (this.SV != null && i < this.SV.size()) {
            return this.SV.get(i);
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
        if (this.dci == null) {
            this.dci = viewGroup;
        }
        MetaData item = getItem(i);
        if (item != null) {
            aVar = a(view != null ? view.getTag() : null, item);
        } else {
            aVar = null;
        }
        if (aVar != null) {
            return aVar.axa;
        }
        return null;
    }

    private a a(Object obj, MetaData metaData) {
        a aVar;
        int skinType = TbadkCoreApplication.m9getInst().getSkinType();
        if (obj == null) {
            aVar = blP();
        } else {
            aVar = (a) obj;
        }
        if (this.fHW != null) {
            this.fHW.a(aVar.axa, metaData);
        }
        String portrait = metaData.getPortrait();
        aVar.aOX.setText(metaData.getName_show());
        aVar.dck.setTagData(metaData);
        aVar.dbP.setTag(portrait);
        if (this.fHX) {
            aVar.dck.setVisibility(0);
        } else {
            aVar.dck.setVisibility(8);
        }
        aVar.dbP.c(portrait, 12, false);
        this.fHV.getPageContext().getLayoutMode().ad(skinType == 1);
        this.fHV.getPageContext().getLayoutMode().w(aVar.axa);
        return aVar;
    }

    private a blP() {
        a aVar = new a(this, null);
        aVar.axa = LayoutInflater.from(this.mContext).inflate(u.h.invite_friend_list_item, (ViewGroup) null);
        aVar.dbP = (HeadImageView) aVar.axa.findViewById(u.g.photo);
        aVar.dbP.setIsRound(false);
        aVar.aOX = (TextView) aVar.axa.findViewById(u.g.txt_user_name);
        aVar.dck = (TbCheckBox) aVar.axa.findViewById(u.g.ckb_select);
        if (this.dcg != null) {
            aVar.dck.setStatedChangedListener(this.dcg);
        }
        aVar.axa.setTag(aVar);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public TextView aOX;
        public View axa;
        public HeadImageView dbP;
        public TbCheckBox dck;

        private a() {
        }

        /* synthetic */ a(n nVar, a aVar) {
            this();
        }
    }
}
