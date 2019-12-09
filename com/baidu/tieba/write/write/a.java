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
    private ArrayList<MetaData> bbH;
    private TbCheckBox.a gTj;
    private AtListActivity jSB;
    private boolean jSD;
    private final Context mContext;
    private b jSC = null;
    private ViewGroup mParent = null;

    /* loaded from: classes3.dex */
    public interface b {
        void a(View view, MetaData metaData);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b bVar) {
        this.jSC = bVar;
    }

    public a(AtListActivity atListActivity, boolean z) {
        this.jSD = true;
        this.jSB = atListActivity;
        this.mContext = this.jSB.getPageContext().getContext();
        this.jSD = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setData(ArrayList<MetaData> arrayList) {
        this.bbH = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(TbCheckBox.a aVar) {
        this.gTj = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bbH == null) {
            return 0;
        }
        return this.bbH.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: BJ */
    public MetaData getItem(int i) {
        if (this.bbH != null && i < this.bbH.size()) {
            return this.bbH.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0542a c0542a;
        if (this.mParent == null) {
            this.mParent = viewGroup;
        }
        MetaData item = getItem(i);
        if (item != null) {
            c0542a = a(view != null ? view.getTag() : null, item);
        } else {
            c0542a = null;
        }
        if (c0542a != null) {
            return c0542a.rootView;
        }
        return null;
    }

    private C0542a a(Object obj, MetaData metaData) {
        C0542a c0542a;
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (obj == null) {
            c0542a = czd();
        } else {
            c0542a = (C0542a) obj;
        }
        if (this.jSC != null) {
            this.jSC.a(c0542a.rootView, metaData);
        }
        String portrait = metaData.getPortrait();
        c0542a.evA.setText(metaData.getName_show());
        c0542a.gTm.setTagData(metaData);
        c0542a.gSR.setTag(portrait);
        if (this.jSD) {
            c0542a.gTm.setVisibility(0);
        } else {
            c0542a.gTm.setVisibility(8);
        }
        c0542a.gSR.startLoad(portrait, 12, false);
        this.jSB.getPageContext().getLayoutMode().setNightMode(skinType == 1);
        this.jSB.getPageContext().getLayoutMode().onModeChanged(c0542a.rootView);
        return c0542a;
    }

    private C0542a czd() {
        C0542a c0542a = new C0542a();
        c0542a.rootView = LayoutInflater.from(this.mContext).inflate(R.layout.invite_friend_list_item, (ViewGroup) null);
        c0542a.gSR = (HeadImageView) c0542a.rootView.findViewById(R.id.photo);
        c0542a.gSR.setIsRound(false);
        c0542a.evA = (TextView) c0542a.rootView.findViewById(R.id.txt_user_name);
        c0542a.gTm = (TbCheckBox) c0542a.rootView.findViewById(R.id.ckb_select);
        if (this.gTj != null) {
            c0542a.gTm.setStatedChangedListener(this.gTj);
        }
        c0542a.rootView.setTag(c0542a);
        return c0542a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.write.write.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0542a {
        public TextView evA;
        public HeadImageView gSR;
        public TbCheckBox gTm;
        public View rootView;

        private C0542a() {
        }
    }
}
