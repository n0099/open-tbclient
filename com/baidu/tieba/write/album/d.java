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
    private com.baidu.tbadk.img.b axk;
    private String ckb;
    private int ckc;
    private AlbumActivity gGx;
    private List<com.baidu.tbadk.b.a> mList;
    private int mWidth;

    public d(AlbumActivity albumActivity) {
        this.gGx = albumActivity;
        this.axk = albumActivity.aLP();
        this.mWidth = (int) this.gGx.getResources().getDimension(d.f.ds120);
        this.ckc = com.baidu.adp.lib.util.l.ad(this.gGx.getPageContext().getPageActivity()) / 2;
    }

    public void d(List<com.baidu.tbadk.b.a> list, String str) {
        this.mList = list;
        this.ckb = str;
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
    /* renamed from: iN */
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
            view = LayoutInflater.from(this.gGx.getPageContext().getPageActivity()).inflate(d.j.album_list_item, viewGroup, false);
            a aVar2 = new a();
            aVar2.cke = (HeadImageView) view.findViewById(d.h.item_head);
            aVar2.ckf = (TextView) view.findViewById(d.h.item_name);
            aVar2.ckg = (ImageView) view.findViewById(d.h.item_arrow);
            view.setTag(aVar2);
            aVar = aVar2;
        }
        aVar.cke.setTag(null);
        aVar.cke.setDefaultResource(d.g.pic_image_h_not);
        aVar.cke.c(null, 12, false);
        aVar.cke.invalidate();
        com.baidu.tbadk.b.a item = getItem(i);
        if (item != null) {
            if (!TextUtils.isEmpty(item.getName())) {
                item.getName();
                aVar.ckf.setText(com.baidu.adp.lib.util.l.a(aVar.ckf.getPaint(), item.getName(), this.ckc) + "(" + item.ns() + ")");
            } else {
                aVar.ckf.setText("");
            }
            String albumId = item.getAlbumId();
            if (!TextUtils.isEmpty(albumId) && albumId.equals(this.ckb)) {
                aVar.ckg.setVisibility(0);
            } else {
                aVar.ckg.setVisibility(8);
            }
            ImageFileInfo nt = item.nt();
            if (nt != null) {
                nt.clearPageActions();
                nt.addPageAction(com.baidu.tbadk.img.effect.d.K(this.mWidth, this.mWidth));
                com.baidu.adp.widget.ImageView.a a2 = this.axk.a(nt, false);
                aVar.cke.setTag(nt.toCachedKey(false));
                if (a2 != null) {
                    aVar.cke.invalidate();
                } else {
                    this.axk.a(nt, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.write.album.d.1
                        @Override // com.baidu.tbadk.imageManager.b
                        public void a(com.baidu.adp.widget.ImageView.a aVar3, String str, boolean z) {
                            HeadImageView headImageView = (HeadImageView) viewGroup.findViewWithTag(str);
                            if (headImageView != null && aVar3 != null) {
                                headImageView.invalidate();
                            }
                        }
                    }, false, this.gGx.isScroll());
                }
            }
        } else {
            aVar.ckf.setText("");
        }
        this.gGx.getLayoutMode().ah(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.gGx.getLayoutMode().t(view);
        return view;
    }

    /* loaded from: classes2.dex */
    private class a {
        HeadImageView cke;
        TextView ckf;
        ImageView ckg;

        private a() {
        }
    }
}
