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
    private ArrayList<MetaData> eiq;
    private TbCheckBox.a jKY;
    private final Context mContext;
    private AtListActivity ndl;
    private boolean ndn;
    private b ndm = null;
    private ViewGroup mParent = null;

    /* loaded from: classes3.dex */
    public interface b {
        void a(View view, MetaData metaData);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b bVar) {
        this.ndm = bVar;
    }

    public a(AtListActivity atListActivity, boolean z) {
        this.ndn = true;
        this.ndl = atListActivity;
        this.mContext = this.ndl.getPageContext().getContext();
        this.ndn = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setData(ArrayList<MetaData> arrayList) {
        this.eiq = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(TbCheckBox.a aVar) {
        this.jKY = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eiq == null) {
            return 0;
        }
        return this.eiq.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: Kp */
    public MetaData getItem(int i) {
        if (this.eiq != null && i < this.eiq.size()) {
            return this.eiq.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0838a c0838a;
        if (this.mParent == null) {
            this.mParent = viewGroup;
        }
        MetaData item = getItem(i);
        if (item != null) {
            c0838a = a(view != null ? view.getTag() : null, item);
        } else {
            c0838a = null;
        }
        if (c0838a != null) {
            return c0838a.rootView;
        }
        return null;
    }

    private C0838a a(Object obj, MetaData metaData) {
        C0838a c0838a;
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (obj == null) {
            c0838a = dLn();
        } else {
            c0838a = (C0838a) obj;
        }
        if (this.ndm != null) {
            this.ndm.a(c0838a.rootView, metaData);
        }
        String avater = metaData.getAvater();
        c0838a.gVA.setText(metaData.getName_show());
        c0838a.jLb.setTagData(metaData);
        c0838a.jKF.setTag(avater);
        if (this.ndn) {
            c0838a.jLb.setVisibility(0);
        } else {
            c0838a.jLb.setVisibility(8);
        }
        c0838a.jKF.startLoad(avater, 12, false);
        this.ndl.getPageContext().getLayoutMode().setNightMode(skinType == 1);
        this.ndl.getPageContext().getLayoutMode().onModeChanged(c0838a.rootView);
        return c0838a;
    }

    private C0838a dLn() {
        C0838a c0838a = new C0838a();
        c0838a.rootView = LayoutInflater.from(this.mContext).inflate(R.layout.invite_friend_list_item, (ViewGroup) null);
        c0838a.jKF = (HeadImageView) c0838a.rootView.findViewById(R.id.photo);
        c0838a.jKF.setIsRound(false);
        c0838a.gVA = (TextView) c0838a.rootView.findViewById(R.id.txt_user_name);
        c0838a.jLb = (TbCheckBox) c0838a.rootView.findViewById(R.id.ckb_select);
        if (this.jKY != null) {
            c0838a.jLb.setStatedChangedListener(this.jKY);
        }
        c0838a.rootView.setTag(c0838a);
        return c0838a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.write.write.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0838a {
        public TextView gVA;
        public HeadImageView jKF;
        public TbCheckBox jLb;
        public View rootView;

        private C0838a() {
        }
    }
}
