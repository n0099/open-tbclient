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
import com.baidu.tieba.e;
import com.baidu.tieba.write.write.f;
/* loaded from: classes3.dex */
public class g {
    private WriteImageGridView hZc;
    private f hZd;
    private TbPageContext<WriteActivity> mContext;
    private WriteImagesInfo mWriteImagesInfo;
    private com.baidu.tbadk.img.b aZp = new com.baidu.tbadk.img.b();
    private String mFrom = "write";
    private String mForumId = "";
    private f.a hZe = new f.a() { // from class: com.baidu.tieba.write.write.g.1
        @Override // com.baidu.tieba.write.write.f.a
        public void xp(int i) {
            if (g.this.mWriteImagesInfo != null && g.this.mWriteImagesInfo.getChosedFiles() != null && i >= 0 && i < g.this.mWriteImagesInfo.getChosedFiles().size()) {
                ImageFileInfo remove = g.this.mWriteImagesInfo.getChosedFiles().remove(i);
                if (remove.isTempFile()) {
                    com.baidu.adp.lib.Disk.d.hB().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                }
                g.this.hZd.a(g.this.mWriteImagesInfo);
                g.this.hZd.notifyDataSetChanged();
                if (v.I(g.this.mWriteImagesInfo.getChosedFiles()) && g.this.mContext.getOrignalPage() != 0) {
                    ((WriteActivity) g.this.mContext.getOrignalPage()).bze();
                }
            }
        }

        @Override // com.baidu.tieba.write.write.f.a
        public void xw(int i) {
            int H;
            if (g.this.mWriteImagesInfo != null && (H = v.H(g.this.mWriteImagesInfo.getChosedFiles())) != 0 && i >= 0 && i < H) {
                g.this.mContext.sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(g.this.mContext.getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER, g.this.mWriteImagesInfo, i)));
            }
        }

        @Override // com.baidu.tieba.write.write.f.a
        public void bPU() {
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
        this.hZc = (WriteImageGridView) view.findViewById(e.g.write_image_grid_view);
        this.hZd = new f(view.getContext(), this.aZp, null, this.hZe);
        this.hZc.setAdapter((ListAdapter) this.hZd);
    }

    public void a(WriteImagesInfo writeImagesInfo, String str, String str2) {
        this.mFrom = str;
        this.mForumId = str2;
        this.mWriteImagesInfo = writeImagesInfo;
        this.hZd.a(this.mWriteImagesInfo);
        this.hZd.notifyDataSetChanged();
    }

    public void destroy() {
        this.aZp.NE();
    }

    public void oy(boolean z) {
        this.hZd.oy(z);
    }
}
