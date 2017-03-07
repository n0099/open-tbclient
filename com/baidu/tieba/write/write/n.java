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
import com.baidu.tieba.w;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class n extends BaseAdapter {
    private ArrayList<MetaData> aaY;
    private TbCheckBox.a dks;
    private AtListActivity fOV;
    private boolean fOX;
    private final Context mContext;
    private b fOW = null;
    private ViewGroup cGE = null;

    /* loaded from: classes.dex */
    public interface b {
        void a(View view, MetaData metaData);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b bVar) {
        this.fOW = bVar;
    }

    public n(AtListActivity atListActivity, boolean z) {
        this.fOX = true;
        this.fOV = atListActivity;
        this.mContext = this.fOV.getPageContext().getContext();
        this.fOX = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setData(ArrayList<MetaData> arrayList) {
        this.aaY = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(TbCheckBox.a aVar) {
        this.dks = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aaY == null) {
            return 0;
        }
        return this.aaY.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: ti */
    public MetaData getItem(int i) {
        if (this.aaY != null && i < this.aaY.size()) {
            return this.aaY.get(i);
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
        if (this.cGE == null) {
            this.cGE = viewGroup;
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
        int skinType = TbadkCoreApplication.m9getInst().getSkinType();
        if (obj == null) {
            aVar = boj();
        } else {
            aVar = (a) obj;
        }
        if (this.fOW != null) {
            this.fOW.a(aVar.rootView, metaData);
        }
        String portrait = metaData.getPortrait();
        aVar.bsn.setText(metaData.getName_show());
        aVar.dkv.setTagData(metaData);
        aVar.dkc.setTag(portrait);
        if (this.fOX) {
            aVar.dkv.setVisibility(0);
        } else {
            aVar.dkv.setVisibility(8);
        }
        aVar.dkc.c(portrait, 12, false);
        this.fOV.getPageContext().getLayoutMode().ah(skinType == 1);
        this.fOV.getPageContext().getLayoutMode().t(aVar.rootView);
        return aVar;
    }

    private a boj() {
        a aVar = new a(this, null);
        aVar.rootView = LayoutInflater.from(this.mContext).inflate(w.j.invite_friend_list_item, (ViewGroup) null);
        aVar.dkc = (HeadImageView) aVar.rootView.findViewById(w.h.photo);
        aVar.dkc.setIsRound(false);
        aVar.bsn = (TextView) aVar.rootView.findViewById(w.h.txt_user_name);
        aVar.dkv = (TbCheckBox) aVar.rootView.findViewById(w.h.ckb_select);
        if (this.dks != null) {
            aVar.dkv.setStatedChangedListener(this.dks);
        }
        aVar.rootView.setTag(aVar);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public TextView bsn;
        public HeadImageView dkc;
        public TbCheckBox dkv;
        public View rootView;

        private a() {
        }

        /* synthetic */ a(n nVar, a aVar) {
            this();
        }
    }
}
