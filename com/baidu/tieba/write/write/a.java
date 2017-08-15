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
    private ArrayList<MetaData> acH;
    private TbCheckBox.a dEr;
    private AtListActivity gGZ;
    private boolean gHb;
    private final Context mContext;
    private b gHa = null;
    private ViewGroup dEt = null;

    /* loaded from: classes.dex */
    public interface b {
        void a(View view, MetaData metaData);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b bVar) {
        this.gHa = bVar;
    }

    public a(AtListActivity atListActivity, boolean z) {
        this.gHb = true;
        this.gGZ = atListActivity;
        this.mContext = this.gGZ.getPageContext().getContext();
        this.gHb = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setData(ArrayList<MetaData> arrayList) {
        this.acH = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(TbCheckBox.a aVar) {
        this.dEr = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.acH == null) {
            return 0;
        }
        return this.acH.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: uJ */
    public MetaData getItem(int i) {
        if (this.acH != null && i < this.acH.size()) {
            return this.acH.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0129a c0129a;
        if (this.dEt == null) {
            this.dEt = viewGroup;
        }
        MetaData item = getItem(i);
        if (item != null) {
            c0129a = a(view != null ? view.getTag() : null, item);
        } else {
            c0129a = null;
        }
        if (c0129a != null) {
            return c0129a.rootView;
        }
        return null;
    }

    private C0129a a(Object obj, MetaData metaData) {
        C0129a c0129a;
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (obj == null) {
            c0129a = bAo();
        } else {
            c0129a = (C0129a) obj;
        }
        if (this.gHa != null) {
            this.gHa.a(c0129a.rootView, metaData);
        }
        String portrait = metaData.getPortrait();
        c0129a.bHa.setText(metaData.getName_show());
        c0129a.dEv.setTagData(metaData);
        c0129a.dEb.setTag(portrait);
        if (this.gHb) {
            c0129a.dEv.setVisibility(0);
        } else {
            c0129a.dEv.setVisibility(8);
        }
        c0129a.dEb.c(portrait, 12, false);
        this.gGZ.getPageContext().getLayoutMode().ah(skinType == 1);
        this.gGZ.getPageContext().getLayoutMode().t(c0129a.rootView);
        return c0129a;
    }

    private C0129a bAo() {
        C0129a c0129a = new C0129a();
        c0129a.rootView = LayoutInflater.from(this.mContext).inflate(d.j.invite_friend_list_item, (ViewGroup) null);
        c0129a.dEb = (HeadImageView) c0129a.rootView.findViewById(d.h.photo);
        c0129a.dEb.setIsRound(false);
        c0129a.bHa = (TextView) c0129a.rootView.findViewById(d.h.txt_user_name);
        c0129a.dEv = (TbCheckBox) c0129a.rootView.findViewById(d.h.ckb_select);
        if (this.dEr != null) {
            c0129a.dEv.setStatedChangedListener(this.dEr);
        }
        c0129a.rootView.setTag(c0129a);
        return c0129a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.write.write.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0129a {
        public TextView bHa;
        public HeadImageView dEb;
        public TbCheckBox dEv;
        public View rootView;

        private C0129a() {
        }
    }
}
