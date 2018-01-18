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
    private ArrayList<MetaData> aQG;
    private TbCheckBox.a eMm;
    private AtListActivity hIa;
    private boolean hIc;
    private final Context mContext;
    private b hIb = null;
    private ViewGroup cmX = null;

    /* loaded from: classes2.dex */
    public interface b {
        void a(View view, MetaData metaData);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b bVar) {
        this.hIb = bVar;
    }

    public a(AtListActivity atListActivity, boolean z) {
        this.hIc = true;
        this.hIa = atListActivity;
        this.mContext = this.hIa.getPageContext().getContext();
        this.hIc = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setData(ArrayList<MetaData> arrayList) {
        this.aQG = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(TbCheckBox.a aVar) {
        this.eMm = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aQG == null) {
            return 0;
        }
        return this.aQG.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: xK */
    public MetaData getItem(int i) {
        if (this.aQG != null && i < this.aQG.size()) {
            return this.aQG.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0174a c0174a;
        if (this.cmX == null) {
            this.cmX = viewGroup;
        }
        MetaData item = getItem(i);
        if (item != null) {
            c0174a = a(view != null ? view.getTag() : null, item);
        } else {
            c0174a = null;
        }
        if (c0174a != null) {
            return c0174a.rootView;
        }
        return null;
    }

    private C0174a a(Object obj, MetaData metaData) {
        C0174a c0174a;
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (obj == null) {
            c0174a = bHi();
        } else {
            c0174a = (C0174a) obj;
        }
        if (this.hIb != null) {
            this.hIb.a(c0174a.rootView, metaData);
        }
        String portrait = metaData.getPortrait();
        c0174a.cPN.setText(metaData.getName_show());
        c0174a.eMp.setTagData(metaData);
        c0174a.eLV.setTag(portrait);
        if (this.hIc) {
            c0174a.eMp.setVisibility(0);
        } else {
            c0174a.eMp.setVisibility(8);
        }
        c0174a.eLV.startLoad(portrait, 12, false);
        this.hIa.getPageContext().getLayoutMode().aM(skinType == 1);
        this.hIa.getPageContext().getLayoutMode().aM(c0174a.rootView);
        return c0174a;
    }

    private C0174a bHi() {
        C0174a c0174a = new C0174a();
        c0174a.rootView = LayoutInflater.from(this.mContext).inflate(d.h.invite_friend_list_item, (ViewGroup) null);
        c0174a.eLV = (HeadImageView) c0174a.rootView.findViewById(d.g.photo);
        c0174a.eLV.setIsRound(false);
        c0174a.cPN = (TextView) c0174a.rootView.findViewById(d.g.txt_user_name);
        c0174a.eMp = (TbCheckBox) c0174a.rootView.findViewById(d.g.ckb_select);
        if (this.eMm != null) {
            c0174a.eMp.setStatedChangedListener(this.eMm);
        }
        c0174a.rootView.setTag(c0174a);
        return c0174a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.write.write.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0174a {
        public TextView cPN;
        public HeadImageView eLV;
        public TbCheckBox eMp;
        public View rootView;

        private C0174a() {
        }
    }
}
