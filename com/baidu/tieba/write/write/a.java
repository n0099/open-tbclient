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
    private ArrayList<MetaData> eYq;
    private TbCheckBox.a kLG;
    private final Context mContext;
    private AtListActivity odk;
    private boolean odm;
    private b odl = null;
    private ViewGroup mParent = null;

    /* loaded from: classes8.dex */
    public interface b {
        void a(View view, MetaData metaData);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b bVar) {
        this.odl = bVar;
    }

    public a(AtListActivity atListActivity, boolean z) {
        this.odm = true;
        this.odk = atListActivity;
        this.mContext = this.odk.getPageContext().getContext();
        this.odm = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setData(ArrayList<MetaData> arrayList) {
        this.eYq = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(TbCheckBox.a aVar) {
        this.kLG = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eYq == null) {
            return 0;
        }
        return this.eYq.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: MH */
    public MetaData getItem(int i) {
        if (this.eYq != null && i < this.eYq.size()) {
            return this.eYq.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0880a c0880a;
        if (this.mParent == null) {
            this.mParent = viewGroup;
        }
        MetaData item = getItem(i);
        if (item != null) {
            c0880a = a(view != null ? view.getTag() : null, item);
        } else {
            c0880a = null;
        }
        if (c0880a != null) {
            return c0880a.rootView;
        }
        return null;
    }

    private C0880a a(Object obj, MetaData metaData) {
        C0880a c0880a;
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (obj == null) {
            c0880a = dZm();
        } else {
            c0880a = (C0880a) obj;
        }
        if (this.odl != null) {
            this.odl.a(c0880a.rootView, metaData);
        }
        String avater = metaData.getAvater();
        c0880a.hYe.setText(metaData.getName_show());
        c0880a.kLJ.setTagData(metaData);
        c0880a.kLo.setTag(avater);
        if (this.odm) {
            c0880a.kLJ.setVisibility(0);
        } else {
            c0880a.kLJ.setVisibility(8);
        }
        c0880a.kLo.startLoad(avater, 12, false);
        this.odk.getPageContext().getLayoutMode().setNightMode(skinType == 1);
        this.odk.getPageContext().getLayoutMode().onModeChanged(c0880a.rootView);
        return c0880a;
    }

    private C0880a dZm() {
        C0880a c0880a = new C0880a();
        c0880a.rootView = LayoutInflater.from(this.mContext).inflate(R.layout.invite_friend_list_item, (ViewGroup) null);
        c0880a.kLo = (HeadImageView) c0880a.rootView.findViewById(R.id.photo);
        c0880a.kLo.setIsRound(false);
        c0880a.hYe = (TextView) c0880a.rootView.findViewById(R.id.txt_user_name);
        c0880a.kLJ = (TbCheckBox) c0880a.rootView.findViewById(R.id.ckb_select);
        c0880a.kLJ.setBackgroundDrawableIdIsWebP(true);
        c0880a.kLJ.setBackgroundDrawableId(R.drawable.icon_pure_strok324_select, R.drawable.icon_pure_strok324);
        if (this.kLG != null) {
            c0880a.kLJ.setStatedChangedListener(this.kLG);
        }
        c0880a.rootView.setTag(c0880a);
        return c0880a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.write.write.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0880a {
        public TextView hYe;
        public TbCheckBox kLJ;
        public HeadImageView kLo;
        public View rootView;

        private C0880a() {
        }
    }
}
