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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.img.b;
import com.baidu.tbadk.img.effect.ImageOperation;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.write.write.WriteActivity;
import java.io.File;
import java.util.LinkedList;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    private GridView cBt;
    private Context mContext;
    private BaseActivity nby;
    private b eOh = new b();
    private EditorTools eMH = null;
    private int eOk = 13;
    private int ncs = 6;
    private boolean nct = false;
    private LinkedList<ImageFileInfo> chosedFiles = null;
    private InterfaceC0835a ncu = new InterfaceC0835a() { // from class: com.baidu.tieba.write.view.PhotoLiveView.a.1
        @Override // com.baidu.tieba.write.view.PhotoLiveView.a.InterfaceC0835a
        public void Kn(int i) {
            if (a.this.chosedFiles != null) {
                if (a.this.chosedFiles.size() - 1 >= i) {
                    ImageFileInfo imageFileInfo = (ImageFileInfo) a.this.chosedFiles.remove(i);
                    if (imageFileInfo.isTempFile()) {
                        d.lK().c(new DiskFileOperate(imageFileInfo.getFilePath(), null, DiskFileOperate.Action.DELETE));
                    }
                }
                int size = a.this.chosedFiles.size();
                if (a.this.eMH != null) {
                    a.this.eMH.b(new com.baidu.tbadk.editortools.a(a.this.eOk, -1, null));
                    if (size > 0) {
                        a.this.eMH.b(new com.baidu.tbadk.editortools.a(2, 10, String.valueOf(size)));
                    } else {
                        a.this.eMH.b(new com.baidu.tbadk.editortools.a(2, 10, null));
                    }
                    if (a.this.chosedFiles.size() == 1 && size == 0) {
                        a.this.eMH.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                    }
                }
                a.this.dLg();
                ((WriteActivity) a.this.nby).q(a.this.chosedFiles);
                a.this.dLd();
                a.this.notifyDataSetChanged();
                a.this.cBt.invalidateViews();
            }
        }
    };

    /* renamed from: com.baidu.tieba.write.view.PhotoLiveView.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    protected interface InterfaceC0835a {
        void Kn(int i);
    }

    public void dLd() {
        if (this.chosedFiles == null || this.chosedFiles.size() == 0) {
            dLe();
        } else if (this.chosedFiles.size() < this.ncs) {
            if (this.chosedFiles.size() <= 0 || !this.chosedFiles.get(this.chosedFiles.size() - 1).getFilePath().startsWith("android.resource://")) {
                dLe();
            }
        }
    }

    private void dLe() {
        ImageFileInfo imageFileInfo = new ImageFileInfo();
        imageFileInfo.setFilePath("android.resource://" + this.mContext.getPackageName() + "/" + R.drawable.btn_addpic_n);
        imageFileInfo.setTempFile(true);
        if (this.chosedFiles == null) {
            this.chosedFiles = new LinkedList<>();
        }
        this.chosedFiles.add(imageFileInfo);
        notifyDataSetChanged();
    }

    public boolean dLf() {
        if (this.chosedFiles == null || this.chosedFiles.size() == 0) {
            return false;
        }
        return this.chosedFiles.get(this.chosedFiles.size() + (-1)).getFilePath().startsWith("android.resource://");
    }

    public void dLg() {
        if (this.chosedFiles != null && this.chosedFiles.size() > 0) {
            int size = this.chosedFiles.size() - 1;
            if (this.chosedFiles.get(size).getFilePath().startsWith("android.resource://")) {
                this.chosedFiles.remove(size);
            }
        }
    }

    public a(BaseActivity baseActivity, WriteImagesInfo writeImagesInfo, GridView gridView) {
        this.mContext = null;
        this.nby = null;
        this.cBt = null;
        this.nby = baseActivity;
        this.mContext = this.nby.getActivity();
        this.cBt = gridView;
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
        this.eMH = editorTools;
    }

    public void b(WriteImagesInfo writeImagesInfo) {
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
        dLd();
        notifyDataSetInvalidated();
    }

    @Override // android.widget.Adapter
    public View getView(final int i, View view, final ViewGroup viewGroup) {
        final boolean z;
        com.baidu.adp.widget.ImageView.a aVar = null;
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.photo_live_grid_item, viewGroup, false);
        ImageFileInfo imageFileInfo = (this.chosedFiles == null || this.chosedFiles.size() + (-1) < i) ? null : this.chosedFiles.get(i);
        View findViewById = inflate.findViewById(R.id.item_root_photo_live);
        FrameLayout frameLayout = (FrameLayout) findViewById.findViewById(R.id.shadow_container_photo_live);
        TbImageView tbImageView = (TbImageView) findViewById.findViewById(R.id.iv_photo_live);
        ImageView imageView = (ImageView) findViewById.findViewById(R.id.delete_photo_live);
        String filePath = imageFileInfo != null ? imageFileInfo.getFilePath() : "";
        if (this.chosedFiles != null) {
            z = i == this.chosedFiles.size() + (-1) && filePath.startsWith("android.resource://");
        } else {
            z = false;
        }
        if (z) {
            imageView.setVisibility(8);
            ap.setImageResource(tbImageView, R.drawable.btn_addpic_n);
        } else {
            ap.setImageResource(imageView, R.drawable.icon_live_close_n);
        }
        frameLayout.setForeground(ap.getDrawable(R.drawable.bg_add_photo_foregroundselector));
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds206);
        ImageOperation bg = com.baidu.tbadk.img.effect.d.bg(dimensionPixelSize, dimensionPixelSize);
        if (imageFileInfo != null) {
            imageFileInfo.clearPageActions();
            imageFileInfo.addPageAction(bg);
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
        if (imageFileInfo != null && this.eOh != null) {
            aVar = this.eOh.a(imageFileInfo, bVar, true);
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
                    if (z && (a.this.nby instanceof WriteActivity)) {
                        if (a.this.chosedFiles != null && a.this.chosedFiles.size() > 0) {
                            a.this.chosedFiles.remove(a.this.chosedFiles.size() - 1);
                        }
                        ((WriteActivity) a.this.nby).q(a.this.chosedFiles);
                        ((WriteActivity) a.this.nby).e((com.baidu.tbadk.editortools.a) null);
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
                        l.showLongToast(a.this.mContext, R.string.editor_mutiiamge_image_error);
                    } else if (a.this.eMH != null) {
                        if (a.this.dLf()) {
                            a.this.dLg();
                        }
                        ((WriteActivity) a.this.nby).q(a.this.chosedFiles);
                        a.this.eMH.b(new com.baidu.tbadk.editortools.a(15, 0, Integer.valueOf(indexOfChild)));
                    }
                }
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.view.PhotoLiveView.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.ncu != null) {
                    a.this.ncu.Kn(i);
                }
            }
        });
        return inflate;
    }

    public void Km(int i) {
        this.ncs = i;
    }
}
