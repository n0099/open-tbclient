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
    private ArrayList<MetaData> aaI;
    private TbCheckBox.a dkF;
    private AtListActivity fZb;
    private boolean fZd;
    private final Context mContext;
    private b fZc = null;
    private ViewGroup dkH = null;

    /* loaded from: classes.dex */
    public interface b {
        void a(View view, MetaData metaData);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b bVar) {
        this.fZc = bVar;
    }

    public n(AtListActivity atListActivity, boolean z) {
        this.fZd = true;
        this.fZb = atListActivity;
        this.mContext = this.fZb.getPageContext().getContext();
        this.fZd = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setData(ArrayList<MetaData> arrayList) {
        this.aaI = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(TbCheckBox.a aVar) {
        this.dkF = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aaI == null) {
            return 0;
        }
        return this.aaI.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: tE */
    public MetaData getItem(int i) {
        if (this.aaI != null && i < this.aaI.size()) {
            return this.aaI.get(i);
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
        if (this.dkH == null) {
            this.dkH = viewGroup;
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
            aVar = bpu();
        } else {
            aVar = (a) obj;
        }
        if (this.fZc != null) {
            this.fZc.a(aVar.rootView, metaData);
        }
        String portrait = metaData.getPortrait();
        aVar.bAh.setText(metaData.getName_show());
        aVar.dkJ.setTagData(metaData);
        aVar.dkp.setTag(portrait);
        if (this.fZd) {
            aVar.dkJ.setVisibility(0);
        } else {
            aVar.dkJ.setVisibility(8);
        }
        aVar.dkp.c(portrait, 12, false);
        this.fZb.getPageContext().getLayoutMode().ah(skinType == 1);
        this.fZb.getPageContext().getLayoutMode().t(aVar.rootView);
        return aVar;
    }

    private a bpu() {
        a aVar = new a(this, null);
        aVar.rootView = LayoutInflater.from(this.mContext).inflate(w.j.invite_friend_list_item, (ViewGroup) null);
        aVar.dkp = (HeadImageView) aVar.rootView.findViewById(w.h.photo);
        aVar.dkp.setIsRound(false);
        aVar.bAh = (TextView) aVar.rootView.findViewById(w.h.txt_user_name);
        aVar.dkJ = (TbCheckBox) aVar.rootView.findViewById(w.h.ckb_select);
        if (this.dkF != null) {
            aVar.dkJ.setStatedChangedListener(this.dkF);
        }
        aVar.rootView.setTag(aVar);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public TextView bAh;
        public TbCheckBox dkJ;
        public HeadImageView dkp;
        public View rootView;

        private a() {
        }

        /* synthetic */ a(n nVar, a aVar) {
            this();
        }
    }
}
