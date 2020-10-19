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
    private ArrayList<MetaData> euy;
    private TbCheckBox.a jZV;
    private final Context mContext;
    private AtListActivity nsK;
    private boolean nsM;
    private b nsL = null;
    private ViewGroup mParent = null;

    /* loaded from: classes3.dex */
    public interface b {
        void a(View view, MetaData metaData);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b bVar) {
        this.nsL = bVar;
    }

    public a(AtListActivity atListActivity, boolean z) {
        this.nsM = true;
        this.nsK = atListActivity;
        this.mContext = this.nsK.getPageContext().getContext();
        this.nsM = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setData(ArrayList<MetaData> arrayList) {
        this.euy = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(TbCheckBox.a aVar) {
        this.jZV = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.euy == null) {
            return 0;
        }
        return this.euy.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: KV */
    public MetaData getItem(int i) {
        if (this.euy != null && i < this.euy.size()) {
            return this.euy.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0856a c0856a;
        if (this.mParent == null) {
            this.mParent = viewGroup;
        }
        MetaData item = getItem(i);
        if (item != null) {
            c0856a = a(view != null ? view.getTag() : null, item);
        } else {
            c0856a = null;
        }
        if (c0856a != null) {
            return c0856a.rootView;
        }
        return null;
    }

    private C0856a a(Object obj, MetaData metaData) {
        C0856a c0856a;
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (obj == null) {
            c0856a = dOZ();
        } else {
            c0856a = (C0856a) obj;
        }
        if (this.nsL != null) {
            this.nsL.a(c0856a.rootView, metaData);
        }
        String avater = metaData.getAvater();
        c0856a.hkx.setText(metaData.getName_show());
        c0856a.jZY.setTagData(metaData);
        c0856a.jZC.setTag(avater);
        if (this.nsM) {
            c0856a.jZY.setVisibility(0);
        } else {
            c0856a.jZY.setVisibility(8);
        }
        c0856a.jZC.startLoad(avater, 12, false);
        this.nsK.getPageContext().getLayoutMode().setNightMode(skinType == 1);
        this.nsK.getPageContext().getLayoutMode().onModeChanged(c0856a.rootView);
        return c0856a;
    }

    private C0856a dOZ() {
        C0856a c0856a = new C0856a();
        c0856a.rootView = LayoutInflater.from(this.mContext).inflate(R.layout.invite_friend_list_item, (ViewGroup) null);
        c0856a.jZC = (HeadImageView) c0856a.rootView.findViewById(R.id.photo);
        c0856a.jZC.setIsRound(false);
        c0856a.hkx = (TextView) c0856a.rootView.findViewById(R.id.txt_user_name);
        c0856a.jZY = (TbCheckBox) c0856a.rootView.findViewById(R.id.ckb_select);
        if (this.jZV != null) {
            c0856a.jZY.setStatedChangedListener(this.jZV);
        }
        c0856a.rootView.setTag(c0856a);
        return c0856a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.write.write.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0856a {
        public TextView hkx;
        public HeadImageView jZC;
        public TbCheckBox jZY;
        public View rootView;

        private C0856a() {
        }
    }
}
