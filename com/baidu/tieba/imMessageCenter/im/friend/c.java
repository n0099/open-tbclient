package com.baidu.tieba.imMessageCenter.im.friend;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes2.dex */
class c extends BaseAdapter {
    private final TbPageContextSupport aHH;
    private TbCheckBox.a dHS;
    private boolean dHU;
    private List<com.baidu.tbadk.coreExtra.relationship.a> mData;
    private b dHT = null;
    private ViewGroup bqb = null;

    /* loaded from: classes2.dex */
    public interface b {
        void a(View view, com.baidu.tbadk.coreExtra.relationship.a aVar);
    }

    public c(TbPageContextSupport tbPageContextSupport, boolean z) {
        this.aHH = tbPageContextSupport;
        this.dHU = z;
    }

    public void a(b bVar) {
        this.dHT = bVar;
    }

    public void setData(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.mData = list;
    }

    public void a(TbCheckBox.a aVar) {
        this.dHS = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.mData == null) {
            return 0;
        }
        return this.mData.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.mData == null) {
            return null;
        }
        return this.mData.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (this.bqb == null) {
            this.bqb = viewGroup;
        }
        com.baidu.tbadk.coreExtra.relationship.a aVar2 = (com.baidu.tbadk.coreExtra.relationship.a) getItem(i);
        if (aVar2 != null) {
            aVar = a(view != null ? view.getTag() : null, aVar2);
        } else {
            aVar = null;
        }
        if (aVar != null) {
            return aVar.rootView;
        }
        return null;
    }

    private a a(Object obj, com.baidu.tbadk.coreExtra.relationship.a aVar) {
        a aVar2;
        if (obj == null) {
            aVar2 = aAb();
        } else {
            aVar2 = (a) obj;
        }
        if (this.dHT != null) {
            this.dHT.a(aVar2.rootView, aVar);
        }
        a(aVar, aVar2, aVar.Ak());
        aVar2.bHb.setText(aVar.getUserName());
        if (this.dHU) {
            aVar2.dHV.setVisibility(8);
        } else {
            aVar2.dHV.setTagData(aVar);
        }
        if (this.aHH instanceof InviteFriendListActivity) {
            ((InviteFriendListActivity) this.aHH).getLayoutMode().t(aVar2.rootView);
        }
        return aVar2;
    }

    private void a(com.baidu.tbadk.coreExtra.relationship.a aVar, a aVar2, String str) {
        if (aVar != null) {
            aVar2.dHB.setTag(str);
            aVar2.dHB.c(str, 12, false);
        }
    }

    private a aAb() {
        a aVar = new a();
        aVar.rootView = LayoutInflater.from(this.aHH.getPageContext().getContext()).inflate(d.j.invite_friend_list_item, (ViewGroup) null);
        aVar.dHB = (HeadImageView) aVar.rootView.findViewById(d.h.photo);
        aVar.dHB.setIsRound(false);
        aVar.bHb = (TextView) aVar.rootView.findViewById(d.h.txt_user_name);
        aVar.dHV = (TbCheckBox) aVar.rootView.findViewById(d.h.ckb_select);
        if (this.dHS != null) {
            aVar.dHV.setStatedChangedListener(this.dHS);
        }
        aVar.rootView.setTag(aVar);
        return aVar;
    }

    /* loaded from: classes2.dex */
    public class a {
        public TextView bHb;
        public HeadImageView dHB;
        public TbCheckBox dHV;
        public View rootView;

        public a() {
        }
    }
}
