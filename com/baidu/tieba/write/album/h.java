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
import com.baidu.tieba.f;
import com.baidu.tieba.write.album.TbCameraView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class h extends BaseAdapter {
    private AlbumActivity htP;
    private com.baidu.tieba.write.album.c huj;
    private View.OnClickListener hul;
    private f hum;
    private g hun;
    private TbCameraView.c huo;
    private TbCameraView.a hup;
    private a huq;
    private LayoutInflater mLayoutInflater;
    private final List<MediaFileInfo> mDataList = new ArrayList();
    private boolean fnc = false;
    private boolean huk = true;

    public TbCameraView bGg() {
        if (this.huq != null) {
            return this.huq.hus;
        }
        return null;
    }

    public h(AlbumActivity albumActivity, com.baidu.tieba.write.album.c cVar) {
        this.htP = albumActivity;
        this.huj = cVar;
        this.mLayoutInflater = LayoutInflater.from(this.htP.getPageContext().getPageActivity());
    }

    public void setData(List<MediaFileInfo> list) {
        this.mDataList.clear();
        if (this.huk) {
            this.mDataList.add(bGh());
        }
        if (!w.z(list)) {
            this.mDataList.addAll(list);
        }
        notifyDataSetChanged();
    }

    private MediaFileInfo bGh() {
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
            if (this.huq == null || this.huq.hus == null) {
                this.huq = new a();
                View inflate = this.mLayoutInflater.inflate(f.h.album_make_picture_view, viewGroup, false);
                this.huq.rootView = inflate;
                this.huq.hus = (TbCameraView) inflate.findViewById(f.g.camera_surfaceview);
                this.huq.hur = (TbImageView) inflate.findViewById(f.g.icon_make_photo);
                this.huq.hur.setDefaultResource(0);
                this.huq.hur.setDefaultErrorResource(0);
                this.huq.hur.setGifIconSupport(false);
                this.huq.hur.setLongIconSupport(false);
                inflate.setTag(this.huq);
                this.htP.showTip(this.huq.hur);
            }
            this.huq.hus.setOnRequestPermissionListener(this.huo);
            this.huq.hus.setOnOpenCameraFailedListener(this.hup);
            this.huq.hur.setOnClickListener(this.hul);
            this.huq.hus.setOnClickListener(this.hul);
            this.huq.rootView.setOnClickListener(this.hul);
            am.c(this.huq.hur, f.C0146f.icon_album_camera);
            am.j(this.huq.rootView, f.d.black_alpha90);
            return this.huq.rootView;
        }
        return view;
    }

    private View b(int i, View view, ViewGroup viewGroup, MediaFileInfo mediaFileInfo) {
        d dVar;
        if (mediaFileInfo != null && mediaFileInfo.getType() == 0 && (mediaFileInfo instanceof ImageFileInfo)) {
            ImageFileInfo imageFileInfo = (ImageFileInfo) mediaFileInfo;
            if (view == null || !(view.getTag() instanceof d)) {
                d dVar2 = new d();
                view = this.mLayoutInflater.inflate(f.h.album_image_item_view, viewGroup, false);
                dVar2.rootView = view;
                dVar2.cVS = (TbImageView) view.findViewById(f.g.pic);
                dVar2.cVS.setDefaultResource(0);
                dVar2.cVS.setDefaultErrorResource(0);
                dVar2.cVS.setTagPaddingDis(8, 8);
                dVar2.cVS.setGifIconSupport(true);
                dVar2.cVS.setLongIconSupport(true);
                dVar2.cVT = (ImageView) view.findViewById(f.g.select_icon);
                dVar2.gUc = (RelativeLayout) view.findViewById(f.g.lay_select);
                view.setTag(dVar2);
                dVar = dVar2;
            } else {
                dVar = (d) view.getTag();
            }
            dVar.cVS.setIsLongPic(imageFileInfo.isLong());
            dVar.cVS.startLoad(imageFileInfo.getFilePath(), 35, false);
            a(dVar.cVT, mediaFileInfo);
            b bVar = new b(mediaFileInfo, i);
            dVar.cVS.setOnClickListener(bVar);
            dVar.gUc.setOnClickListener(bVar);
        }
        return view;
    }

    private View c(int i, View view, ViewGroup viewGroup, MediaFileInfo mediaFileInfo) {
        c cVar;
        if (mediaFileInfo != null && mediaFileInfo.getType() == 1 && (mediaFileInfo instanceof VideoFileInfo)) {
            VideoFileInfo videoFileInfo = (VideoFileInfo) mediaFileInfo;
            if (view == null || !(view.getTag() instanceof d)) {
                c cVar2 = new c();
                view = this.mLayoutInflater.inflate(f.h.album_video_item_view, viewGroup, false);
                cVar2.rootView = view;
                cVar2.huv = (TbImageView) view.findViewById(f.g.video_thumb);
                cVar2.huv.setDefaultResource(0);
                cVar2.huv.setDefaultErrorResource(0);
                cVar2.huv.setTagPaddingDis(8, 8);
                cVar2.huv.setGifIconSupport(false);
                cVar2.huv.setLongIconSupport(false);
                cVar2.cVT = (ImageView) view.findViewById(f.g.select_icon);
                cVar2.huw = (RelativeLayout) view.findViewById(f.g.video_select);
                cVar2.hux = (TextView) view.findViewById(f.g.video_play_time);
                view.setTag(cVar2);
                cVar = cVar2;
            } else {
                cVar = (c) view.getTag();
            }
            cVar.huv.startLoad(videoFileInfo.videoPath, 37, false);
            cVar.hux.setText(ap.da(videoFileInfo.videoDuration));
            a(cVar.cVT, mediaFileInfo);
            b bVar = new b(mediaFileInfo, i);
            cVar.huv.setOnClickListener(bVar);
            cVar.huw.setOnClickListener(bVar);
        }
        return view;
    }

    private void a(ImageView imageView, MediaFileInfo mediaFileInfo) {
        boolean z = false;
        if (this.huj != null && (mediaFileInfo instanceof ImageFileInfo)) {
            z = this.huj.isAdded((ImageFileInfo) mediaFileInfo);
        } else if (this.huj != null && (mediaFileInfo instanceof VideoFileInfo)) {
            z = this.huj.b((VideoFileInfo) mediaFileInfo);
        }
        d(imageView, z);
    }

    public void d(ImageView imageView, boolean z) {
        if (imageView != null) {
            if (z) {
                imageView.setContentDescription(this.htP.getResources().getString(f.j.check_box_checked));
                am.c(imageView, f.C0146f.icon_list_select_ok_n);
                return;
            }
            imageView.setContentDescription(this.htP.getResources().getString(f.j.check_box_not_checked));
            am.c(imageView, f.C0146f.icon_list_select_n);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        private MediaFileInfo huu;
        private int position;

        public b(MediaFileInfo mediaFileInfo, int i) {
            this.huu = mediaFileInfo;
            this.position = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == f.g.pic) {
                if (h.this.hum != null && this.huu != null) {
                    h.this.hum.a(this.position, this.huu);
                }
            } else if (view.getId() == f.g.lay_select) {
                if (this.huu != null && h.this.hun != null) {
                    h.this.hun.b(this.position, this.huu);
                }
            } else if (view.getId() == f.g.video_thumb) {
                if (h.this.hum != null && this.huu != null) {
                    h.this.hum.a(this.position, this.huu);
                }
            } else if (view.getId() == f.g.video_select && this.huu != null && h.this.hun != null) {
                h.this.hun.b(this.position, this.huu);
            }
        }
    }

    public boolean isScroll() {
        return this.fnc;
    }

    public void je(boolean z) {
        this.fnc = z;
    }

    public void a(f fVar) {
        this.hum = fVar;
    }

    public void a(g gVar) {
        this.hun = gVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a {
        TbImageView hur;
        TbCameraView hus;
        View rootView;

        private a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class d {
        TbImageView cVS;
        ImageView cVT;
        RelativeLayout gUc;
        View rootView;

        private d() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class c {
        ImageView cVT;
        TbImageView huv;
        RelativeLayout huw;
        TextView hux;
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
        this.hul = onClickListener;
    }

    public void setOnRequestPermissionListener(TbCameraView.c cVar) {
        this.huo = cVar;
    }

    public void setOnOpenCameraFailedListener(TbCameraView.a aVar) {
        this.hup = aVar;
    }

    public void nv(boolean z) {
        if (this.huk != z) {
            this.huk = z;
            notifyDataSetChanged();
        }
    }
}
