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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.write.album.TbCameraView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class h extends BaseAdapter {
    private AlbumActivity jNL;
    private com.baidu.tieba.write.album.c jNV;
    private View.OnClickListener jNX;
    private f jNY;
    private g jNZ;
    private TbCameraView.c jOa;
    private TbCameraView.a jOb;
    private a jOc;
    private LayoutInflater mLayoutInflater;
    private final List<MediaFileInfo> mDataList = new ArrayList();
    private boolean apR = false;
    private boolean jNW = true;

    public TbCameraView cyh() {
        if (this.jOc != null) {
            return this.jOc.jOe;
        }
        return null;
    }

    public h(AlbumActivity albumActivity, com.baidu.tieba.write.album.c cVar) {
        this.jNL = albumActivity;
        this.jNV = cVar;
        this.mLayoutInflater = LayoutInflater.from(this.jNL.getPageContext().getPageActivity());
    }

    public void setData(List<MediaFileInfo> list) {
        this.mDataList.clear();
        if (this.jNW) {
            this.mDataList.add(cyi());
        }
        if (!v.isEmpty(list)) {
            this.mDataList.addAll(list);
        }
        notifyDataSetChanged();
    }

    private MediaFileInfo cyi() {
        return new AddMediaInfo();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return v.getCount(this.mDataList);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: Bx */
    public MediaFileInfo getItem(int i) {
        return (MediaFileInfo) v.getItem(this.mDataList, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        MediaFileInfo mediaFileInfo = (MediaFileInfo) v.getItem(this.mDataList, i);
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
            if (this.jOc == null || this.jOc.jOe == null) {
                this.jOc = new a();
                View inflate = this.mLayoutInflater.inflate(R.layout.album_make_picture_view, viewGroup, false);
                this.jOc.rootView = inflate;
                this.jOc.jOe = (TbCameraView) inflate.findViewById(R.id.camera_surfaceview);
                this.jOc.jOd = (TbImageView) inflate.findViewById(R.id.icon_make_photo);
                this.jOc.jOd.setDefaultResource(0);
                this.jOc.jOd.setDefaultErrorResource(0);
                this.jOc.jOd.setGifIconSupport(false);
                this.jOc.jOd.setLongIconSupport(false);
                inflate.setTag(this.jOc);
                this.jNL.showTip(this.jOc.jOd);
            }
            this.jOc.jOe.setOnRequestPermissionListener(this.jOa);
            this.jOc.jOe.setOnOpenCameraFailedListener(this.jOb);
            this.jOc.jOd.setOnClickListener(this.jNX);
            this.jOc.jOe.setOnClickListener(this.jNX);
            this.jOc.rootView.setOnClickListener(this.jNX);
            am.setImageResource(this.jOc.jOd, R.drawable.icon_album_camera);
            am.setBackgroundColor(this.jOc.rootView, R.color.black_alpha90);
            return this.jOc.rootView;
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
                dVar2.fhu = (TbImageView) view.findViewById(R.id.pic);
                dVar2.fhu.setDefaultResource(0);
                dVar2.fhu.setDefaultErrorResource(0);
                dVar2.fhu.setTagPaddingDis(8, 8);
                dVar2.fhu.setGifIconSupport(true);
                dVar2.fhu.setLongIconSupport(true);
                dVar2.apX = (ImageView) view.findViewById(R.id.select_icon);
                dVar2.apY = (RelativeLayout) view.findViewById(R.id.lay_select);
                if (this.jNV != null && this.jNV.getWriteImagesInfo() != null && this.jNV.getWriteImagesInfo().isFromQRCode()) {
                    dVar2.apY.setVisibility(8);
                }
                view.setTag(dVar2);
                dVar = dVar2;
            } else {
                dVar = (d) view.getTag();
            }
            dVar.fhu.setIsLongPic(imageFileInfo.isLong());
            dVar.fhu.startLoad(imageFileInfo.getFilePath(), 35, false);
            a(dVar.apX, mediaFileInfo);
            b bVar = new b(mediaFileInfo, i);
            dVar.fhu.setOnClickListener(bVar);
            dVar.apY.setOnClickListener(bVar);
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
                cVar2.jOh = (TbImageView) view.findViewById(R.id.video_thumb);
                cVar2.jOh.setDefaultResource(0);
                cVar2.jOh.setDefaultErrorResource(0);
                cVar2.jOh.setTagPaddingDis(8, 8);
                cVar2.jOh.setGifIconSupport(false);
                cVar2.jOh.setLongIconSupport(false);
                cVar2.apX = (ImageView) view.findViewById(R.id.select_icon);
                cVar2.jOi = (RelativeLayout) view.findViewById(R.id.video_select);
                cVar2.jOj = (TextView) view.findViewById(R.id.video_play_time);
                view.setTag(cVar2);
                cVar = cVar2;
            } else {
                cVar = (c) view.getTag();
            }
            cVar.jOh.startLoad(videoFileInfo.videoPath, 37, false);
            cVar.jOj.setText(aq.stringForVideoTime(videoFileInfo.videoDuration));
            a(cVar.apX, mediaFileInfo);
            b bVar = new b(mediaFileInfo, i);
            cVar.jOh.setOnClickListener(bVar);
            cVar.jOi.setOnClickListener(bVar);
        }
        return view;
    }

    private void a(ImageView imageView, MediaFileInfo mediaFileInfo) {
        boolean z = false;
        if (this.jNV != null && (mediaFileInfo instanceof ImageFileInfo)) {
            z = this.jNV.isAdded((ImageFileInfo) mediaFileInfo);
        } else if (this.jNV != null && (mediaFileInfo instanceof VideoFileInfo)) {
            z = this.jNV.b((VideoFileInfo) mediaFileInfo);
        }
        b(imageView, z);
    }

    public void b(ImageView imageView, boolean z) {
        if (imageView != null) {
            if (z) {
                imageView.setContentDescription(this.jNL.getResources().getString(R.string.check_box_checked));
                am.setImageResource(imageView, R.drawable.icon_list_select_ok_n);
                return;
            }
            imageView.setContentDescription(this.jNL.getResources().getString(R.string.check_box_not_checked));
            am.setImageResource(imageView, R.drawable.icon_list_select_n);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        private MediaFileInfo jOg;
        private int position;

        public b(MediaFileInfo mediaFileInfo, int i) {
            this.jOg = mediaFileInfo;
            this.position = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.pic) {
                if (h.this.jNY != null && this.jOg != null) {
                    h.this.jNY.a(this.position, this.jOg);
                }
            } else if (view.getId() == R.id.lay_select) {
                if (this.jOg != null && h.this.jNZ != null) {
                    h.this.jNZ.b(this.position, this.jOg);
                }
            } else if (view.getId() == R.id.video_thumb) {
                if (h.this.jNY != null && this.jOg != null) {
                    h.this.jNY.a(this.position, this.jOg);
                }
            } else if (view.getId() == R.id.video_select && this.jOg != null && h.this.jNZ != null) {
                h.this.jNZ.b(this.position, this.jOg);
            }
        }
    }

    public boolean isScroll() {
        return this.apR;
    }

    public void aT(boolean z) {
        this.apR = z;
    }

    public void a(f fVar) {
        this.jNY = fVar;
    }

    public void a(g gVar) {
        this.jNZ = gVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a {
        TbImageView jOd;
        TbCameraView jOe;
        View rootView;

        private a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class d {
        ImageView apX;
        RelativeLayout apY;
        TbImageView fhu;
        View rootView;

        private d() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class c {
        ImageView apX;
        TbImageView jOh;
        RelativeLayout jOi;
        TextView jOj;
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

    public void ae(View.OnClickListener onClickListener) {
        this.jNX = onClickListener;
    }

    public void setOnRequestPermissionListener(TbCameraView.c cVar) {
        this.jOa = cVar;
    }

    public void setOnOpenCameraFailedListener(TbCameraView.a aVar) {
        this.jOb = aVar;
    }

    public void rQ(boolean z) {
        if (this.jNW != z) {
            this.jNW = z;
            notifyDataSetChanged();
        }
    }
}
