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
/* loaded from: classes7.dex */
public class i {
    private TbPageContext<WriteActivity> eWx;
    private WriteImagesInfo mWriteImagesInfo;
    private WriteImageGridView ooM;
    public h ooN;
    private com.baidu.tbadk.img.b fEc = new com.baidu.tbadk.img.b();
    private String mFrom = "write";
    private String mForumId = "";
    private h.a ooO = new h.a() { // from class: com.baidu.tieba.write.write.i.1
        @Override // com.baidu.tieba.write.write.h.a
        public void Ly(int i) {
            if (i.this.mWriteImagesInfo != null && i.this.mWriteImagesInfo.getChosedFiles() != null && i >= 0 && i < i.this.mWriteImagesInfo.getChosedFiles().size()) {
                ImageFileInfo remove = i.this.mWriteImagesInfo.getChosedFiles().remove(i);
                if (remove.isTempFile()) {
                    com.baidu.adp.lib.Disk.d.lg().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                }
                i.this.ooN.a(i.this.mWriteImagesInfo);
                i.this.ooN.notifyDataSetChanged();
                if (y.isEmpty(i.this.mWriteImagesInfo.getChosedFiles()) && i.this.eWx.getOrignalPage() != 0) {
                    ((WriteActivity) i.this.eWx.getOrignalPage()).dKh();
                }
                if (i.this.eWx.getPageActivity() instanceof WriteActivity) {
                    ((WriteActivity) i.this.eWx.getPageActivity()).dZx();
                }
            }
        }

        @Override // com.baidu.tieba.write.write.h.a
        public void LH(int i) {
            int count;
            ImageFileInfo imageInfoAt;
            if (i.this.mWriteImagesInfo != null && (count = y.getCount(i.this.mWriteImagesInfo.getChosedFiles())) != 0 && i >= 0 && i < count && (imageInfoAt = i.this.mWriteImagesInfo.getImageInfoAt(i)) != null && imageInfoAt.getImageType() != 1) {
                i.this.eWx.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(i.this.eWx.getPageActivity(), RequestResponseCode.REQUEST_MOTU_IMAGE, i.this.mWriteImagesInfo, i)));
            }
        }

        @Override // com.baidu.tieba.write.write.h.a
        public void dZJ() {
            if (i.this.mWriteImagesInfo != null) {
                AlbumFloatActivityConfig albumFloatActivityConfig = new AlbumFloatActivityConfig(i.this.eWx.getPageActivity(), i.this.mWriteImagesInfo.toJsonString(), true, true);
                albumFloatActivityConfig.getIntent().putExtra("forum_id", i.this.mForumId);
                albumFloatActivityConfig.getIntent().putExtra("from", i.this.mFrom);
                albumFloatActivityConfig.setRequestCode(12002);
                if (i.this.eWx.getPageActivity() instanceof WriteActivity) {
                    albumFloatActivityConfig.setCanSelectVideo(((WriteActivity) i.this.eWx.getPageActivity()).dXi());
                    AntiData antiData = new AntiData();
                    antiData.voice_message = ((WriteActivity) i.this.eWx.getPageActivity()).fFk;
                    antiData.setIfVoice(((WriteActivity) i.this.eWx.getPageActivity()).onf);
                    albumFloatActivityConfig.setStatisticFrom(((WriteActivity) i.this.eWx.getPageActivity()).noo.getStatisticFrom());
                    albumFloatActivityConfig.setExtraData(antiData, ((WriteActivity) i.this.eWx.getPageActivity()).mPrefixData, ((WriteActivity) i.this.eWx.getPageActivity()).noo.getFirstDir(), ((WriteActivity) i.this.eWx.getPageActivity()).noo.getSecondDir());
                }
                albumFloatActivityConfig.setFromWrite(true);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumFloatActivityConfig));
            }
        }
    };

    public i(TbPageContext<WriteActivity> tbPageContext, View view) {
        this.eWx = tbPageContext;
        this.ooM = (WriteImageGridView) view.findViewById(R.id.write_image_grid_view);
        this.ooN = new h(view.getContext(), this.fEc, null, this.ooO);
        this.ooM.setAdapter((ListAdapter) this.ooN);
    }

    public void a(WriteImagesInfo writeImagesInfo, String str, String str2) {
        this.mFrom = str;
        this.mForumId = str2;
        this.mWriteImagesInfo = writeImagesInfo;
        this.ooN.a(this.mWriteImagesInfo);
        this.ooN.notifyDataSetChanged();
    }

    public GridView XR() {
        return this.ooM;
    }

    public void destroy() {
        this.fEc.cancelAllAsyncTask();
    }

    public void zA(boolean z) {
        this.ooN.zA(z);
    }
}
