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
import com.baidu.adp.lib.Disk.d;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.editortools.i;
import com.baidu.tbadk.editortools.s;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView;
import com.baidu.tieba.tbadkCore.imgView.DragLayer;
import java.io.File;
import java.util.LinkedList;
/* loaded from: classes2.dex */
public class NewFrameMultiImgToolView extends com.baidu.tieba.tbadkCore.imgView.a implements s, DragHorizonScrollView.a {
    private static boolean aCp = false;
    private int Jo;
    private i Jp;
    private DragHorizonScrollView aCq;
    private DragLayer aCs;
    private WriteImagesInfo aCt;
    private com.baidu.tbadk.img.b aCu;
    private int aCx;
    private int aCy;
    private boolean aCz;
    private b gFf;
    private a gFg;
    protected com.baidu.tbadk.editortools.b mActionListener;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes2.dex */
    public interface a {
        void L(View view);
    }

    public NewFrameMultiImgToolView(Context context) {
        super(context);
        this.aCx = 49;
        this.aCy = 27;
        this.aCz = false;
        this.gFg = new a() { // from class: com.baidu.tieba.write.view.NewFrameMultiImgToolView.1
            @Override // com.baidu.tieba.write.view.NewFrameMultiImgToolView.a
            public void L(View view) {
                if (!NewFrameMultiImgToolView.this.aCq.bsY()) {
                    NewFrameMultiImgToolView.this.bF(view);
                    int bG = NewFrameMultiImgToolView.this.aCq.bG(view);
                    if (bG >= 0 && bG < NewFrameMultiImgToolView.this.aCt.getChosedFiles().size()) {
                        ImageFileInfo remove = NewFrameMultiImgToolView.this.aCt.getChosedFiles().remove(bG);
                        if (remove.isTempFile()) {
                            d.dI().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                        }
                        int maxItemNum = NewFrameMultiImgToolView.this.aCq.getMaxItemNum();
                        int size = NewFrameMultiImgToolView.this.aCt.getChosedFiles().size();
                        if (NewFrameMultiImgToolView.this.Jp != null) {
                            NewFrameMultiImgToolView.this.Jp.b(new com.baidu.tbadk.editortools.a(NewFrameMultiImgToolView.this.aCx, -1, null));
                            if (size > 0) {
                                NewFrameMultiImgToolView.this.Jp.b(new com.baidu.tbadk.editortools.a(2, NewFrameMultiImgToolView.this.aCy, String.valueOf(size)));
                            } else {
                                NewFrameMultiImgToolView.this.Jp.b(new com.baidu.tbadk.editortools.a(2, NewFrameMultiImgToolView.this.aCy, null));
                            }
                            if (maxItemNum == 1 && size == 0) {
                                if (NewFrameMultiImgToolView.this.aCz) {
                                    NewFrameMultiImgToolView.this.Jp.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                                } else {
                                    NewFrameMultiImgToolView.this.a(NewFrameMultiImgToolView.this.aCt, true);
                                    NewFrameMultiImgToolView.this.Jp.invalidate();
                                }
                            }
                        }
                        if (size == 0) {
                            NewFrameMultiImgToolView.this.a(NewFrameMultiImgToolView.this.aCt, true);
                        }
                    }
                }
            }
        };
        this.mActionListener = new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.write.view.NewFrameMultiImgToolView.2
            @Override // com.baidu.tbadk.editortools.b
            public void a(com.baidu.tbadk.editortools.a aVar) {
                if (aVar != null) {
                    switch (aVar.code) {
                        case 9:
                            if (NewFrameMultiImgToolView.this.gFf != null) {
                                NewFrameMultiImgToolView.this.gFf.notifyDataSetChanged();
                            }
                            NewFrameMultiImgToolView.this.b(new com.baidu.tbadk.editortools.a(2, NewFrameMultiImgToolView.this.aCy, null));
                            return;
                        case 12:
                        case d.n.View_hapticFeedbackEnabled /* 46 */:
                            if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a)) {
                                NewFrameMultiImgToolView.this.a(((com.baidu.tbadk.editortools.imagetool.a) aVar.data).aCm, ((com.baidu.tbadk.editortools.imagetool.a) aVar.data).aCn);
                                return;
                            }
                            return;
                        default:
                            return;
                    }
                }
            }
        };
    }

    public NewFrameMultiImgToolView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aCx = 49;
        this.aCy = 27;
        this.aCz = false;
        this.gFg = new a() { // from class: com.baidu.tieba.write.view.NewFrameMultiImgToolView.1
            @Override // com.baidu.tieba.write.view.NewFrameMultiImgToolView.a
            public void L(View view) {
                if (!NewFrameMultiImgToolView.this.aCq.bsY()) {
                    NewFrameMultiImgToolView.this.bF(view);
                    int bG = NewFrameMultiImgToolView.this.aCq.bG(view);
                    if (bG >= 0 && bG < NewFrameMultiImgToolView.this.aCt.getChosedFiles().size()) {
                        ImageFileInfo remove = NewFrameMultiImgToolView.this.aCt.getChosedFiles().remove(bG);
                        if (remove.isTempFile()) {
                            com.baidu.adp.lib.Disk.d.dI().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                        }
                        int maxItemNum = NewFrameMultiImgToolView.this.aCq.getMaxItemNum();
                        int size = NewFrameMultiImgToolView.this.aCt.getChosedFiles().size();
                        if (NewFrameMultiImgToolView.this.Jp != null) {
                            NewFrameMultiImgToolView.this.Jp.b(new com.baidu.tbadk.editortools.a(NewFrameMultiImgToolView.this.aCx, -1, null));
                            if (size > 0) {
                                NewFrameMultiImgToolView.this.Jp.b(new com.baidu.tbadk.editortools.a(2, NewFrameMultiImgToolView.this.aCy, String.valueOf(size)));
                            } else {
                                NewFrameMultiImgToolView.this.Jp.b(new com.baidu.tbadk.editortools.a(2, NewFrameMultiImgToolView.this.aCy, null));
                            }
                            if (maxItemNum == 1 && size == 0) {
                                if (NewFrameMultiImgToolView.this.aCz) {
                                    NewFrameMultiImgToolView.this.Jp.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                                } else {
                                    NewFrameMultiImgToolView.this.a(NewFrameMultiImgToolView.this.aCt, true);
                                    NewFrameMultiImgToolView.this.Jp.invalidate();
                                }
                            }
                        }
                        if (size == 0) {
                            NewFrameMultiImgToolView.this.a(NewFrameMultiImgToolView.this.aCt, true);
                        }
                    }
                }
            }
        };
        this.mActionListener = new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.write.view.NewFrameMultiImgToolView.2
            @Override // com.baidu.tbadk.editortools.b
            public void a(com.baidu.tbadk.editortools.a aVar) {
                if (aVar != null) {
                    switch (aVar.code) {
                        case 9:
                            if (NewFrameMultiImgToolView.this.gFf != null) {
                                NewFrameMultiImgToolView.this.gFf.notifyDataSetChanged();
                            }
                            NewFrameMultiImgToolView.this.b(new com.baidu.tbadk.editortools.a(2, NewFrameMultiImgToolView.this.aCy, null));
                            return;
                        case 12:
                        case d.n.View_hapticFeedbackEnabled /* 46 */:
                            if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a)) {
                                NewFrameMultiImgToolView.this.a(((com.baidu.tbadk.editortools.imagetool.a) aVar.data).aCm, ((com.baidu.tbadk.editortools.imagetool.a) aVar.data).aCn);
                                return;
                            }
                            return;
                        default:
                            return;
                    }
                }
            }
        };
    }

    public void initView() {
        this.aCq = (DragHorizonScrollView) findViewById(d.h.muti_image_upload_dragscrollview);
        this.aCs = (DragLayer) findViewById(d.h.muti_image_upload_draglayer);
    }

    public void setAsyncLocalImageLoader(com.baidu.tbadk.img.b bVar) {
        this.aCu = bVar;
    }

    public int getImageNum() {
        return this.aCt.getChosedFiles().size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(WriteImagesInfo writeImagesInfo, boolean z) {
        this.aCt = writeImagesInfo;
        this.gFf = new b(getContext(), this.aCu, this, this.gFg, this.aCy == 27);
        this.gFf.a(this.aCt);
        this.aCq.a(this.gFf, z);
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 9:
                    if (this.gFf != null) {
                        this.gFf.notifyDataSetChanged();
                    }
                    b(new com.baidu.tbadk.editortools.a(2, this.aCy, null));
                    return;
                case 12:
                case d.n.View_hapticFeedbackEnabled /* 46 */:
                    if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a)) {
                        a(((com.baidu.tbadk.editortools.imagetool.a) aVar.data).aCm, ((com.baidu.tbadk.editortools.imagetool.a) aVar.data).aCn);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public void bza() {
        if (this.Jp != null) {
            this.Jp.a(46, this.mActionListener);
            this.Jp.a(47, this.mActionListener);
            this.Jp.a(48, this.mActionListener);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setEditorTools(i iVar) {
        this.Jp = iVar;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Jp != null) {
            this.Jp.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setToolId(int i) {
        this.Jo = i;
    }

    @Override // com.baidu.tbadk.editortools.s
    public int getToolId() {
        return this.Jo;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.s
    public void lK() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.s
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView.a
    public void H(int i, int i2) {
        if (i != i2 && this.aCt != null && this.aCt.size() != 0) {
            LinkedList<ImageFileInfo> chosedFiles = this.aCt.getChosedFiles();
            chosedFiles.add(i2, chosedFiles.remove(i));
        }
    }

    public DragHorizonScrollView getDragHorizonScrollView() {
        return this.aCq;
    }

    public DragLayer getDragLayer() {
        return this.aCs;
    }

    /* loaded from: classes2.dex */
    public static class b extends BaseAdapter {
        private WriteImagesInfo aCD = null;
        private s aCE;
        private boolean aCG;
        private com.baidu.tbadk.img.b aCu;
        private a gFi;
        private Context mContext;

        public b(Context context, com.baidu.tbadk.img.b bVar, s sVar, a aVar, boolean z) {
            this.aCG = true;
            this.mContext = context;
            this.aCu = bVar;
            this.aCE = sVar;
            this.gFi = aVar;
            this.aCG = z;
        }

        public void a(WriteImagesInfo writeImagesInfo) {
            this.aCD = writeImagesInfo;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.aCD == null) {
                return 0;
            }
            return this.aCD.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return this.aCD.getChosedFiles().get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, final ViewGroup viewGroup) {
            FrameLayout frameLayout = view == null ? (FrameLayout) LayoutInflater.from(this.mContext).inflate(d.j.new_frame_editor_muti_image_item, (ViewGroup) null) : view;
            ImageFileInfo imageFileInfo = (ImageFileInfo) v.c(this.aCD.getChosedFiles(), i);
            if (imageFileInfo == null) {
                return null;
            }
            int measuredWidth = (viewGroup.getMeasuredWidth() - (this.mContext.getResources().getDimensionPixelSize(d.f.ds66) * 2)) + this.mContext.getResources().getDimensionPixelSize(d.f.ds32);
            final FrameLayout frameLayout2 = (FrameLayout) frameLayout;
            FrameLayout frameLayout3 = (FrameLayout) frameLayout2.findViewById(d.h.item_root);
            TbImageView tbImageView = (TbImageView) frameLayout2.findViewById(d.h.iv);
            if (measuredWidth > 0) {
                imageFileInfo.clearPageActions();
                imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.J((measuredWidth / 3) - frameLayout3.getPaddingRight(), viewGroup.getMeasuredHeight() - frameLayout3.getPaddingTop()));
                frameLayout3.setForeground(aj.getDrawable(d.g.new_frame_add_photo_foreground_selector));
                tbImageView.setTag(imageFileInfo.toCachedKey(true));
                if (this.aCu.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.write.view.NewFrameMultiImgToolView.b.1
                    @Override // com.baidu.tbadk.imageManager.b
                    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
                        TbImageView tbImageView2 = (TbImageView) viewGroup.findViewWithTag(str);
                        if (tbImageView2 != null && aVar != null) {
                            tbImageView2.invalidate();
                        }
                    }
                }, true) != null) {
                    tbImageView.invalidate();
                }
            }
            frameLayout2.setLayoutParams(new ViewGroup.LayoutParams(measuredWidth / 3, -1));
            if (this.aCG) {
                frameLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.view.NewFrameMultiImgToolView.b.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        boolean z;
                        int indexOfChild = viewGroup.indexOfChild(view2);
                        if (indexOfChild >= 0) {
                            ImageFileInfo imageFileInfo2 = (ImageFileInfo) b.this.getItem(indexOfChild);
                            if (imageFileInfo2 == null) {
                                z = false;
                            } else {
                                z = new File(imageFileInfo2.getFilePath()).exists();
                            }
                            if (!z) {
                                k.e(b.this.mContext, d.l.editor_mutiiamge_image_error);
                            } else if (b.this.aCE != null) {
                                b.this.aCE.b(new com.baidu.tbadk.editortools.a(15, 0, Integer.valueOf(indexOfChild)));
                            }
                        }
                    }
                });
            }
            LinearLayout linearLayout = (LinearLayout) frameLayout2.findViewById(d.h.delete_info);
            ImageView imageView = (ImageView) frameLayout2.findViewById(d.h.gif_icon);
            aj.c((ImageView) frameLayout2.findViewById(d.h.delete), d.g.new_frame_btn_delete_photo_selector);
            aj.c(imageView, d.g.ic_image_gif);
            if (imageFileInfo.isGif() && !imageFileInfo.hasActionsWithoutResize()) {
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(8);
            }
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.view.NewFrameMultiImgToolView.b.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.gFi != null) {
                        b.this.gFi.L(frameLayout2);
                    }
                }
            });
            frameLayout2.setContentDescription(frameLayout2.getResources().getString(d.l.editor_image) + (i + 1) + " " + imageFileInfo.getModifyTime());
            return frameLayout2;
        }
    }

    public void setDeleteAction(int i) {
        this.aCx = i;
    }

    public void setTargetToolId(int i) {
        this.aCy = i;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void onChangeSkinType(int i) {
        aj.k(this, d.e.common_color_10255);
    }

    public void setNeedQuit(boolean z) {
        this.aCz = z;
    }
}
