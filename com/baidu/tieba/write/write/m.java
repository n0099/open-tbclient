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
import com.baidu.tieba.n;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class m extends BaseAdapter {
    private ArrayList<MetaData> YA;
    private AtListActivity dWR;
    private boolean dWT;
    private TbCheckBox.a mCheckBoxStateChangedListener;
    private final Context mContext;
    private b dWS = null;
    private ViewGroup cgR = null;

    /* loaded from: classes.dex */
    public interface b {
        void a(View view, MetaData metaData);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b bVar) {
        this.dWS = bVar;
    }

    public m(AtListActivity atListActivity, boolean z) {
        this.dWT = true;
        this.dWR = atListActivity;
        this.mContext = this.dWR.getPageContext().getContext();
        this.dWT = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setData(ArrayList<MetaData> arrayList) {
        this.YA = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setCheckBoxStateChangedListener(TbCheckBox.a aVar) {
        this.mCheckBoxStateChangedListener = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.YA == null) {
            return 0;
        }
        return this.YA.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: oA */
    public MetaData getItem(int i) {
        if (this.YA != null && i < this.YA.size()) {
            return this.YA.get(i);
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
        if (this.cgR == null) {
            this.cgR = viewGroup;
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
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        if (obj == null) {
            aVar = aLC();
        } else {
            aVar = (a) obj;
        }
        if (this.dWS != null) {
            this.dWS.a(aVar.rootView, metaData);
        }
        String portrait = metaData.getPortrait();
        aVar.aLp.setText(metaData.getName_show());
        aVar.cgT.setTagData(metaData);
        aVar.cgx.setTag(portrait);
        if (this.dWT) {
            aVar.cgT.setVisibility(0);
        } else {
            aVar.cgT.setVisibility(8);
        }
        aVar.cgx.d(portrait, 12, false);
        this.dWR.getPageContext().getLayoutMode().ac(skinType == 1);
        this.dWR.getPageContext().getLayoutMode().k(aVar.rootView);
        return aVar;
    }

    private a aLC() {
        a aVar = new a(this, null);
        aVar.rootView = LayoutInflater.from(this.mContext).inflate(n.h.invite_friend_list_item, (ViewGroup) null);
        aVar.cgx = (HeadImageView) aVar.rootView.findViewById(n.g.photo);
        aVar.cgx.setIsRound(false);
        aVar.aLp = (TextView) aVar.rootView.findViewById(n.g.txt_user_name);
        aVar.cgT = (TbCheckBox) aVar.rootView.findViewById(n.g.ckb_select);
        if (this.mCheckBoxStateChangedListener != null) {
            aVar.cgT.setStatedChangedListener(this.mCheckBoxStateChangedListener);
        }
        aVar.rootView.setTag(aVar);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public TextView aLp;
        public TbCheckBox cgT;
        public HeadImageView cgx;
        public View rootView;

        private a() {
        }

        /* synthetic */ a(m mVar, a aVar) {
            this();
        }
    }
}
