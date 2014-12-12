package com.baidu.tieba.tbadkCore.PbEditor;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u extends BaseAdapter {
    final /* synthetic */ EditorToolComponetContainer bUi;
    private final WriteImagesInfo bUl;

    public u(EditorToolComponetContainer editorToolComponetContainer, WriteImagesInfo writeImagesInfo) {
        this.bUi = editorToolComponetContainer;
        this.bUl = writeImagesInfo;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bUl == null) {
            return 0;
        }
        return this.bUl.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.bUl.getChosedFiles().get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        int i2;
        int i3;
        com.baidu.tbadk.img.e eVar;
        FrameLayout frameLayout = view == null ? (FrameLayout) com.baidu.adp.lib.g.b.ek().inflate(this.bUi.mContext, com.baidu.tieba.x.editor_muti_image_item, null) : view;
        TbadkCoreApplication.m255getInst().getSkinType();
        ImageFileInfo imageFileInfo = this.bUl.getChosedFiles().get(i);
        int measuredWidth = viewGroup.getMeasuredWidth();
        i2 = this.bUi.bUd;
        int i4 = measuredWidth - (i2 * 2);
        i3 = this.bUi.padding;
        int i5 = i4 + i3;
        FrameLayout frameLayout2 = (FrameLayout) frameLayout;
        LinearLayout linearLayout = (LinearLayout) frameLayout2.findViewById(com.baidu.tieba.w.iv_container);
        FrameLayout frameLayout3 = (FrameLayout) frameLayout2.findViewById(com.baidu.tieba.w.shadow_container);
        TbImageView tbImageView = (TbImageView) frameLayout2.findViewById(com.baidu.tieba.w.iv);
        if (i5 > 0) {
            int paddingRight = (i5 / 3) - linearLayout.getPaddingRight();
            int measuredHeight = viewGroup.getMeasuredHeight() - linearLayout.getPaddingTop();
            com.baidu.tbadk.core.util.ax.i(frameLayout3, com.baidu.tieba.v.bg_add_photo);
            frameLayout3.setForeground(com.baidu.tbadk.core.util.ax.getDrawable(com.baidu.tieba.v.bg_add_photo_foregroundselector));
            imageFileInfo.clearPageActions();
            imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.z(paddingRight, measuredHeight));
            tbImageView.setTag(imageFileInfo.toCachedKey(true));
            eVar = this.bUi.bUh;
            if (eVar.a(imageFileInfo, new v(this, viewGroup), true) != null) {
                tbImageView.invalidate();
            }
        }
        frameLayout2.setLayoutParams(new ViewGroup.LayoutParams(i5 / 3, -1));
        frameLayout2.setOnClickListener(new w(this, viewGroup));
        ImageView imageView = (ImageView) frameLayout2.findViewById(com.baidu.tieba.w.delete);
        com.baidu.tbadk.core.util.ax.c(imageView, com.baidu.tieba.v.btn_add_photo_close_n);
        imageView.setOnClickListener(new x(this, frameLayout2));
        return frameLayout2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ib(String str) {
        new y(this, str).execute(new Void[0]);
    }
}
