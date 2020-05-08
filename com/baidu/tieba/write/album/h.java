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
/* loaded from: classes2.dex */
public class h extends BaseAdapter {
    private AlbumActivity lye;
    private com.baidu.tieba.write.album.c lyp;
    private View.OnClickListener lyr;
    private f lys;
    private g lyt;
    private TbCameraView.c lyu;
    private TbCameraView.a lyv;
    private a lyw;
    private LayoutInflater mLayoutInflater;
    private final List<MediaFileInfo> mDataList = new ArrayList();
    private boolean aWI = false;
    private boolean lyq = true;

    public TbCameraView dft() {
        if (this.lyw != null) {
            return this.lyw.lyy;
        }
        return null;
    }

    public h(AlbumActivity albumActivity, com.baidu.tieba.write.album.c cVar) {
        this.lye = albumActivity;
        this.lyp = cVar;
        this.mLayoutInflater = LayoutInflater.from(this.lye.getPageContext().getPageActivity());
    }

    public void setData(List<MediaFileInfo> list) {
        this.mDataList.clear();
        if (this.lyq) {
            this.mDataList.add(dfu());
        }
        if (!v.isEmpty(list)) {
            this.mDataList.addAll(list);
        }
        notifyDataSetChanged();
    }

    private MediaFileInfo dfu() {
        return new AddMediaInfo();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return v.getCount(this.mDataList);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: EN */
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
            if (this.lyw == null || this.lyw.lyy == null) {
                this.lyw = new a();
                View inflate = this.mLayoutInflater.inflate(R.layout.album_make_picture_view, viewGroup, false);
                this.lyw.rootView = inflate;
                this.lyw.lyy = (TbCameraView) inflate.findViewById(R.id.camera_surfaceview);
                this.lyw.lyx = (TbImageView) inflate.findViewById(R.id.icon_make_photo);
                this.lyw.lyx.setDefaultResource(0);
                this.lyw.lyx.setDefaultErrorResource(0);
                this.lyw.lyx.setGifIconSupport(false);
                this.lyw.lyx.setLongIconSupport(false);
                inflate.setTag(this.lyw);
                this.lye.showTip(this.lyw.lyx);
            }
            this.lyw.lyy.setOnRequestPermissionListener(this.lyu);
            this.lyw.lyy.setOnOpenCameraFailedListener(this.lyv);
            this.lyw.lyx.setOnClickListener(this.lyr);
            this.lyw.lyy.setOnClickListener(this.lyr);
            this.lyw.rootView.setOnClickListener(this.lyr);
            am.setImageResource(this.lyw.lyx, R.drawable.icon_album_camera);
            am.setBackgroundColor(this.lyw.rootView, R.color.black_alpha90);
            return this.lyw.rootView;
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
                dVar2.gLt = (TbImageView) view.findViewById(R.id.pic);
                dVar2.gLt.setDefaultResource(0);
                dVar2.gLt.setDefaultErrorResource(0);
                dVar2.gLt.setTagPaddingDis(8, 8);
                dVar2.gLt.setGifIconSupport(true);
                dVar2.gLt.setLongIconSupport(true);
                dVar2.aWO = (ImageView) view.findViewById(R.id.select_icon);
                dVar2.aWP = (RelativeLayout) view.findViewById(R.id.lay_select);
                if (this.lyp != null && this.lyp.getWriteImagesInfo() != null && this.lyp.getWriteImagesInfo().isFromQRCode()) {
                    dVar2.aWP.setVisibility(8);
                }
                view.setTag(dVar2);
                dVar = dVar2;
            } else {
                dVar = (d) view.getTag();
            }
            dVar.gLt.setIsLongPic(imageFileInfo.isLong());
            dVar.gLt.startLoad(imageFileInfo.getFilePath(), 35, false);
            a(dVar.aWO, mediaFileInfo);
            b bVar = new b(mediaFileInfo, i);
            dVar.gLt.setOnClickListener(bVar);
            dVar.aWP.setOnClickListener(bVar);
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
                cVar2.lyB = (TbImageView) view.findViewById(R.id.video_thumb);
                cVar2.lyB.setDefaultResource(0);
                cVar2.lyB.setDefaultErrorResource(0);
                cVar2.lyB.setTagPaddingDis(8, 8);
                cVar2.lyB.setGifIconSupport(false);
                cVar2.lyB.setLongIconSupport(false);
                cVar2.aWO = (ImageView) view.findViewById(R.id.select_icon);
                cVar2.lyC = (RelativeLayout) view.findViewById(R.id.video_select);
                cVar2.lyD = (TextView) view.findViewById(R.id.video_play_time);
                view.setTag(cVar2);
                cVar = cVar2;
            } else {
                cVar = (c) view.getTag();
            }
            cVar.lyB.startLoad(videoFileInfo.videoPath, 37, false);
            cVar.lyD.setText(aq.stringForVideoTime(videoFileInfo.videoDuration));
            a(cVar.aWO, mediaFileInfo);
            b bVar = new b(mediaFileInfo, i);
            cVar.lyB.setOnClickListener(bVar);
            cVar.lyC.setOnClickListener(bVar);
        }
        return view;
    }

    private void a(ImageView imageView, MediaFileInfo mediaFileInfo) {
        boolean z = false;
        if (this.lyp != null && (mediaFileInfo instanceof ImageFileInfo)) {
            z = this.lyp.isAdded((ImageFileInfo) mediaFileInfo);
        } else if (this.lyp != null && (mediaFileInfo instanceof VideoFileInfo)) {
            z = this.lyp.b((VideoFileInfo) mediaFileInfo);
        }
        b(imageView, z);
    }

    public void b(ImageView imageView, boolean z) {
        if (imageView != null) {
            if (z) {
                imageView.setContentDescription(this.lye.getResources().getString(R.string.check_box_checked));
                am.setImageResource(imageView, R.drawable.icon_list_select_ok_n);
                return;
            }
            imageView.setContentDescription(this.lye.getResources().getString(R.string.check_box_not_checked));
            am.setImageResource(imageView, R.drawable.icon_list_select_n);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        private MediaFileInfo lyA;
        private int position;

        public b(MediaFileInfo mediaFileInfo, int i) {
            this.lyA = mediaFileInfo;
            this.position = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.pic) {
                if (h.this.lys != null && this.lyA != null) {
                    h.this.lys.a(this.position, this.lyA);
                }
            } else if (view.getId() == R.id.lay_select) {
                if (this.lyA != null && h.this.lyt != null) {
                    h.this.lyt.b(this.position, this.lyA);
                }
            } else if (view.getId() == R.id.video_thumb) {
                if (h.this.lys != null && this.lyA != null) {
                    h.this.lys.a(this.position, this.lyA);
                }
            } else if (view.getId() == R.id.video_select && this.lyA != null && h.this.lyt != null) {
                h.this.lyt.b(this.position, this.lyA);
            }
        }
    }

    public boolean isScroll() {
        return this.aWI;
    }

    public void cb(boolean z) {
        this.aWI = z;
    }

    public void a(f fVar) {
        this.lys = fVar;
    }

    public void a(g gVar) {
        this.lyt = gVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a {
        TbImageView lyx;
        TbCameraView lyy;
        View rootView;

        private a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class d {
        ImageView aWO;
        RelativeLayout aWP;
        TbImageView gLt;
        View rootView;

        private d() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class c {
        ImageView aWO;
        TbImageView lyB;
        RelativeLayout lyC;
        TextView lyD;
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

    public void ai(View.OnClickListener onClickListener) {
        this.lyr = onClickListener;
    }

    public void setOnRequestPermissionListener(TbCameraView.c cVar) {
        this.lyu = cVar;
    }

    public void setOnOpenCameraFailedListener(TbCameraView.a aVar) {
        this.lyv = aVar;
    }

    public void uT(boolean z) {
        if (this.lyq != z) {
            this.lyq = z;
            notifyDataSetChanged();
        }
    }
}
