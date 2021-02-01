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
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.write.write.h;
/* loaded from: classes8.dex */
public class i {
    private TbPageContext<WriteActivity> eUY;
    private WriteImagesInfo mWriteImagesInfo;
    private WriteImageGridView omg;
    public h omh;
    private com.baidu.tbadk.img.b fCD = new com.baidu.tbadk.img.b();
    private String mFrom = "write";
    private String mForumId = "";
    private h.a omi = new h.a() { // from class: com.baidu.tieba.write.write.i.1
        @Override // com.baidu.tieba.write.write.h.a
        public void Lt(int i) {
            if (i.this.mWriteImagesInfo != null && i.this.mWriteImagesInfo.getChosedFiles() != null && i >= 0 && i < i.this.mWriteImagesInfo.getChosedFiles().size()) {
                ImageFileInfo remove = i.this.mWriteImagesInfo.getChosedFiles().remove(i);
                if (remove.isTempFile()) {
                    com.baidu.adp.lib.Disk.d.lg().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                }
                i.this.omh.a(i.this.mWriteImagesInfo);
                i.this.omh.notifyDataSetChanged();
                if (y.isEmpty(i.this.mWriteImagesInfo.getChosedFiles()) && i.this.eUY.getOrignalPage() != 0) {
                    ((WriteActivity) i.this.eUY.getOrignalPage()).dJR();
                }
                if (i.this.eUY.getPageActivity() instanceof WriteActivity) {
                    ((WriteActivity) i.this.eUY.getPageActivity()).dZh();
                }
            }
        }

        @Override // com.baidu.tieba.write.write.h.a
        public void LC(int i) {
            int count;
            ImageFileInfo imageInfoAt;
            if (i.this.mWriteImagesInfo != null && (count = y.getCount(i.this.mWriteImagesInfo.getChosedFiles())) != 0 && i >= 0 && i < count && (imageInfoAt = i.this.mWriteImagesInfo.getImageInfoAt(i)) != null && imageInfoAt.getImageType() != 1) {
                i.this.eUY.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(i.this.eUY.getPageActivity(), RequestResponseCode.REQUEST_MOTU_IMAGE, i.this.mWriteImagesInfo, i)));
            }
        }

        @Override // com.baidu.tieba.write.write.h.a
        public void dZt() {
            if (i.this.mWriteImagesInfo != null) {
                AlbumFloatActivityConfig albumFloatActivityConfig = new AlbumFloatActivityConfig(i.this.eUY.getPageActivity(), i.this.mWriteImagesInfo.toJsonString(), true, true);
                albumFloatActivityConfig.getIntent().putExtra("forum_id", i.this.mForumId);
                albumFloatActivityConfig.getIntent().putExtra("from", i.this.mFrom);
                albumFloatActivityConfig.setRequestCode(12002);
                if (i.this.eUY.getPageActivity() instanceof WriteActivity) {
                    albumFloatActivityConfig.setCanSelectVideo(((WriteActivity) i.this.eUY.getPageActivity()).dWS());
                    AntiData antiData = new AntiData();
                    antiData.voice_message = ((WriteActivity) i.this.eUY.getPageActivity()).fDL;
                    antiData.setIfVoice(((WriteActivity) i.this.eUY.getPageActivity()).okz);
                    albumFloatActivityConfig.setStatisticFrom(((WriteActivity) i.this.eUY.getPageActivity()).nlK.getStatisticFrom());
                    albumFloatActivityConfig.setExtraData(antiData, ((WriteActivity) i.this.eUY.getPageActivity()).mPrefixData, ((WriteActivity) i.this.eUY.getPageActivity()).nlK.getFirstDir(), ((WriteActivity) i.this.eUY.getPageActivity()).nlK.getSecondDir());
                }
                albumFloatActivityConfig.setFromWrite(true);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumFloatActivityConfig));
            }
        }
    };

    public i(TbPageContext<WriteActivity> tbPageContext, View view) {
        this.eUY = tbPageContext;
        this.omg = (WriteImageGridView) view.findViewById(R.id.write_image_grid_view);
        this.omh = new h(view.getContext(), this.fCD, null, this.omi);
        this.omg.setAdapter((ListAdapter) this.omh);
    }

    public void a(WriteImagesInfo writeImagesInfo, String str, String str2) {
        this.mFrom = str;
        this.mForumId = str2;
        this.mWriteImagesInfo = writeImagesInfo;
        this.omh.a(this.mWriteImagesInfo);
        this.omh.notifyDataSetChanged();
    }

    public GridView XO() {
        return this.omg;
    }

    public void destroy() {
        this.fCD.cancelAllAsyncTask();
    }

    public void zB(boolean z) {
        this.omh.zB(z);
    }
}
