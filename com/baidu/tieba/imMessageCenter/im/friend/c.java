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
    private final TbPageContextSupport aJe;
    private TbCheckBox.a dYF;
    private boolean dYH;
    private List<com.baidu.tbadk.coreExtra.relationship.a> mData;
    private b dYG = null;
    private ViewGroup byH = null;

    /* loaded from: classes2.dex */
    public interface b {
        void a(View view, com.baidu.tbadk.coreExtra.relationship.a aVar);
    }

    public c(TbPageContextSupport tbPageContextSupport, boolean z) {
        this.aJe = tbPageContextSupport;
        this.dYH = z;
    }

    public void a(b bVar) {
        this.dYG = bVar;
    }

    public void setData(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.mData = list;
    }

    public void a(TbCheckBox.a aVar) {
        this.dYF = aVar;
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
        if (this.byH == null) {
            this.byH = viewGroup;
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
            aVar2 = aEi();
        } else {
            aVar2 = (a) obj;
        }
        if (this.dYG != null) {
            this.dYG.a(aVar2.rootView, aVar);
        }
        a(aVar, aVar2, aVar.AQ());
        aVar2.bWB.setText(aVar.getUserName());
        if (this.dYH) {
            aVar2.dYI.setVisibility(8);
        } else {
            aVar2.dYI.setTagData(aVar);
        }
        if (this.aJe instanceof InviteFriendListActivity) {
            ((InviteFriendListActivity) this.aJe).getLayoutMode().t(aVar2.rootView);
        }
        return aVar2;
    }

    private void a(com.baidu.tbadk.coreExtra.relationship.a aVar, a aVar2, String str) {
        if (aVar != null) {
            aVar2.dYo.setTag(str);
            aVar2.dYo.startLoad(str, 12, false);
        }
    }

    private a aEi() {
        a aVar = new a();
        aVar.rootView = LayoutInflater.from(this.aJe.getPageContext().getContext()).inflate(d.h.invite_friend_list_item, (ViewGroup) null);
        aVar.dYo = (HeadImageView) aVar.rootView.findViewById(d.g.photo);
        aVar.dYo.setIsRound(false);
        aVar.bWB = (TextView) aVar.rootView.findViewById(d.g.txt_user_name);
        aVar.dYI = (TbCheckBox) aVar.rootView.findViewById(d.g.ckb_select);
        if (this.dYF != null) {
            aVar.dYI.setStatedChangedListener(this.dYF);
        }
        aVar.rootView.setTag(aVar);
        return aVar;
    }

    /* loaded from: classes2.dex */
    public class a {
        public TextView bWB;
        public TbCheckBox dYI;
        public HeadImageView dYo;
        public View rootView;

        public a() {
        }
    }
}
