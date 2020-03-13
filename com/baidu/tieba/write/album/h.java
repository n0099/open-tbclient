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
    private AlbumActivity kMZ;
    private com.baidu.tieba.write.album.c kNj;
    private View.OnClickListener kNl;
    private f kNm;
    private g kNn;
    private TbCameraView.c kNo;
    private TbCameraView.a kNp;
    private a kNq;
    private LayoutInflater mLayoutInflater;
    private final List<MediaFileInfo> mDataList = new ArrayList();
    private boolean aCI = false;
    private boolean kNk = true;

    public TbCameraView cUF() {
        if (this.kNq != null) {
            return this.kNq.kNs;
        }
        return null;
    }

    public h(AlbumActivity albumActivity, com.baidu.tieba.write.album.c cVar) {
        this.kMZ = albumActivity;
        this.kNj = cVar;
        this.mLayoutInflater = LayoutInflater.from(this.kMZ.getPageContext().getPageActivity());
    }

    public void setData(List<MediaFileInfo> list) {
        this.mDataList.clear();
        if (this.kNk) {
            this.mDataList.add(cUG());
        }
        if (!v.isEmpty(list)) {
            this.mDataList.addAll(list);
        }
        notifyDataSetChanged();
    }

    private MediaFileInfo cUG() {
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
            if (this.kNq == null || this.kNq.kNs == null) {
                this.kNq = new a();
                View inflate = this.mLayoutInflater.inflate(R.layout.album_make_picture_view, viewGroup, false);
                this.kNq.rootView = inflate;
                this.kNq.kNs = (TbCameraView) inflate.findViewById(R.id.camera_surfaceview);
                this.kNq.kNr = (TbImageView) inflate.findViewById(R.id.icon_make_photo);
                this.kNq.kNr.setDefaultResource(0);
                this.kNq.kNr.setDefaultErrorResource(0);
                this.kNq.kNr.setGifIconSupport(false);
                this.kNq.kNr.setLongIconSupport(false);
                inflate.setTag(this.kNq);
                this.kMZ.showTip(this.kNq.kNr);
            }
            this.kNq.kNs.setOnRequestPermissionListener(this.kNo);
            this.kNq.kNs.setOnOpenCameraFailedListener(this.kNp);
            this.kNq.kNr.setOnClickListener(this.kNl);
            this.kNq.kNs.setOnClickListener(this.kNl);
            this.kNq.rootView.setOnClickListener(this.kNl);
            am.setImageResource(this.kNq.kNr, R.drawable.icon_album_camera);
            am.setBackgroundColor(this.kNq.rootView, R.color.black_alpha90);
            return this.kNq.rootView;
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
                dVar2.gbu = (TbImageView) view.findViewById(R.id.pic);
                dVar2.gbu.setDefaultResource(0);
                dVar2.gbu.setDefaultErrorResource(0);
                dVar2.gbu.setTagPaddingDis(8, 8);
                dVar2.gbu.setGifIconSupport(true);
                dVar2.gbu.setLongIconSupport(true);
                dVar2.aCO = (ImageView) view.findViewById(R.id.select_icon);
                dVar2.aCP = (RelativeLayout) view.findViewById(R.id.lay_select);
                if (this.kNj != null && this.kNj.getWriteImagesInfo() != null && this.kNj.getWriteImagesInfo().isFromQRCode()) {
                    dVar2.aCP.setVisibility(8);
                }
                view.setTag(dVar2);
                dVar = dVar2;
            } else {
                dVar = (d) view.getTag();
            }
            dVar.gbu.setIsLongPic(imageFileInfo.isLong());
            dVar.gbu.startLoad(imageFileInfo.getFilePath(), 35, false);
            a(dVar.aCO, mediaFileInfo);
            b bVar = new b(mediaFileInfo, i);
            dVar.gbu.setOnClickListener(bVar);
            dVar.aCP.setOnClickListener(bVar);
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
                cVar2.kNv = (TbImageView) view.findViewById(R.id.video_thumb);
                cVar2.kNv.setDefaultResource(0);
                cVar2.kNv.setDefaultErrorResource(0);
                cVar2.kNv.setTagPaddingDis(8, 8);
                cVar2.kNv.setGifIconSupport(false);
                cVar2.kNv.setLongIconSupport(false);
                cVar2.aCO = (ImageView) view.findViewById(R.id.select_icon);
                cVar2.kNw = (RelativeLayout) view.findViewById(R.id.video_select);
                cVar2.kNx = (TextView) view.findViewById(R.id.video_play_time);
                view.setTag(cVar2);
                cVar = cVar2;
            } else {
                cVar = (c) view.getTag();
            }
            cVar.kNv.startLoad(videoFileInfo.videoPath, 37, false);
            cVar.kNx.setText(aq.stringForVideoTime(videoFileInfo.videoDuration));
            a(cVar.aCO, mediaFileInfo);
            b bVar = new b(mediaFileInfo, i);
            cVar.kNv.setOnClickListener(bVar);
            cVar.kNw.setOnClickListener(bVar);
        }
        return view;
    }

    private void a(ImageView imageView, MediaFileInfo mediaFileInfo) {
        boolean z = false;
        if (this.kNj != null && (mediaFileInfo instanceof ImageFileInfo)) {
            z = this.kNj.isAdded((ImageFileInfo) mediaFileInfo);
        } else if (this.kNj != null && (mediaFileInfo instanceof VideoFileInfo)) {
            z = this.kNj.b((VideoFileInfo) mediaFileInfo);
        }
        b(imageView, z);
    }

    public void b(ImageView imageView, boolean z) {
        if (imageView != null) {
            if (z) {
                imageView.setContentDescription(this.kMZ.getResources().getString(R.string.check_box_checked));
                am.setImageResource(imageView, R.drawable.icon_list_select_ok_n);
                return;
            }
            imageView.setContentDescription(this.kMZ.getResources().getString(R.string.check_box_not_checked));
            am.setImageResource(imageView, R.drawable.icon_list_select_n);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes13.dex */
    public class b implements View.OnClickListener {
        private MediaFileInfo kNu;
        private int position;

        public b(MediaFileInfo mediaFileInfo, int i) {
            this.kNu = mediaFileInfo;
            this.position = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.pic) {
                if (h.this.kNm != null && this.kNu != null) {
                    h.this.kNm.a(this.position, this.kNu);
                }
            } else if (view.getId() == R.id.lay_select) {
                if (this.kNu != null && h.this.kNn != null) {
                    h.this.kNn.b(this.position, this.kNu);
                }
            } else if (view.getId() == R.id.video_thumb) {
                if (h.this.kNm != null && this.kNu != null) {
                    h.this.kNm.a(this.position, this.kNu);
                }
            } else if (view.getId() == R.id.video_select && this.kNu != null && h.this.kNn != null) {
                h.this.kNn.b(this.position, this.kNu);
            }
        }
    }

    public boolean isScroll() {
        return this.aCI;
    }

    public void bw(boolean z) {
        this.aCI = z;
    }

    public void a(f fVar) {
        this.kNm = fVar;
    }

    public void a(g gVar) {
        this.kNn = gVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes13.dex */
    public class a {
        TbImageView kNr;
        TbCameraView kNs;
        View rootView;

        private a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes13.dex */
    public class d {
        ImageView aCO;
        RelativeLayout aCP;
        TbImageView gbu;
        View rootView;

        private d() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes13.dex */
    public class c {
        ImageView aCO;
        TbImageView kNv;
        RelativeLayout kNw;
        TextView kNx;
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
        this.kNl = onClickListener;
    }

    public void setOnRequestPermissionListener(TbCameraView.c cVar) {
        this.kNo = cVar;
    }

    public void setOnOpenCameraFailedListener(TbCameraView.a aVar) {
        this.kNp = aVar;
    }

    public void tM(boolean z) {
        if (this.kNk != z) {
            this.kNk = z;
            notifyDataSetChanged();
        }
    }
}
