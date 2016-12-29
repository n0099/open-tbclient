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
import com.baidu.tieba.r;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class n extends BaseAdapter {
    private ArrayList<MetaData> Wv;
    private TbCheckBox.a daN;
    private AtListActivity fCh;
    private boolean fCj;
    private final Context mContext;
    private b fCi = null;
    private ViewGroup cyf = null;

    /* loaded from: classes.dex */
    public interface b {
        void a(View view, MetaData metaData);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b bVar) {
        this.fCi = bVar;
    }

    public n(AtListActivity atListActivity, boolean z) {
        this.fCj = true;
        this.fCh = atListActivity;
        this.mContext = this.fCh.getPageContext().getContext();
        this.fCj = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setData(ArrayList<MetaData> arrayList) {
        this.Wv = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(TbCheckBox.a aVar) {
        this.daN = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.Wv == null) {
            return 0;
        }
        return this.Wv.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: sy */
    public MetaData getItem(int i) {
        if (this.Wv != null && i < this.Wv.size()) {
            return this.Wv.get(i);
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
        if (this.cyf == null) {
            this.cyf = viewGroup;
        }
        MetaData item = getItem(i);
        if (item != null) {
            aVar = a(view != null ? view.getTag() : null, item);
        } else {
            aVar = null;
        }
        if (aVar != null) {
            return aVar.aAK;
        }
        return null;
    }

    private a a(Object obj, MetaData metaData) {
        a aVar;
        int skinType = TbadkCoreApplication.m9getInst().getSkinType();
        if (obj == null) {
            aVar = bmY();
        } else {
            aVar = (a) obj;
        }
        if (this.fCi != null) {
            this.fCi.a(aVar.aAK, metaData);
        }
        String portrait = metaData.getPortrait();
        aVar.bbH.setText(metaData.getName_show());
        aVar.daQ.setTagData(metaData);
        aVar.daw.setTag(portrait);
        if (this.fCj) {
            aVar.daQ.setVisibility(0);
        } else {
            aVar.daQ.setVisibility(8);
        }
        aVar.daw.c(portrait, 12, false);
        this.fCh.getPageContext().getLayoutMode().ai(skinType == 1);
        this.fCh.getPageContext().getLayoutMode().x(aVar.aAK);
        return aVar;
    }

    private a bmY() {
        a aVar = new a(this, null);
        aVar.aAK = LayoutInflater.from(this.mContext).inflate(r.h.invite_friend_list_item, (ViewGroup) null);
        aVar.daw = (HeadImageView) aVar.aAK.findViewById(r.g.photo);
        aVar.daw.setIsRound(false);
        aVar.bbH = (TextView) aVar.aAK.findViewById(r.g.txt_user_name);
        aVar.daQ = (TbCheckBox) aVar.aAK.findViewById(r.g.ckb_select);
        if (this.daN != null) {
            aVar.daQ.setStatedChangedListener(this.daN);
        }
        aVar.aAK.setTag(aVar);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public View aAK;
        public TextView bbH;
        public TbCheckBox daQ;
        public HeadImageView daw;

        private a() {
        }

        /* synthetic */ a(n nVar, a aVar) {
            this();
        }
    }
}
