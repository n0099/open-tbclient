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
    private ArrayList<MetaData> adv;
    private TbCheckBox.a eli;
    private AtListActivity hfO;
    private boolean hfQ;
    private final Context mContext;
    private b hfP = null;
    private ViewGroup bHh = null;

    /* loaded from: classes3.dex */
    public interface b {
        void a(View view2, MetaData metaData);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b bVar) {
        this.hfP = bVar;
    }

    public a(AtListActivity atListActivity, boolean z) {
        this.hfQ = true;
        this.hfO = atListActivity;
        this.mContext = this.hfO.getPageContext().getContext();
        this.hfQ = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setData(ArrayList<MetaData> arrayList) {
        this.adv = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(TbCheckBox.a aVar) {
        this.eli = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.adv == null) {
            return 0;
        }
        return this.adv.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: vf */
    public MetaData getItem(int i) {
        if (this.adv != null && i < this.adv.size()) {
            return this.adv.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        C0242a c0242a;
        if (this.bHh == null) {
            this.bHh = viewGroup;
        }
        MetaData item = getItem(i);
        if (item != null) {
            c0242a = a(view2 != null ? view2.getTag() : null, item);
        } else {
            c0242a = null;
        }
        if (c0242a != null) {
            return c0242a.rootView;
        }
        return null;
    }

    private C0242a a(Object obj, MetaData metaData) {
        C0242a c0242a;
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (obj == null) {
            c0242a = bCO();
        } else {
            c0242a = (C0242a) obj;
        }
        if (this.hfP != null) {
            this.hfP.a(c0242a.rootView, metaData);
        }
        String portrait = metaData.getPortrait();
        c0242a.bGp.setText(metaData.getName_show());
        c0242a.ell.setTagData(metaData);
        c0242a.ekR.setTag(portrait);
        if (this.hfQ) {
            c0242a.ell.setVisibility(0);
        } else {
            c0242a.ell.setVisibility(8);
        }
        c0242a.ekR.startLoad(portrait, 12, false);
        this.hfO.getPageContext().getLayoutMode().setNightMode(skinType == 1);
        this.hfO.getPageContext().getLayoutMode().u(c0242a.rootView);
        return c0242a;
    }

    private C0242a bCO() {
        C0242a c0242a = new C0242a();
        c0242a.rootView = LayoutInflater.from(this.mContext).inflate(d.i.invite_friend_list_item, (ViewGroup) null);
        c0242a.ekR = (HeadImageView) c0242a.rootView.findViewById(d.g.photo);
        c0242a.ekR.setIsRound(false);
        c0242a.bGp = (TextView) c0242a.rootView.findViewById(d.g.txt_user_name);
        c0242a.ell = (TbCheckBox) c0242a.rootView.findViewById(d.g.ckb_select);
        if (this.eli != null) {
            c0242a.ell.setStatedChangedListener(this.eli);
        }
        c0242a.rootView.setTag(c0242a);
        return c0242a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.write.write.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0242a {
        public TextView bGp;
        public HeadImageView ekR;
        public TbCheckBox ell;
        public View rootView;

        private C0242a() {
        }
    }
}
