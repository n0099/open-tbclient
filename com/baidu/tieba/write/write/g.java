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
import com.baidu.tieba.write.write.f;
/* loaded from: classes3.dex */
public class g {
    private TbPageContext<WriteActivity> adf;
    private WriteImageGridView hij;
    private f hik;
    private WriteImagesInfo mWriteImagesInfo;
    private com.baidu.tbadk.img.b aDT = new com.baidu.tbadk.img.b();
    private String mFrom = AlbumActivityConfig.FROM_WRITE;
    private String mForumId = "";
    private f.a hil = new f.a() { // from class: com.baidu.tieba.write.write.g.1
        @Override // com.baidu.tieba.write.write.f.a
        public void ve(int i) {
            if (g.this.mWriteImagesInfo != null && g.this.mWriteImagesInfo.getChosedFiles() != null && i >= 0 && i < g.this.mWriteImagesInfo.getChosedFiles().size()) {
                ImageFileInfo remove = g.this.mWriteImagesInfo.getChosedFiles().remove(i);
                if (remove.isTempFile()) {
                    com.baidu.adp.lib.Disk.d.dp().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                }
                g.this.hik.a(g.this.mWriteImagesInfo);
                g.this.hik.notifyDataSetChanged();
                if (v.w(g.this.mWriteImagesInfo.getChosedFiles()) && g.this.adf.getOrignalPage() != 0) {
                    ((WriteActivity) g.this.adf.getOrignalPage()).nw(false);
                }
            }
        }

        @Override // com.baidu.tieba.write.write.f.a
        public void vl(int i) {
            int v;
            if (g.this.mWriteImagesInfo != null && (v = v.v(g.this.mWriteImagesInfo.getChosedFiles())) != 0 && i >= 0 && i < v) {
                g.this.adf.sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(g.this.adf.getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER, g.this.mWriteImagesInfo, i)));
            }
        }

        @Override // com.baidu.tieba.write.write.f.a
        public void bDS() {
            if (g.this.mWriteImagesInfo != null) {
                AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) g.this.adf.getPageActivity(), g.this.mWriteImagesInfo.toJsonString(), true, true);
                albumActivityConfig.getIntent().putExtra("forum_id", g.this.mForumId);
                albumActivityConfig.getIntent().putExtra("from", g.this.mFrom);
                albumActivityConfig.setRequestCode(IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK);
                albumActivityConfig.setFromWrite(true);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
            }
        }
    };

    public g(TbPageContext<WriteActivity> tbPageContext, View view2) {
        this.adf = tbPageContext;
        this.hij = (WriteImageGridView) view2.findViewById(d.g.write_image_grid_view);
        this.hik = new f(view2.getContext(), this.aDT, null, this.hil);
        this.hij.setAdapter((ListAdapter) this.hik);
    }

    public void a(WriteImagesInfo writeImagesInfo, String str, String str2) {
        this.mFrom = str;
        this.mForumId = str2;
        this.mWriteImagesInfo = writeImagesInfo;
        this.hik.a(this.mWriteImagesInfo);
        this.hik.notifyDataSetChanged();
    }

    public void destroy() {
        this.aDT.Fk();
    }

    public void nq(boolean z) {
        this.hik.nq(z);
    }
}
