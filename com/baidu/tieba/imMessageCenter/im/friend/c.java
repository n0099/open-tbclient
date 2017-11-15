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
    private final TbPageContextSupport aIz;
    private TbCheckBox.a dPL;
    private boolean dPN;
    private List<com.baidu.tbadk.coreExtra.relationship.a> mData;
    private b dPM = null;
    private ViewGroup brZ = null;

    /* loaded from: classes2.dex */
    public interface b {
        void a(View view, com.baidu.tbadk.coreExtra.relationship.a aVar);
    }

    public c(TbPageContextSupport tbPageContextSupport, boolean z) {
        this.aIz = tbPageContextSupport;
        this.dPN = z;
    }

    public void a(b bVar) {
        this.dPM = bVar;
    }

    public void setData(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.mData = list;
    }

    public void a(TbCheckBox.a aVar) {
        this.dPL = aVar;
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
        if (this.brZ == null) {
            this.brZ = viewGroup;
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
            aVar2 = aCA();
        } else {
            aVar2 = (a) obj;
        }
        if (this.dPM != null) {
            this.dPM.a(aVar2.rootView, aVar);
        }
        a(aVar, aVar2, aVar.AF());
        aVar2.bOy.setText(aVar.getUserName());
        if (this.dPN) {
            aVar2.dPO.setVisibility(8);
        } else {
            aVar2.dPO.setTagData(aVar);
        }
        if (this.aIz instanceof InviteFriendListActivity) {
            ((InviteFriendListActivity) this.aIz).getLayoutMode().t(aVar2.rootView);
        }
        return aVar2;
    }

    private void a(com.baidu.tbadk.coreExtra.relationship.a aVar, a aVar2, String str) {
        if (aVar != null) {
            aVar2.dPu.setTag(str);
            aVar2.dPu.startLoad(str, 12, false);
        }
    }

    private a aCA() {
        a aVar = new a();
        aVar.rootView = LayoutInflater.from(this.aIz.getPageContext().getContext()).inflate(d.h.invite_friend_list_item, (ViewGroup) null);
        aVar.dPu = (HeadImageView) aVar.rootView.findViewById(d.g.photo);
        aVar.dPu.setIsRound(false);
        aVar.bOy = (TextView) aVar.rootView.findViewById(d.g.txt_user_name);
        aVar.dPO = (TbCheckBox) aVar.rootView.findViewById(d.g.ckb_select);
        if (this.dPL != null) {
            aVar.dPO.setStatedChangedListener(this.dPL);
        }
        aVar.rootView.setTag(aVar);
        return aVar;
    }

    /* loaded from: classes2.dex */
    public class a {
        public TextView bOy;
        public TbCheckBox dPO;
        public HeadImageView dPu;
        public View rootView;

        public a() {
        }
    }
}
