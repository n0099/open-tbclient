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
/* loaded from: classes8.dex */
public class a extends BaseAdapter {
    private ArrayList<MetaData> eVV;
    private TbCheckBox.a kPt;
    private final Context mContext;
    private AtListActivity ojj;
    private boolean ojl;
    private b ojk = null;
    private ViewGroup mParent = null;

    /* loaded from: classes8.dex */
    public interface b {
        void a(View view, MetaData metaData);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b bVar) {
        this.ojk = bVar;
    }

    public a(AtListActivity atListActivity, boolean z) {
        this.ojl = true;
        this.ojj = atListActivity;
        this.mContext = this.ojj.getPageContext().getContext();
        this.ojl = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setData(ArrayList<MetaData> arrayList) {
        this.eVV = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(TbCheckBox.a aVar) {
        this.kPt = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eVV == null) {
            return 0;
        }
        return this.eVV.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: Lw */
    public MetaData getItem(int i) {
        if (this.eVV != null && i < this.eVV.size()) {
            return this.eVV.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0906a c0906a;
        if (this.mParent == null) {
            this.mParent = viewGroup;
        }
        MetaData item = getItem(i);
        if (item != null) {
            c0906a = a(view != null ? view.getTag() : null, item);
        } else {
            c0906a = null;
        }
        if (c0906a != null) {
            return c0906a.rootView;
        }
        return null;
    }

    private C0906a a(Object obj, MetaData metaData) {
        C0906a c0906a;
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (obj == null) {
            c0906a = dXR();
        } else {
            c0906a = (C0906a) obj;
        }
        if (this.ojk != null) {
            this.ojk.a(c0906a.rootView, metaData);
        }
        String avater = metaData.getAvater();
        c0906a.hYg.setText(metaData.getName_show());
        c0906a.kPw.setTagData(metaData);
        c0906a.kPb.setTag(avater);
        if (this.ojl) {
            c0906a.kPw.setVisibility(0);
        } else {
            c0906a.kPw.setVisibility(8);
        }
        c0906a.kPb.startLoad(avater, 12, false);
        this.ojj.getPageContext().getLayoutMode().setNightMode(skinType == 1);
        this.ojj.getPageContext().getLayoutMode().onModeChanged(c0906a.rootView);
        return c0906a;
    }

    private C0906a dXR() {
        C0906a c0906a = new C0906a();
        c0906a.rootView = LayoutInflater.from(this.mContext).inflate(R.layout.invite_friend_list_item, (ViewGroup) null);
        c0906a.kPb = (HeadImageView) c0906a.rootView.findViewById(R.id.photo);
        c0906a.kPb.setIsRound(false);
        c0906a.hYg = (TextView) c0906a.rootView.findViewById(R.id.txt_user_name);
        c0906a.kPw = (TbCheckBox) c0906a.rootView.findViewById(R.id.ckb_select);
        c0906a.kPw.setBackgroundDrawableIdIsWebP(true);
        c0906a.kPw.setBackgroundDrawableId(R.drawable.icon_pure_strok324_select, R.drawable.icon_pure_strok324);
        if (this.kPt != null) {
            c0906a.kPw.setStatedChangedListener(this.kPt);
        }
        c0906a.rootView.setTag(c0906a);
        return c0906a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.write.write.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0906a {
        public TextView hYg;
        public HeadImageView kPb;
        public TbCheckBox kPw;
        public View rootView;

        private C0906a() {
        }
    }
}
