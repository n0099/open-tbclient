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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.x;
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
    private static boolean azJ = false;
    private int JT;
    private com.baidu.tbadk.editortools.j JU;
    private DragHorizonScrollView azK;
    private DragLayer azM;
    private WriteImagesInfo azN;
    private com.baidu.tbadk.img.b azO;
    private int azR;
    private int azS;
    private boolean azT;
    private b fXH;
    private a fXI;
    protected com.baidu.tbadk.editortools.b mActionListener;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public interface a {
        void F(View view);
    }

    public NewFrameMultiImgToolView(Context context) {
        super(context);
        this.azR = 49;
        this.azS = 27;
        this.azT = false;
        this.fXI = new e(this);
        this.mActionListener = new f(this);
    }

    public NewFrameMultiImgToolView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.azR = 49;
        this.azS = 27;
        this.azT = false;
        this.fXI = new e(this);
        this.mActionListener = new f(this);
    }

    public void initView() {
        this.azK = (DragHorizonScrollView) findViewById(w.h.muti_image_upload_dragscrollview);
        this.azM = (DragLayer) findViewById(w.h.muti_image_upload_draglayer);
    }

    public void setAsyncLocalImageLoader(com.baidu.tbadk.img.b bVar) {
        this.azO = bVar;
    }

    public int getImageNum() {
        return this.azN.getChosedFiles().size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(WriteImagesInfo writeImagesInfo, boolean z) {
        this.azN = writeImagesInfo;
        this.fXH = new b(getContext(), this.azO, this, this.fXI, this.azS == 27);
        this.fXH.a(this.azN);
        this.azK.a(this.fXH, z);
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 9:
                    if (this.fXH != null) {
                        this.fXH.notifyDataSetChanged();
                    }
                    b(new com.baidu.tbadk.editortools.a(2, this.azS, null));
                    return;
                case 12:
                case w.n.View_hapticFeedbackEnabled /* 46 */:
                    if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a)) {
                        a(((com.baidu.tbadk.editortools.imagetool.a) aVar.data).azG, ((com.baidu.tbadk.editortools.imagetool.a) aVar.data).azH);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public void boO() {
        if (this.JU != null) {
            this.JU.a(46, this.mActionListener);
            this.JU.a(47, this.mActionListener);
            this.JU.a(48, this.mActionListener);
        }
    }

    @Override // com.baidu.tbadk.editortools.y
    public void setEditorTools(com.baidu.tbadk.editortools.j jVar) {
        this.JU = jVar;
    }

    @Override // com.baidu.tbadk.editortools.y
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.JU != null) {
            this.JU.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.y
    public void setToolId(int i) {
        this.JT = i;
    }

    @Override // com.baidu.tbadk.editortools.y
    public int getToolId() {
        return this.JT;
    }

    @Override // com.baidu.tbadk.editortools.y
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.y
    public void lO() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.y
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView.a
    public void J(int i, int i2) {
        if (i != i2 && this.azN != null && this.azN.size() != 0) {
            LinkedList<ImageFileInfo> chosedFiles = this.azN.getChosedFiles();
            chosedFiles.add(i2, chosedFiles.remove(i));
        }
    }

    public DragHorizonScrollView getDragHorizonScrollView() {
        return this.azK;
    }

    public DragLayer getDragLayer() {
        return this.azM;
    }

    /* loaded from: classes.dex */
    public static class b extends BaseAdapter {
        private boolean aAa;
        private com.baidu.tbadk.img.b azO;
        private WriteImagesInfo azX = null;
        private y azY;
        private a fXK;
        private Context mContext;

        public b(Context context, com.baidu.tbadk.img.b bVar, y yVar, a aVar, boolean z) {
            this.aAa = true;
            this.mContext = context;
            this.azO = bVar;
            this.azY = yVar;
            this.fXK = aVar;
            this.aAa = z;
        }

        public void a(WriteImagesInfo writeImagesInfo) {
            this.azX = writeImagesInfo;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.azX == null) {
                return 0;
            }
            return this.azX.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return this.azX.getChosedFiles().get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            FrameLayout frameLayout = view == null ? (FrameLayout) LayoutInflater.from(this.mContext).inflate(w.j.new_frame_editor_muti_image_item, (ViewGroup) null) : view;
            ImageFileInfo imageFileInfo = (ImageFileInfo) x.c(this.azX.getChosedFiles(), i);
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
                frameLayout3.setForeground(aq.getDrawable(w.g.new_frame_add_photo_foreground_selector));
                tbImageView.setTag(imageFileInfo.toCachedKey(true));
                if (this.azO.a(imageFileInfo, new g(this, viewGroup), true) != null) {
                    tbImageView.invalidate();
                }
            }
            frameLayout2.setLayoutParams(new ViewGroup.LayoutParams(measuredWidth / 3, -1));
            if (this.aAa) {
                frameLayout2.setOnClickListener(new h(this, viewGroup));
            }
            aq.c((ImageView) frameLayout2.findViewById(w.h.delete), w.g.new_frame_btn_delete_photo_selector);
            aq.c((ImageView) frameLayout2.findViewById(w.h.gif_icon), w.g.ic_image_gif);
            ((LinearLayout) frameLayout2.findViewById(w.h.delete_info)).setOnClickListener(new i(this, frameLayout2));
            frameLayout2.setContentDescription(String.valueOf(frameLayout2.getResources().getString(w.l.log_msg_pic)) + (i + 1) + " " + imageFileInfo.getModifyTime());
            return frameLayout2;
        }
    }

    public void setDeleteAction(int i) {
        this.azR = i;
    }

    public void setTargetToolId(int i) {
        this.azS = i;
    }

    @Override // com.baidu.tbadk.editortools.y
    public void onChangeSkinType(int i) {
        aq.k(this, w.e.common_color_10255);
    }

    public void setNeedQuit(boolean z) {
        this.azT = z;
    }
}
