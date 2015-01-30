package com.baidu.tieba.tbadkCore.PbEditor;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u extends BaseAdapter {
    final /* synthetic */ EditorToolComponetContainer bWa;
    private final WriteImagesInfo bWd;

    public u(EditorToolComponetContainer editorToolComponetContainer, WriteImagesInfo writeImagesInfo) {
        this.bWa = editorToolComponetContainer;
        this.bWd = writeImagesInfo;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bWd == null) {
            return 0;
        }
        return this.bWd.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.bWd.getChosedFiles().get(i);
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
        FrameLayout frameLayout = view == null ? (FrameLayout) com.baidu.adp.lib.g.b.ei().inflate(this.bWa.mContext, com.baidu.tieba.x.editor_muti_image_item, null) : view;
        TbadkCoreApplication.m255getInst().getSkinType();
        ImageFileInfo imageFileInfo = this.bWd.getChosedFiles().get(i);
        int measuredWidth = viewGroup.getMeasuredWidth();
        i2 = this.bWa.bVV;
        int i4 = measuredWidth - (i2 * 2);
        i3 = this.bWa.padding;
        int i5 = i4 + i3;
        FrameLayout frameLayout2 = (FrameLayout) frameLayout;
        LinearLayout linearLayout = (LinearLayout) frameLayout2.findViewById(com.baidu.tieba.w.iv_container);
        FrameLayout frameLayout3 = (FrameLayout) frameLayout2.findViewById(com.baidu.tieba.w.shadow_container);
        TbImageView tbImageView = (TbImageView) frameLayout2.findViewById(com.baidu.tieba.w.iv);
        if (i5 > 0) {
            int paddingRight = (i5 / 3) - linearLayout.getPaddingRight();
            int measuredHeight = viewGroup.getMeasuredHeight() - linearLayout.getPaddingTop();
            bc.i(frameLayout3, com.baidu.tieba.v.bg_add_photo);
            frameLayout3.setForeground(bc.getDrawable(com.baidu.tieba.v.bg_add_photo_foregroundselector));
            imageFileInfo.clearPageActions();
            imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.z(paddingRight, measuredHeight));
            tbImageView.setTag(imageFileInfo.toCachedKey(true));
            eVar = this.bWa.bVZ;
            if (eVar.a(imageFileInfo, new v(this, viewGroup), true) != null) {
                tbImageView.invalidate();
            }
        }
        frameLayout2.setLayoutParams(new ViewGroup.LayoutParams(i5 / 3, -1));
        frameLayout2.setOnClickListener(new w(this, viewGroup));
        ImageView imageView = (ImageView) frameLayout2.findViewById(com.baidu.tieba.w.delete);
        bc.c(imageView, com.baidu.tieba.v.btn_add_photo_close_n);
        imageView.setOnClickListener(new x(this, frameLayout2));
        return frameLayout2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ij(String str) {
        new y(this, str).execute(new Void[0]);
    }
}
