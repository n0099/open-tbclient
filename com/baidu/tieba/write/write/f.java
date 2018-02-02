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
    private TbPageContext<WriteActivity> aQs;
    private WriteImageGridView hKJ;
    private e hKK;
    private WriteImagesInfo mWriteImagesInfo;
    private com.baidu.tbadk.img.b brq = new com.baidu.tbadk.img.b();
    private String mFrom = AlbumActivityConfig.FROM_WRITE;
    private String mForumId = "";
    private e.a hKL = new e.a() { // from class: com.baidu.tieba.write.write.f.1
        @Override // com.baidu.tieba.write.write.e.a
        public void xz(int i) {
            if (f.this.mWriteImagesInfo != null && f.this.mWriteImagesInfo.getChosedFiles() != null && i >= 0 && i < f.this.mWriteImagesInfo.getChosedFiles().size()) {
                ImageFileInfo remove = f.this.mWriteImagesInfo.getChosedFiles().remove(i);
                if (remove.isTempFile()) {
                    com.baidu.adp.lib.Disk.d.ll().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                }
                f.this.hKK.a(f.this.mWriteImagesInfo);
                f.this.hKK.notifyDataSetChanged();
                if (v.E(f.this.mWriteImagesInfo.getChosedFiles()) && f.this.aQs.getOrignalPage() != 0) {
                    ((WriteActivity) f.this.aQs.getOrignalPage()).eg(false);
                }
            }
        }

        @Override // com.baidu.tieba.write.write.e.a
        public void xO(int i) {
            int D;
            if (f.this.mWriteImagesInfo != null && (D = v.D(f.this.mWriteImagesInfo.getChosedFiles())) != 0 && i >= 0 && i < D) {
                f.this.aQs.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(f.this.aQs.getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER, f.this.mWriteImagesInfo, i)));
            }
        }

        @Override // com.baidu.tieba.write.write.e.a
        public void bIm() {
            if (f.this.mWriteImagesInfo != null) {
                AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) f.this.aQs.getPageActivity(), f.this.mWriteImagesInfo.toJsonString(), true, true);
                albumActivityConfig.getIntent().putExtra("forum_id", f.this.mForumId);
                albumActivityConfig.getIntent().putExtra("from", f.this.mFrom);
                albumActivityConfig.setRequestCode(IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK);
                albumActivityConfig.setFromWrite(true);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
            }
        }
    };

    public f(TbPageContext<WriteActivity> tbPageContext, View view) {
        this.aQs = tbPageContext;
        this.hKJ = (WriteImageGridView) view.findViewById(d.g.write_image_grid_view);
        this.hKK = new e(view.getContext(), this.brq, null, this.hKL);
        this.hKJ.setAdapter((ListAdapter) this.hKK);
    }

    public void a(WriteImagesInfo writeImagesInfo, String str, String str2) {
        this.mFrom = str;
        this.mForumId = str2;
        this.mWriteImagesInfo = writeImagesInfo;
        this.hKK.a(this.mWriteImagesInfo);
        this.hKK.notifyDataSetChanged();
    }

    public void destroy() {
        this.brq.Mb();
    }

    public void nA(boolean z) {
        this.hKK.nA(z);
    }
}
