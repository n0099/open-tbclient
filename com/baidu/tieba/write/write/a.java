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
        C0547a c0547a;
        if (this.mParent == null) {
            this.mParent = viewGroup;
        }
        MetaData item = getItem(i);
        if (item != null) {
            c0547a = a(view != null ? view.getTag() : null, item);
        } else {
            c0547a = null;
        }
        if (c0547a != null) {
            return c0547a.rootView;
        }
        return null;
    }

    private C0547a a(Object obj, MetaData metaData) {
        C0547a c0547a;
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (obj == null) {
            c0547a = czd();
        } else {
            c0547a = (C0547a) obj;
        }
        if (this.jSC != null) {
            this.jSC.a(c0547a.rootView, metaData);
        }
        String portrait = metaData.getPortrait();
        c0547a.evA.setText(metaData.getName_show());
        c0547a.gTm.setTagData(metaData);
        c0547a.gSR.setTag(portrait);
        if (this.jSD) {
            c0547a.gTm.setVisibility(0);
        } else {
            c0547a.gTm.setVisibility(8);
        }
        c0547a.gSR.startLoad(portrait, 12, false);
        this.jSB.getPageContext().getLayoutMode().setNightMode(skinType == 1);
        this.jSB.getPageContext().getLayoutMode().onModeChanged(c0547a.rootView);
        return c0547a;
    }

    private C0547a czd() {
        C0547a c0547a = new C0547a();
        c0547a.rootView = LayoutInflater.from(this.mContext).inflate(R.layout.invite_friend_list_item, (ViewGroup) null);
        c0547a.gSR = (HeadImageView) c0547a.rootView.findViewById(R.id.photo);
        c0547a.gSR.setIsRound(false);
        c0547a.evA = (TextView) c0547a.rootView.findViewById(R.id.txt_user_name);
        c0547a.gTm = (TbCheckBox) c0547a.rootView.findViewById(R.id.ckb_select);
        if (this.gTj != null) {
            c0547a.gTm.setStatedChangedListener(this.gTj);
        }
        c0547a.rootView.setTag(c0547a);
        return c0547a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.write.write.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0547a {
        public TextView evA;
        public HeadImageView gSR;
        public TbCheckBox gTm;
        public View rootView;

        private C0547a() {
        }
    }
}
