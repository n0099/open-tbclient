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
    private com.baidu.tbadk.img.b ayo;
    private AlbumActivity gAM;
    private String gBb;
    private int gBc;
    private List<com.baidu.tbadk.c.a> mList;
    private int mWidth;

    public d(AlbumActivity albumActivity) {
        this.gAM = albumActivity;
        this.ayo = albumActivity.aoS();
        this.mWidth = (int) this.gAM.getResources().getDimension(d.f.ds120);
        this.gBc = com.baidu.adp.lib.util.k.ad(this.gAM.getPageContext().getPageActivity()) / 2;
    }

    public void c(List<com.baidu.tbadk.c.a> list, String str) {
        this.mList = list;
        this.gBb = str;
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
    /* renamed from: ur */
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
            view = LayoutInflater.from(this.gAM.getPageContext().getPageActivity()).inflate(d.j.album_list_item, viewGroup, false);
            a aVar2 = new a();
            aVar2.gBe = (HeadImageView) view.findViewById(d.h.item_head);
            aVar2.gBf = (TextView) view.findViewById(d.h.item_name);
            aVar2.gBg = (ImageView) view.findViewById(d.h.item_arrow);
            view.setTag(aVar2);
            aVar = aVar2;
        }
        aVar.gBe.setTag(null);
        aVar.gBe.setDefaultResource(d.g.pic_image_h_not);
        aVar.gBe.c(null, 12, false);
        aVar.gBe.invalidate();
        com.baidu.tbadk.c.a item = getItem(i);
        if (item != null) {
            if (!TextUtils.isEmpty(item.getName())) {
                item.getName();
                aVar.gBf.setText(com.baidu.adp.lib.util.k.a(aVar.gBf.getPaint(), item.getName(), this.gBc) + "(" + item.nA() + ")");
            } else {
                aVar.gBf.setText("");
            }
            String albumId = item.getAlbumId();
            if (!TextUtils.isEmpty(albumId) && albumId.equals(this.gBb)) {
                aVar.gBg.setVisibility(0);
            } else {
                aVar.gBg.setVisibility(8);
            }
            ImageFileInfo nB = item.nB();
            if (nB != null) {
                nB.clearPageActions();
                nB.addPageAction(com.baidu.tbadk.img.effect.d.J(this.mWidth, this.mWidth));
                com.baidu.adp.widget.a.a a2 = this.ayo.a(nB, false);
                aVar.gBe.setTag(nB.toCachedKey(false));
                if (a2 != null) {
                    aVar.gBe.invalidate();
                } else {
                    this.ayo.a(nB, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.write.album.d.1
                        @Override // com.baidu.tbadk.imageManager.b
                        public void a(com.baidu.adp.widget.a.a aVar3, String str, boolean z) {
                            HeadImageView headImageView = (HeadImageView) viewGroup.findViewWithTag(str);
                            if (headImageView != null && aVar3 != null) {
                                headImageView.invalidate();
                            }
                        }
                    }, false, this.gAM.isScroll());
                }
            }
        } else {
            aVar.gBf.setText("");
        }
        this.gAM.getLayoutMode().ah(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.gAM.getLayoutMode().t(view);
        return view;
    }

    /* loaded from: classes2.dex */
    private class a {
        HeadImageView gBe;
        TextView gBf;
        ImageView gBg;

        private a() {
        }
    }
}
