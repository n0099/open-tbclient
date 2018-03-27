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
    private ArrayList<MetaData> aRZ;
    private TbCheckBox.a eQT;
    private AtListActivity hKc;
    private boolean hKe;
    private final Context mContext;
    private b hKd = null;
    private ViewGroup cqX = null;

    /* loaded from: classes2.dex */
    public interface b {
        void a(View view, MetaData metaData);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b bVar) {
        this.hKd = bVar;
    }

    public a(AtListActivity atListActivity, boolean z) {
        this.hKe = true;
        this.hKc = atListActivity;
        this.mContext = this.hKc.getPageContext().getContext();
        this.hKe = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setData(ArrayList<MetaData> arrayList) {
        this.aRZ = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(TbCheckBox.a aVar) {
        this.eQT = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aRZ == null) {
            return 0;
        }
        return this.aRZ.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: xK */
    public MetaData getItem(int i) {
        if (this.aRZ != null && i < this.aRZ.size()) {
            return this.aRZ.get(i);
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
        if (this.cqX == null) {
            this.cqX = viewGroup;
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
            c0258a = bIc();
        } else {
            c0258a = (C0258a) obj;
        }
        if (this.hKd != null) {
            this.hKd.a(c0258a.rootView, metaData);
        }
        String portrait = metaData.getPortrait();
        c0258a.cql.setText(metaData.getName_show());
        c0258a.eQW.setTagData(metaData);
        c0258a.eQC.setTag(portrait);
        if (this.hKe) {
            c0258a.eQW.setVisibility(0);
        } else {
            c0258a.eQW.setVisibility(8);
        }
        c0258a.eQC.startLoad(portrait, 12, false);
        this.hKc.getPageContext().getLayoutMode().aQ(skinType == 1);
        this.hKc.getPageContext().getLayoutMode().aM(c0258a.rootView);
        return c0258a;
    }

    private C0258a bIc() {
        C0258a c0258a = new C0258a();
        c0258a.rootView = LayoutInflater.from(this.mContext).inflate(d.h.invite_friend_list_item, (ViewGroup) null);
        c0258a.eQC = (HeadImageView) c0258a.rootView.findViewById(d.g.photo);
        c0258a.eQC.setIsRound(false);
        c0258a.cql = (TextView) c0258a.rootView.findViewById(d.g.txt_user_name);
        c0258a.eQW = (TbCheckBox) c0258a.rootView.findViewById(d.g.ckb_select);
        if (this.eQT != null) {
            c0258a.eQW.setStatedChangedListener(this.eQT);
        }
        c0258a.rootView.setTag(c0258a);
        return c0258a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.write.write.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0258a {
        public TextView cql;
        public HeadImageView eQC;
        public TbCheckBox eQW;
        public View rootView;

        private C0258a() {
        }
    }
}
