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
import com.baidu.tieba.e;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    private TbCheckBox.a eVB;
    private AtListActivity hPw;
    private boolean hPy;
    private final Context mContext;
    private ArrayList<MetaData> mData;
    private b hPx = null;
    private ViewGroup mParent = null;

    /* loaded from: classes3.dex */
    public interface b {
        void a(View view, MetaData metaData);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b bVar) {
        this.hPx = bVar;
    }

    public a(AtListActivity atListActivity, boolean z) {
        this.hPy = true;
        this.hPw = atListActivity;
        this.mContext = this.hPw.getPageContext().getContext();
        this.hPy = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setData(ArrayList<MetaData> arrayList) {
        this.mData = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(TbCheckBox.a aVar) {
        this.eVB = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.mData == null) {
            return 0;
        }
        return this.mData.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: wU */
    public MetaData getItem(int i) {
        if (this.mData != null && i < this.mData.size()) {
            return this.mData.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0330a c0330a;
        if (this.mParent == null) {
            this.mParent = viewGroup;
        }
        MetaData item = getItem(i);
        if (item != null) {
            c0330a = a(view != null ? view.getTag() : null, item);
        } else {
            c0330a = null;
        }
        if (c0330a != null) {
            return c0330a.rootView;
        }
        return null;
    }

    private C0330a a(Object obj, MetaData metaData) {
        C0330a c0330a;
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (obj == null) {
            c0330a = bMJ();
        } else {
            c0330a = (C0330a) obj;
        }
        if (this.hPx != null) {
            this.hPx.a(c0330a.rootView, metaData);
        }
        String portrait = metaData.getPortrait();
        c0330a.chp.setText(metaData.getName_show());
        c0330a.eVE.setTagData(metaData);
        c0330a.eVj.setTag(portrait);
        if (this.hPy) {
            c0330a.eVE.setVisibility(0);
        } else {
            c0330a.eVE.setVisibility(8);
        }
        c0330a.eVj.startLoad(portrait, 12, false);
        this.hPw.getPageContext().getLayoutMode().setNightMode(skinType == 1);
        this.hPw.getPageContext().getLayoutMode().onModeChanged(c0330a.rootView);
        return c0330a;
    }

    private C0330a bMJ() {
        C0330a c0330a = new C0330a();
        c0330a.rootView = LayoutInflater.from(this.mContext).inflate(e.h.invite_friend_list_item, (ViewGroup) null);
        c0330a.eVj = (HeadImageView) c0330a.rootView.findViewById(e.g.photo);
        c0330a.eVj.setIsRound(false);
        c0330a.chp = (TextView) c0330a.rootView.findViewById(e.g.txt_user_name);
        c0330a.eVE = (TbCheckBox) c0330a.rootView.findViewById(e.g.ckb_select);
        if (this.eVB != null) {
            c0330a.eVE.setStatedChangedListener(this.eVB);
        }
        c0330a.rootView.setTag(c0330a);
        return c0330a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.write.write.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0330a {
        public TextView chp;
        public TbCheckBox eVE;
        public HeadImageView eVj;
        public View rootView;

        private C0330a() {
        }
    }
}
