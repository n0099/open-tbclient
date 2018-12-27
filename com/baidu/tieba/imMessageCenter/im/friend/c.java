package com.baidu.tieba.imMessageCenter.im.friend;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tieba.e;
import java.util.List;
/* loaded from: classes4.dex */
class c extends BaseAdapter {
    private final TbPageContextSupport bfj;
    private TbCheckBox.a ffh;
    private boolean ffj;
    private List<com.baidu.tbadk.coreExtra.relationship.a> mData;
    private b ffi = null;
    private ViewGroup mParent = null;

    /* loaded from: classes4.dex */
    public interface b {
        void a(View view, com.baidu.tbadk.coreExtra.relationship.a aVar);
    }

    public c(TbPageContextSupport tbPageContextSupport, boolean z) {
        this.bfj = tbPageContextSupport;
        this.ffj = z;
    }

    public void a(b bVar) {
        this.ffi = bVar;
    }

    public void setData(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.mData = list;
    }

    public void a(TbCheckBox.a aVar) {
        this.ffh = aVar;
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
        if (this.mParent == null) {
            this.mParent = viewGroup;
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
            aVar2 = aVS();
        } else {
            aVar2 = (a) obj;
        }
        if (this.ffi != null) {
            this.ffi.a(aVar2.rootView, aVar);
        }
        a(aVar, aVar2, aVar.Kc());
        aVar2.clo.setText(aVar.Ke());
        if (this.ffj) {
            aVar2.ffk.setVisibility(8);
        } else {
            aVar2.ffk.setTagData(aVar);
        }
        if (this.bfj instanceof InviteFriendListActivity) {
            ((InviteFriendListActivity) this.bfj).getLayoutMode().onModeChanged(aVar2.rootView);
        }
        return aVar2;
    }

    private void a(com.baidu.tbadk.coreExtra.relationship.a aVar, a aVar2, String str) {
        if (aVar != null) {
            aVar2.feP.setTag(str);
            aVar2.feP.startLoad(str, 12, false);
        }
    }

    private a aVS() {
        a aVar = new a();
        aVar.rootView = LayoutInflater.from(this.bfj.getPageContext().getContext()).inflate(e.h.invite_friend_list_item, (ViewGroup) null);
        aVar.feP = (HeadImageView) aVar.rootView.findViewById(e.g.photo);
        aVar.feP.setIsRound(false);
        aVar.clo = (TextView) aVar.rootView.findViewById(e.g.txt_user_name);
        aVar.ffk = (TbCheckBox) aVar.rootView.findViewById(e.g.ckb_select);
        if (this.ffh != null) {
            aVar.ffk.setStatedChangedListener(this.ffh);
        }
        aVar.rootView.setTag(aVar);
        return aVar;
    }

    /* loaded from: classes4.dex */
    public class a {
        public TextView clo;
        public HeadImageView feP;
        public TbCheckBox ffk;
        public View rootView;

        public a() {
        }
    }
}
