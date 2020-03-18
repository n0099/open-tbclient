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
    private AlbumActivity kOJ;
    private com.baidu.tieba.write.album.c kOT;
    private View.OnClickListener kOV;
    private f kOW;
    private g kOX;
    private TbCameraView.c kOY;
    private TbCameraView.a kOZ;
    private a kPa;
    private LayoutInflater mLayoutInflater;
    private final List<MediaFileInfo> mDataList = new ArrayList();
    private boolean aCW = false;
    private boolean kOU = true;

    public TbCameraView cVa() {
        if (this.kPa != null) {
            return this.kPa.kPc;
        }
        return null;
    }

    public h(AlbumActivity albumActivity, com.baidu.tieba.write.album.c cVar) {
        this.kOJ = albumActivity;
        this.kOT = cVar;
        this.mLayoutInflater = LayoutInflater.from(this.kOJ.getPageContext().getPageActivity());
    }

    public void setData(List<MediaFileInfo> list) {
        this.mDataList.clear();
        if (this.kOU) {
            this.mDataList.add(cVb());
        }
        if (!v.isEmpty(list)) {
            this.mDataList.addAll(list);
        }
        notifyDataSetChanged();
    }

    private MediaFileInfo cVb() {
        return new AddMediaInfo();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return v.getCount(this.mDataList);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: Em */
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
            if (this.kPa == null || this.kPa.kPc == null) {
                this.kPa = new a();
                View inflate = this.mLayoutInflater.inflate(R.layout.album_make_picture_view, viewGroup, false);
                this.kPa.rootView = inflate;
                this.kPa.kPc = (TbCameraView) inflate.findViewById(R.id.camera_surfaceview);
                this.kPa.kPb = (TbImageView) inflate.findViewById(R.id.icon_make_photo);
                this.kPa.kPb.setDefaultResource(0);
                this.kPa.kPb.setDefaultErrorResource(0);
                this.kPa.kPb.setGifIconSupport(false);
                this.kPa.kPb.setLongIconSupport(false);
                inflate.setTag(this.kPa);
                this.kOJ.showTip(this.kPa.kPb);
            }
            this.kPa.kPc.setOnRequestPermissionListener(this.kOY);
            this.kPa.kPc.setOnOpenCameraFailedListener(this.kOZ);
            this.kPa.kPb.setOnClickListener(this.kOV);
            this.kPa.kPc.setOnClickListener(this.kOV);
            this.kPa.rootView.setOnClickListener(this.kOV);
            am.setImageResource(this.kPa.kPb, R.drawable.icon_album_camera);
            am.setBackgroundColor(this.kPa.rootView, R.color.black_alpha90);
            return this.kPa.rootView;
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
                dVar2.gcc = (TbImageView) view.findViewById(R.id.pic);
                dVar2.gcc.setDefaultResource(0);
                dVar2.gcc.setDefaultErrorResource(0);
                dVar2.gcc.setTagPaddingDis(8, 8);
                dVar2.gcc.setGifIconSupport(true);
                dVar2.gcc.setLongIconSupport(true);
                dVar2.aDc = (ImageView) view.findViewById(R.id.select_icon);
                dVar2.aDd = (RelativeLayout) view.findViewById(R.id.lay_select);
                if (this.kOT != null && this.kOT.getWriteImagesInfo() != null && this.kOT.getWriteImagesInfo().isFromQRCode()) {
                    dVar2.aDd.setVisibility(8);
                }
                view.setTag(dVar2);
                dVar = dVar2;
            } else {
                dVar = (d) view.getTag();
            }
            dVar.gcc.setIsLongPic(imageFileInfo.isLong());
            dVar.gcc.startLoad(imageFileInfo.getFilePath(), 35, false);
            a(dVar.aDc, mediaFileInfo);
            b bVar = new b(mediaFileInfo, i);
            dVar.gcc.setOnClickListener(bVar);
            dVar.aDd.setOnClickListener(bVar);
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
                cVar2.kPf = (TbImageView) view.findViewById(R.id.video_thumb);
                cVar2.kPf.setDefaultResource(0);
                cVar2.kPf.setDefaultErrorResource(0);
                cVar2.kPf.setTagPaddingDis(8, 8);
                cVar2.kPf.setGifIconSupport(false);
                cVar2.kPf.setLongIconSupport(false);
                cVar2.aDc = (ImageView) view.findViewById(R.id.select_icon);
                cVar2.kPg = (RelativeLayout) view.findViewById(R.id.video_select);
                cVar2.kPh = (TextView) view.findViewById(R.id.video_play_time);
                view.setTag(cVar2);
                cVar = cVar2;
            } else {
                cVar = (c) view.getTag();
            }
            cVar.kPf.startLoad(videoFileInfo.videoPath, 37, false);
            cVar.kPh.setText(aq.stringForVideoTime(videoFileInfo.videoDuration));
            a(cVar.aDc, mediaFileInfo);
            b bVar = new b(mediaFileInfo, i);
            cVar.kPf.setOnClickListener(bVar);
            cVar.kPg.setOnClickListener(bVar);
        }
        return view;
    }

    private void a(ImageView imageView, MediaFileInfo mediaFileInfo) {
        boolean z = false;
        if (this.kOT != null && (mediaFileInfo instanceof ImageFileInfo)) {
            z = this.kOT.isAdded((ImageFileInfo) mediaFileInfo);
        } else if (this.kOT != null && (mediaFileInfo instanceof VideoFileInfo)) {
            z = this.kOT.b((VideoFileInfo) mediaFileInfo);
        }
        b(imageView, z);
    }

    public void b(ImageView imageView, boolean z) {
        if (imageView != null) {
            if (z) {
                imageView.setContentDescription(this.kOJ.getResources().getString(R.string.check_box_checked));
                am.setImageResource(imageView, R.drawable.icon_list_select_ok_n);
                return;
            }
            imageView.setContentDescription(this.kOJ.getResources().getString(R.string.check_box_not_checked));
            am.setImageResource(imageView, R.drawable.icon_list_select_n);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes13.dex */
    public class b implements View.OnClickListener {
        private MediaFileInfo kPe;
        private int position;

        public b(MediaFileInfo mediaFileInfo, int i) {
            this.kPe = mediaFileInfo;
            this.position = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.pic) {
                if (h.this.kOW != null && this.kPe != null) {
                    h.this.kOW.a(this.position, this.kPe);
                }
            } else if (view.getId() == R.id.lay_select) {
                if (this.kPe != null && h.this.kOX != null) {
                    h.this.kOX.b(this.position, this.kPe);
                }
            } else if (view.getId() == R.id.video_thumb) {
                if (h.this.kOW != null && this.kPe != null) {
                    h.this.kOW.a(this.position, this.kPe);
                }
            } else if (view.getId() == R.id.video_select && this.kPe != null && h.this.kOX != null) {
                h.this.kOX.b(this.position, this.kPe);
            }
        }
    }

    public boolean isScroll() {
        return this.aCW;
    }

    public void bx(boolean z) {
        this.aCW = z;
    }

    public void a(f fVar) {
        this.kOW = fVar;
    }

    public void a(g gVar) {
        this.kOX = gVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes13.dex */
    public class a {
        TbImageView kPb;
        TbCameraView kPc;
        View rootView;

        private a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes13.dex */
    public class d {
        ImageView aDc;
        RelativeLayout aDd;
        TbImageView gcc;
        View rootView;

        private d() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes13.dex */
    public class c {
        ImageView aDc;
        TbImageView kPf;
        RelativeLayout kPg;
        TextView kPh;
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
        this.kOV = onClickListener;
    }

    public void setOnRequestPermissionListener(TbCameraView.c cVar) {
        this.kOY = cVar;
    }

    public void setOnOpenCameraFailedListener(TbCameraView.a aVar) {
        this.kOZ = aVar;
    }

    public void tT(boolean z) {
        if (this.kOU != z) {
            this.kOU = z;
            notifyDataSetChanged();
        }
    }
}
