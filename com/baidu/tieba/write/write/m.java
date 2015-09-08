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
    private ArrayList<MetaData> Xn;
    private AtListActivity dcj;
    private boolean dcl;
    private TbCheckBox.a mCheckBoxStateChangedListener;
    private final Context mContext;
    private b dck = null;
    private ViewGroup bKc = null;

    /* loaded from: classes.dex */
    public interface b {
        void a(View view, MetaData metaData);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b bVar) {
        this.dck = bVar;
    }

    public m(AtListActivity atListActivity, boolean z) {
        this.dcl = true;
        this.dcj = atListActivity;
        this.mContext = this.dcj.getPageContext().getContext();
        this.dcl = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setData(ArrayList<MetaData> arrayList) {
        this.Xn = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setCheckBoxStateChangedListener(TbCheckBox.a aVar) {
        this.mCheckBoxStateChangedListener = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.Xn == null) {
            return 0;
        }
        return this.Xn.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: lj */
    public MetaData getItem(int i) {
        if (this.Xn != null && i < this.Xn.size()) {
            return this.Xn.get(i);
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
        if (this.bKc == null) {
            this.bKc = viewGroup;
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
            aVar = azg();
        } else {
            aVar = (a) obj;
        }
        if (this.dck != null) {
            this.dck.a(aVar.rootView, metaData);
        }
        String portrait = metaData.getPortrait();
        aVar.aIV.setText(metaData.getName_show());
        aVar.bKe.setTagData(metaData);
        aVar.bJI.setTag(portrait);
        if (this.dcl) {
            aVar.bKe.setVisibility(0);
        } else {
            aVar.bKe.setVisibility(8);
        }
        aVar.bJI.d(portrait, 12, false);
        this.dcj.getPageContext().getLayoutMode().ad(skinType == 1);
        this.dcj.getPageContext().getLayoutMode().k(aVar.rootView);
        return aVar;
    }

    private a azg() {
        a aVar = new a(this, null);
        aVar.rootView = LayoutInflater.from(this.mContext).inflate(i.g.invite_friend_list_item, (ViewGroup) null);
        aVar.bJI = (HeadImageView) aVar.rootView.findViewById(i.f.photo);
        aVar.bJI.setIsRound(false);
        aVar.aIV = (TextView) aVar.rootView.findViewById(i.f.txt_user_name);
        aVar.bKe = (TbCheckBox) aVar.rootView.findViewById(i.f.ckb_select);
        if (this.mCheckBoxStateChangedListener != null) {
            aVar.bKe.setStatedChangedListener(this.mCheckBoxStateChangedListener);
        }
        aVar.rootView.setTag(aVar);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public TextView aIV;
        public HeadImageView bJI;
        public TbCheckBox bKe;
        public View rootView;

        private a() {
        }

        /* synthetic */ a(m mVar, a aVar) {
            this();
        }
    }
}
