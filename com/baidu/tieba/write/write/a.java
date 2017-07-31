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
/* loaded from: classes.dex */
public class a extends BaseAdapter {
    private ArrayList<MetaData> acF;
    private TbCheckBox.a dCu;
    private AtListActivity gFh;
    private boolean gFj;
    private final Context mContext;
    private b gFi = null;
    private ViewGroup dCw = null;

    /* loaded from: classes.dex */
    public interface b {
        void a(View view, MetaData metaData);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b bVar) {
        this.gFi = bVar;
    }

    public a(AtListActivity atListActivity, boolean z) {
        this.gFj = true;
        this.gFh = atListActivity;
        this.mContext = this.gFh.getPageContext().getContext();
        this.gFj = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setData(ArrayList<MetaData> arrayList) {
        this.acF = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(TbCheckBox.a aVar) {
        this.dCu = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.acF == null) {
            return 0;
        }
        return this.acF.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: uA */
    public MetaData getItem(int i) {
        if (this.acF != null && i < this.acF.size()) {
            return this.acF.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0128a c0128a;
        if (this.dCw == null) {
            this.dCw = viewGroup;
        }
        MetaData item = getItem(i);
        if (item != null) {
            c0128a = a(view != null ? view.getTag() : null, item);
        } else {
            c0128a = null;
        }
        if (c0128a != null) {
            return c0128a.rootView;
        }
        return null;
    }

    private C0128a a(Object obj, MetaData metaData) {
        C0128a c0128a;
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (obj == null) {
            c0128a = bzH();
        } else {
            c0128a = (C0128a) obj;
        }
        if (this.gFi != null) {
            this.gFi.a(c0128a.rootView, metaData);
        }
        String portrait = metaData.getPortrait();
        c0128a.bGr.setText(metaData.getName_show());
        c0128a.dCy.setTagData(metaData);
        c0128a.dCe.setTag(portrait);
        if (this.gFj) {
            c0128a.dCy.setVisibility(0);
        } else {
            c0128a.dCy.setVisibility(8);
        }
        c0128a.dCe.c(portrait, 12, false);
        this.gFh.getPageContext().getLayoutMode().ah(skinType == 1);
        this.gFh.getPageContext().getLayoutMode().t(c0128a.rootView);
        return c0128a;
    }

    private C0128a bzH() {
        C0128a c0128a = new C0128a();
        c0128a.rootView = LayoutInflater.from(this.mContext).inflate(d.j.invite_friend_list_item, (ViewGroup) null);
        c0128a.dCe = (HeadImageView) c0128a.rootView.findViewById(d.h.photo);
        c0128a.dCe.setIsRound(false);
        c0128a.bGr = (TextView) c0128a.rootView.findViewById(d.h.txt_user_name);
        c0128a.dCy = (TbCheckBox) c0128a.rootView.findViewById(d.h.ckb_select);
        if (this.dCu != null) {
            c0128a.dCy.setStatedChangedListener(this.dCu);
        }
        c0128a.rootView.setTag(c0128a);
        return c0128a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.write.write.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0128a {
        public TextView bGr;
        public HeadImageView dCe;
        public TbCheckBox dCy;
        public View rootView;

        private C0128a() {
        }
    }
}
