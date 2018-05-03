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
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    private ArrayList<MetaData> adv;
    private TbCheckBox.a elf;
    private AtListActivity hfL;
    private boolean hfN;
    private final Context mContext;
    private b hfM = null;
    private ViewGroup bHg = null;

    /* loaded from: classes3.dex */
    public interface b {
        void a(View view2, MetaData metaData);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b bVar) {
        this.hfM = bVar;
    }

    public a(AtListActivity atListActivity, boolean z) {
        this.hfN = true;
        this.hfL = atListActivity;
        this.mContext = this.hfL.getPageContext().getContext();
        this.hfN = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setData(ArrayList<MetaData> arrayList) {
        this.adv = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(TbCheckBox.a aVar) {
        this.elf = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.adv == null) {
            return 0;
        }
        return this.adv.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: vf */
    public MetaData getItem(int i) {
        if (this.adv != null && i < this.adv.size()) {
            return this.adv.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        C0242a c0242a;
        if (this.bHg == null) {
            this.bHg = viewGroup;
        }
        MetaData item = getItem(i);
        if (item != null) {
            c0242a = a(view2 != null ? view2.getTag() : null, item);
        } else {
            c0242a = null;
        }
        if (c0242a != null) {
            return c0242a.rootView;
        }
        return null;
    }

    private C0242a a(Object obj, MetaData metaData) {
        C0242a c0242a;
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (obj == null) {
            c0242a = bCO();
        } else {
            c0242a = (C0242a) obj;
        }
        if (this.hfM != null) {
            this.hfM.a(c0242a.rootView, metaData);
        }
        String portrait = metaData.getPortrait();
        c0242a.bGo.setText(metaData.getName_show());
        c0242a.eli.setTagData(metaData);
        c0242a.ekO.setTag(portrait);
        if (this.hfN) {
            c0242a.eli.setVisibility(0);
        } else {
            c0242a.eli.setVisibility(8);
        }
        c0242a.ekO.startLoad(portrait, 12, false);
        this.hfL.getPageContext().getLayoutMode().setNightMode(skinType == 1);
        this.hfL.getPageContext().getLayoutMode().u(c0242a.rootView);
        return c0242a;
    }

    private C0242a bCO() {
        C0242a c0242a = new C0242a();
        c0242a.rootView = LayoutInflater.from(this.mContext).inflate(d.i.invite_friend_list_item, (ViewGroup) null);
        c0242a.ekO = (HeadImageView) c0242a.rootView.findViewById(d.g.photo);
        c0242a.ekO.setIsRound(false);
        c0242a.bGo = (TextView) c0242a.rootView.findViewById(d.g.txt_user_name);
        c0242a.eli = (TbCheckBox) c0242a.rootView.findViewById(d.g.ckb_select);
        if (this.elf != null) {
            c0242a.eli.setStatedChangedListener(this.elf);
        }
        c0242a.rootView.setTag(c0242a);
        return c0242a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.write.write.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0242a {
        public TextView bGo;
        public HeadImageView ekO;
        public TbCheckBox eli;
        public View rootView;

        private C0242a() {
        }
    }
}
