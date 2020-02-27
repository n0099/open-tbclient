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
    private ArrayList<MetaData> cVQ;
    private TbCheckBox.a hMN;
    private AtListActivity kRA;
    private boolean kRC;
    private final Context mContext;
    private b kRB = null;
    private ViewGroup mParent = null;

    /* loaded from: classes13.dex */
    public interface b {
        void a(View view, MetaData metaData);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b bVar) {
        this.kRB = bVar;
    }

    public a(AtListActivity atListActivity, boolean z) {
        this.kRC = true;
        this.kRA = atListActivity;
        this.mContext = this.kRA.getPageContext().getContext();
        this.kRC = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setData(ArrayList<MetaData> arrayList) {
        this.cVQ = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(TbCheckBox.a aVar) {
        this.hMN = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.cVQ == null) {
            return 0;
        }
        return this.cVQ.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: Eq */
    public MetaData getItem(int i) {
        if (this.cVQ != null && i < this.cVQ.size()) {
            return this.cVQ.get(i);
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
            c0640a = cVw();
        } else {
            c0640a = (C0640a) obj;
        }
        if (this.kRB != null) {
            this.kRB.a(c0640a.rootView, metaData);
        }
        String avater = metaData.getAvater();
        c0640a.fsL.setText(metaData.getName_show());
        c0640a.hMQ.setTagData(metaData);
        c0640a.hMv.setTag(avater);
        if (this.kRC) {
            c0640a.hMQ.setVisibility(0);
        } else {
            c0640a.hMQ.setVisibility(8);
        }
        c0640a.hMv.startLoad(avater, 12, false);
        this.kRA.getPageContext().getLayoutMode().setNightMode(skinType == 1);
        this.kRA.getPageContext().getLayoutMode().onModeChanged(c0640a.rootView);
        return c0640a;
    }

    private C0640a cVw() {
        C0640a c0640a = new C0640a();
        c0640a.rootView = LayoutInflater.from(this.mContext).inflate(R.layout.invite_friend_list_item, (ViewGroup) null);
        c0640a.hMv = (HeadImageView) c0640a.rootView.findViewById(R.id.photo);
        c0640a.hMv.setIsRound(false);
        c0640a.fsL = (TextView) c0640a.rootView.findViewById(R.id.txt_user_name);
        c0640a.hMQ = (TbCheckBox) c0640a.rootView.findViewById(R.id.ckb_select);
        if (this.hMN != null) {
            c0640a.hMQ.setStatedChangedListener(this.hMN);
        }
        c0640a.rootView.setTag(c0640a);
        return c0640a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.write.write.a$a  reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public class C0640a {
        public TextView fsL;
        public TbCheckBox hMQ;
        public HeadImageView hMv;
        public View rootView;

        private C0640a() {
        }
    }
}
