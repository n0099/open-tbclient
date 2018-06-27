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
    private ArrayList<MetaData> alT;
    private TbCheckBox.a eBu;
    private AtListActivity hwT;
    private boolean hwV;
    private final Context mContext;
    private b hwU = null;
    private ViewGroup mParent = null;

    /* loaded from: classes3.dex */
    public interface b {
        void a(View view, MetaData metaData);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b bVar) {
        this.hwU = bVar;
    }

    public a(AtListActivity atListActivity, boolean z) {
        this.hwV = true;
        this.hwT = atListActivity;
        this.mContext = this.hwT.getPageContext().getContext();
        this.hwV = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setData(ArrayList<MetaData> arrayList) {
        this.alT = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(TbCheckBox.a aVar) {
        this.eBu = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.alT == null) {
            return 0;
        }
        return this.alT.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: vF */
    public MetaData getItem(int i) {
        if (this.alT != null && i < this.alT.size()) {
            return this.alT.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0261a c0261a;
        if (this.mParent == null) {
            this.mParent = viewGroup;
        }
        MetaData item = getItem(i);
        if (item != null) {
            c0261a = a(view != null ? view.getTag() : null, item);
        } else {
            c0261a = null;
        }
        if (c0261a != null) {
            return c0261a.rootView;
        }
        return null;
    }

    private C0261a a(Object obj, MetaData metaData) {
        C0261a c0261a;
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (obj == null) {
            c0261a = bIs();
        } else {
            c0261a = (C0261a) obj;
        }
        if (this.hwU != null) {
            this.hwU.a(c0261a.rootView, metaData);
        }
        String portrait = metaData.getPortrait();
        c0261a.bRW.setText(metaData.getName_show());
        c0261a.eBx.setTagData(metaData);
        c0261a.eBd.setTag(portrait);
        if (this.hwV) {
            c0261a.eBx.setVisibility(0);
        } else {
            c0261a.eBx.setVisibility(8);
        }
        c0261a.eBd.startLoad(portrait, 12, false);
        this.hwT.getPageContext().getLayoutMode().setNightMode(skinType == 1);
        this.hwT.getPageContext().getLayoutMode().onModeChanged(c0261a.rootView);
        return c0261a;
    }

    private C0261a bIs() {
        C0261a c0261a = new C0261a();
        c0261a.rootView = LayoutInflater.from(this.mContext).inflate(d.i.invite_friend_list_item, (ViewGroup) null);
        c0261a.eBd = (HeadImageView) c0261a.rootView.findViewById(d.g.photo);
        c0261a.eBd.setIsRound(false);
        c0261a.bRW = (TextView) c0261a.rootView.findViewById(d.g.txt_user_name);
        c0261a.eBx = (TbCheckBox) c0261a.rootView.findViewById(d.g.ckb_select);
        if (this.eBu != null) {
            c0261a.eBx.setStatedChangedListener(this.eBu);
        }
        c0261a.rootView.setTag(c0261a);
        return c0261a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.write.write.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0261a {
        public TextView bRW;
        public HeadImageView eBd;
        public TbCheckBox eBx;
        public View rootView;

        private C0261a() {
        }
    }
}
