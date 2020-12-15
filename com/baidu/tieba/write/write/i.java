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
    private TbPageContext<WriteActivity> eNx;
    private WriteImagesInfo mWriteImagesInfo;
    private WriteImageGridView oeH;
    public h oeI;
    private com.baidu.tbadk.img.b fvq = new com.baidu.tbadk.img.b();
    private String mFrom = "write";
    private String mForumId = "";
    private h.a oeJ = new h.a() { // from class: com.baidu.tieba.write.write.i.1
        @Override // com.baidu.tieba.write.write.h.a
        public void MT(int i) {
            if (i.this.mWriteImagesInfo != null && i.this.mWriteImagesInfo.getChosedFiles() != null && i >= 0 && i < i.this.mWriteImagesInfo.getChosedFiles().size()) {
                ImageFileInfo remove = i.this.mWriteImagesInfo.getChosedFiles().remove(i);
                if (remove.isTempFile()) {
                    com.baidu.adp.lib.Disk.d.lL().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                }
                i.this.oeI.a(i.this.mWriteImagesInfo);
                i.this.oeI.notifyDataSetChanged();
                if (y.isEmpty(i.this.mWriteImagesInfo.getChosedFiles()) && i.this.eNx.getOrignalPage() != 0) {
                    ((WriteActivity) i.this.eNx.getOrignalPage()).dLG();
                }
                if (i.this.eNx.getPageActivity() instanceof WriteActivity) {
                    ((WriteActivity) i.this.eNx.getPageActivity()).ebA();
                }
            }
        }

        @Override // com.baidu.tieba.write.write.h.a
        public void Nd(int i) {
            int count;
            ImageFileInfo imageInfoAt;
            if (i.this.mWriteImagesInfo != null && (count = y.getCount(i.this.mWriteImagesInfo.getChosedFiles())) != 0 && i >= 0 && i < count && (imageInfoAt = i.this.mWriteImagesInfo.getImageInfoAt(i)) != null && imageInfoAt.getImageType() != 1) {
                i.this.eNx.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(i.this.eNx.getPageActivity(), RequestResponseCode.REQUEST_MOTU_IMAGE, i.this.mWriteImagesInfo, i)));
            }
        }

        @Override // com.baidu.tieba.write.write.h.a
        public void ebM() {
            if (i.this.mWriteImagesInfo != null) {
                AlbumFloatActivityConfig albumFloatActivityConfig = new AlbumFloatActivityConfig(i.this.eNx.getPageActivity(), i.this.mWriteImagesInfo.toJsonString(), true, true);
                albumFloatActivityConfig.getIntent().putExtra("forum_id", i.this.mForumId);
                albumFloatActivityConfig.getIntent().putExtra("from", i.this.mFrom);
                albumFloatActivityConfig.setRequestCode(RequestResponseCode.REQUEST_ALBUM_IMAGE);
                if (i.this.eNx.getPageActivity() instanceof WriteActivity) {
                    albumFloatActivityConfig.setCanSelectVideo(((WriteActivity) i.this.eNx.getPageActivity()).dYS());
                    AntiData antiData = new AntiData();
                    antiData.voice_message = ((WriteActivity) i.this.eNx.getPageActivity()).fwy;
                    antiData.setIfVoice(((WriteActivity) i.this.eNx.getPageActivity()).oda);
                    albumFloatActivityConfig.setExtraData(antiData, ((WriteActivity) i.this.eNx.getPageActivity()).mPrefixData, ((WriteActivity) i.this.eNx.getPageActivity()).nbe.getFirstDir(), ((WriteActivity) i.this.eNx.getPageActivity()).nbe.getSecondDir());
                }
                albumFloatActivityConfig.setFromWrite(true);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumFloatActivityConfig));
            }
        }
    };

    public i(TbPageContext<WriteActivity> tbPageContext, View view) {
        this.eNx = tbPageContext;
        this.oeH = (WriteImageGridView) view.findViewById(R.id.write_image_grid_view);
        this.oeI = new h(view.getContext(), this.fvq, null, this.oeJ);
        this.oeH.setAdapter((ListAdapter) this.oeI);
    }

    public void a(WriteImagesInfo writeImagesInfo, String str, String str2) {
        this.mFrom = str;
        this.mForumId = str2;
        this.mWriteImagesInfo = writeImagesInfo;
        this.oeI.a(this.mWriteImagesInfo);
        this.oeI.notifyDataSetChanged();
    }

    public GridView ebN() {
        return this.oeH;
    }

    public void destroy() {
        this.fvq.cancelAllAsyncTask();
    }

    public void zi(boolean z) {
        this.oeI.zi(z);
    }
}
