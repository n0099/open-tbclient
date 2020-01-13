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
/* loaded from: classes11.dex */
public class a extends BaseAdapter {
    private ArrayList<MetaData> cRO;
    private TbCheckBox.a hKP;
    private AtListActivity kQP;
    private boolean kQR;
    private final Context mContext;
    private b kQQ = null;
    private ViewGroup mParent = null;

    /* loaded from: classes11.dex */
    public interface b {
        void a(View view, MetaData metaData);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b bVar) {
        this.kQQ = bVar;
    }

    public a(AtListActivity atListActivity, boolean z) {
        this.kQR = true;
        this.kQP = atListActivity;
        this.mContext = this.kQP.getPageContext().getContext();
        this.kQR = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setData(ArrayList<MetaData> arrayList) {
        this.cRO = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(TbCheckBox.a aVar) {
        this.hKP = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.cRO == null) {
            return 0;
        }
        return this.cRO.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: El */
    public MetaData getItem(int i) {
        if (this.cRO != null && i < this.cRO.size()) {
            return this.cRO.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0632a c0632a;
        if (this.mParent == null) {
            this.mParent = viewGroup;
        }
        MetaData item = getItem(i);
        if (item != null) {
            c0632a = a(view != null ? view.getTag() : null, item);
        } else {
            c0632a = null;
        }
        if (c0632a != null) {
            return c0632a.rootView;
        }
        return null;
    }

    private C0632a a(Object obj, MetaData metaData) {
        C0632a c0632a;
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (obj == null) {
            c0632a = cUg();
        } else {
            c0632a = (C0632a) obj;
        }
        if (this.kQQ != null) {
            this.kQQ.a(c0632a.rootView, metaData);
        }
        String avater = metaData.getAvater();
        c0632a.fqi.setText(metaData.getName_show());
        c0632a.hKS.setTagData(metaData);
        c0632a.hKx.setTag(avater);
        if (this.kQR) {
            c0632a.hKS.setVisibility(0);
        } else {
            c0632a.hKS.setVisibility(8);
        }
        c0632a.hKx.startLoad(avater, 12, false);
        this.kQP.getPageContext().getLayoutMode().setNightMode(skinType == 1);
        this.kQP.getPageContext().getLayoutMode().onModeChanged(c0632a.rootView);
        return c0632a;
    }

    private C0632a cUg() {
        C0632a c0632a = new C0632a();
        c0632a.rootView = LayoutInflater.from(this.mContext).inflate(R.layout.invite_friend_list_item, (ViewGroup) null);
        c0632a.hKx = (HeadImageView) c0632a.rootView.findViewById(R.id.photo);
        c0632a.hKx.setIsRound(false);
        c0632a.fqi = (TextView) c0632a.rootView.findViewById(R.id.txt_user_name);
        c0632a.hKS = (TbCheckBox) c0632a.rootView.findViewById(R.id.ckb_select);
        if (this.hKP != null) {
            c0632a.hKS.setStatedChangedListener(this.hKP);
        }
        c0632a.rootView.setTag(c0632a);
        return c0632a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.write.write.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public class C0632a {
        public TextView fqi;
        public TbCheckBox hKS;
        public HeadImageView hKx;
        public View rootView;

        private C0632a() {
        }
    }
}
