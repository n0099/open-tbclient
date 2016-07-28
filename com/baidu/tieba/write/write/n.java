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
    private ArrayList<MetaData> TD;
    private TbCheckBox.a dfe;
    private AtListActivity fTM;
    private boolean fTO;
    private final Context mContext;
    private b fTN = null;
    private ViewGroup dfg = null;

    /* loaded from: classes.dex */
    public interface b {
        void a(View view, MetaData metaData);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b bVar) {
        this.fTN = bVar;
    }

    public n(AtListActivity atListActivity, boolean z) {
        this.fTO = true;
        this.fTM = atListActivity;
        this.mContext = this.fTM.getPageContext().getContext();
        this.fTO = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setData(ArrayList<MetaData> arrayList) {
        this.TD = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(TbCheckBox.a aVar) {
        this.dfe = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.TD == null) {
            return 0;
        }
        return this.TD.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: sO */
    public MetaData getItem(int i) {
        if (this.TD != null && i < this.TD.size()) {
            return this.TD.get(i);
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
        if (this.dfg == null) {
            this.dfg = viewGroup;
        }
        MetaData item = getItem(i);
        if (item != null) {
            aVar = a(view != null ? view.getTag() : null, item);
        } else {
            aVar = null;
        }
        if (aVar != null) {
            return aVar.axO;
        }
        return null;
    }

    private a a(Object obj, MetaData metaData) {
        a aVar;
        int skinType = TbadkCoreApplication.m10getInst().getSkinType();
        if (obj == null) {
            aVar = boK();
        } else {
            aVar = (a) obj;
        }
        if (this.fTN != null) {
            this.fTN.a(aVar.axO, metaData);
        }
        String portrait = metaData.getPortrait();
        aVar.aPR.setText(metaData.getName_show());
        aVar.dfi.setTagData(metaData);
        aVar.deN.setTag(portrait);
        if (this.fTO) {
            aVar.dfi.setVisibility(0);
        } else {
            aVar.dfi.setVisibility(8);
        }
        aVar.deN.c(portrait, 12, false);
        this.fTM.getPageContext().getLayoutMode().af(skinType == 1);
        this.fTM.getPageContext().getLayoutMode().w(aVar.axO);
        return aVar;
    }

    private a boK() {
        a aVar = new a(this, null);
        aVar.axO = LayoutInflater.from(this.mContext).inflate(u.h.invite_friend_list_item, (ViewGroup) null);
        aVar.deN = (HeadImageView) aVar.axO.findViewById(u.g.photo);
        aVar.deN.setIsRound(false);
        aVar.aPR = (TextView) aVar.axO.findViewById(u.g.txt_user_name);
        aVar.dfi = (TbCheckBox) aVar.axO.findViewById(u.g.ckb_select);
        if (this.dfe != null) {
            aVar.dfi.setStatedChangedListener(this.dfe);
        }
        aVar.axO.setTag(aVar);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public TextView aPR;
        public View axO;
        public HeadImageView deN;
        public TbCheckBox dfi;

        private a() {
        }

        /* synthetic */ a(n nVar, a aVar) {
            this();
        }
    }
}
