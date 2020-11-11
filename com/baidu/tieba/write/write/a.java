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
    private ArrayList<MetaData> eIM;
    private TbCheckBox.a ksr;
    private final Context mContext;
    private AtListActivity nLd;
    private boolean nLf;
    private b nLe = null;
    private ViewGroup mParent = null;

    /* loaded from: classes3.dex */
    public interface b {
        void a(View view, MetaData metaData);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b bVar) {
        this.nLe = bVar;
    }

    public a(AtListActivity atListActivity, boolean z) {
        this.nLf = true;
        this.nLd = atListActivity;
        this.mContext = this.nLd.getPageContext().getContext();
        this.nLf = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setData(ArrayList<MetaData> arrayList) {
        this.eIM = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(TbCheckBox.a aVar) {
        this.ksr = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eIM == null) {
            return 0;
        }
        return this.eIM.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: LA */
    public MetaData getItem(int i) {
        if (this.eIM != null && i < this.eIM.size()) {
            return this.eIM.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0886a c0886a;
        if (this.mParent == null) {
            this.mParent = viewGroup;
        }
        MetaData item = getItem(i);
        if (item != null) {
            c0886a = a(view != null ? view.getTag() : null, item);
        } else {
            c0886a = null;
        }
        if (c0886a != null) {
            return c0886a.rootView;
        }
        return null;
    }

    private C0886a a(Object obj, MetaData metaData) {
        C0886a c0886a;
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (obj == null) {
            c0886a = dUH();
        } else {
            c0886a = (C0886a) obj;
        }
        if (this.nLe != null) {
            this.nLe.a(c0886a.rootView, metaData);
        }
        String avater = metaData.getAvater();
        c0886a.hCp.setText(metaData.getName_show());
        c0886a.ksu.setTagData(metaData);
        c0886a.krY.setTag(avater);
        if (this.nLf) {
            c0886a.ksu.setVisibility(0);
        } else {
            c0886a.ksu.setVisibility(8);
        }
        c0886a.krY.startLoad(avater, 12, false);
        this.nLd.getPageContext().getLayoutMode().setNightMode(skinType == 1);
        this.nLd.getPageContext().getLayoutMode().onModeChanged(c0886a.rootView);
        return c0886a;
    }

    private C0886a dUH() {
        C0886a c0886a = new C0886a();
        c0886a.rootView = LayoutInflater.from(this.mContext).inflate(R.layout.invite_friend_list_item, (ViewGroup) null);
        c0886a.krY = (HeadImageView) c0886a.rootView.findViewById(R.id.photo);
        c0886a.krY.setIsRound(false);
        c0886a.hCp = (TextView) c0886a.rootView.findViewById(R.id.txt_user_name);
        c0886a.ksu = (TbCheckBox) c0886a.rootView.findViewById(R.id.ckb_select);
        if (this.ksr != null) {
            c0886a.ksu.setStatedChangedListener(this.ksr);
        }
        c0886a.rootView.setTag(c0886a);
        return c0886a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.write.write.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0886a {
        public TextView hCp;
        public HeadImageView krY;
        public TbCheckBox ksu;
        public View rootView;

        private C0886a() {
        }
    }
}
