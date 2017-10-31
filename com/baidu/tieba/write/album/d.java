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
    private com.baidu.tbadk.img.b axU;
    private String crw;
    private int crx;
    private AlbumActivity gQv;
    private List<com.baidu.tbadk.b.a> mList;
    private int mWidth;

    public d(AlbumActivity albumActivity) {
        this.gQv = albumActivity;
        this.axU = albumActivity.aOH();
        this.mWidth = (int) this.gQv.getResources().getDimension(d.e.ds120);
        this.crx = com.baidu.adp.lib.util.l.ac(this.gQv.getPageContext().getPageActivity()) / 2;
    }

    public void d(List<com.baidu.tbadk.b.a> list, String str) {
        this.mList = list;
        this.crw = str;
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
    /* renamed from: jd */
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
            view = LayoutInflater.from(this.gQv.getPageContext().getPageActivity()).inflate(d.h.album_list_item, viewGroup, false);
            a aVar2 = new a();
            aVar2.crz = (HeadImageView) view.findViewById(d.g.item_head);
            aVar2.crA = (TextView) view.findViewById(d.g.item_name);
            aVar2.crB = (ImageView) view.findViewById(d.g.item_arrow);
            view.setTag(aVar2);
            aVar = aVar2;
        }
        aVar.crz.setTag(null);
        aVar.crz.setDefaultResource(d.f.pic_image_h_not);
        aVar.crz.startLoad(null, 12, false);
        aVar.crz.invalidate();
        com.baidu.tbadk.b.a item = getItem(i);
        if (item != null) {
            if (!TextUtils.isEmpty(item.getName())) {
                item.getName();
                aVar.crA.setText(com.baidu.adp.lib.util.l.a(aVar.crA.getPaint(), item.getName(), this.crx) + "(" + item.nv() + ")");
            } else {
                aVar.crA.setText("");
            }
            String albumId = item.getAlbumId();
            if (!TextUtils.isEmpty(albumId) && albumId.equals(this.crw)) {
                aVar.crB.setVisibility(0);
            } else {
                aVar.crB.setVisibility(8);
            }
            ImageFileInfo nw = item.nw();
            if (nw != null) {
                nw.clearPageActions();
                nw.addPageAction(com.baidu.tbadk.img.effect.d.K(this.mWidth, this.mWidth));
                com.baidu.adp.widget.a.a a2 = this.axU.a(nw, false);
                aVar.crz.setTag(nw.toCachedKey(false));
                if (a2 != null) {
                    aVar.crz.invalidate();
                } else {
                    this.axU.a(nw, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.write.album.d.1
                        @Override // com.baidu.tbadk.imageManager.b
                        public void a(com.baidu.adp.widget.a.a aVar3, String str, boolean z) {
                            HeadImageView headImageView = (HeadImageView) viewGroup.findViewWithTag(str);
                            if (headImageView != null && aVar3 != null) {
                                headImageView.invalidate();
                            }
                        }
                    }, false, this.gQv.isScroll());
                }
            }
        } else {
            aVar.crA.setText("");
        }
        this.gQv.getLayoutMode().ag(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.gQv.getLayoutMode().t(view);
        return view;
    }

    /* loaded from: classes2.dex */
    private class a {
        TextView crA;
        ImageView crB;
        HeadImageView crz;

        private a() {
        }
    }
}
