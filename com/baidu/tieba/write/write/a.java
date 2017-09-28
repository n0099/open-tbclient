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
    private ArrayList<MetaData> abP;
    private TbCheckBox.a dIg;
    private AtListActivity gLt;
    private boolean gLv;
    private final Context mContext;
    private b gLu = null;
    private ViewGroup bqn = null;

    /* loaded from: classes2.dex */
    public interface b {
        void a(View view, MetaData metaData);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b bVar) {
        this.gLu = bVar;
    }

    public a(AtListActivity atListActivity, boolean z) {
        this.gLv = true;
        this.gLt = atListActivity;
        this.mContext = this.gLt.getPageContext().getContext();
        this.gLv = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setData(ArrayList<MetaData> arrayList) {
        this.abP = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(TbCheckBox.a aVar) {
        this.dIg = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.abP == null) {
            return 0;
        }
        return this.abP.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: vj */
    public MetaData getItem(int i) {
        if (this.abP != null && i < this.abP.size()) {
            return this.abP.get(i);
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
        if (this.bqn == null) {
            this.bqn = viewGroup;
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
            c0143a = bAV();
        } else {
            c0143a = (C0143a) obj;
        }
        if (this.gLu != null) {
            this.gLu.a(c0143a.rootView, metaData);
        }
        String portrait = metaData.getPortrait();
        c0143a.bHn.setText(metaData.getName_show());
        c0143a.dIj.setTagData(metaData);
        c0143a.dHP.setTag(portrait);
        if (this.gLv) {
            c0143a.dIj.setVisibility(0);
        } else {
            c0143a.dIj.setVisibility(8);
        }
        c0143a.dHP.c(portrait, 12, false);
        this.gLt.getPageContext().getLayoutMode().ai(skinType == 1);
        this.gLt.getPageContext().getLayoutMode().t(c0143a.rootView);
        return c0143a;
    }

    private C0143a bAV() {
        C0143a c0143a = new C0143a();
        c0143a.rootView = LayoutInflater.from(this.mContext).inflate(d.j.invite_friend_list_item, (ViewGroup) null);
        c0143a.dHP = (HeadImageView) c0143a.rootView.findViewById(d.h.photo);
        c0143a.dHP.setIsRound(false);
        c0143a.bHn = (TextView) c0143a.rootView.findViewById(d.h.txt_user_name);
        c0143a.dIj = (TbCheckBox) c0143a.rootView.findViewById(d.h.ckb_select);
        if (this.dIg != null) {
            c0143a.dIj.setStatedChangedListener(this.dIg);
        }
        c0143a.rootView.setTag(c0143a);
        return c0143a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.write.write.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0143a {
        public TextView bHn;
        public HeadImageView dHP;
        public TbCheckBox dIj;
        public View rootView;

        private C0143a() {
        }
    }
}
