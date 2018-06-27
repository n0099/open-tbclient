package com.baidu.tieba.write.view.PhotoLiveView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import com.baidu.adp.lib.Disk.d;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.img.b;
import com.baidu.tbadk.img.effect.ImageOperation;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.write.write.WriteActivity;
import java.io.File;
import java.util.LinkedList;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    private GridView cWR;
    private BaseActivity mBaseActivity;
    private Context mContext;
    private b aNm = new b();
    private EditorTools aLT = null;
    private int aNp = 13;
    private int hwm = 6;
    private boolean hwn = false;
    private LinkedList<ImageFileInfo> chosedFiles = null;
    private InterfaceC0258a hwo = new InterfaceC0258a() { // from class: com.baidu.tieba.write.view.PhotoLiveView.a.1
        @Override // com.baidu.tieba.write.view.PhotoLiveView.a.InterfaceC0258a
        public void vD(int i) {
            if (a.this.chosedFiles != null) {
                if (a.this.chosedFiles.size() - 1 >= i) {
                    ImageFileInfo imageFileInfo = (ImageFileInfo) a.this.chosedFiles.remove(i);
                    if (imageFileInfo.isTempFile()) {
                        d.gf().c(new DiskFileOperate(imageFileInfo.getFilePath(), null, DiskFileOperate.Action.DELETE));
                    }
                }
                int size = a.this.chosedFiles.size();
                if (a.this.aLT != null) {
                    a.this.aLT.b(new com.baidu.tbadk.editortools.a(a.this.aNp, -1, null));
                    if (size > 0) {
                        a.this.aLT.b(new com.baidu.tbadk.editortools.a(2, 10, String.valueOf(size)));
                    } else {
                        a.this.aLT.b(new com.baidu.tbadk.editortools.a(2, 10, null));
                    }
                    if (a.this.chosedFiles.size() == 1 && size == 0) {
                        a.this.aLT.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                    }
                }
                a.this.bIn();
                ((WriteActivity) a.this.mBaseActivity).t(a.this.chosedFiles);
                a.this.bIk();
                a.this.notifyDataSetChanged();
                a.this.cWR.invalidateViews();
            }
        }
    };

    /* renamed from: com.baidu.tieba.write.view.PhotoLiveView.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    protected interface InterfaceC0258a {
        void vD(int i);
    }

    public void bIk() {
        if (this.chosedFiles == null || this.chosedFiles.size() == 0) {
            bIl();
        } else if (this.chosedFiles.size() < this.hwm) {
            if (this.chosedFiles.size() <= 0 || !this.chosedFiles.get(this.chosedFiles.size() - 1).getFilePath().startsWith("android.resource://")) {
                bIl();
            }
        }
    }

    private void bIl() {
        ImageFileInfo imageFileInfo = new ImageFileInfo();
        imageFileInfo.setFilePath("android.resource://" + this.mContext.getPackageName() + "/" + d.f.btn_addpic_n);
        imageFileInfo.setTempFile(true);
        if (this.chosedFiles == null) {
            this.chosedFiles = new LinkedList<>();
        }
        this.chosedFiles.add(imageFileInfo);
        notifyDataSetChanged();
    }

    public boolean bIm() {
        if (this.chosedFiles == null || this.chosedFiles.size() == 0) {
            return false;
        }
        return this.chosedFiles.get(this.chosedFiles.size() + (-1)).getFilePath().startsWith("android.resource://");
    }

    public void bIn() {
        if (this.chosedFiles != null && this.chosedFiles.size() > 0) {
            int size = this.chosedFiles.size() - 1;
            if (this.chosedFiles.get(size).getFilePath().startsWith("android.resource://")) {
                this.chosedFiles.remove(size);
            }
        }
    }

    public a(BaseActivity baseActivity, WriteImagesInfo writeImagesInfo, GridView gridView) {
        this.mContext = null;
        this.mBaseActivity = null;
        this.cWR = null;
        this.mBaseActivity = baseActivity;
        this.mContext = this.mBaseActivity.getActivity();
        this.cWR = gridView;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.chosedFiles == null) {
            return 0;
        }
        return this.chosedFiles.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.chosedFiles == null) {
            return null;
        }
        if (this.chosedFiles.size() - 1 >= i) {
            return this.chosedFiles.get(i);
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public void setEditorTools(EditorTools editorTools) {
        this.aLT = editorTools;
    }

    public void c(WriteImagesInfo writeImagesInfo) {
        if (writeImagesInfo == null) {
            writeImagesInfo = new WriteImagesInfo();
        }
        if (this.chosedFiles == null) {
            this.chosedFiles = new LinkedList<>();
        }
        this.chosedFiles.clear();
        if (writeImagesInfo.getChosedFiles() != null && writeImagesInfo.size() > 0) {
            this.chosedFiles.addAll(writeImagesInfo.getChosedFiles());
        }
        bIk();
        notifyDataSetInvalidated();
    }

    @Override // android.widget.Adapter
    public View getView(final int i, View view, final ViewGroup viewGroup) {
        final boolean z;
        com.baidu.adp.widget.ImageView.a aVar = null;
        View inflate = LayoutInflater.from(this.mContext).inflate(d.i.photo_live_grid_item, viewGroup, false);
        ImageFileInfo imageFileInfo = (this.chosedFiles == null || this.chosedFiles.size() + (-1) < i) ? null : this.chosedFiles.get(i);
        View findViewById = inflate.findViewById(d.g.item_root_photo_live);
        FrameLayout frameLayout = (FrameLayout) findViewById.findViewById(d.g.shadow_container_photo_live);
        TbImageView tbImageView = (TbImageView) findViewById.findViewById(d.g.iv_photo_live);
        ImageView imageView = (ImageView) findViewById.findViewById(d.g.delete_photo_live);
        String filePath = imageFileInfo != null ? imageFileInfo.getFilePath() : "";
        if (this.chosedFiles != null) {
            z = i == this.chosedFiles.size() + (-1) && filePath.startsWith("android.resource://");
        } else {
            z = false;
        }
        if (z) {
            imageView.setVisibility(8);
            am.c(tbImageView, d.f.btn_addpic_n);
        } else {
            am.c(imageView, d.f.icon_live_close_n);
        }
        frameLayout.setForeground(am.getDrawable(d.f.bg_add_photo_foregroundselector));
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(d.e.ds206);
        ImageOperation H = com.baidu.tbadk.img.effect.d.H(dimensionPixelSize, dimensionPixelSize);
        if (imageFileInfo != null) {
            imageFileInfo.clearPageActions();
            imageFileInfo.addPageAction(H);
            tbImageView.setTag(imageFileInfo.toCachedKey(true));
        }
        com.baidu.tbadk.imageManager.b bVar = new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.write.view.PhotoLiveView.a.2
            @Override // com.baidu.tbadk.imageManager.b
            public void a(com.baidu.adp.widget.ImageView.a aVar2, String str, boolean z2) {
                TbImageView tbImageView2;
                if (viewGroup != null && (tbImageView2 = (TbImageView) viewGroup.findViewWithTag(str)) != null && aVar2 != null) {
                    tbImageView2.invalidate();
                }
            }
        };
        if (imageFileInfo != null && this.aNm != null) {
            aVar = this.aNm.a(imageFileInfo, bVar, true);
        }
        if (aVar != null) {
            tbImageView.invalidate();
        }
        inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.view.PhotoLiveView.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                boolean z2;
                int indexOfChild = viewGroup.indexOfChild(view2);
                if (indexOfChild >= 0) {
                    if (z && (a.this.mBaseActivity instanceof WriteActivity)) {
                        if (a.this.chosedFiles != null && a.this.chosedFiles.size() > 0) {
                            a.this.chosedFiles.remove(a.this.chosedFiles.size() - 1);
                        }
                        ((WriteActivity) a.this.mBaseActivity).t(a.this.chosedFiles);
                        ((WriteActivity) a.this.mBaseActivity).e((com.baidu.tbadk.editortools.a) null);
                        return;
                    }
                    ImageFileInfo imageFileInfo2 = (ImageFileInfo) a.this.getItem(indexOfChild);
                    if (imageFileInfo2 == null) {
                        z2 = false;
                    } else {
                        File file = new File(imageFileInfo2.getFilePath());
                        z2 = file.exists() && file.length() != 0;
                    }
                    if (!z2) {
                        l.showLongToast(a.this.mContext, d.k.editor_mutiiamge_image_error);
                    } else if (a.this.aLT != null) {
                        if (a.this.bIm()) {
                            a.this.bIn();
                        }
                        ((WriteActivity) a.this.mBaseActivity).t(a.this.chosedFiles);
                        a.this.aLT.b(new com.baidu.tbadk.editortools.a(15, 0, Integer.valueOf(indexOfChild)));
                    }
                }
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.view.PhotoLiveView.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.hwo != null) {
                    a.this.hwo.vD(i);
                }
            }
        });
        return inflate;
    }

    public void vC(int i) {
        this.hwm = i;
    }
}
