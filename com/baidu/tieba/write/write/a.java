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
    private AtListActivity msB;
    private boolean msD;
    private b msC = null;
    private ViewGroup mParent = null;

    /* loaded from: classes2.dex */
    public interface b {
        void a(View view, MetaData metaData);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b bVar) {
        this.msC = bVar;
    }

    public a(AtListActivity atListActivity, boolean z) {
        this.msD = true;
        this.msB = atListActivity;
        this.mContext = this.msB.getPageContext().getContext();
        this.msD = z;
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
        C0777a c0777a;
        if (this.mParent == null) {
            this.mParent = viewGroup;
        }
        MetaData item = getItem(i);
        if (item != null) {
            c0777a = a(view != null ? view.getTag() : null, item);
        } else {
            c0777a = null;
        }
        if (c0777a != null) {
            return c0777a.rootView;
        }
        return null;
    }

    private C0777a a(Object obj, MetaData metaData) {
        C0777a c0777a;
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (obj == null) {
            c0777a = dsw();
        } else {
            c0777a = (C0777a) obj;
        }
        if (this.msC != null) {
            this.msC.a(c0777a.rootView, metaData);
        }
        String avater = metaData.getAvater();
        c0777a.gzP.setText(metaData.getName_show());
        c0777a.jeX.setTagData(metaData);
        c0777a.jeB.setTag(avater);
        if (this.msD) {
            c0777a.jeX.setVisibility(0);
        } else {
            c0777a.jeX.setVisibility(8);
        }
        c0777a.jeB.startLoad(avater, 12, false);
        this.msB.getPageContext().getLayoutMode().setNightMode(skinType == 1);
        this.msB.getPageContext().getLayoutMode().onModeChanged(c0777a.rootView);
        return c0777a;
    }

    private C0777a dsw() {
        C0777a c0777a = new C0777a();
        c0777a.rootView = LayoutInflater.from(this.mContext).inflate(R.layout.invite_friend_list_item, (ViewGroup) null);
        c0777a.jeB = (HeadImageView) c0777a.rootView.findViewById(R.id.photo);
        c0777a.jeB.setIsRound(false);
        c0777a.gzP = (TextView) c0777a.rootView.findViewById(R.id.txt_user_name);
        c0777a.jeX = (TbCheckBox) c0777a.rootView.findViewById(R.id.ckb_select);
        if (this.jeU != null) {
            c0777a.jeX.setStatedChangedListener(this.jeU);
        }
        c0777a.rootView.setTag(c0777a);
        return c0777a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.write.write.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0777a {
        public TextView gzP;
        public HeadImageView jeB;
        public TbCheckBox jeX;
        public View rootView;

        private C0777a() {
        }
    }
}
