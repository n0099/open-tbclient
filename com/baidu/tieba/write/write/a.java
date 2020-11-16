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
    private ArrayList<MetaData> eHj;
    private TbCheckBox.a ktb;
    private final Context mContext;
    private AtListActivity nME;
    private boolean nMG;
    private b nMF = null;
    private ViewGroup mParent = null;

    /* loaded from: classes3.dex */
    public interface b {
        void a(View view, MetaData metaData);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b bVar) {
        this.nMF = bVar;
    }

    public a(AtListActivity atListActivity, boolean z) {
        this.nMG = true;
        this.nME = atListActivity;
        this.mContext = this.nME.getPageContext().getContext();
        this.nMG = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setData(ArrayList<MetaData> arrayList) {
        this.eHj = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(TbCheckBox.a aVar) {
        this.ktb = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eHj == null) {
            return 0;
        }
        return this.eHj.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: Md */
    public MetaData getItem(int i) {
        if (this.eHj != null && i < this.eHj.size()) {
            return this.eHj.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0889a c0889a;
        if (this.mParent == null) {
            this.mParent = viewGroup;
        }
        MetaData item = getItem(i);
        if (item != null) {
            c0889a = a(view != null ? view.getTag() : null, item);
        } else {
            c0889a = null;
        }
        if (c0889a != null) {
            return c0889a.rootView;
        }
        return null;
    }

    private C0889a a(Object obj, MetaData metaData) {
        C0889a c0889a;
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (obj == null) {
            c0889a = dUG();
        } else {
            c0889a = (C0889a) obj;
        }
        if (this.nMF != null) {
            this.nMF.a(c0889a.rootView, metaData);
        }
        String avater = metaData.getAvater();
        c0889a.hBW.setText(metaData.getName_show());
        c0889a.kte.setTagData(metaData);
        c0889a.ksI.setTag(avater);
        if (this.nMG) {
            c0889a.kte.setVisibility(0);
        } else {
            c0889a.kte.setVisibility(8);
        }
        c0889a.ksI.startLoad(avater, 12, false);
        this.nME.getPageContext().getLayoutMode().setNightMode(skinType == 1);
        this.nME.getPageContext().getLayoutMode().onModeChanged(c0889a.rootView);
        return c0889a;
    }

    private C0889a dUG() {
        C0889a c0889a = new C0889a();
        c0889a.rootView = LayoutInflater.from(this.mContext).inflate(R.layout.invite_friend_list_item, (ViewGroup) null);
        c0889a.ksI = (HeadImageView) c0889a.rootView.findViewById(R.id.photo);
        c0889a.ksI.setIsRound(false);
        c0889a.hBW = (TextView) c0889a.rootView.findViewById(R.id.txt_user_name);
        c0889a.kte = (TbCheckBox) c0889a.rootView.findViewById(R.id.ckb_select);
        c0889a.kte.setBackgroundDrawableIdIsWebP(true);
        c0889a.kte.setBackgroundDrawableId(R.drawable.icon_pure_strok324_select, R.drawable.icon_pure_strok324);
        if (this.ktb != null) {
            c0889a.kte.setStatedChangedListener(this.ktb);
        }
        c0889a.rootView.setTag(c0889a);
        return c0889a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.write.write.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0889a {
        public TextView hBW;
        public HeadImageView ksI;
        public TbCheckBox kte;
        public View rootView;

        private C0889a() {
        }
    }
}
