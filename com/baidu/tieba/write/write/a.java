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
    private ArrayList<MetaData> acc;
    private TbCheckBox.a dPL;
    private AtListActivity gWn;
    private boolean gWp;
    private final Context mContext;
    private b gWo = null;
    private ViewGroup brZ = null;

    /* loaded from: classes2.dex */
    public interface b {
        void a(View view, MetaData metaData);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b bVar) {
        this.gWo = bVar;
    }

    public a(AtListActivity atListActivity, boolean z) {
        this.gWp = true;
        this.gWn = atListActivity;
        this.mContext = this.gWn.getPageContext().getContext();
        this.gWp = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setData(ArrayList<MetaData> arrayList) {
        this.acc = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(TbCheckBox.a aVar) {
        this.dPL = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.acc == null) {
            return 0;
        }
        return this.acc.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: vH */
    public MetaData getItem(int i) {
        if (this.acc != null && i < this.acc.size()) {
            return this.acc.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0148a c0148a;
        if (this.brZ == null) {
            this.brZ = viewGroup;
        }
        MetaData item = getItem(i);
        if (item != null) {
            c0148a = a(view != null ? view.getTag() : null, item);
        } else {
            c0148a = null;
        }
        if (c0148a != null) {
            return c0148a.rootView;
        }
        return null;
    }

    private C0148a a(Object obj, MetaData metaData) {
        C0148a c0148a;
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (obj == null) {
            c0148a = bEy();
        } else {
            c0148a = (C0148a) obj;
        }
        if (this.gWo != null) {
            this.gWo.a(c0148a.rootView, metaData);
        }
        String portrait = metaData.getPortrait();
        c0148a.bOy.setText(metaData.getName_show());
        c0148a.dPO.setTagData(metaData);
        c0148a.dPu.setTag(portrait);
        if (this.gWp) {
            c0148a.dPO.setVisibility(0);
        } else {
            c0148a.dPO.setVisibility(8);
        }
        c0148a.dPu.startLoad(portrait, 12, false);
        this.gWn.getPageContext().getLayoutMode().ag(skinType == 1);
        this.gWn.getPageContext().getLayoutMode().t(c0148a.rootView);
        return c0148a;
    }

    private C0148a bEy() {
        C0148a c0148a = new C0148a();
        c0148a.rootView = LayoutInflater.from(this.mContext).inflate(d.h.invite_friend_list_item, (ViewGroup) null);
        c0148a.dPu = (HeadImageView) c0148a.rootView.findViewById(d.g.photo);
        c0148a.dPu.setIsRound(false);
        c0148a.bOy = (TextView) c0148a.rootView.findViewById(d.g.txt_user_name);
        c0148a.dPO = (TbCheckBox) c0148a.rootView.findViewById(d.g.ckb_select);
        if (this.dPL != null) {
            c0148a.dPO.setStatedChangedListener(this.dPL);
        }
        c0148a.rootView.setTag(c0148a);
        return c0148a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.write.write.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0148a {
        public TextView bOy;
        public TbCheckBox dPO;
        public HeadImageView dPu;
        public View rootView;

        private C0148a() {
        }
    }
}
