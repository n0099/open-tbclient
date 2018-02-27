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
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class a extends BaseAdapter {
    private ArrayList<MetaData> aRX;
    private TbCheckBox.a eQE;
    private AtListActivity hJE;
    private boolean hJG;
    private final Context mContext;
    private b hJF = null;
    private ViewGroup cqU = null;

    /* loaded from: classes2.dex */
    public interface b {
        void a(View view, MetaData metaData);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b bVar) {
        this.hJF = bVar;
    }

    public a(AtListActivity atListActivity, boolean z) {
        this.hJG = true;
        this.hJE = atListActivity;
        this.mContext = this.hJE.getPageContext().getContext();
        this.hJG = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setData(ArrayList<MetaData> arrayList) {
        this.aRX = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(TbCheckBox.a aVar) {
        this.eQE = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aRX == null) {
            return 0;
        }
        return this.aRX.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: xK */
    public MetaData getItem(int i) {
        if (this.aRX != null && i < this.aRX.size()) {
            return this.aRX.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0258a c0258a;
        if (this.cqU == null) {
            this.cqU = viewGroup;
        }
        MetaData item = getItem(i);
        if (item != null) {
            c0258a = a(view != null ? view.getTag() : null, item);
        } else {
            c0258a = null;
        }
        if (c0258a != null) {
            return c0258a.rootView;
        }
        return null;
    }

    private C0258a a(Object obj, MetaData metaData) {
        C0258a c0258a;
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (obj == null) {
            c0258a = bHX();
        } else {
            c0258a = (C0258a) obj;
        }
        if (this.hJF != null) {
            this.hJF.a(c0258a.rootView, metaData);
        }
        String portrait = metaData.getPortrait();
        c0258a.cqi.setText(metaData.getName_show());
        c0258a.eQH.setTagData(metaData);
        c0258a.eQn.setTag(portrait);
        if (this.hJG) {
            c0258a.eQH.setVisibility(0);
        } else {
            c0258a.eQH.setVisibility(8);
        }
        c0258a.eQn.startLoad(portrait, 12, false);
        this.hJE.getPageContext().getLayoutMode().aQ(skinType == 1);
        this.hJE.getPageContext().getLayoutMode().aM(c0258a.rootView);
        return c0258a;
    }

    private C0258a bHX() {
        C0258a c0258a = new C0258a();
        c0258a.rootView = LayoutInflater.from(this.mContext).inflate(d.h.invite_friend_list_item, (ViewGroup) null);
        c0258a.eQn = (HeadImageView) c0258a.rootView.findViewById(d.g.photo);
        c0258a.eQn.setIsRound(false);
        c0258a.cqi = (TextView) c0258a.rootView.findViewById(d.g.txt_user_name);
        c0258a.eQH = (TbCheckBox) c0258a.rootView.findViewById(d.g.ckb_select);
        if (this.eQE != null) {
            c0258a.eQH.setStatedChangedListener(this.eQE);
        }
        c0258a.rootView.setTag(c0258a);
        return c0258a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.write.write.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0258a {
        public TextView cqi;
        public TbCheckBox eQH;
        public HeadImageView eQn;
        public View rootView;

        private C0258a() {
        }
    }
}
