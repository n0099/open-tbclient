package com.baidu.tieba.write.album;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.img.ImageFileInfo;
import java.util.List;
/* loaded from: classes.dex */
public class j extends BaseAdapter {
    private String ctL;
    private int ctM;
    private com.baidu.tbadk.img.e cts;
    private AlbumActivity ctu;
    private List<a> mList;
    private int mWidth;

    public j(AlbumActivity albumActivity) {
        this.ctu = albumActivity;
        this.cts = albumActivity.apy();
        this.mWidth = (int) this.ctu.getResources().getDimension(com.baidu.tieba.t.album_image_height);
        this.ctM = com.baidu.adp.lib.util.n.M(this.ctu.getPageContext().getPageActivity()) / 2;
    }

    public void c(List<a> list, String str) {
        this.mList = list;
        this.ctL = str;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.mList != null) {
            return this.mList.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: iP */
    public a getItem(int i) {
        if (this.mList == null || i < 0 || i >= this.mList.size()) {
            return null;
        }
        return this.mList.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        l lVar;
        if (view != null) {
            lVar = (l) view.getTag();
        } else {
            view = com.baidu.adp.lib.g.b.hH().a(this.ctu.getPageContext().getPageActivity(), com.baidu.tieba.w.album_list_item, viewGroup, false);
            l lVar2 = new l(this, null);
            lVar2.ctO = (HeadImageView) view.findViewById(com.baidu.tieba.v.item_head);
            lVar2.ctP = (TextView) view.findViewById(com.baidu.tieba.v.item_name);
            lVar2.ctQ = (ImageView) view.findViewById(com.baidu.tieba.v.item_arrow);
            view.setTag(lVar2);
            lVar = lVar2;
        }
        lVar.ctO.setTag(null);
        lVar.ctO.setDefaultResource(com.baidu.tieba.u.pic_image_h_not);
        lVar.ctO.c(null, 12, false);
        lVar.ctO.invalidate();
        a item = getItem(i);
        if (item != null) {
            if (!TextUtils.isEmpty(item.getName())) {
                item.getName();
                lVar.ctP.setText(String.valueOf(com.baidu.adp.lib.util.n.a(lVar.ctP.getPaint(), item.getName(), this.ctM)) + "(" + item.apB() + ")");
            } else {
                lVar.ctP.setText("");
            }
            String albumId = item.getAlbumId();
            if (!TextUtils.isEmpty(albumId) && albumId.equals(this.ctL)) {
                lVar.ctQ.setVisibility(0);
            } else {
                lVar.ctQ.setVisibility(8);
            }
            ImageFileInfo apC = item.apC();
            if (apC != null) {
                apC.clearPageActions();
                apC.addPageAction(com.baidu.tbadk.img.effect.d.x(this.mWidth, this.mWidth));
                com.baidu.adp.widget.a.a a = this.cts.a(apC, false);
                lVar.ctO.setTag(apC.toCachedKey(false));
                if (a != null) {
                    lVar.ctO.invalidate();
                } else {
                    this.cts.a(apC, new k(this, viewGroup), false, this.ctu.isScroll());
                }
            }
        } else {
            lVar.ctP.setText("");
        }
        this.ctu.getLayoutMode().X(TbadkCoreApplication.m411getInst().getSkinType() == 1);
        this.ctu.getLayoutMode().h(view);
        return view;
    }
}
