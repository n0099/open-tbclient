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
    private final TbPageContextSupport aTe;
    private TbCheckBox.a eBu;
    private boolean eBw;
    private List<com.baidu.tbadk.coreExtra.relationship.a> mData;
    private b eBv = null;
    private ViewGroup mParent = null;

    /* loaded from: classes2.dex */
    public interface b {
        void a(View view, com.baidu.tbadk.coreExtra.relationship.a aVar);
    }

    public c(TbPageContextSupport tbPageContextSupport, boolean z) {
        this.aTe = tbPageContextSupport;
        this.eBw = z;
    }

    public void a(b bVar) {
        this.eBv = bVar;
    }

    public void setData(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.mData = list;
    }

    public void a(TbCheckBox.a aVar) {
        this.eBu = aVar;
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
            aVar2 = aNq();
        } else {
            aVar2 = (a) obj;
        }
        if (this.eBv != null) {
            this.eBv.a(aVar2.rootView, aVar);
        }
        a(aVar, aVar2, aVar.Fy());
        aVar2.bRW.setText(aVar.FA());
        if (this.eBw) {
            aVar2.eBx.setVisibility(8);
        } else {
            aVar2.eBx.setTagData(aVar);
        }
        if (this.aTe instanceof InviteFriendListActivity) {
            ((InviteFriendListActivity) this.aTe).getLayoutMode().onModeChanged(aVar2.rootView);
        }
        return aVar2;
    }

    private void a(com.baidu.tbadk.coreExtra.relationship.a aVar, a aVar2, String str) {
        if (aVar != null) {
            aVar2.eBd.setTag(str);
            aVar2.eBd.startLoad(str, 12, false);
        }
    }

    private a aNq() {
        a aVar = new a();
        aVar.rootView = LayoutInflater.from(this.aTe.getPageContext().getContext()).inflate(d.i.invite_friend_list_item, (ViewGroup) null);
        aVar.eBd = (HeadImageView) aVar.rootView.findViewById(d.g.photo);
        aVar.eBd.setIsRound(false);
        aVar.bRW = (TextView) aVar.rootView.findViewById(d.g.txt_user_name);
        aVar.eBx = (TbCheckBox) aVar.rootView.findViewById(d.g.ckb_select);
        if (this.eBu != null) {
            aVar.eBx.setStatedChangedListener(this.eBu);
        }
        aVar.rootView.setTag(aVar);
        return aVar;
    }

    /* loaded from: classes2.dex */
    public class a {
        public TextView bRW;
        public HeadImageView eBd;
        public TbCheckBox eBx;
        public View rootView;

        public a() {
        }
    }
}
