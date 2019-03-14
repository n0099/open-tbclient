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
/* loaded from: classes4.dex */
class c extends BaseAdapter {
    private final TbPageContextSupport cpE;
    private TbCheckBox.a gwb;
    private boolean gwd;
    private List<com.baidu.tbadk.coreExtra.relationship.a> mData;
    private b gwc = null;
    private ViewGroup mParent = null;

    /* loaded from: classes4.dex */
    public interface b {
        void a(View view, com.baidu.tbadk.coreExtra.relationship.a aVar);
    }

    public c(TbPageContextSupport tbPageContextSupport, boolean z) {
        this.cpE = tbPageContextSupport;
        this.gwd = z;
    }

    public void a(b bVar) {
        this.gwc = bVar;
    }

    public void setData(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.mData = list;
    }

    public void a(TbCheckBox.a aVar) {
        this.gwb = aVar;
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
            aVar2 = bwX();
        } else {
            aVar2 = (a) obj;
        }
        if (this.gwc != null) {
            this.gwc.a(aVar2.rootView, aVar);
        }
        a(aVar, aVar2, aVar.ajO());
        aVar2.dAX.setText(aVar.ajQ());
        if (this.gwd) {
            aVar2.gwe.setVisibility(8);
        } else {
            aVar2.gwe.setTagData(aVar);
        }
        if (this.cpE instanceof InviteFriendListActivity) {
            ((InviteFriendListActivity) this.cpE).getLayoutMode().onModeChanged(aVar2.rootView);
        }
        return aVar2;
    }

    private void a(com.baidu.tbadk.coreExtra.relationship.a aVar, a aVar2, String str) {
        if (aVar != null) {
            aVar2.gvJ.setTag(str);
            aVar2.gvJ.startLoad(str, 12, false);
        }
    }

    private a bwX() {
        a aVar = new a();
        aVar.rootView = LayoutInflater.from(this.cpE.getPageContext().getContext()).inflate(d.h.invite_friend_list_item, (ViewGroup) null);
        aVar.gvJ = (HeadImageView) aVar.rootView.findViewById(d.g.photo);
        aVar.gvJ.setIsRound(false);
        aVar.dAX = (TextView) aVar.rootView.findViewById(d.g.txt_user_name);
        aVar.gwe = (TbCheckBox) aVar.rootView.findViewById(d.g.ckb_select);
        if (this.gwb != null) {
            aVar.gwe.setStatedChangedListener(this.gwb);
        }
        aVar.rootView.setTag(aVar);
        return aVar;
    }

    /* loaded from: classes4.dex */
    public class a {
        public TextView dAX;
        public HeadImageView gvJ;
        public TbCheckBox gwe;
        public View rootView;

        public a() {
        }
    }
}
