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
import com.baidu.adp.lib.util.l;
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
    private static boolean aBJ = false;
    private int JF;
    private i JG;
    private DragHorizonScrollView aBK;
    private DragLayer aBM;
    private WriteImagesInfo aBN;
    private com.baidu.tbadk.img.b aBO;
    private int aBR;
    private int aBS;
    private boolean aBT;
    private b gJZ;
    private a gKa;
    protected com.baidu.tbadk.editortools.b mActionListener;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes2.dex */
    public interface a {
        void M(View view);
    }

    public NewFrameMultiImgToolView(Context context) {
        super(context);
        this.aBR = 49;
        this.aBS = 27;
        this.aBT = false;
        this.gKa = new a() { // from class: com.baidu.tieba.write.view.NewFrameMultiImgToolView.1
            @Override // com.baidu.tieba.write.view.NewFrameMultiImgToolView.a
            public void M(View view) {
                if (!NewFrameMultiImgToolView.this.aBK.brW()) {
                    NewFrameMultiImgToolView.this.bF(view);
                    int bG = NewFrameMultiImgToolView.this.aBK.bG(view);
                    if (bG >= 0 && bG < NewFrameMultiImgToolView.this.aBN.getChosedFiles().size()) {
                        ImageFileInfo remove = NewFrameMultiImgToolView.this.aBN.getChosedFiles().remove(bG);
                        if (remove.isTempFile()) {
                            d.dH().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                        }
                        int maxItemNum = NewFrameMultiImgToolView.this.aBK.getMaxItemNum();
                        int size = NewFrameMultiImgToolView.this.aBN.getChosedFiles().size();
                        if (NewFrameMultiImgToolView.this.JG != null) {
                            NewFrameMultiImgToolView.this.JG.b(new com.baidu.tbadk.editortools.a(NewFrameMultiImgToolView.this.aBR, -1, null));
                            if (size > 0) {
                                NewFrameMultiImgToolView.this.JG.b(new com.baidu.tbadk.editortools.a(2, NewFrameMultiImgToolView.this.aBS, String.valueOf(size)));
                            } else {
                                NewFrameMultiImgToolView.this.JG.b(new com.baidu.tbadk.editortools.a(2, NewFrameMultiImgToolView.this.aBS, null));
                            }
                            if (maxItemNum == 1 && size == 0) {
                                if (NewFrameMultiImgToolView.this.aBT) {
                                    NewFrameMultiImgToolView.this.JG.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                                } else {
                                    NewFrameMultiImgToolView.this.a(NewFrameMultiImgToolView.this.aBN, true);
                                    NewFrameMultiImgToolView.this.JG.invalidate();
                                }
                            }
                        }
                        if (size == 0) {
                            NewFrameMultiImgToolView.this.a(NewFrameMultiImgToolView.this.aBN, true);
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
                            if (NewFrameMultiImgToolView.this.gJZ != null) {
                                NewFrameMultiImgToolView.this.gJZ.notifyDataSetChanged();
                            }
                            NewFrameMultiImgToolView.this.b(new com.baidu.tbadk.editortools.a(2, NewFrameMultiImgToolView.this.aBS, null));
                            return;
                        case 12:
                        case d.n.View_hapticFeedbackEnabled /* 46 */:
                            if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a)) {
                                NewFrameMultiImgToolView.this.a(((com.baidu.tbadk.editortools.imagetool.a) aVar.data).aBG, ((com.baidu.tbadk.editortools.imagetool.a) aVar.data).aBH);
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
        this.aBR = 49;
        this.aBS = 27;
        this.aBT = false;
        this.gKa = new a() { // from class: com.baidu.tieba.write.view.NewFrameMultiImgToolView.1
            @Override // com.baidu.tieba.write.view.NewFrameMultiImgToolView.a
            public void M(View view) {
                if (!NewFrameMultiImgToolView.this.aBK.brW()) {
                    NewFrameMultiImgToolView.this.bF(view);
                    int bG = NewFrameMultiImgToolView.this.aBK.bG(view);
                    if (bG >= 0 && bG < NewFrameMultiImgToolView.this.aBN.getChosedFiles().size()) {
                        ImageFileInfo remove = NewFrameMultiImgToolView.this.aBN.getChosedFiles().remove(bG);
                        if (remove.isTempFile()) {
                            com.baidu.adp.lib.Disk.d.dH().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                        }
                        int maxItemNum = NewFrameMultiImgToolView.this.aBK.getMaxItemNum();
                        int size = NewFrameMultiImgToolView.this.aBN.getChosedFiles().size();
                        if (NewFrameMultiImgToolView.this.JG != null) {
                            NewFrameMultiImgToolView.this.JG.b(new com.baidu.tbadk.editortools.a(NewFrameMultiImgToolView.this.aBR, -1, null));
                            if (size > 0) {
                                NewFrameMultiImgToolView.this.JG.b(new com.baidu.tbadk.editortools.a(2, NewFrameMultiImgToolView.this.aBS, String.valueOf(size)));
                            } else {
                                NewFrameMultiImgToolView.this.JG.b(new com.baidu.tbadk.editortools.a(2, NewFrameMultiImgToolView.this.aBS, null));
                            }
                            if (maxItemNum == 1 && size == 0) {
                                if (NewFrameMultiImgToolView.this.aBT) {
                                    NewFrameMultiImgToolView.this.JG.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                                } else {
                                    NewFrameMultiImgToolView.this.a(NewFrameMultiImgToolView.this.aBN, true);
                                    NewFrameMultiImgToolView.this.JG.invalidate();
                                }
                            }
                        }
                        if (size == 0) {
                            NewFrameMultiImgToolView.this.a(NewFrameMultiImgToolView.this.aBN, true);
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
                            if (NewFrameMultiImgToolView.this.gJZ != null) {
                                NewFrameMultiImgToolView.this.gJZ.notifyDataSetChanged();
                            }
                            NewFrameMultiImgToolView.this.b(new com.baidu.tbadk.editortools.a(2, NewFrameMultiImgToolView.this.aBS, null));
                            return;
                        case 12:
                        case d.n.View_hapticFeedbackEnabled /* 46 */:
                            if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a)) {
                                NewFrameMultiImgToolView.this.a(((com.baidu.tbadk.editortools.imagetool.a) aVar.data).aBG, ((com.baidu.tbadk.editortools.imagetool.a) aVar.data).aBH);
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
        this.aBK = (DragHorizonScrollView) findViewById(d.h.muti_image_upload_dragscrollview);
        this.aBM = (DragLayer) findViewById(d.h.muti_image_upload_draglayer);
    }

    public void setAsyncLocalImageLoader(com.baidu.tbadk.img.b bVar) {
        this.aBO = bVar;
    }

    public int getImageNum() {
        return this.aBN.getChosedFiles().size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(WriteImagesInfo writeImagesInfo, boolean z) {
        this.aBN = writeImagesInfo;
        this.gJZ = new b(getContext(), this.aBO, this, this.gKa, this.aBS == 27);
        this.gJZ.a(this.aBN);
        this.aBK.a(this.gJZ, z);
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 9:
                    if (this.gJZ != null) {
                        this.gJZ.notifyDataSetChanged();
                    }
                    b(new com.baidu.tbadk.editortools.a(2, this.aBS, null));
                    return;
                case 12:
                case d.n.View_hapticFeedbackEnabled /* 46 */:
                    if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a)) {
                        a(((com.baidu.tbadk.editortools.imagetool.a) aVar.data).aBG, ((com.baidu.tbadk.editortools.imagetool.a) aVar.data).aBH);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public void bAn() {
        if (this.JG != null) {
            this.JG.a(46, this.mActionListener);
            this.JG.a(47, this.mActionListener);
            this.JG.a(48, this.mActionListener);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setEditorTools(i iVar) {
        this.JG = iVar;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.JG != null) {
            this.JG.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setToolId(int i) {
        this.JF = i;
    }

    @Override // com.baidu.tbadk.editortools.s
    public int getToolId() {
        return this.JF;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.s
    public void lM() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.s
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView.a
    public void I(int i, int i2) {
        if (i != i2 && this.aBN != null && this.aBN.size() != 0) {
            LinkedList<ImageFileInfo> chosedFiles = this.aBN.getChosedFiles();
            chosedFiles.add(i2, chosedFiles.remove(i));
        }
    }

    public DragHorizonScrollView getDragHorizonScrollView() {
        return this.aBK;
    }

    public DragLayer getDragLayer() {
        return this.aBM;
    }

    /* loaded from: classes2.dex */
    public static class b extends BaseAdapter {
        private com.baidu.tbadk.img.b aBO;
        private WriteImagesInfo aBX = null;
        private s aBY;
        private boolean aCa;
        private a gKc;
        private LayoutInflater gKd;
        private Context mContext;

        private int getDimensionPixelSize(int i) {
            return this.mContext.getResources().getDimensionPixelSize(i);
        }

        private String getString(int i) {
            return this.mContext.getResources().getString(i);
        }

        public b(Context context, com.baidu.tbadk.img.b bVar, s sVar, a aVar, boolean z) {
            this.aCa = true;
            this.aBY = sVar;
            this.mContext = context;
            this.gKd = LayoutInflater.from(this.mContext);
            this.aBO = bVar;
            this.gKc = aVar;
            this.aCa = z;
        }

        public void a(WriteImagesInfo writeImagesInfo) {
            this.aBX = writeImagesInfo;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.aBX == null) {
                return 0;
            }
            return this.aBX.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return this.aBX.getChosedFiles().get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, final ViewGroup viewGroup) {
            FrameLayout frameLayout = view == null ? (FrameLayout) this.gKd.inflate(d.j.new_frame_editor_muti_image_item, (ViewGroup) null) : view;
            ImageFileInfo imageFileInfo = (ImageFileInfo) v.c(this.aBX.getChosedFiles(), i);
            if (imageFileInfo == null) {
                return null;
            }
            int measuredWidth = (viewGroup.getMeasuredWidth() - (getDimensionPixelSize(d.f.ds66) * 2)) + getDimensionPixelSize(d.f.ds32);
            final FrameLayout frameLayout2 = (FrameLayout) frameLayout;
            FrameLayout frameLayout3 = (FrameLayout) frameLayout2.findViewById(d.h.item_root);
            TbImageView tbImageView = (TbImageView) frameLayout2.findViewById(d.h.iv);
            tbImageView.setGifIconSupport(true);
            tbImageView.setLongIconSupport(true);
            tbImageView.setIsLongPic(imageFileInfo.isLong());
            if (measuredWidth > 0) {
                imageFileInfo.clearPageActions();
                imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.K((measuredWidth / 3) - frameLayout3.getPaddingRight(), viewGroup.getMeasuredHeight() - frameLayout3.getPaddingTop()));
                frameLayout3.setForeground(aj.getDrawable(d.g.new_frame_add_photo_foreground_selector));
                tbImageView.setTag(imageFileInfo.toCachedKey(true));
                if (this.aBO.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.write.view.NewFrameMultiImgToolView.b.1
                    @Override // com.baidu.tbadk.imageManager.b
                    public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
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
            if (this.aCa) {
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
                                l.e(b.this.mContext, d.l.editor_mutiiamge_image_error);
                            } else if (b.this.aBY != null) {
                                b.this.aBY.b(new com.baidu.tbadk.editortools.a(15, 0, Integer.valueOf(indexOfChild)));
                            }
                        }
                    }
                });
            }
            aj.c((ImageView) frameLayout2.findViewById(d.h.delete), d.g.new_frame_btn_delete_photo_selector);
            ((LinearLayout) frameLayout2.findViewById(d.h.delete_info)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.view.NewFrameMultiImgToolView.b.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.gKc != null) {
                        b.this.gKc.M(frameLayout2);
                    }
                }
            });
            frameLayout2.setContentDescription(getString(d.l.editor_image) + (i + 1) + " " + imageFileInfo.getModifyTime());
            return frameLayout2;
        }
    }

    public void setDeleteAction(int i) {
        this.aBR = i;
    }

    public void setTargetToolId(int i) {
        this.aBS = i;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void onChangeSkinType(int i) {
        aj.k(this, d.e.common_color_10255);
    }

    public void setNeedQuit(boolean z) {
        this.aBT = z;
    }
}
