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
    private ArrayList<MetaData> efX;
    private TbCheckBox.a jCq;
    private final Context mContext;
    private AtListActivity mSY;
    private boolean mTa;
    private b mSZ = null;
    private ViewGroup mParent = null;

    /* loaded from: classes3.dex */
    public interface b {
        void a(View view, MetaData metaData);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b bVar) {
        this.mSZ = bVar;
    }

    public a(AtListActivity atListActivity, boolean z) {
        this.mTa = true;
        this.mSY = atListActivity;
        this.mContext = this.mSY.getPageContext().getContext();
        this.mTa = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setData(ArrayList<MetaData> arrayList) {
        this.efX = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(TbCheckBox.a aVar) {
        this.jCq = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.efX == null) {
            return 0;
        }
        return this.efX.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: JK */
    public MetaData getItem(int i) {
        if (this.efX != null && i < this.efX.size()) {
            return this.efX.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0841a c0841a;
        if (this.mParent == null) {
            this.mParent = viewGroup;
        }
        MetaData item = getItem(i);
        if (item != null) {
            c0841a = a(view != null ? view.getTag() : null, item);
        } else {
            c0841a = null;
        }
        if (c0841a != null) {
            return c0841a.rootView;
        }
        return null;
    }

    private C0841a a(Object obj, MetaData metaData) {
        C0841a c0841a;
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (obj == null) {
            c0841a = dHj();
        } else {
            c0841a = (C0841a) obj;
        }
        if (this.mSZ != null) {
            this.mSZ.a(c0841a.rootView, metaData);
        }
        String avater = metaData.getAvater();
        c0841a.gRO.setText(metaData.getName_show());
        c0841a.jCt.setTagData(metaData);
        c0841a.jBX.setTag(avater);
        if (this.mTa) {
            c0841a.jCt.setVisibility(0);
        } else {
            c0841a.jCt.setVisibility(8);
        }
        c0841a.jBX.startLoad(avater, 12, false);
        this.mSY.getPageContext().getLayoutMode().setNightMode(skinType == 1);
        this.mSY.getPageContext().getLayoutMode().onModeChanged(c0841a.rootView);
        return c0841a;
    }

    private C0841a dHj() {
        C0841a c0841a = new C0841a();
        c0841a.rootView = LayoutInflater.from(this.mContext).inflate(R.layout.invite_friend_list_item, (ViewGroup) null);
        c0841a.jBX = (HeadImageView) c0841a.rootView.findViewById(R.id.photo);
        c0841a.jBX.setIsRound(false);
        c0841a.gRO = (TextView) c0841a.rootView.findViewById(R.id.txt_user_name);
        c0841a.jCt = (TbCheckBox) c0841a.rootView.findViewById(R.id.ckb_select);
        if (this.jCq != null) {
            c0841a.jCt.setStatedChangedListener(this.jCq);
        }
        c0841a.rootView.setTag(c0841a);
        return c0841a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.write.write.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0841a {
        public TextView gRO;
        public HeadImageView jBX;
        public TbCheckBox jCt;
        public View rootView;

        private C0841a() {
        }
    }
}
