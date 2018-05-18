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
    private final TbPageContextSupport aJH;
    private TbCheckBox.a emm;
    private boolean emo;
    private List<com.baidu.tbadk.coreExtra.relationship.a> mData;
    private b emn = null;
    private ViewGroup bIv = null;

    /* loaded from: classes2.dex */
    public interface b {
        void a(View view2, com.baidu.tbadk.coreExtra.relationship.a aVar);
    }

    public c(TbPageContextSupport tbPageContextSupport, boolean z) {
        this.aJH = tbPageContextSupport;
        this.emo = z;
    }

    public void a(b bVar) {
        this.emn = bVar;
    }

    public void setData(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.mData = list;
    }

    public void a(TbCheckBox.a aVar) {
        this.emm = aVar;
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
    public View getView(int i, View view2, ViewGroup viewGroup) {
        a aVar;
        if (this.bIv == null) {
            this.bIv = viewGroup;
        }
        com.baidu.tbadk.coreExtra.relationship.a aVar2 = (com.baidu.tbadk.coreExtra.relationship.a) getItem(i);
        if (aVar2 != null) {
            aVar = a(view2 != null ? view2.getTag() : null, aVar2);
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
            aVar2 = aHP();
        } else {
            aVar2 = (a) obj;
        }
        if (this.emn != null) {
            this.emn.a(aVar2.rootView, aVar);
        }
        a(aVar, aVar2, aVar.BF());
        aVar2.bHL.setText(aVar.getUserName());
        if (this.emo) {
            aVar2.emp.setVisibility(8);
        } else {
            aVar2.emp.setTagData(aVar);
        }
        if (this.aJH instanceof InviteFriendListActivity) {
            ((InviteFriendListActivity) this.aJH).getLayoutMode().u(aVar2.rootView);
        }
        return aVar2;
    }

    private void a(com.baidu.tbadk.coreExtra.relationship.a aVar, a aVar2, String str) {
        if (aVar != null) {
            aVar2.elV.setTag(str);
            aVar2.elV.startLoad(str, 12, false);
        }
    }

    private a aHP() {
        a aVar = new a();
        aVar.rootView = LayoutInflater.from(this.aJH.getPageContext().getContext()).inflate(d.i.invite_friend_list_item, (ViewGroup) null);
        aVar.elV = (HeadImageView) aVar.rootView.findViewById(d.g.photo);
        aVar.elV.setIsRound(false);
        aVar.bHL = (TextView) aVar.rootView.findViewById(d.g.txt_user_name);
        aVar.emp = (TbCheckBox) aVar.rootView.findViewById(d.g.ckb_select);
        if (this.emm != null) {
            aVar.emp.setStatedChangedListener(this.emm);
        }
        aVar.rootView.setTag(aVar);
        return aVar;
    }

    /* loaded from: classes2.dex */
    public class a {
        public TextView bHL;
        public HeadImageView elV;
        public TbCheckBox emp;
        public View rootView;

        public a() {
        }
    }
}
