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
/* loaded from: classes7.dex */
public class a extends BaseAdapter {
    private ArrayList<MetaData> eXu;
    private TbCheckBox.a kRv;
    private final Context mContext;
    private AtListActivity olo;
    private boolean olq;
    private b olp = null;
    private ViewGroup mParent = null;

    /* loaded from: classes7.dex */
    public interface b {
        void a(View view, MetaData metaData);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b bVar) {
        this.olp = bVar;
    }

    public a(AtListActivity atListActivity, boolean z) {
        this.olq = true;
        this.olo = atListActivity;
        this.mContext = this.olo.getPageContext().getContext();
        this.olq = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setData(ArrayList<MetaData> arrayList) {
        this.eXu = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(TbCheckBox.a aVar) {
        this.kRv = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eXu == null) {
            return 0;
        }
        return this.eXu.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: LA */
    public MetaData getItem(int i) {
        if (this.eXu != null && i < this.eXu.size()) {
            return this.eXu.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0912a c0912a;
        if (this.mParent == null) {
            this.mParent = viewGroup;
        }
        MetaData item = getItem(i);
        if (item != null) {
            c0912a = a(view != null ? view.getTag() : null, item);
        } else {
            c0912a = null;
        }
        if (c0912a != null) {
            return c0912a.rootView;
        }
        return null;
    }

    private C0912a a(Object obj, MetaData metaData) {
        C0912a c0912a;
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (obj == null) {
            c0912a = dXZ();
        } else {
            c0912a = (C0912a) obj;
        }
        if (this.olp != null) {
            this.olp.a(c0912a.rootView, metaData);
        }
        String avater = metaData.getAvater();
        c0912a.hZP.setText(metaData.getName_show());
        c0912a.kRy.setTagData(metaData);
        c0912a.kRd.setTag(avater);
        if (this.olq) {
            c0912a.kRy.setVisibility(0);
        } else {
            c0912a.kRy.setVisibility(8);
        }
        c0912a.kRd.startLoad(avater, 12, false);
        this.olo.getPageContext().getLayoutMode().setNightMode(skinType == 1);
        this.olo.getPageContext().getLayoutMode().onModeChanged(c0912a.rootView);
        return c0912a;
    }

    private C0912a dXZ() {
        C0912a c0912a = new C0912a();
        c0912a.rootView = LayoutInflater.from(this.mContext).inflate(R.layout.invite_friend_list_item, (ViewGroup) null);
        c0912a.kRd = (HeadImageView) c0912a.rootView.findViewById(R.id.photo);
        c0912a.kRd.setIsRound(false);
        c0912a.hZP = (TextView) c0912a.rootView.findViewById(R.id.txt_user_name);
        c0912a.kRy = (TbCheckBox) c0912a.rootView.findViewById(R.id.ckb_select);
        c0912a.kRy.setBackgroundDrawableIdIsWebP(true);
        c0912a.kRy.setBackgroundDrawableId(R.drawable.icon_pure_strok324_select, R.drawable.icon_pure_strok324);
        if (this.kRv != null) {
            c0912a.kRy.setStatedChangedListener(this.kRv);
        }
        c0912a.rootView.setTag(c0912a);
        return c0912a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.write.write.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0912a {
        public TextView hZP;
        public HeadImageView kRd;
        public TbCheckBox kRy;
        public View rootView;

        private C0912a() {
        }
    }
}
