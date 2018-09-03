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
import com.baidu.tieba.f;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    private ArrayList<MetaData> als;
    private TbCheckBox.a eFk;
    private AtListActivity hyc;
    private boolean hye;
    private final Context mContext;
    private b hyd = null;
    private ViewGroup mParent = null;

    /* loaded from: classes3.dex */
    public interface b {
        void a(View view, MetaData metaData);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b bVar) {
        this.hyd = bVar;
    }

    public a(AtListActivity atListActivity, boolean z) {
        this.hye = true;
        this.hyc = atListActivity;
        this.mContext = this.hyc.getPageContext().getContext();
        this.hye = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setData(ArrayList<MetaData> arrayList) {
        this.als = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(TbCheckBox.a aVar) {
        this.eFk = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.als == null) {
            return 0;
        }
        return this.als.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: vE */
    public MetaData getItem(int i) {
        if (this.als != null && i < this.als.size()) {
            return this.als.get(i);
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
            c0261a = bHh();
        } else {
            c0261a = (C0261a) obj;
        }
        if (this.hyd != null) {
            this.hyd.a(c0261a.rootView, metaData);
        }
        String portrait = metaData.getPortrait();
        c0261a.bSQ.setText(metaData.getName_show());
        c0261a.eFn.setTagData(metaData);
        c0261a.eES.setTag(portrait);
        if (this.hye) {
            c0261a.eFn.setVisibility(0);
        } else {
            c0261a.eFn.setVisibility(8);
        }
        c0261a.eES.startLoad(portrait, 12, false);
        this.hyc.getPageContext().getLayoutMode().setNightMode(skinType == 1);
        this.hyc.getPageContext().getLayoutMode().onModeChanged(c0261a.rootView);
        return c0261a;
    }

    private C0261a bHh() {
        C0261a c0261a = new C0261a();
        c0261a.rootView = LayoutInflater.from(this.mContext).inflate(f.h.invite_friend_list_item, (ViewGroup) null);
        c0261a.eES = (HeadImageView) c0261a.rootView.findViewById(f.g.photo);
        c0261a.eES.setIsRound(false);
        c0261a.bSQ = (TextView) c0261a.rootView.findViewById(f.g.txt_user_name);
        c0261a.eFn = (TbCheckBox) c0261a.rootView.findViewById(f.g.ckb_select);
        if (this.eFk != null) {
            c0261a.eFn.setStatedChangedListener(this.eFk);
        }
        c0261a.rootView.setTag(c0261a);
        return c0261a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.write.write.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0261a {
        public TextView bSQ;
        public HeadImageView eES;
        public TbCheckBox eFn;
        public View rootView;

        private C0261a() {
        }
    }
}
