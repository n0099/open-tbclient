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
    private ArrayList<MetaData> aHF;
    private TbCheckBox.a gNd;
    private AtListActivity jKO;
    private boolean jKQ;
    private final Context mContext;
    private b jKP = null;
    private ViewGroup mParent = null;

    /* loaded from: classes3.dex */
    public interface b {
        void a(View view, MetaData metaData);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b bVar) {
        this.jKP = bVar;
    }

    public a(AtListActivity atListActivity, boolean z) {
        this.jKQ = true;
        this.jKO = atListActivity;
        this.mContext = this.jKO.getPageContext().getContext();
        this.jKQ = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setData(ArrayList<MetaData> arrayList) {
        this.aHF = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(TbCheckBox.a aVar) {
        this.gNd = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aHF == null) {
            return 0;
        }
        return this.aHF.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: CB */
    public MetaData getItem(int i) {
        if (this.aHF != null && i < this.aHF.size()) {
            return this.aHF.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0436a c0436a;
        if (this.mParent == null) {
            this.mParent = viewGroup;
        }
        MetaData item = getItem(i);
        if (item != null) {
            c0436a = a(view != null ? view.getTag() : null, item);
        } else {
            c0436a = null;
        }
        if (c0436a != null) {
            return c0436a.rootView;
        }
        return null;
    }

    private C0436a a(Object obj, MetaData metaData) {
        C0436a c0436a;
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (obj == null) {
            c0436a = cyp();
        } else {
            c0436a = (C0436a) obj;
        }
        if (this.jKP != null) {
            this.jKP.a(c0436a.rootView, metaData);
        }
        String portrait = metaData.getPortrait();
        c0436a.epe.setText(metaData.getName_show());
        c0436a.gNg.setTagData(metaData);
        c0436a.gML.setTag(portrait);
        if (this.jKQ) {
            c0436a.gNg.setVisibility(0);
        } else {
            c0436a.gNg.setVisibility(8);
        }
        c0436a.gML.startLoad(portrait, 12, false);
        this.jKO.getPageContext().getLayoutMode().setNightMode(skinType == 1);
        this.jKO.getPageContext().getLayoutMode().onModeChanged(c0436a.rootView);
        return c0436a;
    }

    private C0436a cyp() {
        C0436a c0436a = new C0436a();
        c0436a.rootView = LayoutInflater.from(this.mContext).inflate(R.layout.invite_friend_list_item, (ViewGroup) null);
        c0436a.gML = (HeadImageView) c0436a.rootView.findViewById(R.id.photo);
        c0436a.gML.setIsRound(false);
        c0436a.epe = (TextView) c0436a.rootView.findViewById(R.id.txt_user_name);
        c0436a.gNg = (TbCheckBox) c0436a.rootView.findViewById(R.id.ckb_select);
        if (this.gNd != null) {
            c0436a.gNg.setStatedChangedListener(this.gNd);
        }
        c0436a.rootView.setTag(c0436a);
        return c0436a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.write.write.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0436a {
        public TextView epe;
        public HeadImageView gML;
        public TbCheckBox gNg;
        public View rootView;

        private C0436a() {
        }
    }
}
