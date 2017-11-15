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
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.d;
import com.baidu.tieba.write.write.c;
/* loaded from: classes2.dex */
public class d {
    private TbPageContext abI;
    private WriteImagesInfo flZ;
    private WriteImageGridView gYx;
    private c gYy;
    private com.baidu.tbadk.img.b aCs = new com.baidu.tbadk.img.b();
    private String aiB = AlbumActivityConfig.FROM_WRITE;
    private String mForumId = "";
    private c.a gYz = new c.a() { // from class: com.baidu.tieba.write.write.d.1
        @Override // com.baidu.tieba.write.write.c.a
        public void vw(int i) {
            if (d.this.flZ != null && d.this.flZ.getChosedFiles() != null && i >= 0 && i < d.this.flZ.getChosedFiles().size()) {
                ImageFileInfo remove = d.this.flZ.getChosedFiles().remove(i);
                if (remove.isTempFile()) {
                    com.baidu.adp.lib.Disk.d.dH().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                }
                d.this.gYy.a(d.this.flZ);
                d.this.gYy.notifyDataSetChanged();
            }
        }

        @Override // com.baidu.tieba.write.write.c.a
        public void vK(int i) {
            int u;
            if (d.this.flZ != null && (u = v.u(d.this.flZ.getChosedFiles())) != 0 && i >= 0 && i < u) {
                d.this.abI.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(d.this.abI.getPageActivity(), 12012, d.this.flZ, i)));
            }
        }

        @Override // com.baidu.tieba.write.write.c.a
        public void bFn() {
            if (d.this.flZ != null) {
                AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) d.this.abI.getPageActivity(), d.this.flZ.toJsonString(), true, true);
                albumActivityConfig.getIntent().putExtra("forum_id", d.this.mForumId);
                albumActivityConfig.getIntent().putExtra("from", d.this.aiB);
                albumActivityConfig.setRequestCode(12002);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
            }
        }
    };

    public d(TbPageContext tbPageContext, View view) {
        this.abI = tbPageContext;
        this.gYx = (WriteImageGridView) view.findViewById(d.g.write_image_grid_view);
        this.gYy = new c(view.getContext(), this.aCs, null, this.gYz);
        this.gYx.setAdapter((ListAdapter) this.gYy);
    }

    public void a(WriteImagesInfo writeImagesInfo, String str, String str2) {
        this.aiB = str;
        this.mForumId = str2;
        this.flZ = writeImagesInfo;
        this.gYy.a(this.flZ);
        this.gYy.notifyDataSetChanged();
    }

    public void destroy() {
        this.aCs.ED();
    }

    public void nI(boolean z) {
        this.gYy.nI(z);
    }
}
