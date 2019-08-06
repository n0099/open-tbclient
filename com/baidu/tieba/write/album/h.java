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
    private g jOA;
    private TbCameraView.c jOB;
    private TbCameraView.a jOC;
    private a jOD;
    private AlbumActivity jOc;
    private com.baidu.tieba.write.album.c jOw;
    private View.OnClickListener jOy;
    private f jOz;
    private LayoutInflater mLayoutInflater;
    private final List<MediaFileInfo> mDataList = new ArrayList();
    private boolean hCC = false;
    private boolean jOx = true;

    public TbCameraView cAG() {
        if (this.jOD != null) {
            return this.jOD.jOF;
        }
        return null;
    }

    public h(AlbumActivity albumActivity, com.baidu.tieba.write.album.c cVar) {
        this.jOc = albumActivity;
        this.jOw = cVar;
        this.mLayoutInflater = LayoutInflater.from(this.jOc.getPageContext().getPageActivity());
    }

    public void setData(List<MediaFileInfo> list) {
        this.mDataList.clear();
        if (this.jOx) {
            this.mDataList.add(cAH());
        }
        if (!v.aa(list)) {
            this.mDataList.addAll(list);
        }
        notifyDataSetChanged();
    }

    private MediaFileInfo cAH() {
        return new AddMediaInfo();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return v.Z(this.mDataList);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: CW */
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
            if (this.jOD == null || this.jOD.jOF == null) {
                this.jOD = new a();
                View inflate = this.mLayoutInflater.inflate(R.layout.album_make_picture_view, viewGroup, false);
                this.jOD.rootView = inflate;
                this.jOD.jOF = (TbCameraView) inflate.findViewById(R.id.camera_surfaceview);
                this.jOD.jOE = (TbImageView) inflate.findViewById(R.id.icon_make_photo);
                this.jOD.jOE.setDefaultResource(0);
                this.jOD.jOE.setDefaultErrorResource(0);
                this.jOD.jOE.setGifIconSupport(false);
                this.jOD.jOE.setLongIconSupport(false);
                inflate.setTag(this.jOD);
                this.jOc.showTip(this.jOD.jOE);
            }
            this.jOD.jOF.setOnRequestPermissionListener(this.jOB);
            this.jOD.jOF.setOnOpenCameraFailedListener(this.jOC);
            this.jOD.jOE.setOnClickListener(this.jOy);
            this.jOD.jOF.setOnClickListener(this.jOy);
            this.jOD.rootView.setOnClickListener(this.jOy);
            am.c(this.jOD.jOE, (int) R.drawable.icon_album_camera);
            am.l(this.jOD.rootView, R.color.black_alpha90);
            return this.jOD.rootView;
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
                dVar2.fdL = (TbImageView) view.findViewById(R.id.pic);
                dVar2.fdL.setDefaultResource(0);
                dVar2.fdL.setDefaultErrorResource(0);
                dVar2.fdL.setTagPaddingDis(8, 8);
                dVar2.fdL.setGifIconSupport(true);
                dVar2.fdL.setLongIconSupport(true);
                dVar2.fdM = (ImageView) view.findViewById(R.id.select_icon);
                dVar2.jnk = (RelativeLayout) view.findViewById(R.id.lay_select);
                if (this.jOw != null && this.jOw.getWriteImagesInfo() != null && this.jOw.getWriteImagesInfo().isFromQRCode()) {
                    dVar2.jnk.setVisibility(8);
                }
                view.setTag(dVar2);
                dVar = dVar2;
            } else {
                dVar = (d) view.getTag();
            }
            dVar.fdL.setIsLongPic(imageFileInfo.isLong());
            dVar.fdL.startLoad(imageFileInfo.getFilePath(), 35, false);
            a(dVar.fdM, mediaFileInfo);
            b bVar = new b(mediaFileInfo, i);
            dVar.fdL.setOnClickListener(bVar);
            dVar.jnk.setOnClickListener(bVar);
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
                cVar2.jOI = (TbImageView) view.findViewById(R.id.video_thumb);
                cVar2.jOI.setDefaultResource(0);
                cVar2.jOI.setDefaultErrorResource(0);
                cVar2.jOI.setTagPaddingDis(8, 8);
                cVar2.jOI.setGifIconSupport(false);
                cVar2.jOI.setLongIconSupport(false);
                cVar2.fdM = (ImageView) view.findViewById(R.id.select_icon);
                cVar2.jOJ = (RelativeLayout) view.findViewById(R.id.video_select);
                cVar2.jOK = (TextView) view.findViewById(R.id.video_play_time);
                view.setTag(cVar2);
                cVar = cVar2;
            } else {
                cVar = (c) view.getTag();
            }
            cVar.jOI.startLoad(videoFileInfo.videoPath, 37, false);
            cVar.jOK.setText(aq.is(videoFileInfo.videoDuration));
            a(cVar.fdM, mediaFileInfo);
            b bVar = new b(mediaFileInfo, i);
            cVar.jOI.setOnClickListener(bVar);
            cVar.jOJ.setOnClickListener(bVar);
        }
        return view;
    }

    private void a(ImageView imageView, MediaFileInfo mediaFileInfo) {
        boolean z = false;
        if (this.jOw != null && (mediaFileInfo instanceof ImageFileInfo)) {
            z = this.jOw.isAdded((ImageFileInfo) mediaFileInfo);
        } else if (this.jOw != null && (mediaFileInfo instanceof VideoFileInfo)) {
            z = this.jOw.b((VideoFileInfo) mediaFileInfo);
        }
        d(imageView, z);
    }

    public void d(ImageView imageView, boolean z) {
        if (imageView != null) {
            if (z) {
                imageView.setContentDescription(this.jOc.getResources().getString(R.string.check_box_checked));
                am.c(imageView, (int) R.drawable.icon_list_select_ok_n);
                return;
            }
            imageView.setContentDescription(this.jOc.getResources().getString(R.string.check_box_not_checked));
            am.c(imageView, (int) R.drawable.icon_list_select_n);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        private MediaFileInfo jOH;
        private int position;

        public b(MediaFileInfo mediaFileInfo, int i) {
            this.jOH = mediaFileInfo;
            this.position = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.pic) {
                if (h.this.jOz != null && this.jOH != null) {
                    h.this.jOz.a(this.position, this.jOH);
                }
            } else if (view.getId() == R.id.lay_select) {
                if (this.jOH != null && h.this.jOA != null) {
                    h.this.jOA.b(this.position, this.jOH);
                }
            } else if (view.getId() == R.id.video_thumb) {
                if (h.this.jOz != null && this.jOH != null) {
                    h.this.jOz.a(this.position, this.jOH);
                }
            } else if (view.getId() == R.id.video_select && this.jOH != null && h.this.jOA != null) {
                h.this.jOA.b(this.position, this.jOH);
            }
        }
    }

    public boolean isScroll() {
        return this.hCC;
    }

    public void nP(boolean z) {
        this.hCC = z;
    }

    public void a(f fVar) {
        this.jOz = fVar;
    }

    public void a(g gVar) {
        this.jOA = gVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a {
        TbImageView jOE;
        TbCameraView jOF;
        View rootView;

        private a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class d {
        TbImageView fdL;
        ImageView fdM;
        RelativeLayout jnk;
        View rootView;

        private d() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class c {
        ImageView fdM;
        TbImageView jOI;
        RelativeLayout jOJ;
        TextView jOK;
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
        this.jOy = onClickListener;
    }

    public void setOnRequestPermissionListener(TbCameraView.c cVar) {
        this.jOB = cVar;
    }

    public void setOnOpenCameraFailedListener(TbCameraView.a aVar) {
        this.jOC = aVar;
    }

    public void si(boolean z) {
        if (this.jOx != z) {
            this.jOx = z;
            notifyDataSetChanged();
        }
    }
}
