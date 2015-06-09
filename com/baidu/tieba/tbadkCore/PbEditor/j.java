package com.baidu.tieba.tbadkCore.PbEditor;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends BaseAdapter {
    final /* synthetic */ EditorToolComponetContainer cqE;
    private final WriteImagesInfo cqH;

    public j(EditorToolComponetContainer editorToolComponetContainer, WriteImagesInfo writeImagesInfo) {
        this.cqE = editorToolComponetContainer;
        this.cqH = writeImagesInfo;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.cqH == null) {
            return 0;
        }
        return this.cqH.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.cqH.getChosedFiles().get(i);
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
        FrameLayout frameLayout = view == null ? (FrameLayout) com.baidu.adp.lib.g.b.hr().inflate(this.cqE.mContext, com.baidu.tieba.r.editor_muti_image_item, null) : view;
        TbadkCoreApplication.m411getInst().getSkinType();
        ImageFileInfo imageFileInfo = this.cqH.getChosedFiles().get(i);
        int measuredWidth = viewGroup.getMeasuredWidth();
        i2 = this.cqE.cqz;
        int i4 = measuredWidth - (i2 * 2);
        i3 = this.cqE.padding;
        int i5 = i4 + i3;
        FrameLayout frameLayout2 = (FrameLayout) frameLayout;
        LinearLayout linearLayout = (LinearLayout) frameLayout2.findViewById(com.baidu.tieba.q.iv_container);
        FrameLayout frameLayout3 = (FrameLayout) frameLayout2.findViewById(com.baidu.tieba.q.shadow_container);
        TbImageView tbImageView = (TbImageView) frameLayout2.findViewById(com.baidu.tieba.q.iv);
        if (i5 > 0) {
            int paddingRight = (i5 / 3) - linearLayout.getPaddingRight();
            int measuredHeight = viewGroup.getMeasuredHeight() - linearLayout.getPaddingTop();
            ay.i(frameLayout3, com.baidu.tieba.p.bg_add_photo);
            frameLayout3.setForeground(ay.getDrawable(com.baidu.tieba.p.bg_add_photo_foregroundselector));
            imageFileInfo.clearPageActions();
            imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.y(paddingRight, measuredHeight));
            tbImageView.setTag(imageFileInfo.toCachedKey(true));
            eVar = this.cqE.cqD;
            if (eVar.a(imageFileInfo, new k(this, viewGroup), true) != null) {
                tbImageView.invalidate();
            }
        }
        frameLayout2.setLayoutParams(new ViewGroup.LayoutParams(i5 / 3, -1));
        frameLayout2.setOnClickListener(new l(this, viewGroup));
        ImageView imageView = (ImageView) frameLayout2.findViewById(com.baidu.tieba.q.delete);
        ay.c(imageView, com.baidu.tieba.p.btn_add_photo_close);
        imageView.setOnClickListener(new m(this, frameLayout2));
        return frameLayout2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jy(String str) {
        new n(this, str).execute(new Void[0]);
    }
}
