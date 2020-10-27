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
    private TbPageContext<WriteActivity> eCn;
    private WriteImagesInfo mWriteImagesInfo;
    private WriteImageGridView nIG;
    public h nIH;
    private com.baidu.tbadk.img.b fiN = new com.baidu.tbadk.img.b();
    private String mFrom = "write";
    private String mForumId = "";
    private h.a nII = new h.a() { // from class: com.baidu.tieba.write.write.i.1
        @Override // com.baidu.tieba.write.write.h.a
        public void Ll(int i) {
            if (i.this.mWriteImagesInfo != null && i.this.mWriteImagesInfo.getChosedFiles() != null && i >= 0 && i < i.this.mWriteImagesInfo.getChosedFiles().size()) {
                ImageFileInfo remove = i.this.mWriteImagesInfo.getChosedFiles().remove(i);
                if (remove.isTempFile()) {
                    com.baidu.adp.lib.Disk.d.lL().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                }
                i.this.nIH.a(i.this.mWriteImagesInfo);
                i.this.nIH.notifyDataSetChanged();
                if (y.isEmpty(i.this.mWriteImagesInfo.getChosedFiles()) && i.this.eCn.getOrignalPage() != 0) {
                    ((WriteActivity) i.this.eCn.getOrignalPage()).dDY();
                }
                if (i.this.eCn.getPageActivity() instanceof WriteActivity) {
                    ((WriteActivity) i.this.eCn.getPageActivity()).dTD();
                }
            }
        }

        @Override // com.baidu.tieba.write.write.h.a
        public void Lv(int i) {
            int count;
            ImageFileInfo imageInfoAt;
            if (i.this.mWriteImagesInfo != null && (count = y.getCount(i.this.mWriteImagesInfo.getChosedFiles())) != 0 && i >= 0 && i < count && (imageInfoAt = i.this.mWriteImagesInfo.getImageInfoAt(i)) != null && imageInfoAt.getImageType() != 1) {
                i.this.eCn.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(i.this.eCn.getPageActivity(), RequestResponseCode.REQUEST_MOTU_IMAGE, i.this.mWriteImagesInfo, i)));
            }
        }

        @Override // com.baidu.tieba.write.write.h.a
        public void dTP() {
            if (i.this.mWriteImagesInfo != null) {
                AlbumFloatActivityConfig albumFloatActivityConfig = new AlbumFloatActivityConfig(i.this.eCn.getPageActivity(), i.this.mWriteImagesInfo.toJsonString(), true, true);
                albumFloatActivityConfig.getIntent().putExtra("forum_id", i.this.mForumId);
                albumFloatActivityConfig.getIntent().putExtra("from", i.this.mFrom);
                albumFloatActivityConfig.setRequestCode(RequestResponseCode.REQUEST_ALBUM_IMAGE);
                if (i.this.eCn.getPageActivity() instanceof WriteActivity) {
                    albumFloatActivityConfig.setCanSelectVideo(((WriteActivity) i.this.eCn.getPageActivity()).dQY());
                    AntiData antiData = new AntiData();
                    antiData.voice_message = ((WriteActivity) i.this.eCn.getPageActivity()).fjU;
                    antiData.setIfVoice(((WriteActivity) i.this.eCn.getPageActivity()).nHj);
                    albumFloatActivityConfig.setExtraData(antiData, ((WriteActivity) i.this.eCn.getPageActivity()).mPrefixData, ((WriteActivity) i.this.eCn.getPageActivity()).mGf.getFirstDir(), ((WriteActivity) i.this.eCn.getPageActivity()).mGf.getSecondDir());
                }
                albumFloatActivityConfig.setFromWrite(true);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumFloatActivityConfig));
            }
        }
    };

    public i(TbPageContext<WriteActivity> tbPageContext, View view) {
        this.eCn = tbPageContext;
        this.nIG = (WriteImageGridView) view.findViewById(R.id.write_image_grid_view);
        this.nIH = new h(view.getContext(), this.fiN, null, this.nII);
        this.nIG.setAdapter((ListAdapter) this.nIH);
    }

    public void a(WriteImagesInfo writeImagesInfo, String str, String str2) {
        this.mFrom = str;
        this.mForumId = str2;
        this.mWriteImagesInfo = writeImagesInfo;
        this.nIH.a(this.mWriteImagesInfo);
        this.nIH.notifyDataSetChanged();
    }

    public GridView dTQ() {
        return this.nIG;
    }

    public void destroy() {
        this.fiN.cancelAllAsyncTask();
    }

    public void yn(boolean z) {
        this.nIH.yn(z);
    }
}
