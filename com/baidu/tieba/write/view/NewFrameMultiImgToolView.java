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
    private static boolean aBw = false;
    private int JG;
    private i JH;
    private WriteImagesInfo aBA;
    private com.baidu.tbadk.img.b aBB;
    private int aBE;
    private int aBF;
    private boolean aBG;
    private DragHorizonScrollView aBx;
    private DragLayer aBz;
    private b gJK;
    private a gJL;
    protected com.baidu.tbadk.editortools.b mActionListener;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes2.dex */
    public interface a {
        void M(View view);
    }

    public NewFrameMultiImgToolView(Context context) {
        super(context);
        this.aBE = 49;
        this.aBF = 27;
        this.aBG = false;
        this.gJL = new a() { // from class: com.baidu.tieba.write.view.NewFrameMultiImgToolView.1
            @Override // com.baidu.tieba.write.view.NewFrameMultiImgToolView.a
            public void M(View view) {
                if (!NewFrameMultiImgToolView.this.aBx.brP()) {
                    NewFrameMultiImgToolView.this.bF(view);
                    int bG = NewFrameMultiImgToolView.this.aBx.bG(view);
                    if (bG >= 0 && bG < NewFrameMultiImgToolView.this.aBA.getChosedFiles().size()) {
                        ImageFileInfo remove = NewFrameMultiImgToolView.this.aBA.getChosedFiles().remove(bG);
                        if (remove.isTempFile()) {
                            d.dH().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                        }
                        int maxItemNum = NewFrameMultiImgToolView.this.aBx.getMaxItemNum();
                        int size = NewFrameMultiImgToolView.this.aBA.getChosedFiles().size();
                        if (NewFrameMultiImgToolView.this.JH != null) {
                            NewFrameMultiImgToolView.this.JH.b(new com.baidu.tbadk.editortools.a(NewFrameMultiImgToolView.this.aBE, -1, null));
                            if (size > 0) {
                                NewFrameMultiImgToolView.this.JH.b(new com.baidu.tbadk.editortools.a(2, NewFrameMultiImgToolView.this.aBF, String.valueOf(size)));
                            } else {
                                NewFrameMultiImgToolView.this.JH.b(new com.baidu.tbadk.editortools.a(2, NewFrameMultiImgToolView.this.aBF, null));
                            }
                            if (maxItemNum == 1 && size == 0) {
                                if (NewFrameMultiImgToolView.this.aBG) {
                                    NewFrameMultiImgToolView.this.JH.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                                } else {
                                    NewFrameMultiImgToolView.this.a(NewFrameMultiImgToolView.this.aBA, true);
                                    NewFrameMultiImgToolView.this.JH.invalidate();
                                }
                            }
                        }
                        if (size == 0) {
                            NewFrameMultiImgToolView.this.a(NewFrameMultiImgToolView.this.aBA, true);
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
                            if (NewFrameMultiImgToolView.this.gJK != null) {
                                NewFrameMultiImgToolView.this.gJK.notifyDataSetChanged();
                            }
                            NewFrameMultiImgToolView.this.b(new com.baidu.tbadk.editortools.a(2, NewFrameMultiImgToolView.this.aBF, null));
                            return;
                        case 12:
                        case d.n.View_hapticFeedbackEnabled /* 46 */:
                            if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a)) {
                                NewFrameMultiImgToolView.this.a(((com.baidu.tbadk.editortools.imagetool.a) aVar.data).aBt, ((com.baidu.tbadk.editortools.imagetool.a) aVar.data).aBu);
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
        this.aBE = 49;
        this.aBF = 27;
        this.aBG = false;
        this.gJL = new a() { // from class: com.baidu.tieba.write.view.NewFrameMultiImgToolView.1
            @Override // com.baidu.tieba.write.view.NewFrameMultiImgToolView.a
            public void M(View view) {
                if (!NewFrameMultiImgToolView.this.aBx.brP()) {
                    NewFrameMultiImgToolView.this.bF(view);
                    int bG = NewFrameMultiImgToolView.this.aBx.bG(view);
                    if (bG >= 0 && bG < NewFrameMultiImgToolView.this.aBA.getChosedFiles().size()) {
                        ImageFileInfo remove = NewFrameMultiImgToolView.this.aBA.getChosedFiles().remove(bG);
                        if (remove.isTempFile()) {
                            com.baidu.adp.lib.Disk.d.dH().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                        }
                        int maxItemNum = NewFrameMultiImgToolView.this.aBx.getMaxItemNum();
                        int size = NewFrameMultiImgToolView.this.aBA.getChosedFiles().size();
                        if (NewFrameMultiImgToolView.this.JH != null) {
                            NewFrameMultiImgToolView.this.JH.b(new com.baidu.tbadk.editortools.a(NewFrameMultiImgToolView.this.aBE, -1, null));
                            if (size > 0) {
                                NewFrameMultiImgToolView.this.JH.b(new com.baidu.tbadk.editortools.a(2, NewFrameMultiImgToolView.this.aBF, String.valueOf(size)));
                            } else {
                                NewFrameMultiImgToolView.this.JH.b(new com.baidu.tbadk.editortools.a(2, NewFrameMultiImgToolView.this.aBF, null));
                            }
                            if (maxItemNum == 1 && size == 0) {
                                if (NewFrameMultiImgToolView.this.aBG) {
                                    NewFrameMultiImgToolView.this.JH.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                                } else {
                                    NewFrameMultiImgToolView.this.a(NewFrameMultiImgToolView.this.aBA, true);
                                    NewFrameMultiImgToolView.this.JH.invalidate();
                                }
                            }
                        }
                        if (size == 0) {
                            NewFrameMultiImgToolView.this.a(NewFrameMultiImgToolView.this.aBA, true);
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
                            if (NewFrameMultiImgToolView.this.gJK != null) {
                                NewFrameMultiImgToolView.this.gJK.notifyDataSetChanged();
                            }
                            NewFrameMultiImgToolView.this.b(new com.baidu.tbadk.editortools.a(2, NewFrameMultiImgToolView.this.aBF, null));
                            return;
                        case 12:
                        case d.n.View_hapticFeedbackEnabled /* 46 */:
                            if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a)) {
                                NewFrameMultiImgToolView.this.a(((com.baidu.tbadk.editortools.imagetool.a) aVar.data).aBt, ((com.baidu.tbadk.editortools.imagetool.a) aVar.data).aBu);
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
        this.aBx = (DragHorizonScrollView) findViewById(d.h.muti_image_upload_dragscrollview);
        this.aBz = (DragLayer) findViewById(d.h.muti_image_upload_draglayer);
    }

    public void setAsyncLocalImageLoader(com.baidu.tbadk.img.b bVar) {
        this.aBB = bVar;
    }

    public int getImageNum() {
        return this.aBA.getChosedFiles().size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(WriteImagesInfo writeImagesInfo, boolean z) {
        this.aBA = writeImagesInfo;
        this.gJK = new b(getContext(), this.aBB, this, this.gJL, this.aBF == 27);
        this.gJK.a(this.aBA);
        this.aBx.a(this.gJK, z);
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 9:
                    if (this.gJK != null) {
                        this.gJK.notifyDataSetChanged();
                    }
                    b(new com.baidu.tbadk.editortools.a(2, this.aBF, null));
                    return;
                case 12:
                case d.n.View_hapticFeedbackEnabled /* 46 */:
                    if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a)) {
                        a(((com.baidu.tbadk.editortools.imagetool.a) aVar.data).aBt, ((com.baidu.tbadk.editortools.imagetool.a) aVar.data).aBu);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public void bAh() {
        if (this.JH != null) {
            this.JH.a(46, this.mActionListener);
            this.JH.a(47, this.mActionListener);
            this.JH.a(48, this.mActionListener);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setEditorTools(i iVar) {
        this.JH = iVar;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.JH != null) {
            this.JH.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setToolId(int i) {
        this.JG = i;
    }

    @Override // com.baidu.tbadk.editortools.s
    public int getToolId() {
        return this.JG;
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
        if (i != i2 && this.aBA != null && this.aBA.size() != 0) {
            LinkedList<ImageFileInfo> chosedFiles = this.aBA.getChosedFiles();
            chosedFiles.add(i2, chosedFiles.remove(i));
        }
    }

    public DragHorizonScrollView getDragHorizonScrollView() {
        return this.aBx;
    }

    public DragLayer getDragLayer() {
        return this.aBz;
    }

    /* loaded from: classes2.dex */
    public static class b extends BaseAdapter {
        private com.baidu.tbadk.img.b aBB;
        private WriteImagesInfo aBK = null;
        private s aBL;
        private boolean aBN;
        private a gJN;
        private LayoutInflater gJO;
        private Context mContext;

        private int getDimensionPixelSize(int i) {
            return this.mContext.getResources().getDimensionPixelSize(i);
        }

        private String getString(int i) {
            return this.mContext.getResources().getString(i);
        }

        public b(Context context, com.baidu.tbadk.img.b bVar, s sVar, a aVar, boolean z) {
            this.aBN = true;
            this.aBL = sVar;
            this.mContext = context;
            this.gJO = LayoutInflater.from(this.mContext);
            this.aBB = bVar;
            this.gJN = aVar;
            this.aBN = z;
        }

        public void a(WriteImagesInfo writeImagesInfo) {
            this.aBK = writeImagesInfo;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.aBK == null) {
                return 0;
            }
            return this.aBK.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return this.aBK.getChosedFiles().get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, final ViewGroup viewGroup) {
            FrameLayout frameLayout = view == null ? (FrameLayout) this.gJO.inflate(d.j.new_frame_editor_muti_image_item, (ViewGroup) null) : view;
            ImageFileInfo imageFileInfo = (ImageFileInfo) v.c(this.aBK.getChosedFiles(), i);
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
                if (this.aBB.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.write.view.NewFrameMultiImgToolView.b.1
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
            if (this.aBN) {
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
                            } else if (b.this.aBL != null) {
                                b.this.aBL.b(new com.baidu.tbadk.editortools.a(15, 0, Integer.valueOf(indexOfChild)));
                            }
                        }
                    }
                });
            }
            aj.c((ImageView) frameLayout2.findViewById(d.h.delete), d.g.new_frame_btn_delete_photo_selector);
            ((LinearLayout) frameLayout2.findViewById(d.h.delete_info)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.view.NewFrameMultiImgToolView.b.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.gJN != null) {
                        b.this.gJN.M(frameLayout2);
                    }
                }
            });
            frameLayout2.setContentDescription(getString(d.l.editor_image) + (i + 1) + " " + imageFileInfo.getModifyTime());
            return frameLayout2;
        }
    }

    public void setDeleteAction(int i) {
        this.aBE = i;
    }

    public void setTargetToolId(int i) {
        this.aBF = i;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void onChangeSkinType(int i) {
        aj.k(this, d.e.common_color_10255);
    }

    public void setNeedQuit(boolean z) {
        this.aBG = z;
    }
}
