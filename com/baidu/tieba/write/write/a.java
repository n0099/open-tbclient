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
    private ArrayList<MetaData> aFH;
    private TbCheckBox.a gwc;
    private AtListActivity jsc;
    private boolean jse;
    private final Context mContext;
    private b jsd = null;
    private ViewGroup mParent = null;

    /* loaded from: classes3.dex */
    public interface b {
        void a(View view, MetaData metaData);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b bVar) {
        this.jsd = bVar;
    }

    public a(AtListActivity atListActivity, boolean z) {
        this.jse = true;
        this.jsc = atListActivity;
        this.mContext = this.jsc.getPageContext().getContext();
        this.jse = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setData(ArrayList<MetaData> arrayList) {
        this.aFH = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(TbCheckBox.a aVar) {
        this.gwc = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aFH == null) {
            return 0;
        }
        return this.aFH.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: Bw */
    public MetaData getItem(int i) {
        if (this.aFH != null && i < this.aFH.size()) {
            return this.aFH.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0324a c0324a;
        if (this.mParent == null) {
            this.mParent = viewGroup;
        }
        MetaData item = getItem(i);
        if (item != null) {
            c0324a = a(view != null ? view.getTag() : null, item);
        } else {
            c0324a = null;
        }
        if (c0324a != null) {
            return c0324a.rootView;
        }
        return null;
    }

    private C0324a a(Object obj, MetaData metaData) {
        C0324a c0324a;
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (obj == null) {
            c0324a = cqh();
        } else {
            c0324a = (C0324a) obj;
        }
        if (this.jsd != null) {
            this.jsd.a(c0324a.rootView, metaData);
        }
        String portrait = metaData.getPortrait();
        c0324a.dBb.setText(metaData.getName_show());
        c0324a.gwf.setTagData(metaData);
        c0324a.gvK.setTag(portrait);
        if (this.jse) {
            c0324a.gwf.setVisibility(0);
        } else {
            c0324a.gwf.setVisibility(8);
        }
        c0324a.gvK.startLoad(portrait, 12, false);
        this.jsc.getPageContext().getLayoutMode().setNightMode(skinType == 1);
        this.jsc.getPageContext().getLayoutMode().onModeChanged(c0324a.rootView);
        return c0324a;
    }

    private C0324a cqh() {
        C0324a c0324a = new C0324a();
        c0324a.rootView = LayoutInflater.from(this.mContext).inflate(d.h.invite_friend_list_item, (ViewGroup) null);
        c0324a.gvK = (HeadImageView) c0324a.rootView.findViewById(d.g.photo);
        c0324a.gvK.setIsRound(false);
        c0324a.dBb = (TextView) c0324a.rootView.findViewById(d.g.txt_user_name);
        c0324a.gwf = (TbCheckBox) c0324a.rootView.findViewById(d.g.ckb_select);
        if (this.gwc != null) {
            c0324a.gwf.setStatedChangedListener(this.gwc);
        }
        c0324a.rootView.setTag(c0324a);
        return c0324a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.write.write.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0324a {
        public TextView dBb;
        public HeadImageView gvK;
        public TbCheckBox gwf;
        public View rootView;

        private C0324a() {
        }
    }
}
