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
import com.baidu.tieba.n;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class m extends BaseAdapter {
    private ArrayList<MetaData> XX;
    private AtListActivity dPs;
    private boolean dPu;
    private TbCheckBox.a mCheckBoxStateChangedListener;
    private final Context mContext;
    private b dPt = null;
    private ViewGroup ccR = null;

    /* loaded from: classes.dex */
    public interface b {
        void a(View view, MetaData metaData);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b bVar) {
        this.dPt = bVar;
    }

    public m(AtListActivity atListActivity, boolean z) {
        this.dPu = true;
        this.dPs = atListActivity;
        this.mContext = this.dPs.getPageContext().getContext();
        this.dPu = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setData(ArrayList<MetaData> arrayList) {
        this.XX = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setCheckBoxStateChangedListener(TbCheckBox.a aVar) {
        this.mCheckBoxStateChangedListener = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.XX == null) {
            return 0;
        }
        return this.XX.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: nI */
    public MetaData getItem(int i) {
        if (this.XX != null && i < this.XX.size()) {
            return this.XX.get(i);
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
        if (this.ccR == null) {
            this.ccR = viewGroup;
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
            aVar = aJh();
        } else {
            aVar = (a) obj;
        }
        if (this.dPt != null) {
            this.dPt.a(aVar.rootView, metaData);
        }
        String portrait = metaData.getPortrait();
        aVar.aJR.setText(metaData.getName_show());
        aVar.ccT.setTagData(metaData);
        aVar.ccx.setTag(portrait);
        if (this.dPu) {
            aVar.ccT.setVisibility(0);
        } else {
            aVar.ccT.setVisibility(8);
        }
        aVar.ccx.d(portrait, 12, false);
        this.dPs.getPageContext().getLayoutMode().af(skinType == 1);
        this.dPs.getPageContext().getLayoutMode().k(aVar.rootView);
        return aVar;
    }

    private a aJh() {
        a aVar = new a(this, null);
        aVar.rootView = LayoutInflater.from(this.mContext).inflate(n.g.invite_friend_list_item, (ViewGroup) null);
        aVar.ccx = (HeadImageView) aVar.rootView.findViewById(n.f.photo);
        aVar.ccx.setIsRound(false);
        aVar.aJR = (TextView) aVar.rootView.findViewById(n.f.txt_user_name);
        aVar.ccT = (TbCheckBox) aVar.rootView.findViewById(n.f.ckb_select);
        if (this.mCheckBoxStateChangedListener != null) {
            aVar.ccT.setStatedChangedListener(this.mCheckBoxStateChangedListener);
        }
        aVar.rootView.setTag(aVar);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public TextView aJR;
        public TbCheckBox ccT;
        public HeadImageView ccx;
        public View rootView;

        private a() {
        }

        /* synthetic */ a(m mVar, a aVar) {
            this();
        }
    }
}
