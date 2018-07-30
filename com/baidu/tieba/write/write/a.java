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
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    private ArrayList<MetaData> alt;
    private TbCheckBox.a eFo;
    private AtListActivity hya;
    private boolean hyc;
    private final Context mContext;
    private b hyb = null;
    private ViewGroup mParent = null;

    /* loaded from: classes3.dex */
    public interface b {
        void a(View view, MetaData metaData);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b bVar) {
        this.hyb = bVar;
    }

    public a(AtListActivity atListActivity, boolean z) {
        this.hyc = true;
        this.hya = atListActivity;
        this.mContext = this.hya.getPageContext().getContext();
        this.hyc = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setData(ArrayList<MetaData> arrayList) {
        this.alt = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(TbCheckBox.a aVar) {
        this.eFo = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.alt == null) {
            return 0;
        }
        return this.alt.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: vE */
    public MetaData getItem(int i) {
        if (this.alt != null && i < this.alt.size()) {
            return this.alt.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0261a c0261a;
        if (this.mParent == null) {
            this.mParent = viewGroup;
        }
        MetaData item = getItem(i);
        if (item != null) {
            c0261a = a(view != null ? view.getTag() : null, item);
        } else {
            c0261a = null;
        }
        if (c0261a != null) {
            return c0261a.rootView;
        }
        return null;
    }

    private C0261a a(Object obj, MetaData metaData) {
        C0261a c0261a;
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (obj == null) {
            c0261a = bHd();
        } else {
            c0261a = (C0261a) obj;
        }
        if (this.hyb != null) {
            this.hyb.a(c0261a.rootView, metaData);
        }
        String portrait = metaData.getPortrait();
        c0261a.bSR.setText(metaData.getName_show());
        c0261a.eFr.setTagData(metaData);
        c0261a.eEW.setTag(portrait);
        if (this.hyc) {
            c0261a.eFr.setVisibility(0);
        } else {
            c0261a.eFr.setVisibility(8);
        }
        c0261a.eEW.startLoad(portrait, 12, false);
        this.hya.getPageContext().getLayoutMode().setNightMode(skinType == 1);
        this.hya.getPageContext().getLayoutMode().onModeChanged(c0261a.rootView);
        return c0261a;
    }

    private C0261a bHd() {
        C0261a c0261a = new C0261a();
        c0261a.rootView = LayoutInflater.from(this.mContext).inflate(d.h.invite_friend_list_item, (ViewGroup) null);
        c0261a.eEW = (HeadImageView) c0261a.rootView.findViewById(d.g.photo);
        c0261a.eEW.setIsRound(false);
        c0261a.bSR = (TextView) c0261a.rootView.findViewById(d.g.txt_user_name);
        c0261a.eFr = (TbCheckBox) c0261a.rootView.findViewById(d.g.ckb_select);
        if (this.eFo != null) {
            c0261a.eFr.setStatedChangedListener(this.eFo);
        }
        c0261a.rootView.setTag(c0261a);
        return c0261a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.write.write.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0261a {
        public TextView bSR;
        public HeadImageView eEW;
        public TbCheckBox eFr;
        public View rootView;

        private C0261a() {
        }
    }
}
