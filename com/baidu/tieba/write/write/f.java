package com.baidu.tieba.write.write;

import android.content.Context;
import android.view.View;
import android.widget.ListAdapter;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.sapi2.passhost.pluginsdk.service.IEventCenterService;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.d;
import com.baidu.tieba.write.write.e;
/* loaded from: classes2.dex */
public class f {
    private TbPageContext<WriteActivity> aQq;
    private WriteImageGridView hUF;
    private e hUG;
    private WriteImagesInfo mWriteImagesInfo;
    private com.baidu.tbadk.img.b bqY = new com.baidu.tbadk.img.b();
    private String mFrom = AlbumActivityConfig.FROM_WRITE;
    private String mForumId = "";
    private e.a hUH = new e.a() { // from class: com.baidu.tieba.write.write.f.1
        @Override // com.baidu.tieba.write.write.e.a
        public void yW(int i) {
            if (f.this.mWriteImagesInfo != null && f.this.mWriteImagesInfo.getChosedFiles() != null && i >= 0 && i < f.this.mWriteImagesInfo.getChosedFiles().size()) {
                ImageFileInfo remove = f.this.mWriteImagesInfo.getChosedFiles().remove(i);
                if (remove.isTempFile()) {
                    com.baidu.adp.lib.Disk.d.ll().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                }
                f.this.hUG.a(f.this.mWriteImagesInfo);
                f.this.hUG.notifyDataSetChanged();
                if (v.G(f.this.mWriteImagesInfo.getChosedFiles()) && f.this.aQq.getOrignalPage() != 0) {
                    ((WriteActivity) f.this.aQq.getOrignalPage()).ef(false);
                }
            }
        }

        @Override // com.baidu.tieba.write.write.e.a
        public void zl(int i) {
            int F;
            if (f.this.mWriteImagesInfo != null && (F = v.F(f.this.mWriteImagesInfo.getChosedFiles())) != 0 && i >= 0 && i < F) {
                f.this.aQq.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(f.this.aQq.getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER, f.this.mWriteImagesInfo, i)));
            }
        }

        @Override // com.baidu.tieba.write.write.e.a
        public void bOH() {
            if (f.this.mWriteImagesInfo != null) {
                AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) f.this.aQq.getPageActivity(), f.this.mWriteImagesInfo.toJsonString(), true, true);
                albumActivityConfig.getIntent().putExtra("forum_id", f.this.mForumId);
                albumActivityConfig.getIntent().putExtra("from", f.this.mFrom);
                albumActivityConfig.setRequestCode(IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK);
                albumActivityConfig.setFromWrite(true);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
            }
        }
    };

    public f(TbPageContext<WriteActivity> tbPageContext, View view) {
        this.aQq = tbPageContext;
        this.hUF = (WriteImageGridView) view.findViewById(d.g.write_image_grid_view);
        this.hUG = new e(view.getContext(), this.bqY, null, this.hUH);
        this.hUF.setAdapter((ListAdapter) this.hUG);
    }

    public void a(WriteImagesInfo writeImagesInfo, String str, String str2) {
        this.mFrom = str;
        this.mForumId = str2;
        this.mWriteImagesInfo = writeImagesInfo;
        this.hUG.a(this.mWriteImagesInfo);
        this.hUG.notifyDataSetChanged();
    }

    public void destroy() {
        this.bqY.Ml();
    }

    public void ou(boolean z) {
        this.hUG.ou(z);
    }
}
