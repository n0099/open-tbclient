package com.baidu.tieba.imMessageCenter.im.friend;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tieba.i;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o extends BaseAdapter {
    private final TbPageContextSupport awn;
    private b bNg = null;
    private ViewGroup bNh = null;
    private boolean bNi;
    private TbCheckBox.a mCheckBoxStateChangedListener;
    private List<com.baidu.tbadk.coreExtra.relationship.a> mData;

    /* loaded from: classes.dex */
    public interface b {
        void a(View view, com.baidu.tbadk.coreExtra.relationship.a aVar);
    }

    public o(TbPageContextSupport tbPageContextSupport, boolean z) {
        this.awn = tbPageContextSupport;
        this.bNi = z;
    }

    public void a(b bVar) {
        this.bNg = bVar;
    }

    public void setData(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.mData = list;
    }

    public void setCheckBoxStateChangedListener(TbCheckBox.a aVar) {
        this.mCheckBoxStateChangedListener = aVar;
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
        if (this.bNh == null) {
            this.bNh = viewGroup;
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
            aVar2 = Zp();
        } else {
            aVar2 = (a) obj;
        }
        if (this.bNg != null) {
            this.bNg.a(aVar2.rootView, aVar);
        }
        a(aVar, aVar2, aVar.getUserPortrait());
        aVar2.aHN.setText(aVar.getUserName());
        if (this.bNi) {
            aVar2.bNj.setVisibility(8);
        } else {
            aVar2.bNj.setTagData(aVar);
        }
        if (this.awn instanceof InviteFriendListActivity) {
            ((InviteFriendListActivity) this.awn).getLayoutMode().k(aVar2.rootView);
        }
        return aVar2;
    }

    private void a(com.baidu.tbadk.coreExtra.relationship.a aVar, a aVar2, String str) {
        if (aVar != null) {
            aVar2.bMN.setTag(str);
            aVar2.bMN.d(str, 12, false);
        }
    }

    private a Zp() {
        a aVar = new a();
        aVar.rootView = LayoutInflater.from(this.awn.getPageContext().getContext()).inflate(i.g.invite_friend_list_item, (ViewGroup) null);
        aVar.bMN = (HeadImageView) aVar.rootView.findViewById(i.f.photo);
        aVar.bMN.setIsRound(false);
        aVar.aHN = (TextView) aVar.rootView.findViewById(i.f.txt_user_name);
        aVar.bNj = (TbCheckBox) aVar.rootView.findViewById(i.f.ckb_select);
        if (this.mCheckBoxStateChangedListener != null) {
            aVar.bNj.setStatedChangedListener(this.mCheckBoxStateChangedListener);
        }
        aVar.rootView.setTag(aVar);
        return aVar;
    }

    /* loaded from: classes.dex */
    public class a {
        public TextView aHN;
        public HeadImageView bMN;
        public TbCheckBox bNj;
        public View rootView;

        public a() {
        }
    }
}
