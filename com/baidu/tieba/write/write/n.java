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
    private ArrayList<MetaData> WD;
    private TbCheckBox.a dsi;
    private AtListActivity gga;
    private boolean ggc;
    private final Context mContext;
    private b ggb = null;
    private ViewGroup dsk = null;

    /* loaded from: classes.dex */
    public interface b {
        void a(View view, MetaData metaData);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b bVar) {
        this.ggb = bVar;
    }

    public n(AtListActivity atListActivity, boolean z) {
        this.ggc = true;
        this.gga = atListActivity;
        this.mContext = this.gga.getPageContext().getContext();
        this.ggc = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setData(ArrayList<MetaData> arrayList) {
        this.WD = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(TbCheckBox.a aVar) {
        this.dsi = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.WD == null) {
            return 0;
        }
        return this.WD.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: tD */
    public MetaData getItem(int i) {
        if (this.WD != null && i < this.WD.size()) {
            return this.WD.get(i);
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
        if (this.dsk == null) {
            this.dsk = viewGroup;
        }
        MetaData item = getItem(i);
        if (item != null) {
            aVar = a(view != null ? view.getTag() : null, item);
        } else {
            aVar = null;
        }
        if (aVar != null) {
            return aVar.aAy;
        }
        return null;
    }

    private a a(Object obj, MetaData metaData) {
        a aVar;
        int skinType = TbadkCoreApplication.m9getInst().getSkinType();
        if (obj == null) {
            aVar = btF();
        } else {
            aVar = (a) obj;
        }
        if (this.ggb != null) {
            this.ggb.a(aVar.aAy, metaData);
        }
        String portrait = metaData.getPortrait();
        aVar.aVU.setText(metaData.getName_show());
        aVar.dsm.setTagData(metaData);
        aVar.drR.setTag(portrait);
        if (this.ggc) {
            aVar.dsm.setVisibility(0);
        } else {
            aVar.dsm.setVisibility(8);
        }
        aVar.drR.c(portrait, 12, false);
        this.gga.getPageContext().getLayoutMode().ah(skinType == 1);
        this.gga.getPageContext().getLayoutMode().x(aVar.aAy);
        return aVar;
    }

    private a btF() {
        a aVar = new a(this, null);
        aVar.aAy = LayoutInflater.from(this.mContext).inflate(r.h.invite_friend_list_item, (ViewGroup) null);
        aVar.drR = (HeadImageView) aVar.aAy.findViewById(r.g.photo);
        aVar.drR.setIsRound(false);
        aVar.aVU = (TextView) aVar.aAy.findViewById(r.g.txt_user_name);
        aVar.dsm = (TbCheckBox) aVar.aAy.findViewById(r.g.ckb_select);
        if (this.dsi != null) {
            aVar.dsm.setStatedChangedListener(this.dsi);
        }
        aVar.aAy.setTag(aVar);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public View aAy;
        public TextView aVU;
        public HeadImageView drR;
        public TbCheckBox dsm;

        private a() {
        }

        /* synthetic */ a(n nVar, a aVar) {
            this();
        }
    }
}
