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
    private ArrayList<MetaData> eCX;
    private TbCheckBox.a kmv;
    private final Context mContext;
    private AtListActivity nFj;
    private boolean nFl;
    private b nFk = null;
    private ViewGroup mParent = null;

    /* loaded from: classes3.dex */
    public interface b {
        void a(View view, MetaData metaData);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b bVar) {
        this.nFk = bVar;
    }

    public a(AtListActivity atListActivity, boolean z) {
        this.nFl = true;
        this.nFj = atListActivity;
        this.mContext = this.nFj.getPageContext().getContext();
        this.nFl = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setData(ArrayList<MetaData> arrayList) {
        this.eCX = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(TbCheckBox.a aVar) {
        this.kmv = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eCX == null) {
            return 0;
        }
        return this.eCX.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: Ln */
    public MetaData getItem(int i) {
        if (this.eCX != null && i < this.eCX.size()) {
            return this.eCX.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0871a c0871a;
        if (this.mParent == null) {
            this.mParent = viewGroup;
        }
        MetaData item = getItem(i);
        if (item != null) {
            c0871a = a(view != null ? view.getTag() : null, item);
        } else {
            c0871a = null;
        }
        if (c0871a != null) {
            return c0871a.rootView;
        }
        return null;
    }

    private C0871a a(Object obj, MetaData metaData) {
        C0871a c0871a;
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (obj == null) {
            c0871a = dSh();
        } else {
            c0871a = (C0871a) obj;
        }
        if (this.nFk != null) {
            this.nFk.a(c0871a.rootView, metaData);
        }
        String avater = metaData.getAvater();
        c0871a.hws.setText(metaData.getName_show());
        c0871a.kmy.setTagData(metaData);
        c0871a.kmc.setTag(avater);
        if (this.nFl) {
            c0871a.kmy.setVisibility(0);
        } else {
            c0871a.kmy.setVisibility(8);
        }
        c0871a.kmc.startLoad(avater, 12, false);
        this.nFj.getPageContext().getLayoutMode().setNightMode(skinType == 1);
        this.nFj.getPageContext().getLayoutMode().onModeChanged(c0871a.rootView);
        return c0871a;
    }

    private C0871a dSh() {
        C0871a c0871a = new C0871a();
        c0871a.rootView = LayoutInflater.from(this.mContext).inflate(R.layout.invite_friend_list_item, (ViewGroup) null);
        c0871a.kmc = (HeadImageView) c0871a.rootView.findViewById(R.id.photo);
        c0871a.kmc.setIsRound(false);
        c0871a.hws = (TextView) c0871a.rootView.findViewById(R.id.txt_user_name);
        c0871a.kmy = (TbCheckBox) c0871a.rootView.findViewById(R.id.ckb_select);
        if (this.kmv != null) {
            c0871a.kmy.setStatedChangedListener(this.kmv);
        }
        c0871a.rootView.setTag(c0871a);
        return c0871a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.write.write.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0871a {
        public TextView hws;
        public HeadImageView kmc;
        public TbCheckBox kmy;
        public View rootView;

        private C0871a() {
        }
    }
}
