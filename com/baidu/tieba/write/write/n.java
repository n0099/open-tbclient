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
    private ArrayList<MetaData> SE;
    private TbCheckBox.a cwR;
    private AtListActivity fcs;
    private boolean fcu;
    private final Context mContext;
    private b fct = null;
    private ViewGroup cwT = null;

    /* loaded from: classes.dex */
    public interface b {
        void a(View view, MetaData metaData);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b bVar) {
        this.fct = bVar;
    }

    public n(AtListActivity atListActivity, boolean z) {
        this.fcu = true;
        this.fcs = atListActivity;
        this.mContext = this.fcs.getPageContext().getContext();
        this.fcu = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setData(ArrayList<MetaData> arrayList) {
        this.SE = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(TbCheckBox.a aVar) {
        this.cwR = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.SE == null) {
            return 0;
        }
        return this.SE.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: rk */
    public MetaData getItem(int i) {
        if (this.SE != null && i < this.SE.size()) {
            return this.SE.get(i);
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
        if (this.cwT == null) {
            this.cwT = viewGroup;
        }
        MetaData item = getItem(i);
        if (item != null) {
            aVar = a(view != null ? view.getTag() : null, item);
        } else {
            aVar = null;
        }
        if (aVar != null) {
            return aVar.awk;
        }
        return null;
    }

    private a a(Object obj, MetaData metaData) {
        a aVar;
        int skinType = TbadkCoreApplication.m11getInst().getSkinType();
        if (obj == null) {
            aVar = bdm();
        } else {
            aVar = (a) obj;
        }
        if (this.fct != null) {
            this.fct.a(aVar.awk, metaData);
        }
        String portrait = metaData.getPortrait();
        aVar.aLz.setText(metaData.getName_show());
        aVar.cwV.setTagData(metaData);
        aVar.cwz.setTag(portrait);
        if (this.fcu) {
            aVar.cwV.setVisibility(0);
        } else {
            aVar.cwV.setVisibility(8);
        }
        aVar.cwz.c(portrait, 12, false);
        this.fcs.getPageContext().getLayoutMode().ae(skinType == 1);
        this.fcs.getPageContext().getLayoutMode().x(aVar.awk);
        return aVar;
    }

    private a bdm() {
        a aVar = new a(this, null);
        aVar.awk = LayoutInflater.from(this.mContext).inflate(t.h.invite_friend_list_item, (ViewGroup) null);
        aVar.cwz = (HeadImageView) aVar.awk.findViewById(t.g.photo);
        aVar.cwz.setIsRound(false);
        aVar.aLz = (TextView) aVar.awk.findViewById(t.g.txt_user_name);
        aVar.cwV = (TbCheckBox) aVar.awk.findViewById(t.g.ckb_select);
        if (this.cwR != null) {
            aVar.cwV.setStatedChangedListener(this.cwR);
        }
        aVar.awk.setTag(aVar);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public TextView aLz;
        public View awk;
        public TbCheckBox cwV;
        public HeadImageView cwz;

        private a() {
        }

        /* synthetic */ a(n nVar, a aVar) {
            this();
        }
    }
}
