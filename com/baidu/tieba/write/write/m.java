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
    private ArrayList<MetaData> Xe;
    private AtListActivity cTm;
    private boolean cTo;
    private TbCheckBox.a mCheckBoxStateChangedListener;
    private final Context mContext;
    private b cTn = null;
    private ViewGroup bJv = null;

    /* loaded from: classes.dex */
    public interface b {
        void a(View view, MetaData metaData);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b bVar) {
        this.cTn = bVar;
    }

    public m(AtListActivity atListActivity, boolean z) {
        this.cTo = true;
        this.cTm = atListActivity;
        this.mContext = this.cTm.getPageContext().getContext();
        this.cTo = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setData(ArrayList<MetaData> arrayList) {
        this.Xe = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setCheckBoxStateChangedListener(TbCheckBox.a aVar) {
        this.mCheckBoxStateChangedListener = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.Xe == null) {
            return 0;
        }
        return this.Xe.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: kw */
    public MetaData getItem(int i) {
        if (this.Xe != null && i < this.Xe.size()) {
            return this.Xe.get(i);
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
        if (this.bJv == null) {
            this.bJv = viewGroup;
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
            aVar = auI();
        } else {
            aVar = (a) obj;
        }
        if (this.cTn != null) {
            this.cTn.a(aVar.rootView, metaData);
        }
        String portrait = metaData.getPortrait();
        aVar.aII.setText(metaData.getName_show());
        aVar.bJx.setTagData(metaData);
        aVar.bJb.setTag(portrait);
        if (this.cTo) {
            aVar.bJx.setVisibility(0);
        } else {
            aVar.bJx.setVisibility(8);
        }
        aVar.bJb.d(portrait, 12, false);
        this.cTm.getPageContext().getLayoutMode().ad(skinType == 1);
        this.cTm.getPageContext().getLayoutMode().k(aVar.rootView);
        return aVar;
    }

    private a auI() {
        a aVar = new a(this, null);
        aVar.rootView = LayoutInflater.from(this.mContext).inflate(i.g.invite_friend_list_item, (ViewGroup) null);
        aVar.bJb = (HeadImageView) aVar.rootView.findViewById(i.f.photo);
        aVar.bJb.setIsRound(false);
        aVar.aII = (TextView) aVar.rootView.findViewById(i.f.txt_user_name);
        aVar.bJx = (TbCheckBox) aVar.rootView.findViewById(i.f.ckb_select);
        if (this.mCheckBoxStateChangedListener != null) {
            aVar.bJx.setStatedChangedListener(this.mCheckBoxStateChangedListener);
        }
        aVar.rootView.setTag(aVar);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public TextView aII;
        public HeadImageView bJb;
        public TbCheckBox bJx;
        public View rootView;

        private a() {
        }

        /* synthetic */ a(m mVar, a aVar) {
            this();
        }
    }
}
