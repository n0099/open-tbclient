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
    private com.baidu.tbadk.img.e ctI;
    private AlbumActivity ctK;
    private String cub;
    private int cuc;
    private List<a> mList;
    private int mWidth;

    public j(AlbumActivity albumActivity) {
        this.ctK = albumActivity;
        this.ctI = albumActivity.apN();
        this.mWidth = (int) this.ctK.getResources().getDimension(com.baidu.tieba.t.album_image_height);
        this.cuc = com.baidu.adp.lib.util.n.M(this.ctK.getPageContext().getPageActivity()) / 2;
    }

    public void c(List<a> list, String str) {
        this.mList = list;
        this.cub = str;
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
    /* renamed from: iS */
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
            view = com.baidu.adp.lib.g.b.hH().a(this.ctK.getPageContext().getPageActivity(), com.baidu.tieba.w.album_list_item, viewGroup, false);
            l lVar2 = new l(this, null);
            lVar2.cue = (HeadImageView) view.findViewById(com.baidu.tieba.v.item_head);
            lVar2.cuf = (TextView) view.findViewById(com.baidu.tieba.v.item_name);
            lVar2.cug = (ImageView) view.findViewById(com.baidu.tieba.v.item_arrow);
            view.setTag(lVar2);
            lVar = lVar2;
        }
        lVar.cue.setTag(null);
        lVar.cue.setDefaultResource(com.baidu.tieba.u.pic_image_h_not);
        lVar.cue.c(null, 12, false);
        lVar.cue.invalidate();
        a item = getItem(i);
        if (item != null) {
            if (!TextUtils.isEmpty(item.getName())) {
                item.getName();
                lVar.cuf.setText(String.valueOf(com.baidu.adp.lib.util.n.a(lVar.cuf.getPaint(), item.getName(), this.cuc)) + "(" + item.apQ() + ")");
            } else {
                lVar.cuf.setText("");
            }
            String albumId = item.getAlbumId();
            if (!TextUtils.isEmpty(albumId) && albumId.equals(this.cub)) {
                lVar.cug.setVisibility(0);
            } else {
                lVar.cug.setVisibility(8);
            }
            ImageFileInfo apR = item.apR();
            if (apR != null) {
                apR.clearPageActions();
                apR.addPageAction(com.baidu.tbadk.img.effect.d.x(this.mWidth, this.mWidth));
                com.baidu.adp.widget.a.a a = this.ctI.a(apR, false);
                lVar.cue.setTag(apR.toCachedKey(false));
                if (a != null) {
                    lVar.cue.invalidate();
                } else {
                    this.ctI.a(apR, new k(this, viewGroup), false, this.ctK.isScroll());
                }
            }
        } else {
            lVar.cuf.setText("");
        }
        this.ctK.getLayoutMode().X(TbadkCoreApplication.m411getInst().getSkinType() == 1);
        this.ctK.getLayoutMode().h(view);
        return view;
    }
}
