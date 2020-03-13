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
    private ArrayList<MetaData> cVS;
    private TbCheckBox.a hNb;
    private AtListActivity kRO;
    private boolean kRQ;
    private final Context mContext;
    private b kRP = null;
    private ViewGroup mParent = null;

    /* loaded from: classes13.dex */
    public interface b {
        void a(View view, MetaData metaData);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b bVar) {
        this.kRP = bVar;
    }

    public a(AtListActivity atListActivity, boolean z) {
        this.kRQ = true;
        this.kRO = atListActivity;
        this.mContext = this.kRO.getPageContext().getContext();
        this.kRQ = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setData(ArrayList<MetaData> arrayList) {
        this.cVS = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(TbCheckBox.a aVar) {
        this.hNb = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.cVS == null) {
            return 0;
        }
        return this.cVS.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: Eq */
    public MetaData getItem(int i) {
        if (this.cVS != null && i < this.cVS.size()) {
            return this.cVS.get(i);
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
            c0640a = cVz();
        } else {
            c0640a = (C0640a) obj;
        }
        if (this.kRP != null) {
            this.kRP.a(c0640a.rootView, metaData);
        }
        String avater = metaData.getAvater();
        c0640a.fsZ.setText(metaData.getName_show());
        c0640a.hNe.setTagData(metaData);
        c0640a.hMJ.setTag(avater);
        if (this.kRQ) {
            c0640a.hNe.setVisibility(0);
        } else {
            c0640a.hNe.setVisibility(8);
        }
        c0640a.hMJ.startLoad(avater, 12, false);
        this.kRO.getPageContext().getLayoutMode().setNightMode(skinType == 1);
        this.kRO.getPageContext().getLayoutMode().onModeChanged(c0640a.rootView);
        return c0640a;
    }

    private C0640a cVz() {
        C0640a c0640a = new C0640a();
        c0640a.rootView = LayoutInflater.from(this.mContext).inflate(R.layout.invite_friend_list_item, (ViewGroup) null);
        c0640a.hMJ = (HeadImageView) c0640a.rootView.findViewById(R.id.photo);
        c0640a.hMJ.setIsRound(false);
        c0640a.fsZ = (TextView) c0640a.rootView.findViewById(R.id.txt_user_name);
        c0640a.hNe = (TbCheckBox) c0640a.rootView.findViewById(R.id.ckb_select);
        if (this.hNb != null) {
            c0640a.hNe.setStatedChangedListener(this.hNb);
        }
        c0640a.rootView.setTag(c0640a);
        return c0640a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.write.write.a$a  reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public class C0640a {
        public TextView fsZ;
        public HeadImageView hMJ;
        public TbCheckBox hNe;
        public View rootView;

        private C0640a() {
        }
    }
}
