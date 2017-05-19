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
    private ArrayList<MetaData> aaJ;
    private TbCheckBox.a dfl;
    private AtListActivity fRf;
    private boolean fRh;
    private final Context mContext;
    private b fRg = null;
    private ViewGroup dfn = null;

    /* loaded from: classes.dex */
    public interface b {
        void a(View view, MetaData metaData);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b bVar) {
        this.fRg = bVar;
    }

    public n(AtListActivity atListActivity, boolean z) {
        this.fRh = true;
        this.fRf = atListActivity;
        this.mContext = this.fRf.getPageContext().getContext();
        this.fRh = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setData(ArrayList<MetaData> arrayList) {
        this.aaJ = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(TbCheckBox.a aVar) {
        this.dfl = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aaJ == null) {
            return 0;
        }
        return this.aaJ.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: tj */
    public MetaData getItem(int i) {
        if (this.aaJ != null && i < this.aaJ.size()) {
            return this.aaJ.get(i);
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
        if (this.dfn == null) {
            this.dfn = viewGroup;
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
            aVar = bnV();
        } else {
            aVar = (a) obj;
        }
        if (this.fRg != null) {
            this.fRg.a(aVar.rootView, metaData);
        }
        String portrait = metaData.getPortrait();
        aVar.but.setText(metaData.getName_show());
        aVar.dfp.setTagData(metaData);
        aVar.deV.setTag(portrait);
        if (this.fRh) {
            aVar.dfp.setVisibility(0);
        } else {
            aVar.dfp.setVisibility(8);
        }
        aVar.deV.c(portrait, 12, false);
        this.fRf.getPageContext().getLayoutMode().ai(skinType == 1);
        this.fRf.getPageContext().getLayoutMode().t(aVar.rootView);
        return aVar;
    }

    private a bnV() {
        a aVar = new a(this, null);
        aVar.rootView = LayoutInflater.from(this.mContext).inflate(w.j.invite_friend_list_item, (ViewGroup) null);
        aVar.deV = (HeadImageView) aVar.rootView.findViewById(w.h.photo);
        aVar.deV.setIsRound(false);
        aVar.but = (TextView) aVar.rootView.findViewById(w.h.txt_user_name);
        aVar.dfp = (TbCheckBox) aVar.rootView.findViewById(w.h.ckb_select);
        if (this.dfl != null) {
            aVar.dfp.setStatedChangedListener(this.dfl);
        }
        aVar.rootView.setTag(aVar);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public TextView but;
        public HeadImageView deV;
        public TbCheckBox dfp;
        public View rootView;

        private a() {
        }

        /* synthetic */ a(n nVar, a aVar) {
            this();
        }
    }
}
