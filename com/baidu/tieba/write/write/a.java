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
/* loaded from: classes13.dex */
public class a extends BaseAdapter {
    private ArrayList<MetaData> cWf;
    private TbCheckBox.a hOB;
    private AtListActivity kTr;
    private boolean kTt;
    private final Context mContext;
    private b kTs = null;
    private ViewGroup mParent = null;

    /* loaded from: classes13.dex */
    public interface b {
        void a(View view, MetaData metaData);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b bVar) {
        this.kTs = bVar;
    }

    public a(AtListActivity atListActivity, boolean z) {
        this.kTt = true;
        this.kTr = atListActivity;
        this.mContext = this.kTr.getPageContext().getContext();
        this.kTt = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setData(ArrayList<MetaData> arrayList) {
        this.cWf = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(TbCheckBox.a aVar) {
        this.hOB = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.cWf == null) {
            return 0;
        }
        return this.cWf.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: Ex */
    public MetaData getItem(int i) {
        if (this.cWf != null && i < this.cWf.size()) {
            return this.cWf.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0641a c0641a;
        if (this.mParent == null) {
            this.mParent = viewGroup;
        }
        MetaData item = getItem(i);
        if (item != null) {
            c0641a = a(view != null ? view.getTag() : null, item);
        } else {
            c0641a = null;
        }
        if (c0641a != null) {
            return c0641a.rootView;
        }
        return null;
    }

    private C0641a a(Object obj, MetaData metaData) {
        C0641a c0641a;
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (obj == null) {
            c0641a = cVW();
        } else {
            c0641a = (C0641a) obj;
        }
        if (this.kTs != null) {
            this.kTs.a(c0641a.rootView, metaData);
        }
        String avater = metaData.getAvater();
        c0641a.ftz.setText(metaData.getName_show());
        c0641a.hOE.setTagData(metaData);
        c0641a.hOj.setTag(avater);
        if (this.kTt) {
            c0641a.hOE.setVisibility(0);
        } else {
            c0641a.hOE.setVisibility(8);
        }
        c0641a.hOj.startLoad(avater, 12, false);
        this.kTr.getPageContext().getLayoutMode().setNightMode(skinType == 1);
        this.kTr.getPageContext().getLayoutMode().onModeChanged(c0641a.rootView);
        return c0641a;
    }

    private C0641a cVW() {
        C0641a c0641a = new C0641a();
        c0641a.rootView = LayoutInflater.from(this.mContext).inflate(R.layout.invite_friend_list_item, (ViewGroup) null);
        c0641a.hOj = (HeadImageView) c0641a.rootView.findViewById(R.id.photo);
        c0641a.hOj.setIsRound(false);
        c0641a.ftz = (TextView) c0641a.rootView.findViewById(R.id.txt_user_name);
        c0641a.hOE = (TbCheckBox) c0641a.rootView.findViewById(R.id.ckb_select);
        if (this.hOB != null) {
            c0641a.hOE.setStatedChangedListener(this.hOB);
        }
        c0641a.rootView.setTag(c0641a);
        return c0641a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.write.write.a$a  reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public class C0641a {
        public TextView ftz;
        public TbCheckBox hOE;
        public HeadImageView hOj;
        public View rootView;

        private C0641a() {
        }
    }
}
