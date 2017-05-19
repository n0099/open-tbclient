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
    private static boolean azX = false;
    private int Kf;
    private com.baidu.tbadk.editortools.j Kg;
    private DragLayer aAa;
    private WriteImagesInfo aAb;
    private com.baidu.tbadk.img.b aAc;
    private int aAf;
    private int aAg;
    private boolean aAh;
    private DragHorizonScrollView azY;
    private b fPL;
    private a fPM;
    protected com.baidu.tbadk.editortools.b mActionListener;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public interface a {
        void F(View view);
    }

    public NewFrameMultiImgToolView(Context context) {
        super(context);
        this.aAf = 49;
        this.aAg = 27;
        this.aAh = false;
        this.fPM = new e(this);
        this.mActionListener = new f(this);
    }

    public NewFrameMultiImgToolView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aAf = 49;
        this.aAg = 27;
        this.aAh = false;
        this.fPM = new e(this);
        this.mActionListener = new f(this);
    }

    public void initView() {
        this.azY = (DragHorizonScrollView) findViewById(w.h.muti_image_upload_dragscrollview);
        this.aAa = (DragLayer) findViewById(w.h.muti_image_upload_draglayer);
    }

    public void setAsyncLocalImageLoader(com.baidu.tbadk.img.b bVar) {
        this.aAc = bVar;
    }

    public int getImageNum() {
        return this.aAb.getChosedFiles().size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(WriteImagesInfo writeImagesInfo, boolean z) {
        this.aAb = writeImagesInfo;
        this.fPL = new b(getContext(), this.aAc, this, this.fPM, this.aAg == 27);
        this.fPL.a(this.aAb);
        this.azY.a(this.fPL, z);
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 9:
                    if (this.fPL != null) {
                        this.fPL.notifyDataSetChanged();
                    }
                    b(new com.baidu.tbadk.editortools.a(2, this.aAg, null));
                    return;
                case 12:
                case 46:
                    if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a)) {
                        a(((com.baidu.tbadk.editortools.imagetool.a) aVar.data).azU, ((com.baidu.tbadk.editortools.imagetool.a) aVar.data).azV);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public void bnp() {
        if (this.Kg != null) {
            this.Kg.a(46, this.mActionListener);
            this.Kg.a(47, this.mActionListener);
            this.Kg.a(48, this.mActionListener);
        }
    }

    @Override // com.baidu.tbadk.editortools.y
    public void setEditorTools(com.baidu.tbadk.editortools.j jVar) {
        this.Kg = jVar;
    }

    @Override // com.baidu.tbadk.editortools.y
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Kg != null) {
            this.Kg.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.y
    public void setToolId(int i) {
        this.Kf = i;
    }

    @Override // com.baidu.tbadk.editortools.y
    public int getToolId() {
        return this.Kf;
    }

    @Override // com.baidu.tbadk.editortools.y
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.y
    public void lW() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.y
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView.a
    public void K(int i, int i2) {
        if (i != i2 && this.aAb != null && this.aAb.size() != 0) {
            LinkedList<ImageFileInfo> chosedFiles = this.aAb.getChosedFiles();
            chosedFiles.add(i2, chosedFiles.remove(i));
        }
    }

    public DragHorizonScrollView getDragHorizonScrollView() {
        return this.azY;
    }

    public DragLayer getDragLayer() {
        return this.aAa;
    }

    /* loaded from: classes.dex */
    public static class b extends BaseAdapter {
        private com.baidu.tbadk.img.b aAc;
        private WriteImagesInfo aAl = null;
        private y aAm;
        private boolean aAo;
        private a fPO;
        private Context mContext;

        public b(Context context, com.baidu.tbadk.img.b bVar, y yVar, a aVar, boolean z) {
            this.aAo = true;
            this.mContext = context;
            this.aAc = bVar;
            this.aAm = yVar;
            this.fPO = aVar;
            this.aAo = z;
        }

        public void a(WriteImagesInfo writeImagesInfo) {
            this.aAl = writeImagesInfo;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.aAl == null) {
                return 0;
            }
            return this.aAl.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return this.aAl.getChosedFiles().get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            FrameLayout frameLayout = view == null ? (FrameLayout) LayoutInflater.from(this.mContext).inflate(w.j.new_frame_editor_muti_image_item, (ViewGroup) null) : view;
            ImageFileInfo imageFileInfo = (ImageFileInfo) x.c(this.aAl.getChosedFiles(), i);
            if (imageFileInfo == null) {
                return null;
            }
            int measuredWidth = (viewGroup.getMeasuredWidth() - (this.mContext.getResources().getDimensionPixelSize(w.f.ds66) * 2)) + this.mContext.getResources().getDimensionPixelSize(w.f.ds32);
            FrameLayout frameLayout2 = (FrameLayout) frameLayout;
            FrameLayout frameLayout3 = (FrameLayout) frameLayout2.findViewById(w.h.item_root);
            TbImageView tbImageView = (TbImageView) frameLayout2.findViewById(w.h.iv);
            if (measuredWidth > 0) {
                imageFileInfo.clearPageActions();
                imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.M((measuredWidth / 3) - frameLayout3.getPaddingRight(), viewGroup.getMeasuredHeight() - frameLayout3.getPaddingTop()));
                frameLayout3.setForeground(aq.getDrawable(w.g.new_frame_add_photo_foreground_selector));
                tbImageView.setTag(imageFileInfo.toCachedKey(true));
                if (this.aAc.a(imageFileInfo, new g(this, viewGroup), true) != null) {
                    tbImageView.invalidate();
                }
            }
            frameLayout2.setLayoutParams(new ViewGroup.LayoutParams(measuredWidth / 3, -1));
            if (this.aAo) {
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
        this.aAf = i;
    }

    public void setTargetToolId(int i) {
        this.aAg = i;
    }

    @Override // com.baidu.tbadk.editortools.y
    public void onChangeSkinType(int i) {
        aq.k(this, w.e.common_color_10255);
    }

    public void setNeedQuit(boolean z) {
        this.aAh = z;
    }
}
