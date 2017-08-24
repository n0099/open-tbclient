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
    private static boolean aDf = false;
    private int Ls;
    private i Lt;
    private DragHorizonScrollView aDg;
    private DragLayer aDi;
    private WriteImagesInfo aDj;
    private com.baidu.tbadk.img.b aDk;
    private int aDn;
    private int aDo;
    private boolean aDp;
    private b gFG;
    private a gFH;
    protected com.baidu.tbadk.editortools.b mActionListener;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public interface a {
        void G(View view);
    }

    public NewFrameMultiImgToolView(Context context) {
        super(context);
        this.aDn = 49;
        this.aDo = 27;
        this.aDp = false;
        this.gFH = new a() { // from class: com.baidu.tieba.write.view.NewFrameMultiImgToolView.1
            @Override // com.baidu.tieba.write.view.NewFrameMultiImgToolView.a
            public void G(View view) {
                if (!NewFrameMultiImgToolView.this.aDg.bty()) {
                    NewFrameMultiImgToolView.this.by(view);
                    int bz = NewFrameMultiImgToolView.this.aDg.bz(view);
                    if (bz >= 0 && bz < NewFrameMultiImgToolView.this.aDj.getChosedFiles().size()) {
                        ImageFileInfo remove = NewFrameMultiImgToolView.this.aDj.getChosedFiles().remove(bz);
                        if (remove.isTempFile()) {
                            d.dS().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                        }
                        int maxItemNum = NewFrameMultiImgToolView.this.aDg.getMaxItemNum();
                        int size = NewFrameMultiImgToolView.this.aDj.getChosedFiles().size();
                        if (NewFrameMultiImgToolView.this.Lt != null) {
                            NewFrameMultiImgToolView.this.Lt.b(new com.baidu.tbadk.editortools.a(NewFrameMultiImgToolView.this.aDn, -1, null));
                            if (size > 0) {
                                NewFrameMultiImgToolView.this.Lt.b(new com.baidu.tbadk.editortools.a(2, NewFrameMultiImgToolView.this.aDo, String.valueOf(size)));
                            } else {
                                NewFrameMultiImgToolView.this.Lt.b(new com.baidu.tbadk.editortools.a(2, NewFrameMultiImgToolView.this.aDo, null));
                            }
                            if (maxItemNum == 1 && size == 0) {
                                if (NewFrameMultiImgToolView.this.aDp) {
                                    NewFrameMultiImgToolView.this.Lt.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                                } else {
                                    NewFrameMultiImgToolView.this.a(NewFrameMultiImgToolView.this.aDj, true);
                                    NewFrameMultiImgToolView.this.Lt.invalidate();
                                }
                            }
                        }
                        if (size == 0) {
                            NewFrameMultiImgToolView.this.a(NewFrameMultiImgToolView.this.aDj, true);
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
                            if (NewFrameMultiImgToolView.this.gFG != null) {
                                NewFrameMultiImgToolView.this.gFG.notifyDataSetChanged();
                            }
                            NewFrameMultiImgToolView.this.b(new com.baidu.tbadk.editortools.a(2, NewFrameMultiImgToolView.this.aDo, null));
                            return;
                        case 12:
                        case d.n.View_hapticFeedbackEnabled /* 46 */:
                            if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a)) {
                                NewFrameMultiImgToolView.this.a(((com.baidu.tbadk.editortools.imagetool.a) aVar.data).aDc, ((com.baidu.tbadk.editortools.imagetool.a) aVar.data).aDd);
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
        this.aDn = 49;
        this.aDo = 27;
        this.aDp = false;
        this.gFH = new a() { // from class: com.baidu.tieba.write.view.NewFrameMultiImgToolView.1
            @Override // com.baidu.tieba.write.view.NewFrameMultiImgToolView.a
            public void G(View view) {
                if (!NewFrameMultiImgToolView.this.aDg.bty()) {
                    NewFrameMultiImgToolView.this.by(view);
                    int bz = NewFrameMultiImgToolView.this.aDg.bz(view);
                    if (bz >= 0 && bz < NewFrameMultiImgToolView.this.aDj.getChosedFiles().size()) {
                        ImageFileInfo remove = NewFrameMultiImgToolView.this.aDj.getChosedFiles().remove(bz);
                        if (remove.isTempFile()) {
                            com.baidu.adp.lib.Disk.d.dS().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                        }
                        int maxItemNum = NewFrameMultiImgToolView.this.aDg.getMaxItemNum();
                        int size = NewFrameMultiImgToolView.this.aDj.getChosedFiles().size();
                        if (NewFrameMultiImgToolView.this.Lt != null) {
                            NewFrameMultiImgToolView.this.Lt.b(new com.baidu.tbadk.editortools.a(NewFrameMultiImgToolView.this.aDn, -1, null));
                            if (size > 0) {
                                NewFrameMultiImgToolView.this.Lt.b(new com.baidu.tbadk.editortools.a(2, NewFrameMultiImgToolView.this.aDo, String.valueOf(size)));
                            } else {
                                NewFrameMultiImgToolView.this.Lt.b(new com.baidu.tbadk.editortools.a(2, NewFrameMultiImgToolView.this.aDo, null));
                            }
                            if (maxItemNum == 1 && size == 0) {
                                if (NewFrameMultiImgToolView.this.aDp) {
                                    NewFrameMultiImgToolView.this.Lt.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                                } else {
                                    NewFrameMultiImgToolView.this.a(NewFrameMultiImgToolView.this.aDj, true);
                                    NewFrameMultiImgToolView.this.Lt.invalidate();
                                }
                            }
                        }
                        if (size == 0) {
                            NewFrameMultiImgToolView.this.a(NewFrameMultiImgToolView.this.aDj, true);
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
                            if (NewFrameMultiImgToolView.this.gFG != null) {
                                NewFrameMultiImgToolView.this.gFG.notifyDataSetChanged();
                            }
                            NewFrameMultiImgToolView.this.b(new com.baidu.tbadk.editortools.a(2, NewFrameMultiImgToolView.this.aDo, null));
                            return;
                        case 12:
                        case d.n.View_hapticFeedbackEnabled /* 46 */:
                            if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a)) {
                                NewFrameMultiImgToolView.this.a(((com.baidu.tbadk.editortools.imagetool.a) aVar.data).aDc, ((com.baidu.tbadk.editortools.imagetool.a) aVar.data).aDd);
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
        this.aDg = (DragHorizonScrollView) findViewById(d.h.muti_image_upload_dragscrollview);
        this.aDi = (DragLayer) findViewById(d.h.muti_image_upload_draglayer);
    }

    public void setAsyncLocalImageLoader(com.baidu.tbadk.img.b bVar) {
        this.aDk = bVar;
    }

    public int getImageNum() {
        return this.aDj.getChosedFiles().size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(WriteImagesInfo writeImagesInfo, boolean z) {
        this.aDj = writeImagesInfo;
        this.gFG = new b(getContext(), this.aDk, this, this.gFH, this.aDo == 27);
        this.gFG.a(this.aDj);
        this.aDg.a(this.gFG, z);
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 9:
                    if (this.gFG != null) {
                        this.gFG.notifyDataSetChanged();
                    }
                    b(new com.baidu.tbadk.editortools.a(2, this.aDo, null));
                    return;
                case 12:
                case d.n.View_hapticFeedbackEnabled /* 46 */:
                    if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a)) {
                        a(((com.baidu.tbadk.editortools.imagetool.a) aVar.data).aDc, ((com.baidu.tbadk.editortools.imagetool.a) aVar.data).aDd);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public void bzA() {
        if (this.Lt != null) {
            this.Lt.a(46, this.mActionListener);
            this.Lt.a(47, this.mActionListener);
            this.Lt.a(48, this.mActionListener);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setEditorTools(i iVar) {
        this.Lt = iVar;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Lt != null) {
            this.Lt.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setToolId(int i) {
        this.Ls = i;
    }

    @Override // com.baidu.tbadk.editortools.s
    public int getToolId() {
        return this.Ls;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.s
    public void lS() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.s
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView.a
    public void K(int i, int i2) {
        if (i != i2 && this.aDj != null && this.aDj.size() != 0) {
            LinkedList<ImageFileInfo> chosedFiles = this.aDj.getChosedFiles();
            chosedFiles.add(i2, chosedFiles.remove(i));
        }
    }

    public DragHorizonScrollView getDragHorizonScrollView() {
        return this.aDg;
    }

    public DragLayer getDragLayer() {
        return this.aDi;
    }

    /* loaded from: classes.dex */
    public static class b extends BaseAdapter {
        private com.baidu.tbadk.img.b aDk;
        private WriteImagesInfo aDt = null;
        private s aDu;
        private boolean aDw;
        private a gFJ;
        private Context mContext;

        public b(Context context, com.baidu.tbadk.img.b bVar, s sVar, a aVar, boolean z) {
            this.aDw = true;
            this.mContext = context;
            this.aDk = bVar;
            this.aDu = sVar;
            this.gFJ = aVar;
            this.aDw = z;
        }

        public void a(WriteImagesInfo writeImagesInfo) {
            this.aDt = writeImagesInfo;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.aDt == null) {
                return 0;
            }
            return this.aDt.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return this.aDt.getChosedFiles().get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, final ViewGroup viewGroup) {
            FrameLayout frameLayout = view == null ? (FrameLayout) LayoutInflater.from(this.mContext).inflate(d.j.new_frame_editor_muti_image_item, (ViewGroup) null) : view;
            ImageFileInfo imageFileInfo = (ImageFileInfo) u.c(this.aDt.getChosedFiles(), i);
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
                if (this.aDk.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.write.view.NewFrameMultiImgToolView.b.1
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
            if (this.aDw) {
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
                            } else if (b.this.aDu != null) {
                                b.this.aDu.b(new com.baidu.tbadk.editortools.a(15, 0, Integer.valueOf(indexOfChild)));
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
                    if (b.this.gFJ != null) {
                        b.this.gFJ.G(frameLayout2);
                    }
                }
            });
            frameLayout2.setContentDescription(frameLayout2.getResources().getString(d.l.log_msg_pic) + (i + 1) + " " + imageFileInfo.getModifyTime());
            return frameLayout2;
        }
    }

    public void setDeleteAction(int i) {
        this.aDn = i;
    }

    public void setTargetToolId(int i) {
        this.aDo = i;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void onChangeSkinType(int i) {
        ai.k(this, d.e.common_color_10255);
    }

    public void setNeedQuit(boolean z) {
        this.aDp = z;
    }
}
