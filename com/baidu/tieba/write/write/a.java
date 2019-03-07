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
    private TbCheckBox.a gwb;
    private AtListActivity jrJ;
    private boolean jrL;
    private final Context mContext;
    private b jrK = null;
    private ViewGroup mParent = null;

    /* loaded from: classes3.dex */
    public interface b {
        void a(View view, MetaData metaData);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b bVar) {
        this.jrK = bVar;
    }

    public a(AtListActivity atListActivity, boolean z) {
        this.jrL = true;
        this.jrJ = atListActivity;
        this.mContext = this.jrJ.getPageContext().getContext();
        this.jrL = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setData(ArrayList<MetaData> arrayList) {
        this.aFH = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(TbCheckBox.a aVar) {
        this.gwb = aVar;
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
    /* renamed from: Bv */
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
        C0321a c0321a;
        if (this.mParent == null) {
            this.mParent = viewGroup;
        }
        MetaData item = getItem(i);
        if (item != null) {
            c0321a = a(view != null ? view.getTag() : null, item);
        } else {
            c0321a = null;
        }
        if (c0321a != null) {
            return c0321a.rootView;
        }
        return null;
    }

    private C0321a a(Object obj, MetaData metaData) {
        C0321a c0321a;
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (obj == null) {
            c0321a = cpX();
        } else {
            c0321a = (C0321a) obj;
        }
        if (this.jrK != null) {
            this.jrK.a(c0321a.rootView, metaData);
        }
        String portrait = metaData.getPortrait();
        c0321a.dBb.setText(metaData.getName_show());
        c0321a.gwe.setTagData(metaData);
        c0321a.gvJ.setTag(portrait);
        if (this.jrL) {
            c0321a.gwe.setVisibility(0);
        } else {
            c0321a.gwe.setVisibility(8);
        }
        c0321a.gvJ.startLoad(portrait, 12, false);
        this.jrJ.getPageContext().getLayoutMode().setNightMode(skinType == 1);
        this.jrJ.getPageContext().getLayoutMode().onModeChanged(c0321a.rootView);
        return c0321a;
    }

    private C0321a cpX() {
        C0321a c0321a = new C0321a();
        c0321a.rootView = LayoutInflater.from(this.mContext).inflate(d.h.invite_friend_list_item, (ViewGroup) null);
        c0321a.gvJ = (HeadImageView) c0321a.rootView.findViewById(d.g.photo);
        c0321a.gvJ.setIsRound(false);
        c0321a.dBb = (TextView) c0321a.rootView.findViewById(d.g.txt_user_name);
        c0321a.gwe = (TbCheckBox) c0321a.rootView.findViewById(d.g.ckb_select);
        if (this.gwb != null) {
            c0321a.gwe.setStatedChangedListener(this.gwb);
        }
        c0321a.rootView.setTag(c0321a);
        return c0321a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.write.write.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0321a {
        public TextView dBb;
        public HeadImageView gvJ;
        public TbCheckBox gwe;
        public View rootView;

        private C0321a() {
        }
    }
}
