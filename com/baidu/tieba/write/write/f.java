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
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.d;
import com.baidu.tieba.write.write.e;
/* loaded from: classes2.dex */
public class f {
    private TbPageContext<WriteActivity> aRI;
    private WriteImageGridView hMs;
    private e hMt;
    private WriteImagesInfo mWriteImagesInfo;
    private com.baidu.tbadk.img.b btu = new com.baidu.tbadk.img.b();
    private String mFrom = AlbumActivityConfig.FROM_WRITE;
    private String mForumId = "";
    private e.a hMu = new e.a() { // from class: com.baidu.tieba.write.write.f.1
        @Override // com.baidu.tieba.write.write.e.a
        public void xz(int i) {
            if (f.this.mWriteImagesInfo != null && f.this.mWriteImagesInfo.getChosedFiles() != null && i >= 0 && i < f.this.mWriteImagesInfo.getChosedFiles().size()) {
                ImageFileInfo remove = f.this.mWriteImagesInfo.getChosedFiles().remove(i);
                if (remove.isTempFile()) {
                    com.baidu.adp.lib.Disk.d.ll().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                }
                f.this.hMt.a(f.this.mWriteImagesInfo);
                f.this.hMt.notifyDataSetChanged();
                if (v.E(f.this.mWriteImagesInfo.getChosedFiles()) && f.this.aRI.getOrignalPage() != 0) {
                    ((WriteActivity) f.this.aRI.getOrignalPage()).nW(false);
                }
            }
        }

        @Override // com.baidu.tieba.write.write.e.a
        public void xO(int i) {
            int D;
            if (f.this.mWriteImagesInfo != null && (D = v.D(f.this.mWriteImagesInfo.getChosedFiles())) != 0 && i >= 0 && i < D) {
                f.this.aRI.sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(f.this.aRI.getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER, f.this.mWriteImagesInfo, i)));
            }
        }

        @Override // com.baidu.tieba.write.write.e.a
        public void bJe() {
            if (f.this.mWriteImagesInfo != null) {
                AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) f.this.aRI.getPageActivity(), f.this.mWriteImagesInfo.toJsonString(), true, true);
                albumActivityConfig.getIntent().putExtra("forum_id", f.this.mForumId);
                albumActivityConfig.getIntent().putExtra("from", f.this.mFrom);
                albumActivityConfig.setRequestCode(IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK);
                albumActivityConfig.setFromWrite(true);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
            }
        }
    };

    public f(TbPageContext<WriteActivity> tbPageContext, View view) {
        this.aRI = tbPageContext;
        this.hMs = (WriteImageGridView) view.findViewById(d.g.write_image_grid_view);
        this.hMt = new e(view.getContext(), this.btu, null, this.hMu);
        this.hMs.setAdapter((ListAdapter) this.hMt);
    }

    public void a(WriteImagesInfo writeImagesInfo, String str, String str2) {
        this.mFrom = str;
        this.mForumId = str2;
        this.mWriteImagesInfo = writeImagesInfo;
        this.hMt.a(this.mWriteImagesInfo);
        this.hMt.notifyDataSetChanged();
    }

    public void destroy() {
        this.btu.MH();
    }

    public void nM(boolean z) {
        this.hMt.nM(z);
    }
}
