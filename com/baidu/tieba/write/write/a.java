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
    private TbCheckBox.a iNf;
    private AtListActivity lWJ;
    private boolean lWL;
    private final Context mContext;
    private b lWK = null;
    private ViewGroup mParent = null;

    /* loaded from: classes2.dex */
    public interface b {
        void a(View view, MetaData metaData);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b bVar) {
        this.lWK = bVar;
    }

    public a(AtListActivity atListActivity, boolean z) {
        this.lWL = true;
        this.lWJ = atListActivity;
        this.mContext = this.lWJ.getPageContext().getContext();
        this.lWL = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setData(ArrayList<MetaData> arrayList) {
        this.dJp = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(TbCheckBox.a aVar) {
        this.iNf = aVar;
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
    /* renamed from: FL */
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
        C0760a c0760a;
        if (this.mParent == null) {
            this.mParent = viewGroup;
        }
        MetaData item = getItem(i);
        if (item != null) {
            c0760a = a(view != null ? view.getTag() : null, item);
        } else {
            c0760a = null;
        }
        if (c0760a != null) {
            return c0760a.rootView;
        }
        return null;
    }

    private C0760a a(Object obj, MetaData metaData) {
        C0760a c0760a;
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (obj == null) {
            c0760a = dnT();
        } else {
            c0760a = (C0760a) obj;
        }
        if (this.lWK != null) {
            this.lWK.a(c0760a.rootView, metaData);
        }
        String avater = metaData.getAvater();
        c0760a.gmQ.setText(metaData.getName_show());
        c0760a.iNi.setTagData(metaData);
        c0760a.iMM.setTag(avater);
        if (this.lWL) {
            c0760a.iNi.setVisibility(0);
        } else {
            c0760a.iNi.setVisibility(8);
        }
        c0760a.iMM.startLoad(avater, 12, false);
        this.lWJ.getPageContext().getLayoutMode().setNightMode(skinType == 1);
        this.lWJ.getPageContext().getLayoutMode().onModeChanged(c0760a.rootView);
        return c0760a;
    }

    private C0760a dnT() {
        C0760a c0760a = new C0760a();
        c0760a.rootView = LayoutInflater.from(this.mContext).inflate(R.layout.invite_friend_list_item, (ViewGroup) null);
        c0760a.iMM = (HeadImageView) c0760a.rootView.findViewById(R.id.photo);
        c0760a.iMM.setIsRound(false);
        c0760a.gmQ = (TextView) c0760a.rootView.findViewById(R.id.txt_user_name);
        c0760a.iNi = (TbCheckBox) c0760a.rootView.findViewById(R.id.ckb_select);
        if (this.iNf != null) {
            c0760a.iNi.setStatedChangedListener(this.iNf);
        }
        c0760a.rootView.setTag(c0760a);
        return c0760a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.write.write.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0760a {
        public TextView gmQ;
        public HeadImageView iMM;
        public TbCheckBox iNi;
        public View rootView;

        private C0760a() {
        }
    }
}
