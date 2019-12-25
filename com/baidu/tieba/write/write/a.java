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
/* loaded from: classes10.dex */
public class a extends BaseAdapter {
    private ArrayList<MetaData> cRE;
    private TbCheckBox.a hHm;
    private AtListActivity kNo;
    private boolean kNq;
    private final Context mContext;
    private b kNp = null;
    private ViewGroup mParent = null;

    /* loaded from: classes10.dex */
    public interface b {
        void a(View view, MetaData metaData);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b bVar) {
        this.kNp = bVar;
    }

    public a(AtListActivity atListActivity, boolean z) {
        this.kNq = true;
        this.kNo = atListActivity;
        this.mContext = this.kNo.getPageContext().getContext();
        this.kNq = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setData(ArrayList<MetaData> arrayList) {
        this.cRE = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(TbCheckBox.a aVar) {
        this.hHm = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.cRE == null) {
            return 0;
        }
        return this.cRE.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: Eg */
    public MetaData getItem(int i) {
        if (this.cRE != null && i < this.cRE.size()) {
            return this.cRE.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0627a c0627a;
        if (this.mParent == null) {
            this.mParent = viewGroup;
        }
        MetaData item = getItem(i);
        if (item != null) {
            c0627a = a(view != null ? view.getTag() : null, item);
        } else {
            c0627a = null;
        }
        if (c0627a != null) {
            return c0627a.rootView;
        }
        return null;
    }

    private C0627a a(Object obj, MetaData metaData) {
        C0627a c0627a;
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (obj == null) {
            c0627a = cTd();
        } else {
            c0627a = (C0627a) obj;
        }
        if (this.kNp != null) {
            this.kNp.a(c0627a.rootView, metaData);
        }
        String avater = metaData.getAvater();
        c0627a.fmZ.setText(metaData.getName_show());
        c0627a.hHp.setTagData(metaData);
        c0627a.hGU.setTag(avater);
        if (this.kNq) {
            c0627a.hHp.setVisibility(0);
        } else {
            c0627a.hHp.setVisibility(8);
        }
        c0627a.hGU.startLoad(avater, 12, false);
        this.kNo.getPageContext().getLayoutMode().setNightMode(skinType == 1);
        this.kNo.getPageContext().getLayoutMode().onModeChanged(c0627a.rootView);
        return c0627a;
    }

    private C0627a cTd() {
        C0627a c0627a = new C0627a();
        c0627a.rootView = LayoutInflater.from(this.mContext).inflate(R.layout.invite_friend_list_item, (ViewGroup) null);
        c0627a.hGU = (HeadImageView) c0627a.rootView.findViewById(R.id.photo);
        c0627a.hGU.setIsRound(false);
        c0627a.fmZ = (TextView) c0627a.rootView.findViewById(R.id.txt_user_name);
        c0627a.hHp = (TbCheckBox) c0627a.rootView.findViewById(R.id.ckb_select);
        if (this.hHm != null) {
            c0627a.hHp.setStatedChangedListener(this.hHm);
        }
        c0627a.rootView.setTag(c0627a);
        return c0627a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.write.write.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public class C0627a {
        public TextView fmZ;
        public HeadImageView hGU;
        public TbCheckBox hHp;
        public View rootView;

        private C0627a() {
        }
    }
}
