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
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class a extends BaseAdapter {
    private ArrayList<MetaData> abO;
    private TbCheckBox.a dLQ;
    private AtListActivity gGx;
    private boolean gGz;
    private final Context mContext;
    private b gGy = null;
    private ViewGroup boD = null;

    /* loaded from: classes2.dex */
    public interface b {
        void a(View view, MetaData metaData);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b bVar) {
        this.gGy = bVar;
    }

    public a(AtListActivity atListActivity, boolean z) {
        this.gGz = true;
        this.gGx = atListActivity;
        this.mContext = this.gGx.getPageContext().getContext();
        this.gGz = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setData(ArrayList<MetaData> arrayList) {
        this.abO = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(TbCheckBox.a aVar) {
        this.dLQ = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.abO == null) {
            return 0;
        }
        return this.abO.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: uN */
    public MetaData getItem(int i) {
        if (this.abO != null && i < this.abO.size()) {
            return this.abO.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0131a c0131a;
        if (this.boD == null) {
            this.boD = viewGroup;
        }
        MetaData item = getItem(i);
        if (item != null) {
            c0131a = a(view != null ? view.getTag() : null, item);
        } else {
            c0131a = null;
        }
        if (c0131a != null) {
            return c0131a.rootView;
        }
        return null;
    }

    private C0131a a(Object obj, MetaData metaData) {
        C0131a c0131a;
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (obj == null) {
            c0131a = bzH();
        } else {
            c0131a = (C0131a) obj;
        }
        if (this.gGy != null) {
            this.gGy.a(c0131a.rootView, metaData);
        }
        String portrait = metaData.getPortrait();
        c0131a.bFC.setText(metaData.getName_show());
        c0131a.dLT.setTagData(metaData);
        c0131a.dLA.setTag(portrait);
        if (this.gGz) {
            c0131a.dLT.setVisibility(0);
        } else {
            c0131a.dLT.setVisibility(8);
        }
        c0131a.dLA.c(portrait, 12, false);
        this.gGx.getPageContext().getLayoutMode().ah(skinType == 1);
        this.gGx.getPageContext().getLayoutMode().t(c0131a.rootView);
        return c0131a;
    }

    private C0131a bzH() {
        C0131a c0131a = new C0131a();
        c0131a.rootView = LayoutInflater.from(this.mContext).inflate(d.j.invite_friend_list_item, (ViewGroup) null);
        c0131a.dLA = (HeadImageView) c0131a.rootView.findViewById(d.h.photo);
        c0131a.dLA.setIsRound(false);
        c0131a.bFC = (TextView) c0131a.rootView.findViewById(d.h.txt_user_name);
        c0131a.dLT = (TbCheckBox) c0131a.rootView.findViewById(d.h.ckb_select);
        if (this.dLQ != null) {
            c0131a.dLT.setStatedChangedListener(this.dLQ);
        }
        c0131a.rootView.setTag(c0131a);
        return c0131a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.write.write.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0131a {
        public TextView bFC;
        public HeadImageView dLA;
        public TbCheckBox dLT;
        public View rootView;

        private C0131a() {
        }
    }
}
