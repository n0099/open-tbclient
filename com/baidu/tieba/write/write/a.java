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
/* loaded from: classes2.dex */
public class a extends BaseAdapter {
    private ArrayList<MetaData> dQf;
    private TbCheckBox.a jeU;
    private final Context mContext;
    private AtListActivity msE;
    private boolean msG;
    private b msF = null;
    private ViewGroup mParent = null;

    /* loaded from: classes2.dex */
    public interface b {
        void a(View view, MetaData metaData);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b bVar) {
        this.msF = bVar;
    }

    public a(AtListActivity atListActivity, boolean z) {
        this.msG = true;
        this.msE = atListActivity;
        this.mContext = this.msE.getPageContext().getContext();
        this.msG = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setData(ArrayList<MetaData> arrayList) {
        this.dQf = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(TbCheckBox.a aVar) {
        this.jeU = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.dQf == null) {
            return 0;
        }
        return this.dQf.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: GS */
    public MetaData getItem(int i) {
        if (this.dQf != null && i < this.dQf.size()) {
            return this.dQf.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0778a c0778a;
        if (this.mParent == null) {
            this.mParent = viewGroup;
        }
        MetaData item = getItem(i);
        if (item != null) {
            c0778a = a(view != null ? view.getTag() : null, item);
        } else {
            c0778a = null;
        }
        if (c0778a != null) {
            return c0778a.rootView;
        }
        return null;
    }

    private C0778a a(Object obj, MetaData metaData) {
        C0778a c0778a;
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (obj == null) {
            c0778a = dsA();
        } else {
            c0778a = (C0778a) obj;
        }
        if (this.msF != null) {
            this.msF.a(c0778a.rootView, metaData);
        }
        String avater = metaData.getAvater();
        c0778a.gzP.setText(metaData.getName_show());
        c0778a.jeX.setTagData(metaData);
        c0778a.jeB.setTag(avater);
        if (this.msG) {
            c0778a.jeX.setVisibility(0);
        } else {
            c0778a.jeX.setVisibility(8);
        }
        c0778a.jeB.startLoad(avater, 12, false);
        this.msE.getPageContext().getLayoutMode().setNightMode(skinType == 1);
        this.msE.getPageContext().getLayoutMode().onModeChanged(c0778a.rootView);
        return c0778a;
    }

    private C0778a dsA() {
        C0778a c0778a = new C0778a();
        c0778a.rootView = LayoutInflater.from(this.mContext).inflate(R.layout.invite_friend_list_item, (ViewGroup) null);
        c0778a.jeB = (HeadImageView) c0778a.rootView.findViewById(R.id.photo);
        c0778a.jeB.setIsRound(false);
        c0778a.gzP = (TextView) c0778a.rootView.findViewById(R.id.txt_user_name);
        c0778a.jeX = (TbCheckBox) c0778a.rootView.findViewById(R.id.ckb_select);
        if (this.jeU != null) {
            c0778a.jeX.setStatedChangedListener(this.jeU);
        }
        c0778a.rootView.setTag(c0778a);
        return c0778a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.write.write.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0778a {
        public TextView gzP;
        public HeadImageView jeB;
        public TbCheckBox jeX;
        public View rootView;

        private C0778a() {
        }
    }
}
