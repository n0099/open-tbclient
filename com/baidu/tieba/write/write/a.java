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
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    private ArrayList<MetaData> dWx;
    private TbCheckBox.a jns;
    private AtListActivity mAF;
    private boolean mAH;
    private final Context mContext;
    private b mAG = null;
    private ViewGroup mParent = null;

    /* loaded from: classes3.dex */
    public interface b {
        void a(View view, MetaData metaData);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b bVar) {
        this.mAG = bVar;
    }

    public a(AtListActivity atListActivity, boolean z) {
        this.mAH = true;
        this.mAF = atListActivity;
        this.mContext = this.mAF.getPageContext().getContext();
        this.mAH = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setData(ArrayList<MetaData> arrayList) {
        this.dWx = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(TbCheckBox.a aVar) {
        this.jns = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.dWx == null) {
            return 0;
        }
        return this.dWx.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: Hn */
    public MetaData getItem(int i) {
        if (this.dWx != null && i < this.dWx.size()) {
            return this.dWx.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0788a c0788a;
        if (this.mParent == null) {
            this.mParent = viewGroup;
        }
        MetaData item = getItem(i);
        if (item != null) {
            c0788a = a(view != null ? view.getTag() : null, item);
        } else {
            c0788a = null;
        }
        if (c0788a != null) {
            return c0788a.rootView;
        }
        return null;
    }

    private C0788a a(Object obj, MetaData metaData) {
        C0788a c0788a;
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (obj == null) {
            c0788a = dvN();
        } else {
            c0788a = (C0788a) obj;
        }
        if (this.mAG != null) {
            this.mAG.a(c0788a.rootView, metaData);
        }
        String avater = metaData.getAvater();
        c0788a.gFm.setText(metaData.getName_show());
        c0788a.jnv.setTagData(metaData);
        c0788a.jmZ.setTag(avater);
        if (this.mAH) {
            c0788a.jnv.setVisibility(0);
        } else {
            c0788a.jnv.setVisibility(8);
        }
        c0788a.jmZ.startLoad(avater, 12, false);
        this.mAF.getPageContext().getLayoutMode().setNightMode(skinType == 1);
        this.mAF.getPageContext().getLayoutMode().onModeChanged(c0788a.rootView);
        return c0788a;
    }

    private C0788a dvN() {
        C0788a c0788a = new C0788a();
        c0788a.rootView = LayoutInflater.from(this.mContext).inflate(R.layout.invite_friend_list_item, (ViewGroup) null);
        c0788a.jmZ = (HeadImageView) c0788a.rootView.findViewById(R.id.photo);
        c0788a.jmZ.setIsRound(false);
        c0788a.gFm = (TextView) c0788a.rootView.findViewById(R.id.txt_user_name);
        c0788a.jnv = (TbCheckBox) c0788a.rootView.findViewById(R.id.ckb_select);
        if (this.jns != null) {
            c0788a.jnv.setStatedChangedListener(this.jns);
        }
        c0788a.rootView.setTag(c0788a);
        return c0788a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.write.write.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0788a {
        public TextView gFm;
        public HeadImageView jmZ;
        public TbCheckBox jnv;
        public View rootView;

        private C0788a() {
        }
    }
}
