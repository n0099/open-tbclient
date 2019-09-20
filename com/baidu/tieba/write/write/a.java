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
    private ArrayList<MetaData> aIL;
    private TbCheckBox.a gWa;
    private AtListActivity jVt;
    private boolean jVv;
    private final Context mContext;
    private b jVu = null;
    private ViewGroup mParent = null;

    /* loaded from: classes3.dex */
    public interface b {
        void a(View view, MetaData metaData);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b bVar) {
        this.jVu = bVar;
    }

    public a(AtListActivity atListActivity, boolean z) {
        this.jVv = true;
        this.jVt = atListActivity;
        this.mContext = this.jVt.getPageContext().getContext();
        this.jVv = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setData(ArrayList<MetaData> arrayList) {
        this.aIL = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(TbCheckBox.a aVar) {
        this.gWa = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aIL == null) {
            return 0;
        }
        return this.aIL.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: Do */
    public MetaData getItem(int i) {
        if (this.aIL != null && i < this.aIL.size()) {
            return this.aIL.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0452a c0452a;
        if (this.mParent == null) {
            this.mParent = viewGroup;
        }
        MetaData item = getItem(i);
        if (item != null) {
            c0452a = a(view != null ? view.getTag() : null, item);
        } else {
            c0452a = null;
        }
        if (c0452a != null) {
            return c0452a.rootView;
        }
        return null;
    }

    private C0452a a(Object obj, MetaData metaData) {
        C0452a c0452a;
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (obj == null) {
            c0452a = cCv();
        } else {
            c0452a = (C0452a) obj;
        }
        if (this.jVu != null) {
            this.jVu.a(c0452a.rootView, metaData);
        }
        String portrait = metaData.getPortrait();
        c0452a.evT.setText(metaData.getName_show());
        c0452a.gWd.setTagData(metaData);
        c0452a.gVI.setTag(portrait);
        if (this.jVv) {
            c0452a.gWd.setVisibility(0);
        } else {
            c0452a.gWd.setVisibility(8);
        }
        c0452a.gVI.startLoad(portrait, 12, false);
        this.jVt.getPageContext().getLayoutMode().setNightMode(skinType == 1);
        this.jVt.getPageContext().getLayoutMode().onModeChanged(c0452a.rootView);
        return c0452a;
    }

    private C0452a cCv() {
        C0452a c0452a = new C0452a();
        c0452a.rootView = LayoutInflater.from(this.mContext).inflate(R.layout.invite_friend_list_item, (ViewGroup) null);
        c0452a.gVI = (HeadImageView) c0452a.rootView.findViewById(R.id.photo);
        c0452a.gVI.setIsRound(false);
        c0452a.evT = (TextView) c0452a.rootView.findViewById(R.id.txt_user_name);
        c0452a.gWd = (TbCheckBox) c0452a.rootView.findViewById(R.id.ckb_select);
        if (this.gWa != null) {
            c0452a.gWd.setStatedChangedListener(this.gWa);
        }
        c0452a.rootView.setTag(c0452a);
        return c0452a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.write.write.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0452a {
        public TextView evT;
        public HeadImageView gVI;
        public TbCheckBox gWd;
        public View rootView;

        private C0452a() {
        }
    }
}
