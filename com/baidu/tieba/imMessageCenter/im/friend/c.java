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
    private final TbPageContextSupport aIw;
    private TbCheckBox.a dKV;
    private b dKW = null;
    private ViewGroup dKX = null;
    private boolean dKY;
    private List<com.baidu.tbadk.coreExtra.relationship.a> mData;

    /* loaded from: classes2.dex */
    public interface b {
        void a(View view, com.baidu.tbadk.coreExtra.relationship.a aVar);
    }

    public c(TbPageContextSupport tbPageContextSupport, boolean z) {
        this.aIw = tbPageContextSupport;
        this.dKY = z;
    }

    public void a(b bVar) {
        this.dKW = bVar;
    }

    public void setData(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.mData = list;
    }

    public void a(TbCheckBox.a aVar) {
        this.dKV = aVar;
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
        if (this.dKX == null) {
            this.dKX = viewGroup;
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
            aVar2 = aBk();
        } else {
            aVar2 = (a) obj;
        }
        if (this.dKW != null) {
            this.dKW.a(aVar2.rootView, aVar);
        }
        a(aVar, aVar2, aVar.AS());
        aVar2.bEL.setText(aVar.getUserName());
        if (this.dKY) {
            aVar2.dKZ.setVisibility(8);
        } else {
            aVar2.dKZ.setTagData(aVar);
        }
        if (this.aIw instanceof InviteFriendListActivity) {
            ((InviteFriendListActivity) this.aIw).getLayoutMode().t(aVar2.rootView);
        }
        return aVar2;
    }

    private void a(com.baidu.tbadk.coreExtra.relationship.a aVar, a aVar2, String str) {
        if (aVar != null) {
            aVar2.dKF.setTag(str);
            aVar2.dKF.c(str, 12, false);
        }
    }

    private a aBk() {
        a aVar = new a();
        aVar.rootView = LayoutInflater.from(this.aIw.getPageContext().getContext()).inflate(d.j.invite_friend_list_item, (ViewGroup) null);
        aVar.dKF = (HeadImageView) aVar.rootView.findViewById(d.h.photo);
        aVar.dKF.setIsRound(false);
        aVar.bEL = (TextView) aVar.rootView.findViewById(d.h.txt_user_name);
        aVar.dKZ = (TbCheckBox) aVar.rootView.findViewById(d.h.ckb_select);
        if (this.dKV != null) {
            aVar.dKZ.setStatedChangedListener(this.dKV);
        }
        aVar.rootView.setTag(aVar);
        return aVar;
    }

    /* loaded from: classes2.dex */
    public class a {
        public TextView bEL;
        public HeadImageView dKF;
        public TbCheckBox dKZ;
        public View rootView;

        public a() {
        }
    }
}
