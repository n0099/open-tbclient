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
    private TbCheckBox.a dPG;
    private AtListActivity gVd;
    private boolean gVf;
    private final Context mContext;
    private b gVe = null;
    private ViewGroup brP = null;

    /* loaded from: classes2.dex */
    public interface b {
        void a(View view, MetaData metaData);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b bVar) {
        this.gVe = bVar;
    }

    public a(AtListActivity atListActivity, boolean z) {
        this.gVf = true;
        this.gVd = atListActivity;
        this.mContext = this.gVd.getPageContext().getContext();
        this.gVf = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setData(ArrayList<MetaData> arrayList) {
        this.acc = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(TbCheckBox.a aVar) {
        this.dPG = aVar;
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
    /* renamed from: vD */
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
        C0145a c0145a;
        if (this.brP == null) {
            this.brP = viewGroup;
        }
        MetaData item = getItem(i);
        if (item != null) {
            c0145a = a(view != null ? view.getTag() : null, item);
        } else {
            c0145a = null;
        }
        if (c0145a != null) {
            return c0145a.rootView;
        }
        return null;
    }

    private C0145a a(Object obj, MetaData metaData) {
        C0145a c0145a;
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (obj == null) {
            c0145a = bEl();
        } else {
            c0145a = (C0145a) obj;
        }
        if (this.gVe != null) {
            this.gVe.a(c0145a.rootView, metaData);
        }
        String portrait = metaData.getPortrait();
        c0145a.bOl.setText(metaData.getName_show());
        c0145a.dPJ.setTagData(metaData);
        c0145a.dPp.setTag(portrait);
        if (this.gVf) {
            c0145a.dPJ.setVisibility(0);
        } else {
            c0145a.dPJ.setVisibility(8);
        }
        c0145a.dPp.startLoad(portrait, 12, false);
        this.gVd.getPageContext().getLayoutMode().ag(skinType == 1);
        this.gVd.getPageContext().getLayoutMode().t(c0145a.rootView);
        return c0145a;
    }

    private C0145a bEl() {
        C0145a c0145a = new C0145a();
        c0145a.rootView = LayoutInflater.from(this.mContext).inflate(d.h.invite_friend_list_item, (ViewGroup) null);
        c0145a.dPp = (HeadImageView) c0145a.rootView.findViewById(d.g.photo);
        c0145a.dPp.setIsRound(false);
        c0145a.bOl = (TextView) c0145a.rootView.findViewById(d.g.txt_user_name);
        c0145a.dPJ = (TbCheckBox) c0145a.rootView.findViewById(d.g.ckb_select);
        if (this.dPG != null) {
            c0145a.dPJ.setStatedChangedListener(this.dPG);
        }
        c0145a.rootView.setTag(c0145a);
        return c0145a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.write.write.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0145a {
        public TextView bOl;
        public TbCheckBox dPJ;
        public HeadImageView dPp;
        public View rootView;

        private C0145a() {
        }
    }
}
