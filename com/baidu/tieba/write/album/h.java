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
    private AlbumActivity htN;
    private com.baidu.tieba.write.album.c huh;
    private View.OnClickListener huj;
    private f huk;
    private g hul;
    private TbCameraView.c hum;
    private TbCameraView.a hun;
    private a huo;
    private LayoutInflater mLayoutInflater;
    private final List<MediaFileInfo> mDataList = new ArrayList();
    private boolean fni = false;
    private boolean hui = true;

    public TbCameraView bGc() {
        if (this.huo != null) {
            return this.huo.huq;
        }
        return null;
    }

    public h(AlbumActivity albumActivity, com.baidu.tieba.write.album.c cVar) {
        this.htN = albumActivity;
        this.huh = cVar;
        this.mLayoutInflater = LayoutInflater.from(this.htN.getPageContext().getPageActivity());
    }

    public void setData(List<MediaFileInfo> list) {
        this.mDataList.clear();
        if (this.hui) {
            this.mDataList.add(bGd());
        }
        if (!w.z(list)) {
            this.mDataList.addAll(list);
        }
        notifyDataSetChanged();
    }

    private MediaFileInfo bGd() {
        return new AddMediaInfo();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return w.y(this.mDataList);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: vr */
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
            if (this.huo == null || this.huo.huq == null) {
                this.huo = new a();
                View inflate = this.mLayoutInflater.inflate(d.h.album_make_picture_view, viewGroup, false);
                this.huo.rootView = inflate;
                this.huo.huq = (TbCameraView) inflate.findViewById(d.g.camera_surfaceview);
                this.huo.hup = (TbImageView) inflate.findViewById(d.g.icon_make_photo);
                this.huo.hup.setDefaultResource(0);
                this.huo.hup.setDefaultErrorResource(0);
                this.huo.hup.setGifIconSupport(false);
                this.huo.hup.setLongIconSupport(false);
                inflate.setTag(this.huo);
                this.htN.showTip(this.huo.hup);
            }
            this.huo.huq.setOnRequestPermissionListener(this.hum);
            this.huo.huq.setOnOpenCameraFailedListener(this.hun);
            this.huo.hup.setOnClickListener(this.huj);
            this.huo.huq.setOnClickListener(this.huj);
            this.huo.rootView.setOnClickListener(this.huj);
            am.c(this.huo.hup, d.f.icon_album_camera);
            am.j(this.huo.rootView, d.C0140d.black_alpha90);
            return this.huo.rootView;
        }
        return view;
    }

    private View b(int i, View view, ViewGroup viewGroup, MediaFileInfo mediaFileInfo) {
        d dVar;
        if (mediaFileInfo != null && mediaFileInfo.getType() == 0 && (mediaFileInfo instanceof ImageFileInfo)) {
            ImageFileInfo imageFileInfo = (ImageFileInfo) mediaFileInfo;
            if (view == null || !(view.getTag() instanceof d)) {
                d dVar2 = new d();
                view = this.mLayoutInflater.inflate(d.h.album_image_item_view, viewGroup, false);
                dVar2.rootView = view;
                dVar2.cVW = (TbImageView) view.findViewById(d.g.pic);
                dVar2.cVW.setDefaultResource(0);
                dVar2.cVW.setDefaultErrorResource(0);
                dVar2.cVW.setTagPaddingDis(8, 8);
                dVar2.cVW.setGifIconSupport(true);
                dVar2.cVW.setLongIconSupport(true);
                dVar2.cVX = (ImageView) view.findViewById(d.g.select_icon);
                dVar2.gUa = (RelativeLayout) view.findViewById(d.g.lay_select);
                view.setTag(dVar2);
                dVar = dVar2;
            } else {
                dVar = (d) view.getTag();
            }
            dVar.cVW.setIsLongPic(imageFileInfo.isLong());
            dVar.cVW.startLoad(imageFileInfo.getFilePath(), 35, false);
            a(dVar.cVX, mediaFileInfo);
            b bVar = new b(mediaFileInfo, i);
            dVar.cVW.setOnClickListener(bVar);
            dVar.gUa.setOnClickListener(bVar);
        }
        return view;
    }

    private View c(int i, View view, ViewGroup viewGroup, MediaFileInfo mediaFileInfo) {
        c cVar;
        if (mediaFileInfo != null && mediaFileInfo.getType() == 1 && (mediaFileInfo instanceof VideoFileInfo)) {
            VideoFileInfo videoFileInfo = (VideoFileInfo) mediaFileInfo;
            if (view == null || !(view.getTag() instanceof d)) {
                c cVar2 = new c();
                view = this.mLayoutInflater.inflate(d.h.album_video_item_view, viewGroup, false);
                cVar2.rootView = view;
                cVar2.hut = (TbImageView) view.findViewById(d.g.video_thumb);
                cVar2.hut.setDefaultResource(0);
                cVar2.hut.setDefaultErrorResource(0);
                cVar2.hut.setTagPaddingDis(8, 8);
                cVar2.hut.setGifIconSupport(false);
                cVar2.hut.setLongIconSupport(false);
                cVar2.cVX = (ImageView) view.findViewById(d.g.select_icon);
                cVar2.huu = (RelativeLayout) view.findViewById(d.g.video_select);
                cVar2.huv = (TextView) view.findViewById(d.g.video_play_time);
                view.setTag(cVar2);
                cVar = cVar2;
            } else {
                cVar = (c) view.getTag();
            }
            cVar.hut.startLoad(videoFileInfo.videoPath, 37, false);
            cVar.huv.setText(ap.da(videoFileInfo.videoDuration));
            a(cVar.cVX, mediaFileInfo);
            b bVar = new b(mediaFileInfo, i);
            cVar.hut.setOnClickListener(bVar);
            cVar.huu.setOnClickListener(bVar);
        }
        return view;
    }

    private void a(ImageView imageView, MediaFileInfo mediaFileInfo) {
        boolean z = false;
        if (this.huh != null && (mediaFileInfo instanceof ImageFileInfo)) {
            z = this.huh.isAdded((ImageFileInfo) mediaFileInfo);
        } else if (this.huh != null && (mediaFileInfo instanceof VideoFileInfo)) {
            z = this.huh.b((VideoFileInfo) mediaFileInfo);
        }
        d(imageView, z);
    }

    public void d(ImageView imageView, boolean z) {
        if (imageView != null) {
            if (z) {
                imageView.setContentDescription(this.htN.getResources().getString(d.j.check_box_checked));
                am.c(imageView, d.f.icon_list_select_ok_n);
                return;
            }
            imageView.setContentDescription(this.htN.getResources().getString(d.j.check_box_not_checked));
            am.c(imageView, d.f.icon_list_select_n);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        private MediaFileInfo hus;
        private int position;

        public b(MediaFileInfo mediaFileInfo, int i) {
            this.hus = mediaFileInfo;
            this.position = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == d.g.pic) {
                if (h.this.huk != null && this.hus != null) {
                    h.this.huk.a(this.position, this.hus);
                }
            } else if (view.getId() == d.g.lay_select) {
                if (this.hus != null && h.this.hul != null) {
                    h.this.hul.b(this.position, this.hus);
                }
            } else if (view.getId() == d.g.video_thumb) {
                if (h.this.huk != null && this.hus != null) {
                    h.this.huk.a(this.position, this.hus);
                }
            } else if (view.getId() == d.g.video_select && this.hus != null && h.this.hul != null) {
                h.this.hul.b(this.position, this.hus);
            }
        }
    }

    public boolean isScroll() {
        return this.fni;
    }

    public void je(boolean z) {
        this.fni = z;
    }

    public void a(f fVar) {
        this.huk = fVar;
    }

    public void a(g gVar) {
        this.hul = gVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a {
        TbImageView hup;
        TbCameraView huq;
        View rootView;

        private a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class d {
        TbImageView cVW;
        ImageView cVX;
        RelativeLayout gUa;
        View rootView;

        private d() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class c {
        ImageView cVX;
        TbImageView hut;
        RelativeLayout huu;
        TextView huv;
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

    public void X(View.OnClickListener onClickListener) {
        this.huj = onClickListener;
    }

    public void setOnRequestPermissionListener(TbCameraView.c cVar) {
        this.hum = cVar;
    }

    public void setOnOpenCameraFailedListener(TbCameraView.a aVar) {
        this.hun = aVar;
    }

    public void nv(boolean z) {
        if (this.hui != z) {
            this.hui = z;
            notifyDataSetChanged();
        }
    }
}
