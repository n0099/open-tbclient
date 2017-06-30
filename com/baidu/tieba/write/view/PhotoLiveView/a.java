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
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.editortools.j;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.img.effect.ImageOperation;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.w;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class a extends BaseAdapter {
    private GridView bYc;
    private BaseActivity mBaseActivity;
    private Context mContext;
    private com.baidu.tbadk.img.b aAR = new com.baidu.tbadk.img.b();
    private j azx = null;
    private int aAU = 13;
    private int giM = 6;
    private boolean giN = false;
    private LinkedList<ImageFileInfo> chosedFiles = null;
    private InterfaceC0089a giO = new b(this);

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: com.baidu.tieba.write.view.PhotoLiveView.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0089a {
        void tP(int i);
    }

    public void btn() {
        if (this.chosedFiles == null || this.chosedFiles.size() == 0) {
            bto();
        } else if (this.chosedFiles.size() < this.giM) {
            if (this.chosedFiles.size() <= 0 || !this.chosedFiles.get(this.chosedFiles.size() - 1).getFilePath().startsWith("android.resource://")) {
                bto();
            }
        }
    }

    private void bto() {
        ImageFileInfo imageFileInfo = new ImageFileInfo();
        imageFileInfo.setFilePath("android.resource://" + this.mContext.getPackageName() + "/" + w.g.btn_addpic_n);
        imageFileInfo.setTempFile(true);
        if (this.chosedFiles == null) {
            this.chosedFiles = new LinkedList<>();
        }
        this.chosedFiles.add(imageFileInfo);
        notifyDataSetChanged();
    }

    public boolean btp() {
        if (this.chosedFiles == null || this.chosedFiles.size() == 0) {
            return false;
        }
        return this.chosedFiles.get(this.chosedFiles.size() + (-1)).getFilePath().startsWith("android.resource://");
    }

    public void btq() {
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
        this.bYc = null;
        this.mBaseActivity = baseActivity;
        this.mContext = this.mBaseActivity.getActivity();
        this.bYc = gridView;
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

    public void setEditorTools(j jVar) {
        this.azx = jVar;
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
        btn();
        notifyDataSetInvalidated();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        boolean z;
        com.baidu.adp.widget.a.a aVar = null;
        View inflate = LayoutInflater.from(this.mContext).inflate(w.j.photo_live_grid_item, viewGroup, false);
        ImageFileInfo imageFileInfo = (this.chosedFiles == null || this.chosedFiles.size() + (-1) < i) ? null : this.chosedFiles.get(i);
        View findViewById = inflate.findViewById(w.h.item_root_photo_live);
        FrameLayout frameLayout = (FrameLayout) findViewById.findViewById(w.h.shadow_container_photo_live);
        TbImageView tbImageView = (TbImageView) findViewById.findViewById(w.h.iv_photo_live);
        ImageView imageView = (ImageView) findViewById.findViewById(w.h.delete_photo_live);
        String filePath = imageFileInfo != null ? imageFileInfo.getFilePath() : "";
        if (this.chosedFiles != null) {
            z = i == this.chosedFiles.size() + (-1) && filePath.startsWith("android.resource://");
        } else {
            z = false;
        }
        if (z) {
            imageView.setVisibility(8);
            as.c(tbImageView, w.g.btn_addpic_n);
        } else {
            as.c(imageView, w.g.icon_live_close_n);
        }
        frameLayout.setForeground(as.getDrawable(w.g.bg_add_photo_foregroundselector));
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(w.f.ds206);
        ImageOperation L = com.baidu.tbadk.img.effect.d.L(dimensionPixelSize, dimensionPixelSize);
        if (imageFileInfo != null) {
            imageFileInfo.clearPageActions();
            imageFileInfo.addPageAction(L);
            tbImageView.setTag(imageFileInfo.toCachedKey(true));
        }
        c cVar = new c(this, viewGroup);
        if (imageFileInfo != null && this.aAR != null) {
            aVar = this.aAR.a(imageFileInfo, cVar, true);
        }
        if (aVar != null) {
            tbImageView.invalidate();
        }
        inflate.setOnClickListener(new d(this, viewGroup, z));
        imageView.setOnClickListener(new e(this, i));
        return inflate;
    }

    public void tO(int i) {
        this.giM = i;
    }
}
