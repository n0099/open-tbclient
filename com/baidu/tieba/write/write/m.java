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
    private ArrayList<MetaData> Xk;
    private AtListActivity dqp;
    private boolean dqr;
    private TbCheckBox.a mCheckBoxStateChangedListener;
    private final Context mContext;
    private b dqq = null;
    private ViewGroup bNN = null;

    /* loaded from: classes.dex */
    public interface b {
        void a(View view, MetaData metaData);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b bVar) {
        this.dqq = bVar;
    }

    public m(AtListActivity atListActivity, boolean z) {
        this.dqr = true;
        this.dqp = atListActivity;
        this.mContext = this.dqp.getPageContext().getContext();
        this.dqr = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setData(ArrayList<MetaData> arrayList) {
        this.Xk = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setCheckBoxStateChangedListener(TbCheckBox.a aVar) {
        this.mCheckBoxStateChangedListener = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.Xk == null) {
            return 0;
        }
        return this.Xk.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: mw */
    public MetaData getItem(int i) {
        if (this.Xk != null && i < this.Xk.size()) {
            return this.Xk.get(i);
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
        if (this.bNN == null) {
            this.bNN = viewGroup;
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
            aVar = aDK();
        } else {
            aVar = (a) obj;
        }
        if (this.dqq != null) {
            this.dqq.a(aVar.rootView, metaData);
        }
        String portrait = metaData.getPortrait();
        aVar.aGS.setText(metaData.getName_show());
        aVar.bNP.setTagData(metaData);
        aVar.bNt.setTag(portrait);
        if (this.dqr) {
            aVar.bNP.setVisibility(0);
        } else {
            aVar.bNP.setVisibility(8);
        }
        aVar.bNt.d(portrait, 12, false);
        this.dqp.getPageContext().getLayoutMode().ad(skinType == 1);
        this.dqp.getPageContext().getLayoutMode().k(aVar.rootView);
        return aVar;
    }

    private a aDK() {
        a aVar = new a(this, null);
        aVar.rootView = LayoutInflater.from(this.mContext).inflate(i.g.invite_friend_list_item, (ViewGroup) null);
        aVar.bNt = (HeadImageView) aVar.rootView.findViewById(i.f.photo);
        aVar.bNt.setIsRound(false);
        aVar.aGS = (TextView) aVar.rootView.findViewById(i.f.txt_user_name);
        aVar.bNP = (TbCheckBox) aVar.rootView.findViewById(i.f.ckb_select);
        if (this.mCheckBoxStateChangedListener != null) {
            aVar.bNP.setStatedChangedListener(this.mCheckBoxStateChangedListener);
        }
        aVar.rootView.setTag(aVar);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public TextView aGS;
        public TbCheckBox bNP;
        public HeadImageView bNt;
        public View rootView;

        private a() {
        }

        /* synthetic */ a(m mVar, a aVar) {
            this();
        }
    }
}
