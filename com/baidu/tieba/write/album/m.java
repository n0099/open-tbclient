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
import com.baidu.tieba.w;
import java.util.List;
/* loaded from: classes.dex */
public class m extends BaseAdapter {
    private com.baidu.tbadk.img.b awS;
    private String geZ;
    private AlbumActivity gex;
    private int gfa;
    private List<e> mList;
    private int mWidth;

    public m(AlbumActivity albumActivity) {
        this.gex = albumActivity;
        this.awS = albumActivity.akX();
        this.mWidth = (int) this.gex.getResources().getDimension(w.f.ds120);
        this.gfa = com.baidu.adp.lib.util.k.af(this.gex.getPageContext().getPageActivity()) / 2;
    }

    public void c(List<e> list, String str) {
        this.mList = list;
        this.geZ = str;
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
    /* renamed from: tF */
    public e getItem(int i) {
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
        a aVar;
        if (view != null) {
            aVar = (a) view.getTag();
        } else {
            view = LayoutInflater.from(this.gex.getPageContext().getPageActivity()).inflate(w.j.album_list_item, viewGroup, false);
            a aVar2 = new a(this, null);
            aVar2.gfc = (HeadImageView) view.findViewById(w.h.item_head);
            aVar2.gfd = (TextView) view.findViewById(w.h.item_name);
            aVar2.gfe = (ImageView) view.findViewById(w.h.item_arrow);
            view.setTag(aVar2);
            aVar = aVar2;
        }
        aVar.gfc.setTag(null);
        aVar.gfc.setDefaultResource(w.g.pic_image_h_not);
        aVar.gfc.c(null, 12, false);
        aVar.gfc.invalidate();
        e item = getItem(i);
        if (item != null) {
            if (!TextUtils.isEmpty(item.getName())) {
                item.getName();
                aVar.gfd.setText(String.valueOf(com.baidu.adp.lib.util.k.a(aVar.gfd.getPaint(), item.getName(), this.gfa)) + "(" + item.bsc() + ")");
            } else {
                aVar.gfd.setText("");
            }
            String albumId = item.getAlbumId();
            if (!TextUtils.isEmpty(albumId) && albumId.equals(this.geZ)) {
                aVar.gfe.setVisibility(0);
            } else {
                aVar.gfe.setVisibility(8);
            }
            ImageFileInfo bsd = item.bsd();
            if (bsd != null) {
                bsd.clearPageActions();
                bsd.addPageAction(com.baidu.tbadk.img.effect.d.L(this.mWidth, this.mWidth));
                com.baidu.adp.widget.a.a a2 = this.awS.a(bsd, false);
                aVar.gfc.setTag(bsd.toCachedKey(false));
                if (a2 != null) {
                    aVar.gfc.invalidate();
                } else {
                    this.awS.a(bsd, new n(this, viewGroup), false, this.gex.isScroll());
                }
            }
        } else {
            aVar.gfd.setText("");
        }
        this.gex.getLayoutMode().ah(TbadkCoreApplication.m9getInst().getSkinType() == 1);
        this.gex.getLayoutMode().t(view);
        return view;
    }

    /* loaded from: classes.dex */
    private class a {
        HeadImageView gfc;
        TextView gfd;
        ImageView gfe;

        private a() {
        }

        /* synthetic */ a(m mVar, a aVar) {
            this();
        }
    }
}
