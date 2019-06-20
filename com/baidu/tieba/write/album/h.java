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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.write.album.TbCameraView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class h extends BaseAdapter {
    private AlbumActivity jFS;
    private com.baidu.tieba.write.album.c jGm;
    private View.OnClickListener jGo;
    private f jGp;
    private g jGq;
    private TbCameraView.c jGr;
    private TbCameraView.a jGs;
    private a jGt;
    private LayoutInflater mLayoutInflater;
    private final List<MediaFileInfo> mDataList = new ArrayList();
    private boolean hvy = false;
    private boolean jGn = true;

    public TbCameraView cxk() {
        if (this.jGt != null) {
            return this.jGt.jGv;
        }
        return null;
    }

    public h(AlbumActivity albumActivity, com.baidu.tieba.write.album.c cVar) {
        this.jFS = albumActivity;
        this.jGm = cVar;
        this.mLayoutInflater = LayoutInflater.from(this.jFS.getPageContext().getPageActivity());
    }

    public void setData(List<MediaFileInfo> list) {
        this.mDataList.clear();
        if (this.jGn) {
            this.mDataList.add(cxl());
        }
        if (!v.aa(list)) {
            this.mDataList.addAll(list);
        }
        notifyDataSetChanged();
    }

    private MediaFileInfo cxl() {
        return new AddMediaInfo();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return v.Z(this.mDataList);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: Cn */
    public MediaFileInfo getItem(int i) {
        return (MediaFileInfo) v.c(this.mDataList, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        MediaFileInfo mediaFileInfo = (MediaFileInfo) v.c(this.mDataList, i);
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
            if (this.jGt == null || this.jGt.jGv == null) {
                this.jGt = new a();
                View inflate = this.mLayoutInflater.inflate(R.layout.album_make_picture_view, viewGroup, false);
                this.jGt.rootView = inflate;
                this.jGt.jGv = (TbCameraView) inflate.findViewById(R.id.camera_surfaceview);
                this.jGt.jGu = (TbImageView) inflate.findViewById(R.id.icon_make_photo);
                this.jGt.jGu.setDefaultResource(0);
                this.jGt.jGu.setDefaultErrorResource(0);
                this.jGt.jGu.setGifIconSupport(false);
                this.jGt.jGu.setLongIconSupport(false);
                inflate.setTag(this.jGt);
                this.jFS.showTip(this.jGt.jGu);
            }
            this.jGt.jGv.setOnRequestPermissionListener(this.jGr);
            this.jGt.jGv.setOnOpenCameraFailedListener(this.jGs);
            this.jGt.jGu.setOnClickListener(this.jGo);
            this.jGt.jGv.setOnClickListener(this.jGo);
            this.jGt.rootView.setOnClickListener(this.jGo);
            al.c(this.jGt.jGu, (int) R.drawable.icon_album_camera);
            al.l(this.jGt.rootView, R.color.black_alpha90);
            return this.jGt.rootView;
        }
        return view;
    }

    private View b(int i, View view, ViewGroup viewGroup, MediaFileInfo mediaFileInfo) {
        d dVar;
        if (mediaFileInfo != null && mediaFileInfo.getType() == 0 && (mediaFileInfo instanceof ImageFileInfo)) {
            ImageFileInfo imageFileInfo = (ImageFileInfo) mediaFileInfo;
            if (view == null || !(view.getTag() instanceof d)) {
                d dVar2 = new d();
                view = this.mLayoutInflater.inflate(R.layout.album_image_item_view, viewGroup, false);
                dVar2.rootView = view;
                dVar2.eYk = (TbImageView) view.findViewById(R.id.pic);
                dVar2.eYk.setDefaultResource(0);
                dVar2.eYk.setDefaultErrorResource(0);
                dVar2.eYk.setTagPaddingDis(8, 8);
                dVar2.eYk.setGifIconSupport(true);
                dVar2.eYk.setLongIconSupport(true);
                dVar2.eYl = (ImageView) view.findViewById(R.id.select_icon);
                dVar2.jfT = (RelativeLayout) view.findViewById(R.id.lay_select);
                if (this.jGm != null && this.jGm.getWriteImagesInfo() != null && this.jGm.getWriteImagesInfo().isFromQRCode()) {
                    dVar2.jfT.setVisibility(8);
                }
                view.setTag(dVar2);
                dVar = dVar2;
            } else {
                dVar = (d) view.getTag();
            }
            dVar.eYk.setIsLongPic(imageFileInfo.isLong());
            dVar.eYk.startLoad(imageFileInfo.getFilePath(), 35, false);
            a(dVar.eYl, mediaFileInfo);
            b bVar = new b(mediaFileInfo, i);
            dVar.eYk.setOnClickListener(bVar);
            dVar.jfT.setOnClickListener(bVar);
        }
        return view;
    }

    private View c(int i, View view, ViewGroup viewGroup, MediaFileInfo mediaFileInfo) {
        c cVar;
        if (mediaFileInfo != null && mediaFileInfo.getType() == 1 && (mediaFileInfo instanceof VideoFileInfo)) {
            VideoFileInfo videoFileInfo = (VideoFileInfo) mediaFileInfo;
            if (view == null || !(view.getTag() instanceof d)) {
                c cVar2 = new c();
                view = this.mLayoutInflater.inflate(R.layout.album_video_item_view, viewGroup, false);
                cVar2.rootView = view;
                cVar2.jGy = (TbImageView) view.findViewById(R.id.video_thumb);
                cVar2.jGy.setDefaultResource(0);
                cVar2.jGy.setDefaultErrorResource(0);
                cVar2.jGy.setTagPaddingDis(8, 8);
                cVar2.jGy.setGifIconSupport(false);
                cVar2.jGy.setLongIconSupport(false);
                cVar2.eYl = (ImageView) view.findViewById(R.id.select_icon);
                cVar2.jGz = (RelativeLayout) view.findViewById(R.id.video_select);
                cVar2.jGA = (TextView) view.findViewById(R.id.video_play_time);
                view.setTag(cVar2);
                cVar = cVar2;
            } else {
                cVar = (c) view.getTag();
            }
            cVar.jGy.startLoad(videoFileInfo.videoPath, 37, false);
            cVar.jGA.setText(ap.im(videoFileInfo.videoDuration));
            a(cVar.eYl, mediaFileInfo);
            b bVar = new b(mediaFileInfo, i);
            cVar.jGy.setOnClickListener(bVar);
            cVar.jGz.setOnClickListener(bVar);
        }
        return view;
    }

    private void a(ImageView imageView, MediaFileInfo mediaFileInfo) {
        boolean z = false;
        if (this.jGm != null && (mediaFileInfo instanceof ImageFileInfo)) {
            z = this.jGm.isAdded((ImageFileInfo) mediaFileInfo);
        } else if (this.jGm != null && (mediaFileInfo instanceof VideoFileInfo)) {
            z = this.jGm.b((VideoFileInfo) mediaFileInfo);
        }
        d(imageView, z);
    }

    public void d(ImageView imageView, boolean z) {
        if (imageView != null) {
            if (z) {
                imageView.setContentDescription(this.jFS.getResources().getString(R.string.check_box_checked));
                al.c(imageView, (int) R.drawable.icon_list_select_ok_n);
                return;
            }
            imageView.setContentDescription(this.jFS.getResources().getString(R.string.check_box_not_checked));
            al.c(imageView, (int) R.drawable.icon_list_select_n);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        private MediaFileInfo jGx;
        private int position;

        public b(MediaFileInfo mediaFileInfo, int i) {
            this.jGx = mediaFileInfo;
            this.position = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.pic) {
                if (h.this.jGp != null && this.jGx != null) {
                    h.this.jGp.a(this.position, this.jGx);
                }
            } else if (view.getId() == R.id.lay_select) {
                if (this.jGx != null && h.this.jGq != null) {
                    h.this.jGq.b(this.position, this.jGx);
                }
            } else if (view.getId() == R.id.video_thumb) {
                if (h.this.jGp != null && this.jGx != null) {
                    h.this.jGp.a(this.position, this.jGx);
                }
            } else if (view.getId() == R.id.video_select && this.jGx != null && h.this.jGq != null) {
                h.this.jGq.b(this.position, this.jGx);
            }
        }
    }

    public boolean isScroll() {
        return this.hvy;
    }

    public void nB(boolean z) {
        this.hvy = z;
    }

    public void a(f fVar) {
        this.jGp = fVar;
    }

    public void a(g gVar) {
        this.jGq = gVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a {
        TbImageView jGu;
        TbCameraView jGv;
        View rootView;

        private a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class d {
        TbImageView eYk;
        ImageView eYl;
        RelativeLayout jfT;
        View rootView;

        private d() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class c {
        ImageView eYl;
        TextView jGA;
        TbImageView jGy;
        RelativeLayout jGz;
        View rootView;

        private c() {
        }
    }

    public int i(ImageFileInfo imageFileInfo) {
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

    public void ab(View.OnClickListener onClickListener) {
        this.jGo = onClickListener;
    }

    public void setOnRequestPermissionListener(TbCameraView.c cVar) {
        this.jGr = cVar;
    }

    public void setOnOpenCameraFailedListener(TbCameraView.a aVar) {
        this.jGs = aVar;
    }

    public void rS(boolean z) {
        if (this.jGn != z) {
            this.jGn = z;
            notifyDataSetChanged();
        }
    }
}
