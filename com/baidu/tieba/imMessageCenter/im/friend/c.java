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
    private final TbPageContextSupport aJh;
    private TbCheckBox.a dYJ;
    private boolean dYL;
    private List<com.baidu.tbadk.coreExtra.relationship.a> mData;
    private b dYK = null;
    private ViewGroup byL = null;

    /* loaded from: classes2.dex */
    public interface b {
        void a(View view, com.baidu.tbadk.coreExtra.relationship.a aVar);
    }

    public c(TbPageContextSupport tbPageContextSupport, boolean z) {
        this.aJh = tbPageContextSupport;
        this.dYL = z;
    }

    public void a(b bVar) {
        this.dYK = bVar;
    }

    public void setData(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.mData = list;
    }

    public void a(TbCheckBox.a aVar) {
        this.dYJ = aVar;
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
        if (this.byL == null) {
            this.byL = viewGroup;
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
            aVar2 = aEj();
        } else {
            aVar2 = (a) obj;
        }
        if (this.dYK != null) {
            this.dYK.a(aVar2.rootView, aVar);
        }
        a(aVar, aVar2, aVar.AQ());
        aVar2.bWF.setText(aVar.getUserName());
        if (this.dYL) {
            aVar2.dYM.setVisibility(8);
        } else {
            aVar2.dYM.setTagData(aVar);
        }
        if (this.aJh instanceof InviteFriendListActivity) {
            ((InviteFriendListActivity) this.aJh).getLayoutMode().t(aVar2.rootView);
        }
        return aVar2;
    }

    private void a(com.baidu.tbadk.coreExtra.relationship.a aVar, a aVar2, String str) {
        if (aVar != null) {
            aVar2.dYs.setTag(str);
            aVar2.dYs.startLoad(str, 12, false);
        }
    }

    private a aEj() {
        a aVar = new a();
        aVar.rootView = LayoutInflater.from(this.aJh.getPageContext().getContext()).inflate(d.h.invite_friend_list_item, (ViewGroup) null);
        aVar.dYs = (HeadImageView) aVar.rootView.findViewById(d.g.photo);
        aVar.dYs.setIsRound(false);
        aVar.bWF = (TextView) aVar.rootView.findViewById(d.g.txt_user_name);
        aVar.dYM = (TbCheckBox) aVar.rootView.findViewById(d.g.ckb_select);
        if (this.dYJ != null) {
            aVar.dYM.setStatedChangedListener(this.dYJ);
        }
        aVar.rootView.setTag(aVar);
        return aVar;
    }

    /* loaded from: classes2.dex */
    public class a {
        public TextView bWF;
        public TbCheckBox dYM;
        public HeadImageView dYs;
        public View rootView;

        public a() {
        }
    }
}
