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
    private com.baidu.tieba.write.album.c jQR;
    private View.OnClickListener jQT;
    private f jQU;
    private g jQV;
    private TbCameraView.c jQW;
    private TbCameraView.a jQX;
    private a jQY;
    private AlbumActivity jQx;
    private LayoutInflater mLayoutInflater;
    private final List<MediaFileInfo> mDataList = new ArrayList();
    private boolean hEy = false;
    private boolean jQS = true;

    public TbCameraView cBu() {
        if (this.jQY != null) {
            return this.jQY.jRa;
        }
        return null;
    }

    public h(AlbumActivity albumActivity, com.baidu.tieba.write.album.c cVar) {
        this.jQx = albumActivity;
        this.jQR = cVar;
        this.mLayoutInflater = LayoutInflater.from(this.jQx.getPageContext().getPageActivity());
    }

    public void setData(List<MediaFileInfo> list) {
        this.mDataList.clear();
        if (this.jQS) {
            this.mDataList.add(cBv());
        }
        if (!v.aa(list)) {
            this.mDataList.addAll(list);
        }
        notifyDataSetChanged();
    }

    private MediaFileInfo cBv() {
        return new AddMediaInfo();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return v.Z(this.mDataList);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: Da */
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
            if (this.jQY == null || this.jQY.jRa == null) {
                this.jQY = new a();
                View inflate = this.mLayoutInflater.inflate(R.layout.album_make_picture_view, viewGroup, false);
                this.jQY.rootView = inflate;
                this.jQY.jRa = (TbCameraView) inflate.findViewById(R.id.camera_surfaceview);
                this.jQY.jQZ = (TbImageView) inflate.findViewById(R.id.icon_make_photo);
                this.jQY.jQZ.setDefaultResource(0);
                this.jQY.jQZ.setDefaultErrorResource(0);
                this.jQY.jQZ.setGifIconSupport(false);
                this.jQY.jQZ.setLongIconSupport(false);
                inflate.setTag(this.jQY);
                this.jQx.showTip(this.jQY.jQZ);
            }
            this.jQY.jRa.setOnRequestPermissionListener(this.jQW);
            this.jQY.jRa.setOnOpenCameraFailedListener(this.jQX);
            this.jQY.jQZ.setOnClickListener(this.jQT);
            this.jQY.jRa.setOnClickListener(this.jQT);
            this.jQY.rootView.setOnClickListener(this.jQT);
            am.c(this.jQY.jQZ, (int) R.drawable.icon_album_camera);
            am.l(this.jQY.rootView, R.color.black_alpha90);
            return this.jQY.rootView;
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
                dVar2.ffy = (TbImageView) view.findViewById(R.id.pic);
                dVar2.ffy.setDefaultResource(0);
                dVar2.ffy.setDefaultErrorResource(0);
                dVar2.ffy.setTagPaddingDis(8, 8);
                dVar2.ffy.setGifIconSupport(true);
                dVar2.ffy.setLongIconSupport(true);
                dVar2.ffz = (ImageView) view.findViewById(R.id.select_icon);
                dVar2.jpF = (RelativeLayout) view.findViewById(R.id.lay_select);
                if (this.jQR != null && this.jQR.getWriteImagesInfo() != null && this.jQR.getWriteImagesInfo().isFromQRCode()) {
                    dVar2.jpF.setVisibility(8);
                }
                view.setTag(dVar2);
                dVar = dVar2;
            } else {
                dVar = (d) view.getTag();
            }
            dVar.ffy.setIsLongPic(imageFileInfo.isLong());
            dVar.ffy.startLoad(imageFileInfo.getFilePath(), 35, false);
            a(dVar.ffz, mediaFileInfo);
            b bVar = new b(mediaFileInfo, i);
            dVar.ffy.setOnClickListener(bVar);
            dVar.jpF.setOnClickListener(bVar);
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
                cVar2.jRd = (TbImageView) view.findViewById(R.id.video_thumb);
                cVar2.jRd.setDefaultResource(0);
                cVar2.jRd.setDefaultErrorResource(0);
                cVar2.jRd.setTagPaddingDis(8, 8);
                cVar2.jRd.setGifIconSupport(false);
                cVar2.jRd.setLongIconSupport(false);
                cVar2.ffz = (ImageView) view.findViewById(R.id.select_icon);
                cVar2.jRe = (RelativeLayout) view.findViewById(R.id.video_select);
                cVar2.jRf = (TextView) view.findViewById(R.id.video_play_time);
                view.setTag(cVar2);
                cVar = cVar2;
            } else {
                cVar = (c) view.getTag();
            }
            cVar.jRd.startLoad(videoFileInfo.videoPath, 37, false);
            cVar.jRf.setText(aq.it(videoFileInfo.videoDuration));
            a(cVar.ffz, mediaFileInfo);
            b bVar = new b(mediaFileInfo, i);
            cVar.jRd.setOnClickListener(bVar);
            cVar.jRe.setOnClickListener(bVar);
        }
        return view;
    }

    private void a(ImageView imageView, MediaFileInfo mediaFileInfo) {
        boolean z = false;
        if (this.jQR != null && (mediaFileInfo instanceof ImageFileInfo)) {
            z = this.jQR.isAdded((ImageFileInfo) mediaFileInfo);
        } else if (this.jQR != null && (mediaFileInfo instanceof VideoFileInfo)) {
            z = this.jQR.b((VideoFileInfo) mediaFileInfo);
        }
        d(imageView, z);
    }

    public void d(ImageView imageView, boolean z) {
        if (imageView != null) {
            if (z) {
                imageView.setContentDescription(this.jQx.getResources().getString(R.string.check_box_checked));
                am.c(imageView, (int) R.drawable.icon_list_select_ok_n);
                return;
            }
            imageView.setContentDescription(this.jQx.getResources().getString(R.string.check_box_not_checked));
            am.c(imageView, (int) R.drawable.icon_list_select_n);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        private MediaFileInfo jRc;
        private int position;

        public b(MediaFileInfo mediaFileInfo, int i) {
            this.jRc = mediaFileInfo;
            this.position = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.pic) {
                if (h.this.jQU != null && this.jRc != null) {
                    h.this.jQU.a(this.position, this.jRc);
                }
            } else if (view.getId() == R.id.lay_select) {
                if (this.jRc != null && h.this.jQV != null) {
                    h.this.jQV.b(this.position, this.jRc);
                }
            } else if (view.getId() == R.id.video_thumb) {
                if (h.this.jQU != null && this.jRc != null) {
                    h.this.jQU.a(this.position, this.jRc);
                }
            } else if (view.getId() == R.id.video_select && this.jRc != null && h.this.jQV != null) {
                h.this.jQV.b(this.position, this.jRc);
            }
        }
    }

    public boolean isScroll() {
        return this.hEy;
    }

    public void nT(boolean z) {
        this.hEy = z;
    }

    public void a(f fVar) {
        this.jQU = fVar;
    }

    public void a(g gVar) {
        this.jQV = gVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a {
        TbImageView jQZ;
        TbCameraView jRa;
        View rootView;

        private a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class d {
        TbImageView ffy;
        ImageView ffz;
        RelativeLayout jpF;
        View rootView;

        private d() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class c {
        ImageView ffz;
        TbImageView jRd;
        RelativeLayout jRe;
        TextView jRf;
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

    public void ad(View.OnClickListener onClickListener) {
        this.jQT = onClickListener;
    }

    public void setOnRequestPermissionListener(TbCameraView.c cVar) {
        this.jQW = cVar;
    }

    public void setOnOpenCameraFailedListener(TbCameraView.a aVar) {
        this.jQX = aVar;
    }

    public void sl(boolean z) {
        if (this.jQS != z) {
            this.jQS = z;
            notifyDataSetChanged();
        }
    }
}
