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
/* loaded from: classes13.dex */
public class a extends BaseAdapter {
    private ArrayList<MetaData> cVR;
    private TbCheckBox.a hMP;
    private AtListActivity kRC;
    private boolean kRE;
    private final Context mContext;
    private b kRD = null;
    private ViewGroup mParent = null;

    /* loaded from: classes13.dex */
    public interface b {
        void a(View view, MetaData metaData);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b bVar) {
        this.kRD = bVar;
    }

    public a(AtListActivity atListActivity, boolean z) {
        this.kRE = true;
        this.kRC = atListActivity;
        this.mContext = this.kRC.getPageContext().getContext();
        this.kRE = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setData(ArrayList<MetaData> arrayList) {
        this.cVR = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(TbCheckBox.a aVar) {
        this.hMP = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.cVR == null) {
            return 0;
        }
        return this.cVR.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: Eq */
    public MetaData getItem(int i) {
        if (this.cVR != null && i < this.cVR.size()) {
            return this.cVR.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0640a c0640a;
        if (this.mParent == null) {
            this.mParent = viewGroup;
        }
        MetaData item = getItem(i);
        if (item != null) {
            c0640a = a(view != null ? view.getTag() : null, item);
        } else {
            c0640a = null;
        }
        if (c0640a != null) {
            return c0640a.rootView;
        }
        return null;
    }

    private C0640a a(Object obj, MetaData metaData) {
        C0640a c0640a;
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (obj == null) {
            c0640a = cVy();
        } else {
            c0640a = (C0640a) obj;
        }
        if (this.kRD != null) {
            this.kRD.a(c0640a.rootView, metaData);
        }
        String avater = metaData.getAvater();
        c0640a.fsM.setText(metaData.getName_show());
        c0640a.hMS.setTagData(metaData);
        c0640a.hMx.setTag(avater);
        if (this.kRE) {
            c0640a.hMS.setVisibility(0);
        } else {
            c0640a.hMS.setVisibility(8);
        }
        c0640a.hMx.startLoad(avater, 12, false);
        this.kRC.getPageContext().getLayoutMode().setNightMode(skinType == 1);
        this.kRC.getPageContext().getLayoutMode().onModeChanged(c0640a.rootView);
        return c0640a;
    }

    private C0640a cVy() {
        C0640a c0640a = new C0640a();
        c0640a.rootView = LayoutInflater.from(this.mContext).inflate(R.layout.invite_friend_list_item, (ViewGroup) null);
        c0640a.hMx = (HeadImageView) c0640a.rootView.findViewById(R.id.photo);
        c0640a.hMx.setIsRound(false);
        c0640a.fsM = (TextView) c0640a.rootView.findViewById(R.id.txt_user_name);
        c0640a.hMS = (TbCheckBox) c0640a.rootView.findViewById(R.id.ckb_select);
        if (this.hMP != null) {
            c0640a.hMS.setStatedChangedListener(this.hMP);
        }
        c0640a.rootView.setTag(c0640a);
        return c0640a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.write.write.a$a  reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public class C0640a {
        public TextView fsM;
        public TbCheckBox hMS;
        public HeadImageView hMx;
        public View rootView;

        private C0640a() {
        }
    }
}
