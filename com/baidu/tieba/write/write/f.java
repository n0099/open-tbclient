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
    private TbPageContext<WriteActivity> aca;
    private e hmA;
    private WriteImageGridView hmz;
    private WriteImagesInfo mWriteImagesInfo;
    private com.baidu.tbadk.img.b aDd = new com.baidu.tbadk.img.b();
    private String mFrom = AlbumActivityConfig.FROM_WRITE;
    private String mForumId = "";
    private e.a hmB = new e.a() { // from class: com.baidu.tieba.write.write.f.1
        @Override // com.baidu.tieba.write.write.e.a
        public void wf(int i) {
            if (f.this.mWriteImagesInfo != null && f.this.mWriteImagesInfo.getChosedFiles() != null && i >= 0 && i < f.this.mWriteImagesInfo.getChosedFiles().size()) {
                ImageFileInfo remove = f.this.mWriteImagesInfo.getChosedFiles().remove(i);
                if (remove.isTempFile()) {
                    com.baidu.adp.lib.Disk.d.dH().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                }
                f.this.hmA.a(f.this.mWriteImagesInfo);
                f.this.hmA.notifyDataSetChanged();
                if (v.w(f.this.mWriteImagesInfo.getChosedFiles()) && f.this.aca.getOrignalPage() != 0) {
                    ((WriteActivity) f.this.aca.getOrignalPage()).dy(false);
                }
            }
        }

        @Override // com.baidu.tieba.write.write.e.a
        public void wu(int i) {
            int v;
            if (f.this.mWriteImagesInfo != null && (v = v.v(f.this.mWriteImagesInfo.getChosedFiles())) != 0 && i >= 0 && i < v) {
                f.this.aca.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(f.this.aca.getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER, f.this.mWriteImagesInfo, i)));
            }
        }

        @Override // com.baidu.tieba.write.write.e.a
        public void bIT() {
            if (f.this.mWriteImagesInfo != null) {
                AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) f.this.aca.getPageActivity(), f.this.mWriteImagesInfo.toJsonString(), true, true);
                albumActivityConfig.getIntent().putExtra("forum_id", f.this.mForumId);
                albumActivityConfig.getIntent().putExtra("from", f.this.mFrom);
                albumActivityConfig.setRequestCode(IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK);
                albumActivityConfig.setFromWrite(true);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
            }
        }
    };

    public f(TbPageContext<WriteActivity> tbPageContext, View view) {
        this.aca = tbPageContext;
        this.hmz = (WriteImageGridView) view.findViewById(d.g.write_image_grid_view);
        this.hmA = new e(view.getContext(), this.aDd, null, this.hmB);
        this.hmz.setAdapter((ListAdapter) this.hmA);
    }

    public void a(WriteImagesInfo writeImagesInfo, String str, String str2) {
        this.mFrom = str;
        this.mForumId = str2;
        this.mWriteImagesInfo = writeImagesInfo;
        this.hmA.a(this.mWriteImagesInfo);
        this.hmA.notifyDataSetChanged();
    }

    public void destroy() {
        this.aDd.EL();
    }

    public void oa(boolean z) {
        this.hmA.oa(z);
    }
}
