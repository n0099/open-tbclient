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
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class a extends BaseAdapter {
    private ArrayList<MetaData> dvq;
    private TbCheckBox.a iys;
    private AtListActivity lDr;
    private boolean lDt;
    private final Context mContext;
    private b lDs = null;
    private ViewGroup mParent = null;

    /* loaded from: classes2.dex */
    public interface b {
        void a(View view, MetaData metaData);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b bVar) {
        this.lDs = bVar;
    }

    public a(AtListActivity atListActivity, boolean z) {
        this.lDt = true;
        this.lDr = atListActivity;
        this.mContext = this.lDr.getPageContext().getContext();
        this.lDt = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setData(ArrayList<MetaData> arrayList) {
        this.dvq = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(TbCheckBox.a aVar) {
        this.iys = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.dvq == null) {
            return 0;
        }
        return this.dvq.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: EY */
    public MetaData getItem(int i) {
        if (this.dvq != null && i < this.dvq.size()) {
            return this.dvq.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0686a c0686a;
        if (this.mParent == null) {
            this.mParent = viewGroup;
        }
        MetaData item = getItem(i);
        if (item != null) {
            c0686a = a(view != null ? view.getTag() : null, item);
        } else {
            c0686a = null;
        }
        if (c0686a != null) {
            return c0686a.rootView;
        }
        return null;
    }

    private C0686a a(Object obj, MetaData metaData) {
        C0686a c0686a;
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (obj == null) {
            c0686a = dgE();
        } else {
            c0686a = (C0686a) obj;
        }
        if (this.lDs != null) {
            this.lDs.a(c0686a.rootView, metaData);
        }
        String avater = metaData.getAvater();
        c0686a.fXT.setText(metaData.getName_show());
        c0686a.iyv.setTagData(metaData);
        c0686a.iya.setTag(avater);
        if (this.lDt) {
            c0686a.iyv.setVisibility(0);
        } else {
            c0686a.iyv.setVisibility(8);
        }
        c0686a.iya.startLoad(avater, 12, false);
        this.lDr.getPageContext().getLayoutMode().setNightMode(skinType == 1);
        this.lDr.getPageContext().getLayoutMode().onModeChanged(c0686a.rootView);
        return c0686a;
    }

    private C0686a dgE() {
        C0686a c0686a = new C0686a();
        c0686a.rootView = LayoutInflater.from(this.mContext).inflate(R.layout.invite_friend_list_item, (ViewGroup) null);
        c0686a.iya = (HeadImageView) c0686a.rootView.findViewById(R.id.photo);
        c0686a.iya.setIsRound(false);
        c0686a.fXT = (TextView) c0686a.rootView.findViewById(R.id.txt_user_name);
        c0686a.iyv = (TbCheckBox) c0686a.rootView.findViewById(R.id.ckb_select);
        if (this.iys != null) {
            c0686a.iyv.setStatedChangedListener(this.iys);
        }
        c0686a.rootView.setTag(c0686a);
        return c0686a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.write.write.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0686a {
        public TextView fXT;
        public HeadImageView iya;
        public TbCheckBox iyv;
        public View rootView;

        private C0686a() {
        }
    }
}
