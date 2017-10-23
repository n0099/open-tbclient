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
    private ArrayList<MetaData> abD;
    private TbCheckBox.a dHS;
    private AtListActivity gLd;
    private boolean gLf;
    private final Context mContext;
    private b gLe = null;
    private ViewGroup bqb = null;

    /* loaded from: classes2.dex */
    public interface b {
        void a(View view, MetaData metaData);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b bVar) {
        this.gLe = bVar;
    }

    public a(AtListActivity atListActivity, boolean z) {
        this.gLf = true;
        this.gLd = atListActivity;
        this.mContext = this.gLd.getPageContext().getContext();
        this.gLf = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setData(ArrayList<MetaData> arrayList) {
        this.abD = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(TbCheckBox.a aVar) {
        this.dHS = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.abD == null) {
            return 0;
        }
        return this.abD.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: vi */
    public MetaData getItem(int i) {
        if (this.abD != null && i < this.abD.size()) {
            return this.abD.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0143a c0143a;
        if (this.bqb == null) {
            this.bqb = viewGroup;
        }
        MetaData item = getItem(i);
        if (item != null) {
            c0143a = a(view != null ? view.getTag() : null, item);
        } else {
            c0143a = null;
        }
        if (c0143a != null) {
            return c0143a.rootView;
        }
        return null;
    }

    private C0143a a(Object obj, MetaData metaData) {
        C0143a c0143a;
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (obj == null) {
            c0143a = bAO();
        } else {
            c0143a = (C0143a) obj;
        }
        if (this.gLe != null) {
            this.gLe.a(c0143a.rootView, metaData);
        }
        String portrait = metaData.getPortrait();
        c0143a.bHb.setText(metaData.getName_show());
        c0143a.dHV.setTagData(metaData);
        c0143a.dHB.setTag(portrait);
        if (this.gLf) {
            c0143a.dHV.setVisibility(0);
        } else {
            c0143a.dHV.setVisibility(8);
        }
        c0143a.dHB.c(portrait, 12, false);
        this.gLd.getPageContext().getLayoutMode().ah(skinType == 1);
        this.gLd.getPageContext().getLayoutMode().t(c0143a.rootView);
        return c0143a;
    }

    private C0143a bAO() {
        C0143a c0143a = new C0143a();
        c0143a.rootView = LayoutInflater.from(this.mContext).inflate(d.j.invite_friend_list_item, (ViewGroup) null);
        c0143a.dHB = (HeadImageView) c0143a.rootView.findViewById(d.h.photo);
        c0143a.dHB.setIsRound(false);
        c0143a.bHb = (TextView) c0143a.rootView.findViewById(d.h.txt_user_name);
        c0143a.dHV = (TbCheckBox) c0143a.rootView.findViewById(d.h.ckb_select);
        if (this.dHS != null) {
            c0143a.dHV.setStatedChangedListener(this.dHS);
        }
        c0143a.rootView.setTag(c0143a);
        return c0143a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.write.write.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0143a {
        public TextView bHb;
        public HeadImageView dHB;
        public TbCheckBox dHV;
        public View rootView;

        private C0143a() {
        }
    }
}
