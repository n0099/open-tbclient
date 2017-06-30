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
    private TbCheckBox.a dsB;
    private AtListActivity gka;
    private boolean gkc;
    private final Context mContext;
    private b gkb = null;
    private ViewGroup dsD = null;

    /* loaded from: classes.dex */
    public interface b {
        void a(View view, MetaData metaData);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b bVar) {
        this.gkb = bVar;
    }

    public n(AtListActivity atListActivity, boolean z) {
        this.gkc = true;
        this.gka = atListActivity;
        this.mContext = this.gka.getPageContext().getContext();
        this.gkc = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setData(ArrayList<MetaData> arrayList) {
        this.aaJ = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(TbCheckBox.a aVar) {
        this.dsB = aVar;
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
    /* renamed from: ua */
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
        if (this.dsD == null) {
            this.dsD = viewGroup;
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
            aVar = btS();
        } else {
            aVar = (a) obj;
        }
        if (this.gkb != null) {
            this.gkb.a(aVar.rootView, metaData);
        }
        String portrait = metaData.getPortrait();
        aVar.bBa.setText(metaData.getName_show());
        aVar.dsF.setTagData(metaData);
        aVar.dsl.setTag(portrait);
        if (this.gkc) {
            aVar.dsF.setVisibility(0);
        } else {
            aVar.dsF.setVisibility(8);
        }
        aVar.dsl.c(portrait, 12, false);
        this.gka.getPageContext().getLayoutMode().ah(skinType == 1);
        this.gka.getPageContext().getLayoutMode().t(aVar.rootView);
        return aVar;
    }

    private a btS() {
        a aVar = new a(this, null);
        aVar.rootView = LayoutInflater.from(this.mContext).inflate(w.j.invite_friend_list_item, (ViewGroup) null);
        aVar.dsl = (HeadImageView) aVar.rootView.findViewById(w.h.photo);
        aVar.dsl.setIsRound(false);
        aVar.bBa = (TextView) aVar.rootView.findViewById(w.h.txt_user_name);
        aVar.dsF = (TbCheckBox) aVar.rootView.findViewById(w.h.ckb_select);
        if (this.dsB != null) {
            aVar.dsF.setStatedChangedListener(this.dsB);
        }
        aVar.rootView.setTag(aVar);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public TextView bBa;
        public TbCheckBox dsF;
        public HeadImageView dsl;
        public View rootView;

        private a() {
        }

        /* synthetic */ a(n nVar, a aVar) {
            this();
        }
    }
}
