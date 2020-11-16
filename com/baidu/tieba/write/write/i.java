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
    private TbPageContext<WriteActivity> eGu;
    private WriteImagesInfo mWriteImagesInfo;
    private WriteImageGridView nQd;
    public h nQe;
    private com.baidu.tbadk.img.b fnM = new com.baidu.tbadk.img.b();
    private String mFrom = "write";
    private String mForumId = "";
    private h.a nQf = new h.a() { // from class: com.baidu.tieba.write.write.i.1
        @Override // com.baidu.tieba.write.write.h.a
        public void Mb(int i) {
            if (i.this.mWriteImagesInfo != null && i.this.mWriteImagesInfo.getChosedFiles() != null && i >= 0 && i < i.this.mWriteImagesInfo.getChosedFiles().size()) {
                ImageFileInfo remove = i.this.mWriteImagesInfo.getChosedFiles().remove(i);
                if (remove.isTempFile()) {
                    com.baidu.adp.lib.Disk.d.lL().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                }
                i.this.nQe.a(i.this.mWriteImagesInfo);
                i.this.nQe.notifyDataSetChanged();
                if (y.isEmpty(i.this.mWriteImagesInfo.getChosedFiles()) && i.this.eGu.getOrignalPage() != 0) {
                    ((WriteActivity) i.this.eGu.getOrignalPage()).dGr();
                }
                if (i.this.eGu.getPageActivity() instanceof WriteActivity) {
                    ((WriteActivity) i.this.eGu.getPageActivity()).dWc();
                }
            }
        }

        @Override // com.baidu.tieba.write.write.h.a
        public void Ml(int i) {
            int count;
            ImageFileInfo imageInfoAt;
            if (i.this.mWriteImagesInfo != null && (count = y.getCount(i.this.mWriteImagesInfo.getChosedFiles())) != 0 && i >= 0 && i < count && (imageInfoAt = i.this.mWriteImagesInfo.getImageInfoAt(i)) != null && imageInfoAt.getImageType() != 1) {
                i.this.eGu.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(i.this.eGu.getPageActivity(), RequestResponseCode.REQUEST_MOTU_IMAGE, i.this.mWriteImagesInfo, i)));
            }
        }

        @Override // com.baidu.tieba.write.write.h.a
        public void dWo() {
            if (i.this.mWriteImagesInfo != null) {
                AlbumFloatActivityConfig albumFloatActivityConfig = new AlbumFloatActivityConfig(i.this.eGu.getPageActivity(), i.this.mWriteImagesInfo.toJsonString(), true, true);
                albumFloatActivityConfig.getIntent().putExtra("forum_id", i.this.mForumId);
                albumFloatActivityConfig.getIntent().putExtra("from", i.this.mFrom);
                albumFloatActivityConfig.setRequestCode(RequestResponseCode.REQUEST_ALBUM_IMAGE);
                if (i.this.eGu.getPageActivity() instanceof WriteActivity) {
                    albumFloatActivityConfig.setCanSelectVideo(((WriteActivity) i.this.eGu.getPageActivity()).dTx());
                    AntiData antiData = new AntiData();
                    antiData.voice_message = ((WriteActivity) i.this.eGu.getPageActivity()).foT;
                    antiData.setIfVoice(((WriteActivity) i.this.eGu.getPageActivity()).nOF);
                    albumFloatActivityConfig.setExtraData(antiData, ((WriteActivity) i.this.eGu.getPageActivity()).mPrefixData, ((WriteActivity) i.this.eGu.getPageActivity()).mMZ.getFirstDir(), ((WriteActivity) i.this.eGu.getPageActivity()).mMZ.getSecondDir());
                }
                albumFloatActivityConfig.setFromWrite(true);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumFloatActivityConfig));
            }
        }
    };

    public i(TbPageContext<WriteActivity> tbPageContext, View view) {
        this.eGu = tbPageContext;
        this.nQd = (WriteImageGridView) view.findViewById(R.id.write_image_grid_view);
        this.nQe = new h(view.getContext(), this.fnM, null, this.nQf);
        this.nQd.setAdapter((ListAdapter) this.nQe);
    }

    public void a(WriteImagesInfo writeImagesInfo, String str, String str2) {
        this.mFrom = str;
        this.mForumId = str2;
        this.mWriteImagesInfo = writeImagesInfo;
        this.nQe.a(this.mWriteImagesInfo);
        this.nQe.notifyDataSetChanged();
    }

    public GridView dWp() {
        return this.nQd;
    }

    public void destroy() {
        this.fnM.cancelAllAsyncTask();
    }

    public void yD(boolean z) {
        this.nQe.yD(z);
    }
}
