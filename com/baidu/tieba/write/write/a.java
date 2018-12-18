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
    private TbCheckBox.a fcq;
    private AtListActivity hWG;
    private boolean hWI;
    private final Context mContext;
    private ArrayList<MetaData> mData;
    private b hWH = null;
    private ViewGroup mParent = null;

    /* loaded from: classes3.dex */
    public interface b {
        void a(View view, MetaData metaData);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b bVar) {
        this.hWH = bVar;
    }

    public a(AtListActivity atListActivity, boolean z) {
        this.hWI = true;
        this.hWG = atListActivity;
        this.mContext = this.hWG.getPageContext().getContext();
        this.hWI = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setData(ArrayList<MetaData> arrayList) {
        this.mData = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(TbCheckBox.a aVar) {
        this.fcq = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.mData == null) {
            return 0;
        }
        return this.mData.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: xr */
    public MetaData getItem(int i) {
        if (this.mData != null && i < this.mData.size()) {
            return this.mData.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0344a c0344a;
        if (this.mParent == null) {
            this.mParent = viewGroup;
        }
        MetaData item = getItem(i);
        if (item != null) {
            c0344a = a(view != null ? view.getTag() : null, item);
        } else {
            c0344a = null;
        }
        if (c0344a != null) {
            return c0344a.rootView;
        }
        return null;
    }

    private C0344a a(Object obj, MetaData metaData) {
        C0344a c0344a;
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (obj == null) {
            c0344a = bOO();
        } else {
            c0344a = (C0344a) obj;
        }
        if (this.hWH != null) {
            this.hWH.a(c0344a.rootView, metaData);
        }
        String portrait = metaData.getPortrait();
        c0344a.clh.setText(metaData.getName_show());
        c0344a.fct.setTagData(metaData);
        c0344a.fbY.setTag(portrait);
        if (this.hWI) {
            c0344a.fct.setVisibility(0);
        } else {
            c0344a.fct.setVisibility(8);
        }
        c0344a.fbY.startLoad(portrait, 12, false);
        this.hWG.getPageContext().getLayoutMode().setNightMode(skinType == 1);
        this.hWG.getPageContext().getLayoutMode().onModeChanged(c0344a.rootView);
        return c0344a;
    }

    private C0344a bOO() {
        C0344a c0344a = new C0344a();
        c0344a.rootView = LayoutInflater.from(this.mContext).inflate(e.h.invite_friend_list_item, (ViewGroup) null);
        c0344a.fbY = (HeadImageView) c0344a.rootView.findViewById(e.g.photo);
        c0344a.fbY.setIsRound(false);
        c0344a.clh = (TextView) c0344a.rootView.findViewById(e.g.txt_user_name);
        c0344a.fct = (TbCheckBox) c0344a.rootView.findViewById(e.g.ckb_select);
        if (this.fcq != null) {
            c0344a.fct.setStatedChangedListener(this.fcq);
        }
        c0344a.rootView.setTag(c0344a);
        return c0344a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.write.write.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0344a {
        public TextView clh;
        public HeadImageView fbY;
        public TbCheckBox fct;
        public View rootView;

        private C0344a() {
        }
    }
}
