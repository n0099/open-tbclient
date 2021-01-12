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
/* loaded from: classes7.dex */
public class a extends BaseAdapter {
    private ArrayList<MetaData> eTF;
    private TbCheckBox.a kHb;
    private final Context mContext;
    private AtListActivity nYC;
    private boolean nYE;
    private b nYD = null;
    private ViewGroup mParent = null;

    /* loaded from: classes7.dex */
    public interface b {
        void a(View view, MetaData metaData);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b bVar) {
        this.nYD = bVar;
    }

    public a(AtListActivity atListActivity, boolean z) {
        this.nYE = true;
        this.nYC = atListActivity;
        this.mContext = this.nYC.getPageContext().getContext();
        this.nYE = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setData(ArrayList<MetaData> arrayList) {
        this.eTF = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(TbCheckBox.a aVar) {
        this.kHb = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eTF == null) {
            return 0;
        }
        return this.eTF.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: La */
    public MetaData getItem(int i) {
        if (this.eTF != null && i < this.eTF.size()) {
            return this.eTF.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0901a c0901a;
        if (this.mParent == null) {
            this.mParent = viewGroup;
        }
        MetaData item = getItem(i);
        if (item != null) {
            c0901a = a(view != null ? view.getTag() : null, item);
        } else {
            c0901a = null;
        }
        if (c0901a != null) {
            return c0901a.rootView;
        }
        return null;
    }

    private C0901a a(Object obj, MetaData metaData) {
        C0901a c0901a;
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (obj == null) {
            c0901a = dVv();
        } else {
            c0901a = (C0901a) obj;
        }
        if (this.nYD != null) {
            this.nYD.a(c0901a.rootView, metaData);
        }
        String avater = metaData.getAvater();
        c0901a.hTx.setText(metaData.getName_show());
        c0901a.kHe.setTagData(metaData);
        c0901a.kGJ.setTag(avater);
        if (this.nYE) {
            c0901a.kHe.setVisibility(0);
        } else {
            c0901a.kHe.setVisibility(8);
        }
        c0901a.kGJ.startLoad(avater, 12, false);
        this.nYC.getPageContext().getLayoutMode().setNightMode(skinType == 1);
        this.nYC.getPageContext().getLayoutMode().onModeChanged(c0901a.rootView);
        return c0901a;
    }

    private C0901a dVv() {
        C0901a c0901a = new C0901a();
        c0901a.rootView = LayoutInflater.from(this.mContext).inflate(R.layout.invite_friend_list_item, (ViewGroup) null);
        c0901a.kGJ = (HeadImageView) c0901a.rootView.findViewById(R.id.photo);
        c0901a.kGJ.setIsRound(false);
        c0901a.hTx = (TextView) c0901a.rootView.findViewById(R.id.txt_user_name);
        c0901a.kHe = (TbCheckBox) c0901a.rootView.findViewById(R.id.ckb_select);
        c0901a.kHe.setBackgroundDrawableIdIsWebP(true);
        c0901a.kHe.setBackgroundDrawableId(R.drawable.icon_pure_strok324_select, R.drawable.icon_pure_strok324);
        if (this.kHb != null) {
            c0901a.kHe.setStatedChangedListener(this.kHb);
        }
        c0901a.rootView.setTag(c0901a);
        return c0901a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.write.write.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0901a {
        public TextView hTx;
        public HeadImageView kGJ;
        public TbCheckBox kHe;
        public View rootView;

        private C0901a() {
        }
    }
}
