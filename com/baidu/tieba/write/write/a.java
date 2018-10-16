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
    private TbCheckBox.a eUi;
    private AtListActivity hNL;
    private boolean hNN;
    private final Context mContext;
    private ArrayList<MetaData> mData;
    private b hNM = null;
    private ViewGroup mParent = null;

    /* loaded from: classes3.dex */
    public interface b {
        void a(View view, MetaData metaData);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b bVar) {
        this.hNM = bVar;
    }

    public a(AtListActivity atListActivity, boolean z) {
        this.hNN = true;
        this.hNL = atListActivity;
        this.mContext = this.hNL.getPageContext().getContext();
        this.hNN = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setData(ArrayList<MetaData> arrayList) {
        this.mData = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(TbCheckBox.a aVar) {
        this.eUi = aVar;
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
    /* renamed from: wB */
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
        C0302a c0302a;
        if (this.mParent == null) {
            this.mParent = viewGroup;
        }
        MetaData item = getItem(i);
        if (item != null) {
            c0302a = a(view != null ? view.getTag() : null, item);
        } else {
            c0302a = null;
        }
        if (c0302a != null) {
            return c0302a.rootView;
        }
        return null;
    }

    private C0302a a(Object obj, MetaData metaData) {
        C0302a c0302a;
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (obj == null) {
            c0302a = bNk();
        } else {
            c0302a = (C0302a) obj;
        }
        if (this.hNM != null) {
            this.hNM.a(c0302a.rootView, metaData);
        }
        String portrait = metaData.getPortrait();
        c0302a.chf.setText(metaData.getName_show());
        c0302a.eUl.setTagData(metaData);
        c0302a.eTQ.setTag(portrait);
        if (this.hNN) {
            c0302a.eUl.setVisibility(0);
        } else {
            c0302a.eUl.setVisibility(8);
        }
        c0302a.eTQ.startLoad(portrait, 12, false);
        this.hNL.getPageContext().getLayoutMode().setNightMode(skinType == 1);
        this.hNL.getPageContext().getLayoutMode().onModeChanged(c0302a.rootView);
        return c0302a;
    }

    private C0302a bNk() {
        C0302a c0302a = new C0302a();
        c0302a.rootView = LayoutInflater.from(this.mContext).inflate(e.h.invite_friend_list_item, (ViewGroup) null);
        c0302a.eTQ = (HeadImageView) c0302a.rootView.findViewById(e.g.photo);
        c0302a.eTQ.setIsRound(false);
        c0302a.chf = (TextView) c0302a.rootView.findViewById(e.g.txt_user_name);
        c0302a.eUl = (TbCheckBox) c0302a.rootView.findViewById(e.g.ckb_select);
        if (this.eUi != null) {
            c0302a.eUl.setStatedChangedListener(this.eUi);
        }
        c0302a.rootView.setTag(c0302a);
        return c0302a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.write.write.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0302a {
        public TextView chf;
        public HeadImageView eTQ;
        public TbCheckBox eUl;
        public View rootView;

        private C0302a() {
        }
    }
}
