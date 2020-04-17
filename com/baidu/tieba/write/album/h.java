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
    private AlbumActivity lya;
    private com.baidu.tieba.write.album.c lyk;
    private View.OnClickListener lym;
    private f lyn;
    private g lyp;
    private TbCameraView.c lyq;
    private TbCameraView.a lyr;
    private a lys;
    private LayoutInflater mLayoutInflater;
    private final List<MediaFileInfo> mDataList = new ArrayList();
    private boolean aWD = false;
    private boolean lyl = true;

    public TbCameraView dfw() {
        if (this.lys != null) {
            return this.lys.lyu;
        }
        return null;
    }

    public h(AlbumActivity albumActivity, com.baidu.tieba.write.album.c cVar) {
        this.lya = albumActivity;
        this.lyk = cVar;
        this.mLayoutInflater = LayoutInflater.from(this.lya.getPageContext().getPageActivity());
    }

    public void setData(List<MediaFileInfo> list) {
        this.mDataList.clear();
        if (this.lyl) {
            this.mDataList.add(dfx());
        }
        if (!v.isEmpty(list)) {
            this.mDataList.addAll(list);
        }
        notifyDataSetChanged();
    }

    private MediaFileInfo dfx() {
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
            if (this.lys == null || this.lys.lyu == null) {
                this.lys = new a();
                View inflate = this.mLayoutInflater.inflate(R.layout.album_make_picture_view, viewGroup, false);
                this.lys.rootView = inflate;
                this.lys.lyu = (TbCameraView) inflate.findViewById(R.id.camera_surfaceview);
                this.lys.lyt = (TbImageView) inflate.findViewById(R.id.icon_make_photo);
                this.lys.lyt.setDefaultResource(0);
                this.lys.lyt.setDefaultErrorResource(0);
                this.lys.lyt.setGifIconSupport(false);
                this.lys.lyt.setLongIconSupport(false);
                inflate.setTag(this.lys);
                this.lya.showTip(this.lys.lyt);
            }
            this.lys.lyu.setOnRequestPermissionListener(this.lyq);
            this.lys.lyu.setOnOpenCameraFailedListener(this.lyr);
            this.lys.lyt.setOnClickListener(this.lym);
            this.lys.lyu.setOnClickListener(this.lym);
            this.lys.rootView.setOnClickListener(this.lym);
            am.setImageResource(this.lys.lyt, R.drawable.icon_album_camera);
            am.setBackgroundColor(this.lys.rootView, R.color.black_alpha90);
            return this.lys.rootView;
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
                dVar2.gLn = (TbImageView) view.findViewById(R.id.pic);
                dVar2.gLn.setDefaultResource(0);
                dVar2.gLn.setDefaultErrorResource(0);
                dVar2.gLn.setTagPaddingDis(8, 8);
                dVar2.gLn.setGifIconSupport(true);
                dVar2.gLn.setLongIconSupport(true);
                dVar2.aWJ = (ImageView) view.findViewById(R.id.select_icon);
                dVar2.aWK = (RelativeLayout) view.findViewById(R.id.lay_select);
                if (this.lyk != null && this.lyk.getWriteImagesInfo() != null && this.lyk.getWriteImagesInfo().isFromQRCode()) {
                    dVar2.aWK.setVisibility(8);
                }
                view.setTag(dVar2);
                dVar = dVar2;
            } else {
                dVar = (d) view.getTag();
            }
            dVar.gLn.setIsLongPic(imageFileInfo.isLong());
            dVar.gLn.startLoad(imageFileInfo.getFilePath(), 35, false);
            a(dVar.aWJ, mediaFileInfo);
            b bVar = new b(mediaFileInfo, i);
            dVar.gLn.setOnClickListener(bVar);
            dVar.aWK.setOnClickListener(bVar);
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
                cVar2.lyx = (TbImageView) view.findViewById(R.id.video_thumb);
                cVar2.lyx.setDefaultResource(0);
                cVar2.lyx.setDefaultErrorResource(0);
                cVar2.lyx.setTagPaddingDis(8, 8);
                cVar2.lyx.setGifIconSupport(false);
                cVar2.lyx.setLongIconSupport(false);
                cVar2.aWJ = (ImageView) view.findViewById(R.id.select_icon);
                cVar2.lyy = (RelativeLayout) view.findViewById(R.id.video_select);
                cVar2.lyz = (TextView) view.findViewById(R.id.video_play_time);
                view.setTag(cVar2);
                cVar = cVar2;
            } else {
                cVar = (c) view.getTag();
            }
            cVar.lyx.startLoad(videoFileInfo.videoPath, 37, false);
            cVar.lyz.setText(aq.stringForVideoTime(videoFileInfo.videoDuration));
            a(cVar.aWJ, mediaFileInfo);
            b bVar = new b(mediaFileInfo, i);
            cVar.lyx.setOnClickListener(bVar);
            cVar.lyy.setOnClickListener(bVar);
        }
        return view;
    }

    private void a(ImageView imageView, MediaFileInfo mediaFileInfo) {
        boolean z = false;
        if (this.lyk != null && (mediaFileInfo instanceof ImageFileInfo)) {
            z = this.lyk.isAdded((ImageFileInfo) mediaFileInfo);
        } else if (this.lyk != null && (mediaFileInfo instanceof VideoFileInfo)) {
            z = this.lyk.b((VideoFileInfo) mediaFileInfo);
        }
        b(imageView, z);
    }

    public void b(ImageView imageView, boolean z) {
        if (imageView != null) {
            if (z) {
                imageView.setContentDescription(this.lya.getResources().getString(R.string.check_box_checked));
                am.setImageResource(imageView, R.drawable.icon_list_select_ok_n);
                return;
            }
            imageView.setContentDescription(this.lya.getResources().getString(R.string.check_box_not_checked));
            am.setImageResource(imageView, R.drawable.icon_list_select_n);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        private MediaFileInfo lyw;
        private int position;

        public b(MediaFileInfo mediaFileInfo, int i) {
            this.lyw = mediaFileInfo;
            this.position = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.pic) {
                if (h.this.lyn != null && this.lyw != null) {
                    h.this.lyn.a(this.position, this.lyw);
                }
            } else if (view.getId() == R.id.lay_select) {
                if (this.lyw != null && h.this.lyp != null) {
                    h.this.lyp.b(this.position, this.lyw);
                }
            } else if (view.getId() == R.id.video_thumb) {
                if (h.this.lyn != null && this.lyw != null) {
                    h.this.lyn.a(this.position, this.lyw);
                }
            } else if (view.getId() == R.id.video_select && this.lyw != null && h.this.lyp != null) {
                h.this.lyp.b(this.position, this.lyw);
            }
        }
    }

    public boolean isScroll() {
        return this.aWD;
    }

    public void cb(boolean z) {
        this.aWD = z;
    }

    public void a(f fVar) {
        this.lyn = fVar;
    }

    public void a(g gVar) {
        this.lyp = gVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a {
        TbImageView lyt;
        TbCameraView lyu;
        View rootView;

        private a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class d {
        ImageView aWJ;
        RelativeLayout aWK;
        TbImageView gLn;
        View rootView;

        private d() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class c {
        ImageView aWJ;
        TbImageView lyx;
        RelativeLayout lyy;
        TextView lyz;
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
        this.lym = onClickListener;
    }

    public void setOnRequestPermissionListener(TbCameraView.c cVar) {
        this.lyq = cVar;
    }

    public void setOnOpenCameraFailedListener(TbCameraView.a aVar) {
        this.lyr = aVar;
    }

    public void uT(boolean z) {
        if (this.lyl != z) {
            this.lyl = z;
            notifyDataSetChanged();
        }
    }
}
