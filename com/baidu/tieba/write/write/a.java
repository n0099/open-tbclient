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
    private TbCheckBox.a kPf;
    private final Context mContext;
    private AtListActivity oiJ;
    private boolean oiL;
    private b oiK = null;
    private ViewGroup mParent = null;

    /* loaded from: classes8.dex */
    public interface b {
        void a(View view, MetaData metaData);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b bVar) {
        this.oiK = bVar;
    }

    public a(AtListActivity atListActivity, boolean z) {
        this.oiL = true;
        this.oiJ = atListActivity;
        this.mContext = this.oiJ.getPageContext().getContext();
        this.oiL = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setData(ArrayList<MetaData> arrayList) {
        this.eVV = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(TbCheckBox.a aVar) {
        this.kPf = aVar;
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
    /* renamed from: Lv */
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
        C0904a c0904a;
        if (this.mParent == null) {
            this.mParent = viewGroup;
        }
        MetaData item = getItem(i);
        if (item != null) {
            c0904a = a(view != null ? view.getTag() : null, item);
        } else {
            c0904a = null;
        }
        if (c0904a != null) {
            return c0904a.rootView;
        }
        return null;
    }

    private C0904a a(Object obj, MetaData metaData) {
        C0904a c0904a;
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (obj == null) {
            c0904a = dXJ();
        } else {
            c0904a = (C0904a) obj;
        }
        if (this.oiK != null) {
            this.oiK.a(c0904a.rootView, metaData);
        }
        String avater = metaData.getAvater();
        c0904a.hXS.setText(metaData.getName_show());
        c0904a.kPi.setTagData(metaData);
        c0904a.kON.setTag(avater);
        if (this.oiL) {
            c0904a.kPi.setVisibility(0);
        } else {
            c0904a.kPi.setVisibility(8);
        }
        c0904a.kON.startLoad(avater, 12, false);
        this.oiJ.getPageContext().getLayoutMode().setNightMode(skinType == 1);
        this.oiJ.getPageContext().getLayoutMode().onModeChanged(c0904a.rootView);
        return c0904a;
    }

    private C0904a dXJ() {
        C0904a c0904a = new C0904a();
        c0904a.rootView = LayoutInflater.from(this.mContext).inflate(R.layout.invite_friend_list_item, (ViewGroup) null);
        c0904a.kON = (HeadImageView) c0904a.rootView.findViewById(R.id.photo);
        c0904a.kON.setIsRound(false);
        c0904a.hXS = (TextView) c0904a.rootView.findViewById(R.id.txt_user_name);
        c0904a.kPi = (TbCheckBox) c0904a.rootView.findViewById(R.id.ckb_select);
        c0904a.kPi.setBackgroundDrawableIdIsWebP(true);
        c0904a.kPi.setBackgroundDrawableId(R.drawable.icon_pure_strok324_select, R.drawable.icon_pure_strok324);
        if (this.kPf != null) {
            c0904a.kPi.setStatedChangedListener(this.kPf);
        }
        c0904a.rootView.setTag(c0904a);
        return c0904a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.write.write.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0904a {
        public TextView hXS;
        public HeadImageView kON;
        public TbCheckBox kPi;
        public View rootView;

        private C0904a() {
        }
    }
}
