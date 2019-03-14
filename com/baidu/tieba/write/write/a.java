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
    private ArrayList<MetaData> aFI;
    private TbCheckBox.a gwb;
    private AtListActivity jrU;
    private boolean jrW;
    private final Context mContext;
    private b jrV = null;
    private ViewGroup mParent = null;

    /* loaded from: classes3.dex */
    public interface b {
        void a(View view, MetaData metaData);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b bVar) {
        this.jrV = bVar;
    }

    public a(AtListActivity atListActivity, boolean z) {
        this.jrW = true;
        this.jrU = atListActivity;
        this.mContext = this.jrU.getPageContext().getContext();
        this.jrW = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setData(ArrayList<MetaData> arrayList) {
        this.aFI = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(TbCheckBox.a aVar) {
        this.gwb = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aFI == null) {
            return 0;
        }
        return this.aFI.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: Bw */
    public MetaData getItem(int i) {
        if (this.aFI != null && i < this.aFI.size()) {
            return this.aFI.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0417a c0417a;
        if (this.mParent == null) {
            this.mParent = viewGroup;
        }
        MetaData item = getItem(i);
        if (item != null) {
            c0417a = a(view != null ? view.getTag() : null, item);
        } else {
            c0417a = null;
        }
        if (c0417a != null) {
            return c0417a.rootView;
        }
        return null;
    }

    private C0417a a(Object obj, MetaData metaData) {
        C0417a c0417a;
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (obj == null) {
            c0417a = cqk();
        } else {
            c0417a = (C0417a) obj;
        }
        if (this.jrV != null) {
            this.jrV.a(c0417a.rootView, metaData);
        }
        String portrait = metaData.getPortrait();
        c0417a.dAX.setText(metaData.getName_show());
        c0417a.gwe.setTagData(metaData);
        c0417a.gvJ.setTag(portrait);
        if (this.jrW) {
            c0417a.gwe.setVisibility(0);
        } else {
            c0417a.gwe.setVisibility(8);
        }
        c0417a.gvJ.startLoad(portrait, 12, false);
        this.jrU.getPageContext().getLayoutMode().setNightMode(skinType == 1);
        this.jrU.getPageContext().getLayoutMode().onModeChanged(c0417a.rootView);
        return c0417a;
    }

    private C0417a cqk() {
        C0417a c0417a = new C0417a();
        c0417a.rootView = LayoutInflater.from(this.mContext).inflate(d.h.invite_friend_list_item, (ViewGroup) null);
        c0417a.gvJ = (HeadImageView) c0417a.rootView.findViewById(d.g.photo);
        c0417a.gvJ.setIsRound(false);
        c0417a.dAX = (TextView) c0417a.rootView.findViewById(d.g.txt_user_name);
        c0417a.gwe = (TbCheckBox) c0417a.rootView.findViewById(d.g.ckb_select);
        if (this.gwb != null) {
            c0417a.gwe.setStatedChangedListener(this.gwb);
        }
        c0417a.rootView.setTag(c0417a);
        return c0417a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.write.write.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0417a {
        public TextView dAX;
        public HeadImageView gvJ;
        public TbCheckBox gwe;
        public View rootView;

        private C0417a() {
        }
    }
}
