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
import com.baidu.tieba.t;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class n extends BaseAdapter {
    private ArrayList<MetaData> Wt;
    private TbCheckBox.a dqL;
    private AtListActivity gdQ;
    private boolean gdS;
    private final Context mContext;
    private b gdR = null;
    private ViewGroup dqN = null;

    /* loaded from: classes.dex */
    public interface b {
        void a(View view, MetaData metaData);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b bVar) {
        this.gdR = bVar;
    }

    public n(AtListActivity atListActivity, boolean z) {
        this.gdS = true;
        this.gdQ = atListActivity;
        this.mContext = this.gdQ.getPageContext().getContext();
        this.gdS = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setData(ArrayList<MetaData> arrayList) {
        this.Wt = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(TbCheckBox.a aVar) {
        this.dqL = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.Wt == null) {
            return 0;
        }
        return this.Wt.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: tp */
    public MetaData getItem(int i) {
        if (this.Wt != null && i < this.Wt.size()) {
            return this.Wt.get(i);
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
        if (this.dqN == null) {
            this.dqN = viewGroup;
        }
        MetaData item = getItem(i);
        if (item != null) {
            aVar = a(view != null ? view.getTag() : null, item);
        } else {
            aVar = null;
        }
        if (aVar != null) {
            return aVar.aAV;
        }
        return null;
    }

    private a a(Object obj, MetaData metaData) {
        a aVar;
        int skinType = TbadkCoreApplication.m9getInst().getSkinType();
        if (obj == null) {
            aVar = bsZ();
        } else {
            aVar = (a) obj;
        }
        if (this.gdR != null) {
            this.gdR.a(aVar.aAV, metaData);
        }
        String portrait = metaData.getPortrait();
        aVar.aVl.setText(metaData.getName_show());
        aVar.dqP.setTagData(metaData);
        aVar.dqu.setTag(portrait);
        if (this.gdS) {
            aVar.dqP.setVisibility(0);
        } else {
            aVar.dqP.setVisibility(8);
        }
        aVar.dqu.c(portrait, 12, false);
        this.gdQ.getPageContext().getLayoutMode().ah(skinType == 1);
        this.gdQ.getPageContext().getLayoutMode().x(aVar.aAV);
        return aVar;
    }

    private a bsZ() {
        a aVar = new a(this, null);
        aVar.aAV = LayoutInflater.from(this.mContext).inflate(t.h.invite_friend_list_item, (ViewGroup) null);
        aVar.dqu = (HeadImageView) aVar.aAV.findViewById(t.g.photo);
        aVar.dqu.setIsRound(false);
        aVar.aVl = (TextView) aVar.aAV.findViewById(t.g.txt_user_name);
        aVar.dqP = (TbCheckBox) aVar.aAV.findViewById(t.g.ckb_select);
        if (this.dqL != null) {
            aVar.dqP.setStatedChangedListener(this.dqL);
        }
        aVar.aAV.setTag(aVar);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public View aAV;
        public TextView aVl;
        public TbCheckBox dqP;
        public HeadImageView dqu;

        private a() {
        }

        /* synthetic */ a(n nVar, a aVar) {
            this();
        }
    }
}
