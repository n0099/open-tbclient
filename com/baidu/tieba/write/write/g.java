package com.baidu.tieba.write.write;

import android.content.Context;
import android.view.View;
import android.widget.ListAdapter;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.write.write.f;
/* loaded from: classes3.dex */
public class g {
    private WriteImageGridView jXR;
    public f jXS;
    private TbPageContext<WriteActivity> mContext;
    private WriteImagesInfo mWriteImagesInfo;
    private com.baidu.tbadk.img.b cue = new com.baidu.tbadk.img.b();
    private String mFrom = AlbumActivityConfig.FROM_WRITE;
    private String mForumId = "";
    private f.a jXT = new f.a() { // from class: com.baidu.tieba.write.write.g.1
        @Override // com.baidu.tieba.write.write.f.a
        public void Dm(int i) {
            if (g.this.mWriteImagesInfo != null && g.this.mWriteImagesInfo.getChosedFiles() != null && i >= 0 && i < g.this.mWriteImagesInfo.getChosedFiles().size()) {
                ImageFileInfo remove = g.this.mWriteImagesInfo.getChosedFiles().remove(i);
                if (remove.isTempFile()) {
                    com.baidu.adp.lib.Disk.d.gC().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                }
                g.this.jXS.a(g.this.mWriteImagesInfo);
                g.this.jXS.notifyDataSetChanged();
                if (v.aa(g.this.mWriteImagesInfo.getChosedFiles()) && g.this.mContext.getOrignalPage() != 0) {
                    ((WriteActivity) g.this.mContext.getOrignalPage()).cnt();
                }
            }
        }

        @Override // com.baidu.tieba.write.write.f.a
        public void Dt(int i) {
            int Z;
            ImageFileInfo imageInfoAt;
            if (g.this.mWriteImagesInfo != null && (Z = v.Z(g.this.mWriteImagesInfo.getChosedFiles())) != 0 && i >= 0 && i < Z && (imageInfoAt = g.this.mWriteImagesInfo.getImageInfoAt(i)) != null && imageInfoAt.getImageType() != 1) {
                g.this.mContext.sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(g.this.mContext.getPageActivity(), 12012, g.this.mWriteImagesInfo, i)));
            }
        }

        @Override // com.baidu.tieba.write.write.f.a
        public void cDB() {
            if (g.this.mWriteImagesInfo != null) {
                AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) g.this.mContext.getPageActivity(), g.this.mWriteImagesInfo.toJsonString(), true, true);
                albumActivityConfig.getIntent().putExtra("forum_id", g.this.mForumId);
                albumActivityConfig.getIntent().putExtra("from", g.this.mFrom);
                albumActivityConfig.setRequestCode(12002);
                albumActivityConfig.setFromWrite(true);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
            }
        }
    };

    public g(TbPageContext<WriteActivity> tbPageContext, View view) {
        this.mContext = tbPageContext;
        this.jXR = (WriteImageGridView) view.findViewById(R.id.write_image_grid_view);
        this.jXS = new f(view.getContext(), this.cue, null, this.jXT);
        this.jXR.setAdapter((ListAdapter) this.jXS);
    }

    public void a(WriteImagesInfo writeImagesInfo, String str, String str2) {
        this.mFrom = str;
        this.mForumId = str2;
        this.mWriteImagesInfo = writeImagesInfo;
        this.jXS.a(this.mWriteImagesInfo);
        this.jXS.notifyDataSetChanged();
    }

    public void destroy() {
        this.cue.atU();
    }

    public void sl(boolean z) {
        this.jXS.sl(z);
    }
}
