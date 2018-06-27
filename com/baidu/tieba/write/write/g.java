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
    private WriteImageGridView hzo;
    private f hzp;
    private TbPageContext<WriteActivity> mContext;
    private WriteImagesInfo mWriteImagesInfo;
    private com.baidu.tbadk.img.b aNm = new com.baidu.tbadk.img.b();
    private String mFrom = AlbumActivityConfig.FROM_WRITE;
    private String mForumId = "";
    private f.a hzq = new f.a() { // from class: com.baidu.tieba.write.write.g.1
        @Override // com.baidu.tieba.write.write.f.a
        public void vD(int i) {
            if (g.this.mWriteImagesInfo != null && g.this.mWriteImagesInfo.getChosedFiles() != null && i >= 0 && i < g.this.mWriteImagesInfo.getChosedFiles().size()) {
                ImageFileInfo remove = g.this.mWriteImagesInfo.getChosedFiles().remove(i);
                if (remove.isTempFile()) {
                    com.baidu.adp.lib.Disk.d.gf().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                }
                g.this.hzp.a(g.this.mWriteImagesInfo);
                g.this.hzp.notifyDataSetChanged();
                if (w.A(g.this.mWriteImagesInfo.getChosedFiles()) && g.this.mContext.getOrignalPage() != 0) {
                    ((WriteActivity) g.this.mContext.getOrignalPage()).nN(false);
                }
            }
        }

        @Override // com.baidu.tieba.write.write.f.a
        public void vK(int i) {
            int z;
            if (g.this.mWriteImagesInfo != null && (z = w.z(g.this.mWriteImagesInfo.getChosedFiles())) != 0 && i >= 0 && i < z) {
                g.this.mContext.sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(g.this.mContext.getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER, g.this.mWriteImagesInfo, i)));
            }
        }

        @Override // com.baidu.tieba.write.write.f.a
        public void bJw() {
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
        this.hzo = (WriteImageGridView) view.findViewById(d.g.write_image_grid_view);
        this.hzp = new f(view.getContext(), this.aNm, null, this.hzq);
        this.hzo.setAdapter((ListAdapter) this.hzp);
    }

    public void a(WriteImagesInfo writeImagesInfo, String str, String str2) {
        this.mFrom = str;
        this.mForumId = str2;
        this.mWriteImagesInfo = writeImagesInfo;
        this.hzp.a(this.mWriteImagesInfo);
        this.hzp.notifyDataSetChanged();
    }

    public void destroy() {
        this.aNm.Jf();
    }

    public void nH(boolean z) {
        this.hzp.nH(z);
    }
}
