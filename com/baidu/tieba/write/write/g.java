package com.baidu.tieba.write.write;

import android.view.View;
import android.widget.GridView;
import android.widget.ListAdapter;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.AlbumFloatActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.write.write.f;
/* loaded from: classes3.dex */
public class g {
    private TbPageContext<WriteActivity> dVN;
    private WriteImageGridView mDr;
    public f mDs;
    private WriteImagesInfo mWriteImagesInfo;
    private com.baidu.tbadk.img.b eBm = new com.baidu.tbadk.img.b();
    private String mFrom = "write";
    private String mForumId = "";
    private f.a mDt = new f.a() { // from class: com.baidu.tieba.write.write.g.1
        @Override // com.baidu.tieba.write.write.f.a
        public void Hl(int i) {
            if (g.this.mWriteImagesInfo != null && g.this.mWriteImagesInfo.getChosedFiles() != null && i >= 0 && i < g.this.mWriteImagesInfo.getChosedFiles().size()) {
                ImageFileInfo remove = g.this.mWriteImagesInfo.getChosedFiles().remove(i);
                if (remove.isTempFile()) {
                    com.baidu.adp.lib.Disk.d.kh().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                }
                g.this.mDs.a(g.this.mWriteImagesInfo);
                g.this.mDs.notifyDataSetChanged();
                if (x.isEmpty(g.this.mWriteImagesInfo.getChosedFiles()) && g.this.dVN.getOrignalPage() != 0) {
                    ((WriteActivity) g.this.dVN.getOrignalPage()).dhM();
                }
                if (g.this.dVN.getPageActivity() instanceof WriteActivity) {
                    ((WriteActivity) g.this.dVN.getPageActivity()).dwT();
                }
            }
        }

        @Override // com.baidu.tieba.write.write.f.a
        public void Hs(int i) {
            int count;
            ImageFileInfo imageInfoAt;
            if (g.this.mWriteImagesInfo != null && (count = x.getCount(g.this.mWriteImagesInfo.getChosedFiles())) != 0 && i >= 0 && i < count && (imageInfoAt = g.this.mWriteImagesInfo.getImageInfoAt(i)) != null && imageInfoAt.getImageType() != 1) {
                g.this.dVN.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(g.this.dVN.getPageActivity(), RequestResponseCode.REQUEST_MOTU_IMAGE, g.this.mWriteImagesInfo, i)));
            }
        }

        @Override // com.baidu.tieba.write.write.f.a
        public void dxa() {
            if (g.this.mWriteImagesInfo != null) {
                AlbumFloatActivityConfig albumFloatActivityConfig = new AlbumFloatActivityConfig(g.this.dVN.getPageActivity(), g.this.mWriteImagesInfo.toJsonString(), true, true);
                albumFloatActivityConfig.getIntent().putExtra("forum_id", g.this.mForumId);
                albumFloatActivityConfig.getIntent().putExtra("from", g.this.mFrom);
                albumFloatActivityConfig.setRequestCode(RequestResponseCode.REQUEST_ALBUM_IMAGE);
                if (g.this.dVN.getPageActivity() instanceof WriteActivity) {
                    albumFloatActivityConfig.setCanSelectVideo(((WriteActivity) g.this.dVN.getPageActivity()).duF());
                    AntiData antiData = new AntiData();
                    antiData.voice_message = ((WriteActivity) g.this.dVN.getPageActivity()).eBU;
                    antiData.setIfVoice(((WriteActivity) g.this.dVN.getPageActivity()).mCk);
                    albumFloatActivityConfig.setExtraData(antiData, ((WriteActivity) g.this.dVN.getPageActivity()).mPrefixData, ((WriteActivity) g.this.dVN.getPageActivity()).lCB.getFirstDir(), ((WriteActivity) g.this.dVN.getPageActivity()).lCB.getSecondDir());
                }
                albumFloatActivityConfig.setFromWrite(true);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumFloatActivityConfig));
            }
        }
    };

    public g(TbPageContext<WriteActivity> tbPageContext, View view) {
        this.dVN = tbPageContext;
        this.mDr = (WriteImageGridView) view.findViewById(R.id.write_image_grid_view);
        this.mDs = new f(view.getContext(), this.eBm, null, this.mDt);
        this.mDr.setAdapter((ListAdapter) this.mDs);
    }

    public void a(WriteImagesInfo writeImagesInfo, String str, String str2) {
        this.mFrom = str;
        this.mForumId = str2;
        this.mWriteImagesInfo = writeImagesInfo;
        this.mDs.a(this.mWriteImagesInfo);
        this.mDs.notifyDataSetChanged();
    }

    public GridView dxb() {
        return this.mDr;
    }

    public void destroy() {
        this.eBm.cancelAllAsyncTask();
    }

    public void wp(boolean z) {
        this.mDs.wp(z);
    }
}
