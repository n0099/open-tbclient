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
    private ArrayList<MetaData> aQH;
    private TbCheckBox.a eKM;
    private AtListActivity hSr;
    private boolean hSt;
    private final Context mContext;
    private b hSs = null;
    private ViewGroup cmO = null;

    /* loaded from: classes2.dex */
    public interface b {
        void a(View view, MetaData metaData);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b bVar) {
        this.hSs = bVar;
    }

    public a(AtListActivity atListActivity, boolean z) {
        this.hSt = true;
        this.hSr = atListActivity;
        this.mContext = this.hSr.getPageContext().getContext();
        this.hSt = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setData(ArrayList<MetaData> arrayList) {
        this.aQH = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(TbCheckBox.a aVar) {
        this.eKM = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aQH == null) {
            return 0;
        }
        return this.aQH.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: zh */
    public MetaData getItem(int i) {
        if (this.aQH != null && i < this.aQH.size()) {
            return this.aQH.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0175a c0175a;
        if (this.cmO == null) {
            this.cmO = viewGroup;
        }
        MetaData item = getItem(i);
        if (item != null) {
            c0175a = a(view != null ? view.getTag() : null, item);
        } else {
            c0175a = null;
        }
        if (c0175a != null) {
            return c0175a.rootView;
        }
        return null;
    }

    private C0175a a(Object obj, MetaData metaData) {
        C0175a c0175a;
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (obj == null) {
            c0175a = bNI();
        } else {
            c0175a = (C0175a) obj;
        }
        if (this.hSs != null) {
            this.hSs.a(c0175a.rootView, metaData);
        }
        String portrait = metaData.getPortrait();
        c0175a.cLm.setText(metaData.getName_show());
        c0175a.eKP.setTagData(metaData);
        c0175a.eKv.setTag(portrait);
        if (this.hSt) {
            c0175a.eKP.setVisibility(0);
        } else {
            c0175a.eKP.setVisibility(8);
        }
        c0175a.eKv.startLoad(portrait, 12, false);
        this.hSr.getPageContext().getLayoutMode().aM(skinType == 1);
        this.hSr.getPageContext().getLayoutMode().aM(c0175a.rootView);
        return c0175a;
    }

    private C0175a bNI() {
        C0175a c0175a = new C0175a();
        c0175a.rootView = LayoutInflater.from(this.mContext).inflate(d.h.invite_friend_list_item, (ViewGroup) null);
        c0175a.eKv = (HeadImageView) c0175a.rootView.findViewById(d.g.photo);
        c0175a.eKv.setIsRound(false);
        c0175a.cLm = (TextView) c0175a.rootView.findViewById(d.g.txt_user_name);
        c0175a.eKP = (TbCheckBox) c0175a.rootView.findViewById(d.g.ckb_select);
        if (this.eKM != null) {
            c0175a.eKP.setStatedChangedListener(this.eKM);
        }
        c0175a.rootView.setTag(c0175a);
        return c0175a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.write.write.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0175a {
        public TextView cLm;
        public TbCheckBox eKP;
        public HeadImageView eKv;
        public View rootView;

        private C0175a() {
        }
    }
}
