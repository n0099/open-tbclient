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
    private ArrayList<MetaData> aQJ;
    private TbCheckBox.a eMH;
    private AtListActivity hIu;
    private boolean hIw;
    private final Context mContext;
    private b hIv = null;
    private ViewGroup cnf = null;

    /* loaded from: classes2.dex */
    public interface b {
        void a(View view, MetaData metaData);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b bVar) {
        this.hIv = bVar;
    }

    public a(AtListActivity atListActivity, boolean z) {
        this.hIw = true;
        this.hIu = atListActivity;
        this.mContext = this.hIu.getPageContext().getContext();
        this.hIw = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setData(ArrayList<MetaData> arrayList) {
        this.aQJ = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(TbCheckBox.a aVar) {
        this.eMH = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aQJ == null) {
            return 0;
        }
        return this.aQJ.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: xK */
    public MetaData getItem(int i) {
        if (this.aQJ != null && i < this.aQJ.size()) {
            return this.aQJ.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0175a c0175a;
        if (this.cnf == null) {
            this.cnf = viewGroup;
        }
        MetaData item = getItem(i);
        if (item != null) {
            c0175a = a(view != null ? view.getTag() : null, item);
        } else {
            c0175a = null;
        }
        if (c0175a != null) {
            return c0175a.rootView;
        }
        return null;
    }

    private C0175a a(Object obj, MetaData metaData) {
        C0175a c0175a;
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (obj == null) {
            c0175a = bHk();
        } else {
            c0175a = (C0175a) obj;
        }
        if (this.hIv != null) {
            this.hIv.a(c0175a.rootView, metaData);
        }
        String portrait = metaData.getPortrait();
        c0175a.cQi.setText(metaData.getName_show());
        c0175a.eMK.setTagData(metaData);
        c0175a.eMq.setTag(portrait);
        if (this.hIw) {
            c0175a.eMK.setVisibility(0);
        } else {
            c0175a.eMK.setVisibility(8);
        }
        c0175a.eMq.startLoad(portrait, 12, false);
        this.hIu.getPageContext().getLayoutMode().aN(skinType == 1);
        this.hIu.getPageContext().getLayoutMode().aM(c0175a.rootView);
        return c0175a;
    }

    private C0175a bHk() {
        C0175a c0175a = new C0175a();
        c0175a.rootView = LayoutInflater.from(this.mContext).inflate(d.h.invite_friend_list_item, (ViewGroup) null);
        c0175a.eMq = (HeadImageView) c0175a.rootView.findViewById(d.g.photo);
        c0175a.eMq.setIsRound(false);
        c0175a.cQi = (TextView) c0175a.rootView.findViewById(d.g.txt_user_name);
        c0175a.eMK = (TbCheckBox) c0175a.rootView.findViewById(d.g.ckb_select);
        if (this.eMH != null) {
            c0175a.eMK.setStatedChangedListener(this.eMH);
        }
        c0175a.rootView.setTag(c0175a);
        return c0175a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.write.write.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0175a {
        public TextView cQi;
        public TbCheckBox eMK;
        public HeadImageView eMq;
        public View rootView;

        private C0175a() {
        }
    }
}
