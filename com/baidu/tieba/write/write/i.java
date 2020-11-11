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
/* loaded from: classes3.dex */
public class i {
    private TbPageContext<WriteActivity> eIc;
    private WriteImagesInfo mWriteImagesInfo;
    private WriteImageGridView nOA;
    public h nOB;
    private com.baidu.tbadk.img.b foE = new com.baidu.tbadk.img.b();
    private String mFrom = "write";
    private String mForumId = "";
    private h.a nOC = new h.a() { // from class: com.baidu.tieba.write.write.i.1
        @Override // com.baidu.tieba.write.write.h.a
        public void Ly(int i) {
            if (i.this.mWriteImagesInfo != null && i.this.mWriteImagesInfo.getChosedFiles() != null && i >= 0 && i < i.this.mWriteImagesInfo.getChosedFiles().size()) {
                ImageFileInfo remove = i.this.mWriteImagesInfo.getChosedFiles().remove(i);
                if (remove.isTempFile()) {
                    com.baidu.adp.lib.Disk.d.lL().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                }
                i.this.nOB.a(i.this.mWriteImagesInfo);
                i.this.nOB.notifyDataSetChanged();
                if (y.isEmpty(i.this.mWriteImagesInfo.getChosedFiles()) && i.this.eIc.getOrignalPage() != 0) {
                    ((WriteActivity) i.this.eIc.getOrignalPage()).dGA();
                }
                if (i.this.eIc.getPageActivity() instanceof WriteActivity) {
                    ((WriteActivity) i.this.eIc.getPageActivity()).dWd();
                }
            }
        }

        @Override // com.baidu.tieba.write.write.h.a
        public void LI(int i) {
            int count;
            ImageFileInfo imageInfoAt;
            if (i.this.mWriteImagesInfo != null && (count = y.getCount(i.this.mWriteImagesInfo.getChosedFiles())) != 0 && i >= 0 && i < count && (imageInfoAt = i.this.mWriteImagesInfo.getImageInfoAt(i)) != null && imageInfoAt.getImageType() != 1) {
                i.this.eIc.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(i.this.eIc.getPageActivity(), RequestResponseCode.REQUEST_MOTU_IMAGE, i.this.mWriteImagesInfo, i)));
            }
        }

        @Override // com.baidu.tieba.write.write.h.a
        public void dWp() {
            if (i.this.mWriteImagesInfo != null) {
                AlbumFloatActivityConfig albumFloatActivityConfig = new AlbumFloatActivityConfig(i.this.eIc.getPageActivity(), i.this.mWriteImagesInfo.toJsonString(), true, true);
                albumFloatActivityConfig.getIntent().putExtra("forum_id", i.this.mForumId);
                albumFloatActivityConfig.getIntent().putExtra("from", i.this.mFrom);
                albumFloatActivityConfig.setRequestCode(RequestResponseCode.REQUEST_ALBUM_IMAGE);
                if (i.this.eIc.getPageActivity() instanceof WriteActivity) {
                    albumFloatActivityConfig.setCanSelectVideo(((WriteActivity) i.this.eIc.getPageActivity()).dTy());
                    AntiData antiData = new AntiData();
                    antiData.voice_message = ((WriteActivity) i.this.eIc.getPageActivity()).fpM;
                    antiData.setIfVoice(((WriteActivity) i.this.eIc.getPageActivity()).nNd);
                    albumFloatActivityConfig.setExtraData(antiData, ((WriteActivity) i.this.eIc.getPageActivity()).mPrefixData, ((WriteActivity) i.this.eIc.getPageActivity()).mMg.getFirstDir(), ((WriteActivity) i.this.eIc.getPageActivity()).mMg.getSecondDir());
                }
                albumFloatActivityConfig.setFromWrite(true);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumFloatActivityConfig));
            }
        }
    };

    public i(TbPageContext<WriteActivity> tbPageContext, View view) {
        this.eIc = tbPageContext;
        this.nOA = (WriteImageGridView) view.findViewById(R.id.write_image_grid_view);
        this.nOB = new h(view.getContext(), this.foE, null, this.nOC);
        this.nOA.setAdapter((ListAdapter) this.nOB);
    }

    public void a(WriteImagesInfo writeImagesInfo, String str, String str2) {
        this.mFrom = str;
        this.mForumId = str2;
        this.mWriteImagesInfo = writeImagesInfo;
        this.nOB.a(this.mWriteImagesInfo);
        this.nOB.notifyDataSetChanged();
    }

    public GridView dWq() {
        return this.nOA;
    }

    public void destroy() {
        this.foE.cancelAllAsyncTask();
    }

    public void yw(boolean z) {
        this.nOB.yw(z);
    }
}
