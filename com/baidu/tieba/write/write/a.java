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
/* loaded from: classes2.dex */
public class a extends BaseAdapter {
    private ArrayList<MetaData> aSi;
    private TbCheckBox.a eQQ;
    private AtListActivity hJR;
    private boolean hJT;
    private final Context mContext;
    private b hJS = null;
    private ViewGroup crh = null;

    /* loaded from: classes2.dex */
    public interface b {
        void a(View view, MetaData metaData);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b bVar) {
        this.hJS = bVar;
    }

    public a(AtListActivity atListActivity, boolean z) {
        this.hJT = true;
        this.hJR = atListActivity;
        this.mContext = this.hJR.getPageContext().getContext();
        this.hJT = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setData(ArrayList<MetaData> arrayList) {
        this.aSi = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(TbCheckBox.a aVar) {
        this.eQQ = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aSi == null) {
            return 0;
        }
        return this.aSi.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: xJ */
    public MetaData getItem(int i) {
        if (this.aSi != null && i < this.aSi.size()) {
            return this.aSi.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0257a c0257a;
        if (this.crh == null) {
            this.crh = viewGroup;
        }
        MetaData item = getItem(i);
        if (item != null) {
            c0257a = a(view != null ? view.getTag() : null, item);
        } else {
            c0257a = null;
        }
        if (c0257a != null) {
            return c0257a.rootView;
        }
        return null;
    }

    private C0257a a(Object obj, MetaData metaData) {
        C0257a c0257a;
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (obj == null) {
            c0257a = bHY();
        } else {
            c0257a = (C0257a) obj;
        }
        if (this.hJS != null) {
            this.hJS.a(c0257a.rootView, metaData);
        }
        String portrait = metaData.getPortrait();
        c0257a.cqu.setText(metaData.getName_show());
        c0257a.eQT.setTagData(metaData);
        c0257a.eQz.setTag(portrait);
        if (this.hJT) {
            c0257a.eQT.setVisibility(0);
        } else {
            c0257a.eQT.setVisibility(8);
        }
        c0257a.eQz.startLoad(portrait, 12, false);
        this.hJR.getPageContext().getLayoutMode().aQ(skinType == 1);
        this.hJR.getPageContext().getLayoutMode().aM(c0257a.rootView);
        return c0257a;
    }

    private C0257a bHY() {
        C0257a c0257a = new C0257a();
        c0257a.rootView = LayoutInflater.from(this.mContext).inflate(d.h.invite_friend_list_item, (ViewGroup) null);
        c0257a.eQz = (HeadImageView) c0257a.rootView.findViewById(d.g.photo);
        c0257a.eQz.setIsRound(false);
        c0257a.cqu = (TextView) c0257a.rootView.findViewById(d.g.txt_user_name);
        c0257a.eQT = (TbCheckBox) c0257a.rootView.findViewById(d.g.ckb_select);
        if (this.eQQ != null) {
            c0257a.eQT.setStatedChangedListener(this.eQQ);
        }
        c0257a.rootView.setTag(c0257a);
        return c0257a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.write.write.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0257a {
        public TextView cqu;
        public TbCheckBox eQT;
        public HeadImageView eQz;
        public View rootView;

        private C0257a() {
        }
    }
}
