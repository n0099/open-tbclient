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
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    private ArrayList<MetaData> eOt;
    private TbCheckBox.a kGv;
    private final Context mContext;
    private AtListActivity oaV;
    private boolean oaX;
    private b oaW = null;
    private ViewGroup mParent = null;

    /* loaded from: classes3.dex */
    public interface b {
        void a(View view, MetaData metaData);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b bVar) {
        this.oaW = bVar;
    }

    public a(AtListActivity atListActivity, boolean z) {
        this.oaX = true;
        this.oaV = atListActivity;
        this.mContext = this.oaV.getPageContext().getContext();
        this.oaX = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setData(ArrayList<MetaData> arrayList) {
        this.eOt = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(TbCheckBox.a aVar) {
        this.kGv = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eOt == null) {
            return 0;
        }
        return this.eOt.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: MV */
    public MetaData getItem(int i) {
        if (this.eOt != null && i < this.eOt.size()) {
            return this.eOt.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0905a c0905a;
        if (this.mParent == null) {
            this.mParent = viewGroup;
        }
        MetaData item = getItem(i);
        if (item != null) {
            c0905a = a(view != null ? view.getTag() : null, item);
        } else {
            c0905a = null;
        }
        if (c0905a != null) {
            return c0905a.rootView;
        }
        return null;
    }

    private C0905a a(Object obj, MetaData metaData) {
        C0905a c0905a;
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (obj == null) {
            c0905a = eac();
        } else {
            c0905a = (C0905a) obj;
        }
        if (this.oaW != null) {
            this.oaW.a(c0905a.rootView, metaData);
        }
        String avater = metaData.getAvater();
        c0905a.hLB.setText(metaData.getName_show());
        c0905a.kGy.setTagData(metaData);
        c0905a.kGd.setTag(avater);
        if (this.oaX) {
            c0905a.kGy.setVisibility(0);
        } else {
            c0905a.kGy.setVisibility(8);
        }
        c0905a.kGd.startLoad(avater, 12, false);
        this.oaV.getPageContext().getLayoutMode().setNightMode(skinType == 1);
        this.oaV.getPageContext().getLayoutMode().onModeChanged(c0905a.rootView);
        return c0905a;
    }

    private C0905a eac() {
        C0905a c0905a = new C0905a();
        c0905a.rootView = LayoutInflater.from(this.mContext).inflate(R.layout.invite_friend_list_item, (ViewGroup) null);
        c0905a.kGd = (HeadImageView) c0905a.rootView.findViewById(R.id.photo);
        c0905a.kGd.setIsRound(false);
        c0905a.hLB = (TextView) c0905a.rootView.findViewById(R.id.txt_user_name);
        c0905a.kGy = (TbCheckBox) c0905a.rootView.findViewById(R.id.ckb_select);
        c0905a.kGy.setBackgroundDrawableIdIsWebP(true);
        c0905a.kGy.setBackgroundDrawableId(R.drawable.icon_pure_strok324_select, R.drawable.icon_pure_strok324);
        if (this.kGv != null) {
            c0905a.kGy.setStatedChangedListener(this.kGv);
        }
        c0905a.rootView.setTag(c0905a);
        return c0905a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.write.write.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0905a {
        public TextView hLB;
        public HeadImageView kGd;
        public TbCheckBox kGy;
        public View rootView;

        private C0905a() {
        }
    }
}
