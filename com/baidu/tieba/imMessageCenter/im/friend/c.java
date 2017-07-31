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
    private final TbPageContextSupport aIQ;
    private TbCheckBox.a dCu;
    private b dCv = null;
    private ViewGroup dCw = null;
    private boolean dCx;
    private List<com.baidu.tbadk.coreExtra.relationship.a> mData;

    /* loaded from: classes2.dex */
    public interface b {
        void a(View view, com.baidu.tbadk.coreExtra.relationship.a aVar);
    }

    public c(TbPageContextSupport tbPageContextSupport, boolean z) {
        this.aIQ = tbPageContextSupport;
        this.dCx = z;
    }

    public void a(b bVar) {
        this.dCv = bVar;
    }

    public void setData(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.mData = list;
    }

    public void a(TbCheckBox.a aVar) {
        this.dCu = aVar;
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
        if (this.dCw == null) {
            this.dCw = viewGroup;
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
            aVar2 = ayT();
        } else {
            aVar2 = (a) obj;
        }
        if (this.dCv != null) {
            this.dCv.a(aVar2.rootView, aVar);
        }
        a(aVar, aVar2, aVar.AO());
        aVar2.bGr.setText(aVar.getUserName());
        if (this.dCx) {
            aVar2.dCy.setVisibility(8);
        } else {
            aVar2.dCy.setTagData(aVar);
        }
        if (this.aIQ instanceof InviteFriendListActivity) {
            ((InviteFriendListActivity) this.aIQ).getLayoutMode().t(aVar2.rootView);
        }
        return aVar2;
    }

    private void a(com.baidu.tbadk.coreExtra.relationship.a aVar, a aVar2, String str) {
        if (aVar != null) {
            aVar2.dCe.setTag(str);
            aVar2.dCe.c(str, 12, false);
        }
    }

    private a ayT() {
        a aVar = new a();
        aVar.rootView = LayoutInflater.from(this.aIQ.getPageContext().getContext()).inflate(d.j.invite_friend_list_item, (ViewGroup) null);
        aVar.dCe = (HeadImageView) aVar.rootView.findViewById(d.h.photo);
        aVar.dCe.setIsRound(false);
        aVar.bGr = (TextView) aVar.rootView.findViewById(d.h.txt_user_name);
        aVar.dCy = (TbCheckBox) aVar.rootView.findViewById(d.h.ckb_select);
        if (this.dCu != null) {
            aVar.dCy.setStatedChangedListener(this.dCu);
        }
        aVar.rootView.setTag(aVar);
        return aVar;
    }

    /* loaded from: classes2.dex */
    public class a {
        public TextView bGr;
        public HeadImageView dCe;
        public TbCheckBox dCy;
        public View rootView;

        public a() {
        }
    }
}
