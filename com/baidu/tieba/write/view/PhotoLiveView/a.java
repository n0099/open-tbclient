package com.baidu.tieba.write.view.PhotoLiveView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.editortools.k;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.img.effect.ImageOperation;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class a extends BaseAdapter {
    private GridView cxr;
    private BaseActivity dke;
    private Context mContext;
    private com.baidu.tbadk.img.b auh = new com.baidu.tbadk.img.b();
    private k asQ = null;
    private int auk = 13;
    private int eqo = 6;
    private boolean eqp = false;
    private LinkedList<ImageFileInfo> chosedFiles = null;
    public final String eqq = "android.resource://";
    private InterfaceC0091a eqr = new b(this);

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: com.baidu.tieba.write.view.PhotoLiveView.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0091a {
        void pL(int i);
    }

    public void aTT() {
        if (this.chosedFiles == null || this.chosedFiles.size() == 0) {
            aTU();
        } else if (this.chosedFiles.size() < this.eqo) {
            if (this.chosedFiles.size() <= 0 || !this.chosedFiles.get(this.chosedFiles.size() - 1).getFilePath().startsWith("android.resource://")) {
                aTU();
            }
        }
    }

    private void aTU() {
        ImageFileInfo imageFileInfo = new ImageFileInfo();
        imageFileInfo.setFilePath("android.resource://" + this.mContext.getPackageName() + "/" + t.f.btn_addpic_n);
        imageFileInfo.setTempFile(true);
        if (this.chosedFiles == null) {
            this.chosedFiles = new LinkedList<>();
        }
        this.chosedFiles.add(imageFileInfo);
        notifyDataSetChanged();
    }

    public boolean aTV() {
        if (this.chosedFiles == null || this.chosedFiles.size() == 0) {
            return false;
        }
        return this.chosedFiles.get(this.chosedFiles.size() + (-1)).getFilePath().startsWith("android.resource://");
    }

    public void aTW() {
        if (this.chosedFiles != null && this.chosedFiles.size() > 0) {
            int size = this.chosedFiles.size() - 1;
            if (this.chosedFiles.get(size).getFilePath().startsWith("android.resource://")) {
                this.chosedFiles.remove(size);
            }
        }
    }

    public a(BaseActivity baseActivity, WriteImagesInfo writeImagesInfo, GridView gridView) {
        this.mContext = null;
        this.dke = null;
        this.cxr = null;
        this.dke = baseActivity;
        this.mContext = this.dke.getActivity();
        this.cxr = gridView;
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

    public void setEditorTools(k kVar) {
        this.asQ = kVar;
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
        aTT();
        notifyDataSetInvalidated();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        boolean z;
        com.baidu.adp.widget.a.a aVar = null;
        View inflate = LayoutInflater.from(this.mContext).inflate(t.h.photo_live_grid_item, viewGroup, false);
        ImageFileInfo imageFileInfo = (this.chosedFiles == null || this.chosedFiles.size() + (-1) < i) ? null : this.chosedFiles.get(i);
        View findViewById = inflate.findViewById(t.g.item_root_photo_live);
        FrameLayout frameLayout = (FrameLayout) findViewById.findViewById(t.g.shadow_container_photo_live);
        TbImageView tbImageView = (TbImageView) findViewById.findViewById(t.g.iv_photo_live);
        ImageView imageView = (ImageView) findViewById.findViewById(t.g.delete_photo_live);
        String filePath = imageFileInfo != null ? imageFileInfo.getFilePath() : "";
        if (this.chosedFiles != null) {
            z = i == this.chosedFiles.size() + (-1) && filePath.startsWith("android.resource://");
        } else {
            z = false;
        }
        if (z) {
            imageView.setVisibility(8);
            ar.c(tbImageView, t.f.btn_addpic_n);
        } else {
            ar.c(imageView, t.f.icon_live_close_n);
        }
        frameLayout.setForeground(ar.getDrawable(t.f.bg_add_photo_foregroundselector));
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(t.e.ds206);
        ImageOperation G = com.baidu.tbadk.img.effect.d.G(dimensionPixelSize, dimensionPixelSize);
        if (imageFileInfo != null) {
            imageFileInfo.clearPageActions();
            imageFileInfo.addPageAction(G);
            tbImageView.setTag(imageFileInfo.toCachedKey(true));
        }
        c cVar = new c(this, viewGroup);
        if (imageFileInfo != null && this.auh != null) {
            aVar = this.auh.a(imageFileInfo, cVar, true);
        }
        if (aVar != null) {
            tbImageView.invalidate();
        }
        inflate.setOnClickListener(new d(this, viewGroup, z));
        imageView.setOnClickListener(new e(this, i));
        return inflate;
    }

    public void pK(int i) {
        this.eqo = i;
    }
}
