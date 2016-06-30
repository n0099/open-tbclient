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
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.editortools.l;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.img.effect.ImageOperation;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.u;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class a extends BaseAdapter {
    private BaseActivity bJz;
    private GridView dxt;
    private Context mContext;
    private com.baidu.tbadk.img.b arw = new com.baidu.tbadk.img.b();
    private l apV = null;
    private int arz = 13;
    private int fGF = 6;
    private boolean fGG = false;
    private LinkedList<ImageFileInfo> chosedFiles = null;
    private InterfaceC0084a fGH = new b(this);

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: com.baidu.tieba.write.view.PhotoLiveView.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0084a {
        void sp(int i);
    }

    public void blj() {
        if (this.chosedFiles == null || this.chosedFiles.size() == 0) {
            blk();
        } else if (this.chosedFiles.size() < this.fGF) {
            if (this.chosedFiles.size() <= 0 || !this.chosedFiles.get(this.chosedFiles.size() - 1).getFilePath().startsWith("android.resource://")) {
                blk();
            }
        }
    }

    private void blk() {
        ImageFileInfo imageFileInfo = new ImageFileInfo();
        imageFileInfo.setFilePath("android.resource://" + this.mContext.getPackageName() + "/" + u.f.btn_addpic_n);
        imageFileInfo.setTempFile(true);
        if (this.chosedFiles == null) {
            this.chosedFiles = new LinkedList<>();
        }
        this.chosedFiles.add(imageFileInfo);
        notifyDataSetChanged();
    }

    public boolean bll() {
        if (this.chosedFiles == null || this.chosedFiles.size() == 0) {
            return false;
        }
        return this.chosedFiles.get(this.chosedFiles.size() + (-1)).getFilePath().startsWith("android.resource://");
    }

    public void blm() {
        if (this.chosedFiles != null && this.chosedFiles.size() > 0) {
            int size = this.chosedFiles.size() - 1;
            if (this.chosedFiles.get(size).getFilePath().startsWith("android.resource://")) {
                this.chosedFiles.remove(size);
            }
        }
    }

    public a(BaseActivity baseActivity, WriteImagesInfo writeImagesInfo, GridView gridView) {
        this.mContext = null;
        this.bJz = null;
        this.dxt = null;
        this.bJz = baseActivity;
        this.mContext = this.bJz.getActivity();
        this.dxt = gridView;
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

    public void setEditorTools(l lVar) {
        this.apV = lVar;
    }

    public void f(WriteImagesInfo writeImagesInfo) {
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
        blj();
        notifyDataSetInvalidated();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        boolean z;
        com.baidu.adp.widget.a.a aVar = null;
        View inflate = LayoutInflater.from(this.mContext).inflate(u.h.photo_live_grid_item, viewGroup, false);
        ImageFileInfo imageFileInfo = (this.chosedFiles == null || this.chosedFiles.size() + (-1) < i) ? null : this.chosedFiles.get(i);
        View findViewById = inflate.findViewById(u.g.item_root_photo_live);
        FrameLayout frameLayout = (FrameLayout) findViewById.findViewById(u.g.shadow_container_photo_live);
        TbImageView tbImageView = (TbImageView) findViewById.findViewById(u.g.iv_photo_live);
        ImageView imageView = (ImageView) findViewById.findViewById(u.g.delete_photo_live);
        String filePath = imageFileInfo != null ? imageFileInfo.getFilePath() : "";
        if (this.chosedFiles != null) {
            z = i == this.chosedFiles.size() + (-1) && filePath.startsWith("android.resource://");
        } else {
            z = false;
        }
        if (z) {
            imageView.setVisibility(8);
            av.c(tbImageView, u.f.btn_addpic_n);
        } else {
            av.c(imageView, u.f.icon_live_close_n);
        }
        frameLayout.setForeground(av.getDrawable(u.f.bg_add_photo_foregroundselector));
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(u.e.ds206);
        ImageOperation D = com.baidu.tbadk.img.effect.d.D(dimensionPixelSize, dimensionPixelSize);
        if (imageFileInfo != null) {
            imageFileInfo.clearPageActions();
            imageFileInfo.addPageAction(D);
            tbImageView.setTag(imageFileInfo.toCachedKey(true));
        }
        c cVar = new c(this, viewGroup);
        if (imageFileInfo != null && this.arw != null) {
            aVar = this.arw.a(imageFileInfo, cVar, true);
        }
        if (aVar != null) {
            tbImageView.invalidate();
        }
        inflate.setOnClickListener(new d(this, viewGroup, z));
        imageView.setOnClickListener(new e(this, i));
        return inflate;
    }

    public void so(int i) {
        this.fGF = i;
    }
}
