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
    private ArrayList<MetaData> Xh;
    private AtListActivity doA;
    private boolean doC;
    private TbCheckBox.a mCheckBoxStateChangedListener;
    private final Context mContext;
    private b doB = null;
    private ViewGroup bNs = null;

    /* loaded from: classes.dex */
    public interface b {
        void a(View view, MetaData metaData);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b bVar) {
        this.doB = bVar;
    }

    public m(AtListActivity atListActivity, boolean z) {
        this.doC = true;
        this.doA = atListActivity;
        this.mContext = this.doA.getPageContext().getContext();
        this.doC = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setData(ArrayList<MetaData> arrayList) {
        this.Xh = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setCheckBoxStateChangedListener(TbCheckBox.a aVar) {
        this.mCheckBoxStateChangedListener = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.Xh == null) {
            return 0;
        }
        return this.Xh.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: mi */
    public MetaData getItem(int i) {
        if (this.Xh != null && i < this.Xh.size()) {
            return this.Xh.get(i);
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
        if (this.bNs == null) {
            this.bNs = viewGroup;
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
            aVar = aCS();
        } else {
            aVar = (a) obj;
        }
        if (this.doB != null) {
            this.doB.a(aVar.rootView, metaData);
        }
        String portrait = metaData.getPortrait();
        aVar.aHY.setText(metaData.getName_show());
        aVar.bNu.setTagData(metaData);
        aVar.bMY.setTag(portrait);
        if (this.doC) {
            aVar.bNu.setVisibility(0);
        } else {
            aVar.bNu.setVisibility(8);
        }
        aVar.bMY.d(portrait, 12, false);
        this.doA.getPageContext().getLayoutMode().ad(skinType == 1);
        this.doA.getPageContext().getLayoutMode().k(aVar.rootView);
        return aVar;
    }

    private a aCS() {
        a aVar = new a(this, null);
        aVar.rootView = LayoutInflater.from(this.mContext).inflate(i.g.invite_friend_list_item, (ViewGroup) null);
        aVar.bMY = (HeadImageView) aVar.rootView.findViewById(i.f.photo);
        aVar.bMY.setIsRound(false);
        aVar.aHY = (TextView) aVar.rootView.findViewById(i.f.txt_user_name);
        aVar.bNu = (TbCheckBox) aVar.rootView.findViewById(i.f.ckb_select);
        if (this.mCheckBoxStateChangedListener != null) {
            aVar.bNu.setStatedChangedListener(this.mCheckBoxStateChangedListener);
        }
        aVar.rootView.setTag(aVar);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public TextView aHY;
        public HeadImageView bMY;
        public TbCheckBox bNu;
        public View rootView;

        private a() {
        }

        /* synthetic */ a(m mVar, a aVar) {
            this();
        }
    }
}
