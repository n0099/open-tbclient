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
/* loaded from: classes2.dex */
public class a extends BaseAdapter {
    private ArrayList<MetaData> dJp;
    private TbCheckBox.a iNS;
    private AtListActivity lXU;
    private boolean lXW;
    private final Context mContext;
    private b lXV = null;
    private ViewGroup mParent = null;

    /* loaded from: classes2.dex */
    public interface b {
        void a(View view, MetaData metaData);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b bVar) {
        this.lXV = bVar;
    }

    public a(AtListActivity atListActivity, boolean z) {
        this.lXW = true;
        this.lXU = atListActivity;
        this.mContext = this.lXU.getPageContext().getContext();
        this.lXW = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setData(ArrayList<MetaData> arrayList) {
        this.dJp = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(TbCheckBox.a aVar) {
        this.iNS = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.dJp == null) {
            return 0;
        }
        return this.dJp.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: FN */
    public MetaData getItem(int i) {
        if (this.dJp != null && i < this.dJp.size()) {
            return this.dJp.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0761a c0761a;
        if (this.mParent == null) {
            this.mParent = viewGroup;
        }
        MetaData item = getItem(i);
        if (item != null) {
            c0761a = a(view != null ? view.getTag() : null, item);
        } else {
            c0761a = null;
        }
        if (c0761a != null) {
            return c0761a.rootView;
        }
        return null;
    }

    private C0761a a(Object obj, MetaData metaData) {
        C0761a c0761a;
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (obj == null) {
            c0761a = doi();
        } else {
            c0761a = (C0761a) obj;
        }
        if (this.lXV != null) {
            this.lXV.a(c0761a.rootView, metaData);
        }
        String avater = metaData.getAvater();
        c0761a.gnb.setText(metaData.getName_show());
        c0761a.iNV.setTagData(metaData);
        c0761a.iNz.setTag(avater);
        if (this.lXW) {
            c0761a.iNV.setVisibility(0);
        } else {
            c0761a.iNV.setVisibility(8);
        }
        c0761a.iNz.startLoad(avater, 12, false);
        this.lXU.getPageContext().getLayoutMode().setNightMode(skinType == 1);
        this.lXU.getPageContext().getLayoutMode().onModeChanged(c0761a.rootView);
        return c0761a;
    }

    private C0761a doi() {
        C0761a c0761a = new C0761a();
        c0761a.rootView = LayoutInflater.from(this.mContext).inflate(R.layout.invite_friend_list_item, (ViewGroup) null);
        c0761a.iNz = (HeadImageView) c0761a.rootView.findViewById(R.id.photo);
        c0761a.iNz.setIsRound(false);
        c0761a.gnb = (TextView) c0761a.rootView.findViewById(R.id.txt_user_name);
        c0761a.iNV = (TbCheckBox) c0761a.rootView.findViewById(R.id.ckb_select);
        if (this.iNS != null) {
            c0761a.iNV.setStatedChangedListener(this.iNS);
        }
        c0761a.rootView.setTag(c0761a);
        return c0761a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.write.write.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0761a {
        public TextView gnb;
        public TbCheckBox iNV;
        public HeadImageView iNz;
        public View rootView;

        private C0761a() {
        }
    }
}
