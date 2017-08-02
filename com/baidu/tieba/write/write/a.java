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
/* loaded from: classes.dex */
public class a extends BaseAdapter {
    private ArrayList<MetaData> abi;
    private TbCheckBox.a dBd;
    private AtListActivity gDW;
    private boolean gDY;
    private final Context mContext;
    private b gDX = null;
    private ViewGroup dBf = null;

    /* loaded from: classes.dex */
    public interface b {
        void a(View view, MetaData metaData);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b bVar) {
        this.gDX = bVar;
    }

    public a(AtListActivity atListActivity, boolean z) {
        this.gDY = true;
        this.gDW = atListActivity;
        this.mContext = this.gDW.getPageContext().getContext();
        this.gDY = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setData(ArrayList<MetaData> arrayList) {
        this.abi = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(TbCheckBox.a aVar) {
        this.dBd = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.abi == null) {
            return 0;
        }
        return this.abi.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: uB */
    public MetaData getItem(int i) {
        if (this.abi != null && i < this.abi.size()) {
            return this.abi.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0129a c0129a;
        if (this.dBf == null) {
            this.dBf = viewGroup;
        }
        MetaData item = getItem(i);
        if (item != null) {
            c0129a = a(view != null ? view.getTag() : null, item);
        } else {
            c0129a = null;
        }
        if (c0129a != null) {
            return c0129a.rootView;
        }
        return null;
    }

    private C0129a a(Object obj, MetaData metaData) {
        C0129a c0129a;
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (obj == null) {
            c0129a = bzA();
        } else {
            c0129a = (C0129a) obj;
        }
        if (this.gDX != null) {
            this.gDX.a(c0129a.rootView, metaData);
        }
        String portrait = metaData.getPortrait();
        c0129a.bFh.setText(metaData.getName_show());
        c0129a.dBh.setTagData(metaData);
        c0129a.dAN.setTag(portrait);
        if (this.gDY) {
            c0129a.dBh.setVisibility(0);
        } else {
            c0129a.dBh.setVisibility(8);
        }
        c0129a.dAN.c(portrait, 12, false);
        this.gDW.getPageContext().getLayoutMode().ah(skinType == 1);
        this.gDW.getPageContext().getLayoutMode().t(c0129a.rootView);
        return c0129a;
    }

    private C0129a bzA() {
        C0129a c0129a = new C0129a();
        c0129a.rootView = LayoutInflater.from(this.mContext).inflate(d.j.invite_friend_list_item, (ViewGroup) null);
        c0129a.dAN = (HeadImageView) c0129a.rootView.findViewById(d.h.photo);
        c0129a.dAN.setIsRound(false);
        c0129a.bFh = (TextView) c0129a.rootView.findViewById(d.h.txt_user_name);
        c0129a.dBh = (TbCheckBox) c0129a.rootView.findViewById(d.h.ckb_select);
        if (this.dBd != null) {
            c0129a.dBh.setStatedChangedListener(this.dBd);
        }
        c0129a.rootView.setTag(c0129a);
        return c0129a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.write.write.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0129a {
        public TextView bFh;
        public HeadImageView dAN;
        public TbCheckBox dBh;
        public View rootView;

        private C0129a() {
        }
    }
}
