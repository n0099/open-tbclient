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
public class m extends BaseAdapter {
    private ArrayList<MetaData> YX;
    private TbCheckBox.a clq;
    private AtListActivity erK;
    private boolean erM;
    private final Context mContext;
    private b erL = null;
    private ViewGroup clt = null;

    /* loaded from: classes.dex */
    public interface b {
        void a(View view, MetaData metaData);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b bVar) {
        this.erL = bVar;
    }

    public m(AtListActivity atListActivity, boolean z) {
        this.erM = true;
        this.erK = atListActivity;
        this.mContext = this.erK.getPageContext().getContext();
        this.erM = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setData(ArrayList<MetaData> arrayList) {
        this.YX = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(TbCheckBox.a aVar) {
        this.clq = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.YX == null) {
            return 0;
        }
        return this.YX.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: pV */
    public MetaData getItem(int i) {
        if (this.YX != null && i < this.YX.size()) {
            return this.YX.get(i);
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
        if (this.clt == null) {
            this.clt = viewGroup;
        }
        MetaData item = getItem(i);
        if (item != null) {
            aVar = a(view != null ? view.getTag() : null, item);
        } else {
            aVar = null;
        }
        if (aVar != null) {
            return aVar.azA;
        }
        return null;
    }

    private a a(Object obj, MetaData metaData) {
        a aVar;
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        if (obj == null) {
            aVar = aUx();
        } else {
            aVar = (a) obj;
        }
        if (this.erL != null) {
            this.erL.a(aVar.azA, metaData);
        }
        String portrait = metaData.getPortrait();
        aVar.aMu.setText(metaData.getName_show());
        aVar.clv.setTagData(metaData);
        aVar.ckX.setTag(portrait);
        if (this.erM) {
            aVar.clv.setVisibility(0);
        } else {
            aVar.clv.setVisibility(8);
        }
        aVar.ckX.d(portrait, 12, false);
        this.erK.getPageContext().getLayoutMode().ac(skinType == 1);
        this.erK.getPageContext().getLayoutMode().x(aVar.azA);
        return aVar;
    }

    private a aUx() {
        a aVar = new a(this, null);
        aVar.azA = LayoutInflater.from(this.mContext).inflate(t.h.invite_friend_list_item, (ViewGroup) null);
        aVar.ckX = (HeadImageView) aVar.azA.findViewById(t.g.photo);
        aVar.ckX.setIsRound(false);
        aVar.aMu = (TextView) aVar.azA.findViewById(t.g.txt_user_name);
        aVar.clv = (TbCheckBox) aVar.azA.findViewById(t.g.ckb_select);
        if (this.clq != null) {
            aVar.clv.setStatedChangedListener(this.clq);
        }
        aVar.azA.setTag(aVar);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public TextView aMu;
        public View azA;
        public HeadImageView ckX;
        public TbCheckBox clv;

        private a() {
        }

        /* synthetic */ a(m mVar, a aVar) {
            this();
        }
    }
}
