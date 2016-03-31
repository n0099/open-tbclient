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
import com.baidu.tieba.t;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class n extends BaseAdapter {
    private ArrayList<MetaData> Xq;
    private TbCheckBox.a cvU;
    private AtListActivity eLE;
    private boolean eLG;
    private final Context mContext;
    private b eLF = null;
    private ViewGroup cvW = null;

    /* loaded from: classes.dex */
    public interface b {
        void a(View view, MetaData metaData);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b bVar) {
        this.eLF = bVar;
    }

    public n(AtListActivity atListActivity, boolean z) {
        this.eLG = true;
        this.eLE = atListActivity;
        this.mContext = this.eLE.getPageContext().getContext();
        this.eLG = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setData(ArrayList<MetaData> arrayList) {
        this.Xq = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(TbCheckBox.a aVar) {
        this.cvU = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.Xq == null) {
            return 0;
        }
        return this.Xq.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: qP */
    public MetaData getItem(int i) {
        if (this.Xq != null && i < this.Xq.size()) {
            return this.Xq.get(i);
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
        if (this.cvW == null) {
            this.cvW = viewGroup;
        }
        MetaData item = getItem(i);
        if (item != null) {
            aVar = a(view != null ? view.getTag() : null, item);
        } else {
            aVar = null;
        }
        if (aVar != null) {
            return aVar.aAh;
        }
        return null;
    }

    private a a(Object obj, MetaData metaData) {
        a aVar;
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        if (obj == null) {
            aVar = baZ();
        } else {
            aVar = (a) obj;
        }
        if (this.eLF != null) {
            this.eLF.a(aVar.aAh, metaData);
        }
        String portrait = metaData.getPortrait();
        aVar.aPp.setText(metaData.getName_show());
        aVar.cvY.setTagData(metaData);
        aVar.cvC.setTag(portrait);
        if (this.eLG) {
            aVar.cvY.setVisibility(0);
        } else {
            aVar.cvY.setVisibility(8);
        }
        aVar.cvC.c(portrait, 12, false);
        this.eLE.getPageContext().getLayoutMode().ab(skinType == 1);
        this.eLE.getPageContext().getLayoutMode().x(aVar.aAh);
        return aVar;
    }

    private a baZ() {
        a aVar = new a(this, null);
        aVar.aAh = LayoutInflater.from(this.mContext).inflate(t.h.invite_friend_list_item, (ViewGroup) null);
        aVar.cvC = (HeadImageView) aVar.aAh.findViewById(t.g.photo);
        aVar.cvC.setIsRound(false);
        aVar.aPp = (TextView) aVar.aAh.findViewById(t.g.txt_user_name);
        aVar.cvY = (TbCheckBox) aVar.aAh.findViewById(t.g.ckb_select);
        if (this.cvU != null) {
            aVar.cvY.setStatedChangedListener(this.cvU);
        }
        aVar.aAh.setTag(aVar);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public View aAh;
        public TextView aPp;
        public HeadImageView cvC;
        public TbCheckBox cvY;

        private a() {
        }

        /* synthetic */ a(n nVar, a aVar) {
            this();
        }
    }
}
