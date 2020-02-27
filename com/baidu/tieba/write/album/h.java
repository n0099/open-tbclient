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
/* loaded from: classes13.dex */
public class h extends BaseAdapter {
    private AlbumActivity kML;
    private com.baidu.tieba.write.album.c kMV;
    private View.OnClickListener kMX;
    private f kMY;
    private g kMZ;
    private TbCameraView.c kNa;
    private TbCameraView.a kNb;
    private a kNc;
    private LayoutInflater mLayoutInflater;
    private final List<MediaFileInfo> mDataList = new ArrayList();
    private boolean aCG = false;
    private boolean kMW = true;

    public TbCameraView cUC() {
        if (this.kNc != null) {
            return this.kNc.kNe;
        }
        return null;
    }

    public h(AlbumActivity albumActivity, com.baidu.tieba.write.album.c cVar) {
        this.kML = albumActivity;
        this.kMV = cVar;
        this.mLayoutInflater = LayoutInflater.from(this.kML.getPageContext().getPageActivity());
    }

    public void setData(List<MediaFileInfo> list) {
        this.mDataList.clear();
        if (this.kMW) {
            this.mDataList.add(cUD());
        }
        if (!v.isEmpty(list)) {
            this.mDataList.addAll(list);
        }
        notifyDataSetChanged();
    }

    private MediaFileInfo cUD() {
        return new AddMediaInfo();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return v.getCount(this.mDataList);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: Ee */
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
            if (this.kNc == null || this.kNc.kNe == null) {
                this.kNc = new a();
                View inflate = this.mLayoutInflater.inflate(R.layout.album_make_picture_view, viewGroup, false);
                this.kNc.rootView = inflate;
                this.kNc.kNe = (TbCameraView) inflate.findViewById(R.id.camera_surfaceview);
                this.kNc.kNd = (TbImageView) inflate.findViewById(R.id.icon_make_photo);
                this.kNc.kNd.setDefaultResource(0);
                this.kNc.kNd.setDefaultErrorResource(0);
                this.kNc.kNd.setGifIconSupport(false);
                this.kNc.kNd.setLongIconSupport(false);
                inflate.setTag(this.kNc);
                this.kML.showTip(this.kNc.kNd);
            }
            this.kNc.kNe.setOnRequestPermissionListener(this.kNa);
            this.kNc.kNe.setOnOpenCameraFailedListener(this.kNb);
            this.kNc.kNd.setOnClickListener(this.kMX);
            this.kNc.kNe.setOnClickListener(this.kMX);
            this.kNc.rootView.setOnClickListener(this.kMX);
            am.setImageResource(this.kNc.kNd, R.drawable.icon_album_camera);
            am.setBackgroundColor(this.kNc.rootView, R.color.black_alpha90);
            return this.kNc.rootView;
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
                dVar2.gbf = (TbImageView) view.findViewById(R.id.pic);
                dVar2.gbf.setDefaultResource(0);
                dVar2.gbf.setDefaultErrorResource(0);
                dVar2.gbf.setTagPaddingDis(8, 8);
                dVar2.gbf.setGifIconSupport(true);
                dVar2.gbf.setLongIconSupport(true);
                dVar2.aCM = (ImageView) view.findViewById(R.id.select_icon);
                dVar2.aCN = (RelativeLayout) view.findViewById(R.id.lay_select);
                if (this.kMV != null && this.kMV.getWriteImagesInfo() != null && this.kMV.getWriteImagesInfo().isFromQRCode()) {
                    dVar2.aCN.setVisibility(8);
                }
                view.setTag(dVar2);
                dVar = dVar2;
            } else {
                dVar = (d) view.getTag();
            }
            dVar.gbf.setIsLongPic(imageFileInfo.isLong());
            dVar.gbf.startLoad(imageFileInfo.getFilePath(), 35, false);
            a(dVar.aCM, mediaFileInfo);
            b bVar = new b(mediaFileInfo, i);
            dVar.gbf.setOnClickListener(bVar);
            dVar.aCN.setOnClickListener(bVar);
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
                cVar2.kNh = (TbImageView) view.findViewById(R.id.video_thumb);
                cVar2.kNh.setDefaultResource(0);
                cVar2.kNh.setDefaultErrorResource(0);
                cVar2.kNh.setTagPaddingDis(8, 8);
                cVar2.kNh.setGifIconSupport(false);
                cVar2.kNh.setLongIconSupport(false);
                cVar2.aCM = (ImageView) view.findViewById(R.id.select_icon);
                cVar2.kNi = (RelativeLayout) view.findViewById(R.id.video_select);
                cVar2.kNj = (TextView) view.findViewById(R.id.video_play_time);
                view.setTag(cVar2);
                cVar = cVar2;
            } else {
                cVar = (c) view.getTag();
            }
            cVar.kNh.startLoad(videoFileInfo.videoPath, 37, false);
            cVar.kNj.setText(aq.stringForVideoTime(videoFileInfo.videoDuration));
            a(cVar.aCM, mediaFileInfo);
            b bVar = new b(mediaFileInfo, i);
            cVar.kNh.setOnClickListener(bVar);
            cVar.kNi.setOnClickListener(bVar);
        }
        return view;
    }

    private void a(ImageView imageView, MediaFileInfo mediaFileInfo) {
        boolean z = false;
        if (this.kMV != null && (mediaFileInfo instanceof ImageFileInfo)) {
            z = this.kMV.isAdded((ImageFileInfo) mediaFileInfo);
        } else if (this.kMV != null && (mediaFileInfo instanceof VideoFileInfo)) {
            z = this.kMV.b((VideoFileInfo) mediaFileInfo);
        }
        b(imageView, z);
    }

    public void b(ImageView imageView, boolean z) {
        if (imageView != null) {
            if (z) {
                imageView.setContentDescription(this.kML.getResources().getString(R.string.check_box_checked));
                am.setImageResource(imageView, R.drawable.icon_list_select_ok_n);
                return;
            }
            imageView.setContentDescription(this.kML.getResources().getString(R.string.check_box_not_checked));
            am.setImageResource(imageView, R.drawable.icon_list_select_n);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes13.dex */
    public class b implements View.OnClickListener {
        private MediaFileInfo kNg;
        private int position;

        public b(MediaFileInfo mediaFileInfo, int i) {
            this.kNg = mediaFileInfo;
            this.position = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.pic) {
                if (h.this.kMY != null && this.kNg != null) {
                    h.this.kMY.a(this.position, this.kNg);
                }
            } else if (view.getId() == R.id.lay_select) {
                if (this.kNg != null && h.this.kMZ != null) {
                    h.this.kMZ.b(this.position, this.kNg);
                }
            } else if (view.getId() == R.id.video_thumb) {
                if (h.this.kMY != null && this.kNg != null) {
                    h.this.kMY.a(this.position, this.kNg);
                }
            } else if (view.getId() == R.id.video_select && this.kNg != null && h.this.kMZ != null) {
                h.this.kMZ.b(this.position, this.kNg);
            }
        }
    }

    public boolean isScroll() {
        return this.aCG;
    }

    public void bw(boolean z) {
        this.aCG = z;
    }

    public void a(f fVar) {
        this.kMY = fVar;
    }

    public void a(g gVar) {
        this.kMZ = gVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes13.dex */
    public class a {
        TbImageView kNd;
        TbCameraView kNe;
        View rootView;

        private a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes13.dex */
    public class d {
        ImageView aCM;
        RelativeLayout aCN;
        TbImageView gbf;
        View rootView;

        private d() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes13.dex */
    public class c {
        ImageView aCM;
        TbImageView kNh;
        RelativeLayout kNi;
        TextView kNj;
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

    public void af(View.OnClickListener onClickListener) {
        this.kMX = onClickListener;
    }

    public void setOnRequestPermissionListener(TbCameraView.c cVar) {
        this.kNa = cVar;
    }

    public void setOnOpenCameraFailedListener(TbCameraView.a aVar) {
        this.kNb = aVar;
    }

    public void tM(boolean z) {
        if (this.kMW != z) {
            this.kMW = z;
            notifyDataSetChanged();
        }
    }
}
