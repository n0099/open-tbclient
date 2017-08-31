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
    private ArrayList<MetaData> abO;
    private TbCheckBox.a dKV;
    private AtListActivity gFE;
    private boolean gFG;
    private final Context mContext;
    private b gFF = null;
    private ViewGroup dKX = null;

    /* loaded from: classes2.dex */
    public interface b {
        void a(View view, MetaData metaData);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b bVar) {
        this.gFF = bVar;
    }

    public a(AtListActivity atListActivity, boolean z) {
        this.gFG = true;
        this.gFE = atListActivity;
        this.mContext = this.gFE.getPageContext().getContext();
        this.gFG = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setData(ArrayList<MetaData> arrayList) {
        this.abO = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(TbCheckBox.a aVar) {
        this.dKV = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.abO == null) {
            return 0;
        }
        return this.abO.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: uL */
    public MetaData getItem(int i) {
        if (this.abO != null && i < this.abO.size()) {
            return this.abO.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0132a c0132a;
        if (this.dKX == null) {
            this.dKX = viewGroup;
        }
        MetaData item = getItem(i);
        if (item != null) {
            c0132a = a(view != null ? view.getTag() : null, item);
        } else {
            c0132a = null;
        }
        if (c0132a != null) {
            return c0132a.rootView;
        }
        return null;
    }

    private C0132a a(Object obj, MetaData metaData) {
        C0132a c0132a;
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (obj == null) {
            c0132a = bzw();
        } else {
            c0132a = (C0132a) obj;
        }
        if (this.gFF != null) {
            this.gFF.a(c0132a.rootView, metaData);
        }
        String portrait = metaData.getPortrait();
        c0132a.bEL.setText(metaData.getName_show());
        c0132a.dKZ.setTagData(metaData);
        c0132a.dKF.setTag(portrait);
        if (this.gFG) {
            c0132a.dKZ.setVisibility(0);
        } else {
            c0132a.dKZ.setVisibility(8);
        }
        c0132a.dKF.c(portrait, 12, false);
        this.gFE.getPageContext().getLayoutMode().ah(skinType == 1);
        this.gFE.getPageContext().getLayoutMode().t(c0132a.rootView);
        return c0132a;
    }

    private C0132a bzw() {
        C0132a c0132a = new C0132a();
        c0132a.rootView = LayoutInflater.from(this.mContext).inflate(d.j.invite_friend_list_item, (ViewGroup) null);
        c0132a.dKF = (HeadImageView) c0132a.rootView.findViewById(d.h.photo);
        c0132a.dKF.setIsRound(false);
        c0132a.bEL = (TextView) c0132a.rootView.findViewById(d.h.txt_user_name);
        c0132a.dKZ = (TbCheckBox) c0132a.rootView.findViewById(d.h.ckb_select);
        if (this.dKV != null) {
            c0132a.dKZ.setStatedChangedListener(this.dKV);
        }
        c0132a.rootView.setTag(c0132a);
        return c0132a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.write.write.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0132a {
        public TextView bEL;
        public HeadImageView dKF;
        public TbCheckBox dKZ;
        public View rootView;

        private C0132a() {
        }
    }
}
