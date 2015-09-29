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
import com.baidu.tieba.i;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class m extends BaseAdapter {
    private ArrayList<MetaData> Xf;
    private AtListActivity doa;
    private boolean doc;
    private TbCheckBox.a mCheckBoxStateChangedListener;
    private final Context mContext;
    private b dob = null;
    private ViewGroup bNh = null;

    /* loaded from: classes.dex */
    public interface b {
        void a(View view, MetaData metaData);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b bVar) {
        this.dob = bVar;
    }

    public m(AtListActivity atListActivity, boolean z) {
        this.doc = true;
        this.doa = atListActivity;
        this.mContext = this.doa.getPageContext().getContext();
        this.doc = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setData(ArrayList<MetaData> arrayList) {
        this.Xf = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setCheckBoxStateChangedListener(TbCheckBox.a aVar) {
        this.mCheckBoxStateChangedListener = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.Xf == null) {
            return 0;
        }
        return this.Xf.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: mg */
    public MetaData getItem(int i) {
        if (this.Xf != null && i < this.Xf.size()) {
            return this.Xf.get(i);
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
        if (this.bNh == null) {
            this.bNh = viewGroup;
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
            aVar = aCM();
        } else {
            aVar = (a) obj;
        }
        if (this.dob != null) {
            this.dob.a(aVar.rootView, metaData);
        }
        String portrait = metaData.getPortrait();
        aVar.aHN.setText(metaData.getName_show());
        aVar.bNj.setTagData(metaData);
        aVar.bMN.setTag(portrait);
        if (this.doc) {
            aVar.bNj.setVisibility(0);
        } else {
            aVar.bNj.setVisibility(8);
        }
        aVar.bMN.d(portrait, 12, false);
        this.doa.getPageContext().getLayoutMode().ad(skinType == 1);
        this.doa.getPageContext().getLayoutMode().k(aVar.rootView);
        return aVar;
    }

    private a aCM() {
        a aVar = new a(this, null);
        aVar.rootView = LayoutInflater.from(this.mContext).inflate(i.g.invite_friend_list_item, (ViewGroup) null);
        aVar.bMN = (HeadImageView) aVar.rootView.findViewById(i.f.photo);
        aVar.bMN.setIsRound(false);
        aVar.aHN = (TextView) aVar.rootView.findViewById(i.f.txt_user_name);
        aVar.bNj = (TbCheckBox) aVar.rootView.findViewById(i.f.ckb_select);
        if (this.mCheckBoxStateChangedListener != null) {
            aVar.bNj.setStatedChangedListener(this.mCheckBoxStateChangedListener);
        }
        aVar.rootView.setTag(aVar);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public TextView aHN;
        public HeadImageView bMN;
        public TbCheckBox bNj;
        public View rootView;

        private a() {
        }

        /* synthetic */ a(m mVar, a aVar) {
            this();
        }
    }
}
