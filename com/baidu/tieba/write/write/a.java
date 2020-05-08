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
    private ArrayList<MetaData> dvu;
    private TbCheckBox.a iyy;
    private AtListActivity lDv;
    private boolean lDx;
    private final Context mContext;
    private b lDw = null;
    private ViewGroup mParent = null;

    /* loaded from: classes2.dex */
    public interface b {
        void a(View view, MetaData metaData);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b bVar) {
        this.lDw = bVar;
    }

    public a(AtListActivity atListActivity, boolean z) {
        this.lDx = true;
        this.lDv = atListActivity;
        this.mContext = this.lDv.getPageContext().getContext();
        this.lDx = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setData(ArrayList<MetaData> arrayList) {
        this.dvu = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(TbCheckBox.a aVar) {
        this.iyy = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.dvu == null) {
            return 0;
        }
        return this.dvu.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: EY */
    public MetaData getItem(int i) {
        if (this.dvu != null && i < this.dvu.size()) {
            return this.dvu.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0707a c0707a;
        if (this.mParent == null) {
            this.mParent = viewGroup;
        }
        MetaData item = getItem(i);
        if (item != null) {
            c0707a = a(view != null ? view.getTag() : null, item);
        } else {
            c0707a = null;
        }
        if (c0707a != null) {
            return c0707a.rootView;
        }
        return null;
    }

    private C0707a a(Object obj, MetaData metaData) {
        C0707a c0707a;
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (obj == null) {
            c0707a = dgB();
        } else {
            c0707a = (C0707a) obj;
        }
        if (this.lDw != null) {
            this.lDw.a(c0707a.rootView, metaData);
        }
        String avater = metaData.getAvater();
        c0707a.fXY.setText(metaData.getName_show());
        c0707a.iyB.setTagData(metaData);
        c0707a.iyg.setTag(avater);
        if (this.lDx) {
            c0707a.iyB.setVisibility(0);
        } else {
            c0707a.iyB.setVisibility(8);
        }
        c0707a.iyg.startLoad(avater, 12, false);
        this.lDv.getPageContext().getLayoutMode().setNightMode(skinType == 1);
        this.lDv.getPageContext().getLayoutMode().onModeChanged(c0707a.rootView);
        return c0707a;
    }

    private C0707a dgB() {
        C0707a c0707a = new C0707a();
        c0707a.rootView = LayoutInflater.from(this.mContext).inflate(R.layout.invite_friend_list_item, (ViewGroup) null);
        c0707a.iyg = (HeadImageView) c0707a.rootView.findViewById(R.id.photo);
        c0707a.iyg.setIsRound(false);
        c0707a.fXY = (TextView) c0707a.rootView.findViewById(R.id.txt_user_name);
        c0707a.iyB = (TbCheckBox) c0707a.rootView.findViewById(R.id.ckb_select);
        if (this.iyy != null) {
            c0707a.iyB.setStatedChangedListener(this.iyy);
        }
        c0707a.rootView.setTag(c0707a);
        return c0707a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.write.write.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0707a {
        public TextView fXY;
        public TbCheckBox iyB;
        public HeadImageView iyg;
        public View rootView;

        private C0707a() {
        }
    }
}
