package com.baidu.tieba.write.write;

import android.content.Context;
import android.view.View;
import android.widget.ListAdapter;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.write.write.f;
/* loaded from: classes2.dex */
public class g {
    private TbPageContext<WriteActivity> dIF;
    private WriteImageGridView lZi;
    public f lZj;
    private WriteImagesInfo mWriteImagesInfo;
    private com.baidu.tbadk.img.b emd = new com.baidu.tbadk.img.b();
    private String mFrom = "write";
    private String mForumId = "";
    private f.a lZk = new f.a() { // from class: com.baidu.tieba.write.write.g.1
        @Override // com.baidu.tieba.write.write.f.a
        public void FJ(int i) {
            if (g.this.mWriteImagesInfo != null && g.this.mWriteImagesInfo.getChosedFiles() != null && i >= 0 && i < g.this.mWriteImagesInfo.getChosedFiles().size()) {
                ImageFileInfo remove = g.this.mWriteImagesInfo.getChosedFiles().remove(i);
                if (remove.isTempFile()) {
                    com.baidu.adp.lib.Disk.d.jR().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                }
                g.this.lZj.a(g.this.mWriteImagesInfo);
                g.this.lZj.notifyDataSetChanged();
                if (v.isEmpty(g.this.mWriteImagesInfo.getChosedFiles()) && g.this.dIF.getOrignalPage() != 0) {
                    ((WriteActivity) g.this.dIF.getOrignalPage()).cZW();
                }
            }
        }

        @Override // com.baidu.tieba.write.write.f.a
        public void FQ(int i) {
            int count;
            ImageFileInfo imageInfoAt;
            if (g.this.mWriteImagesInfo != null && (count = v.getCount(g.this.mWriteImagesInfo.getChosedFiles())) != 0 && i >= 0 && i < count && (imageInfoAt = g.this.mWriteImagesInfo.getImageInfoAt(i)) != null && imageInfoAt.getImageType() != 1) {
                g.this.dIF.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(g.this.dIF.getPageActivity(), RequestResponseCode.REQUEST_MOTU_IMAGE, g.this.mWriteImagesInfo, i)));
            }
        }

        @Override // com.baidu.tieba.write.write.f.a
        public void dpb() {
            if (g.this.mWriteImagesInfo != null) {
                AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) g.this.dIF.getPageActivity(), g.this.mWriteImagesInfo.toJsonString(), true, true);
                albumActivityConfig.getIntent().putExtra("forum_id", g.this.mForumId);
                albumActivityConfig.getIntent().putExtra("from", g.this.mFrom);
                albumActivityConfig.setRequestCode(RequestResponseCode.REQUEST_ALBUM_IMAGE);
                albumActivityConfig.setFromWrite(true);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
            }
        }
    };

    public g(TbPageContext<WriteActivity> tbPageContext, View view) {
        this.dIF = tbPageContext;
        this.lZi = (WriteImageGridView) view.findViewById(R.id.write_image_grid_view);
        this.lZj = new f(view.getContext(), this.emd, null, this.lZk);
        this.lZi.setAdapter((ListAdapter) this.lZj);
    }

    public void a(WriteImagesInfo writeImagesInfo, String str, String str2) {
        this.mFrom = str;
        this.mForumId = str2;
        this.mWriteImagesInfo = writeImagesInfo;
        this.lZj.a(this.mWriteImagesInfo);
        this.lZj.notifyDataSetChanged();
    }

    public void destroy() {
        this.emd.cancelAllAsyncTask();
    }

    public void vr(boolean z) {
        this.lZj.vr(z);
    }
}
