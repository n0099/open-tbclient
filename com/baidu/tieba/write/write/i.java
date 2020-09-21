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
    private TbPageContext<WriteActivity> ehG;
    private WriteImagesInfo mWriteImagesInfo;
    private WriteImageGridView ngJ;
    public h ngK;
    private com.baidu.tbadk.img.b eOh = new com.baidu.tbadk.img.b();
    private String mFrom = "write";
    private String mForumId = "";
    private h.a ngL = new h.a() { // from class: com.baidu.tieba.write.write.i.1
        @Override // com.baidu.tieba.write.write.h.a
        public void Kn(int i) {
            if (i.this.mWriteImagesInfo != null && i.this.mWriteImagesInfo.getChosedFiles() != null && i >= 0 && i < i.this.mWriteImagesInfo.getChosedFiles().size()) {
                ImageFileInfo remove = i.this.mWriteImagesInfo.getChosedFiles().remove(i);
                if (remove.isTempFile()) {
                    com.baidu.adp.lib.Disk.d.lK().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                }
                i.this.ngK.a(i.this.mWriteImagesInfo);
                i.this.ngK.notifyDataSetChanged();
                if (y.isEmpty(i.this.mWriteImagesInfo.getChosedFiles()) && i.this.ehG.getOrignalPage() != 0) {
                    ((WriteActivity) i.this.ehG.getOrignalPage()).dxf();
                }
                if (i.this.ehG.getPageActivity() instanceof WriteActivity) {
                    ((WriteActivity) i.this.ehG.getPageActivity()).dMJ();
                }
            }
        }

        @Override // com.baidu.tieba.write.write.h.a
        public void Kx(int i) {
            int count;
            ImageFileInfo imageInfoAt;
            if (i.this.mWriteImagesInfo != null && (count = y.getCount(i.this.mWriteImagesInfo.getChosedFiles())) != 0 && i >= 0 && i < count && (imageInfoAt = i.this.mWriteImagesInfo.getImageInfoAt(i)) != null && imageInfoAt.getImageType() != 1) {
                i.this.ehG.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(i.this.ehG.getPageActivity(), RequestResponseCode.REQUEST_MOTU_IMAGE, i.this.mWriteImagesInfo, i)));
            }
        }

        @Override // com.baidu.tieba.write.write.h.a
        public void dMV() {
            if (i.this.mWriteImagesInfo != null) {
                AlbumFloatActivityConfig albumFloatActivityConfig = new AlbumFloatActivityConfig(i.this.ehG.getPageActivity(), i.this.mWriteImagesInfo.toJsonString(), true, true);
                albumFloatActivityConfig.getIntent().putExtra("forum_id", i.this.mForumId);
                albumFloatActivityConfig.getIntent().putExtra("from", i.this.mFrom);
                albumFloatActivityConfig.setRequestCode(RequestResponseCode.REQUEST_ALBUM_IMAGE);
                if (i.this.ehG.getPageActivity() instanceof WriteActivity) {
                    albumFloatActivityConfig.setCanSelectVideo(((WriteActivity) i.this.ehG.getPageActivity()).dKe());
                    AntiData antiData = new AntiData();
                    antiData.voice_message = ((WriteActivity) i.this.ehG.getPageActivity()).ePo;
                    antiData.setIfVoice(((WriteActivity) i.this.ehG.getPageActivity()).nfm);
                    albumFloatActivityConfig.setExtraData(antiData, ((WriteActivity) i.this.ehG.getPageActivity()).mPrefixData, ((WriteActivity) i.this.ehG.getPageActivity()).mdW.getFirstDir(), ((WriteActivity) i.this.ehG.getPageActivity()).mdW.getSecondDir());
                }
                albumFloatActivityConfig.setFromWrite(true);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumFloatActivityConfig));
            }
        }
    };

    public i(TbPageContext<WriteActivity> tbPageContext, View view) {
        this.ehG = tbPageContext;
        this.ngJ = (WriteImageGridView) view.findViewById(R.id.write_image_grid_view);
        this.ngK = new h(view.getContext(), this.eOh, null, this.ngL);
        this.ngJ.setAdapter((ListAdapter) this.ngK);
    }

    public void a(WriteImagesInfo writeImagesInfo, String str, String str2) {
        this.mFrom = str;
        this.mForumId = str2;
        this.mWriteImagesInfo = writeImagesInfo;
        this.ngK.a(this.mWriteImagesInfo);
        this.ngK.notifyDataSetChanged();
    }

    public GridView dMW() {
        return this.ngJ;
    }

    public void destroy() {
        this.eOh.cancelAllAsyncTask();
    }

    public void xp(boolean z) {
        this.ngK.xp(z);
    }
}
