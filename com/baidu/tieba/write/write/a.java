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
    private ArrayList<MetaData> egb;
    private TbCheckBox.a jCw;
    private final Context mContext;
    private AtListActivity mTs;
    private boolean mTu;
    private b mTt = null;
    private ViewGroup mParent = null;

    /* loaded from: classes3.dex */
    public interface b {
        void a(View view, MetaData metaData);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b bVar) {
        this.mTt = bVar;
    }

    public a(AtListActivity atListActivity, boolean z) {
        this.mTu = true;
        this.mTs = atListActivity;
        this.mContext = this.mTs.getPageContext().getContext();
        this.mTu = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setData(ArrayList<MetaData> arrayList) {
        this.egb = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(TbCheckBox.a aVar) {
        this.jCw = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.egb == null) {
            return 0;
        }
        return this.egb.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: JK */
    public MetaData getItem(int i) {
        if (this.egb != null && i < this.egb.size()) {
            return this.egb.get(i);
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
            c0841a = dHs();
        } else {
            c0841a = (C0841a) obj;
        }
        if (this.mTt != null) {
            this.mTt.a(c0841a.rootView, metaData);
        }
        String avater = metaData.getAvater();
        c0841a.gRS.setText(metaData.getName_show());
        c0841a.jCz.setTagData(metaData);
        c0841a.jCd.setTag(avater);
        if (this.mTu) {
            c0841a.jCz.setVisibility(0);
        } else {
            c0841a.jCz.setVisibility(8);
        }
        c0841a.jCd.startLoad(avater, 12, false);
        this.mTs.getPageContext().getLayoutMode().setNightMode(skinType == 1);
        this.mTs.getPageContext().getLayoutMode().onModeChanged(c0841a.rootView);
        return c0841a;
    }

    private C0841a dHs() {
        C0841a c0841a = new C0841a();
        c0841a.rootView = LayoutInflater.from(this.mContext).inflate(R.layout.invite_friend_list_item, (ViewGroup) null);
        c0841a.jCd = (HeadImageView) c0841a.rootView.findViewById(R.id.photo);
        c0841a.jCd.setIsRound(false);
        c0841a.gRS = (TextView) c0841a.rootView.findViewById(R.id.txt_user_name);
        c0841a.jCz = (TbCheckBox) c0841a.rootView.findViewById(R.id.ckb_select);
        if (this.jCw != null) {
            c0841a.jCz.setStatedChangedListener(this.jCw);
        }
        c0841a.rootView.setTag(c0841a);
        return c0841a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.write.write.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0841a {
        public TextView gRS;
        public HeadImageView jCd;
        public TbCheckBox jCz;
        public View rootView;

        private C0841a() {
        }
    }
}
