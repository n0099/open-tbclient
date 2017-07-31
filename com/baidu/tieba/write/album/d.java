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
/* loaded from: classes.dex */
public class d extends BaseAdapter {
    private com.baidu.tbadk.img.b azb;
    private AlbumActivity gAh;
    private String gAw;
    private int gAx;
    private List<com.baidu.tbadk.c.a> mList;
    private int mWidth;

    public d(AlbumActivity albumActivity) {
        this.gAh = albumActivity;
        this.azb = albumActivity.amK();
        this.mWidth = (int) this.gAh.getResources().getDimension(d.f.ds120);
        this.gAx = com.baidu.adp.lib.util.k.ag(this.gAh.getPageContext().getPageActivity()) / 2;
    }

    public void c(List<com.baidu.tbadk.c.a> list, String str) {
        this.mList = list;
        this.gAw = str;
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
    /* renamed from: ug */
    public com.baidu.tbadk.c.a getItem(int i) {
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
            view = LayoutInflater.from(this.gAh.getPageContext().getPageActivity()).inflate(d.j.album_list_item, viewGroup, false);
            a aVar2 = new a();
            aVar2.gAz = (HeadImageView) view.findViewById(d.h.item_head);
            aVar2.gAA = (TextView) view.findViewById(d.h.item_name);
            aVar2.gAB = (ImageView) view.findViewById(d.h.item_arrow);
            view.setTag(aVar2);
            aVar = aVar2;
        }
        aVar.gAz.setTag(null);
        aVar.gAz.setDefaultResource(d.g.pic_image_h_not);
        aVar.gAz.c(null, 12, false);
        aVar.gAz.invalidate();
        com.baidu.tbadk.c.a item = getItem(i);
        if (item != null) {
            if (!TextUtils.isEmpty(item.getName())) {
                item.getName();
                aVar.gAA.setText(com.baidu.adp.lib.util.k.a(aVar.gAA.getPaint(), item.getName(), this.gAx) + "(" + item.nF() + ")");
            } else {
                aVar.gAA.setText("");
            }
            String albumId = item.getAlbumId();
            if (!TextUtils.isEmpty(albumId) && albumId.equals(this.gAw)) {
                aVar.gAB.setVisibility(0);
            } else {
                aVar.gAB.setVisibility(8);
            }
            ImageFileInfo nG = item.nG();
            if (nG != null) {
                nG.clearPageActions();
                nG.addPageAction(com.baidu.tbadk.img.effect.d.M(this.mWidth, this.mWidth));
                com.baidu.adp.widget.a.a a2 = this.azb.a(nG, false);
                aVar.gAz.setTag(nG.toCachedKey(false));
                if (a2 != null) {
                    aVar.gAz.invalidate();
                } else {
                    this.azb.a(nG, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.write.album.d.1
                        @Override // com.baidu.tbadk.imageManager.b
                        public void a(com.baidu.adp.widget.a.a aVar3, String str, boolean z) {
                            HeadImageView headImageView = (HeadImageView) viewGroup.findViewWithTag(str);
                            if (headImageView != null && aVar3 != null) {
                                headImageView.invalidate();
                            }
                        }
                    }, false, this.gAh.isScroll());
                }
            }
        } else {
            aVar.gAA.setText("");
        }
        this.gAh.getLayoutMode().ah(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.gAh.getLayoutMode().t(view);
        return view;
    }

    /* loaded from: classes.dex */
    private class a {
        TextView gAA;
        ImageView gAB;
        HeadImageView gAz;

        private a() {
        }
    }
}
