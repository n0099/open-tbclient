package com.baidu.tieba.mygiftlist;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.ay;
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
    private o Yj;
    private List<GiftList> btb;
    private MyGiftListActivity btc;
    private boolean mIsHost;
    private int bta = 1;
    private boolean btd = false;
    private String bte = null;
    View.OnClickListener Ie = new h(this);

    public g(MyGiftListActivity myGiftListActivity, boolean z) {
        this.btc = myGiftListActivity;
        this.mIsHost = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.btd) {
            return 1;
        }
        if (this.btb != null && this.btb.size() != 0) {
            return this.btb.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: gH */
    public GiftList getItem(int i) {
        if (this.btd) {
            return null;
        }
        int itemId = (int) getItemId(i);
        if (this.btb == null || this.btb.size() == 0 || itemId < 0 || itemId >= this.btb.size()) {
            return null;
        }
        return this.btb.get(itemId);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return this.bta;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        i iVar;
        if (this.btd) {
            return ul();
        }
        if (view == null || view.getTag(v.tag_first) == null) {
            view = com.baidu.adp.lib.g.b.ek().a(this.btc, w.my_gift_list_item, viewGroup, false);
            i iVar2 = new i(this, null);
            iVar2.btg = (HeadImageView) view.findViewById(v.item_portrait);
            iVar2.btg.setOnClickListener(this.Ie);
            iVar2.bnr = (TextView) view.findViewById(v.user_name);
            iVar2.btj = (TextView) view.findViewById(v.gift_num);
            iVar2.bti = (TbClipImageView) view.findViewById(v.gift_icon);
            iVar2.bth = (TextView) view.findViewById(v.gift_name);
            iVar2.auh = (TextView) view.findViewById(v.time);
            iVar2.btk = (ImageView) view.findViewById(v.paly_icon);
            view.setTag(v.tag_first, iVar2);
            iVar = iVar2;
        } else {
            iVar = (i) view.getTag(v.tag_first);
        }
        if (!this.mIsHost) {
            iVar.auh.setVisibility(8);
        }
        GiftList item = getItem(i);
        if (item.sender != null) {
            iVar.btg.c(item.sender.portrait, 28, false);
            iVar.btg.setAutoChangeStyle(false);
            iVar.btg.setDrawBorder(false);
            iVar.bnr.setText(item.sender.name_show);
            iVar.btg.setTag(v.tag_first, item.sender.id);
            iVar.btg.setTag(v.tag_second, item.sender.name_show);
        }
        if (item.gift != null) {
            iVar.bti.c(item.gift.thumbnail_url, 10, false);
            iVar.bth.setText(String.valueOf(this.btc.getString(y.send_to_you)) + item.gift.name);
            iVar.bti.setAutoChangeStyle(false);
            iVar.bti.setDrawBorder(false);
            iVar.btj.setText(String.valueOf(this.btc.getString(y.mutil_sign)) + item.gift.num);
            iVar.auh.setText(ay.j(item.gift.send_time.intValue() * 1000));
            this.bte = item.gift.play_url;
            boolean isEmpty = TextUtils.isEmpty(this.bte);
            if (this.mIsHost && !isEmpty && com.baidu.adp.lib.util.m.fx()) {
                iVar.btk.setVisibility(0);
            } else {
                iVar.btk.setVisibility(8);
            }
        }
        F(view);
        if (com.baidu.adp.lib.util.m.fx()) {
            view.setTag(v.tag_second, this.bte);
            return view;
        }
        return view;
    }

    private View ul() {
        View inflate = com.baidu.adp.lib.g.b.ek().inflate(this.btc, w.buy_no_face_item, null);
        q a = q.a(new p(this.btc.getResources().getString(y.send_gift), this.btc.VE()));
        int dimension = (int) this.btc.getResources().getDimension(t.ds22);
        int dimension2 = (int) this.btc.getResources().getDimension(t.ds140);
        String VG = this.btc.VG();
        String string = this.btc.getString(y.no_gift);
        String string2 = this.btc.getString(y.come_on);
        String format = String.format(this.btc.getString(y.send_him_gift_note), VG);
        MyGiftListActivity myGiftListActivity = this.btc;
        NoDataViewFactory.ImgType imgType = NoDataViewFactory.ImgType.GIFT;
        if (!this.mIsHost) {
            dimension = dimension2;
        }
        this.Yj = NoDataViewFactory.a(myGiftListActivity, inflate, r.a(imgType, dimension), s.O(string, this.mIsHost ? string2 : format), (this.mIsHost || !TbadkApplication.m251getInst().isGiftSwitchOn()) ? null : a);
        int skinType = TbadkApplication.m251getInst().getSkinType();
        this.btc.getLayoutMode().L(skinType == 1);
        this.btc.getLayoutMode().h(inflate);
        this.Yj.onChangeSkinType(skinType);
        this.Yj.setVisibility(0);
        return inflate;
    }

    public void setData(List<GiftList> list) {
        if (list == null) {
            this.btd = true;
        } else {
            this.btd = false;
        }
        this.btb = list;
        notifyDataSetChanged();
    }

    private void F(View view) {
        this.btc.getLayoutMode().L(TbadkApplication.m251getInst().getSkinType() == 1);
        this.btc.getLayoutMode().h(view);
    }
}
