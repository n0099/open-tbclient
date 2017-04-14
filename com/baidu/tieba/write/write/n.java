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
    private ArrayList<MetaData> abn;
    private TbCheckBox.a diR;
    private AtListActivity fQF;
    private boolean fQH;
    private final Context mContext;
    private b fQG = null;
    private ViewGroup cFd = null;

    /* loaded from: classes.dex */
    public interface b {
        void a(View view, MetaData metaData);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b bVar) {
        this.fQG = bVar;
    }

    public n(AtListActivity atListActivity, boolean z) {
        this.fQH = true;
        this.fQF = atListActivity;
        this.mContext = this.fQF.getPageContext().getContext();
        this.fQH = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setData(ArrayList<MetaData> arrayList) {
        this.abn = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(TbCheckBox.a aVar) {
        this.diR = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.abn == null) {
            return 0;
        }
        return this.abn.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: tg */
    public MetaData getItem(int i) {
        if (this.abn != null && i < this.abn.size()) {
            return this.abn.get(i);
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
        if (this.cFd == null) {
            this.cFd = viewGroup;
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
            aVar = boS();
        } else {
            aVar = (a) obj;
        }
        if (this.fQG != null) {
            this.fQG.a(aVar.rootView, metaData);
        }
        String portrait = metaData.getPortrait();
        aVar.bsf.setText(metaData.getName_show());
        aVar.diU.setTagData(metaData);
        aVar.diB.setTag(portrait);
        if (this.fQH) {
            aVar.diU.setVisibility(0);
        } else {
            aVar.diU.setVisibility(8);
        }
        aVar.diB.c(portrait, 12, false);
        this.fQF.getPageContext().getLayoutMode().aj(skinType == 1);
        this.fQF.getPageContext().getLayoutMode().t(aVar.rootView);
        return aVar;
    }

    private a boS() {
        a aVar = new a(this, null);
        aVar.rootView = LayoutInflater.from(this.mContext).inflate(w.j.invite_friend_list_item, (ViewGroup) null);
        aVar.diB = (HeadImageView) aVar.rootView.findViewById(w.h.photo);
        aVar.diB.setIsRound(false);
        aVar.bsf = (TextView) aVar.rootView.findViewById(w.h.txt_user_name);
        aVar.diU = (TbCheckBox) aVar.rootView.findViewById(w.h.ckb_select);
        if (this.diR != null) {
            aVar.diU.setStatedChangedListener(this.diR);
        }
        aVar.rootView.setTag(aVar);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public TextView bsf;
        public HeadImageView diB;
        public TbCheckBox diU;
        public View rootView;

        private a() {
        }

        /* synthetic */ a(n nVar, a aVar) {
            this();
        }
    }
}
