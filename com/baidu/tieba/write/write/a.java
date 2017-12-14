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
    private ArrayList<MetaData> acr;
    private TbCheckBox.a dYF;
    private AtListActivity hkh;
    private boolean hkj;
    private final Context mContext;
    private b hki = null;
    private ViewGroup byH = null;

    /* loaded from: classes2.dex */
    public interface b {
        void a(View view, MetaData metaData);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b bVar) {
        this.hki = bVar;
    }

    public a(AtListActivity atListActivity, boolean z) {
        this.hkj = true;
        this.hkh = atListActivity;
        this.mContext = this.hkh.getPageContext().getContext();
        this.hkj = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setData(ArrayList<MetaData> arrayList) {
        this.acr = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(TbCheckBox.a aVar) {
        this.dYF = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.acr == null) {
            return 0;
        }
        return this.acr.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: wq */
    public MetaData getItem(int i) {
        if (this.acr != null && i < this.acr.size()) {
            return this.acr.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0163a c0163a;
        if (this.byH == null) {
            this.byH = viewGroup;
        }
        MetaData item = getItem(i);
        if (item != null) {
            c0163a = a(view != null ? view.getTag() : null, item);
        } else {
            c0163a = null;
        }
        if (c0163a != null) {
            return c0163a.rootView;
        }
        return null;
    }

    private C0163a a(Object obj, MetaData metaData) {
        C0163a c0163a;
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (obj == null) {
            c0163a = bHU();
        } else {
            c0163a = (C0163a) obj;
        }
        if (this.hki != null) {
            this.hki.a(c0163a.rootView, metaData);
        }
        String portrait = metaData.getPortrait();
        c0163a.bWB.setText(metaData.getName_show());
        c0163a.dYI.setTagData(metaData);
        c0163a.dYo.setTag(portrait);
        if (this.hkj) {
            c0163a.dYI.setVisibility(0);
        } else {
            c0163a.dYI.setVisibility(8);
        }
        c0163a.dYo.startLoad(portrait, 12, false);
        this.hkh.getPageContext().getLayoutMode().ag(skinType == 1);
        this.hkh.getPageContext().getLayoutMode().t(c0163a.rootView);
        return c0163a;
    }

    private C0163a bHU() {
        C0163a c0163a = new C0163a();
        c0163a.rootView = LayoutInflater.from(this.mContext).inflate(d.h.invite_friend_list_item, (ViewGroup) null);
        c0163a.dYo = (HeadImageView) c0163a.rootView.findViewById(d.g.photo);
        c0163a.dYo.setIsRound(false);
        c0163a.bWB = (TextView) c0163a.rootView.findViewById(d.g.txt_user_name);
        c0163a.dYI = (TbCheckBox) c0163a.rootView.findViewById(d.g.ckb_select);
        if (this.dYF != null) {
            c0163a.dYI.setStatedChangedListener(this.dYF);
        }
        c0163a.rootView.setTag(c0163a);
        return c0163a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.write.write.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0163a {
        public TextView bWB;
        public TbCheckBox dYI;
        public HeadImageView dYo;
        public View rootView;

        private C0163a() {
        }
    }
}
