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
import com.baidu.tieba.e;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    private TbCheckBox.a ffV;
    private AtListActivity iaZ;
    private boolean ibb;
    private final Context mContext;
    private ArrayList<MetaData> mData;
    private b iba = null;
    private ViewGroup mParent = null;

    /* loaded from: classes3.dex */
    public interface b {
        void a(View view, MetaData metaData);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b bVar) {
        this.iba = bVar;
    }

    public a(AtListActivity atListActivity, boolean z) {
        this.ibb = true;
        this.iaZ = atListActivity;
        this.mContext = this.iaZ.getPageContext().getContext();
        this.ibb = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setData(ArrayList<MetaData> arrayList) {
        this.mData = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(TbCheckBox.a aVar) {
        this.ffV = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.mData == null) {
            return 0;
        }
        return this.mData.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: xG */
    public MetaData getItem(int i) {
        if (this.mData != null && i < this.mData.size()) {
            return this.mData.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0343a c0343a;
        if (this.mParent == null) {
            this.mParent = viewGroup;
        }
        MetaData item = getItem(i);
        if (item != null) {
            c0343a = a(view != null ? view.getTag() : null, item);
        } else {
            c0343a = null;
        }
        if (c0343a != null) {
            return c0343a.rootView;
        }
        return null;
    }

    private C0343a a(Object obj, MetaData metaData) {
        C0343a c0343a;
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (obj == null) {
            c0343a = bQn();
        } else {
            c0343a = (C0343a) obj;
        }
        if (this.iba != null) {
            this.iba.a(c0343a.rootView, metaData);
        }
        String portrait = metaData.getPortrait();
        c0343a.cma.setText(metaData.getName_show());
        c0343a.ffY.setTagData(metaData);
        c0343a.ffD.setTag(portrait);
        if (this.ibb) {
            c0343a.ffY.setVisibility(0);
        } else {
            c0343a.ffY.setVisibility(8);
        }
        c0343a.ffD.startLoad(portrait, 12, false);
        this.iaZ.getPageContext().getLayoutMode().setNightMode(skinType == 1);
        this.iaZ.getPageContext().getLayoutMode().onModeChanged(c0343a.rootView);
        return c0343a;
    }

    private C0343a bQn() {
        C0343a c0343a = new C0343a();
        c0343a.rootView = LayoutInflater.from(this.mContext).inflate(e.h.invite_friend_list_item, (ViewGroup) null);
        c0343a.ffD = (HeadImageView) c0343a.rootView.findViewById(e.g.photo);
        c0343a.ffD.setIsRound(false);
        c0343a.cma = (TextView) c0343a.rootView.findViewById(e.g.txt_user_name);
        c0343a.ffY = (TbCheckBox) c0343a.rootView.findViewById(e.g.ckb_select);
        if (this.ffV != null) {
            c0343a.ffY.setStatedChangedListener(this.ffV);
        }
        c0343a.rootView.setTag(c0343a);
        return c0343a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.write.write.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0343a {
        public TextView cma;
        public HeadImageView ffD;
        public TbCheckBox ffY;
        public View rootView;

        private C0343a() {
        }
    }
}
