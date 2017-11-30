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
/* loaded from: classes2.dex */
public class a extends BaseAdapter {
    private ArrayList<MetaData> acx;
    private TbCheckBox.a dXA;
    private AtListActivity hho;
    private boolean hhq;
    private final Context mContext;
    private b hhp = null;
    private ViewGroup byF = null;

    /* loaded from: classes2.dex */
    public interface b {
        void a(View view, MetaData metaData);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b bVar) {
        this.hhp = bVar;
    }

    public a(AtListActivity atListActivity, boolean z) {
        this.hhq = true;
        this.hho = atListActivity;
        this.mContext = this.hho.getPageContext().getContext();
        this.hhq = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setData(ArrayList<MetaData> arrayList) {
        this.acx = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(TbCheckBox.a aVar) {
        this.dXA = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.acx == null) {
            return 0;
        }
        return this.acx.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: wd */
    public MetaData getItem(int i) {
        if (this.acx != null && i < this.acx.size()) {
            return this.acx.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0146a c0146a;
        if (this.byF == null) {
            this.byF = viewGroup;
        }
        MetaData item = getItem(i);
        if (item != null) {
            c0146a = a(view != null ? view.getTag() : null, item);
        } else {
            c0146a = null;
        }
        if (c0146a != null) {
            return c0146a.rootView;
        }
        return null;
    }

    private C0146a a(Object obj, MetaData metaData) {
        C0146a c0146a;
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (obj == null) {
            c0146a = bHh();
        } else {
            c0146a = (C0146a) obj;
        }
        if (this.hhp != null) {
            this.hhp.a(c0146a.rootView, metaData);
        }
        String portrait = metaData.getPortrait();
        c0146a.bWx.setText(metaData.getName_show());
        c0146a.dXD.setTagData(metaData);
        c0146a.dXj.setTag(portrait);
        if (this.hhq) {
            c0146a.dXD.setVisibility(0);
        } else {
            c0146a.dXD.setVisibility(8);
        }
        c0146a.dXj.startLoad(portrait, 12, false);
        this.hho.getPageContext().getLayoutMode().ag(skinType == 1);
        this.hho.getPageContext().getLayoutMode().t(c0146a.rootView);
        return c0146a;
    }

    private C0146a bHh() {
        C0146a c0146a = new C0146a();
        c0146a.rootView = LayoutInflater.from(this.mContext).inflate(d.h.invite_friend_list_item, (ViewGroup) null);
        c0146a.dXj = (HeadImageView) c0146a.rootView.findViewById(d.g.photo);
        c0146a.dXj.setIsRound(false);
        c0146a.bWx = (TextView) c0146a.rootView.findViewById(d.g.txt_user_name);
        c0146a.dXD = (TbCheckBox) c0146a.rootView.findViewById(d.g.ckb_select);
        if (this.dXA != null) {
            c0146a.dXD.setStatedChangedListener(this.dXA);
        }
        c0146a.rootView.setTag(c0146a);
        return c0146a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.write.write.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0146a {
        public TextView bWx;
        public TbCheckBox dXD;
        public HeadImageView dXj;
        public View rootView;

        private C0146a() {
        }
    }
}
