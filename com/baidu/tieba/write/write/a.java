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
    private ArrayList<MetaData> bbZ;
    private TbCheckBox.a gUa;
    private AtListActivity jTs;
    private boolean jTu;
    private final Context mContext;
    private b jTt = null;
    private ViewGroup mParent = null;

    /* loaded from: classes3.dex */
    public interface b {
        void a(View view, MetaData metaData);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b bVar) {
        this.jTt = bVar;
    }

    public a(AtListActivity atListActivity, boolean z) {
        this.jTu = true;
        this.jTs = atListActivity;
        this.mContext = this.jTs.getPageContext().getContext();
        this.jTu = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setData(ArrayList<MetaData> arrayList) {
        this.bbZ = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(TbCheckBox.a aVar) {
        this.gUa = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bbZ == null) {
            return 0;
        }
        return this.bbZ.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: BK */
    public MetaData getItem(int i) {
        if (this.bbZ != null && i < this.bbZ.size()) {
            return this.bbZ.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0547a c0547a;
        if (this.mParent == null) {
            this.mParent = viewGroup;
        }
        MetaData item = getItem(i);
        if (item != null) {
            c0547a = a(view != null ? view.getTag() : null, item);
        } else {
            c0547a = null;
        }
        if (c0547a != null) {
            return c0547a.rootView;
        }
        return null;
    }

    private C0547a a(Object obj, MetaData metaData) {
        C0547a c0547a;
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (obj == null) {
            c0547a = czf();
        } else {
            c0547a = (C0547a) obj;
        }
        if (this.jTt != null) {
            this.jTt.a(c0547a.rootView, metaData);
        }
        String portrait = metaData.getPortrait();
        c0547a.ewr.setText(metaData.getName_show());
        c0547a.gUd.setTagData(metaData);
        c0547a.gTI.setTag(portrait);
        if (this.jTu) {
            c0547a.gUd.setVisibility(0);
        } else {
            c0547a.gUd.setVisibility(8);
        }
        c0547a.gTI.startLoad(portrait, 12, false);
        this.jTs.getPageContext().getLayoutMode().setNightMode(skinType == 1);
        this.jTs.getPageContext().getLayoutMode().onModeChanged(c0547a.rootView);
        return c0547a;
    }

    private C0547a czf() {
        C0547a c0547a = new C0547a();
        c0547a.rootView = LayoutInflater.from(this.mContext).inflate(R.layout.invite_friend_list_item, (ViewGroup) null);
        c0547a.gTI = (HeadImageView) c0547a.rootView.findViewById(R.id.photo);
        c0547a.gTI.setIsRound(false);
        c0547a.ewr = (TextView) c0547a.rootView.findViewById(R.id.txt_user_name);
        c0547a.gUd = (TbCheckBox) c0547a.rootView.findViewById(R.id.ckb_select);
        if (this.gUa != null) {
            c0547a.gUd.setStatedChangedListener(this.gUa);
        }
        c0547a.rootView.setTag(c0547a);
        return c0547a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.write.write.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0547a {
        public TextView ewr;
        public HeadImageView gTI;
        public TbCheckBox gUd;
        public View rootView;

        private C0547a() {
        }
    }
}
