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
/* loaded from: classes11.dex */
public class h extends BaseAdapter {
    private AlbumActivity kMa;
    private com.baidu.tieba.write.album.c kMk;
    private View.OnClickListener kMm;
    private f kMn;
    private g kMo;
    private TbCameraView.c kMp;
    private TbCameraView.a kMq;
    private a kMr;
    private LayoutInflater mLayoutInflater;
    private final List<MediaFileInfo> mDataList = new ArrayList();
    private boolean ayq = false;
    private boolean kMl = true;

    public TbCameraView cTm() {
        if (this.kMr != null) {
            return this.kMr.kMt;
        }
        return null;
    }

    public h(AlbumActivity albumActivity, com.baidu.tieba.write.album.c cVar) {
        this.kMa = albumActivity;
        this.kMk = cVar;
        this.mLayoutInflater = LayoutInflater.from(this.kMa.getPageContext().getPageActivity());
    }

    public void setData(List<MediaFileInfo> list) {
        this.mDataList.clear();
        if (this.kMl) {
            this.mDataList.add(cTn());
        }
        if (!v.isEmpty(list)) {
            this.mDataList.addAll(list);
        }
        notifyDataSetChanged();
    }

    private MediaFileInfo cTn() {
        return new AddMediaInfo();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return v.getCount(this.mDataList);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: DZ */
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
            if (this.kMr == null || this.kMr.kMt == null) {
                this.kMr = new a();
                View inflate = this.mLayoutInflater.inflate(R.layout.album_make_picture_view, viewGroup, false);
                this.kMr.rootView = inflate;
                this.kMr.kMt = (TbCameraView) inflate.findViewById(R.id.camera_surfaceview);
                this.kMr.kMs = (TbImageView) inflate.findViewById(R.id.icon_make_photo);
                this.kMr.kMs.setDefaultResource(0);
                this.kMr.kMs.setDefaultErrorResource(0);
                this.kMr.kMs.setGifIconSupport(false);
                this.kMr.kMs.setLongIconSupport(false);
                inflate.setTag(this.kMr);
                this.kMa.showTip(this.kMr.kMs);
            }
            this.kMr.kMt.setOnRequestPermissionListener(this.kMp);
            this.kMr.kMt.setOnOpenCameraFailedListener(this.kMq);
            this.kMr.kMs.setOnClickListener(this.kMm);
            this.kMr.kMt.setOnClickListener(this.kMm);
            this.kMr.rootView.setOnClickListener(this.kMm);
            am.setImageResource(this.kMr.kMs, R.drawable.icon_album_camera);
            am.setBackgroundColor(this.kMr.rootView, R.color.black_alpha90);
            return this.kMr.rootView;
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
                dVar2.fZf = (TbImageView) view.findViewById(R.id.pic);
                dVar2.fZf.setDefaultResource(0);
                dVar2.fZf.setDefaultErrorResource(0);
                dVar2.fZf.setTagPaddingDis(8, 8);
                dVar2.fZf.setGifIconSupport(true);
                dVar2.fZf.setLongIconSupport(true);
                dVar2.ayw = (ImageView) view.findViewById(R.id.select_icon);
                dVar2.ayx = (RelativeLayout) view.findViewById(R.id.lay_select);
                if (this.kMk != null && this.kMk.getWriteImagesInfo() != null && this.kMk.getWriteImagesInfo().isFromQRCode()) {
                    dVar2.ayx.setVisibility(8);
                }
                view.setTag(dVar2);
                dVar = dVar2;
            } else {
                dVar = (d) view.getTag();
            }
            dVar.fZf.setIsLongPic(imageFileInfo.isLong());
            dVar.fZf.startLoad(imageFileInfo.getFilePath(), 35, false);
            a(dVar.ayw, mediaFileInfo);
            b bVar = new b(mediaFileInfo, i);
            dVar.fZf.setOnClickListener(bVar);
            dVar.ayx.setOnClickListener(bVar);
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
                cVar2.kMw = (TbImageView) view.findViewById(R.id.video_thumb);
                cVar2.kMw.setDefaultResource(0);
                cVar2.kMw.setDefaultErrorResource(0);
                cVar2.kMw.setTagPaddingDis(8, 8);
                cVar2.kMw.setGifIconSupport(false);
                cVar2.kMw.setLongIconSupport(false);
                cVar2.ayw = (ImageView) view.findViewById(R.id.select_icon);
                cVar2.kMx = (RelativeLayout) view.findViewById(R.id.video_select);
                cVar2.kMy = (TextView) view.findViewById(R.id.video_play_time);
                view.setTag(cVar2);
                cVar = cVar2;
            } else {
                cVar = (c) view.getTag();
            }
            cVar.kMw.startLoad(videoFileInfo.videoPath, 37, false);
            cVar.kMy.setText(aq.stringForVideoTime(videoFileInfo.videoDuration));
            a(cVar.ayw, mediaFileInfo);
            b bVar = new b(mediaFileInfo, i);
            cVar.kMw.setOnClickListener(bVar);
            cVar.kMx.setOnClickListener(bVar);
        }
        return view;
    }

    private void a(ImageView imageView, MediaFileInfo mediaFileInfo) {
        boolean z = false;
        if (this.kMk != null && (mediaFileInfo instanceof ImageFileInfo)) {
            z = this.kMk.isAdded((ImageFileInfo) mediaFileInfo);
        } else if (this.kMk != null && (mediaFileInfo instanceof VideoFileInfo)) {
            z = this.kMk.b((VideoFileInfo) mediaFileInfo);
        }
        b(imageView, z);
    }

    public void b(ImageView imageView, boolean z) {
        if (imageView != null) {
            if (z) {
                imageView.setContentDescription(this.kMa.getResources().getString(R.string.check_box_checked));
                am.setImageResource(imageView, R.drawable.icon_list_select_ok_n);
                return;
            }
            imageView.setContentDescription(this.kMa.getResources().getString(R.string.check_box_not_checked));
            am.setImageResource(imageView, R.drawable.icon_list_select_n);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class b implements View.OnClickListener {
        private MediaFileInfo kMv;
        private int position;

        public b(MediaFileInfo mediaFileInfo, int i) {
            this.kMv = mediaFileInfo;
            this.position = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.pic) {
                if (h.this.kMn != null && this.kMv != null) {
                    h.this.kMn.a(this.position, this.kMv);
                }
            } else if (view.getId() == R.id.lay_select) {
                if (this.kMv != null && h.this.kMo != null) {
                    h.this.kMo.b(this.position, this.kMv);
                }
            } else if (view.getId() == R.id.video_thumb) {
                if (h.this.kMn != null && this.kMv != null) {
                    h.this.kMn.a(this.position, this.kMv);
                }
            } else if (view.getId() == R.id.video_select && this.kMv != null && h.this.kMo != null) {
                h.this.kMo.b(this.position, this.kMv);
            }
        }
    }

    public boolean isScroll() {
        return this.ayq;
    }

    public void bo(boolean z) {
        this.ayq = z;
    }

    public void a(f fVar) {
        this.kMn = fVar;
    }

    public void a(g gVar) {
        this.kMo = gVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class a {
        TbImageView kMs;
        TbCameraView kMt;
        View rootView;

        private a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class d {
        ImageView ayw;
        RelativeLayout ayx;
        TbImageView fZf;
        View rootView;

        private d() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class c {
        ImageView ayw;
        TbImageView kMw;
        RelativeLayout kMx;
        TextView kMy;
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
        this.kMm = onClickListener;
    }

    public void setOnRequestPermissionListener(TbCameraView.c cVar) {
        this.kMp = cVar;
    }

    public void setOnOpenCameraFailedListener(TbCameraView.a aVar) {
        this.kMq = aVar;
    }

    public void tI(boolean z) {
        if (this.kMl != z) {
            this.kMl = z;
            notifyDataSetChanged();
        }
    }
}
