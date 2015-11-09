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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.editortools.j;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.img.effect.ImageOperation;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.i;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class a extends BaseAdapter {
    private BaseActivity doS;
    private Context mContext;
    private GridView mGridView;
    private com.baidu.tbadk.img.b apO = new com.baidu.tbadk.img.b();
    private j aoD = null;
    private int apR = 13;
    private int doQ = 6;
    private boolean doR = false;
    private LinkedList<ImageFileInfo> chosedFiles = null;
    public final String doT = "android.resource://";
    private InterfaceC0081a doU = new b(this);

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: com.baidu.tieba.write.view.PhotoLiveView.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0081a {
        void mm(int i);
    }

    public void aDg() {
        if (this.chosedFiles == null || this.chosedFiles.size() == 0) {
            aDh();
        } else if (this.chosedFiles.size() < this.doQ) {
            if (this.chosedFiles.size() <= 0 || !this.chosedFiles.get(this.chosedFiles.size() - 1).getFilePath().startsWith("android.resource://")) {
                aDh();
            }
        }
    }

    private void aDh() {
        ImageFileInfo imageFileInfo = new ImageFileInfo();
        imageFileInfo.setFilePath("android.resource://" + this.mContext.getPackageName() + "/" + i.e.btn_addpic_n);
        imageFileInfo.setTempFile(true);
        if (this.chosedFiles == null) {
            this.chosedFiles = new LinkedList<>();
        }
        this.chosedFiles.add(imageFileInfo);
        notifyDataSetChanged();
    }

    public boolean aDi() {
        if (this.chosedFiles == null || this.chosedFiles.size() == 0) {
            return false;
        }
        return this.chosedFiles.get(this.chosedFiles.size() + (-1)).getFilePath().startsWith("android.resource://");
    }

    public void aDj() {
        if (this.chosedFiles != null && this.chosedFiles.size() > 0) {
            int size = this.chosedFiles.size() - 1;
            if (this.chosedFiles.get(size).getFilePath().startsWith("android.resource://")) {
                this.chosedFiles.remove(size);
            }
        }
    }

    public a(BaseActivity baseActivity, WriteImagesInfo writeImagesInfo, GridView gridView) {
        this.mContext = null;
        this.doS = null;
        this.mGridView = null;
        this.doS = baseActivity;
        this.mContext = this.doS.getActivity();
        this.mGridView = gridView;
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
        this.aoD = jVar;
    }

    public void d(WriteImagesInfo writeImagesInfo) {
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
        aDg();
        notifyDataSetInvalidated();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        boolean z;
        com.baidu.adp.widget.a.a aVar = null;
        View inflate = LayoutInflater.from(this.mContext).inflate(i.g.photo_live_grid_item, viewGroup, false);
        ImageFileInfo imageFileInfo = (this.chosedFiles == null || this.chosedFiles.size() + (-1) < i) ? null : this.chosedFiles.get(i);
        View findViewById = inflate.findViewById(i.f.item_root_photo_live);
        FrameLayout frameLayout = (FrameLayout) findViewById.findViewById(i.f.shadow_container_photo_live);
        TbImageView tbImageView = (TbImageView) findViewById.findViewById(i.f.iv_photo_live);
        ImageView imageView = (ImageView) findViewById.findViewById(i.f.delete_photo_live);
        String filePath = imageFileInfo != null ? imageFileInfo.getFilePath() : "";
        if (this.chosedFiles != null) {
            z = i == this.chosedFiles.size() + (-1) && filePath.startsWith("android.resource://");
        } else {
            z = false;
        }
        if (z) {
            imageView.setVisibility(8);
        } else {
            an.c(imageView, i.e.icon_live_close_n);
        }
        an.i(frameLayout, i.e.btn_addpic_n);
        com.baidu.tbadk.h.a.a(this.doS.getPageContext(), frameLayout);
        frameLayout.setForeground(an.getDrawable(i.e.bg_add_photo_foregroundselector));
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(i.d.ds206);
        ImageOperation J = com.baidu.tbadk.img.effect.d.J(dimensionPixelSize, dimensionPixelSize);
        if (imageFileInfo != null) {
            imageFileInfo.clearPageActions();
            imageFileInfo.addPageAction(J);
            tbImageView.setTag(imageFileInfo.toCachedKey(true));
        }
        c cVar = new c(this, viewGroup, frameLayout);
        if (imageFileInfo != null && this.apO != null) {
            aVar = this.apO.a(imageFileInfo, cVar, true);
        }
        if (aVar != null) {
            tbImageView.invalidate();
        } else {
            tbImageView.setImageResource(i.e.btn_addpic_n);
            frameLayout.setBackgroundResource(i.e.btn_addpic_n);
            frameLayout.bringToFront();
        }
        inflate.setOnClickListener(new d(this, viewGroup, z));
        imageView.setOnClickListener(new e(this, i));
        return inflate;
    }

    public void ml(int i) {
        this.doQ = i;
    }
}
