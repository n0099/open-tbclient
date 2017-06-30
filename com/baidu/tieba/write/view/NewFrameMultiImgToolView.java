package com.baidu.tieba.write.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.z;
import com.baidu.tbadk.editortools.y;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView;
import com.baidu.tieba.tbadkCore.imgView.DragLayer;
import com.baidu.tieba.w;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class NewFrameMultiImgToolView extends com.baidu.tieba.tbadkCore.imgView.a implements y, DragHorizonScrollView.a {
    private static boolean aAM = false;
    private int JS;
    private com.baidu.tbadk.editortools.j JT;
    private DragHorizonScrollView aAN;
    private DragLayer aAP;
    private WriteImagesInfo aAQ;
    private com.baidu.tbadk.img.b aAR;
    private int aAU;
    private int aAV;
    private boolean aAW;
    private b giH;
    private a giI;
    protected com.baidu.tbadk.editortools.b mActionListener;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public interface a {
        void G(View view);
    }

    public NewFrameMultiImgToolView(Context context) {
        super(context);
        this.aAU = 49;
        this.aAV = 27;
        this.aAW = false;
        this.giI = new e(this);
        this.mActionListener = new f(this);
    }

    public NewFrameMultiImgToolView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aAU = 49;
        this.aAV = 27;
        this.aAW = false;
        this.giI = new e(this);
        this.mActionListener = new f(this);
    }

    public void initView() {
        this.aAN = (DragHorizonScrollView) findViewById(w.h.muti_image_upload_dragscrollview);
        this.aAP = (DragLayer) findViewById(w.h.muti_image_upload_draglayer);
    }

    public void setAsyncLocalImageLoader(com.baidu.tbadk.img.b bVar) {
        this.aAR = bVar;
    }

    public int getImageNum() {
        return this.aAQ.getChosedFiles().size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(WriteImagesInfo writeImagesInfo, boolean z) {
        this.aAQ = writeImagesInfo;
        this.giH = new b(getContext(), this.aAR, this, this.giI, this.aAV == 27);
        this.giH.a(this.aAQ);
        this.aAN.a(this.giH, z);
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 9:
                    if (this.giH != null) {
                        this.giH.notifyDataSetChanged();
                    }
                    b(new com.baidu.tbadk.editortools.a(2, this.aAV, null));
                    return;
                case 12:
                case w.n.View_hapticFeedbackEnabled /* 46 */:
                    if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a)) {
                        a(((com.baidu.tbadk.editortools.imagetool.a) aVar.data).aAJ, ((com.baidu.tbadk.editortools.imagetool.a) aVar.data).aAK);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public void btm() {
        if (this.JT != null) {
            this.JT.a(46, this.mActionListener);
            this.JT.a(47, this.mActionListener);
            this.JT.a(48, this.mActionListener);
        }
    }

    @Override // com.baidu.tbadk.editortools.y
    public void setEditorTools(com.baidu.tbadk.editortools.j jVar) {
        this.JT = jVar;
    }

    @Override // com.baidu.tbadk.editortools.y
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.JT != null) {
            this.JT.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.y
    public void setToolId(int i) {
        this.JS = i;
    }

    @Override // com.baidu.tbadk.editortools.y
    public int getToolId() {
        return this.JS;
    }

    @Override // com.baidu.tbadk.editortools.y
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.y
    public void lM() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.y
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView.a
    public void J(int i, int i2) {
        if (i != i2 && this.aAQ != null && this.aAQ.size() != 0) {
            LinkedList<ImageFileInfo> chosedFiles = this.aAQ.getChosedFiles();
            chosedFiles.add(i2, chosedFiles.remove(i));
        }
    }

    public DragHorizonScrollView getDragHorizonScrollView() {
        return this.aAN;
    }

    public DragLayer getDragLayer() {
        return this.aAP;
    }

    /* loaded from: classes.dex */
    public static class b extends BaseAdapter {
        private com.baidu.tbadk.img.b aAR;
        private WriteImagesInfo aBa = null;
        private y aBb;
        private boolean aBd;
        private a giK;
        private Context mContext;

        public b(Context context, com.baidu.tbadk.img.b bVar, y yVar, a aVar, boolean z) {
            this.aBd = true;
            this.mContext = context;
            this.aAR = bVar;
            this.aBb = yVar;
            this.giK = aVar;
            this.aBd = z;
        }

        public void a(WriteImagesInfo writeImagesInfo) {
            this.aBa = writeImagesInfo;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.aBa == null) {
                return 0;
            }
            return this.aBa.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return this.aBa.getChosedFiles().get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            FrameLayout frameLayout = view == null ? (FrameLayout) LayoutInflater.from(this.mContext).inflate(w.j.new_frame_editor_muti_image_item, (ViewGroup) null) : view;
            ImageFileInfo imageFileInfo = (ImageFileInfo) z.c(this.aBa.getChosedFiles(), i);
            if (imageFileInfo == null) {
                return null;
            }
            int measuredWidth = (viewGroup.getMeasuredWidth() - (this.mContext.getResources().getDimensionPixelSize(w.f.ds66) * 2)) + this.mContext.getResources().getDimensionPixelSize(w.f.ds32);
            FrameLayout frameLayout2 = (FrameLayout) frameLayout;
            FrameLayout frameLayout3 = (FrameLayout) frameLayout2.findViewById(w.h.item_root);
            TbImageView tbImageView = (TbImageView) frameLayout2.findViewById(w.h.iv);
            if (measuredWidth > 0) {
                imageFileInfo.clearPageActions();
                imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.L((measuredWidth / 3) - frameLayout3.getPaddingRight(), viewGroup.getMeasuredHeight() - frameLayout3.getPaddingTop()));
                frameLayout3.setForeground(as.getDrawable(w.g.new_frame_add_photo_foreground_selector));
                tbImageView.setTag(imageFileInfo.toCachedKey(true));
                if (this.aAR.a(imageFileInfo, new g(this, viewGroup), true) != null) {
                    tbImageView.invalidate();
                }
            }
            frameLayout2.setLayoutParams(new ViewGroup.LayoutParams(measuredWidth / 3, -1));
            if (this.aBd) {
                frameLayout2.setOnClickListener(new h(this, viewGroup));
            }
            LinearLayout linearLayout = (LinearLayout) frameLayout2.findViewById(w.h.delete_info);
            ImageView imageView = (ImageView) frameLayout2.findViewById(w.h.gif_icon);
            as.c((ImageView) frameLayout2.findViewById(w.h.delete), w.g.new_frame_btn_delete_photo_selector);
            as.c(imageView, w.g.ic_image_gif);
            if (imageFileInfo.isGif() && !imageFileInfo.hasActionsWithoutResize()) {
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(8);
            }
            linearLayout.setOnClickListener(new i(this, frameLayout2));
            frameLayout2.setContentDescription(String.valueOf(frameLayout2.getResources().getString(w.l.log_msg_pic)) + (i + 1) + " " + imageFileInfo.getModifyTime());
            return frameLayout2;
        }
    }

    public void setDeleteAction(int i) {
        this.aAU = i;
    }

    public void setTargetToolId(int i) {
        this.aAV = i;
    }

    @Override // com.baidu.tbadk.editortools.y
    public void onChangeSkinType(int i) {
        as.k(this, w.e.common_color_10255);
    }

    public void setNeedQuit(boolean z) {
        this.aAW = z;
    }
}
