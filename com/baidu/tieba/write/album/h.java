package com.baidu.tieba.write.album;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.album.AddMediaInfo;
import com.baidu.tbadk.album.MediaFileInfo;
import com.baidu.tbadk.album.VideoFileInfo;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.write.album.TbCameraView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class h extends BaseAdapter {
    private AlbumActivity hsG;
    private com.baidu.tieba.write.album.c hta;
    private View.OnClickListener htc;
    private f htd;
    private g hte;
    private TbCameraView.c htf;
    private TbCameraView.a htg;
    private a hth;
    private LayoutInflater mLayoutInflater;
    private final List<MediaFileInfo> mDataList = new ArrayList();
    private boolean fmX = false;
    private boolean htb = true;

    public TbCameraView bHr() {
        if (this.hth != null) {
            return this.hth.htj;
        }
        return null;
    }

    public h(AlbumActivity albumActivity, com.baidu.tieba.write.album.c cVar) {
        this.hsG = albumActivity;
        this.hta = cVar;
        this.mLayoutInflater = LayoutInflater.from(this.hsG.getPageContext().getPageActivity());
    }

    public void setData(List<MediaFileInfo> list) {
        this.mDataList.clear();
        if (this.htb) {
            this.mDataList.add(bHs());
        }
        if (!w.A(list)) {
            this.mDataList.addAll(list);
        }
        notifyDataSetChanged();
    }

    private MediaFileInfo bHs() {
        return new AddMediaInfo();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return w.z(this.mDataList);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: vs */
    public MediaFileInfo getItem(int i) {
        return (MediaFileInfo) w.d(this.mDataList, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        MediaFileInfo mediaFileInfo = (MediaFileInfo) w.d(this.mDataList, i);
        if (mediaFileInfo != null) {
            return mediaFileInfo.getType();
        }
        return 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        MediaFileInfo item = getItem(i);
        if (item != null) {
            if (item.getType() == 2) {
                return a(i, view, viewGroup, item);
            }
            if (item.getType() == 1) {
                return c(i, view, viewGroup, item);
            }
            if (item.getType() == 0) {
                return b(i, view, viewGroup, item);
            }
            return view;
        }
        return view;
    }

    private View a(int i, View view, ViewGroup viewGroup, MediaFileInfo mediaFileInfo) {
        if (mediaFileInfo != null && mediaFileInfo.getType() == 2) {
            if (this.hth == null || this.hth.htj == null) {
                this.hth = new a();
                View inflate = this.mLayoutInflater.inflate(d.i.album_make_picture_view, viewGroup, false);
                this.hth.rootView = inflate;
                this.hth.htj = (TbCameraView) inflate.findViewById(d.g.camera_surfaceview);
                this.hth.hti = (TbImageView) inflate.findViewById(d.g.icon_make_photo);
                this.hth.hti.setDefaultResource(0);
                this.hth.hti.setDefaultErrorResource(0);
                this.hth.hti.setGifIconSupport(false);
                this.hth.hti.setLongIconSupport(false);
                inflate.setTag(this.hth);
                this.hsG.showTip(this.hth.hti);
            }
            this.hth.htj.setOnRequestPermissionListener(this.htf);
            this.hth.htj.setOnOpenCameraFailedListener(this.htg);
            this.hth.hti.setOnClickListener(this.htc);
            this.hth.htj.setOnClickListener(this.htc);
            this.hth.rootView.setOnClickListener(this.htc);
            am.c(this.hth.hti, d.f.icon_album_camera);
            am.j(this.hth.rootView, d.C0142d.black_alpha90);
            return this.hth.rootView;
        }
        return view;
    }

    private View b(int i, View view, ViewGroup viewGroup, MediaFileInfo mediaFileInfo) {
        d dVar;
        if (mediaFileInfo != null && mediaFileInfo.getType() == 0 && (mediaFileInfo instanceof ImageFileInfo)) {
            ImageFileInfo imageFileInfo = (ImageFileInfo) mediaFileInfo;
            if (view == null || !(view.getTag() instanceof d)) {
                d dVar2 = new d();
                view = this.mLayoutInflater.inflate(d.i.album_image_item_view, viewGroup, false);
                dVar2.rootView = view;
                dVar2.cTj = (TbImageView) view.findViewById(d.g.pic);
                dVar2.cTj.setDefaultResource(0);
                dVar2.cTj.setDefaultErrorResource(0);
                dVar2.cTj.setTagPaddingDis(8, 8);
                dVar2.cTj.setGifIconSupport(true);
                dVar2.cTj.setLongIconSupport(true);
                dVar2.cTk = (ImageView) view.findViewById(d.g.select_icon);
                dVar2.gTc = (RelativeLayout) view.findViewById(d.g.lay_select);
                view.setTag(dVar2);
                dVar = dVar2;
            } else {
                dVar = (d) view.getTag();
            }
            dVar.cTj.setIsLongPic(imageFileInfo.isLong());
            dVar.cTj.startLoad(imageFileInfo.getFilePath(), 35, false);
            a(dVar.cTk, mediaFileInfo);
            b bVar = new b(mediaFileInfo, i);
            dVar.cTj.setOnClickListener(bVar);
            dVar.gTc.setOnClickListener(bVar);
        }
        return view;
    }

    private View c(int i, View view, ViewGroup viewGroup, MediaFileInfo mediaFileInfo) {
        c cVar;
        if (mediaFileInfo != null && mediaFileInfo.getType() == 1 && (mediaFileInfo instanceof VideoFileInfo)) {
            VideoFileInfo videoFileInfo = (VideoFileInfo) mediaFileInfo;
            if (view == null || !(view.getTag() instanceof d)) {
                c cVar2 = new c();
                view = this.mLayoutInflater.inflate(d.i.album_video_item_view, viewGroup, false);
                cVar2.rootView = view;
                cVar2.htm = (TbImageView) view.findViewById(d.g.video_thumb);
                cVar2.htm.setDefaultResource(0);
                cVar2.htm.setDefaultErrorResource(0);
                cVar2.htm.setTagPaddingDis(8, 8);
                cVar2.htm.setGifIconSupport(false);
                cVar2.htm.setLongIconSupport(false);
                cVar2.cTk = (ImageView) view.findViewById(d.g.select_icon);
                cVar2.htn = (RelativeLayout) view.findViewById(d.g.video_select);
                cVar2.hto = (TextView) view.findViewById(d.g.video_play_time);
                view.setTag(cVar2);
                cVar = cVar2;
            } else {
                cVar = (c) view.getTag();
            }
            cVar.htm.startLoad(videoFileInfo.videoPath, 37, false);
            cVar.hto.setText(ap.cY(videoFileInfo.videoDuration));
            a(cVar.cTk, mediaFileInfo);
            b bVar = new b(mediaFileInfo, i);
            cVar.htm.setOnClickListener(bVar);
            cVar.htn.setOnClickListener(bVar);
        }
        return view;
    }

    private void a(ImageView imageView, MediaFileInfo mediaFileInfo) {
        boolean z = false;
        if (this.hta != null && (mediaFileInfo instanceof ImageFileInfo)) {
            z = this.hta.isAdded((ImageFileInfo) mediaFileInfo);
        } else if (this.hta != null && (mediaFileInfo instanceof VideoFileInfo)) {
            z = this.hta.b((VideoFileInfo) mediaFileInfo);
        }
        d(imageView, z);
    }

    public void d(ImageView imageView, boolean z) {
        if (imageView != null) {
            if (z) {
                imageView.setContentDescription(this.hsG.getResources().getString(d.k.check_box_checked));
                am.c(imageView, d.f.icon_list_select_ok_n);
                return;
            }
            imageView.setContentDescription(this.hsG.getResources().getString(d.k.check_box_not_checked));
            am.c(imageView, d.f.icon_list_select_n);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        private MediaFileInfo htl;
        private int position;

        public b(MediaFileInfo mediaFileInfo, int i) {
            this.htl = mediaFileInfo;
            this.position = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == d.g.pic) {
                if (h.this.htd != null && this.htl != null) {
                    h.this.htd.a(this.position, this.htl);
                }
            } else if (view.getId() == d.g.lay_select) {
                if (this.htl != null && h.this.hte != null) {
                    h.this.hte.b(this.position, this.htl);
                }
            } else if (view.getId() == d.g.video_thumb) {
                if (h.this.htd != null && this.htl != null) {
                    h.this.htd.a(this.position, this.htl);
                }
            } else if (view.getId() == d.g.video_select && this.htl != null && h.this.hte != null) {
                h.this.hte.b(this.position, this.htl);
            }
        }
    }

    public boolean isScroll() {
        return this.fmX;
    }

    public void js(boolean z) {
        this.fmX = z;
    }

    public void a(f fVar) {
        this.htd = fVar;
    }

    public void a(g gVar) {
        this.hte = gVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a {
        TbImageView hti;
        TbCameraView htj;
        View rootView;

        private a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class d {
        TbImageView cTj;
        ImageView cTk;
        RelativeLayout gTc;
        View rootView;

        private d() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class c {
        ImageView cTk;
        TbImageView htm;
        RelativeLayout htn;
        TextView hto;
        View rootView;

        private c() {
        }
    }

    public int g(ImageFileInfo imageFileInfo) {
        if (imageFileInfo == null || imageFileInfo.getFilePath() == null) {
            return -1;
        }
        if (this.mDataList == null || this.mDataList.size() == 0) {
            return -1;
        }
        String filePath = imageFileInfo.getFilePath();
        int size = this.mDataList.size();
        for (int i = 0; i < size; i++) {
            MediaFileInfo mediaFileInfo = this.mDataList.get(i);
            if (mediaFileInfo instanceof ImageFileInfo) {
                ImageFileInfo imageFileInfo2 = (ImageFileInfo) mediaFileInfo;
                if (imageFileInfo2.getFilePath() != null && imageFileInfo2.getFilePath().equals(filePath)) {
                    return i;
                }
            }
        }
        return -1;
    }

    public void Z(View.OnClickListener onClickListener) {
        this.htc = onClickListener;
    }

    public void setOnRequestPermissionListener(TbCameraView.c cVar) {
        this.htf = cVar;
    }

    public void setOnOpenCameraFailedListener(TbCameraView.a aVar) {
        this.htg = aVar;
    }

    public void nH(boolean z) {
        if (this.htb != z) {
            this.htb = z;
            notifyDataSetChanged();
        }
    }
}
