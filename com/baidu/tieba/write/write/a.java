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
    private TbCheckBox.a gNc;
    private AtListActivity jKN;
    private boolean jKP;
    private final Context mContext;
    private b jKO = null;
    private ViewGroup mParent = null;

    /* loaded from: classes3.dex */
    public interface b {
        void a(View view, MetaData metaData);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b bVar) {
        this.jKO = bVar;
    }

    public a(AtListActivity atListActivity, boolean z) {
        this.jKP = true;
        this.jKN = atListActivity;
        this.mContext = this.jKN.getPageContext().getContext();
        this.jKP = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setData(ArrayList<MetaData> arrayList) {
        this.aHF = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(TbCheckBox.a aVar) {
        this.gNc = aVar;
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
            c0436a = cyn();
        } else {
            c0436a = (C0436a) obj;
        }
        if (this.jKO != null) {
            this.jKO.a(c0436a.rootView, metaData);
        }
        String portrait = metaData.getPortrait();
        c0436a.epd.setText(metaData.getName_show());
        c0436a.gNf.setTagData(metaData);
        c0436a.gMK.setTag(portrait);
        if (this.jKP) {
            c0436a.gNf.setVisibility(0);
        } else {
            c0436a.gNf.setVisibility(8);
        }
        c0436a.gMK.startLoad(portrait, 12, false);
        this.jKN.getPageContext().getLayoutMode().setNightMode(skinType == 1);
        this.jKN.getPageContext().getLayoutMode().onModeChanged(c0436a.rootView);
        return c0436a;
    }

    private C0436a cyn() {
        C0436a c0436a = new C0436a();
        c0436a.rootView = LayoutInflater.from(this.mContext).inflate(R.layout.invite_friend_list_item, (ViewGroup) null);
        c0436a.gMK = (HeadImageView) c0436a.rootView.findViewById(R.id.photo);
        c0436a.gMK.setIsRound(false);
        c0436a.epd = (TextView) c0436a.rootView.findViewById(R.id.txt_user_name);
        c0436a.gNf = (TbCheckBox) c0436a.rootView.findViewById(R.id.ckb_select);
        if (this.gNc != null) {
            c0436a.gNf.setStatedChangedListener(this.gNc);
        }
        c0436a.rootView.setTag(c0436a);
        return c0436a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.write.write.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0436a {
        public TextView epd;
        public HeadImageView gMK;
        public TbCheckBox gNf;
        public View rootView;

        private C0436a() {
        }
    }
}
