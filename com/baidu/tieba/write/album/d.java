package com.baidu.tieba.write.album;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes2.dex */
public class d extends BaseAdapter {
    private com.baidu.tbadk.img.b axw;
    private String ckn;
    private int cko;
    private AlbumActivity gGN;
    private List<com.baidu.tbadk.b.a> mList;
    private int mWidth;

    public d(AlbumActivity albumActivity) {
        this.gGN = albumActivity;
        this.axw = albumActivity.aLU();
        this.mWidth = (int) this.gGN.getResources().getDimension(d.f.ds120);
        this.cko = com.baidu.adp.lib.util.l.ad(this.gGN.getPageContext().getPageActivity()) / 2;
    }

    public void d(List<com.baidu.tbadk.b.a> list, String str) {
        this.mList = list;
        this.ckn = str;
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
    /* renamed from: iO */
    public com.baidu.tbadk.b.a getItem(int i) {
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
    public View getView(int i, View view, final ViewGroup viewGroup) {
        a aVar;
        if (view != null) {
            aVar = (a) view.getTag();
        } else {
            view = LayoutInflater.from(this.gGN.getPageContext().getPageActivity()).inflate(d.j.album_list_item, viewGroup, false);
            a aVar2 = new a();
            aVar2.ckq = (HeadImageView) view.findViewById(d.h.item_head);
            aVar2.ckr = (TextView) view.findViewById(d.h.item_name);
            aVar2.cks = (ImageView) view.findViewById(d.h.item_arrow);
            view.setTag(aVar2);
            aVar = aVar2;
        }
        aVar.ckq.setTag(null);
        aVar.ckq.setDefaultResource(d.g.pic_image_h_not);
        aVar.ckq.c(null, 12, false);
        aVar.ckq.invalidate();
        com.baidu.tbadk.b.a item = getItem(i);
        if (item != null) {
            if (!TextUtils.isEmpty(item.getName())) {
                item.getName();
                aVar.ckr.setText(com.baidu.adp.lib.util.l.a(aVar.ckr.getPaint(), item.getName(), this.cko) + "(" + item.nA() + ")");
            } else {
                aVar.ckr.setText("");
            }
            String albumId = item.getAlbumId();
            if (!TextUtils.isEmpty(albumId) && albumId.equals(this.ckn)) {
                aVar.cks.setVisibility(0);
            } else {
                aVar.cks.setVisibility(8);
            }
            ImageFileInfo nB = item.nB();
            if (nB != null) {
                nB.clearPageActions();
                nB.addPageAction(com.baidu.tbadk.img.effect.d.K(this.mWidth, this.mWidth));
                com.baidu.adp.widget.ImageView.a a2 = this.axw.a(nB, false);
                aVar.ckq.setTag(nB.toCachedKey(false));
                if (a2 != null) {
                    aVar.ckq.invalidate();
                } else {
                    this.axw.a(nB, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.write.album.d.1
                        @Override // com.baidu.tbadk.imageManager.b
                        public void a(com.baidu.adp.widget.ImageView.a aVar3, String str, boolean z) {
                            HeadImageView headImageView = (HeadImageView) viewGroup.findViewWithTag(str);
                            if (headImageView != null && aVar3 != null) {
                                headImageView.invalidate();
                            }
                        }
                    }, false, this.gGN.isScroll());
                }
            }
        } else {
            aVar.ckr.setText("");
        }
        this.gGN.getLayoutMode().ai(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.gGN.getLayoutMode().t(view);
        return view;
    }

    /* loaded from: classes2.dex */
    private class a {
        HeadImageView ckq;
        TextView ckr;
        ImageView cks;

        private a() {
        }
    }
}
