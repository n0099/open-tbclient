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
    private ArrayList<MetaData> acu;
    private TbCheckBox.a dYJ;
    private AtListActivity hkm;
    private boolean hko;
    private final Context mContext;
    private b hkn = null;
    private ViewGroup byL = null;

    /* loaded from: classes2.dex */
    public interface b {
        void a(View view, MetaData metaData);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b bVar) {
        this.hkn = bVar;
    }

    public a(AtListActivity atListActivity, boolean z) {
        this.hko = true;
        this.hkm = atListActivity;
        this.mContext = this.hkm.getPageContext().getContext();
        this.hko = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setData(ArrayList<MetaData> arrayList) {
        this.acu = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(TbCheckBox.a aVar) {
        this.dYJ = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.acu == null) {
            return 0;
        }
        return this.acu.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: wq */
    public MetaData getItem(int i) {
        if (this.acu != null && i < this.acu.size()) {
            return this.acu.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0162a c0162a;
        if (this.byL == null) {
            this.byL = viewGroup;
        }
        MetaData item = getItem(i);
        if (item != null) {
            c0162a = a(view != null ? view.getTag() : null, item);
        } else {
            c0162a = null;
        }
        if (c0162a != null) {
            return c0162a.rootView;
        }
        return null;
    }

    private C0162a a(Object obj, MetaData metaData) {
        C0162a c0162a;
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (obj == null) {
            c0162a = bHU();
        } else {
            c0162a = (C0162a) obj;
        }
        if (this.hkn != null) {
            this.hkn.a(c0162a.rootView, metaData);
        }
        String portrait = metaData.getPortrait();
        c0162a.bWF.setText(metaData.getName_show());
        c0162a.dYM.setTagData(metaData);
        c0162a.dYs.setTag(portrait);
        if (this.hko) {
            c0162a.dYM.setVisibility(0);
        } else {
            c0162a.dYM.setVisibility(8);
        }
        c0162a.dYs.startLoad(portrait, 12, false);
        this.hkm.getPageContext().getLayoutMode().ag(skinType == 1);
        this.hkm.getPageContext().getLayoutMode().t(c0162a.rootView);
        return c0162a;
    }

    private C0162a bHU() {
        C0162a c0162a = new C0162a();
        c0162a.rootView = LayoutInflater.from(this.mContext).inflate(d.h.invite_friend_list_item, (ViewGroup) null);
        c0162a.dYs = (HeadImageView) c0162a.rootView.findViewById(d.g.photo);
        c0162a.dYs.setIsRound(false);
        c0162a.bWF = (TextView) c0162a.rootView.findViewById(d.g.txt_user_name);
        c0162a.dYM = (TbCheckBox) c0162a.rootView.findViewById(d.g.ckb_select);
        if (this.dYJ != null) {
            c0162a.dYM.setStatedChangedListener(this.dYJ);
        }
        c0162a.rootView.setTag(c0162a);
        return c0162a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.write.write.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0162a {
        public TextView bWF;
        public TbCheckBox dYM;
        public HeadImageView dYs;
        public View rootView;

        private C0162a() {
        }
    }
}
