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
    private AtListActivity odj;
    private boolean odl;
    private b odk = null;
    private ViewGroup mParent = null;

    /* loaded from: classes8.dex */
    public interface b {
        void a(View view, MetaData metaData);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b bVar) {
        this.odk = bVar;
    }

    public a(AtListActivity atListActivity, boolean z) {
        this.odl = true;
        this.odj = atListActivity;
        this.mContext = this.odj.getPageContext().getContext();
        this.odl = z;
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
        C0918a c0918a;
        if (this.mParent == null) {
            this.mParent = viewGroup;
        }
        MetaData item = getItem(i);
        if (item != null) {
            c0918a = a(view != null ? view.getTag() : null, item);
        } else {
            c0918a = null;
        }
        if (c0918a != null) {
            return c0918a.rootView;
        }
        return null;
    }

    private C0918a a(Object obj, MetaData metaData) {
        C0918a c0918a;
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (obj == null) {
            c0918a = dZn();
        } else {
            c0918a = (C0918a) obj;
        }
        if (this.odk != null) {
            this.odk.a(c0918a.rootView, metaData);
        }
        String avater = metaData.getAvater();
        c0918a.hYe.setText(metaData.getName_show());
        c0918a.kLJ.setTagData(metaData);
        c0918a.kLo.setTag(avater);
        if (this.odl) {
            c0918a.kLJ.setVisibility(0);
        } else {
            c0918a.kLJ.setVisibility(8);
        }
        c0918a.kLo.startLoad(avater, 12, false);
        this.odj.getPageContext().getLayoutMode().setNightMode(skinType == 1);
        this.odj.getPageContext().getLayoutMode().onModeChanged(c0918a.rootView);
        return c0918a;
    }

    private C0918a dZn() {
        C0918a c0918a = new C0918a();
        c0918a.rootView = LayoutInflater.from(this.mContext).inflate(R.layout.invite_friend_list_item, (ViewGroup) null);
        c0918a.kLo = (HeadImageView) c0918a.rootView.findViewById(R.id.photo);
        c0918a.kLo.setIsRound(false);
        c0918a.hYe = (TextView) c0918a.rootView.findViewById(R.id.txt_user_name);
        c0918a.kLJ = (TbCheckBox) c0918a.rootView.findViewById(R.id.ckb_select);
        c0918a.kLJ.setBackgroundDrawableIdIsWebP(true);
        c0918a.kLJ.setBackgroundDrawableId(R.drawable.icon_pure_strok324_select, R.drawable.icon_pure_strok324);
        if (this.kLG != null) {
            c0918a.kLJ.setStatedChangedListener(this.kLG);
        }
        c0918a.rootView.setTag(c0918a);
        return c0918a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.write.write.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0918a {
        public TextView hYe;
        public TbCheckBox kLJ;
        public HeadImageView kLo;
        public View rootView;

        private C0918a() {
        }
    }
}
