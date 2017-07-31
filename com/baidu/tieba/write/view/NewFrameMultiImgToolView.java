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
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.u;
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
/* loaded from: classes.dex */
public class NewFrameMultiImgToolView extends com.baidu.tieba.tbadkCore.imgView.a implements s, DragHorizonScrollView.a {
    private static boolean aDd = false;
    private int Lq;
    private i Lr;
    private DragHorizonScrollView aDe;
    private DragLayer aDg;
    private WriteImagesInfo aDh;
    private com.baidu.tbadk.img.b aDi;
    private int aDl;
    private int aDm;
    private boolean aDn;
    private b gDO;
    private a gDP;
    protected com.baidu.tbadk.editortools.b mActionListener;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public interface a {
        void G(View view);
    }

    public NewFrameMultiImgToolView(Context context) {
        super(context);
        this.aDl = 49;
        this.aDm = 27;
        this.aDn = false;
        this.gDP = new a() { // from class: com.baidu.tieba.write.view.NewFrameMultiImgToolView.1
            @Override // com.baidu.tieba.write.view.NewFrameMultiImgToolView.a
            public void G(View view) {
                if (!NewFrameMultiImgToolView.this.aDe.bsX()) {
                    NewFrameMultiImgToolView.this.bx(view);
                    int by = NewFrameMultiImgToolView.this.aDe.by(view);
                    if (by >= 0 && by < NewFrameMultiImgToolView.this.aDh.getChosedFiles().size()) {
                        ImageFileInfo remove = NewFrameMultiImgToolView.this.aDh.getChosedFiles().remove(by);
                        if (remove.isTempFile()) {
                            d.dS().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                        }
                        int maxItemNum = NewFrameMultiImgToolView.this.aDe.getMaxItemNum();
                        int size = NewFrameMultiImgToolView.this.aDh.getChosedFiles().size();
                        if (NewFrameMultiImgToolView.this.Lr != null) {
                            NewFrameMultiImgToolView.this.Lr.b(new com.baidu.tbadk.editortools.a(NewFrameMultiImgToolView.this.aDl, -1, null));
                            if (size > 0) {
                                NewFrameMultiImgToolView.this.Lr.b(new com.baidu.tbadk.editortools.a(2, NewFrameMultiImgToolView.this.aDm, String.valueOf(size)));
                            } else {
                                NewFrameMultiImgToolView.this.Lr.b(new com.baidu.tbadk.editortools.a(2, NewFrameMultiImgToolView.this.aDm, null));
                            }
                            if (maxItemNum == 1 && size == 0) {
                                if (NewFrameMultiImgToolView.this.aDn) {
                                    NewFrameMultiImgToolView.this.Lr.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                                } else {
                                    NewFrameMultiImgToolView.this.a(NewFrameMultiImgToolView.this.aDh, true);
                                    NewFrameMultiImgToolView.this.Lr.invalidate();
                                }
                            }
                        }
                        if (size == 0) {
                            NewFrameMultiImgToolView.this.a(NewFrameMultiImgToolView.this.aDh, true);
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
                            if (NewFrameMultiImgToolView.this.gDO != null) {
                                NewFrameMultiImgToolView.this.gDO.notifyDataSetChanged();
                            }
                            NewFrameMultiImgToolView.this.b(new com.baidu.tbadk.editortools.a(2, NewFrameMultiImgToolView.this.aDm, null));
                            return;
                        case 12:
                        case d.n.View_hapticFeedbackEnabled /* 46 */:
                            if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a)) {
                                NewFrameMultiImgToolView.this.a(((com.baidu.tbadk.editortools.imagetool.a) aVar.data).aDa, ((com.baidu.tbadk.editortools.imagetool.a) aVar.data).aDb);
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
        this.aDl = 49;
        this.aDm = 27;
        this.aDn = false;
        this.gDP = new a() { // from class: com.baidu.tieba.write.view.NewFrameMultiImgToolView.1
            @Override // com.baidu.tieba.write.view.NewFrameMultiImgToolView.a
            public void G(View view) {
                if (!NewFrameMultiImgToolView.this.aDe.bsX()) {
                    NewFrameMultiImgToolView.this.bx(view);
                    int by = NewFrameMultiImgToolView.this.aDe.by(view);
                    if (by >= 0 && by < NewFrameMultiImgToolView.this.aDh.getChosedFiles().size()) {
                        ImageFileInfo remove = NewFrameMultiImgToolView.this.aDh.getChosedFiles().remove(by);
                        if (remove.isTempFile()) {
                            com.baidu.adp.lib.Disk.d.dS().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                        }
                        int maxItemNum = NewFrameMultiImgToolView.this.aDe.getMaxItemNum();
                        int size = NewFrameMultiImgToolView.this.aDh.getChosedFiles().size();
                        if (NewFrameMultiImgToolView.this.Lr != null) {
                            NewFrameMultiImgToolView.this.Lr.b(new com.baidu.tbadk.editortools.a(NewFrameMultiImgToolView.this.aDl, -1, null));
                            if (size > 0) {
                                NewFrameMultiImgToolView.this.Lr.b(new com.baidu.tbadk.editortools.a(2, NewFrameMultiImgToolView.this.aDm, String.valueOf(size)));
                            } else {
                                NewFrameMultiImgToolView.this.Lr.b(new com.baidu.tbadk.editortools.a(2, NewFrameMultiImgToolView.this.aDm, null));
                            }
                            if (maxItemNum == 1 && size == 0) {
                                if (NewFrameMultiImgToolView.this.aDn) {
                                    NewFrameMultiImgToolView.this.Lr.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                                } else {
                                    NewFrameMultiImgToolView.this.a(NewFrameMultiImgToolView.this.aDh, true);
                                    NewFrameMultiImgToolView.this.Lr.invalidate();
                                }
                            }
                        }
                        if (size == 0) {
                            NewFrameMultiImgToolView.this.a(NewFrameMultiImgToolView.this.aDh, true);
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
                            if (NewFrameMultiImgToolView.this.gDO != null) {
                                NewFrameMultiImgToolView.this.gDO.notifyDataSetChanged();
                            }
                            NewFrameMultiImgToolView.this.b(new com.baidu.tbadk.editortools.a(2, NewFrameMultiImgToolView.this.aDm, null));
                            return;
                        case 12:
                        case d.n.View_hapticFeedbackEnabled /* 46 */:
                            if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a)) {
                                NewFrameMultiImgToolView.this.a(((com.baidu.tbadk.editortools.imagetool.a) aVar.data).aDa, ((com.baidu.tbadk.editortools.imagetool.a) aVar.data).aDb);
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
        this.aDe = (DragHorizonScrollView) findViewById(d.h.muti_image_upload_dragscrollview);
        this.aDg = (DragLayer) findViewById(d.h.muti_image_upload_draglayer);
    }

    public void setAsyncLocalImageLoader(com.baidu.tbadk.img.b bVar) {
        this.aDi = bVar;
    }

    public int getImageNum() {
        return this.aDh.getChosedFiles().size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(WriteImagesInfo writeImagesInfo, boolean z) {
        this.aDh = writeImagesInfo;
        this.gDO = new b(getContext(), this.aDi, this, this.gDP, this.aDm == 27);
        this.gDO.a(this.aDh);
        this.aDe.a(this.gDO, z);
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 9:
                    if (this.gDO != null) {
                        this.gDO.notifyDataSetChanged();
                    }
                    b(new com.baidu.tbadk.editortools.a(2, this.aDm, null));
                    return;
                case 12:
                case d.n.View_hapticFeedbackEnabled /* 46 */:
                    if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a)) {
                        a(((com.baidu.tbadk.editortools.imagetool.a) aVar.data).aDa, ((com.baidu.tbadk.editortools.imagetool.a) aVar.data).aDb);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public void bzb() {
        if (this.Lr != null) {
            this.Lr.a(46, this.mActionListener);
            this.Lr.a(47, this.mActionListener);
            this.Lr.a(48, this.mActionListener);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setEditorTools(i iVar) {
        this.Lr = iVar;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Lr != null) {
            this.Lr.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setToolId(int i) {
        this.Lq = i;
    }

    @Override // com.baidu.tbadk.editortools.s
    public int getToolId() {
        return this.Lq;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.s
    public void lT() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.s
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView.a
    public void K(int i, int i2) {
        if (i != i2 && this.aDh != null && this.aDh.size() != 0) {
            LinkedList<ImageFileInfo> chosedFiles = this.aDh.getChosedFiles();
            chosedFiles.add(i2, chosedFiles.remove(i));
        }
    }

    public DragHorizonScrollView getDragHorizonScrollView() {
        return this.aDe;
    }

    public DragLayer getDragLayer() {
        return this.aDg;
    }

    /* loaded from: classes.dex */
    public static class b extends BaseAdapter {
        private com.baidu.tbadk.img.b aDi;
        private WriteImagesInfo aDr = null;
        private s aDs;
        private boolean aDu;
        private a gDR;
        private Context mContext;

        public b(Context context, com.baidu.tbadk.img.b bVar, s sVar, a aVar, boolean z) {
            this.aDu = true;
            this.mContext = context;
            this.aDi = bVar;
            this.aDs = sVar;
            this.gDR = aVar;
            this.aDu = z;
        }

        public void a(WriteImagesInfo writeImagesInfo) {
            this.aDr = writeImagesInfo;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.aDr == null) {
                return 0;
            }
            return this.aDr.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return this.aDr.getChosedFiles().get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, final ViewGroup viewGroup) {
            FrameLayout frameLayout = view == null ? (FrameLayout) LayoutInflater.from(this.mContext).inflate(d.j.new_frame_editor_muti_image_item, (ViewGroup) null) : view;
            ImageFileInfo imageFileInfo = (ImageFileInfo) u.c(this.aDr.getChosedFiles(), i);
            if (imageFileInfo == null) {
                return null;
            }
            int measuredWidth = (viewGroup.getMeasuredWidth() - (this.mContext.getResources().getDimensionPixelSize(d.f.ds66) * 2)) + this.mContext.getResources().getDimensionPixelSize(d.f.ds32);
            final FrameLayout frameLayout2 = (FrameLayout) frameLayout;
            FrameLayout frameLayout3 = (FrameLayout) frameLayout2.findViewById(d.h.item_root);
            TbImageView tbImageView = (TbImageView) frameLayout2.findViewById(d.h.iv);
            if (measuredWidth > 0) {
                imageFileInfo.clearPageActions();
                imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.M((measuredWidth / 3) - frameLayout3.getPaddingRight(), viewGroup.getMeasuredHeight() - frameLayout3.getPaddingTop()));
                frameLayout3.setForeground(ai.getDrawable(d.g.new_frame_add_photo_foreground_selector));
                tbImageView.setTag(imageFileInfo.toCachedKey(true));
                if (this.aDi.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.write.view.NewFrameMultiImgToolView.b.1
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
            if (this.aDu) {
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
                                k.f(b.this.mContext, d.l.editor_mutiiamge_image_error);
                            } else if (b.this.aDs != null) {
                                b.this.aDs.b(new com.baidu.tbadk.editortools.a(15, 0, Integer.valueOf(indexOfChild)));
                            }
                        }
                    }
                });
            }
            LinearLayout linearLayout = (LinearLayout) frameLayout2.findViewById(d.h.delete_info);
            ImageView imageView = (ImageView) frameLayout2.findViewById(d.h.gif_icon);
            ai.c((ImageView) frameLayout2.findViewById(d.h.delete), d.g.new_frame_btn_delete_photo_selector);
            ai.c(imageView, d.g.ic_image_gif);
            if (imageFileInfo.isGif() && !imageFileInfo.hasActionsWithoutResize()) {
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(8);
            }
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.view.NewFrameMultiImgToolView.b.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.gDR != null) {
                        b.this.gDR.G(frameLayout2);
                    }
                }
            });
            frameLayout2.setContentDescription(frameLayout2.getResources().getString(d.l.log_msg_pic) + (i + 1) + " " + imageFileInfo.getModifyTime());
            return frameLayout2;
        }
    }

    public void setDeleteAction(int i) {
        this.aDl = i;
    }

    public void setTargetToolId(int i) {
        this.aDm = i;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void onChangeSkinType(int i) {
        ai.k(this, d.e.common_color_10255);
    }

    public void setNeedQuit(boolean z) {
        this.aDn = z;
    }
}
