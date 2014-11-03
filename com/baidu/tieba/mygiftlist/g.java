package com.baidu.tieba.mygiftlist;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.o;
import com.baidu.tbadk.core.view.p;
import com.baidu.tbadk.core.view.q;
import com.baidu.tbadk.core.view.r;
import com.baidu.tbadk.core.view.s;
import com.baidu.tbadk.widget.TbClipImageView;
import com.baidu.tieba.t;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
import java.util.List;
import tbclient.GetGiftMyList.GiftList;
/* loaded from: classes.dex */
public class g extends BaseAdapter {
    private o Yn;
    private List<GiftList> btq;
    private MyGiftListActivity btr;
    private boolean mIsHost;
    private int btp = 1;
    private boolean bts = false;
    private String btt = null;
    View.OnClickListener If = new h(this);

    public g(MyGiftListActivity myGiftListActivity, boolean z) {
        this.btr = myGiftListActivity;
        this.mIsHost = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bts) {
            return 1;
        }
        if (this.btq != null && this.btq.size() != 0) {
            return this.btq.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: gH */
    public GiftList getItem(int i) {
        if (this.bts) {
            return null;
        }
        int itemId = (int) getItemId(i);
        if (this.btq == null || this.btq.size() == 0 || itemId < 0 || itemId >= this.btq.size()) {
            return null;
        }
        return this.btq.get(itemId);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return this.btp;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        i iVar;
        if (this.bts) {
            return un();
        }
        if (view == null || view.getTag(v.tag_first) == null) {
            view = com.baidu.adp.lib.g.b.ek().a(this.btr, w.my_gift_list_item, viewGroup, false);
            i iVar2 = new i(this, null);
            iVar2.btv = (HeadImageView) view.findViewById(v.item_portrait);
            iVar2.btv.setOnClickListener(this.If);
            iVar2.bnF = (TextView) view.findViewById(v.user_name);
            iVar2.bty = (TextView) view.findViewById(v.gift_num);
            iVar2.btx = (TbClipImageView) view.findViewById(v.gift_icon);
            iVar2.btw = (TextView) view.findViewById(v.gift_name);
            iVar2.auq = (TextView) view.findViewById(v.time);
            iVar2.btz = (ImageView) view.findViewById(v.paly_icon);
            view.setTag(v.tag_first, iVar2);
            iVar = iVar2;
        } else {
            iVar = (i) view.getTag(v.tag_first);
        }
        if (!this.mIsHost) {
            iVar.auq.setVisibility(8);
        }
        GiftList item = getItem(i);
        if (item.sender != null) {
            iVar.btv.c(item.sender.portrait, 28, false);
            iVar.btv.setAutoChangeStyle(false);
            iVar.btv.setDrawBorder(false);
            iVar.bnF.setText(item.sender.name_show);
            iVar.btv.setTag(v.tag_first, item.sender.id);
            iVar.btv.setTag(v.tag_second, item.sender.name_show);
        }
        if (item.gift != null) {
            iVar.btx.c(item.gift.thumbnail_url, 10, false);
            iVar.btw.setText(String.valueOf(this.btr.getString(y.send_to_you)) + item.gift.name);
            iVar.btx.setAutoChangeStyle(false);
            iVar.btx.setDrawBorder(false);
            iVar.bty.setText(String.valueOf(this.btr.getString(y.mutil_sign)) + item.gift.num);
            iVar.auq.setText(az.j(item.gift.send_time.intValue() * 1000));
            this.btt = item.gift.play_url;
            boolean isEmpty = TextUtils.isEmpty(this.btt);
            if (this.mIsHost && !isEmpty && com.baidu.adp.lib.util.m.fx()) {
                iVar.btz.setVisibility(0);
            } else {
                iVar.btz.setVisibility(8);
            }
        }
        F(view);
        if (com.baidu.adp.lib.util.m.fx()) {
            view.setTag(v.tag_second, this.btt);
            return view;
        }
        return view;
    }

    private View un() {
        View inflate = com.baidu.adp.lib.g.b.ek().inflate(this.btr, w.buy_no_face_item, null);
        q a = q.a(new p(this.btr.getResources().getString(y.send_gift), this.btr.VH()));
        int dimension = (int) this.btr.getResources().getDimension(t.ds22);
        int dimension2 = (int) this.btr.getResources().getDimension(t.ds140);
        String VJ = this.btr.VJ();
        String string = this.btr.getString(y.no_gift);
        String string2 = this.btr.getString(y.come_on);
        String format = String.format(this.btr.getString(y.send_him_gift_note), VJ);
        MyGiftListActivity myGiftListActivity = this.btr;
        NoDataViewFactory.ImgType imgType = NoDataViewFactory.ImgType.GIFT;
        if (!this.mIsHost) {
            dimension = dimension2;
        }
        this.Yn = NoDataViewFactory.a(myGiftListActivity, inflate, r.a(imgType, dimension), s.O(string, this.mIsHost ? string2 : format), (this.mIsHost || !TbadkApplication.m251getInst().isGiftSwitchOn()) ? null : a);
        int skinType = TbadkApplication.m251getInst().getSkinType();
        this.btr.getLayoutMode().L(skinType == 1);
        this.btr.getLayoutMode().h(inflate);
        this.Yn.onChangeSkinType(skinType);
        this.Yn.setVisibility(0);
        return inflate;
    }

    public void setData(List<GiftList> list) {
        if (list == null) {
            this.bts = true;
        } else {
            this.bts = false;
        }
        this.btq = list;
        notifyDataSetChanged();
    }

    private void F(View view) {
        this.btr.getLayoutMode().L(TbadkApplication.m251getInst().getSkinType() == 1);
        this.btr.getLayoutMode().h(view);
    }
}
