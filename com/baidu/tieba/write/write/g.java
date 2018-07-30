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
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.d;
import com.baidu.tieba.write.write.f;
/* loaded from: classes3.dex */
public class g {
    private WriteImageGridView hAw;
    private f hAx;
    private TbPageContext<WriteActivity> mContext;
    private WriteImagesInfo mWriteImagesInfo;
    private com.baidu.tbadk.img.b aNm = new com.baidu.tbadk.img.b();
    private String mFrom = AlbumActivityConfig.FROM_WRITE;
    private String mForumId = "";
    private f.a hAy = new f.a() { // from class: com.baidu.tieba.write.write.g.1
        @Override // com.baidu.tieba.write.write.f.a
        public void vC(int i) {
            if (g.this.mWriteImagesInfo != null && g.this.mWriteImagesInfo.getChosedFiles() != null && i >= 0 && i < g.this.mWriteImagesInfo.getChosedFiles().size()) {
                ImageFileInfo remove = g.this.mWriteImagesInfo.getChosedFiles().remove(i);
                if (remove.isTempFile()) {
                    com.baidu.adp.lib.Disk.d.ge().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                }
                g.this.hAx.a(g.this.mWriteImagesInfo);
                g.this.hAx.notifyDataSetChanged();
                if (w.z(g.this.mWriteImagesInfo.getChosedFiles()) && g.this.mContext.getOrignalPage() != 0) {
                    ((WriteActivity) g.this.mContext.getOrignalPage()).nB(false);
                }
            }
        }

        @Override // com.baidu.tieba.write.write.f.a
        public void vJ(int i) {
            int y;
            if (g.this.mWriteImagesInfo != null && (y = w.y(g.this.mWriteImagesInfo.getChosedFiles())) != 0 && i >= 0 && i < y) {
                g.this.mContext.sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(g.this.mContext.getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER, g.this.mWriteImagesInfo, i)));
            }
        }

        @Override // com.baidu.tieba.write.write.f.a
        public void bIj() {
            if (g.this.mWriteImagesInfo != null) {
                AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) g.this.mContext.getPageActivity(), g.this.mWriteImagesInfo.toJsonString(), true, true);
                albumActivityConfig.getIntent().putExtra("forum_id", g.this.mForumId);
                albumActivityConfig.getIntent().putExtra("from", g.this.mFrom);
                albumActivityConfig.setRequestCode(IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK);
                albumActivityConfig.setFromWrite(true);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
            }
        }
    };

    public g(TbPageContext<WriteActivity> tbPageContext, View view) {
        this.mContext = tbPageContext;
        this.hAw = (WriteImageGridView) view.findViewById(d.g.write_image_grid_view);
        this.hAx = new f(view.getContext(), this.aNm, null, this.hAy);
        this.hAw.setAdapter((ListAdapter) this.hAx);
    }

    public void a(WriteImagesInfo writeImagesInfo, String str, String str2) {
        this.mFrom = str;
        this.mForumId = str2;
        this.mWriteImagesInfo = writeImagesInfo;
        this.hAx.a(this.mWriteImagesInfo);
        this.hAx.notifyDataSetChanged();
    }

    public void destroy() {
        this.aNm.Ja();
    }

    public void nv(boolean z) {
        this.hAx.nv(z);
    }
}
