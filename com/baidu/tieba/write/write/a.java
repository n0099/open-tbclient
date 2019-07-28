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
    private ArrayList<MetaData> aIn;
    private TbCheckBox.a gTp;
    private AtListActivity jRQ;
    private boolean jRS;
    private final Context mContext;
    private b jRR = null;
    private ViewGroup mParent = null;

    /* loaded from: classes3.dex */
    public interface b {
        void a(View view, MetaData metaData);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b bVar) {
        this.jRR = bVar;
    }

    public a(AtListActivity atListActivity, boolean z) {
        this.jRS = true;
        this.jRQ = atListActivity;
        this.mContext = this.jRQ.getPageContext().getContext();
        this.jRS = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setData(ArrayList<MetaData> arrayList) {
        this.aIn = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(TbCheckBox.a aVar) {
        this.gTp = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aIn == null) {
            return 0;
        }
        return this.aIn.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: Di */
    public MetaData getItem(int i) {
        if (this.aIn != null && i < this.aIn.size()) {
            return this.aIn.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0441a c0441a;
        if (this.mParent == null) {
            this.mParent = viewGroup;
        }
        MetaData item = getItem(i);
        if (item != null) {
            c0441a = a(view != null ? view.getTag() : null, item);
        } else {
            c0441a = null;
        }
        if (c0441a != null) {
            return c0441a.rootView;
        }
        return null;
    }

    private C0441a a(Object obj, MetaData metaData) {
        C0441a c0441a;
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (obj == null) {
            c0441a = cBm();
        } else {
            c0441a = (C0441a) obj;
        }
        if (this.jRR != null) {
            this.jRR.a(c0441a.rootView, metaData);
        }
        String portrait = metaData.getPortrait();
        c0441a.euc.setText(metaData.getName_show());
        c0441a.gTs.setTagData(metaData);
        c0441a.gSX.setTag(portrait);
        if (this.jRS) {
            c0441a.gTs.setVisibility(0);
        } else {
            c0441a.gTs.setVisibility(8);
        }
        c0441a.gSX.startLoad(portrait, 12, false);
        this.jRQ.getPageContext().getLayoutMode().setNightMode(skinType == 1);
        this.jRQ.getPageContext().getLayoutMode().onModeChanged(c0441a.rootView);
        return c0441a;
    }

    private C0441a cBm() {
        C0441a c0441a = new C0441a();
        c0441a.rootView = LayoutInflater.from(this.mContext).inflate(R.layout.invite_friend_list_item, (ViewGroup) null);
        c0441a.gSX = (HeadImageView) c0441a.rootView.findViewById(R.id.photo);
        c0441a.gSX.setIsRound(false);
        c0441a.euc = (TextView) c0441a.rootView.findViewById(R.id.txt_user_name);
        c0441a.gTs = (TbCheckBox) c0441a.rootView.findViewById(R.id.ckb_select);
        if (this.gTp != null) {
            c0441a.gTs.setStatedChangedListener(this.gTp);
        }
        c0441a.rootView.setTag(c0441a);
        return c0441a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.write.write.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0441a {
        public TextView euc;
        public HeadImageView gSX;
        public TbCheckBox gTs;
        public View rootView;

        private C0441a() {
        }
    }
}
