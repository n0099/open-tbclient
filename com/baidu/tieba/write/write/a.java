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
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    private ArrayList<MetaData> alt;
    private TbCheckBox.a exE;
    private AtListActivity hsL;
    private boolean hsN;
    private final Context mContext;
    private b hsM = null;
    private ViewGroup mParent = null;

    /* loaded from: classes3.dex */
    public interface b {
        void a(View view, MetaData metaData);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b bVar) {
        this.hsM = bVar;
    }

    public a(AtListActivity atListActivity, boolean z) {
        this.hsN = true;
        this.hsL = atListActivity;
        this.mContext = this.hsL.getPageContext().getContext();
        this.hsN = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setData(ArrayList<MetaData> arrayList) {
        this.alt = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(TbCheckBox.a aVar) {
        this.exE = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.alt == null) {
            return 0;
        }
        return this.alt.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: vw */
    public MetaData getItem(int i) {
        if (this.alt != null && i < this.alt.size()) {
            return this.alt.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0259a c0259a;
        if (this.mParent == null) {
            this.mParent = viewGroup;
        }
        MetaData item = getItem(i);
        if (item != null) {
            c0259a = a(view != null ? view.getTag() : null, item);
        } else {
            c0259a = null;
        }
        if (c0259a != null) {
            return c0259a.rootView;
        }
        return null;
    }

    private C0259a a(Object obj, MetaData metaData) {
        C0259a c0259a;
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (obj == null) {
            c0259a = bHR();
        } else {
            c0259a = (C0259a) obj;
        }
        if (this.hsM != null) {
            this.hsM.a(c0259a.rootView, metaData);
        }
        String portrait = metaData.getPortrait();
        c0259a.bPN.setText(metaData.getName_show());
        c0259a.exH.setTagData(metaData);
        c0259a.exm.setTag(portrait);
        if (this.hsN) {
            c0259a.exH.setVisibility(0);
        } else {
            c0259a.exH.setVisibility(8);
        }
        c0259a.exm.startLoad(portrait, 12, false);
        this.hsL.getPageContext().getLayoutMode().setNightMode(skinType == 1);
        this.hsL.getPageContext().getLayoutMode().onModeChanged(c0259a.rootView);
        return c0259a;
    }

    private C0259a bHR() {
        C0259a c0259a = new C0259a();
        c0259a.rootView = LayoutInflater.from(this.mContext).inflate(d.i.invite_friend_list_item, (ViewGroup) null);
        c0259a.exm = (HeadImageView) c0259a.rootView.findViewById(d.g.photo);
        c0259a.exm.setIsRound(false);
        c0259a.bPN = (TextView) c0259a.rootView.findViewById(d.g.txt_user_name);
        c0259a.exH = (TbCheckBox) c0259a.rootView.findViewById(d.g.ckb_select);
        if (this.exE != null) {
            c0259a.exH.setStatedChangedListener(this.exE);
        }
        c0259a.rootView.setTag(c0259a);
        return c0259a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.write.write.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0259a {
        public TextView bPN;
        public TbCheckBox exH;
        public HeadImageView exm;
        public View rootView;

        private C0259a() {
        }
    }
}
