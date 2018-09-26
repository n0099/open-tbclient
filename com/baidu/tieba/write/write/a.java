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
import com.baidu.tieba.e;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    private ArrayList<MetaData> anX;
    private TbCheckBox.a eMA;
    private boolean hGB;
    private AtListActivity hGz;
    private final Context mContext;
    private b hGA = null;
    private ViewGroup mParent = null;

    /* loaded from: classes3.dex */
    public interface b {
        void a(View view, MetaData metaData);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b bVar) {
        this.hGA = bVar;
    }

    public a(AtListActivity atListActivity, boolean z) {
        this.hGB = true;
        this.hGz = atListActivity;
        this.mContext = this.hGz.getPageContext().getContext();
        this.hGB = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setData(ArrayList<MetaData> arrayList) {
        this.anX = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(TbCheckBox.a aVar) {
        this.eMA = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.anX == null) {
            return 0;
        }
        return this.anX.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: we */
    public MetaData getItem(int i) {
        if (this.anX != null && i < this.anX.size()) {
            return this.anX.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0267a c0267a;
        if (this.mParent == null) {
            this.mParent = viewGroup;
        }
        MetaData item = getItem(i);
        if (item != null) {
            c0267a = a(view != null ? view.getTag() : null, item);
        } else {
            c0267a = null;
        }
        if (c0267a != null) {
            return c0267a.rootView;
        }
        return null;
    }

    private C0267a a(Object obj, MetaData metaData) {
        C0267a c0267a;
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (obj == null) {
            c0267a = bJY();
        } else {
            c0267a = (C0267a) obj;
        }
        if (this.hGA != null) {
            this.hGA.a(c0267a.rootView, metaData);
        }
        String portrait = metaData.getPortrait();
        c0267a.bYF.setText(metaData.getName_show());
        c0267a.eMD.setTagData(metaData);
        c0267a.eMi.setTag(portrait);
        if (this.hGB) {
            c0267a.eMD.setVisibility(0);
        } else {
            c0267a.eMD.setVisibility(8);
        }
        c0267a.eMi.startLoad(portrait, 12, false);
        this.hGz.getPageContext().getLayoutMode().setNightMode(skinType == 1);
        this.hGz.getPageContext().getLayoutMode().onModeChanged(c0267a.rootView);
        return c0267a;
    }

    private C0267a bJY() {
        C0267a c0267a = new C0267a();
        c0267a.rootView = LayoutInflater.from(this.mContext).inflate(e.h.invite_friend_list_item, (ViewGroup) null);
        c0267a.eMi = (HeadImageView) c0267a.rootView.findViewById(e.g.photo);
        c0267a.eMi.setIsRound(false);
        c0267a.bYF = (TextView) c0267a.rootView.findViewById(e.g.txt_user_name);
        c0267a.eMD = (TbCheckBox) c0267a.rootView.findViewById(e.g.ckb_select);
        if (this.eMA != null) {
            c0267a.eMD.setStatedChangedListener(this.eMA);
        }
        c0267a.rootView.setTag(c0267a);
        return c0267a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.write.write.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0267a {
        public TextView bYF;
        public TbCheckBox eMD;
        public HeadImageView eMi;
        public View rootView;

        private C0267a() {
        }
    }
}
