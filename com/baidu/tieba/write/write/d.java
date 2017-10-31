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
    private WriteImagesInfo flC;
    private WriteImageGridView gXn;
    private c gXo;
    private com.baidu.tbadk.img.b aCk = new com.baidu.tbadk.img.b();
    private String aiB = AlbumActivityConfig.FROM_WRITE;
    private String mForumId = "";
    private c.a gXp = new c.a() { // from class: com.baidu.tieba.write.write.d.1
        @Override // com.baidu.tieba.write.write.c.a
        public void vs(int i) {
            if (d.this.flC != null && d.this.flC.getChosedFiles() != null && i >= 0 && i < d.this.flC.getChosedFiles().size()) {
                ImageFileInfo remove = d.this.flC.getChosedFiles().remove(i);
                if (remove.isTempFile()) {
                    com.baidu.adp.lib.Disk.d.dH().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                }
                d.this.gXo.a(d.this.flC);
                d.this.gXo.notifyDataSetChanged();
            }
        }

        @Override // com.baidu.tieba.write.write.c.a
        public void vG(int i) {
            int u;
            if (d.this.flC != null && (u = v.u(d.this.flC.getChosedFiles())) != 0 && i >= 0 && i < u) {
                d.this.abI.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(d.this.abI.getPageActivity(), 12012, d.this.flC, i)));
            }
        }

        @Override // com.baidu.tieba.write.write.c.a
        public void bFa() {
            if (d.this.flC != null) {
                AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) d.this.abI.getPageActivity(), d.this.flC.toJsonString(), true, true);
                albumActivityConfig.getIntent().putExtra("forum_id", d.this.mForumId);
                albumActivityConfig.getIntent().putExtra("from", d.this.aiB);
                albumActivityConfig.setRequestCode(12002);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
            }
        }
    };

    public d(TbPageContext tbPageContext, View view) {
        this.abI = tbPageContext;
        this.gXn = (WriteImageGridView) view.findViewById(d.g.write_image_grid_view);
        this.gXo = new c(view.getContext(), this.aCk, null, this.gXp);
        this.gXn.setAdapter((ListAdapter) this.gXo);
    }

    public void a(WriteImagesInfo writeImagesInfo, String str, String str2) {
        this.aiB = str;
        this.mForumId = str2;
        this.flC = writeImagesInfo;
        this.gXo.a(this.flC);
        this.gXo.notifyDataSetChanged();
    }

    public void destroy() {
        this.aCk.Er();
    }

    public void nA(boolean z) {
        this.gXo.nA(z);
    }
}
