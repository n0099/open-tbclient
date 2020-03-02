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
    private AlbumActivity kMN;
    private com.baidu.tieba.write.album.c kMX;
    private View.OnClickListener kMZ;
    private f kNa;
    private g kNb;
    private TbCameraView.c kNc;
    private TbCameraView.a kNd;
    private a kNe;
    private LayoutInflater mLayoutInflater;
    private final List<MediaFileInfo> mDataList = new ArrayList();
    private boolean aCH = false;
    private boolean kMY = true;

    public TbCameraView cUE() {
        if (this.kNe != null) {
            return this.kNe.kNg;
        }
        return null;
    }

    public h(AlbumActivity albumActivity, com.baidu.tieba.write.album.c cVar) {
        this.kMN = albumActivity;
        this.kMX = cVar;
        this.mLayoutInflater = LayoutInflater.from(this.kMN.getPageContext().getPageActivity());
    }

    public void setData(List<MediaFileInfo> list) {
        this.mDataList.clear();
        if (this.kMY) {
            this.mDataList.add(cUF());
        }
        if (!v.isEmpty(list)) {
            this.mDataList.addAll(list);
        }
        notifyDataSetChanged();
    }

    private MediaFileInfo cUF() {
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
            if (this.kNe == null || this.kNe.kNg == null) {
                this.kNe = new a();
                View inflate = this.mLayoutInflater.inflate(R.layout.album_make_picture_view, viewGroup, false);
                this.kNe.rootView = inflate;
                this.kNe.kNg = (TbCameraView) inflate.findViewById(R.id.camera_surfaceview);
                this.kNe.kNf = (TbImageView) inflate.findViewById(R.id.icon_make_photo);
                this.kNe.kNf.setDefaultResource(0);
                this.kNe.kNf.setDefaultErrorResource(0);
                this.kNe.kNf.setGifIconSupport(false);
                this.kNe.kNf.setLongIconSupport(false);
                inflate.setTag(this.kNe);
                this.kMN.showTip(this.kNe.kNf);
            }
            this.kNe.kNg.setOnRequestPermissionListener(this.kNc);
            this.kNe.kNg.setOnOpenCameraFailedListener(this.kNd);
            this.kNe.kNf.setOnClickListener(this.kMZ);
            this.kNe.kNg.setOnClickListener(this.kMZ);
            this.kNe.rootView.setOnClickListener(this.kMZ);
            am.setImageResource(this.kNe.kNf, R.drawable.icon_album_camera);
            am.setBackgroundColor(this.kNe.rootView, R.color.black_alpha90);
            return this.kNe.rootView;
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
                dVar2.gbh = (TbImageView) view.findViewById(R.id.pic);
                dVar2.gbh.setDefaultResource(0);
                dVar2.gbh.setDefaultErrorResource(0);
                dVar2.gbh.setTagPaddingDis(8, 8);
                dVar2.gbh.setGifIconSupport(true);
                dVar2.gbh.setLongIconSupport(true);
                dVar2.aCN = (ImageView) view.findViewById(R.id.select_icon);
                dVar2.aCO = (RelativeLayout) view.findViewById(R.id.lay_select);
                if (this.kMX != null && this.kMX.getWriteImagesInfo() != null && this.kMX.getWriteImagesInfo().isFromQRCode()) {
                    dVar2.aCO.setVisibility(8);
                }
                view.setTag(dVar2);
                dVar = dVar2;
            } else {
                dVar = (d) view.getTag();
            }
            dVar.gbh.setIsLongPic(imageFileInfo.isLong());
            dVar.gbh.startLoad(imageFileInfo.getFilePath(), 35, false);
            a(dVar.aCN, mediaFileInfo);
            b bVar = new b(mediaFileInfo, i);
            dVar.gbh.setOnClickListener(bVar);
            dVar.aCO.setOnClickListener(bVar);
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
                cVar2.kNj = (TbImageView) view.findViewById(R.id.video_thumb);
                cVar2.kNj.setDefaultResource(0);
                cVar2.kNj.setDefaultErrorResource(0);
                cVar2.kNj.setTagPaddingDis(8, 8);
                cVar2.kNj.setGifIconSupport(false);
                cVar2.kNj.setLongIconSupport(false);
                cVar2.aCN = (ImageView) view.findViewById(R.id.select_icon);
                cVar2.kNk = (RelativeLayout) view.findViewById(R.id.video_select);
                cVar2.kNl = (TextView) view.findViewById(R.id.video_play_time);
                view.setTag(cVar2);
                cVar = cVar2;
            } else {
                cVar = (c) view.getTag();
            }
            cVar.kNj.startLoad(videoFileInfo.videoPath, 37, false);
            cVar.kNl.setText(aq.stringForVideoTime(videoFileInfo.videoDuration));
            a(cVar.aCN, mediaFileInfo);
            b bVar = new b(mediaFileInfo, i);
            cVar.kNj.setOnClickListener(bVar);
            cVar.kNk.setOnClickListener(bVar);
        }
        return view;
    }

    private void a(ImageView imageView, MediaFileInfo mediaFileInfo) {
        boolean z = false;
        if (this.kMX != null && (mediaFileInfo instanceof ImageFileInfo)) {
            z = this.kMX.isAdded((ImageFileInfo) mediaFileInfo);
        } else if (this.kMX != null && (mediaFileInfo instanceof VideoFileInfo)) {
            z = this.kMX.b((VideoFileInfo) mediaFileInfo);
        }
        b(imageView, z);
    }

    public void b(ImageView imageView, boolean z) {
        if (imageView != null) {
            if (z) {
                imageView.setContentDescription(this.kMN.getResources().getString(R.string.check_box_checked));
                am.setImageResource(imageView, R.drawable.icon_list_select_ok_n);
                return;
            }
            imageView.setContentDescription(this.kMN.getResources().getString(R.string.check_box_not_checked));
            am.setImageResource(imageView, R.drawable.icon_list_select_n);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes13.dex */
    public class b implements View.OnClickListener {
        private MediaFileInfo kNi;
        private int position;

        public b(MediaFileInfo mediaFileInfo, int i) {
            this.kNi = mediaFileInfo;
            this.position = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.pic) {
                if (h.this.kNa != null && this.kNi != null) {
                    h.this.kNa.a(this.position, this.kNi);
                }
            } else if (view.getId() == R.id.lay_select) {
                if (this.kNi != null && h.this.kNb != null) {
                    h.this.kNb.b(this.position, this.kNi);
                }
            } else if (view.getId() == R.id.video_thumb) {
                if (h.this.kNa != null && this.kNi != null) {
                    h.this.kNa.a(this.position, this.kNi);
                }
            } else if (view.getId() == R.id.video_select && this.kNi != null && h.this.kNb != null) {
                h.this.kNb.b(this.position, this.kNi);
            }
        }
    }

    public boolean isScroll() {
        return this.aCH;
    }

    public void bw(boolean z) {
        this.aCH = z;
    }

    public void a(f fVar) {
        this.kNa = fVar;
    }

    public void a(g gVar) {
        this.kNb = gVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes13.dex */
    public class a {
        TbImageView kNf;
        TbCameraView kNg;
        View rootView;

        private a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes13.dex */
    public class d {
        ImageView aCN;
        RelativeLayout aCO;
        TbImageView gbh;
        View rootView;

        private d() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes13.dex */
    public class c {
        ImageView aCN;
        TbImageView kNj;
        RelativeLayout kNk;
        TextView kNl;
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
        this.kMZ = onClickListener;
    }

    public void setOnRequestPermissionListener(TbCameraView.c cVar) {
        this.kNc = cVar;
    }

    public void setOnOpenCameraFailedListener(TbCameraView.a aVar) {
        this.kNd = aVar;
    }

    public void tM(boolean z) {
        if (this.kMY != z) {
            this.kMY = z;
            notifyDataSetChanged();
        }
    }
}
